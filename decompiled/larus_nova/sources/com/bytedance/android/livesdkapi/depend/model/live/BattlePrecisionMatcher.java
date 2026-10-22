package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import r27.a;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.PrecisionMatch.Matcher")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattlePrecisionMatcher;", "", "()V", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "tagList", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRivalTag;", "getTagList", "()Ljava/util/List;", "setTagList", "(Ljava/util/List;)V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "Status", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattlePrecisionMatcher implements h {

    @SerializedName("room")
    protected Room room;

    @SerializedName("status")
    protected int status;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<BattleRivalTag> tagList;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    protected String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattlePrecisionMatcher$Status;", "", "(Ljava/lang/String;I)V", "StatusUndefined", "StatusNotReady", "StatusReady", "StatusRejected", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status StatusNotReady = null;
        public static final Status StatusReady = null;
        public static final Status StatusRejected = null;
        public static final Status StatusUndefined = null;

        static {
            Status r100 = new Status("StatusUndefined", 0);
            StatusUndefined = r100;
            Status r101 = new Status("StatusNotReady", 1);
            StatusNotReady = r101;
            Status r102 = new Status("StatusReady", 2);
            StatusReady = r102;
            Status r103 = new Status("StatusRejected", 3);
            StatusRejected = r103;
            $VALUES = new Status[]{r100, r101, r102, r103};
        }

        public static Status valueOf(String r100) {
            return (Status) a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        private Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public BattlePrecisionMatcher() {
    }

    public final Room getRoom() {
        return this.room;
    }

    public final int getStatus() {
        return this.status;
    }

    public final List<BattleRivalTag> getTagList() {
        return this.tagList;
    }

    public final String getUserId() {
        return this.userId;
    }

    public BattlePrecisionMatcher(g r100) {
        this.tagList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 2) goto L8;
        this.room = new Room(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.status = r100.i();
        goto L3
    L10:
        if (r102 != 4) goto L12;
        this.tagList.add(new BattleRivalTag(r100));
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.userId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setRoom(Room r100) {
        this.room = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTagList(List<BattleRivalTag> r100) {
        this.tagList = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
