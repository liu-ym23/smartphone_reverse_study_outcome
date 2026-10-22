package com.bytedance.anniex.bd.foundation.impl;

import android.net.Uri;
import com.amap.api.col.s.ce;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.rts.foundation.y;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f190155c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Uri f190156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f190157b;

    public static final class a {
        public static u a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uriStr");
            return new u(r100);
        L5:
            th = move-exception;
            int r101 = y.f267598a;
            y.a.b(new Object[]{th});
            return null;
        }
    }

    static {
    }

    public final void a() {
        Uri r100 = this.f190156a;
        if (r100 == null) goto L9;
        Uri.Builder r101 = r100.buildUpon();
        if (r101 == null) goto L9;
        Uri.Builder r102 = r101.clearQuery();
        if (r102 == null) goto L9;
        Uri r103 = r102.build();
    L10:
        this.f190156a = r103;
        return;
    L9:
        r103 = null;
        goto L10
    }

    public final String b() {
        Uri r100 = this.f190156a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHost();
    }

    public final Map<String, String> d() {
        Map<String, String> r100 = this.f190157b;
        if (r100 == null) goto L6;
        Intrinsics.checkNotNull(r100);
        return r100;
    L6:
        this.f190157b = new LinkedHashMap();
        Uri r101 = this.f190156a;     // Catch: Throwable -> L36
        if (r101 != null) goto L10;
    L12:
        boolean r102 = false;
    L13:
        if (r102 == false) goto L38;
        Uri r103 = this.f190156a;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L36
        String r104 = r103.getEncodedQuery();     // Catch: Throwable -> L36
        if (r104 != null) goto L18;
        Map<String, String> r105 = this.f190157b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r105);     // Catch: Throwable -> L36
        return r105;
    L18:
        Iterator<T> r106 = com.bytedance.rts.foundation.r.f(r104, "&", -1).iterator();     // Catch: Throwable -> L36
    L20:
        if (r106.hasNext() == false) goto L34;
        String r107 = (String) r106.next();     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(r107, "") == true) goto L20;
        int r108 = StringsKt.indexOf$default(r107, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);     // Catch: Throwable -> L36
        if (r108 < 0) goto L27;
        String r109 = com.bytedance.rts.foundation.r.e(r107, 0, r108);     // Catch: Throwable -> L36
        String r110 = com.bytedance.rts.foundation.r.e(r107, r108 + 1, r107.length());     // Catch: Throwable -> L36
        r107 = r109;
    L29:
        if (Intrinsics.areEqual(r107, "") == true) goto L20;
        String r111 = Uri.decode(r107);     // Catch: Throwable -> L36
        String r112 = Uri.decode(r110);     // Catch: Throwable -> L36
        if (r111 == null) goto L20;
        if (r112 == null) goto L20;
        Map<String, String> r113 = this.f190157b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L36
        com.bytedance.rts.foundation.m.e(r113, r111, r112);     // Catch: Throwable -> L36
        goto L20
    L27:
        r110 = "";
        goto L29
    L34:
        Map<String, String> r114 = this.f190157b;     // Catch: Throwable -> L36
        Intrinsics.checkNotNull(r114);     // Catch: Throwable -> L36
        return r114;
    L38:
        Map<String, String> r115 = this.f190157b;
        Intrinsics.checkNotNull(r115);
        return r115;
    L10:
        if (r101.isHierarchical() != true) goto L12;
        r102 = true;
    L36:
        th = move-exception;
        int r116 = y.f267598a;
        y.a.b(new Object[]{th});
        goto L38
    }

    public final String e() {
        Uri r100 = this.f190156a;
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public u(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        Uri r101 = UriProtector.parse(r100);
        Intrinsics.checkNotNull(r101);
        this.f190156a = r101;
    }

    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (String) ((LinkedHashMap) d()).get(r100);
    L5:
        th = move-exception;
        int r101 = y.f267598a;
        y.a.b(new Object[]{th});
        return null;
    }

    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, ce.f26396k);
        Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
        Uri r102 = this.f190156a;
        Uri r103 = null;
        if (r102 == null) goto L5;
        String r104 = UriProtector.getQueryParameter(r102, r100);
    L6:
        if (r104 != null) goto L16;
        Uri r105 = this.f190156a;
        if (r105 == null) goto L14;
        Uri.Builder r106 = r105.buildUpon();
        if (r106 == null) goto L14;
        Uri.Builder r107 = r106.appendQueryParameter(r100, r101);
        if (r107 == null) goto L14;
        r103 = r107.build();
    L14:
        this.f190156a = r103;
        return;
    L16:
        if (Intrinsics.areEqual(r104, r101) == false) goto L18;
        return;
    L18:
        Uri r108 = this.f190156a;
        if (r108 == null) goto L21;
        Set<String> r109 = UriProtector.getQueryParameterNames(r108);
    L22:
        Uri r110 = this.f190156a;
        if (r110 == null) goto L27;
        Uri.Builder r111 = r110.buildUpon();
        if (r111 == null) goto L27;
        Uri.Builder r112 = r111.clearQuery();
    L28:
        if (r109 == null) goto L42;
        if (r112 == null) goto L42;
        Iterator<String> r113 = r109.iterator();
    L32:
        if (r113.hasNext() == false) goto L42;
        String r114 = r113.next();
        if (Intrinsics.areEqual(r114, r100) == true) goto L35;
        Uri r115 = this.f190156a;
        if (r115 == null) goto L39;
        String r116 = UriProtector.getQueryParameter(r115, r114);
    L40:
        if (r116 == null) goto L32;
        r112.appendQueryParameter(r114, r116);
        goto L32
    L39:
        r116 = null;
        goto L40
    L35:
        r112.appendQueryParameter(r100, r101);
    L42:
        if (r112 == null) goto L44;
        r103 = r112.build();
    L44:
        this.f190156a = r103;
        return;
    L27:
        r112 = null;
        goto L28
    L21:
        r109 = null;
        goto L22
    L5:
        r104 = null;
        goto L6
    }
}
