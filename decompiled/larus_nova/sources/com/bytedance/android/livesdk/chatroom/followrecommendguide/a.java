package com.bytedance.android.livesdk.chatroom.followrecommendguide;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.h31;
import com.bytedance.android.livesdk.config.kx;
import com.bytedance.android.livesdk.config.r4;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IPersonalizedContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h31 f106238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f106239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f106240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f106241d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Long, IPersonalizedContext> f106242e = null;

    static {
        f106238a = kx.f120635a.getValue();
        f106239b = 1;
        f106240c = "next_room";
        LinkedHashSet r100 = new LinkedHashSet();
        r100.add("follow_recommend");
        f106241d = r100;
        f106242e = new LinkedHashMap();
        if (j() == false) goto L34;
        h31 r101 = f106238a;
        if (r101 == null) goto L44;
        Map<String, r4> r102 = r101.c();
        if (r102 != null) goto L9;
        return;
    L9:
        if ((!r102.isEmpty()) == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L46;
        Iterator<r4> r103 = r102.values().iterator();
    L15:
        if (r103.hasNext() == false) goto L47;
        r4 r104 = r103.next();
        boolean r105 = false;
        if (r104.f().length() <= 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L15;
        if (r104.g().length() <= 0) goto L24;
        r105 = true;
    L24:
        if (r105 == false) goto L15;
        Set<String> r107 = f106241d;
        StringBuilder r108 = new StringBuilder();
        String r109 = r104.f();
        if (r109 == null) goto L33;
        r108.append(r109.toLowerCase());
        r108.append("_");
        String r110 = r104.g();
        if (r110 == null) goto L31;
        r108.append(r110.toLowerCase());
        r107.add(r108.toString());
        goto L15
    L31:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L33:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L19:
        r106 = false;
        goto L20
    L47:
        return;
    L46:
        return;
    L44:
        return;
    }

    @JvmStatic
    public static final boolean b() {
        if (f106238a.h() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean e() {
        if (f106238a.h() != 3) goto L5;
    L8:
        return true;
    L5:
        if (f106238a.h() == 4) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean j() {
        if (f106238a.i() == false) goto L5;
    L8:
        return true;
    L5:
        if (f106238a.g() == true) goto L8;
        return false;
    }

    @JvmStatic
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterSource");
        if (b() == true) goto L5;
        return false;
    L5:
        h31 r101 = f106238a;
        if (r101 == null) goto L17;
        Map<String, r4> r102 = r101.c();
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.containsKey(r100) != true) goto L19;
        r4 r103 = f106238a.c().get(r100);
        if (r103 != null) goto L14;
        return false;
    L14:
        if (r103.h() != true) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L17:
        return false;
    }

    @JvmStatic
    public static final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "enterSource");
        if (b() == true) goto L5;
        return false;
    L5:
        List<String> r101 = f106238a.e();
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.contains(r100.toLowerCase()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @JvmStatic
    public static final boolean d(String r100) {
        if (r100 == null) goto L11;
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 != true) goto L11;
        return false;
    L7:
        r101 = false;
    L11:
        if (j() == false) goto L20;
        Iterator<String> r102 = f106241d.iterator();
    L14:
        if (r102.hasNext() == false) goto L24;
        String r103 = r102.next();
        if (r100 == null) goto L14;
        if (StringsKt.contains$default(r100, r103, false, 2, null) != true) goto L14;
        return true;
    L24:
        return false;
    L20:
        if (r100 == null) goto L24;
        if (StringsKt.contains$default(r100, "follow_recommend_", false, 2, null) != true) goto L24;
        return true;
    }

    @JvmStatic
    public static final void g(String r100) {
        ALogger.i("InnerFeedEmptyRecommendGuideUtil", r100);
    }

    @JvmStatic
    public static final void h(boolean r100) {
        g r101 = u.l();
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == false) goto L5;
        String r103 = ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN;
    L6:
        r102.put("draw_action", r103);
        Unit r104 = Unit.INSTANCE;
        r101.sendLog("livesdk_end_to_recommend_draw_success", r102, new Object[]{new x(), Room.class});
        return;
    L5:
        r103 = "up";
        goto L6
    }

    @JvmStatic
    public static final boolean f(String r100, String r101) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (r100 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L33;
        if (r101 != null) goto L15;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L39;
        String r104 = r100 + '-' + r101;
        h31 r105 = f106238a;
        if (r105 == null) goto L34;
        Map<String, r4> r106 = r105.c();
        if (r106 != null) goto L26;
        return false;
    L26:
        if (r106.containsKey(r104) != true) goto L36;
        r4 r107 = f106238a.c().get(r104);
        if (r107 != null) goto L30;
        return false;
    L30:
        if (r107.i() != true) goto L38;
        return true;
    L38:
        return false;
    L36:
        return false;
    L34:
        return false;
    L39:
        return false;
    L15:
        if (r101.length() == 0) goto L18;
        r103 = false;
        goto L19
    L33:
        return false;
    L8:
        if (r100.length() == 0) goto L11;
        r102 = false;
        goto L12
    }

    @JvmStatic
    public static final void i(Map<String, String> r100, Long r101) {
        g r102 = u.l();
        LinkedHashMap r103 = new LinkedHashMap();
        if (r100 == null) goto L6;
        String r104 = r100.get(com.bytedance.android.ec.core.event.a.KEY_EXIT_TYPE);
        if (r104 == null) goto L6;
    L7:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_EXIT_TYPE, r104);
        if (r101 == null) goto L19;
        IPersonalizedContext r105 = (IPersonalizedContext) ((LinkedHashMap) f106242e).get(Long.valueOf(r101.longValue()));
        if (r105 == null) goto L19;
        Map<String, String> r106 = r105.packSlideUpPersonalEventMap();
        if (r106 == null) goto L19;
        if ((!r106.isEmpty()) == true) goto L17;
        r106 = null;
    L17:
        if (r106 == null) goto L19;
        r103.putAll(r106);
    L19:
        Unit r107 = Unit.INSTANCE;
        r102.sendLog("livesdk_live_exit_new", r103, new Object[]{new x(), Room.class});
        return;
    L6:
        r104 = "right_draw";
        goto L7
    }
}
