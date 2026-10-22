package com.obric.autoaction.app.launcherpage.discovery.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("daily")
    private final boolean f23628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("weekly")
    private final List<Integer> f23629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("monthly")
    private final int f23630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("yearly")
    private final String f23631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("expire_date")
    private final String f23632e;

    @SerializedName("is_single_task")
    private final boolean f;

    public o() {
        this(false, null, 0, null, null, false, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.aiagent.plugin");
        if (this.f23628a == r6.f23628a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23629b, r6.f23629b) == true) goto L15;
        return false;
    L15:
        if (this.f23630c == r6.f23630c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23631d, r6.f23631d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f23632e, r6.f23632e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = Boolean.hashCode(this.f23628a) * 31;
        List<Integer> r1 = this.f23629b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.f23630c)) * 31;
        String r5 = this.f23631d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f23632e;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + Boolean.hashCode(this.f);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "InstructionPeriodicPolicy(daily=" + this.f23628a + ", weekly=" + this.f23629b + ", monthly=" + this.f23630c + ", yearly=" + this.f23631d + ", expireDate=" + this.f23632e + ", isSingleTask=" + this.f + ')';
    }

    public o(boolean r3, List<Integer> r4, int r5, String r6, String r7, boolean r8) {
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f23628a = r3;
        this.f23629b = r9;
        this.f23630c = r5;
        this.f23631d = r6;
        this.f23632e = r7;
        this.f = r8;
    }

    public /* synthetic */ o(boolean r8, List r9, int r10, String r11, String r12, boolean r13, int r14, d.h.b.h r15) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if ((r14 & 1) == 0) goto L5;
        boolean r1 = false;
    L6:
        String r4 = null;
        if ((r14 & 2) == 0) goto L10;
        r0 = null;
    L10:
        if ((r14 & 4) == 0) goto L12;
        int r3 = 0;
    L14:
        if ((r14 & 8) == 0) goto L16;
        String r5 = null;
    L18:
        if ((r14 & 16) != 0) goto L22;
        r4 = r12;
    L22:
        if ((r14 & 32) != 0) goto L25;
        r2 = r13;
    L25:
        this(r1, r0, r3, r5, r4, r2);
        return;
    L16:
        r5 = r11;
        goto L18
    L12:
        r3 = r10;
        goto L14
    L5:
        r1 = r8;
        goto L6
    }

    public final boolean a() {
        return this.f23628a;
    }

    public final List<Integer> b() {
        return this.f23629b;
    }

    public final int c() {
        return this.f23630c;
    }

    public final String d() {
        return this.f23631d;
    }

    public final String e() {
        return this.f23632e;
    }

    public final boolean f() {
        return this.f;
    }
}
