package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rR\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardTitleBean;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "singleTitle", "", "bankIconUrl", "bankName", "safetyIconUrl", "safetyText", "voucherList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isPayNewCard", "", "orderAmount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ZLjava/lang/String;)V", "hasSafetyIconAndText", "hasVoucher", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardTitleBean implements CJPayObject, Serializable {
    public String bankIconUrl;
    public String bankName;
    public boolean isPayNewCard;
    public String orderAmount;
    public String safetyIconUrl;
    public String safetyText;
    public String singleTitle;
    public ArrayList<String> voucherList;

    public CJPayBindCardTitleBean() {
        this(null, null, null, null, null, null, false, null, 255, null);
    }

    public final boolean hasSafetyIconAndText() {
        if ((!StringsKt.isBlank(this.safetyIconUrl)) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.safetyText)) == false) goto L7;
        return true;
    }

    public final boolean hasVoucher() {
        Iterator<T> r100 = this.voucherList.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if ((!StringsKt.isBlank((String) r100.next())) == false) goto L4;
        return true;
    L8:
        return false;
    }

    public CJPayBindCardTitleBean(String r100, String r101, String r102, String r103, String r104, ArrayList<String> r105, boolean r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, "singleTitle");
        Intrinsics.checkNotNullParameter(r101, "bankIconUrl");
        Intrinsics.checkNotNullParameter(r102, "bankName");
        Intrinsics.checkNotNullParameter(r103, "safetyIconUrl");
        Intrinsics.checkNotNullParameter(r104, "safetyText");
        Intrinsics.checkNotNullParameter(r105, "voucherList");
        Intrinsics.checkNotNullParameter(r107, "orderAmount");
        this.singleTitle = r100;
        this.bankIconUrl = r101;
        this.bankName = r102;
        this.safetyIconUrl = r103;
        this.safetyText = r104;
        this.voucherList = r105;
        this.isPayNewCard = r106;
        this.orderAmount = r107;
    }

    public /* synthetic */ CJPayBindCardTitleBean(String r110, String r111, String r112, String r113, String r114, ArrayList r115, boolean r116, String r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = BindCardCommonInfoUtil.INSTANCE.getSafetyIconUrl();
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = BindCardCommonInfoUtil.INSTANCE.getSafetyText();
    L23:
        if ((r118 & 32) == 0) goto L25;
        ArrayList r106 = new ArrayList();
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
