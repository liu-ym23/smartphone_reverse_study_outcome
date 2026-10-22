package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.DatabaseConfiguration;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\u00072\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0000\u001a:\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u00112\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0013"}, d2 = {"isMigrationRequired", "", "Landroidx/room/DatabaseConfiguration;", "fromVersion", "", "toVersion", "contains", "Landroidx/room/RoomDatabase$MigrationContainer;", "startVersion", "endVersion", "findMigrationPath", "", "Landroidx/room/migration/Migration;", "start", "end", "findUpMigrationPath", "result", "", "upgrade", "room-runtime"}, k = 2, mv = {2, 1, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class MigrationUtil {
    public static final boolean contains(RoomDatabase.MigrationContainer migrationContainer, int i, int i6) {
        k.f(migrationContainer, "<this>");
        Map<Integer, Map<Integer, Migration>> migrations = migrationContainer.getMigrations();
        if (!migrations.containsKey(Integer.valueOf(i))) {
            return false;
        }
        Map<Integer, Migration> mapM = migrations.get(Integer.valueOf(i));
        if (mapM == null) {
            mapM = a.M();
        }
        return mapM.containsKey(Integer.valueOf(i6));
    }

    public static final List<Migration> findMigrationPath(RoomDatabase.MigrationContainer migrationContainer, int i, int i6) {
        k.f(migrationContainer, "<this>");
        if (i == i6) {
            return EmptyList.f4893a;
        }
        return findUpMigrationPath(migrationContainer, new ArrayList(), i6 > i, i, i6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Migration> findUpMigrationPath(RoomDatabase.MigrationContainer migrationContainer, List<Migration> list, boolean z10, int i, int i6) {
        int iIntValue;
        boolean z11;
        while (true) {
            if (z10) {
                if (i >= i6) {
                    return list;
                }
            } else if (i <= i6) {
                return list;
            }
            Pair<Map<Integer, Migration>, Iterable<Integer>> sortedDescendingNodes$room_runtime = z10 ? migrationContainer.getSortedDescendingNodes$room_runtime(i) : migrationContainer.getSortedNodes$room_runtime(i);
            if (sortedDescendingNodes$room_runtime == null) {
                return null;
            }
            Map map = (Map) sortedDescendingNodes$room_runtime.f4886a;
            Iterator it = ((Iterable) sortedDescendingNodes$room_runtime.b).iterator();
            while (it.hasNext()) {
                iIntValue = ((Number) it.next()).intValue();
                if (!z10) {
                    if (i6 <= iIntValue && iIntValue < i) {
                        Object obj = map.get(Integer.valueOf(iIntValue));
                        k.c(obj);
                        list.add(obj);
                        z11 = true;
                        break;
                    }
                } else if (i + 1 <= iIntValue && iIntValue <= i6) {
                    Object obj2 = map.get(Integer.valueOf(iIntValue));
                    k.c(obj2);
                    list.add(obj2);
                    z11 = true;
                    break;
                }
            }
            iIntValue = i;
            z11 = false;
            if (!z11) {
                return null;
            }
            i = iIntValue;
        }
    }

    public static final boolean isMigrationRequired(DatabaseConfiguration databaseConfiguration, int i, int i6) {
        k.f(databaseConfiguration, "<this>");
        if (i > i6 && databaseConfiguration.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        Set<Integer> migrationNotRequiredFrom$room_runtime = databaseConfiguration.getMigrationNotRequiredFrom$room_runtime();
        return databaseConfiguration.requireMigration && (migrationNotRequiredFrom$room_runtime == null || !migrationNotRequiredFrom$room_runtime.contains(Integer.valueOf(i)));
    }
}
