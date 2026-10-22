package com.bytedance.android.livesdk.slideuptip;

import am2.x;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.c0;
import com.bytedance.android.livesdk.chatroom.m0;
import com.bytedance.android.livesdk.chatroom.viewmodule.z;
import com.bytedance.android.livesdk.chatroom.viewmodule.z0;
import com.bytedance.android.livesdk.config.ih1;
import com.bytedance.android.livesdk.config.og1;
import com.bytedance.android.livesdk.config.pg1;
import com.bytedance.android.livesdk.config.t7;
import com.bytedance.android.livesdk.interactivity.api.enterroom.IEnterGuideService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListProvider;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.LiveMultiTabRoomViewModel;
import com.bytedance.android.livesdkapi.model.SlideUpTipABV2Config;
import com.bytedance.android.livesdkapi.service.IGuideManagerService;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f158424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f158425b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f158426c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f158427d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f158428e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f158429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f158430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f158431h;

    public interface a {
        void a(boolean r100, SlideUpTipsTriggerSource r101);
    }

    public interface b {
        boolean a();
    }

    static {
        f158424a = Arrays.asList(new String[]{"ad_reward_stream", "ad_reward_link_stream"});
        f158425b = Arrays.asList(new String[]{"homepage_follow", "homepage_follow_ecom", "homepage_ecom_follow"});
        f158426c = "live.pref.SHOW_SCROLL_TIPS";
        f158427d = "live.pref.SHOW_SCROLL_TIPS_GOLDBOOSTER";
        f158428e = "live.pref.SHOW_SCROLL_TIPS_LAST_TIME";
        f158429f = 0;
        f158430g = false;
    }

    public static SlideUpTipABV2Config c() {
        pg1 r100 = pg1.f120978a;
        String r101 = null;
        if (r100.getValue() == null) goto L12;
        Map<String, ? extends SlideUpTipABV2Config> r102 = r100.getValue();
        c0 r103 = c0.b();
        if (r103.f105568a == false) goto L11;
        c0.a r104 = r103.f105569b;
        if (r104 == null) goto L11;
        r101 = r104.f105585a;
    L11:
        return r102.get(r101);
    L12:
        return null;
    }

    public static boolean e() {
        if (f158429f != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static long b() {
        if (c() != null) goto L7;
        return 7;
    L7:
        return c().cancelTime;
    }

    public static boolean d() {
        if (c() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(String r110) {
        if (LiveSlideUpTipsGuideUtil.a(r110) == true) goto L5;
        return false;
    L5:
        SharedPrefHelper r100 = SharedPrefHelper.b(s1.getContext());
        if (r100.f(f158426c, true) == false) goto L8;
        return false;
    L8:
        long r101 = r100.i(f158428e, System.currentTimeMillis());
        long r102 = System.currentTimeMillis() - r101;
        Intrinsics.checkNotNullParameter(r110, "source");
        Map r103 = (Map) LiveSlideUpTipsGuideUtil.f158383a.getValue();
        if (r103 == null) goto L13;
        ih1 r111 = (ih1) r103.get(r110);
        if (r111 == null) goto L13;
        int r112 = r111.b();
    L15:
        if (r102 >= (((long) r112) * 1000)) goto L17;
        return false;
    L17:
        return true;
    L13:
        r112 = 5184000;
        goto L15
    }

    public static void f(String r100, String r101, String r102, Map<String, String> r103) {
        if (tb1.c.f545229a == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.log.g r104 = u.l();
        HashMap r105 = new HashMap();
        r105.put("enter_from_merge", r101);
        r105.put("enter_method", r102);
        if (r103 != null) goto L8;
    L11:
        r104.sendLog(r100, r105, new Object[]{new x(), Room.class});
        return;
    L8:
        if (r103.isEmpty() == true) goto L11;
        r105.putAll(r103);
        goto L11
    }

    public static void h(Activity r100, ILiveRoomListProvider r101, boolean r110, a r111, String r112, String r113, SlideUpTipsTriggerSource r114, b r115) {
        boolean r102 = tb1.c.f545229a;
        if (r102 == true) goto L5;
        return;
    L5:
        if (d() == false) goto L125;
        if (r100 != null) goto L8;
    L10:
        if (r115 == null) goto L16;
        if (r115.a() == false) goto L16;
        ALogger.i("LiveSlideUpTipsGuideStrategy", "conflict from guide page view");
        return;
    L16:
        if (f158429f != 2) goto L18;
        return;
    L18:
        f158430g = false;
        f158429f = 0;
        Room r103 = ((IRoomService) jc1.k.f(IRoomService.class)).getCurrentRoom();
        if (r102 == false) goto L25;
        if (r103 == null) goto L25;
        if (r103.isD3Room() == false) goto L25;
        f158429f = 1;
        return;
    L25:
        if (r103 != null) goto L27;
    L32:
        com.bytedance.android.livesdk.e.b().getClass();
        if (com.bytedance.android.livesdk.e.c() == false) goto L36;
        f158429f = 1;
        return;
    L36:
        IEnterGuideService r104 = (IEnterGuideService) jc1.k.f(IEnterGuideService.class);
        if (r104 != null) goto L39;
    L41:
        IGuideManagerService r105 = (IGuideManagerService) jc1.k.f(IGuideManagerService.class);
        if (r105 == null) goto L47;
        if (r105.isShowingAuthDialog() == false) goto L47;
        ALogger.i("SlideUpTipABUtilV2", "IGuideManagerService#isShowingAuthDialog return");
        f158429f = 1;
    L52:
        boolean r106 = true;
    L54:
        if (r106 == false) goto L56;
        return;
    L56:
        if (r101 != null) goto L58;
    L117:
        f158429f = 1;
        if (SharedPrefHelper.b(s1.getContext()).f(f158426c, true) == false) goto L127;
        if (r101 != null) goto L121;
        return;
    L121:
        if (r101.size() > 1) goto L129;
        f158430g = true;
        return;
    L129:
        return;
    L127:
        return;
    L58:
        if (r101.size() <= 1) goto L117;
        if (r111 == null) goto L117;
        if (r110 == false) goto L63;
        f158429f = 1;
        return;
    L63:
        SharedPrefHelper r107 = SharedPrefHelper.b(s1.getContext());
        if (r112.equals("1455_new_channel_v2") == false) goto L77;
        String r108 = f158427d;
        if (r107.f(r108, true) == false) goto L74;
        og1 r116 = og1.f120903a;
        if (r116.getValue() == null) goto L70;
        boolean r117 = r116.getValue().booleanValue();
    L71:
        if (r117 == false) goto L74;
        r107.l(r108, Boolean.FALSE);
        r107.a();
    L116:
        r111.a(true, r114);
        f158429f = 2;
        return;
    L70:
        r117 = false;
    L74:
        r111.a(false, r114);
        return;
    L77:
        if (f158424a.contains(r112) == true) goto L79;
        t7 r118 = t7.f121275a;
        if (r118.getValue() != null) goto L86;
    L88:
        boolean r119 = false;
    L89:
        long r109 = 1;
        if (r119 == false) goto L99;
        String r120 = f158426c + "_time" + r112;
        int r121 = r107.h(r120, 1);
        if (c() == null) goto L95;
        r109 = c().maxTimes;
    L95:
        if (r121 > r109) goto L97;
        r107.l(r120, Integer.valueOf(r121 + 1));
        r107.a();
        goto L116
    L97:
        r111.a(false, r114);
        return;
    L99:
        String r122 = r112 + "_" + r113;
        String r123 = f158426c;
        if (r107.f(r123, true) == false) goto L102;
    L107:
        int r124 = r107.h(r123 + "_time", 0) + 1;
        r107.l(f158428e, Long.valueOf(System.currentTimeMillis()));
        r107.a();
        if (c() == null) goto L111;
        r109 = c().maxTimes;
    L111:
        if (r124 < r109) goto L114;
        r107.l(r123, Boolean.FALSE);
        r107.a();
    L114:
        if ((r100 instanceof FragmentActivity) == false) goto L116;
        ((LiveMultiTabRoomViewModel) ViewModelProviders.of((FragmentActivity) r100).get(LiveMultiTabRoomViewModel.class)).setHasShowSlideTip(true);
        goto L116
    L102:
        if (r114 == SlideUpTipsTriggerSource.STRATEGY_TRIGGER) goto L104;
    L105:
        r111.a(false, r114);
        return;
    L104:
        if (a(r122) == true) goto L107;
    L86:
        if (r118.getValue().contains(r112) == false) goto L88;
        r119 = true;
        goto L89
    L79:
        if (r107.f("live.pref.SHOW_SCROLL_TIPS_AD_TASK", true) == true) goto L82;
        r111.a(false, r114);
        return;
    L82:
        r107.l("live.pref.SHOW_SCROLL_TIPS_AD_TASK", Boolean.FALSE);
        r107.a();
    L47:
        if (com.bytedance.android.livesdk.bottomguide.b.f104358b == false) goto L50;
        ALogger.i("SlideUpTipABUtilV2", "BottomGuideManager#getHasShown return");
        f158429f = 1;
        goto L52
    L50:
        if (z0.f117683b == false) goto L53;
        ALogger.i("SlideUpTipABUtilV2", "IndividualTaskManager#getHasShown return");
        f158429f = 1;
        goto L52
    L53:
        int r125 = z.f117681a;
        r106 = false;
        goto L54
    L39:
        if (r104.getHasShownSlideUpGuideInSingleContainer() == false) goto L41;
        ALogger.i("SlideUpTipABUtilV2", "getHasShownSlideUpGuideInSingleContainer return");
        f158429f = 1;
        goto L52
    L27:
        if (r103.getMRoomAuthStatus() == null) goto L32;
        if (r103.getMRoomAuthStatus().isEnableStrokeUpDownGuide() == true) goto L32;
        f158429f = 1;
        return;
    L8:
        if (e5.j(r100) == false) goto L10;
        return;
    }

    public static void g(final Activity r110, Bundle r111, final ILiveRoomListProvider r112, final boolean r113, final a r114, final String r115, final String r116, final SlideUpTipsTriggerSource r210, final b r211) {
        if (tb1.c.f545229a == true) goto L5;
        return;
    L5:
        if (d() == false) goto L43;
        if (r113 == true) goto L45;
        int r100 = 0;
        if (d() == false) goto L25;
        if (r111 == null) goto L25;
        Bundle r101 = m0.a(r111);
        if (r101 == null) goto L25;
        if (f158425b.contains(r101.getString("enter_from_merge")) == false) goto L25;
        long r102 = r111.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
        long[] r103 = r111.getLongArray(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_IDS);
        if (r103 == null) goto L25;
        boolean r104 = true;
        if (r103.length <= 1) goto L25;
        if (r103[r103.length - 1] != r102) goto L25;
    L26:
        if (r104 == false) goto L29;
        return;
    L29:
        if (c() == null) goto L31;
        r100 = c().delaySeconds;
    L31:
        long r105 = 1000 * ((long) r100);
        if (r210 != SlideUpTipsTriggerSource.STRATEGY_TRIGGER) goto L34;
    L40:
        h(r110, r112, r113, r114, r115, r116, r210, r211);
        return;
    L34:
        if (r105 <= 1) goto L40;
        if (f158431h != null) goto L39;
        f158431h = new Handler(Looper.getMainLooper());
    L39:
        f158431h.removeCallbacksAndMessages(null);
        f158431h.postDelayed(new i(r110, r112, r113, r114, r115, r116, r210, r211), r105);
        return;
    L25:
        r104 = false;
        goto L26
    L45:
        return;
    }
}
