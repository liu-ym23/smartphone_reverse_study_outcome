package com.obric.autogui.platforms.miui.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.SystemClock;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.g;
import d.f;
import d.h.a.m;
import d.h.b.o;
import d.h.b.z;
import d.k;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: MiuiVirusScanClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "GR-VirusScan";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30023a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f30024b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f30025c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f30026d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f30027e = null;
    private static final f f = null;

    /* JADX INFO: compiled from: MiuiVirusScanClient.kt */
    @d.c.b.a.f(b = "MiuiVirusScanClient.kt", c = {215, 219}, d = "scanByJava", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusScanClient")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f30030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f30031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f30032e;
        Object f;
        long g;
        long h;
        /* synthetic */ Object i;
        final /* synthetic */ d j;
        int k;

        a(d r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.j = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.i = r7;
            this.k |= Integer.MIN_VALUE;
            return d.a(this.j, null, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: MiuiVirusScanClient.kt */
    public static final class b implements com.miui.guardprovider.sdk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f30033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f30034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ w<Long> f30035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.platforms.miui.a.a.a> f30036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.a f30037e;
        final /* synthetic */ com.miui.guardprovider.sdk.f f;

        b(long r3, String r5, w<Long> r6, w<com.obric.autogui.platforms.miui.a.a.a> r7, z.a r8, com.miui.guardprovider.sdk.f r9) {
            w<Long> r10 = (w) ZeusTransformUtils.wrapperContextForParams(r6, w.class, "com.obric.aiagent.plugin");
            w<com.obric.autogui.platforms.miui.a.a.a> r11 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
            this.f30033a = r3;
            this.f30034b = r5;
            this.f30035c = r10;
            this.f30036d = r11;
            this.f30037e = r8;
            this.f = r9;
        }

        @Override // com.miui.guardprovider.sdk.d
        public void a(String r5) {
            o.e(r5, DownloadConstants.PATH_KEY);
            Loog.INSTANCE.d(d.TAG, "java_opensdk: callback onItemScanStarted: reqId=" + this.f30033a + ", pkg=" + this.f30034b + ", item=" + r5);
        }

        @Override // com.miui.guardprovider.sdk.d
        public void a(String r9, PackageInfo r10, List<com.miui.guardprovider.c> r11) {
            List<com.miui.guardprovider.c> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            o.e(r9, DownloadConstants.PATH_KEY);
            if (this.f30035c.i() == true) goto L5;
            this.f30035c.a(Long.valueOf(SystemClock.elapsedRealtime()));
        L5:
            if (r10 == null) goto L8;
            String r13 = r10.packageName;
            if (r13 == null) goto L8;
        L9:
            long r0 = d.a(d.f30023a, r12);
            com.obric.autogui.platforms.miui.a.a.b.C0785b r2 = d.a(d.f30023a).a(r12);
            boolean r3 = r2.a();
            Loog r4 = Loog.INSTANCE;
            StringBuilder r14 = new StringBuilder().append("java_opensdk: callback onItemScanFinished: reqId=").append(this.f30033a).append(", reqPkg=").append(this.f30034b).append(", cbArg=").append(r9).append(", cbPkg=").append(r13).append(", results=");
            if (r12 == null) goto L12;
            int r5 = r12.size();
        L13:
            r4.d(d.TAG, r14.append(r5).append(", flagsMask=").append(r0).append(", isVirus=").append(r3).append(", reason=").append(r2.b()).append(", resultsDetail=").append(d.b(d.f30023a, r12)).toString());
            if (o.a(r13, this.f30034b) == true) goto L17;
            return;
        L17:
            if (this.f30036d.i() == true) goto L20;
            this.f30036d.a(new com.obric.autogui.platforms.miui.a.a.a.C0784a(this.f30034b, r3, "java_item_done"));
            return;
        L20:
            return;
        L12:
            r5 = 0;
        L8:
            r13 = r9;
            goto L9
        }

        @Override // com.miui.guardprovider.sdk.d
        public void a(int r5, String r6) {
            if (this.f30035c.i() == true) goto L5;
            this.f30035c.a(Long.valueOf(SystemClock.elapsedRealtime()));
        L5:
            Loog.INSTANCE.d(d.TAG, "java_opensdk: callback onScanCompleted: reqId=" + this.f30033a + ", pkg=" + this.f30034b + ", code=" + r5 + ", msg=" + r6);
            if (this.f30036d.i() == true) goto L8;
            this.f30036d.a(new com.obric.autogui.platforms.miui.a.a.a.c(this.f30034b, r5, r6));
        L8:
            d.a(this.f30037e, this.f, "onScanCompleted");
        }
    }

    /* JADX INFO: compiled from: MiuiVirusScanClient.kt */
    @d.c.b.a.f(b = "MiuiVirusScanClient.kt", c = {219}, d = "invokeSuspend", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusScanClient$scanByJava$firstCbCostMs$1$firstMs$1")
    static final class c extends l implements m<am, d.c.d<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<Long> f30039b;

        c(w<Long> r3, d.c.d<? super c> r4) {
            w<Long> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30039b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Long> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f30039b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Long> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30038a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<Long> r6 = this.f30039b;
            d.c.d<? super Long> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30038a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.miui.a.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MiuiVirusScanClient.kt */
    @d.c.b.a.f(b = "MiuiVirusScanClient.kt", c = {189}, d = "invokeSuspend", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusScanClient$scanByJava$timeoutJob$1")
    static final class C0787d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<com.obric.autogui.platforms.miui.a.a.a> f30041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f30042c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ z.a f30043d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.miui.guardprovider.sdk.f f30044e;

        C0787d(w<com.obric.autogui.platforms.miui.a.a.a> r3, String r4, z.a r5, com.miui.guardprovider.sdk.f r6, d.c.d<? super C0787d> r7) {
            w<com.obric.autogui.platforms.miui.a.a.a> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30041b = r8;
            this.f30042c = r4;
            this.f30043d = r5;
            this.f30044e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0787d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0787d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0787d(this.f30041b, this.f30042c, this.f30043d, this.f30044e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30040a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (this.f30041b.i() == true) goto L15;
            d.a(d.f30023a, this.f30042c, "java_opensdk");
            this.f30041b.a(new com.obric.autogui.platforms.miui.a.a.a.e(this.f30042c));
            d.a(this.f30043d, this.f30044e, "timeout");
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30040a = 1;
            if (ax.a(100000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: MiuiVirusScanClient.kt */
    @d.c.b.a.f(b = "MiuiVirusScanClient.kt", c = {315, 89}, d = "invokeSuspend", e = "com.obric.autogui.platforms.miui.security.virus.MiuiVirusScanClient$scanByPackageName$2")
    static final class e extends l implements m<am, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f30045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f30046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f30047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f30048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f30049e;
        int f;
        final /* synthetic */ long g;
        final /* synthetic */ String h;
        final /* synthetic */ long i;

        e(long r3, String r5, long r6, d.c.d<? super e> r8) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            this.h = r5;
            this.i = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.g, this.h, this.i, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r24) {
            Object r7 = d.c.a.b.a();
            int r1 = this.f;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            long r2 = this.f30046b;
            long r3 = this.f30045a;
            String r5 = (String) ZeusTransformUtils.preCheckCast(this.f30049e, String.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r6 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f30048d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r24);     // Catch: Throwable -> L9
            Object r0 = r24;
        L57:
            com.obric.autogui.platforms.miui.a.a.a r4 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
            Loog.INSTANCE.i(d.TAG, "scanByPackageName: done via java_opensdk: reqId=" + r3 + ", pkg=" + r5 + ", outcome=" + d.a(d.f30023a, r4) + ", isVirus=" + r4.a() + ", cacheable=" + r4.b() + ", cost=" + (SystemClock.elapsedRealtime() - r2) + "ms");     // Catch: Throwable -> L37
            r6.b(null);
            return r4;
        L37:
            th = th;
        L44:
            Object r8 = null;
        L45:
            r6.b(r8);
            throw th;
        L9:
            th = th;
        L10:
            r8 = null;
            goto L45
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            long r9 = this.f30047c;
            long r10 = this.f30046b;
            long r12 = this.f30045a;
            String r11 = (String) ZeusTransformUtils.preCheckCast(this.f30049e, String.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.f.a r14 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(this.f30048d, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
            d.o.a(r24);
            String r13 = r11;
            long r15 = r12;
            long r16 = r10;
            kotlinx.coroutines.f.a r17 = r14;
            long r18 = r9;
        L49:
        L41:
            th = th;
            kotlinx.coroutines.f.a r19 = r17;
        L43:
            r6 = r19;
            goto L44
        L19:
            long r20 = SystemClock.elapsedRealtime() - r15;
            if (r20 > 0) goto L55;
        L28:
            Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41
            d r22 = d.f30023a;     // Catch: Throwable -> L41
            this.f30048d = r17;     // Catch: Throwable -> L41
            this.f30049e = r13;     // Catch: Throwable -> L41
            this.f30045a = r16;     // Catch: Throwable -> L41
            this.f30046b = r18;     // Catch: Throwable -> L41
            this.f = 2;     // Catch: Throwable -> L41
            r19 = r17;
            String r110 = r13;
            r0 = d.a(r22, r21, r13, r16, this);     // Catch: Throwable -> L39
            if (r0 != r7) goto L33;
            return r7;
        L33:
            r6 = r19;
            r3 = r16;
            r2 = r18;
            r5 = r110;
        L39:
            th = th;
            goto L43
        L55:
            Loog.INSTANCE.d(d.TAG, "scanByPackageName: acquired global lock after " + r20 + "ms, reqId=" + r16 + ", pkg=" + r13);     // Catch: Throwable -> L24
        L24:
            th = th;
            r6 = r17;
        L26:
            th = th;
            r6 = r17;
            goto L10
        L14:
            d.o.a(r24);
            long r111 = SystemClock.elapsedRealtime();
            kotlinx.coroutines.f.a r23 = d.a();
            long r25 = this.g;
            r13 = this.h;
            r18 = this.i;
            d.c.d<? super x> r26 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30048d = r23;
            this.f30049e = r13;
            this.f30045a = r111;
            this.f30046b = r25;
            this.f30047c = r18;
            this.f = 1;
            if (r23.a(null, r26) != r7) goto L17;
            return r7;
        L17:
            r17 = r23;
            r15 = r111;
            r16 = r25;
            goto L49
        }
    }

    /* JADX INFO: renamed from: lambda$3S_dRwjj6otiLBnC8a-z2FqDnqE, reason: not valid java name */
    public static /* synthetic */ ExecutorService m850lambda$3S_dRwjj6otiLBnC8az2FqDnqE() {
        return f();
    }

    public static /* synthetic */ Thread lambda$L4R3Z2Lxsy7iJBIKTL7EJLY5Wi8(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ com.obric.autogui.platforms.miui.a.a.b lambda$dFDgwp4zyXxzrBSe9jHEXA4eErI() {
        return e();
    }

    private d() {
    }

    public static final /* synthetic */ long a(d r2, List r3) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ com.obric.autogui.platforms.miui.a.a.b a(d r0) {
        return r0.b();
    }

    public static final /* synthetic */ Object a(d r8, Context r9, String r10, long r11, d.c.d r13) {
        return r8.a((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, r11, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(d r0, com.obric.autogui.platforms.miui.a.a.a r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.f.a a() {
        return f30025c;
    }

    public static final /* synthetic */ void a(d r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(z.a r0, com.miui.guardprovider.sdk.f r1, String r2) {
        b(r0, r1, r2);
    }

    public static final /* synthetic */ String b(d r2, List r3) {
        return r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    static {
        f30023a = new d();
        f30024b = an.a(cx.a(null, 1, null).plus((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin")));
        f30025c = kotlinx.coroutines.f.c.a(false, 1, null);
        f30026d = new AtomicLong(0);
        f30027e = d.g.a($$Lambda$d$dFDgwp4zyXxzrBSe9jHEXA4eErI.INSTANCE);
        f = d.g.a($$Lambda$d$3S_dRwjj6otiLBnC8az2FqDnqE.INSTANCE);
    }

    private final com.obric.autogui.platforms.miui.a.a.b b() {
        return (com.obric.autogui.platforms.miui.a.a.b) ZeusTransformUtils.preCheckCast(f30027e.b(), com.obric.autogui.platforms.miui.a.a.b.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.platforms.miui.a.a.b e() {
        String r0 = AutoActionConfigs.INSTANCE.getStringCfg("vlm.security.virus_scan_criteria");
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        Loog.INSTANCE.i(TAG, "[MiuiVirusScanClient] Criteria from Default (Empty Config).");
        return com.obric.autogui.platforms.miui.a.a.b.f29976a.a();
    L12:
        Loog.INSTANCE.i(TAG, "[MiuiVirusScanClient] Criteria from Configured: Size=" + r0.length() + '.');
        return com.obric.autogui.platforms.miui.a.a.b.f29976a.a(r0);
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final String a(com.obric.autogui.platforms.miui.a.a.a r3) {
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.C0784a.class) == false) goto L6;
        return "Done(" + ((com.obric.autogui.platforms.miui.a.a.a.C0784a) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.platforms.miui.a.a.a.C0784a.class, "com.obric.aiagent.plugin")).c() + ')';
    L6:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.c.class) == false) goto L9;
        return "FinishedNoItem";
    L9:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.d.class) == false) goto L12;
        return "NotSupported";
    L12:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.e.class) == false) goto L15;
        return "Timeout";
    L15:
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.platforms.miui.a.a.a.b.class) == false) goto L19;
        return "Error";
    L19:
        throw new k();
    }

    private final ExecutorService c() {
        return (ExecutorService) ZeusTransformUtils.preCheckCast(f.b(), ExecutorService.class, "com.obric.aiagent.plugin");
    }

    private static final ExecutorService f() {
        return Executors.newSingleThreadExecutor($$Lambda$d$L4R3Z2Lxsy7iJBIKTL7EJLY5Wi8.INSTANCE);
    }

    private static final Thread a(Runnable r2) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "gr-virus-scan");
        r0.setDaemon(true);
        return r0;
    }

    public final Object a(String r10, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r11) {
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L5;
        long r2 = f30026d.incrementAndGet();
        long r5 = SystemClock.elapsedRealtime();
        return i.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"), (m) ZeusTransformUtils.preCheckCast(new e(r2, r10, r5, null), m.class, "com.obric.aiagent.plugin"), r9);
    L5:
        return new com.obric.autogui.platforms.miui.a.a.a.b(r10, "blank package name");
    }

    private final Object a(Context r43, String r44, long r45, d.c.d<? super com.obric.autogui.platforms.miui.a.a.a> r47) {
        String r10 = r44;
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r43, Context.class, "com.obric.aiagent.plugin");
        d.c.d r2 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r47, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r2, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
        if ((r3.k & Integer.MIN_VALUE) == 0) goto L7;
        r3.k -= Integer.MIN_VALUE;
    L8:
        a r15 = r3;
        Object r4 = r15.i;
        Object r9 = d.c.a.b.a();
        int r5 = r15.k;
        String r7 = "ms";
        if (r5 != 0) goto L11;
        d.o.a(r4);
        long r6 = SystemClock.elapsedRealtime();
        com.miui.guardprovider.sdk.f r11 = new com.miui.guardprovider.sdk.f(r0);
        if (r11.a() == true) goto L25;
        a(r10);
        return new com.obric.autogui.platforms.miui.a.a.a.d(r10);
    L25:
        Loog.INSTANCE.d(TAG, "java_opensdk: prepare start, reqId=" + r45 + ", pkg=" + r10);
        n.a r1 = n.f38560a;     // Catch: Throwable -> L28
        d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        Object r12 = n.f(d.c.b.a.b.a(r11.a(5000)));     // Catch: Throwable -> L28
    L31:
        if (n.c(r12) == null) goto L42;
        n.a r13 = n.f38560a;     // Catch: Throwable -> L35
        Object r14 = n.f(d.c.b.a.b.a(r11.c()));     // Catch: Throwable -> L35
    L37:
        Boolean r16 = d.c.b.a.b.a(false);
        if (n.b(r14) == false) goto L40;
        r14 = r16;
    L40:
        r12 = d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L35:
        th = move-exception;
        n.a r17 = n.f38560a;
        r14 = n.f(d.o.a(th));
    L42:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L44;
        Loog.INSTANCE.d(TAG, "java_opensdk: prepared, reqId=" + r45 + ", pkg=" + r10 + ", costSoFar=" + (SystemClock.elapsedRealtime() - r6) + "ms");
        com.miui.guardprovider.sdk.b r18 = d();
        CancellationSignal r22 = new CancellationSignal();
        w r19 = y.a(null, 1, null);
        w r20 = y.a(null, 1, null);
        z.a r21 = new z.a();
        String r110 = TAG;
        a r29 = r15;
        String r111 = ", pkg=";
        b r23 = new b(r45, r44, r20, r19, r21, r11);
        ca r24 = i.a(f30024b, null, null, (m) ZeusTransformUtils.preCheckCast(new C0787d(r19, r44, r21, r11, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        Loog.INSTANCE.d(r110, "java_opensdk: startScanWithPackageNames: reqId=" + r45 + r111 + r10 + ", args=" + r18);     // Catch: Throwable -> L48
        r11.a(p.a(r44), (Executor) ZeusTransformUtils.preCheckCast(c(), Executor.class, "com.obric.aiagent.plugin"), r22, r18, (com.miui.guardprovider.sdk.d) ZeusTransformUtils.preCheckCast(r23, com.miui.guardprovider.sdk.d.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L48
        com.miui.guardprovider.sdk.f r25 = r11;
        z.a r26 = r21;
        w r27 = r19;
    L54:
        r29.f30028a = this;
        r29.f30029b = r10;
        r29.f30030c = r25;
        w r28 = r20;
        r29.f30031d = r28;
        r29.f30032e = r26;
        r29.f = r24;
        r29.g = r45;
        r29.h = r6;
        com.miui.guardprovider.sdk.f r46 = r25;
        int r30 = 1;
        r29.k = 1;
        Object r31 = r27.a(r29);
        Object r32 = r9;
        if (r31 != r32) goto L57;
        return r32;
    L57:
        long r39 = r6;
        long r33 = r45;
        d r112 = this;
        com.miui.guardprovider.sdk.f r34 = r46;
        r4 = r31;
        ca r35 = r24;
    L58:
        com.obric.autogui.platforms.miui.a.a.a r36 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");
        ca.a.a(r35, null, r30, null);
        n.a r37 = n.f38560a;     // Catch: Throwable -> L79
        d r38 = (d) ZeusTransformUtils.preCheckCast(r112, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L79
        m r40 = (m) ZeusTransformUtils.preCheckCast(new c(r28, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L79
        r29.f30028a = r112;     // Catch: Throwable -> L79
        r29.f30029b = r10;     // Catch: Throwable -> L79
        r29.f30030c = r34;     // Catch: Throwable -> L79
        r29.f30031d = r26;     // Catch: Throwable -> L79
        r29.f30032e = r36;     // Catch: Throwable -> L79
        r29.f = null;     // Catch: Throwable -> L79
        r29.g = r33;     // Catch: Throwable -> L79
        com.obric.autogui.platforms.miui.a.a.a r48 = r36;
        long r41 = r39;
        r29.h = r41;     // Catch: Throwable -> L77
        r29.k = 2;     // Catch: Throwable -> L77
        long r113 = r41;
        r4 = dg.b(WsConstants.EXIT_DELAY_TIME, r40, r29);     // Catch: Throwable -> L75
        if (r4 != r32) goto L66;
        return r32;
    L66:
        com.obric.autogui.platforms.miui.a.a.a r42 = r48;
        z.a r49 = r26;
        com.miui.guardprovider.sdk.f r50 = r34;
        d r51 = r112;
        String r114 = r10;
        long r115 = r33;
        long r52 = r113;
    L104:
        Long r53 = (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L73
        if (r53 != null) goto L70;
        long r116 = -1;
    L71:
        Object r54 = n.f(d.c.b.a.b.a(r116));     // Catch: Throwable -> L73
    L83:
        Long r55 = d.c.b.a.b.a(-1);
        if (n.b(r54) == false) goto L86;
        r54 = r55;
    L86:
        z.a r56 = r49;
        long r57 = ((Number) ZeusTransformUtils.preCheckCast(r54, Number.class, "com.obric.aiagent.plugin")).longValue();
        long r58 = SystemClock.elapsedRealtime() - r52;
        if (r42.a() == false) goto L89;
        Loog.INSTANCE.w(r110, "java_opensdk: scan done: VIRUS: reqId=" + r115 + r111 + r114 + ", outcome=" + r51.a(r42) + ", firstCb=" + r57 + "ms, cost=" + r58 + r7);
    L91:
        if (ZeusTransformUtils.instanceOf(r42, com.obric.autogui.platforms.miui.a.a.a.C0784a.class) == false) goto L93;
    L94:
        b(r56, r50, "final");
    L95:
        return r42;
    L93:
        if (ZeusTransformUtils.instanceOf(r42, com.obric.autogui.platforms.miui.a.a.a.c.class) == false) goto L95;
    L89:
        Loog.INSTANCE.i(r110, new StringBuilder().append("java_opensdk: scan done: reqId=").append(r115).append(r111).append(r114).append(", outcome=").append(r51.a(r42)).append(", firstCb=").append(r57).append("ms, cost=").append(r58).append(r7).toString());
        goto L91
    L70:
        r116 = r53.longValue() - r52;     // Catch: Throwable -> L73
    L73:
        th = th;
    L82:
        n.a r59 = n.f38560a;
        r54 = n.f(d.o.a(th));
    L75:
        th = th;
    L81:
        r42 = r48;
        r49 = r26;
        r50 = r34;
        r51 = r112;
        r114 = r10;
        r115 = r33;
        r52 = r113;
    L77:
        th = th;
        r113 = r41;
    L79:
        th = th;
        r48 = r36;
        r113 = r39;
    L48:
        th = move-exception;
        Loog.INSTANCE.e(r110, "java_opensdk: startScanWithPackageNames failed: reqId=" + r45 + r111 + r10 + ", err=" + th, th);
        if (r19.i() == true) goto L52;
        r27 = r19;
        r27.a(new com.obric.autogui.platforms.miui.a.a.a.b(r10, "java exception: " + th.getMessage()));
    L53:
        r25 = r11;
        r26 = r21;
        b(r26, r25, "startScan exception");
        goto L54
    L52:
        r27 = r19;
        goto L53
    L44:
        return new com.obric.autogui.platforms.miui.a.a.a.b(r10, "prepare failed");
    L28:
        th = move-exception;
        n.a r60 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L31
    L11:
        if (r5 == 1) goto L20;
        if (r5 != 2) goto L19;
        r52 = r15.h;
        r115 = r15.g;
        r42 = (com.obric.autogui.platforms.miui.a.a.a) ZeusTransformUtils.preCheckCast(r15.f30032e, com.obric.autogui.platforms.miui.a.a.a.class, "com.obric.aiagent.plugin");
        r49 = (z.a) ZeusTransformUtils.preCheckCast(r15.f30031d, z.a.class, "com.obric.aiagent.plugin");
        r50 = (com.miui.guardprovider.sdk.f) ZeusTransformUtils.preCheckCast(r15.f30030c, com.miui.guardprovider.sdk.f.class, "com.obric.aiagent.plugin");
        r114 = (String) ZeusTransformUtils.preCheckCast(r15.f30029b, String.class, "com.obric.aiagent.plugin");
        d r117 = (d) ZeusTransformUtils.preCheckCast(r15.f30028a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);     // Catch: Throwable -> L16
        r111 = ", pkg=";
        r7 = "ms";
        r110 = TAG;
        r51 = r117;
    L16:
        th = th;
        r111 = ", pkg=";
        r7 = "ms";
        r110 = TAG;
        r51 = r117;
        goto L82
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        long r118 = r15.h;
        r33 = r15.g;
        ca r61 = (ca) ZeusTransformUtils.preCheckCast(r15.f, ca.class, "com.obric.aiagent.plugin");
        z.a r62 = (z.a) ZeusTransformUtils.preCheckCast(r15.f30032e, z.a.class, "com.obric.aiagent.plugin");
        w r63 = (w) ZeusTransformUtils.preCheckCast(r15.f30031d, w.class, "com.obric.aiagent.plugin");
        com.miui.guardprovider.sdk.f r64 = (com.miui.guardprovider.sdk.f) ZeusTransformUtils.preCheckCast(r15.f30030c, com.miui.guardprovider.sdk.f.class, "com.obric.aiagent.plugin");
        String r65 = (String) ZeusTransformUtils.preCheckCast(r15.f30029b, String.class, "com.obric.aiagent.plugin");
        r112 = (d) ZeusTransformUtils.preCheckCast(r15.f30028a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        r39 = r118;
        r10 = r65;
        r28 = r63;
        r110 = TAG;
        r30 = 1;
        r35 = r61;
        r26 = r62;
        r32 = r9;
        r111 = ", pkg=";
        r34 = r64;
        r29 = r15;
    L7:
        r3 = new a(this, r2);
        goto L8
    }

    private static final void b(z.a r0, com.miui.guardprovider.sdk.f r1, String r2) {
        if (r0.f38499a == false) goto L5;
        return;
    L5:
        r0.f38499a = true;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L8
        r1.d();     // Catch: Throwable -> L8
        n.f(x.f38692a);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        n.a r4 = n.f38560a;
        n.f(d.o.a(th));
    }

    private final com.miui.guardprovider.sdk.b d() {
        com.miui.guardprovider.sdk.b r1 = new com.miui.guardprovider.sdk.b.a(4).a(true).a(30).a();
        o.c(r1, "build(...)");
        return r1;
    }

    private final long a(List<com.miui.guardprovider.c> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        long r1 = 0;
        if (r8 == false) goto L12;
        return 0;
    L12:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L14:
        if (r9.hasNext() == false) goto L20;
        com.miui.guardprovider.c r10 = (com.miui.guardprovider.c) ZeusTransformUtils.preCheckCast(r9.next(), com.miui.guardprovider.c.class, "com.obric.aiagent.plugin");
        n.a r3 = n.f38560a;     // Catch: Throwable -> L18
        r1 = r1 | r10.f();     // Catch: Throwable -> L18
        n.f(x.f38692a);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        n.a r4 = n.f38560a;
        n.f(d.o.a(th));
        goto L14
    L20:
        return r1;
    L5:
        if (r7.isEmpty() == true) goto L8;
        r8 = false;
        goto L9
    }

    private final String b(List<com.miui.guardprovider.c> r11) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L7;
        return "null";
    L7:
        if (r10.isEmpty() == false) goto L10;
        return "[]";
    L10:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(p.c((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), 3), Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        int r6 = r3 + 1;
        if (r3 >= 0) goto L16;
        p.c();
    L16:
        r2.add('#' + r3 + '{' + f30023a.a((com.miui.guardprovider.c) ZeusTransformUtils.preCheckCast(r5, com.miui.guardprovider.c.class, "com.obric.aiagent.plugin")) + '}');
        r3 = r6;
        goto L12
    L17:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        if (r10.size() <= 3) goto L20;
        String r12 = ", ...(+" + (r10.size() - 3) + ')';
    L22:
        return '[' + p.a((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null) + r12 + ']';
    L20:
        r12 = "";
        goto L22
    }

    private final String a(com.miui.guardprovider.c r11) {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L5
        d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(Integer.valueOf(r11.a()));     // Catch: Throwable -> L5
    L7:
        Object r5 = null;
        if (n.b(r4) == false) goto L10;
        r4 = null;
    L10:
        Integer r6 = (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.aiagent.plugin");
        n.a r7 = n.f38560a;     // Catch: Throwable -> L13
        d r8 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
        Object r9 = n.f(r11.b());     // Catch: Throwable -> L13
    L16:
        if (n.b(r9) == false) goto L18;
        r9 = null;
    L18:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
        n.a r12 = n.f38560a;     // Catch: Throwable -> L21
        d r13 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        Object r14 = n.f(r11.c());     // Catch: Throwable -> L21
    L24:
        if (n.b(r14) == false) goto L26;
        r14 = null;
    L26:
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.aiagent.plugin");
        n.a r16 = n.f38560a;     // Catch: Throwable -> L29
        d r17 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        Object r18 = n.f(r11.d());     // Catch: Throwable -> L29
    L32:
        if (n.b(r18) == false) goto L34;
        r18 = null;
    L34:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.aiagent.plugin");
        n.a r20 = n.f38560a;     // Catch: Throwable -> L37
        d r21 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L37
        Object r22 = n.f(Long.valueOf(r11.f()));     // Catch: Throwable -> L37
    L40:
        if (n.b(r22) == false) goto L42;
        r22 = 0L;
    L42:
        long r23 = ((Number) ZeusTransformUtils.preCheckCast(r22, Number.class, "com.obric.aiagent.plugin")).longValue();
        n.a r24 = n.f38560a;     // Catch: Throwable -> L51
        d r110 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L51
        Bundle r111 = r11.e();     // Catch: Throwable -> L51
        if (r111 == null) goto L48;
        Set<String> r112 = r111.keySet();     // Catch: Throwable -> L51
        if (r112 == null) goto L48;
        List r113 = p.c((Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.aiagent.plugin"), 5);     // Catch: Throwable -> L51
    L49:
        Object r114 = n.f(r113);     // Catch: Throwable -> L51
    L54:
        if (n.b(r114) == true) goto L58;
        r5 = r114;
    L58:
        return "level=" + r6 + ", name=" + r10 + ", desc=" + r15 + ", engine=" + r19 + ", flags=0x" + Long.toHexString(r23) + ", extrasKeys=" + ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"));
    L48:
        r113 = null;
    L51:
        th = move-exception;
        n.a r115 = n.f38560a;
        r114 = n.f(d.o.a(th));
    L37:
        th = move-exception;
        n.a r25 = n.f38560a;
        r22 = n.f(d.o.a(th));
    L29:
        th = move-exception;
        n.a r26 = n.f38560a;
        r18 = n.f(d.o.a(th));
    L21:
        th = move-exception;
        n.a r27 = n.f38560a;
        r14 = n.f(d.o.a(th));
    L13:
        th = move-exception;
        n.a r28 = n.f38560a;
        r9 = n.f(d.o.a(th));
    L5:
        th = move-exception;
        n.a r29 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    private final void a(String r9) {
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.e(TAG, "virus-scan-server not supported: pkg=" + r9 + ", rs=" + r8.getPackageManager().resolveService(com.miui.guardprovider.b.f13912a, 0) + ", pc=" + r8.checkSelfPermission("com.miui.guardprovider.permission.VirusScanNG"));
        IAutoActionTrackingApi r0 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r2 = new JSONObject();
        r2.put("exception_type", "virus_scan_not_supported");
        r2.put("debug_info", "pkg=" + r9 + ", sdk=virus-scan-server, api=startScanWithPackageNames");
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r0, "technical_bad_case", r2, false, false, null, 28, null);
    }

    private final void a(String r11, String r12) {
        Loog.INSTANCE.e(TAG, "virus-scan-server backend timeout: pkg=" + r11 + ", stack=" + r12);
        IAutoActionTrackingApi r2 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r4 = new JSONObject();
        r4.put("exception_type", "virus_scan_backend_timeout");
        r4.put("debug_info", "pkg=" + r11 + ", stack=" + r12);
        x r10 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r2, "technical_bad_case", r4, false, false, null, 28, null);
    }
}
