package com.bytedance.ai.bridge.service;

import e3.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/service/SaveImageToPhotosAlbumRequest;", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "bridgeName", "", "filePath", "<init>", "(Lcom/bytedance/ai/bridge/context/IAIBridgeContext;Ljava/lang/String;Ljava/lang/String;)V", "getBridgeContext", "()Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "getBridgeName", "()Ljava/lang/String;", "getFilePath", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SaveImageToPhotosAlbumRequest {
    private final d bridgeContext;
    private final String bridgeName;
    private final String filePath;

    public static /* synthetic */ SaveImageToPhotosAlbumRequest copy$default(SaveImageToPhotosAlbumRequest r100, d r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bridgeContext;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.bridgeName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.filePath;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final d component1() {
        return this.bridgeContext;
    }

    public final String component2() {
        return this.bridgeName;
    }

    public final String component3() {
        return this.filePath;
    }

    public final SaveImageToPhotosAlbumRequest copy(d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        return new SaveImageToPhotosAlbumRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SaveImageToPhotosAlbumRequest) == true) goto L8;
        return false;
    L8:
        SaveImageToPhotosAlbumRequest r101 = (SaveImageToPhotosAlbumRequest) r100;
        if (Intrinsics.areEqual(this.bridgeContext, r101.bridgeContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bridgeName, r101.bridgeName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.bridgeContext.hashCode() * 31) + this.bridgeName.hashCode()) * 31) + this.filePath.hashCode();
    }

    public String toString() {
        return "SaveImageToPhotosAlbumRequest(bridgeContext=" + this.bridgeContext + ", bridgeName=" + this.bridgeName + ", filePath=" + this.filePath + ')';
    }

    public final d getBridgeContext() {
        return this.bridgeContext;
    }

    public final String getBridgeName() {
        return this.bridgeName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public SaveImageToPhotosAlbumRequest(d r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "bridgeName");
        Intrinsics.checkNotNullParameter(r102, "filePath");
        this.bridgeContext = r100;
        this.bridgeName = r101;
        this.filePath = r102;
    }
}
