package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.baidu.platform.comapi.map.MapController;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006 "}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "addiItemInfo", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "getAddiItemInfo", "()Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;", "setAddiItemInfo", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayAddiItemInfo;)V", "addiTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getAddiTypeList", "()Ljava/util/ArrayList;", "setAddiTypeList", "(Ljava/util/ArrayList;)V", "hasDiscount", "", "getHasDiscount", "()Z", "setHasDiscount", "(Z)V", "isOpen", "setOpen", "isUseAddiVoucher", "setUseAddiVoucher", "setInfo", "", "isChecked", MapController.ITEM_LAYER_TAG, "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayAddiParams implements Serializable, CJPayObject {
    private CJPayAddiItemInfo addiItemInfo;
    private ArrayList<String> addiTypeList;
    private boolean hasDiscount;
    private boolean isOpen;
    private boolean isUseAddiVoucher;

    public CJPayAddiParams() {
        this.addiTypeList = new ArrayList();
    }

    public final CJPayAddiItemInfo getAddiItemInfo() {
        return this.addiItemInfo;
    }

    public final ArrayList<String> getAddiTypeList() {
        return this.addiTypeList;
    }

    public final boolean getHasDiscount() {
        return this.hasDiscount;
    }

    public final boolean isOpen() {
        return this.isOpen;
    }

    public final boolean isUseAddiVoucher() {
        return this.isUseAddiVoucher;
    }

    public final void setAddiItemInfo(CJPayAddiItemInfo r100) {
        this.addiItemInfo = r100;
    }

    public final void setAddiTypeList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.addiTypeList = r100;
    }

    public final void setHasDiscount(boolean r100) {
        this.hasDiscount = r100;
    }

    public final void setOpen(boolean r100) {
        this.isOpen = r100;
    }

    public final void setUseAddiVoucher(boolean r100) {
        this.isUseAddiVoucher = r100;
    }

    public final void setInfo(boolean r100, CJPayAddiItemInfo r101) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        boolean r102 = r101.has_discount;
        this.hasDiscount = r102;
        this.isOpen = r100;
        if (r102 == false) goto L6;
        if (r100 == false) goto L6;
        boolean r103 = true;
    L7:
        this.isUseAddiVoucher = r103;
        this.addiItemInfo = r101;
        this.addiTypeList.clear();
        if (r100 == false) goto L11;
        this.addiTypeList.add(r101.pay_addi_info_type);
        return;
    L11:
        return;
    L6:
        r103 = false;
        goto L7
    }
}
