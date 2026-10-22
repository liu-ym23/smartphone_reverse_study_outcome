package com.obric.autogui.common.api.platform.security;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: VirusCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VirusCheckResult {
    private final String errorMessage;
    private final boolean isVirus;
    private final int resultCode;
    private final String virusType;
    private final Integer virusTypeCode;

    public static /* synthetic */ VirusCheckResult copy$default(VirusCheckResult r3, int r4, String r5, Integer r6, boolean r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.resultCode;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.virusType;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.virusTypeCode;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.isVirus;
    L14:
        boolean r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.errorMessage;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.resultCode;
    }

    public final String component2() {
        return this.virusType;
    }

    public final Integer component3() {
        return this.virusTypeCode;
    }

    public final boolean component4() {
        return this.isVirus;
    }

    public final String component5() {
        return this.errorMessage;
    }

    public final VirusCheckResult copy(int r7, String r8, Integer r9, boolean r10, String r11) {
        return new VirusCheckResult(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, VirusCheckResult.class) == true) goto L8;
        return false;
    L8:
        VirusCheckResult r6 = (VirusCheckResult) ZeusTransformUtils.preCheckCast(r5, VirusCheckResult.class, "com.obric.aiagent.plugin");
        if (this.resultCode == r6.resultCode) goto L12;
        return false;
    L12:
        if (o.a(this.virusType, r6.virusType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.virusTypeCode, r6.virusTypeCode) == true) goto L18;
        return false;
    L18:
        if (this.isVirus == r6.isVirus) goto L21;
        return false;
    L21:
        if (o.a(this.errorMessage, r6.errorMessage) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.resultCode) * 31;
        String r1 = this.virusType;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Integer r5 = this.virusTypeCode;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.isVirus)) * 31;
        String r8 = this.errorMessage;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "VirusCheckResult(resultCode=" + this.resultCode + ", virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ", isVirus=" + this.isVirus + ", errorMessage=" + this.errorMessage + ')';
    }

    public VirusCheckResult(int r1, String r2, Integer r3, boolean r4, String r5) {
        this.resultCode = r1;
        this.virusType = r2;
        this.virusTypeCode = r3;
        this.isVirus = r4;
        this.errorMessage = r5;
    }

    public /* synthetic */ VirusCheckResult(int r7, String r8, Integer r9, boolean r10, String r11, int r12, h r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final String getVirusType() {
        return this.virusType;
    }

    public final Integer getVirusTypeCode() {
        return this.virusTypeCode;
    }

    public final boolean isVirus() {
        return this.isVirus;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean isSuccess() {
        if (this.resultCode != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
