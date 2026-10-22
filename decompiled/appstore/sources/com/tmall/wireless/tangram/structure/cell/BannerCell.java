package com.tmall.wireless.tangram.structure.cell;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.RecyclablePagerAdapter;
import com.tmall.wireless.tangram.core.adapter.BinderViewHolder;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BannerCell extends BaseCell {
    public int hGap;
    public int[] itemMargin;
    public int mAutoScrollInternal;
    public BannerAdapter mBannerAdapter;
    public int mBgColor;
    public List<BaseCell> mCells;
    public BaseCell mFooter;
    public BaseCell mHeader;
    public int mIndicatorColor;
    public int mIndicatorDefaultColor;
    public String mIndicatorFocus;
    public int mIndicatorGap;
    public String mIndicatorGravity;
    public int mIndicatorHeight;
    public int mIndicatorMargin;
    public String mIndicatorNor;
    public String mIndicatorPos;
    public int mIndicatorRadius;
    public boolean mInfinite;
    public int mInfiniteMinCount;
    public float mRatio;
    public int[] margin;
    public float pageWidth;

    public class BannerAdapter extends RecyclablePagerAdapter<BinderViewHolder> {
        private GroupBasicAdapter adapter;
        final /* synthetic */ BannerCell this$0;

        public BannerAdapter(BannerCell r10, GroupBasicAdapter r11, RecyclerView.RecycledViewPool r12) {
            this.this$0 = r10;
            super(r11, r12);
            this.adapter = r11;
        }

        @Override // com.alibaba.android.vlayout.RecyclablePagerAdapter, androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.this$0.mCells.size();
        }

        public BaseCell getItemCell(int r10) {
            return this.this$0.mCells.get(r10);
        }

        @Override // com.alibaba.android.vlayout.RecyclablePagerAdapter
        public int getItemViewType(int r10) {
            return this.adapter.getItemType(this.this$0.mCells.get(r10));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int r10) {
            if (Float.isNaN(this.this$0.pageWidth) == false) goto L6;
            return 1.0f;
        L6:
            return this.this$0.pageWidth;
        }

        @Override // com.alibaba.android.vlayout.RecyclablePagerAdapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
            onBindViewHolder((BinderViewHolder) r10, r11);
        }

        public void onBindViewHolder(BinderViewHolder r10, int r11) {
            r10.bind(this.this$0.mCells.get(r11));
        }
    }

    public BannerCell() {
        this.pageWidth = Float.NaN;
        this.itemMargin = new int[2];
        this.margin = new int[4];
        this.mCells = new ArrayList();
    }

    public void initAdapter() {
        if (this.mBannerAdapter != null) goto L8;
        ServiceManager r10 = this.serviceManager;
        if (r10 == null) goto L9;
        this.mBannerAdapter = new BannerAdapter(this, (GroupBasicAdapter) r10.getService(GroupBasicAdapter.class), (RecyclerView.RecycledViewPool) this.serviceManager.getService(RecyclerView.RecycledViewPool.class));
        return;
    L9:
        return;
    }

    public void setAutoScrollInternal(int r10) {
        this.mAutoScrollInternal = r10;
    }

    public void setBgColor(int r10) {
        this.mBgColor = r10;
    }

    public void setData(List<BaseCell> r10) {
        initAdapter();
        this.mCells.addAll(r10);
        this.mBannerAdapter.notifyDataSetChanged();
    }

    public void setIndicatorColor(int r10) {
        this.mIndicatorColor = r10;
    }

    public void setIndicatorDefaultColor(int r10) {
        this.mIndicatorDefaultColor = r10;
    }

    public void setIndicatorFocus(String r10) {
        this.mIndicatorFocus = r10;
    }

    public void setIndicatorGap(int r10) {
        this.mIndicatorGap = r10;
    }

    public void setIndicatorGravity(String r10) {
        this.mIndicatorGravity = r10;
    }

    public void setIndicatorHeight(int r10) {
        this.mIndicatorHeight = r10;
    }

    public void setIndicatorMargin(int r10) {
        this.mIndicatorMargin = r10;
    }

    public void setIndicatorNor(String r10) {
        this.mIndicatorNor = r10;
    }

    public void setIndicatorPos(String r10) {
        this.mIndicatorPos = r10;
    }

    public void setIndicatorRadius(int r10) {
        this.mIndicatorRadius = r10;
    }

    public void setInfinite(boolean r10) {
        this.mInfinite = r10;
    }

    public void setInfiniteMinCount(int r10) {
        this.mInfiniteMinCount = r10;
    }

    public void setPageWidth(double r10) {
        this.pageWidth = (float) r10;
    }

    public void setRatio(float r10) {
        this.mRatio = r10;
    }

    public void sethGap(int r10) {
        this.hGap = r10;
    }
}
