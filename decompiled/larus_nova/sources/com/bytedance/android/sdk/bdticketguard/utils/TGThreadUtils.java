package com.bytedance.android.sdk.bdticketguard.utils;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes3.dex */
public final class TGThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f164072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f164073b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f164074c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f164075d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f164076e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TGThreadUtils f164077f = null;

    static {
        f164072a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TGThreadUtils.class), "ioExecutor", "getIoExecutor()Ljava/util/concurrent/ThreadPoolExecutor;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(TGThreadUtils.class), "schedulerExecutor", "getSchedulerExecutor()Ljava/util/concurrent/ScheduledExecutorService;"))};
        f164077f = new TGThreadUtils();
        f164073b = new AtomicInteger(0);
        f164074c = new AtomicInteger(0);
        f164075d = LazyKt.lazy(TGThreadUtils$ioExecutor$2.INSTANCE);
        f164076e = LazyKt.lazy(TGThreadUtils$schedulerExecutor$2.INSTANCE);
    }

    public TGThreadUtils() {
    }

    public static void a(Function0 r100) {
        f r101 = new f(r100);
        Lazy r102 = f164075d;
        KProperty r103 = f164072a[0];
        ((ThreadPoolExecutor) r102.getValue()).submit(r101);
    }
}
