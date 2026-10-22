package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.LinkerResumeApplyContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkerResumeApplyContent;", "", "()V", "applyOpenUser", "", "getApplyOpenUser", "()Ljava/lang/String;", "applyUser", "", "getApplyUser", "()Ljava/lang/Long;", "setApplyUser", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "param", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ApplyParam;", "getParam", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ApplyParam;", "setParam", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ApplyParam;)V", "roomId", "getRoomId", "setRoomId", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerResumeApplyContent implements h {

    @SerializedName("apply_open_user")
    protected String applyOpenUser;

    @SerializedName("apply_user")
    protected Long applyUser;

    @SerializedName("param")
    protected ApplyParam param;

    @SerializedName("room_id")
    protected Long roomId;

    public LinkerResumeApplyContent() {
        this.applyUser = 0L;
        this.roomId = 0L;
        this.applyOpenUser = "";
    }

    public final String getApplyOpenUser() {
        return this.applyOpenUser;
    }

    public final Long getApplyUser() {
        return this.applyUser;
    }

    public final ApplyParam getParam() {
        return this.param;
    }

    public final Long getRoomId() {
        return this.roomId;
    }

    public LinkerResumeApplyContent(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.param = new ApplyParam(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.applyUser = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.roomId = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.applyOpenUser = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.applyUser != null) goto L22;
        this.applyUser = 0L;
    L22:
        if (this.roomId != null) goto L25;
        this.roomId = 0L;
    L25:
        if (this.applyOpenUser != null) goto L43;
        this.applyOpenUser = "";
        return;
    }

    public final void setApplyUser(Long r100) {
        this.applyUser = r100;
    }

    public final void setParam(ApplyParam r100) {
        this.param = r100;
    }

    public final void setRoomId(Long r100) {
        this.roomId = r100;
    }
}
