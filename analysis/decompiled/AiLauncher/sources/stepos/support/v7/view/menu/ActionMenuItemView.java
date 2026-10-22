package stepos.support.v7.view.menu;

import android.R;
import android.annotation.SuppressLint;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.E;
import androidx.appcompat.widget.F;
import androidx.core.view.N;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import f.C4027a;
import stepos.support.v7.appcompat.R$attr;
import stepos.support.v7.appcompat.R$bool;
import stepos.support.v7.appcompat.R$dimen;
import stepos.support.v7.appcompat.R$drawable;
import stepos.support.v7.appcompat.R$styleable;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionMenuView;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes5.dex */
public class ActionMenuItemView extends AppCompatTextView implements h.a, View.OnClickListener, View.OnLongClickListener, ActionMenuView.b {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f40857y = {R.attr.state_pressed};

    /* renamed from: a, reason: collision with root package name */
    public e f40858a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f40859b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f40860c;

    /* renamed from: d, reason: collision with root package name */
    public c.b f40861d;

    /* renamed from: e, reason: collision with root package name */
    public E f40862e;

    /* renamed from: f, reason: collision with root package name */
    public c f40863f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40864g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40865h;

    /* renamed from: i, reason: collision with root package name */
    public int f40866i;

    /* renamed from: j, reason: collision with root package name */
    public int f40867j;

    /* renamed from: k, reason: collision with root package name */
    public int f40868k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f40869l;

    /* renamed from: m, reason: collision with root package name */
    public float f40870m;

    /* renamed from: n, reason: collision with root package name */
    public float f40871n;

    /* renamed from: o, reason: collision with root package name */
    public int f40872o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f40873p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f40874q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f40875r;

    /* renamed from: s, reason: collision with root package name */
    public int f40876s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f40877t;

    /* renamed from: u, reason: collision with root package name */
    public final float f40878u;

    /* renamed from: v, reason: collision with root package name */
    public final int f40879v;

    /* renamed from: w, reason: collision with root package name */
    public final Paint f40880w;

    /* renamed from: x, reason: collision with root package name */
    public final com.stepos.common.animator.f f40881x;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40882a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f40883b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f40884c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Drawable f40885d;

        public a(int i10, int i11, int i12, Drawable drawable) {
            this.f40882a = i10;
            this.f40883b = i11;
            this.f40884c = i12;
            this.f40885d = drawable;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ActionMenuItemView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int height = ActionMenuItemView.this.getHeight() - this.f40882a;
            ((StepOSPressAnimationDrawable) this.f40885d).p(Math.max(this.f40883b > (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() ? (ActionMenuItemView.this.getWidth() - ActionMenuItemView.this.getPaddingStart()) - ActionMenuItemView.this.getPaddingEnd() : this.f40883b + this.f40884c, height), height);
        }
    }

    public class b extends E {
        public b() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.E
        public boolean c() {
            F fB;
            return ActionMenuItemView.this.f40861d != null && ActionMenuItemView.this.f40861d.b(ActionMenuItemView.this.f40858a) && (fB = b()) != null && fB.isShowing();
        }

        @Override // androidx.appcompat.widget.E
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public F b() {
            if (ActionMenuItemView.this.f40863f != null) {
                return ActionMenuItemView.this.f40863f.a();
            }
            return null;
        }
    }

    public static abstract class c {
        public abstract F a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setCompoundDrawables(boolean z10) {
        setCompoundDrawables(z10 ? null : this.f40860c, z10 ? this.f40860c : null, null, null);
    }

    @Override // stepos.support.v7.widget.ActionMenuView.b
    public boolean a() {
        return i();
    }

    @Override // stepos.support.v7.widget.ActionMenuView.b
    public boolean b() {
        return i() && this.f40858a.getIcon() == null;
    }

    @Override // stepos.support.v7.view.menu.h.a
    public boolean c() {
        return true;
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void d(e eVar, int i10) {
        this.f40858a = eVar;
        boolean z10 = true;
        this.f40877t = true;
        setIcon(eVar.getIcon());
        setTitle(eVar.j(this));
        setId(eVar.getItemId());
        setVisibility(eVar.isVisible() ? 0 : 8);
        setEnabled(eVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected(eVar.q());
        if (eVar.hasSubMenu() && this.f40862e == null) {
            this.f40862e = new b();
        }
        setIsOverflowActor(eVar.p());
        if (this.f40860c != null) {
            if (this.f40858a.isEnabled() || (!isPressed() && isFocused())) {
                z10 = false;
            }
            this.f40860c.mutate();
            this.f40860c.setAlpha(z10 ? (int) (this.f40870m * this.f40872o) : this.f40872o);
        }
        this.f40877t = false;
        m();
        if (eVar.i() != null) {
            setTextColor(eVar.i());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f40858a;
        if (eVar == null || this.f40860c == null || !this.f40869l) {
            return;
        }
        if (!eVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.f40860c.mutate();
        isPressed();
    }

    @Override // stepos.support.v7.view.menu.h.a
    public e getItemData() {
        return this.f40858a;
    }

    public boolean i() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean j() {
        return this.f40873p;
    }

    public final int k() {
        return (int) getPaint().measureText(getText().toString());
    }

    public final void l(boolean z10) {
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.f40860c == null || !z10) ? this.f40869l ? new int[]{R$attr.steposActionMenuTextAppearanceSplit} : new int[]{androidx.appcompat.R$attr.actionMenuTextAppearance} : this.f40869l ? new int[]{R$attr.steposActionMenuTextAppearanceWithIconSplit} : new int[]{R$attr.steposActionMenuTextAppearanceWithIcon}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
    }

    public final void m() {
        if (this.f40877t) {
            return;
        }
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f40859b);
        if (this.f40860c != null && (!this.f40858a.F() || (!this.f40864g && !this.f40865h))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f40859b : null);
        l(z12);
        setCompoundDrawables(z12);
        if (z12 && this.f40860c != null && this.f40869l) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.f40860c == null || !this.f40869l) {
            return;
        }
        Drawable drawableB = C4027a.b(getContext(), R$drawable.action_menu_split_background_8dp);
        if (TextUtils.isEmpty(getText()) || !(drawableB instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new a(getContext().getResources().getDimensionPixelOffset(R$dimen.stepos_action_menu_bottom_drawable_padding_vertical) * 2, k(), getContext().getResources().getDimensionPixelOffset(R$dimen.stepos_action_menu_bottom_drawable_padding_horizontal) * 2, drawableB));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        c.b bVar = this.f40861d;
        if (bVar != null) {
            bVar.b(this.f40858a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f40864g = getContext().getResources().getBoolean(R$bool.abc_config_allowActionMenuItemTextWithIcon);
        m();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.f40860c == null && this.f40858a.o()) {
            Layout layout = getLayout();
            float measuredHeight = (getMeasuredHeight() / 2) - (layout.getHeight() / 2);
            float measuredWidth = (getMeasuredWidth() / 2) + (layout.getWidth() / 2);
            float f10 = this.f40878u;
            canvas.drawCircle(measuredWidth + f10, measuredHeight, f10, this.f40880w);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (i()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i10 = iArr[1] + (height / 2);
        int i11 = iArr[0] + (width / 2);
        if (N.u(view) == 0) {
            i11 = context.getResources().getDisplayMetrics().widthPixels - i11;
        }
        Toast toastMakeText = Toast.makeText(context, this.f40858a.getTitle(), 0);
        if (i10 < rect.height()) {
            toastMakeText.setGravity(8388661, i11, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean zI = i();
        if (zI && (i12 = this.f40867j) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f40866i) : this.f40866i;
        if (mode != 1073741824 && this.f40866i > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (!zI && this.f40860c != null) {
            super.setPadding((getMeasuredWidth() - this.f40860c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        if (this.f40858a.o()) {
            Drawable drawable = this.f40860c;
            if (drawable instanceof Jc.c) {
                ((Jc.c) drawable).b();
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        E e10;
        motionEvent.getAction();
        if (this.f40858a.hasSubMenu() && (e10 = this.f40862e) != null && e10.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f40865h != z10) {
            this.f40865h = z10;
            e eVar = this.f40858a;
            if (eVar != null) {
                eVar.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f40860c = drawable;
        if (drawable != null) {
            Jc.c cVar = new Jc.c(getContext(), drawable);
            cVar.d(this.f40858a.o());
            cVar.c(this.f40858a.e());
            this.f40860c = cVar;
            int intrinsicWidth = cVar.getIntrinsicWidth();
            int intrinsicHeight = cVar.getIntrinsicHeight();
            int i10 = this.f40868k;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            if (this.f40869l) {
                Resources resources = getContext().getResources();
                int i11 = R$dimen.stepos_split_action_bar_default_margin;
                cVar.setBounds(0, resources.getDimensionPixelSize(i11), intrinsicWidth, i10 + getContext().getResources().getDimensionPixelSize(i11));
            } else {
                cVar.setBounds(0, 0, intrinsicWidth, i10);
            }
        }
        m();
    }

    public void setIsInSplit(boolean z10) {
        this.f40869l = z10;
    }

    public void setIsOverflowActor(boolean z10) {
        this.f40873p = z10;
    }

    public void setItemInvoker(c.b bVar) {
        this.f40861d = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.f40867j = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(c cVar) {
        this.f40863f = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f40859b = charSequence;
        setContentDescription(charSequence);
        m();
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void setTitleMaxLines(int i10) {
        setMaxLines(i10);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f40872o = 255;
        this.f40879v = -65536;
        com.stepos.common.animator.f fVar = new com.stepos.common.animator.f();
        this.f40881x = fVar;
        Resources resources = context.getResources();
        this.f40864g = resources.getBoolean(R$bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionMenuItemView, i10, 0);
        this.f40866i = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.ActionMenuItemView_android_minWidth, 0);
        this.f40871n = typedArrayObtainStyledAttributes.getFloat(R$styleable.ActionMenuItemView_steposItemIconPressedAlpha, 1.0f);
        this.f40874q = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionMenuItemView_steposItemBackgroundSplit);
        this.f40875r = typedArrayObtainStyledAttributes.getDrawable(R$styleable.ActionMenuItemView_steposItemBackgroundOnlyText);
        this.f40876s = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionMenuItemView_steposItemDrawablePadding, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f40868k = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f40867j = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R$styleable.MenuView, i10, 0);
        this.f40870m = typedArrayObtainStyledAttributes2.getFloat(androidx.appcompat.R$styleable.MenuView_android_itemIconDisabledAlpha, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        this.f40878u = context.getResources().getDimension(com.stepos.common.R$dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        this.f40880w = paint;
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        fVar.f(this, false, com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_SCALE | com.stepos.common.animator.f.CUSTOM_PRESS_EFFECT_ALPHA);
    }
}
