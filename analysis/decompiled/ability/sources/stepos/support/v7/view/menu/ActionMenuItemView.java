package stepos.support.v7.view.menu;

import Ra.a;
import Va.AbstractC0267e;
import Va.C;
import Va.C0264b;
import Va.C0266d;
import Va.ViewTreeObserverOnGlobalLayoutListenerC0265c;
import Va.m;
import Va.n;
import Va.q;
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
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.stepos.ability.R;
import com.stepos.common.animator.StepOSPressAnimationDrawable;
import com.stepos.common.widget.x;
import stepos.support.v7.widget.InterfaceC2006v;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes4.dex */
public class ActionMenuItemView extends AppCompatTextView implements C, View.OnClickListener, View.OnLongClickListener, InterfaceC2006v {

    /* renamed from: a, reason: collision with root package name */
    public q f6375a;
    public CharSequence b;
    public Drawable c;
    public m d;
    public C0266d e;
    public AbstractC0267e f;
    public boolean g;
    public boolean h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public int f6376j;
    public final int k;
    public boolean l;
    public final float m;
    public final int n;
    public boolean o;
    public boolean p;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, 0);
        this.n = 255;
        com.stepos.common.animator.m mVar = new com.stepos.common.animator.m();
        Resources resources = context.getResources();
        this.g = resources.getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f1162a, 0, 0);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.getFloat(4, 1.0f);
        typedArrayObtainStyledAttributes.getDrawable(2);
        typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.k = (int) ((resources.getDisplayMetrics().density * 24.0f) + 0.5f);
        setOnClickListener(this);
        this.f6376j = -1;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.MenuView, 0, 0);
        this.m = typedArrayObtainStyledAttributes2.getFloat(androidx.appcompat.R.styleable.MenuView_android_itemIconDisabledAlpha, 1.0f);
        typedArrayObtainStyledAttributes2.recycle();
        context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setStyle(Paint.Style.FILL);
        setIncludeFontPadding(false);
        mVar.b(this, 5, false);
    }

    private void setCompoundDrawables(boolean z10) {
        setCompoundDrawables(z10 ? null : this.c, z10 ? this.c : null, null, null);
    }

    @Override // Va.C
    public final void a(q qVar) throws Resources.NotFoundException {
        this.f6375a = qVar;
        boolean z10 = true;
        this.p = true;
        setIcon(qVar.getIcon());
        setTitle(qVar.getTitleCondensed());
        setId(qVar.f1453a);
        setVisibility(qVar.isVisible() ? 0 : 8);
        setEnabled(qVar.isEnabled());
        setEllipsize(TextUtils.TruncateAt.MIDDLE);
        setSelected((qVar.f1461x & 64) != 0);
        if (qVar.hasSubMenu() && this.e == null) {
            this.e = new C0266d(this);
        }
        setIsOverflowActor(false);
        if (this.c != null) {
            if (this.f6375a.isEnabled() || (!isPressed() && isFocused())) {
                z10 = false;
            }
            this.c.mutate();
            Drawable drawable = this.c;
            int i = this.n;
            if (z10) {
                i = (int) (this.m * i);
            }
            drawable.setAlpha(i);
        }
        this.p = false;
        updateTextButtonVisibility();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        q qVar = this.f6375a;
        if (qVar == null || this.c == null || !this.l) {
            return;
        }
        if (!qVar.isEnabled() && !isPressed()) {
            isFocused();
        }
        this.c.mutate();
        isPressed();
    }

    @Override // Va.C
    public q getItemData() {
        return this.f6375a;
    }

    public final boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // stepos.support.v7.widget.InterfaceC2006v
    public final boolean needsDividerAfter() {
        return hasText();
    }

    @Override // stepos.support.v7.widget.InterfaceC2006v
    public final boolean needsDividerBefore() {
        return hasText() && this.f6375a.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        m mVar = this.d;
        if (mVar != null) {
            mVar.b(this.f6375a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g = getContext().getResources().getBoolean(R.bool.abc_config_allowActionMenuItemTextWithIcon);
        updateTextButtonVisibility();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (getRight() - getLeft() == 0 && getMeasuredWidth() > 0) {
            getParent().requestLayout();
            return;
        }
        if (!TextUtils.isEmpty(getText()) && this.c == null) {
            this.f6375a.getClass();
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        if (hasText()) {
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
        int i6 = (width / 2) + iArr[0];
        if (ViewCompat.getLayoutDirection(view) == 0) {
            i6 = context.getResources().getDisplayMetrics().widthPixels - i6;
        }
        Toast toastMakeText = Toast.makeText(context, this.f6375a.e, 0);
        if (i < rect.height()) {
            toastMakeText.setGravity(8388661, i6, (iArr[1] + height) - rect.top);
        } else {
            toastMakeText.setGravity(81, 0, height);
        }
        toastMakeText.show();
        return true;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i6) {
        int i10;
        boolean zHasText = hasText();
        if (zHasText && (i10 = this.f6376j) >= 0) {
            super.setPadding(i10, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i6);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i11 = this.i;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i11) : i11;
        if (mode != 1073741824 && i11 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY), i6);
        }
        if (!zHasText && this.c != null) {
            super.setPadding((getMeasuredWidth() - this.c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        this.f6375a.getClass();
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C0266d c0266d;
        motionEvent.getAction();
        if (this.f6375a.hasSubMenu() && (c0266d = this.e) != null && c0266d.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }

    public void setExpandedFormat(boolean z10) {
        if (this.h != z10) {
            this.h = z10;
            q qVar = this.f6375a;
            if (qVar != null) {
                n nVar = qVar.n;
                nVar.f1443j = true;
                nVar.o(true);
            }
        }
    }

    public void setIcon(Drawable drawable) throws Resources.NotFoundException {
        this.c = drawable;
        if (drawable != null) {
            Context context = getContext();
            C0264b c0264b = new C0264b();
            Drawable drawable2 = c0264b.f1435a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            c0264b.f1435a = drawable;
            drawable.setCallback(c0264b);
            context.getResources().getDimension(R.dimen.mc_new_message_view_radius);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setStyle(Paint.Style.FILL);
            x xVar = new x(context);
            c0264b.b = xVar;
            xVar.d = true;
            this.f6375a.getClass();
            this.f6375a.getClass();
            x xVar2 = c0264b.b;
            xVar2.f3820s = 1;
            xVar2.f3821t = String.valueOf(0);
            xVar2.f3820s = 0;
            this.c = c0264b;
            int intrinsicWidth = c0264b.f1435a.getIntrinsicWidth();
            int intrinsicHeight = c0264b.f1435a.getIntrinsicHeight();
            int i = this.k;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            if (this.l) {
                c0264b.setBounds(0, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin), intrinsicWidth, getContext().getResources().getDimensionPixelSize(R.dimen.stepos_split_action_bar_default_margin) + i);
            } else {
                c0264b.setBounds(0, 0, intrinsicWidth, i);
            }
        }
        updateTextButtonVisibility();
    }

    public void setIsInSplit(boolean z10) {
        this.l = z10;
    }

    public void setIsOverflowActor(boolean z10) {
        this.o = z10;
    }

    public void setItemInvoker(m mVar) {
        this.d = mVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i6, int i10, int i11) {
        this.f6376j = i;
        super.setPadding(i, i6, i10, i11);
    }

    public void setPopupCallback(AbstractC0267e abstractC0267e) {
        this.f = abstractC0267e;
    }

    public void setTitle(CharSequence charSequence) {
        this.b = charSequence;
        setContentDescription(charSequence);
        updateTextButtonVisibility();
    }

    @Override // Va.C
    public void setTitleMaxLines(int i) {
        setMaxLines(i);
    }

    public final void updateTextButtonVisibility() {
        if (this.p) {
            return;
        }
        boolean z10 = (!TextUtils.isEmpty(this.b)) & (this.c == null || ((this.f6375a.y & 4) == 4 && (this.g || this.h)));
        setText(z10 ? this.b : null);
        int resourceId = getContext().getTheme().obtainStyledAttributes((this.c == null || !z10) ? this.l ? new int[]{R.attr.steposActionMenuTextAppearanceSplit} : new int[]{androidx.appcompat.R.attr.actionMenuTextAppearance} : this.l ? new int[]{R.attr.steposActionMenuTextAppearanceWithIconSplit} : new int[]{R.attr.steposActionMenuTextAppearanceWithIcon}).getResourceId(0, -1);
        if (resourceId > 0) {
            setTextAppearance(getContext(), resourceId);
        }
        setCompoundDrawables(z10);
        if (z10 && this.c != null && this.l) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        setGravity(17);
        if (this.c == null || !this.l) {
            return;
        }
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.action_menu_split_background_8dp);
        if (TextUtils.isEmpty(getText()) || !(drawable instanceof StepOSPressAnimationDrawable)) {
            return;
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0265c(this, getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_vertical) * 2, (int) getPaint().measureText(getText().toString()), getContext().getResources().getDimensionPixelOffset(R.dimen.stepos_action_menu_bottom_drawable_padding_horizontal) * 2, (StepOSPressAnimationDrawable) drawable));
    }
}
