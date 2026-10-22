package obric.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: tasks.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lobric/util/Tasks;", "Ljava/lang/Runnable;", "()V", "tasks", "", "add", "", "task", "remove", "run", "runAndClear", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Tasks implements Runnable {
    private final List<Runnable> tasks;

    public Tasks() {
        this.tasks = new ArrayList();
    }

    public final synchronized void add(Runnable r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "task");     // Catch: Throwable -> L8
        if (this.tasks.contains(r2) == true) goto L6;
        this.tasks.add(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final synchronized void remove(Runnable r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "task");     // Catch: Throwable -> L6
        this.tasks.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Runnable
    public void run() {
        monitor-enter(this);
        List r0 = CollectionsKt.toList(this.tasks);     // Catch: Throwable -> L10
        monitor-exit(this);
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Runnable) r1.next()).run();
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void runAndClear() {
        monitor-enter(this);
        List r0 = CollectionsKt.toList(this.tasks);     // Catch: Throwable -> L10
        this.tasks.clear();     // Catch: Throwable -> L10
        monitor-exit(this);
        Iterator r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        ((Runnable) r2.next()).run();
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
