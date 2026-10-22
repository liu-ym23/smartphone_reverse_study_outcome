package com.obric.capability.schedulekit;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: IntentSdkVersionResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "IntentSdkVersionResolver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f31911a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f31912b = null;

    /* JADX INFO: compiled from: IntentSdkVersionResolver.kt */
    @d.c.b.a.f(b = "IntentSdkVersionResolver.kt", c = {35}, d = "getSdkVersionByIntent", e = "com.obric.capability.schedulekit.IntentSdkVersionResolver")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31914b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f31915c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31916d;

        a(f r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31915c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31914b = r3;
            this.f31916d |= Integer.MIN_VALUE;
            return this.f31915c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    private f() {
    }

    static {
        f31911a = new f();
        f31912b = new ConcurrentHashMap();
    }

    public final int a(String r6) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        if (r5 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == false) goto L11;
        return 0;
    L11:
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(f31912b.get(r6), Integer.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L24;
        return r8.intValue();
    L24:
        ApplicationInfo r9 = ((Context) ZeusTransformUtils.preCheckCast((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.capability.schedulekit.a.c.f31868a.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationInfo(r6, 128);     // Catch: Throwable -> L20
        o.c(r9, "context.packageManager.g…T_META_DATA\n            )");     // Catch: Throwable -> L20
        Bundle r10 = r9.metaData;     // Catch: Throwable -> L20
        if (r10 == null) goto L22;
        r1 = r10.getInt("obric.intent.sdk.version", 0);     // Catch: Throwable -> L20
    L22:
        ((Map) ZeusTransformUtils.preCheckCast(f31912b, Map.class, "com.obric.aiagent.plugin")).put(r6, Integer.valueOf(r1));
        return r1;
    L20:
        th = move-exception;
        com.obric.capability.schedulekit.c.c.f31906a.w(TAG, "getSdkVersionByPackage(" + r6 + ") failed: " + th.getMessage());
        goto L22
    L5:
        if (r5.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    public final Object a(String r5, d.c.d<? super Integer> r6) {
        d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
        if ((r0.f31916d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31916d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f31914b;
        Object r8 = d.c.a.b.a();
        int r2 = r0.f31916d;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (String) ZeusTransformUtils.preCheckCast(r0.f31913a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
    L17:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L20;
    L23:
        if (r3 == false) goto L26;
        com.obric.capability.schedulekit.c.c.f31906a.w(TAG, "getSdkVersionByIntent(" + r5 + ") no impl found");
        return d.c.b.a.b.a(0);
    L26:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == false) goto L36;
        Comparable r12 = (Comparable) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(f31911a.a(((AppIntentImplInfo) ZeusTransformUtils.preCheckCast(r11.next(), AppIntentImplInfo.class, "com.obric.aiagent.plugin")).getPackageName())), Comparable.class, "com.obric.aiagent.plugin");
    L30:
        if (r11.hasNext() == false) goto L34;
        Comparable r13 = (Comparable) ZeusTransformUtils.preCheckCast(d.c.b.a.b.a(f31911a.a(((AppIntentImplInfo) ZeusTransformUtils.preCheckCast(r11.next(), AppIntentImplInfo.class, "com.obric.aiagent.plugin")).getPackageName())), Comparable.class, "com.obric.aiagent.plugin");
        if (r12.compareTo(r13) >= 0) goto L30;
        r12 = r13;
        goto L30
    L34:
        return r12;
    L36:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new NoSuchElementException(), Throwable.class, "com.obric.aiagent.plugin"));
    L20:
        if (r10.isEmpty() == true) goto L23;
        r3 = false;
        goto L23
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        com.obric.capability.schedulekit.a r14 = com.obric.capability.schedulekit.a.f31846a;
        r0.f31913a = r5;
        r0.f31916d = 1;
        r4 = r14.a(r5, r0);
        if (r4 != r8) goto L17;
        return r8;
    L7:
        r0 = new a(this, r7);
        goto L8
    }
}
