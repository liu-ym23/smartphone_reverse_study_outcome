package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/ItemCardRecommendReasonStruct;", "Ljava/io/Serializable;", "", "reasonType", "Ljava/lang/Integer;", "getReasonType", "()Ljava/lang/Integer;", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "rankId", "getRankId", "rankStyle", "getRankStyle", "rankNo", "getRankNo", "link", "getLink", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ItemCardRecommendReasonStruct implements Serializable {
    public static final a Companion = null;
    public static final int TYPE_COMMENT = 2;
    public static final int TYPE_FOLLOWED = 3;
    public static final int TYPE_RANK = 4;
    public static final int TYPE_VIEWED = 1;

    @SerializedName("content")
    private final String content;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("link")
    private final String link;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
    private final String rankId;

    @SerializedName("rank_no")
    private final Integer rankNo;

    @SerializedName("rank_style")
    private final Integer rankStyle;

    @SerializedName("type")
    private final Integer reasonType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ItemCardRecommendReasonStruct() {
    }

    public final String getContent() {
        return this.content;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getRankId() {
        return this.rankId;
    }

    public final Integer getRankNo() {
        return this.rankNo;
    }

    public final Integer getRankStyle() {
        return this.rankStyle;
    }

    public final Integer getReasonType() {
        return this.reasonType;
    }
}
