package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    public abstract void bind(SupportSQLiteStatement r100, T r101);

    public EntityInsertionAdapter(RoomDatabase r100) {
        super(r100);
    }

    public final void insert(Iterable<? extends T> r100) {
        SupportSQLiteStatement r101 = acquire();
        Iterator<? extends T> r102 = r100.iterator();     // Catch: Throwable -> L10
    L5:
        if (r102.hasNext() == false) goto L8;
        bind(r101, r102.next());     // Catch: Throwable -> L10
        r101.executeInsert();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r101);
        return;
    L10:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final long insertAndReturnId(T r100) {
        SupportSQLiteStatement r101 = acquire();
        bind(r101, r100);     // Catch: Throwable -> L6
        long r102 = r101.executeInsert();     // Catch: Throwable -> L6
        release(r101);
        return r102;
    L6:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> r100) {
        SupportSQLiteStatement r101 = acquire();
        long[] r102 = new long[r100.size()];     // Catch: Throwable -> L10
        Iterator<? extends T> r103 = r100.iterator();     // Catch: Throwable -> L10
        int r104 = 0;
    L5:
        if (r103.hasNext() == false) goto L8;
        bind(r101, r103.next());     // Catch: Throwable -> L10
        r102[r104] = r101.executeInsert();     // Catch: Throwable -> L10
        r104 = r104 + 1;
        goto L5
    L8:
        release(r101);
        return r102;
    L10:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> r100) {
        SupportSQLiteStatement r101 = acquire();
        Long[] r102 = new Long[r100.size()];     // Catch: Throwable -> L10
        Iterator<? extends T> r103 = r100.iterator();     // Catch: Throwable -> L10
        int r104 = 0;
    L5:
        if (r103.hasNext() == false) goto L8;
        bind(r101, r103.next());     // Catch: Throwable -> L10
        r102[r104] = Long.valueOf(r101.executeInsert());     // Catch: Throwable -> L10
        r104 = r104 + 1;
        goto L5
    L8:
        release(r101);
        return r102;
    L10:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> r100) {
        SupportSQLiteStatement r101 = acquire();
        ArrayList r102 = new ArrayList(r100.size());     // Catch: Throwable -> L10
        Iterator<? extends T> r103 = r100.iterator();     // Catch: Throwable -> L10
        int r104 = 0;
    L5:
        if (r103.hasNext() == false) goto L8;
        bind(r101, r103.next());     // Catch: Throwable -> L10
        r102.add(r104, Long.valueOf(r101.executeInsert()));     // Catch: Throwable -> L10
        r104 = r104 + 1;
        goto L5
    L8:
        release(r101);
        return r102;
    L10:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final void insert(T[] r100) {
        SupportSQLiteStatement r101 = acquire();
        int r102 = r100.length;     // Catch: Throwable -> L9
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L7;
        bind(r101, r100[r103]);     // Catch: Throwable -> L9
        r101.executeInsert();     // Catch: Throwable -> L9
        r103 = r103 + 1;
        goto L4
    L7:
        release(r101);
        return;
    L9:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] r100) {
        SupportSQLiteStatement r101 = acquire();
        long[] r102 = new long[r100.length];     // Catch: Throwable -> L9
        int r103 = r100.length;     // Catch: Throwable -> L9
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r103) goto L7;
        bind(r101, r100[r104]);     // Catch: Throwable -> L9
        r102[r105] = r101.executeInsert();     // Catch: Throwable -> L9
        r105 = r105 + 1;
        r104 = r104 + 1;
        goto L4
    L7:
        release(r101);
        return r102;
    L9:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] r100) {
        SupportSQLiteStatement r101 = acquire();
        Long[] r102 = new Long[r100.length];     // Catch: Throwable -> L9
        int r103 = r100.length;     // Catch: Throwable -> L9
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r103) goto L7;
        bind(r101, r100[r104]);     // Catch: Throwable -> L9
        r102[r105] = Long.valueOf(r101.executeInsert());     // Catch: Throwable -> L9
        r105 = r105 + 1;
        r104 = r104 + 1;
        goto L4
    L7:
        release(r101);
        return r102;
    L9:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] r100) {
        SupportSQLiteStatement r101 = acquire();
        ArrayList r102 = new ArrayList(r100.length);     // Catch: Throwable -> L9
        int r103 = r100.length;     // Catch: Throwable -> L9
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r103) goto L7;
        bind(r101, r100[r104]);     // Catch: Throwable -> L9
        r102.add(r105, Long.valueOf(r101.executeInsert()));     // Catch: Throwable -> L9
        r105 = r105 + 1;
        r104 = r104 + 1;
        goto L4
    L7:
        release(r101);
        return r102;
    L9:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final void insert(T r100) {
        SupportSQLiteStatement r101 = acquire();
        bind(r101, r100);     // Catch: Throwable -> L6
        r101.executeInsert();     // Catch: Throwable -> L6
        release(r101);
        return;
    L6:
        th = move-exception;
        release(r101);
        throw th;
    }
}
