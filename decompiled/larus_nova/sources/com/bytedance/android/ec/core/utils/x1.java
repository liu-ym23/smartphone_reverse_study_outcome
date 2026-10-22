package com.bytedance.android.ec.core.utils;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x1<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f45742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f45743b;

    public static final class a<T> implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x1 f45744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f45745b;

        public a(x1 r100, ObservableEmitter r101) {
            this.f45744a = r100;
            this.f45745b = r101;
        }

        @Override // com.bytedance.android.ec.core.utils.o
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f45745b.isDisposed() == true) goto L8;
            if (r101 != null) goto L6;
            this.f45745b.onError(new Throwable("load remote url fails: " + this.f45744a.f45742a));
            return;
        L6:
            ObservableEmitter r102 = this.f45745b;
            x1 r103 = this.f45744a;
            r102.onNext(new m1(r103.f45743b, r101, r103.f45742a));
            this.f45745b.onComplete();
            return;
        }
    }

    public x1(String r100, int r101) {
        this.f45742a = r100;
        this.f45743b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<m1> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECLiveImageUtils.f(this.f45742a, new a(this, r100));
    }
}
