package com.stepos.alphame.headset;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.stepos.alphame.engine.EngineBase;
import com.stepos.alphame.manager.ActionManager;
import com.stepos.alphame.utils.LocalConsts;

/* loaded from: classes.dex */
public class HeadsetEngine extends EngineBase {
    private static final String EXTRA_STATE = "state";

    @SuppressLint({"StaticFieldLeak"})
    private static HeadsetEngine sInstance;
    private final Context mContext;
    private final HeadsetStateChangedReceiver mHeadsetStateChangedReceiver;
    private int mState = -1;

    public class HeadsetStateChangedReceiver extends BroadcastReceiver {
        public /* synthetic */ HeadsetStateChangedReceiver(HeadsetEngine headsetEngine, int i4) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra;
            if (intent == null || !"android.intent.action.HEADSET_PLUG".equals(intent.getAction()) || !intent.hasExtra("state") || (intExtra = intent.getIntExtra("state", -1)) == HeadsetEngine.this.mState) {
                return;
            }
            HeadsetEngine.this.mState = intExtra;
            ActionManager.getInstance().broadcast(LocalConsts.ACTION_HEADSET_CHANGED, Integer.valueOf(HeadsetEngine.this.mState));
        }

        private HeadsetStateChangedReceiver() {
        }
    }

    private HeadsetEngine(Context context) {
        this.mContext = context;
        HeadsetStateChangedReceiver headsetStateChangedReceiver = new HeadsetStateChangedReceiver(this, 0);
        this.mHeadsetStateChangedReceiver = headsetStateChangedReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        context.registerReceiver(headsetStateChangedReceiver, intentFilter);
    }

    public static boolean checkHeadsetPluggedIn(Context context) {
        return ((AudioManager) context.getSystemService("audio")).isWiredHeadsetOn();
    }

    public static HeadsetEngine getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new HeadsetEngine(context);
        }
        return sInstance;
    }

    public int getHeadsetState() {
        return this.mState;
    }
}
