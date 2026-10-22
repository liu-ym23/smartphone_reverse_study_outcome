package com.bytedance.ai.resource.core.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/resource/core/db/AIPackageDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "userDao", "Lcom/bytedance/ai/resource/core/db/AIPackageDao;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AIPackageDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f37336a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile AIPackageDatabase f37337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_1_2$1 f37338c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_2_3$1 f37339d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_3_4$1 f37340e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_4_5$1 f37341f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_5_6$1 f37342g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_6_7$1 f37343h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_7_8$1 f37344i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_8_9$1 f37345j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_9_10$1 f37346k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_10_11$1 f37347l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_11_12$1 f37348m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_12_13$1 f37349n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_13_14$1 f37350o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_14_15$1 f37351p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AIPackageDatabase$Companion$MIGRATION_15_16$1 f37352q = null;

    public static final class Companion {
        public final AIPackageDatabase b() {
            AIPackageDatabase r100 = AIPackageDatabase.f37337b;
            if (r100 != null) goto L15;
            monitor-enter(this);
            r100 = AIPackageDatabase.f37337b;     // Catch: Throwable -> L9
            if (r100 != null) goto L11;
            Companion r101 = AIPackageDatabase.f37336a;     // Catch: Throwable -> L9
            r100 = a();     // Catch: Throwable -> L9
            AIPackageDatabase.f37337b = r100;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r100;
        }

        public static AIPackageDatabase a() {
            Context r100 = f2.k.a();
            int r101 = com.bytedance.ai.utils.a.f37625a;
            h2.a r102 = f2.b.f475099c;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r103 == true) goto L17;
            if (r102 != null) goto L11;
        L13:
            boolean r104 = false;
        L14:
            if (r104 == true) goto L17;
            String r105 = "ai_package_prod.db";
        L19:
            return (AIPackageDatabase) Room.databaseBuilder(r100, AIPackageDatabase.class, r105).fallbackToDestructiveMigration().addCallback(new AIPackageDatabase$Companion$createDatabase$1()).addMigrations(new Migration[]{AIPackageDatabase.f37338c, AIPackageDatabase.f37339d, AIPackageDatabase.f37340e, AIPackageDatabase.f37341f, AIPackageDatabase.f37342g, AIPackageDatabase.f37343h, AIPackageDatabase.f37344i, AIPackageDatabase.f37345j, AIPackageDatabase.f37346k, AIPackageDatabase.f37347l, AIPackageDatabase.f37348m, AIPackageDatabase.f37349n, AIPackageDatabase.f37350o, AIPackageDatabase.f37351p, AIPackageDatabase.f37352q}).build();
        L11:
            if (r102.f483577p != true) goto L13;
            r104 = true;
        L17:
            r105 = "ai_package_test.db";
            goto L19
        L5:
            if (r102.f483575n != true) goto L7;
            r103 = true;
            goto L8
        }

        public Companion() {
        }
    }

    public abstract AIPackageDao c();

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_1_2$1] */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_10_11$1] */
    /* JADX WARN: Type inference failed for: r0v11, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_11_12$1] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_12_13$1] */
    /* JADX WARN: Type inference failed for: r0v13, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_13_14$1] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_14_15$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_15_16$1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_2_3$1] */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_3_4$1] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_4_5$1] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_5_6$1] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_6_7$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_7_8$1] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_8_9$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.ai.resource.core.db.AIPackageDatabase$Companion$MIGRATION_9_10$1] */
    static {
        f37336a = new Companion();
        f37338c = new AIPackageDatabase$Companion$MIGRATION_1_2$1();
        f37339d = new AIPackageDatabase$Companion$MIGRATION_2_3$1();
        f37340e = new AIPackageDatabase$Companion$MIGRATION_3_4$1();
        f37341f = new AIPackageDatabase$Companion$MIGRATION_4_5$1();
        f37342g = new AIPackageDatabase$Companion$MIGRATION_5_6$1();
        f37343h = new AIPackageDatabase$Companion$MIGRATION_6_7$1();
        f37344i = new AIPackageDatabase$Companion$MIGRATION_7_8$1();
        f37345j = new AIPackageDatabase$Companion$MIGRATION_8_9$1();
        f37346k = new AIPackageDatabase$Companion$MIGRATION_9_10$1();
        f37347l = new AIPackageDatabase$Companion$MIGRATION_10_11$1();
        f37348m = new AIPackageDatabase$Companion$MIGRATION_11_12$1();
        f37349n = new AIPackageDatabase$Companion$MIGRATION_12_13$1();
        f37350o = new AIPackageDatabase$Companion$MIGRATION_13_14$1();
        f37351p = new AIPackageDatabase$Companion$MIGRATION_14_15$1();
        f37352q = new AIPackageDatabase$Companion$MIGRATION_15_16$1();
    }

    public AIPackageDatabase() {
    }
}
