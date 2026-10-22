package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    protected abstract void bind(SupportSQLiteStatement statement, T entity);

    public EntityInsertionAdapter(RoomDatabase database) {
        super(database);
    }

    public final void insert(T entity) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, entity);     // Catch: Throwable -> L6
        r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(T[] entities) {
        SupportSQLiteStatement r0 = acquire();
        int r1 = entities.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L7;
        bind(r0, entities[r2]);     // Catch: Throwable -> L9
        r0.executeInsert();     // Catch: Throwable -> L9
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final void insert(Iterable<? extends T> entities) {
        SupportSQLiteStatement r0 = acquire();
        Iterator<? extends T> r3 = entities.iterator();     // Catch: Throwable -> L10
    L5:
        if (r3.hasNext() == false) goto L8;
        bind(r0, r3.next());     // Catch: Throwable -> L10
        r0.executeInsert();     // Catch: Throwable -> L10
        goto L5
    L8:
        release(r0);
        return;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long insertAndReturnId(T entity) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, entity);     // Catch: Throwable -> L6
        long r1 = r0.executeInsert();     // Catch: Throwable -> L6
        release(r0);
        return r1;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> entities) {
        SupportSQLiteStatement r0 = acquire();
        long[] r1 = new long[entities.size()];     // Catch: Throwable -> L10
        Iterator<? extends T> r6 = entities.iterator();     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r6.hasNext() == false) goto L8;
        bind(r0, r6.next());     // Catch: Throwable -> L10
        r1[r2] = r0.executeInsert();     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final long[] insertAndReturnIdsArray(T[] entities) {
        SupportSQLiteStatement r0 = acquire();
        long[] r1 = new long[entities.length];     // Catch: Throwable -> L9
        int r2 = entities.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, entities[r3]);     // Catch: Throwable -> L9
        r1[r4] = r0.executeInsert();     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        SupportSQLiteStatement r0 = acquire();
        Long[] r1 = new Long[entities.size()];     // Catch: Throwable -> L10
        Iterator<? extends T> r6 = entities.iterator();     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r6.hasNext() == false) goto L8;
        bind(r0, r6.next());     // Catch: Throwable -> L10
        r1[r2] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] entities) {
        SupportSQLiteStatement r0 = acquire();
        Long[] r1 = new Long[entities.length];     // Catch: Throwable -> L9
        int r2 = entities.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, entities[r3]);     // Catch: Throwable -> L9
        r1[r4] = Long.valueOf(r0.executeInsert());     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(T[] entities) {
        SupportSQLiteStatement r0 = acquire();
        ArrayList r1 = new ArrayList(entities.length);     // Catch: Throwable -> L9
        int r2 = entities.length;     // Catch: Throwable -> L9
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L7;
        bind(r0, entities[r3]);     // Catch: Throwable -> L9
        r1.add(r4, Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L9
        r4 = r4 + 1;
        r3 = r3 + 1;
        goto L4
    L7:
        release(r0);
        return r1;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> entities) {
        SupportSQLiteStatement r0 = acquire();
        ArrayList r1 = new ArrayList(entities.size());     // Catch: Throwable -> L10
        Iterator<? extends T> r6 = entities.iterator();     // Catch: Throwable -> L10
        int r2 = 0;
    L5:
        if (r6.hasNext() == false) goto L8;
        bind(r0, r6.next());     // Catch: Throwable -> L10
        r1.add(r2, Long.valueOf(r0.executeInsert()));     // Catch: Throwable -> L10
        r2 = r2 + 1;
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }
}
