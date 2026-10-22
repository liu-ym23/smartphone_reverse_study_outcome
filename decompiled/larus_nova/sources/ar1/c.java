package ar1;

import am2.b0;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class c extends a<b0> {
    public c() {
    }

    @Override // ar1.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
    }

    @Override // ar1.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        b0 r102 = (b0) r101;
        super.u(r100, r102);
        r100.putAll(r102.a());
    }
}
