package com.bytedance.android.live.schema.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.live.schema.api.b f100507a = null;

    static {
        f100507a = new com.bytedance.android.live.schema.api.b("sslocal://webcast_redirect?entry=initialize", "initialize", null, null, null);
    }

    @JvmStatic
    public static final Map<String, String> a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        String r100 = r110.getEncodedQuery();
        if (r100 == null) goto L35;
        if (r100.length() != 0) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L35;
        HashMap r112 = new HashMap();
        Object[] r101 = StringsKt.split$default(r100, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);
        if (r101 == null) goto L33;
        String[] r102 = (String[]) r101;
        int r103 = r102.length;
        int r104 = 0;
    L13:
        if (r104 >= r103) goto L31;
        Object[] r105 = StringsKt.split$default(r102[r104], new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, null).toArray(new String[0]);
        if (r105 == null) goto L30;
        String[] r106 = (String[]) r105;
        StringBuilder r107 = new StringBuilder();
        if (r106.length != 2) goto L19;
        String r108 = r106[0];
        r107.append(r106[1]);
    L21:
        if (r106.length <= 2) goto L26;
        r108 = r106[0];
        int r113 = r106.length;
        int r114 = 1;
    L23:
        if (r114 >= r113) goto L26;
        r107.append(r106[r114]);
        r107.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r114 = r114 + 1;
    L26:
        if (TextUtils.isEmpty(r108) == true) goto L28;
        r112.put(r108, Uri.decode(r107.toString()));
    L28:
        r104 = r104 + 1;
        goto L13
    L19:
        r108 = "";
        goto L21
    L30:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L31:
        return r112;
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L7:
        r111 = false;
    L35:
        return MapsKt.emptyMap();
    }

    @JvmStatic
    public static final com.bytedance.android.live.schema.api.b b(String r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        if (r100 != null) goto L6;
        return null;
    L6:
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        if (TextUtils.equals(r103.getHost(), "webcast_redirect") == false) goto L10;
        Map<String, String> r104 = a(r103);     // Catch: Throwable -> L11
        String r105 = r104.get("entry");     // Catch: Throwable -> L11
        String r106 = r104.get("scheme_query");     // Catch: Throwable -> L11
        String r107 = r104.get("url_query");     // Catch: Throwable -> L11
        String r108 = r104.get("default_schema");     // Catch: Throwable -> L11
        boolean r109 = Intrinsics.areEqual(r104.get("decode_query_value"), "1");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L11
        com.bytedance.android.live.schema.api.b r110 = new com.bytedance.android.live.schema.api.b(r100, r105, r106, r107, r108);     // Catch: Throwable -> L11
        r110.f100493a = r109;     // Catch: Throwable -> L11
        return r110;
    L10:
        return null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Object r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r112) == true) goto L17;
        r101 = r112;
    L17:
        return (com.bytedance.android.live.schema.api.b) r101;
    }
}
