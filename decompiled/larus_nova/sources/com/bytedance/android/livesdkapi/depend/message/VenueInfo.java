package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.VenueInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/VenueInfo;", "", "()V", "currentTime", "", "distributeTime", "pollingInterval", "roomId", "", "stage", "", "targetTime", UserInfo.UPDATE_TIME, "Stage", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VenueInfo implements h {
    public static final Stage Stage = null;
    public static final int StageOutBreak = 2;
    public static final int StagePreHeating = 1;
    public static final int StageUnknown = 0;
    public static final int StageWastHeat = 3;

    @SerializedName("current_time")
    public long currentTime;

    @SerializedName("distribute_time")
    public long distributeTime;

    @SerializedName("polling_interval")
    public long pollingInterval;

    @SerializedName("room_id")
    public String roomId;

    @SerializedName("stage")
    public int stage;

    @SerializedName("target_time")
    public long targetTime;

    @SerializedName("update_time")
    public long updateTime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/VenueInfo$Stage;", "", "()V", "StageOutBreak", "", "StagePreHeating", "StageUnknown", "StageWastHeat", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Stage {
        private Stage() {
        }

        public /* synthetic */ Stage(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Stage = new Stage(null);
    }

    public VenueInfo() {
    }

    public VenueInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.distributeTime = r100.j();
        goto L3
    L8:
        this.updateTime = r100.j();
        goto L3
    L9:
        this.pollingInterval = r100.j();
        goto L3
    L10:
        this.roomId = am3.h.c(r100);
        goto L3
    L11:
        this.currentTime = r100.j();
        goto L3
    L12:
        this.targetTime = r100.j();
        goto L3
    L13:
        this.stage = r100.i();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
    }
}
