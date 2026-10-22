package com.android.server.policy;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class GlobalKeyIntent {
    private static final String EXTRA_BEGAN_FROM_NON_INTERACTIVE = "EXTRA_BEGAN_FROM_NON_INTERACTIVE";
    private final boolean mBeganFromNonInteractive;
    private final ComponentName mComponentName;
    private final KeyEvent mKeyEvent;

    GlobalKeyIntent(ComponentName componentName, KeyEvent event, boolean beganFromNonInteractive) {
        this.mComponentName = componentName;
        this.mKeyEvent = new KeyEvent(event);
        this.mBeganFromNonInteractive = beganFromNonInteractive;
    }

    Intent getIntent() {
        Intent intent = new Intent("android.intent.action.GLOBAL_BUTTON").setComponent(this.mComponentName).setFlags(268435456).putExtra("android.intent.extra.KEY_EVENT", this.mKeyEvent).putExtra(EXTRA_BEGAN_FROM_NON_INTERACTIVE, this.mBeganFromNonInteractive);
        return intent;
    }

    public KeyEvent getKeyEvent() {
        return this.mKeyEvent;
    }

    public boolean beganFromNonInteractive() {
        return this.mBeganFromNonInteractive;
    }

    public static GlobalKeyIntent from(Intent intent) {
        if (intent.getAction() == "android.intent.action.GLOBAL_BUTTON") goto L6;
        Log.wtf("GlobalKeyIntent", "Intent should be ACTION_GLOBAL_BUTTON");
        return null;
    L6:
        KeyEvent event = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT", KeyEvent.class);
        boolean fromNonInteractive = intent.getBooleanExtra(EXTRA_BEGAN_FROM_NON_INTERACTIVE, false);
        return new GlobalKeyIntent(intent.getComponent(), event, fromNonInteractive);
    }
}
