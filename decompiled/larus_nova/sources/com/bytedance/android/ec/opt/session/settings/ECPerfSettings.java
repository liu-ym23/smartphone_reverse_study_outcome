package com.bytedance.android.ec.opt.session.settings;

import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes44.dex */
public final class ECPerfSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f48103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f48104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f48105c = null;

    static {
        f48103a = new Gson();
        f48104b = LazyKt.lazy(ECPerfSettings$enableSession$2.INSTANCE);
        f48105c = LazyKt.lazy(ECPerfSettings$extractRule$2.INSTANCE);
    }
}
