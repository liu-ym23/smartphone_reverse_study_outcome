package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PurePreviewData;", "", "streamUrl", "", "roomId", "ownerUserId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getOwnerUserId", "()Ljava/lang/String;", "getRoomId", "getStreamUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PurePreviewData {
    private final String ownerUserId;
    private final String roomId;
    private final String streamUrl;

    public static /* synthetic */ PurePreviewData copy$default(PurePreviewData r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.streamUrl;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.roomId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.ownerUserId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.streamUrl;
    }

    public final String component2() {
        return this.roomId;
    }

    public final String component3() {
        return this.ownerUserId;
    }

    public final PurePreviewData copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "streamUrl");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "ownerUserId");
        return new PurePreviewData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PurePreviewData) == false) goto L12;
        PurePreviewData r101 = (PurePreviewData) r100;
        if (Intrinsics.areEqual(this.streamUrl, r101.streamUrl) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.ownerUserId, r101.ownerUserId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.streamUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.roomId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ownerUserId;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PurePreviewData(streamUrl=" + this.streamUrl + ", roomId=" + this.roomId + ", ownerUserId=" + this.ownerUserId + ")";
    }

    public final String getOwnerUserId() {
        return this.ownerUserId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public PurePreviewData(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "streamUrl");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "ownerUserId");
        this.streamUrl = r100;
        this.roomId = r101;
        this.ownerUserId = r102;
    }
}
