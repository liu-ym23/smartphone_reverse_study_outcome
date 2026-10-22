package com.bytedance.android.shopping.abscontainer.arch.core.ability.impl;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.abscontainer.arch.core.lifecycle.e;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements j33.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x33.a f164125a;

    public c(x33.a r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        this.f164125a = r100;
    }

    public final void c(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        x33.a r101 = this.f164125a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "map");
        i43.a r102 = r101.f562345a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "params");
        r102.appendEventParams(r100);
    }

    @Override // j33.d
    public final void a(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        x33.a r102 = this.f164125a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        i43.a r103 = r102.f562345a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        r103.doEventAction(r100, PageFinder.via(r103.f488211d.Lw()), r101);
        e r104 = r102.f562346b;
        if (r104 == null) goto L6;
        r104.l(r100, r101);
        return;
    }

    public final void b(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        x33.a r102 = this.f164125a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        i43.a r103 = r102.f562345a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r100, "onceKey");
        if (r103.f488210c.contains(r100) == true) goto L5;
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        r103.doEventAction(r100, PageFinder.via(r103.f488211d.Lw()), r101);
        r103.f488210c.add(r100);
    L5:
        e r104 = r102.f562346b;
        if (r104 == null) goto L9;
        r104.l(r100, r101);
        return;
    }
}
