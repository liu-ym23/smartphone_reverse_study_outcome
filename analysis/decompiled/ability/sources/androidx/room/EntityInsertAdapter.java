package androidx.room;

import C7.i;
import D7.v;
import H4.o;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0010\u0010\u0014J'\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0015¢\u0006\u0004\b\u0010\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u001c\u0010\u001eJ/\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a¢\u0006\u0004\b\u001f\u0010 J1\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u001f\u0010!J/\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0012¢\u0006\u0004\b#\u0010$J-\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u001a¢\u0006\u0004\b#\u0010%¨\u0006&"}, d2 = {"Landroidx/room/EntityInsertAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", AppAgent.CONSTRUCT, "()V", "", "createQuery", "()Ljava/lang/String;", "Landroidx/sqlite/SQLiteStatement;", "statement", "entity", "LC7/r;", "bind", "(Landroidx/sqlite/SQLiteStatement;Ljava/lang/Object;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "insert", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)V", "", "entities", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)V", "", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Iterable;)V", "", "insertAndReturnId", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)J", "", "", "insertAndReturnIdsArray", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)[J", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[J", "insertAndReturnIdsArrayBox", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)[Ljava/lang/Long;", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)[Ljava/lang/Long;", "", "insertAndReturnIdsList", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)Ljava/util/List;", "(Landroidx/sqlite/SQLiteConnection;Ljava/util/Collection;)Ljava/util/List;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public abstract class EntityInsertAdapter<T> {
    public abstract void bind(SQLiteStatement statement, T entity);

    public abstract String createQuery();

    public final void insert(SQLiteConnection connection, T entity) {
        k.f(connection, "connection");
        if (entity == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, entity);
            sQLiteStatementPrepare.step();
            e.s(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public final long insertAndReturnId(SQLiteConnection connection, T entity) {
        k.f(connection, "connection");
        if (entity == null) {
            return -1L;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, entity);
            sQLiteStatementPrepare.step();
            e.s(sQLiteStatementPrepare, null);
            return SQLiteConnectionUtil.getLastInsertedRowId(connection);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long[] insertAndReturnIdsArray(SQLiteConnection connection, Collection<? extends T> entities) {
        long lastInsertedRowId;
        k.f(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            int size = entities.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                Object objY0 = v.y0(i, entities);
                if (objY0 != null) {
                    bind(sQLiteStatementPrepare, objY0);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    lastInsertedRowId = -1;
                }
                jArr[i] = lastInsertedRowId;
            }
            e.s(sQLiteStatementPrepare, null);
            return jArr;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection connection, Collection<? extends T> entities) {
        long lastInsertedRowId;
        k.f(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                Object objY0 = v.y0(i, entities);
                if (objY0 != null) {
                    bind(sQLiteStatementPrepare, objY0);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    lastInsertedRowId = -1;
                }
                lArr[i] = Long.valueOf(lastInsertedRowId);
            }
            e.s(sQLiteStatementPrepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection connection, Collection<? extends T> entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilderY = o.y();
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            for (T t9 : entities) {
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    listBuilderY.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(connection)));
                } else {
                    listBuilderY.add(-1L);
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return o.q(listBuilderY);
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insert(SQLiteConnection connection, T[] entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            i iVarJ = k.j(entities);
            while (iVarJ.hasNext()) {
                Object next = iVarJ.next();
                if (next != null) {
                    bind(sQLiteStatementPrepare, next);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                }
            }
            e.s(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public final void insert(SQLiteConnection connection, Iterable<? extends T> entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            for (T t9 : entities) {
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                }
            }
            e.s(sQLiteStatementPrepare, null);
        } finally {
        }
    }

    public final long[] insertAndReturnIdsArray(SQLiteConnection connection, T[] entities) {
        long lastInsertedRowId;
        k.f(connection, "connection");
        if (entities == null) {
            return new long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            int length = entities.length;
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                T t9 = entities[i];
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    lastInsertedRowId = -1;
                }
                jArr[i] = lastInsertedRowId;
            }
            e.s(sQLiteStatementPrepare, null);
            return jArr;
        } finally {
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection connection, T[] entities) {
        long lastInsertedRowId;
        k.f(connection, "connection");
        if (entities == null) {
            return new Long[0];
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i = 0; i < length; i++) {
                T t9 = entities[i];
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    lastInsertedRowId = SQLiteConnectionUtil.getLastInsertedRowId(connection);
                } else {
                    lastInsertedRowId = -1;
                }
                lArr[i] = Long.valueOf(lastInsertedRowId);
            }
            e.s(sQLiteStatementPrepare, null);
            return lArr;
        } finally {
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection connection, T[] entities) {
        k.f(connection, "connection");
        if (entities == null) {
            return EmptyList.f4893a;
        }
        ListBuilder listBuilderY = o.y();
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            for (T t9 : entities) {
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    listBuilderY.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(connection)));
                } else {
                    listBuilderY.add(-1L);
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return o.q(listBuilderY);
        } finally {
        }
    }
}
