package com.bytedance.android.gamecp.host_api.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/c;", "", "", "os", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "harmonyVersion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "isPureModeOpen", "Z", "d", "()Z", "isPureEnhancedModeOpen", "c", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("harmony_ver")
    private final String harmonyVersion;

    @SerializedName(EventConstants.ExtraJson.KEY_ENHANCED_PURE_MODE)
    private final boolean isPureEnhancedModeOpen;

    @SerializedName(EventConstants.ExtraJson.KEY_PURE_MODE)
    private final boolean isPureModeOpen;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @SerializedName("os")
    private final String f57369os;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f57369os, r101.f57369os) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.harmonyVersion, r101.harmonyVersion) == true) goto L10;
        return false;
    L10:
        if (this.isPureModeOpen == r101.isPureModeOpen) goto L12;
        return false;
    L12:
        if (this.isPureEnhancedModeOpen == r101.isPureEnhancedModeOpen) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r100 = this.f57369os;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.harmonyVersion;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.isPureModeOpen;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (r105 + r108) * 31;
        boolean r110 = this.isPureEnhancedModeOpen;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HijackDeviceInfo(os=" + this.f57369os + ", harmonyVersion=" + this.harmonyVersion + ", isPureModeOpen=" + this.isPureModeOpen + ", isPureEnhancedModeOpen=" + this.isPureEnhancedModeOpen + ")";
    }

    public final String a() {
        return this.harmonyVersion;
    }

    public final String b() {
        return this.f57369os;
    }

    public final boolean c() {
        return this.isPureEnhancedModeOpen;
    }

    public final boolean d() {
        return this.isPureModeOpen;
    }

    public c(String r100, String r101, boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "os");
        this.f57369os = r100;
        this.harmonyVersion = r101;
        this.isPureModeOpen = r102;
        this.isPureEnhancedModeOpen = r103;
    }
}
