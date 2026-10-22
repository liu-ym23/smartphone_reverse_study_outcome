package com.bytedance.android.live.profit.redpacket.jsbridge;

import com.bytedance.android.scope.o;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import wy0.h;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements wy0.f, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f88645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vy0.c f88646b;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f88645a = this.f88646b.O3(this);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Disposable r100 = this.f88645a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("disposable");
    L5:
        r100.dispose();
    }

    public e(vy0.c r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridService");
        this.f88646b = r100;
    }

    @Override // wy0.f
    public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.emptyMap();
    }

    @Override // wy0.d
    public final Map<String, h<Object, ?>> c(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.a(r100);
    }

    @Override // wy0.f
    public final Map<String, g<?, ?>> d(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return MapsKt.mapOf(TuplesKt.to("sendRedEnvelopSuccess", new SendRedEnvelopSuccessMethod()));
    }

    @Override // wy0.d
    public final Map<String, g<Object, ?>> f(y6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        return wy0.f.a.b(r100);
    }
}
