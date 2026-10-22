package com.bytedance.android.live.livelink.guestlink.pipeline;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import lb6.f;

/* JADX INFO: loaded from: classes46.dex */
public final class b implements ob6.a.InterfaceC7033a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GuestLinkPipeLineManager f81260a;

    @Override // ob6.a.InterfaceC7033a
    public final void c() {
    }

    @Override // ob6.a.InterfaceC7033a
    public final void s() {
    }

    @Override // ob6.a.InterfaceC7033a
    public final void t() {
    }

    public b(GuestLinkPipeLineManager r100) {
        this.f81260a = r100;
    }

    @Override // ob6.a.InterfaceC7033a
    public final void A(String r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        nb6.a r102 = this.f81260a.f81232c;
        if (r102 == null) goto L14;
        CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
        if (r103 == null) goto L22;
        Iterator<T> r104 = r103.iterator();
    L8:
        if (r104.hasNext() == false) goto L23;
        nb6.b r105 = (nb6.b) r104.next();
        if (r105 == null) goto L8;
        f r106 = r105.f518519a;
        if (r106 == null) goto L8;
        r106.A(r100, r101);
        goto L8
    L23:
        return;
    L22:
        return;
    }

    @Override // ob6.a.InterfaceC7033a
    public final void J(String[] r100, boolean[] r101, int[] r102) {
        nb6.a r103 = this.f81260a.f81232c;
        if (r103 == null) goto L14;
        CopyOnWriteArraySet<nb6.b> r104 = r103.f518518a;
        if (r104 == null) goto L22;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L23;
        nb6.b r106 = (nb6.b) r105.next();
        if (r106 == null) goto L8;
        f r107 = r106.f518519a;
        if (r107 == null) goto L8;
        r107.J(r100, r101, r102);
        goto L8
    L23:
        return;
    L22:
        return;
    }
}
