package com.bytedance.android.ecom.arch.slice.render.elements.scroll;

import android.os.SystemClock;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Function4<Integer, Integer, Integer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f50482a;

    public b(c r100) {
        this.f50482a = r100;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Unit invoke(Integer r100, Integer r101, Integer r110, Integer r111) {
        final int r102 = r100.intValue();
        final int r103 = r101.intValue();
        final int r104 = r110.intValue();
        final int r105 = r111.intValue();
        c r106 = this.f50482a;
        final IAction r107 = r106.V3;
        if (r107 == null) goto L11;
        yq.a r108 = r106.W3;
        if (r108 != null) goto L7;
        r108 = new yq.a();
        r106.W3 = r108;
    L7:
        long r112 = r107.getScrollCallbackThreshold();
        Function0<Unit> r109 = new SlcScrollElementViewManager$onScrollListener$1$invoke$1(this, r107, r102, r103, r104, r105);
        long r113 = SystemClock.elapsedRealtime();
        if ((r113 - r108.f568738a) < r112) goto L11;
        r109.invoke();
        r108.f568738a = r113;
    L11:
        return Unit.INSTANCE;
    }
}
