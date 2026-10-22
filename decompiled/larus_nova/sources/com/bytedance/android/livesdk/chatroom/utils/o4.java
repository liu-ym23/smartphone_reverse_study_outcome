package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public final class o4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f114571a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f114572b = "unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f114573c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f114574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f114575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f114576f;

    public class a implements Function2<Boolean, String, Unit> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Boolean r100, String r101) {
            o4.f114574d = r100.booleanValue();
            return null;
        }
    }

    public static void b(boolean r100) {
        if (r100 == false) goto L5;
        a("live_desktop_business", "leave_live_room", "", "normal", new a());
        return;
    }

    public static void c(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("guide_type", r101);
        r102.put(HiAnalyticsConstant.BI_KEY_INSTALL_TYPE, f114572b);
        com.bytedance.android.livesdk.log.u.l().sendLog(r100, r102, new Object[]{Room.class, am2.x.class});
    }

    public static void a(String r100, String r101, String r102, String r110, Function2 r111) {
        ((IHostBusiness) jc1.k.f(IHostBusiness.class)).canShowDesktopGuide(r100, r101, r102, r110, "ug_desktop_guide", r111);
    }
}
