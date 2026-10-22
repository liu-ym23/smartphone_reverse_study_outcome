package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.MatchLive")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/MatchLive;", "", "()V", "ag_live_status", "", "getAg_live_status", "()I", "setAg_live_status", "(I)V", "appointment_id", "", "getAppointment_id", "()Ljava/lang/String;", "setAppointment_id", "(Ljava/lang/String;)V", VSConstants.VS_CAMERA_ID, "getCamera_id", "setCamera_id", "has_subscribe", "", "getHas_subscribe", "()Z", "setHas_subscribe", "(Z)V", "room_id", "getRoom_id", "setRoom_id", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchLive implements h {

    @SerializedName("ag_live_status")
    protected int ag_live_status;

    @SerializedName("appointment_id")
    protected String appointment_id;

    @SerializedName(VSConstants.VS_CAMERA_ID)
    protected String camera_id;

    @SerializedName("has_subscribe")
    protected boolean has_subscribe;

    @SerializedName("room_id")
    protected String room_id;

    public MatchLive() {
    }

    public final int getAg_live_status() {
        return this.ag_live_status;
    }

    public final String getAppointment_id() {
        return this.appointment_id;
    }

    public final String getCamera_id() {
        return this.camera_id;
    }

    public final boolean getHas_subscribe() {
        return this.has_subscribe;
    }

    public final String getRoom_id() {
        return this.room_id;
    }

    public MatchLive(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.ag_live_status = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.appointment_id = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.room_id = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.has_subscribe = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.camera_id = am3.h.c(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setAg_live_status(int r100) {
        this.ag_live_status = r100;
    }

    public final void setAppointment_id(String r100) {
        this.appointment_id = r100;
    }

    public final void setCamera_id(String r100) {
        this.camera_id = r100;
    }

    public final void setHas_subscribe(boolean r100) {
        this.has_subscribe = r100;
    }

    public final void setRoom_id(String r100) {
        this.room_id = r100;
    }
}
