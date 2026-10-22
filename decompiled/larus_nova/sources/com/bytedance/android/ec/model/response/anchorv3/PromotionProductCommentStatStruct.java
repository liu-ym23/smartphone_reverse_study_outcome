package com.bytedance.android.ec.model.response.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/PromotionProductCommentStatStruct;", "Ljava/io/Serializable;", "()V", "caption", "", "getCaption", "()Ljava/lang/String;", "count", "", "getCount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "id", "getId", "title", "getTitle", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class PromotionProductCommentStatStruct implements Serializable {

    @SerializedName("caption")
    private final String caption;

    @SerializedName("count")
    private final Long count;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f47938id;

    @SerializedName("title")
    private final String title;

    public PromotionProductCommentStatStruct() {
    }

    public final String getCaption() {
        return this.caption;
    }

    public final Long getCount() {
        return this.count;
    }

    public final Long getId() {
        return this.f47938id;
    }

    public final String getTitle() {
        return this.title;
    }
}
