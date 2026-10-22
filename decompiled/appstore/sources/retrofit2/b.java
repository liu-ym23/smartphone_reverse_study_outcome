package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends CallAdapter.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CallAdapter.a f24006a = null;

    public class a implements CallAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f24007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f24008b;

        public a(b r10, Type r11) {
            this.f24008b = r10;
            this.f24007a = r11;
        }

        public Call a(Call r10) {
            return r10;
        }

        @Override // retrofit2.CallAdapter
        public /* bridge */ /* synthetic */ Object adapt(Call r10) {
            return a(r10);
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.f24007a;
        }
    }

    static {
        f24006a = new b();
    }

    public b() {
    }

    @Override // retrofit2.CallAdapter.a
    public CallAdapter a(Type r10, Annotation[] r11, Retrofit r12) {
        if (CallAdapter.a.c(r10) == Call.class) goto L7;
        return null;
    L7:
        return new a(this, i.g(r10));
    }
}
