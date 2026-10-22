package com.bytedance.android.sdk.bdticketguard;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class q<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<R> f163974a;

    public static final class a<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<R>[] f163975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<Character, a<R>> f163976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function2<? super String, ? super String, ? extends R> f163977c;

        public a() {
            this.f163975a = new a[128];
        }
    }

    public q(Pair<String, ? extends Function2<? super String, ? super String, ? extends R>>... r100) {
        this.f163974a = new a();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        Pair<String, ? extends Function2<? super String, ? super String, ? extends R>> r103 = r100[r102];
        insert(r103.component1(), r103.component2());
        r102 = r102 + 1;
        goto L3
    }

    private final void insert(String r100, Function2<? super String, ? super String, ? extends R> r101) {
        a<R> r102 = this.f163974a;
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L24;
        char r104 = Character.toLowerCase(r100.charAt(r103));
        if (r104 >= 128) goto L8;
        a<R> r105 = r102.f163975a[r104];
    L12:
        if (r105 != null) goto L23;
        r105 = new a();
        if (r104 >= 128) goto L17;
        r102.f163975a[r104] = r105;
        goto L23
    L17:
        if (r102.f163976b != null) goto L19;
        r102.f163976b = new LinkedHashMap();
    L19:
        Map<Character, a<R>> r106 = r102.f163976b;
        if (r106 != null) goto L22;
        Intrinsics.throwNpe();
    L22:
        r106.put(Character.valueOf(r104), r105);
    L23:
        r102 = r105;
        r103 = r103 + 1;
        goto L4
    L8:
        Map<Character, a<R>> r107 = r102.f163976b;
        if (r107 == null) goto L11;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        r105 = (a) r108.get(Character.valueOf(r104));
        goto L12
    L11:
        r105 = null;
        goto L12
    L24:
        r102.f163977c = r101;
    }

    public final void a(String r100, String r101) {
        a<R> r102 = this.f163974a;
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L14;
        char r104 = Character.toLowerCase(r100.charAt(r103));
        Function2<? super String, ? super String, ? extends R> r105 = null;
        if (r104 >= 128) goto L8;
        r102 = r102.f163975a[r104];
    L12:
        if (r102 == null) goto L15;
        r103 = r103 + 1;
    L15:
        if (r105 == null) goto L20;
        r105.invoke(r100, r101);
        return;
    L20:
        return;
    L8:
        Map<Character, a<R>> r106 = r102.f163976b;
        if (r106 == null) goto L11;
        r102 = (a) ((LinkedHashMap) r106).get(Character.valueOf(r104));
        goto L12
    L11:
        r102 = null;
        goto L12
    L14:
        r105 = r102.f163977c;
        goto L15
    }
}
