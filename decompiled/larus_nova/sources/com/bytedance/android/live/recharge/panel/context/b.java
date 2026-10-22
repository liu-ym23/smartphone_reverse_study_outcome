package com.bytedance.android.live.recharge.panel.context;

import com.bytedance.revenue.platform.api.core.rx.h;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final void a(final Disposable r100, CompositeDisposable r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$bind");
        if (r101 == null) goto L6;
        int r102 = h.f267513a;
        r101.add(h.a(new CommonRechargePanelPropertiesProviderKt$bind$1(r100)));
        return;
    }
}
