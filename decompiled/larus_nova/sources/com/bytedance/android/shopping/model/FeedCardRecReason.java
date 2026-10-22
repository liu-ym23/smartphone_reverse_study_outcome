package com.bytedance.android.shopping.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000b¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/model/FeedCardRecReason;", "Ljava/io/Serializable;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "content", "getContent", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "rankId", "getRankId", "uid", "getUid", "", "rankNo", "Ljava/lang/Long;", "getRankNo", "()Ljava/lang/Long;", "link", "getLink", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class FeedCardRecReason implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -110;

    @SerializedName("content")
    private final String content;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("link")
    private final String link;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RANK_ID)
    private final String rankId;

    @SerializedName("rank_no")
    private final Long rankNo;

    @SerializedName("type")
    private final Integer type;

    @SerializedName("type_name")
    private final String typeName;

    @SerializedName("uid")
    private final String uid;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedCardRecReason() {
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

    public final Long getRankNo() {
        return this.rankNo;
    }

    public final Integer getType() {
        return this.type;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public final String getUid() {
        return this.uid;
    }
}
