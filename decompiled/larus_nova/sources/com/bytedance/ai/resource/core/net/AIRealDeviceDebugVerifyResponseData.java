package com.bytedance.ai.resource.core.net;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J0\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/resource/core/net/AIRealDeviceDebugVerifyResponseData;", "", "allowed", "", "reason", "", "debugContext", "", "<init>", "(ZLjava/lang/Integer;Ljava/lang/String;)V", "getAllowed", "()Z", "getReason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDebugContext", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ZLjava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ai/resource/core/net/AIRealDeviceDebugVerifyResponseData;", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIRealDeviceDebugVerifyResponseData {
    private final boolean allowed;

    @SerializedName("debug_context")
    private final String debugContext;
    private final Integer reason;

    public AIRealDeviceDebugVerifyResponseData() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ AIRealDeviceDebugVerifyResponseData copy$default(AIRealDeviceDebugVerifyResponseData r100, boolean r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.allowed;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.reason;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.debugContext;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.allowed;
    }

    public final Integer component2() {
        return this.reason;
    }

    public final String component3() {
        return this.debugContext;
    }

    public final AIRealDeviceDebugVerifyResponseData copy(boolean r100, Integer r101, String r102) {
        return new AIRealDeviceDebugVerifyResponseData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIRealDeviceDebugVerifyResponseData) == true) goto L8;
        return false;
    L8:
        AIRealDeviceDebugVerifyResponseData r101 = (AIRealDeviceDebugVerifyResponseData) r100;
        if (this.allowed == r101.allowed) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reason, r101.reason) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.debugContext, r101.debugContext) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.allowed == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        Integer r102 = this.reason;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.debugContext;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "AIRealDeviceDebugVerifyResponseData(allowed=" + this.allowed + ", reason=" + this.reason + ", debugContext=" + this.debugContext + ')';
    }

    public final boolean getAllowed() {
        return this.allowed;
    }

    public final String getDebugContext() {
        return this.debugContext;
    }

    public final Integer getReason() {
        return this.reason;
    }

    public AIRealDeviceDebugVerifyResponseData(boolean r100, Integer r101, String r102) {
        this.allowed = r100;
        this.reason = r101;
        this.debugContext = r102;
    }

    public /* synthetic */ AIRealDeviceDebugVerifyResponseData(boolean r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
