package A4;

import android.os.DeadObjectException;
import j9.m;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f106a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ExecutorService c;

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new b(0));
        kotlin.jvm.internal.k.e(executorServiceNewCachedThreadPool, "newCachedThreadPool(...)");
        c = executorServiceNewCachedThreadPool;
    }

    public static String a(String str) {
        int iP0 = m.p0(str, '#', 0, 6);
        return iP0 >= 0 ? m.N0(iP0, str) : str;
    }

    public static void b(String str, String str2, Throwable th) {
        String msg = str2 + " failed for " + str;
        kotlin.jvm.internal.k.f(msg, "msg");
        String strConcat = "Ability_".concat("TaskListenerManager");
        P3.b bVar = P3.c.f1086a;
        bVar.invoke(5, strConcat, msg, th);
        if ((th instanceof DeadObjectException) || (th.getCause() instanceof DeadObjectException)) {
            String strA = a(str);
            f106a.remove(str);
            Set set = (Set) b.get(strA);
            if (set != null) {
                set.remove(str);
            }
            String msg2 = "listener removed (dead object): ".concat(str);
            kotlin.jvm.internal.k.f(msg2, "msg");
            bVar.invoke(3, "Ability_".concat("TaskListenerManager"), msg2, null);
        }
    }
}
