package com.bytedance.android.live.network.impl.utils;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes46.dex */
public final class NetworkGson {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f83915a = null;

    public static Gson a() {
        return (Gson) f83915a.getValue();
    }

    static {
        f83915a = LazyKt.lazy(NetworkGson$instance$2.INSTANCE);
    }
}
