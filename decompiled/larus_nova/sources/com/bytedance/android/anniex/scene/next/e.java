package com.bytedance.android.anniex.scene.next;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, a> f41268a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f41272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41275g;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f41269a == r101.f41269a) goto L12;
            return false;
        L12:
            if (this.f41270b == r101.f41270b) goto L15;
            return false;
        L15:
            if (this.f41271c == r101.f41271c) goto L18;
            return false;
        L18:
            if (this.f41272d == r101.f41272d) goto L21;
            return false;
        L21:
            if (this.f41273e == r101.f41273e) goto L24;
            return false;
        L24:
            if (this.f41274f == r101.f41274f) goto L27;
            return false;
        L27:
            if (this.f41275g == r101.f41275g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f41269a * 31) + this.f41270b) * 31) + this.f41271c) * 31) + this.f41272d) * 31) + this.f41273e) * 31) + this.f41274f) * 31) + this.f41275g;
        }

        public final String toString() {
            return "RepeatStrategyStats(totalRepeatSceneShow=" + this.f41269a + ", totalRepeatCount=" + this.f41270b + ", totalPredictions=" + this.f41271c + ", totalRepeatPredictions=" + this.f41272d + ", predictHits=" + this.f41273e + ", predictRepeatHits=" + this.f41274f + ", predictUnRepeatHits=" + this.f41275g + ')';
        }

        public a(int r100) {
            this.f41269a = 0;
            this.f41270b = 0;
            this.f41271c = 0;
            this.f41272d = 0;
            this.f41273e = 0;
            this.f41274f = 0;
            this.f41275g = 0;
        }
    }

    public e() {
        this.f41268a = new ConcurrentHashMap();
    }
}
