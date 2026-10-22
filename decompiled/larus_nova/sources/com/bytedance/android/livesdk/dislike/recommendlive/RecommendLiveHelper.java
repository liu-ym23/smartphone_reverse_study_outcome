package com.bytedance.android.livesdk.dislike.recommendlive;

import am2.x;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsCallback;
import com.bytedance.android.livehostapi.business.depend.dislike.ILiveRecommendToFriendsService;
import com.bytedance.android.livehostapi.business.depend.dislike.RecommendToFriendsParams;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.jm0;
import com.bytedance.android.livesdk.config.mm0;
import com.bytedance.android.livesdk.config.nm0;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous.LiveRecommendRequestParams;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.recommendAnonymous.LiveRecommendStatusRequestParams;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class RecommendLiveHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f122216a = 0;

    public RecommendLiveHelper() {
    }

    public static boolean b(long r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static ILiveRecommendToFriendsService d() {
        IHostBusiness r100 = (IHostBusiness) k.f(IHostBusiness.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLiveRecommendToFiendsService();
    }

    public static boolean e() {
        if (nm0.f120845a.getValue().booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (mm0.f120768a.getValue().getEnableInputDialog() == false) goto L7;
        return true;
    }

    public static boolean f() {
        ILiveRecommendToFriendsService r100 = d();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isRecommendedLive();
    }

    public static void k() {
        ILiveRecommendToFriendsService r100 = d();
        if (r100 == null) goto L6;
        r100.setIsRecommendedLive();
        return;
    }

    static {
    }

    public static boolean g(long r100) {
        ILiveRecommendToFriendsService r101 = d();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isRoomRecommended(r100);
    }

    public static void l(long r100) {
        ILiveRecommendToFriendsService r101 = d();
        if (r101 == null) goto L6;
        r101.setRoomRecommended(r100);
        return;
    }

    public static Disposable c(long r110, final ILiveRecommendToFriendsCallback r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "tag");
        if (jm0.f120537a.getValue().getEnable() == false) goto L12;
        ILiveRecommendToFriendsService r100 = d();
        if (r100 != null) goto L7;
        return null;
    L7:
        if (g(r110) == false) goto L9;
        long r101 = 1;
    L11:
        return r100.requestRecommendLiveStatus(new LiveRecommendStatusRequestParams(r110, r112, r101, new RecommendLiveHelper$getRecommendStatus$1(r111), new RecommendLiveHelper$getRecommendStatus$2(r111)));
    L9:
        r101 = 0;
        goto L11
    L12:
        ILiveRecommendToFriendsService r113 = d();
        if (r113 != null) goto L15;
        return null;
    L15:
        return r113.getRoomRecommendStatus(r110, r111);
    }

    public static void a(long r110, String r111, final ILiveRecommendToFriendsCallback r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "tag");
        if (jm0.f120537a.getValue().getEnable() == false) goto L8;
        ILiveRecommendToFriendsService r100 = d();
        if (r100 == null) goto L12;
        r100.requestLiveRecommendApi(new LiveRecommendRequestParams(r110, r111, r113, new RecommendLiveHelper$cancelRecommend$1(r112), new RecommendLiveHelper$cancelRecommend$2(r112), -1, false, null, 192, null), true);
        return;
    L12:
        return;
    L8:
        ILiveRecommendToFriendsService r101 = d();
        if (r101 == null) goto L13;
        r101.cancelRecommendRoom(r110, false, r112);
        return;
    }

    public static void i(Room r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "sharePlatform");
        HashMap r104 = new HashMap();
        if (r100 == null) goto L9;
        User r105 = r100.mo8271getOwner();
        if (r105 == null) goto L9;
        if (r105.isFollowing() != true) goto L9;
        String r106 = "1";
    L10:
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS, r106);
        r104.put("status", r101);
        r104.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r102);
        r104.put("entrance_name", r102);
        if (r103 == null) goto L13;
        r104.put("entrance_name", r103);
    L13:
        if (r100 == null) goto L15;
        LiveMode r107 = r100.getStreamType();
    L16:
        int r108 = h1.f66189a;
        r104.put("live_type", i1.a(r107));
        r104.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        u.l().sendLog("livesdk_follower_share_show", r104, new Object[]{x.class, Room.class});
        g r109 = u.l();
        LinkedHashMap r110 = new LinkedHashMap();
        r110.put("is_live", "1");
        r110.put("enter_method", "live_inner_long_press");
        r110.put("action_type", "show");
        Unit r111 = Unit.INSTANCE;
        r109.h("recommend_video_toast", r110, new Object[0]);
        return;
    L15:
        r107 = null;
    L9:
        r106 = "0";
        goto L10
    }

    public static void m(FragmentManager r100, RecommendToFriendsParams r101, DataCenter r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r103, "recommendEntranceName");
        a r104 = new a(r101, r103, r102);
        ILiveRecommendToFriendsService r105 = d();
        if (r105 == null) goto L6;
        r105.showPromptDialog(r100, r101, r104);
        return;
    }

    public static void h(Room r100, String r101, String r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L5;
        r102 = com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK;
    L5:
        LiveMode r105 = null;
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        Intrinsics.checkNotNullParameter(r102, "sharePlatform");
        HashMap r106 = new HashMap();
        if (r100 == null) goto L15;
        User r107 = r100.mo8271getOwner();
        if (r107 == null) goto L15;
        if (r107.isFollowing() != true) goto L15;
        String r108 = "1";
    L16:
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_FANS, r108);
        r106.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r102);
        r106.put("entrance_name", r102);
        if (r103 == null) goto L19;
        r106.put("entrance_name", r103);
    L19:
        r106.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        if (r100 == null) goto L22;
        r105 = r100.getStreamType();
    L22:
        int r109 = h1.f66189a;
        r106.put("live_type", i1.a(r105));
        r106.put("status", r101);
        u.l().sendLog("livesdk_follower_share", r106, new Object[]{x.class, Room.class});
        g r110 = u.l();
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("is_live", "1");
        r111.put("enter_method", "live_inner_long_press");
        r111.put("action_type", "click");
        Unit r112 = Unit.INSTANCE;
        r110.h("recommend_video_toast", r111, new Object[0]);
        return;
    L15:
        r108 = "0";
        goto L16
    }

    public static void j(long r110, String r111, final ILiveRecommendToFriendsCallback r112, String r113, boolean r114, final DataCenter r210) {
        Intrinsics.checkNotNullParameter(r111, "anchorId");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "tag");
        if (jm0.f120537a.getValue().getEnable() == false) goto L18;
        o r100 = u.l().c(x.class);
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.getMap();
        if (r101 == null) goto L9;
        String r102 = r101.get("enter_from_merge");
    L11:
        if (Intrinsics.areEqual(r102, UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT) == false) goto L13;
        int r103 = 2;
    L14:
        ILiveRecommendToFriendsService r104 = d();
        if (r104 == null) goto L22;
        r104.requestLiveRecommendApi(new LiveRecommendRequestParams(r110, r111, r113, new RecommendLiveHelper$recommendRoom$1(r112), new RecommendLiveHelper$recommendRoom$2(r112), r103, r114, new RecommendLiveHelper$recommendRoom$3(r210)), false);
        return;
    L22:
        return;
    L13:
        r103 = 0;
    L9:
        r102 = null;
        goto L11
    L18:
        ILiveRecommendToFriendsService r105 = d();
        if (r105 == null) goto L23;
        r105.recommendRoom(r110, false, r112);
        return;
    }
}
