package p4;

import a2.i;
import android.database.Cursor;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends g {

    /* renamed from: h, reason: collision with root package name */
    public int[] f9704h;
    public long[] i;

    /* renamed from: j, reason: collision with root package name */
    public double[] f9705j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f9706k;

    /* renamed from: l, reason: collision with root package name */
    public byte[][] f9707l;

    /* renamed from: m, reason: collision with root package name */
    public Cursor f9708m;

    public static void i(Cursor cursor, int i) {
        if (i < 0 || i >= cursor.getColumnCount()) {
            t0.a.l(25, "column index out of range");
            throw null;
        }
    }

    @Override // x4.c
    public final boolean G() {
        d();
        g();
        Cursor cursor = this.f9708m;
        if (cursor != null) {
            return cursor.moveToNext();
        }
        od.f.e("Required value was null.");
        return false;
    }

    @Override // x4.c
    public final void c(int i, long j10) {
        d();
        e(1, i);
        this.f9704h[i] = 1;
        this.i[i] = j10;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        if (!this.f9712g) {
            d();
            this.f9704h = new int[0];
            this.i = new long[0];
            this.f9705j = new double[0];
            this.f9706k = new String[0];
            this.f9707l = new byte[0][];
            reset();
        }
        this.f9712g = true;
    }

    public final void e(int i, int i3) {
        int i10 = i3 + 1;
        int[] iArr = this.f9704h;
        if (iArr.length < i10) {
            this.f9704h = Arrays.copyOf(iArr, i10);
        }
        if (i == 1) {
            long[] jArr = this.i;
            if (jArr.length < i10) {
                this.i = Arrays.copyOf(jArr, i10);
                return;
            }
            return;
        }
        if (i == 2) {
            double[] dArr = this.f9705j;
            if (dArr.length < i10) {
                this.f9705j = Arrays.copyOf(dArr, i10);
                return;
            }
            return;
        }
        if (i == 3) {
            String[] strArr = this.f9706k;
            if (strArr.length < i10) {
                this.f9706k = (String[]) Arrays.copyOf(strArr, i10);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        byte[][] bArr = this.f9707l;
        if (bArr.length < i10) {
            this.f9707l = (byte[][]) Arrays.copyOf(bArr, i10);
        }
    }

    public final void g() {
        if (this.f9708m == null) {
            i iVar = new i(22);
            iVar.f49f = this;
            VarHandle.storeStoreFence();
            this.f9708m = this.f9710c.C(iVar);
        }
    }

    @Override // x4.c
    public final int getColumnCount() {
        d();
        g();
        Cursor cursor = this.f9708m;
        if (cursor != null) {
            return cursor.getColumnCount();
        }
        return 0;
    }

    @Override // x4.c
    public final String getColumnName(int i) {
        d();
        g();
        Cursor cursor = this.f9708m;
        if (cursor == null) {
            od.f.e("Required value was null.");
            return null;
        }
        i(cursor, i);
        String columnName = cursor.getColumnName(i);
        columnName.getClass();
        return columnName;
    }

    @Override // x4.c
    public final long getLong(int i) {
        d();
        Cursor cursor = this.f9708m;
        if (cursor != null) {
            i(cursor, i);
            return cursor.getLong(i);
        }
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final boolean isNull(int i) {
        d();
        Cursor cursor = this.f9708m;
        if (cursor != null) {
            i(cursor, i);
            return cursor.isNull(i);
        }
        t0.a.l(21, "no row");
        throw null;
    }

    @Override // x4.c
    public final void p(int i, String str) {
        str.getClass();
        d();
        e(3, i);
        this.f9704h[i] = 3;
        this.f9706k[i] = str;
    }

    @Override // x4.c
    public final void reset() {
        d();
        Cursor cursor = this.f9708m;
        if (cursor != null) {
            cursor.close();
        }
        this.f9708m = null;
    }

    @Override // x4.c
    public final String z(int i) {
        d();
        Cursor cursor = this.f9708m;
        if (cursor == null) {
            t0.a.l(21, "no row");
            throw null;
        }
        i(cursor, i);
        String string = cursor.getString(i);
        string.getClass();
        return string;
    }
}
