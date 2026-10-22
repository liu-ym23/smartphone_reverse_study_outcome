package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.im.LinkerChangeMultiPKTeamInfoContent")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/LinkerChangeMultiPkTabOrTeamInfoContent;", "", "()V", "multiPKModeInfo", "Lcom/bytedance/android/livesdk/chatroom/interact/model/MultiPKModeInfo;", "getMultiPKModeInfo", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/MultiPKModeInfo;", "setMultiPKModeInfo", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/MultiPKModeInfo;)V", "toast", "", "getToast", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkerChangeMultiPkTabOrTeamInfoContent implements vh7.h {

    @SerializedName("multi_pk_mode_info")
    protected MultiPKModeInfo multiPKModeInfo;

    @SerializedName("toast")
    protected String toast;

    public LinkerChangeMultiPkTabOrTeamInfoContent() {
    }

    public LinkerChangeMultiPkTabOrTeamInfoContent(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.multiPKModeInfo = new MultiPKModeInfo(r100);
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.toast = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final MultiPKModeInfo getMultiPKModeInfo() {
        return this.multiPKModeInfo;
    }

    public final String getToast() {
        return this.toast;
    }

    public final void setMultiPKModeInfo(MultiPKModeInfo r100) {
        this.multiPKModeInfo = r100;
    }

    public final void setToast(String r100) {
        this.toast = r100;
    }
}
