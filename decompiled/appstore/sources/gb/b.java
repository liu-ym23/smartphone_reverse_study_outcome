package gb;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;
import jb.d;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f20038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f20039b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f20040c = null;

    static {
        f20040c = new b();
        f20038a = new ArrayList();
        f20039b = new WeakHashMap();
    }

    public b() {
    }

    public final void a(View r10, a r11) {
        q.g(r10, "view");
        q.g(r11, "animationInfo");
        f20039b.put(r10, r11);
    }

    public final void b(d r10) {
        q.g(r10, "animationManager");
        ArrayList r11 = f20038a;
        r11.add(r10);
        qb.b.f23627c.g("AnimationLifecycleListener", "addAnimationManager, size: " + r11.size());
    }

    public final a c(View r10) {
        q.g(r10, "view");
        return (a) f20039b.get(r10);
    }

    public final void d(d r10) {
        q.g(r10, "animationManager");
        ArrayList r11 = f20038a;
        r11.remove(r10);
        qb.b.f23627c.g("AnimationLifecycleListener", "removeAnimationManager, size: " + r11.size());
    }
}
