package cd3;

import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements SlcScrollingView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f23370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SlcScrollingView f23371b;

    @Override // com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView.b
    public final void a() {
        if (this.f23370a.W3.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L14;
        Object r101 = this.f23370a.f50260a.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r101 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == true) goto L10;
        r101 = null;
    L10:
        com.bytedance.android.shopping.deepfeed.slice.service.b r102 = (com.bytedance.android.shopping.deepfeed.slice.service.b) r101;
        if (r102 == null) goto L15;
        b r103 = this.f23370a;
        r102.O(r103.W3, r103.X3, this.f23371b);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public a(b r100, SlcScrollingView r101) {
        this.f23370a = r100;
        this.f23371b = r101;
    }
}
