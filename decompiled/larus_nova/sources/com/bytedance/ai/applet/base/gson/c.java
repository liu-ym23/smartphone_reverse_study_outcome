package com.bytedance.ai.applet.base.gson;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f34513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f34514b = null;

    static {
        f34513a = LazyKt.lazy(new a());
        f34514b = LazyKt.lazy(new b());
    }

    public static final Gson a() {
        return (Gson) f34513a.getValue();
    }
}
