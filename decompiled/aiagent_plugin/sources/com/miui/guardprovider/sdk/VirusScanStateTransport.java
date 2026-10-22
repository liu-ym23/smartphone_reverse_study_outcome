package com.miui.guardprovider.sdk;

import android.content.pm.PackageInfo;
import android.os.CancellationSignal;
import com.miui.guardprovider.aidl.IScanStateListener;
import com.miui.guardprovider.aidl.ScanResultInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
class VirusScanStateTransport extends IScanStateListener.Stub implements CancellationSignal.OnCancelListener {
    private volatile d callback;
    private final Executor executor;

    static VirusScanStateTransport createTransport(Executor r2, d r3, CancellationSignal r4) {
        return new VirusScanStateTransport((Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"), r4);
    }

    private VirusScanStateTransport(Executor r3, d r4, CancellationSignal r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.executor = (Executor) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), Executor.class, "com.obric.aiagent.plugin");
        this.callback = (d) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r7), d.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L6;
        r5.setOnCancelListener(this);
        return;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        this.callback = null;
    }

    @Override // com.miui.guardprovider.aidl.IScanStateListener
    public void onItemScanStarted(final String r3) {
        final d r0 = this.callback;
        if (r0 == null) goto L6;
        this.executor.execute(new $$Lambda$VirusScanStateTransport$rsRnOd_3COVGhnC7qiCU0vrZYk(r0, r3));
        return;
    }

    static /* synthetic */ void lambda$onItemScanStarted$0(d r2, String r3) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).a(r3);
    }

    @Override // com.miui.guardprovider.aidl.IScanStateListener
    public void onItemScanFinished(final String r3, final PackageInfo r4, List<ScanResultInfo> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        final d r0 = this.callback;
        if (r0 == null) goto L6;
        final List<com.miui.guardprovider.c> r7 = a.a(r6);
        this.executor.execute(new $$Lambda$VirusScanStateTransport$UObQ3WIskYmf0fVh_D5z5arVk(r0, r3, r4, r7));
        return;
    }

    static /* synthetic */ void lambda$onItemScanFinished$1(d r2, String r3, PackageInfo r4, List r5) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).a(r3, r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.miui.guardprovider.aidl.IScanStateListener
    public void onScanCompleted(final int r3, final String r4) {
        final d r0 = this.callback;
        if (r0 == null) goto L6;
        this.executor.execute(new $$Lambda$VirusScanStateTransport$WmTwIjmCy7GCfbravODzqFzEIbA(r0, r3, r4));
        return;
    }

    static /* synthetic */ void lambda$onScanCompleted$2(d r2, int r3, String r4) {
        ((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")).a(r3, r4);
    }
}
