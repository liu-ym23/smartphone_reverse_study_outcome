package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements Observable.Operator, Func2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Func1 f24220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Func2 f24221b;

    public class a extends Subscriber {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f24222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f24223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Subscriber f24224c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i f24225d;

        public a(i r10, Subscriber r11, Subscriber r12) {
            this.f24225d = r10;
            this.f24224c = r12;
            super(r11);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.f24224c.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.f24224c.onError(r10);
        }

        @Override // rx.Observer
        public void onNext(Object r10) {
            Object r11 = this.f24225d.f24220a.call(r10);     // Catch: Throwable -> L14
            Object r12 = this.f24222a;
            this.f24222a = r11;
            if (this.f24223b == true) goto L17;
            this.f24223b = true;
            this.f24224c.onNext(r10);
            return;
        L17:
            if (((Boolean) this.f24225d.f24221b.call(r12, r11)).booleanValue() == true) goto L8;
            this.f24224c.onNext(r10);
            return;
        L8:
            request(1);
            return;
        L9:
            th = move-exception;
            rx.exceptions.a.g(th, this.f24224c, r11);
            return;
        L14:
            th = move-exception;
            rx.exceptions.a.g(th, this.f24224c, r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f24226a = null;

        static {
            f24226a = new i(UtilityFunctions.b());
        }
    }

    public i(Func1 r10) {
        this.f24220a = r10;
        this.f24221b = this;
    }

    public static i c() {
        return b.f24226a;
    }

    public Boolean a(Object r10, Object r11) {
        if (r10 == r11) goto L8;
        if (r10 != null) goto L5;
    L7:
        boolean r12 = false;
    L10:
        return Boolean.valueOf(r12);
    L5:
        if (r10.equals(r11) == false) goto L7;
    L8:
        r12 = true;
        goto L10
    }

    public Subscriber b(Subscriber r10) {
        return new a(this, r10, r10);
    }

    @Override // rx.functions.Func1
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber r10) {
        return b(r10);
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Object call(Object r10, Object r11) {
        return a(r10, r11);
    }
}
