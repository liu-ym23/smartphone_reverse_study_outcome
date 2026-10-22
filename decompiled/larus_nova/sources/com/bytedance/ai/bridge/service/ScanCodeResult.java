package com.bytedance.ai.bridge.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/service/ScanCodeResult;", "", "characterSet", "", "path", "rawData", "result", "scanType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCharacterSet", "()Ljava/lang/String;", "getPath", "getRawData", "getResult", "getScanType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScanCodeResult {
    private final String characterSet;
    private final String path;
    private final String rawData;
    private final String result;
    private final String scanType;

    public static /* synthetic */ ScanCodeResult copy$default(ScanCodeResult r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.characterSet;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.path;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.rawData;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.result;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.scanType;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.characterSet;
    }

    public final String component2() {
        return this.path;
    }

    public final String component3() {
        return this.rawData;
    }

    public final String component4() {
        return this.result;
    }

    public final String component5() {
        return this.scanType;
    }

    public final ScanCodeResult copy(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "characterSet");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r110, "rawData");
        Intrinsics.checkNotNullParameter(r111, "result");
        Intrinsics.checkNotNullParameter(r112, "scanType");
        return new ScanCodeResult(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScanCodeResult) == true) goto L8;
        return false;
    L8:
        ScanCodeResult r101 = (ScanCodeResult) r100;
        if (Intrinsics.areEqual(this.characterSet, r101.characterSet) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.path, r101.path) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.rawData, r101.rawData) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.result, r101.result) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.scanType, r101.scanType) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.characterSet.hashCode() * 31) + this.path.hashCode()) * 31) + this.rawData.hashCode()) * 31) + this.result.hashCode()) * 31) + this.scanType.hashCode();
    }

    public String toString() {
        return "ScanCodeResult(characterSet=" + this.characterSet + ", path=" + this.path + ", rawData=" + this.rawData + ", result=" + this.result + ", scanType=" + this.scanType + ')';
    }

    public final String getCharacterSet() {
        return this.characterSet;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getRawData() {
        return this.rawData;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getScanType() {
        return this.scanType;
    }

    public ScanCodeResult(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "characterSet");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "rawData");
        Intrinsics.checkNotNullParameter(r103, "result");
        Intrinsics.checkNotNullParameter(r104, "scanType");
        this.characterSet = r100;
        this.path = r101;
        this.rawData = r102;
        this.result = r103;
        this.scanType = r104;
    }

    public /* synthetic */ ScanCodeResult(String r100, String r101, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r104 = "";
    L14:
        this(r102, r103, r104, r111, r112);
        return;
    L13:
        r104 = r110;
        goto L14
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
