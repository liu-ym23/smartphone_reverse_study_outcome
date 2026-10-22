package B0;

import Z2.I;
import android.database.Cursor;
import androidx.room.A;
import androidx.room.E;
import androidx.room.G;
import kotlin.jvm.internal.Intrinsics;
import t0.J;

/* loaded from: classes.dex */
public final class p implements i {

    /* renamed from: a, reason: collision with root package name */
    public final A f160a;

    /* renamed from: b, reason: collision with root package name */
    public final b f161b;

    /* renamed from: c, reason: collision with root package name */
    public final G f162c;

    /* renamed from: d, reason: collision with root package name */
    public final G f163d;

    public p(A a4, int i4) {
        int i5 = 0;
        int i6 = 1;
        if (i4 != 1) {
            this.f160a = a4;
            this.f161b = new b(this, a4, 4);
            this.f162c = new o(a4, i5);
            this.f163d = new o(a4, i6);
            return;
        }
        this.f160a = a4;
        this.f161b = new b(this, a4, 2);
        this.f162c = new j(this, a4, i5);
        this.f163d = new j(this, a4, i6);
    }

    public final void a(String str) {
        A a4 = this.f160a;
        a4.assertNotSuspendingTransaction();
        G g4 = this.f162c;
        k0.j jVarAcquire = g4.acquire();
        if (str == null) {
            jVarAcquire.bindNull(1);
        } else {
            jVarAcquire.bindString(1, str);
        }
        a4.beginTransaction();
        try {
            jVarAcquire.executeUpdateDelete();
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
            g4.release(jVarAcquire);
        }
    }

    public final h b(k id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(id, "id");
        String str = id.f150a;
        E eD = E.d(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        if (str == null) {
            eD.bindNull(1);
        } else {
            eD.bindString(1, str);
        }
        eD.bindLong(2, id.f151b);
        A a4 = this.f160a;
        a4.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(a4, eD);
        try {
            int iN = I.n(cursorH, "work_spec_id");
            int iN2 = I.n(cursorH, "generation");
            int iN3 = I.n(cursorH, "system_id");
            h hVar = null;
            String string = null;
            if (cursorH.moveToFirst()) {
                if (!cursorH.isNull(iN)) {
                    string = cursorH.getString(iN);
                }
                hVar = new h(string, cursorH.getInt(iN2), cursorH.getInt(iN3));
            }
            return hVar;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    public final void c(h hVar) {
        A a4 = this.f160a;
        a4.assertNotSuspendingTransaction();
        a4.beginTransaction();
        try {
            this.f161b.insert(hVar);
            a4.setTransactionSuccessful();
        } finally {
            a4.endTransaction();
        }
    }
}
