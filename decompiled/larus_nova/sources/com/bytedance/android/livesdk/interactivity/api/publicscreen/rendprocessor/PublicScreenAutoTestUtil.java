package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.b4;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes9.dex */
public final class PublicScreenAutoTestUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133496a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133497b = null;

    static {
        if (b4.f104233a.getValue().booleanValue() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        f133496a = r100;
        f133497b = LazyKt.lazy(PublicScreenAutoTestUtil$publicScreenUrlList$2.INSTANCE);
        return;
    L5:
        if (v.a() == false) goto L7;
        r100 = true;
        goto L8
    }
}
