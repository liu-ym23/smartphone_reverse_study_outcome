package com.bytedance.android.live.saas.middleware.utuid;

import android.app.Application;
import com.bytedance.android.dy.saas.utuid.e;
import com.bytedance.android.dy.saas.utuid.f;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.base.ISdkInitTask;
import com.bytedance.android.live.saas.middleware.monitor.IMonitorReport;
import com.bytedance.android.live.saas.middleware.utuid.network.NetworkUtUidImpl;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J>\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u001c\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00100\u000fJ\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/utuid/UtUidInitTask;", "Lcom/bytedance/android/live/saas/middleware/base/ISdkInitTask;", "Lcom/bytedance/android/dy/saas/utuid/e;", "", "success", "", "thr", "", "reportUtUidResult", "Landroid/app/Application;", "app", "params", "init", "", a.KEY_DID, "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "idSubject", "fetchFromNet", "unInit", "Lio/reactivex/disposables/Disposable;", "disposable", "Lio/reactivex/disposables/Disposable;", "<init>", "()V", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class UtUidInitTask implements ISdkInitTask<e> {
    private Disposable disposable;

    public UtUidInitTask() {
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public void unInit() {
        Disposable r100 = this.disposable;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    private final void reportUtUidResult(boolean r110, Throwable r111) {
        JSONObject r100 = new JSONObject();
        r100.put("success", r110 ? 1 : 0);
        if (r111 == null) goto L5;
        r100.put("msg", r111.getMessage());
        r100.put("stacktrace", ArraysKt.joinToString$default(r111.getStackTrace(), "\n", null, null, 0, null, C99611.INSTANCE, 30, null));
    L5:
        IMonitorReport r112 = BDLiveSdk.getMonitor();
        if (r112 == null) goto L9;
        r112.monitorCommonLog("livesdk_utuid_status", r100);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.bytedance.android.live.saas.middleware.utuid.UtUidInitTask$init$1] */
    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(final Application r100, final e r101) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "params");
        if (StringsKt.isBlank(r101.f42647d) == false) goto L6;
        r101.f42647d = "pangle_235429";
    L6:
        if (StringsKt.isBlank(r101.f42648e) == false) goto L8;
        r101.f42648e = "2c8a3fd7a52b1d5d15597b1908169ccd";
    L8:
        boolean r102 = f.f42651a;
        f.f42657g = new NetworkUtUidImpl();
        f.f(r100, r101, new C99601(this, r100, r101));
    }

    @Override // com.bytedance.android.live.saas.middleware.base.ISdkInitTask
    public /* bridge */ /* synthetic */ void init(Application r100, e r101) {
        init2(r100, r101);
    }

    public static final /* synthetic */ void access$reportUtUidResult(UtUidInitTask r100, boolean r101, Throwable r102) {
        r100.reportUtUidResult(r101, r102);
    }

    public final void fetchFromNet(final Application r100, final e r101, String r102, PublishSubject<Pair<String, String>> r103) {
        Intrinsics.checkNotNullParameter(r100, "app");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r103, "idSubject");
        if (r102 != null) goto L5;
    L10:
        this.disposable = r103.filter(AnonymousClass1.INSTANCE).subscribe(new AnonymousClass2(r100, r101));
        return;
    L5:
        if (r102.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        boolean r105 = f.f42651a;
        f.e(r100, r101, r102);
        return;
    L7:
        r104 = false;
        goto L8
    }

    public static /* synthetic */ void reportUtUidResult$default(UtUidInitTask r100, boolean r101, Throwable r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.reportUtUidResult(r101, r102);
    }
}
