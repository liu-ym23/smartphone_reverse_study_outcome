package com.bytedance.android.window.shop.home.tab.tabplugin;

import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public abstract class ECWindowJsbPlugin implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f188908a;

    public static final class a {
    }

    static {
    }

    public abstract List<c> c();

    public void e() {
    }

    public void f() {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public void a() {
        Iterator r100 = ((List) this.f188908a.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        c r101 = (c) r100.next();
        ECLiveHybridUtil.m(r101.f188942b, r101.f188941a);
        goto L4
    L6:
        e();
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.e
    public void b() {
        Iterator r100 = ((List) this.f188908a.getValue()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        c r101 = (c) r100.next();
        ECLiveHybridUtil.p(r101.f188942b, r101.f188941a);
        goto L4
    L6:
        f();
    }

    public ECWindowJsbPlugin() {
        this.f188908a = LazyKt.lazy(new ECWindowJsbPlugin$actionRegistries$2(this));
    }

    public static boolean g(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "secAuthorId");
        return d(r100, "sec_author_id", r101, true);
    }

    public static boolean d(JSONObject r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "expected");
        String r104 = r100.optString(r101, "");
        if (r103 == false) goto L9;
        if (Intrinsics.areEqual(r104, "") == false) goto L9;
        return true;
    L9:
        return Intrinsics.areEqual(r104, r102);
    }
}
