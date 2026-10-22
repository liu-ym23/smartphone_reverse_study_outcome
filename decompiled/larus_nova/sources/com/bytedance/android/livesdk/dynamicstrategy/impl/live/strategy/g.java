package com.bytedance.android.livesdk.dynamicstrategy.impl.live.strategy;

import android.text.TextUtils;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import ju1.m;
import ju1.n;
import kotlin.jvm.internal.Intrinsics;
import r52.x;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements iu1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PropertyOwner<n> f123200a;

    public static final class a {
    }

    static {
    }

    @Override // iu1.b
    public final void onDestroy() {
    }

    @Override // iu1.b
    public final ju1.h getStrategy() {
        ju1.h r100 = mu1.b.d(x.f536281a.getValue());
        if (r100 == null) goto L8;
        if (TextUtils.equals(r100.b(), "live_component_strategy") == false) goto L8;
        return r100;
    L8:
        return new m("live_component_strategy", 0);
    }

    public g() {
        this.f123200a = new PropertyOwner(new n(0, true));
    }

    @Override // iu1.b
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f123200a.a(r100);
    }

    @Override // iu1.b
    public final void b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f123200a.a(r100);
    }
}
