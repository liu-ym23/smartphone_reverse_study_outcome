package com.bytedance.android.livesdk.livecommerce.params;

import android.content.Context;
import com.bytedance.android.ec.core.utils.LoginUtil;
import com.bytedance.android.livesdk.livecommerce.event.i;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<Context, Unit> f149784a = null;

    public a() {
    }

    static {
        f149784a = new WeakHashMap();
    }

    public static final void a(String r100, String r101, List r102) {
        i r103 = new i();
        Intrinsics.checkNotNullParameter(r100, "reason");
        r103.f("failure_reason", r100);
        String r104 = String.valueOf(r102);
        r103.f("action_params_type", r101);
        r103.f("paramsTypes", r104);
        r103.k();
    }

    public static void b(final Context r110, final String r111, final String r112, final String r113, final String r114, final boolean r115, List r116, List r117, Map r210, Map r211, int r212) {
        if ((r212 & 64) == 0) goto L5;
        final List r100 = null;
    L7:
        if ((r212 & 128) == 0) goto L9;
        final List r101 = null;
    L11:
        if ((r212 & 256) == 0) goto L13;
        final Map r102 = null;
    L15:
        if ((r212 & 512) == 0) goto L17;
        final Map r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Intrinsics.areEqual(r114, "xtab_mall") == false) goto L25;
        if (r103 != null) goto L22;
        r103 = MapsKt.emptyMap();
    L22:
        if (r102 != null) goto L24;
        r102 = MapsKt.emptyMap();
    L24:
        Map<String, String> r104 = LoginUtil.f45533a;
        LoginUtil.f(r110, new LiveJumpWithParamsHelper$openSchemaAppendLiveEntrance$1(r113, r103, r102, r110));
        return;
    L25:
        Map<String, String> r105 = LoginUtil.f45533a;
        LoginUtil.f(r110, new LiveJumpWithParamsHelper$openSchemaWithParams$1(r111, r112, r101, r113, r103, r114, r100, r110, r115));
        return;
    L17:
        r103 = r211;
        goto L18
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r117;
        goto L11
    L5:
        r100 = r116;
        goto L7
    }
}
