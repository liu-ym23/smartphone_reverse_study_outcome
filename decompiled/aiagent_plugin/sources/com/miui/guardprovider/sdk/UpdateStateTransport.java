package com.miui.guardprovider.sdk;

import android.os.CancellationSignal;
import com.miui.guardprovider.aidl.IUpdateStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class UpdateStateTransport extends IUpdateStateListener.Stub implements CancellationSignal.OnCancelListener {
    private volatile e callback;
    private final Executor executor;

    UpdateStateTransport(Executor r3, e r4, CancellationSignal r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        this.executor = (Executor) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), Executor.class, "com.obric.aiagent.plugin");
        this.callback = (e) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), e.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.setOnCancelListener(this);
        return;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        this.callback = null;
    }

    @Override // com.miui.guardprovider.aidl.IUpdateStateListener
    public void onUpdateStart() {
        final e r0 = this.callback;
        if (r0 == null) goto L6;
        Executor r2 = this.executor;
        Objects.requireNonNull(r0);
        r2.execute(new $$Lambda$r8LecfE9clNA74KFKalk2btno8(r0));
        return;
    }

    @Override // com.miui.guardprovider.aidl.IUpdateStateListener
    public void onUpdateProgress(final int r3, final int r4) {
        final e r0 = this.callback;
        if (r0 == null) goto L6;
        this.executor.execute(new $$Lambda$UpdateStateTransport$8jOgqvVd6zI9GZzVljMOu_e_MTA(r0, r3, r4));
        return;
    }

    static /* synthetic */ void lambda$onUpdateProgress$0(e r2, int r3, int r4) {
        ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }

    @Override // com.miui.guardprovider.aidl.IUpdateStateListener
    public void onUpdateFinished(final int r3) {
        final e r0 = this.callback;
        if (r0 == null) goto L6;
        this.executor.execute(new $$Lambda$UpdateStateTransport$8WX8kZD1qfv4MZMGYwmfYoHN3o(r0, r3));
        return;
    }

    static /* synthetic */ void lambda$onUpdateFinished$1(e r2, int r3) {
        ((e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin")).a(r3);
    }
}
