package bv2;

import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f implements com.bytedance.android.livesdk.vscore_api.paidlive.ability.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f20793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f20794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f20796e;

    public static final class a implements ttc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20797a;

        public a(f r100) {
            this.f20797a = r100;
        }

        @Override // ttc.b
        public final boolean getAsBoolean() {
            if (this.f20797a.f20792a >= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20798a;

        public b(f r100) {
            this.f20798a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            f r102 = this.f20798a;
            int r103 = r102.f20792a - 1;
            r102.f20792a = r103;
            if (r103 >= 0) goto L8;
            r102.c();
            Function0<Unit> r104 = this.f20798a.f20793b;
            if (r104 == null) goto L9;
            Unit r105 = r104.invoke();
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20799a;

        public c(f r100) {
            this.f20799a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f20799a.release();
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f20800a;

        public d(f r100) {
            this.f20800a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f20800a.release();
        }
    }

    public final void c() {
        this.f20795d = false;
        Disposable r100 = this.f20794c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f20794c = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final void release() {
        this.f20792a = -1;
        this.f20793b = null;
        c();
    }

    public final void a() {
        if (this.f20792a >= 0) goto L5;
        return;
    L5:
        if (this.f20795d == false) goto L7;
        return;
    L7:
        if (this.f20793b == null) goto L16;
        Disposable r100 = this.f20794c;
        if (r100 == null) goto L12;
        r100.dispose();
    L12:
        this.f20794c = Observable.timer(1, TimeUnit.SECONDS).repeatUntil(new a(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this), new d(this));
        this.f20795d = true;
        return;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        release();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.c
    public final void reset() {
        release();
    }

    public f(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f20796e = r100;
        this.f20792a = -1;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.c
    public final void dn(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "endTask");
        release();
        this.f20792a = r100;
        this.f20793b = r101;
        VideoContext r102 = this.f20796e.D().d();
        if (r102 == null) goto L5;
        r102.D0(new e(this));
    L5:
        VideoContext r103 = this.f20796e.D().d();
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.isPlaying() != true) goto L12;
        a();
        return;
    }
}
