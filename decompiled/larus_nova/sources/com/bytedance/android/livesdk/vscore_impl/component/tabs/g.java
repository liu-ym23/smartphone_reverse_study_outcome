package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataCenter f159959a;

    public g(DataCenter r100) {
        this.f159959a = r100;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void a(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        if (this.f159959a == null) goto L6;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "0");
        int r101 = TabLogHelper.f159919a;
        TabLogHelper.b("livesdk_live_tab_entrance_show", r100, this.f159959a);
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void b(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        DataCenter r101 = this.f159959a;
        if (r101 == null) goto L6;
        TabLogHelper.b("livesdk_live_tab_show", r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_impl.component.tabs.w
    public final void c(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        DataCenter r101 = this.f159959a;
        if (r101 == null) goto L6;
        TabLogHelper.b("livesdk_live_tab_duration", r100, r101);
        return;
    }
}
