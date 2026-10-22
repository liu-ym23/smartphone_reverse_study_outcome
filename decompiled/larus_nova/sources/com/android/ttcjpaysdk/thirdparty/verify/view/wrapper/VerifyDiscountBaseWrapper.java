package com.android.ttcjpaysdk.thirdparty.verify.view.wrapper;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.base.framework.BaseWrapper;
import com.android.ttcjpaysdk.base.ui.data.CJPayPayInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u001eH\u0016J\u000e\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'J4\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00142\u001a\u0010+\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010,j\n\u0012\u0004\u0012\u00020-\u0018\u0001`.H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006/"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/verify/view/wrapper/VerifyDiscountBaseWrapper;", "Lcom/android/ttcjpaysdk/base/framework/BaseWrapper;", "contentView", "Landroid/view/View;", "payInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "(Landroid/view/View;Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;)V", "getContentView", "()Landroid/view/View;", "discountRooNew", "Landroid/widget/RelativeLayout;", "getDiscountRooNew", "()Landroid/widget/RelativeLayout;", "discountRooOld", "getDiscountRooOld", "discountRoot", "getDiscountRoot", "mDiscount", "Landroid/widget/TextView;", "originDiscount", "", "getOriginDiscount", "()Ljava/lang/String;", "setOriginDiscount", "(Ljava/lang/String;)V", "getPayInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo;", "getDiscountView", "getOriginDiscountStr", "isRootViewVisible", "", "setDiscountTextSize", "", "size", "", "setGuideDiscountInfo", "isChecked", "setRootViewVisibility", RemoteMessageConst.Notification.VISIBILITY, "", "updateDiscount", "discount", "amount", "areaList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayPayInfo$AmountAreaInfo;", "Lkotlin/collections/ArrayList;", "bdpay-verify_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class VerifyDiscountBaseWrapper extends BaseWrapper {
    private final View contentView;
    private final RelativeLayout discountRooNew;
    private final RelativeLayout discountRooOld;
    private final View discountRoot;
    private final TextView mDiscount;
    private String originDiscount;
    private final CJPayPayInfo payInfo;

    public void setGuideDiscountInfo(boolean r100) {
    }

    public void updateDiscount(String r100, String r101, ArrayList<CJPayPayInfo.AmountAreaInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "discount");
        Intrinsics.checkNotNullParameter(r101, "amount");
    }

    public final boolean isRootViewVisible() {
        View r100 = this.discountRoot;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final RelativeLayout getDiscountRooNew() {
        return this.discountRooNew;
    }

    public final RelativeLayout getDiscountRooOld() {
        return this.discountRooOld;
    }

    public final View getDiscountRoot() {
        return this.discountRoot;
    }

    public final View getDiscountView() {
        return this.mDiscount;
    }

    public final String getOriginDiscount() {
        return this.originDiscount;
    }

    public String getOriginDiscountStr() {
        return this.originDiscount;
    }

    public final CJPayPayInfo getPayInfo() {
        return this.payInfo;
    }

    public final void setDiscountTextSize(float r100) {
        TextView r101 = this.mDiscount;
        if (r101 == null) goto L7;
        r101.setTextSize(r100);
        return;
    }

    public final void setOriginDiscount(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.originDiscount = r100;
    }

    public final void setRootViewVisibility(int r100) {
        View r101 = this.discountRoot;
        if (r101 == null) goto L7;
        r101.setVisibility(r100);
        return;
    }

    public VerifyDiscountBaseWrapper(View r100, CJPayPayInfo r101) {
        super(r100);
        this.contentView = r100;
        this.payInfo = r101;
        TextView r102 = null;
        if (r100 == null) goto L5;
        View r103 = r100.findViewById(R.id.cj_pay_view_verify_discount_layout);
    L6:
        this.discountRoot = r103;
        if (r100 == null) goto L9;
        RelativeLayout r104 = (RelativeLayout) r100.findViewById(R.id.cj_pay_verify_discount_new);
    L10:
        this.discountRooNew = r104;
        if (r100 == null) goto L13;
        RelativeLayout r105 = (RelativeLayout) r100.findViewById(R.id.cj_pay_verify_discount_old);
    L14:
        this.discountRooOld = r105;
        if (r100 == null) goto L17;
        r102 = (TextView) r100.findViewById(R.id.cj_pay_verify_discount_desc);
    L17:
        this.mDiscount = r102;
        this.originDiscount = "";
        return;
    L13:
        r105 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
