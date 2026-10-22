package com.obric.agent.intents.music.netease.a;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CMApiPlayListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("type")
    private int f14752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private long f14753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("name")
    private String f14754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("singerName")
    private String f14755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("vip")
    private boolean f14756e;

    @SerializedName("playing")
    private boolean f;

    @SerializedName("coverUrl")
    private String g;

    public b() {
        this(0, 0, null, null, false, false, null, 127, null);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
        if (this.f14752a == r10.f14752a) goto L12;
        return false;
    L12:
        if (this.f14753b == r10.f14753b) goto L15;
        return false;
    L15:
        if (o.a(this.f14754c, r10.f14754c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f14755d, r10.f14755d) == true) goto L21;
        return false;
    L21:
        if (this.f14756e == r10.f14756e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (o.a(this.g, r10.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.f14752a) * 31) + Long.hashCode(this.f14753b)) * 31;
        String r1 = this.f14754c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.f14755d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + Boolean.hashCode(this.f14756e)) * 31) + Boolean.hashCode(this.f)) * 31;
        String r8 = this.g;
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
        return "CMApiPlayListItem(type=" + this.f14752a + ", id=" + this.f14753b + ", name=" + this.f14754c + ", singerName=" + this.f14755d + ", vip=" + this.f14756e + ", playing=" + this.f + ", coverUrl=" + this.g + ')';
    }

    public b(int r1, long r2, String r4, String r5, boolean r6, boolean r7, String r8) {
        this.f14752a = r1;
        this.f14753b = r2;
        this.f14754c = r4;
        this.f14755d = r5;
        this.f14756e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ b(int r10, long r11, String r13, String r14, boolean r15, boolean r16, String r17, int r18, h r19) {
        if ((r18 & 1) == 0) goto L5;
        int r0 = -1;
    L7:
        if ((r18 & 2) == 0) goto L9;
        long r1 = 0;
    L10:
        String r4 = "";
        if ((r18 & 4) == 0) goto L13;
        String r3 = "";
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = "";
    L18:
        boolean r7 = false;
        if ((r18 & 16) == 0) goto L21;
        boolean r6 = false;
    L23:
        if ((r18 & 32) != 0) goto L27;
        r7 = r16;
    L27:
        if ((r18 & 64) != 0) goto L30;
        r4 = r17;
    L30:
        this(r0, r1, r3, r5, r6, r7, r4);
        return;
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L18
    L13:
        r3 = r13;
        goto L15
    L9:
        r1 = r11;
        goto L10
    L5:
        r0 = r10;
        goto L7
    }

    public final int getType() {
        return this.f14752a;
    }

    public final long a() {
        return this.f14753b;
    }

    public final String b() {
        return this.f14754c;
    }

    public final String c() {
        return this.f14755d;
    }

    public final String d() {
        return this.g;
    }
}
