package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    protected abstract void bind(SupportSQLiteStatement statement, T entity);

    @Override // androidx.room.SharedSQLiteStatement
    protected abstract String createQuery();

    public EntityDeletionOrUpdateAdapter(RoomDatabase database) {
        super(database);
    }

    public final int handle(T entity) {
        SupportSQLiteStatement r0 = acquire();
        bind(r0, entity);     // Catch: Throwable -> L6
        int r2 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r0);
        return r2;
    L6:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> entities) {
        SupportSQLiteStatement r0 = acquire();
        Iterator<? extends T> r4 = entities.iterator();     // Catch: Throwable -> L10
        int r1 = 0;
    L5:
        if (r4.hasNext() == false) goto L8;
        bind(r0, r4.next());     // Catch: Throwable -> L10
        r1 = r1 + r0.executeUpdateDelete();
        goto L5
    L8:
        release(r0);
        return r1;
    L10:
        th = move-exception;
        release(r0);
        throw th;
    }

    public final int handleMultiple(T[] entities) {
        SupportSQLiteStatement r0 = acquire();
        int r1 = entities.length;     // Catch: Throwable -> L9
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L7;
        bind(r0, entities[r2]);     // Catch: Throwable -> L9
        r3 = r3 + r0.executeUpdateDelete();
        r2 = r2 + 1;
        goto L4
    L7:
        release(r0);
        return r3;
    L9:
        th = move-exception;
        release(r0);
        throw th;
    }
}
