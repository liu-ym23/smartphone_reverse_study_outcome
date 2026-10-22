package com.bytedance.android.ec.sdk.helper;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.ec.base.service.ECServiceManager;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements dj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f48129a = null;

    public o() {
    }

    static {
        f48129a = new o();
    }

    public static dj.a e() {
        Object r100 = d.f48119b.getIOrderShowOffService();
        if (r100 != null) goto L6;
        boolean r101 = ECServiceManager.f42805a;
        r100 = ECServiceManager.c(dj.a.class);
    L6:
        return (dj.a) r100;
    }

    @Override // dj.a
    public final void c(Context r100, Bundle r101, Function1<Object, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "editConfigParams");
        Intrinsics.checkNotNullParameter(r102, "callBack");
        e().c(r100, r101, r102);
    }

    @Override // dj.a
    public final Function0<Unit> a(Context r100, List<String> r101, String r102, Function2<? super String, ? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "images");
        Intrinsics.checkNotNullParameter(r102, "video");
        Intrinsics.checkNotNullParameter(r103, "synthesizeFinishCallback");
        return e().a(r100, r101, r102, r103);
    }

    @Override // dj.a
    public final void b(Context r100, Bundle r101, int r102, Function2<? super Integer, Object, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "editConfigParams");
        Intrinsics.checkNotNullParameter(r103, "callBack");
        e().b(r100, r101, r102, r103);
    }

    @Override // dj.a
    public final void d(Context r100, Bundle r101, Object r102, Function2<? super Boolean, ? super String, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "publishExtra");
        Intrinsics.checkNotNullParameter(r103, "callBack");
        e().d(r100, r101, r102, r103);
    }
}
