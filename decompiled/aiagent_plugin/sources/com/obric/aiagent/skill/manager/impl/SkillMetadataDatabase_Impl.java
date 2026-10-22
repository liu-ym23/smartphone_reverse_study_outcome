package com.obric.aiagent.skill.manager.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class SkillMetadataDatabase_Impl extends SkillMetadataDatabase {
    private volatile dc f;

    public SkillMetadataDatabase_Impl() {
    }

    static /* synthetic */ androidx.sqlite.db.c a(SkillMetadataDatabase_Impl r2, androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        r2.f2668a = r4;
        return r4;
    }

    static /* synthetic */ List a(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List b(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ void b(SkillMetadataDatabase_Impl r2, androidx.sqlite.db.c r3) {
        r2.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    static /* synthetic */ List c(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List d(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List e(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List f(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List g(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List h(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    static /* synthetic */ List i(SkillMetadataDatabase_Impl r0) {
        return r0.f2670c;
    }

    @Override // androidx.room.p
    public androidx.sqlite.db.d b(androidx.room.c r4) {
        final int r2 = 2;
        androidx.room.r r0 = new androidx.room.r(r4, new AnonymousClass1(this, r2), "8253089a3dead4904c3b5f11fa2f9d15", "e6589620e837f5fee98cda8224c0fe54");
        androidx.sqlite.db.d.b r3 = androidx.sqlite.db.d.b.a(r4.f2624b).a(r4.f2625c).a(r0).a();
        return r4.f2623a.b(r3);
    }

    @Override // androidx.room.p
    public androidx.room.h c() {
        return new androidx.room.h(this, new HashMap(0), new HashMap(0), new String[]{"skill_metadata"});
    }

    @Override // androidx.room.p
    public Map<Class<?>, List<Class<?>>> d() {
        HashMap r2 = new HashMap();
        r2.put(dc.class, dd.c());
        return r2;
    }

    @Override // androidx.room.p
    public Set<Class<? extends androidx.room.a.a>> e() {
        return new HashSet();
    }

    @Override // androidx.room.p
    public List<androidx.room.a.b> a(Map<Class<? extends androidx.room.a.a>, androidx.room.a.a> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        return Arrays.asList(new androidx.room.a.b[0]);
    }

    @Override // com.obric.aiagent.skill.manager.impl.SkillMetadataDatabase
    public dc o() {
        if (this.f != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f != null) goto L10;
        this.f = new dd(this);     // Catch: Throwable -> L13
    L10:
        dc r0 = this.f;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.f;
    }
}
