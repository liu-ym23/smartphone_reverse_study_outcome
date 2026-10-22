package Z;

import a0.AbstractC0407a;
import android.database.Cursor;
import d0.C0646a;
import d0.InterfaceC0647b;
import d0.InterfaceC0648c;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class i extends InterfaceC0648c.a {

    /* renamed from: b, reason: collision with root package name */
    private Z.a f6593b;

    /* renamed from: c, reason: collision with root package name */
    private final a f6594c;

    /* renamed from: d, reason: collision with root package name */
    private final String f6595d;

    /* renamed from: e, reason: collision with root package name */
    private final String f6596e;

    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f6597a;

        public a(int i5) {
            this.f6597a = i5;
        }

        protected abstract void a(InterfaceC0647b interfaceC0647b);

        protected abstract void b(InterfaceC0647b interfaceC0647b);

        protected abstract void c(InterfaceC0647b interfaceC0647b);

        protected abstract void d(InterfaceC0647b interfaceC0647b);

        protected abstract void e(InterfaceC0647b interfaceC0647b);
    }

    public i(Z.a aVar, a aVar2, String str, String str2) {
        super(aVar2.f6597a);
        this.f6593b = aVar;
        this.f6594c = aVar2;
        this.f6595d = str;
        this.f6596e = str2;
    }

    private void h(InterfaceC0647b interfaceC0647b) {
        if (j(interfaceC0647b)) {
            Cursor cursorA0 = interfaceC0647b.a0(new C0646a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                string = cursorA0.moveToFirst() ? cursorA0.getString(0) : null;
            } finally {
                cursorA0.close();
            }
        }
        if (!this.f6595d.equals(string) && !this.f6596e.equals(string)) {
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
        }
    }

    private void i(InterfaceC0647b interfaceC0647b) {
        interfaceC0647b.k("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(InterfaceC0647b interfaceC0647b) {
        Cursor cursorD = interfaceC0647b.d("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z5 = false;
            if (cursorD.moveToFirst()) {
                if (cursorD.getInt(0) != 0) {
                    z5 = true;
                }
            }
            return z5;
        } finally {
            cursorD.close();
        }
    }

    private void k(InterfaceC0647b interfaceC0647b) {
        i(interfaceC0647b);
        interfaceC0647b.k(h.a(this.f6595d));
    }

    @Override // d0.InterfaceC0648c.a
    public void b(InterfaceC0647b interfaceC0647b) {
        super.b(interfaceC0647b);
    }

    @Override // d0.InterfaceC0648c.a
    public void d(InterfaceC0647b interfaceC0647b) {
        k(interfaceC0647b);
        this.f6594c.a(interfaceC0647b);
        this.f6594c.c(interfaceC0647b);
    }

    @Override // d0.InterfaceC0648c.a
    public void e(InterfaceC0647b interfaceC0647b, int i5, int i6) {
        g(interfaceC0647b, i5, i6);
    }

    @Override // d0.InterfaceC0648c.a
    public void f(InterfaceC0647b interfaceC0647b) {
        super.f(interfaceC0647b);
        h(interfaceC0647b);
        this.f6594c.d(interfaceC0647b);
        this.f6593b = null;
    }

    @Override // d0.InterfaceC0648c.a
    public void g(InterfaceC0647b interfaceC0647b, int i5, int i6) {
        List<AbstractC0407a> listC;
        Z.a aVar = this.f6593b;
        if (aVar != null && (listC = aVar.f6534d.c(i5, i6)) != null) {
            Iterator<AbstractC0407a> it = listC.iterator();
            while (it.hasNext()) {
                it.next().a(interfaceC0647b);
            }
            this.f6594c.e(interfaceC0647b);
            k(interfaceC0647b);
            return;
        }
        Z.a aVar2 = this.f6593b;
        if (aVar2 != null && !aVar2.a(i5)) {
            this.f6594c.b(interfaceC0647b);
            this.f6594c.a(interfaceC0647b);
            return;
        }
        throw new IllegalStateException("A migration from " + i5 + " to " + i6 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }
}
