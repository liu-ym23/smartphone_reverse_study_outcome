package com.android.ttcjpaysdk.facelive.utils;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/utils/CJPayFaceUrlParameterUtils;", "", "()V", "addParametersToUrl", "", "url", "params", "", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFaceUrlParameterUtils {
    public static final CJPayFaceUrlParameterUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayFaceUrlParameterUtils();
    }

    private CJPayFaceUrlParameterUtils() {
    }

    public final String addParametersToUrl(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        boolean r102 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L46;
        boolean r103 = false;
        if (r101 != null) goto L8;
        Boolean r104 = null;
    L13:
        if (r104 == null) goto L15;
        r103 = r104.booleanValue();     // Catch: Throwable -> L35
    L15:
        if (r103 == false) goto L47;
        CJPayFaceUrlBuilder r105 = new CJPayFaceUrlBuilder(r100);     // Catch: Throwable -> L35
        List<CJPayFaceNameValuePair> r106 = r105.getParamList();     // Catch: Throwable -> L35
        if (r106 == null) goto L25;
        List<CJPayFaceNameValuePair> r107 = r106;     // Catch: Throwable -> L35
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));     // Catch: Throwable -> L35
        Iterator<T> r109 = r107.iterator();     // Catch: Throwable -> L35
    L20:
        if (r109.hasNext() == false) goto L22;
        r108.add(((CJPayFaceNameValuePair) r109.next()).getName().toLowerCase());     // Catch: Throwable -> L35
        goto L20
    L22:
        Set r110 = CollectionsKt.toSet(r108);     // Catch: Throwable -> L35
        if (r110 == null) goto L25;
    L26:
        if (r101 == null) goto L33;
        Iterator<Map.Entry<String, String>> r111 = r101.entrySet().iterator();     // Catch: Throwable -> L35
    L29:
        if (r111.hasNext() == false) goto L33;
        Map.Entry<String, String> r112 = r111.next();     // Catch: Throwable -> L35
        String r113 = r112.getKey();     // Catch: Throwable -> L35
        String r114 = r112.getValue();     // Catch: Throwable -> L35
        if (r110.contains(r113.toLowerCase()) == true) goto L29;
        r105.addParam(r113, r114);     // Catch: Throwable -> L35
    L33:
        return r105.build();
    L25:
        r110 = SetsKt.emptySet();     // Catch: Throwable -> L35
        goto L26
    L47:
        return r100;
    L8:
        if (r101.isEmpty() == false) goto L11;
        r102 = false;
    L11:
        r104 = Boolean.valueOf(r102);     // Catch: Throwable -> L35
        goto L13
    L46:
        return r100;
    L35:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayFaceUrlParameterUtils#addParametersToUrl", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayFaceUrlParameterUtils#addParametersToUrl", th);
        return r100;
    }
}
