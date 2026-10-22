package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/entity/dto/ECItemCardDigest;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()Ljava/lang/String;", "feedType", "", "getFeedType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "roomId", "getRoomId", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECItemCardDigest implements Serializable {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("feed_type")
    private final Integer feedType;

    @SerializedName("room_id")
    private final String roomId;

    public ECItemCardDigest() {
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final Integer getFeedType() {
        return this.feedType;
    }

    public final String getRoomId() {
        return this.roomId;
    }
}
