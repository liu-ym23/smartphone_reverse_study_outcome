package ak5;

import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class t implements Function<l, k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f4051b;

    @Override // io.reactivex.functions.Function
    public final k apply(l r100) throws Exception {
        k r101 = new k();
        r101.f4034a = r100;
        r101.f4035b = this.f4050a;
        Map<String, String> r102 = this.f4051b;
        ((HashMap) r101.f4036c).putAll(r102);
        return r101;
    }

    public t(boolean r100, Map<String, String> r101) {
        HashMap r102 = new HashMap();
        this.f4051b = r102;
        this.f4050a = r100;
        r102.putAll(r101);
    }
}
