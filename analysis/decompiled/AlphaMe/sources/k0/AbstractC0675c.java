package k0;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import net.zetetic.database.sqlcipher.SQLiteDatabaseConfiguration;

/* renamed from: k0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0675c {

    /* renamed from: a, reason: collision with root package name */
    public final int f13321a;

    public AbstractC0675c(int i4) {
        this.f13321a = i4;
    }

    public static void a(String str) {
        if (StringsKt__StringsJVMKt.equals(str, SQLiteDatabaseConfiguration.MEMORY_DB_PATH, true)) {
            return;
        }
        int length = str.length() - 1;
        int i4 = 0;
        boolean z4 = false;
        while (i4 <= length) {
            boolean z5 = Intrinsics.compare((int) str.charAt(!z4 ? i4 : length), 32) <= 0;
            if (z4) {
                if (!z5) {
                    break;
                } else {
                    length--;
                }
            } else if (z5) {
                i4++;
            } else {
                z4 = true;
            }
        }
        if (str.subSequence(i4, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            File file = new File(str);
            Intrinsics.checkNotNullParameter(file, "file");
            SQLiteDatabase.deleteDatabase(file);
        } catch (Exception e4) {
            Log.w("SupportSQLite", "delete failed: ", e4);
        }
    }

    public void b(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
    }

    public abstract void c(InterfaceC0674b interfaceC0674b);

    public abstract void d(InterfaceC0674b interfaceC0674b, int i4, int i5);

    public abstract void e(InterfaceC0674b interfaceC0674b);

    public abstract void f(InterfaceC0674b interfaceC0674b, int i4, int i5);
}
