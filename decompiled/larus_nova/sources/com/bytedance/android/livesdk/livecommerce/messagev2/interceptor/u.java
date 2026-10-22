package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v.a f149444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f149445b;

    public u(v.a r100, String r101) {
        this.f149444a = r100;
        this.f149445b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        File[] r101 = new PolarisFileWrapper(this.f149445b).listFiles();     // Catch: Exception -> L16
        if (r101 == null) goto L15;
        if (r101.length != 0) goto L8;
        boolean r102 = true;
    L10:
        if ((!r102) == false) goto L15;
        if (r101[0].isFile() == false) goto L15;
        this.f149444a.f149449b.onNext(r101[0]);     // Catch: Exception -> L16
        return;
    L8:
        r102 = false;
    L15:
        throw new IllegalStateException("folder has no image , path：" + this.f149445b);     // Catch: Exception -> L16
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        this.f149444a.f149449b.tryOnError(e);
    }
}
