package androidx.appcompat.view.menu;

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
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {
    private static final String TAG = "ListMenuItemView";
    private Drawable mBackground;
    private CheckBox mCheckBox;
    private LinearLayout mContent;
    private boolean mForceShowIcon;
    private ImageView mGroupDivider;
    private boolean mHasListDivider;
    private ImageView mIconView;
    private LayoutInflater mInflater;
    private MenuItemImpl mItemData;
    private boolean mPreserveIconSpacing;
    private RadioButton mRadioButton;
    private TextView mShortcutView;
    private Drawable mSubMenuArrow;
    private ImageView mSubMenuArrowView;
    private int mTextAppearance;
    private Context mTextAppearanceContext;
    private TextView mTitleView;

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.listMenuViewStyle);
    }

    public ListMenuItemView(Context r4, AttributeSet r5, int r6) {
        super(r4, r5);
        TintTypedArray r7 = TintTypedArray.obtainStyledAttributes(getContext(), r5, R.styleable.MenuView, r6, 0);
        this.mBackground = r7.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.mTextAppearance = r7.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.mPreserveIconSpacing = r7.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.mTextAppearanceContext = r4;
        this.mSubMenuArrow = r7.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray r8 = r4.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = r8.hasValue(0);
        r7.recycle();
        r8.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        TextView r0 = (TextView) findViewById(R.id.title);
        this.mTitleView = r0;
        int r1 = this.mTextAppearance;
        if (r1 == (-1)) goto L5;
        r0.setTextAppearance(this.mTextAppearanceContext, r1);
    L5:
        this.mShortcutView = (TextView) findViewById(R.id.shortcut);
        ImageView r2 = (ImageView) findViewById(R.id.submenuarrow);
        this.mSubMenuArrowView = r2;
        if (r2 == null) goto L8;
        r2.setImageDrawable(this.mSubMenuArrow);
    L8:
        this.mGroupDivider = (ImageView) findViewById(R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r2, int r3) {
        this.mItemData = r2;
        if (r2.isVisible() == false) goto L5;
        int r4 = 0;
    L6:
        setVisibility(r4);
        setTitle(r2.getTitleForItemView(this));
        setCheckable(r2.isCheckable());
        setShortcut(r2.shouldShowShortcut(), r2.getShortcut());
        setIcon(r2.getIcon());
        setEnabled(r2.isEnabled());
        setSubMenuArrowVisible(r2.hasSubMenu());
        setContentDescription(r2.getContentDescription());
        return;
    L5:
        r4 = 8;
        goto L6
    }

    private void addContentView(View r2) {
        addContentView(r2, -1);
    }

    private void addContentView(View r2, int r3) {
        LinearLayout r0 = this.mContent;
        if (r0 == null) goto L5;
        r0.addView(r2, r3);
        return;
    L5:
        addView(r2, r3);
    }

    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
        this.mPreserveIconSpacing = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r2) {
        if (r2 == null) goto L7;
        this.mTitleView.setText(r2);
        if (this.mTitleView.getVisibility() == 0) goto L10;
        this.mTitleView.setVisibility(0);
        return;
    L10:
        return;
    L7:
        if (this.mTitleView.getVisibility() == 8) goto L12;
        this.mTitleView.setVisibility(8);
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r4) {
        if (r4 == true) goto L9;
        if (this.mRadioButton != null) goto L9;
        if (this.mCheckBox != null) goto L9;
        return;
    L9:
        if (this.mItemData.isExclusiveCheckable() == false) goto L15;
        if (this.mRadioButton != null) goto L13;
        insertRadioButton();
    L13:
        CompoundButton r0 = this.mRadioButton;
        CompoundButton r1 = this.mCheckBox;
    L19:
        if (r4 == false) goto L27;
        r0.setChecked(this.mItemData.isChecked());
        if (r0.getVisibility() == 0) goto L23;
        r0.setVisibility(0);
    L23:
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.getVisibility() == 8) goto L35;
        r1.setVisibility(8);
        return;
    L35:
        return;
    L27:
        CheckBox r5 = this.mCheckBox;
        if (r5 == null) goto L30;
        r5.setVisibility(8);
    L30:
        RadioButton r3 = this.mRadioButton;
        if (r3 == null) goto L37;
        r3.setVisibility(8);
        return;
    L37:
        return;
    L15:
        if (this.mCheckBox != null) goto L17;
        insertCheckBox();
    L17:
        r0 = this.mCheckBox;
        r1 = this.mRadioButton;
        goto L19
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r2) {
        if (this.mItemData.isExclusiveCheckable() == false) goto L9;
        if (this.mRadioButton != null) goto L7;
        insertRadioButton();
    L7:
        CompoundButton r1 = this.mRadioButton;
    L12:
        r1.setChecked(r2);
        return;
    L9:
        if (this.mCheckBox != null) goto L11;
        insertCheckBox();
    L11:
        r1 = this.mCheckBox;
        goto L12
    }

    private void setSubMenuArrowVisible(boolean r1) {
        ImageView r0 = this.mSubMenuArrowView;
        if (r0 == null) goto L9;
        if (r1 == false) goto L6;
        int r2 = 0;
    L7:
        r0.setVisibility(r2);
        return;
    L6:
        r2 = 8;
        goto L7
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r2, char r3) {
        if (r2 == true) goto L4;
    L6:
        int r4 = 8;
    L7:
        if (r4 != 0) goto L10;
        this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    L10:
        if (this.mShortcutView.getVisibility() == r4) goto L13;
        this.mShortcutView.setVisibility(r4);
        return;
    L13:
        return;
    L4:
        if (this.mItemData.shouldShowShortcut() == false) goto L6;
        r4 = 0;
        goto L7
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r5) {
        if (this.mItemData.shouldShowIcon() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
    L13:
        ImageView r2 = this.mIconView;
        if (r2 != null) goto L19;
        if (r5 != null) goto L19;
        if (this.mPreserveIconSpacing == true) goto L19;
        return;
    L19:
        if (r2 != null) goto L21;
        insertIconView();
    L21:
        if (r5 == null) goto L23;
    L26:
        ImageView r3 = this.mIconView;
        if (r0 == true) goto L30;
        r5 = null;
    L30:
        r3.setImageDrawable(r5);
        if (this.mIconView.getVisibility() == 0) goto L35;
        this.mIconView.setVisibility(0);
        return;
    L35:
        return;
    L23:
        if (this.mPreserveIconSpacing == true) goto L26;
        this.mIconView.setVisibility(8);
        return;
    L11:
        if (this.mPreserveIconSpacing == true) goto L13;
        return;
    L5:
        if (this.mForceShowIcon == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int r4, int r5) {
        if (this.mIconView != null) goto L5;
    L11:
        super.onMeasure(r4, r5);
        return;
    L5:
        if (this.mPreserveIconSpacing == false) goto L11;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
        if (r0.height <= 0) goto L11;
        if (r1.width > 0) goto L11;
        r1.width = r0.height;
        goto L11
    }

    private void insertIconView() {
        ImageView r0 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.mIconView = r0;
        addContentView(r0, 0);
    }

    private void insertRadioButton() {
        RadioButton r0 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.mRadioButton = r0;
        addContentView(r0);
    }

    private void insertCheckBox() {
        CheckBox r0 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.mCheckBox = r0;
        addContentView(r0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater != null) goto L6;
        this.mInflater = LayoutInflater.from(getContext());
    L6:
        return this.mInflater;
    }

    public void setGroupDividerEnabled(boolean r2) {
        ImageView r0 = this.mGroupDivider;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mHasListDivider == true) goto L8;
        if (r2 == false) goto L8;
        int r1 = 0;
    L9:
        r0.setVisibility(r1);
        return;
    L8:
        r1 = 8;
        goto L9
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r4) {
        ImageView r0 = this.mGroupDivider;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        r4.top += (this.mGroupDivider.getHeight() + r1.topMargin) + r1.bottomMargin;
        return;
    }
}
