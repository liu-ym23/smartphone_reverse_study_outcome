package com.bytedanceos.common.ui.recycler.binder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.networkv2.entity.FirstRecommendDescEntity;
import com.obric.oui.paneltitlebar.OPanelTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendDescBinder extends com.drakeet.multitype.b {
    private final float BIG_FONT_DEFAULT_SIZE;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private OPanelTitleBar mTvDesc;
        final /* synthetic */ FirstRecommendDescBinder this$0;

        public ViewHolder(FirstRecommendDescBinder r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.mTvDesc = (OPanelTitleBar) r11.findViewById(R$id.tv_desc);
        }

        public static /* synthetic */ OPanelTitleBar access$000(ViewHolder r10) {
            return r10.mTvDesc;
        }
    }

    public FirstRecommendDescBinder() {
        this.BIG_FONT_DEFAULT_SIZE = 41.0f;
    }

    @Override // com.drakeet.multitype.c
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, @NonNull Object r11) {
        onBindViewHolder((ViewHolder) r10, (FirstRecommendDescEntity) r11);
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return onCreateViewHolder(r10, r11);
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, @NonNull FirstRecommendDescEntity r11) {
        if (TextUtils.isEmpty(r11.getDescription()) == false) goto L5;
        r10.itemView.setVisibility(8);
        return;
    L5:
        ViewHolder.access$000(r10).setTitle(r11.getDescription());
        r10.itemView.setVisibility(0);
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return new ViewHolder(this, r10.inflate(R$layout.item_first_recommend_desc, r11, false));
    }
}
