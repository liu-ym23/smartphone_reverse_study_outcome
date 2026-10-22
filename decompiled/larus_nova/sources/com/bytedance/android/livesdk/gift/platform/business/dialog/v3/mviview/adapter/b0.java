package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import androidx.viewpager.widget.ViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public final class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LazyMVIViewPagerAdapter f127821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f127822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPager f127823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f127824d;

    public b0(LazyMVIViewPagerAdapter r100, int r101, GiftViewPager r102, Function1 r103) {
        this.f127821a = r100;
        this.f127822b = r101;
        this.f127823c = r102;
        this.f127824d = r103;
    }

    public final void a() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L20
        int r101 = this.f127821a.getCount();     // Catch: Throwable -> L20
        int r102 = this.f127822b;     // Catch: Throwable -> L20
        if (r102 < r101) goto L8;
        return;
    L8:
        if (r102 == this.f127823c.getCurrentItem()) goto L11;
        jy0.b.a("GiftLazyViewPager", "检测页不是当前页，无需检测  position:" + this.f127822b);     // Catch: Throwable -> L20
        return;
    L11:
        LazyMVIViewPagerAdapter r103 = this.f127821a;     // Catch: Throwable -> L20
        int r104 = this.f127822b;     // Catch: Throwable -> L20
        int r105 = LazyMVIViewPagerAdapter.f127798m;     // Catch: Throwable -> L20
        if (r103.f127803i.contains(Integer.valueOf(r104)) == true) goto L16;
        jy0.b.a("GiftLazyViewPager", "检测页不是占位页 " + this.f127822b + "，无需检测 position:" + this.f127822b);     // Catch: Throwable -> L20
        return;
    L16:
        if (this.f127821a.f127801g.containsKey(Integer.valueOf(this.f127822b)) == true) goto L18;
        this.f127824d.invoke(Integer.valueOf(this.f127822b));     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(Boolean.valueOf(this.f127821a.f127803i.remove(Integer.valueOf(this.f127822b))));     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
