package com.bytedanceos.common.ui.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.ui.utils.ViewPagerIndexPool;
import com.obric.oui.paneltitlebar.OPanelTitleBar;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes2.dex */
public class BaseAppGroupView extends RelativeLayout {
    public static final int APP_GROUP_COLUMN = 3;
    private static final int DEFAULT_MAX_ITEM_IN_ONE_PAGE = 3;
    public static final int HORIZONTAL_COUNT_IN_EACH_PAGE = 4;
    public static final int TYPE_HORIZONTAL = 1;
    public static final int TYPE_VERTICAL = 2;
    public static final int VIEW_PAGER_ITEM_MARGIN = 0;
    private PagerAdapter mAdapter;
    private String mContextAddressString;
    int mGroupColumn;
    private OPanelTitleBar mGroupTitle;
    private String mGroupTitleStr;
    int mItemCount;
    public int mMaxItemInOnePage;
    private View mMoreView;
    public View.OnClickListener mOnBtnClickListener;
    public View.OnClickListener mOnItemClickListener;
    private boolean mPageChanged;
    private int mPageIndex;
    private ViewPagerCompat.SimpleOnPageChangeListener mSimpleOnPageChangeListener;
    public int mType;
    public BaseViewPager mViewPager;

    static {
        VIEW_PAGER_ITEM_MARGIN = BaseApplication.c().getResources().getDimensionPixelOffset(R$dimen.view_pager_item_margin);
    }

    public BaseAppGroupView(Context r10, int r11) {
        super(r10);
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        this.mItemCount = 0;
        this.mGroupColumn = 3;
        this.mType = 2;
        this.mMaxItemInOnePage = 3;
        this.mSimpleOnPageChangeListener = new AnonymousClass1(this);
        init();
        getGroupTitle().setTitle(getContext().getString(r11));
    }

    public static /* synthetic */ int access$000(BaseAppGroupView r10) {
        return r10.mPageIndex;
    }

    public static /* synthetic */ int access$002(BaseAppGroupView r10, int r11) {
        r10.mPageIndex = r11;
        return r11;
    }

    public static /* synthetic */ boolean access$100(BaseAppGroupView r10) {
        return r10.mPageChanged;
    }

    public static /* synthetic */ boolean access$102(BaseAppGroupView r10, boolean r11) {
        r10.mPageChanged = r11;
        return r11;
    }

    public static /* synthetic */ String access$200(BaseAppGroupView r10) {
        return r10.getContextAddressString();
    }

    private String getContextAddressString() {
        if (this.mContextAddressString != null) goto L9;
        if (getContext() == null) goto L9;
        return getContext().toString();
    L9:
        return this.mContextAddressString;
    }

    private OPanelTitleBar getGroupTitle() {
        if (this.mGroupTitle != null) goto L8;
        ViewStub r10 = (ViewStub) findViewById(R$id.app_group_name_stub);
        if (r10 == null) goto L8;
        this.mGroupTitle = (OPanelTitleBar) r10.inflate();
    L8:
        return this.mGroupTitle;
    }

    private View getMoreView() {
        if (this.mMoreView != null) goto L8;
        ViewStub r10 = (ViewStub) findViewById(R$id.app_group_more_stub);
        if (r10 == null) goto L8;
        this.mMoreView = r10.inflate();
    L8:
        return this.mMoreView;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R$layout.app_group_view_container, this);
        setDescendantFocusability(393216);
        setBackgroundColor(getContext().getResources().getColor(R.color.transparent));
        BaseViewPager r10 = (BaseViewPager) findViewById(R$id.app_group_body);
        this.mViewPager = r10;
        r10.addOnPageChangeListener(this.mSimpleOnPageChangeListener);
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public int getCurrentItem() {
        return this.mViewPager.getCurrentItem();
    }

    public int getViewHashCode() {
        return 0;
    }

    public void refreshWholeGroupView() {
    }

    public void resetItemCountAndGroupColumn() {
    }

    public void resetViewPagerLayout() {
        resetItemCountAndGroupColumn();
        this.mAdapter.notifyDataSetChanged();
        int r10 = ViewPagerIndexPool.getInstance().getCurrentPageIndex(getContextAddressString(), getViewHashCode());
        this.mViewPager.setCurrentItem(r10);
        submitWhenAppVisible(r10);
        this.mPageIndex = r10;
    }

    public void setAdapter(PagerAdapter r10) {
        this.mAdapter = r10;
        this.mViewPager.setAdapter(r10);
    }

    public void setContextAddressString(String r10) {
        this.mContextAddressString = r10;
    }

    public void setCurrentItem(int r10) {
        this.mViewPager.setCurrentItem(r10);
    }

    public void setGroupColumn(int r10) {
        this.mGroupColumn = r10;
    }

    public void setGroupId(String r10) {
        setGroupId(r10, 10);
    }

    public void setGroupLineVisible(int r10) {
    }

    public void setGroupTitle(String r10) {
        this.mGroupTitleStr = r10;
        getGroupTitle().setTitle(r10);
        View r11 = this.mMoreView;
        if (r11 == null) goto L6;
        r11.setTag(R$id.app_group_name, this.mGroupTitleStr);
        return;
    }

    public void setMaxItemInOnePage(int r10) {
        this.mMaxItemInOnePage = r10;
    }

    public void setOnClickListener(BaseCell r10, String r11, int r12) {
        r10.setOnClickListener(this.mMoreView, r12);
    }

    public void setType(int r10) {
        this.mType = r10;
    }

    public void submitWhenAppVisible(int r10) {
    }

    public void updateViewPagerLayout(int r10, int r11) {
        PagerAdapter r12 = this.mAdapter;
        if (r12 != null) goto L5;
        return;
    L5:
        if (r12.getCount() <= 0) goto L9;
        this.mViewPager.measureHeight(r10, r11);
        return;
    }

    public void setGroupId(String r10, int r11) {
        getMoreView().setTag(r10);
        getMoreView().setTag(R$id.app_group_more_view_type, Integer.valueOf(r11));
        String r12 = this.mGroupTitleStr;
        if (r12 == null) goto L6;
        this.mMoreView.setTag(R$id.app_group_name, r12);
        return;
    }

    public void setOnClickListener(View.OnClickListener r10, View.OnClickListener r11) {
        this.mOnBtnClickListener = r10;
        this.mOnItemClickListener = r11;
        if (r10 == null) goto L8;
        View r12 = this.mMoreView;
        if (r12 == null) goto L9;
        r12.setOnClickListener(r10);
        return;
    L9:
        return;
    }

    public BaseAppGroupView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mOnBtnClickListener = null;
        this.mOnItemClickListener = null;
        this.mItemCount = 0;
        this.mGroupColumn = 3;
        this.mType = 2;
        this.mMaxItemInOnePage = 3;
        this.mSimpleOnPageChangeListener = new AnonymousClass1(this);
        init();
    }
}
