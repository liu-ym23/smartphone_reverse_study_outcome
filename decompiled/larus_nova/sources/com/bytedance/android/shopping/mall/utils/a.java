package com.bytedance.android.shopping.mall.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f178608e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f178610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f178611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178612d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.utils.a$a, reason: collision with other inner class name */
    public static final class C2652a {
    }

    static {
    }

    public final SharedPreferences a() {
        return (SharedPreferences) this.f178609a.getValue();
    }

    public final void d() {
        StringBuilder r100 = new StringBuilder();
        List<String> r101 = this.f178610b;
        if (r101 == null) goto L8;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.append((String) r102.next());
        r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
    L8:
        a().edit().putString("key_set", StringsKt.removeSuffix(r100, HiAnalyticsConstant.REPORT_VAL_SEPARATOR).toString()).apply();
    }

    public final void b() {
        String r100 = a().getString("key_set", null);
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L17;
        if (r100 == null) goto L17;
        List r103 = StringsKt.split$default(r100, new String[]{HiAnalyticsConstant.REPORT_VAL_SEPARATOR}, false, 0, 6, null);
        if (r103 == null) goto L17;
        Iterator r104 = r103.iterator();
    L15:
        if (r104.hasNext() == false) goto L17;
        r101.add((String) r104.next());
    L17:
        Unit r105 = Unit.INSTANCE;
        this.f178610b = r101;
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public a(Context r100) {
        this.f178611c = r100;
        this.f178612d = "login_control";
        this.f178609a = LazyKt.lazy(new ECMallLocalStorage$sharedPreferences$2(this));
    }

    public final void delete(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        b();
        SharedPreferences.Editor r101 = a().edit();
        List<String> r102 = this.f178610b;
        if (r102 != null) goto L8;
    L13:
        r101.remove(r100 + "_timestamp").remove(r100).apply();
        return;
    L8:
        if (((ArrayList) r102).contains(r100) != true) goto L13;
        List<String> r103 = this.f178610b;
        if (r103 == null) goto L12;
        ((ArrayList) r103).remove(r100);
    L12:
        d();
        goto L13
    }

    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        b();
        SharedPreferences.Editor r102 = a().edit();
        List<String> r103 = this.f178610b;
        if (r103 != null) goto L8;
    L16:
        SharedPreferences.Editor r104 = r102.putLong(r100.concat("_timestamp"), System.currentTimeMillis());
        if ((r101 instanceof String) == false) goto L20;
        r104.putString(r100, (String) r101);
    L41:
        r104.apply();
        return;
    L20:
        if ((r101 instanceof Boolean) == false) goto L23;
        r104.putBoolean(r100, ((Boolean) r101).booleanValue());
        goto L41
    L23:
        if ((r101 instanceof Integer) == false) goto L26;
        r104.putInt(r100, ((Number) r101).intValue());
        goto L41
    L26:
        if ((r101 instanceof Float) == false) goto L29;
        r104.putFloat(r100, ((Number) r101).floatValue());
        goto L41
    L29:
        if ((r101 instanceof Long) == false) goto L32;
        r104.putLong(r100, ((Number) r101).longValue());
        goto L41
    L32:
        if ((r101 instanceof Set) == false) goto L41;
        if ((!((Collection) r101).isEmpty()) == false) goto L41;
        if ((CollectionsKt.first((Iterable) r101) instanceof String) == false) goto L41;
        if (r101 == null) goto L40;
        r104.putStringSet(r100, (Set) r101);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
    L8:
        if (((ArrayList) r103).contains(r100) != true) goto L12;
        List<String> r105 = this.f178610b;
        if (r105 == null) goto L12;
        ((ArrayList) r105).remove(r100);
    L12:
        List<String> r106 = this.f178610b;
        if (r106 == null) goto L15;
        ListProtector.add(r106, 0, r100);
    L15:
        d();
        goto L16
    }
}
