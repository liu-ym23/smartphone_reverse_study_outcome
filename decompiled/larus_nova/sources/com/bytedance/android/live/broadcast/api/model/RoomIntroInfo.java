package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.room.CreateInfoResponse.RoomIntroInfo")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/RoomIntroInfo;", "", "", "toString", "", "isNewRoomIntroOn", "", "setRoomIntroState", "", "introSwitch", "I", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomIntroInfo implements vh7.h {
    public static final a Companion = null;
    public static final int ROOM_INTRO_OFF = 2;
    public static final int ROOM_INTRO_ON = 1;

    @SerializedName("intro_switch")
    public int introSwitch;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public RoomIntroInfo() {
    }

    public String toString() {
        return "RoomIntroInfo(introSwitch=" + this.introSwitch + ')';
    }

    public RoomIntroInfo(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.introSwitch = r100.i();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final void setRoomIntroState(boolean r100) {
        if (r100 == false) goto L4;
        this.introSwitch = 1;
        return;
    L4:
        this.introSwitch = 2;
    }
}
