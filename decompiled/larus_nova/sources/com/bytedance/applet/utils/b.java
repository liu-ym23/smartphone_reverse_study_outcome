package com.bytedance.applet.utils;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.JsonObject;
import com.larus.audioplayer.api.stream.StreamPlayerStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements y78.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f192281a = null;

    static {
        f192281a = new b();
    }

    public b() {
    }

    @Override // y78.a
    public final void a(String r100, StreamPlayerStatus r101, Integer r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        Intrinsics.checkNotNullParameter(r101, "newStates");
        Intrinsics.checkNotNullParameter(r103, "errorMsg");
        Intrinsics.checkNotNullParameter(r104, "pauseReason");
        FLogger.f375446a.i("StreamListener", "【stream player state change, call first part】, newStates=" + r101);
        com.bytedance.applet.task.b.f192232a.getClass();
        com.bytedance.applet.task.b.e(r101);
        Lazy r105 = l3.d.f507201a;
        JsonObject r106 = new JsonObject();
        r106.addProperty(ST.UUID_DEVICE, r100);
        r106.addProperty("status", r101.getValue());
        if (r102 == null) goto L5;
        int r107 = r102.intValue();
    L6:
        r106.addProperty("errorCode", Integer.valueOf(r107));
        r106.addProperty("reason", r103);
        Unit r108 = Unit.INSTANCE;
        l3.d.c(new l3.a("flow.streamAudioPlayStatusChanged", r106, 4));
        return;
    L5:
        r107 = 0;
        goto L6
    }
}
