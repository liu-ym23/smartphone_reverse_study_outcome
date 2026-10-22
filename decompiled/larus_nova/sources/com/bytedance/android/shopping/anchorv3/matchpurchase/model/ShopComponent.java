package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.matchpurchase.AllCombinationStruct;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/ShopComponent;", "Ljava/io/Serializable;", "()V", "allCombinationStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/AllCombinationStruct;", "getAllCombinationStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/AllCombinationStruct;", "title", "", "getTitle", "()Ljava/lang/String;", "titleIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getTitleIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopComponent implements Serializable {

    @SerializedName("all_combination_struct")
    private final AllCombinationStruct allCombinationStruct;

    @SerializedName("title")
    private final String title;

    @SerializedName("title_icon")
    private final ECUrlModel titleIcon;

    public ShopComponent() {
    }

    public final AllCombinationStruct getAllCombinationStruct() {
        return this.allCombinationStruct;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ECUrlModel getTitleIcon() {
        return this.titleIcon;
    }
}
