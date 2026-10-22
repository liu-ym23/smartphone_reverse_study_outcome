package com.bytedance.android.ec.core.utils;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes43.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f45662b;

    public final String c() {
        String r100 = this.f45661a + '?';
        Iterator<Map.Entry<String, String>> r101 = this.f45662b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<String, String> r102 = r101.next();
        r100 = r100 + r102.getKey() + com.alipay.sdk.m.n.a.f25612h + r102.getValue() + Typography.amp;
        goto L4
    L7:
        return StringsKt.dropLast(r100, 1);
    }

    public o0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f45661a = "";
        this.f45662b = new HashMap();
        List r101 = d(r100, "?");
        String r102 = (String) CollectionsKt.getOrNull(r101, 0);
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        this.f45661a = r102;
        String r103 = (String) CollectionsKt.getOrNull(r101, 1);
        if (r103 == null) goto L24;
        List r104 = StringsKt.split$default(r103, new String[]{"&"}, false, 0, 6, null);
        if (r104 == null) goto L29;
        Iterator r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L30;
        Iterator r106 = ((ArrayList) d((String) r105.next(), ContainerUtils.KEY_VALUE_DELIMITER)).iterator();
        String r107 = "";
        String r108 = r107;
        int r109 = 0;
    L14:
        if (r106.hasNext() == false) goto L23;
        Object r110 = r106.next();
        int r111 = r109 + 1;
        if (r109 >= 0) goto L18;
        CollectionsKt.throwIndexOverflow();
    L18:
        String r112 = (String) r110;
        if (r109 != 0) goto L21;
        r107 = r112;
    L22:
        r109 = r111;
        goto L14
    L21:
        r108 = r112;
        goto L22
    L23:
        this.f45662b.put(r107, r108);
        goto L11
    L30:
        return;
    L29:
        return;
    }

    public final String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f45662b.get(r100);
    }

    public static List d(String r100, String r101) {
        ArrayList r102 = new ArrayList();
        Iterator r103 = StringsKt.split$default(r100, new String[]{r101}, false, 2, 2, null).iterator();
    L4:
        if (r103.hasNext() == false) goto L7;
        r102.add((String) r103.next());
        goto L4
    L7:
        if (r102.size() >= 2) goto L9;
        r102.add("");
    L9:
        return r102;
    }

    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        HashMap<String, String> r102 = this.f45662b;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r102.put(r100, r101);
    }

    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f45662b.containsKey(r100) == true) goto L9;
        HashMap<String, String> r102 = this.f45662b;
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r102.put(r100, r101);
        return;
    }
}
