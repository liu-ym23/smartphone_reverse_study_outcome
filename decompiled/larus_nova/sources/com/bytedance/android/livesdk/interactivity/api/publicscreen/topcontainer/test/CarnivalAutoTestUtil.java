package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test;

import com.bytedance.android.live.core.utils.v;
import kotlin.Lazy;
import kotlin.LazyKt;
import r52.r;

/* JADX INFO: loaded from: classes9.dex */
public final class CarnivalAutoTestUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133551a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133552b = null;

    static {
        if (r.f536247a.getValue().booleanValue() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f133551a = r100;
        f133552b = LazyKt.lazy(CarnivalAutoTestUtil$bean$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r100 = true;
        goto L8
    }

    public static a a() {
        if (v.a() == true) goto L7;
        return null;
    L7:
        return (a) f133552b.getValue();
    }
}
