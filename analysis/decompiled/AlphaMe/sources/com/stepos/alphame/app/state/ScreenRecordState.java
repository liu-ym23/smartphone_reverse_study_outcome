package com.stepos.alphame.app.state;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class ScreenRecordState extends StateBase {
    private static final boolean DEBUG = true;
    private static final String TAG = "ScreenRecordState";

    @SuppressLint({"StaticFieldLeak"})
    private static ScreenRecordState mInstance;
    private Context mContext;
    private DisplayManager mDisplayManager;
    private HashMap<String, Long> mHistoryMap;
    private long mScreenRecordTime = 0;

    private ScreenRecordState(Context context) {
        this.mHistoryMap = null;
        this.mDisplayManager = null;
        this.mContext = context;
        this.mHistoryMap = new HashMap<>();
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService("display");
    }

    public static synchronized ScreenRecordState getInstance(Context context) {
        try {
            if (mInstance == null) {
                mInstance = new ScreenRecordState(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    private boolean getScreenRecordState(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Log.d(TAG, "getScreenRecordState packageName = " + str + " currentTime = " + jElapsedRealtime);
        if (this.mHistoryMap.containsKey(str)) {
            long jLongValue = this.mHistoryMap.get(str).longValue();
            StringBuilder sbE = AbstractC0831a.e("screenRecordTime = ", jLongValue, " isScreenRecord = ");
            long j4 = jElapsedRealtime - jLongValue;
            sbE.append(j4 < 120000);
            Log.d(TAG, sbE.toString());
            if (j4 < 120000) {
                return true;
            }
            this.mHistoryMap.remove(str);
        }
        return false;
    }

    public String getOwnerPackageName(Display display) {
        if (display == null) {
            return null;
        }
        try {
            return PerfBinderHelper.getDisplayOwnerPackageName(display.getDisplayId());
        } catch (Exception e4) {
            Log.d(TAG, "getOwnerPackageName failed : " + e4);
            return null;
        }
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return getScreenRecordState(str) ? 32 : 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkDetail() {
        ArrayList arrayList = new ArrayList();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (String str : this.mHistoryMap.keySet()) {
            if (jElapsedRealtime - this.mHistoryMap.get(str).longValue() <= 120000) {
                StringBuilder sbV = g.v(str, "#");
                sbV.append(String.valueOf(32));
                arrayList.add(sbV.toString());
            }
        }
        return arrayList;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkList() {
        ArrayList arrayList = new ArrayList();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        for (String str : this.mHistoryMap.keySet()) {
            if (jElapsedRealtime - this.mHistoryMap.get(str).longValue() <= 120000) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public boolean isScreenRecord() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean z4 = jElapsedRealtime - this.mScreenRecordTime < 25000;
        StringBuilder sbE = AbstractC0831a.e("isScreenRecord currentTime = ", jElapsedRealtime, " mScreenRecordTime = ");
        sbE.append(this.mScreenRecordTime);
        sbE.append(" isScreenRecord = ");
        sbE.append(z4);
        Log.d(TAG, sbE.toString());
        return z4;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isScreenRecord() ? 32 : 0;
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
            Display[] displays = this.mDisplayManager.getDisplays();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            for (Display display : displays) {
                String ownerPackageName = getOwnerPackageName(display);
                if (!TextUtils.isEmpty(ownerPackageName) && !"null".equals(ownerPackageName)) {
                    this.mScreenRecordTime = jElapsedRealtime;
                    this.mHistoryMap.put(ownerPackageName, Long.valueOf(jElapsedRealtime));
                }
            }
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }
}
