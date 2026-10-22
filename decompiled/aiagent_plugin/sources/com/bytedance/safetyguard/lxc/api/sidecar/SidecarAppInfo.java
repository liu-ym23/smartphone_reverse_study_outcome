package com.bytedance.safetyguard.lxc.api.sidecar;

import com.bytedance.crypto.platform.PlatformConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SidecarModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SidecarAppInfo {
    private final String appId;
    private final SidecarBrand brand;
    private final String currentUserName;
    private final String currentUserOpenId;
    private final boolean hasBotToken;
    private final boolean hasUserToken;

    public static /* synthetic */ SidecarAppInfo copy$default(SidecarAppInfo r4, String r5, SidecarBrand r6, String r7, String r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.appId;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.brand;
    L8:
        SidecarBrand r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.currentUserOpenId;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.currentUserName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.hasUserToken;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.hasBotToken;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.appId;
    }

    public final SidecarBrand component2() {
        return this.brand;
    }

    public final String component3() {
        return this.currentUserOpenId;
    }

    public final String component4() {
        return this.currentUserName;
    }

    public final boolean component5() {
        return this.hasUserToken;
    }

    public final boolean component6() {
        return this.hasBotToken;
    }

    public final SidecarAppInfo copy(String r8, SidecarBrand r9, String r10, String r11, boolean r12, boolean r13) {
        o.e(r8, "appId");
        o.e(r9, PlatformConst.BUNDLE_KEY_BRAND);
        return new SidecarAppInfo(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SidecarAppInfo.class) == true) goto L8;
        return false;
    L8:
        SidecarAppInfo r6 = (SidecarAppInfo) ZeusTransformUtils.preCheckCast(r5, SidecarAppInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.appId, r6.appId) == true) goto L12;
        return false;
    L12:
        if (this.brand == r6.brand) goto L15;
        return false;
    L15:
        if (o.a(this.currentUserOpenId, r6.currentUserOpenId) == true) goto L18;
        return false;
    L18:
        if (o.a(this.currentUserName, r6.currentUserName) == true) goto L21;
        return false;
    L21:
        if (this.hasUserToken == r6.hasUserToken) goto L24;
        return false;
    L24:
        if (this.hasBotToken == r6.hasBotToken) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.appId.hashCode() * 31) + this.brand.hashCode()) * 31;
        String r1 = this.currentUserOpenId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.currentUserName;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((((r4 + r2) * 31) + Boolean.hashCode(this.hasUserToken)) * 31) + Boolean.hashCode(this.hasBotToken);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SidecarAppInfo(appId=" + this.appId + ", brand=" + this.brand + ", currentUserOpenId=" + this.currentUserOpenId + ", currentUserName=" + this.currentUserName + ", hasUserToken=" + this.hasUserToken + ", hasBotToken=" + this.hasBotToken + ')';
    }

    public SidecarAppInfo(String r2, SidecarBrand r3, String r4, String r5, boolean r6, boolean r7) {
        o.e(r2, "appId");
        o.e(r3, PlatformConst.BUNDLE_KEY_BRAND);
        this.appId = r2;
        this.brand = r3;
        this.currentUserOpenId = r4;
        this.currentUserName = r5;
        this.hasUserToken = r6;
        this.hasBotToken = r7;
    }

    public /* synthetic */ SidecarAppInfo(String r10, SidecarBrand r11, String r12, String r13, boolean r14, boolean r15, int r16, h r17) {
        if ((r16 & 4) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r16 & 8) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r16 & 16) == 0) goto L16;
        if (r5 == null) goto L14;
        boolean r0 = true;
    L15:
        boolean r7 = r0;
    L18:
        if ((r16 & 32) == 0) goto L20;
        boolean r8 = true;
    L21:
        this(r10, r11, r5, r6, r7, r8);
        return;
    L20:
        r8 = r15;
        goto L21
    L14:
        r0 = false;
        goto L15
    L16:
        r7 = r14;
        goto L18
    L9:
        r6 = r13;
        goto L11
    L5:
        r5 = r12;
        goto L7
    }

    public final String getAppId() {
        return this.appId;
    }

    public final SidecarBrand getBrand() {
        return this.brand;
    }

    public final String getCurrentUserOpenId() {
        return this.currentUserOpenId;
    }

    public final String getCurrentUserName() {
        return this.currentUserName;
    }

    public final boolean getHasUserToken() {
        return this.hasUserToken;
    }

    public final boolean getHasBotToken() {
        return this.hasBotToken;
    }
}
