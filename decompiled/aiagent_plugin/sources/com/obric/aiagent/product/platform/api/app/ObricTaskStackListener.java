package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import d.f;
import d.g;

/* JADX INFO: compiled from: ObricTaskStackListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ObricTaskStackListener {
    private final f assistantStub$delegate;
    private final f obricStub$delegate;

    public static /* synthetic */ ObricTaskStackListener$assistantStub$2$1 lambda$9S3YnG7jokkJgsLXrMuX89Za4Nc(ObricTaskStackListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    /* JADX INFO: renamed from: lambda$bF-12-69KeK9e8BdjXH6-CLCLxs, reason: not valid java name */
    public static /* synthetic */ ObricTaskStackListener$obricStub$2$1 m208lambda$bF1269KeK9e8BdjXH6CLCLxs(ObricTaskStackListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    public void onBlacklistAppOpen(String r1) {
    }

    public void onDisplaySecureChanged(int r1, boolean r2) {
    }

    public void onDisplayStatusBarChanged(int r1, int r2) {
    }

    public void onReportError(int r1, int r2) {
    }

    public void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo r1) {
    }

    public void onTaskToBackground(ActivityManager.RunningTaskInfo r1) {
    }

    public ObricTaskStackListener() {
        this.obricStub$delegate = g.a(new $$Lambda$ObricTaskStackListener$bF1269KeK9e8BdjXH6CLCLxs(this));
        this.assistantStub$delegate = g.a(new $$Lambda$ObricTaskStackListener$9S3YnG7jokkJgsLXrMuX89Za4Nc(this));
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricTaskStackListener$obricStub$2$1] */
    private static final ObricTaskStackListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricTaskStackListener r1) {
        return new ObricTaskStackListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.b();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricTaskStackListener$assistantStub$2$1] */
    private static final ObricTaskStackListener$assistantStub$2$1 assistantStub_delegate$lambda$1(final ObricTaskStackListener r1) {
        return new ObricTaskStackListener$assistantStub$2$1(r1);
    }
}
