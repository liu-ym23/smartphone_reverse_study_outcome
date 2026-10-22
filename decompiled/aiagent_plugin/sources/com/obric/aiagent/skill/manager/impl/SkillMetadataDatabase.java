package com.obric.aiagent.skill.manager.impl;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillMetadataStore.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SkillMetadataDatabase extends androidx.room.p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f19415e = null;
    private static volatile SkillMetadataDatabase f;
    private static final b g = null;

    /* JADX INFO: compiled from: SkillMetadataStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final SkillMetadataDatabase a(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "context");
            SkillMetadataDatabase r0 = SkillMetadataDatabase.p();
            if (r0 != null) goto L14;
            monitor-enter(this);
            r0 = SkillMetadataDatabase.p();     // Catch: Throwable -> L11
            if (r0 != null) goto L9;
            androidx.room.p r6 = androidx.room.o.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), SkillMetadataDatabase.class, "skill_manager_metadata.db").a(new androidx.room.a.b[]{SkillMetadataDatabase.q()}).b();     // Catch: Throwable -> L11
            SkillMetadataDatabase r1 = (SkillMetadataDatabase) ZeusTransformUtils.preCheckCast(r6, SkillMetadataDatabase.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
            a r2 = SkillMetadataDatabase.f19415e;     // Catch: Throwable -> L11
            SkillMetadataDatabase.a(r1);     // Catch: Throwable -> L11
            d.h.b.o.c(r6, "also(...)");     // Catch: Throwable -> L11
            r0 = (SkillMetadataDatabase) ZeusTransformUtils.preCheckCast(r6, SkillMetadataDatabase.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
        L11:
            th = move-exception;
            throw th;
        L14:
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillMetadataStore.kt */
    public static final class b extends androidx.room.a.b {
        b() {
            super(1, 2);
        }

        @Override // androidx.room.a.b
        public void a(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "database");
            r1.b("ALTER TABLE skill_metadata ADD COLUMN app_function_package_name TEXT");
            r1.b("ALTER TABLE skill_metadata ADD COLUMN app_function_content_fingerprint TEXT");
            r1.b("CREATE UNIQUE INDEX IF NOT EXISTS index_skill_metadata_app_function_package_name ON skill_metadata(app_function_package_name)");
        }
    }

    public abstract dc o();

    public static final /* synthetic */ void a(SkillMetadataDatabase r0) {
        f = r0;
    }

    public static final /* synthetic */ SkillMetadataDatabase p() {
        return f;
    }

    public static final /* synthetic */ b q() {
        return g;
    }

    public SkillMetadataDatabase() {
    }

    static {
        f19415e = new a(null);
        g = new b();
    }
}
