package com.android.ttcjpaysdk.base.h5.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/utils/CJPayUrlUtils;", "", "()V", "appendUrlParamsToScheme", "", "schemeUrl", "params", "", "checkWxH5PayHost", "", "url", "modifyUri", "Landroid/net/Uri;", "uri", "queryParameter", "expectedValue", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayUrlUtils {
    public static final CJPayUrlUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayUrlUtils();
    }

    private CJPayUrlUtils() {
    }

    @JvmStatic
    public static final boolean checkWxH5PayHost(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        Uri r102 = UriProtector.parse(r100);
        if (r102 != null) goto L14;
        return false;
    L14:
        return Intrinsics.areEqual(r102.getHost(), "wx.tenpay.com");
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    @JvmStatic
    public static final String appendUrlParamsToScheme(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Intrinsics.checkNotNull(r100);
        StringBuilder r102 = new StringBuilder(r100);
        if (StringsKt.contains$default(r100, "?", false, 2, null) != true) goto L9;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        r102.append("&");
    L23:
        Iterator<Map.Entry<String, String>> r104 = r101.entrySet().iterator();     // Catch: Exception -> L20
    L16:
        if (r104.hasNext() == false) goto L18;
        Map.Entry<String, String> r105 = r104.next();     // Catch: Exception -> L20
        String r106 = r105.getKey();     // Catch: Exception -> L20
        String r107 = r105.getValue();     // Catch: Exception -> L20
        r102.append(r106);     // Catch: Exception -> L20
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: Exception -> L20
        r102.append(URLEncoder.encode(r107, "UTF-8"));     // Catch: Exception -> L20
        r102.append("&");     // Catch: Exception -> L20
        goto L16
    L18:
        return r102.substring(0, r102.length() - 1);
    L20:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayUrlUtils#appendUrlParamsToScheme", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayUrlUtils#appendUrlParamsToScheme", e);
        return r100;
    L13:
        r102.append("?");
        goto L23
    L9:
        r103 = false;
        goto L11
    }

    public final Uri modifyUri(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "queryParameter");
        Intrinsics.checkNotNullParameter(r102, "expectedValue");
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r100, r101), r102) == false) goto L6;
        return r100;
    L6:
        return r100.buildUpon().appendQueryParameter(r101, r102).build();
    }
}
