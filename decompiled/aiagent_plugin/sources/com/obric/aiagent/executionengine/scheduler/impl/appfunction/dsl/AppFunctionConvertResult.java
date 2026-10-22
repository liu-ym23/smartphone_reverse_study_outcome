package com.obric.aiagent.executionengine.scheduler.impl.appfunction.dsl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: IAppFunctionConvert.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionConvertResult {
    private final int code;
    private final Map<String, String> ext;
    private final String message;
    private final String outputJson;
    private final boolean success;

    public static /* synthetic */ AppFunctionConvertResult copy$default(AppFunctionConvertResult r6, boolean r7, int r8, String r9, String r10, Map r11, int r12, Object r13) {
        Map<String, String> r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.success;
    L5:
        boolean r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r8 = r6.code;
    L8:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L11;
        r9 = r6.message;
    L11:
        String r3 = r9;
        if ((r12 & 8) == 0) goto L14;
        r10 = r6.outputJson;
    L14:
        String r4 = r10;
        if ((r12 & 16) == 0) goto L18;
        r14 = r6.ext;
    L18:
        return r6.copy(r1, r2, r3, r4, r14);
    }

    public final boolean component1() {
        return this.success;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.message;
    }

    public final String component4() {
        return this.outputJson;
    }

    public final Map<String, String> component5() {
        return this.ext;
    }

    public final AppFunctionConvertResult copy(boolean r7, int r8, String r9, String r10, Map<String, String> r11) {
        return new AppFunctionConvertResult(r7, r8, r9, r10, (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppFunctionConvertResult.class) == true) goto L8;
        return false;
    L8:
        AppFunctionConvertResult r6 = (AppFunctionConvertResult) ZeusTransformUtils.preCheckCast(r5, AppFunctionConvertResult.class, "com.obric.aiagent.plugin");
        if (this.success == r6.success) goto L12;
        return false;
    L12:
        if (this.code == r6.code) goto L15;
        return false;
    L15:
        if (o.a(this.message, r6.message) == true) goto L18;
        return false;
    L18:
        if (o.a(this.outputJson, r6.outputJson) == true) goto L21;
        return false;
    L21:
        if (o.a(this.ext, r6.ext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.success) * 31) + Integer.hashCode(this.code)) * 31;
        String r1 = this.message;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.outputJson;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Map<String, String> r8 = this.ext;
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
        return "AppFunctionConvertResult(success=" + this.success + ", code=" + this.code + ", message=" + this.message + ", outputJson=" + this.outputJson + ", ext=" + this.ext + ')';
    }

    public AppFunctionConvertResult(boolean r3, int r4, String r5, String r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        this.success = r3;
        this.code = r4;
        this.message = r5;
        this.outputJson = r6;
        this.ext = r8;
    }

    public /* synthetic */ AppFunctionConvertResult(boolean r7, int r8, String r9, String r10, Map r11, int r12, h r13) {
        Map r14 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        if ((r12 & 2) == 0) goto L5;
        r8 = 0;
    L5:
        int r2 = r8;
        if ((r12 & 4) == 0) goto L8;
        String r3 = null;
    L10:
        if ((r12 & 8) == 0) goto L12;
        String r4 = null;
    L14:
        if ((r12 & 16) == 0) goto L16;
        Map r5 = null;
    L17:
        this(r7, r2, r3, r4, r5);
        return;
    L16:
        r5 = r14;
        goto L17
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOutputJson() {
        return this.outputJson;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }
}
