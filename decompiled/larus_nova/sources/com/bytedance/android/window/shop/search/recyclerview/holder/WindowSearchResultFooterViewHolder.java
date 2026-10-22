package com.bytedance.android.window.shop.search.recyclerview.holder;

import android.widget.TextView;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultFooterNoticeVO;
import com.bytedance.android.ec.window.base.search.recyclerview.vo.WindowSearchResultItemType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import jp.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowSearchResultFooterViewHolder;", "Lcom/bytedance/android/window/shop/search/recyclerview/holder/WindowBaseSearchResultViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchResultFooterViewHolder extends WindowBaseSearchResultViewHolder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f189785e = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f189786d;

    public static final class a {
    }

    static {
    }

    public WindowSearchResultFooterViewHolder(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "footerView");
        super(null, r100, WindowSearchResultItemType.FOOTER_VIEW);
        this.f189786d = r100;
    }

    @Override // com.bytedance.android.window.shop.search.recyclerview.holder.WindowBaseSearchResultViewHolder
    public final void T3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        this.f189786d.setText(((WindowSearchResultFooterNoticeVO) r100).f49552b.getDescription());
    }
}
