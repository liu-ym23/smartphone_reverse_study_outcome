package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionReceiveAddrStruct;", "Ljava/io/Serializable;", "()V", "addrId", "", "getAddrId", "()Ljava/lang/String;", "jumpUrl", "getJumpUrl", "text", "getText", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionReceiveAddrStruct implements Serializable {

    @SerializedName("addr_id")
    private final String addrId;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("text")
    private final String text;

    public PromotionReceiveAddrStruct() {
    }

    public final String getAddrId() {
        return this.addrId;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getText() {
        return this.text;
    }
}
