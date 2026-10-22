package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class r0<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String[] f135955a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f135956b;

    public r0(String[] r100, String r101) {
        this.f135955a = r100;
        this.f135956b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        ALogger.d("HighlightBacktrackUtil", "调用合成接口");     // Catch: Exception -> L14
        IMiddlewareHostBusiness r101 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);     // Catch: Exception -> L14
        if (r101 == null) goto L6;
        Integer r102 = Integer.valueOf(r101.concatVideo(this.f135955a, this.f135956b));     // Catch: Exception -> L14
    L7:
        if (r102 != null) goto L10;
    L12:
        r100.onError(new RuntimeException("concat failed with result " + r102 + '.'));     // Catch: Exception -> L14
        return;
    L10:
        if (r102.intValue() != 0) goto L12;
        r100.onNext(95);     // Catch: Exception -> L14
        r100.onComplete();     // Catch: Exception -> L14
        return;
    L6:
        r102 = null;
    L14:
        e = move-exception;
        r100.onError(e);
    }
}
