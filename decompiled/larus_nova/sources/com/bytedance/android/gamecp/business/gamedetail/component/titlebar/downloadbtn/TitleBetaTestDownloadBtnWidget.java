package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.downloadbtn;

import com.bytedance.android.gamecp.base.gamedetail.f0;
import com.bytedance.android.gamecp.business.gamedetail.base.model.h;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/downloadbtn/TitleBetaTestDownloadBtnWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/downloadbtn/BaseTitleDownloadBtnWidget;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/downloadbtn/b;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TitleBetaTestDownloadBtnWidget extends BaseTitleDownloadBtnWidget<b> {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Function1<? super RecyclerViewItemWidget<b>, ? extends Object> f55176w;

    public TitleBetaTestDownloadBtnWidget(f0 r100, h r101, boolean r102, Function1<? super RecyclerViewItemWidget<b>, ? extends Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "uiStyle");
        super(r100, r101, r102, r103);
        this.f55176w = r103;
    }
}
