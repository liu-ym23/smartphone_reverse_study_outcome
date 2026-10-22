package com.bytedance.android.shopping.store.moments.dto;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated(message = "混排建议使用商城的结构")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/store/moments/dto/ItemDTO;", "Ljava/io/Serializable;", "", "itemType", "I", "getItemType", "()I", "setItemType", "(I)V", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "setItemId", "(Ljava/lang/String;)V", "itemData", "getItemData", "setItemData", "spanSize", "Ljava/lang/Integer;", "getSpanSize", "()Ljava/lang/Integer;", "setSpanSize", "(Ljava/lang/Integer;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemDTO implements Serializable {
    public static final a Companion = null;

    @SerializedName("item_data")
    private String itemData;

    @SerializedName("item_id")
    private String itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private int itemType;

    @SerializedName("span_size")
    private Integer spanSize;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ItemDTO() {
        this.itemType = -1;
    }

    public final String getItemData() {
        return this.itemData;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final int getItemType() {
        return this.itemType;
    }

    public final Integer getSpanSize() {
        return this.spanSize;
    }

    public final void setItemData(String r100) {
        this.itemData = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setItemType(int r100) {
        this.itemType = r100;
    }

    public final void setSpanSize(Integer r100) {
        this.spanSize = r100;
    }
}
