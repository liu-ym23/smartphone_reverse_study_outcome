package bv2;

import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IRoomEventHub;
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
public final class d implements com.bytedance.android.livesdk.vscore_api.paidlive.ability.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f20783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f20784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.a f20786e;

    public static final class a implements ttc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20787a;

        public a(d r100) {
            this.f20787a = r100;
        }

        @Override // ttc.b
        public final boolean getAsBoolean() {
            if (this.f20787a.f20782a >= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20788a;

        public b(d r100) {
            this.f20788a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            d r102 = this.f20788a;
            int r103 = r102.f20782a - 1;
            r102.f20782a = r103;
            if (r103 >= 0) goto L8;
            r102.c();
            Function0<Unit> r104 = this.f20788a.f20783b;
            if (r104 == null) goto L9;
            Unit r105 = r104.invoke();
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20789a;

        public c(d r100) {
            this.f20789a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f20789a.release();
        }
    }

    /* JADX INFO: renamed from: bv2.d$d, reason: collision with other inner class name */
    public static final class C0364d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f20790a;

        public C0364d(d r100) {
            this.f20790a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f20790a.release();
        }
    }

    public final void c() {
        this.f20785d = false;
        Disposable r100 = this.f20784c;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f20784c = null;
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    public final void release() {
        this.f20782a = -1;
        this.f20783b = null;
        c();
    }

    public final void a() {
        if (this.f20782a >= 0) goto L5;
        return;
    L5:
        if (this.f20785d == false) goto L7;
        return;
    L7:
        if (this.f20783b == null) goto L16;
        Disposable r100 = this.f20784c;
        if (r100 == null) goto L12;
        r100.dispose();
    L12:
        this.f20784c = Observable.timer(1, TimeUnit.SECONDS).repeatUntil(new a(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this), new C0364d(this));
        this.f20785d = true;
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

    public d(com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f20786e = r100;
        this.f20782a = -1;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.ability.c
    public final void dn(int r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "endTask");
        release();
        this.f20782a = r100;
        this.f20783b = r101;
        Function0<ILivePlayerClient> r102 = this.f20786e.D().a();
        ILivePlayerClient r103 = null;
        if (r102 == null) goto L5;
        ILivePlayerClient r104 = r102.invoke();
    L6:
        if (r104 == null) goto L10;
        IRoomEventHub r105 = r104.getEventHub();
        if (r105 == null) goto L10;
        r105.getStopped().observe(this.f20786e.D().g(), new bv2.a(this));
        r105.getPlaying().observe(this.f20786e.D().g(), new bv2.b(this));
        r105.getReleased().observe(this.f20786e.D().g(), new bv2.c(this));
    L10:
        Function0<ILivePlayerClient> r106 = this.f20786e.D().a();
        if (r106 == null) goto L13;
        r103 = r106.invoke();
    L13:
        if (r103 != null) goto L15;
        return;
    L15:
        if (r103.isPlaying() != true) goto L19;
        a();
        return;
    L19:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
