package com.stepos.alphame.app.state;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.utils.AppUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class DownloadState extends StateBase {
    private static final String TAG = "DownloadState";
    private static final int UNKNOW_UID = -1;

    @SuppressLint({"StaticFieldLeak"})
    private static DownloadState sInstance;
    private Context mContext;
    private int MAX_NET_SPEED = 71680;
    private long MIN_CHECK_LOOP_TIME = VehicleBluetoothManager.MIN_CONNECT_DISTANCE;
    private PackageManager mPm = null;
    private Object mLock = new Object();
    private long mDownloadTime = 0;

    @SuppressLint({"UseSparseArrays"})
    private HashMap<String, Long> mHistoryMap = null;
    private List<String> mWorkDetail = new ArrayList();

    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Long> uidBytesCache = new HashMap<>();
    private long mLastTotalBytes = 0;

    private DownloadState(Context context) {
        this.mContext = context;
        init();
    }

    private boolean getDownloadState(String str) {
        if (StateBase.DEBUG) {
            Log.d(TAG, "getDownloadState packageName = " + str);
        }
        if (this.mHistoryMap.containsKey(str)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long jLongValue = this.mHistoryMap.get(str).longValue();
            if (StateBase.DEBUG) {
                StringBuilder sbE = AbstractC0831a.e("currentTime = ", jElapsedRealtime, " downloadTime = ");
                sbE.append(jLongValue);
                sbE.append(" isDowning = ");
                sbE.append(jElapsedRealtime - jLongValue <= 25000);
                Log.d(TAG, sbE.toString());
            }
            if (jElapsedRealtime - jLongValue <= 25000) {
                return true;
            }
            this.mHistoryMap.remove(str);
        }
        return false;
    }

    private List<String> getDownloadingAppsLocked(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (AppUtils.isNetworkAvailable(this.mContext)) {
                    long totalRxBytes = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
                    long j4 = this.mLastTotalBytes;
                    if (j4 != 0 && totalRxBytes - j4 < this.MAX_NET_SPEED * 5) {
                        return arrayList;
                    }
                    this.mLastTotalBytes = totalRxBytes;
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : list) {
                        int uidByPkgName = getUidByPkgName(str);
                        if (uidByPkgName != -1) {
                            arrayList2.add(Integer.valueOf(uidByPkgName));
                            long uidRxBytes = TrafficStats.getUidRxBytes(uidByPkgName);
                            long uidTxBytes = TrafficStats.getUidTxBytes(uidByPkgName);
                            if (uidRxBytes <= uidTxBytes) {
                                uidRxBytes = uidTxBytes;
                            }
                            Long pkgHistoryBytes = getPkgHistoryBytes(str);
                            if (pkgHistoryBytes != null) {
                                if (Math.abs(uidRxBytes - pkgHistoryBytes.longValue()) > this.MAX_NET_SPEED * 5) {
                                    arrayList.add(str);
                                }
                                this.uidBytesCache.put(Integer.valueOf(uidByPkgName), Long.valueOf(uidRxBytes));
                            } else if (this.mPm.checkPermission("android.permission.INTERNET", str) == 0) {
                                this.uidBytesCache.put(Integer.valueOf(uidByPkgName), Long.valueOf(uidRxBytes));
                                arrayList.add(str);
                            }
                        }
                    }
                    HashSet hashSet = new HashSet();
                    hashSet.addAll(this.uidBytesCache.keySet());
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        if (!arrayList2.contains(num)) {
                            this.uidBytesCache.remove(num);
                        }
                    }
                    return arrayList;
                }
            } catch (Exception e4) {
                if (StateBase.DEBUG) {
                    Log.i(TAG, e4.toString());
                }
                return arrayList;
            }
        }
        this.mLastTotalBytes = 0L;
        return new ArrayList();
    }

    public static synchronized DownloadState getInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new DownloadState(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    private String getPkgByUid(int i4) {
        String[] packagesForUid = this.mPm.getPackagesForUid(i4);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return null;
        }
        String strQ = "";
        for (String str : packagesForUid) {
            strQ = AbstractC0351g.q(strQ, AwarenessDataItem.PERMISSION_SPLITTER, str);
        }
        return strQ;
    }

    private Long getPkgHistoryBytes(String str) throws PackageManager.NameNotFoundException {
        int uidByPkgName = getUidByPkgName(str);
        if (uidByPkgName == -1) {
            return null;
        }
        return this.uidBytesCache.get(Integer.valueOf(uidByPkgName));
    }

    private int getUidByPkgName(String str) throws PackageManager.NameNotFoundException {
        try {
            if (!TextUtils.isEmpty(str) && str.contains(AwarenessDataItem.USERID_SPLITTER)) {
                str = str.split(AwarenessDataItem.USERID_SPLITTER)[0];
            }
            ApplicationInfo applicationInfo = this.mPm.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.uid;
            }
            return -1;
        } catch (Exception e4) {
            AbstractC0351g.B("getUidByPkgName exception: ", e4, TAG);
            return -1;
        }
    }

    private void init() {
        this.mPm = this.mContext.getPackageManager();
        this.mHistoryMap = new HashMap<>();
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return getDownloadState(str) ? 1 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkDetail() {
        return this.mWorkDetail;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkList() {
        ArrayList arrayList = new ArrayList();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mWorkDetail.clear();
        for (String str : this.mHistoryMap.keySet()) {
            if (jElapsedRealtime - this.mHistoryMap.get(str).longValue() <= 25000) {
                arrayList.add(str);
                List<String> list = this.mWorkDetail;
                StringBuilder sbV = g.v(str, "#");
                sbV.append(String.valueOf(1));
                list.add(sbV.toString());
            }
        }
        return arrayList;
    }

    public boolean isDownloading() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z4 = jElapsedRealtime - this.mDownloadTime < 25000;
        if (StateBase.DEBUG) {
            StringBuilder sbE = AbstractC0831a.e("isDownload currentTime = ", jElapsedRealtime, " mDownloadTime = ");
            sbE.append(this.mDownloadTime);
            sbE.append(" isDownload = ");
            sbE.append(z4);
            Log.d(TAG, sbE.toString());
        }
        return z4;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isDownloading() ? 1 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void pause() {
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void run() {
    }

    public void setMinDownloadNetSpeed(int i4) {
        synchronized (this.mLock) {
            if (i4 < 60) {
                i4 = 60;
            }
            this.MAX_NET_SPEED = i4;
        }
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void startCheck(List<String> list) {
        try {
            List<String> downloadingAppsLocked = getDownloadingAppsLocked(list);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<String> it = downloadingAppsLocked.iterator();
            while (it.hasNext()) {
                this.mHistoryMap.put(it.next(), Long.valueOf(jElapsedRealtime));
                this.mDownloadTime = jElapsedRealtime;
            }
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }
}
