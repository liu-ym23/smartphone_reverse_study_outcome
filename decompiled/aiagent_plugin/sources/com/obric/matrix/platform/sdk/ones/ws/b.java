package com.obric.matrix.platform.sdk.ones.ws;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.matrix.a.ad;
import com.obric.matrix.a.ae;
import com.obric.matrix.a.at;
import com.obric.matrix.a.av;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.a.r;
import d.h.a.w;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MatrixWsHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static final String TAG = "MatrixWsHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f33744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.matrix.platform.sdk.ones.ws.a f33745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<r<Integer, Integer, Integer, Boolean, x>> f33746c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, w<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, x>> f33747d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f33748e = null;
    private static boolean f;
    private static final C0913b g = null;
    private static final d h = null;
    private static m<? super Boolean, ? super ad, x> i;

    /* JADX INFO: compiled from: MatrixWsHelper.kt */
    public static final class a implements com.obric.matrix.platform.sdk.ones.c {
        a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.c
        public void a(int r18, ad r19) {
            o.e(r19, "response");
            ae r0 = r19.i;
            if (r0 == null) goto L10;
            at r1 = r0.f33300d;
            if (r1 == null) goto L11;
            ConcurrentHashMap r2 = b.a();
            Integer r3 = r1.f33400b.k;
            o.c(r3, "it.wsMessageInfo.service");
            int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue();
            Integer r5 = r1.f33400b.l;
            o.c(r5, "it.wsMessageInfo.method");
            w r7 = (w) ZeusTransformUtils.preCheckCast(r2.get(com.obric.matrix.platform.sdk.ones.ws.c.a(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue())), w.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L12;
            Integer r8 = r1.f33400b.q;
            o.c(r8, "it.wsMessageInfo.channelId");
            Long r9 = r1.f33400b.i;
            o.c(r9, "it.wsMessageInfo.seqId");
            Long r10 = r1.f33400b.j;
            o.c(r10, "it.wsMessageInfo.logId");
            Integer r11 = r1.f33400b.k;
            o.c(r11, "it.wsMessageInfo.service");
            Integer r12 = r1.f33400b.l;
            o.c(r12, "it.wsMessageInfo.method");
            r7.a(r8, r9, r10, r11, r12, r1.f33400b.n, r1.f33400b.m, r1.f33400b.o.m(), r1.f33400b.r);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.ws.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MatrixWsHelper.kt */
    public static final class C0913b implements com.obric.matrix.platform.sdk.ones.c {
        C0913b() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.c
        public void a(int r8, ad r9) {
            o.e(r9, "response");
            ae r7 = r9.i;
            if (r7 == null) goto L10;
            av r10 = r7.f33301e;
            if (r10 == null) goto L10;
            a(b.TAG, "wsStatusCallbackFromMatrix # onResult() called with subscribeWsStatusResponse = " + r10);
            b r11 = b.f33744a;
            Boolean r12 = r10.i;
            o.c(r12, "it.isConnected");
            b.a(r12.booleanValue());
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(b.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            r r1 = (r) ZeusTransformUtils.preCheckCast(r13.next(), r.class, "com.obric.aiagent.plugin");
            Integer r3 = r10.f;
            o.c(r3, "it.channelType");
            Integer r4 = r10.g;
            o.c(r4, "it.connectionState");
            Integer r5 = r10.h;
            o.c(r5, "it.channelId");
            Boolean r6 = r10.i;
            o.c(r6, "it.isConnected");
            r1.a(r3, r4, r5, r6);
        L10:
            m r14 = b.b();
            if (r14 == null) goto L22;
            ae r15 = r9.i;
            if (r15 == null) goto L15;
            av r16 = r15.f33301e;
        L16:
            if (r16 == null) goto L18;
            boolean r17 = true;
        L19:
            r14.invoke(Boolean.valueOf(r17), r9);
            b r18 = b.f33744a;
            b.a(null);
            return;
        L18:
            r17 = false;
            goto L19
        L15:
            r16 = null;
            goto L16
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: MatrixWsHelper.kt */
    static final class c extends p implements r<Integer, Integer, Integer, Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f33749a = null;

        static {
            f33749a = new c();
        }

        c() {
            super(4);
        }

        @Override // d.h.a.r
        public /* synthetic */ x a(Integer r3, Integer r4, Integer r5, Boolean r6) {
            a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(int r7, int r8, int r9, boolean r10) {
            com.obric.matrix.platform.sdk.ones.internal.b.b.b(b.TAG, "wsStatusReceiverFromMatrix receive: channelType = " + r7 + ", connectionState = " + r8 + ", channelId = " + r9 + ", isConnected = " + r10, null, 4, null);
            b r6 = b.f33744a;
            b.a(r10);
            List r11 = b.c();
            monitor-enter(r11);
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(b.c(), Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
        L6:
            if (r0.hasNext() == false) goto L8;
            ((r) ZeusTransformUtils.preCheckCast(r0.next(), r.class, "com.obric.aiagent.plugin")).a(Integer.valueOf(r7), Integer.valueOf(r8), Integer.valueOf(r9), Boolean.valueOf(r10));     // Catch: Throwable -> L11
            goto L6
        L8:
            x r12 = x.f38692a;     // Catch: Throwable -> L11
            monitor-exit(r11);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    private b() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return f33747d;
    }

    public static final /* synthetic */ void a(m r2) {
        i = (m) ZeusTransformUtils.wrapperContextForParams(r2, m.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(boolean r0) {
        f = r0;
    }

    public static final /* synthetic */ m b() {
        return i;
    }

    public static final /* synthetic */ List c() {
        return f33746c;
    }

    static {
        f33744a = new b();
        f33746c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f33747d = new ConcurrentHashMap();
        f33748e = new a();
        g = new C0913b();
        h = new d((r) ZeusTransformUtils.preCheckCast(c.f33749a, r.class, "com.obric.aiagent.plugin"));
    }

    public final void a(int r16, long r17, long r19, int r21, int r22, String r23, String r24, byte[] r25, HashMap<String, String> r26) {
        com.obric.matrix.platform.sdk.ones.internal.b.b.b(TAG, "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + f33745b, null, 4, null);
        com.obric.matrix.platform.sdk.ones.ws.a r2 = f33745b;
        if (r2 == null) goto L6;
        r2.a(r16, r17, r19, r21, r22, r23, r24, r25, (Map) ZeusTransformUtils.preCheckCast(r26, Map.class, "com.obric.aiagent.plugin"));
        return;
    }
}
