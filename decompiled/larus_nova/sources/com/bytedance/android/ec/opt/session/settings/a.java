package com.bytedance.android.ec.opt.session.settings;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public static final String c(Object r100) {
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r101 = (String) r100;
        if (r101 == null) goto L20;
        Uri r102 = UriProtector.parse(r101);
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.isHierarchical() == false) goto L16;
        String r103 = UriProtector.getQueryParameter(r102, "url");
        if (r103 != null) goto L14;
        r103 = UriProtector.getQueryParameter(r102, "anchor_url");
    L14:
        if (r103 != null) goto L17;
        r103 = r102.toString();
    L17:
        if (r103 != null) goto L19;
        return null;
    L19:
        return UriProtector.parse(r103).buildUpon().clearQuery().build().toString();
    L16:
        r103 = r102.toString();
        goto L17
    L20:
        return null;
    }

    public static final Object a(Object r100, List<String> r101) {
        if (r101.isEmpty() == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof Map) == true) goto L8;
        return null;
    L8:
        String r102 = (String) CollectionsKt.firstOrNull(r101);
        if (r102 != null) goto L12;
        return null;
    L12:
        return a(((Map) r100).get(r102), CollectionsKt.drop(r101, 1));
    }

    public static final Object b(ParamsExtractRule r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getValueByStrategy");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L36
        String r103 = r100.getStrategy();     // Catch: Throwable -> L36
        if (r103 == null) goto L40;
        int r104 = r103.hashCode();     // Catch: Throwable -> L36
        if (r104 == (-970671264)) goto L18;
        if (r104 == (-868974455)) goto L15;
        if (r104 != 1544803905) goto L41;
        r103.equals("default");     // Catch: Throwable -> L36
        return r101;
    L41:
        return r101;
    L15:
        if (r103.equals("url_pick_v1") == true) goto L44;
        return r101;
    L44:
        return c(r101);
    L18:
        if (r103.equals("url_crop") == true) goto L20;
        return r101;
    L20:
        if ((r101 instanceof String) == true) goto L22;
        r101 = null;
    L22:
        String r105 = (String) r101;     // Catch: Throwable -> L36
        if (r105 == null) goto L35;
        Uri r106 = UriProtector.parse(r105);     // Catch: Throwable -> L36
        if (r106 == null) goto L35;
        Uri.Builder r107 = r106.buildUpon();     // Catch: Throwable -> L36
        if (r107 == null) goto L35;
        Uri.Builder r108 = r107.clearQuery();     // Catch: Throwable -> L36
        if (r108 == null) goto L35;
        Uri r109 = r108.build();     // Catch: Throwable -> L36
        if (r109 == null) goto L35;
        return r109.toString();
    L35:
        return null;
    L40:
        return r101;
    L36:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }
}
