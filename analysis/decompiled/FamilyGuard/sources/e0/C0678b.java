package e0;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;

/* renamed from: e0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0678b implements InterfaceC0648c {

    /* renamed from: a, reason: collision with root package name */
    private final a f16638a;

    /* renamed from: e0.b$a */
    static class a extends SQLiteOpenHelper {

        /* renamed from: a, reason: collision with root package name */
        final C0677a[] f16639a;

        /* renamed from: b, reason: collision with root package name */
        final InterfaceC0648c.a f16640b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f16641c;

        /* renamed from: e0.b$a$a, reason: collision with other inner class name */
        class C0209a implements DatabaseErrorHandler {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0677a[] f16642a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ InterfaceC0648c.a f16643b;

            C0209a(C0677a[] c0677aArr, InterfaceC0648c.a aVar) {
                this.f16642a = c0677aArr;
                this.f16643b = aVar;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                C0677a c0677a = this.f16642a[0];
                if (c0677a != null) {
                    this.f16643b.c(c0677a);
                }
            }
        }

        a(Context context, String str, C0677a[] c0677aArr, InterfaceC0648c.a aVar) {
            super(context, str, null, aVar.f16573a, new C0209a(c0677aArr, aVar));
            this.f16640b = aVar;
            this.f16639a = c0677aArr;
        }

        C0677a a(SQLiteDatabase sQLiteDatabase) {
            if (this.f16639a[0] == null) {
                this.f16639a[0] = new C0677a(sQLiteDatabase);
            }
            return this.f16639a[0];
        }

        synchronized InterfaceC0647b c() {
            this.f16641c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.f16641c) {
                return a(writableDatabase);
            }
            close();
            return c();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f16639a[0] = null;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f16640b.b(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f16640b.d(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            this.f16641c = true;
            this.f16640b.e(a(sQLiteDatabase), i5, i6);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.f16641c) {
                return;
            }
            this.f16640b.f(a(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
            this.f16641c = true;
            this.f16640b.g(a(sQLiteDatabase), i5, i6);
        }
    }

    C0678b(Context context, String str, InterfaceC0648c.a aVar) {
        this.f16638a = c(context, str, aVar);
    }

    private a c(Context context, String str, InterfaceC0648c.a aVar) {
        return new a(context, str, new C0677a[1], aVar);
    }

    @Override // d0.InterfaceC0648c
    public void a(boolean z5) {
        this.f16638a.setWriteAheadLoggingEnabled(z5);
    }

    @Override // d0.InterfaceC0648c
    public InterfaceC0647b b() {
        return this.f16638a.c();
    }
}
