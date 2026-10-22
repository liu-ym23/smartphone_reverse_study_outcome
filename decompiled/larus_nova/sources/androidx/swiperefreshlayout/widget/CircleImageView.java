package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.DisplayMetrics;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes17.dex */
class CircleImageView extends ImageView {
    private static final int FILL_SHADOW_COLOR = 1023410176;
    private static final int KEY_SHADOW_COLOR = 503316480;
    private static final int SHADOW_ELEVATION = 4;
    private static final float SHADOW_RADIUS = 3.5f;
    private static final float X_OFFSET = 0.0f;
    private static final float Y_OFFSET = 1.75f;
    private Animation.AnimationListener mListener;
    int mShadowRadius;

    public class OvalShadow extends OvalShape {
        private RadialGradient mRadialGradient;
        private Paint mShadowPaint;
        final /* synthetic */ CircleImageView this$0;

        private void updateRadialGradient(int r100) {
            float r101 = r100 / 2;
            RadialGradient r102 = new RadialGradient(r101, r101, this.this$0.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, null, Shader.TileMode.CLAMP);
            this.mRadialGradient = r102;
            this.mShadowPaint.setShader(r102);
        }

        public OvalShadow(CircleImageView r100, int r101) {
            this.this$0 = r100;
            this.mShadowPaint = new Paint();
            r100.mShadowRadius = r101;
            updateRadialGradient((int) rect().width());
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas r100, Paint r101) {
            int r102 = this.this$0.getWidth() / 2;
            float r103 = r102;
            float r104 = this.this$0.getHeight() / 2;
            r100.drawCircle(r103, r104, r103, this.mShadowPaint);
            r100.drawCircle(r103, r104, r102 - this.this$0.mShadowRadius, r101);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float r100, float r101) {
            super.onResize(r100, r101);
            updateRadialGradient((int) r100);
        }
    }

    private boolean elevationSupported() {
        return true;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener r100 = this.mListener;
        if (r100 == null) goto L6;
        r100.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r100 = this.mListener;
        if (r100 == null) goto L6;
        r100.onAnimationStart(getAnimation());
        return;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_CircleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void setAnimationListener(Animation.AnimationListener r100) {
        this.mListener = r100;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r100) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        ((ShapeDrawable) getBackground()).getPaint().setColor(r100);
        return;
    }

    public void setBackgroundColorRes(int r100) {
        setBackgroundColor(ContextCompat.getColor(getContext(), r100));
    }

    public CircleImageView(Context r100, int r101) {
        super(r100);
        float r102 = INVOKEVIRTUAL_androidx_swiperefreshlayout_widget_CircleImageView_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(getContext().getResources()).density;
        int r103 = (int) (Y_OFFSET * r102);
        int r104 = (int) (0.0f * r102);
        this.mShadowRadius = (int) (SHADOW_RADIUS * r102);
        if (elevationSupported() == false) goto L5;
        ShapeDrawable r105 = new ShapeDrawable(new OvalShape());
        ViewCompat.setElevation(this, r102 * 4.0f);
    L6:
        r105.getPaint().setColor(r101);
        ViewCompat.setBackground(this, r105);
        return;
    L5:
        ShapeDrawable r106 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
        setLayerType(1, r106.getPaint());
        r106.getPaint().setShadowLayer(this.mShadowRadius, r104, r103, KEY_SHADOW_COLOR);
        int r107 = this.mShadowRadius;
        setPadding(r107, r107, r107, r107);
        r105 = r106;
        goto L6
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (elevationSupported() == true) goto L6;
        setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        return;
    }
}
