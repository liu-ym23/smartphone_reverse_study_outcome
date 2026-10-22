package com.bytedance.android.ec.store.product.holder;

import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/store/product/holder/ShopItemViewHolder;", "Lcom/ss/android/ugc/aweme/kiwi/model/QModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ShopItemViewHolder<T extends QModel> extends RecyclerView.ViewHolder {
    public abstract void T3(T r100);

    public ShopItemViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
    }

    public Rect U3(int r100) {
        return new Rect(0, 0, 0, 0);
    }
}
