package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class k2 {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L19;
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L15
        String r103 = UriProtector.getQueryParameter(r102, "log_data");     // Catch: Exception -> L15
        if (r103 != null) goto L8;
    L12:
        r103 = SliceInitService.DEFAULT_SWITCH;
    L13:
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L15
        b(r104, new JSONObject(r101));     // Catch: Exception -> L15
        return String.valueOf(c(r102, r104.toString()));
    L8:
        if (r103.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == false) goto L13;
    L10:
        r105 = false;
    L20:
        return r100;
    L19:
        return r100;
    L18:
        return r100;
    }

    public static void b(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        Intrinsics.checkNotNullParameter(r101, "input");
        JSONArray r102 = r101.names();
        if (r102 == null) goto L5;
        int r103 = r102.length();
    L6:
        Iterator<Integer> r104 = RangesKt.until(0, r103).iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        int r105 = ((IntIterator) r104).nextInt();
        String r106 = r101.names().get(r105).toString();
        r100.put(r106, r101.get(r106));
        goto L8
    L10:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public static Uri c(Uri r100, String r101) {
        if (r101 == null) goto L24;
        Uri.Builder r102 = r100.buildUpon();
        r102.clearQuery();
        Iterator<String> r103 = UriProtector.getQueryParameterNames(r100).iterator();
        boolean r104 = false;
    L6:
        if (r103.hasNext() == false) goto L14;
        String r105 = r103.next();
        if ((!Intrinsics.areEqual(r105, "log_data")) == true) goto L9;
        r102.appendQueryParameter(r105, r101);
        r104 = true;
        goto L6
    L9:
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();
    L11:
        if (r106.hasNext() == false) goto L6;
        r102.appendQueryParameter(r105, r106.next());
        goto L11
    L14:
        if (r104 == true) goto L17;
        r102.appendQueryParameter("log_data", r101);
    L17:
        return r102.build();
    L24:
        return r100;
    }
}
