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
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes2.dex */
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

    private LayoutInflater getInflater() {
        if (this.mInflater != null) goto L6;
        this.mInflater = LayoutInflater.from(getContext());
    L6:
        return this.mInflater;
    }

    private void insertCheckBox() {
        CheckBox r100 = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, this, false);
        this.mCheckBox = r100;
        addContentView(r100);
    }

    private void insertIconView() {
        ImageView r100 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, this, false);
        this.mIconView = r100;
        addContentView(r100, 0);
    }

    private void insertRadioButton() {
        RadioButton r100 = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, this, false);
        this.mRadioButton = r100;
        addContentView(r100);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.setBackground(this, this.mBackground);
        TextView r100 = (TextView) findViewById(R.id.title);
        this.mTitleView = r100;
        int r101 = this.mTextAppearance;
        if (r101 == (-1)) goto L5;
        r100.setTextAppearance(this.mTextAppearanceContext, r101);
    L5:
        this.mShortcutView = (TextView) findViewById(R.id.shortcut);
        ImageView r102 = (ImageView) findViewById(R.id.submenuarrow);
        this.mSubMenuArrowView = r102;
        if (r102 == null) goto L8;
        r102.setImageDrawable(this.mSubMenuArrow);
    L8:
        this.mGroupDivider = (ImageView) findViewById(R.id.group_divider);
        this.mContent = (LinearLayout) findViewById(R.id.content);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return this.mForceShowIcon;
    }

    private void addContentView(View r100) {
        addContentView(r100, -1);
    }

    private void setSubMenuArrowVisible(boolean r100) {
        ImageView r101 = this.mSubMenuArrowView;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect r100) {
        ImageView r101 = this.mGroupDivider;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getVisibility() != 0) goto L9;
        LinearLayout.LayoutParams r102 = (LinearLayout.LayoutParams) this.mGroupDivider.getLayoutParams();
        r100.top += (this.mGroupDivider.getHeight() + r102.topMargin) + r102.bottomMargin;
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean r100) {
        if (r100 == true) goto L9;
        if (this.mRadioButton != null) goto L9;
        if (this.mCheckBox != null) goto L9;
        return;
    L9:
        if (this.mItemData.isExclusiveCheckable() == false) goto L15;
        if (this.mRadioButton != null) goto L13;
        insertRadioButton();
    L13:
        CompoundButton r101 = this.mRadioButton;
        CompoundButton r102 = this.mCheckBox;
    L19:
        if (r100 == false) goto L27;
        r101.setChecked(this.mItemData.isChecked());
        if (r101.getVisibility() == 0) goto L23;
        r101.setVisibility(0);
    L23:
        if (r102 != null) goto L25;
        return;
    L25:
        if (r102.getVisibility() == 8) goto L35;
        r102.setVisibility(8);
        return;
    L35:
        return;
    L27:
        CheckBox r103 = this.mCheckBox;
        if (r103 == null) goto L30;
        r103.setVisibility(8);
    L30:
        RadioButton r104 = this.mRadioButton;
        if (r104 == null) goto L37;
        r104.setVisibility(8);
        return;
    L37:
        return;
    L15:
        if (this.mCheckBox != null) goto L17;
        insertCheckBox();
    L17:
        r101 = this.mCheckBox;
        r102 = this.mRadioButton;
        goto L19
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean r100) {
        if (this.mItemData.isExclusiveCheckable() == false) goto L9;
        if (this.mRadioButton != null) goto L7;
        insertRadioButton();
    L7:
        CompoundButton r101 = this.mRadioButton;
    L12:
        r101.setChecked(r100);
        return;
    L9:
        if (this.mCheckBox != null) goto L11;
        insertCheckBox();
    L11:
        r101 = this.mCheckBox;
        goto L12
    }

    public void setForceShowIcon(boolean r100) {
        this.mForceShowIcon = r100;
        this.mPreserveIconSpacing = r100;
    }

    public void setGroupDividerEnabled(boolean r100) {
        ImageView r101 = this.mGroupDivider;
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.mHasListDivider == true) goto L8;
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable r100) {
        if (this.mItemData.shouldShowIcon() == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L13:
        ImageView r102 = this.mIconView;
        if (r102 != null) goto L19;
        if (r100 != null) goto L19;
        if (this.mPreserveIconSpacing == true) goto L19;
        return;
    L19:
        if (r102 != null) goto L21;
        insertIconView();
    L21:
        if (r100 == null) goto L23;
    L26:
        ImageView r103 = this.mIconView;
        if (r101 == true) goto L30;
        r100 = null;
    L30:
        r103.setImageDrawable(r100);
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
        r101 = false;
        goto L9
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence r100) {
        if (r100 == null) goto L7;
        this.mTitleView.setText(r100);
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

    public ListMenuItemView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.listMenuViewStyle);
    }

    private void addContentView(View r100, int r101) {
        LinearLayout r102 = this.mContent;
        if (r102 == null) goto L5;
        r102.addView(r100, r101);
        return;
    L5:
        addView(r100, r101);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl r100, int r101) {
        this.mItemData = r100;
        if (r100.isVisible() == false) goto L5;
        int r102 = 0;
    L6:
        setVisibility(r102);
        setTitle(r100.getTitleForItemView(this));
        setCheckable(r100.isCheckable());
        setShortcut(r100.shouldShowShortcut(), r100.getShortcut());
        setIcon(r100.getIcon());
        setEnabled(r100.isEnabled());
        setSubMenuArrowVisible(r100.hasSubMenu());
        setContentDescription(r100.getContentDescription());
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        if (this.mIconView != null) goto L5;
    L11:
        super.onMeasure(r100, r101);
        return;
    L5:
        if (this.mPreserveIconSpacing == false) goto L11;
        ViewGroup.LayoutParams r102 = getLayoutParams();
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) this.mIconView.getLayoutParams();
        int r104 = r102.height;
        if (r104 <= 0) goto L11;
        if (r103.width > 0) goto L11;
        r103.width = r104;
        goto L11
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean r100, char r101) {
        if (r100 == true) goto L4;
    L6:
        int r102 = 8;
    L7:
        if (r102 != 0) goto L10;
        this.mShortcutView.setText(this.mItemData.getShortcutLabel());
    L10:
        if (this.mShortcutView.getVisibility() == r102) goto L13;
        this.mShortcutView.setVisibility(r102);
        return;
    L13:
        return;
    L4:
        if (this.mItemData.shouldShowShortcut() == false) goto L6;
        r102 = 0;
        goto L7
    }

    public ListMenuItemView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101);
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(getContext(), r101, new int[]{android.R.attr.windowAnimationStyle, android.R.attr.itemTextAppearance, android.R.attr.horizontalDivider, android.R.attr.verticalDivider, android.R.attr.headerBackground, android.R.attr.itemBackground, android.R.attr.itemIconDisabledAlpha, R.attr.preserveIconSpacing, R.attr.subMenuArrow}, r102, 0);
        this.mBackground = r103.getDrawable(5);
        this.mTextAppearance = r103.getResourceId(1, -1);
        this.mPreserveIconSpacing = r103.getBoolean(7, false);
        this.mTextAppearanceContext = r100;
        this.mSubMenuArrow = r103.getDrawable(8);
        TypedArray r104 = r100.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.mHasListDivider = r104.hasValue(0);
        r103.recycle();
        r104.recycle();
    }
}
