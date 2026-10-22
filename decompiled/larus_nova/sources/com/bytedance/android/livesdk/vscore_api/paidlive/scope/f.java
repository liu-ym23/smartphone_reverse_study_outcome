package com.bytedance.android.livesdk.vscore_api.paidlive.scope;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.g0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.paidlive.PaidRoomContext;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.b2;
import j40.t1;
import j40.w3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<String, b> f159507a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, b> f159508b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f159509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f159510d;

    public f() {
    }

    static {
        boolean r100 = pm1.h.f529819a;
        f159507a = new LinkedHashMap();
        f159508b = new LinkedHashMap();
    }

    public static com.bytedance.android.livesdk.vscore_api.paidlive.c h() {
        b r100 = f159509c;
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.vscore_api.paidlive.c r101 = (com.bytedance.android.livesdk.vscore_api.paidlive.c) m.f163449e.d(r100, com.bytedance.android.livesdk.vscore_api.paidlive.c.class);
    L7:
        if (r101 == null) goto L10;
        ALogger.v("PaidScopeUtil", e.f159506a);
        return r101;
    L10:
        if (w3.f497318a.getValue().booleanValue() == true) goto L13;
        ALogger.d("PaidScopeUtil", "getPaidManagerService return default service");
    L13:
        return g(null);
    L5:
        r101 = null;
        goto L7
    }

    public static boolean a(Room r100) {
        if (t1.f497301a.getValue().booleanValue() == true) goto L5;
        return true;
    L5:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (b2.f497172a.getValue().booleanValue() == false) goto L46;
        IEpisodeExtraInfo r101 = r100.getEpisodeExtra();
        if (r101 == null) goto L16;
        IVSCameraInfo r102 = r101.getPriorityCameraInfo();
        if (r102 == null) goto L16;
        if (r102.isPaidCamera() != true) goto L16;
        boolean r103 = true;
    L17:
        IEpisodeExtraInfo r104 = r100.getEpisodeExtra();
        PrivilegeInfo r105 = null;
        if (r104 == null) goto L20;
        IVSCameraInfo r106 = r104.getPriorityCameraInfo();
    L21:
        if (r106 == null) goto L29;
        IEpisodeExtraInfo r107 = r100.getEpisodeExtra();
        if (r107 == null) goto L27;
        Map<String, PrivilegeInfo> r108 = r107.getPrivilegeInfo();
        if (r108 == null) goto L27;
        r105 = r108.get(String.valueOf(6));
    L27:
        if (r105 == null) goto L29;
        boolean r109 = true;
    L30:
        if (r103 == true) goto L58;
        if (r109 == false) goto L33;
        return true;
    L33:
        if (r100.isPaidRoom() == false) goto L35;
        return true;
    L35:
        if (r100.isPaidSubscribeRoom() == true) goto L61;
        IBaseUser r110 = r100.getOwner();
        if (r110 == null) goto L43;
        g0 r111 = r110.getSubscribe();
        if (r111 == null) goto L43;
        if (r111.getOpen() != 1) goto L43;
        return true;
    L43:
        return false;
    L61:
        return true;
    L58:
        return true;
    L29:
        r109 = false;
        goto L30
    L20:
        r106 = null;
    L16:
        r103 = false;
        goto L17
    L46:
        if (r100.isPaidRoom() == false) goto L48;
        return true;
    L48:
        if (r100.isPaidSubscribeRoom() == true) goto L65;
        IBaseUser r112 = r100.getOwner();
        if (r112 == null) goto L56;
        g0 r113 = r112.getSubscribe();
        if (r113 == null) goto L56;
        if (r113.getOpen() != 1) goto L56;
        return true;
    L56:
        return false;
    L65:
        return true;
    }

    public static boolean b(IRoom r110) {
        boolean r100 = false;
        if (r110 != null) goto L7;
        ALogger.e("PaidScopeUtil", "canInitPaidScopeInRoom check result = false, room==null");
        return false;
    L7:
        if (com.bytedance.android.livesdk.config.setting.d.a(r110, "PaidScope") == false) goto L9;
        return false;
    L9:
        boolean r101 = r110.isPaidRoom();
        boolean r102 = r110.isPaidSubscribeRoom();
        boolean r103 = lu2.c.d(r110);
        IEpisodeExtraInfo r104 = r110.getEpisodeExtra();
        if (r104 == null) goto L16;
        Map<String, PrivilegeInfo> r105 = r104.getPrivilegeInfo();
        if (r105 == null) goto L16;
        if ((!r105.isEmpty()) != true) goto L16;
        boolean r106 = true;
    L17:
        IBaseUser r111 = r110.getOwner();
        if (r111 == null) goto L24;
        g0 r112 = r111.getSubscribe();
        if (r112 == null) goto L24;
        if (r112.getOpen() != 1) goto L24;
        boolean r113 = true;
    L25:
        if (r101 == true) goto L30;
        if (r102 == true) goto L30;
        if (r103 == true) goto L30;
        if (r106 == true) goto L30;
        if (r113 == true) goto L30;
    L31:
        ALogger.i("PaidScopeUtil", "canInitPaidScopeInRoom check result = " + r100 + ", isPaidRoom=" + r101 + ", isPaidSubscribeRoom=" + r102 + ", isPaidCamera=" + r103 + ", isPaidPrivilege=" + r106 + ",canRoomChangePaidType=" + r113);
        return r100;
    L30:
        r100 = true;
    L24:
        r113 = false;
    L16:
        r106 = false;
        goto L17
    }

    public static com.bytedance.android.livesdk.vscore_api.paidlive.i g(IRoom r100) {
        if (w3.f497318a.getValue().booleanValue() == true) goto L10;
        StringBuilder r101 = new StringBuilder("defaultService init roomid:");
        if (r100 == null) goto L7;
        Long r102 = Long.valueOf(r100.getId());
    L8:
        r101.append(r102);
        ALogger.d("PaidScopeUtil", r101.toString());
        goto L10
    L7:
        r102 = null;
    L10:
        return new com.bytedance.android.livesdk.vscore_api.paidlive.i(r100);
    }

    public static boolean c(long r100, int r101) {
        return d(r100, r101, PaidSceneViewEntry.IN_ROOM);
    }

    public static void j(b r100, PaidSceneViewEntry r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "entry");
        if (r101.isPreview() == false) goto L5;
        Map<String, b> r102 = f159508b;
        Intrinsics.checkNotNullParameter(r100, "$this$previewMapKey");
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getId());
        r103.append('_');
        r103.append(r100.w0());
        b r104 = r102.remove(r103.toString());
    L7:
        if (r104 != null) goto L11;
        ALogger.e("PaidScopeUtil", "leaveScopeByInstance id:" + r100.getId() + " entry = " + r100.w0().getDesc() + ", has already remove");
        return;
    L11:
        if (l.b(r100) == false) goto L13;
        b r105 = r100;
    L14:
        if (r105 == null) goto L17;
        l.c(r105);
    L17:
        if (Intrinsics.areEqual(f159509c, r100) == false) goto L19;
        f159509c = null;
    L19:
        StringBuilder r106 = new StringBuilder("leaveScopeByInstance id:");
        r106.append(r100.getId());
        r106.append(" entry = ");
        r106.append(r100.w0().getDesc());
        r106.append(", scopeMap:");
        r106.append(f159507a.size());
        r106.append(", previewScopeMap:");
        r106.append(f159508b);
        r106.append(", activeScope=");
        Object r107 = f159509c;
        if (r107 != null) goto L22;
        r107 = "null";
    L22:
        r106.append(r107);
        ALogger.e("PaidScopeUtil", r106.toString());
        return;
    L13:
        r105 = null;
        goto L14
    L5:
        LinkedHashMap<String, b> r108 = f159507a;
        Intrinsics.checkNotNullParameter(r100, "$this$InRoomKey");
        StringBuilder r109 = new StringBuilder();
        r109.append(r100.getId());
        r109.append('_');
        r109.append(r100.g());
        r104 = r108.remove(r109.toString());
        goto L7
    }

    public static boolean d(long r110, int r111, PaidSceneViewEntry r210) {
        Intrinsics.checkNotNullParameter(r210, "entry");
        if (r210.isInRoom() == false) goto L5;
    L20:
        StringBuilder r100 = new StringBuilder();
        r100.append(r110);
        r100.append('_');
        r100.append(r111);
        b r101 = f159507a.get(r100.toString());
        if (r101 != null) goto L23;
        return false;
    L23:
        if (r101.g() == r111) goto L27;
        ALogger.e("PaidScopeUtil", "checkfragment[" + r210 + "]:id:" + r110 + ", " + r111 + ",scope:" + r101.g() + " fragment scope与当前fragment不匹配");
        return false;
    L27:
        if (l.b(r101) == true) goto L30;
        long r102 = System.currentTimeMillis();
        l.a(r101);
        f159510d = System.currentTimeMillis() - r102;
        f159509c = r101;
        ALogger.e("PaidScopeUtil", "enter[" + r210 + "]: id:" + r110 + ", fragmentHash:" + r111 + ", active scope");
        return true;
    L30:
        ALogger.e("PaidScopeUtil", "enter[" + r210 + "]: id:" + r110 + ", fragmentHash:" + r111 + ", has enter,skip");
        return true;
    L5:
        if (r210.isAnchor() == true) goto L20;
        StringBuilder r103 = new StringBuilder();
        r103.append(r110);
        r103.append('_');
        r103.append(r210);
        String r104 = r103.toString();
        b r105 = (b) ((LinkedHashMap) f159508b).get(r104);
        if (r105 != null) goto L10;
        return false;
    L10:
        if (r105.g() == r111) goto L14;
        ALogger.e("PaidScopeUtil", "checkfragment[preview]:id:" + r104 + ", " + r111 + ",scope:" + r105.g() + " fragment scope与当前fragment不匹配");
        return false;
    L14:
        if (l.b(r105) == true) goto L17;
        long r106 = System.currentTimeMillis();
        l.a(r105);
        f159510d = System.currentTimeMillis() - r106;
        f159509c = r105;
        ALogger.e("PaidScopeUtil", "enter[preview]: id:" + r104 + ", fragmentHash:" + r111 + ", active scope");
        return true;
    L17:
        ALogger.e("PaidScopeUtil", "enter[preview]: id:" + r104 + ", fragmentHash:" + r111 + ", has enter,skip");
        return true;
    }

    public static void i(long r110, int r111, PaidSceneViewEntry r112) {
        Intrinsics.checkNotNullParameter(r112, "entry");
        ALogger.e("PaidScopeUtil", "start leaveFragmentScope: id:" + r110 + ", fragmentHash:" + r111 + ", entry:" + r112.name());
        String r100 = null;
        if (r112.isInRoom() == false) goto L5;
    L29:
        StringBuilder r113 = new StringBuilder();
        r113.append(r110);
        r113.append('_');
        r113.append(r111);
        String r114 = r113.toString();
        LinkedHashMap<String, b> r115 = f159507a;
        b r116 = r115.get(r114);
        if (r116 != null) goto L32;
        return;
    L32:
        if (r116.g() == r111) goto L34;
        return;
    L34:
        if (l.b(r116) == false) goto L36;
        b r101 = r116;
    L37:
        if (r101 == null) goto L39;
        l.c(r101);
    L39:
        r115.remove(r114);
        if (Intrinsics.areEqual(f159509c, r116) == false) goto L42;
        f159509c = null;
    L42:
        StringBuilder r117 = new StringBuilder("leaveFragmentScope from scopeMap :");
        r117.append(r111);
        r117.append(",entry = ");
        r117.append(r116.w0().getDesc());
        r117.append(", currentScopeMapSize:");
        r117.append(r115.size());
        r117.append(", active=");
        b r118 = f159509c;
        if (r118 == null) goto L45;
        r100 = r118.toString();
    L45:
        r117.append(r100);
        ALogger.e("PaidScopeUtil", r117.toString());
        return;
    L36:
        r101 = null;
        goto L37
    L5:
        if (r112.isAnchor() == true) goto L29;
        StringBuilder r102 = new StringBuilder();
        r102.append(r110);
        r102.append('_');
        r102.append(r112);
        String r119 = r102.toString();
        Map<String, b> r120 = f159508b;
        b r121 = (b) ((LinkedHashMap) r120).get(r119);
        if (r121 != null) goto L10;
        return;
    L10:
        if (l.b(r121) == false) goto L12;
        b r103 = r121;
    L13:
        if (r103 == null) goto L15;
        l.c(r103);
    L15:
        r120.remove(r119);
        if (Intrinsics.areEqual(f159509c, r121) == false) goto L18;
        f159509c = null;
    L18:
        StringBuilder r122 = new StringBuilder("leaveFragmentScope from previewScopeMap :");
        r122.append(r111);
        r122.append(",entry = ");
        r122.append(r121.w0().getDesc());
        r122.append(", currentPreviewScopeMapSize:");
        r122.append(r120.size());
        r122.append(", active=");
        b r123 = f159509c;
        if (r123 == null) goto L21;
        r100 = r123.toString();
    L21:
        r122.append(r100);
        ALogger.e("PaidScopeUtil", r122.toString());
        if ((!r120.isEmpty()) == false) goto L48;
        StringBuilder r124 = new StringBuilder("leaveFragmentScope remain id:");
        ArrayList r104 = new ArrayList(r120.size());
        Iterator r125 = ((LinkedHashMap) r120).entrySet().iterator();
    L25:
        if (r125.hasNext() == false) goto L27;
        r104.add((String) ((Map.Entry) r125.next()).getKey());
        goto L25
    L27:
        r124.append(CollectionsKt.joinToString$default(r104, null, null, null, 0, null, null, 63, null));
        ALogger.e("PaidScopeUtil", r124.toString());
        return;
    L48:
        return;
    L12:
        r103 = null;
        goto L13
    }

    public static void f(long r110, int r111, FragmentActivity r112, Fragment r113, DataCenter r114, PaidRoomContext r115, Function0 r116, Function0 r117) {
        e(r110, r111, r112, r113, r114, r115, r116, r117, PaidSceneViewEntry.IN_ROOM);
    }

    public static b e(long r110, int r111, FragmentActivity r112, LifecycleOwner r210, DataCenter r211, PaidRoomContext r212, Function0 r213, Function0 r214, PaidSceneViewEntry r215) {
        Intrinsics.checkNotNullParameter(r112, "activity");
        Intrinsics.checkNotNullParameter(r210, "fragmentLifecycle");
        Intrinsics.checkNotNullParameter(r211, "dataCenter");
        Intrinsics.checkNotNullParameter(r212, "roomContext");
        Intrinsics.checkNotNullParameter(r213, "iPaidLiveBusiness");
        Intrinsics.checkNotNullParameter(r214, "playerClient");
        Intrinsics.checkNotNullParameter(r215, "entry");
        ALogger.e("PaidScopeUtil", "create: id:" + r110 + ", fragmentHash:" + r111 + ", entry:" + r215.name());
        StringBuilder r100 = new StringBuilder();
        r100.append(r110);
        r100.append('_');
        r100.append(r111);
        String r101 = r100.toString();
        if (r215.isInRoom() == false) goto L5;
    L6:
        LinkedHashMap<String, b> r113 = f159507a;
        if (r113.containsKey(r101) == false) goto L10;
        ALogger.e("PaidScopeUtil", "create[in_room]: id:" + r101 + ", duplicated");
        return r113.get(r101);
    L10:
        StringBuilder r114 = new StringBuilder();
        r114.append(r110);
        r114.append('_');
        r114.append(r215);
        String r115 = r114.toString();
        if (r215.isPreview() == false) goto L16;
        Map<String, b> r116 = f159508b;
        if (r116.containsKey(r115) == false) goto L16;
        ALogger.e("PaidScopeUtil", "create[preview]: id:" + r115 + ", duplicated");
        return (b) ((LinkedHashMap) r116).get(r115);
    L16:
        m.f163449e.getClass();
        i r117 = new i(m.f163448d);
        Intrinsics.checkNotNullParameter(r117, "scope");
        r117.f159519f = Integer.valueOf(r111);
        r117.f159518e = Long.valueOf(r110);
        Intrinsics.checkNotNullParameter(r215, "value");
        r117.f159520g = r215;
        d r102 = new d(r210, r112, r211, r212, r213, r214);
        Intrinsics.checkNotNullParameter(r102, "value");
        r117.f159521h = r102;
        r117.I();
        if (r215.isPreview() == false) goto L19;
        f159508b.put(r115, r117);
    L20:
        return r117;
    L19:
        f159507a.put(r101, r117);
        goto L20
    L5:
        if (r215.isAnchor() == false) goto L10;
        goto L6
    }
}
