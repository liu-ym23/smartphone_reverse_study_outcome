package com.bytedance.android.gamecp.business.floatwindow.installguide;

import com.bytedance.android.gamecp.business.download.custommade.BeforeInstallGuide;
import com.bytedance.android.gamecp.business.download.custommade.bean.InInstallGuide;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetFloatWindowInstallGuideResponse.Data")
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/floatwindow/installguide/a;", "", "", "Lcom/bytedance/android/gamecp/business/floatwindow/installguide/n;", "stepList", "Ljava/util/List;", "", "isShowFloatWindow", "Ljava/lang/Boolean;", "", "Lcom/bytedance/android/gamecp/business/floatwindow/installguide/d;", "installAuthGuides", "hasGift", "Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;", "beforeInstallGuide", "Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;", "Lcom/bytedance/android/gamecp/business/download/custommade/bean/InInstallGuide;", "inInstallGuide", "Lcom/bytedance/android/gamecp/business/download/custommade/bean/InInstallGuide;", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("before_install_guide")
    public BeforeInstallGuide beforeInstallGuide;

    @SerializedName("has_gift")
    public Boolean hasGift;

    @SerializedName("in_install_guide")
    public InInstallGuide inInstallGuide;

    @SerializedName("install_auth_guides")
    public List<d> installAuthGuides;

    @SerializedName("show_floating_window")
    public Boolean isShowFloatWindow;

    @SerializedName("install_step_descs")
    public List<n> stepList;

    public a() {
        Boolean r100 = Boolean.FALSE;
        this.isShowFloatWindow = r100;
        this.hasGift = r100;
    }

    public a(am3.g r100) {
        this.stepList = new ArrayList();
        this.installAuthGuides = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
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
        this.beforeInstallGuide = new BeforeInstallGuide(r100);
        goto L3
    L8:
        this.inInstallGuide = new InInstallGuide(r100);
        goto L3
    L9:
        this.hasGift = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L10:
        List r103 = this.installAuthGuides;
        vh7.h r104 = new d(r100);
    L13:
        r103.add(r104);
        goto L3
    L11:
        this.isShowFloatWindow = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        r103 = this.stepList;
        r104 = new n(r100);
        goto L13
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if (this.isShowFloatWindow != null) goto L18;
        this.isShowFloatWindow = Boolean.FALSE;
    L18:
        if (this.hasGift != null) goto L36;
        this.hasGift = Boolean.FALSE;
        return;
    }
}
