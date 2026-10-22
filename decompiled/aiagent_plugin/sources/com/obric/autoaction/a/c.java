package com.obric.autoaction.a;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ao;
import androidx.lifecycle.p;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;

/* JADX INFO: compiled from: ComponentHost.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f22632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final p f22633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final androidx.lifecycle.i f22634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<f> f22635e;
    private final Map<Class<?>, Object> f;
    private final ao g;
    private final androidx.lifecycle.am h;

    public c(Context r9, am r10, p r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        am r13 = (am) ZeusTransformUtils.wrapperContextForParams(r10, am.class, "com.obric.aiagent.plugin");
        p r14 = (p) ZeusTransformUtils.wrapperContextForParams(r11, p.class, "com.obric.aiagent.plugin");
        o.e(r12, "context");
        o.e(r13, "uiScope");
        o.e(r14, "lifecycleOwner");
        this.f22631a = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");
        this.f22632b = r13;
        this.f22633c = r14;
        this.f22634d = r14.getLifecycle();
        this.f22635e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        ao r3 = new ao();
        this.g = r3;
        this.h = new androidx.lifecycle.am(r3, (androidx.lifecycle.am.b) ZeusTransformUtils.preCheckCast(new androidx.lifecycle.am.c(), androidx.lifecycle.am.b.class, "com.obric.aiagent.plugin"), null, 4, null);
    }

    public final Context getContext() {
        return this.f22631a;
    }

    public final am a() {
        return this.f22632b;
    }

    public final p b() {
        return this.f22633c;
    }

    public final androidx.lifecycle.am c() {
        return this.h;
    }

    public final void a(f r4) {
        f r5 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        o.e(r5, "component");
        ((Collection) ZeusTransformUtils.preCheckCast(this.f22635e, Collection.class, "com.obric.aiagent.plugin")).add(r5);
        if (ZeusTransformUtils.instanceOf(r5, androidx.lifecycle.d.class) == false) goto L6;
        this.f22634d.a((androidx.lifecycle.o) ZeusTransformUtils.preCheckCast(r5, androidx.lifecycle.o.class, "com.obric.aiagent.plugin"));
        return;
    }

    public final void d() {
        an.a(this.f22632b, null, 1, null);
        this.f22635e.clear();
        this.f.clear();
        this.g.b();
    }

    public final void a(Intent r4) {
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f22635e, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r3.next(), f.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, e.class) == false) goto L4;
        ((e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.aiagent.plugin")).a(r4);
        goto L4
    }

    public final void a(Class<?> r2, Object r3) {
        o.e(r2, "clazz");
        o.e(r3, WsConstants.KEY_SERVICE);
        this.f.put(r2, r3);
    }

    public final <T> T a(Class<T> r2) {
        o.e(r2, "clazz");
        T r1 = (T) this.f.get(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1;
    }
}
