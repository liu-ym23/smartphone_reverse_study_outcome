package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveActionTracker implements il2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LiveSingleAction> f150730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f150731b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f150732c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f150733d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f150734e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f150735f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.btm.api.model.d f150736g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f150737h;

    public static final class a {
    }

    static {
    }

    @Override // il2.a
    public final il2.b b() {
        return (il2.b) this.f150734e.getValue();
    }

    @Override // il2.a
    public final LiveActionTracker a(g r100) {
        this.f150733d = r100;
        return this;
    }

    @Override // il2.a
    public final LiveActionTracker d(com.bytedance.android.btm.api.model.d r100) {
        this.f150736g = r100;
        return this;
    }

    public final void e(boolean r110) {
        if (this.f150732c == false) goto L5;
        return;
    L5:
        ArrayList r100 = (ArrayList) this.f150730a;
        if ((!r100.isEmpty()) == true) goto L9;
        r100 = null;
    L9:
        ArrayList r101 = r100;
        if (r101 == null) goto L18;
        int r102 = b.f150745a;
        String r103 = this.f150735f;
        g r104 = this.f150733d;
        com.bytedance.android.btm.api.model.d r105 = this.f150736g;
        String r106 = this.f150731b;
        Intrinsics.checkNotNullParameter(r103, "pageName");
        Intrinsics.checkNotNullParameter(r101, "actionStack");
        Intrinsics.checkNotNullParameter(r106, ST.UUID_DEVICE);
        if (r101.isEmpty() == true) goto L18;
        oh.a.c("ecom_live_action_quality_track", new com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.a(r104, r103, r106, r101, r110, r105));     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L18:
        c r111 = this.f150737h;
        r111.getClass();
        Intrinsics.checkNotNullParameter(this, com.bytedance.android.ec.core.event.a.KEY_TRACKER);
        int r107 = c.f150746b;
        dm.a.a("ActionTrack").a("remove tracker " + this);
        c.b r112 = r111.f150747a;
        r112.getClass();
        Intrinsics.checkNotNullParameter(this, "key");
        r112.f150749a.remove(this);
        this.f150732c = true;
    }

    public LiveActionTracker(String r100, com.bytedance.android.btm.api.model.d r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        Intrinsics.checkNotNullParameter(r102, "trackerCenter");
        this.f150735f = r100;
        this.f150736g = r101;
        this.f150737h = r102;
        this.f150730a = new ArrayList();
        this.f150731b = UUID.randomUUID().toString();
        this.f150734e = LazyKt.lazy(LiveActionTracker$trackerExtra$2.INSTANCE);
    }

    @Override // il2.a
    public final LiveActionTracker c(String r100, Map r110, boolean r111, String r112, String r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        if (this.f150732c == false) goto L5;
        return this;
    L5:
        LiveSingleAction r101 = new LiveSingleAction(r100, r110, r111, r112, r113, r114);
        ((ArrayList) this.f150730a).add(r101);
        return this;
    }
}
