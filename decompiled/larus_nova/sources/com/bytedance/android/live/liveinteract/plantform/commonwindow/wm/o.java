package com.bytedance.android.live.liveinteract.plantform.commonwindow.wm;

import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kh0.a f76103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f76104b;

    public static final class a {
    }

    static {
    }

    public o(boolean r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter("multi_seat_widget", "panelId");
        this.f76104b = r101;
        this.f76103a = new kh0.a(r100, null, "multi_seat_widget", null);
    }
}
