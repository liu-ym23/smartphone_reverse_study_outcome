package com.bytedance.android.livesdk.gift.platform.business.anchor;

import com.bytedance.android.scope.o;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes9.dex */
public final class AnchorTrayPostEffectService implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f126519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f126520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f126521c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        Iterator r100 = ((Map) this.f126520b.getValue()).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Disposable r101 = ((e) r100.next()).f126530b;
        if (r101 == null) goto L4;
        r101.dispose();
        goto L4
    }

    public AnchorTrayPostEffectService(k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f126521c = r100;
        this.f126519a = new AtomicBoolean(false);
        this.f126520b = LazyKt.lazy(AnchorTrayPostEffectService$postEffectTimerMap$2.INSTANCE);
    }
}
