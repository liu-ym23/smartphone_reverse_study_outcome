package com.bytedance.android.livesdk.utils;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class i3<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vl2.m f158988a;

    public i3(Context r100, vl2.m r101) {
        this.f158988a = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<LottieComposition> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        rg2.d r101 = (rg2.d) rg2.a.a(rg2.d.class);
        JSONObject r102 = this.f158988a.f555668c;
        r101.a();
    }
}
