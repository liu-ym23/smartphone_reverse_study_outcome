package com.obric.aiagent.skill.manager.impl.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SkillShopPageFragment.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ce extends androidx.viewpager2.adapter.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f20712e;
    private List<? extends bu> f;

    public ce(FragmentActivity r3, boolean r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "activity");
        super(r5);
        this.f20712e = r4;
        this.f = d.a.p.b();
    }

    public final void a(List<? extends bu> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "value");
        if (d.h.b.o.a(this.f, r4) == false) goto L5;
        return;
    L5:
        this.f = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin"));
        d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int a() {
        return this.f.size();
    }

    @Override // androidx.viewpager2.adapter.a
    public Fragment c(int r3) {
        bu r4 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f, r3), bu.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return new Fragment();
    L7:
        return (Fragment) ZeusTransformUtils.preCheckCast(SkillShopPageFragment.Companion.a(r4, this.f20712e), Fragment.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.viewpager2.adapter.a, androidx.recyclerview.widget.RecyclerView.a
    public long b(int r3) {
        bu r2 = (bu) ZeusTransformUtils.preCheckCast(d.a.p.d(this.f, r3), bu.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        return r2.e();
    L6:
        return r3;
    }

    @Override // androidx.viewpager2.adapter.a
    public boolean a(long r7) {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r6.iterator();
    L9:
        if (r8.hasNext() == false) goto L15;
        if (((bu) ZeusTransformUtils.preCheckCast(r8.next(), bu.class, "com.obric.aiagent.plugin")).e() != r7) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L9;
        return true;
    L13:
        r0 = false;
    L15:
        return false;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L7;
        goto L7
    }
}
