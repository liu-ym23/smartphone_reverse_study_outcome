package stepos.support.v7.widget;

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
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class o extends m.x implements r {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q f12781h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, Context context) throws Resources.NotFoundException {
        super(context, null, qVar.J ? R.attr.steposActionOverflowButtonSplitStyle : R.attr.actionOverflowButtonStyle);
        this.f12781h = qVar;
        setId(R.id.stepos_action_overflow_button);
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        setOnTouchListener(new l.b(this, this, 2));
        if (qVar.J) {
            n nVar = new n();
            nVar.f10053g = 0;
            nVar.f10055j = 0;
            nVar.f10056k = 0;
            nVar.f10059n = false;
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, oe.a.f9504f, R.attr.steposActionButtonRippleSplitStyle, 0);
            int color = typedArrayObtainStyledAttributes.getColor(4, -16777216);
            nVar.f10057l = Color.alpha(color);
            nVar.f10051e = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
            nVar.f10053g = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
            nVar.f10058m = typedArrayObtainStyledAttributes.getBoolean(8, false);
            nVar.f10061p = typedArrayObtainStyledAttributes.getBoolean(0, true);
            nVar.f10062q = typedArrayObtainStyledAttributes.getBoolean(5, true);
            nVar.f10055j = typedArrayObtainStyledAttributes.getInt(1, 160);
            nVar.f10056k = typedArrayObtainStyledAttributes.getInt(3, 320);
            nVar.f10063r = typedArrayObtainStyledAttributes.getBoolean(6, true);
            typedArrayObtainStyledAttributes.recycle();
            Paint paint = new Paint();
            nVar.f10048b = paint;
            paint.setColor(color);
            paint.setAlpha(nVar.f10057l);
            paint.setAntiAlias(true);
            Paint paint2 = new Paint();
            nVar.f10049c = paint2;
            paint2.setColor(color);
            paint2.setAlpha(nVar.f10057l / 2);
            paint2.setAntiAlias(true);
            WeakReference weakReference = new WeakReference(this);
            nVar.f10047a = weakReference;
            nVar.f10050d = nVar.f10051e;
            ((View) weakReference.get()).setClickable(true);
            View view = (View) weakReference.get();
            pe.a aVar = new pe.a();
            aVar.f10042b = nVar;
            VarHandle.storeStoreFence();
            view.addOnLayoutChangeListener(aVar);
            View view2 = (View) weakReference.get();
            androidx.fragment.app.r rVar = new androidx.fragment.app.r(9);
            rVar.f1301f = nVar;
            VarHandle.storeStoreFence();
            view2.post(rVar);
            setBackgroundDrawable(nVar);
        }
        Drawable drawable = qVar.B;
        if (drawable != null) {
            setImageDrawable(drawable);
        }
        setContentDescription(getResources().getString(R.string.abc_action_menu_overflow_description));
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setColor(-65536);
        paint3.setStyle(Paint.Style.FILL);
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
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        super.onLayout(z10, i, i3, i10, i11);
        int i12 = (int) (getResources().getDisplayMetrics().density * 52.0f);
        int i13 = i10 - i;
        if (i13 < i12) {
            int i14 = (i12 - i13) / 2;
            Rect rect = new Rect(i - i14, i3, i10 + i14, i11);
            View view = (View) getParent();
            TouchDelegate touchDelegate = new TouchDelegate(rect, this);
            this.f12781h.f12809n = touchDelegate;
            view.setTouchDelegate(touchDelegate);
        }
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f12781h.o();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i, int i3, int i10, int i11) {
        boolean frame = super.setFrame(i, i3, i10, i11);
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
            background.setHotspotBounds(i14 - i12, i15 - i13, i14 + i12, i15 + i13);
        }
        return frame;
    }
}
