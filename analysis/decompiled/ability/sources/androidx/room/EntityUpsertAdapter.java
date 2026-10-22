package androidx.room;

import D7.v;
import H4.o;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.SQLiteConnection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import j9.m;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0014¢\u0006\u0004\b\u0012\u0010\u0016J'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0017¢\u0006\u0004\b\u0012\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ)\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001f¢\u0006\u0004\b\u001d\u0010 J/\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190!2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0014¢\u0006\u0004\b\"\u0010#J-\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190!2\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001f¢\u0006\u0004\b\"\u0010$J1\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0015\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0014¢\u0006\u0004\b%\u0010&J/\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u00142\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001f¢\u0006\u0004\b%\u0010'R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010(R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010)¨\u0006+"}, d2 = {"Landroidx/room/EntityUpsertAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/room/EntityInsertAdapter;", "entityInsertAdapter", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "updateAdapter", AppAgent.CONSTRUCT, "(Landroidx/room/EntityInsertAdapter;Landroidx/room/EntityDeleteOrUpdateAdapter;)V", "Landroid/database/SQLException;", "Landroidx/sqlite/SQLiteException;", "ex", "LC7/r;", "checkUniquenessException", "(Landroid/database/SQLException;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "entity", "upsert", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)V", "", "entities", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)V", "", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Iterable;)V", "", "upsertAndReturnId", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)J", "", "upsertAndReturnIdsArray", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[J", "", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)[J", "", "upsertAndReturnIdsList", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)Ljava/util/List;", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)Ljava/util/List;", "upsertAndReturnIdsArrayBox", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[Ljava/lang/Long;", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)[Ljava/lang/Long;", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "Companion", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public final class EntityUpsertAdapter<T> {
    private static final String ErrorMsg = "unique";
    private static final String SQLITE_CONSTRAINT_PRIMARYKEY = "1555";
    private static final String SQLITE_CONSTRAINT_UNIQUE = "2067";
    private final EntityInsertAdapter<T> entityInsertAdapter;
    private final EntityDeleteOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertAdapter(EntityInsertAdapter<T> entityInsertAdapter, EntityDeleteOrUpdateAdapter<T> updateAdapter) {
        k.f(entityInsertAdapter, "entityInsertAdapter");
        k.f(updateAdapter, "updateAdapter");
        this.entityInsertAdapter = entityInsertAdapter;
        this.updateAdapter = updateAdapter;
    }

    private final void checkUniquenessException(SQLException ex) {
        String message = ex.getMessage();
        if (message == null) {
            throw ex;
        }
        if (!m.h0(message, ErrorMsg, true) && !m.h0(message, SQLITE_CONSTRAINT_UNIQUE, false) && !m.h0(message, SQLITE_CONSTRAINT_PRIMARYKEY, false)) {
            throw ex;
        }
    }

    public final void upsert(SQLiteConnection connection, T entity) {
        k.f(connection, "connection");
        try {
            this.entityInsertAdapter.insert(connection, (SQLiteConnection) entity);
        } catch (SQLException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(connection, entity);
        }
    }

    public final long upsertAndReturnId(SQLiteConnection connection, T entity) {
        k.f(connection, "connection");
        try {
            return this.entityInsertAdapter.insertAndReturnId(connection, entity);
        } catch (SQLException e) {
            this.checkUniquenessException(e);
            this.updateAdapter.handle(connection, entity);
            return -1L;
        }
    }

    public final long[] upsertAndReturnIdsArray(SQLiteConnection connection, T[] entities) {
        long jInsertAndReturnId;
        k.f(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        int length = entities.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(connection, entities[i]);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, entities[i]);
                jInsertAndReturnId = -1;
            }
            jArr[i] = jInsertAndReturnId;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection connection, T[] entities) {
        long jInsertAndReturnId;
        k.f(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        int length = entities.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(connection, entities[i]);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, entities[i]);
                jInsertAndReturnId = -1;
            }
            lArr[i] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection connection, Collection<? extends T> entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilderY = o.y();
        for (T t9 : entities) {
            try {
                listBuilderY.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t9)));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, t9);
                listBuilderY.add(-1L);
            }
        }
        return o.q(listBuilderY);
    }

    public final void upsert(SQLiteConnection connection, T[] entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return;
        }
        for (T t9 : entities) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t9);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, t9);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long[] upsertAndReturnIdsArray(SQLiteConnection connection, Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.f(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        int size = entities.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(connection, v.y0(i, entities));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, v.y0(i, entities));
                jInsertAndReturnId = -1;
            }
            jArr[i] = jInsertAndReturnId;
        }
        return jArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection connection, Collection<? extends T> entities) {
        long jInsertAndReturnId;
        k.f(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        int size = entities.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            try {
                jInsertAndReturnId = this.entityInsertAdapter.insertAndReturnId(connection, v.y0(i, entities));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, v.y0(i, entities));
                jInsertAndReturnId = -1;
            }
            lArr[i] = Long.valueOf(jInsertAndReturnId);
        }
        return lArr;
    }

    public final void upsert(SQLiteConnection connection, Iterable<? extends T> entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return;
        }
        for (T t9 : entities) {
            try {
                this.entityInsertAdapter.insert(connection, (SQLiteConnection) t9);
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, t9);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection connection, T[] entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilderY = o.y();
        for (T t9 : entities) {
            try {
                listBuilderY.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(connection, t9)));
            } catch (SQLException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(connection, t9);
                listBuilderY.add(-1L);
            }
        }
        return o.q(listBuilderY);
    }
}
