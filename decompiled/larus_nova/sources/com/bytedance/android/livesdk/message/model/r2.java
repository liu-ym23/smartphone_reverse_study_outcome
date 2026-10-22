package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ChorusLeaderSettingContent")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/r2;", "", "", "leadChorusSwitch", "I", "getLeadChorusSwitch", "()I", "setLeadChorusSwitch", "(I)V", "", "", "assignUserIds", "Ljava/util/List;", "getAssignUserIds", "()Ljava/util/List;", "setAssignUserIds", "(Ljava/util/List;)V", "", "assignOpenUserIds", "getAssignOpenUserIds", "setAssignOpenUserIds", "<init>", "()V", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r2 implements vh7.h {

    @SerializedName("assign_open_user_ids")
    protected List<String> assignOpenUserIds;

    @SerializedName("assign_user_ids")
    protected List<Long> assignUserIds;

    @SerializedName("lead_chorus_switch")
    protected int leadChorusSwitch;

    public r2() {
        this.leadChorusSwitch = LeadChorusSetting.Close.getValue();
        this.assignUserIds = new ArrayList();
        this.assignOpenUserIds = new ArrayList();
    }

    public r2(am3.g r100) {
        this.assignUserIds = new ArrayList();
        this.assignOpenUserIds = new ArrayList();
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        if (r103 != 1) goto L7;
        this.leadChorusSwitch = r100.i();
        r102 = r102 | true;
        goto L3
    L7:
        if (r103 == 2) goto L12;
        if (r103 != 5000) goto L10;
        List r104 = this.assignOpenUserIds;
        Comparable r105 = am3.h.c(r100);
    L13:
        r104.add(r105);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L12:
        r104 = this.assignUserIds;
        r105 = Long.valueOf(r100.j());
        goto L13
    L15:
        r100.d(r101);
        if ((r102 & true) == true) goto L19;
        this.leadChorusSwitch = LeadChorusSetting.Close.getValue();
    L19:
        if (this.assignUserIds.isEmpty() == false) goto L22;
        this.assignUserIds = new ArrayList();
    L22:
        if (this.assignOpenUserIds.isEmpty() == false) goto L35;
        this.assignOpenUserIds = new ArrayList();
        return;
    }
}
