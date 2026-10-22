package com.obric.autogui.net.push.internal;

import android.content.Context;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.matrix.sdk.push.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AOPushManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AOPushManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<com.obric.autogui.tools.api.net.push.a> f29135b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f29136c = null;

    /* JADX INFO: renamed from: com.obric.autogui.net.push.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOPushManager.kt */
    @f(b = "AOPushManager.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.net.push.internal.AOPushManager$init$1")
    static final class C0734a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f29137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f29138b;

        C0734a(Context r3, d<? super C0734a> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f29138b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0734a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0734a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0734a(this.f29138b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f29137a != 0) goto L7;
            o.a(r2);
            a.a(a.f29134a, this.f29138b);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: AOPushManager.kt */
    public static final class b implements com.obric.matrix.sdk.push.b {
        b() {
        }

        @Override // com.obric.matrix.sdk.push.b
        public void a(String r2, String r3) {
            d.h.b.o.e(r2, "errorCode");
            d.h.b.o.e(r3, "errorMsg");
            Loog.INSTANCE.e(a.TAG, "register channel failed, errorMsg is " + r3);
        }

        @Override // com.obric.matrix.sdk.push.b
        public void a(String r3) {
            d.h.b.o.e(r3, "deviceToken");
            Loog.INSTANCE.i(a.TAG, "register channel success, token is  " + r3);
        }
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r2, Context r3) {
        r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    static {
        f29134a = new a();
        f29135b = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f29136c = new b();
    }

    public final void a(Context r8) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        i.a(an.a(), (g) ZeusTransformUtils.preCheckCast(bd.a(), g.class, "com.obric.aiagent.plugin"), null, (m) ZeusTransformUtils.preCheckCast(new C0734a(r7, null), m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    private final void b(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.d(TAG, "doInit");
        c.a(r3, new com.obric.matrix.sdk.push.d("obric_auto_action", "49d7b75d1f322ef9bc284e9dba41fafd00afd9fe"), (com.obric.matrix.sdk.push.b) ZeusTransformUtils.preCheckCast(f29136c, com.obric.matrix.sdk.push.b.class, "com.obric.aiagent.plugin"));
    }

    public final void a(com.obric.autogui.tools.api.net.push.a r2) {
        com.obric.autogui.tools.api.net.push.a r1 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "callback");
        f29135b.add(r1);
    }

    public final void b(com.obric.autogui.tools.api.net.push.a r2) {
        com.obric.autogui.tools.api.net.push.a r1 = (com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "callback");
        f29135b.remove(r1);
    }

    public final void a(String r4) {
        d.h.b.o.e(r4, "message");
        Iterator<com.obric.autogui.tools.api.net.push.a> r3 = f29135b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.autogui.tools.api.net.push.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.autogui.tools.api.net.push.a.class, "com.obric.aiagent.plugin")).onReceiveMsg(r4);
        goto L4
    }
}
