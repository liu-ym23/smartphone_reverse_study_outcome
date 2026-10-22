package com.obric.aiagent.skill.manager.impl;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopApiClient.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class fr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("items")
    private final List<fs> f19913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("total")
    private final int f19914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("page")
    private final int f19915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("page_size")
    private final int f19916d;

    public fr() {
        this(null, 0, 0, 0, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, fr.class) == true) goto L8;
        return false;
    L8:
        fr r6 = (fr) ZeusTransformUtils.preCheckCast(r5, fr.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19913a, r6.f19913a) == true) goto L12;
        return false;
    L12:
        if (this.f19914b == r6.f19914b) goto L15;
        return false;
    L15:
        if (this.f19915c == r6.f19915c) goto L18;
        return false;
    L18:
        if (this.f19916d == r6.f19916d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        List<fs> r0 = this.f19913a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((r1 * 31) + Integer.hashCode(this.f19914b)) * 31) + Integer.hashCode(this.f19915c)) * 31) + Integer.hashCode(this.f19916d);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "SkillShopListData(items=" + this.f19913a + ", total=" + this.f19914b + ", page=" + this.f19915c + ", pageSize=" + this.f19916d + ')';
    }

    public fr(List<fs> r3, int r4, int r5, int r6) {
        this.f19913a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f19914b = r4;
        this.f19915c = r5;
        this.f19916d = r6;
    }

    public /* synthetic */ fr(List r2, int r3, int r4, int r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r8, r3, r4, r5);
    }

    public final List<fs> a() {
        return this.f19913a;
    }

    public final int b() {
        return this.f19914b;
    }

    public final int c() {
        return this.f19915c;
    }

    public final int d() {
        return this.f19916d;
    }
}
