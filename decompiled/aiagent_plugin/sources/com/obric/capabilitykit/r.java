package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f32199a = null;

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {75, 80, 89, 97}, d = "handleReturnedFd", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper")
    public static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f32200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f32201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32202c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f32203d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ r f32204e;
        public int f;

        public a(r r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32204e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32203d = r2;
            this.f |= Integer.MIN_VALUE;
            return r.a(this.f32204e, null, null, this);
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$2")
    public static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.n<? extends x>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputStream f32206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f32207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f32208d;

        public b(InputStream r3, AssetFileDescriptor r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32206b = r3;
            this.f32207c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super d.n<x>> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            b r0 = new b(this.f32206b, this.f32207c, r5);
            r0.f32208d = r3;
            return r0;
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.n<? extends x>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.f32205a != 0) goto L23;
            d.o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.f32208d, am.class, "com.obric.aiagent.plugin");
            this.f32206b.close();     // Catch: Throwable -> L7
            Object r7 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r8 = d.n.c(r7);
            if (r8 == null) goto L12;
            Logger.INSTANCE.e("UriShareHelper", "closing input stream raised error: " + r8, r8);
        L12:
            AssetFileDescriptor r4 = this.f32207c;
            r4.close();     // Catch: Throwable -> L15
            Logger.INSTANCE.d("UriShareHelper", "receiver closed the shared fd/" + r4.hashCode() + '.');     // Catch: Throwable -> L15
            Object r9 = d.n.f(x.f38692a);     // Catch: Throwable -> L15
        L17:
            Throwable r10 = d.n.c(r9);
            if (r10 == null) goto L21;
            Logger.INSTANCE.e("UriShareHelper", "closing fd raised error: " + r10, r10);
        L21:
            return d.n.g(r9);
        L15:
            th = move-exception;
            r9 = d.n.f(d.o.a(th));
        L7:
            th = move-exception;
            r7 = d.n.f(d.o.a(th));
            goto L9
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$1")
    public static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super FileInputStream>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f32210b;

        public c(AssetFileDescriptor r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32210b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super FileInputStream> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new c(this.f32210b, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super FileInputStream> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f32209a != 0) goto L7;
            d.o.a(r2);
            return this.f32210b.createInputStream();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$handleReturnedFd$iStream$2")
    public static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AssetFileDescriptor f32212b;

        public d(AssetFileDescriptor r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32212b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new d(this.f32212b, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f32211a != 0) goto L7;
            d.o.a(r2);
            this.f32212b.close();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {47, 60}, d = "openInputStreamByPackage", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper")
    public static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f32213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f32214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f32215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f32216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public /* synthetic */ Object f32217e;
        public final /* synthetic */ r f;
        public int g;

        public e(r r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32217e = r2;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, null, this);
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {129}, d = "startUriSession$capabilitykit_release", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper")
    public static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f32218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f32219b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f32220c;

        public f(r r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32219b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            this.f32218a = r2;
            this.f32220c |= Integer.MIN_VALUE;
            return this.f32219b.a(null, null, this);
        }
    }

    @d.c.b.a.f(b = "UriShareInternalHelper.kt", c = {ApWakeEvent.ACCELERATING_START}, d = "invokeSuspend", e = "com.obric.capabilitykit.execution.fileaccess.sharer.UriShareInternalHelper$startUriSession$session$1")
    public static final class g extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super UriFileAccessSession>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32221a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32222b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Uri f32223c;

        public g(String r3, Uri r4, d.c.d<? super g> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f32222b = r3;
            this.f32223c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super UriFileAccessSession> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return new g(this.f32222b, this.f32223c, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super UriFileAccessSession> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f32221a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            r r6 = r.f32199a;
            String r2 = this.f32222b;
            Uri r3 = this.f32223c;
            this.f32221a = 1;
            r5 = r.a(r6, r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public static final class h extends d.h.b.p implements d.h.a.b<UriFileAccessSession, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n<UriFileAccessSession> f32224a;

        public h(kotlinx.coroutines.n<? super UriFileAccessSession> r3) {
            this.f32224a = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
            super(1);
        }

        public final void a(UriFileAccessSession r2) {
            d.h.b.o.e(r2, SensitiveType.SESSION);
            kotlinx.coroutines.n<UriFileAccessSession> r1 = this.f32224a;
            r1.resumeWith(d.n.f(r2));     // Catch: Throwable -> L5
            Object r3 = d.n.f(x.f38692a);     // Catch: Throwable -> L5
        L8:
            if (d.n.c(r3) == null) goto L15;
            AssetFileDescriptor r4 = r2.getFd();
            if (r4 == null) goto L16;
            r4.close();
            return;
        L16:
            return;
        L15:
            return;
        L5:
            th = move-exception;
            r3 = d.n.f(d.o.a(th));
            goto L8
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(UriFileAccessSession r3) {
            a((UriFileAccessSession) ZeusTransformUtils.preCheckCast(r3, UriFileAccessSession.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }
    }

    static {
        f32199a = new r();
    }

    private r() {
    }

    private final int a(String r2, Uri r3) {
        AtomicCapabilitySdk.INSTANCE.stopUriFileAccess$capabilitykit_release(r3, r2);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
        return 1;
    }

    public static final /* synthetic */ w$a a(r r2, d.h.a.b r3) {
        return r2.a((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.obric.capabilitykit.w$a] */
    private final w$a a(d.h.a.b<? super UriFileAccessSession, x> r2) {
        final d.h.a.b r1 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin");
        return new w$a(r1);
    }

    private final Object a(AssetFileDescriptor r11, d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r12, d.c.d<? super Integer> r13) {
        d.h.a.m r14 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r15, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15, a.class, "com.obric.aiagent.plugin");
        int r2 = r0.f;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f = r2 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.f32203d;
        Object r16 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L26;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L22;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        int r17 = r0.f32202c;
        d.o.a(r10);
    L44:
        return d.c.b.a.b.a(r17);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        InputStream r18 = (InputStream) ZeusTransformUtils.preCheckCast(r0.f32201b, InputStream.class, "com.obric.aiagent.plugin");
        AssetFileDescriptor r19 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r0.f32200a, AssetFileDescriptor.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Exception -> L20
    L35:
        int r110 = 0;
    L36:
        InputStream r9 = r18;
        r17 = r110;
        ai r1 = bd.c();
        b r4 = new b(r9, r19, null);
        r0.f32200a = null;
        r0.f32201b = null;
        r0.f32202c = r17;
        r0.f = 4;
        if (kotlinx.coroutines.i.a(r1, r4, r0) != r16) goto L44;
        return r16;
    L20:
        Exception e2 = e;
    L39:
        Logger.INSTANCE.e("UriShareHelper", "handle input stream raised error: " + e2, e2);
        r110 = 6;
        goto L36
    L22:
        d.o.a(r10);
    L50:
        return d.c.b.a.b.a(5);
    L23:
        r14 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r0.f32201b, d.h.a.m.class, "com.obric.aiagent.plugin");
        r11 = (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r0.f32200a, AssetFileDescriptor.class, "com.obric.aiagent.plugin");
        d.o.a(r10);     // Catch: Exception -> L45
    L30:
        d.h.b.o.c(r10, "fd: AssetFileDescriptor,…)\n            }\n        }");     // Catch: Exception -> L45
        InputStream r111 = (InputStream) ZeusTransformUtils.preCheckCast(r10, InputStream.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45
        Logger.INSTANCE.i("UriShareHelper", "the client is handling the returned InputStream...");     // Catch: Exception -> L37
        r0.f32200a = r11;     // Catch: Exception -> L37
        r0.f32201b = r111;     // Catch: Exception -> L37
        r0.f = 3;     // Catch: Exception -> L37
        if (r14.invoke(r111, r0) != r16) goto L34;
        return r16;
    L34:
        r19 = r11;
        r18 = r111;
    L37:
        e = move-exception;
        AssetFileDescriptor r20 = r11;
        r18 = r111;
        e2 = e;
        r19 = r20;
        goto L39
    L26:
        d.o.a(r10);
        ai r112 = bd.c();     // Catch: Exception -> L45
        c r5 = new c(r11, null);     // Catch: Exception -> L45
        r0.f32200a = r11;     // Catch: Exception -> L45
        r0.f32201b = r14;     // Catch: Exception -> L45
        r0.f = 1;     // Catch: Exception -> L45
        r10 = kotlinx.coroutines.i.a(r112, r5, r0);     // Catch: Exception -> L45
        if (r10 != r16) goto L30;
        return r16;
    L45:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "cannot open input stream; error: " + e, e);
        ai r113 = bd.c();
        d r114 = new d(r11, null);
        r0.f32200a = null;
        r0.f32201b = null;
        r0.f = 2;
        if (kotlinx.coroutines.i.a(r113, r114, r0) != r16) goto L50;
        return r16;
    L7:
        r0 = new a(this, r15);
        goto L8
    }

    public static final /* synthetic */ Object a(r r2, AssetFileDescriptor r3, d.h.a.m r4, d.c.d r5) {
        return r2.a(r3, (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.m.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(r r2, String r3, Uri r4, d.c.d r5) {
        return r2.b(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    private final Object b(String r9, Uri r10, d.c.d<? super UriFileAccessSession> r11) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r12 = new kotlinx.coroutines.o(d.c.a.b.a(r8), 1);
        r12.e();
        AtomicCapabilitySdk.INSTANCE.requestUriFileAccess$capabilitykit_release(r10, r9, a(f32199a, new h(r12)));     // Catch: Exception -> L5
    L11:
        Object r13 = r12.h();
        if (r13 != d.c.a.b.a()) goto L14;
        d.c.b.a.h.c(r8);
    L14:
        return r13;
    L5:
        e = move-exception;
        Logger.INSTANCE.e("UriShareHelper", "requestUriFileAccess; exception=" + e, e);
        r12.resumeWith(d.n.f(new UriFileAccessSession(7, null, null, 6, null)));     // Catch: Throwable -> L9
        d.n.f(x.f38692a);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        d.n.f(d.o.a(th));
        goto L11
    }

    public final Object a(AppEntity r3, Uri r4, d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r5, d.c.d<? super Integer> r6) {
        d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r7 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d<? super Integer> r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        String r9 = r3.getPackageName();
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        Logger.INSTANCE.e("UriShareHelper", "no sharer package found in entity.");
        return d.c.b.a.b.a(3);
    L10:
        return a(r9, r4, r7, r8);
    L5:
        r0 = false;
        goto L6
    }

    public final Object a(String r7, Uri r8, d.c.d<? super UriFileAccessSession> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r10, f.class, "com.obric.aiagent.plugin");
        int r2 = r0.f32220c;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f32220c = r2 - Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f32218a;
        Object r11 = d.c.a.b.a();
        int r3 = r0.f32220c;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r6);
    L17:
        UriFileAccessSession r12 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r6, UriFileAccessSession.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L21;
        Logger.INSTANCE.e("UriShareHelper", "startUriSession: withTimeoutOrNull exceeds timeout: 3000ms ");
        return new UriFileAccessSession(9, "访问文件超时", null, 4, null);
    L21:
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        g r13 = new g(r7, r8, null);
        r0.f32220c = 1;
        r6 = dg.b(WsConstants.EXIT_DELAY_TIME, r13, r0);
        if (r6 != r11) goto L17;
        return r11;
    L7:
        r0 = new f(this, r10);
        goto L8
    }

    public final Object a(String r9, Uri r10, d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r11, d.c.d<? super Integer> r12) {
        d.h.a.m<? super InputStream, ? super d.c.d<? super x>, ? extends Object> r13 = (d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.m.class, "com.obric.aiagent.plugin");
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, e.class) == false) goto L7;
        e r1 = (e) ZeusTransformUtils.preCheckCast(r14, e.class, "com.obric.aiagent.plugin");
        int r3 = r1.g;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r1.g = r3 - Integer.MIN_VALUE;
    L8:
        Object r15 = r1.f32217e;
        Object r4 = d.c.a.b.a();
        int r5 = r1.g;
        if (r5 == 0) goto L16;
        if (r5 == 1) goto L15;
        if (r5 != 2) goto L14;
        Uri r8 = (Uri) ZeusTransformUtils.preCheckCast(r1.f32215c, Uri.class, "com.obric.aiagent.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r1.f32214b, String.class, "com.obric.aiagent.plugin");
        r r16 = (r) ZeusTransformUtils.preCheckCast(r1.f32213a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L30:
        int r17 = ((Number) ZeusTransformUtils.preCheckCast(r15, Number.class, "com.obric.aiagent.plugin")).intValue();
        if (r17 == 0) goto L33;
        r16.a(r9, r8);
        return d.c.b.a.b.a(r17);
    L33:
        return d.c.b.a.b.a(r16.a(r9, r8));
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (d.h.a.m) ZeusTransformUtils.preCheckCast(r1.f32216d, d.h.a.m.class, "com.obric.aiagent.plugin");
        r10 = (Uri) ZeusTransformUtils.preCheckCast(r1.f32215c, Uri.class, "com.obric.aiagent.plugin");
        r9 = (String) ZeusTransformUtils.preCheckCast(r1.f32214b, String.class, "com.obric.aiagent.plugin");
        r this = (r) ZeusTransformUtils.preCheckCast(r1.f32213a, r.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
    L19:
        UriFileAccessSession r18 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r15, UriFileAccessSession.class, "com.obric.aiagent.plugin");
        AssetFileDescriptor r0 = r18.getFd();
        if (r18.getStatus() != 0) goto L22;
        if (r0 == null) goto L25;
        r1.f32213a = this;
        r1.f32214b = r9;
        r1.f32215c = r10;
        r1.f32216d = null;
        r1.g = 2;
        r15 = this.a(r0, r13, r1);
        if (r15 != r4) goto L29;
        return r4;
    L29:
        Uri r7 = r10;
        r16 = this;
        r8 = r7;
        goto L30
    L25:
        return d.c.b.a.b.a(1);
    L22:
        return d.c.b.a.b.a(r18.getStatus());
    L16:
        d.o.a(r15);
        r1.f32213a = this;
        r1.f32214b = r9;
        r1.f32215c = r10;
        r1.f32216d = r13;
        r1.g = 1;
        r15 = a(r9, r10, r1);
        if (r15 != r4) goto L19;
        return r4;
    L7:
        r1 = new e(this, r14);
        goto L8
    }
}
