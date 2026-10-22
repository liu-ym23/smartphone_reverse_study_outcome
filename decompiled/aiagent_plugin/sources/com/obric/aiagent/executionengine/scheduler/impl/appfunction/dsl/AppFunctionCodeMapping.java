package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AppFunctionDslConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionCodeMapping {
    private final int resultCode;
    private final Integer srcCode;
    private final String srcMessage;

    public static /* synthetic */ AppFunctionCodeMapping copy$default(AppFunctionCodeMapping r0, Integer r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.srcCode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.srcMessage;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.resultCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Integer component1() {
        return this.srcCode;
    }

    public final String component2() {
        return this.srcMessage;
    }

    public final int component3() {
        return this.resultCode;
    }

    public final AppFunctionCodeMapping copy(Integer r1, String r2, int r3) {
        return new AppFunctionCodeMapping(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionCodeMapping.class) == true) goto L8;
        return false;
    L8:
        AppFunctionCodeMapping r6 = (AppFunctionCodeMapping) ZeusTransformUtils.preCheckCast(r5, AppFunctionCodeMapping.class, "com.obric.aiagent.plugin");
        if (o.a(this.srcCode, r6.srcCode) == true) goto L12;
        return false;
    L12:
        if (o.a(this.srcMessage, r6.srcMessage) == true) goto L15;
        return false;
    L15:
        if (this.resultCode == r6.resultCode) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.srcCode;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.srcMessage;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((r3 + r1) * 31) + Integer.hashCode(this.resultCode);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppFunctionCodeMapping(srcCode=" + this.srcCode + ", srcMessage=" + this.srcMessage + ", resultCode=" + this.resultCode + ')';
    }

    public AppFunctionCodeMapping(Integer r1, String r2, int r3) {
        this.srcCode = r1;
        this.srcMessage = r2;
        this.resultCode = r3;
    }

    public /* synthetic */ AppFunctionCodeMapping(Integer r2, String r3, int r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3, r4);
    }

    public final Integer getSrcCode() {
        return this.srcCode;
    }

    public final String getSrcMessage() {
        return this.srcMessage;
    }

    public final int getResultCode() {
        return this.resultCode;
    }
}
