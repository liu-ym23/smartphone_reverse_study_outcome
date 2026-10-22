package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes13.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryVideoVH f169445a;

    public e(GalleryVideoVH r100) {
        this.f169445a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Boolean r101 = (Boolean) r100;
        GalleryVideoVH r102 = this.f169445a;
        int r103 = GalleryVideoVH.f169416s;
        r102.Z3(true);
    }
}
