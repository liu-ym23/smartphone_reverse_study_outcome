package com.bytedance.android.live.revenue.platform.settings.impl;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.setting.c7;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.live.strategy.api.StrategyMutableLiveData;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f91656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Object, Type>> f91657b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StrategyMutableLiveData<Object> f91658c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Boolean f91659d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile IStrategyService f91660e;

    public static final class a implements b70.a {
        public a() {
        }

        @Override // b70.a
        public final void onSuccess() {
            f.f91657b.clear();
        }
    }

    static {
        Class r100 = Boolean.TYPE;
        f91656a = (Boolean) c7.e("ultra_setting_cache_enable", r100, Boolean.FALSE, false, false);
        f91657b = new ConcurrentHashMap();
        f91658c = new StrategyMutableLiveData();
        f91659d = (Boolean) c7.e("ultra_setting_strategy_enable", r100, Boolean.TRUE, true, false);
        SettingIncStrategy.a(new a());
    }

    public static Object a(String r100, Object r101, Type r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r102, "type");
        Boolean r104 = f91656a;
        if (r104.booleanValue() == false) goto L10;
        Pair<Object, Type> r105 = f91657b.get(r100);
        if (r105 == null) goto L10;
        if (Intrinsics.areEqual(r105.getSecond(), r102) == false) goto L10;
        return r105.getFirst();
    L10:
        Object r106 = c7.e(r100, r102, r101, r103, false);
        if (f91659d.booleanValue() == false) goto L46;
        if (r103 == true) goto L46;
        if (k.h(IStrategyService.class) == false) goto L46;
        if (f91660e != null) goto L18;
        f91660e = (IStrategyService) k.f(IStrategyService.class);
    L18:
        IStrategyService r107 = f91660e;
        if (r107 == null) goto L46;
        if (r107.isStrategyFactor(r100) != true) goto L46;
        if ((r106 instanceof Boolean) == false) goto L25;
    L34:
        IStrategyService r108 = f91660e;
        if (r108 == null) goto L37;
        LiveData r109 = r108.getFactor(r100, r106, true, true);
    L38:
        if (r109 == null) goto L40;
        Object r110 = r109.getValue();
    L41:
        if (r110 == null) goto L46;
        if (r110 == f91658c.getValue()) goto L46;
        r106 = r110;
        goto L46
    L40:
        r110 = null;
        goto L41
    L37:
        r109 = null;
        goto L38
    L25:
        if ((r106 instanceof Integer) == true) goto L34;
        if ((r106 instanceof String) == true) goto L34;
        if ((r106 instanceof Float) == true) goto L34;
        if ((r106 instanceof Double) == true) goto L34;
        r110 = StrategyConvertHelper.getObjectStrategyValue(r100, r106, true, true);
    L46:
        if (r104.booleanValue() == false) goto L49;
        if (r106 == null) goto L49;
        f91657b.put(r100, TuplesKt.to(r106, r102));
    L49:
        return r106;
    }
}
