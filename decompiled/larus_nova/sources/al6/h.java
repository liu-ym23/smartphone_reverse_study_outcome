package al6;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f4148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bl6.b f4150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, Float> f4151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f4152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f4153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f4154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f4155h;

    public h() {
        b r100 = new b();
        e r101 = new e();
        c r102 = new c();
        a r103 = new a(null);
        Intrinsics.checkNotNullParameter(r100, "comboManager");
        Intrinsics.checkNotNullParameter(r101, "scoreStatsManager");
        Intrinsics.checkNotNullParameter(r102, "rawDataParser");
        Intrinsics.checkNotNullParameter(r103, "scoreTypeEvaluator");
        this.f4152e = r100;
        this.f4153f = r101;
        this.f4154g = r102;
        this.f4155h = r103;
        this.f4151d = new LinkedHashMap();
    }
}
