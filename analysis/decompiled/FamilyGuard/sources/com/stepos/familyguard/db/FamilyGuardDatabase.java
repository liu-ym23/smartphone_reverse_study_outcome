package com.stepos.familyguard.db;

import P1.a;
import a0.AbstractC0407a;
import d0.InterfaceC0647b;
import k2.AbstractC0797a;
import k2.AbstractC0809m;
import k2.InterfaceC0799c;
import k2.InterfaceC0801e;
import k2.InterfaceC0803g;
import k2.InterfaceC0805i;
import k2.InterfaceC0807k;
import k2.InterfaceC0811o;
import l2.InterfaceC0836e;
import l2.InterfaceC0839h;
import l2.InterfaceC0841j;

/* loaded from: classes.dex */
public abstract class FamilyGuardDatabase extends Z.g {

    /* renamed from: i, reason: collision with root package name */
    private static volatile FamilyGuardDatabase f14745i;

    /* renamed from: j, reason: collision with root package name */
    private static final AbstractC0407a f14746j = new k(27, 28);

    /* renamed from: k, reason: collision with root package name */
    private static final AbstractC0407a f14747k = new u(28, 29);

    /* renamed from: l, reason: collision with root package name */
    private static final AbstractC0407a f14748l = new v(1, 2);

    /* renamed from: m, reason: collision with root package name */
    private static final AbstractC0407a f14749m = new w(2, 3);

    /* renamed from: n, reason: collision with root package name */
    private static final AbstractC0407a f14750n = new x(3, 4);

    /* renamed from: o, reason: collision with root package name */
    private static final AbstractC0407a f14751o = new y(4, 5);

    /* renamed from: p, reason: collision with root package name */
    private static final AbstractC0407a f14752p = new z(5, 6);

    /* renamed from: q, reason: collision with root package name */
    private static final AbstractC0407a f14753q = new A(6, 7);

    /* renamed from: r, reason: collision with root package name */
    private static final AbstractC0407a f14754r = new B(7, 8);

    /* renamed from: s, reason: collision with root package name */
    private static final AbstractC0407a f14755s = new C0590a(8, 9);

    /* renamed from: t, reason: collision with root package name */
    private static final AbstractC0407a f14756t = new C0591b(9, 10);

    /* renamed from: u, reason: collision with root package name */
    private static final AbstractC0407a f14757u = new c(10, 11);

    /* renamed from: v, reason: collision with root package name */
    private static final AbstractC0407a f14758v = new d(11, 12);

    /* renamed from: w, reason: collision with root package name */
    private static final AbstractC0407a f14759w = new e(12, 13);

    /* renamed from: x, reason: collision with root package name */
    private static final AbstractC0407a f14760x = new f(13, 14);

    /* renamed from: y, reason: collision with root package name */
    private static final AbstractC0407a f14761y = new g(14, 15);

    /* renamed from: z, reason: collision with root package name */
    private static final AbstractC0407a f14762z = new h(15, 16);

    /* renamed from: A, reason: collision with root package name */
    private static final AbstractC0407a f14734A = new i(16, 17);

    /* renamed from: B, reason: collision with root package name */
    private static final AbstractC0407a f14735B = new j(17, 18);

    /* renamed from: C, reason: collision with root package name */
    private static final AbstractC0407a f14736C = new l(18, 19);

    /* renamed from: D, reason: collision with root package name */
    private static final AbstractC0407a f14737D = new m(19, 20);

    /* renamed from: E, reason: collision with root package name */
    private static final AbstractC0407a f14738E = new n(20, 21);

    /* renamed from: F, reason: collision with root package name */
    private static final AbstractC0407a f14739F = new o(21, 22);

    /* renamed from: G, reason: collision with root package name */
    private static final AbstractC0407a f14740G = new p(22, 23);

    /* renamed from: H, reason: collision with root package name */
    private static final AbstractC0407a f14741H = new q(23, 24);

    /* renamed from: I, reason: collision with root package name */
    private static final AbstractC0407a f14742I = new r(24, 25);

    /* renamed from: J, reason: collision with root package name */
    private static final AbstractC0407a f14743J = new s(25, 26);

    /* renamed from: K, reason: collision with root package name */
    private static final AbstractC0407a f14744K = new t(26, 27);

    class A extends AbstractC0407a {
        A(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `AppPackage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `packageName` TEXT)");
        }
    }

    class B extends AbstractC0407a {
        B(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFenceState`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceState` (`id` INTEGER, `relationId` INTEGER NOT NULL, `state` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    /* renamed from: com.stepos.familyguard.db.FamilyGuardDatabase$a, reason: case insensitive filesystem */
    class C0590a extends AbstractC0407a {
        C0590a(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BatteryInfoCache` (`relationId` INTEGER NOT NULL, `capacity` INTEGER NOT NULL, `averageCurrent` INTEGER NOT NULL, `chargeCounter` INTEGER NOT NULL, `status` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PickupTimeCache` (`relationId` INTEGER NOT NULL, `pickupTimes` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
        }
    }

    /* renamed from: com.stepos.familyguard.db.FamilyGuardDatabase$b, reason: case insensitive filesystem */
    class C0591b extends AbstractC0407a {
        C0591b(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `Relation`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Relation` (`id` INTEGER, `userId` INTEGER NOT NULL, `lmodify` INTEGER NOT NULL, `postTime` INTEGER NOT NULL, `imsi` TEXT, `imei` TEXT, `phone` TEXT, `status` INTEGER NOT NULL, `watchDays` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mark` INTEGER NOT NULL, `sDeviceType` INTEGER NOT NULL, `isTrack` INTEGER NOT NULL, `hasLimitPermission` INTEGER NOT NULL, `masterRoleType` INTEGER, `masterRoleName` TEXT, `slaveRoleName` TEXT, PRIMARY KEY(`id`))");
        }
    }

    class c extends AbstractC0407a {
        c(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineState` (`id` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `isIgnore` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceNotify` (`relationId` INTEGER NOT NULL, `geoFenceServerId` INTEGER NOT NULL, `eventId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `isIgnore` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
            interfaceC0647b.k("DELETE FROM `Timeline`");
            interfaceC0647b.k("DROP TABLE IF EXISTS `TimelineConfig`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineConfig` (`id` INTEGER NOT NULL, `timeQueue` TEXT, `isEnd` INTEGER NOT NULL, `count` INTEGER NOT NULL, `geoFenceCount` INTEGER NOT NULL, `riskCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    class d extends AbstractC0407a {
        d(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `Relation`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Relation` (`id` INTEGER, `userId` INTEGER NOT NULL, `lmodify` INTEGER NOT NULL, `postTime` INTEGER NOT NULL, `imsi` TEXT, `imei` TEXT, `phone` TEXT, `status` INTEGER NOT NULL, `watchDays` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mark` INTEGER NOT NULL, `sDeviceType` INTEGER NOT NULL, `isTrack` INTEGER NOT NULL, `masterRoleType` INTEGER, `masterRoleName` TEXT, `slaveRoleName` TEXT, PRIMARY KEY(`id`))");
            interfaceC0647b.k("DROP TABLE IF EXISTS `Permission`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Permission` (`relationId` INTEGER NOT NULL, `digitalHealthLimit` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
        }
    }

    class e extends AbstractC0407a {
        e(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE `Relation` ADD `isDeleted` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class f extends AbstractC0407a {
        f(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `Timeline`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Timeline` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `relationId` INTEGER NOT NULL, `triggerImsi` TEXT, `type` INTEGER NOT NULL, `content` TEXT, `createTime` INTEGER NOT NULL, `number` TEXT)");
        }
    }

    class g extends AbstractC0407a {
        g(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageCategoryCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
        }
    }

    class h extends AbstractC0407a {
        h(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'PackageLimitCache'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageLimitId` INTEGER NOT NULL, `packageName` TEXT, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("DROP TABLE IF EXISTS 'CategoryLimitCache'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `categoryLimitId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
        }
    }

    class i extends AbstractC0407a {
        i(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'AppPackage'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `AppPackage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `packageName` TEXT, `label` TEXT)");
        }
    }

    class j extends AbstractC0407a {
        j(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'AppPackage'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `AppPackage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `packageName` TEXT, `label` TEXT, `iconUrl` TEXT)");
        }
    }

    class k extends AbstractC0407a {
        k(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `StatsDataSetCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `data` TEXT, `relationId` INTEGER NOT NULL )");
        }
    }

    class l extends AbstractC0407a {
        l(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE `Permission`ADD COLUMN `updateTime` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class m extends AbstractC0407a {
        m(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'PackageLimitCache'");
            interfaceC0647b.k("DROP TABLE IF EXISTS 'CategoryLimitCache'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimitCache` (`packageLimitId` INTEGER NOT NULL, `packageName` TEXT NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `version` INTEGER NOT NULL, PRIMARY KEY(`packageName`, `relationId`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimitCache` (`categoryLimitId` INTEGER NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `version` INTEGER NOT NULL, PRIMARY KEY(`categoryId`, `relationId`))");
        }
    }

    class n extends AbstractC0407a {
        n(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE `Relation` ADD `flymeVersion` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class o extends AbstractC0407a {
        o(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE `Relation` ADD `appVersion` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class p extends AbstractC0407a {
        p(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `ImsiPhone` (`imsi` TEXT NOT NULL, `phone` TEXT, PRIMARY KEY(`imsi`))");
        }
    }

    class q extends AbstractC0407a {
        q(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFenceLastedState` (`relationId` INTEGER NOT NULL, `serverId` INTEGER NOT NULL, `state` INTEGER NOT NULL, `sync` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, PRIMARY KEY(`relationId`))");
        }
    }

    class r extends AbstractC0407a {
        r(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE `Relation` ADD `lastAppVersion` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class s extends AbstractC0407a {
        s(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'AppPackage'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `AppPackage` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `relationId` INTEGER NOT NULL, `packageName` TEXT, `label` TEXT, `iconUrl` TEXT, `iconUrlF8` TEXT)");
        }
    }

    class t extends AbstractC0407a {
        t(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'PeriodLimitCache'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PeriodLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `periodLimitId` INTEGER NOT NULL, `type` INTEGER NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `notifyOnly` INTEGER  NOT NULL, `enable` INTEGER  NOT NULL, `remoteVersion` INTEGER  NOT NULL, `relationId` INTEGER NOT NULL )");
            interfaceC0647b.k("DROP TABLE IF EXISTS 'RawPeriodCache'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RawPeriodCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `rawPeriodId` INTEGER NOT NULL, `weekDayType` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL , `limitCacheId` INTEGER  NOT NULL, `remoteVersion` INTEGER  NOT NULL, `relationId` INTEGER NOT NULL )");
        }
    }

    class u extends AbstractC0407a {
        u(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Relation_new` (`id` INTEGER PRIMARY KEY NOT NULL, `userId` INTEGER NOT NULL, `lmodify` INTEGER NOT NULL, `postTime` INTEGER NOT NULL, `imsi` TEXT, `imei` TEXT, `phone` TEXT, `status` INTEGER NOT NULL, `watchDays` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mark` INTEGER NOT NULL, `sDeviceType` INTEGER NOT NULL, `isTrack` INTEGER NOT NULL, `appVersion` INTEGER NOT NULL, `lastAppVersion` INTEGER NOT NULL, `masterRoleType` INTEGER, `masterRoleName` TEXT, `slaveRoleName` TEXT, `isDeleted` INTEGER NOT NULL)");
            interfaceC0647b.k("INSERT INTO `Relation_new` (`id`, `userId`, `lmodify`, `postTime`, `imsi`, `imei`, `phone`, `status`, `watchDays`, `type`, `mark`, `sDeviceType`, `isTrack`, `appVersion`, `lastAppVersion`, `masterRoleType`, `masterRoleName`, `slaveRoleName`, `isDeleted`) SELECT `id`, `userId`, `lmodify`, `postTime`, `imsi`, `imei`, `phone`, `status`, `watchDays`, `type`, `mark`, `sDeviceType`, `isTrack`, `appVersion`, `lastAppVersion`, `masterRoleType`, `masterRoleName`, `slaveRoleName`, `isDeleted` FROM `Relation`");
            interfaceC0647b.k("DROP TABLE `Relation`");
            interfaceC0647b.k("ALTER TABLE `Relation_new` RENAME TO `Relation`");
        }
    }

    class v extends AbstractC0407a {
        v(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationConfig`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationConfig` (`id` INTEGER NOT NULL, `lastLocationTime` INTEGER NOT NULL, `lastUpdateTime` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        }
    }

    class w extends AbstractC0407a {
        w(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `LocationGeoFence`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `LocationGeoFence` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `serverId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `name` TEXT, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `radius` INTEGER NOT NULL, `address` TEXT, `enable` INTEGER NOT NULL, `serialNumber` INTEGER NOT NULL, `version` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `createTime` INTEGER NOT NULL, `deleted` INTEGER NOT NULL, `file` TEXT)");
        }
    }

    class x extends AbstractC0407a {
        x(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineUpload` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `relationId` INTEGER NOT NULL,  `type` INTEGER NOT NULL, `content` TEXT)");
        }
    }

    class y extends AbstractC0407a {
        y(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `Timeline`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `Timeline` (`id` INTEGER, `relationId` INTEGER NOT NULL, `triggerImsi` TEXT, `type` INTEGER NOT NULL, `content` TEXT, `createTime` INTEGER NOT NULL, `number` TEXT, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `TimelineConfig` (`id` INTEGER NOT NULL, `timeQueue` TEXT, `isEnd` INTEGER NOT NULL, PRIMARY KEY(`id`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BlackList` (`relationId` INTEGER NOT NULL, `phone` TEXT NOT NULL, PRIMARY KEY(`relationId`, `phone`))");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `BlackListUpload` (`relationId` INTEGER NOT NULL, `phone` TEXT NOT NULL, `status` INTEGER NOT NULL, PRIMARY KEY(`relationId`, `phone`))");
        }
    }

    class z extends AbstractC0407a {
        z(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageLimitId` INTEGER NOT NULL, `packageName` TEXT, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimitCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `categoryLimitId` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `UsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageUsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `packageName` TEXT, `relationId` INTEGER NOT NULL)");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryUsingTimeStatsCache` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `interval` INTEGER NOT NULL, `startTime` INTEGER NOT NULL, `updateTime` INTEGER NOT NULL, `usingTime` INTEGER NOT NULL, `relationId` INTEGER NOT NULL, `categoryId` INTEGER NOT NULL)");
        }
    }

    public static FamilyGuardDatabase x() {
        if (f14745i == null) {
            synchronized (FamilyGuardDatabase.class) {
                try {
                    if (f14745i == null) {
                        f14745i = (FamilyGuardDatabase) Z.f.a(a.a(), FamilyGuardDatabase.class, "stepos_family_guard.db").b(f14748l).b(f14749m).b(f14750n).b(f14751o).b(f14752p).b(f14753q).b(f14754r).b(f14755s).b(f14756t).b(f14757u).b(f14758v).b(f14759w).b(f14760x).b(f14761y).b(f14762z).b(f14734A).b(f14735B).b(f14736C).b(f14737D).b(f14738E).b(f14739F).b(f14740G).b(f14741H).b(f14742I).b(f14743J).b(f14744K).b(f14746j).b(f14747k).c();
                    }
                } finally {
                }
            }
        }
        return f14745i;
    }

    public abstract InterfaceC0807k A();

    public abstract InterfaceC0839h B();

    public abstract InterfaceC0841j C();

    public abstract AbstractC0809m D();

    public abstract l2.n E();

    public abstract InterfaceC0811o F();

    public abstract AbstractC0797a t();

    public abstract InterfaceC0799c u();

    public abstract InterfaceC0801e v();

    public abstract InterfaceC0803g w();

    public abstract InterfaceC0836e y();

    public abstract InterfaceC0805i z();
}
