package com.bytedance.android.shopping.deepfeed.weights.common;

import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedLinearGradientDrawable extends ShapeDrawable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f174165d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f174166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f174167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Orientation f174168c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/DeepFeedLinearGradientDrawable$Orientation;", "", "LEFT_TO_RIGHT", "TOP_TO_BOTTOM", "RIGHT_TO_LEFT", "BOTTOM_TO_TOP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Orientation extends Enum<Orientation> {
        public static final Orientation BOTTOM_TO_TOP = null;
        public static final Orientation LEFT_TO_RIGHT = null;
        public static final Orientation RIGHT_TO_LEFT = null;
        public static final Orientation TOP_TO_BOTTOM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Orientation[] f174169a = null;

        static {
            Orientation r100 = new Orientation("LEFT_TO_RIGHT", 0);
            LEFT_TO_RIGHT = r100;
            Orientation r101 = new Orientation("TOP_TO_BOTTOM", 1);
            TOP_TO_BOTTOM = r101;
            Orientation r102 = new Orientation("RIGHT_TO_LEFT", 2);
            RIGHT_TO_LEFT = r102;
            Orientation r103 = new Orientation("BOTTOM_TO_TOP", 3);
            BOTTOM_TO_TOP = r103;
            f174169a = new Orientation[]{r100, r101, r102, r103};
        }

        public static Orientation valueOf(String r100) {
            return (Orientation) r27.a.a(Orientation.class, r100);
        }

        public static Orientation[] values() {
            return (Orientation[]) f174169a.clone();
        }

        public Orientation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static DeepFeedLinearGradientDrawable a(float r100) {
            int[] r101 = {ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT), ColorProtector.parseColor("#FFE6F3"), ColorProtector.parseColor("#FFF1F4"), ColorProtector.parseColor("#FFF5C4")};
            float[] r102 = {0.0f, 0.15f, 0.65f, 1.0f};
            if (r100 <= 0) goto L6;
            return new DeepFeedLinearGradientDrawable(r101, r102, r100);
        L6:
            return new DeepFeedLinearGradientDrawable(r101, r102);
        }
    }

    public static final class b<A, B, C, D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A f174170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final B f174171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C f174172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final D f174173d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f174170a, r101.f174170a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f174171b, r101.f174171b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f174172c, r101.f174172c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f174173d, r101.f174173d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            A r100 = this.f174170a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            B r104 = this.f174171b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            C r107 = this.f174172c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            D r110 = this.f174173d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Quad(first=" + this.f174170a + ", second=" + this.f174171b + ", third=" + this.f174172c + ", fourth=" + this.f174173d + ")";
        }

        public b(A r100, B r101, C r102, D r103) {
            this.f174170a = r100;
            this.f174171b = r101;
            this.f174172c = r102;
            this.f174173d = r103;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r110) {
        Intrinsics.checkNotNullParameter(r110, "bounds");
        super.onBoundsChange(r110);
        float r100 = r110.width();
        float r111 = r110.height();
        int r101 = com.bytedance.android.shopping.deepfeed.weights.common.a.f174221a[this.f174168c.ordinal()];
        if (r101 != 1) goto L5;
        b r112 = new b(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(r100), Float.valueOf(0.0f));
    L16:
        b r102 = r112;
    L17:
        getPaint().setShader(new LinearGradient(((Number) r102.f174170a).floatValue(), ((Number) r102.f174171b).floatValue(), ((Number) r102.f174172c).floatValue(), ((Number) r102.f174173d).floatValue(), this.f174166a, this.f174167b, Shader.TileMode.CLAMP));
        return;
    L5:
        if (r101 != 2) goto L7;
        r102 = new b(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(r111));
        goto L17
    L7:
        if (r101 != 3) goto L9;
        r112 = new b(Float.valueOf(r100), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L16
    L9:
        if (r101 != 4) goto L12;
        r102 = new b(Float.valueOf(0.0f), Float.valueOf(r111), Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public DeepFeedLinearGradientDrawable(int[] r100, float[] r101) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        Intrinsics.checkNotNullParameter(r101, "positions");
        super(new RectShape());
        this.f174168c = Orientation.LEFT_TO_RIGHT;
        if (r100.length != r101.length) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        this.f174166a = r100;
        this.f174167b = r101;
        getPaint().setAntiAlias(true);
        getPaint().setStyle(Paint.Style.FILL);
        return;
    L10:
        throw new IllegalArgumentException("颜色数组和位置数组长度必须一致".toString());
    L5:
        r102 = false;
        goto L6
    }

    public DeepFeedLinearGradientDrawable(int[] r100, float[] r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "colors");
        Intrinsics.checkNotNullParameter(r101, "positions");
        boolean r103 = false;
        super(new RoundRectShape(new float[]{r102, r102, r102, r102, r102, r102, r102, r102}, null, null));
        this.f174168c = Orientation.LEFT_TO_RIGHT;
        if (r100.length != r101.length) goto L5;
        r103 = true;
    L5:
        if (r103 == false) goto L9;
        this.f174166a = r100;
        this.f174167b = r101;
        getPaint().setAntiAlias(true);
        getPaint().setStyle(Paint.Style.FILL);
        return;
    L9:
        throw new IllegalArgumentException("颜色数组和位置数组长度必须一致".toString());
    }
}
