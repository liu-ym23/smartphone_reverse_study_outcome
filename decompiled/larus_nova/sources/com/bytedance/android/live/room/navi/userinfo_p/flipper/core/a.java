package com.bytedance.android.live.room.navi.userinfo_p.flipper.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements w91.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<w91.a.InterfaceC8082a> f100036a;

    @Override // w91.a
    public final void d() {
    }

    @Override // w91.a
    public final int a() {
        return ((ArrayList) this.f100036a).size();
    }

    public final void f() {
        Iterator r100 = ((ArrayList) this.f100036a).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        w91.a.InterfaceC8082a r101 = (w91.a.InterfaceC8082a) r100.next();
        r100.remove();
        if (r101 == null) goto L4;
        r101.a();
        goto L4
    }

    public a() {
        this.f100036a = new ArrayList();
    }

    @Override // w91.a
    public final boolean b(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        List<w91.a.InterfaceC8082a> r101 = this.f100036a;
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator r103 = ((ArrayList) r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((w91.a.InterfaceC8082a) r103.next(), r100) == false) goto L7;
        r102 = true;
    L11:
        if (r102 == true) goto L14;
        ((ArrayList) this.f100036a).add(r100);
    L14:
        return !r102;
    }

    @Override // w91.a
    public final boolean c(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Iterator r101 = ((ArrayList) this.f100036a).iterator();
        if (r101.hasNext() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual((w91.a.InterfaceC8082a) r101.next(), r100) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // w91.a
    public final boolean e(w91.a.InterfaceC8082a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        List<w91.a.InterfaceC8082a> r101 = this.f100036a;
        if (r101 != null) goto L5;
        return false;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L18;
        Iterator r102 = ((ArrayList) this.f100036a).iterator();
    L9:
        if (r102.hasNext() == false) goto L19;
        if (Intrinsics.areEqual((w91.a.InterfaceC8082a) r102.next(), r100) == false) goto L9;
        r102.remove();
        return true;
    L19:
        return false;
    L18:
        return false;
    }
}
