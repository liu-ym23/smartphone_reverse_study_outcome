package stepos.support.v7.view.menu;

import android.annotation.SuppressLint;
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
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.i0;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.aiengine.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.widget.q;
import java.util.WeakHashMap;
import stepos.support.v7.view.menu.c;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.widget.ActionMenuPresenter;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.p;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements h.a, View.OnClickListener, View.OnLongClickListener, ActionMenuView.a {

    /* renamed from: j, reason: collision with root package name */
    public e f12323j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f12324k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f12325l;

    /* renamed from: m, reason: collision with root package name */
    public c.b f12326m;

    /* renamed from: n, reason: collision with root package name */
    public b f12327n;

    /* renamed from: o, reason: collision with root package name */
    public c f12328o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f12329p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12330q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public int f12331s;

    /* renamed from: t, reason: collision with root package name */
    public final int f12332t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f12333u;

    /* renamed from: v, reason: collision with root package name */
    public final float f12334v;

    /* renamed from: w, reason: collision with root package name */
    public final int f12335w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f12336x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f12337y;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12338a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12339b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f12340c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ StepOSPressAnimationDrawable f12341d;

        public a(int i10, int i11, int i12, StepOSPressAnimationDrawable stepOSPressAnimationDrawable) {
            this.f12338a = i10;
            this.f12339b = i11;
            this.f12340c = i12;
            this.f12341d = stepOSPressAnimationDrawable;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            actionMenuItemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int height = actionMenuItemView.getHeight() - this.f12338a;
            int width = (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd();
            int i10 = this.f12339b;
            int iMax = Math.max(i10 > width ? (actionMenuItemView.getWidth() - actionMenuItemView.getPaddingStart()) - actionMenuItemView.getPaddingEnd() : i10 + this.f12340c, height);
            StepOSPressAnimationDrawable stepOSPressAnimationDrawable = this.f12341d;
            stepOSPressAnimationDrawable.f6439u = iMax;
            stepOSPressAnimationDrawable.f6440v = height;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends i0 {
        public b() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.i0
        public final l.f b() {
            ActionMenuPresenter.c cVar;
            c cVar2 = ActionMenuItemView.this.f12328o;
            if (cVar2 == null || (cVar = ActionMenuPresenter.this.E) == null) {
                return null;
            }
            return cVar.f12425l;
        }

        @Override // androidx.appcompat.widget.i0
        public final boolean c() {
            ActionMenuPresenter.c cVar;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            c.b bVar = actionMenuItemView.f12326m;
            if (bVar == null || !bVar.b(actionMenuItemView.f12323j)) {
                return false;
            }
            c cVar2 = actionMenuItemView.f12328o;
            p pVar = (cVar2 == null || (cVar = ActionMenuPresenter.this.E) == null) ? null : cVar.f12425l;
            return pVar != null && pVar.C.isShowing();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c {
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.f12335w = 255;
        com.stepos.common.animator.g gVar = new com.stepos.common.animator.g();
        Resources resources = context.getResources();
        this.f12329p = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ce.a.f3412a, 0, 0);
        this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f12332t = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f12331s = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.a.r, 0, 0);
        this.f12334v = typedArrayObtainStyledAttributes2.getFloat(6, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-65536);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        gVar.b(this, 5, false);
    }

    private void setCompoundDrawables(boolean z) {
        setCompoundDrawables(z ? null : this.f12325l, z ? this.f12325l : null, null, null);
    }

    @Override // stepos.support.v7.widget.ActionMenuView.a
    public final boolean a() {
        return h();
    }

    @Override // stepos.support.v7.widget.ActionMenuView.a
    public final boolean b() {
        return h() && this.f12323j.getIcon() == null;
    }

    @Override // stepos.support.v7.view.menu.h.a
    public final void c(e eVar) throws Resources.NotFoundException {
        this.f12323j = eVar;
        boolean z = true;
        this.f12337y = true;
        setIcon(eVar.getIcon());
        setTitle(eVar.getTitleCondensed());
        setId(eVar.f12397a);
        setVisibility(eVar.isVisible() ? 0 : 8);
        setEnabled(eVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected((eVar.A & 64) != 0);
        if (eVar.hasSubMenu() && this.f12327n == null) {
            this.f12327n = new b();
        }
        setIsOverflowActor(false);
        if (this.f12325l != null) {
            if (this.f12323j.isEnabled() || (!isPressed() && isFocused())) {
                z = false;
            }
            this.f12325l.mutate();
            Drawable drawable = this.f12325l;
            int i10 = this.f12335w;
            if (z) {
                i10 = (int) (this.f12334v * i10);
            }
            drawable.setAlpha(i10);
        }
        this.f12337y = false;
        i();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f12323j;
        if (eVar == null || this.f12325l == null || !this.f12333u) {
            return;
        }
        if (!eVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.f12325l.mutate();
        isPressed();
    }

    @Override // stepos.support.v7.view.menu.h.a
    public e getItemData() {
        return this.f12323j;
    }

    public final boolean h() {
        return !TextUtils.isEmpty(getText());
    }

    public final void i() throws Resources.NotFoundException {
        if (this.f12337y) {
            return;
        }
        boolean z = (!TextUtils.isEmpty(this.f12324k)) & (this.f12325l == null || ((this.f12323j.B & 4) == 4 && (this.f12329p || this.f12330q)));
        setText(z ? this.f12324k : null);
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.f12325l == null || !z) ? this.f12333u ? new int[]{R.attr.steposActionMenuTextAppearanceSplit} : new int[]{R.attr.actionMenuTextAppearance} : this.f12333u ? new int[]{R.attr.steposActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.steposActionMenuTextAppearanceWithIcon}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
        setCompoundDrawables(z);
        if (z && this.f12325l != null && this.f12333u) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.f12325l == null || !this.f12333u) {
            return;
        }
        Drawable drawableL = b1.L(R.drawable.action_menu_split_background_8dp, getContext());
        if (TextUtils.isEmpty(getText()) || !(drawableL instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new a(getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_vertical) * 2, (int) getPaint().measureText(getText().toString()), getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_horizontal) * 2, (StepOSPressAnimationDrawable) drawableL));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        c.b bVar = this.f12326m;
        if (bVar != null) {
            bVar.b(this.f12323j);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        this.f12329p = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        i();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.f12325l == null) {
            this.f12323j.getClass();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (h()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i10 = (height / 2) + iArr[1];
        int i11 = (width / 2) + iArr[0];
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (view.getLayoutDirection() == 0) {
            i11 = context.getResources().getDisplayMetrics().widthPixels - i11;
        }
        Toast toastMakeText = Toast.makeText(context, this.f12323j.f12401e, 0);
        if (i10 < rect.height()) {
            toastMakeText.setGravity(8388661, i11, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12;
        boolean zH = h();
        if (zH && (i12 = this.f12331s) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.r;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i13) : i13;
        if (mode != 1073741824 && i13 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (!zH && this.f12325l != null) {
            super.setPadding((getMeasuredWidth() - this.f12325l.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        this.f12323j.getClass();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        motionEvent.getAction();
        if (this.f12323j.hasSubMenu() && (bVar = this.f12327n) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z) {
        if (this.f12330q != z) {
            this.f12330q = z;
            e eVar = this.f12323j;
            if (eVar != null) {
                stepos.support.v7.view.menu.c cVar = eVar.f12409q;
                cVar.f12382m = true;
                cVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        this.f12325l = drawable;
        if (drawable != null) {
            Context context = getContext();
            ge.c cVar = new ge.c();
            Drawable drawable2 = cVar.f9146a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            cVar.f9146a = drawable;
            drawable.setCallback(cVar);
            context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.FILL);
            q qVar = new q(context);
            cVar.f9163b = qVar;
            qVar.f7178d = true;
            this.f12323j.getClass();
            this.f12323j.getClass();
            qVar.f7191s = 1;
            qVar.f7192t = String.valueOf(0);
            qVar.f7191s = 0;
            this.f12325l = cVar;
            int intrinsicWidth = cVar.f9146a.getIntrinsicWidth();
            int intrinsicHeight = cVar.f9146a.getIntrinsicHeight();
            int i10 = this.f12332t;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            if (this.f12333u) {
                cVar.setBounds(0, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin), intrinsicWidth, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin) + i10);
            } else {
                cVar.setBounds(0, 0, intrinsicWidth, i10);
            }
        }
        i();
    }

    public void setIsInSplit(boolean z) {
        this.f12333u = z;
    }

    public void setIsOverflowActor(boolean z) {
        this.f12336x = z;
    }

    public void setItemInvoker(c.b bVar) {
        this.f12326m = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i10, int i11, int i12, int i13) {
        this.f12331s = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(c cVar) {
        this.f12328o = cVar;
    }

    public void setTitle(CharSequence charSequence) throws Resources.NotFoundException {
        this.f12324k = charSequence;
        setContentDescription(charSequence);
        i();
    }

    @Override // stepos.support.v7.view.menu.h.a
    public void setTitleMaxLines(int i10) {
        setMaxLines(i10);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }
}
