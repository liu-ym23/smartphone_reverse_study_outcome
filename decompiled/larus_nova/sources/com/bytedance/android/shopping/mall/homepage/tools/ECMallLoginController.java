package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallLoginController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f178469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f178470b;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.shopping.mall.utils.a a() {
        return (com.bytedance.android.shopping.mall.utils.a) this.f178469a.getValue();
    }

    public ECMallLoginController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f178470b = r100;
        this.f178469a = LazyKt.lazy(new ECMallLoginController$localStorage$2(this));
    }
}
