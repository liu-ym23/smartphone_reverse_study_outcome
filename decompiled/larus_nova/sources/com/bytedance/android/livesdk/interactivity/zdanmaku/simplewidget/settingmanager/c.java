package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import p22.o;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f141801a = null;

    static {
        f141801a = new c();
    }

    public c() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "event");
        o r102 = r101.f141800a;
        if (r102 != null) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r103 = SimpleSettingManager.f141793a;
        return SimpleSettingManager.b();
    L6:
        return r102;
    }
}
