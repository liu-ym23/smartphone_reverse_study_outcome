package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentTagStruct;", "Ljava/io/Serializable;", "()V", "countNumber", "", "getCountNumber", "()Ljava/lang/Long;", "Ljava/lang/Long;", "id", "getId", "sentiment", "getSentiment", "tagName", "", "getTagName", "()Ljava/lang/String;", "tagVersion", "getTagVersion", "()J", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentTagStruct implements Serializable {

    @SerializedName("count_number")
    private final Long countNumber;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f47940id;

    @SerializedName("sentiment")
    private final Long sentiment;

    @SerializedName("tag_name")
    private final String tagName;

    @SerializedName("tag_version")
    private final long tagVersion;

    public PromotionProductCommentTagStruct() {
    }

    public final Long getCountNumber() {
        return this.countNumber;
    }

    public final Long getId() {
        return this.f47940id;
    }

    public final Long getSentiment() {
        return this.sentiment;
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final long getTagVersion() {
        return this.tagVersion;
    }
}
