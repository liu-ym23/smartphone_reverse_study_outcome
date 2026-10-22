package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class x<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169563a;

    public x(t r100) {
        this.f169563a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (((Integer) r100).intValue() < 0) goto L9;
        t r101 = this.f169563a;
        List<s> r102 = r101.f169396d.f169328f.getThumbList().getValue();
        if (r102 != null) goto L7;
        r102 = CollectionsKt.emptyList();
    L7:
        t.c(r101, r102);
        return;
    }
}
