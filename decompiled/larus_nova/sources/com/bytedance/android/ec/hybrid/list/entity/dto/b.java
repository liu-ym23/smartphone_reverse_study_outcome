package com.bytedance.android.ec.hybrid.list.entity.dto;

import com.bytedance.android.ec.hybrid.list.entity.k;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECHybridListDTO f47094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f47095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f47096c;

    public b(ECHybridListDTO r100, boolean r101, a r102) {
        this.f47094a = r100;
        this.f47095b = r101;
        this.f47096c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECHybridListDTO.a r101 = ECHybridListDTO.Companion;
        ECHybridListDTO r102 = this.f47094a;
        boolean r103 = this.f47095b;
        a r104 = this.f47096c;
        r101.getClass();
        r100.onNext(ECHybridListDTO.a.d(r102, r103, r104));
        r100.onComplete();
    }
}
