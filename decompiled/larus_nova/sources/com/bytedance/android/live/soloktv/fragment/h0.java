package com.bytedance.android.live.soloktv.fragment;

import android.graphics.Bitmap;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class h0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.soloktv.model.k f101214a;

    public h0(com.bytedance.android.live.soloktv.model.k r100) {
        this.f101214a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        com.bytedance.android.live.soloktv.util.j r101 = com.bytedance.android.live.soloktv.util.j.f101607a;
        com.bytedance.android.live.soloktv.model.k r102 = this.f101214a;
        r101.getClass();
        Bitmap r103 = com.bytedance.android.live.soloktv.util.j.c(r102);
        if (r103 == null) goto L5;
        Bitmap r104 = Bitmap.createBitmap(200, (int) 355.55557f, Bitmap.Config.RGB_565);
        com.bytedance.android.livesdk.utils.e0.a(r103, r104, 150);
        r100.onNext(r104);
        return;
    L5:
        r100.onError(new Throwable());
    }
}
