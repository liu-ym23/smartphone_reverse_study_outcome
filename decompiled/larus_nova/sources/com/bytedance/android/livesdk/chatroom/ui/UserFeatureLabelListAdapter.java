package com.bytedance.android.livesdk.chatroom.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class UserFeatureLabelListAdapter extends RecyclerView.Adapter<LabelViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<ImageModel> f112565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f112566b;

    public static class LabelViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f112567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f112568b;

        public LabelViewHolder(View r100) {
            super(r100);
            this.f112568b = (ImageView) this.itemView.findViewById(R.id.ttlive_user_card_label_icon);
            this.f112567a = com.bytedance.android.live.core.utils.s1.f(16.0f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<ImageModel> r100 = this.f112565a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return ((ArrayList) r100).size();
    }

    public UserFeatureLabelListAdapter() {
    }

    public final void setData(List<ImageModel> r100) {
        if (CollectionUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.f112565a != null) goto L8;
        this.f112565a = new ArrayList();
    L8:
        ((ArrayList) this.f112565a).clear();
        ((ArrayList) this.f112565a).addAll(r100);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        LabelViewHolder r101 = (LabelViewHolder) r100;
        if (CollectionUtils.isEmpty(this.f112565a) == false) goto L5;
        return;
    L5:
        if (r110 >= ((ArrayList) this.f112565a).size()) goto L28;
        ImageModel r111 = (ImageModel) ListProtector.get(this.f112565a, r110);
        View.OnClickListener r102 = this.f112566b;
        r101.getClass();
        if (r111 != null) goto L10;
        return;
    L10:
        if (r111.getImageType().intValue() != 7) goto L12;
    L25:
        UIUtils.setViewVisibility(r101.f112568b, 8);
        return;
    L12:
        if (r111.getImageType().intValue() == 50) goto L25;
        if (r111.getImageType().intValue() == 51) goto L25;
        if (r111.getImageType().intValue() == 52) goto L25;
        if (r111.getImageType().intValue() == 53) goto L25;
        if (r111.getImageType().intValue() == 5) goto L25;
        if (r111.getImageType().intValue() == 6) goto L25;
        ImageUtil.loadImage(r101.f112568b, r111, -1, -1, true, 0, new s9(r101));
        UIUtils.setClickListener(true, r101.itemView, r102);
        r101.itemView.setTag(r111);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new LabelViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_user_card_label_icon_layout, r100, false));
    }
}
