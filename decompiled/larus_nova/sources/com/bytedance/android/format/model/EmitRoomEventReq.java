package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/format/model/EmitRoomEventReq;", "Ljava/io/Serializable;", "()V", "commonParams", "Lcom/bytedance/android/format/model/CommonParams;", "getCommonParams", "()Lcom/bytedance/android/format/model/CommonParams;", "setCommonParams", "(Lcom/bytedance/android/format/model/CommonParams;)V", "eventReq", "", "getEventReq", "()I", "setEventReq", "(I)V", "RoomEventType", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class EmitRoomEventReq implements Serializable {

    @SerializedName("common_params")
    private CommonParams commonParams;

    @SerializedName("event_type")
    private int eventReq;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/format/model/EmitRoomEventReq$RoomEventType;", "", "", "type", "I", "getType", "()I", "Undefined", "ShareSuccess", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RoomEventType extends Enum<RoomEventType> {
        public static final RoomEventType ShareSuccess = null;
        public static final RoomEventType Undefined = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RoomEventType[] f51328a = null;
        private final int type;

        static {
            RoomEventType r100 = new RoomEventType("Undefined", 0, 0);
            Undefined = r100;
            RoomEventType r101 = new RoomEventType("ShareSuccess", 1, 1);
            ShareSuccess = r101;
            f51328a = new RoomEventType[]{r100, r101};
        }

        public static RoomEventType valueOf(String r100) {
            return (RoomEventType) r27.a.a(RoomEventType.class, r100);
        }

        public static RoomEventType[] values() {
            return (RoomEventType[]) f51328a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public RoomEventType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public EmitRoomEventReq() {
        this.eventReq = RoomEventType.Undefined.getType();
    }

    public final CommonParams getCommonParams() {
        return this.commonParams;
    }

    public final int getEventReq() {
        return this.eventReq;
    }

    public final void setCommonParams(CommonParams r100) {
        this.commonParams = r100;
    }

    public final void setEventReq(int r100) {
        this.eventReq = r100;
    }
}
