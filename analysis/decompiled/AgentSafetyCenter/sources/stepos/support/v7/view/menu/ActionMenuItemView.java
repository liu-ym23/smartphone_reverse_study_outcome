package stepos.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Toast;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.widget.i;
import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import l.b;
import m.v0;
import n3.k0;
import oe.a;
import r9.l;
import stepos.support.v7.widget.r;
import te.c;
import te.d;
import te.k;
import te.m;
import te.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class ActionMenuItemView extends v0 implements w, View.OnClickListener, View.OnLongClickListener, r {

    /* renamed from: k, reason: collision with root package name */
    public m f12526k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f12527l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f12528m;

    /* renamed from: n, reason: collision with root package name */
    public k f12529n;

    /* renamed from: o, reason: collision with root package name */
    public b f12530o;

    /* renamed from: p, reason: collision with root package name */
    public d f12531p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12532q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f12533r;

    /* renamed from: s, reason: collision with root package name */
    public final int f12534s;

    /* renamed from: t, reason: collision with root package name */
    public int f12535t;

    /* renamed from: u, reason: collision with root package name */
    public final int f12536u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12537v;

    /* renamed from: w, reason: collision with root package name */
    public final float f12538w;

    /* renamed from: x, reason: collision with root package name */
    public final int f12539x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12540y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f12541z;

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f12539x = 255;
        l lVar = new l();
        Resources resources = context.getResources();
        this.f12532q = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f9499a, i, 0);
        this.f12534s = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f12536u = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f12535t = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.f4114r, i, 0);
        this.f12538w = typedArrayObtainStyledAttributes2.getFloat(6, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        lVar.b(5, this);
    }

    private void setCompoundDrawables(boolean z10) {
        setCompoundDrawables(z10 ? null : this.f12528m, z10 ? this.f12528m : null, null, null);
    }

    @Override // stepos.support.v7.widget.r
    public final boolean a() {
        return f();
    }

    @Override // stepos.support.v7.widget.r
    public final boolean b() {
        return f() && this.f12526k.getIcon() == null;
    }

    @Override // te.w
    public final void d(m mVar) throws Resources.NotFoundException {
        this.f12526k = mVar;
        boolean z10 = true;
        this.f12541z = true;
        setIcon(mVar.getIcon());
        setTitle(mVar.getTitleCondensed());
        setId(mVar.f13363a);
        setVisibility(mVar.isVisible() ? 0 : 8);
        setEnabled(mVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected((mVar.f13385x & 64) != 0);
        if (mVar.hasSubMenu() && this.f12530o == null) {
            this.f12530o = new b(this, 3);
        }
        setIsOverflowActor(false);
        if (this.f12528m != null) {
            if (this.f12526k.isEnabled() || (!isPressed() && isFocused())) {
                z10 = false;
            }
            this.f12528m.mutate();
            Drawable drawable = this.f12528m;
            int i = this.f12539x;
            if (z10) {
                i = (int) (this.f12538w * i);
            }
            drawable.setAlpha(i);
        }
        this.f12541z = false;
        g();
    }

    @Override // m.v0, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        m mVar = this.f12526k;
        if (mVar == null || this.f12528m == null || !this.f12537v) {
            return;
        }
        if (!mVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.f12528m.mutate();
        isPressed();
    }

    public final boolean f() {
        return !TextUtils.isEmpty(getText());
    }

    public final void g() {
        if (this.f12541z) {
            return;
        }
        boolean z10 = (!TextUtils.isEmpty(this.f12527l)) & (this.f12528m == null || ((this.f12526k.f13386y & 4) == 4 && (this.f12532q || this.f12533r)));
        setText(z10 ? this.f12527l : null);
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.f12528m == null || !z10) ? this.f12537v ? new int[]{R.attr.steposActionMenuTextAppearanceSplit} : new int[]{R.attr.actionMenuTextAppearance} : this.f12537v ? new int[]{R.attr.steposActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.steposActionMenuTextAppearanceWithIcon}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
        setCompoundDrawables(z10);
        if (z10 && this.f12528m != null && this.f12537v) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.f12528m == null || !this.f12537v) {
            return;
        }
        Drawable drawableV = id.k.v(R.drawable.action_menu_split_background_8dp, getContext());
        if (TextUtils.isEmpty(getText()) || !(drawableV instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        int iMeasureText = (int) getPaint().measureText(getText().toString());
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_vertical) * 2;
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_horizontal) * 2;
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        c cVar = new c();
        cVar.i = this;
        cVar.f13330c = dimensionPixelOffset;
        cVar.f13331f = iMeasureText;
        cVar.f13332g = dimensionPixelOffset2;
        cVar.f13333h = (StepOSPressAnimationDrawable) drawableV;
        VarHandle.storeStoreFence();
        viewTreeObserver.addOnGlobalLayoutListener(cVar);
    }

    @Override // te.w
    public m getItemData() {
        return this.f12526k;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        k kVar = this.f12529n;
        if (kVar != null) {
            kVar.d(this.f12526k);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f12532q = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        g();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.f12528m == null) {
            this.f12526k.getClass();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (f()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = (height / 2) + iArr[1];
        int i3 = (width / 2) + iArr[0];
        WeakHashMap weakHashMap = k0.f8724a;
        if (view.getLayoutDirection() == 0) {
            i3 = context.getResources().getDisplayMetrics().widthPixels - i3;
        }
        Toast toastMakeText = Toast.makeText(context, this.f12526k.f13367e, 0);
        if (i < rect.height()) {
            toastMakeText.setGravity(8388661, i3, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // m.v0, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i3) {
        int i10;
        boolean zF = f();
        if (zF && (i10 = this.f12535t) >= 0) {
            super.setPadding(i10, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i3);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i11 = this.f12534s;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i11) : i11;
        if (mode != 1073741824 && i11 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i3);
        }
        if (!zF && this.f12528m != null) {
            super.setPadding((getMeasuredWidth() - this.f12528m.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        this.f12526k.getClass();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        motionEvent.getAction();
        if (this.f12526k.hasSubMenu() && (bVar = this.f12530o) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f12533r != z10) {
            this.f12533r = z10;
            m mVar = this.f12526k;
            if (mVar != null) {
                te.l lVar = mVar.f13375n;
                lVar.f13351j = true;
                lVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        this.f12528m = drawable;
        if (drawable != null) {
            Context context = getContext();
            te.b bVar = new te.b();
            Drawable drawable2 = bVar.f13328c;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            bVar.f13328c = drawable;
            drawable.setCallback(bVar);
            context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL);
            i iVar = new i(context);
            bVar.f13329f = iVar;
            iVar.f2702d = true;
            VarHandle.storeStoreFence();
            this.f12526k.getClass();
            this.f12526k.getClass();
            iVar.f2716s = 1;
            iVar.f2717t = String.valueOf(0);
            iVar.f2716s = 0;
            this.f12528m = bVar;
            int intrinsicWidth = bVar.f13328c.getIntrinsicWidth();
            int intrinsicHeight = bVar.f13328c.getIntrinsicHeight();
            int i = this.f12536u;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            if (this.f12537v) {
                bVar.setBounds(0, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin), intrinsicWidth, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin) + i);
            } else {
                bVar.setBounds(0, 0, intrinsicWidth, i);
            }
        }
        g();
    }

    public void setIsInSplit(boolean z10) {
        this.f12537v = z10;
    }

    public void setIsOverflowActor(boolean z10) {
        this.f12540y = z10;
    }

    public void setItemInvoker(k kVar) {
        this.f12529n = kVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i3, int i10, int i11) {
        this.f12535t = i;
        super.setPadding(i, i3, i10, i11);
    }

    public void setPopupCallback(d dVar) {
        this.f12531p = dVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f12527l = charSequence;
        setContentDescription(charSequence);
        g();
    }

    @Override // te.w
    public void setTitleMaxLines(int i) {
        setMaxLines(i);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }
}
