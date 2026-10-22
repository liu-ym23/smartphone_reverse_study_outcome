package Q8;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final BoxStore f5430a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<T> f5431b;

    /* renamed from: c, reason: collision with root package name */
    public final ThreadLocal<Cursor<T>> f5432c = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name */
    public final ThreadLocal<Cursor<T>> f5433d = new ThreadLocal<>();

    public a(BoxStore boxStore, Class<T> cls) {
        this.f5430a = boxStore;
        this.f5431b = cls;
        boxStore.Y(cls).B();
    }

    public void a() {
        Cursor<T> cursor = this.f5433d.get();
        if (cursor != null) {
            cursor.close();
            cursor.l().close();
            this.f5433d.remove();
        }
    }

    public void b(Cursor<T> cursor) {
        if (this.f5432c.get() == null) {
            cursor.close();
            cursor.l().i();
        }
    }

    public long c() {
        return d(0L);
    }

    public long d(long j10) {
        Cursor<T> cursorG = g();
        try {
            return cursorG.b(j10);
        } finally {
            j(cursorG);
        }
    }

    public Cursor<T> e() {
        Transaction transaction = this.f5430a.f34317r.get();
        if (transaction == null) {
            return null;
        }
        if (transaction.isClosed()) {
            throw new IllegalStateException("Active TX is closed");
        }
        Cursor<T> cursor = this.f5432c.get();
        if (cursor != null && !cursor.l().isClosed()) {
            return cursor;
        }
        Cursor<T> cursorL = transaction.l(this.f5431b);
        this.f5432c.set(cursorL);
        return cursorL;
    }

    public List<T> f() {
        ArrayList arrayList = new ArrayList();
        Cursor<T> cursorG = g();
        try {
            for (T tG = cursorG.g(); tG != null; tG = cursorG.m()) {
                arrayList.add(tG);
            }
            return arrayList;
        } finally {
            j(cursorG);
        }
    }

    public Cursor<T> g() {
        Cursor<T> cursorE = e();
        if (cursorE != null) {
            return cursorE;
        }
        Cursor<T> cursor = this.f5433d.get();
        if (cursor == null) {
            Cursor<T> cursorL = this.f5430a.e().l(this.f5431b);
            this.f5433d.set(cursorL);
            return cursorL;
        }
        Transaction transaction = cursor.f34325a;
        if (transaction.isClosed() || !transaction.G()) {
            throw new IllegalStateException("Illegal reader TX state");
        }
        transaction.U();
        cursor.A();
        return cursor;
    }

    public Cursor<T> h() {
        Cursor<T> cursorE = e();
        if (cursorE != null) {
            return cursorE;
        }
        Transaction transactionG = this.f5430a.g();
        try {
            return transactionG.l(this.f5431b);
        } catch (RuntimeException e10) {
            transactionG.close();
            throw e10;
        }
    }

    public long i(T t10) {
        Cursor<T> cursorH = h();
        try {
            long jN = cursorH.n(t10);
            b(cursorH);
            return jN;
        } finally {
            k(cursorH);
        }
    }

    public void j(Cursor<T> cursor) {
        if (this.f5432c.get() == null) {
            Transaction transactionL = cursor.l();
            if (transactionL.isClosed() || transactionL.G() || !transactionL.A()) {
                throw new IllegalStateException("Illegal reader TX state");
            }
            transactionL.J();
        }
    }

    public void k(Cursor<T> cursor) {
        if (this.f5432c.get() == null) {
            Transaction transactionL = cursor.l();
            if (transactionL.isClosed()) {
                return;
            }
            cursor.close();
            transactionL.b();
            transactionL.close();
        }
    }

    public void l(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        Cursor<T> cursorH = h();
        try {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                cursorH.e(cursorH.i(it.next()));
            }
            b(cursorH);
            k(cursorH);
        } catch (Throwable th) {
            k(cursorH);
            throw th;
        }
    }

    public boolean m(T t10) {
        Cursor<T> cursorH = h();
        try {
            boolean zE = cursorH.e(cursorH.i(t10));
            b(cursorH);
            return zE;
        } finally {
            k(cursorH);
        }
    }

    public void n(Transaction transaction) {
        Cursor<T> cursor = this.f5432c.get();
        if (cursor != null) {
            this.f5432c.remove();
            cursor.close();
        }
    }
}
