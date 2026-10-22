package com.bytedance.android.ec.store.product;

import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.ExecutorType;
import com.bytedance.android.ec.store.utils.taskmanager.c;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECStoreSettingsValuePreloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f48263a;

    public static void a() {
        if (f48263a == false) goto L5;
        return;
    L5:
        f48263a = true;
        Lazy r100 = ECTaskManager.f48688b;
        ECTaskManager r101 = ECTaskManager.a.a();
        ECStoreSettingsValuePreloader$preload$1 r102 = ECStoreSettingsValuePreloader$preload$1.INSTANCE;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "runnable");
        int r103 = c.f48696c;
        c.b.f48699a.a(ExecutorType.COMPUTE, r102);
    }

    static {
    }
}
