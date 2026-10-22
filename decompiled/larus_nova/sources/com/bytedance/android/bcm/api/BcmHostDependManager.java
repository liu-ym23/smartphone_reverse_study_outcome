package com.bytedance.android.bcm.api;

import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class BcmHostDependManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f41756a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd.c f41757b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final cd.c f41758c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final cd.c f41759d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BcmHostDependManager f41760e = null;

    static {
        f41756a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BcmHostDependManager.class), "bcmCheckerGeckoDepend", "getBcmCheckerGeckoDepend()Lcom/bytedance/android/bcm/api/depend/IResourceDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BcmHostDependManager.class), "bcmConfigGeckoDepend", "getBcmConfigGeckoDepend()Lcom/bytedance/android/bcm/api/depend/IResourceDepend;")), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BcmHostDependManager.class), "expressRunner", "getExpressRunner()Lcom/bytedance/android/bcm/api/checker/IExpressionRunner;"))};
        f41760e = new BcmHostDependManager();
        f41757b = new cd.c(BcmHostDependManager$bcmCheckerGeckoDepend$2.INSTANCE);
        f41758c = new cd.c(BcmHostDependManager$bcmConfigGeckoDepend$2.INSTANCE);
        f41759d = new cd.c(BcmHostDependManager$expressRunner$2.INSTANCE);
    }

    public BcmHostDependManager() {
    }
}
