package com.bytedance.safetyguard.lxc.api.sidecar;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.h;
import d.h.b.o;
import java.util.Set;

/* JADX INFO: compiled from: SidecarResults.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarResult {
    private final String appId;
    private final SidecarBrand brand;
    private final int code;
    private final String hint;
    private final String message;
    private final Set<String> scopes;
    private final Integer subcode;
    private final String subtype;
    private final boolean success;
    private final String type;
    private final String userOpenId;

    public static /* synthetic */ SidecarResult copy$default(SidecarResult r13, boolean r14, int r15, String r16, String r17, String r18, String r19, String r20, String r21, SidecarBrand r22, Set r23, Integer r24, int r25, Object r26) {
        Set<String> r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.aiagent.plugin");
        if ((r25 & 1) == 0) goto L5;
        boolean r3 = r13.success;
    L7:
        if ((r25 & 2) == 0) goto L9;
        int r4 = r13.code;
    L11:
        if ((r25 & 4) == 0) goto L13;
        String r5 = r13.type;
    L15:
        if ((r25 & 8) == 0) goto L17;
        String r6 = r13.subtype;
    L19:
        if ((r25 & 16) == 0) goto L21;
        String r7 = r13.message;
    L23:
        if ((r25 & 32) == 0) goto L25;
        String r8 = r13.hint;
    L27:
        if ((r25 & 64) == 0) goto L29;
        String r9 = r13.appId;
    L31:
        if ((r25 & 128) == 0) goto L33;
        String r10 = r13.userOpenId;
    L35:
        if ((r25 & 256) == 0) goto L37;
        SidecarBrand r11 = r13.brand;
    L39:
        if ((r25 & 512) == 0) goto L42;
        r2 = r13.scopes;
    L42:
        if ((r25 & 1024) == 0) goto L44;
        Integer r1 = r13.subcode;
    L46:
        return r13.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r2, r1);
    L44:
        r1 = r24;
        goto L46
    L37:
        r11 = r22;
        goto L39
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    public final boolean component1() {
        return this.success;
    }

    public final Set<String> component10() {
        return this.scopes;
    }

    public final Integer component11() {
        return this.subcode;
    }

    public final int component2() {
        return this.code;
    }

    public final String component3() {
        return this.type;
    }

    public final String component4() {
        return this.subtype;
    }

    public final String component5() {
        return this.message;
    }

    public final String component6() {
        return this.hint;
    }

    public final String component7() {
        return this.appId;
    }

    public final String component8() {
        return this.userOpenId;
    }

    public final SidecarBrand component9() {
        return this.brand;
    }

    public final SidecarResult copy(boolean r14, int r15, String r16, String r17, String r18, String r19, String r20, String r21, SidecarBrand r22, Set<String> r23, Integer r24) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r23, Set.class, "com.obric.aiagent.plugin");
        o.e(r18, "message");
        o.e(r11, "scopes");
        return new SidecarResult(r14, r15, r16, r17, r18, r19, r20, r21, r22, r11, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SidecarResult.class) == true) goto L8;
        return false;
    L8:
        SidecarResult r6 = (SidecarResult) ZeusTransformUtils.preCheckCast(r5, SidecarResult.class, "com.obric.aiagent.plugin");
        if (this.success == r6.success) goto L12;
        return false;
    L12:
        if (this.code == r6.code) goto L15;
        return false;
    L15:
        if (o.a(this.type, r6.type) == true) goto L18;
        return false;
    L18:
        if (o.a(this.subtype, r6.subtype) == true) goto L21;
        return false;
    L21:
        if (o.a(this.message, r6.message) == true) goto L24;
        return false;
    L24:
        if (o.a(this.hint, r6.hint) == true) goto L27;
        return false;
    L27:
        if (o.a(this.appId, r6.appId) == true) goto L30;
        return false;
    L30:
        if (o.a(this.userOpenId, r6.userOpenId) == true) goto L33;
        return false;
    L33:
        if (this.brand == r6.brand) goto L36;
        return false;
    L36:
        if (o.a(this.scopes, r6.scopes) == true) goto L39;
        return false;
    L39:
        if (o.a(this.subcode, r6.subcode) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.success) * 31) + Integer.hashCode(this.code)) * 31;
        String r1 = this.type;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.subtype;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.message.hashCode()) * 31;
        String r8 = this.hint;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.appId;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.userOpenId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        SidecarBrand r17 = this.brand;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((r16 + r18) * 31) + this.scopes.hashCode()) * 31;
        Integer r20 = this.subcode;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("SidecarResult(success=").append(this.success).append(", code=").append(this.code).append(", type=").append(this.type).append(", subtype=").append(this.subtype).append(", message=").append(this.message).append(", hint=").append(this.hint).append(", appId=").append(this.appId).append(", userOpenId=").append(this.userOpenId).append(", brand=").append(this.brand).append(", scopes=").append(this.scopes).append(", subcode=").append(this.subcode).append(')');
        return r0.toString();
    }

    public SidecarResult(boolean r3, int r4, String r5, String r6, String r7, String r8, String r9, String r10, SidecarBrand r11, Set<String> r12, Integer r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        o.e(r7, "message");
        o.e(r14, "scopes");
        this.success = r3;
        this.code = r4;
        this.type = r5;
        this.subtype = r6;
        this.message = r7;
        this.hint = r8;
        this.appId = r9;
        this.userOpenId = r10;
        this.brand = r11;
        this.scopes = r14;
        this.subcode = r13;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSubtype() {
        return this.subtype;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getHint() {
        return this.hint;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getUserOpenId() {
        return this.userOpenId;
    }

    public final SidecarBrand getBrand() {
        return this.brand;
    }

    public /* synthetic */ SidecarResult(boolean r13, int r14, String r15, String r16, String r17, String r18, String r19, String r20, SidecarBrand r21, Set r22, Integer r23, int r24, h r25) {
        Set r1 = (Set) ZeusTransformUtils.wrapperContextForParams(r22, Set.class, "com.obric.aiagent.plugin");
        if ((r24 & 2) == 0) goto L5;
        int r2 = 0;
    L6:
        Integer r4 = null;
        if ((r24 & 4) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r24 & 8) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r24 & 16) == 0) goto L17;
        String r6 = "ok";
    L19:
        if ((r24 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r24 & 64) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r24 & 128) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r24 & 256) == 0) goto L33;
        SidecarBrand r10 = null;
    L35:
        if ((r24 & 512) == 0) goto L38;
        r1 = ax.b();
    L38:
        if ((r24 & 1024) != 0) goto L41;
        r4 = r23;
    L41:
        this(r13, r2, r3, r5, r6, r7, r8, r9, r10, r1, r4);
        return;
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L6
    }

    public final Set<String> getScopes() {
        return this.scopes;
    }

    public final Integer getSubcode() {
        return this.subcode;
    }

    public final boolean getOk() {
        return this.success;
    }
}
