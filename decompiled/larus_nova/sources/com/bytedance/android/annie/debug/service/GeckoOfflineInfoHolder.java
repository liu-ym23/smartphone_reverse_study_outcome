package com.bytedance.android.annie.debug.service;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class GeckoOfflineInfoHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<GeckoOfflineInfoHolder> f39390b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f39391a;

    public static final class a {
    }

    static {
        f39390b = LazyKt.lazy(GeckoOfflineInfoHolder$Companion$instance$2.INSTANCE);
    }

    public GeckoOfflineInfoHolder() {
        this.f39391a = LazyKt.lazy(GeckoOfflineInfoHolder$offlineStates$2.INSTANCE);
    }

    public static String a(String r100) {
        List r101 = StringsKt.split$default(r100, new String[]{"?"}, false, 0, 6, null);
        if ((!r101.isEmpty()) == true) goto L7;
        return null;
    L7:
        return (String) ListProtector.get(r101, 0);
    }
}
