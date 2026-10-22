package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct;", "Ljava/io/Serializable;", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "city", "Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct$AddressUnit;", "getCity", "()Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct$AddressUnit;", "id", "getId", "mobile", "getMobile", "province", "getProvince", SocialConstants.PARAM_RECEIVER, "getReceiver", "tag", "getTag", "town", "getTown", "AddressUnit", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductAddressStruct implements Serializable {

    @SerializedName("address")
    private final String address;

    @SerializedName("city")
    private final AddressUnit city;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f47936id;

    @SerializedName("mobile")
    private final String mobile;

    @SerializedName("province")
    private final AddressUnit province;

    @SerializedName(SocialConstants.PARAM_RECEIVER)
    private final String receiver;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("town")
    private final AddressUnit town;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductAddressStruct$AddressUnit;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "name", "getName", "ec-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class AddressUnit implements Serializable {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private final String f47937id;

        @SerializedName("name")
        private final String name;

        public AddressUnit() {
        }

        public final String getId() {
            return this.f47937id;
        }

        public final String getName() {
            return this.name;
        }
    }

    public PromotionProductAddressStruct() {
    }

    public final String getAddress() {
        return this.address;
    }

    public final AddressUnit getCity() {
        return this.city;
    }

    public final String getId() {
        return this.f47936id;
    }

    public final String getMobile() {
        return this.mobile;
    }

    public final AddressUnit getProvince() {
        return this.province;
    }

    public final String getReceiver() {
        return this.receiver;
    }

    public final String getTag() {
        return this.tag;
    }

    public final AddressUnit getTown() {
        return this.town;
    }
}
