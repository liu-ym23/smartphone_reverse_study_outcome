package ad3;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3006a;

    public a(b r100) {
        this.f3006a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        b r100 = this.f3006a;
        Object r101 = r100.f3012g.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r101 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L5;
        r101 = null;
    L5:
        com.bytedance.android.shopping.deepfeed.slice.service.b r102 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r101;
        if (r102 != null) goto L8;
        return true;
    L8:
        if (r102.L() < 0) goto L10;
        return true;
    L10:
        if (r100.f3008c >= 0) goto L16;
        r100.c(r100.f3009d);
        return true;
    L16:
        return true;
    }
}
