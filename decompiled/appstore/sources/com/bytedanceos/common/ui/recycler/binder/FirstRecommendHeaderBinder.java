package com.bytedanceos.common.ui.recycler.binder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$layout;
import com.bytedanceos.common.network.widget.NetworkImageView;
import com.bytedanceos.common.networkv2.entity.FirstRecommendBannerEntity;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendHeaderBinder extends com.drakeet.multitype.b {
    private static final float RADIUS = 0.0f;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private NetworkImageView mNivCover;
        final /* synthetic */ FirstRecommendHeaderBinder this$0;

        public ViewHolder(FirstRecommendHeaderBinder r10, View r11) {
            this.this$0 = r10;
            super(r11);
            this.mNivCover = (NetworkImageView) r11.findViewById(R$id.niv_cover);
        }
    }

    static {
        RADIUS = BaseApplication.c().getResources().getDimension(R$dimen.oui_r_l1);
    }

    public FirstRecommendHeaderBinder() {
    }

    public void onBindViewHolder(@NonNull ViewHolder r10, @NonNull FirstRecommendBannerEntity r11) {
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return onCreateViewHolder(r10, r11);
    }

    @Override // com.drakeet.multitype.c
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r10, @NonNull Object r11) {
        onBindViewHolder((ViewHolder) r10, (FirstRecommendBannerEntity) r11);
    }

    @Override // com.drakeet.multitype.b
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull LayoutInflater r10, @NonNull ViewGroup r11) {
        return new ViewHolder(this, r10.inflate(R$layout.item_first_recommend_banner, r11, false));
    }
}
