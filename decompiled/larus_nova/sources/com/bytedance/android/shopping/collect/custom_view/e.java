package com.bytedance.android.shopping.collect.custom_view;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.api.mall.feed.h;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements com.bytedance.android.shopping.api.mall.feed.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f172215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f172216b;

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean oi() {
        return false;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final yj.e Pn() {
        return this.f172216b.f170539i;
    }

    public final Map<String, Object> a() {
        if (this.f172215a != null) goto L14;
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("page_name", this.f172216b.f170531a);
        String r101 = this.f172216b.f170533c;
        if (r101 == null) goto L7;
        r100.put("ecom_scene_id", r101);
    L7:
        String r102 = this.f172216b.f170532b;
        if (r102 == null) goto L10;
        r100.put("enter_from", r102);
    L10:
        Map<String, Object> r103 = this.f172216b.f170535e;
        if (r103 == null) goto L13;
        r100.putAll(r103);
    L13:
        Unit r104 = Unit.INSTANCE;
        this.f172215a = r100;
    L14:
        Map<String, Object> r105 = this.f172215a;
        if (r105 == null) goto L17;
        return r105;
    L17:
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> getGlobalProps() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.putAll(a());
        return r100;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final boolean isDarkMode() {
        return this.f172216b.f170534d;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final LifecycleOwner s4() {
        return this.f172216b.f170537g;
    }

    public e(h r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f172216b = r100;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, Object> PN(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final Map<String, String> Xj(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        Intrinsics.checkNotNullParameter(r100, "apiKey");
        return null;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.e
    public final void jq(Map<String, ? extends Object> r100, Set<String> r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.putAll(a());
        if (r101 == null) goto L8;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.remove((String) r103.next());
    L8:
        if (r100 == null) goto L10;
        r102.putAll(r100);
    L10:
        this.f172215a = r102;
    }
}
