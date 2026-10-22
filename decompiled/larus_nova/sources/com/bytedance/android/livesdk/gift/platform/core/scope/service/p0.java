package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class p0<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m0 f131685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f131686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f131687c;

    public p0(m0 r100, long r101, ArrayList r102) {
        this.f131685a = r100;
        this.f131686b = r101;
        this.f131687c = r102;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        m0.a(this.f131685a, this.f131686b, null, this.f131687c);
    }
}
