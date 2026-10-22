package y1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.Closeable;
import java.io.File;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface c extends Closeable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13967a;

        public a(int i10) {
            this.f13967a = i10;
        }

        public static void a(String str) {
            if (str.equalsIgnoreCase(":memory:")) {
                return;
            }
            int length = str.length() - 1;
            int i10 = 0;
            boolean z = false;
            while (i10 <= length) {
                boolean z3 = g.g(str.charAt(!z ? i10 : length), 32) <= 0;
                if (z) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i10++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i10, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: ".concat(str));
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e10) {
                Log.w("SupportSQLite", "delete failed: ", e10);
            }
        }

        public abstract void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i10, int i11);

        public abstract void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void f(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i10, int i11);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f13968a;

        /* renamed from: b, reason: collision with root package name */
        public final String f13969b;

        /* renamed from: c, reason: collision with root package name */
        public final a f13970c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f13971d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f13972e;

        public b(Context context, String str, a callback, boolean z, boolean z3) {
            g.f(context, "context");
            g.f(callback, "callback");
            this.f13968a = context;
            this.f13969b = str;
            this.f13970c = callback;
            this.f13971d = z;
            this.f13972e = z3;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: y1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0177c {
        c b(b bVar);
    }

    y1.b n0();

    void setWriteAheadLoggingEnabled(boolean z);
}
