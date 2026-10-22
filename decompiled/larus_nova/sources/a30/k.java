package a30;

import com.bytedance.android.live.revlink.api.ILinkService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f1519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1520b;

    public k(j r100, String r101) {
        this.f1519a = r100;
        this.f1520b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        p11.i r102 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getLinkRegionService();
        if (r102 == null) goto L5;
        r102.enableRenderFilter("", false, true);
    L5:
        if (r102 == null) goto L7;
        kc0.i.a.a(r102, this.f1520b);
    L7:
        this.f1519a.k("enable success, from = removeAndEnableWithDelay, linkRegionService = " + r102);
    }
}
