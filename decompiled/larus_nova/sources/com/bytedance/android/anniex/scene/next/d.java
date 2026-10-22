package com.bytedance.android.anniex.scene.next;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentMap<String, a> f41258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f41259b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f41262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f41263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f41264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f41265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f41266g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f41267h;

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
            if (this.f41260a == r101.f41260a) goto L12;
            return false;
        L12:
            if (this.f41261b == r101.f41261b) goto L15;
            return false;
        L15:
            if (this.f41262c == r101.f41262c) goto L18;
            return false;
        L18:
            if (this.f41263d == r101.f41263d) goto L21;
            return false;
        L21:
            if (this.f41264e == r101.f41264e) goto L24;
            return false;
        L24:
            if (this.f41265f == r101.f41265f) goto L27;
            return false;
        L27:
            if (this.f41266g == r101.f41266g) goto L30;
            return false;
        L30:
            if (this.f41267h == r101.f41267h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((this.f41260a * 31) + this.f41261b) * 31) + this.f41262c) * 31) + this.f41263d) * 31) + this.f41264e) * 31) + this.f41265f) * 31) + this.f41266g) * 31) + this.f41267h;
        }

        public final String toString() {
            return "StrategyStats(totalPredictions=" + this.f41260a + ", noPredictResult=" + this.f41261b + ", notHits=" + this.f41262c + ", top1Hits=" + this.f41263d + ", topNHits=" + this.f41264e + ", delayHits=" + this.f41265f + ", preCreateTimelyHits=" + this.f41266g + ", preCreateLateHits=" + this.f41267h + ')';
        }

        public a(int r100) {
            this.f41260a = 0;
            this.f41261b = 0;
            this.f41262c = 0;
            this.f41263d = 0;
            this.f41264e = 0;
            this.f41265f = 0;
            this.f41266g = 0;
            this.f41267h = 0;
        }
    }

    public d() {
        this.f41258a = new ConcurrentHashMap();
    }

    public boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "firstValue");
        Intrinsics.checkNotNullParameter(r101, "predictValue");
        return Intrinsics.areEqual(r100, r101);
    }

    public boolean b(List<String> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "firstValue");
        Intrinsics.checkNotNullParameter(r101, "predictValue");
        return r100.contains(r101);
    }
}
