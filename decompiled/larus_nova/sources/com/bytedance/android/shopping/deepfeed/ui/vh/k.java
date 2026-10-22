package com.bytedance.android.shopping.deepfeed.ui.vh;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.ec.model.ECUrlModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductBannerImageVH f173838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECUrlModel f173839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f173840c;

    public k(DeepFeedProductBannerImageVH r100, ECUrlModel r101, int r102) {
        this.f173838a = r100;
        this.f173839b = r101;
        this.f173840c = r102;
    }

    public final void a() {
        LruCache<String, Bitmap> r100 = l.f173841a;
        ECUrlModel r101 = this.f173839b;
        int r102 = this.f173840c;
        Bitmap r103 = this.f173838a.V3();
        if (r102 != 0) goto L25;
        if (r103 == null) goto L26;
        if (r101 == null) goto L10;
        List<String> r104 = r101.getUrlList();
        if (r104 == null) goto L10;
        String r105 = (String) CollectionsKt.firstOrNull(r104);
    L12:
        if (r105 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L27;
        Bitmap.Config r107 = r103.getConfig();
        if (r107 != null) goto L23;
        r107 = Bitmap.Config.ARGB_8888;
    L23:
        l.f173843c.put(r105, r103.copy(r107, false));
        return;
    L27:
        return;
    L14:
        if (r105.length() == 0) goto L17;
        r106 = false;
    L10:
        r105 = null;
        goto L12
    L26:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
