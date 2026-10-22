package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

import com.bytedance.android.livesdk.interactivity.api.settings.config.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f133483e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f133484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f133486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f133487d;

    public static final class a {
        public static e a(p0 r100) {
            Intrinsics.checkNotNullParameter(r100, "localConfig");
            return new e(r100.d(), r100.e(), r100.c(), r100.b());
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (this.f133484a == r101.f133484a) goto L8;
        return false;
    L8:
        if (this.f133485b == r101.f133485b) goto L10;
        return false;
    L10:
        if (this.f133486c == r101.f133486c) goto L12;
        return false;
    L12:
        if (this.f133487d == r101.f133487d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f133484a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f133485b) * 31) + this.f133486c) * 31) + this.f133487d;
    }

    public final String toString() {
        return "PSSpeedAdaptConfig(updateInterval=" + this.f133484a + ", updateScrollSize=" + this.f133485b + ", updateFoldSize=" + this.f133486c + ", scrollSpeed=" + this.f133487d + ")";
    }

    public e(long r100, int r101, int r102, int r103) {
        this.f133484a = r100;
        this.f133485b = r101;
        this.f133486c = r102;
        this.f133487d = r103;
    }
}
