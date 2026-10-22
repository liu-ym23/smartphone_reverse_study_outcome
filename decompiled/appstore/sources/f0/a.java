package f0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class a extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation.AnimationListener f19430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19431b;

    /* JADX INFO: renamed from: f0.a$a, reason: collision with other inner class name */
    public class C0248a extends OvalShape {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RadialGradient f19432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Paint f19433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f19434c;

        public C0248a(a r10, int r11) {
            this.f19434c = r10;
            this.f19433b = new Paint();
            r10.f19431b = r11;
            a((int) rect().width());
        }

        public final void a(int r10) {
            float r11 = r10 / 2;
            RadialGradient r12 = new RadialGradient(r11, r11, this.f19434c.f19431b, new int[]{1023410176, 0}, null, Shader.TileMode.CLAMP);
            this.f19432a = r12;
            this.f19433b.setShader(r12);
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas r10, Paint r11) {
            int r12 = this.f19434c.getWidth() / 2;
            float r13 = r12;
            float r14 = this.f19434c.getHeight() / 2;
            r10.drawCircle(r13, r14, r13, this.f19433b);
            r10.drawCircle(r13, r14, r12 - this.f19434c.f19431b, r11);
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float r10, float r11) {
            super.onResize(r10, r11);
            a((int) r10);
        }
    }

    public a(Context r10, int r11) {
        super(r10);
        float r12 = getContext().getResources().getDisplayMetrics().density;
        int r13 = (int) (1.75f * r12);
        int r14 = (int) (0.0f * r12);
        this.f19431b = (int) (3.5f * r12);
        if (a() == false) goto L5;
        ShapeDrawable r15 = new ShapeDrawable(new OvalShape());
        ViewCompat.x0(this, r12 * 4.0f);
    L6:
        r15.getPaint().setColor(r11);
        ViewCompat.t0(this, r15);
        return;
    L5:
        ShapeDrawable r16 = new ShapeDrawable(new C0248a(this, this.f19431b));
        setLayerType(1, r16.getPaint());
        r16.getPaint().setShadowLayer(this.f19431b, r14, r13, 503316480);
        int r17 = this.f19431b;
        setPadding(r17, r17, r17, r17);
        r15 = r16;
        goto L6
    }

    public final boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener r10) {
        this.f19430a = r10;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener r10 = this.f19430a;
        if (r10 == null) goto L6;
        r10.onAnimationEnd(getAnimation());
        return;
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener r10 = this.f19430a;
        if (r10 == null) goto L6;
        r10.onAnimationStart(getAnimation());
        return;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        if (a() == true) goto L6;
        setMeasuredDimension(getMeasuredWidth() + (this.f19431b * 2), getMeasuredHeight() + (this.f19431b * 2));
        return;
    }

    @Override // android.view.View
    public void setBackgroundColor(int r10) {
        if ((getBackground() instanceof ShapeDrawable) == false) goto L6;
        ((ShapeDrawable) getBackground()).getPaint().setColor(r10);
        return;
    }
}
