package cc3;

import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.r0;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class i implements Observer<r0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zb3.b f23236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f23237b;

    @Override // io.reactivex.Observer
    public final void onComplete() {
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Intrinsics.checkNotNullParameter(r100, "d");
    }

    @Override // io.reactivex.Observer
    public final void onNext(r0 r110) {
        r0 r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "t");
        if (this.f23236a.f571131b != 1) goto L5;
        boolean r100 = true;
    L7:
        if (r111.a() != 0) goto L16;
        zb3.b r112 = this.f23236a;
        if (r100 == false) goto L11;
        long r101 = r112.f571132c + 1;
    L12:
        Function1 r102 = this.f23237b;
        if (r102 == null) goto L15;
        Unit r113 = (Unit) r102.invoke(new zb3.a(String.valueOf(r112.f571130a), r100, r101, 8));
    L15:
        s0.a(new vb3.a(this.f23236a.f571130a, r100, r101));
        return;
    L11:
        r101 = r112.f571132c - 1;
        goto L12
    L16:
        Function1 r114 = this.f23237b;
        if (r114 == null) goto L21;
        Unit r115 = (Unit) r114.invoke(new zb3.a(String.valueOf(this.f23236a.f571130a), !r100, this.f23236a.f571132c, 8));
        return;
    L21:
        return;
    L5:
        r100 = false;
        goto L7
    }

    public i(zb3.b r100, Function1 r101) {
        this.f23236a = r100;
        this.f23237b = r101;
    }
}
