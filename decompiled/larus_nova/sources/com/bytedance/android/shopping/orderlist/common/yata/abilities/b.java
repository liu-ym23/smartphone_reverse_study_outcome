package com.bytedance.android.shopping.orderlist.common.yata.abilities;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.orderlist.common.repo.OrderCommonApi;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f180096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f180097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f180098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f180099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f180100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f180101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f180102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<PageFinder> f180103h;

    public b(Context r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(OrderCommonApi.API_HOST, "apiHost");
        Intrinsics.checkNotNullParameter(r101, "pageFinderMethod");
        this.f180101f = r100;
        this.f180102g = OrderCommonApi.API_HOST;
        this.f180103h = r101;
        this.f180096a = LazyKt.lazy(new OrderCommonYataAbilityManager$confirmAbility$2(this));
        this.f180097b = LazyKt.lazy(OrderCommonYataAbilityManager$errorHandler$2.INSTANCE);
        this.f180098c = LazyKt.lazy(new OrderCommonYataAbilityManager$openSchemaAbility$2(this));
        this.f180099d = LazyKt.lazy(OrderCommonYataAbilityManager$toastAbility$2.INSTANCE);
        this.f180100e = LazyKt.lazy(new OrderCommonYataAbilityManager$networkAbility$2(this));
    }
}
