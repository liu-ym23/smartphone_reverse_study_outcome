package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class r<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f168955a;

    public static final class a<T> implements com.bytedance.android.ec.core.utils.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f168956a;

        public a(ObservableEmitter r100) {
            this.f168956a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.o
        public final void accept(Object r100) {
            this.f168956a.onNext(new com.bytedance.android.shopping.anchorv4.voavhs.blur.c((Bitmap) r100));
        }
    }

    public r(String r100) {
        this.f168955a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.android.shopping.anchorv4.voavhs.blur.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECLiveImageUtils.f(this.f168955a, new a(r100));
    }
}
