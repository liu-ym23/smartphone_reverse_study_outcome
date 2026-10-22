package androidx.room;

import H4.o;
import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@C7.c
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u000f\u0010\u0013J\u001b\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00192\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001a\u001a\u00020\u00192\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001a\u0010\u001dJ#\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u001f\u0010 J!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160\u001e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\u001f\u0010!J%\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0011¢\u0006\u0004\b\"\u0010#J#\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c¢\u0006\u0004\b\"\u0010$R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010%R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010&¨\u0006'"}, d2 = {"Landroidx/room/EntityUpsertionAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/EntityInsertionAdapter;", "insertionAdapter", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "updateAdapter", AppAgent.CONSTRUCT, "(Landroidx/room/EntityInsertionAdapter;Landroidx/room/EntityDeletionOrUpdateAdapter;)V", "Landroid/database/sqlite/SQLiteConstraintException;", "ex", "LC7/r;", "checkUniquenessException", "(Landroid/database/sqlite/SQLiteConstraintException;)V", "entity", "upsert", "(Ljava/lang/Object;)V", "", "entities", "([Ljava/lang/Object;)V", "", "(Ljava/lang/Iterable;)V", "", "upsertAndReturnId", "(Ljava/lang/Object;)J", "", "upsertAndReturnIdsArray", "([Ljava/lang/Object;)[J", "", "(Ljava/util/Collection;)[J", "", "upsertAndReturnIdsList", "([Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;)Ljava/util/List;", "upsertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "Landroidx/room/EntityInsertionAdapter;", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> insertionAdapter, EntityDeletionOrUpdateAdapter<T> updateAdapter) {
        k.f(insertionAdapter, "insertionAdapter");
        k.f(updateAdapter, "updateAdapter");
        this.insertionAdapter = insertionAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException ex) {
        String message = ex.getMessage();
        if (message == null) {
            throw ex;
        }
        if (!m.h0(message, "unique", true) && !m.h0(message, "2067", false) && !m.h0(message, "1555", false)) {
            throw ex;
        }
    }

    public final void upsert(T entity) {
        try {
            this.insertionAdapter.insert((EntityInsertionAdapter<T>) entity);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(entity);
        }
    }

    public final long upsertAndReturnId(T entity) {
        try {
            return this.insertionAdapter.insertAndReturnId(entity);
        } catch (SQLiteConstraintException e) {
            this.checkUniquenessException(e);
            this.updateAdapter.handle(entity);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] entities) {
        long jInsertAndReturnId;
        k.f(entities, "entities");
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i]);
                jInsertAndReturnId = -1;
            }
            jArr[i] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] entities) {
        long jInsertAndReturnId;
        k.f(entities, "entities");
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(entities[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(entities[i]);
                jInsertAndReturnId = -1;
            }
            lArr[i] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] entities) {
        k.f(entities, "entities");
        ListBuilder listBuilderY = o.y();
        for (T t9 : entities) {
            try {
                listBuilderY.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t9)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t9);
                listBuilderY.add(-1L);
            }
        }
        return o.q(listBuilderY);
    }

    public final void upsert(T[] entities) {
        k.f(entities, "entities");
        for (T t9 : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t9);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t9);
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.f(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            jArr[i] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.f(entities, "entities");
        Iterator<? extends T> it = entities.iterator();
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            T next = it.next();
            try {
                jInsertAndReturnId = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                jInsertAndReturnId = -1;
            }
            lArr[i] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final void upsert(Iterable<? extends T> entities) {
        k.f(entities, "entities");
        for (T t9 : entities) {
            try {
                this.insertionAdapter.insert((EntityInsertionAdapter<T>) t9);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t9);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> entities) {
        k.f(entities, "entities");
        ListBuilder listBuilderY = o.y();
        for (T t9 : entities) {
            try {
                listBuilderY.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t9)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t9);
                listBuilderY.add(-1L);
            }
        }
        return o.q(listBuilderY);
    }
}
