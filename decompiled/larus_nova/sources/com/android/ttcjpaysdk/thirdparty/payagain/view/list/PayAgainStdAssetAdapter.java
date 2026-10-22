package com.android.ttcjpaysdk.thirdparty.payagain.view.list;

import android.content.Context;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.std.asset.view.StdAssetAdapter;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetGroupView;
import com.android.ttcjpaysdk.std.asset.view.base.IAssetItemView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/view/list/PayAgainStdAssetAdapter;", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "parentGroupView", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;", "data", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "Lkotlin/collections/ArrayList;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetGroupView;Ljava/util/ArrayList;)V", "genItem", "Lcom/android/ttcjpaysdk/std/asset/view/base/IAssetItemView;", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainStdAssetAdapter extends StdAssetAdapter {
    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetAdapter
    public IAssetItemView genItem() {
        return new PayAgainStdAssetItemView(getContext(), getParentGroupView(), null, 4, null);
    }

    public PayAgainStdAssetAdapter(Context r100, IAssetGroupView r101, ArrayList<StdAssetItemBean> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parentGroupView");
        Intrinsics.checkNotNullParameter(r102, "data");
        super(r100, r101, r102);
    }
}
