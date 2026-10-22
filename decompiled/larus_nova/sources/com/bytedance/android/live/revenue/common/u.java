package com.bytedance.android.live.revenue.common;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u {
    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final Map<String, String> d() {
        com.bytedance.android.live.revenue.core.util.j.a r100 = com.bytedance.android.live.revenue.core.util.j.C0;
        yz0.g r101 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r100.a(), yz0.g.class);
        String r102 = null;
        if (r101 == null) goto L5;
        IRoomBase r103 = r101.getRoom();
    L6:
        yz0.g r104 = (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r100.a(), yz0.g.class);
        if (r104 == null) goto L11;
        IBaseUser r105 = r104.getUser();
        if (r105 == null) goto L11;
        r102 = r105.getIdString();
    L11:
        Pair[] r106 = new Pair[3];
        if (r103 == null) goto L15;
        String r107 = r103.getIdStr();
        if (r107 == null) goto L15;
    L16:
        r106[0] = TuplesKt.to("room_id", r107);
        if (r103 == null) goto L22;
        IBaseUser r108 = r103.getOwnerKt();
        if (r108 == null) goto L22;
        String r109 = r108.getIdString();
        if (r109 == null) goto L22;
    L23:
        r106[1] = TuplesKt.to("anchor_id", r109);
        if (r102 != null) goto L26;
        r102 = "";
    L26:
        r106[2] = TuplesKt.to("user_id", r102);
        return MapsKt.mapOf(r106);
    L22:
        r109 = "";
    L15:
        r107 = "";
        goto L16
    L5:
        r103 = null;
        goto L6
    }

    public static String a(String r100, Map r101) {
        List r102 = CollectionsKt.listOf(new String[]{"url", "fallback_url"});
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "urlList");
        if (r100 == null) goto L17;
        int r103 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        Uri r104 = UriProtector.parse(r100);
        Uri.Builder r105 = f(r104, r102).buildUpon();
        Iterator r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L13;
        String r107 = (String) r106.next();
        String r108 = UriProtector.getQueryParameter(r104, r107);
        if (r108 != null) goto L11;
        r108 = "";
    L11:
        r105.appendQueryParameter(r107, e(r108, r101));
        goto L7
    L13:
        return r105.toString();
    L17:
        return "";
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String b(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        String r102 = "";
        if (r100 != null) goto L5;
        return "";
    L5:
        int r103 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        Uri r104 = UriProtector.parse(r100);
        Uri.Builder r105 = f(r104, CollectionsKt.listOf(new String[]{"url", "fallback_url"})).buildUpon();
        String r106 = UriProtector.getQueryParameter(r104, "url");
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r105.appendQueryParameter("url", e(r106, r101));
        String r107 = UriProtector.getQueryParameter(r104, "fallback_url");
        if (r107 == null) goto L21;
        if (r107.length() <= 0) goto L13;
        boolean r108 = true;
    L14:
        if (r108 != true) goto L21;
        Intrinsics.checkNotNullParameter(r107, "schemeString");
        Uri r109 = UriProtector.parse(r107);
        Uri.Builder r110 = f(r109, CollectionsKt.listOf("url")).buildUpon();
        String r111 = UriProtector.getQueryParameter(r109, "url");
        if (r111 == null) goto L19;
        r102 = r111;
    L19:
        r110.appendQueryParameter("url", e(r102, r101));
        r105.appendQueryParameter("fallback_url", r110.toString());
        goto L21
    L13:
        r108 = false;
    L21:
        return r105.toString();
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return "";
    L9:
        int r103 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        Uri.Builder r104 = UriProtector.parse(r100).buildUpon();
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L14;
        Map.Entry<String, String> r106 = r105.next();
        r104.appendQueryParameter(r106.getKey(), r106.getValue());
        goto L11
    L14:
        return r104.build().toString();
    L5:
        r102 = false;
        goto L6
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final String e(String r100, Map<String, String> r101) {
        int r102 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        Uri.Builder r103 = UriProtector.parse(r100).buildUpon();
        Iterator<Map.Entry<String, String>> r104 = d().entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry<String, String> r105 = r104.next();
        r103.appendQueryParameter(r105.getKey(), r105.getValue());
        goto L4
    L6:
        Iterator<Map.Entry<String, String>> r106 = r101.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L11;
        Map.Entry<String, String> r107 = r106.next();
        r103.appendQueryParameter(r107.getKey(), r107.getValue());
        goto L8
    L11:
        return r103.toString();
    }

    @Deprecated(message = "使用UriQueryView替换，以及在此基础上封装新的工具函数")
    public static final Uri f(Uri r100, List<String> r101) {
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if ((!r101.contains((String) r106)) == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        Iterator r107 = r104.iterator();
    L10:
        if (r107.hasNext() == false) goto L13;
        String r108 = (String) r107.next();
        r103.appendQueryParameter(r108, UriProtector.getQueryParameter(r100, r108));
        goto L10
    L13:
        return r103.build();
    }
}
