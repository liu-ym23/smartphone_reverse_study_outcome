package com.bytedance.android.livesdk.widget.schedule;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f162100g;

    @Override // com.bytedance.android.livesdk.widget.schedule.a
    public final long a() {
        return this.f162100g;
    }

    public g(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetsLoadDone");
        super("p2_widgets_load", r100);
        this.f162100g = com.bytedance.android.live.core.tetris.widgets.d.f().getP1WidgetLoadTimeout();
    }
}
