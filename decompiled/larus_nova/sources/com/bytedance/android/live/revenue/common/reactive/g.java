package com.bytedance.android.live.revenue.common.reactive;

import com.facebook.keyframes.model.KFAnimation;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g<T> implements ObservableOnSubscribe<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f90985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f90986b;

    public static final class a implements ttc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Disposable f90987a;

        public a(Disposable r100) {
            this.f90987a = r100;
        }

        @Override // ttc.c
        public final void cancel() {
            this.f90987a.dispose();
        }
    }

    public static final class b<T> implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f90988a;

        public b(ObservableEmitter r100) {
            this.f90988a = r100;
        }

        @Override // com.bytedance.android.live.revenue.common.reactive.f
        public final void a(T r100) {
            Intrinsics.checkNotNullParameter(r100, "newValue");
            this.f90988a.onNext(r100);
        }
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        b r101 = new b(r100);
        r100.setCancellable(new a(this.f90985a.a(r101)));
        if (this.f90986b == false) goto L6;
        r100.onNext(this.f90985a.getValue());
        return;
    }

    public g(e<T> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f90985a = r100;
        this.f90986b = r101;
    }
}
