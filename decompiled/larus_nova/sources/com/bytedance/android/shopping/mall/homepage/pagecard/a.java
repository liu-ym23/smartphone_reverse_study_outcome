package com.bytedance.android.shopping.mall.homepage.pagecard;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PageCard f178289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f178290b;

    public a(PageCard r100, List r101) {
        this.f178289a = r100;
        this.f178290b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Function0<Unit> r102 = this.f178289a.f178270h;
        if (r102 == null) goto L5;
        r102.invoke();
        nf3.a r103 = this.f178289a.f178275m;
        int r104 = nf3.a.f518944c;
        r103.a(false, false);
        Lazy r105 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.b.f47502b, "pagecard asyncGetDynamicParams timeout : " + this.f178290b);
    L5:
        this.f178289a.f178270h = null;
    }
}
