package com.bytedance.ai.resource.core.bean;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\nHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoRequest;", "", "deviceId", "", "mode", "scanTargets", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformScanTarget;", EffectConfiguration.KEY_CURSOR, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "getDeviceId", "()Ljava/lang/String;", "getMode", "getScanTargets", "()Ljava/util/List;", "getCursor", "getLimit", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfoRequest {
    private final String cursor;

    @SerializedName("device_id")
    private final String deviceId;
    private final int limit;
    private final String mode;

    @SerializedName("scan_targets")
    private final List<OpenPlatformScanTarget> scanTargets;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfoRequest copy$default(OpenPlatformPreviewAppInfoRequest r100, String r101, String r102, List r103, String r104, int r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.deviceId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.mode;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.scanTargets;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.cursor;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.limit;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.deviceId;
    }

    public final String component2() {
        return this.mode;
    }

    public final List<OpenPlatformScanTarget> component3() {
        return this.scanTargets;
    }

    public final String component4() {
        return this.cursor;
    }

    public final int component5() {
        return this.limit;
    }

    public final OpenPlatformPreviewAppInfoRequest copy(String r100, String r101, List<OpenPlatformScanTarget> r110, String r111, int r112) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r110, "scanTargets");
        return new OpenPlatformPreviewAppInfoRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewAppInfoRequest) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfoRequest r101 = (OpenPlatformPreviewAppInfoRequest) r100;
        if (Intrinsics.areEqual(this.deviceId, r101.deviceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.mode, r101.mode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.scanTargets, r101.scanTargets) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cursor, r101.cursor) == true) goto L21;
        return false;
    L21:
        if (this.limit == r101.limit) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.deviceId.hashCode() * 31) + this.mode.hashCode()) * 31) + this.scanTargets.hashCode()) * 31;
        String r101 = this.cursor;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.limit;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "OpenPlatformPreviewAppInfoRequest(deviceId=" + this.deviceId + ", mode=" + this.mode + ", scanTargets=" + this.scanTargets + ", cursor=" + this.cursor + ", limit=" + this.limit + ')';
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final int getLimit() {
        return this.limit;
    }

    public final String getMode() {
        return this.mode;
    }

    public final List<OpenPlatformScanTarget> getScanTargets() {
        return this.scanTargets;
    }

    public OpenPlatformPreviewAppInfoRequest(String r100, String r101, List<OpenPlatformScanTarget> r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "deviceId");
        Intrinsics.checkNotNullParameter(r101, "mode");
        Intrinsics.checkNotNullParameter(r102, "scanTargets");
        this.deviceId = r100;
        this.mode = r101;
        this.scanTargets = r102;
        this.cursor = r103;
        this.limit = r104;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfoRequest(String r100, String r101, List r102, String r110, int r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        r102 = CollectionsKt.emptyList();
    L5:
        List r103 = r102;
        if ((r112 & 8) == 0) goto L8;
        r110 = null;
    L8:
        String r104 = r110;
        if ((r112 & 16) == 0) goto L11;
        int r105 = 20;
    L12:
        this(r100, r101, r103, r104, r105);
        return;
    L11:
        r105 = r111;
        goto L12
    }
}
