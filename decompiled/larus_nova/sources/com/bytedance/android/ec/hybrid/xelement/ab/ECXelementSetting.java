package com.bytedance.android.ec.hybrid.xelement.ab;

import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.dataplatform.config.SettingPanel;
import jj4.a;
import jj4.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECXelementSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47710a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f47711b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f47712c = null;

    static {
        f47710a = LazyKt.lazy(ECXelementSetting$imageRefreshOptCacheEnabled$2.INSTANCE);
        f47711b = LazyKt.lazy(ECXelementSetting$imageRefreshOptBizCache$2.INSTANCE);
        f47712c = LazyKt.lazy(ECXelementSetting$imageRefreshOptSceneCache$2.INSTANCE);
    }

    @SettingPanel("ECLynxDragListView")
    public static boolean a() {
        int r100 = p.f45243a;
        Object r101 = Boolean.TRUE;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        b r103 = b.f499326b;     // Catch: Throwable -> L7
        Object r104 = a.a("ec_draglist_async_handler_fix", Boolean.class, r101, false);     // Catch: Throwable -> L7
        if (r104 != null) goto L14;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L14:
        return ((Boolean) r104).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Object r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r106) == true) goto L12;
        r101 = r106;
    L12:
        r104 = r101;
        goto L14
    }
}
