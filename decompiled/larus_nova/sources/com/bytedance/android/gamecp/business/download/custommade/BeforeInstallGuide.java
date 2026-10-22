package com.bytedance.android.gamecp.business.download.custommade;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.GetFloatWindowInstallGuideResponse.BeforeInstallGuide")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuide;", "Ljava/io/Serializable;", "()V", "guideDesc", "", "Lcom/bytedance/android/gamecp/business/download/custommade/BeforeInstallGuideDesc;", "packageGuideText", "", "stayDuration", "", "Ljava/lang/Integer;", "toString", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BeforeInstallGuide implements Serializable, vh7.h {

    @SerializedName("guide_desc")
    public List<BeforeInstallGuideDesc> guideDesc;

    @SerializedName("package_guide_text")
    public String packageGuideText;

    @SerializedName("stay_duration_second")
    public Integer stayDuration;

    public String toString() {
        return "BeforeInstallGuide(stayDuration = " + this.stayDuration + ",packageGuideText = " + this.packageGuideText + ", guideDesc = " + this.guideDesc + ')';
    }

    public BeforeInstallGuide() {
        this.stayDuration = 0;
        this.packageGuideText = "";
    }

    public BeforeInstallGuide(am3.g r100) {
        this.guideDesc = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.stayDuration = Integer.valueOf(r100.i());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.packageGuideText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.guideDesc.add(new BeforeInstallGuideDesc(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.stayDuration != null) goto L19;
        this.stayDuration = 0;
    L19:
        if (this.packageGuideText != null) goto L34;
        this.packageGuideText = "";
        return;
    }
}
