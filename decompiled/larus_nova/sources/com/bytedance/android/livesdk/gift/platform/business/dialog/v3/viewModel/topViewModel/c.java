package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f129002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f129003b;

    public c(ArrayList r100, String r101) {
        this.f129002a = r100;
        this.f129003b = r101;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ay1.b.b().put(this.f129003b, this.f129002a);
    }
}
