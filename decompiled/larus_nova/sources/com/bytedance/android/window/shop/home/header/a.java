package com.bytedance.android.window.shop.home.header;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.k;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f188204a;

    public a(JSONObject r100) {
        this.f188204a = r100;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<k> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ECHybridListDTO r101 = (ECHybridListDTO) u0.b(this.f188204a.toString(), ECHybridListDTO.class);     // Catch: Exception -> L5
        r100.onNext(ECHybridListDTO.a.e(ECHybridListDTO.Companion, r101));     // Catch: Exception -> L5
    L7:
        r100.onComplete();
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r100.onError(e);
        goto L7
    }
}
