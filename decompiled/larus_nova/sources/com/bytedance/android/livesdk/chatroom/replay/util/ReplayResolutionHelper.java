package com.bytedance.android.livesdk.chatroom.replay.util;

import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayResolutionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f110257a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        if (StringsKt.contains$default(r100, ' ', false, 2, null) == false) goto L8;
        if (r101 == false) goto L7;
        return r100.substring(StringsKt.indexOf$default(r100, ' ', 0, false, 6, null), r100.length());
    L7:
        return r100.substring(0, StringsKt.indexOf$default(r100, ' ', 0, false, 6, null));
    L8:
        return r100;
    }

    @JvmStatic
    public static final void b(boolean r100, String r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        final LinkedHashMap r103 = new LinkedHashMap();
        r103.put("vs_screen_type", "landscape");
        if (Intrinsics.areEqual(r101, PlayerResolution.NAME.ORIGIN) == false) goto L5;
        String r104 = "original";
    L12:
        r103.put("vs_screen_clarity", r104);
        r103.put("vs_is_from_cast_screen", "0");
        if (r100 == false) goto L15;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r102).d("screen_clarity_option_show", r103, new Object[0]);
    L20:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r105 = ReplayDataContext.a.b(r102);
        if (r105 == null) goto L30;
        j<iq1.a> r106 = r105.getLoggerHelper();
        if (r106 == null) goto L31;
        r106.c(new ReplayResolutionHelper$logShowEvent$3(r103));
        return;
    L31:
        return;
    L30:
        return;
    L15:
        ReplayDataContext.Companion.getClass();
        ReplayDataContext r107 = ReplayDataContext.a.b(r102);
        if (r107 == null) goto L20;
        j<iq1.a> r108 = r107.getLoggerHelper();
        if (r108 == null) goto L20;
        r108.c(new ReplayResolutionHelper$logShowEvent$2(r103));
        goto L20
    L5:
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        String r109 = a(r101, true);
        Locale r110 = Locale.ROOT;
        if (r109 == null) goto L29;
        String r111 = r109.toLowerCase(r110);
        if (r111 == null) goto L27;
        r104 = StringsKt.trim(r111).toString();
        goto L12
    L27:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
