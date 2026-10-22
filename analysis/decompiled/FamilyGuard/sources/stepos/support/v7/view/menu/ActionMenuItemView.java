package stepos.support.v7.view.menu;

import X4.l;
import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.L;
import androidx.appcompat.widget.M;
import androidx.core.view.H;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import g.C0728a;
import h.C0744a;
import stepos.support.v7.view.menu.d;
import stepos.support.v7.view.menu.i;
import stepos.support.v7.widget.ActionMenuView;

/* loaded from: classes.dex */
public class ActionMenuItemView extends D implements i.a, View.OnClickListener, View.OnLongClickListener, ActionMenuView.b {

    /* renamed from: F, reason: collision with root package name */
    private static final int[] f21193F = {R.attr.state_pressed};

    /* renamed from: A, reason: collision with root package name */
    private boolean f21194A;

    /* renamed from: B, reason: collision with root package name */
    private final float f21195B;

    /* renamed from: C, reason: collision with root package name */
    private final int f21196C;

    /* renamed from: D, reason: collision with root package name */
    private final Paint f21197D;

    /* renamed from: E, reason: collision with root package name */
    private final I1.f f21198E;

    /* renamed from: h, reason: collision with root package name */
    private f f21199h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f21200i;

    /* renamed from: j, reason: collision with root package name */
    private Drawable f21201j;

    /* renamed from: k, reason: collision with root package name */
    private d.b f21202k;

    /* renamed from: l, reason: collision with root package name */
    private L f21203l;

    /* renamed from: m, reason: collision with root package name */
    private c f21204m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21205n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21206o;

    /* renamed from: p, reason: collision with root package name */
    private int f21207p;

    /* renamed from: q, reason: collision with root package name */
    private int f21208q;

    /* renamed from: r, reason: collision with root package name */
    private int f21209r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f21210s;

    /* renamed from: t, reason: collision with root package name */
    private float f21211t;

    /* renamed from: u, reason: collision with root package name */
    private float f21212u;

    /* renamed from: v, reason: collision with root package name */
    private int f21213v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f21214w;

    /* renamed from: x, reason: collision with root package name */
    private Drawable f21215x;

    /* renamed from: y, reason: collision with root package name */
    private Drawable f21216y;

    /* renamed from: z, reason: collision with root package name */
    private int f21217z;

    class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f21218a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f21219b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f21220c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f21221d;

        a(int i5, int i6, int i7, Drawable drawable) {
            this.f21218a = i5;
            this.f21219b = i6;
            this.f21220c = i7;
            this.f21221d = drawable;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ActionMenuItemView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int height = ActionMenuItemView.this.getHeight() - this.f21218a;
            ((StepOSPressAnimationDrawable) this.f21221d).p(Math.max(this.f21219b > (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() ? (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() : this.f21219b + this.f21220c, height), height);
        }
    }

    private class b extends L {
        public b() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.L
        protected boolean c() {
            M mB;
            return ActionMenuItemView.this.f21202k != null && ActionMenuItemView.this.f21202k.d(ActionMenuItemView.this.f21199h) && (mB = b()) != null && mB.h();
        }

        @Override // androidx.appcompat.widget.L
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public M b() {
            if (ActionMenuItemView.this.f21204m != null) {
                return ActionMenuItemView.this.f21204m.a();
            }
            return null;
        }
    }

    public static abstract class c {
        public abstract M a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A() {
        if (this.f21194A) {
            return;
        }
        boolean z5 = true;
        boolean z6 = !TextUtils.isEmpty(this.f21200i);
        if (this.f21201j != null && (!this.f21199h.F() || (!this.f21205n && !this.f21206o))) {
            z5 = false;
        }
        boolean z7 = z6 & z5;
        setText(z7 ? this.f21200i : null);
        z(z7);
        setCompoundDrawables(z7);
        if (z7 && this.f21201j != null && this.f21210s) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.f21201j == null || !this.f21210s) {
            return;
        }
        Drawable drawableB = C0744a.b(getContext(), X4.e.f5928b);
        if (TextUtils.isEmpty(getText()) || !(drawableB instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new a(getContext().getResources().getDimensionPixelOffset(X4.d.f5921u) * 2, y(), getContext().getResources().getDimensionPixelOffset(X4.d.f5920t) * 2, drawableB));
    }

    private void setCompoundDrawables(boolean z5) {
        setCompoundDrawables(z5 ? null : this.f21201j, z5 ? this.f21201j : null, null, null);
    }

    private int y() {
        return (int) getPaint().measureText(getText().toString());
    }

    private void z(boolean z5) {
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.f21201j == null || !z5) ? this.f21210s ? new int[]{X4.a.f5836l} : new int[]{C0728a.f16833j} : this.f21210s ? new int[]{X4.a.f5838n} : new int[]{X4.a.f5837m}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
    }

    @Override // stepos.support.v7.widget.ActionMenuView.b
    public boolean a() {
        return w();
    }

    @Override // stepos.support.v7.widget.ActionMenuView.b
    public boolean b() {
        return w() && this.f21199h.getIcon() == null;
    }

    @Override // stepos.support.v7.view.menu.i.a
    public boolean c() {
        return true;
    }

    @Override // stepos.support.v7.view.menu.i.a
    public void d(f fVar, int i5) {
        this.f21199h = fVar;
        boolean z5 = true;
        this.f21194A = true;
        setIcon(fVar.getIcon());
        setTitle(fVar.j(this));
        setId(fVar.getItemId());
        setVisibility(fVar.isVisible() ? 0 : 8);
        setEnabled(fVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected(fVar.q());
        if (fVar.hasSubMenu() && this.f21203l == null) {
            this.f21203l = new b();
        }
        setIsOverflowActor(fVar.p());
        if (this.f21201j != null) {
            if (this.f21199h.isEnabled() || (!isPressed() && isFocused())) {
                z5 = false;
            }
            this.f21201j.mutate();
            this.f21201j.setAlpha(z5 ? (int) (this.f21211t * this.f21213v) : this.f21213v);
        }
        this.f21194A = false;
        A();
        if (fVar.i() != null) {
            setTextColor(fVar.i());
        }
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f21199h;
        if (fVar == null || this.f21201j == null || !this.f21210s) {
            return;
        }
        if (!fVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.f21201j.mutate();
        isPressed();
    }

    @Override // stepos.support.v7.view.menu.i.a
    public f getItemData() {
        return this.f21199h;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d.b bVar = this.f21202k;
        if (bVar != null) {
            bVar.d(this.f21199h);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f21205n = getContext().getResources().getBoolean(X4.b.f5852b);
        A();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.f21201j == null && this.f21199h.o()) {
            Layout layout = getLayout();
            float measuredHeight = (getMeasuredHeight() / 2) - (layout.getHeight() / 2);
            float measuredWidth = (getMeasuredWidth() / 2) + (layout.getWidth() / 2);
            float f5 = this.f21195B;
            canvas.drawCircle(measuredWidth + f5, measuredHeight, f5, this.f21197D);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (w()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i5 = iArr[1] + (height / 2);
        int i6 = iArr[0] + (width / 2);
        if (H.x(view) == 0) {
            i6 = context.getResources().getDisplayMetrics().widthPixels - i6;
        }
        Toast toastMakeText = Toast.makeText(context, this.f21199h.getTitle(), 0);
        if (i5 < rect.height()) {
            toastMakeText.setGravity(8388661, i6, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        boolean zW = w();
        if (zW && (i7 = this.f21208q) >= 0) {
            super.setPadding(i7, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i5, i6);
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f21207p) : this.f21207p;
        if (mode != 1073741824 && this.f21207p > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i6);
        }
        if (!zW && this.f21201j != null) {
            super.setPadding((getMeasuredWidth() - this.f21201j.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (this.f21199h.o()) {
            Drawable drawable = this.f21201j;
            if (drawable instanceof stepos.support.v7.view.menu.a) {
                ((stepos.support.v7.view.menu.a) drawable).b();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        L l5;
        motionEvent.getAction();
        if (this.f21199h.hasSubMenu() && (l5 = this.f21203l) != null && l5.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z5) {
    }

    public void setChecked(boolean z5) {
    }

    public void setExpandedFormat(boolean z5) {
        if (this.f21206o != z5) {
            this.f21206o = z5;
            f fVar = this.f21199h;
            if (fVar != null) {
                fVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f21201j = drawable;
        if (drawable != null) {
            stepos.support.v7.view.menu.a aVar = new stepos.support.v7.view.menu.a(getContext(), drawable);
            aVar.d(this.f21199h.o());
            aVar.c(this.f21199h.e());
            this.f21201j = aVar;
            int intrinsicWidth = aVar.getIntrinsicWidth();
            int intrinsicHeight = aVar.getIntrinsicHeight();
            int i5 = this.f21209r;
            if (intrinsicWidth > i5) {
                intrinsicHeight = (int) (intrinsicHeight * (i5 / intrinsicWidth));
                intrinsicWidth = i5;
            }
            if (intrinsicHeight > i5) {
                intrinsicWidth = (int) (intrinsicWidth * (i5 / intrinsicHeight));
            } else {
                i5 = intrinsicHeight;
            }
            if (this.f21210s) {
                Resources resources = getContext().getResources();
                int i6 = X4.d.f5893b0;
                aVar.setBounds(0, resources.getDimensionPixelSize(i6), intrinsicWidth, i5 + getContext().getResources().getDimensionPixelSize(i6));
            } else {
                aVar.setBounds(0, 0, intrinsicWidth, i5);
            }
        }
        A();
    }

    public void setIsInSplit(boolean z5) {
        this.f21210s = z5;
    }

    public void setIsOverflowActor(boolean z5) {
        this.f21214w = z5;
    }

    public void setItemInvoker(d.b bVar) {
        this.f21202k = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i5, int i6, int i7, int i8) {
        this.f21208q = i5;
        super.setPadding(i5, i6, i7, i8);
    }

    public void setPopupCallback(c cVar) {
        this.f21204m = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f21200i = charSequence;
        setContentDescription(charSequence);
        A();
    }

    @Override // stepos.support.v7.view.menu.i.a
    public void setTitleMaxLines(int i5) {
        setMaxLines(i5);
    }

    public boolean w() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean x() {
        return this.f21214w;
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f21213v = 255;
        this.f21196C = -65536;
        I1.f fVar = new I1.f();
        this.f21198E = fVar;
        Resources resources = context.getResources();
        this.f21205n = resources.getBoolean(X4.b.f5852b);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f6254d, i5, 0);
        this.f21207p = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.f17204w, 0);
        this.f21212u = typedArrayObtainStyledAttributes.getFloat(l.f6280h, 1.0f);
        this.f21215x = typedArrayObtainStyledAttributes.getDrawable(l.f6268f);
        this.f21216y = typedArrayObtainStyledAttributes.getDrawable(l.f6261e);
        this.f21217z = typedArrayObtainStyledAttributes.getDimensionPixelOffset(l.f6274g, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f21209r = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f21208q = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.j.f17068T1, i5, 0);
        this.f21211t = typedArrayObtainStyledAttributes2.getFloat(g.j.f17080W1, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        this.f21195B = context.getResources().getDimension(H1.f.f2164z);
        Paint paint = new Paint();
        this.f21197D = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        fVar.f(this, false, I1.f.f2929e | I1.f.f2931g);
    }
}
