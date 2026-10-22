package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 62\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b4\u00105R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u001c\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000fR$\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\u0017\u001a\u0004\b1\u0010\u0019R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006¨\u00068"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveStruct;", "Ljava/io/Serializable;", "", "uid", "Ljava/lang/String;", "getUid", "()Ljava/lang/String;", "secUid", "getSecUid", "roomId", "getRoomId", "", "status", "Ljava/lang/Integer;", "getStatus", "()Ljava/lang/Integer;", "", "number", "Ljava/lang/Long;", "getNumber", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "getTitle", "avatar", "getAvatar", "nickName", "getNickName", "productCount", "getProductCount", "totalNumber", "getTotalNumber", "followStatus", "getFollowStatus", "", "relationTags", "Ljava/util/List;", "getRelationTags", "()Ljava/util/List;", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveLink;", "link", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveLink;", "getLink", "()Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardLiveLink;", "liveIcon", "getLiveIcon", "liveDescription", "getLiveDescription", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemCardLiveStruct implements Serializable {
    public static final a Companion = null;
    public static final int IS_FOLLOW = 1;

    @SerializedName("avatar")
    private final ECUrlModel avatar;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("follow_status")
    private final Integer followStatus;

    @SerializedName("link")
    private final ItemCardLiveLink link;

    @SerializedName("live_description")
    private final String liveDescription;

    @SerializedName("live_icon")
    private final ECUrlModel liveIcon;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("number")
    private final Long number;

    @SerializedName("product_count")
    private final Long productCount;

    @SerializedName("relation_tags")
    private final List<String> relationTags;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_uid")
    private final String secUid;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("title")
    private final String title;

    @SerializedName("total_number")
    private final Long totalNumber;

    @SerializedName("uid")
    private final String uid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ItemCardLiveStruct() {
    }

    public final ECUrlModel getAvatar() {
        return this.avatar;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final Integer getFollowStatus() {
        return this.followStatus;
    }

    public final ItemCardLiveLink getLink() {
        return this.link;
    }

    public final String getLiveDescription() {
        return this.liveDescription;
    }

    public final ECUrlModel getLiveIcon() {
        return this.liveIcon;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final Long getNumber() {
        return this.number;
    }

    public final Long getProductCount() {
        return this.productCount;
    }

    public final List<String> getRelationTags() {
        return this.relationTags;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecUid() {
        return this.secUid;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Long getTotalNumber() {
        return this.totalNumber;
    }

    public final String getUid() {
        return this.uid;
    }
}
