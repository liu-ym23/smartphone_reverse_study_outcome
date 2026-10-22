package com.bytedanceos.common.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.ui.widget.AppHorizontalItemView;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MustAppInfoAdapter extends BaseAdapter {
    private List<AppInfo> mDataList;
    private View.OnClickListener mOnBtnClickListener;

    public class Holder {
        AppHorizontalItemView mItemView;
        final /* synthetic */ MustAppInfoAdapter this$0;

        public Holder(MustAppInfoAdapter r10, View r11) {
            this.this$0 = r10;
            AppHorizontalItemView r12 = (AppHorizontalItemView) r11.findViewById(R$id.app_view_musts);
            this.mItemView = r12;
            r12.setOnClickListener(MustAppInfoAdapter.access$000(r10), null);
            this.mItemView.disableClick();
        }

        public void bind(AppInfo r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            this.mItemView.bindData(r10);
        }
    }

    public MustAppInfoAdapter() {
    }

    public static /* synthetic */ View.OnClickListener access$000(MustAppInfoAdapter r10) {
        return r10.mOnBtnClickListener;
    }

    public static MustAppInfoAdapter newInstance() {
        return new MustAppInfoAdapter();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<AppInfo> r10 = this.mDataList;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r10) {
        return this.mDataList.get(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L4;
        r11 = LayoutInflater.from(BaseApplication.c()).inflate(R$layout.must_apps_item_layout, null);
        Holder r13 = new Holder(this, r11);
        r11.setTag(r13);
    L5:
        if (r13 == null) goto L7;
        r13.bind(this.mDataList.get(r10));
    L7:
        return r11;
    L4:
        r13 = (Holder) r11.getTag();
        goto L5
    }

    public MustAppInfoAdapter syncData(List<AppInfo> r10, View.OnClickListener r11) {
        this.mDataList = r10;
        this.mOnBtnClickListener = r11;
        notifyDataSetChanged();
        return this;
    }
}
