package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.live.core.setting.n0;
import com.bytedance.android.livesdk.dslservice.util.p;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxAirDSLProcess f122871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f122872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f122873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f122874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m f122875e;

    public d(LynxAirDSLProcess r100, a r101, p r102, String r103, m r104) {
        this.f122871a = r100;
        this.f122872b = r101;
        this.f122873c = r102;
        this.f122874d = r103;
        this.f122875e = r104;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        a r102 = this.f122872b;
        boolean r103 = true;
        r102.f122818b = 1;
        String r104 = r102.f122864f;
        if (r104 != null) goto L5;
        r104 = "UnKnown";
    L5:
        this.f122871a.getClass();
        if (Intrinsics.areEqual(r104, "NodeCache") == true) goto L12;
        if (Intrinsics.areEqual(r104, "LocalRawData") == true) goto L12;
        r103 = false;
    L12:
        if (n0.f65363a.getValue().booleanValue() == true) goto L14;
        m r105 = this.f122875e;
        if (r105 == null) goto L24;
        r105.a(this.f122872b, r103, r104);
    L24:
        if (r103 == true) goto L32;
        p r106 = this.f122873c;
        if (r106 == null) goto L28;
        r106.a(new c(this, r104));
    L28:
        this.f122872b.b(au1.a.c.f16301b, false);
        return;
    L32:
        return;
    L14:
        if (dt2.c.f469997a.getValue().booleanValue() == true) goto L18;
        p r107 = this.f122873c;
        if (r107 == null) goto L18;
        r107.a(new b(this, r104));
    L18:
        this.f122872b.b(au1.a.c.f16301b, false);
        m r108 = this.f122875e;
        if (r108 == null) goto L30;
        r108.a(this.f122872b, r103, r104);
        return;
    }
}
