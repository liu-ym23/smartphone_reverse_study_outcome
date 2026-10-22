package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.widget;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class k<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f169518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l f169519b;

    public k(h r100, com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.l r101) {
        this.f169518a = r100;
        this.f169519b = r101;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        this.f169518a.f169512f = null;
        int r102 = r101.intValue() + 1;
        if (r101.intValue() >= 0) goto L5;
    L13:
        this.f169518a.f169508b.add(r101);
        h r103 = this.f169518a;
        if (r103.f169510d == true) goto L19;
        Runnable r104 = r103.f169512f;
        if (r104 == null) goto L20;
        r104.run();
        return;
    L20:
        return;
    L19:
        return;
    L5:
        if (this.f169518a.f169508b.contains(Integer.valueOf(r102)) == true) goto L13;
        List<com.bytedance.android.ec.model.k> r105 = this.f169519b.f169324b;
        if (r105 == null) goto L13;
        com.bytedance.android.ec.model.k r106 = (com.bytedance.android.ec.model.k) CollectionsKt.getOrNull(r105, r102);
        if (r106 == null) goto L13;
        if (r106.getType() != 2) goto L13;
        h r107 = this.f169518a;
        r107.f169512f = new j(this, r102);
        goto L13
    }
}
