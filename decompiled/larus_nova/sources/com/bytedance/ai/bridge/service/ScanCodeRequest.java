package com.bytedance.ai.bridge.service;

import e3.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/service/ScanCodeRequest;", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "bridgeName", "", "onlyFromCamera", "", "scanType", "", "<init>", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)V", "getBridgeContext", "()Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "getBridgeName", "()Ljava/lang/String;", "getOnlyFromCamera", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScanType", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;)Lcom/bytedance/ai/bridge/service/ScanCodeRequest;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCodeRequest {
    private final d bridgeContext;
    private final String bridgeName;
    private final Boolean onlyFromCamera;
    private final List<String> scanType;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanCodeRequest copy$default(ScanCodeRequest r100, d r101, String r102, Boolean r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.bridgeContext;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.bridgeName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.onlyFromCamera;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.scanType;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final d component1() {
        return this.bridgeContext;
    }

    public final String component2() {
        return this.bridgeName;
    }

    public final Boolean component3() {
        return this.onlyFromCamera;
    }

    public final List<String> component4() {
        return this.scanType;
    }

    public final ScanCodeRequest copy(d r100, String r101, Boolean r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "scanType");
        return new ScanCodeRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScanCodeRequest) == true) goto L8;
        return false;
    L8:
        ScanCodeRequest r101 = (ScanCodeRequest) r100;
        if (Intrinsics.areEqual(this.bridgeContext, r101.bridgeContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bridgeName, r101.bridgeName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.onlyFromCamera, r101.onlyFromCamera) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.scanType, r101.scanType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.bridgeContext.hashCode() * 31) + this.bridgeName.hashCode()) * 31;
        Boolean r101 = this.onlyFromCamera;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.scanType.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "ScanCodeRequest(bridgeContext=" + this.bridgeContext + ", bridgeName=" + this.bridgeName + ", onlyFromCamera=" + this.onlyFromCamera + ", scanType=" + this.scanType + ')';
    }

    public final d getBridgeContext() {
        return this.bridgeContext;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final Boolean getOnlyFromCamera() {
        return this.onlyFromCamera;
    }

    public final List<String> getScanType() {
        return this.scanType;
    }

    public ScanCodeRequest(d r100, String r101, Boolean r102, List<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "scanType");
        this.bridgeContext = r100;
        this.bridgeName = r101;
        this.onlyFromCamera = r102;
        this.scanType = r103;
    }
}
