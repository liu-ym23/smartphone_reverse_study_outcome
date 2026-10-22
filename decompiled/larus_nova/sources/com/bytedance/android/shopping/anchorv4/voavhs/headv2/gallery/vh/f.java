package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.vh;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery.i;

/* JADX INFO: loaded from: classes13.dex */
public final class f<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GalleryVideoVH f169446a;

    public f(GalleryVideoVH r100) {
        this.f169446a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        GalleryVideoVH r101 = this.f169446a;
        int r102 = ((Integer) r100).intValue();
        View r103 = r101.f169419c;
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L11;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        r105 = null;
    L7:
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        if (r106 == null) goto L11;
        r106.bottomMargin = r102;
        r103.setLayoutParams(r106);
    L11:
        if (i.a() == false) goto L22;
        FrameLayout r107 = r101.f169420d;
        if (r107 == null) goto L23;
        ViewGroup.LayoutParams r108 = r107.getLayoutParams();
        if ((r108 instanceof ViewGroup.MarginLayoutParams) == false) goto L18;
        r104 = r108;
    L18:
        ViewGroup.MarginLayoutParams r109 = (ViewGroup.MarginLayoutParams) r104;
        if (r109 == null) goto L24;
        r109.bottomMargin = r102;
        r107.setLayoutParams(r109);
        return;
    L24:
        return;
    L23:
        return;
    }
}
