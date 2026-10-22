package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.StarProfile")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/StarProfile;", "", "()V", "avatarUrl", "Lcom/bytedance/android/livesdkapi/depend/message/Avatar;", "cardId", "", "color", "", "Ljava/lang/Integer;", "description", "followCount", "", "nickName", "reservationId", "roomId", DyPayConstant.KEY_START_TIME, "status", "uid", "StarProfileStatus", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StarProfile implements h {
    public static final StarProfileStatus StarProfileStatus = null;
    public static final int StarProfileStatusFollowing = 1;
    public static final int StarProfileStatusLiving = 2;
    public static final int StarProfileStatusReservation = 3;
    public static final int StarProfileStatusUnKnown = 0;

    @SerializedName("avatar_url")
    public Avatar avatarUrl;

    @SerializedName("card_id")
    public String cardId;

    @SerializedName("color")
    public Integer color;

    @SerializedName("description")
    public String description;

    @SerializedName("follow_count")
    public long followCount;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("reservation_id")
    public String reservationId;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("status")
    public int status;

    @SerializedName("uid")
    public String uid;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/StarProfile$StarProfileStatus;", "", "()V", "StarProfileStatusFollowing", "", "StarProfileStatusLiving", "StarProfileStatusReservation", "StarProfileStatusUnKnown", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class StarProfileStatus {
        private StarProfileStatus() {
        }

        public /* synthetic */ StarProfileStatus(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        StarProfileStatus = new StarProfileStatus(null);
    }

    public StarProfile() {
    }

    public StarProfile(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L6;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            default: goto L6;
        };
    L7:
        this.color = Integer.valueOf(r100.i());
        goto L3
    L8:
        this.followCount = r100.j();
        goto L3
    L9:
        this.cardId = am3.h.c(r100);
        goto L3
    L10:
        this.reservationId = am3.h.c(r100);
        goto L3
    L11:
        this.startTime = r100.j();
        goto L3
    L12:
        this.uid = am3.h.c(r100);
        goto L3
    L13:
        this.roomId = am3.h.c(r100);
        goto L3
    L14:
        this.description = am3.h.c(r100);
        goto L3
    L15:
        this.nickName = am3.h.c(r100);
        goto L3
    L16:
        this.avatarUrl = new Avatar(r100);
        goto L3
    L17:
        this.status = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
