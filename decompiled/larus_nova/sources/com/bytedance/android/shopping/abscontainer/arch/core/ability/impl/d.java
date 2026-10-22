package com.bytedance.android.shopping.abscontainer.arch.core.ability.impl;

import android.view.View;
import com.gyf.barlibrary.ImmersionBar;
import j33.e;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l33.c f164126a;

    @Override // j33.e
    public final View d(String r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // j33.e
    public final View e(Map<String, ?> r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // j33.e
    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "theme");
        int r101 = r100.hashCode();
        if (r101 == 3075958) goto L15;
        if (r101 == 102970646) goto L8;
        return;
    L8:
        if (r100.equals("light") == false) goto L22;
        ImmersionBar r102 = ImmersionBar.with(this.f164126a.getContainerContext());
        if (r102 == null) goto L23;
        ImmersionBar r103 = r102.statusBarDarkFont(true);
        if (r103 == null) goto L24;
        r103.init();
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L15:
        if (r100.equals("dark") == false) goto L26;
        ImmersionBar r104 = ImmersionBar.with(this.f164126a.getContainerContext());
        if (r104 == null) goto L27;
        ImmersionBar r105 = r104.statusBarDarkFont(false);
        if (r105 == null) goto L28;
        r105.init();
        return;
    L28:
        return;
    L27:
        return;
    }

    @Override // j33.e
    public final Pair<Integer, String> h(Map<String, ?> r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // j33.e
    public final Map<String, Float> i(View r100) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // j33.e
    public final void showToast(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public d(l33.c r100, p33.a r101) {
        Intrinsics.checkNotNullParameter(r100, "platformContainerDelegate");
        Intrinsics.checkNotNullParameter(r101, "layoutStruct");
        this.f164126a = r100;
    }

    @Override // j33.e
    public final void g(View r100, View r101, Integer r102, Map<String, ?> r103, String r104, Function0<Unit> r105) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
