package androidx.room;

import C7.i;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H$¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/room/EntityDeleteOrUpdateAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "", AppAgent.CONSTRUCT, "()V", "", "createQuery", "()Ljava/lang/String;", "Landroidx/sqlite/SQLiteStatement;", "statement", "entity", "LC7/r;", "bind", "(Landroidx/sqlite/SQLiteStatement;Ljava/lang/Object;)V", "Landroidx/sqlite/SQLiteConnection;", "connection", "", "handle", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Object;)I", "", "entities", "handleMultiple", "(Landroidx/sqlite/SQLiteConnection;Ljava/lang/Iterable;)I", "", "(Landroidx/sqlite/SQLiteConnection;[Ljava/lang/Object;)I", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes2.dex */
public abstract class EntityDeleteOrUpdateAdapter<T> {
    public abstract void bind(SQLiteStatement statement, T entity);

    public abstract String createQuery();

    public final int handle(SQLiteConnection connection, T entity) {
        k.f(connection, "connection");
        if (entity == null) {
            return 0;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            bind(sQLiteStatementPrepare, entity);
            sQLiteStatementPrepare.step();
            e.s(sQLiteStatementPrepare, null);
            return SQLiteConnectionUtil.getTotalChangedRows(connection);
        } finally {
        }
    }

    public final int handleMultiple(SQLiteConnection connection, Iterable<? extends T> entities) {
        k.f(connection, "connection");
        int totalChangedRows = 0;
        if (entities == null) {
            return 0;
        }
        SQLiteStatement sQLiteStatementPrepare = connection.prepare(createQuery());
        try {
            for (T t9 : entities) {
                if (t9 != null) {
                    bind(sQLiteStatementPrepare, t9);
                    sQLiteStatementPrepare.step();
                    sQLiteStatementPrepare.reset();
                    totalChangedRows += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return totalChangedRows;
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int handleMultiple(SQLiteConnection connection, T[] entities) {
        k.f(connection, "connection");
        int totalChangedRows = 0;
        if (entities == null) {
            return 0;
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
                    totalChangedRows += SQLiteConnectionUtil.getTotalChangedRows(connection);
                }
            }
            e.s(sQLiteStatementPrepare, null);
            return totalChangedRows;
        } finally {
        }
    }
}
