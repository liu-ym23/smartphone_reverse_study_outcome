package com.bytedanceos.common.ui.recycler.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.networkv2.entity.EmptyEntity;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendDividerBinder extends com.drakeet.multitype.b {

    public class ViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ FirstRecommendDividerBinder this$0;

        public ViewHolder(FirstRecommendDividerBinder r10, View r11) {
            this.this$0 = r10;
            super(r11);
        }
    }

    public FirstRecommendDividerBinder() {
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, @NonNull EmptyEntity r11) {
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // com.drakeet.multitype.c
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, @NonNull Object r11) {
        onBindViewHolder((ViewHolder) r10, (EmptyEntity) r11);
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return new ViewHolder(this, r10.inflate(R$layout.item_first_recommend_divider_list, r11, false));
    }
}
