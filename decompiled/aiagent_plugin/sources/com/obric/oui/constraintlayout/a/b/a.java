package com.obric.oui.constraintlayout.a.b;

import com.obric.oui.constraintlayout.a.a.a.p;
import com.obric.oui.constraintlayout.a.c.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: WidgetFrame.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    public static float n = Float.NaN;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f34665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f34666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f34667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f34668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f34669e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float o;
    public float p;
    public float q;
    public float r;
    public int s;
    public String t;
    p u;
    private final HashMap<String, com.obric.oui.constraintlayout.a.a.a> v;

    static {
    }

    public a() {
        this.f34665a = null;
        this.f34666b = 0;
        this.f34667c = 0;
        this.f34668d = 0;
        this.f34669e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = 0;
        this.v = new HashMap();
        this.t = null;
    }

    public a(e r4) {
        this.f34665a = null;
        this.f34666b = 0;
        this.f34667c = 0;
        this.f34668d = 0;
        this.f34669e = 0;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = 0;
        this.v = new HashMap();
        this.t = null;
        this.f34665a = r4;
    }

    public void a(a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.i = r4.i;
        this.j = r4.j;
        this.k = r4.k;
        this.l = r4.l;
        this.m = r4.m;
        this.o = r4.o;
        this.p = r4.p;
        this.q = r4.q;
        this.s = r4.s;
        a(r4.u);
        this.v.clear();
        Iterator<com.obric.oui.constraintlayout.a.a.a> r5 = r4.v.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        com.obric.oui.constraintlayout.a.a.a r0 = (com.obric.oui.constraintlayout.a.a.a) ZeusTransformUtils.preCheckCast(r5.next(), com.obric.oui.constraintlayout.a.a.a.class, "com.obric.aiagent.plugin");
        this.v.put(r0.b(), r0.a());
        goto L6
    }

    public a update() {
        e r0 = this.f34665a;
        if (r0 == null) goto L5;
        this.f34666b = r0.J();
        this.f34667c = this.f34665a.K();
        this.f34668d = this.f34665a.L();
        this.f34669e = this.f34665a.M();
        a(this.f34665a.j);
    L5:
        return this;
    }

    public a update(e r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        this.f34665a = r1;
        update();
        return this;
    }

    void a(p r1) {
        this.u = r1;
    }
}
