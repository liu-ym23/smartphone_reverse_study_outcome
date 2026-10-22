package com.stepos.alphame.app.state;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.AppData;
import com.stepos.alphame.app.AppStateEngine;
import com.stepos.alphame.utils.AppUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class LocationState extends StateBase {
    private static final String TAG = "LocationState";

    @SuppressLint({"StaticFieldLeak"})
    private static LocationState mInstance;
    private AppData mAppData;
    private Context mContext;
    private HashMap<String, Long> mHistoryMap;
    private AppStateEngine mStateEngine;
    private long mNavigationTime = 0;
    private List<String> mWorkDetail = new ArrayList();

    private LocationState(Context context) {
        this.mHistoryMap = null;
        this.mAppData = null;
        this.mContext = context;
        this.mHistoryMap = new HashMap<>();
        this.mAppData = AppData.getInstance(this.mContext);
    }

    public static synchronized LocationState getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new LocationState(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private boolean getLocationState(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (StateBase.DEBUG) {
            Log.d(TAG, "getLocationState packageName = " + str + " currentTime = " + jElapsedRealtime);
        }
        if (this.mHistoryMap.containsKey(str)) {
            long jLongValue = this.mHistoryMap.get(str).longValue();
            if (StateBase.DEBUG) {
                StringBuilder sbE = AbstractC0831a.e("navigationTime = ", jLongValue, " isNavigation = ");
                sbE.append(jElapsedRealtime - jLongValue < 120000);
                Log.d(TAG, sbE.toString());
            }
            if (jElapsedRealtime - jLongValue < 120000) {
                return true;
            }
            this.mHistoryMap.remove(str);
        }
        return false;
    }

    public List<String> getNavigatingList(List<String> list) throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        List<String> usingGpsList = AppUtils.getUsingGpsList(list, this.mContext);
        if (this.mStateEngine == null) {
            this.mStateEngine = AppStateEngine.getInstance();
        }
        for (String str : usingGpsList) {
            if (this.mAppData.isNavigationTypeApp(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return getLocationState(str) ? 4 : 0;
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
            if (jElapsedRealtime - this.mHistoryMap.get(str).longValue() <= 120000) {
                arrayList.add(str);
                List<String> list = this.mWorkDetail;
                StringBuilder sbV = g.v(str, "#");
                sbV.append(String.valueOf(4));
                list.add(sbV.toString());
            }
        }
        return arrayList;
    }

    public boolean isNavigation() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z4 = jElapsedRealtime - this.mNavigationTime < 25000;
        if (StateBase.DEBUG) {
            StringBuilder sbE = AbstractC0831a.e("isNavigation currentTime = ", jElapsedRealtime, " mNavigationTime = ");
            sbE.append(this.mNavigationTime);
            sbE.append(" isNavigation = ");
            sbE.append(z4);
            Log.d(TAG, sbE.toString());
        }
        return z4;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isNavigation() ? 4 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void pause() {
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void run() {
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void startCheck(List<String> list) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            List<String> navigatingList = getNavigatingList(list);
            Iterator<String> it = navigatingList.iterator();
            while (it.hasNext()) {
                this.mHistoryMap.put(it.next(), Long.valueOf(jElapsedRealtime));
                this.mNavigationTime = jElapsedRealtime;
            }
            if (StateBase.DEBUG) {
                Log.d(TAG, "startCheck navigatingList = " + navigatingList.toString() + " currentTime = " + jElapsedRealtime);
            }
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }
}
