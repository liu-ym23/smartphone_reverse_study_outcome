package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.PixelCopy;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseInfoServiceSnapshotTransitionController f181703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f181704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f181705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f181706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Bitmap f181707e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f181708f;

    public b(BaseInfoServiceSnapshotTransitionController r100, Rect r101, boolean r102, Function1 r103, Bitmap r104, Integer r105) {
        this.f181703a = r100;
        this.f181704b = r101;
        this.f181705c = r102;
        this.f181706d = r103;
        this.f181707e = r104;
        this.f181708f = r105;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        if (r100 != 0) goto L5;
        this.f181703a.f181606j = null;
        dm.a.a("PdpSnapshotTransition").b("capture success mode=pixel_copy bounds=" + this.f181704b + " expanded=" + this.f181705c, null);
        this.f181706d.invoke(new BaseInfoServiceSnapshotTransitionController.c(this.f181703a.f181613q, new Rect(this.f181704b), this.f181705c, this.f181707e, this.f181708f));
        return;
    L5:
        this.f181703a.g("capture_pixel_copy_failed:" + r100);
        this.f181706d.invoke(null);
    }
}
