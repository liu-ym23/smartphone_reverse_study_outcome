package com.gyf.barlibrary;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BarParams.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Cloneable {
    int A;
    boolean B;
    public boolean C;
    int D;
    boolean E;
    boolean F;
    boolean G;

    @Deprecated
    boolean H;
    i I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f13798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f13799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f13800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f13801e;
    float f;
    public boolean g;
    boolean h;
    b i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    float n;
    float o;
    boolean p;
    int q;
    int r;
    Map<View, Map<Integer, Integer>> s;
    float t;
    int u;
    int v;
    float w;
    public boolean x;
    View y;
    View z;

    public c() {
        this.f13797a = 0;
        this.f13798b = -16777216;
        this.f13799c = true;
        this.f13800d = -16777216;
        this.f13801e = 0.0f;
        this.f = 0.0f;
        this.g = false;
        this.h = false;
        this.i = b.f13795d;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = true;
        this.q = -16777216;
        this.r = -16777216;
        this.s = new HashMap();
        this.t = 0.0f;
        this.u = 0;
        this.v = -16777216;
        this.w = 0.0f;
        this.x = false;
        this.B = false;
        this.C = false;
        this.D = 18;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = false;
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public c a() {
        return (c) ZeusTransformUtils.preCheckCast(super.clone(), c.class, "com.obric.aiagent.plugin");
    L4:
        return null;
    }
}
