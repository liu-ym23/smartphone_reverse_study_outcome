package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class PanelElementProvider implements kp1.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f116545a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PanelElementProvider f116546b = null;

    public PanelElementProvider() {
    }

    static {
        f116546b = new PanelElementProvider();
        f116545a = LazyKt.lazy(PanelElementProvider$providers$2.INSTANCE);
    }

    @Override // kp1.c
    public final kp1.b<? extends lp1.b<Object>> a(kp1.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        kp1.c r101 = (kp1.c) ((Map) f116545a.getValue()).get(r100.getType());
        if (r101 == null) goto L7;
        kp1.b<? extends lp1.b<Object>> r102 = r101.a(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return w.f116585b.a(r100);
    }
}
