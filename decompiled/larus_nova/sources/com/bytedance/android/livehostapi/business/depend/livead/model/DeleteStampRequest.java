package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/DeleteStampRequest;", "", "()V", "roomId", "", "getRoomId", "()J", "setRoomId", "(J)V", "stamps", "", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampQuery;", "getStamps", "()Ljava/util/List;", "setStamps", "(Ljava/util/List;)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeleteStampRequest {

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("stamps")
    private List<StampQuery> stamps;

    public DeleteStampRequest() {
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final List<StampQuery> getStamps() {
        return this.stamps;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setStamps(List<StampQuery> r100) {
        this.stamps = r100;
    }
}
