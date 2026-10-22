package com.bytedanceos.common.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.Topic;
import com.bytedanceos.common.tangram.view.BouncyScrollListView;
import com.bytedanceos.common.ui.adapter.QuickAdapter;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BannerScrollView extends BouncyScrollListView {
    private BannerScrollAdapter mAdapter;
    private List<Topic> mDataList;
    private int mHorizontalPadding;
    private int mLastOffset;
    private int mLastPosition;
    private View.OnClickListener mOnClickListener;
    private RecyclerView mRecyclerView;

    public class BannerScrollAdapter extends QuickAdapter<Topic> {
        final /* synthetic */ BannerScrollView this$0;

        public BannerScrollAdapter(BannerScrollView r10, List<Topic> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
        public /* bridge */ /* synthetic */ void convert(QuickAdapter.VH r10, Topic r11, int r12) {
            convert2(r10, r11, r12);
        }

        @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
        public int getLayoutId(int r10) {
            return R$layout.topic_slide_multi_banner_item;
        }

        @Override // com.bytedanceos.common.ui.adapter.QuickAdapter
        public void initView(int r10, QuickAdapter.VH r11) {
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public void convert2(QuickAdapter.VH r10, Topic r11, int r12) {
            ((BaseBannerView) r10.getView(R$id.topic_banner_layout)).bindData(r11);
            if (BannerScrollView.access$000(this.this$0) == null) goto L6;
            r10.mConvertView.setTag(r11);
            r10.mConvertView.setOnClickListener(BannerScrollView.access$000(this.this$0));
            return;
        }
    }

    public BannerScrollView(Context r10) {
        this(r10, null);
    }

    public static /* synthetic */ View.OnClickListener access$000(BannerScrollView r10) {
        return r10.mOnClickListener;
    }

    private void init() {
        setClipToPadding(false);
        setClipChildren(false);
        int r10 = this.mHorizontalPadding;
        setPadding(r10, 0, r10, 0);
        RecyclerView r11 = getListView();
        this.mRecyclerView = r11;
        r11.setClipChildren(false);
        this.mRecyclerView.setFocusable(false);
        BannerScrollAdapter r12 = new BannerScrollAdapter(this, this.mDataList);
        this.mAdapter = r12;
        this.mRecyclerView.setAdapter(r12);
    }

    private void recordScrollPosition() {
        LinearLayoutManager r10 = (LinearLayoutManager) this.mRecyclerView.getLayoutManager();
        View r11 = r10.getChildAt(0);
        if (r11 == null) goto L6;
        this.mLastPosition = r10.getPosition(r11);
        this.mLastOffset = r11.getLeft();
        return;
    }

    private void recoverPosition() {
        ((LinearLayoutManager) this.mRecyclerView.getLayoutManager()).scrollToPositionWithOffset(this.mLastPosition, this.mLastOffset);
    }

    public void setData(List<Topic> r10) {
        if (this.mDataList.isEmpty() == true) goto L5;
        this.mDataList.clear();
    L5:
        this.mDataList.addAll(r10);
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r10) {
        this.mOnClickListener = r10;
    }

    public BannerScrollView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public BannerScrollView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mHorizontalPadding = Style.dp2px(8.0d);
        this.mDataList = new ArrayList();
        init();
    }
}
