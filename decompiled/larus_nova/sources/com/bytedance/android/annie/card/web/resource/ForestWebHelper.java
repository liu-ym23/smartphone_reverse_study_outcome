package com.bytedance.android.annie.card.web.resource;

import kotlin.Lazy;
import kotlin.LazyKt;
import y9.q;

/* JADX INFO: loaded from: classes43.dex */
public final class ForestWebHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f39205a = null;

    static {
        f39205a = LazyKt.lazy(ForestWebHelper$config$2.INSTANCE);
    }

    public static q a() {
        return (q) f39205a.getValue();
    }
}
