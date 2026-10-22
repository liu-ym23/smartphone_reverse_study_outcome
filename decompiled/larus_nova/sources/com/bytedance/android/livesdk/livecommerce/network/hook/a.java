package com.bytedance.android.livesdk.livecommerce.network.hook;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import si2.g;
import si2.k;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f149493a = 0;

    static {
    }

    public static String a(String r110, FilterNullArrayList r111) {
        Intrinsics.checkNotNullParameter(r110, "url");
        if (EComABUtils.enableLiveUrlRedirect().booleanValue() == true) goto L5;
        return r110;
    L5:
        String r100 = g.f542149a;
        boolean r101 = true;
        if (r100 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L105;
        String r103 = null;
        if (StringsKt.startsWith$default(r110, r100, false, 2, null) == false) goto L106;
        String r104 = r110.substring(r100.length());
        List<String> r105 = EComABUtils.getNetworkAPIEnableRedirectList();
        List<String> r106 = r105;
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == false) goto L24;
    L30:
        if (r111 == null) goto L41;
        Iterator<E> r108 = r111.iterator();
    L33:
        if (r108.hasNext() == false) goto L37;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((k) r109).f45605a, "room_id") == false) goto L33;
    L38:
        k r112 = (k) r109;
        if (r112 == null) goto L41;
        String r113 = r112.f45606b;
    L42:
        if (r111 == null) goto L53;
        Iterator<E> r114 = r111.iterator();
    L45:
        if (r114.hasNext() == false) goto L49;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((k) r115).f45605a, "room_unique_key") == false) goto L45;
    L50:
        k r116 = (k) r115;
        if (r116 == null) goto L53;
        String r117 = r116.f45606b;
    L54:
        if (r111 == null) goto L65;
        Iterator<E> r118 = r111.iterator();
    L57:
        if (r118.hasNext() == false) goto L61;
        Object r119 = r118.next();
        if (Intrinsics.areEqual(((k) r119).f45605a, "container_room_id") == false) goto L57;
    L62:
        k r120 = (k) r119;
        if (r120 == null) goto L65;
        r103 = r120.f45606b;
        goto L65
    L61:
        r119 = null;
    L65:
        if (r113 != null) goto L67;
    L70:
        boolean r121 = true;
    L71:
        if (r121 == true) goto L82;
        if (r103 != null) goto L74;
    L77:
        boolean r122 = true;
    L78:
        if (r122 == true) goto L82;
        if ((!Intrinsics.areEqual(r113, r103)) == false) goto L82;
        return r110;
    L74:
        if (r103.length() == 0) goto L77;
        r122 = false;
    L82:
        int r123 = RoomContextController.f151593h;
        LiveRoomRedirectInfo r124 = RoomContextController.a.b(r113, r117).f151598g;
        if (r124 == null) goto L107;
        Map<String, String> r125 = r124.f151922b;
        if (r125 == null) goto L109;
        String r126 = r125.get(r104);
        if (r126 != null) goto L90;
    L93:
        if (r101 == false) goto L95;
        return r110;
    L95:
        return r100 + r126;
    L90:
        if (r126.length() == 0) goto L93;
        r101 = false;
        goto L93
    L109:
        return r110;
    L107:
        return r110;
    L67:
        if (r113.length() == 0) goto L70;
        r121 = false;
        goto L71
    L49:
        r115 = null;
    L53:
        r117 = null;
        goto L54
    L37:
        r109 = null;
    L41:
        r113 = null;
        goto L42
    L24:
        if (StringsKt.endsWith$default(r104, HTTP.URL_DEFAULT, false, 2, null) == false) goto L26;
        String r127 = r104;
    L28:
        if (r105.contains(r127) == true) goto L30;
        return r110;
    L26:
        r127 = r104 + '/';
        goto L28
    L18:
        if (r106.isEmpty() == true) goto L21;
        r107 = false;
        goto L22
    L106:
        return r110;
    L105:
        return r110;
    L8:
        if (r100.length() == 0) goto L11;
        r102 = false;
        goto L12
    }
}
