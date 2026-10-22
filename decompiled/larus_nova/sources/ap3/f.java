package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowDatabase f15849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.c f15850b;

    public f(WindowDatabase r100, io.c r101) {
        this.f15849a = r100;
        this.f15850b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        g r101 = g.f15851a;
        monitor-enter(r101);
        ho.e r102 = this.f15849a.e();     // Catch: Throwable -> L13
        io.c r103 = this.f15850b;     // Catch: Throwable -> L13
        ho.h r104 = (ho.h) r102;     // Catch: Throwable -> L13
        r104.f486191a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f486191a.beginTransaction();     // Catch: Throwable -> L13
        int r105 = r104.f486193c.handle(r103) + 0;     // Catch: Throwable -> L10
        r104.f486191a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f486191a.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Integer.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f486191a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
