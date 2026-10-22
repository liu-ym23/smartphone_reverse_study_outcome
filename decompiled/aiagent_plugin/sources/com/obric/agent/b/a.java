package com.obric.agent.b;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ActionResultLite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MonitorConstants.CODE)
    private int f14245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("msg")
    private String f14246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("replyFor")
    private String f14247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("uiType")
    private int f14248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("entity_data")
    private String f14249e;

    @SerializedName("card_data")
    private String f;

    public a() {
        this(0, null, null, 0, null, null, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f14245a == r6.f14245a) goto L12;
        return false;
    L12:
        if (o.a(this.f14246b, r6.f14246b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f14247c, r6.f14247c) == true) goto L18;
        return false;
    L18:
        if (this.f14248d == r6.f14248d) goto L21;
        return false;
    L21:
        if (o.a(this.f14249e, r6.f14249e) == true) goto L24;
        return false;
    L24:
        if (o.a(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f14245a) * 31;
        String r1 = this.f14246b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f14247c;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.f14248d)) * 31;
        String r8 = this.f14249e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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
        return "ActionResultLite(code=" + this.f14245a + ", msg=" + this.f14246b + ", replyFor=" + this.f14247c + ", uiType=" + this.f14248d + ", entityData=" + this.f14249e + ", cardData=" + this.f + ')';
    }

    public a(int r1, String r2, String r3, int r4, String r5, String r6) {
        this.f14245a = r1;
        this.f14246b = r2;
        this.f14247c = r3;
        this.f14248d = r4;
        this.f14249e = r5;
        this.f = r6;
    }

    public /* synthetic */ a(int r5, String r6, String r7, int r8, String r9, String r10, int r11, h r12) {
        if ((r11 & 1) == 0) goto L5;
        r5 = Integer.MIN_VALUE;
    L5:
        String r0 = "";
        if ((r11 & 2) == 0) goto L8;
        String r13 = "";
    L10:
        if ((r11 & 4) != 0) goto L14;
        r0 = r7;
    L14:
        if ((r11 & 8) == 0) goto L16;
        r8 = 0;
    L16:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L19;
        String r2 = null;
    L21:
        if ((r11 & 32) == 0) goto L23;
        String r3 = null;
    L24:
        this(r5, r13, r0, r1, r2, r3);
        return;
    L23:
        r3 = r10;
        goto L24
    L19:
        r2 = r9;
        goto L21
    L8:
        r13 = r6;
        goto L10
    }

    public final int a() {
        return this.f14245a;
    }

    public final void a(String r1) {
        this.f14246b = r1;
    }

    public final String b() {
        return this.f14246b;
    }

    public final void b(String r1) {
        this.f14247c = r1;
    }

    public final String c() {
        return this.f14247c;
    }

    public final int d() {
        return this.f14248d;
    }

    public final void c(String r1) {
        this.f14249e = r1;
    }

    public final String e() {
        return this.f14249e;
    }

    public final void d(String r1) {
        this.f = r1;
    }
}
