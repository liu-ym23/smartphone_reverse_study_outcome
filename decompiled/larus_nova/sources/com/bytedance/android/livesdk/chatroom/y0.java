package com.bytedance.android.livesdk.chatroom;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class y0 {
    public static final String b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        Uri r103 = UriProtector.parse(r100);
        Uri.Builder r104 = d(r103, CollectionsKt.listOf(new String[]{"url", "fallback_url"})).buildUpon();
        String r105 = UriProtector.getQueryParameter(r103, "url");
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r104.appendQueryParameter("url", c(r105, r101));
        String r106 = UriProtector.getQueryParameter(r103, "fallback_url");
        if (TextUtils.isEmpty(r106) == true) goto L16;
        Uri r107 = UriProtector.parse(r106);
        Uri.Builder r108 = d(r107, CollectionsKt.listOf("url")).buildUpon();
        String r109 = UriProtector.getQueryParameter(r107, "url");
        if (r109 == null) goto L14;
        r102 = r109;
    L14:
        r108.appendQueryParameter("url", c(r102, r101));
        r104.appendQueryParameter("fallback_url", r108.toString());
    L16:
        return r104.toString();
    }

    public static final String c(String r100, Map<String, String> r101) {
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        Pair[] r103 = new Pair[3];
        o r104 = IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3);
        if (r104 == null) goto L7;
        Room r105 = r104.getCurrentRoom();
        if (r105 == null) goto L7;
        Long r106 = Long.valueOf(r105.getId());
    L8:
        r103[0] = TuplesKt.to("room_id", String.valueOf(r106));
        o r107 = IRoomContextService.a.a((IRoomContextService) jc1.k.n(IRoomContextService.class), null, 0, 3);
        String r108 = "";
        if (r107 == null) goto L14;
        Room r109 = r107.getCurrentRoom();
        if (r109 == null) goto L14;
        String r110 = r109.getOwnerUserIdString();
        if (r110 == null) goto L14;
    L15:
        r103[1] = TuplesKt.to("anchor_id", r110);
        String r111 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        if (r111 == null) goto L19;
        r108 = r111;
    L19:
        r103[2] = TuplesKt.to("user_id", r108);
        Iterator r112 = MapsKt.mapOf(r103).entrySet().iterator();
    L21:
        if (r112.hasNext() == false) goto L23;
        Map.Entry r113 = (Map.Entry) r112.next();
        r102.appendQueryParameter((String) r113.getKey(), (String) r113.getValue());
        goto L21
    L23:
        Iterator<Map.Entry<String, String>> r114 = r101.entrySet().iterator();
    L25:
        if (r114.hasNext() == false) goto L28;
        Map.Entry<String, String> r115 = r114.next();
        r102.appendQueryParameter(r115.getKey(), r115.getValue());
        goto L25
    L28:
        return r102.toString();
    L14:
        r110 = "";
    L7:
        r106 = null;
        goto L8
    }

    public static final Uri d(Uri r100, List<String> r101) {
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        if (r102 != null) goto L5;
        return r100;
    L5:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L7:
        if (r105.hasNext() == false) goto L11;
        Object r106 = r105.next();
        if ((!r101.contains((String) r106)) == false) goto L7;
        r104.add(r106);
        goto L7
    L11:
        Iterator r107 = r104.iterator();
    L13:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        r103.appendQueryParameter(r108, UriProtector.getQueryParameter(r100, r108));
        goto L13
    L16:
        return r103.build();
    }

    public static String a(String r100, Map r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = MapsKt.emptyMap();
    L6:
        if ((r102 & 4) == 0) goto L8;
        List r103 = CollectionsKt.listOf(new String[]{"url", "fallback_url"});
    L9:
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r103, "urlList");
        if (r100 == null) goto L24;
        Uri r104 = UriProtector.parse(r100);
        Uri.Builder r105 = d(r104, r103).buildUpon();
        Iterator r106 = r103.iterator();
    L14:
        if (r106.hasNext() == false) goto L20;
        String r107 = (String) r106.next();
        String r108 = UriProtector.getQueryParameter(r104, r107);
        if (r108 != null) goto L18;
        r108 = "";
    L18:
        r105.appendQueryParameter(r107, c(r108, r101));
        goto L14
    L20:
        return r105.toString();
    L24:
        return "";
    L8:
        r103 = null;
        goto L9
    }
}
