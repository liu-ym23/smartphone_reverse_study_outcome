package com.bytedance.android.shopping.utils;

import android.net.Uri;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class l0 {
    public static final String b(String r100, Pair... r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendOrReplaceSchemaJsonParams");
        Intrinsics.checkNotNullParameter(r101, "params");
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L20
        String r103 = UriProtector.getQueryParameter(r102, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS);     // Catch: Exception -> L20
        int r104 = 0;
        if (r103 != null) goto L6;
    L10:
        r103 = SliceInitService.DEFAULT_SWITCH;
    L11:
        JSONObject r105 = new JSONObject(r103);     // Catch: Exception -> L20
        int r106 = r101.length;     // Catch: Exception -> L20
    L12:
        if (r104 >= r106) goto L18;
        Pair r107 = r101[r104];     // Catch: Exception -> L20
        String r108 = (String) r107.component1();     // Catch: Exception -> L20
        String r109 = (String) r107.component2();     // Catch: Exception -> L20
        if (r108 == null) goto L17;
        if (r109 == null) goto L17;
        r105.put(r108, r109);     // Catch: Exception -> L20
    L17:
        r104 = r104 + 1;     // Catch: Exception -> L20
        goto L12
    L18:
        return c(r102, ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r105.toString()).toString();
    L6:
        if (r103.length() != 0) goto L8;
        boolean r110 = true;
    L9:
        if (r110 == false) goto L11;
    L8:
        r110 = false;
    L20:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r100;
    }

    public static final String a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$appendOrReplaceParameter");
        return c(UriProtector.parse(r100), r101, r102).toString();
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return r100;
    }

    public static final Uri c(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceOrAppendParameter");
        if (r101 == null) goto L26;
        if (r102 == null) goto L27;
        Uri.Builder r103 = r100.buildUpon();
        r103.clearQuery();
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();
        boolean r105 = false;
    L8:
        if (r104.hasNext() == false) goto L16;
        String r106 = r104.next();
        if ((!Intrinsics.areEqual(r106, r101)) == true) goto L11;
        r103.appendQueryParameter(r106, r102);
        r105 = true;
        goto L8
    L11:
        Iterator<String> r107 = UriProtector.getQueryParameters(r100, r106).iterator();
    L13:
        if (r107.hasNext() == false) goto L8;
        r103.appendQueryParameter(r106, r107.next());
        goto L13
    L16:
        if (r105 == true) goto L19;
        r103.appendQueryParameter(r101, r102);
    L19:
        return r103.build();
    L27:
        return r100;
    L26:
        return r100;
    }
}
