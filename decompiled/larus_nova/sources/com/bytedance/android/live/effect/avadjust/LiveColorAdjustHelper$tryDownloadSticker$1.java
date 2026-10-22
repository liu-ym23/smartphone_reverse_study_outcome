package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/l$b;", "callback", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "sticker", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/live/effect/avadjust/l$b;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", "notifyDownloadResultUiThread"}, k = 3, mv = {1, 4, 3})
final class LiveColorAdjustHelper$tryDownloadSticker$1 extends Lambda implements Function2<l.b, Sticker, Unit> {
    final /* synthetic */ boolean $uiThread;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Sticker f66832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l.b f66833b;

        public a(Sticker r100, l.b r101) {
            this.f66832a = r100;
            this.f66833b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L19;
            throw th;
        L19:
            return;
        L3:
            if (this.f66832a == null) goto L7;
            l.b r100 = this.f66833b;     // Catch: Throwable -> L11
            if (r100 == null) goto L16;
            r100.onSuccess();     // Catch: Throwable -> L11
        L16:
            return;
        L7:
            l.b r101 = this.f66833b;     // Catch: Throwable -> L11
            if (r101 == null) goto L16;
            r101.onError();     // Catch: Throwable -> L11
            goto L16
        }
    }

    public LiveColorAdjustHelper$tryDownloadSticker$1(boolean r100) {
        this.$uiThread = r100;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(l.b r100, Sticker r101) {
        if (this.$uiThread == false) goto L9;
        if (r101 == null) goto L7;
        if (r100 == null) goto L11;
        r100.onSuccess();
        return;
    L11:
        return;
    L7:
        if (r100 == null) goto L13;
        r100.onError();
        return;
    L13:
        return;
    L9:
        AndroidSchedulers.mainThread().scheduleDirect(new a(r101, r100));
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(l.b r100, Sticker r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
