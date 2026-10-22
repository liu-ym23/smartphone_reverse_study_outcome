package androidx.room;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public abstract class k extends G {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(A database) {
        super(database);
        Intrinsics.checkNotNullParameter(database, "database");
    }

    public abstract void bind(k0.j jVar, Object obj);

    public final void insert(Object obj) {
        k0.j jVarAcquire = acquire();
        try {
            bind(jVarAcquire, obj);
            jVarAcquire.executeInsert();
        } finally {
            release(jVarAcquire);
        }
    }

    public final long insertAndReturnId(Object obj) {
        k0.j jVarAcquire = acquire();
        try {
            bind(jVarAcquire, obj);
            return jVarAcquire.executeInsert();
        } finally {
            release(jVarAcquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull Collection<Object> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            long[] jArr = new long[entities.size()];
            int i4 = 0;
            for (Object obj : entities) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                bind(jVarAcquire, obj);
                jArr[i4] = jVarAcquire.executeInsert();
                i4 = i5;
            }
            release(jVarAcquire);
            return jArr;
        } catch (Throwable th) {
            release(jVarAcquire);
            throw th;
        }
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull Collection<Object> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        Iterator<Object> it = entities.iterator();
        try {
            int size = entities.size();
            Long[] lArr = new Long[size];
            for (int i4 = 0; i4 < size; i4++) {
                bind(jVarAcquire, it.next());
                lArr[i4] = Long.valueOf(jVarAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(jVarAcquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull Object[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            for (Object obj : entities) {
                bind(jVarAcquire, obj);
                listCreateListBuilder.add(Long.valueOf(jVarAcquire.executeInsert()));
            }
            List<Long> listBuild = CollectionsKt.build(listCreateListBuilder);
            release(jVarAcquire);
            return listBuild;
        } catch (Throwable th) {
            release(jVarAcquire);
            throw th;
        }
    }

    public final void insert(@NotNull Object[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            for (Object obj : entities) {
                bind(jVarAcquire, obj);
                jVarAcquire.executeInsert();
            }
        } finally {
            release(jVarAcquire);
        }
    }

    @NotNull
    public final long[] insertAndReturnIdsArray(@NotNull Object[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            long[] jArr = new long[entities.length];
            int length = entities.length;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int i6 = i5 + 1;
                bind(jVarAcquire, entities[i4]);
                jArr[i5] = jVarAcquire.executeInsert();
                i4++;
                i5 = i6;
            }
            return jArr;
        } finally {
            release(jVarAcquire);
        }
    }

    @NotNull
    public final Long[] insertAndReturnIdsArrayBox(@NotNull Object[] entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        Iterator it = ArrayIteratorKt.iterator(entities);
        try {
            int length = entities.length;
            Long[] lArr = new Long[length];
            for (int i4 = 0; i4 < length; i4++) {
                bind(jVarAcquire, it.next());
                lArr[i4] = Long.valueOf(jVarAcquire.executeInsert());
            }
            return lArr;
        } finally {
            release(jVarAcquire);
        }
    }

    @NotNull
    public final List<Long> insertAndReturnIdsList(@NotNull Collection<Object> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            Iterator<T> it = entities.iterator();
            while (it.hasNext()) {
                bind(jVarAcquire, it.next());
                listCreateListBuilder.add(Long.valueOf(jVarAcquire.executeInsert()));
            }
            List<Long> listBuild = CollectionsKt.build(listCreateListBuilder);
            release(jVarAcquire);
            return listBuild;
        } catch (Throwable th) {
            release(jVarAcquire);
            throw th;
        }
    }

    public final void insert(@NotNull Iterable<Object> entities) {
        Intrinsics.checkNotNullParameter(entities, "entities");
        k0.j jVarAcquire = acquire();
        try {
            Iterator<Object> it = entities.iterator();
            while (it.hasNext()) {
                bind(jVarAcquire, it.next());
                jVarAcquire.executeInsert();
            }
        } finally {
            release(jVarAcquire);
        }
    }
}
