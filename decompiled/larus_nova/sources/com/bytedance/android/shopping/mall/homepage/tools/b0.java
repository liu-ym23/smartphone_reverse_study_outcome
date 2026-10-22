package com.bytedance.android.shopping.mall.homepage.tools;

import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f178512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f178513b;

    public static final class a {
    }

    static {
    }

    public final String a() {
        if (this.f178513b.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        String r101 = this.f178513b;
        Iterator<Map.Entry<String, String>> r102 = this.f178512a.entrySet().iterator();
        String r103 = r101;
    L11:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r102.next();
        r103 = StringsKt.replace$default(r103, r104.getKey(), r104.getValue(), false, 4, null);
        goto L11
    L13:
        return r103;
    L8:
        return this.f178513b;
    L5:
        r100 = false;
        goto L6
    }

    public b0(String r100, z r110) {
        Intrinsics.checkNotNullParameter(r100, "rawSchema");
        Intrinsics.checkNotNullParameter(r110, "replaceArgument");
        this.f178513b = r100;
        Map<String, String> r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("{indexPlaceholder}", String.valueOf(r110.f178549a))});
        Map<String, Object> r111 = r110.f178550b;
        if (r111 != null) goto L5;
    L24:
        Unit r102 = Unit.INSTANCE;
        this.f178512a = r101;
        return;
    L5:
        if ((!r111.isEmpty()) == true) goto L8;
        r111 = null;
    L8:
        if (r111 == null) goto L24;
        Iterator<T> r103 = r111.keySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L24;
        String r104 = (String) r103.next();
        Object r105 = r111.get(r104);
        if (r105 == null) goto L15;
        String r106 = r105.toString();
    L16:
        if (r106 != null) goto L18;
    L21:
        boolean r107 = true;
    L22:
        if (r107 == true) goto L11;
        Intrinsics.checkNotNull(r106);
        r101.put("{" + r104 + "Placeholder}", r106);
        goto L11
    L18:
        if (r106.length() == 0) goto L21;
        r107 = false;
        goto L22
    L15:
        r106 = null;
        goto L16
    }
}
