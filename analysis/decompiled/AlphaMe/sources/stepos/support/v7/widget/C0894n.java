package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.C0211l;
import com.stepos.alphame.R;

/* renamed from: stepos.support.v7.widget.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0894n extends androidx.appcompat.widget.G implements r {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f15101a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15102b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15103c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0897q f15104d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0894n(C0897q c0897q, Context context) {
        super(context, null, c0897q.f15115F ? R.attr.steposActionOverflowButtonSplitStyle : R.attr.actionOverflowButtonStyle);
        this.f15104d = c0897q;
        setId(R.id.stepos_action_overflow_button);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new C0211l(2, this, this, c0897q));
        if (c0897q.f15115F) {
            setBackgroundDrawable(new C0893m(this));
        }
        Drawable drawable = c0897q.f15139x;
        if (drawable != null) {
            setImageDrawable(drawable);
        }
        setContentDescription(getResources().getString(R.string.abc_action_menu_overflow_description));
        this.f15102b = context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        this.f15101a = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override // stepos.support.v7.widget.r
    public final boolean a() {
        return false;
    }

    @Override // stepos.support.v7.widget.r
    public final boolean b() {
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f15103c) {
            try {
                Matrix matrix = (Matrix) m2.i.a(this).a().f13572a.get(this);
                canvas.save();
                canvas.translate(getPaddingLeft(), getPaddingTop());
                if (matrix != null) {
                    canvas.concat(matrix);
                }
                float f4 = getDrawable().getBounds().right;
                float f5 = this.f15102b;
                canvas.drawCircle(f4 + f5, r0.top + f5, f5, this.f15101a);
                canvas.restore();
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        int i8 = (int) (getResources().getDisplayMetrics().density * 52.0f);
        int i9 = i6 - i4;
        if (i9 < i8) {
            int i10 = (i8 - i9) / 2;
            Rect rect = new Rect(i4 - i10, i5, i6 + i10, i7);
            View view = (View) getParent();
            TouchDelegate touchDelegate = new TouchDelegate(rect, this);
            C0897q c0897q = this.f15104d;
            c0897q.f15125j = touchDelegate;
            view.setTouchDelegate(c0897q.f15125j);
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f15104d.o();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i4, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i4, i5, i6, i7);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        int paddingLeft = getPaddingLeft() - getPaddingRight();
        int paddingTop = getPaddingTop() - getPaddingBottom();
        if (drawable != null && background != null && (paddingLeft != 0 || paddingTop != 0)) {
            int width = getWidth();
            int height = getHeight();
            int i8 = width / 2;
            int i9 = height / 2;
            int i10 = (width + paddingLeft) / 2;
            int i11 = (height + paddingTop) / 2;
            E.a.f(background, i10 - i8, i11 - i9, i10 + i8, i11 + i9);
        }
        return frame;
    }
}
