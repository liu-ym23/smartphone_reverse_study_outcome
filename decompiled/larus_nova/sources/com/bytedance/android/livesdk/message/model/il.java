package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.LinkmicChorusUserListChangedContent.SimpleLinkmicChorusUser")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/il;", "", "", "userId", "Ljava/lang/String;", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "interactId", "getInteractId", "setInteractId", "", "chorusUserType", "I", "getChorusUserType", "()I", "setChorusUserType", "(I)V", "openUserId", "getOpenUserId", "setOpenUserId", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class il implements vh7.h {

    @SerializedName("chorus_user_type")
    protected int chorusUserType;

    @SerializedName("linkmic_id")
    protected String interactId;

    @SerializedName("open_user_id")
    protected String openUserId;

    @SerializedName("user_id")
    protected String userId;

    public il() {
        this.userId = "";
        this.interactId = "";
        this.openUserId = "";
    }

    public il(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.userId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.interactId = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.chorusUserType = r100.i();
        goto L3
    L12:
        if (r102 != 5000) goto L13;
        this.openUserId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.userId != null) goto L22;
        this.userId = "";
    L22:
        if (this.interactId != null) goto L25;
        this.interactId = "";
    L25:
        if (this.openUserId != null) goto L43;
        this.openUserId = "";
        return;
    }
}
