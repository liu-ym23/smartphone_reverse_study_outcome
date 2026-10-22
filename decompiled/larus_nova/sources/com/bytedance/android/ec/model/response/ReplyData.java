package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/ec/model/response/ReplyData;", "Ljava/io/Serializable;", "()V", "canReply", "", "getCanReply", "()Z", "setCanReply", "(Z)V", "count", "", "getCount", "()Ljava/lang/Long;", "setCount", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "showReply", "getShowReply", "setShowReply", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ReplyData implements Serializable {

    @SerializedName("can_reply")
    private boolean canReply;

    @SerializedName("count")
    private Long count;

    @SerializedName("show_reply")
    private boolean showReply;

    public ReplyData() {
        this.count = 0L;
        this.canReply = true;
    }

    public final boolean getCanReply() {
        return this.canReply;
    }

    public final Long getCount() {
        return this.count;
    }

    public final boolean getShowReply() {
        return this.showReply;
    }

    public final void setCanReply(boolean r100) {
        this.canReply = r100;
    }

    public final void setCount(Long r100) {
        this.count = r100;
    }

    public final void setShowReply(boolean r100) {
        this.showReply = r100;
    }
}
