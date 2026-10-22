package com.bytedance.safetyguard.lxc.internal.e.i;

import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.safetyguard.lxc.api.sidecar.SidecarBrand;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CredentialStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SidecarBrand f10903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10905e;

    public static /* synthetic */ c a(c r3, String r4, String r5, SidecarBrand r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.f10901a;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.f10902b;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.f10903c;
    L11:
        SidecarBrand r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.f10904d;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.f10905e;
    L17:
        String r12 = r4;
        return r3.a(r12, r11, r0, r1, r8);
    }

    public final c a(String r7, String r8, SidecarBrand r9, String r10, String r11) {
        o.e(r7, "appId");
        o.e(r8, "appSecret");
        o.e(r9, PlatformConst.BUNDLE_KEY_BRAND);
        return new c(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f10901a, r6.f10901a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f10902b, r6.f10902b) == true) goto L15;
        return false;
    L15:
        if (this.f10903c == r6.f10903c) goto L18;
        return false;
    L18:
        if (o.a(this.f10904d, r6.f10904d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f10905e, r6.f10905e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.f10901a.hashCode() * 31) + this.f10902b.hashCode()) * 31) + this.f10903c.hashCode()) * 31;
        String r1 = this.f10904d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f10905e;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public c(String r2, String r3, SidecarBrand r4, String r5, String r6) {
        o.e(r2, "appId");
        o.e(r3, "appSecret");
        o.e(r4, PlatformConst.BUNDLE_KEY_BRAND);
        this.f10901a = r2;
        this.f10902b = r3;
        this.f10903c = r4;
        this.f10904d = r5;
        this.f10905e = r6;
    }

    public /* synthetic */ c(String r8, String r9, SidecarBrand r10, String r11, String r12, int r13, h r14) {
        if ((r13 & 8) == 0) goto L5;
        String r5 = null;
    L7:
        if ((r13 & 16) == 0) goto L9;
        String r6 = null;
    L10:
        this(r8, r9, r10, r5, r6);
        return;
    L9:
        r6 = r12;
        goto L10
    L5:
        r5 = r11;
        goto L7
    }

    public final String a() {
        return this.f10901a;
    }

    public final String b() {
        return this.f10902b;
    }

    public final SidecarBrand c() {
        return this.f10903c;
    }

    public final String d() {
        return this.f10904d;
    }

    public final String e() {
        return this.f10905e;
    }

    public String toString() {
        return "StoredAppRecord(appId=" + this.f10901a + ", appSecret=<redacted>, brand=" + this.f10903c + ", currentUserOpenId=" + this.f10904d + ", currentUserName=" + this.f10905e + ')';
    }
}
