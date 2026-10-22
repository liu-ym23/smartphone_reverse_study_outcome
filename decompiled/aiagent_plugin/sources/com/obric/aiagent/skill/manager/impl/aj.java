package com.obric.aiagent.skill.manager.impl;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillShopRepository.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f19482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19483e;
    private final String f;
    private final String g;

    public aj() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, aj.class) == true) goto L8;
        return false;
    L8:
        aj r6 = (aj) ZeusTransformUtils.preCheckCast(r5, aj.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f19479a, r6.f19479a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f19480b, r6.f19480b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f19481c, r6.f19481c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f19482d, r6.f19482d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f19483e, r6.f19483e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f19479a.hashCode() * 31) + this.f19480b.hashCode()) * 31) + this.f19481c.hashCode()) * 31) + this.f19482d.hashCode()) * 31) + this.f19483e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public String toString() {
        return "ShopBanner(id=" + this.f19479a + ", title=" + this.f19480b + ", subtitle=" + this.f19481c + ", collectionId=" + this.f19482d + ", imageUrl=" + this.f19483e + ", collectionName=" + this.f + ", collectionSlug=" + this.g + ')';
    }

    public aj(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        d.h.b.o.e(r2, DbHelper.COL_ID);
        d.h.b.o.e(r3, DBDefinition.TITLE);
        d.h.b.o.e(r4, "subtitle");
        d.h.b.o.e(r5, "collectionId");
        d.h.b.o.e(r6, "imageUrl");
        d.h.b.o.e(r7, "collectionName");
        d.h.b.o.e(r8, "collectionSlug");
        this.f19479a = r2;
        this.f19480b = r3;
        this.f19481c = r4;
        this.f19482d = r5;
        this.f19483e = r6;
        this.f = r7;
        this.g = r8;
    }

    public /* synthetic */ aj(String r2, String r3, String r4, String r5, String r6, String r7, String r8, int r9, d.h.b.h r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = "";
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = "";
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = "";
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final String a() {
        return this.f19480b;
    }

    public final String b() {
        return this.f19481c;
    }

    public final String c() {
        return this.f19483e;
    }

    public final String d() {
        return this.f;
    }

    public final String e() {
        return this.g;
    }
}
