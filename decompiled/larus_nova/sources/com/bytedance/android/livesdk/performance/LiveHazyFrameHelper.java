package com.bytedance.android.livesdk.performance;

import com.bytedance.android.livesdk.config.zz;
import com.bytedance.android.livesdkapi.model.LiveHazyFrameConfig;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveHazyFrameHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveHazyFrameConfig f154369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f154370b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f154371c = null;

    static {
        f154369a = zz.f121802a.getValue();
        f154370b = LazyKt.lazy(LiveHazyFrameHelper$isFoldScreen$2.INSTANCE);
        f154371c = LazyKt.lazy(LiveHazyFrameHelper$isPad$2.INSTANCE);
    }

    public static boolean a() {
        if (((Boolean) f154370b.getValue()).booleanValue() == false) goto L6;
        return true;
    L6:
        if (((Boolean) f154371c.getValue()).booleanValue() == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean b() {
        if (f154369a.getEnableInner() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == true) goto L7;
        return true;
    }
}
