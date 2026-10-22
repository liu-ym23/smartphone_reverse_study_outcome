package com.bytedance.watson.assist.a;

import java.util.List;

/* JADX INFO: compiled from: IAssistStat.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {

    /* JADX INFO: compiled from: IAssistStat.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f11804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f11805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11806c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11807d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11808e;
        public float f;
        public List<List<Integer>> g;

        public a() {
        }
    }

    /* JADX INFO: compiled from: IAssistStat.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11809a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11810b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f11811c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f11812d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f11813e;
        public float f;
        public float g;
        public float h;
        public float i;
        public float j;
        public float k;
        public float l;
        public float m;
        public float n;
        public float o;

        public b() {
        }

        public String toString() {
            return "CpuTimePercent{smallCoreLow=" + this.f11809a + ", smallCoreMidLow=" + this.f11810b + ", smallCoreMidHigh=" + this.f11811c + ", smallCoreHigh=" + this.f11812d + ", smallCoreSum=" + this.f11813e + ", middleCoreLow=" + this.f + ", middleCoreMidLow=" + this.g + ", middleCoreMidHigh=" + this.h + ", middleCoreHigh=" + this.i + ", middleCoreSum=" + this.j + ", bigCoreLow=" + this.k + ", bigCoreMidLow=" + this.l + ", bigCoreMidHigh=" + this.m + ", bigCoreHigh=" + this.n + ", bigCoreSum=" + this.o + '}';
        }
    }

    com.bytedance.watson.assist.a.a a();

    boolean a(float r1);

    c b();

    int c();

    int d();

    float e();

    void f();

    b g();

    boolean h();

    a i();
}
