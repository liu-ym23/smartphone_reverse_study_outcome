package com.bytedance.android.gamecp.business;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GameAnnouncement")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/i;", "", "", "title", "Ljava/lang/String;", "", ReportConstant.COMMON_ACTION_TYPE, "Ljava/lang/Integer;", "announcementType", "content", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i implements vh7.h {

    @SerializedName("action_type")
    public Integer actionType;

    @SerializedName("announcement_type")
    public Integer announcementType;

    @SerializedName("jump_content")
    public String content;

    @SerializedName("title")
    public String title;

    public i() {
        this.title = "";
        this.actionType = 0;
        this.announcementType = 0;
        this.content = "";
    }

    public i(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.title = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.actionType = Integer.valueOf(r100.i());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.announcementType = Integer.valueOf(r100.i());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.content = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.title != null) goto L22;
        this.title = "";
    L22:
        if (this.actionType != null) goto L25;
        this.actionType = 0;
    L25:
        if (this.announcementType != null) goto L28;
        this.announcementType = 0;
    L28:
        if (this.content != null) goto L46;
        this.content = "";
        return;
    }
}
