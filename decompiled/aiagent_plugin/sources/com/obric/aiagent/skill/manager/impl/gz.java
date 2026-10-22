package com.obric.aiagent.skill.manager.impl;

import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SkillShopPaging.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class gz<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20063a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<T, String> f20065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashMap<String, T> f20066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20067e;
    private int f;
    private gy g;
    private boolean h;

    /* JADX INFO: compiled from: SkillShopPaging.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f20063a = new a(null);
    }

    public gz(int r3, d.h.a.b<? super T, String> r4) {
        d.h.a.b<T, String> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "itemKey");
        this.f20064b = r3;
        this.f20065c = r5;
        this.f20066d = new LinkedHashMap();
        this.f = 1;
        this.h = true;
    }

    public /* synthetic */ gz(int r2, d.h.a.b r3, int r4, d.h.b.h r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L5;
        r2 = 10;
    L5:
        this(r2, r6);
    }

    public final List<T> a() {
        Collection<T> r2 = this.f20066d.values();
        d.h.b.o.c(r2, "<get-values>(...)");
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final boolean b() {
        return this.h;
    }

    public final void c() {
        this.f20067e++;
        this.f = 1;
        this.g = null;
        this.h = true;
        this.f20066d.clear();
    }

    public final gy d() {
        if (this.g == null) goto L5;
        return null;
    L5:
        if (this.h == false) goto L11;
        gy r0 = new gy(this.f20067e, this.f, this.f20064b);
        this.g = r0;
        return r0;
    L11:
        return null;
    }

    public final boolean a(gy r8, an<? extends T> r9) {
        d.h.b.o.e(r8, Ext.KEY_REQUEST);
        d.h.b.o.e(r9, "result");
        if (d.h.b.o.a(this.g, r8) == true) goto L5;
        return false;
    L5:
        if (r8.a() != this.f20067e) goto L25;
        Iterator<T> r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        String r2 = null;
        if (r10.hasNext() == false) goto L16;
        T r0 = r10.next();
        String r4 = this.f20065c.invoke(r0);
        if ((true ^ d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L13;
        r2 = r4;
    L13:
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L8;
        ((Map) ZeusTransformUtils.preCheckCast(this.f20066d, Map.class, "com.obric.aiagent.plugin")).put(r3, r0);
        goto L8
    L16:
        this.f = r9.b() + 1;
        this.h = r9.c();
        this.g = null;
        return true;
    L25:
        return false;
    }

    public final boolean a(gy r5) {
        d.h.b.o.e(r5, Ext.KEY_REQUEST);
        if (d.h.b.o.a(this.g, r5) == true) goto L5;
        return false;
    L5:
        if (r5.a() != this.f20067e) goto L11;
        this.g = null;
        return true;
    L11:
        return false;
    }
}
