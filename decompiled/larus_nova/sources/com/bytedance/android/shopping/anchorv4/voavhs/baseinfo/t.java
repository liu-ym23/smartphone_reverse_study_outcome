package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class t<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECUrlModel f167984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f167985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f167986c;

    public static final class a<T> implements y.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f167987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f167988b;

        public a(t r100, ObservableEmitter r101) {
            this.f167987a = r100;
            this.f167988b = r101;
        }

        @Override // com.bytedance.android.ec.core.utils.y.c
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            if (this.f167988b.isDisposed() == true) goto L8;
            if (r101 != null) goto L6;
            this.f167988b.onError(new Throwable("load remote url fails: " + this.f167987a.f167984a));
            return;
        L6:
            ObservableEmitter r102 = this.f167988b;
            t r103 = this.f167987a;
            r102.onNext(new w.b(r103.f167985b, r101, r103.f167986c, r103.f167984a.getUri(), this.f167987a.f167984a.getWidth(), this.f167987a.f167984a.getHeight()));
            this.f167988b.onComplete();
            return;
        }
    }

    public t(ECUrlModel r100, int r101) {
        this.f167984a = r100;
        this.f167985b = r101;
        this.f167986c = true;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<w> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        y.l(this.f167984a, 0, 0, new a(this, r100));
    }
}
