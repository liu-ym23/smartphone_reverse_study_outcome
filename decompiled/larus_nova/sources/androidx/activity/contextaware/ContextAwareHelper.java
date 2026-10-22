package androidx.activity.contextaware;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/activity/contextaware/ContextAwareHelper;", "", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "listeners", "", "Landroidx/activity/contextaware/OnContextAvailableListener;", "addOnContextAvailableListener", "", "listener", "clearAvailableContext", "dispatchOnContextAvailable", "peekAvailableContext", "removeOnContextAvailableListener", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContextAwareHelper {
    private volatile Context context;
    private final Set<OnContextAvailableListener> listeners;

    public final void clearAvailableContext() {
        this.context = null;
    }

    public ContextAwareHelper() {
        this.listeners = new CopyOnWriteArraySet();
    }

    public final Context peekAvailableContext() {
        return this.context;
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Context r101 = this.context;
        if (r101 == null) goto L5;
        r100.onContextAvailable(r101);
    L5:
        this.listeners.add(r100);
    }

    public final void dispatchOnContextAvailable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        Iterator<OnContextAvailableListener> r101 = this.listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onContextAvailable(r100);
        goto L4
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listeners.remove(r100);
    }
}
