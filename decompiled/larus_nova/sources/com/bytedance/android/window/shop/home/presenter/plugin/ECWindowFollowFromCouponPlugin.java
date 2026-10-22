package com.bytedance.android.window.shop.home.presenter.plugin;

import com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin;
import com.bytedance.android.window.shop.home.tab.tabplugin.c;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECWindowFollowFromCouponPlugin extends ECWindowJsbPlugin {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f188593d = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f188594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f188595c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.home.tab.tabplugin.ECWindowJsbPlugin
    public final List<c> c() {
        return CollectionsKt.listOf(new c("ecom.coupon.follow_state_changed", new ECWindowFollowFromCouponPlugin$createJsbActions$1(this)));
    }

    public ECWindowFollowFromCouponPlugin(Function0<String> r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "getSecAuthorId");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_RECEIVER);
        this.f188594b = r100;
        this.f188595c = r101;
    }
}
