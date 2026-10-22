package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WsChannelReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f7088d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f7089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i.a f7091c;

    static {
    }

    static /* synthetic */ b a(m r0) {
        return r0.f7089a;
    }

    static /* synthetic */ void a(m r2, Context r3) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ boolean a() {
        return f7088d;
    }

    @Deprecated
    public m() {
        this.f7090b = true;
    }

    public m(Context r3, b r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f7090b = true;
        this.f7091c = i.b(r5);
        this.f7089a = r4;
    }

    public void onReceive(Context r3, Intent r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L21;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.f7089a != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r4.getAction()) == false) goto L12;
        return;
    L12:
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r4.getAction()) == true) goto L15;
        return;
    L15:
        if (this.f7090b == false) goto L19;
        this.f7090b = false;
        if (i.b(r5) != this.f7091c) goto L19;
        return;
    L19:
        com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r5));
        return;
    }

    private void a(Context r2) {
        boolean r1 = com.bytedance.common.wschannel.m.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).c();     // Catch: Throwable -> L7
        if (r1 == f7088d) goto L10;
        f7088d = r1;     // Catch: Throwable -> L7
        return;
    L10:
        return;
    }
}
