package ap3;

import com.bytedance.android.ec.window.base.db.WindowDatabase;
import ho.l;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h<T> implements ObservableOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WindowDatabase f15852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f15854c;

    public h(WindowDatabase r100, String r101, String r102) {
        this.f15852a = r100;
        this.f15853b = r101;
        this.f15854c = r102;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<List<io.d>> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        CollectionsKt.emptyList();
        i r101 = i.f15855a;
        monitor-enter(r101);
        ho.i r102 = this.f15852a.f();     // Catch: Throwable -> L8
        l r103 = (l) r102;     // Catch: Throwable -> L8
        List<io.d> r104 = r103.a(this.f15853b, this.f15854c);     // Catch: Throwable -> L8
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        r100.onNext(r104);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
