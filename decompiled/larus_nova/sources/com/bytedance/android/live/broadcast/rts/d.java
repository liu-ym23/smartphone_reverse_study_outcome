package com.bytedance.android.live.broadcast.rts;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f59195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f59196f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f59197g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f59198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function2<? super String, ? super Map<String, String>, Unit> f59199i;

    public d(String r100, String r101, String r102, String r103, String r104, String r105, Map<String, Object> r106, Function0<Unit> r107, Function2<? super String, ? super Map<String, String>, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "anchorId");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r103, "source");
        Intrinsics.checkNotNullParameter(r104, "webcastSDKVersion");
        Intrinsics.checkNotNullParameter(r107, "closePanel");
        Intrinsics.checkNotNullParameter(r110, "trackEvent");
        this.f59191a = r100;
        this.f59192b = r101;
        this.f59193c = r102;
        this.f59194d = r103;
        this.f59195e = r104;
        this.f59196f = r105;
        this.f59197g = r106;
        this.f59198h = r107;
        this.f59199i = r110;
    }
}
