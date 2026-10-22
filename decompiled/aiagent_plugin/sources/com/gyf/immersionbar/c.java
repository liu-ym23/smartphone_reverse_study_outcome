package com.gyf.immersionbar;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BarParams.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Cloneable {
    public View A;
    public boolean B;
    public int C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f13831J;
    public boolean K;
    m L;
    n M;
    l N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13836e;
    public float f;
    public float g;
    public boolean h;
    public boolean i;
    public b j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public int s;
    Map<View, Map<Integer, Integer>> t;
    public float u;
    public int v;
    public int w;
    public float x;
    public boolean y;
    public View z;

    public c() {
        this.f13832a = 0;
        this.f13833b = -16777216;
        this.f13834c = -16777216;
        this.f13835d = 0.0f;
        this.f13836e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = false;
        this.i = false;
        this.j = b.f13829d;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = true;
        this.r = -16777216;
        this.s = -16777216;
        this.t = new HashMap();
        this.u = 0.0f;
        this.v = 0;
        this.w = -16777216;
        this.x = 0.0f;
        this.y = false;
        this.B = true;
        this.E = false;
        this.F = false;
        this.G = 18;
        this.H = true;
        this.I = true;
        this.f13831J = true;
        this.K = true;
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
