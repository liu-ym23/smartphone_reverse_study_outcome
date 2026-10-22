package com.bytedance.android.livesdk.ktvimpl.mv;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMvModel f146058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f146059b;

    public g(KtvMvModel r100, String r101) {
        this.f146058a = r100;
        this.f146059b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Function3<? super String, ? super Long, ? super String, Unit> r102 = this.f146058a.f145941f;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(this.f146059b, null, null);
    L5:
        String r104 = "getKtvGroupUser error " + r101.getMessage();
        ALogger.i(bb0.b.b(), r104 + ", invoke class :" + KtvMvModel.class.getSimpleName());
    }
}
