package com.bytedance.android.shopping.orderlist.common.widgets.touch;

import android.content.Context;
import android.view.ViewConfiguration;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f180080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f180081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f180082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f180083e;

    public final boolean a() {
        float r100 = Math.abs(this.f180082d - this.f180080b);
        float r101 = Math.abs(this.f180083e - this.f180081c);
        if (r100 > this.f180079a) goto L5;
    L7:
        return false;
    L5:
        if (r100 <= r101) goto L7;
        return true;
    }

    public final boolean b() {
        float r100 = Math.abs(this.f180082d - this.f180080b);
        float r101 = Math.abs(this.f180083e - this.f180081c);
        if (r101 > this.f180079a) goto L5;
    L7:
        return false;
    L5:
        if (r101 <= r100) goto L7;
        return true;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f180079a = ViewConfiguration.get(r100).getScaledTouchSlop();
    }
}
