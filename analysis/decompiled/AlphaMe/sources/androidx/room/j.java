package androidx.room;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class j extends G {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(A database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public abstract void bind(k0.j jVar, Object obj);

    public final int handle(Object obj) {
        k0.j jVarAcquire = acquire();
        try {
            bind(jVarAcquire, obj);
            return jVarAcquire.executeUpdateDelete();
        } finally {
            release(jVarAcquire);
        }
    }

    public final int handleMultiple(@NotNull Iterable<Object> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            Iterator<Object> it = entities.iterator();
            int iExecuteUpdateDelete = 0;
            while (it.hasNext()) {
                bind(jVarAcquire, it.next());
                iExecuteUpdateDelete += jVarAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(jVarAcquire);
        }
    }

    public final int handleMultiple(@NotNull Object[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            int iExecuteUpdateDelete = 0;
            for (Object obj : entities) {
                bind(jVarAcquire, obj);
                iExecuteUpdateDelete += jVarAcquire.executeUpdateDelete();
            }
            return iExecuteUpdateDelete;
        } finally {
            release(jVarAcquire);
        }
    }
}
