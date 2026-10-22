package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.network.ads.AdsReportManager;
import com.bytedanceos.common.toolbox.DeviceType;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.utils.ViewPagerRecycledPool;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AppGroupView extends BaseAppGroupView {
    private AppGroupAdapter mAppGroupAdapter;
    private List<AppInfo> mDataLists;
    private SparseArray<View> mViews;

    public class AppGroupAdapter extends PagerAdapter {
        final /* synthetic */ AppGroupView this$0;

        public AppGroupAdapter(AppGroupView r10) {
            this.this$0 = r10;
        }

        private void bindAppGroupItemView(AppGroupItemView r10, int r11, int r12) {
            AppGroupView r13 = this.this$0;
            r10.setOnClickListener(r13.mOnBtnClickListener, r13.mOnItemClickListener);
            r10.updateItemView((AppInfo) AppGroupView.access$000(this.this$0).get(r11));
            if (r11 != ((this.this$0.mItemCount * (r12 + 1)) - 1)) goto L6;
            r10.showLine(false);
        L6:
            if (r12 != (this.this$0.mGroupColumn - 1)) goto L9;
            r10.updateAppStatusViewLayout();
            return;
        }

        private void bindAppHorizontalItemView(AppHorizontalItemView r10, int r11) {
            AppGroupView r12 = this.this$0;
            r10.setOnClickListener(r12.mOnBtnClickListener, r12.mOnItemClickListener);
            r10.updateItemView((AppInfo) AppGroupView.access$000(this.this$0).get(r11));
        }

        private void instantiateRealItem(PageLinearLayout r10, int r11, int r12) {
            if (r11 < AppGroupView.access$000(this.this$0).size()) goto L6;
            return;
        L6:
            if (this.this$0.mType != 2) goto L8;
            AppGroupItemView r13 = new AppGroupItemView(r10.getContext());
            bindAppGroupItemView(r13, r11, r12);
            LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(-1, 0);
            AppGroupItemView r15 = r13;
        L9:
            r14.weight = 1.0f;
            r10.addCacheItem(r15);
            r10.addView(r15, r14);
            AppGroupView.access$100(this.this$0).put(r11, r15);
            return;
        L8:
            AppHorizontalItemView r16 = new AppHorizontalItemView(r10.getContext());
            bindAppHorizontalItemView(r16, r11);
            r14 = new LinearLayout.LayoutParams(0, -1);
            r15 = r16;
            goto L9
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup r10, int r11, Object r12) {
            PageLinearLayout r13 = (PageLinearLayout) r12;
            r10.removeView(r13);
            ViewPagerRecycledPool.getInstance().addLast(r13.getType(), r13);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.mGroupColumn;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object r10) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int r10) {
            if (this.this$0.mType == 1) goto L9;
            if (e.C0() == false) goto L17;
            return 0.9535f;
        L17:
            return 0.93f;
        L9:
            if (e.C0() == false) goto L13;
            DeviceType.is(DeviceType.DELTA);
            return 0.93f;
        L13:
            if (DeviceType.is(DeviceType.DELTA) == false) goto L15;
            return 0.93f;
        L15:
            return 0.95f;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup r10, int r11) {
            AppGroupView r12 = this.this$0;
            int r13 = 0;
            if (r12.mType != 2) goto L5;
            int r14 = 1;
        L6:
            int r15 = PageLinearLayout.getType(r14, r12.mItemCount);
            if (ViewPagerRecycledPool.getInstance().isEmpty(r15) == false) goto L12;
            PageLinearLayout r16 = new PageLinearLayout(r10.getContext());
            r16.setGravity(3);
            r16.setOrientation(r14);
            r16.setType(r14, this.this$0.mItemCount);
        L9:
            int r17 = this.this$0.mItemCount;
            if (r13 >= r17) goto L28;
            instantiateRealItem(r16, (r17 * r11) + r13, r11);
            r13 = r13 + 1;
        L28:
            r10.addView(r16);
            return r16;
        L12:
            r16 = (PageLinearLayout) ViewPagerRecycledPool.getInstance().removeFirst(r15);
            boolean r18 = r16.getCacheItem(0) instanceof View;
            if (r18 == true) goto L15;
            r16.clearItems();
            r16.removeAllViews();
        L15:
            int r19 = this.this$0.mItemCount;
            if (r13 >= r19) goto L28;
            int r20 = (r19 * r11) + r13;
            if (r18 == false) goto L26;
            View r21 = (View) r16.getCacheItem(r13);
            if ((r21 instanceof AppGroupItemView) == false) goto L23;
            bindAppGroupItemView((AppGroupItemView) r21, r20, r11);
        L27:
            r13 = r13 + 1;
            goto L15
        L23:
            if ((r21 instanceof AppHorizontalItemView) == false) goto L25;
            bindAppHorizontalItemView((AppHorizontalItemView) r21, r20);
            goto L27
        L25:
            instantiateRealItem(r16, r20, r11);
            goto L27
        L26:
            instantiateRealItem(r16, r20, r11);
            goto L27
        L5:
            r14 = 0;
            goto L6
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View r10, Object r11) {
            if (r10 != r11) goto L4;
            return true;
        L4:
            return false;
        }
    }

    public AppGroupView(Context r10, int r11) {
        super(r10, r11);
        this.mDataLists = new CopyOnWriteArrayList();
        this.mViews = new SparseArray();
        init();
    }

    public static /* synthetic */ List access$000(AppGroupView r10) {
        return r10.mDataLists;
    }

    public static /* synthetic */ SparseArray access$100(AppGroupView r10) {
        return r10.mViews;
    }

    public void destroyView() {
        SparseArray<View> r10 = this.mViews;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() <= 0) goto L9;
        this.mViews.clear();
        return;
    }

    public List<AppInfo> getDataList() {
        return this.mDataLists;
    }

    @Override // com.bytedanceos.common.ui.widget.BaseAppGroupView
    public int getViewHashCode() {
        if (this.mDataLists.isEmpty() == false) goto L6;
        return -1;
    L6:
        Iterator<AppInfo> r10 = this.mDataLists.iterator();
        int r11 = 0;
    L8:
        if (r10.hasNext() == false) goto L10;
        r11 = r11 + r10.next().hashCode();
        goto L8
    L10:
        return r11;
    }

    public void init() {
        AppGroupAdapter r10 = new AppGroupAdapter(this);
        this.mAppGroupAdapter = r10;
        setAdapter(r10);
    }

    public void refreshGroupView() {
        List<AppInfo> r10 = this.mDataLists;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() <= 0) goto L36;
        BaseViewPager r11 = this.mViewPager;
        if (r11 == null) goto L37;
        int r12 = 1;
        if (this.mType == 1) goto L12;
        r12 = this.mItemCount;
    L12:
        int r13 = Math.max(0, (r11.getCurrentItem() * this.mItemCount) - r12);
        int r14 = r13;
    L14:
        if (r14 >= ((this.mItemCount + r13) + r12)) goto L38;
        if (r14 >= this.mDataLists.size()) goto L27;
        if (r14 >= this.mViews.size()) goto L27;
        if (this.mType != 2) goto L24;
        AppGroupItemView r15 = (AppGroupItemView) this.mViews.get(r14);
        if (r15 == null) goto L27;
        r15.updateAppStatus(this.mDataLists.get(r14));
        goto L27
    L24:
        AppHorizontalItemView r16 = (AppHorizontalItemView) this.mViews.get(r14);
        if (r16 == null) goto L27;
        r16.updateAppStatus(this.mDataLists.get(r14));
    L27:
        r14 = r14 + 1;
        goto L14
    L38:
        return;
    L37:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.BaseAppGroupView
    public void refreshWholeGroupView() {
        List<AppInfo> r10 = this.mDataLists;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() <= 0) goto L27;
        int r11 = 0;
    L8:
        if (r11 >= this.mDataLists.size()) goto L28;
        if (r11 >= this.mViews.size()) goto L29;
        if (this.mType != 2) goto L16;
        AppGroupItemView r12 = (AppGroupItemView) this.mViews.get(r11);
        if (r12 == null) goto L19;
        r12.bindData(this.mDataLists.get(r11));
        r12.updateAppStatus(this.mDataLists.get(r11));
    L19:
        r11 = r11 + 1;
        goto L8
    L16:
        AppHorizontalItemView r13 = (AppHorizontalItemView) this.mViews.get(r11);
        if (r13 == null) goto L19;
        r13.bindData(this.mDataLists.get(r11));
        r13.updateAppStatus(this.mDataLists.get(r11));
        goto L19
    L29:
        return;
    L28:
        return;
    }

    @Override // com.bytedanceos.common.ui.widget.BaseAppGroupView
    public void resetItemCountAndGroupColumn() {
        if (this.mType != 2) goto L8;
        this.mGroupColumn = 3;
        int r10 = this.mDataLists.size() / this.mGroupColumn;
        this.mItemCount = r10;
        int r11 = this.mMaxItemInOnePage;
        if (r11 == (-1)) goto L10;
        if (r10 <= r11) goto L10;
        this.mItemCount = r11;
    L10:
        if (this.mType != 2) goto L12;
        int r12 = 1;
    L13:
        updateViewPagerLayout(r12, this.mItemCount);
        return;
    L12:
        r12 = 0;
        goto L13
    L8:
        this.mItemCount = 4;
        this.mGroupColumn = this.mDataLists.size() / this.mItemCount;
        goto L10
    }

    public void setDataList(List<AppInfo> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == false) goto L7;
        return;
    L7:
        if (this.mDataLists.size() <= 0) goto L9;
        this.mDataLists.clear();
    L9:
        this.mDataLists.addAll(r10);
        resetViewPagerLayout();
    }

    @Override // com.bytedanceos.common.ui.widget.BaseAppGroupView
    public void submitWhenAppVisible(int r10) {
        List<AppInfo> r11 = this.mDataLists;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.size() > 0) goto L7;
        return;
    L7:
        if (this.mViewPager == null) goto L20;
        int r12 = r10 * this.mItemCount;
        int r13 = r12;
    L10:
        if (r13 >= (this.mItemCount + r12)) goto L21;
        if (r13 >= this.mDataLists.size()) goto L14;
        AdsReportManager.h().k(this.mDataLists.get(r13));
    L14:
        r13 = r13 + 1;
        goto L10
    L21:
        return;
    }

    public AppGroupView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mDataLists = new CopyOnWriteArrayList();
        this.mViews = new SparseArray();
        init();
    }
}
