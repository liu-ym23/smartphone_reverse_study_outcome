package com.bytedance.android.livesdk.clearscreen.utils;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class d<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f119521a;

    public d(boolean r100) {
        this.f119521a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (this.f119521a == false) goto L5;
        ClearScreenLogUtils.Companion r101 = ClearScreenLogUtils.f119492a;
        Map r102 = MapsKt.emptyMap();
        r101.getClass();
        ClearScreenLogUtils.Companion.d(null, "slide_room", r102);
        return;
    L5:
        ClearScreenLogUtils.Companion r103 = ClearScreenLogUtils.f119492a;
        Map r104 = MapsKt.emptyMap();
        r103.getClass();
        ClearScreenLogUtils.Companion.f(null, "slide_room", r104);
    }
}
