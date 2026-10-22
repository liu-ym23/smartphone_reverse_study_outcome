package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.g0;
import androidx.appcompat.widget.t;
import com.google.common.primitives.Ints;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Drawable f447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MenuBuilder.ItemInvoker f448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f454j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f455k;

    public class a extends t {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ActionMenuItemView f456j;

        public a(ActionMenuItemView r10) {
            this.f456j = r10;
            super(r10);
        }

        @Override // androidx.appcompat.widget.t
        public ShowableListMenu b() {
            b r10 = this.f456j.f450f;
            if (r10 != null) goto L5;
            return null;
        L5:
            return r10.a();
        }

        @Override // androidx.appcompat.widget.t
        public boolean c() {
            ActionMenuItemView r10 = this.f456j;
            MenuBuilder.ItemInvoker r11 = r10.f448d;
            if (r11 != null) goto L5;
            return false;
        L5:
            if (r11.invokeItem(r10.f445a) == false) goto L13;
            ShowableListMenu r12 = b();
            if (r12 != null) goto L9;
            return false;
        L9:
            if (r12.isShowing() == false) goto L15;
            return true;
        L15:
            return false;
        L13:
            return false;
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract ShowableListMenu a();
    }

    public ActionMenuItemView(Context r10) {
        this(r10, null);
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean c() {
        Configuration r10 = getContext().getResources().getConfiguration();
        int r11 = r10.screenWidthDp;
        int r12 = r10.screenHeightDp;
        if (r11 < 480) goto L5;
    L11:
        return true;
    L5:
        if (r11 < 640) goto L8;
        if (r12 >= 480) goto L11;
    L8:
        if (r10.orientation == 2) goto L11;
        return false;
    }

    public final void d() {
        boolean r10 = true;
        boolean r11 = !TextUtils.isEmpty(this.f446b);
        if (this.f447c != null) goto L5;
    L12:
        boolean r12 = r11 & r10;
        CharSequence r13 = null;
        if (r12 == false) goto L15;
        CharSequence r14 = this.f446b;
    L16:
        setText(r14);
        CharSequence r15 = this.f445a.getContentDescription();
        if (TextUtils.isEmpty(r15) == false) goto L22;
        if (r12 == false) goto L20;
        CharSequence r16 = null;
    L21:
        setContentDescription(r16);
    L23:
        CharSequence r17 = this.f445a.getTooltipText();
        if (TextUtils.isEmpty(r17) == false) goto L29;
        if (r12 == true) goto L28;
        r13 = this.f445a.getTitle();
    L28:
        g0.a(this, r13);
        return;
    L29:
        g0.a(this, r17);
        return;
    L20:
        r16 = this.f445a.getTitle();
        goto L21
    L22:
        setContentDescription(r15);
        goto L23
    L15:
        r14 = null;
        goto L16
    L5:
        if (this.f445a.y() == true) goto L7;
    L11:
        r10 = false;
        goto L12
    L7:
        if (this.f451g == true) goto L12;
        if (this.f452h == false) goto L11;
        goto L11
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public g getItemData() {
        return this.f445a;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(g r10, int r11) {
        this.f445a = r10;
        setIcon(r10.getIcon());
        setTitle(r10.g(this));
        setId(r10.getItemId());
        if (r10.isVisible() == false) goto L5;
        int r12 = 0;
    L6:
        setVisibility(r12);
        setEnabled(r10.isEnabled());
        if (r10.hasSubMenu() == true) goto L9;
        return;
    L9:
        if (this.f449e != null) goto L13;
        this.f449e = new a(this);
        return;
    L13:
        return;
    L5:
        r12 = 8;
        goto L6
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return b();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f445a.getIcon() != null) goto L7;
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        MenuBuilder.ItemInvoker r11 = this.f448d;
        if (r11 == null) goto L6;
        r11.invokeItem(this.f445a);
        return;
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        this.f451g = c();
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        boolean r12 = b();
        if (r12 == false) goto L7;
        int r13 = this.f454j;
        if (r13 < 0) goto L7;
        super.setPadding(r13, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    L7:
        super.onMeasure(r10, r11);
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getSize(r10);
        int r16 = getMeasuredWidth();
        if (r14 != Integer.MIN_VALUE) goto L10;
        int r17 = Math.min(r15, this.f453i);
    L12:
        if (r14 != 1073741824) goto L14;
    L17:
        if (r12 == false) goto L19;
        return;
    L19:
        if (this.f447c == null) goto L23;
        super.setPadding((getMeasuredWidth() - this.f447c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        return;
    L23:
        return;
    L14:
        if (this.f453i <= 0) goto L17;
        if (r16 >= r17) goto L17;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r17, Ints.MAX_POWER_OF_TWO), r11);
        goto L17
    L10:
        r17 = this.f453i;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        if (this.f445a.hasSubMenu() == false) goto L11;
        t r11 = this.f449e;
        if (r11 == null) goto L11;
        if (r11.onTouch(this, r10) == false) goto L11;
        return true;
    L11:
        return super.onTouchEvent(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
    }

    public void setExpandedFormat(boolean r10) {
        if (this.f452h == r10) goto L8;
        this.f452h = r10;
        g r11 = this.f445a;
        if (r11 == null) goto L9;
        r11.a();
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r10) {
        this.f447c = r10;
        if (r10 == null) goto L11;
        int r11 = r10.getIntrinsicWidth();
        int r12 = r10.getIntrinsicHeight();
        int r13 = this.f455k;
        if (r11 <= r13) goto L7;
        r12 = (int) (r12 * (r13 / r11));
        r11 = r13;
    L7:
        if (r12 <= r13) goto L9;
        r11 = (int) (r11 * (r13 / r12));
    L10:
        r10.setBounds(0, 0, r11, r13);
        goto L11
    L9:
        r13 = r12;
    L11:
        setCompoundDrawables(r10, null, null, null);
        d();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker r10) {
        this.f448d = r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int r10, int r11, int r12, int r13) {
        this.f454j = r10;
        super.setPadding(r10, r11, r12, r13);
    }

    public void setPopupCallback(b r10) {
        this.f450f = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r10) {
        this.f446b = r10;
        d();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public ActionMenuItemView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public ActionMenuItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        Resources r13 = r10.getResources();
        this.f451g = c();
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.ActionMenuItemView, r12, 0);
        this.f453i = r14.getDimensionPixelSize(R$styleable.ActionMenuItemView_android_minWidth, 0);
        r14.recycle();
        this.f455k = (int) ((r13.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f454j = -1;
        setSaveEnabled(false);
    }
}
