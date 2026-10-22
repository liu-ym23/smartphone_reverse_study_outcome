package com.bytedance.android.annie.debug.service;

import android.view.View;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y7.g;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f39392a;

    public a() {
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f39392a = r100;
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void onRelease(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        GeckoOfflineInfoHolder r101 = GeckoOfflineInfoHolder.f39390b.getValue();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        String r102 = GeckoOfflineInfoHolder.a(r100);
        if (r102 == null) goto L16;
        monitor-enter(r101);
        g r103 = (g) ((Map) r101.f39391a.getValue()).remove(r102);     // Catch: Throwable -> L11
        monitor-exit(r101);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.annie.debug.service.c
    public final void h(View r210, com.bytedance.android.annie.card.web.resource.a r211) {
        Intrinsics.checkNotNullParameter(r211, "resourceInfo");
        Intrinsics.checkNotNullParameter(r211, "resourceInfo");
        if (r210 != null) goto L5;
        return;
    L5:
        String r100 = this.f39392a;
        if (r100 != null) goto L8;
        return;
    L8:
        GeckoOfflineInfoHolder r110 = GeckoOfflineInfoHolder.f39390b.getValue();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r210, "view");
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r211, "resourceInfo");
        String r101 = "template loaded, offline " + r211.f39216a + ", from " + r211.f39217b + ", version " + r211.f39218c + ", url " + r100;
        b8.a r102 = b8.a.f17992a;
        b8.a.d(new b8.b("GeckoOfflineInfoHolder", LogLevel.DEBUG, null, r101));
        String r103 = GeckoOfflineInfoHolder.a(r100);
        if (r103 != null) goto L12;
        return;
    L12:
        if (r211.f39216a == true) goto L14;
        g r104 = new g(false, r211.f39219d, r211.f39217b, "");
    L47:
        monitor-enter(r110);
        ((Map) r110.f39391a.getValue()).put(r103, r104);     // Catch: Throwable -> L51
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L51
        monitor-exit(r110);
        return;
    L51:
        th = move-exception;
        throw th;
    L14:
        if (r211.f39219d == false) goto L16;
        String r106 = String.valueOf(r211.f39218c);
    L45:
        String r107 = "offline version " + r106 + ", forest " + r211.f39219d;
        b8.a r108 = b8.a.f17992a;
        b8.a.d(new b8.b("GeckoOfflineInfoHolder", LogLevel.DEBUG, null, r107));
        r104 = new g(true, r211.f39219d, r211.f39217b, r106);
        goto L47
    L16:
        int r109 = a8.a.f2134a;
        Intrinsics.checkNotNullParameter(r100, "url");
        if (StringsKt.isBlank(r100) == true) goto L44;
        ArrayList r111 = new ArrayList();
        r111.addAll(ov5.a.f526905b);
        ListIterator r112 = r111.listIterator(r111.size());
    L21:
        if (r112.hasPrevious() == false) goto L25;
        Object r113 = r112.previous();
        int r114 = 2;
        if (StringsKt.contains$default(((ov5.a.C7115a) r113).f526907b, (CharSequence) ListProtector.get(StringsKt.split$default(r100, new String[]{"?"}, false, 0, 6, null), 0), false, 2, null) == false) goto L21;
    L26:
        ov5.a.C7115a r115 = (ov5.a.C7115a) r113;
        if (r115 == null) goto L44;
        if (r115.f526906a == false) goto L44;
        if (r115.f526909d != (-1)) goto L41;
        Object r116 = ListProtector.get(StringsKt.split$default(r115.f526908c, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null), 0);
        ListIterator r117 = r111.listIterator(r111.size());
    L35:
        if (r117.hasPrevious() == false) goto L39;
        Object r118 = r117.previous();
        if (StringsKt.contains$default(((ov5.a.C7115a) r118).f526908c, (CharSequence) r116, false, r114, null) == false) goto L35;
    L40:
        r115 = (ov5.a.C7115a) r118;
        goto L41
    L39:
        r118 = null;
    L41:
        if (r115 == null) goto L44;
        r106 = Long.valueOf(r115.f526909d).toString();
        if (r106 != null) goto L45;
    L25:
        r114 = 2;
        r113 = null;
    L44:
        r106 = "";
        goto L45
    }
}
