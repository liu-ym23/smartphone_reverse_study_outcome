package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.facebook.imagepipeline.request.BasePostprocessor;

/* JADX INFO: loaded from: classes13.dex */
public final class m extends BasePostprocessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f173851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f173852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f173853c;

    @Override // com.facebook.imagepipeline.request.BasePostprocessor
    public final void process(Bitmap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (com.bytedance.android.shopping.extensions.k.c(this.f173852b) == true) goto L6;
        return;
    L6:
        if (this.f173851a != 0) goto L21;
        Integer r101 = this.f173853c;
        if (r101 != null) goto L11;
    L15:
        Bitmap.Config r102 = r100.getConfig();
        if (r102 == null) goto L22;
        LruCache<String, Bitmap> r103 = l.f173841a;
        Bitmap r104 = l.f173841a.put(this.f173852b, r100.copy(r102, false));
        return;
    L22:
        return;
    L11:
        if (r101.intValue() != 0) goto L15;
        Bitmap.Config r105 = r100.getConfig();
        if (r105 == null) goto L15;
        LruCache<String, Bitmap> r106 = l.f173841a;
        l.f173844d = r100.copy(r105, false);
        goto L15
    }

    public m(int r100, String r101, Integer r102) {
        this.f173851a = r100;
        this.f173852b = r101;
        this.f173853c = r102;
    }
}
