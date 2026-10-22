package com.obric.autoaction.app.launcherpage.discovery;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryPagerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends androidx.viewpager2.adapter.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0522a f23570e = null;
    private List<? extends com.obric.autoaction.app.launcherpage.discovery.a.a> f;

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiscoveryPagerAdapter.kt */
    public static final class C0522a {
        public /* synthetic */ C0522a(h r1) {
            this();
        }

        private C0522a() {
        }
    }

    static {
        f23570e = new C0522a(null);
    }

    public a(FragmentManager r2, i r3) {
        o.e(r2, "fragmentManager");
        o.e(r3, "lifecycle");
        super(r2, r3);
        this.f = p.b();
    }

    public final void a(List<? extends com.obric.autoaction.app.launcherpage.discovery.a.a> r3) {
        List<? extends com.obric.autoaction.app.launcherpage.discovery.a.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "value");
        this.f = r4;
        d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f.size();
    }

    @Override // androidx.viewpager2.adapter.a
    public Fragment c(int r3) {
        return (Fragment) ZeusTransformUtils.preCheckCast(DiscoveryPageFragment.Companion.a((com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(this.f.get(r3), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin")), Fragment.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.viewpager2.adapter.a, androidx.recyclerview.widget.RecyclerView.a
    public long b(int r3) {
        return a((com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(this.f.get(r3), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.viewpager2.adapter.a
    public boolean a(long r8) {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L15;
        if (a((com.obric.autoaction.app.launcherpage.discovery.a.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.autoaction.app.launcherpage.discovery.a.a.class, "com.obric.aiagent.plugin")) != r8) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L9;
        return true;
    L13:
        r2 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    private final long a(com.obric.autoaction.app.launcherpage.discovery.a.a r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.discovery.a.a.C0523a.class) == false) goto L6;
        return 0;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class) == false) goto L10;
        return ((com.obric.autoaction.app.launcherpage.discovery.a.a.b) ZeusTransformUtils.preCheckCast(r2, com.obric.autoaction.app.launcherpage.discovery.a.a.b.class, "com.obric.aiagent.plugin")).a().hashCode();
    L10:
        throw new k();
    }
}
