package com.bytedance.android.ecom.bcm.track.impl.setting;

import com.bytedance.android.ecom.bcm.track.api.TrackHostDependManager;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes3.dex */
public final class Setting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static w f51149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51150b = null;

    static {
        f51149a = new w();
        f51150b = LazyKt.lazy(Setting$gson$2.INSTANCE);
    }

    public static void a() {
        TrackHostDependManager r100 = TrackHostDependManager.f51063d;
        r100.getClass();
        zc.h r101 = (zc.h) TrackHostDependManager.f51061b.getValue(r100, TrackHostDependManager.f51060a[0]);
        if (r101 == null) goto L5;
        String r102 = r101.getSetting();
    L6:
        if (r102 == null) goto L12;
        f51149a = (w) ((Gson) f51150b.getValue()).fromJson(r102, w.class);     // Catch: Exception -> L9
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
