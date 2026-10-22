package androidx.room;

import S7.k;
import S7.n;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"androidx/room/RoomDatabaseKt__RoomDatabaseKt", "androidx/room/RoomDatabaseKt__RoomDatabase_androidKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoomDatabaseKt {
    public static final <R> Object compatTransactionCoroutineExecute(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.compatTransactionCoroutineExecute(roomDatabase, kVar, cVar);
    }

    @C7.c
    public static final p9.c invalidationTrackerFlow(RoomDatabase roomDatabase, String[] strArr, boolean z10) {
        return RoomDatabaseKt__RoomDatabase_androidKt.invalidationTrackerFlow(roomDatabase, strArr, z10);
    }

    public static final <R> Object useReaderConnection(RoomDatabase roomDatabase, n nVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useReaderConnection(roomDatabase, nVar, cVar);
    }

    public static final <R> Object useWriterConnection(RoomDatabase roomDatabase, n nVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt__RoomDatabaseKt.useWriterConnection(roomDatabase, nVar, cVar);
    }

    public static final void validateAutoMigrations(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateAutoMigrations(roomDatabase, databaseConfiguration);
    }

    public static final void validateMigrationsNotRequired(Set<Integer> set, Set<Integer> set2) {
        RoomDatabaseKt__RoomDatabaseKt.validateMigrationsNotRequired(set, set2);
    }

    public static final void validateTypeConverters(RoomDatabase roomDatabase, DatabaseConfiguration databaseConfiguration) {
        RoomDatabaseKt__RoomDatabaseKt.validateTypeConverters(roomDatabase, databaseConfiguration);
    }

    public static final <R> Object withTransaction(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransaction(roomDatabase, kVar, cVar);
    }

    public static final <R> Object withTransactionContext(RoomDatabase roomDatabase, k kVar, H7.c<? super R> cVar) {
        return RoomDatabaseKt__RoomDatabase_androidKt.withTransactionContext(roomDatabase, kVar, cVar);
    }
}
