package com.google.android.material.transition.platform;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.g;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import s.a;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
class TransitionUtils {
    private static final String EASING_TYPE_CUBIC_BEZIER = "cubic-bezier";
    private static final String EASING_TYPE_FORMAT_END = ")";
    private static final String EASING_TYPE_FORMAT_START = "(";
    private static final String EASING_TYPE_PATH = "path";

    @AttrRes
    static final int NO_ATTR_RES_ID = 0;
    static final int NO_DURATION = -1;
    private static final int PATH_TYPE_ARC = 1;
    private static final int PATH_TYPE_LINEAR = 0;
    private static final RectF transformAlphaRectF = null;

    public interface CanvasOperation {
        void run(Canvas r10);
    }

    public interface CornerSizeBinaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize r10, @NonNull CornerSize r11);
    }

    static {
        transformAlphaRectF = new RectF();
    }

    private TransitionUtils() {
    }

    public static float calculateArea(@NonNull RectF r10) {
        return r10.width() * r10.height();
    }

    public static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel r10, final RectF r11) {
        return r10.withTransformedCornerSizes(new AnonymousClass1(r11));
    }

    public static Shader createColorShader(@ColorInt int r10) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, r10, r10, Shader.TileMode.CLAMP);
    }

    @NonNull
    public static <T> T defaultIfNull(@Nullable T r10, @NonNull T r11) {
        if (r10 == null) goto L5;
        return r10;
    L5:
        return r11;
    }

    public static View findAncestorById(View r10, @IdRes int r11) {
        String r12 = r10.getResources().getResourceName(r11);
    L3:
        if (r10 == null) goto L11;
        if (r10.getId() == r11) goto L6;
        Object r13 = r10.getParent();
        if ((r13 instanceof View) == false) goto L11;
        r10 = (View) r13;
        goto L3
    L6:
        return r10;
    L11:
        throw new IllegalArgumentException(r12 + " is not a valid ancestor");
    }

    public static View findDescendantOrAncestorById(View r10, @IdRes int r11) {
        View r12 = r10.findViewById(r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        return findAncestorById(r10, r11);
    }

    private static float getControlPoint(String[] r10, int r11) {
        float r12 = Float.parseFloat(r10[r11]);
        if (r12 < 0.0f) goto L8;
        if (r12 > 1.0f) goto L8;
        return r12;
    L8:
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + r12);
    }

    private static String getEasingContent(String r10, String r11) {
        return r10.substring(r11.length() + 1, r10.length() - 1);
    }

    public static RectF getLocationOnScreen(View r10) {
        int[] r11 = new int[2];
        r10.getLocationOnScreen(r11);
        int r12 = r11[0];
        int r13 = r11[1];
        return new RectF(r12, r13, r10.getWidth() + r12, r10.getHeight() + r13);
    }

    public static RectF getRelativeBounds(View r10) {
        return new RectF(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    public static Rect getRelativeBoundsRect(View r10) {
        return new Rect(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    private static boolean isEasingType(String r10, String r11) {
        if (r10.startsWith(r11 + EASING_TYPE_FORMAT_START) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.endsWith(EASING_TYPE_FORMAT_END) == false) goto L7;
        return true;
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel r10, RectF r11) {
        if (r10.getTopLeftCornerSize().getCornerSize(r11) == 0.0f) goto L5;
    L12:
        return true;
    L5:
        if (r10.getTopRightCornerSize().getCornerSize(r11) != 0.0f) goto L12;
        if (r10.getBottomRightCornerSize().getCornerSize(r11) != 0.0f) goto L12;
        if (r10.getBottomLeftCornerSize().getCornerSize(r11) != 0.0f) goto L12;
        return false;
    }

    public static float lerp(float r10, float r11, float r12) {
        return r10 + (r12 * (r11 - r10));
    }

    public static void maybeAddTransition(TransitionSet r10, @Nullable Transition r11) {
        if (r11 == null) goto L5;
        r10.addTransition(r11);
        return;
    }

    public static boolean maybeApplyThemeDuration(Transition r10, Context r11, @AttrRes int r12) {
        if (r12 != 0) goto L4;
        return false;
    L4:
        if (r10.getDuration() != (-1)) goto L11;
        int r13 = MaterialAttributes.resolveInteger(r11, r12, -1);
        if (r13 == (-1)) goto L12;
        r10.setDuration(r13);
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static boolean maybeApplyThemeInterpolator(Transition r10, Context r11, @AttrRes int r12, TimeInterpolator r13) {
        if (r12 != 0) goto L4;
        return false;
    L4:
        if (r10.getInterpolator() != null) goto L9;
        r10.setInterpolator(resolveThemeInterpolator(r11, r12, r13));
        return true;
    L9:
        return false;
    }

    public static boolean maybeApplyThemePath(Transition r10, Context r11, @AttrRes int r12) {
        if (r12 == 0) goto L7;
        PathMotion r13 = resolveThemePath(r11, r12);
        if (r13 == null) goto L9;
        r10.setPathMotion(r13);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    public static void maybeRemoveTransition(TransitionSet r10, @Nullable Transition r11) {
        if (r11 == null) goto L5;
        r10.removeTransition(r11);
        return;
    }

    public static TimeInterpolator resolveThemeInterpolator(Context r10, @AttrRes int r11, @NonNull TimeInterpolator r12) {
        TypedValue r13 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r13, true) == true) goto L5;
        return r12;
    L5:
        if (r13.type != 3) goto L21;
        String r14 = String.valueOf(r13.string);
        if (isEasingType(r14, EASING_TYPE_CUBIC_BEZIER) == false) goto L15;
        String[] r15 = getEasingContent(r14, EASING_TYPE_CUBIC_BEZIER).split(",");
        if (r15.length != 4) goto L13;
        return a.a(getControlPoint(r15, 0), getControlPoint(r15, 1), getControlPoint(r15, 2), getControlPoint(r15, 3));
    L13:
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + r15.length);
    L15:
        if (isEasingType(r14, EASING_TYPE_PATH) == false) goto L19;
        return a.b(g.d(getEasingContent(r14, EASING_TYPE_PATH)));
    L19:
        throw new IllegalArgumentException("Invalid motion easing type: " + r14);
    L21:
        throw new IllegalArgumentException("Motion easing theme attribute must be a string");
    }

    @Nullable
    public static PathMotion resolveThemePath(Context r10, @AttrRes int r11) {
        TypedValue r12 = new TypedValue();
        if (r10.getTheme().resolveAttribute(r11, r12, true) == false) goto L20;
        int r13 = r12.type;
        if (r13 != 16) goto L15;
        int r14 = r12.data;
        if (r14 != 0) goto L9;
        return null;
    L9:
        if (r14 != 1) goto L13;
        return new MaterialArcMotion();
    L13:
        throw new IllegalArgumentException("Invalid motion path type: " + r14);
    L15:
        if (r13 != 3) goto L19;
        return new PatternPathMotion(g.d(String.valueOf(r12.string)));
    L19:
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    L20:
        return null;
    }

    private static int saveLayerAlphaCompat(Canvas r10, Rect r11, int r12) {
        RectF r13 = transformAlphaRectF;
        r13.set(r11);
        return r10.saveLayerAlpha(r13, r12);
    }

    public static void transform(Canvas r10, Rect r11, float r12, float r13, float r14, int r15, CanvasOperation r16) {
        if (r15 > 0) goto L4;
        return;
    L4:
        int r17 = r10.save();
        r10.translate(r12, r13);
        r10.scale(r14, r14);
        if (r15 >= 255) goto L7;
        saveLayerAlphaCompat(r10, r11, r15);
    L7:
        r16.run(r10);
        r10.restoreToCount(r17);
    }

    public static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel r10, ShapeAppearanceModel r11, RectF r12, CornerSizeBinaryOperator r13) {
        if (isShapeAppearanceSignificant(r10, r12) == false) goto L5;
        ShapeAppearanceModel r14 = r10;
    L7:
        return r14.toBuilder().setTopLeftCornerSize(r13.apply(r10.getTopLeftCornerSize(), r11.getTopLeftCornerSize())).setTopRightCornerSize(r13.apply(r10.getTopRightCornerSize(), r11.getTopRightCornerSize())).setBottomLeftCornerSize(r13.apply(r10.getBottomLeftCornerSize(), r11.getBottomLeftCornerSize())).setBottomRightCornerSize(r13.apply(r10.getBottomRightCornerSize(), r11.getBottomRightCornerSize())).build();
    L5:
        r14 = r11;
        goto L7
    }

    public static float lerp(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        return lerp(r10, r11, r12, r13, r14, false);
    }

    public static float lerp(float r10, float r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d) float r14, boolean r15) {
        if (r15 == false) goto L10;
        if (r14 < 0.0f) goto L8;
        if (r14 <= 1.0f) goto L10;
    L8:
        return lerp(r10, r11, r14);
    L10:
        if (r14 >= r12) goto L13;
        return r10;
    L13:
        if (r14 <= r13) goto L16;
        return r11;
    L16:
        return lerp(r10, r11, (r14 - r12) / (r13 - r12));
    }

    public static int lerp(int r10, int r11, @FloatRange(from = 0.0d, to = 1.0d) float r12, @FloatRange(from = 0.0d, to = 1.0d) float r13, @FloatRange(from = 0.0d, to = 1.0d) float r14) {
        if (r14 >= r12) goto L6;
        return r10;
    L6:
        if (r14 <= r13) goto L9;
        return r11;
    L9:
        return (int) lerp(r10, r11, (r14 - r12) / (r13 - r12));
    }

    public static ShapeAppearanceModel lerp(ShapeAppearanceModel r10, ShapeAppearanceModel r11, final RectF r12, final RectF r13, @FloatRange(from = 0.0d, to = 1.0d) final float r14, @FloatRange(from = 0.0d, to = 1.0d) final float r15, @FloatRange(from = 0.0d, to = 1.0d) final float r16) {
        if (r16 >= r14) goto L6;
        return r10;
    L6:
        if (r16 <= r15) goto L9;
        return r11;
    L9:
        return transformCornerSizes(r10, r11, r12, new AnonymousClass2(r12, r13, r14, r15, r16));
    }
}
