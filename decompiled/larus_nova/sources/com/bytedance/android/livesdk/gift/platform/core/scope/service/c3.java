package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c3 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f131487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2 f131488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vy0.b f131489c;

    public static final class a implements wy0.d {
        public a() {
        }

        @Override // wy0.d
        public final Map<String, wy0.h<Object, ?>> c(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            return new LinkedHashMap();
        }

        @Override // wy0.d
        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r100) {
            Intrinsics.checkNotNullParameter(r100, "manager");
            Intrinsics.checkNotNullParameter(r100, "manager");
            return MapsKt.emptyMap();
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        com.bytedance.revenue.platform.api.core.rx.f.a(this.f131489c.Sb(new a()), this.f131487a);
        this.f131488b.g0();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131487a.clear();
    }

    public c3(t2 r100, vy0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "globalJsbService");
        Intrinsics.checkNotNullParameter(r101, "hybridService");
        this.f131488b = r100;
        this.f131489c = r101;
        this.f131487a = new CompositeDisposable();
    }
}
