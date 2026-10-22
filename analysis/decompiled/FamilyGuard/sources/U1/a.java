package U1;

import a0.AbstractC0407a;
import android.content.Context;
import com.stepos.digitalwellbeing.DigitalWellbeingDataBase;
import d0.InterfaceC0647b;
import f2.C0702g;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f5440b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f5441c = false;

    /* renamed from: d, reason: collision with root package name */
    private static final AbstractC0407a f5442d = new C0083a(1, 2);

    /* renamed from: e, reason: collision with root package name */
    private static final AbstractC0407a f5443e = new b(2, 3);

    /* renamed from: f, reason: collision with root package name */
    private static final AbstractC0407a f5444f = new c(3, 4);

    /* renamed from: g, reason: collision with root package name */
    private static final AbstractC0407a f5445g = new d(4, 5);

    /* renamed from: h, reason: collision with root package name */
    private static final AbstractC0407a f5446h = new e(5, 6);

    /* renamed from: i, reason: collision with root package name */
    private static final AbstractC0407a f5447i = new f(6, 7);

    /* renamed from: a, reason: collision with root package name */
    private final DigitalWellbeingDataBase f5448a;

    /* renamed from: U1.a$a, reason: collision with other inner class name */
    class C0083a extends AbstractC0407a {
        C0083a(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageLimit`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL)");
            interfaceC0647b.k("DROP TABLE IF EXISTS `CategoryLimit`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL)");
        }
    }

    class b extends AbstractC0407a {
        b(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS `PackageLimit`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PackageLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `packageName` TEXT, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `adminId` INTEGER NOT NULL)");
            interfaceC0647b.k("DROP TABLE IF EXISTS `CategoryLimit`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `CategoryLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `categoryId` INTEGER NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `adminId` INTEGER NOT NULL)");
        }
    }

    class c extends AbstractC0407a {
        c(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `WorkdayAdjustEntity` (`time` INTEGER NOT NULL, `workday` INTEGER NOT NULL, PRIMARY KEY(`time`))");
        }
    }

    class d extends AbstractC0407a {
        d(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("ALTER TABLE 'PackageLimit' ADD COLUMN `isChild` INTEGER NOT NULL DEFAULT 0");
            interfaceC0647b.k("ALTER TABLE 'CategoryLimit' ADD COLUMN `isChild` INTEGER NOT NULL DEFAULT 0");
        }
    }

    class e extends AbstractC0407a {
        e(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'PeriodLimit'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `PeriodLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `packageName` TEXT, `categoryId` INTEGER NOT NULL, `adminId` INTEGER  NOT NULL, `notifyOnly` INTEGER  NOT NULL, `isChild` INTEGER  NOT NULL, `enable` INTEGER  NOT NULL, `version` INTEGER  NOT NULL )");
            interfaceC0647b.k("DROP TABLE IF EXISTS 'RawPeriod'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RawPeriod` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `weekDayType` INTEGER NOT NULL, `start` INTEGER NOT NULL, `end` INTEGER NOT NULL , `limitId` INTEGER  NOT NULL )");
            interfaceC0647b.k("DROP TABLE IF EXISTS 'RipePeriod'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `RipePeriod` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `time` INTEGER NOT NULL, `limitId` INTEGER  NOT NULL ,`limitType` INTEGER NOT NULL, `adminId` INTEGER NOT NULL, `limitPackageName` TEXT, `limitCategoryId` INTEGER NOT NULL, `version` INTEGER NOT NULL, `type` INTEGER NOT NULL, `mergedWeekDayType` INTEGER NOT NULL )");
        }
    }

    class f extends AbstractC0407a {
        f(int i5, int i6) {
            super(i5, i6);
        }

        @Override // a0.AbstractC0407a
        public void a(InterfaceC0647b interfaceC0647b) {
            interfaceC0647b.k("DROP TABLE IF EXISTS 'suspended_record'");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS 'suspended_record' ('packageName' TEXT PRIMARY KEY NOT NULL, 'flags' INTEGER NOT NULL, 'updateTime' INTEGER NOT NULL)");
            interfaceC0647b.k("DROP TABLE IF EXISTS `GlobalLimit`");
            interfaceC0647b.k("CREATE TABLE IF NOT EXISTS `GlobalLimit` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `workdayLimit` INTEGER NOT NULL, `offDayLimit` INTEGER NOT NULL, `notifyOnly` INTEGER NOT NULL, `state` INTEGER NOT NULL, `enable` INTEGER NOT NULL, `interval` INTEGER NOT NULL, `lastHandleTime` INTEGER NOT NULL, `isChild` INTEGER  NOT NULL, `adminId` INTEGER NOT NULL)");
            C0702g.b("DDBS", "migrate 6 to 7");
            a.f5441c = true;
        }
    }

    private a(Context context) {
        this.f5448a = (DigitalWellbeingDataBase) Z.f.a(context, DigitalWellbeingDataBase.class, "digitalWellbeingDataBase").b(f5442d).b(f5443e).b(f5444f).b(f5445g).b(f5446h).b(f5447i).c();
    }

    public static synchronized a c(Context context) {
        try {
            if (f5440b == null) {
                f5440b = new a(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5440b;
    }

    public static boolean d() {
        return f5441c;
    }

    public DigitalWellbeingDataBase b() {
        return this.f5448a;
    }
}
