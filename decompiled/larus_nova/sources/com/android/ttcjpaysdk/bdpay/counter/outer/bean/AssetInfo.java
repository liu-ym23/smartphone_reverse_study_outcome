package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.baidu.platform.comapi.map.MapController;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "()V", "asset_meta_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetMetaInfo;", "asset_show_info", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/AssetShowInfo;", "isEnable", "", "isNewCard", "isSameItem", MapController.ITEM_LAYER_TAG, "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AssetInfo implements CJPayObject, Serializable {
    public AssetMetaInfo asset_meta_info;
    public AssetShowInfo asset_show_info;

    public final boolean isEnable() {
        return StringsKt.isBlank(this.asset_show_info.not_support_msg);
    }

    public final boolean isNewCard() {
        return Intrinsics.areEqual(this.asset_meta_info.asset_type, "NEWCARD");
    }

    public AssetInfo() {
        this.asset_meta_info = new AssetMetaInfo();
        this.asset_show_info = new AssetShowInfo();
    }

    public final boolean isSameItem(AssetInfo r100) {
        if (r100 == null) goto L6;
        AssetMetaInfo r101 = r100.asset_meta_info;
        if (r101 == null) goto L6;
        String r102 = r101.asset_id;
    L8:
        return Intrinsics.areEqual(r102, this.asset_meta_info.asset_id);
    L6:
        r102 = null;
        goto L8
    }
}
