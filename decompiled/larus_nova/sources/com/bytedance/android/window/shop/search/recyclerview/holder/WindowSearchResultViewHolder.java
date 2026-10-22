package com.bytedance.android.window.shop.search.recyclerview.holder;

import android.view.View;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import jp.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vq3.d;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowSearchResultViewHolder;", "Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowBaseSearchResultViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultViewHolder extends WindowBaseSearchResultViewHolder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f189787d = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder
    public final void T3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        QUIManager r101 = this.f189774a;
        if (r101 == null) goto L6;
        r101.c(d.class, ((jp.a) r100).f499927b);
        return;
    }

    public WindowSearchResultViewHolder(QUIManager r100, View r101, WindowSearchResultItemType r102) {
        Intrinsics.checkNotNullParameter(r100, "uiManager");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "type");
        super(r100, r101, r102);
    }
}
