package com.bytedance.android.livesdk.widget.schedule;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f162098g;

    @Override // com.bytedance.android.livesdk.widget.schedule.a
    public final long a() {
        return this.f162098g;
    }

    public e(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "widgetsLoadDone");
        super("p0_widgets_load", r100);
        this.f162098g = com.bytedance.android.live.core.tetris.widgets.d.f().getP0WidgetLoadTimeout();
    }
}
