package com.tmall.wireless.tangram.structure.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.tmall.wireless.tangram.core.adapter.BinderViewHolder;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.entitycard.EntityCard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EntityCardView extends ViewGroup implements ITangramViewLifeCycle {
    private GroupBasicAdapter mAdapter;
    float mAspectRatio;
    int mBgColor;
    EntityCard mEntityCard;
    int mItemCount;
    private RecyclerView.RecycledViewPool mPool;
    private List<BinderViewHolder> mViewHolders;

    public EntityCardView(Context r10) {
        this(r10, null);
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void cellInited(BaseCell r10) {
        this.mEntityCard = (EntityCard) r10;
        ServiceManager r11 = r10.serviceManager;
        if (r11 != null) goto L5;
        return;
    L5:
        this.mPool = (RecyclerView.RecycledViewPool) r11.getService(RecyclerView.RecycledViewPool.class);
        this.mAdapter = (GroupBasicAdapter) r10.serviceManager.getService(GroupBasicAdapter.class);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof VirtualLayoutManager.LayoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new VirtualLayoutManager.LayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new VirtualLayoutManager.LayoutParams(getContext(), r10);
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postBindView(BaseCell r10) {
        int r11 = 0;
        if (this.mViewHolders.isEmpty() == true) goto L8;
        int r12 = this.mViewHolders.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        BinderViewHolder r14 = this.mViewHolders.get(r13);
        r14.unbind();
        removeView(r14.itemView);
        this.mPool.putRecycledView(r14);
        r13 = r13 + 1;
        goto L5
    L7:
        this.mViewHolders.clear();
    L8:
        List<BaseCell> r15 = this.mEntityCard.getCells();
        int r16 = r15.size();
    L9:
        if (r11 >= r16) goto L14;
        int r17 = this.mAdapter.getItemType(r15.get(r11));
        BinderViewHolder r18 = (BinderViewHolder) this.mPool.getRecycledView(r17);
        if (r18 != null) goto L13;
        r18 = (BinderViewHolder) this.mAdapter.createViewHolder(this, r17);
    L13:
        r18.bind(r15.get(r11));
        addView(r18.itemView);
        this.mViewHolders.add(r18);
        r11 = r11 + 1;
        goto L9
    }

    @Override // com.tmall.wireless.tangram.structure.view.ITangramViewLifeCycle
    public void postUnBindView(BaseCell r10) {
        int r11 = this.mViewHolders.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        BinderViewHolder r13 = this.mViewHolders.get(r12);
        r13.unbind();
        removeView(r13.itemView);
        this.mPool.putRecycledView(r13);
        r12 = r12 + 1;
        goto L3
    L5:
        this.mViewHolders.clear();
    }

    public void setAspectRatio(float r10) {
        this.mAspectRatio = r10;
    }

    public void setBgColor(int r10) {
        this.mBgColor = r10;
    }

    public void setItemCount(int r10) {
        this.mItemCount = r10;
    }

    public EntityCardView(Context r10, AttributeSet r11) {
        this(r10, r11, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new VirtualLayoutManager.LayoutParams(r10);
    }

    public EntityCardView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mAspectRatio = Float.NaN;
        this.mItemCount = 0;
        this.mViewHolders = new ArrayList();
        setOnClickListener(null);
    }
}
