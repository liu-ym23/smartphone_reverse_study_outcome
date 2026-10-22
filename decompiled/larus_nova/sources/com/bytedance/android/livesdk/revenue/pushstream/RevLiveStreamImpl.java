package com.bytedance.android.livesdk.revenue.pushstream;

import android.view.View;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.live.revlink.impl.multianchor.widget.linkoutstrategy.DoubleLaunchCompactService;
import fr2.j1;
import fr2.q0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes11.dex */
public final class RevLiveStreamImpl extends com.bytedance.android.livesdk.revenue.util.b<d> implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f157272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f157273c;

    @Override // com.bytedance.android.livesdk.revenue.pushstream.a
    public final View getSurfaceView() {
        return ((d) this.f157529a).getSurfaceView();
    }

    @Override // com.bytedance.android.livesdk.revenue.pushstream.a
    public final j1 j() {
        d0 r100 = this.f157273c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return new j1(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.pushstream.a
    public final void x0() {
        ((d) this.f157529a).x0();
    }

    @Override // com.bytedance.android.livesdk.revenue.pushstream.a
    public final d0 A() {
        return this.f157273c;
    }

    public RevLiveStreamImpl(d r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        super(r100);
        this.f157272b = LazyKt.lazy(RevLiveStreamImpl$camObsMap$2.INSTANCE);
        this.f157273c = ((d) this.f157529a).A();
    }

    @Override // com.bytedance.android.livesdk.revenue.pushstream.a
    public final void i(DoubleLaunchCompactService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        q0 r101 = new q0(r100);
        ((d) this.f157529a).o1(r101);
        ((Map) this.f157272b.getValue()).put(r100, r101);
    }
}
