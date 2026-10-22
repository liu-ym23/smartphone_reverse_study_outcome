package com.bytedance.android.window.shop.innerflow.holder.factory;

import android.app.Activity;
import com.bytedance.android.window.shop.innerflow.holder.ECShopInnerFlowItemHolder;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import vp3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopInnerFlowHolderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Function1<Activity, ECShopInnerFlowItemHolder<? extends b>>> f189159a = null;

    static {
        a r100 = a.f189160a;
        f189159a = MapsKt.mapOf(new Pair[]{TuplesKt.to(2, new ECShopInnerFlowHolderFactory$holderGenerators$1(r100)), TuplesKt.to(3, new ECShopInnerFlowHolderFactory$holderGenerators$2(r100)), TuplesKt.to(4, new ECShopInnerFlowHolderFactory$holderGenerators$3(r100))});
    }
}
