package com.bytedance.ai.bridge.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/service/ChooseImageFileResult;", "", "path", "", "size", "", "type", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getPath", "()Ljava/lang/String;", "getSize", "()J", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChooseImageFileResult {
    private final String path;
    private final long size;
    private final String type;

    public static /* synthetic */ ChooseImageFileResult copy$default(ChooseImageFileResult r100, String r101, long r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.path;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.size;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.type;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.path;
    }

    public final long component2() {
        return this.size;
    }

    public final String component3() {
        return this.type;
    }

    public final ChooseImageFileResult copy(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return new ChooseImageFileResult(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChooseImageFileResult) == true) goto L8;
        return false;
    L8:
        ChooseImageFileResult r101 = (ChooseImageFileResult) r100;
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L12;
        return false;
    L12:
        if (this.size == r101.size) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.path.hashCode() * 31;
        long r101 = this.size;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        String r103 = this.type;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public String toString() {
        return "ChooseImageFileResult(path=" + this.path + ", size=" + this.size + ", type=" + this.type + ')';
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final String getType() {
        return this.type;
    }

    public ChooseImageFileResult(String r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.path = r100;
        this.size = r101;
        this.type = r102;
    }

    public /* synthetic */ ChooseImageFileResult(String r100, long r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
