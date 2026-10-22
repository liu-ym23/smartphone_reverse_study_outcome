package com.bytedance.android.shopping.prepurchase.arch.standard.component.pref;

import com.bytedance.android.shopping.prepurchase.arch.container.intf.k;
import com.bytedance.android.shopping.prepurchase.arch.container.state.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c<T> implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StandardPrefService f181009a;

    public c(xg3.d r100) {
        this.f181009a = r100;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
    public final void onChanged(Object r100) {
        k r101 = (k) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        if ((r101 instanceof k.c.b) == false) goto L5;
    L6:
        StandardPrefService r102 = this.f181009a;
        if (r102.f180983i == true) goto L9;
        r102.f180983i = true;
        r102.f180986l.onRenderStart();
    L9:
        this.f181009a.f180987m.a();
        return;
    L5:
        if ((r101 instanceof k.d) == true) goto L6;
    }
}
