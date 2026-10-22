package com.android.ttcjpaysdk.thirdparty.payagain.view.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.widget.ExtendRecyclerView;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetGroupBean;
import com.android.ttcjpaysdk.std.asset.bean.StdAssetItemBean;
import com.android.ttcjpaysdk.std.asset.view.StdAssetAdapter;
import com.android.ttcjpaysdk.std.asset.view.StdAssetGroupView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/payagain/view/list/PayAgainStdAssetGroupView;", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetGroupView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "d", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;", "(Landroid/content/Context;Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetGroupBean;)V", "titleContainer", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "setTitleContainer", "(Landroid/widget/LinearLayout;)V", "genAdapter", "Lcom/android/ttcjpaysdk/std/asset/view/StdAssetAdapter;", "list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/std/asset/bean/StdAssetItemBean;", "Lkotlin/collections/ArrayList;", "updateView", "", "bdpay-payagain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayAgainStdAssetGroupView extends StdAssetGroupView {
    private LinearLayout titleContainer;

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetGroupView
    public void updateView() {
        super.updateView();
        View r100 = getGroupLayout();
        View r101 = null;
        if (r100 == null) goto L5;
        LinearLayout r102 = (LinearLayout) r100.findViewById(R.id.cj_pay_group_title_container);
    L6:
        this.titleContainer = r102;
        if (r102 == null) goto L9;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        r104.height = CJPayBasicExtensionKt.dp(38.0f);
        r102.setLayoutParams(r104);
    L9:
        ExtendRecyclerView r105 = getRecyclerView();
        boolean r106 = false;
        if (r105 == null) goto L12;
        r105.setPadding(0, 0, 0, 0);
    L12:
        StdAssetGroupBean r107 = getData();
        if (r107 != null) goto L15;
        return;
    L15:
        if (r107.getGroupInfoAssetSelectPageGroupInfoBean() == null) goto L17;
        r106 = true;
    L17:
        if (r106 == true) goto L20;
        r107 = null;
    L20:
        if (r107 != null) goto L22;
        return;
    L22:
        if (r107.hideGroupTitle() == false) goto L26;
        LinearLayout r108 = this.titleContainer;
        if (r108 == null) goto L33;
        CJPayViewExtensionsKt.viewGone(r108);
    L33:
        View r109 = getGroupLayout();
        if (r109 == null) goto L37;
        r101 = r109.findViewById(R.id.cj_pay_group_title_split_line);
    L37:
        if (r107.showTitleSplitLIne() == false) goto L40;
        if (r101 == null) goto L45;
        CJPayViewExtensionsKt.viewVisible(r101);
        return;
    L45:
        return;
    L40:
        if (r101 == null) goto L47;
        CJPayViewExtensionsKt.viewGone(r101);
        return;
    L47:
        return;
    L26:
        View r110 = getGroupLayout();
        if (r110 == null) goto L29;
        TextView r111 = (TextView) r110.findViewById(R.id.cj_pay_group_title);
    L30:
        if (r111 == null) goto L33;
        r111.setText(r107.getGroupTitle());
        goto L33
    L29:
        r111 = null;
        goto L30
    L5:
        r102 = null;
        goto L6
    }

    public final LinearLayout getTitleContainer() {
        return this.titleContainer;
    }

    @Override // com.android.ttcjpaysdk.std.asset.view.StdAssetGroupView
    public StdAssetAdapter genAdapter(ArrayList<StdAssetItemBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        return new PayAgainStdAssetAdapter(getContext(), this, r100);
    }

    public final void setTitleContainer(LinearLayout r100) {
        this.titleContainer = r100;
    }

    public PayAgainStdAssetGroupView(Context r100, StdAssetGroupBean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "d");
        super(r100, r101);
    }
}
