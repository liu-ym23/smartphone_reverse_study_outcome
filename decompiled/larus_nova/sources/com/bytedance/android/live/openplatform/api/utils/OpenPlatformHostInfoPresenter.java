package com.bytedance.android.live.openplatform.api.utils;

import kotlin.Unit;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class OpenPlatformHostInfoPresenter {
    /* JADX WARN: Type inference failed for: r1v3, types: [T, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r4v0, types: [T, kotlin.Unit] */
    public static boolean a() {
        final Ref.BooleanRef r100 = new Ref.BooleanRef();
        r100.element = true;
        kjc.c r101 = new kjc.c();
        f.a(r101, new OpenPlatformHostInfoPresenter$isDouyin$$inlined$call$lambda$1(r100));
        if (1 != kjc.a.a()) goto L6;
        kjc.b<T> r102 = r101.f503730a;
        r100.element = true;
        r102.f503729a = Unit.INSTANCE;
        r101.f503731b = true;
    L6:
        if (r101.f503731b == true) goto L8;
        kjc.b<T> r103 = r101.f503730a;
        r100.element = true;
        r103.f503729a = Unit.INSTANCE;
    L8:
        T r104 = r101.f503730a.f503729a;
        return r100.element;
    }

    static {
    }
}
