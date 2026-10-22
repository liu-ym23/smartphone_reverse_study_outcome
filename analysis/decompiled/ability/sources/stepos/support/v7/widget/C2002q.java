package stepos.support.v7.widget;

import Va.C0266d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.TouchDelegate;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.stepos.ability.R;
import java.lang.ref.WeakReference;

/* renamed from: stepos.support.v7.widget.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2002q extends AppCompatImageView implements InterfaceC2006v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2005u f6626a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2002q(C2005u c2005u, Context context) throws Resources.NotFoundException {
        super(context, null, c2005u.f6635F ? R.attr.steposActionOverflowButtonSplitStyle : androidx.appcompat.R.attr.actionOverflowButtonStyle);
        this.f6626a = c2005u;
        setId(R.id.stepos_action_overflow_button);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new C0266d(this, this));
        if (c2005u.f6635F) {
            C2001p c2001p = new C2001p();
            c2001p.g = 0;
            c2001p.f1189j = 0;
            c2001p.k = 0;
            c2001p.n = false;
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, Ra.a.f, R.attr.steposActionButtonRippleSplitStyle, 0);
            int color = typedArrayObtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
            c2001p.l = Color.alpha(color);
            c2001p.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
            c2001p.g = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            c2001p.m = typedArrayObtainStyledAttributes.getBoolean(8, false);
            c2001p.p = typedArrayObtainStyledAttributes.getBoolean(0, true);
            c2001p.f1190q = typedArrayObtainStyledAttributes.getBoolean(5, true);
            c2001p.f1189j = typedArrayObtainStyledAttributes.getInt(1, 160);
            c2001p.k = typedArrayObtainStyledAttributes.getInt(3, 320);
            c2001p.f1191r = typedArrayObtainStyledAttributes.getBoolean(6, true);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            c2001p.b = paint;
            paint.setColor(color);
            paint.setAlpha(c2001p.l);
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            c2001p.c = paint2;
            paint2.setColor(color);
            paint2.setAlpha(c2001p.l / 2);
            paint2.setAntiAlias(true);
            WeakReference weakReference = new WeakReference(this);
            c2001p.f1188a = weakReference;
            c2001p.d = c2001p.e;
            ((View) weakReference.get()).setClickable(true);
            ((View) weakReference.get()).addOnLayoutChangeListener(new Sa.a(c2001p, 0));
            ((View) weakReference.get()).post(new A6.l(c2001p, 14));
            setBackgroundDrawable(c2001p);
        }
        Drawable drawable = c2005u.f6643x;
        if (drawable != null) {
            setImageDrawable(drawable);
        }
        setContentDescription(getResources().getString(androidx.appcompat.R.string.abc_action_menu_overflow_description));
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(SupportMenu.CATEGORY_MASK);
        paint3.setStyle(Paint.Style.FILL);
    }

    @Override // stepos.support.v7.widget.InterfaceC2006v
    public final boolean needsDividerAfter() {
        return false;
    }

    @Override // stepos.support.v7.widget.InterfaceC2006v
    public final boolean needsDividerBefore() {
        return false;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        int i12 = (int) (getResources().getDisplayMetrics().density * 52.0f);
        int i13 = i10 - i;
        if (i13 < i12) {
            int i14 = (i12 - i13) / 2;
            Rect rect = new Rect(i - i14, i6, i10 + i14, i11);
            View view = (View) getParent();
            TouchDelegate touchDelegate = new TouchDelegate(rect, this);
            C2005u c2005u = this.f6626a;
            c2005u.f6636j = touchDelegate;
            view.setTouchDelegate(c2005u.f6636j);
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f6626a.m();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i6, int i10, int i11) {
        boolean frame = super.setFrame(i, i6, i10, i11);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        int paddingLeft = getPaddingLeft() - getPaddingRight();
        int paddingTop = getPaddingTop() - getPaddingBottom();
        if (drawable != null && background != null && (paddingLeft != 0 || paddingTop != 0)) {
            int width = getWidth();
            int height = getHeight();
            int i12 = width / 2;
            int i13 = height / 2;
            int i14 = (width + paddingLeft) / 2;
            int i15 = (height + paddingTop) / 2;
            DrawableCompat.setHotspotBounds(background, i14 - i12, i15 - i13, i14 + i12, i15 + i13);
        }
        return frame;
    }
}
