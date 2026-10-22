package com.android.server.location.injector;

import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemScreenInteractiveHelper extends ScreenInteractiveHelper {
    private final Context mContext;
    private volatile boolean mIsInteractive;
    private boolean mReady;

    public SystemScreenInteractiveHelper(Context context) {
        this.mContext = context;
    }

    public void onSystemReady() {
        if (this.mReady == false) goto L5;
        return;
    L5:
        IntentFilter screenIntentFilter = new IntentFilter();
        screenIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        screenIntentFilter.addAction("android.intent.action.SCREEN_ON");
        this.mContext.registerReceiverAsUser(new AnonymousClass1(this), UserHandle.ALL, screenIntentFilter, null, FgThread.getHandler());
        this.mReady = true;
    }

    void onScreenInteractiveChanged(boolean interactive) {
        if (interactive != this.mIsInteractive) goto L5;
        return;
    L5:
        this.mIsInteractive = interactive;
        notifyScreenInteractiveChanged(interactive);
    }

    @Override // com.android.server.location.injector.ScreenInteractiveHelper
    public boolean isInteractive() {
        Preconditions.checkState(this.mReady);
        return this.mIsInteractive;
    }
}
