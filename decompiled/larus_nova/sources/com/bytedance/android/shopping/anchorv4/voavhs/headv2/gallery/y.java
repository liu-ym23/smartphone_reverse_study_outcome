package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import androidx.lifecycle.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public final class y<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f169566a;

    public y(t r100) {
        this.f169566a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        t r101 = this.f169566a;
        t.c(r101, (List) r100);
    }
}
