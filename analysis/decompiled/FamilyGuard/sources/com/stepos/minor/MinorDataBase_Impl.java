package com.stepos.minor;

import F2.A;
import F2.B;
import F2.e;
import F2.f;
import Z.g;
import Z.i;
import b0.C0552a;
import com.stepos.minor.state.MinorStateEntity;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class MinorDataBase_Impl extends MinorDataBase {

    /* renamed from: i, reason: collision with root package name */
    private volatile e f15362i;

    /* renamed from: j, reason: collision with root package name */
    private volatile A f15363j;

    class a extends i.a {
        a(int i5) {
            super(i5);
        }

        @Override // Z.i.a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `minor` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `icon` BLOB, `birthType` INTEGER NOT NULL, `birthdayDate` INTEGER NOT NULL, `birthdayDateLunar` INTEGER NOT NULL, `birthdayAge` INTEGER NOT NULL, `birthdayRange` INTEGER NOT NULL, `state` INTEGER NOT NULL, `age_range` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `minor_state_entity` (`id` INTEGER NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `whitelist_app` (`minor_id` INTEGER NOT NULL, `package_name` TEXT NOT NULL, `removable` INTEGER NOT NULL, PRIMARY KEY(`package_name`, `minor_id`), FOREIGN KEY(`minor_id`) REFERENCES `minor`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            interfaceC0647b.k("CREATE  INDEX `index_whitelist_app_minor_id` ON `whitelist_app` (`minor_id`)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC0647b.k("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"bc31ec7516625848af20cbe41ba9fdfc\")");
        }

        @Override // Z.i.a
        public void b(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `minor`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `minor_state_entity`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `whitelist_app`");
        }

        @Override // Z.i.a
        protected void c(InterfaceC0647b interfaceC0647b) {
            if (((g) MinorDataBase_Impl.this).f6574g != null) {
                int size = ((g) MinorDataBase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((g) MinorDataBase_Impl.this).f6574g.get(i5)).a(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        public void d(InterfaceC0647b interfaceC0647b) {
            ((g) MinorDataBase_Impl.this).f6568a = interfaceC0647b;
            interfaceC0647b.k("PRAGMA foreign_keys = ON");
            MinorDataBase_Impl.this.m(interfaceC0647b);
            if (((g) MinorDataBase_Impl.this).f6574g != null) {
                int size = ((g) MinorDataBase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((g) MinorDataBase_Impl.this).f6574g.get(i5)).b(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        protected void e(InterfaceC0647b interfaceC0647b) {
            HashMap map = new HashMap(10);
            map.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map.put(Minor.COLUMN_NAME, new C0552a.C0153a(Minor.COLUMN_NAME, "TEXT", false, 0));
            map.put(Minor.COLUMN_ICON, new C0552a.C0153a(Minor.COLUMN_ICON, "BLOB", false, 0));
            map.put(Minor.COLUMN_BIRTHDAY_TYPE, new C0552a.C0153a(Minor.COLUMN_BIRTHDAY_TYPE, "INTEGER", true, 0));
            map.put(Minor.COLUMN_BIRTHDAY_DATE, new C0552a.C0153a(Minor.COLUMN_BIRTHDAY_DATE, "INTEGER", true, 0));
            map.put(Minor.COLUMN_BIRTHDAY_DATE_LUNAR, new C0552a.C0153a(Minor.COLUMN_BIRTHDAY_DATE_LUNAR, "INTEGER", true, 0));
            map.put(Minor.COLUMN_BIRTHDAY_AGE, new C0552a.C0153a(Minor.COLUMN_BIRTHDAY_AGE, "INTEGER", true, 0));
            map.put(Minor.COLUMN_BIRTHDAY_RANGE, new C0552a.C0153a(Minor.COLUMN_BIRTHDAY_RANGE, "INTEGER", true, 0));
            map.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map.put(Minor.COLUMN_AGE_RANGE, new C0552a.C0153a(Minor.COLUMN_AGE_RANGE, "INTEGER", true, 0));
            C0552a c0552a = new C0552a(Minor.TABLE_NAME, map, new HashSet(0), new HashSet(0));
            C0552a c0552aA = C0552a.a(interfaceC0647b, Minor.TABLE_NAME);
            if (!c0552a.equals(c0552aA)) {
                throw new IllegalStateException("Migration didn't properly handle minor(com.stepos.minor.Minor).\n Expected:\n" + c0552a + "\n Found:\n" + c0552aA);
            }
            HashMap map2 = new HashMap(2);
            map2.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map2.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            C0552a c0552a2 = new C0552a(MinorStateEntity.TABLE_NAME, map2, new HashSet(0), new HashSet(0));
            C0552a c0552aA2 = C0552a.a(interfaceC0647b, MinorStateEntity.TABLE_NAME);
            if (!c0552a2.equals(c0552aA2)) {
                throw new IllegalStateException("Migration didn't properly handle minor_state_entity(com.stepos.minor.state.MinorStateEntity).\n Expected:\n" + c0552a2 + "\n Found:\n" + c0552aA2);
            }
            HashMap map3 = new HashMap(3);
            map3.put(WhitelistApp.COLUMN_MINOR_ID, new C0552a.C0153a(WhitelistApp.COLUMN_MINOR_ID, "INTEGER", true, 2));
            map3.put(WhitelistApp.COLUMN_PACKAGE_NAME, new C0552a.C0153a(WhitelistApp.COLUMN_PACKAGE_NAME, "TEXT", true, 1));
            map3.put(WhitelistApp.COLUMN_REMOVABLE, new C0552a.C0153a(WhitelistApp.COLUMN_REMOVABLE, "INTEGER", true, 0));
            HashSet hashSet = new HashSet(1);
            hashSet.add(new C0552a.b(Minor.TABLE_NAME, "CASCADE", "NO ACTION", Arrays.asList(WhitelistApp.COLUMN_MINOR_ID), Arrays.asList(Minor.COLUMN_ID)));
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new C0552a.d("index_whitelist_app_minor_id", false, Arrays.asList(WhitelistApp.COLUMN_MINOR_ID)));
            C0552a c0552a3 = new C0552a(WhitelistApp.TABLE_NAME, map3, hashSet, hashSet2);
            C0552a c0552aA3 = C0552a.a(interfaceC0647b, WhitelistApp.TABLE_NAME);
            if (c0552a3.equals(c0552aA3)) {
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle whitelist_app(com.stepos.minor.WhitelistApp).\n Expected:\n" + c0552a3 + "\n Found:\n" + c0552aA3);
        }
    }

    @Override // Z.g
    protected Z.e d() {
        return new Z.e(this, Minor.TABLE_NAME, MinorStateEntity.TABLE_NAME, WhitelistApp.TABLE_NAME);
    }

    @Override // Z.g
    protected InterfaceC0648c e(Z.a aVar) {
        return aVar.f6531a.a(InterfaceC0648c.b.a(aVar.f6532b).c(aVar.f6533c).b(new i(aVar, new a(1), "bc31ec7516625848af20cbe41ba9fdfc", "88ea114e84c6bc9152665d9fbecb7d80")).a());
    }

    @Override // com.stepos.minor.MinorDataBase
    public e t() {
        e eVar;
        if (this.f15362i != null) {
            return this.f15362i;
        }
        synchronized (this) {
            try {
                if (this.f15362i == null) {
                    this.f15362i = new f(this);
                }
                eVar = this.f15362i;
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    @Override // com.stepos.minor.MinorDataBase
    public A u() {
        A a6;
        if (this.f15363j != null) {
            return this.f15363j;
        }
        synchronized (this) {
            try {
                if (this.f15363j == null) {
                    this.f15363j = new B(this);
                }
                a6 = this.f15363j;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a6;
    }
}
