package com.bytedance.android.gamecp.business.floatwindow.installguide;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetFloatWindowInstallGuideResponse.InstallAuthGuide")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/gamecp/business/floatwindow/installguide/d;", "", "", "type", "Ljava/lang/Integer;", "", "title", "Ljava/lang/String;", "content", "buttonTxt", "buttonIcon", "guideImg", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements vh7.h {

    @SerializedName("button_icon")
    public String buttonIcon;

    @SerializedName("button_txt")
    public String buttonTxt;

    @SerializedName("content")
    public String content;

    @SerializedName("guide_img")
    public String guideImg;

    @SerializedName("title")
    public String title;

    @SerializedName("type")
    public Integer type;

    public d() {
        this.type = 0;
        this.title = "";
        this.content = "";
        this.buttonTxt = "";
        this.buttonIcon = "";
        this.guideImg = "";
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.guideImg = am3.h.c(r100);
        goto L3
    L8:
        this.buttonIcon = am3.h.c(r100);
        goto L3
    L9:
        this.buttonTxt = am3.h.c(r100);
        goto L3
    L10:
        this.content = am3.h.c(r100);
        goto L3
    L11:
        this.title = am3.h.c(r100);
        goto L3
    L12:
        this.type = Integer.valueOf(r100.i());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.type != null) goto L17;
        this.type = 0;
    L17:
        if (this.title != null) goto L20;
        this.title = "";
    L20:
        if (this.content != null) goto L23;
        this.content = "";
    L23:
        if (this.buttonTxt != null) goto L26;
        this.buttonTxt = "";
    L26:
        if (this.buttonIcon != null) goto L29;
        this.buttonIcon = "";
    L29:
        if (this.guideImg != null) goto L48;
        this.guideImg = "";
        return;
    }
}
