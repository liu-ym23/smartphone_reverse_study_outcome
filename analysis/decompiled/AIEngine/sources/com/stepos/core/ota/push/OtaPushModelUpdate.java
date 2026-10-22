package com.stepos.core.ota.push;

import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushModelUpdate {
    private final boolean forceUpdate;
    private final String md5Log;
    private final String modelId;
    private final Long size;
    private final String taskId;
    private final String versionCode;

    public OtaPushModelUpdate(String modelId, String str, Long l10, String str2, String str3, boolean z) {
        g.f(modelId, "modelId");
        this.modelId = modelId;
        this.versionCode = str;
        this.size = l10;
        this.taskId = str2;
        this.md5Log = str3;
        this.forceUpdate = z;
    }

    public static /* synthetic */ OtaPushModelUpdate copy$default(OtaPushModelUpdate otaPushModelUpdate, String str, String str2, Long l10, String str3, String str4, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = otaPushModelUpdate.modelId;
        }
        if ((i10 & 2) != 0) {
            str2 = otaPushModelUpdate.versionCode;
        }
        if ((i10 & 4) != 0) {
            l10 = otaPushModelUpdate.size;
        }
        if ((i10 & 8) != 0) {
            str3 = otaPushModelUpdate.taskId;
        }
        if ((i10 & 16) != 0) {
            str4 = otaPushModelUpdate.md5Log;
        }
        if ((i10 & 32) != 0) {
            z = otaPushModelUpdate.forceUpdate;
        }
        String str5 = str4;
        boolean z3 = z;
        return otaPushModelUpdate.copy(str, str2, l10, str3, str5, z3);
    }

    public final String component1() {
        return this.modelId;
    }

    public final String component2() {
        return this.versionCode;
    }

    public final Long component3() {
        return this.size;
    }

    public final String component4() {
        return this.taskId;
    }

    public final String component5() {
        return this.md5Log;
    }

    public final boolean component6() {
        return this.forceUpdate;
    }

    public final OtaPushModelUpdate copy(String modelId, String str, Long l10, String str2, String str3, boolean z) {
        g.f(modelId, "modelId");
        return new OtaPushModelUpdate(modelId, str, l10, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtaPushModelUpdate)) {
            return false;
        }
        OtaPushModelUpdate otaPushModelUpdate = (OtaPushModelUpdate) obj;
        return g.b(this.modelId, otaPushModelUpdate.modelId) && g.b(this.versionCode, otaPushModelUpdate.versionCode) && g.b(this.size, otaPushModelUpdate.size) && g.b(this.taskId, otaPushModelUpdate.taskId) && g.b(this.md5Log, otaPushModelUpdate.md5Log) && this.forceUpdate == otaPushModelUpdate.forceUpdate;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final String getMd5Log() {
        return this.md5Log;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        int iHashCode = this.modelId.hashCode() * 31;
        String str = this.versionCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode3 = (iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str2 = this.taskId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.md5Log;
        return Boolean.hashCode(this.forceUpdate) + ((iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String summary() {
        String str = this.modelId;
        String str2 = this.versionCode;
        Long l10 = this.size;
        String str3 = this.taskId;
        boolean z = this.forceUpdate;
        String str4 = this.md5Log;
        StringBuilder sbS = ai.onnxruntime.a.s("modelId=", str, " versionCode=", str2, " size=");
        sbS.append(l10);
        sbS.append(" taskId=");
        sbS.append(str3);
        sbS.append(" force=");
        sbS.append(z);
        sbS.append(" md5=");
        sbS.append(str4);
        return sbS.toString();
    }

    public String toString() {
        String str = this.modelId;
        String str2 = this.versionCode;
        Long l10 = this.size;
        String str3 = this.taskId;
        String str4 = this.md5Log;
        boolean z = this.forceUpdate;
        StringBuilder sbS = ai.onnxruntime.a.s("OtaPushModelUpdate(modelId=", str, ", versionCode=", str2, ", size=");
        sbS.append(l10);
        sbS.append(", taskId=");
        sbS.append(str3);
        sbS.append(", md5Log=");
        sbS.append(str4);
        sbS.append(", forceUpdate=");
        sbS.append(z);
        sbS.append(")");
        return sbS.toString();
    }

    public /* synthetic */ OtaPushModelUpdate(String str, String str2, Long l10, String str3, String str4, boolean z, int i10, e eVar) {
        this(str, str2, l10, str3, str4, (i10 & 32) != 0 ? false : z);
    }
}
