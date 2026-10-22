package com.bytedance.android.ecom.arch.slice.render.context;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.JvmStatic;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f50237e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f50238f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f50239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f50240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f50241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f50242d;

    public static final class a {
        public a() {
        }

        public static DisplayMetrics a(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        @JvmStatic
        public static b c(boolean r100) {
            float r101 = a(Resources.getSystem()).density;
            float r102 = a(Resources.getSystem()).scaledDensity;
            if (r100 == true) goto L7;
            r102 = r101;
        L7:
            return new b(r101, r101, r102, 1.0f);
        }

        @JvmStatic
        public static b d(float r100, float r101, float r102) {
            return b(r100, r101, r102, RangesKt.coerceAtMost(a(Resources.getSystem()).widthPixels, a(Resources.getSystem()).heightPixels));
        }

        @JvmStatic
        public static b b(float r100, float r101, float r102, int r103) {
            float r104 = 0;
            if (r100 > r104) goto L5;
            float r105 = a(Resources.getSystem()).density;
        L9:
            if (r101 <= r104) goto L11;
            float r106 = r101 * r105;
        L13:
            if (r102 <= r104) goto L15;
            float r107 = r105 * r102;
        L17:
            return new b(r105, r106, r107, r102);
        L15:
            r102 = 1.0f;
            r107 = r105;
            goto L17
        L11:
            r106 = r105;
            goto L13
        L5:
            if (r103 > 0) goto L7;
            r103 = RangesKt.coerceAtMost(a(Resources.getSystem()).widthPixels, a(Resources.getSystem()).heightPixels);
        L7:
            r105 = r103 / r100;
            goto L9
        }
    }

    public /* synthetic */ b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Float.compare(this.f50239a, r101.f50239a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f50240b, r101.f50240b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f50241c, r101.f50241c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f50242d, r101.f50242d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f50239a) * 31) + Float.floatToIntBits(this.f50240b)) * 31) + Float.floatToIntBits(this.f50241c)) * 31) + Float.floatToIntBits(this.f50242d);
    }

    public final String toString() {
        return "SlcDisplayMetrics(density=" + this.f50239a + ", viewScaledDensity=" + this.f50240b + ", fontScaledDensity=" + this.f50241c + ", fontScale=" + this.f50242d + ")";
    }

    static {
        f50238f = new a();
        f50237e = a.c(true);
    }

    public b(float r100, float r101, float r102, float r103) {
        this.f50239a = r100;
        this.f50240b = r101;
        this.f50241c = r102;
        this.f50242d = r103;
    }

    public static b a(b r100, float r101, float r102, float r103, float r104, int r105) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f50239a;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.f50240b;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.f50241c;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.f50242d;
    L15:
        return new b(r101, r102, r103, r104);
    }
}
