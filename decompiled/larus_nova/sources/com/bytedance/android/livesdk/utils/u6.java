package com.bytedance.android.livesdk.utils;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class u6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f159183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f159184b;

    public final Uri c() {
        Uri.Builder r100 = this.f159184b.buildUpon().clearQuery();
        Iterator r101 = ((LinkedHashMap) this.f159183a).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        Object r104 = r102.getValue();
        if ((r104 instanceof u6) == false) goto L8;
        String r105 = ((u6) r104).c().toString();
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

    public u6(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUri");
        this.f159184b = r100;
        this.f159183a = new LinkedHashMap();
        if (r100.isHierarchical() == false) goto L8;
        Iterator<T> r101 = UriProtector.getQueryParameterNames(r100).iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = (String) r101.next();
        String r103 = UriProtector.getQueryParameter(this.f159184b, r102);
        Intrinsics.checkNotNull(r103);
        this.f159183a.put(r102, r103);
        goto L6
    L10:
        return;
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f159183a).get(r100);
        if ((r101 instanceof u6) == false) goto L6;
        return ((u6) r101).c().toString();
    L6:
        if ((r101 instanceof String) == true) goto L11;
        return null;
    L11:
        return (String) r101;
    }

    public final u6 d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Object r101 = ((LinkedHashMap) this.f159183a).get(r100);
        if ((r101 instanceof u6) == false) goto L7;
        return (u6) r101;
    L7:
        if ((r101 instanceof String) == false) goto L12;
        Uri r102 = UriProtector.parse((String) r101);
        if (r102.isHierarchical() == false) goto L11;
        u6 r103 = new u6(r102);
    L13:
        this.f159183a.put(r100, r103);
        return r103;
    L11:
        r103 = new u6(Uri.EMPTY);
        goto L13
    L12:
        r103 = new u6(Uri.EMPTY);
        goto L13
    }

    public u6(String r100) {
        Intrinsics.checkNotNullParameter(r100, "baseUriString");
        this(UriProtector.parse(r100));
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L5;
        this.f159183a.put(r100, r101);
        return;
    L5:
        this.f159183a.remove(r100);
    }
}
