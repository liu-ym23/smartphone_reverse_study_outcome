package ar1;

import am2.a0;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends a<a0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a0 f16002c;

    public b() {
    }

    @Override // ar1.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        a0 r101 = (a0) r100;
        this.f16002c = r101;
        if (r101 == null) goto L6;
        putAll(r101.a());
        return;
    }

    @Override // ar1.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        a0 r102 = (a0) r101;
        super.u(r100, r102);
        r100.putAll(r102.a());
    }
}
