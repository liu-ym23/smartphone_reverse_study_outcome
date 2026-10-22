package stepos.support.v7.view.menu;

import I3.a;
import K.S;
import L3.b;
import L3.c;
import L3.d;
import L3.j;
import L3.k;
import L3.l;
import L3.x;
import Z2.I;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.C0200f0;
import com.stepos.alphame.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.animator.m;
import g.AbstractC0560a;
import java.util.WeakHashMap;
import k.C0648b;
import stepos.support.v7.widget.r;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes2.dex */
public class ActionMenuItemView extends C0200f0 implements x, View.OnClickListener, View.OnLongClickListener, r {

    /* renamed from: g, reason: collision with root package name */
    public l f14662g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f14663h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f14664i;

    /* renamed from: j, reason: collision with root package name */
    public j f14665j;

    /* renamed from: k, reason: collision with root package name */
    public C0648b f14666k;

    /* renamed from: l, reason: collision with root package name */
    public d f14667l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14668m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14669n;

    /* renamed from: o, reason: collision with root package name */
    public final int f14670o;

    /* renamed from: p, reason: collision with root package name */
    public int f14671p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14672q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f14673r;

    /* renamed from: s, reason: collision with root package name */
    public final float f14674s;

    /* renamed from: t, reason: collision with root package name */
    public final int f14675t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14676u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f14677v;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.f14675t = 255;
        m mVar = new m();
        Resources resources = context.getResources();
        this.f14668m = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f841a, 0, 0);
        this.f14670o = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f14672q = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f14671p = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0560a.f12605r, 0, 0);
        this.f14674s = typedArrayObtainStyledAttributes2.getFloat(6, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        mVar.b(this, 5, false);
    }

    private void setCompoundDrawables(boolean z4) {
        setCompoundDrawables(z4 ? null : this.f14664i, z4 ? this.f14664i : null, null, null);
    }

    @Override // stepos.support.v7.widget.r
    public final boolean a() {
        return s();
    }

    @Override // stepos.support.v7.widget.r
    public final boolean b() {
        return s() && this.f14662g.getIcon() == null;
    }

    @Override // L3.x
    public final void d(l lVar) {
        this.f14662g = lVar;
        int i4 = 1;
        this.f14677v = true;
        setIcon(lVar.getIcon());
        setTitle(lVar.getTitleCondensed());
        setId(lVar.f1305a);
        setVisibility(lVar.isVisible() ? 0 : 8);
        setEnabled(lVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected((lVar.f1328x & 64) != 0);
        if (lVar.hasSubMenu() && this.f14666k == null) {
            this.f14666k = new C0648b(this, i4);
        }
        setIsOverflowActor(false);
        if (this.f14664i != null) {
            if (this.f14662g.isEnabled() || (!isPressed() && isFocused())) {
                i4 = 0;
            }
            this.f14664i.mutate();
            Drawable drawable = this.f14664i;
            int i5 = this.f14675t;
            if (i4 != 0) {
                i5 = (int) (this.f14674s * i5);
            }
            drawable.setAlpha(i5);
        }
        this.f14677v = false;
        t();
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        l lVar = this.f14662g;
        if (lVar == null || this.f14664i == null || !this.f14673r) {
            return;
        }
        if (!lVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.f14664i.mutate();
        if (isPressed()) {
            boolean z4 = this.f14664i instanceof DrawableContainer;
        }
    }

    @Override // L3.x
    public l getItemData() {
        return this.f14662g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.f14665j;
        if (jVar != null) {
            jVar.d(this.f14662g);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14668m = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        t();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.f14664i == null) {
            this.f14662g.getClass();
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView, android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (s()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i4 = (height / 2) + iArr[1];
        int i5 = (width / 2) + iArr[0];
        WeakHashMap weakHashMap = S.f939a;
        if (view.getLayoutDirection() == 0) {
            i5 = context.getResources().getDisplayMetrics().widthPixels - i5;
        }
        Toast toastMakeText = Toast.makeText(context, this.f14662g.f1309e, 0);
        if (i4 < rect.height()) {
            toastMakeText.setGravity(8388661, i5, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // androidx.appcompat.widget.C0200f0, android.widget.TextView, android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6;
        boolean zS = s();
        if (zS && (i6 = this.f14671p) >= 0) {
            super.setPadding(i6, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i4, i5);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int measuredWidth = getMeasuredWidth();
        int i7 = this.f14670o;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i7) : i7;
        if (mode != 1073741824 && i7 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i5);
        }
        if (!zS && this.f14664i != null) {
            super.setPadding((getMeasuredWidth() - this.f14664i.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        this.f14662g.getClass();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0648b c0648b;
        motionEvent.getAction();
        if (this.f14662g.hasSubMenu() && (c0648b = this.f14666k) != null && c0648b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean s() {
        return !TextUtils.isEmpty(getText());
    }

    public void setCheckable(boolean z4) {
    }

    public void setChecked(boolean z4) {
    }

    public void setExpandedFormat(boolean z4) {
        if (this.f14669n != z4) {
            this.f14669n = z4;
            l lVar = this.f14662g;
            if (lVar != null) {
                k kVar = lVar.f1318n;
                kVar.f1290j = true;
                kVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f14664i = drawable;
        if (drawable != null) {
            b bVar = new b(getContext(), drawable);
            this.f14662g.getClass();
            bVar.f1264b = false;
            this.f14662g.getClass();
            bVar.f1265c = 0;
            com.stepos.common.widget.r rVar = bVar.f1266d;
            rVar.f11962s = 1;
            rVar.f11963t = String.valueOf(0);
            rVar.f11962s = 0;
            this.f14664i = bVar;
            int intrinsicWidth = bVar.f1263a.getIntrinsicWidth();
            int intrinsicHeight = bVar.f1263a.getIntrinsicHeight();
            int i4 = this.f14672q;
            if (intrinsicWidth > i4) {
                intrinsicHeight = (int) (intrinsicHeight * (i4 / intrinsicWidth));
                intrinsicWidth = i4;
            }
            if (intrinsicHeight > i4) {
                intrinsicWidth = (int) (intrinsicWidth * (i4 / intrinsicHeight));
            } else {
                i4 = intrinsicHeight;
            }
            if (this.f14673r) {
                bVar.setBounds(0, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin), intrinsicWidth, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin) + i4);
            } else {
                bVar.setBounds(0, 0, intrinsicWidth, i4);
            }
        }
        t();
    }

    public void setIsInSplit(boolean z4) {
        this.f14673r = z4;
    }

    public void setIsOverflowActor(boolean z4) {
        this.f14676u = z4;
    }

    public void setItemInvoker(j jVar) {
        this.f14665j = jVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i4, int i5, int i6, int i7) {
        this.f14671p = i4;
        super.setPadding(i4, i5, i6, i7);
    }

    public void setPopupCallback(d dVar) {
        this.f14667l = dVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f14663h = charSequence;
        setContentDescription(charSequence);
        t();
    }

    @Override // L3.x
    public void setTitleMaxLines(int i4) {
        setMaxLines(i4);
    }

    public final void t() {
        if (this.f14677v) {
            return;
        }
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f14663h);
        if (this.f14664i != null && ((this.f14662g.f1329y & 4) != 4 || (!this.f14668m && !this.f14669n))) {
            z4 = false;
        }
        boolean z6 = z5 & z4;
        setText(z6 ? this.f14663h : null);
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.f14664i == null || !z6) ? this.f14673r ? new int[]{R.attr.steposActionMenuTextAppearanceSplit} : new int[]{R.attr.actionMenuTextAppearance} : this.f14673r ? new int[]{R.attr.steposActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.steposActionMenuTextAppearanceWithIcon}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
        setCompoundDrawables(z6);
        if (z6 && this.f14664i != null && this.f14673r) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.f14664i == null || !this.f14673r) {
            return;
        }
        Drawable drawableO = I.o(getContext(), R.drawable.action_menu_split_background_8dp);
        if (TextUtils.isEmpty(getText()) || !(drawableO instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new c(this, getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_vertical) * 2, (int) getPaint().measureText(getText().toString()), getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_horizontal) * 2, drawableO));
    }
}
