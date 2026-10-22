package Z7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;

/* loaded from: classes4.dex */
public abstract class N {

    /* renamed from: a, reason: collision with root package name */
    public int f7336a;

    /* renamed from: b, reason: collision with root package name */
    public String f7337b;

    /* renamed from: c, reason: collision with root package name */
    public String f7338c;

    public abstract String[] a();

    public abstract void b(Context context, boolean z10, V7.a aVar);

    public void c(SQLiteDatabase sQLiteDatabase) {
    }

    public void d(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (a() == null) {
                return;
            }
            for (String str : a()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
            }
            c(sQLiteDatabase);
        } catch (Throwable th) {
            if (C1139k.g(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void e(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (a() == null) {
                return;
            }
            for (String str : a()) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(str)));
            }
            c(sQLiteDatabase);
        } catch (Throwable th) {
            if (C1139k.g(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void f(StrategyBean strategyBean) {
    }
}
