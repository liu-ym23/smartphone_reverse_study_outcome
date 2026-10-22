package com.bytedance.android.live.liveinteract.animation;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<g> f70970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f70971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f70972c;

    public final void i() {
        Iterator<g> r100 = this.f70970a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().a();
        goto L4
    }

    public final void j() {
        Iterator<g> r100 = this.f70970a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().f();
        goto L4
    }

    public final void k() {
        Iterator<g> r100 = this.f70970a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().d();
        goto L4
    }

    public final void l() {
        Iterator<g> r100 = this.f70970a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().g();
        goto L4
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final String a() {
        return this.f70971b;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public int getType() {
        return this.f70972c;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.f
    public final void d(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        if (this.f70970a.contains(r100) == true) goto L6;
        this.f70970a.add(r100);
        return;
    }

    public final void h(f r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        Iterator<g> r101 = this.f70970a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().b(r100);
        goto L4
    }

    public c(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f70971b = r100;
        this.f70972c = r101;
        this.f70970a = new CopyOnWriteArrayList();
    }
}
