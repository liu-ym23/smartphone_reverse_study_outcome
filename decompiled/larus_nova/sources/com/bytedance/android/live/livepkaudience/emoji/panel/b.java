package com.bytedance.android.live.livepkaudience.emoji.panel;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f81978b;

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int a() {
        return 1;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final int c() {
        return 0;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final String d() {
        return "";
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final Object b() {
        return this.f81978b;
    }

    @Override // com.bytedance.android.live.livepkaudience.emoji.panel.g
    public final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Object r101 = r100.getTag();
        if (r101 == null) goto L9;
        int r102 = ((Integer) r101).intValue();
        if (r102 == this.f81978b.f81980b) goto L10;
        this.f81981a.z5(r102, false);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public b(f r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "extra");
        super(r100);
        this.f81978b = r101;
    }
}
