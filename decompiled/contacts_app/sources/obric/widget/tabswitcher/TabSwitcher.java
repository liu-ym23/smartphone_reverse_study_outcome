package obric.widget.tabswitcher;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import java.util.Iterator;
import java.util.List;
import obric.widget.BottomBar;
import obric.widget.BottomBarItemView;
import obric.widget.MenuDialogTitleBar;
import obric.widget.R;
import obric.widget.tabswitcher.model.ITabManager;
import obric.widget.tabswitcher.model.Tab;

/* JADX INFO: loaded from: classes5.dex */
public class TabSwitcher extends RelativeLayout implements View.OnLongClickListener, RadioGroup.OnCheckedChangeListener, BottomBar.OnCheckedChangeListener {
    private static final String TAG = "TabSwitcher";
    private AnimationPanel mAnimPanel;
    private final BottomBar mBottomBar;
    private int mCheckedRadioButtonId;
    private int mCheckedRadioButtonIndex;
    private final Context mContext;
    private float mDrawableTopOffset;
    private final View mEditBarShadowView;
    private boolean mEditable;
    private final ViewGroup mEditableTabBarContainer;
    private int mEditableTabBarContainerHeight;
    private final RadioGroup mEditableTabbarRadioGroup;
    private final LayoutInflater mLayoutInflater;
    private List<Tab> mMoreTabs;
    private BottomBar.OnCheckedChangeListener mOnBottomCheckedChangeListener;
    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    private PickPutBehavior mPickPutBehavior;
    private ITabManager mTabManager;
    private PickPutBehavior mTabbarPickPutBehavior;
    private List<Tab> mTabs;
    private final MenuDialogTitleBar mTitleBar;

    static /* synthetic */ void access$000(TabSwitcher r0, boolean r1) {
        r0.hideEditableBar(r1);
    }

    static /* synthetic */ RadioGroup access$100(TabSwitcher r0) {
        return r0.mEditableTabbarRadioGroup;
    }

    static /* synthetic */ ViewGroup access$200(TabSwitcher r0) {
        return r0.mEditableTabBarContainer;
    }

    static /* synthetic */ int access$302(TabSwitcher r0, int r1) {
        r0.mEditableTabBarContainerHeight = r1;
        return r1;
    }

    static /* synthetic */ ITabManager access$400(TabSwitcher r0) {
        return r0.mTabManager;
    }

    static /* synthetic */ void access$500(TabSwitcher r0) {
        r0.restoreTabs();
    }

    static /* synthetic */ List access$602(TabSwitcher r0, List r1) {
        r0.mTabs = r1;
        return r1;
    }

    static /* synthetic */ List access$702(TabSwitcher r0, List r1) {
        r0.mMoreTabs = r1;
        return r1;
    }

    public TabSwitcher(Context context) {
        this(context, null, 0);
    }

    public TabSwitcher(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabSwitcher(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mEditable = true;
        this.mCheckedRadioButtonIndex = 0;
        this.mContext = context;
        LayoutInflater r2 = LayoutInflater.from(getContext());
        this.mLayoutInflater = r2;
        r2.inflate(R.layout.sb_switch_bar, this, true);
        this.mEditableTabBarContainer = (ViewGroup) findViewById(R.id.sb_edit);
        RadioGroup r3 = (RadioGroup) findViewById(R.id.sb_editableTabContainer);
        this.mEditableTabbarRadioGroup = r3;
        MenuDialogTitleBar r4 = (MenuDialogTitleBar) findViewById(R.id.sb_title_bar);
        this.mTitleBar = r4;
        r4.setLeftButtonVisibility(0);
        r4.getLeftImageView().setImageResource(R.drawable.standard_icon_cancel_selector);
        r4.setOnLeftButtonClickListener(new AnonymousClass1(this));
        r4.getRightImageView().setImageResource(R.drawable.standard_icon_complete_selector);
        r4.setOnRightButtonClickListener(new AnonymousClass2(this));
        r4.setTitle(R.string.sb_editable_tab_title);
        BottomBar r5 = (BottomBar) findViewById(R.id.sb_bottom_bar);
        this.mBottomBar = r5;
        r5.setOnCheckedChangeListener(this);
        this.mEditBarShadowView = findViewById(R.id.sb_edit_layout_bg);
        r3.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass3(this));
    }

    public void setup(ITabManager manager, int checkId) {
        this.mTabManager = manager;
        this.mTabs = manager.getTabs();
        this.mMoreTabs = manager.getMoreTabs();
        setupBottomBar(this.mBottomBar, this.mTabs);
        this.mBottomBar.setDefaultSelectedItem(checkId);
        this.mBottomBar.setup(true);
        setupRadioGroup(this.mEditableTabbarRadioGroup, this.mMoreTabs, true);
        this.mDrawableTopOffset = this.mContext.getResources().getDimension(R.dimen.sb_tab_bar_top_padding);
        this.mPickPutBehavior = new EditableBarBehavior(this.mEditableTabbarRadioGroup, manager, true);
        this.mTabbarPickPutBehavior = new EditableBarBehavior((ViewGroup) this.mBottomBar.getChildAt(0), manager, false);
    }

    private void setupBottomBar(BottomBar bottomBar, List<Tab> tabs) {
        bottomBar.removeAllViews();
        bottomBar.clearItems();
        Iterator<Tab> r9 = tabs.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Tab r0 = r9.next();
        bottomBar.addBarItem(r0.getId(), this.mContext.getResources().getString(r0.getTextResId()), r0.getDrawableResId(), -1, this.mContext.getResources().getColorStateList(r0.getTextColorResId()));
        goto L4
    L6:
        bottomBar.setOnLongClickListener(this);
    }

    private void setupRadioGroup(RadioGroup tabbar, List<Tab> tabs, boolean isTopRadioGroup) {
        tabbar.removeAllViews();
        tabbar.setWeightSum(5.0f);
        Iterator<Tab> r8 = tabs.iterator();
    L4:
        if (r8.hasNext() == false) goto L16;
        Tab r0 = r8.next();
        RadioButton r1 = (RadioButton) this.mLayoutInflater.inflate(R.layout.sb_tab_item, tabbar, false);
        r1.setText(r0.getTextResId());
        if (isTopRadioGroup == false) goto L8;
        int r2 = r0.getMoreTabDrawableResId();
    L9:
        Drawable r3 = getResources().getDrawable(r2);
        r3.setBounds(0, 0, r3.getMinimumWidth(), r3.getMinimumHeight());
        r1.setCompoundDrawables(null, r3, null, null);
        int r4 = r0.getTextColorResId();
        if (r4 != 0) goto L12;
        r4 = R.color.tab_bar_text_color;
    L12:
        if (isTopRadioGroup == false) goto L14;
        r1.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.obric_switch_bar_top_drawablePadding));
        r1.setBackground(getResources().getDrawable(R.drawable.sb_tabbar_item_selector));
    L15:
        r1.setTextColor(getResources().getColorStateList(r4));
        r1.setGravity(49);
        r1.setVisibility(0);
        r1.setOnLongClickListener(this);
        r1.setId(r0.getId());
        tabbar.addView(r1);
        goto L4
    L14:
        r1.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.obric_switch_bar_drawablePadding));
        r1.setBackground(getResources().getDrawable(R.drawable.obric_tab_bar_rb_bg_selector));
        goto L15
    L8:
        r2 = r0.getDrawableResId();
        goto L9
    }

    private void restoreTabs() {
        setupBottomBar(this.mBottomBar, this.mTabs);
        this.mBottomBar.setDefaultSelectedItem(this.mCheckedRadioButtonId);
        this.mBottomBar.setup(true);
        setupRadioGroup(this.mEditableTabbarRadioGroup, this.mMoreTabs, true);
        this.mDrawableTopOffset = this.mContext.getResources().getDimension(R.dimen.sb_tab_bar_top_padding);
        this.mPickPutBehavior = new EditableBarBehavior(this.mEditableTabbarRadioGroup, this.mTabManager, true);
        this.mTabbarPickPutBehavior = new EditableBarBehavior((ViewGroup) this.mBottomBar.getChildAt(0), this.mTabManager, false);
    }

    private void prepareAnimPanel() {
        this.mAnimPanel = new AnimationPanel(this.mContext, this.mPickPutBehavior, this.mTabbarPickPutBehavior, this.mDrawableTopOffset);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, this.mEditableTabbarRadioGroup.getHeight() + this.mBottomBar.getHeight());
        r0.gravity = 80;
        this.mAnimPanel.setLayoutParams(r0);
    }

    public void attachAnimPanel() {
        if (this.mAnimPanel != null) goto L5;
        prepareAnimPanel();
    L5:
        ViewGroup r0 = (ViewGroup) getRootView().findViewById(android.R.id.content);
        ViewParent r1 = this.mAnimPanel.getParent();
        if (r1 == null) goto L8;
        ((ViewGroup) r1).removeView(this.mAnimPanel);
    L8:
        r0.addView(this.mAnimPanel);
        this.mPickPutBehavior.reset();
        this.mTabbarPickPutBehavior.reset();
    }

    public void detachAnimPanel(View view, int height, boolean cancel) {
        view.setVisibility(8);
        ViewGroup.LayoutParams r3 = view.getLayoutParams();
        if (r3 == null) goto L6;
        r3.height = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
    L6:
        if (this.mAnimPanel == null) goto L8;
        ((ViewGroup) getRootView().findViewById(android.R.id.content)).removeView(this.mAnimPanel);
        this.mAnimPanel = null;
    L8:
        setEditBarShadowVisibility(false);
        this.mEditableTabBarContainer.setVisibility(8);
        ViewGroup r4 = (ViewGroup) this.mBottomBar.getChildAt(0);
        if (cancel == true) goto L23;
        int r5 = this.mCheckedRadioButtonIndex;
        if (r5 >= 0) goto L13;
        return;
    L13:
        if (r5 >= r4.getChildCount()) goto L25;
        int r6 = r4.getChildAt(this.mCheckedRadioButtonIndex).getId();
        if (r6 == this.mCheckedRadioButtonId) goto L19;
        this.mCheckedRadioButtonId = r6;
    L19:
        if (r4.findViewById(this.mCheckedRadioButtonId) != null) goto L21;
        this.mCheckedRadioButtonId = r4.getChildAt(this.mBottomBar.getChildCount() - 1).getId();
    L21:
        this.mBottomBar.setDefaultSelectedItem(this.mCheckedRadioButtonId);
        return;
    L25:
        return;
    }

    private void hideEditableBar(boolean cancel) {
        makeShrinkAmimator(this.mEditableTabBarContainer, cancel).start();
    }

    public boolean isEditBarShown() {
        return this.mEditableTabBarContainer.isShown();
    }

    private Animator makeExtendAnimator(final View view, final int height) {
        final ViewGroup.LayoutParams r0 = view.getLayoutParams();
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, height});
        r1.addListener(new AnonymousClass4(this, r0, view, height));
        r1.addUpdateListener(new AnonymousClass5(this, r0, view));
        return r1;
    }

    private Animator makeShrinkAmimator(final View view, final boolean cancel) {
        AnimationPanel r0 = this.mAnimPanel;
        if (r0 == null) goto L5;
        r0.endAnimationPanelAnimation();
    L5:
        final int r5 = view.getHeight();
        final ViewGroup.LayoutParams r1 = view.getLayoutParams();
        ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r5, 0});
        r7.addListener(new AnonymousClass6(this, r1, view, r5, cancel));
        r7.addUpdateListener(new AnonymousClass7(this, r1, view));
        return r7;
    }

    public void setEditable(boolean editable) {
        this.mEditable = editable;
        if (isEditBarShown() == false) goto L6;
        hideEditableBar(false);
        return;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View v) {
        if (this.mEditable == false) goto L9;
        showEditTabbar();
        if ((v instanceof BottomBarItemView) == false) goto L10;
        ((BottomBarItemView) v).setChecked(false);
        return true;
    L10:
        return true;
    L9:
        return false;
    }

    private void showEditTabbar() {
        makeExtendAnimator(this.mEditableTabBarContainer, this.mEditableTabBarContainerHeight).start();
        this.mEditableTabBarContainer.setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    public void setEditBarShadowVisibility(boolean visible) {
        if (visible == false) goto L4;
        int r2 = 0;
    L5:
        this.mEditBarShadowView.setVisibility(r2);
        this.mEditBarShadowView.setClickable(true);
        return;
    L4:
        r2 = 8;
        goto L5
    }

    public void setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener listener) {
        this.mOnCheckedChangeListener = listener;
    }

    public void setOnBottomCheckedChangeListener(BottomBar.OnCheckedChangeListener listener) {
        this.mOnBottomCheckedChangeListener = listener;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (this.mCheckedRadioButtonId == checkedId) goto L28;
        if (checkedId < 0) goto L30;
        View r0 = group.findViewById(checkedId);
        if (r0 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof RadioButton) == true) goto L12;
    L14:
        this.mCheckedRadioButtonId = checkedId;
        int r1 = 0;
    L16:
        if (r1 >= group.getChildCount()) goto L21;
        if (group.getChildAt(r1).getId() != checkedId) goto L20;
        this.mCheckedRadioButtonIndex = r1;
    L20:
        r1 = r1 + 1;
        goto L16
    L21:
        RadioGroup.OnCheckedChangeListener r2 = this.mOnCheckedChangeListener;
        if (r2 == null) goto L29;
        r2.onCheckedChanged(group, checkedId);
        return;
    L29:
        return;
    L12:
        if (((RadioButton) r0).isChecked() == true) goto L14;
        return;
    L30:
        return;
    }

    public void check(int checkId) {
        this.mBottomBar.setDefaultSelectedItem(checkId);
    }

    public void setTitleText(int resId) {
        this.mTitleBar.setTitle(resId);
    }

    @Override // obric.widget.BottomBar.OnCheckedChangeListener
    public void onCheckedChanged(ViewGroup parent, int checkedId) {
        if (this.mCheckedRadioButtonId == checkedId) goto L28;
        if (checkedId < 0) goto L30;
        View r0 = parent.findViewById(checkedId);
        if (r0 != null) goto L10;
        return;
    L10:
        if ((r0 instanceof BottomBarItemView) == true) goto L12;
    L14:
        this.mCheckedRadioButtonId = checkedId;
        int r1 = 0;
    L16:
        if (r1 >= parent.getChildCount()) goto L21;
        if (parent.getChildAt(r1).getId() != checkedId) goto L20;
        this.mCheckedRadioButtonIndex = r1;
    L20:
        r1 = r1 + 1;
        goto L16
    L21:
        BottomBar.OnCheckedChangeListener r2 = this.mOnBottomCheckedChangeListener;
        if (r2 == null) goto L29;
        r2.onCheckedChanged(parent, checkedId);
        return;
    L29:
        return;
    L12:
        if (((BottomBarItemView) r0).isChecked() == true) goto L14;
        return;
    L30:
        return;
    }
}
