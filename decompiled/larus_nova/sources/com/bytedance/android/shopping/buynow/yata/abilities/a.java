package com.bytedance.android.shopping.buynow.yata.abilities;

import android.app.Activity;
import com.bytedance.android.shopping.buynow.container.BuyNowFragment;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements kl3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f171280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BuyNowFragment f171281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BuyNowViewModel f171282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AndroidYaTaInstance f171283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f171284e;

    @Override // kl3.a
    public final d a() {
        return new d(this.f171282c.getTracker());
    }

    @Override // kl3.a
    public final BuyNowUIAbility b() {
        return new BuyNowUIAbility(this.f171280a, this.f171281b, this.f171282c, this.f171283d);
    }

    @Override // kl3.a
    public final l c() {
        return new l(this.f171283d);
    }

    @Override // kl3.a
    public final kl3.b d() {
        return new kl3.b();
    }

    @Override // kl3.a
    public final kl3.c e() {
        return new kl3.c(this.f171280a);
    }

    @Override // kl3.a
    public final kl3.e f() {
        return new kl3.e(this.f171284e);
    }

    @Override // kl3.a
    public final kl3.d r() {
        return new kl3.d(this.f171281b.f170744r);
    }

    public a(Activity r100, BuyNowFragment r101, BuyNowViewModel r102, AndroidYaTaInstance r103, BuyNowFragment r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "buyNowFragment");
        Intrinsics.checkNotNullParameter(r102, "viewModel");
        Intrinsics.checkNotNullParameter(r103, "yataInstance");
        Intrinsics.checkNotNullParameter(r104, "disposableScope");
        this.f171280a = r100;
        this.f171281b = r101;
        this.f171282c = r102;
        this.f171283d = r103;
        this.f171284e = r104;
    }
}
