package com.stepos.ailauncher.storage.database;

import android.database.SQLException;
import androidx.room.RoomDatabase;
import com.autonavi.aps.amapapi.config.Const;
import d1.AbstractC3942a;
import j1.InterfaceC4756c;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/storage/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Companion", Const.INTENT_KEY_UMID, "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "launcher_database";
    private static volatile AppDatabase INSTANCE;
    private static final a MIGRATION_3_4 = new a();
    private static final b MIGRATION_4_5 = new b();
    private static final c MIGRATION_5_6 = new c();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/storage/database/AppDatabase$a", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends AbstractC3942a {
        public a() {
            super(3, 4);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            p.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS `installed_skill` (`slug` TEXT NOT NULL, `displayName` TEXT NOT NULL, `summary` TEXT NOT NULL, `iconUrl` TEXT, `downloadCount` INTEGER NOT NULL, `installKind` TEXT NOT NULL, `installSource` TEXT NOT NULL, `enabled` INTEGER NOT NULL, `installedAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`slug`))");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/storage/database/AppDatabase$b", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends AbstractC3942a {
        public b() {
            super(4, 5);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            p.i(db2, "db");
            db2.execSQL("CREATE TABLE IF NOT EXISTS `launcher_vector_entities` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bizKey` TEXT NOT NULL, `bizType` TEXT NOT NULL, `entityClassName` TEXT NOT NULL DEFAULT 'LauncherVectorEntity', `bizId` TEXT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `metadata` TEXT NOT NULL, `updateTime` INTEGER NOT NULL)");
            db2.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_launcher_vector_entities_bizKey` ON `launcher_vector_entities` (`bizKey`)");
            db2.execSQL("CREATE INDEX IF NOT EXISTS `index_launcher_vector_entities_bizType` ON `launcher_vector_entities` (`bizType`)");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/storage/database/AppDatabase$c", "Ld1/a;", "Lj1/c;", "db", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/c;)V", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends AbstractC3942a {
        public c() {
            super(5, 6);
        }

        @Override // d1.AbstractC3942a
        public void b(InterfaceC4756c db2) throws SQLException {
            p.i(db2, "db");
            db2.execSQL("DROP TABLE IF EXISTS `launcher_vector_entities`");
        }
    }
}
