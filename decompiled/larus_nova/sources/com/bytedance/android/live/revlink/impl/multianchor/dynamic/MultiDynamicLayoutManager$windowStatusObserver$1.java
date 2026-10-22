package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/revlink/impl/multianchor/dynamic/MultiDynamicLayoutManager$windowStatusObserver$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lf31/i;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiDynamicLayoutManager$windowStatusObserver$1 implements Observer<f31.i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiDynamicLayoutManager f93858a;

    public MultiDynamicLayoutManager$windowStatusObserver$1(MultiDynamicLayoutManager r100) {
        this.f93858a = r100;
    }

    public final void a(f31.i r100) {
        jy0.b.c("MultiDynamicLayoutManager", "onWindowStatusChange " + r100, null, 4);
        if (r100 != null) goto L5;
        return;
    L5:
        List<f31.k> r101 = r100.f475339a;
        i r102 = r100.f475341c;
        List<f31.k> r103 = r101;
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        return;
    L14:
        if (r102 != null) goto L16;
        r102 = new i(f31.l.e(r101), f31.l.a(r101), f31.l.c(r101), f31.l.d(r101));
    L16:
        MultiDynamicLayoutManager r105 = this.f93858a;
        i r106 = r105.f93853b;
        if (r106 != null) goto L19;
    L28:
        r105.f93853b = r102;
        jy0.b.c("MultiDynamicLayoutManager", "update lynxContainer layout parameters " + this.f93858a.f93853b, null, 4);
        this.f93858a.f93857f.invoke();
        return;
    L19:
        if (r106.f94082a != r102.f94082a) goto L28;
        if (r106.f94083b != r102.f94083b) goto L28;
        if (r106.f94084c != r102.f94084c) goto L28;
        if (r106.f94085d != r102.f94085d) goto L28;
        jy0.b.d("MultiDynamicLayoutManager", "block windowStatus for same content");
        return;
    L8:
        if (r103.isEmpty() == true) goto L11;
        r104 = false;
        goto L12
    }

    @Override // androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        a((f31.i) r100);
    }
}
