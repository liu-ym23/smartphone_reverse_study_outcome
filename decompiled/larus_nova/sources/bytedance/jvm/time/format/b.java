package bytedance.jvm.time.format;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f.b f21641d;

    public b(f.b r100) {
        this.f21641d = r100;
    }

    @Override // bytedance.jvm.time.format.f
    public final Iterator<Map.Entry<String, Long>> e(bytedance.jvm.time.temporal.j r100, TextStyle r101, Locale r102) {
        return this.f21641d.b(r101);
    }

    @Override // bytedance.jvm.time.format.f
    public final String c(bytedance.jvm.time.temporal.j r100, long r101, TextStyle r102, Locale r103) {
        return this.f21641d.a(r101, r102);
    }

    @Override // bytedance.jvm.time.format.f
    public final Iterator<Map.Entry<String, Long>> d(bytedance.jvm.time.chrono.j r100, bytedance.jvm.time.temporal.j r101, TextStyle r102, Locale r103) {
        return this.f21641d.b(r102);
    }

    @Override // bytedance.jvm.time.format.f
    public final String b(bytedance.jvm.time.chrono.j r100, bytedance.jvm.time.temporal.j r101, long r102, TextStyle r103, Locale r104) {
        return this.f21641d.a(r102, r103);
    }
}
