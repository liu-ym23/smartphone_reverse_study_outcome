package ap3;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.window.base.db.WindowDatabase;
import ho.l;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f15855a = null;

    public static final class a<T> implements ObservableOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WindowDatabase f15856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ io.d f15857b;

        public a(WindowDatabase r100, io.d r101) {
            this.f15856a = r100;
            this.f15857b = r101;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Long> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            i r101 = i.f15855a;
            monitor-enter(r101);
            ho.i r102 = this.f15856a.f();     // Catch: Throwable -> L13
            io.d r103 = this.f15857b;     // Catch: Throwable -> L13
            l r104 = (l) r102;     // Catch: Throwable -> L13
            r104.f486194a.assertNotSuspendingTransaction();     // Catch: Throwable -> L13
            r104.f486194a.beginTransaction();     // Catch: Throwable -> L13
            long r105 = r104.f486195b.insertAndReturnId(r103);     // Catch: Throwable -> L10
            r104.f486194a.setTransactionSuccessful();     // Catch: Throwable -> L10
            r104.f486194a.endTransaction();     // Catch: Throwable -> L13
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(r101);
            r100.onNext(Long.valueOf(r105));
            return;
        L10:
            th = move-exception;
            r104.f486194a.endTransaction();     // Catch: Throwable -> L13
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    public i() {
    }

    static {
        f15855a = new i();
    }

    public static Observable a(io.d r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        WindowDatabase r101 = go.a.f481867b.a();
        if (r101 == null) goto L7;
        return Observable.create(new a(r101, r100));
    L7:
        return Observable.just(-1L);
    }
}
