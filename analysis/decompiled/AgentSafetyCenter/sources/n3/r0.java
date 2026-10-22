package n3;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: c, reason: collision with root package name */
    public final int f8745c;

    public /* synthetic */ r0(int i) {
        this.f8745c = i;
    }

    public static void a(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i = 0;
        boolean z10 = false;
        while (i <= length) {
            boolean z11 = yb.k.b(str.charAt(!z10 ? i : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length--;
                }
            } else if (z11) {
                i++;
            } else {
                z10 = true;
            }
        }
        if (str.subSequence(i, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e10) {
            Log.w("SupportSQLite", "delete failed: ", e10);
        }
    }

    public abstract void c(z4.c cVar);

    public abstract void d(z4.c cVar, int i, int i3);

    public abstract void f(z4.c cVar);

    public abstract m1 h(m1 m1Var, List list);

    public abstract p5.u i(t0 t0Var, p5.u uVar);

    public abstract void j(z4.c cVar, int i, int i3);

    public void g() {
    }

    public void b(z4.c cVar) {
    }

    public void e(t0 t0Var) {
    }
}
