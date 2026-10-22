package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.os.SystemClock;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f181533a;

    public d(a r100) {
        this.f181533a = r100;
    }

    public final void a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "stopType");
        if (this.f181533a.f181516j.a() == false) goto L6;
        return;
    L6:
        if (this.f181533a.f181510d >= 0) goto L8;
        return;
    L8:
        long r102 = SystemClock.elapsedRealtime();
        a r103 = this.f181533a;
        long r104 = r102 - r103.f181510d;
        r103.f181510d = -1;
        Pair[] r105 = new Pair[4];
        if (r100 == false) goto L11;
        String r106 = "1";
    L12:
        r105[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_PLAY_OVER, r106);
        r105[1] = TuplesKt.to("duration", Long.valueOf(r104));
        r105[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STOP_TYPE, r101);
        r105[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_VIDEO_SOURCE_TYPE, Integer.valueOf(com.bytedance.android.shopping.extensions.k.f(this.f181533a.f181516j.f181554c.f181582e.h())));
        b("pd_video_play_time", MapsKt.mutableMapOf(r105));
        return;
    L11:
        r106 = "0";
        goto L12
    }

    public final void b(String r100, Map<String, ? extends Object> r110) {
        vg3.z r101 = this.f181533a.f181517k.m();
        if (r101 == null) goto L16;
        LinkedHashMap r102 = new LinkedHashMap();
        Map<String, Object> r103 = this.f181533a.f181516j.f181557f;
        if (r103 == null) goto L7;
        r102.putAll(r103);
    L7:
        if (r110 == null) goto L9;
        r102.putAll(r110);
    L9:
        String r111 = this.f181533a.f181516j.f181554c.f181582e.j();
        if (r111 != null) goto L12;
        r111 = "";
    L12:
        r102.put("video_id", r111);
        Unit r112 = Unit.INSTANCE;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r104 = r101.d(r102);
        if (r104 == null) goto L17;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r104, r100, false, null, null, 14);
        return;
    L17:
        return;
    }
}
