package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f160014a;

    public v(DataCenter r100) {
        this.f160014a = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        DataCenter r101 = this.f160014a;
        if (r101 == null) goto L8;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "1");
        nm1.h r102 = pm1.f.f();
        if (r102 == null) goto L9;
        r102.f(r101, "livesdk_replay_video_tab_entrance_show", r100, new Object[0]);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        DataCenter r101 = this.f160014a;
        if (r101 == null) goto L8;
        nm1.h r102 = pm1.f.f();
        if (r102 == null) goto L9;
        r102.f(r101, "livesdk_replay_video_tab_show", r100, new Object[0]);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void c(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        DataCenter r101 = this.f160014a;
        if (r101 == null) goto L8;
        nm1.h r102 = pm1.f.f();
        if (r102 == null) goto L9;
        r102.f(r101, "livesdk_replay_video_tab_duration", r100, new Object[0]);
        return;
    L9:
        return;
    }
}
