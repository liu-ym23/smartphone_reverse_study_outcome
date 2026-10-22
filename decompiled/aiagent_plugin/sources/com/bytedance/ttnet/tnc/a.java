package com.bytedance.ttnet.tnc;

import com.google.protobuf.DescriptorProtos;
import java.util.Map;

/* JADX INFO: compiled from: TNCConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f11500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Integer> f11502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11504e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public String l;
    public int m;
    public long n;

    public a() {
        this.f11500a = false;
        this.f11501b = true;
        this.f11502c = null;
        this.f11503d = 10;
        this.f11504e = 3;
        this.f = 3;
        this.g = 10;
        this.h = 3;
        this.i = 3;
        this.j = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
        this.k = 120;
        this.l = null;
        this.m = 0;
        this.n = 0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(" localEnable: ").append(this.f11500a);
        r0.append(" probeEnable: ").append(this.f11501b);
        StringBuilder r1 = r0.append(" hostFilter: ");
        Map<String, Integer> r2 = this.f11502c;
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r0.append(" reqTo: ").append(this.f11503d).append("#").append(this.f11504e).append("#").append(this.f);
        r0.append(" reqErr: ").append(this.g).append("#").append(this.h).append("#").append(this.i);
        r0.append(" updateInterval: ").append(this.j);
        r0.append(" updateRandom: ").append(this.k);
        r0.append(" httpBlack: ").append(this.l);
        return r0.toString();
    L5:
        r3 = 0;
        goto L6
    }
}
