package com.bytedance.android.livesdk.floatview.mob;

import am2.x;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f125240a = 0;

    static {
    }

    public static void a(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("click_result", m2.b(r100));
        u.l().sendLog("livesdk_mini_window_popup_autoset_click", r101, new Object[]{Room.class, x.class});
    }

    public static void b(HashMap r100) {
        HashMap r101 = new HashMap();
        r101.putAll(r100);
        u.l().sendLog("livesdk_mini_window_popup_click", r101, new Object[]{Room.class, x.class});
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter("live_detail", "eventPage");
        g r101 = u.l();
        HashMap r102 = new HashMap();
        r102.put("click_result", r100);
        Unit r103 = Unit.INSTANCE;
        x r104 = new x();
        r104.f4350b = "live_detail";
        r101.sendLog("livesdk_part_mini_window_set_click", r102, new Object[]{r104, Room.class});
    }
}
