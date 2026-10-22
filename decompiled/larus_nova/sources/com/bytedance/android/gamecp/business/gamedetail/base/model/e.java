package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/e;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", "dataChannelConfigStruct", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/k;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/l;", "structureConfig", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/l;", "c", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/l;", "", "teamPlayStatus", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "interactionPlayStatus", "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("data_channel_config_struct")
    private final k dataChannelConfigStruct;

    @SerializedName("interaction_play_status")
    private final Boolean interactionPlayStatus;

    @SerializedName("structure_config")
    private final l structureConfig;

    @SerializedName("team_play_status")
    private final Boolean teamPlayStatus;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.dataChannelConfigStruct, r101.dataChannelConfigStruct) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.structureConfig, r101.structureConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.teamPlayStatus, r101.teamPlayStatus) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.interactionPlayStatus, r101.interactionPlayStatus) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        k r100 = this.dataChannelConfigStruct;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        l r104 = this.structureConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.teamPlayStatus;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.interactionPlayStatus;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonMetaData(dataChannelConfigStruct=" + this.dataChannelConfigStruct + ", structureConfig=" + this.structureConfig + ", teamPlayStatus=" + this.teamPlayStatus + ", interactionPlayStatus=" + this.interactionPlayStatus + ")";
    }

    public e() {
        this.dataChannelConfigStruct = null;
        this.structureConfig = null;
        this.teamPlayStatus = null;
        this.interactionPlayStatus = null;
    }

    public final k a() {
        return this.dataChannelConfigStruct;
    }

    public final Boolean b() {
        return this.interactionPlayStatus;
    }

    public final l c() {
        return this.structureConfig;
    }

    public final Boolean d() {
        return this.teamPlayStatus;
    }
}
