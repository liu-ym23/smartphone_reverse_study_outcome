package com.tmall.wireless.tangram.structure.cell;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$color;
import com.tmall.wireless.tangram.core.adapter.BinderViewHolder;
import com.tmall.wireless.tangram.core.adapter.GroupBasicAdapter;
import com.tmall.wireless.tangram.core.service.ServiceManager;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LinearScrollCell extends BaseCell {
    public static final int DEFAULT_DEFAULT_INDICATOR_COLOR = 0;
    public static final int DEFAULT_INDICATOR_COLOR = 0;
    public static final String KEY_DEFAULT_INDICATOR_COLOR = "defaultIndicatorColor";
    public static final String KEY_FOOTER_TYPE = "footerType";
    public static final String KEY_HAS_INDICATOR = "hasIndicator";
    public static final String KEY_INDICATOR_COLOR = "indicatorColor";
    public static final String KEY_PAGE_HEIGHT = "pageHeight";
    public static final String KEY_PAGE_WIDTH = "pageWidth";
    public static final String KEY_RETAIN_SCROLL_STATE = "retainScrollState";
    public Adapter adapter;
    public int bgColor;
    public List<BaseCell> cells;
    public int currentDistance;
    public int defaultIndicatorColor;
    public String footerType;
    public boolean hasIndicator;
    public int indicatorColor;
    public double pageHeight;
    public double pageWidth;
    public boolean retainScrollState;

    public class Adapter extends RecyclerView.Adapter {
        private GroupBasicAdapter adapter;
        final /* synthetic */ LinearScrollCell this$0;

        public Adapter(LinearScrollCell r10, GroupBasicAdapter r11) {
            this.this$0 = r10;
            this.adapter = r11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<BaseCell> r10 = this.this$0.cells;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r10) {
            return this.adapter.getItemType(this.this$0.cells.get(r10));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
            onBindViewHolder((BinderViewHolder) r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            return onCreateViewHolder(r10, r11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r10) {
            onViewRecycled((BinderViewHolder) r10);
        }

        public void onBindViewHolder(BinderViewHolder r10, int r11) {
            r10.bind(this.this$0.cells.get(r11));
            BaseCell r12 = this.this$0.cells.get(r11);
            RecyclerView.LayoutParams r13 = new RecyclerView.LayoutParams(r10.itemView.getLayoutParams());
            if (Double.isNaN(this.this$0.pageWidth) == true) goto L6;
            ((ViewGroup.MarginLayoutParams) r13).width = (int) (this.this$0.pageWidth + 0.5d);
        L6:
            if (Double.isNaN(this.this$0.pageHeight) == true) goto L8;
            ((ViewGroup.MarginLayoutParams) r13).height = (int) (this.this$0.pageHeight + 0.5d);
        L8:
            int[] r14 = {0, 0, 0, 0};
            Style r15 = r12.style;
            if (r15 == null) goto L11;
            r14 = r15.margin;
        L11:
            r13.setMargins(r14[3], r14[0], r14[1], r14[2]);
            if (Double.isNaN(r12.extras.optDouble(LinearScrollCell.KEY_PAGE_WIDTH)) == true) goto L14;
            ((ViewGroup.MarginLayoutParams) r13).width = Style.dp2px(r12.extras.optDouble(LinearScrollCell.KEY_PAGE_WIDTH));
        L14:
            r10.itemView.setLayoutParams(r13);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public BinderViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
            return this.adapter.onCreateViewHolder(r10, r11);
        }

        public void onViewRecycled(BinderViewHolder r10) {
            this.adapter.onViewRecycled(r10);
        }
    }

    static {
        DEFAULT_DEFAULT_INDICATOR_COLOR = BaseApplication.c().getResources().getColor(R$color.default_indicator_color);
        DEFAULT_INDICATOR_COLOR = BaseApplication.c().getResources().getColor(R$color.indicator_color);
    }

    public LinearScrollCell() {
        this.cells = new ArrayList();
        this.pageWidth = Double.NaN;
        this.pageHeight = Double.NaN;
        this.defaultIndicatorColor = DEFAULT_DEFAULT_INDICATOR_COLOR;
        this.indicatorColor = DEFAULT_INDICATOR_COLOR;
        this.hasIndicator = true;
        this.bgColor = 0;
        this.currentDistance = 0;
        this.retainScrollState = true;
    }

    public GroupBasicAdapter getAdapter() {
        ServiceManager r10 = this.serviceManager;
        if (r10 != null) goto L5;
        return null;
    L5:
        return (GroupBasicAdapter) r10.getService(GroupBasicAdapter.class);
    }

    public RecyclerView.RecycledViewPool getRecycledViewPool() {
        ServiceManager r10 = this.serviceManager;
        if (r10 != null) goto L5;
        return null;
    L5:
        return (RecyclerView.RecycledViewPool) r10.getService(RecyclerView.RecycledViewPool.class);
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.ComponentLifecycle
    public void onAdded() {
        super.onAdded();
        this.adapter = new Adapter(this, getAdapter());
    }

    public void setCells(List<BaseCell> r10) {
        this.cells.clear();
        if (r10 != null) goto L5;
    L7:
        this.adapter.notifyDataSetChanged();
        return;
    L5:
        if (r10.size() <= 0) goto L7;
        this.cells.addAll(r10);
        goto L7
    }
}
