package com.android.server;

import android.content.Context;
import android.util.Log;
import com.android.internal.util.ConcurrentUtils;
import com.android.server.location.contexthub.ContextHubService;
import com.android.server.location.contexthub.IContextHubWrapper;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
class ContextHubSystemService extends SystemService {
    private static final String TAG = "ContextHubSystemService";
    private ContextHubService mContextHubService;
    private Future<?> mInit;

    public static /* synthetic */ void $r8$lambda$rh2pjqKKW3BPmYQWkE44zlrrbEc(ContextHubSystemService r0, Context r1) {
        r0.lambda$new$0(r1);
    }

    public ContextHubSystemService(final Context context) {
        super(context);
        this.mInit = SystemServerInitThreadPool.submit(new ContextHubSystemService$$ExternalSyntheticLambda0(this, context), "Init ContextHubSystemService");
    }

    private /* synthetic */ void lambda$new$0(Context context) {
        this.mContextHubService = new ContextHubService(context, IContextHubWrapper.getContextHubWrapper());
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        Log.d(TAG, "onBootPhase: PHASE_SYSTEM_SERVICES_READY");
        ConcurrentUtils.waitForFutureNoInterrupt(this.mInit, "Wait for ContextHubSystemService init");
        this.mInit = null;
        publishBinderService("contexthub", this.mContextHubService);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        this.mContextHubService.onUserChanged();
    }
}
