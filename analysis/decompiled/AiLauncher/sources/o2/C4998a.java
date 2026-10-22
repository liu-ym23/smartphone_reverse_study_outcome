package o2;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* renamed from: o2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4998a {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<Priority> f37465a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public static HashMap<Priority, Integer> f37466b;

    static {
        HashMap<Priority, Integer> map = new HashMap<>();
        f37466b = map;
        map.put(Priority.DEFAULT, 0);
        f37466b.put(Priority.VERY_LOW, 1);
        f37466b.put(Priority.HIGHEST, 2);
        for (Priority priority : f37466b.keySet()) {
            f37465a.append(f37466b.get(priority).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = f37466b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i10) {
        Priority priority = f37465a.get(i10);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i10);
    }
}
