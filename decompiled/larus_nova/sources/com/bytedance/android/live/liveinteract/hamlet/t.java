package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f73525a = null;

    static {
        f73525a = new t();
    }

    public t() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        String r100 = ff0.c.a(r111);
        if ((r111 instanceof ApiServerException) == false) goto L5;
        r111.getMessage();
        int r112 = ((ApiServerException) r111).getErrorCode();
    L6:
        af0.a.f3134a.getClass();
        LinkMonitorData r101 = LinkMonitorData.HamletAvatarCameraCreateFail;     // Catch: Exception -> L10
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L10
        r102.put("error_code", r112);     // Catch: Exception -> L10
        Unit r113 = Unit.INSTANCE;     // Catch: Exception -> L10
        af0.a.l(r101, r102);     // Catch: Exception -> L10
    L8:
        ff0.d r114 = ff0.d.f476647a;
        com.bytedance.android.live.liveinteract.utils.j.a(1, "createNewCamera fail", 0, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("logId", String.valueOf(r100))}), 12);
        return;
    L5:
        r112 = 0;
        goto L6
    }
}
