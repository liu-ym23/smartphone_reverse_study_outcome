package com.stepos.alphame.app.state;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class StepState extends StateBase implements SensorEventListener {
    private static final int DURATION_CHECK = 60000;
    private static final int HISTORY_MAX_SECOND = 300;
    public static final int NO_STEPS = -1;
    private static final int S_MOVING_CHECK_SECONDS = 120;
    private static String TAG = "StepState";

    @SuppressLint({"StaticFieldLeak"})
    private static StepState mInstance;
    private Context mContext;
    private SensorManager mSensorManager = null;
    private Sensor mStepSensor = null;
    private int mStartSteps = -1;
    private int mCurrentSteps = 0;

    @SuppressLint({"UseSparseArrays"})
    Map<Integer, Integer> mHistoryStep = new HashMap();
    private List<String> mWorkDetail = new ArrayList();

    private StepState(Context context) {
        this.mContext = context;
        initVarable();
    }

    public static StepState getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new StepState(context);
        }
        return mInstance;
    }

    private void initVarable() {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mStepSensor = sensorManager.getDefaultSensor(19);
    }

    private void markStepCount(float f4) {
        int i4 = (int) f4;
        this.mCurrentSteps = i4;
        if (this.mStartSteps == -1) {
            this.mStartSteps = i4;
        }
        int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() / 1000);
        ArrayList arrayList = new ArrayList();
        for (Integer num : this.mHistoryStep.keySet()) {
            if (iElapsedRealtime - num.intValue() > 300) {
                arrayList.add(num);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mHistoryStep.remove((Integer) it.next());
        }
        this.mHistoryStep.put(Integer.valueOf(iElapsedRealtime), Integer.valueOf(this.mCurrentSteps));
        if (StateBase.DEBUG) {
            Log.d(TAG, "Get step:" + f4 + " and history size:" + this.mHistoryStep.size());
        }
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int getState(String str) {
        return 0;
    }

    public int getStepCount() {
        if (StateBase.DEBUG) {
            Log.d(TAG, "getStepCount:" + this.mCurrentSteps);
        }
        return this.mCurrentSteps;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkDetail() {
        return this.mWorkDetail;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public List<String> getWorkList() {
        return new ArrayList();
    }

    public boolean isMoving(long j4) {
        int iElapsedRealtime = ((int) SystemClock.elapsedRealtime()) / 1000;
        int iIntValue = 0;
        for (Integer num : this.mHistoryStep.keySet()) {
            if (j4 <= 0) {
                j4 = 120;
            }
            if (iElapsedRealtime - num.intValue() <= j4) {
                iIntValue += this.mHistoryStep.get(num).intValue();
            }
        }
        if (StateBase.DEBUG) {
            Log.d(TAG, "is Moving:" + j4 + " and step = " + iIntValue);
        }
        return iIntValue > 0;
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public int isWorking(long j4) {
        return isMoving(j4) ? 16 : 0;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i4) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 19) {
            markStepCount(sensorEvent.values[0]);
        }
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void pause() {
        this.mSensorManager.unregisterListener(this);
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void run() {
        this.mSensorManager.registerListener(this, this.mStepSensor, 0);
    }

    @Override // com.stepos.alphame.app.state.StateBase
    public void startCheck(List<String> list) {
        try {
            this.mStartSteps = -1;
        } catch (Exception e4) {
            AbstractC0351g.B("startCheck exception: ", e4, TAG);
        }
    }

    public int stopCount() {
        return this.mCurrentSteps - this.mStartSteps;
    }
}
