package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.bytedance.android.shopping.store.hybrid.entity.ComponentsWrapper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class StoreLynxJsbChecker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f184857d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f184858e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f184859f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f184860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ComponentsWrapper f184861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<? super String, ? super String, ? super String, Unit> f184862c;

    public static final class a {
        public a() {
        }
    }

    static {
        f184859f = new a();
        f184857d = LazyKt.lazy(StoreLynxJsbChecker$Companion$tabConfig$2.INSTANCE);
        f184858e = LazyKt.lazy(StoreLynxJsbChecker$Companion$checker$2.INSTANCE);
    }

    public StoreLynxJsbChecker(String r100, ComponentsWrapper r101, Function3 r102) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        this.f184861b = r101;
        this.f184862c = r102;
        this.f184860a = LazyKt.lazy(new StoreLynxJsbChecker$hasISV$2(this));
    }
}
