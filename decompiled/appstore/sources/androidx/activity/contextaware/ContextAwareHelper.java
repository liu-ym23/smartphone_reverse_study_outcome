package androidx.activity.contextaware;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class ContextAwareHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f167b;

    public ContextAwareHelper() {
        this.f166a = new CopyOnWriteArraySet();
    }

    public final void a() {
        this.f167b = null;
    }

    public final void addOnContextAvailableListener(@NotNull OnContextAvailableListener r10) {
        q.g(r10, "listener");
        Context r11 = this.f167b;
        if (r11 == null) goto L5;
        r10.onContextAvailable(r11);
    L5:
        this.f166a.add(r10);
    }

    public final void b(Context r10) {
        q.g(r10, "context");
        this.f167b = r10;
        Iterator r11 = this.f166a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((OnContextAvailableListener) r11.next()).onContextAvailable(r10);
        goto L4
    }

    public final Context c() {
        return this.f167b;
    }

    public final void removeOnContextAvailableListener(@NotNull OnContextAvailableListener r10) {
        q.g(r10, "listener");
        this.f166a.remove(r10);
    }
}
