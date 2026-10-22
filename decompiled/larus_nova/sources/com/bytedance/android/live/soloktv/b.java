package com.bytedance.android.live.soloktv;

import android.graphics.Bitmap;
import com.bytedance.android.live.soloktv.model.k;
import com.bytedance.android.live.soloktv.util.j;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f100992a = null;

    static {
        f100992a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Bitmap> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.record.c r101 = SoloKtvContext.a.a().getDataStore();
        if (r101 == null) goto L5;
        k r102 = r101.f101453a;
    L6:
        j.f101607a.getClass();
        Bitmap r103 = j.c(r102);
        if (r103 == null) goto L9;
        r100.onNext(r103);
        return;
    L9:
        r100.onError(new Throwable());
        return;
    L5:
        r102 = null;
        goto L6
    }
}
