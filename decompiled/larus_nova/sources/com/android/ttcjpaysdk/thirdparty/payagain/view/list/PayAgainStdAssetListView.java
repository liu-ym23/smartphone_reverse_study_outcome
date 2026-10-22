package com.android.ttcjpaysdk.thirdparty.payagain.view.list;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetGroupBean;
import com.android.ttcjpaysdk.std.asset.view.StdAssetListView;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetGroupView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/view/list/PayAgainStdAssetListView;", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetListView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "genGroupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "bean", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "getBusinessFooterTopPadding", "", "getGroupLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainStdAssetListView extends StdAssetListView {
    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetListView
    public int getBusinessFooterTopPadding() {
        return CJPayBasicExtensionKt.dp(16.0f);
    }

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetListView
    public LinearLayout.LayoutParams getGroupLayoutParams() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-1, -2);
        r100.bottomMargin = CJPayBasicExtensionKt.dp(0.0f);
        return r100;
    }

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetListView
    public IAssetGroupView genGroupView(StdAssetGroupBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bean");
        return new PayAgainStdAssetGroupView(getContext(), r100);
    }

    public PayAgainStdAssetListView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public /* synthetic */ PayAgainStdAssetListView(Context r100, AttributeSet r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
