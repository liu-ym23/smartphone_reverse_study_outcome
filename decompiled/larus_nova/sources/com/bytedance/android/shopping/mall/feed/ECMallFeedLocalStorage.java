package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallFeedLocalStorage {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f176824g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f176825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f176826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f176827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f176828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f176829e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f176830f;

    public static final class a {
        public a() {
        }

        public static final String a(String r100) {
            Lazy r101 = ECMallFeedLocalStorage.f176824g;
            return r100 + "_timestamp";
        }
    }

    public final SharedPreferences b() {
        return (SharedPreferences) this.f176826b.getValue();
    }

    static {
        new a();
        f176824g = LazyKt.lazy(ECMallFeedLocalStorage$Companion$mallSaasCacheDefaultTime$2.INSTANCE);
    }

    public final boolean a(long r110) {
        if (r110 <= 0) goto L40;
        long r100 = System.currentTimeMillis() - r110;
        long r101 = 60;
        long r102 = (((((long) ((Number) f176824g.getValue()).intValue()) * 1000) * r101) * r101) * ((long) 24);
        Long r103 = this.f176830f;
        List<ECMallFeedLocalStorageConfig.b> r104 = null;
        if (r103 == null) goto L16;
        if (r103.longValue() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L16;
        r102 = r103.longValue();
        goto L16
    L9:
        r105 = false;
    L16:
        if (r100 > r102) goto L41;
        ECMallFeedLocalStorageConfig.a r106 = ECMallFeedLocalStorageConfig.f176832b;
        String r107 = this.f176829e;
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "pageName");
        Map<String, List<ECMallFeedLocalStorageConfig.b>> r108 = ((ECMallFeedLocalStorageConfig) ECMallFeedLocalStorageConfig.f176831a.getValue()).a();
        if (r108 == null) goto L32;
        List<ECMallFeedLocalStorageConfig.b> r109 = r108.get(r107);
        if (r109 == null) goto L32;
        if ((!r109.isEmpty()) == false) goto L24;
        r104 = r109;
    L24:
        if (r104 == null) goto L32;
        Iterator<ECMallFeedLocalStorageConfig.b> r111 = r104.iterator();
    L28:
        if (r111.hasNext() == false) goto L32;
        if (r111.next().a(r110) == false) goto L28;
        boolean r112 = true;
    L33:
        if (r112 == true) goto L42;
        return false;
    L42:
        return true;
    L32:
        r112 = false;
        goto L33
    L41:
        return true;
    L40:
        return true;
    }

    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return null;
    L6:
        if (a(b().getLong(a.a(r100), -1)) == false) goto L9;
        b().edit().remove(a.a(r100)).remove(r100).apply();
        return null;
    L9:
        String r101 = b().getString(r100, null);
        if (r101 != null) goto L12;
    L15:
        boolean r102 = true;
    L17:
        if ((true ^ r102) == true) goto L19;
        return null;
    L19:
        return r101;
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r102 = false;
        goto L17
    }

    public ECMallFeedLocalStorage(Context r100, String r101, Integer r102, Long r103) {
        this.f176828d = r100;
        this.f176829e = r101;
        this.f176830f = r103;
        if (r102 != null) goto L5;
    L13:
        int r104 = 3;
    L14:
        this.f176825a = r104;
        this.f176826b = LazyKt.lazy(new ECMallFeedLocalStorage$sharedPreferences$2(this));
        return;
    L5:
        if (r102.intValue() <= 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        r104 = r102.intValue();
        goto L14
    L7:
        r105 = false;
        goto L8
    }
}
