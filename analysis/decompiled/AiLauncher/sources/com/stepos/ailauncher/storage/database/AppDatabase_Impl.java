package com.stepos.ailauncher.storage.database;

import Y8.h;
import androidx.room.InvalidationTracker;
import androidx.room.w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.provider.c;
import d1.AbstractC3942a;
import f1.C4031a;
import f1.C4044n;
import i1.C4159a;
import i1.InterfaceC4160b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import n6.InterfaceC4942a;
import n6.c;
import p9.InterfaceC5063a;
import w9.InterfaceC5745d;
import x5.d;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ)\u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\f0\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b0\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\f2\u001a\u0010\u0013\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000b\u0012\u0004\u0012\u00020\u00100\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/storage/database/AppDatabase_Impl;", "Lcom/stepos/ailauncher/storage/database/AppDatabase;", "<init>", "()V", "Landroidx/room/w;", "a0", "()Landroidx/room/w;", "Landroidx/room/InvalidationTracker;", "m", "()Landroidx/room/InvalidationTracker;", "", "Lw9/d;", "", "y", "()Ljava/util/Map;", "", "", "w", "()Ljava/util/Set;", "autoMigrationSpecs", "Ld1/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;)Ljava/util/List;", "LY8/h;", "Ln6/c;", "_uiTaskDao", "LY8/h;", "Ln6/a;", "_installedSkillDao", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private final h<c> _uiTaskDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.storage.database.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AppDatabase_Impl.Y(this.f28372a);
        }
    });
    private final h<InterfaceC4942a> _installedSkillDao = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.storage.database.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return AppDatabase_Impl.X(this.f28373a);
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"com/stepos/ailauncher/storage/database/AppDatabase_Impl$a", "Landroidx/room/w;", "Li1/b;", "connection", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Li1/b;)V", Const.INTENT_KEY_PKGNAME, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/room/w$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Li1/b;)Landroidx/room/w$a;", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a extends w {
        public a() {
            super(6, "459ff69df9d212fa5154f57daff035c2", "d5a39466069e3c6e102dab25815c78fa");
        }

        @Override // androidx.room.w
        public void a(InterfaceC4160b connection) {
            p.i(connection, "connection");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `ui_tasks` (`taskId` TEXT NOT NULL, `parentTaskId` TEXT, `conversationId` TEXT, `name` TEXT, `description` TEXT, `coverUri` TEXT, `status` INTEGER NOT NULL, `appUIJson` TEXT, `createTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `version` INTEGER NOT NULL, `toolCallId` TEXT, `error` TEXT, PRIMARY KEY(`taskId`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS `installed_skill` (`slug` TEXT NOT NULL, `displayName` TEXT NOT NULL, `summary` TEXT NOT NULL, `iconUrl` TEXT, `downloadCount` INTEGER NOT NULL, `installKind` TEXT NOT NULL, `installSource` TEXT NOT NULL, `enabled` INTEGER NOT NULL, `installedAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`slug`))");
            C4159a.a(connection, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            C4159a.a(connection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '459ff69df9d212fa5154f57daff035c2')");
        }

        @Override // androidx.room.w
        public void b(InterfaceC4160b connection) {
            p.i(connection, "connection");
            C4159a.a(connection, "DROP TABLE IF EXISTS `ui_tasks`");
            C4159a.a(connection, "DROP TABLE IF EXISTS `installed_skill`");
        }

        @Override // androidx.room.w
        public void f(InterfaceC4160b connection) {
            p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void g(InterfaceC4160b connection) {
            p.i(connection, "connection");
            AppDatabase_Impl.this.K(connection);
        }

        @Override // androidx.room.w
        public void h(InterfaceC4160b connection) {
            p.i(connection, "connection");
        }

        @Override // androidx.room.w
        public void i(InterfaceC4160b connection) {
            p.i(connection, "connection");
            C4031a.a(connection);
        }

        @Override // androidx.room.w
        public w.a j(InterfaceC4160b connection) {
            p.i(connection, "connection");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("taskId", new C4044n.a("taskId", "TEXT", true, 1, null, 1));
            linkedHashMap.put("parentTaskId", new C4044n.a("parentTaskId", "TEXT", false, 0, null, 1));
            linkedHashMap.put("conversationId", new C4044n.a("conversationId", "TEXT", false, 0, null, 1));
            linkedHashMap.put("name", new C4044n.a("name", "TEXT", false, 0, null, 1));
            linkedHashMap.put("description", new C4044n.a("description", "TEXT", false, 0, null, 1));
            linkedHashMap.put("coverUri", new C4044n.a("coverUri", "TEXT", false, 0, null, 1));
            linkedHashMap.put("status", new C4044n.a("status", "INTEGER", true, 0, null, 1));
            linkedHashMap.put("appUIJson", new C4044n.a("appUIJson", "TEXT", false, 0, null, 1));
            linkedHashMap.put("createTime", new C4044n.a("createTime", "INTEGER", true, 0, null, 1));
            linkedHashMap.put("updateTime", new C4044n.a("updateTime", "INTEGER", true, 0, null, 1));
            linkedHashMap.put("version", new C4044n.a("version", "INTEGER", true, 0, null, 1));
            linkedHashMap.put("toolCallId", new C4044n.a("toolCallId", "TEXT", false, 0, null, 1));
            linkedHashMap.put("error", new C4044n.a("error", "TEXT", false, 0, null, 1));
            C4044n c4044n = new C4044n("ui_tasks", linkedHashMap, new LinkedHashSet(), new LinkedHashSet());
            C4044n.Companion companion = C4044n.INSTANCE;
            C4044n c4044nA = companion.a(connection, "ui_tasks");
            if (!c4044n.equals(c4044nA)) {
                return new w.a(false, "ui_tasks(com.stepos.ailauncher.storage.entity.UiTaskEntity).\n Expected:\n" + c4044n + "\n Found:\n" + c4044nA);
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("slug", new C4044n.a("slug", "TEXT", true, 1, null, 1));
            linkedHashMap2.put("displayName", new C4044n.a("displayName", "TEXT", true, 0, null, 1));
            linkedHashMap2.put(c.a.COL_SUMMARY, new C4044n.a(c.a.COL_SUMMARY, "TEXT", true, 0, null, 1));
            linkedHashMap2.put("iconUrl", new C4044n.a("iconUrl", "TEXT", false, 0, null, 1));
            linkedHashMap2.put("downloadCount", new C4044n.a("downloadCount", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("installKind", new C4044n.a("installKind", "TEXT", true, 0, null, 1));
            linkedHashMap2.put("installSource", new C4044n.a("installSource", "TEXT", true, 0, null, 1));
            linkedHashMap2.put(d.EXTRA_ENABLED, new C4044n.a(d.EXTRA_ENABLED, "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("installedAt", new C4044n.a("installedAt", "INTEGER", true, 0, null, 1));
            linkedHashMap2.put("updatedAt", new C4044n.a("updatedAt", "INTEGER", true, 0, null, 1));
            C4044n c4044n2 = new C4044n("installed_skill", linkedHashMap2, new LinkedHashSet(), new LinkedHashSet());
            C4044n c4044nA2 = companion.a(connection, "installed_skill");
            if (c4044n2.equals(c4044nA2)) {
                return new w.a(true, null);
            }
            return new w.a(false, "installed_skill(com.stepos.ailauncher.storage.entity.InstalledSkillEntity).\n Expected:\n" + c4044n2 + "\n Found:\n" + c4044nA2);
        }
    }

    public static final n6.b X(AppDatabase_Impl appDatabase_Impl) {
        return new n6.b(appDatabase_Impl);
    }

    public static final n6.d Y(AppDatabase_Impl appDatabase_Impl) {
        return new n6.d(appDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public w n() {
        return new a();
    }

    @Override // androidx.room.RoomDatabase
    public List<AbstractC3942a> j(Map<InterfaceC5745d<Object>, Object> autoMigrationSpecs) {
        p.i(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker m() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "ui_tasks", "installed_skill");
    }

    @Override // androidx.room.RoomDatabase
    public Set<InterfaceC5745d<Object>> w() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<InterfaceC5745d<?>, List<InterfaceC5745d<?>>> y() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(t.b(n6.c.class), n6.d.INSTANCE.a());
        linkedHashMap.put(t.b(InterfaceC4942a.class), n6.b.INSTANCE.a());
        return linkedHashMap;
    }
}
