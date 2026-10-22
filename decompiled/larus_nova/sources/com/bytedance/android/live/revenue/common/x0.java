package com.bytedance.android.live.revenue.common;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f91014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f91015b;

    public final Uri c() {
        Uri.Builder r100 = this.f91015b.buildUpon().clearQuery();
        Iterator r101 = ((LinkedHashMap) this.f91014a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        Object r104 = r102.getValue();
        if ((r104 instanceof x0) == false) goto L8;
        String r105 = ((x0) r104).c().toString();
    L9:
        r100.appendQueryParameter(r103, r105);
        goto L4
    L8:
        r105 = r104.toString();
        goto L9
    L11:
        return r100.build();
    }

    public final String toString() {
        return c().toString();
    }

    public x0(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUri");
        this.f91015b = r100;
        this.f91014a = new LinkedHashMap();
        if (r100.isHierarchical() == false) goto L8;
        Iterator<T> r101 = UriProtector.getQueryParameterNames(r100).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        String r103 = UriProtector.getQueryParameter(this.f91015b, r102);
        Intrinsics.checkNotNull(r103);
        this.f91014a.put(r102, r103);
        goto L6
    L10:
        return;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f91014a).get(r100);
        if ((r101 instanceof x0) == false) goto L6;
        return ((x0) r101).c().toString();
    L6:
        if ((r101 instanceof String) == true) goto L11;
        return null;
    L11:
        return (String) r101;
    }

    public final x0 d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f91014a).get(r100);
        if ((r101 instanceof x0) == false) goto L7;
        return (x0) r101;
    L7:
        if ((r101 instanceof String) == false) goto L12;
        int r102 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Uri r103 = com.bytedance.revenue.platform.api.core.e.a((String) r101);
        if (r103.isHierarchical() == false) goto L11;
        x0 r104 = new x0(r103);
    L13:
        this.f91014a.put(r100, r104);
        return r104;
    L11:
        r104 = new x0(Uri.EMPTY);
        goto L13
    L12:
        int r105 = com.bytedance.revenue.platform.api.core.e.f267507a;
        r104 = new x0(Uri.EMPTY);
        goto L13
    }

    public x0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUriString");
        int r101 = com.bytedance.revenue.platform.api.core.e.f267507a;
        Intrinsics.checkNotNullParameter(r100, "schemeString");
        this(UriProtector.parse(r100));
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        this.f91014a.put(r100, r101);
        return;
    L5:
        this.f91014a.remove(r100);
    }
}
