package androidx.work;

import android.content.Context;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes17.dex */
public class DelegatingWorkerFactory extends WorkerFactory {
    private static final String TAG = null;
    private final List<WorkerFactory> mFactories;

    static {
        TAG = Logger.tagWithPrefix("DelegatingWkrFctry");
    }

    public DelegatingWorkerFactory() {
        this.mFactories = new CopyOnWriteArrayList();
    }

    public List<WorkerFactory> getFactories() {
        return this.mFactories;
    }

    public final void addFactory(WorkerFactory r100) {
        this.mFactories.add(r100);
    }

    @Override // androidx.work.WorkerFactory
    public final ListenableWorker createWorker(Context r100, String r101, WorkerParameters r102) {
        Iterator<WorkerFactory> r103 = this.mFactories.iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        ListenableWorker r104 = r103.next().createWorker(r100, r101, r102);     // Catch: Throwable -> L9
        if (r104 == null) goto L4;
        return r104;
    L9:
        th = move-exception;
        String r105 = String.format("Unable to instantiate a ListenableWorker (%s)", new Object[]{r101});
        Logger.get().error(TAG, r105, new Throwable[]{th});
        throw th;
    L12:
        return null;
    }
}
