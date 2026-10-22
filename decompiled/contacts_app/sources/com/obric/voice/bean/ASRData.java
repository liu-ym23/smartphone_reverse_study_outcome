package com.obric.voice.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ASRData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/obric/voice/bean/ASRData;", "", "taskId", "", "offsetInBytes", "", "sizeInBytes", "writeEnd", "", "(Ljava/lang/String;IIZ)V", "getOffsetInBytes", "()I", "getSizeInBytes", "getTaskId", "()Ljava/lang/String;", "getWriteEnd", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ASRData {

    @SerializedName("offsetInBytes")
    private final int offsetInBytes;

    @SerializedName("sizeInBytes")
    private final int sizeInBytes;

    @SerializedName("taskId")
    private final String taskId;

    @SerializedName("writeEnd")
    private final boolean writeEnd;

    public ASRData() {
        this(null, 0, 0, false, 15, null);
    }

    public static /* synthetic */ ASRData copy$default(ASRData r0, String r1, int r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.taskId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.offsetInBytes;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sizeInBytes;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.writeEnd;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.taskId;
    }

    public final int component2() {
        return this.offsetInBytes;
    }

    public final int component3() {
        return this.sizeInBytes;
    }

    public final boolean component4() {
        return this.writeEnd;
    }

    public final ASRData copy(String r1, int r2, int r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "taskId");
        return new ASRData(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ASRData) == true) goto L8;
        return false;
    L8:
        ASRData r6 = (ASRData) r5;
        if (Intrinsics.areEqual(this.taskId, r6.taskId) == true) goto L12;
        return false;
    L12:
        if (this.offsetInBytes == r6.offsetInBytes) goto L15;
        return false;
    L15:
        if (this.sizeInBytes == r6.sizeInBytes) goto L18;
        return false;
    L18:
        if (this.writeEnd == r6.writeEnd) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        int r0 = ((((this.taskId.hashCode() * 31) + Integer.hashCode(this.offsetInBytes)) * 31) + Integer.hashCode(this.sizeInBytes)) * 31;
        boolean r2 = this.writeEnd;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return r0 + r3;
    }

    public String toString() {
        return "ASRData(taskId=" + this.taskId + ", offsetInBytes=" + this.offsetInBytes + ", sizeInBytes=" + this.sizeInBytes + ", writeEnd=" + this.writeEnd + ')';
    }

    public ASRData(String r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "taskId");
        this.taskId = r2;
        this.offsetInBytes = r3;
        this.sizeInBytes = r4;
        this.writeEnd = r5;
    }

    public /* synthetic */ ASRData(String r2, int r3, int r4, boolean r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = false;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final int getOffsetInBytes() {
        return this.offsetInBytes;
    }

    public final int getSizeInBytes() {
        return this.sizeInBytes;
    }

    public final boolean getWriteEnd() {
        return this.writeEnd;
    }
}
