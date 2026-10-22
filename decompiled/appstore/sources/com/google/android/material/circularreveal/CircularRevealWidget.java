package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = null;
        private final RevealInfo revealInfo;

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            this.revealInfo = new RevealInfo(null);
        }

        @Override // android.animation.TypeEvaluator
        @NonNull
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float r10, @NonNull RevealInfo r11, @NonNull RevealInfo r12) {
            return evaluate2(r10, r11, r12);
        }

        @NonNull
        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float r10, @NonNull RevealInfo r11, @NonNull RevealInfo r12) {
            this.revealInfo.set(MathUtils.lerp(r11.centerX, r12.centerX, r10), MathUtils.lerp(r11.centerY, r12.centerY, r10), MathUtils.lerp(r11.radius, r12.radius, r10));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = null;

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r10) {
            super(RevealInfo.class, r10);
        }

        @Override // android.util.Property
        @Nullable
        public /* bridge */ /* synthetic */ RevealInfo get(@NonNull CircularRevealWidget r10) {
            return get2(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r10, @Nullable RevealInfo r11) {
            set2(r10, r11);
        }

        @Nullable
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(@NonNull CircularRevealWidget r10) {
            return r10.getRevealInfo();
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r10, @Nullable RevealInfo r11) {
            r10.setRevealInfo(r11);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r10) {
            super(Integer.class, r10);
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Integer get(@NonNull CircularRevealWidget r10) {
            return get2(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r10, @NonNull Integer r11) {
            set2(r10, r11);
        }

        @NonNull
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(@NonNull CircularRevealWidget r10) {
            return Integer.valueOf(r10.getCircularRevealScrimColor());
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r10, @NonNull Integer r11) {
            r10.setCircularRevealScrimColor(r11.intValue());
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        public /* synthetic */ RevealInfo(AnonymousClass1 r10) {
            this();
        }

        public boolean isInvalid() {
            if (this.radius != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public void set(float r10, float r11, float r12) {
            this.centerX = r10;
            this.centerY = r11;
            this.radius = r12;
        }

        private RevealInfo() {
        }

        public RevealInfo(float r10, float r11, float r12) {
            this.centerX = r10;
            this.centerY = r11;
            this.radius = r12;
        }

        public void set(@NonNull RevealInfo r10) {
            set(r10.centerX, r10.centerY, r10.radius);
        }

        public RevealInfo(@NonNull RevealInfo r10) {
            this(r10.centerX, r10.centerY, r10.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas r10);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable r10);

    void setCircularRevealScrimColor(@ColorInt int r10);

    void setRevealInfo(@Nullable RevealInfo r10);
}
