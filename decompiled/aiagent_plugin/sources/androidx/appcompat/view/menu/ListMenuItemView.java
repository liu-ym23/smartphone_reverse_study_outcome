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
import androidx.appcompat.widget.y;
import androidx.core.view.ViewCompat;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements AbsListView.SelectionBoundsAdjuster, e.a {
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

    @Override // androidx.appcompat.view.menu.e.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public ListMenuItemView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.listMenuViewStyle, "attr", "listMenuViewStyle"));
    }

    public ListMenuItemView(Context r5, AttributeSet r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r8, r9);
        y r10 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r9, R.styleable.MenuView, r7, 0);
        this.mBackground = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuView_android_itemBackground, "styleable", "MenuView_android_itemBackground"));
        this.mTextAppearance = r10.g(ZeusTransformUtils.mapRes(R.styleable.MenuView_android_itemTextAppearance, "styleable", "MenuView_android_itemTextAppearance"), -1);
        this.mPreserveIconSpacing = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuView_preserveIconSpacing, "styleable", "MenuView_preserveIconSpacing"), false);
        this.mTextAppearanceContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.mSubMenuArrow = r10.a(ZeusTransformUtils.mapRes(R.styleable.MenuView_subMenuArrow, "styleable", "MenuView_subMenuArrow"));
        TypedArray r11 = r8.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, ZeusTransformUtils.mapRes(R.attr.dropDownListViewStyle, "attr", "dropDownListViewStyle"), 0);
        this.mHasListDivider = r11.hasValue(0);
        r10.b();
        r11.recycle();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.a(this, this.mBackground);
        TextView r0 = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.title, DbHelper.COL_ID, DBDefinition.TITLE)), TextView.class, "com.obric.aiagent.plugin");
        this.mTitleView = r0;
        int r2 = this.mTextAppearance;
        if (r2 == (-1)) goto L5;
        r0.setTextAppearance(this.mTextAppearanceContext, r2);
    L5:
        this.mShortcutView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.shortcut, DbHelper.COL_ID, "shortcut")), TextView.class, "com.obric.aiagent.plugin");
        ImageView r1 = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.submenuarrow, DbHelper.COL_ID, "submenuarrow")), ImageView.class, "com.obric.aiagent.plugin");
        this.mSubMenuArrowView = r1;
        if (r1 == null) goto L8;
        r1.setImageDrawable(this.mSubMenuArrow);
    L8:
        this.mGroupDivider = (ImageView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.group_divider, DbHelper.COL_ID, "group_divider")), ImageView.class, "com.obric.aiagent.plugin");
        this.mContent = (LinearLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.content, DbHelper.COL_ID, "content")), LinearLayout.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.appcompat.view.menu.e.a
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

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L8;
        this.mTitleView.setText(r4);
        if (this.mTitleView.getVisibility() == 0) goto L11;
        this.mTitleView.setVisibility(0);
        return;
    L11:
        return;
    L8:
        if (this.mTitleView.getVisibility() == 8) goto L13;
        this.mTitleView.setVisibility(8);
        return;
    }

    @Override // androidx.appcompat.view.menu.e.a
    public MenuItemImpl getItemData() {
        return this.mItemData;
    }

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
    public void onMeasure(int r5, int r6) {
        if (this.mIconView != null) goto L5;
    L11:
        super.onMeasure(r5, r6);
        return;
    L5:
        if (this.mPreserveIconSpacing == false) goto L11;
        ViewGroup.LayoutParams r0 = getLayoutParams();
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.mIconView.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        if (r0.height <= 0) goto L11;
        if (r1.width > 0) goto L11;
        r1.width = r0.height;
        goto L11
    }

    private void insertIconView() {
        ImageView r0 = (ImageView) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(getInflater(), ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_icon, "layout", "abc_list_menu_item_icon"), this, false, "com.obric.aiagent.plugin"), ImageView.class, "com.obric.aiagent.plugin");
        this.mIconView = r0;
        addContentView(r0, 0);
    }

    private void insertRadioButton() {
        RadioButton r0 = (RadioButton) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(getInflater(), ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_radio, "layout", "abc_list_menu_item_radio"), this, false, "com.obric.aiagent.plugin"), RadioButton.class, "com.obric.aiagent.plugin");
        this.mRadioButton = r0;
        addContentView(r0);
    }

    private void insertCheckBox() {
        CheckBox r0 = (CheckBox) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(getInflater(), ZeusTransformUtils.mapRes(R.layout.abc_list_menu_item_checkbox, "layout", "abc_list_menu_item_checkbox"), this, false, "com.obric.aiagent.plugin"), CheckBox.class, "com.obric.aiagent.plugin");
        this.mCheckBox = r0;
        addContentView(r0);
    }

    public boolean showsIcon() {
        return this.mForceShowIcon;
    }

    private LayoutInflater getInflater() {
        if (this.mInflater != null) goto L6;
        this.mInflater = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
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
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) ZeusTransformUtils.preCheckCast(this.mGroupDivider.getLayoutParams(), LinearLayout.LayoutParams.class, "com.obric.aiagent.plugin");
        r4.top += (this.mGroupDivider.getHeight() + r1.topMargin) + r1.bottomMargin;
        return;
    }
}
