package com.bytedance.android.shopping.anchorv4.voavhs.headgausee;

import android.graphics.Bitmap;
import com.bytedance.android.ec.core.utils.ECLiveImageUtils;
import com.bytedance.android.ec.core.utils.o;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f168999a;

    public static final class a<T> implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f169000a;

        public a(ObservableEmitter r100) {
            this.f169000a = r100;
        }

        @Override // com.bytedance.android.ec.core.utils.o
        public final void accept(Object r100) {
            this.f169000a.onNext(new com.bytedance.android.shopping.anchorv4.voavhs.blur.c((Bitmap) r100));
        }
    }

    public d(String r100) {
        this.f168999a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<com.bytedance.android.shopping.anchorv4.voavhs.blur.c> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECLiveImageUtils.f(this.f168999a, new a(r100));
    }
}
