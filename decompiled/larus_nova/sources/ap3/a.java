package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowDatabase f15838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15839b;

    public a(WindowDatabase r100, String r101) {
        this.f15838a = r100;
        this.f15839b = r101;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<io.b>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        c r101 = c.f15842a;
        monitor-enter(r101);
        ho.a r102 = this.f15838a.d();     // Catch: Throwable -> L8
        ho.d r103 = (ho.d) r102;     // Catch: Throwable -> L8
        List<io.b> r104 = r103.a(this.f15839b);     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.onNext(r104);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
