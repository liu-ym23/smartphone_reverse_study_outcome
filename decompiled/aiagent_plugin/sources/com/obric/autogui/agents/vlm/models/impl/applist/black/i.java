package com.obric.autogui.agents.vlm.models.impl.applist.black;

import android.content.Context;
import com.google.gson.Gson;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.ad;
import d.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: CachedConfiguredDisplayedTextsBundle.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "C-Cfg-DTxtBdl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile Map<String, ? extends Object> f27414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f27415e;
    private final ReentrantReadWriteLock f;
    private final AtomicBoolean g;
    private final am h;

    /* JADX INFO: renamed from: com.obric.autogui.agents.vlm.models.impl.applist.black.i$1, reason: invalid class name */
    /* JADX INFO: compiled from: CachedConfiguredDisplayedTextsBundle.kt */
    @d.c.b.a.f(b = "CachedConfiguredDisplayedTextsBundle.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.CachedConfiguredDisplayedTextsBundle$1")
    static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f27417b;

        AnonymousClass1(i r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27417b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f27417b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f27416a != 0) goto L7;
            d.o.a(r2);
            i.a(this.f27417b);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: CachedConfiguredDisplayedTextsBundle.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: CachedConfiguredDisplayedTextsBundle.kt */
    @d.c.b.a.f(b = "CachedConfiguredDisplayedTextsBundle.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.CachedConfiguredDisplayedTextsBundle$triggerCacheReloadIfNeeded$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f27419b;

        b(i r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27419b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f27419b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f27418a != 0) goto L12;
            d.o.a(r2);
            i.a(this.f27419b);     // Catch: Throwable -> L8
            i.b(this.f27419b).set(false);
            return x.f38692a;
        L8:
            th = move-exception;
            i.b(this.f27419b).set(false);
            throw th;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f27411a = new a(null);
    }

    public i(String r10, int r11) {
        d.h.b.o.e(r10, "name");
        this.f27412b = r10;
        this.f27413c = r11;
        this.f27414d = ao.b();
        this.f27415e = -1;
        this.f = new ReentrantReadWriteLock();
        this.g = new AtomicBoolean(false);
        am r3 = an.a(bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.h = r3;
        kotlinx.coroutines.i.a(r3, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public /* synthetic */ i(String r1, int r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 600000;
    L5:
        this(r1, r2);
    }

    public static final /* synthetic */ void a(i r0) {
        r0.b();
    }

    public static final /* synthetic */ AtomicBoolean b(i r0) {
        return r0.g;
    }

    public String a(Context r3, String r4, int r5, Object... r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        d.h.b.o.e(r4, "templateName");
        d.h.b.o.e(r6, "args");
        a();
        ReentrantReadWriteLock.ReadLock r0 = this.f.readLock();
        r0.lock();
        Object r2 = this.f27414d.get(r4);     // Catch: Throwable -> L9
        r0.unlock();
        if (ZeusTransformUtils.instanceOf(r2, String.class) == false) goto L7;
        ad r8 = ad.f38485a;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        Object[] r10 = Arrays.copyOf(r6, r6.length);
        String r11 = String.format(r9, Arrays.copyOf(r10, r10.length));
        d.h.b.o.c(r11, "format(...)");
        return r11;
    L7:
        String r12 = r7.getString(r5, Arrays.copyOf(r6, r6.length));
        d.h.b.o.a(r12);
        return r12;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final void a() {
        if ((System.currentTimeMillis() - this.f27415e) > this.f27413c) goto L5;
        return;
    L5:
        if (this.g.compareAndSet(false, true) == false) goto L9;
        kotlinx.coroutines.i.a(this.h, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    private final void b() {
        ReentrantReadWriteLock r2 = this.f;
        ReentrantReadWriteLock.ReadLock r3 = r2.readLock();
        int r5 = 0;
        if (r2.getWriteHoldCount() != 0) goto L5;
        int r4 = r2.getReadHoldCount();
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L9;
        r3.unlock();
        r6 = r6 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r7 = r2.writeLock();
        r7.lock();
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L53
        if (this.f27415e != (-1)) goto L13;
    L15:
        Loog.INSTANCE.d(TAG, "[TextBundle] Reloading cache for text bundle: " + this.f27412b);     // Catch: Throwable -> L53
        String r9 = AutoActionConfigs.INSTANCE.getStringCfg("tb." + this.f27412b);     // Catch: Throwable -> L53
        if (r9 != null) goto L60;
        Loog.INSTANCE.e(TAG, "[TextBundle] Cannot fetch configured textBundle [" + this.f27412b + ']');     // Catch: Throwable -> L53
        this.f27415e = System.currentTimeMillis();     // Catch: Throwable -> L53
    L46:
        x r13 = x.f38692a;     // Catch: Throwable -> L53
    L47:
        if (r5 >= r4) goto L49;
        r3.lock();
        r5 = r5 + 1;
        goto L47
    L49:
        r7.unlock();
        return;
    L60:
        Object r10 = new Gson().fromJson(r9, new CachedConfiguredDisplayedTextsBundle$loadCache$1$mapType$1().getType());     // Catch: Throwable -> L41 Exception -> L43
        d.h.b.o.c(r10, "fromJson(...)");     // Catch: Throwable -> L41 Exception -> L43
        Map r11 = (Map) ZeusTransformUtils.preCheckCast(r10, Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        Map<String, ? extends Object> r12 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        Iterator r14 = r11.entrySet().iterator();     // Catch: Throwable -> L41 Exception -> L43
    L21:
        if (r14.hasNext() == false) goto L37;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        Object r17 = r15.getValue();     // Catch: Throwable -> L41 Exception -> L43
        if (ZeusTransformUtils.instanceOf(r17, List.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L21;
        r12.put(r16, r17);     // Catch: Throwable -> L41 Exception -> L43
        goto L21
    L24:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L41 Exception -> L43
        Iterator r20 = r18.iterator();     // Catch: Throwable -> L41 Exception -> L43
    L26:
        if (r20.hasNext() == false) goto L33;
        Object r110 = r20.next();     // Catch: Throwable -> L41 Exception -> L43
        if (r110 == null) goto L30;
        String r111 = r110.toString();     // Catch: Throwable -> L41 Exception -> L43
    L31:
        if (r111 == null) goto L26;
        r19.add(r111);     // Catch: Throwable -> L41 Exception -> L43
        goto L26
    L30:
        r111 = null;
        goto L31
    L33:
        r12.put(r16, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new String[0]), String[].class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41 Exception -> L43
        goto L21
    L37:
        this.f27414d = r12;     // Catch: Throwable -> L41 Exception -> L43
        Loog.INSTANCE.d(TAG, "[TextBundle] Successfully loaded textBundle [" + this.f27412b + ']');     // Catch: Throwable -> L41 Exception -> L43
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L53
    L39:
        this.f27415e = r0;     // Catch: Throwable -> L53
        goto L46
    L43:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "[TextBundle] Failed to parse textBundle [" + this.f27412b + ']', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L41
        r0 = System.currentTimeMillis();     // Catch: Throwable -> L53
    L41:
        th = move-exception;
        this.f27415e = System.currentTimeMillis();     // Catch: Throwable -> L53
        throw th;     // Catch: Throwable -> L53
    L13:
        if ((r8 - this.f27415e) > this.f27413c) goto L15;
    L53:
        th = move-exception;
    L54:
        if (r5 >= r4) goto L56;
        r3.lock();
        r5 = r5 + 1;
        goto L54
    L56:
        r7.unlock();
        throw th;
    L5:
        r4 = 0;
        goto L6
    }

    public String[] a(Context r3, String r4) {
        d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
        d.h.b.o.e(r4, "templateName");
        a();
        ReentrantReadWriteLock.ReadLock r5 = this.f.readLock();
        r5.lock();
        Object r2 = this.f27414d.get(r4);     // Catch: Throwable -> L10
        if ((r2 instanceof String[]) == false) goto L7;
        String[] r6 = (String[]) ZeusTransformUtils.preCheckCast(r2, String[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L10
    L8:
        r5.unlock();
        return r6;
    L7:
        r6 = null;
    L10:
        th = move-exception;
        r5.unlock();
        throw th;
    }
}
