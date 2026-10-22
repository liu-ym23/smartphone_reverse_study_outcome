package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.Context;
import android.os.DeadObjectException;
import com.obric.matrix.a.ab;
import com.obric.matrix.a.ad;
import com.obric.matrix.platform.server.IServerBroker;
import com.obric.matrix.platform.server.IServerCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.o;
import d.h.b.p;
import d.m;
import d.x;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: CmdManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "CmdManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33687a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f33688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashSet<Integer> f33689c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<Integer> f33690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HashSet<Integer> f33691e;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.internal.tunnel.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CmdManager.kt */
    public static final class C0910a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ab f33692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f33693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.matrix.platform.sdk.ones.c f33694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f33695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ c.a.a<m<Integer, ad>> f33696e;

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.internal.tunnel.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CmdManager.kt */
        static final class C0911a extends p implements d.h.a.m<Integer, String, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f33697a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c.a.a<m<Integer, ad>> f33698b;

            C0911a(int r3, c.a.a<m<Integer, ad>> r4) {
                c.a.a<m<Integer, ad>> r5 = (c.a.a) ZeusTransformUtils.wrapperContextForParams(r4, c.a.a.class, "com.obric.aiagent.plugin");
                this.f33697a = r3;
                this.f33698b = r5;
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(Integer r3, String r4) {
                a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(int r8, String r9) {
                o.e(r9, "errorMsg");
                a.a(a.f33687a, this.f33697a, this.f33698b, null, r8, r9);
            }
        }

        /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.internal.tunnel.a$a$b */
        /* JADX INFO: compiled from: CmdManager.kt */
        static final class b extends p implements d.h.a.m<Integer, String, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f33699a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c.a.a<m<Integer, ad>> f33700b;

            b(int r3, c.a.a<m<Integer, ad>> r4) {
                c.a.a<m<Integer, ad>> r5 = (c.a.a) ZeusTransformUtils.wrapperContextForParams(r4, c.a.a.class, "com.obric.aiagent.plugin");
                this.f33699a = r3;
                this.f33700b = r5;
                super(2);
            }

            @Override // d.h.a.m
            public /* synthetic */ x invoke(Integer r3, String r4) {
                a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(int r8, String r9) {
                o.e(r9, "errorMsg");
                a.a(a.f33687a, this.f33699a, this.f33700b, null, r8, r9);
            }
        }

        @Override // com.obric.matrix.platform.sdk.ones.internal.tunnel.e
        public void a(boolean r13) {
            com.obric.matrix.platform.sdk.ones.internal.b.b.b(a.TAG, "sendCMDByBind real start", null, 4, null);
            if (r13 == false) goto L16;
            byte[] r7 = this.f33692a.encode();
            if (this.f33693b == com.obric.matrix.a.p.f33529d.getValue()) goto L7;
        L12:
            IServerBroker r5 = d.f33701a.a();
            if (r5 == null) goto L15;
            a r14 = a.f33687a;
            int r6 = this.f33693b;
            final long r8 = this.f33695d;
            final c.a.a<m<Integer, ad>> r10 = this.f33696e;
            final com.obric.matrix.platform.sdk.ones.c r11 = this.f33694c;
            a.a(r14, r5, r6, r7, (IServerCallback) ZeusTransformUtils.preCheckCast(new CmdManager$sendCMDByBind$1$onResult$2(r8, r10, r11), IServerCallback.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f33693b, this.f33696e), d.h.a.m.class, "com.obric.aiagent.plugin"));
        L15:
            com.obric.matrix.platform.sdk.ones.internal.b.b.a(a.TAG, "invokeAsyn complete 1 cost " + (System.currentTimeMillis() - this.f33695d), null, 4, null);
            return;
        L7:
            if (this.f33694c != null) goto L12;
            com.obric.matrix.platform.sdk.ones.internal.b.b.b(a.TAG, "sendCMDByBind subscribe ws msg with broadcast without callback", null, 4, null);
            IServerBroker r9 = d.f33701a.a();
            if (r9 == null) goto L18;
            a.a(a.f33687a, r9, this.f33693b, r7, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0911a(this.f33693b, this.f33696e), d.h.a.m.class, "com.obric.aiagent.plugin"));
            return;
        L18:
            return;
        L16:
            a.a(a.f33687a, this.f33693b, this.f33696e, this.f33694c, 0, null, 24, null);
        }
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r8, int r9, c.a.a r10, com.obric.matrix.platform.sdk.ones.c r11, int r12, String r13) {
        r8.a(r9, (c.a.a) ZeusTransformUtils.wrapperContextForParams(r10, c.a.a.class, "com.obric.aiagent.plugin"), (com.obric.matrix.platform.sdk.ones.c) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.matrix.platform.sdk.ones.c.class, "com.obric.aiagent.plugin"), r12, r13);
    }

    public static final /* synthetic */ void a(a r8, IServerBroker r9, int r10, byte[] r11, IServerCallback r12, d.h.a.m r13) {
        r8.a((IServerBroker) ZeusTransformUtils.wrapperContextForParams(r9, IServerBroker.class, "com.obric.aiagent.plugin"), r10, r11, (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r12, IServerCallback.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.m.class, "com.obric.aiagent.plugin"));
    }

    static {
        f33687a = new a();
        f33688b = 35;
        f33689c = ax.c(new Integer[]{Integer.valueOf(com.obric.matrix.a.p.f33529d.getValue()), Integer.valueOf(com.obric.matrix.a.p.f33530e.getValue()), Integer.valueOf(com.obric.matrix.a.p.g.getValue()), Integer.valueOf(com.obric.matrix.a.p.m.getValue())});
        f33690d = d.a.p.a(Integer.valueOf(com.obric.matrix.a.p.f33528c.getValue()));
        f33691e = new HashSet();
    }

    static /* synthetic */ void a(a r7, int r8, c.a.a r9, com.obric.matrix.platform.sdk.ones.c r10, int r11, String r12, int r13, Object r14) {
        c.a.a<m<Integer, ad>> r3 = (c.a.a) ZeusTransformUtils.wrapperContextForParams(r9, c.a.a.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.c r4 = (com.obric.matrix.platform.sdk.ones.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.matrix.platform.sdk.ones.c.class, "com.obric.aiagent.plugin");
        if ((r13 & 8) == 0) goto L5;
        r11 = -20002;
    L5:
        int r5 = r11;
        if ((r13 & 16) == 0) goto L8;
        r12 = "binder connect error";
    L8:
        r7.a(r8, r3, r4, r5, r12);
    }

    private final void a(int r10, c.a.a<m<Integer, ad>> r11, com.obric.matrix.platform.sdk.ones.c r12, int r13, String r14) {
        c.a.a r9 = (c.a.a) ZeusTransformUtils.wrapperContextForParams(r11, c.a.a.class, "com.obric.aiagent.plugin");
        com.obric.matrix.platform.sdk.ones.c r15 = (com.obric.matrix.platform.sdk.ones.c) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.matrix.platform.sdk.ones.c.class, "com.obric.aiagent.plugin");
        String r2 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "handleBinderCallFail, errorCode: " + r13 + ", errorMsg: " + r14, null, 4, null);
        ad r16 = new ad.a().b(Integer.valueOf(r13)).a(r14).a();
        com.obric.matrix.platform.sdk.ones.internal.a.a r3 = com.obric.matrix.platform.sdk.ones.internal.a.a.f33679a;
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.b.f33630a.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r17 == null) goto L5;
        r2 = r17.getPackageName();
    L5:
        if (r2 != null) goto L7;
        String r6 = "";
    L8:
        o.c(r16, "response");
        r3.a(r10, 1, r6, r16, null);
        if (r9 == null) goto L11;
        r9.a(new m(Integer.valueOf(r10), r16));
    L11:
        if (r15 == null) goto L14;
        r15.a(r10, r16);
        return;
    L14:
        return;
    L7:
        r6 = r2;
        goto L8
    }

    private final void a(IServerBroker r3, int r4, byte[] r5, IServerCallback r6, d.h.a.m<? super Integer, ? super String, x> r7) {
        IServerBroker r8 = (IServerBroker) ZeusTransformUtils.wrapperContextForParams(r3, IServerBroker.class, "com.obric.aiagent.plugin");
        IServerCallback r9 = (IServerCallback) ZeusTransformUtils.wrapperContextForParams(r6, IServerCallback.class, "com.obric.aiagent.plugin");
        d.h.a.m r10 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.m.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L17;
        r8.invokeAsyn(r4, r5, r9);     // Catch: Exception -> L6 DeadObjectException -> L10
    L21:
        return;
    L10:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "invokeAsync, matrix dead", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r10 == null) goto L20;
        r10.invoke(-20005, "matrix is dead");
        return;
    L20:
        return;
    L6:
        e = move-exception;
        com.obric.matrix.platform.sdk.ones.internal.b.b.i(TAG, "invokeAsync, unknown error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r10 == null) goto L18;
        r10.invoke(-20006, "unknown reason: " + e);
        return;
    L18:
        return;
    }
}
