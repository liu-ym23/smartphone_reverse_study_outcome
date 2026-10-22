package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: MenuHostHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f1505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArrayList<j> f1506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<j, a> f1507c;

    /* JADX INFO: compiled from: MenuHostHelper.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final androidx.lifecycle.i f1508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private androidx.lifecycle.m f1509b;

        a(androidx.lifecycle.i r3, androidx.lifecycle.m r4) {
            androidx.lifecycle.m r5 = (androidx.lifecycle.m) ZeusTransformUtils.wrapperContextForParams(r4, androidx.lifecycle.m.class, "com.obric.aiagent.plugin");
            this.f1508a = r3;
            this.f1509b = r5;
            r3.a(r5);
        }

        void a() {
            this.f1508a.b(this.f1509b);
            this.f1509b = null;
        }
    }

    public static /* synthetic */ void lambda$N8zx94pGTJibQxGKylc4LVFYCKg(h r0, androidx.lifecycle.i.b r1, j r2, androidx.lifecycle.p r3, androidx.lifecycle.i.a r4) {
        r0.a(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$x-tzMcHl_TQ78Q9PpJSg-f7eN6g, reason: not valid java name */
    public static /* synthetic */ void m2lambda$xtzMcHl_TQ78Q9PpJSgf7eN6g(h r0, j r1, androidx.lifecycle.p r2, androidx.lifecycle.i.a r3) {
        r0.a(r1, r2, r3);
    }

    public h(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f1506b = new CopyOnWriteArrayList();
        this.f1507c = new HashMap();
        this.f1505a = r4;
    }

    public void a(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        Iterator<j> r3 = this.f1506b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin")).a(r5);
        goto L4
    }

    public void a(Menu r4, MenuInflater r5) {
        Menu r6 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        Iterator<j> r3 = this.f1506b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin")).a(r6, r5);
        goto L4
    }

    public boolean a(MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        Iterator<j> r3 = this.f1506b.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin")).a(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void b(Menu r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        Iterator<j> r3 = this.f1506b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((j) ZeusTransformUtils.preCheckCast(r3.next(), j.class, "com.obric.aiagent.plugin")).b(r5);
        goto L4
    }

    public void a(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        this.f1506b.add(r4);
        this.f1505a.run();
    }

    public void a(j r4, androidx.lifecycle.p r5) {
        final j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r7 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        a(r6);
        androidx.lifecycle.i r8 = r7.getLifecycle();
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f1507c.remove(r6), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.a();
    L5:
        androidx.lifecycle.m r1 = new $$Lambda$h$xtzMcHl_TQ78Q9PpJSgf7eN6g(this, r6);
        this.f1507c.put(r6, new a(r8, r1));
    }

    private /* synthetic */ void a(j r3, androidx.lifecycle.p r4, androidx.lifecycle.i.a r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r7 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r4, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        if (r5 != androidx.lifecycle.i.a.ON_DESTROY) goto L6;
        b(r6);
        return;
    }

    public void a(j r4, androidx.lifecycle.p r5, final androidx.lifecycle.i.b r6) {
        final j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.i r8 = ((androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.p.class, "com.obric.aiagent.plugin")).getLifecycle();
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f1507c.remove(r7), a.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.a();
    L5:
        androidx.lifecycle.m r1 = new $$Lambda$h$N8zx94pGTJibQxGKylc4LVFYCKg(this, r6, r7);
        this.f1507c.put(r7, new a(r8, r1));
    }

    private /* synthetic */ void a(androidx.lifecycle.i.b r3, j r4, androidx.lifecycle.p r5, androidx.lifecycle.i.a r6) {
        j r7 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r8 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r5, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        if (r6 != androidx.lifecycle.i.a.b(r3)) goto L6;
        a(r7);
        return;
    L6:
        if (r6 != androidx.lifecycle.i.a.ON_DESTROY) goto L9;
        b(r7);
        return;
    L9:
        if (r6 != androidx.lifecycle.i.a.a(r3)) goto L14;
        this.f1506b.remove(r7);
        this.f1505a.run();
        return;
    }

    public void b(j r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        this.f1506b.remove(r4);
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.f1507c.remove(r4), a.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L5;
        r5.a();
    L5:
        this.f1505a.run();
    }
}
