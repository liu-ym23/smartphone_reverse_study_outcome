package com.bytedance.android.live.ktv.common.util;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class KtvCommonConfigParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f70602a = null;

    public static String a() {
        return (String) f70602a.getValue();
    }

    static {
        f70602a = LazyKt.lazy(KtvCommonConfigParams$STORAGE_ROOT_DIR$2.INSTANCE);
    }
}
