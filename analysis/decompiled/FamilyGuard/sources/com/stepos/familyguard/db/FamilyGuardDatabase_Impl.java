package com.stepos.familyguard.db;

import Z.e;
import Z.g;
import Z.i;
import b0.C0552a;
import com.stepos.minor.Minor;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;
import java.util.HashMap;
import java.util.HashSet;
import k2.AbstractC0797a;
import k2.AbstractC0809m;
import k2.C0798b;
import k2.C0800d;
import k2.C0802f;
import k2.C0804h;
import k2.C0806j;
import k2.C0808l;
import k2.C0810n;
import k2.C0812p;
import k2.InterfaceC0799c;
import k2.InterfaceC0801e;
import k2.InterfaceC0803g;
import k2.InterfaceC0805i;
import k2.InterfaceC0807k;
import k2.InterfaceC0811o;
import l2.C0837f;
import l2.C0840i;
import l2.C0842k;
import l2.InterfaceC0836e;
import l2.InterfaceC0839h;
import l2.InterfaceC0841j;
import l2.n;
import l2.o;

/* loaded from: classes.dex */
public final class FamilyGuardDatabase_Impl extends FamilyGuardDatabase {

    /* renamed from: L, reason: collision with root package name */
    private volatile AbstractC0797a f14763L;

    /* renamed from: M, reason: collision with root package name */
    private volatile AbstractC0809m f14764M;

    /* renamed from: N, reason: collision with root package name */
    private volatile InterfaceC0805i f14765N;

    /* renamed from: O, reason: collision with root package name */
    private volatile InterfaceC0801e f14766O;

    /* renamed from: P, reason: collision with root package name */
    private volatile InterfaceC0811o f14767P;

    /* renamed from: Q, reason: collision with root package name */
    private volatile InterfaceC0807k f14768Q;

    /* renamed from: R, reason: collision with root package name */
    private volatile InterfaceC0803g f14769R;

    /* renamed from: S, reason: collision with root package name */
    private volatile InterfaceC0799c f14770S;

    /* renamed from: T, reason: collision with root package name */
    private volatile InterfaceC0836e f14771T;

    /* renamed from: U, reason: collision with root package name */
    private volatile InterfaceC0839h f14772U;

    /* renamed from: V, reason: collision with root package name */
    private volatile InterfaceC0841j f14773V;

    /* renamed from: W, reason: collision with root package name */
    private volatile n f14774W;

    class a extends i.a {
        a(int i5) {
            super(i5);
        }

        @Override // Z.i.a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Account` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `type` INTEGER NOT NULL, `status` INTEGER NOT NULL, `phone` TEXT, `imei` TEXT, `featureVersion` INTEGER NOT NULL, `imsi` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `User` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `imsi` TEXT, `imei` TEXT, `phone` TEXT, `role` INTEGER NOT NULL, `serverCode` INTEGER NOT NULL, `serverMessage` TEXT, `code` INTEGER NOT NULL, `message` TEXT, `states` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Relation` (`id` INTEGER, `userId` INTEGER NOT NULL, `lmodify` INTEGER NOT NULL, `postTime` INTEGER NOT NULL, `imsi` TEXT, `imei` TEXT, `phone` TEXT, `status` INTEGER NOT NULL, `watchDays` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mark` INTEGER NOT NULL, `sDeviceType` INTEGER NOT NULL, `isTrack` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `lastAppVersion` INTEGER NOT NULL, `masterRoleType` INTEGER, `masterRoleName` TEXT, `slaveRoleName` TEXT, `isDeleted` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Festival` (`id` INTEGER, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `webUrl` TEXT, `serviceUpdateTime` INTEGER NOT NULL, `delete` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `FestivalEvent` (`id` INTEGER, `festivalId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `url` TEXT, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `position` INTEGER NOT NULL, `left` INTEGER NOT NULL, `top` INTEGER NOT NULL, `right` INTEGER NOT NULL, `bottom` INTEGER NOT NULL, `extra` TEXT, `file` TEXT, `activeTime` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Config` (`id` INTEGER NOT NULL, `lastModify` INTEGER, `updateTime` INTEGER, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `ConfigPhone` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `typeName` TEXT, `durationMin` INTEGER, `durationMax` INTEGER, `behavior` INTEGER, `noticeLevel` INTEGER, `lastUpdate` INTEGER)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `ConfigSms` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `riskCode` TEXT, `noticeLevel` INTEGER, `lastUpdate` INTEGER)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `ConfigSmsPhone` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tag` TEXT, `noticeLevel` INTEGER, `lastUpdate` INTEGER)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationConfig` (`id` INTEGER NOT NULL, `lastLocationTime` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationContent` (`relationId` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `accuracy` REAL NOT NULL, `address` TEXT, `timestamp` INTEGER NOT NULL, `type` INTEGER NOT NULL, PRIMARY KEY(`relationId`, `timestamp`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFence` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `serverId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `name` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `radius` INTEGER NOT NULL, `address` TEXT, `enable` INTEGER NOT NULL, `serialNumber` INTEGER NOT NULL, `version` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `file` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceState` (`id` INTEGER, `relationId` INTEGER NOT NULL, `state` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceNotify` (`relationId` INTEGER NOT NULL, `geoFenceServerId` INTEGER NOT NULL, `eventId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `isIgnore` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceLastedState` (`relationId` INTEGER NOT NULL, `serverId` INTEGER NOT NULL, `state` INTEGER NOT NULL, `sync` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Timeline` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `relationId` INTEGER NOT NULL, `triggerImsi` TEXT, `type` INTEGER NOT NULL, `content` TEXT, `createTime` INTEGER NOT NULL, `number` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineUpload` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `relationId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `content` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineConfig` (`id` INTEGER NOT NULL, `timeQueue` TEXT, `isEnd` INTEGER NOT NULL, `count` INTEGER NOT NULL, `geoFenceCount` INTEGER NOT NULL, `riskCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineState` (`id` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `isIgnore` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BlackList` (`relationId` INTEGER NOT NULL, `phone` TEXT NOT NULL, PRIMARY KEY(`relationId`, `phone`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BlackListUpload` (`relationId` INTEGER NOT NULL, `phone` TEXT NOT NULL, `status` INTEGER NOT NULL, PRIMARY KEY(`relationId`, `phone`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimitCache` (`packageLimitId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `version` INTEGER NOT NULL, PRIMARY KEY(`packageName`, `relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimitCache` (`categoryLimitId` INTEGER NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `version` INTEGER NOT NULL, PRIMARY KEY(`categoryId`, `relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `UsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageUsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `packageName` TEXT, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryUsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `categoryId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `AppPackage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `packageName` TEXT, `label` TEXT, `iconUrl` TEXT, `iconUrlF8` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PickupTimeCache` (`relationId` INTEGER NOT NULL, `pickupTimes` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BatteryInfoCache` (`relationId` INTEGER NOT NULL, `capacity` INTEGER NOT NULL, `averageCurrent` INTEGER NOT NULL, `chargeCounter` INTEGER NOT NULL, `status` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Permission` (`relationId` INTEGER NOT NULL, `digitalHealthLimit` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageCategoryCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `ImsiPhone` (`imsi` TEXT NOT NULL, `phone` TEXT, PRIMARY KEY(`imsi`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PeriodLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `periodLimitId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `remoteVersion` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RawPeriodCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawPeriodId` INTEGER NOT NULL, `weekDayType` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL, `limitCacheId` INTEGER NOT NULL, `remoteVersion` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `StatsDataSetCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `data` TEXT)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            interfaceC0647b.k("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"f00302b5204673a162218cd7fab9a744\")");
        }

        @Override // Z.i.a
        public void b(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `Account`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `User`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Relation`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Festival`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `FestivalEvent`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Config`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `ConfigPhone`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `ConfigSms`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `ConfigSmsPhone`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationConfig`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationContent`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFence`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFenceState`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFenceNotify`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFenceLastedState`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Timeline`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `TimelineUpload`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `TimelineConfig`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `TimelineState`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `BlackList`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `BlackListUpload`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageLimitCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `CategoryLimitCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `UsingTimeStatsCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageUsingTimeStatsCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `CategoryUsingTimeStatsCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `AppPackage`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PickupTimeCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `BatteryInfoCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Permission`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageCategoryCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `ImsiPhone`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `PeriodLimitCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `RawPeriodCache`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `StatsDataSetCache`");
        }

        @Override // Z.i.a
        protected void c(InterfaceC0647b interfaceC0647b) {
            if (((g) FamilyGuardDatabase_Impl.this).f6574g != null) {
                int size = ((g) FamilyGuardDatabase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((g) FamilyGuardDatabase_Impl.this).f6574g.get(i5)).a(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        public void d(InterfaceC0647b interfaceC0647b) {
            ((g) FamilyGuardDatabase_Impl.this).f6568a = interfaceC0647b;
            FamilyGuardDatabase_Impl.this.m(interfaceC0647b);
            if (((g) FamilyGuardDatabase_Impl.this).f6574g != null) {
                int size = ((g) FamilyGuardDatabase_Impl.this).f6574g.size();
                for (int i5 = 0; i5 < size; i5++) {
                    ((g.b) ((g) FamilyGuardDatabase_Impl.this).f6574g.get(i5)).b(interfaceC0647b);
                }
            }
        }

        @Override // Z.i.a
        protected void e(InterfaceC0647b interfaceC0647b) {
            HashMap map = new HashMap(7);
            map.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map.put("status", new C0552a.C0153a("status", "INTEGER", true, 0));
            map.put("phone", new C0552a.C0153a("phone", "TEXT", false, 0));
            map.put("imei", new C0552a.C0153a("imei", "TEXT", false, 0));
            map.put("featureVersion", new C0552a.C0153a("featureVersion", "INTEGER", true, 0));
            map.put("imsi", new C0552a.C0153a("imsi", "TEXT", false, 0));
            C0552a c0552a = new C0552a("Account", map, new HashSet(0), new HashSet(0));
            C0552a c0552aA = C0552a.a(interfaceC0647b, "Account");
            if (!c0552a.equals(c0552aA)) {
                throw new IllegalStateException("Migration didn't properly handle Account(com.stepos.familyguard.db.entity.Account).\n Expected:\n" + c0552a + "\n Found:\n" + c0552aA);
            }
            HashMap map2 = new HashMap(10);
            map2.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map2.put("imsi", new C0552a.C0153a("imsi", "TEXT", false, 0));
            map2.put("imei", new C0552a.C0153a("imei", "TEXT", false, 0));
            map2.put("phone", new C0552a.C0153a("phone", "TEXT", false, 0));
            map2.put("role", new C0552a.C0153a("role", "INTEGER", true, 0));
            map2.put("serverCode", new C0552a.C0153a("serverCode", "INTEGER", true, 0));
            map2.put("serverMessage", new C0552a.C0153a("serverMessage", "TEXT", false, 0));
            map2.put("code", new C0552a.C0153a("code", "INTEGER", true, 0));
            map2.put("message", new C0552a.C0153a("message", "TEXT", false, 0));
            map2.put("states", new C0552a.C0153a("states", "INTEGER", true, 0));
            C0552a c0552a2 = new C0552a("User", map2, new HashSet(0), new HashSet(0));
            C0552a c0552aA2 = C0552a.a(interfaceC0647b, "User");
            if (!c0552a2.equals(c0552aA2)) {
                throw new IllegalStateException("Migration didn't properly handle User(com.stepos.familyguard.db.entity.User).\n Expected:\n" + c0552a2 + "\n Found:\n" + c0552aA2);
            }
            HashMap map3 = new HashMap(19);
            map3.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map3.put("userId", new C0552a.C0153a("userId", "INTEGER", true, 0));
            map3.put("lmodify", new C0552a.C0153a("lmodify", "INTEGER", true, 0));
            map3.put("postTime", new C0552a.C0153a("postTime", "INTEGER", true, 0));
            map3.put("imsi", new C0552a.C0153a("imsi", "TEXT", false, 0));
            map3.put("imei", new C0552a.C0153a("imei", "TEXT", false, 0));
            map3.put("phone", new C0552a.C0153a("phone", "TEXT", false, 0));
            map3.put("status", new C0552a.C0153a("status", "INTEGER", true, 0));
            map3.put("watchDays", new C0552a.C0153a("watchDays", "INTEGER", true, 0));
            map3.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map3.put("mark", new C0552a.C0153a("mark", "INTEGER", true, 0));
            map3.put("sDeviceType", new C0552a.C0153a("sDeviceType", "INTEGER", true, 0));
            map3.put("isTrack", new C0552a.C0153a("isTrack", "INTEGER", true, 0));
            map3.put("appVersion", new C0552a.C0153a("appVersion", "INTEGER", true, 0));
            map3.put("lastAppVersion", new C0552a.C0153a("lastAppVersion", "INTEGER", true, 0));
            map3.put("masterRoleType", new C0552a.C0153a("masterRoleType", "INTEGER", false, 0));
            map3.put("masterRoleName", new C0552a.C0153a("masterRoleName", "TEXT", false, 0));
            map3.put("slaveRoleName", new C0552a.C0153a("slaveRoleName", "TEXT", false, 0));
            map3.put("isDeleted", new C0552a.C0153a("isDeleted", "INTEGER", true, 0));
            C0552a c0552a3 = new C0552a("Relation", map3, new HashSet(0), new HashSet(0));
            C0552a c0552aA3 = C0552a.a(interfaceC0647b, "Relation");
            if (!c0552a3.equals(c0552aA3)) {
                throw new IllegalStateException("Migration didn't properly handle Relation(com.stepos.familyguard.db.entity.Relation).\n Expected:\n" + c0552a3 + "\n Found:\n" + c0552aA3);
            }
            HashMap map4 = new HashMap(8);
            map4.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map4.put("start", new C0552a.C0153a("start", "INTEGER", true, 0));
            map4.put("end", new C0552a.C0153a("end", "INTEGER", true, 0));
            map4.put("webUrl", new C0552a.C0153a("webUrl", "TEXT", false, 0));
            map4.put("serviceUpdateTime", new C0552a.C0153a("serviceUpdateTime", "INTEGER", true, 0));
            map4.put("delete", new C0552a.C0153a("delete", "INTEGER", true, 0));
            map4.put("createTime", new C0552a.C0153a("createTime", "INTEGER", true, 0));
            map4.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a4 = new C0552a("Festival", map4, new HashSet(0), new HashSet(0));
            C0552a c0552aA4 = C0552a.a(interfaceC0647b, "Festival");
            if (!c0552a4.equals(c0552aA4)) {
                throw new IllegalStateException("Migration didn't properly handle Festival(com.stepos.familyguard.db.entity.Festival).\n Expected:\n" + c0552a4 + "\n Found:\n" + c0552aA4);
            }
            HashMap map5 = new HashMap(17);
            map5.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map5.put("festivalId", new C0552a.C0153a("festivalId", "INTEGER", true, 0));
            map5.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map5.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map5.put("url", new C0552a.C0153a("url", "TEXT", false, 0));
            map5.put("width", new C0552a.C0153a("width", "INTEGER", true, 0));
            map5.put("height", new C0552a.C0153a("height", "INTEGER", true, 0));
            map5.put("position", new C0552a.C0153a("position", "INTEGER", true, 0));
            map5.put("left", new C0552a.C0153a("left", "INTEGER", true, 0));
            map5.put("top", new C0552a.C0153a("top", "INTEGER", true, 0));
            map5.put("right", new C0552a.C0153a("right", "INTEGER", true, 0));
            map5.put("bottom", new C0552a.C0153a("bottom", "INTEGER", true, 0));
            map5.put("extra", new C0552a.C0153a("extra", "TEXT", false, 0));
            map5.put("file", new C0552a.C0153a("file", "TEXT", false, 0));
            map5.put("activeTime", new C0552a.C0153a("activeTime", "INTEGER", true, 0));
            map5.put("createTime", new C0552a.C0153a("createTime", "INTEGER", true, 0));
            map5.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a5 = new C0552a("FestivalEvent", map5, new HashSet(0), new HashSet(0));
            C0552a c0552aA5 = C0552a.a(interfaceC0647b, "FestivalEvent");
            if (!c0552a5.equals(c0552aA5)) {
                throw new IllegalStateException("Migration didn't properly handle FestivalEvent(com.stepos.familyguard.db.entity.FestivalEvent).\n Expected:\n" + c0552a5 + "\n Found:\n" + c0552aA5);
            }
            HashMap map6 = new HashMap(3);
            map6.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map6.put("lastModify", new C0552a.C0153a("lastModify", "INTEGER", false, 0));
            map6.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", false, 0));
            C0552a c0552a6 = new C0552a("Config", map6, new HashSet(0), new HashSet(0));
            C0552a c0552aA6 = C0552a.a(interfaceC0647b, "Config");
            if (!c0552a6.equals(c0552aA6)) {
                throw new IllegalStateException("Migration didn't properly handle Config(com.stepos.familyguard.db.entity.Config).\n Expected:\n" + c0552a6 + "\n Found:\n" + c0552aA6);
            }
            HashMap map7 = new HashMap(7);
            map7.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map7.put("typeName", new C0552a.C0153a("typeName", "TEXT", false, 0));
            map7.put("durationMin", new C0552a.C0153a("durationMin", "INTEGER", false, 0));
            map7.put("durationMax", new C0552a.C0153a("durationMax", "INTEGER", false, 0));
            map7.put("behavior", new C0552a.C0153a("behavior", "INTEGER", false, 0));
            map7.put("noticeLevel", new C0552a.C0153a("noticeLevel", "INTEGER", false, 0));
            map7.put("lastUpdate", new C0552a.C0153a("lastUpdate", "INTEGER", false, 0));
            C0552a c0552a7 = new C0552a("ConfigPhone", map7, new HashSet(0), new HashSet(0));
            C0552a c0552aA7 = C0552a.a(interfaceC0647b, "ConfigPhone");
            if (!c0552a7.equals(c0552aA7)) {
                throw new IllegalStateException("Migration didn't properly handle ConfigPhone(com.stepos.familyguard.db.entity.ConfigPhone).\n Expected:\n" + c0552a7 + "\n Found:\n" + c0552aA7);
            }
            HashMap map8 = new HashMap(4);
            map8.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map8.put("riskCode", new C0552a.C0153a("riskCode", "TEXT", false, 0));
            map8.put("noticeLevel", new C0552a.C0153a("noticeLevel", "INTEGER", false, 0));
            map8.put("lastUpdate", new C0552a.C0153a("lastUpdate", "INTEGER", false, 0));
            C0552a c0552a8 = new C0552a("ConfigSms", map8, new HashSet(0), new HashSet(0));
            C0552a c0552aA8 = C0552a.a(interfaceC0647b, "ConfigSms");
            if (!c0552a8.equals(c0552aA8)) {
                throw new IllegalStateException("Migration didn't properly handle ConfigSms(com.stepos.familyguard.db.entity.ConfigSms).\n Expected:\n" + c0552a8 + "\n Found:\n" + c0552aA8);
            }
            HashMap map9 = new HashMap(4);
            map9.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map9.put("tag", new C0552a.C0153a("tag", "TEXT", false, 0));
            map9.put("noticeLevel", new C0552a.C0153a("noticeLevel", "INTEGER", false, 0));
            map9.put("lastUpdate", new C0552a.C0153a("lastUpdate", "INTEGER", false, 0));
            C0552a c0552a9 = new C0552a("ConfigSmsPhone", map9, new HashSet(0), new HashSet(0));
            C0552a c0552aA9 = C0552a.a(interfaceC0647b, "ConfigSmsPhone");
            if (!c0552a9.equals(c0552aA9)) {
                throw new IllegalStateException("Migration didn't properly handle ConfigSmsPhone(com.stepos.familyguard.db.entity.ConfigSmsPhone).\n Expected:\n" + c0552a9 + "\n Found:\n" + c0552aA9);
            }
            HashMap map10 = new HashMap(3);
            map10.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map10.put("lastLocationTime", new C0552a.C0153a("lastLocationTime", "INTEGER", true, 0));
            map10.put("lastUpdateTime", new C0552a.C0153a("lastUpdateTime", "INTEGER", true, 0));
            C0552a c0552a10 = new C0552a("LocationConfig", map10, new HashSet(0), new HashSet(0));
            C0552a c0552aA10 = C0552a.a(interfaceC0647b, "LocationConfig");
            if (!c0552a10.equals(c0552aA10)) {
                throw new IllegalStateException("Migration didn't properly handle LocationConfig(com.stepos.familyguard.db.entity.LocationConfig).\n Expected:\n" + c0552a10 + "\n Found:\n" + c0552aA10);
            }
            HashMap map11 = new HashMap(7);
            map11.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map11.put("latitude", new C0552a.C0153a("latitude", "REAL", true, 0));
            map11.put("longitude", new C0552a.C0153a("longitude", "REAL", true, 0));
            map11.put("accuracy", new C0552a.C0153a("accuracy", "REAL", true, 0));
            map11.put("address", new C0552a.C0153a("address", "TEXT", false, 0));
            map11.put("timestamp", new C0552a.C0153a("timestamp", "INTEGER", true, 2));
            map11.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            C0552a c0552a11 = new C0552a("LocationContent", map11, new HashSet(0), new HashSet(0));
            C0552a c0552aA11 = C0552a.a(interfaceC0647b, "LocationContent");
            if (!c0552a11.equals(c0552aA11)) {
                throw new IllegalStateException("Migration didn't properly handle LocationContent(com.stepos.familyguard.db.entity.LocationContent).\n Expected:\n" + c0552a11 + "\n Found:\n" + c0552aA11);
            }
            HashMap map12 = new HashMap(15);
            map12.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map12.put("serverId", new C0552a.C0153a("serverId", "INTEGER", true, 0));
            map12.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map12.put(Minor.COLUMN_NAME, new C0552a.C0153a(Minor.COLUMN_NAME, "TEXT", false, 0));
            map12.put("latitude", new C0552a.C0153a("latitude", "REAL", true, 0));
            map12.put("longitude", new C0552a.C0153a("longitude", "REAL", true, 0));
            map12.put("radius", new C0552a.C0153a("radius", "INTEGER", true, 0));
            map12.put("address", new C0552a.C0153a("address", "TEXT", false, 0));
            map12.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map12.put("serialNumber", new C0552a.C0153a("serialNumber", "INTEGER", true, 0));
            map12.put("version", new C0552a.C0153a("version", "INTEGER", true, 0));
            map12.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            map12.put("createTime", new C0552a.C0153a("createTime", "INTEGER", true, 0));
            map12.put("deleted", new C0552a.C0153a("deleted", "INTEGER", true, 0));
            map12.put("file", new C0552a.C0153a("file", "TEXT", false, 0));
            C0552a c0552a12 = new C0552a("LocationGeoFence", map12, new HashSet(0), new HashSet(0));
            C0552a c0552aA12 = C0552a.a(interfaceC0647b, "LocationGeoFence");
            if (!c0552a12.equals(c0552aA12)) {
                throw new IllegalStateException("Migration didn't properly handle LocationGeoFence(com.stepos.familyguard.db.entity.LocationGeoFence).\n Expected:\n" + c0552a12 + "\n Found:\n" + c0552aA12);
            }
            HashMap map13 = new HashMap(4);
            map13.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map13.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map13.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map13.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a13 = new C0552a("LocationGeoFenceState", map13, new HashSet(0), new HashSet(0));
            C0552a c0552aA13 = C0552a.a(interfaceC0647b, "LocationGeoFenceState");
            if (!c0552a13.equals(c0552aA13)) {
                throw new IllegalStateException("Migration didn't properly handle LocationGeoFenceState(com.stepos.familyguard.db.entity.LocationGeoFenceState).\n Expected:\n" + c0552a13 + "\n Found:\n" + c0552aA13);
            }
            HashMap map14 = new HashMap(5);
            map14.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map14.put("geoFenceServerId", new C0552a.C0153a("geoFenceServerId", "INTEGER", true, 0));
            map14.put("eventId", new C0552a.C0153a("eventId", "INTEGER", true, 0));
            map14.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map14.put("isIgnore", new C0552a.C0153a("isIgnore", "INTEGER", true, 0));
            C0552a c0552a14 = new C0552a("LocationGeoFenceNotify", map14, new HashSet(0), new HashSet(0));
            C0552a c0552aA14 = C0552a.a(interfaceC0647b, "LocationGeoFenceNotify");
            if (!c0552a14.equals(c0552aA14)) {
                throw new IllegalStateException("Migration didn't properly handle LocationGeoFenceNotify(com.stepos.familyguard.db.entity.LocationGeoFenceNotify).\n Expected:\n" + c0552a14 + "\n Found:\n" + c0552aA14);
            }
            HashMap map15 = new HashMap(5);
            map15.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map15.put("serverId", new C0552a.C0153a("serverId", "INTEGER", true, 0));
            map15.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map15.put("sync", new C0552a.C0153a("sync", "INTEGER", true, 0));
            map15.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a15 = new C0552a("LocationGeoFenceLastedState", map15, new HashSet(0), new HashSet(0));
            C0552a c0552aA15 = C0552a.a(interfaceC0647b, "LocationGeoFenceLastedState");
            if (!c0552a15.equals(c0552aA15)) {
                throw new IllegalStateException("Migration didn't properly handle LocationGeoFenceLastedState(com.stepos.familyguard.db.entity.LocationGeoFenceLastedState).\n Expected:\n" + c0552a15 + "\n Found:\n" + c0552aA15);
            }
            HashMap map16 = new HashMap(7);
            map16.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map16.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map16.put("triggerImsi", new C0552a.C0153a("triggerImsi", "TEXT", false, 0));
            map16.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map16.put("content", new C0552a.C0153a("content", "TEXT", false, 0));
            map16.put("createTime", new C0552a.C0153a("createTime", "INTEGER", true, 0));
            map16.put("number", new C0552a.C0153a("number", "TEXT", false, 0));
            C0552a c0552a16 = new C0552a("Timeline", map16, new HashSet(0), new HashSet(0));
            C0552a c0552aA16 = C0552a.a(interfaceC0647b, "Timeline");
            if (!c0552a16.equals(c0552aA16)) {
                throw new IllegalStateException("Migration didn't properly handle Timeline(com.stepos.familyguard.db.entity.Timeline).\n Expected:\n" + c0552a16 + "\n Found:\n" + c0552aA16);
            }
            HashMap map17 = new HashMap(4);
            map17.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", false, 1));
            map17.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map17.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map17.put("content", new C0552a.C0153a("content", "TEXT", false, 0));
            C0552a c0552a17 = new C0552a("TimelineUpload", map17, new HashSet(0), new HashSet(0));
            C0552a c0552aA17 = C0552a.a(interfaceC0647b, "TimelineUpload");
            if (!c0552a17.equals(c0552aA17)) {
                throw new IllegalStateException("Migration didn't properly handle TimelineUpload(com.stepos.familyguard.db.entity.TimelineUpload).\n Expected:\n" + c0552a17 + "\n Found:\n" + c0552aA17);
            }
            HashMap map18 = new HashMap(6);
            map18.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map18.put("timeQueue", new C0552a.C0153a("timeQueue", "TEXT", false, 0));
            map18.put("isEnd", new C0552a.C0153a("isEnd", "INTEGER", true, 0));
            map18.put("count", new C0552a.C0153a("count", "INTEGER", true, 0));
            map18.put("geoFenceCount", new C0552a.C0153a("geoFenceCount", "INTEGER", true, 0));
            map18.put("riskCount", new C0552a.C0153a("riskCount", "INTEGER", true, 0));
            C0552a c0552a18 = new C0552a("TimelineConfig", map18, new HashSet(0), new HashSet(0));
            C0552a c0552aA18 = C0552a.a(interfaceC0647b, "TimelineConfig");
            if (!c0552a18.equals(c0552aA18)) {
                throw new IllegalStateException("Migration didn't properly handle TimelineConfig(com.stepos.familyguard.db.entity.TimelineConfig).\n Expected:\n" + c0552a18 + "\n Found:\n" + c0552aA18);
            }
            HashMap map19 = new HashMap(4);
            map19.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map19.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map19.put("isRead", new C0552a.C0153a("isRead", "INTEGER", true, 0));
            map19.put("isIgnore", new C0552a.C0153a("isIgnore", "INTEGER", true, 0));
            C0552a c0552a19 = new C0552a("TimelineState", map19, new HashSet(0), new HashSet(0));
            C0552a c0552aA19 = C0552a.a(interfaceC0647b, "TimelineState");
            if (!c0552a19.equals(c0552aA19)) {
                throw new IllegalStateException("Migration didn't properly handle TimelineState(com.stepos.familyguard.db.entity.TimelineState).\n Expected:\n" + c0552a19 + "\n Found:\n" + c0552aA19);
            }
            HashMap map20 = new HashMap(2);
            map20.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map20.put("phone", new C0552a.C0153a("phone", "TEXT", true, 2));
            C0552a c0552a20 = new C0552a("BlackList", map20, new HashSet(0), new HashSet(0));
            C0552a c0552aA20 = C0552a.a(interfaceC0647b, "BlackList");
            if (!c0552a20.equals(c0552aA20)) {
                throw new IllegalStateException("Migration didn't properly handle BlackList(com.stepos.familyguard.db.entity.BlackList).\n Expected:\n" + c0552a20 + "\n Found:\n" + c0552aA20);
            }
            HashMap map21 = new HashMap(3);
            map21.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map21.put("phone", new C0552a.C0153a("phone", "TEXT", true, 2));
            map21.put("status", new C0552a.C0153a("status", "INTEGER", true, 0));
            C0552a c0552a21 = new C0552a("BlackListUpload", map21, new HashSet(0), new HashSet(0));
            C0552a c0552aA21 = C0552a.a(interfaceC0647b, "BlackListUpload");
            if (!c0552a21.equals(c0552aA21)) {
                throw new IllegalStateException("Migration didn't properly handle BlackListUpload(com.stepos.familyguard.db.entity.BlackListUpload).\n Expected:\n" + c0552a21 + "\n Found:\n" + c0552aA21);
            }
            HashMap map22 = new HashMap(11);
            map22.put("packageLimitId", new C0552a.C0153a("packageLimitId", "INTEGER", true, 0));
            map22.put("packageName", new C0552a.C0153a("packageName", "TEXT", true, 1));
            map22.put("workdayLimit", new C0552a.C0153a("workdayLimit", "INTEGER", true, 0));
            map22.put("offDayLimit", new C0552a.C0153a("offDayLimit", "INTEGER", true, 0));
            map22.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map22.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map22.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map22.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map22.put("lastHandleTime", new C0552a.C0153a("lastHandleTime", "INTEGER", true, 0));
            map22.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 2));
            map22.put("version", new C0552a.C0153a("version", "INTEGER", true, 0));
            C0552a c0552a22 = new C0552a("PackageLimitCache", map22, new HashSet(0), new HashSet(0));
            C0552a c0552aA22 = C0552a.a(interfaceC0647b, "PackageLimitCache");
            if (!c0552a22.equals(c0552aA22)) {
                throw new IllegalStateException("Migration didn't properly handle PackageLimitCache(com.stepos.familyguard.db.entity.PackageLimitCache).\n Expected:\n" + c0552a22 + "\n Found:\n" + c0552aA22);
            }
            HashMap map23 = new HashMap(11);
            map23.put("categoryLimitId", new C0552a.C0153a("categoryLimitId", "INTEGER", true, 0));
            map23.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 1));
            map23.put("workdayLimit", new C0552a.C0153a("workdayLimit", "INTEGER", true, 0));
            map23.put("offDayLimit", new C0552a.C0153a("offDayLimit", "INTEGER", true, 0));
            map23.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map23.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map23.put("state", new C0552a.C0153a("state", "INTEGER", true, 0));
            map23.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map23.put("lastHandleTime", new C0552a.C0153a("lastHandleTime", "INTEGER", true, 0));
            map23.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 2));
            map23.put("version", new C0552a.C0153a("version", "INTEGER", true, 0));
            C0552a c0552a23 = new C0552a("CategoryLimitCache", map23, new HashSet(0), new HashSet(0));
            C0552a c0552aA23 = C0552a.a(interfaceC0647b, "CategoryLimitCache");
            if (!c0552a23.equals(c0552aA23)) {
                throw new IllegalStateException("Migration didn't properly handle CategoryLimitCache(com.stepos.familyguard.db.entity.CategoryLimitCache).\n Expected:\n" + c0552a23 + "\n Found:\n" + c0552aA23);
            }
            HashMap map24 = new HashMap(6);
            map24.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map24.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map24.put("startTime", new C0552a.C0153a("startTime", "INTEGER", true, 0));
            map24.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            map24.put("usingTime", new C0552a.C0153a("usingTime", "INTEGER", true, 0));
            map24.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            C0552a c0552a24 = new C0552a("UsingTimeStatsCache", map24, new HashSet(0), new HashSet(0));
            C0552a c0552aA24 = C0552a.a(interfaceC0647b, "UsingTimeStatsCache");
            if (!c0552a24.equals(c0552aA24)) {
                throw new IllegalStateException("Migration didn't properly handle UsingTimeStatsCache(com.stepos.familyguard.db.entity.UsingTimeStatsCache).\n Expected:\n" + c0552a24 + "\n Found:\n" + c0552aA24);
            }
            HashMap map25 = new HashMap(7);
            map25.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map25.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map25.put("startTime", new C0552a.C0153a("startTime", "INTEGER", true, 0));
            map25.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            map25.put("usingTime", new C0552a.C0153a("usingTime", "INTEGER", true, 0));
            map25.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map25.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            C0552a c0552a25 = new C0552a("PackageUsingTimeStatsCache", map25, new HashSet(0), new HashSet(0));
            C0552a c0552aA25 = C0552a.a(interfaceC0647b, "PackageUsingTimeStatsCache");
            if (!c0552a25.equals(c0552aA25)) {
                throw new IllegalStateException("Migration didn't properly handle PackageUsingTimeStatsCache(com.stepos.familyguard.db.entity.PackageUsingTimeStatsCache).\n Expected:\n" + c0552a25 + "\n Found:\n" + c0552aA25);
            }
            HashMap map26 = new HashMap(7);
            map26.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map26.put("interval", new C0552a.C0153a("interval", "INTEGER", true, 0));
            map26.put("startTime", new C0552a.C0153a("startTime", "INTEGER", true, 0));
            map26.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            map26.put("usingTime", new C0552a.C0153a("usingTime", "INTEGER", true, 0));
            map26.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map26.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            C0552a c0552a26 = new C0552a("CategoryUsingTimeStatsCache", map26, new HashSet(0), new HashSet(0));
            C0552a c0552aA26 = C0552a.a(interfaceC0647b, "CategoryUsingTimeStatsCache");
            if (!c0552a26.equals(c0552aA26)) {
                throw new IllegalStateException("Migration didn't properly handle CategoryUsingTimeStatsCache(com.stepos.familyguard.db.entity.CategoryUsingTimeStatsCache).\n Expected:\n" + c0552a26 + "\n Found:\n" + c0552aA26);
            }
            HashMap map27 = new HashMap(6);
            map27.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map27.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map27.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map27.put("label", new C0552a.C0153a("label", "TEXT", false, 0));
            map27.put("iconUrl", new C0552a.C0153a("iconUrl", "TEXT", false, 0));
            map27.put("iconUrlF8", new C0552a.C0153a("iconUrlF8", "TEXT", false, 0));
            C0552a c0552a27 = new C0552a("AppPackage", map27, new HashSet(0), new HashSet(0));
            C0552a c0552aA27 = C0552a.a(interfaceC0647b, "AppPackage");
            if (!c0552a27.equals(c0552aA27)) {
                throw new IllegalStateException("Migration didn't properly handle AppPackage(com.stepos.familyguard.db.entity.AppPackage).\n Expected:\n" + c0552a27 + "\n Found:\n" + c0552aA27);
            }
            HashMap map28 = new HashMap(2);
            map28.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map28.put("pickupTimes", new C0552a.C0153a("pickupTimes", "INTEGER", true, 0));
            C0552a c0552a28 = new C0552a("PickupTimeCache", map28, new HashSet(0), new HashSet(0));
            C0552a c0552aA28 = C0552a.a(interfaceC0647b, "PickupTimeCache");
            if (!c0552a28.equals(c0552aA28)) {
                throw new IllegalStateException("Migration didn't properly handle PickupTimeCache(com.stepos.familyguard.db.entity.PickupTimeCache).\n Expected:\n" + c0552a28 + "\n Found:\n" + c0552aA28);
            }
            HashMap map29 = new HashMap(5);
            map29.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map29.put("capacity", new C0552a.C0153a("capacity", "INTEGER", true, 0));
            map29.put("averageCurrent", new C0552a.C0153a("averageCurrent", "INTEGER", true, 0));
            map29.put("chargeCounter", new C0552a.C0153a("chargeCounter", "INTEGER", true, 0));
            map29.put("status", new C0552a.C0153a("status", "INTEGER", true, 0));
            C0552a c0552a29 = new C0552a("BatteryInfoCache", map29, new HashSet(0), new HashSet(0));
            C0552a c0552aA29 = C0552a.a(interfaceC0647b, "BatteryInfoCache");
            if (!c0552a29.equals(c0552aA29)) {
                throw new IllegalStateException("Migration didn't properly handle BatteryInfoCache(com.stepos.familyguard.db.entity.BatteryInfoCache).\n Expected:\n" + c0552a29 + "\n Found:\n" + c0552aA29);
            }
            HashMap map30 = new HashMap(3);
            map30.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 1));
            map30.put("digitalHealthLimit", new C0552a.C0153a("digitalHealthLimit", "INTEGER", true, 0));
            map30.put("updateTime", new C0552a.C0153a("updateTime", "INTEGER", true, 0));
            C0552a c0552a30 = new C0552a("Permission", map30, new HashSet(0), new HashSet(0));
            C0552a c0552aA30 = C0552a.a(interfaceC0647b, "Permission");
            if (!c0552a30.equals(c0552aA30)) {
                throw new IllegalStateException("Migration didn't properly handle Permission(com.stepos.familyguard.db.entity.Permission).\n Expected:\n" + c0552a30 + "\n Found:\n" + c0552aA30);
            }
            HashMap map31 = new HashMap(4);
            map31.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map31.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map31.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            map31.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            C0552a c0552a31 = new C0552a("PackageCategoryCache", map31, new HashSet(0), new HashSet(0));
            C0552a c0552aA31 = C0552a.a(interfaceC0647b, "PackageCategoryCache");
            if (!c0552a31.equals(c0552aA31)) {
                throw new IllegalStateException("Migration didn't properly handle PackageCategoryCache(com.stepos.familyguard.db.entity.PackageCategoryCache).\n Expected:\n" + c0552a31 + "\n Found:\n" + c0552aA31);
            }
            HashMap map32 = new HashMap(2);
            map32.put("imsi", new C0552a.C0153a("imsi", "TEXT", true, 1));
            map32.put("phone", new C0552a.C0153a("phone", "TEXT", false, 0));
            C0552a c0552a32 = new C0552a("ImsiPhone", map32, new HashSet(0), new HashSet(0));
            C0552a c0552aA32 = C0552a.a(interfaceC0647b, "ImsiPhone");
            if (!c0552a32.equals(c0552aA32)) {
                throw new IllegalStateException("Migration didn't properly handle ImsiPhone(com.stepos.familyguard.db.entity.ImsiPhone).\n Expected:\n" + c0552a32 + "\n Found:\n" + c0552aA32);
            }
            HashMap map33 = new HashMap(9);
            map33.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map33.put("periodLimitId", new C0552a.C0153a("periodLimitId", "INTEGER", true, 0));
            map33.put("type", new C0552a.C0153a("type", "INTEGER", true, 0));
            map33.put("packageName", new C0552a.C0153a("packageName", "TEXT", false, 0));
            map33.put("categoryId", new C0552a.C0153a("categoryId", "INTEGER", true, 0));
            map33.put("notifyOnly", new C0552a.C0153a("notifyOnly", "INTEGER", true, 0));
            map33.put("enable", new C0552a.C0153a("enable", "INTEGER", true, 0));
            map33.put("remoteVersion", new C0552a.C0153a("remoteVersion", "INTEGER", true, 0));
            map33.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            C0552a c0552a33 = new C0552a("PeriodLimitCache", map33, new HashSet(0), new HashSet(0));
            C0552a c0552aA33 = C0552a.a(interfaceC0647b, "PeriodLimitCache");
            if (!c0552a33.equals(c0552aA33)) {
                throw new IllegalStateException("Migration didn't properly handle PeriodLimitCache(com.stepos.familyguard.db.entity.PeriodLimitCache).\n Expected:\n" + c0552a33 + "\n Found:\n" + c0552aA33);
            }
            HashMap map34 = new HashMap(8);
            map34.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map34.put("rawPeriodId", new C0552a.C0153a("rawPeriodId", "INTEGER", true, 0));
            map34.put("weekDayType", new C0552a.C0153a("weekDayType", "INTEGER", true, 0));
            map34.put("start", new C0552a.C0153a("start", "INTEGER", true, 0));
            map34.put("end", new C0552a.C0153a("end", "INTEGER", true, 0));
            map34.put("limitCacheId", new C0552a.C0153a("limitCacheId", "INTEGER", true, 0));
            map34.put("remoteVersion", new C0552a.C0153a("remoteVersion", "INTEGER", true, 0));
            map34.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            C0552a c0552a34 = new C0552a("RawPeriodCache", map34, new HashSet(0), new HashSet(0));
            C0552a c0552aA34 = C0552a.a(interfaceC0647b, "RawPeriodCache");
            if (!c0552a34.equals(c0552aA34)) {
                throw new IllegalStateException("Migration didn't properly handle RawPeriodCache(com.stepos.familyguard.db.entity.RawPeriodCache).\n Expected:\n" + c0552a34 + "\n Found:\n" + c0552aA34);
            }
            HashMap map35 = new HashMap(3);
            map35.put(Minor.COLUMN_ID, new C0552a.C0153a(Minor.COLUMN_ID, "INTEGER", true, 1));
            map35.put("relationId", new C0552a.C0153a("relationId", "INTEGER", true, 0));
            map35.put("data", new C0552a.C0153a("data", "TEXT", false, 0));
            C0552a c0552a35 = new C0552a("StatsDataSetCache", map35, new HashSet(0), new HashSet(0));
            C0552a c0552aA35 = C0552a.a(interfaceC0647b, "StatsDataSetCache");
            if (c0552a35.equals(c0552aA35)) {
                return;
            }
            throw new IllegalStateException("Migration didn't properly handle StatsDataSetCache(com.stepos.familyguard.db.entity.StatsDataSetCache).\n Expected:\n" + c0552a35 + "\n Found:\n" + c0552aA35);
        }
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0807k A() {
        InterfaceC0807k interfaceC0807k;
        if (this.f14768Q != null) {
            return this.f14768Q;
        }
        synchronized (this) {
            try {
                if (this.f14768Q == null) {
                    this.f14768Q = new C0808l(this);
                }
                interfaceC0807k = this.f14768Q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0807k;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0839h B() {
        InterfaceC0839h interfaceC0839h;
        if (this.f14772U != null) {
            return this.f14772U;
        }
        synchronized (this) {
            try {
                if (this.f14772U == null) {
                    this.f14772U = new C0840i(this);
                }
                interfaceC0839h = this.f14772U;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0839h;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0841j C() {
        InterfaceC0841j interfaceC0841j;
        if (this.f14773V != null) {
            return this.f14773V;
        }
        synchronized (this) {
            try {
                if (this.f14773V == null) {
                    this.f14773V = new C0842k(this);
                }
                interfaceC0841j = this.f14773V;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0841j;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public AbstractC0809m D() {
        AbstractC0809m abstractC0809m;
        if (this.f14764M != null) {
            return this.f14764M;
        }
        synchronized (this) {
            try {
                if (this.f14764M == null) {
                    this.f14764M = new C0810n(this);
                }
                abstractC0809m = this.f14764M;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0809m;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public n E() {
        n nVar;
        if (this.f14774W != null) {
            return this.f14774W;
        }
        synchronized (this) {
            try {
                if (this.f14774W == null) {
                    this.f14774W = new o(this);
                }
                nVar = this.f14774W;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0811o F() {
        InterfaceC0811o interfaceC0811o;
        if (this.f14767P != null) {
            return this.f14767P;
        }
        synchronized (this) {
            try {
                if (this.f14767P == null) {
                    this.f14767P = new C0812p(this);
                }
                interfaceC0811o = this.f14767P;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0811o;
    }

    @Override // Z.g
    protected e d() {
        return new e(this, "Account", "User", "Relation", "Festival", "FestivalEvent", "Config", "ConfigPhone", "ConfigSms", "ConfigSmsPhone", "LocationConfig", "LocationContent", "LocationGeoFence", "LocationGeoFenceState", "LocationGeoFenceNotify", "LocationGeoFenceLastedState", "Timeline", "TimelineUpload", "TimelineConfig", "TimelineState", "BlackList", "BlackListUpload", "PackageLimitCache", "CategoryLimitCache", "UsingTimeStatsCache", "PackageUsingTimeStatsCache", "CategoryUsingTimeStatsCache", "AppPackage", "PickupTimeCache", "BatteryInfoCache", "Permission", "PackageCategoryCache", "ImsiPhone", "PeriodLimitCache", "RawPeriodCache", "StatsDataSetCache");
    }

    @Override // Z.g
    protected InterfaceC0648c e(Z.a aVar) {
        return aVar.f6531a.a(InterfaceC0648c.b.a(aVar.f6532b).c(aVar.f6533c).b(new i(aVar, new a(29), "f00302b5204673a162218cd7fab9a744", "b24ca6df0f406fb9c4c9ebef4a6b4464")).a());
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public AbstractC0797a t() {
        AbstractC0797a abstractC0797a;
        if (this.f14763L != null) {
            return this.f14763L;
        }
        synchronized (this) {
            try {
                if (this.f14763L == null) {
                    this.f14763L = new C0798b(this);
                }
                abstractC0797a = this.f14763L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractC0797a;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0799c u() {
        InterfaceC0799c interfaceC0799c;
        if (this.f14770S != null) {
            return this.f14770S;
        }
        synchronized (this) {
            try {
                if (this.f14770S == null) {
                    this.f14770S = new C0800d(this);
                }
                interfaceC0799c = this.f14770S;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0799c;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0801e v() {
        InterfaceC0801e interfaceC0801e;
        if (this.f14766O != null) {
            return this.f14766O;
        }
        synchronized (this) {
            try {
                if (this.f14766O == null) {
                    this.f14766O = new C0802f(this);
                }
                interfaceC0801e = this.f14766O;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0801e;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0803g w() {
        InterfaceC0803g interfaceC0803g;
        if (this.f14769R != null) {
            return this.f14769R;
        }
        synchronized (this) {
            try {
                if (this.f14769R == null) {
                    this.f14769R = new C0804h(this);
                }
                interfaceC0803g = this.f14769R;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0803g;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0836e y() {
        InterfaceC0836e interfaceC0836e;
        if (this.f14771T != null) {
            return this.f14771T;
        }
        synchronized (this) {
            try {
                if (this.f14771T == null) {
                    this.f14771T = new C0837f(this);
                }
                interfaceC0836e = this.f14771T;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0836e;
    }

    @Override // com.stepos.familyguard.db.FamilyGuardDatabase
    public InterfaceC0805i z() {
        InterfaceC0805i interfaceC0805i;
        if (this.f14765N != null) {
            return this.f14765N;
        }
        synchronized (this) {
            try {
                if (this.f14765N == null) {
                    this.f14765N = new C0806j(this);
                }
                interfaceC0805i = this.f14765N;
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC0805i;
    }
}
