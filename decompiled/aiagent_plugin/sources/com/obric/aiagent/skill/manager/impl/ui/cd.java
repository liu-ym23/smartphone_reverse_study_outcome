package com.obric.aiagent.skill.manager.impl.ui;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: SkillShopViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.obric.aiagent.skill.manager.impl.am> f20708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f20709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f20710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f20711d;

    public cd() {
        this(null, false, false, false, 15, null);
    }

    public static /* synthetic */ cd a(cd r1, List r2, boolean r3, boolean r4, boolean r5, int r6, Object r7) {
        List<com.obric.aiagent.skill.manager.impl.am> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = r1.f20708a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f20709b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = r1.f20710c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.f20711d;
    L15:
        return r1.a(r8, r3, r4, r5);
    }

    public final cd a(List<com.obric.aiagent.skill.manager.impl.am> r2, boolean r3, boolean r4, boolean r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "items");
        return new cd(r1, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, cd.class) == true) goto L8;
        return false;
    L8:
        cd r6 = (cd) ZeusTransformUtils.preCheckCast(r5, cd.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f20708a, r6.f20708a) == true) goto L12;
        return false;
    L12:
        if (this.f20709b == r6.f20709b) goto L15;
        return false;
    L15:
        if (this.f20710c == r6.f20710c) goto L18;
        return false;
    L18:
        if (this.f20711d == r6.f20711d) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f20708a.hashCode() * 31) + Boolean.hashCode(this.f20709b)) * 31) + Boolean.hashCode(this.f20710c)) * 31) + Boolean.hashCode(this.f20711d);
    }

    public String toString() {
        return "SkillShopPageState(items=" + this.f20708a + ", isLoading=" + this.f20709b + ", hasLoadedFirstPage=" + this.f20710c + ", hasMore=" + this.f20711d + ')';
    }

    public cd(List<com.obric.aiagent.skill.manager.impl.am> r3, boolean r4, boolean r5, boolean r6) {
        List<com.obric.aiagent.skill.manager.impl.am> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "items");
        this.f20708a = r7;
        this.f20709b = r4;
        this.f20710c = r5;
        this.f20711d = r6;
    }

    public /* synthetic */ cd(List r2, boolean r3, boolean r4, boolean r5, int r6, d.h.b.h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r8 = d.a.p.b();
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = false;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = true;
    L14:
        this(r8, r3, r4, r5);
    }

    public final List<com.obric.aiagent.skill.manager.impl.am> a() {
        return this.f20708a;
    }

    public final boolean b() {
        return this.f20709b;
    }

    public final boolean c() {
        return this.f20710c;
    }

    public final boolean d() {
        return this.f20711d;
    }
}
