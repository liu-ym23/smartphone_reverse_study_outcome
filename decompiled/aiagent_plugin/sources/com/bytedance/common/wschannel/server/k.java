package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WsChannelEnableObserver.java */
/* JADX INFO: loaded from: classes.dex */
class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f7077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f7078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e.a f7079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ContentObserver f7081e;

    static /* synthetic */ void a(k r0) {
        r0.e();
    }

    k(Context r3, Handler r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f7077a = r4;
        this.f7078b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.common.wschannel.server.e
    public void a() {
        c();
        final Handler r1 = this.f7077a;
        this.f7081e = new WsChannelEnableObserver$1(this, r1);
        d();
    }

    private void c() {
        boolean r0 = com.bytedance.common.wschannel.m.a(this.f7078b).c();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L6;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r0);     // Catch: Throwable -> L9
    L6:
        if (r0 == this.f7080d) goto L12;
        this.f7080d = r0;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    private void d() {
        ZeusProviderTransform.registerContentObserver(this.f7078b.getContentResolver(), WsChannelMultiProcessSharedProvider.getContentUri(this.f7078b, WsConstants.KEY_FRONTIER_ENABLED, WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE), true, this.f7081e, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        return;
    }

    private void e() {
        boolean r0 = this.f7080d;     // Catch: Exception -> L8
        c();     // Catch: Exception -> L8
        boolean r1 = this.f7080d;     // Catch: Exception -> L8
        if (r0 == r1) goto L11;
        e.a r2 = this.f7079c;     // Catch: Exception -> L8
        if (r2 == null) goto L12;
        r2.a(r1);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.common.wschannel.server.e
    public boolean b() {
        return this.f7080d;
    }

    @Override // com.bytedance.common.wschannel.server.e
    public void a(e.a r3) {
        this.f7079c = (e.a) ZeusTransformUtils.wrapperContextForParams(r3, e.a.class, "com.obric.aiagent.plugin");
    }
}
