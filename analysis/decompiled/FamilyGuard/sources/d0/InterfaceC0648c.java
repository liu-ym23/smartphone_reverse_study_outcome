package d0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* renamed from: d0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0648c {

    /* renamed from: d0.c$a */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f16573a;

        public a(int i5) {
            this.f16573a = i5;
        }

        private void a(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e6) {
                Log.w("SupportSQLite", "delete failed: ", e6);
            }
        }

        public void b(InterfaceC0647b interfaceC0647b) {
        }

        public void c(InterfaceC0647b interfaceC0647b) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + interfaceC0647b.f0());
            if (!interfaceC0647b.isOpen()) {
                a(interfaceC0647b.f0());
                return;
            }
            List<Pair<String, String>> listH = null;
            try {
                try {
                    listH = interfaceC0647b.h();
                } catch (SQLiteException unused) {
                }
                try {
                    interfaceC0647b.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (listH != null) {
                    Iterator<Pair<String, String>> it = listH.iterator();
                    while (it.hasNext()) {
                        a((String) it.next().second);
                    }
                } else {
                    a(interfaceC0647b.f0());
                }
            }
        }

        public abstract void d(InterfaceC0647b interfaceC0647b);

        public abstract void e(InterfaceC0647b interfaceC0647b, int i5, int i6);

        public void f(InterfaceC0647b interfaceC0647b) {
        }

        public abstract void g(InterfaceC0647b interfaceC0647b, int i5, int i6);
    }

    /* renamed from: d0.c$b */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Context f16574a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16575b;

        /* renamed from: c, reason: collision with root package name */
        public final a f16576c;

        /* renamed from: d0.c$b$a */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            Context f16577a;

            /* renamed from: b, reason: collision with root package name */
            String f16578b;

            /* renamed from: c, reason: collision with root package name */
            a f16579c;

            a(Context context) {
                this.f16577a = context;
            }

            public b a() {
                a aVar = this.f16579c;
                if (aVar == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                Context context = this.f16577a;
                if (context != null) {
                    return new b(context, this.f16578b, aVar);
                }
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            }

            public a b(a aVar) {
                this.f16579c = aVar;
                return this;
            }

            public a c(String str) {
                this.f16578b = str;
                return this;
            }
        }

        b(Context context, String str, a aVar) {
            this.f16574a = context;
            this.f16575b = str;
            this.f16576c = aVar;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* renamed from: d0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0205c {
        InterfaceC0648c a(b bVar);
    }

    void a(boolean z5);

    InterfaceC0647b b();
}
