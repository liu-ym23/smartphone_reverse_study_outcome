package com.bytedance.android.shopping.ligo.context;

import android.net.Uri;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class LigoComponentRegistry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f176431b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, w83.a> f176432a;

    public static final class a {
    }

    static {
        f176431b = LazyKt.lazy(LigoComponentRegistry$Companion$INSTANCE$2.INSTANCE);
    }

    public LigoComponentRegistry() {
        this.f176432a = new HashMap();
    }

    public final w83.a a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return this.f176432a.get(r100.toString());
    }
}
