package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowDatabase f15840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ io.b f15841b;

    public b(WindowDatabase r100, io.b r101) {
        this.f15840a = r100;
        this.f15841b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Long> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        c r101 = c.f15842a;
        monitor-enter(r101);
        ho.a r102 = this.f15840a.d();     // Catch: Throwable -> L13
        io.b r103 = this.f15841b;     // Catch: Throwable -> L13
        ho.d r104 = (ho.d) r102;     // Catch: Throwable -> L13
        r104.f486189a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
        r104.f486189a.beginTransaction();     // Catch: Throwable -> L13
        long r105 = r104.f486190b.insertAndReturnId(r103);     // Catch: Throwable -> L10
        r104.f486189a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r104.f486189a.endTransaction();     // Catch: Throwable -> L13
        monitor-exit(r101);
        r100.onNext(Long.valueOf(r105));
        return;
    L10:
        th = move-exception;
        r104.f486189a.endTransaction();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }
}
