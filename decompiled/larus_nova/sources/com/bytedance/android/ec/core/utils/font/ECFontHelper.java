package com.bytedance.android.ec.core.utils.font;

import android.content.Context;
import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECFontHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f45588a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f45589b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f45590c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f45591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ECFontHelper f45592e = null;

    public ECFontHelper() {
    }

    private final Context getContext() {
        return (Context) f45589b.getValue();
    }

    static {
        f45592e = new ECFontHelper();
        f45588a = LazyKt.lazy(ECFontHelper$executor$2.INSTANCE);
        f45589b = LazyKt.lazy(ECFontHelper$context$2.INSTANCE);
        f45590c = LazyKt.lazy(ECFontHelper$loaderMap$2.INSTANCE);
    }

    public final void a() {
        com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_ec_font_preload");
        b("DouyinNumberABC", 600, false);     // Catch: Throwable -> L5
        b("DouyinNumberABC", 500, false);     // Catch: Throwable -> L5
        b("DouyinNumberABC", 400, false);     // Catch: Throwable -> L5
        dm.a.a("ECFontHelper").i("ECFontHelper#doPreload method execution end");     // Catch: Throwable -> L5
        f45591d = true;     // Catch: Throwable -> L5
        return;
    }

    public final Typeface b(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "fontFamily");
        Context r103 = getContext();
        if (r103 != null) goto L5;
        return null;
    L5:
        e r104 = (e) ((ConcurrentHashMap) f45590c.getValue()).get(r100);
        if (r104 != null) goto L8;
        return null;
    L8:
        return r104.a(r103, r101);
    }
}
