package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.Observable;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements CallAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f23997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jg.a f23998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f23999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f24000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f24002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24003g;

    public f(Type r10, jg.a r11, boolean r12, boolean r13, boolean r14, boolean r15, boolean r16) {
        this.f23997a = r10;
        this.f23998b = r11;
        this.f23999c = r12;
        this.f24000d = r13;
        this.f24001e = r14;
        this.f24002f = r15;
        this.f24003g = r16;
    }

    @Override // retrofit2.CallAdapter
    public Object adapt(Call r10) {
        if (this.f23999c == false) goto L5;
        Observable.OnSubscribe r11 = new b(r10);
    L7:
        if (this.f24000d == false) goto L11;
        Observable.OnSubscribe r12 = new e(r11);
    L9:
        r11 = r12;
    L13:
        Observable r13 = Observable.b(r11);
        jg.a r14 = this.f23998b;
        if (r14 == null) goto L17;
        r13 = r13.s(r14);
    L17:
        if (this.f24002f == false) goto L21;
        return r13.x();
    L21:
        if (this.f24003g == true) goto L23;
        return r13;
    L23:
        return r13.w();
    L11:
        if (this.f24001e == false) goto L13;
        r12 = new a(r11);
        goto L9
    L5:
        r11 = new c(r10);
        goto L7
    }

    @Override // retrofit2.CallAdapter
    public Type responseType() {
        return this.f23997a;
    }
}
