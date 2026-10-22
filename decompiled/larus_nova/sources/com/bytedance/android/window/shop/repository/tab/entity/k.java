package com.bytedance.android.window.shop.repository.tab.entity;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends f {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f189581t = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f189582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f189583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f189584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f189585m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f189586n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final e f189587o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.android.window.shop.repository.dto.f f189588p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final com.bytedance.android.window.shop.repository.dto.f f189589q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.window.shop.repository.dto.f f189590r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final tq3.c f189591s;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.f189591s;
    }

    public k(String r100, String r101, String r102, String r103, String r104, ProductVideoVO r105, com.bytedance.android.window.shop.repository.dto.f r106, com.bytedance.android.window.shop.repository.dto.f r107, com.bytedance.android.window.shop.repository.dto.f r110, tq3.c r111) {
        Intrinsics.checkNotNullParameter(r100, "mainTitleSingle");
        Intrinsics.checkNotNullParameter(r101, "subTitleSingle");
        Intrinsics.checkNotNullParameter(r102, "mainTitleDouble");
        Intrinsics.checkNotNullParameter(r103, "subTitleDouble");
        Intrinsics.checkNotNullParameter(r104, "jumpUrl");
        super(209);
        this.f189582j = r100;
        this.f189583k = r101;
        this.f189584l = r102;
        this.f189585m = r103;
        this.f189586n = r104;
        this.f189587o = r105;
        this.f189588p = r106;
        this.f189589q = r107;
        this.f189590r = r110;
        this.f189591s = r111;
    }
}
