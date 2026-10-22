package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowDatabase f15843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f15845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f15846d;

    public d(WindowDatabase r100, String r101, String r102, String r103) {
        this.f15843a = r100;
        this.f15844b = r101;
        this.f15845c = r102;
        this.f15846d = r103;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<io.c>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        g r101 = g.f15851a;
        monitor-enter(r101);
        ho.e r102 = this.f15843a.e();     // Catch: Throwable -> L8
        ho.h r103 = (ho.h) r102;     // Catch: Throwable -> L8
        List<io.c> r104 = r103.a(this.f15844b, this.f15845c, this.f15846d);     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.onNext(r104);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
