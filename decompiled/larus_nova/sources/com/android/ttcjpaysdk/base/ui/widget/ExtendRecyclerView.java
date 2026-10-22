package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class ExtendRecyclerView extends RecyclerView {
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;

    public static class FixedViewInfo {
        public Object data;
        public View view;

        public FixedViewInfo(View r100) {
            this.view = r100;
        }
    }

    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public RecyclerView.Adapter getAdapter() {
        RecyclerView.Adapter r100 = super.getAdapter();
        if (HeaderAndFooterRecyclerViewAdapter.class.isInstance(r100) == false) goto L8;
        RecyclerView.Adapter r101 = ((HeaderAndFooterRecyclerViewAdapter) r100).getWrappedAdapter();
        if (r101 != null) goto L7;
        return r100;
    L7:
        return r101;
    L8:
        return r100;
    }

    public RecyclerView.Adapter getRealAdapter() {
        return super.getAdapter();
    }

    public ExtendRecyclerView(Context r100) {
        super(r100);
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
    }

    public void addFooterView(View r100) {
        addFooterView(r100, null);
    }

    public void addHeaderView(View r100) {
        addHeaderView(r100, null);
    }

    public boolean removeHeaderView(View r100) {
        boolean r101 = false;
        if (this.mHeaderViewInfos.size() <= 0) goto L10;
        RecyclerView.Adapter r102 = super.getAdapter();
        if (HeaderAndFooterRecyclerViewAdapter.class.isInstance(r102) == true) goto L7;
    L8:
        r101 = true;
    L9:
        removeFixedViewInfo(r100, this.mHeaderViewInfos);
        goto L10
    L7:
        if (((HeaderAndFooterRecyclerViewAdapter) r102).removeHeader(r100) == false) goto L9;
    L10:
        return r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter r100) {
        if (this.mHeaderViewInfos.size() > 0) goto L7;
        if (this.mFooterViewInfos.size() > 0) goto L7;
    L9:
        super.setAdapter(r100);
        return;
    L7:
        if (HeaderAndFooterRecyclerViewAdapter.class.isInstance(r100) == true) goto L9;
        r100 = new HeaderAndFooterRecyclerViewAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, r100);
        goto L9
    }

    public ExtendRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
    }

    private void removeFixedViewInfo(View r100, ArrayList<FixedViewInfo> r101) {
        int r102 = r101.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (((FixedViewInfo) ListProtector.get(r101, r103)).view == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        ListProtector.remove(r101, r103);
        return;
    }

    public void addFooterView(View r100, Object r101) {
        FixedViewInfo r102 = new FixedViewInfo(r100);
        r102.data = r101;
        this.mFooterViewInfos.add(r102);
        RecyclerView.Adapter r103 = super.getAdapter();
        if (r103 != null) goto L5;
        return;
    L5:
        if (HeaderAndFooterRecyclerViewAdapter.class.isInstance(r103) == true) goto L7;
        setAdapter(r103);
    L7:
        r103.notifyDataSetChanged();
    }

    public void addHeaderView(View r100, Object r101) {
        FixedViewInfo r102 = new FixedViewInfo(r100);
        r102.data = r101;
        this.mHeaderViewInfos.add(r102);
        RecyclerView.Adapter r103 = super.getAdapter();
        if (r103 != null) goto L5;
        return;
    L5:
        if (HeaderAndFooterRecyclerViewAdapter.class.isInstance(r103) == true) goto L7;
        setAdapter(r103);
    L7:
        r103.notifyDataSetChanged();
    }

    public ExtendRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mHeaderViewInfos = new ArrayList();
        this.mFooterViewInfos = new ArrayList();
    }
}
