package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import com.bytedance.android.ec.model.ECUrlModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class w1<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUrlModel f45737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45738b;

    public static final class a<T> implements y.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w1 f45739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f45740b;

        public a(w1 r100, ObservableEmitter r101) {
            this.f45739a = r100;
            this.f45740b = r101;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f45740b.isDisposed() == true) goto L8;
            if (r101 != null) goto L6;
            this.f45740b.onError(new Throwable("load remote url fails"));
            return;
        L6:
            this.f45740b.onNext(new m1(this.f45739a.f45738b, r101, null));
            this.f45740b.onComplete();
            return;
        }
    }

    public w1(ECUrlModel r100, int r101) {
        this.f45737a = r100;
        this.f45738b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<m1> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        y.l(this.f45737a, 0, 0, new a(this, r100));
    }
}
