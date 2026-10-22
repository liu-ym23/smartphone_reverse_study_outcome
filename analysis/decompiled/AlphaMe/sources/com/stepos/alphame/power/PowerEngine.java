package com.stepos.alphame.power;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.stepos.alphame.engine.EngineBase;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PowerEngine extends EngineBase {
    private static final int POWER_RANGE_10 = 3;
    private static final int POWER_RANGE_100 = 0;
    private static final int POWER_RANGE_30 = 2;
    private static final int POWER_RANGE_50 = 1;

    @SuppressLint({"StaticFieldLeak"})
    private static PowerEngine sInstance;
    private final Context mContext;
    private int mPowerSource = -1;
    private int mPowerLevel = 0;
    private int mRealtimePowerLevel = 0;
    private ArrayList<PowerChangerListener> mListeners = new ArrayList<>();
    private final PowerStateChangedReceiver mPowerStateChangedReceiver = new PowerStateChangedReceiver(this, 0);

    public static abstract class PowerChangerListener {
        public abstract void onChanged(int i4, int i5);
    }

    public class PowerStateChangedReceiver extends BroadcastReceiver {
        public /* synthetic */ PowerStateChangedReceiver(PowerEngine powerEngine, int i4) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x0034  */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onReceive(android.content.Context r5, android.content.Intent r6) {
            /*
                r4 = this;
                java.lang.String r5 = "level"
                r0 = 0
                int r5 = r6.getIntExtra(r5, r0)
                com.stepos.alphame.power.PowerEngine r1 = com.stepos.alphame.power.PowerEngine.this
                com.stepos.alphame.power.PowerEngine.i(r1, r5)
                java.lang.String r1 = "scale"
                r2 = 100
                int r1 = r6.getIntExtra(r1, r2)
                java.lang.String r2 = "plugged"
                int r6 = r6.getIntExtra(r2, r0)
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.e(r0)
                if (r6 != r0) goto L34
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.j(r0, r5)
                com.stepos.alphame.power.PowerEngine r2 = com.stepos.alphame.power.PowerEngine.this
                int r3 = com.stepos.alphame.power.PowerEngine.d(r2)
                int r2 = com.stepos.alphame.power.PowerEngine.j(r2, r3)
                if (r0 == r2) goto L59
            L34:
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.e(r0)
                if (r6 == r0) goto L41
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                com.stepos.alphame.power.PowerEngine.h(r0, r6)
            L41:
                com.stepos.alphame.manager.ActionManager r6 = com.stepos.alphame.manager.ActionManager.getInstance()
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.e(r0)
                int[] r0 = new int[]{r0, r5, r1}
                java.lang.String r1 = "ACTION_CHARGING_CHANGED"
                r6.broadcast(r1, r0)
                com.stepos.alphame.power.PowerEngine r6 = com.stepos.alphame.power.PowerEngine.this
                com.stepos.alphame.power.PowerEngine.g(r6, r5)
            L59:
                com.stepos.alphame.power.PowerEngine r5 = com.stepos.alphame.power.PowerEngine.this
                java.util.ArrayList r5 = com.stepos.alphame.power.PowerEngine.c(r5)
                java.util.Iterator r5 = r5.iterator()
            L63:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L7f
                java.lang.Object r6 = r5.next()
                com.stepos.alphame.power.PowerEngine$PowerChangerListener r6 = (com.stepos.alphame.power.PowerEngine.PowerChangerListener) r6
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.e(r0)
                com.stepos.alphame.power.PowerEngine r1 = com.stepos.alphame.power.PowerEngine.this
                int r1 = com.stepos.alphame.power.PowerEngine.d(r1)
                r6.onChanged(r0, r1)
                goto L63
            L7f:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                java.lang.String r6 = "PowerStateChangedReceiver "
                r5.<init>(r6)
                com.stepos.alphame.power.PowerEngine r6 = com.stepos.alphame.power.PowerEngine.this
                int r6 = com.stepos.alphame.power.PowerEngine.e(r6)
                r5.append(r6)
                java.lang.String r6 = ", "
                r5.append(r6)
                com.stepos.alphame.power.PowerEngine r0 = com.stepos.alphame.power.PowerEngine.this
                int r0 = com.stepos.alphame.power.PowerEngine.d(r0)
                r5.append(r0)
                r5.append(r6)
                com.stepos.alphame.power.PowerEngine r4 = com.stepos.alphame.power.PowerEngine.this
                int r4 = com.stepos.alphame.power.PowerEngine.f(r4)
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                com.stepos.alphame.utils.AlphaMeLogger.dLog(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.power.PowerEngine.PowerStateChangedReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }

        private PowerStateChangedReceiver() {
        }
    }

    private PowerEngine(Context context) {
        this.mContext = context;
    }

    public static PowerEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PowerEngine(context);
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLevelRange(int i4) {
        if (i4 > 50) {
            return 0;
        }
        if (i4 > 30) {
            return 1;
        }
        return i4 > 10 ? 2 : 3;
    }

    public int getPowerLevel() {
        return this.mPowerLevel;
    }

    public int getRealtimePowerLevel() {
        return this.mRealtimePowerLevel;
    }

    public boolean isCharging() {
        return this.mPowerSource > 0;
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        this.mContext.registerReceiver(this.mPowerStateChangedReceiver, intentFilter);
    }

    @Override // com.stepos.alphame.engine.EngineBase
    public void onStop() {
        super.onStop();
        this.mContext.unregisterReceiver(this.mPowerStateChangedReceiver);
    }

    public void registerPowerChangeListener(PowerChangerListener powerChangerListener) {
        this.mListeners.add(powerChangerListener);
    }

    public void unregisterPowerChangeListener(PowerChangerListener powerChangerListener) {
        this.mListeners.remove(powerChangerListener);
    }
}
