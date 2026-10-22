package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements Observable.OnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Call f23989a;

    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallArbiter f23990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f23991b;

        public a(b r10, CallArbiter r11) {
            this.f23991b = r10;
            this.f23990a = r11;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call r10, Throwable r11) {
            rx.exceptions.a.e(r11);
            this.f23990a.emitError(r11);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call r10, Response r11) {
            this.f23990a.emitResponse(r11);
        }
    }

    public b(Call r10) {
        this.f23989a = r10;
    }

    public void a(Subscriber r10) {
        Call r11 = this.f23989a.mo73clone();
        CallArbiter r12 = new CallArbiter(r11, r10);
        r10.add(r12);
        r10.setProducer(r12);
        r11.enqueue(new a(this, r12));
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Subscriber r10) {
        a(r10);
    }
}
