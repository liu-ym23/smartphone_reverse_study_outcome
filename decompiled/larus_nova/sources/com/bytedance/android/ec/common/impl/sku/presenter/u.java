package com.bytedance.android.ec.common.impl.sku.presenter;

import android.content.Context;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class u<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f43297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f43298b;

    public u(String r100, Context r101) {
        this.f43297a = r100;
        this.f43298b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        JSONObject r100 = jg.g.f(UriProtector.getQueryParameter(UriProtector.parse(this.f43297a), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r100 == null) goto L5;
        String r101 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE);
    L7:
        if (Intrinsics.areEqual(r101, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L12;
        int r102 = ECSdk.f48106a;
        com.bytedance.android.ec.core.monitor.o r103 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r103 == null) goto L13;
        r103.a(this.f43298b, "inflow_feed_place_order", this.f43297a, null, VmSdkSetting.a().i());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
