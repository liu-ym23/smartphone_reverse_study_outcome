package ak5;

import io.reactivex.functions.Function;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public final class r<T extends Serializable> implements Function<String, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s<T> f4049a;

    public r(s<T> r100) {
        this.f4049a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(String r100) throws Exception {
        s<T> r101 = this.f4049a;
        return r101.parse(r100);
    }
}
