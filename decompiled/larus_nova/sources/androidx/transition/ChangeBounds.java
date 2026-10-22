package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class ChangeBounds extends Transition {
    private static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = null;
    private static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = null;
    private static final Property<View, PointF> POSITION_PROPERTY = null;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = null;
    private static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = null;
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties = null;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;

    public static class ViewBounds {
        private int mBottom;
        private int mBottomRightCalls;
        private int mLeft;
        private int mRight;
        private int mTop;
        private int mTopLeftCalls;
        private View mView;

        private void setLeftTopRightBottom() {
            ViewUtils.setLeftTopRightBottom(this.mView, this.mLeft, this.mTop, this.mRight, this.mBottom);
            this.mTopLeftCalls = 0;
            this.mBottomRightCalls = 0;
        }

        public ViewBounds(View r100) {
            this.mView = r100;
        }

        public void setBottomRight(PointF r100) {
            this.mRight = Math.round(r100.x);
            this.mBottom = Math.round(r100.y);
            int r101 = this.mBottomRightCalls + 1;
            this.mBottomRightCalls = r101;
            if (this.mTopLeftCalls != r101) goto L6;
            setLeftTopRightBottom();
            return;
        }

        public void setTopLeft(PointF r100) {
            this.mLeft = Math.round(r100.x);
            this.mTop = Math.round(r100.y);
            int r101 = this.mTopLeftCalls + 1;
            this.mTopLeftCalls = r101;
            if (r101 != this.mBottomRightCalls) goto L6;
            setLeftTopRightBottom();
            return;
        }
    }

    static {
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        final Class<PointF> r100 = PointF.class;
        final String r101 = "boundsOrigin";
        DRAWABLE_ORIGIN_PROPERTY = new AnonymousClass1(r100, r101);
        final Class<PointF> r102 = PointF.class;
        final String r103 = "topLeft";
        TOP_LEFT_PROPERTY = new AnonymousClass2(r102, r103);
        final Class<PointF> r104 = PointF.class;
        final String r105 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = new AnonymousClass3(r104, r105);
        final Class<PointF> r106 = PointF.class;
        BOTTOM_RIGHT_ONLY_PROPERTY = new AnonymousClass4(r106, r105);
        final Class<PointF> r107 = PointF.class;
        TOP_LEFT_ONLY_PROPERTY = new AnonymousClass5(r107, r103);
        final Class<PointF> r108 = PointF.class;
        final String r109 = "position";
        POSITION_PROPERTY = new AnonymousClass6(r108, r109);
        sRectEvaluator = new RectEvaluator();
    }

    public ChangeBounds() {
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    private void captureValues(TransitionValues r100) {
        View r101 = r100.view;
        if (ViewCompat.isLaidOut(r101) == false) goto L5;
    L8:
        r100.values.put(PROPNAME_BOUNDS, new Rect(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom()));
        r100.values.put(PROPNAME_PARENT, r100.view.getParent());
        if (this.mReparent == false) goto L12;
        r100.view.getLocationInWindow(this.mTempLocation);
        r100.values.put(PROPNAME_WINDOW_X, Integer.valueOf(this.mTempLocation[0]));
        r100.values.put(PROPNAME_WINDOW_Y, Integer.valueOf(this.mTempLocation[1]));
    L12:
        if (this.mResizeClip == false) goto L16;
        r100.values.put(PROPNAME_CLIP, ViewCompat.getClipBounds(r101));
        return;
    L16:
        return;
    L5:
        if (r101.getWidth() != 0) goto L8;
        if (r101.getHeight() != 0) goto L8;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues r100) {
        captureValues(r100);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues r100) {
        captureValues(r100);
    }

    public void setResizeClip(boolean r100) {
        this.mResizeClip = r100;
    }

    public ChangeBounds(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mTempLocation = new int[2];
        this.mResizeClip = false;
        this.mReparent = false;
        TypedArray r102 = r100.obtainStyledAttributes(r101, Styleable.CHANGE_BOUNDS);
        boolean r103 = TypedArrayUtils.getNamedBoolean(r102, (XmlResourceParser) r101, "resizeClip", 0, false);
        r102.recycle();
        setResizeClip(r103);
    }

    private boolean parentMatches(View r100, View r101) {
        if (this.mReparent == false) goto L11;
        TransitionValues r102 = getMatchedTransitionValues(r100, true);
        if (r102 != null) goto L10;
        if (r100 == r101) goto L14;
    L8:
        return false;
    L14:
        return true;
    L10:
        if (r101 != r102.view) goto L8;
        return true;
    L11:
        return true;
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup r110, TransitionValues r210, TransitionValues r211) {
        if (r210 == null) goto L77;
        if (r211 == null) goto L81;
        Map<String, Object> r100 = r210.values;
        Map<String, Object> r101 = r211.values;
        ViewGroup r102 = (ViewGroup) r100.get(PROPNAME_PARENT);
        ViewGroup r103 = (ViewGroup) r101.get(PROPNAME_PARENT);
        if (r102 == null) goto L75;
        if (r103 == null) goto L80;
        final View r104 = r211.view;
        if (parentMatches(r102, r103) == false) goto L67;
        Rect r105 = (Rect) r210.values.get(PROPNAME_BOUNDS);
        Rect r106 = (Rect) r211.values.get(PROPNAME_BOUNDS);
        int r107 = r105.left;
        final int r108 = r106.left;
        int r111 = r105.top;
        final int r112 = r106.top;
        int r113 = r105.right;
        final int r114 = r106.right;
        int r109 = r105.bottom;
        final int r115 = r106.bottom;
        int r116 = r113 - r107;
        int r117 = r109 - r111;
        int r118 = r114 - r108;
        int r119 = r115 - r112;
        Rect r120 = (Rect) r210.values.get(PROPNAME_CLIP);
        final Rect r121 = (Rect) r211.values.get(PROPNAME_CLIP);
        if (r116 == 0) goto L15;
        if (r117 == 0) goto L15;
    L17:
        if (r107 != r108) goto L21;
        if (r111 != r112) goto L21;
        int r122 = 0;
    L22:
        if (r113 != r114) goto L24;
        if (r109 != r115) goto L24;
    L26:
        if (r120 != null) goto L28;
    L29:
        if (r120 != null) goto L32;
        if (r121 == null) goto L32;
    L31:
        r122 = r122 + 1;
    L32:
        if (r122 > 0) goto L34;
        return null;
    L34:
        if (this.mResizeClip == true) goto L46;
        final View r123 = r104;
        ViewUtils.setLeftTopRightBottom(r123, r107, r111, r113, r109);
        if (r122 != 2) goto L41;
        if (r116 != r118) goto L40;
        if (r117 != r119) goto L40;
        Animator r124 = ObjectAnimatorUtils.ofPointF(r123, POSITION_PROPERTY, getPathMotion().getPath(r107, r111, r108, r112));
    L64:
        if ((r123.getParent() instanceof ViewGroup) == false) goto L66;
        final ViewGroup r125 = (ViewGroup) r123.getParent();
        ViewGroupUtils.suppressLayout(r125, true);
        addListener(new AnonymousClass9(this, r125));
    L66:
        return r124;
    L40:
        final ViewBounds r126 = new ViewBounds(r123);
        ObjectAnimator r127 = ObjectAnimatorUtils.ofPointF(r126, TOP_LEFT_PROPERTY, getPathMotion().getPath(r107, r111, r108, r112));
        ObjectAnimator r128 = ObjectAnimatorUtils.ofPointF(r126, BOTTOM_RIGHT_PROPERTY, getPathMotion().getPath(r113, r109, r114, r115));
        AnimatorSet r129 = new AnimatorSet();
        r129.playTogether(new Animator[]{r127, r128});
        r129.addListener(new AnonymousClass7(this, r126));
        r124 = r129;
        goto L64
    L41:
        if (r107 != r108) goto L45;
        if (r111 != r112) goto L45;
        r124 = ObjectAnimatorUtils.ofPointF(r123, BOTTOM_RIGHT_ONLY_PROPERTY, getPathMotion().getPath(r113, r109, r114, r115));
    L45:
        r124 = ObjectAnimatorUtils.ofPointF(r123, TOP_LEFT_ONLY_PROPERTY, getPathMotion().getPath(r107, r111, r108, r112));
        goto L64
    L46:
        r123 = r104;
        ViewUtils.setLeftTopRightBottom(r123, r107, r111, Math.max(r116, r118) + r107, Math.max(r117, r119) + r111);
        if (r107 != r108) goto L51;
        if (r111 != r112) goto L51;
        ObjectAnimator r130 = null;
    L52:
        if (r120 != null) goto L54;
        int r131 = 0;
        Rect r132 = new Rect(0, 0, r116, r117);
    L55:
        if (r121 != null) goto L57;
        Rect r133 = new Rect(r131, r131, r118, r119);
    L59:
        if (r132.equals(r133) == true) goto L61;
        ViewCompat.setClipBounds(r123, r132);
        RectEvaluator r134 = sRectEvaluator;
        Object[] r135 = new Object[2];
        r135[r131] = r132;
        r135[1] = r133;
        ObjectAnimator r136 = ObjectAnimator.ofObject(r123, "clipBounds", r134, r135);
        r136.addListener(new AnonymousClass8(this, r123, r121, r108, r112, r114, r115));
        ObjectAnimator r137 = r136;
    L62:
        r124 = TransitionUtils.mergeAnimators(r130, r137);
        goto L64
    L61:
        r137 = null;
        goto L62
    L57:
        r133 = r121;
        goto L59
    L54:
        r131 = 0;
        r132 = r120;
    L51:
        r130 = ObjectAnimatorUtils.ofPointF(r123, POSITION_PROPERTY, getPathMotion().getPath(r107, r111, r108, r112));
        goto L52
    L28:
        if (r120.equals(r121) == false) goto L31;
    L24:
        r122 = r122 + 1;
    L21:
        r122 = 1;
    L15:
        if (r118 == 0) goto L25;
        if (r119 != 0) goto L17;
    L25:
        r122 = 0;
        goto L26
    L67:
        int r138 = ((Integer) r210.values.get(PROPNAME_WINDOW_X)).intValue();
        int r139 = ((Integer) r210.values.get(PROPNAME_WINDOW_Y)).intValue();
        int r140 = ((Integer) r211.values.get(PROPNAME_WINDOW_X)).intValue();
        int r141 = ((Integer) r211.values.get(PROPNAME_WINDOW_Y)).intValue();
        if (r138 != r140) goto L73;
        if (r139 != r141) goto L73;
        return null;
    L73:
        r110.getLocationInWindow(this.mTempLocation);
        Bitmap r142 = Bitmap.createBitmap(r104.getWidth(), r104.getHeight(), Bitmap.Config.ARGB_8888);
        r104.draw(new Canvas(r142));
        final BitmapDrawable r143 = new BitmapDrawable(r142);
        final float r144 = ViewUtils.getTransitionAlpha(r104);
        ViewUtils.setTransitionAlpha(r104, 0.0f);
        ViewUtils.getOverlay(r110).add(r143);
        PathMotion r145 = getPathMotion();
        int[] r146 = this.mTempLocation;
        int r147 = r146[0];
        int r148 = r146[1];
        ObjectAnimator r149 = ObjectAnimator.ofPropertyValuesHolder(r143, new PropertyValuesHolder[]{PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, r145.getPath(r138 - r147, r139 - r148, r140 - r147, r141 - r148))});
        r149.addListener(new AnonymousClass10(this, r110, r143, r104, r144));
        return r149;
    L80:
        return null;
    L75:
        return null;
    L81:
        return null;
    L77:
        return null;
    }
}
