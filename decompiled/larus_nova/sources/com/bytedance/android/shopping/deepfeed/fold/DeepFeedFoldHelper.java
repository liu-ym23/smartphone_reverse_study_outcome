package com.bytedance.android.shopping.deepfeed.fold;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import nj.d;
import tc3.a;

/* JADX INFO: loaded from: classes13.dex */
public final class DeepFeedFoldHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f173363a = null;

    static {
        f173363a = LazyKt.lazy(DeepFeedFoldHelper$service$2.INSTANCE);
    }

    public static boolean f() {
        d r100 = (d) f173363a.getValue();
        if (r100 == null) goto L7;
        r100.isFold();
        return false;
    L7:
        return false;
    }

    public static boolean a() {
        Integer r100 = a.a().i();
        if (r100 != null) goto L6;
    L8:
        e();
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        f();
        goto L8
    }

    public static boolean d() {
        Integer r100 = a.a().i();
        if (r100 != null) goto L6;
    L7:
        Integer r101 = a.a().i();
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.intValue() != 2) goto L15;
    L12:
        f();
        return false;
    L15:
        return false;
    L6:
        if (r100.intValue() == 1) goto L12;
        goto L7
    }

    public static boolean e() {
        Integer r100 = a.a().i();
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.intValue() != 2) goto L10;
        f();
        return false;
    L10:
        return false;
    }

    public static boolean b(Activity r100) {
        d r101 = (d) f173363a.getValue();
        if (r101 == null) goto L7;
        r101.l();
        return false;
    L7:
        return false;
    }

    public static int c(Context r100) {
        f();
        return ToolsKt.o(r100);
    }
}
