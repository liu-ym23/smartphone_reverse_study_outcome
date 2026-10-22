package aj5;

import android.app.Application;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.util.db.a f3932a;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.b("Benefit_DataManager", "onCreate()... ");
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.b("Benefit_DataManager", "onOpen()... ");
        }
    }

    public final b a() {
        monitor-enter(this);
        BenefitDatabase r100 = (BenefitDatabase) this.f3932a.r1("benefit.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100.c();
    L7:
        th = move-exception;
        throw th;
    }

    public f(Application r100, com.bytedance.ee.util.db.a r101) {
        this.f3932a = r101;
        DBController.a r102 = new DBController.a(r100);
        r102.f243099a = "benefit.db";
        r102.f243100b = BenefitDatabase.class;
        r102.f243102d = new a();
        r101.W3("benefit.db", r102);
    }
}
