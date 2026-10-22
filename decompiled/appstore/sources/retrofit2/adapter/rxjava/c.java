package retrofit2.adapter.rxjava;

import retrofit2.Call;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call f23992a;

    public c(Call r10) {
        this.f23992a = r10;
    }

    public void a(Subscriber r10) {
        Call r11 = this.f23992a.mo73clone();
        CallArbiter r12 = new CallArbiter(r11, r10);
        r10.add(r12);
        r10.setProducer(r12);
        r12.emitResponse(r11.execute());
        return;
    L6:
        th = move-exception;
        rx.exceptions.a.e(th);
        r12.emitError(th);
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
