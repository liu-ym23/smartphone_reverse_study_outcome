package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    public abstract void bind(SupportSQLiteStatement r100, T r101);

    @Override // androidx.room.SharedSQLiteStatement
    public abstract String createQuery();

    public EntityDeletionOrUpdateAdapter(RoomDatabase r100) {
        super(r100);
    }

    public final int handle(T r100) {
        SupportSQLiteStatement r101 = acquire();
        bind(r101, r100);     // Catch: Throwable -> L6
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L6
        release(r101);
        return r102;
    L6:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final int handleMultiple(Iterable<? extends T> r100) {
        SupportSQLiteStatement r101 = acquire();
        Iterator<? extends T> r102 = r100.iterator();     // Catch: Throwable -> L10
        int r103 = 0;
    L5:
        if (r102.hasNext() == false) goto L8;
        bind(r101, r102.next());     // Catch: Throwable -> L10
        r103 = r103 + r101.executeUpdateDelete();
        goto L5
    L8:
        release(r101);
        return r103;
    L10:
        th = move-exception;
        release(r101);
        throw th;
    }

    public final int handleMultiple(T[] r100) {
        SupportSQLiteStatement r101 = acquire();
        int r102 = r100.length;     // Catch: Throwable -> L9
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r102) goto L7;
        bind(r101, r100[r103]);     // Catch: Throwable -> L9
        r104 = r104 + r101.executeUpdateDelete();
        r103 = r103 + 1;
        goto L4
    L7:
        release(r101);
        return r104;
    L9:
        th = move-exception;
        release(r101);
        throw th;
    }
}
