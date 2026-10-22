package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.holder.ECLoadMoreViewHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/mixframe/MixFrameLoadMoreViewHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLoadMoreViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MixFrameLoadMoreViewHolder extends ECLoadMoreViewHolder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f186760q = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final QUIManager f186761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final View f186762p;

    public static final class a {
    }

    static {
    }

    public MixFrameLoadMoreViewHolder(QUIManager r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f186761o = r100;
        this.f186762p = r101;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r100, String r101, k.a r102) {
        Intrinsics.checkNotNullParameter(r101, "itemId");
        super.b4(r100, r101, r102);
        this.f186761o.c(d.class, null);
    }
}
