package com.bytedance.android.shopping.feed.resourcecard.frequency;

import android.os.SystemClock;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sk.a;
import yd3.d;
import yd3.p;

/* JADX INFO: loaded from: classes13.dex */
public final class ResourceCardFreqController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f175190a = null;

    public static int c() {
        return ((Number) f175190a.getValue()).intValue();
    }

    static {
        f175190a = LazyKt.lazy(ResourceCardFreqController$maxRecordSize$2.INSTANCE);
    }

    public static boolean a(p r100) {
        d r101 = null;
        if (r100 == null) goto L5;
        d r102 = r100.q();
    L6:
        a r103 = a.f542311a;
        if (b(r102, new ResourceCardFreqController$canShow$1(r103)) == false) goto L13;
        if (r100 == null) goto L11;
        r101 = r100.c();
    L11:
        if (b(r101, new ResourceCardFreqController$canShow$2(r103)) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        r102 = null;
        goto L6
    }

    public static void d(Integer r100) {
        if (r100 == null) goto L8;
        r100.intValue();
        a r101 = a.f542311a;
        int r102 = r100.intValue();
        r101.getClass();
        List<String> r103 = a.a(r102);
        if (r103.size() < c()) goto L6;
        ListProtector.remove(r103, 0);
    L6:
        r103.add(String.valueOf(SystemClock.elapsedRealtime()));
        int r104 = r100.intValue();
        Intrinsics.checkNotNullParameter(r103, "record");
        q.f48131a.b("resource_card_click_freq_" + r104, r103);
        return;
    }

    public static boolean b(d r100, Function1 r101) {
        if (r100 == null) goto L29;
        Long r102 = r100.a();
        if (r102 == null) goto L30;
        long r103 = r102.longValue();
        Long r104 = r100.c();
        if (r104 == null) goto L31;
        long r105 = r104.longValue();
        Integer r106 = r100.b();
        if (r106 == null) goto L32;
        int r107 = r106.intValue();
        if (r103 >= 0) goto L13;
        return true;
    L13:
        if (r105 > 0) goto L15;
        return true;
    L15:
        if (c() <= 0) goto L37;
        long r108 = Math.min(r105, c());
        List r109 = (List) r101.invoke(Integer.valueOf(r107));
        if (r109.size() >= r108) goto L20;
        return true;
    L20:
        String r110 = (String) CollectionsKt.getOrNull(r109, r109.size() - ((int) r108));
        if (r110 == null) goto L35;
        Long r111 = StringsKt.toLongOrNull(r110);
        if (r111 != null) goto L25;
        return true;
    L25:
        if ((SystemClock.elapsedRealtime() - r111.longValue()) > r103) goto L38;
        return false;
    L38:
        return true;
    L35:
        return true;
    L37:
        return true;
    L32:
        return true;
    L31:
        return true;
    L30:
        return true;
    L29:
        return true;
    }
}
