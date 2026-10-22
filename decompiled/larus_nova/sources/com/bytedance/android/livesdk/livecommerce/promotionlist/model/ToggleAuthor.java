package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/ToggleAuthor;", "Ljava/io/Serializable;", "()V", "authorId", "", "getAuthorId", "()J", "roomId", "getRoomId", "secAuthorId", "", "getSecAuthorId", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToggleAuthor implements Serializable {

    @SerializedName("author_id")
    private final long authorId;

    @SerializedName("room_id")
    private final long roomId;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    public ToggleAuthor() {
    }

    public final long getAuthorId() {
        return this.authorId;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }
}
