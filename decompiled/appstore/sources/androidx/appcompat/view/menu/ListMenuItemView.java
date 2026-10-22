package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.b0;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioButton f497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CheckBox f499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Drawable f508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f509o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LayoutInflater f510p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f511q;

    public ListMenuItemView(Context r10, AttributeSet r11) {
        this(r10, r11, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f510p != null) goto L6;
        this.f510p = LayoutInflater.from(getContext());
    L6:
        return this.f510p;
    }

    private void setSubMenuArrowVisible(boolean r10) {
        ImageView r11 = this.f501g;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public final void a(View r10) {
        b(r10, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r10) {
        ImageView r11 = this.f502h;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r12 = (LinearLayout.LayoutParams) this.f502h.getLayoutParams();
        r10.top += (this.f502h.getHeight() + r12.topMargin) + r12.bottomMargin;
        return;
    }

    public final void b(View r10, int r11) {
        LinearLayout r12 = this.f503i;
        if (r12 == null) goto L5;
        r12.addView(r10, r11);
        return;
    L5:
        addView(r10, r11);
    }

    public final void c() {
        CheckBox r10 = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, this, false);
        this.f499e = r10;
        a(r10);
    }

    public final void d() {
        ImageView r10 = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, this, false);
        this.f496b = r10;
        b(r10, 0);
    }

    public final void e() {
        RadioButton r10 = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, this, false);
        this.f497c = r10;
        a(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public g getItemData() {
        return this.f495a;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(g r10, int r11) {
        this.f495a = r10;
        if (r10.isVisible() == false) goto L5;
        int r12 = 0;
    L6:
        setVisibility(r12);
        setTitle(r10.g(this));
        setCheckable(r10.isCheckable());
        setShortcut(r10.x(), r10.e());
        setIcon(r10.getIcon());
        setEnabled(r10.isEnabled());
        setSubMenuArrowVisible(r10.hasSubMenu());
        setContentDescription(r10.getContentDescription());
        return;
    L5:
        r12 = 8;
        goto L6
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.t0(this, this.f504j);
        TextView r10 = (TextView) findViewById(R$id.title);
        this.f498d = r10;
        int r11 = this.f505k;
        if (r11 == (-1)) goto L5;
        r10.setTextAppearance(this.f506l, r11);
    L5:
        this.f500f = (TextView) findViewById(R$id.shortcut);
        ImageView r12 = (ImageView) findViewById(R$id.submenuarrow);
        this.f501g = r12;
        if (r12 == null) goto L8;
        r12.setImageDrawable(this.f508n);
    L8:
        this.f502h = (ImageView) findViewById(R$id.group_divider);
        this.f503i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.f496b != null) goto L5;
    L11:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (this.f507m == false) goto L11;
        ViewGroup.LayoutParams r12 = getLayoutParams();
        LinearLayout.LayoutParams r13 = (LinearLayout.LayoutParams) this.f496b.getLayoutParams();
        int r14 = r12.height;
        if (r14 <= 0) goto L11;
        if (r13.width > 0) goto L11;
        r13.width = r14;
        goto L11
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r10) {
        if (r10 == true) goto L9;
        if (this.f497c != null) goto L9;
        if (this.f499e != null) goto L9;
        return;
    L9:
        if (this.f495a.k() == false) goto L15;
        if (this.f497c != null) goto L13;
        e();
    L13:
        CompoundButton r11 = this.f497c;
        CompoundButton r12 = this.f499e;
    L19:
        if (r10 == false) goto L27;
        r11.setChecked(this.f495a.isChecked());
        if (r11.getVisibility() == 0) goto L23;
        r11.setVisibility(0);
    L23:
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.getVisibility() == 8) goto L35;
        r12.setVisibility(8);
        return;
    L35:
        return;
    L27:
        CheckBox r13 = this.f499e;
        if (r13 == null) goto L30;
        r13.setVisibility(8);
    L30:
        RadioButton r14 = this.f497c;
        if (r14 == null) goto L37;
        r14.setVisibility(8);
        return;
    L37:
        return;
    L15:
        if (this.f499e != null) goto L17;
        c();
    L17:
        r11 = this.f499e;
        r12 = this.f497c;
        goto L19
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r10) {
        if (this.f495a.k() == false) goto L9;
        if (this.f497c != null) goto L7;
        e();
    L7:
        CompoundButton r11 = this.f497c;
    L12:
        r11.setChecked(r10);
        return;
    L9:
        if (this.f499e != null) goto L11;
        c();
    L11:
        r11 = this.f499e;
        goto L12
    }

    public void setForceShowIcon(boolean r10) {
        this.f511q = r10;
        this.f507m = r10;
    }

    public void setGroupDividerEnabled(boolean r10) {
        ImageView r11 = this.f502h;
        if (r11 != null) goto L5;
        return;
    L5:
        if (this.f509o == true) goto L8;
        if (r10 == false) goto L8;
        int r12 = 0;
    L9:
        r11.setVisibility(r12);
        return;
    L8:
        r12 = 8;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r10) {
        if (this.f495a.w() == false) goto L5;
    L8:
        boolean r11 = true;
    L9:
        if (r11 == false) goto L11;
    L13:
        ImageView r12 = this.f496b;
        if (r12 != null) goto L19;
        if (r10 != null) goto L19;
        if (this.f507m == true) goto L19;
        return;
    L19:
        if (r12 != null) goto L21;
        d();
    L21:
        if (r10 == null) goto L23;
    L26:
        ImageView r13 = this.f496b;
        if (r11 == true) goto L30;
        r10 = null;
    L30:
        r13.setImageDrawable(r10);
        if (this.f496b.getVisibility() == 0) goto L35;
        this.f496b.setVisibility(0);
        return;
    L35:
        return;
    L23:
        if (this.f507m == true) goto L26;
        this.f496b.setVisibility(8);
        return;
    L11:
        if (this.f507m == true) goto L13;
        return;
    L5:
        if (this.f511q == true) goto L8;
        r11 = false;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r10, char r11) {
        if (r10 == true) goto L4;
    L6:
        int r12 = 8;
    L7:
        if (r12 != 0) goto L10;
        this.f500f.setText(this.f495a.f());
    L10:
        if (this.f500f.getVisibility() == r12) goto L13;
        this.f500f.setVisibility(r12);
        return;
    L13:
        return;
    L4:
        if (this.f495a.x() == false) goto L6;
        r12 = 0;
        goto L7
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r10) {
        if (r10 == null) goto L7;
        this.f498d.setText(r10);
        if (this.f498d.getVisibility() == 0) goto L10;
        this.f498d.setVisibility(0);
        return;
    L10:
        return;
    L7:
        if (this.f498d.getVisibility() == 8) goto L12;
        this.f498d.setVisibility(8);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.f511q;
    }

    public ListMenuItemView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11);
        b0 r13 = b0.v(getContext(), r11, R$styleable.MenuView, r12, 0);
        this.f504j = r13.g(R$styleable.MenuView_android_itemBackground);
        this.f505k = r13.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f507m = r13.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f506l = r10;
        this.f508n = r13.g(R$styleable.MenuView_subMenuArrow);
        TypedArray r14 = r10.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f509o = r14.hasValue(0);
        r13.w();
        r14.recycle();
    }
}
