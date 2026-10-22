package com.bytedance.android.shopping.buynow.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.buynow.data.model.PageType;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nl.c;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f171227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f171228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f171229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PageFinder f171230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f171231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f171232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f171233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f171234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f171235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map<String, ? extends Object> f171236j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f171237k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f171238l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f171239m;

    public final boolean a() {
        return Intrinsics.areEqual(this.f171233g, PageType.BUYNOW);
    }

    public final boolean b() {
        return Intrinsics.areEqual(this.f171233g, PageType.CONTINUEPAY);
    }

    public final boolean c() {
        return Intrinsics.areEqual(this.f171233g, PageType.ULTIMATEBUYNOW);
    }

    public a(int r100) {
        Intrinsics.checkNotNullParameter(PageType.BUYNOW, "pageType");
        this.f171227a = null;
        this.f171228b = null;
        this.f171229c = null;
        this.f171230d = null;
        this.f171231e = 0;
        this.f171232f = null;
        this.f171233g = PageType.BUYNOW;
        this.f171234h = 0;
        this.f171235i = false;
        this.f171236j = null;
        this.f171237k = null;
        this.f171238l = null;
        this.f171239m = false;
    }
}
