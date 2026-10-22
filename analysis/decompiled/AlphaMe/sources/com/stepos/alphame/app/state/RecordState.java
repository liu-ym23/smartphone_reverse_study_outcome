package com.stepos.alphame.app.state;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.AppData;
import com.stepos.alphame.utils.AppUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class RecordState extends StateBase {
    private static final String TAG = "RecordState";

    @SuppressLint({"StaticFieldLeak"})
    private static RecordState mInstance;
    private AppData mAppData;
    private Context mContext;
    private HashMap<String, Long> mHistoryMap;
    private PackageManager mPackageManager;
    private long mRecordTime = 0;
    private List<String> mWorkDetail = new ArrayList();

    private RecordState(Context context) {
        this.mHistoryMap = null;
        this.mAppData = null;
        this.mContext = context;
        this.mHistoryMap = new HashMap<>();
        this.mPackageManager = this.mContext.getPackageManager();
        this.mAppData = AppData.getInstance(this.mContext);
    }

    public static synchronized RecordState getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new RecordState(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private boolean getRecordState(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (StateBase.DEBUG) {
            Log.d(TAG, "getRecordState packageName = " + str + " currentTime = " + jElapsedRealtime);
        }
        if (this.mHistoryMap.containsKey(str)) {
            long jLongValue = this.mHistoryMap.get(str).longValue();
            if (StateBase.DEBUG) {
                StringBuilder sbE = AbstractC0831a.e("recordTime = ", jLongValue, " isRecord = ");
                sbE.append(jElapsedRealtime - jLongValue < 25000);
                Log.d(TAG, sbE.toString());
            }
            if (jElapsedRealtime - jLongValue < 25000) {
                return true;
            }
            this.mHistoryMap.remove(str);
        }
        return false;
    }

    private boolean isRecording() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z4 = jElapsedRealtime - this.mRecordTime < 25000;
        if (StateBase.DEBUG) {
            StringBuilder sbE = AbstractC0831a.e("isRecording currentTime = ", jElapsedRealtime, " mRecordTime = ");
            sbE.append(this.mRecordTime);
            sbE.append(" isRecord = ");
            sbE.append(z4);
            Log.d(TAG, sbE.toString());
        }
        return z4;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return getRecordState(str) ? 8 : 0;
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
                sbV.append(String.valueOf(8));
                list.add(sbV.toString());
            }
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isRecording() ? 8 : 0;
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
            List<String> recordingList = AppUtils.getRecordingList(list, this.mPackageManager, this.mAppData);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<String> it = recordingList.iterator();
            while (it.hasNext()) {
                this.mHistoryMap.put(it.next(), Long.valueOf(jElapsedRealtime));
                this.mRecordTime = jElapsedRealtime;
            }
            if (StateBase.DEBUG) {
                Log.d(TAG, "startCheck recordList = " + recordingList.toString() + " currentTime = " + jElapsedRealtime);
            }
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }

    public void startCheck(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsRecord = AppUtils.isRecord(str, this.mPackageManager);
        if (StateBase.DEBUG) {
            Log.d(TAG, "startCheck packageName = " + str + " currentTime = " + jElapsedRealtime + " isRecord = " + zIsRecord + " isContainsKey = " + this.mHistoryMap.containsKey(str));
        }
        if (zIsRecord) {
            this.mHistoryMap.put(str, Long.valueOf(jElapsedRealtime));
            this.mRecordTime = jElapsedRealtime;
        }
    }
}
