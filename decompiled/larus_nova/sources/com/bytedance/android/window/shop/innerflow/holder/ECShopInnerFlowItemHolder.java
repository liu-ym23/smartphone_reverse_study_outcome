package com.bytedance.android.window.shop.innerflow.holder;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vp3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/holder/ECShopInnerFlowItemHolder;", "Lvp3/b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECShopInnerFlowItemHolder<T extends vp3.b> extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QUIManager f189042a;

    public abstract void T3(T r100);

    public abstract void U3();

    public ECShopInnerFlowItemHolder(QUIManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r101);
        this.f189042a = r100;
    }
}
