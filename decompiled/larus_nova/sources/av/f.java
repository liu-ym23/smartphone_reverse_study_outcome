package av;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.gamecp.common.track.monitor.page.GPFragmentLifeCycleListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements e, av.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<e> f16350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, d> f16351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f16352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Activity, Boolean> f16353d;

    public static final class a {
    }

    static {
    }

    @Override // av.a
    public final void c() {
        if (this.f16351b.size() > 0) goto L5;
        return;
    L5:
        boolean r100 = !com.bytedance.android.gamecp.common.utils.e.a();
        Iterator<Map.Entry<String, d>> r101 = this.f16351b.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L19;
        d r102 = r101.next().getValue();
        if (r100 == false) goto L15;
        if (r102.f16344b <= 0) goto L15;
        if (r102.f16347e > 0) goto L15;
        r102.f16347e = System.currentTimeMillis();
    L15:
        if (r100 == true) goto L7;
        if (r102.f16347e <= 0) goto L7;
        r102.f16348f += System.currentTimeMillis() - r102.f16347e;
        r102.f16347e = 0;
        goto L7
    }

    public f() {
        this.f16350a = new ArrayList();
        this.f16351b = new HashMap();
        this.f16352c = new AtomicBoolean(false);
        this.f16353d = new WeakHashMap();
    }

    @Override // av.e
    public final void a(Object r110) {
        Intrinsics.checkNotNullParameter(r110, "page");
        String r100 = String.valueOf(r110.hashCode());
        d r101 = this.f16351b.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        View r102 = r101.f16343a.get();
        if (r102 == null) goto L14;
        int r103 = com.bytedance.android.gamecp.common.track.monitor.a.f56810y;
        com.bytedance.android.gamecp.common.track.monitor.a.C0914a.a(r102, true);
        if (r101.f16344b <= 0) goto L13;
        long r104 = System.currentTimeMillis();
        long r105 = r101.f16348f;
        long r106 = r101.f16347e;
        if (r106 <= 0) goto L12;
        r105 = r104 - r106;
    L12:
        r101.f16345c = (r104 - r101.f16344b) - r105;
    L13:
        r101.f16346d.b(r102, r101.f16345c / 1000.0f);
    L14:
        this.f16351b.remove(r100);
        e(this, r110, true, false, false, 12);
    }

    @Override // av.e
    public final void b(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        String r101 = String.valueOf(r100.hashCode());
        d r102 = this.f16351b.get(r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if (r102.f16343a.get() != null) goto L8;
        this.f16351b.remove(r101);
    L8:
        e(this, r100, false, false, true, 6);
    }

    @Override // av.e
    public final void d(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        e(this, r100, false, true, false, 10);
        String r101 = String.valueOf(r100.hashCode());
        d r102 = this.f16351b.get(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        View r103 = r102.f16343a.get();
        if (r103 == null) goto L13;
        int r104 = com.bytedance.android.gamecp.common.track.monitor.a.f56810y;
        com.bytedance.android.gamecp.common.track.monitor.a.C0914a.a(r103, false);
        if (r102.f16349g == true) goto L11;
        r102.f16346d.a(r103);
        r102.f16349g = true;
    L11:
        if (r102.f16344b > 0) goto L15;
        r102.f16344b = System.currentTimeMillis();
        return;
    L15:
        return;
    L13:
        this.f16351b.remove(r101);
    }

    public final void f(Object r100) {
        if ((r100 instanceof Activity) == false) goto L20;
        if (this.f16352c.compareAndSet(false, true) == false) goto L7;
        ((Activity) r100).getApplication().registerActivityLifecycleCallbacks(new b(this, this));
    L7:
        Boolean r101 = this.f16353d.get(r100);
        Boolean r102 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r101, r102)) == true) goto L10;
        return;
    L10:
        if ((r100 instanceof FragmentActivity) == true) goto L12;
        Object r103 = null;
    L13:
        FragmentActivity r104 = (FragmentActivity) r103;
        if (r104 == null) goto L18;
        FragmentManager r105 = r104.getSupportFragmentManager();
        if (r105 == null) goto L18;
        r105.registerFragmentLifecycleCallbacks(new GPFragmentLifeCycleListener(this), true);
    L18:
        this.f16353d.put(r100, r102);
        return;
    L12:
        r103 = r100;
        goto L13
    L20:
        if ((r100 instanceof Fragment) == true) goto L22;
        return;
    L22:
        if (this.f16352c.compareAndSet(false, true) == false) goto L28;
        FragmentActivity r106 = ((Fragment) r100).getActivity();
        if (r106 == null) goto L28;
        Application r107 = r106.getApplication();
        if (r107 == null) goto L28;
        r107.registerActivityLifecycleCallbacks(new b(this, this));
    L28:
        FragmentActivity r108 = ((Fragment) r100).getActivity();
        if (r108 == null) goto L40;
        Boolean r109 = this.f16353d.get(r108);
        Boolean r110 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r109, r110)) == false) goto L41;
        FragmentManager r111 = r108.getSupportFragmentManager();
        if (r111 == null) goto L35;
        r111.registerFragmentLifecycleCallbacks(new GPFragmentLifeCycleListener(this), true);
    L35:
        this.f16353d.put(r108, r110);
        return;
    L41:
        return;
    }

    public static void e(f r100, Object r101, boolean r102, boolean r103, boolean r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = false;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = false;
    L11:
        r100.getClass();
        Iterator r106 = new ArrayList(r100.f16350a).iterator();
    L13:
        if (r106.hasNext() == false) goto L21;
        e r107 = (e) r106.next();
        if (r102 == true) goto L16;
        if (r103 == true) goto L18;
        if (r104 == false) goto L13;
        r107.b(r101);
        goto L13
    L18:
        r107.d(r101);
        goto L13
    L16:
        r107.a(r101);
        goto L13
    }
}
