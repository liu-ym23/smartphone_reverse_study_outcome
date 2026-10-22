package s0;

import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import t0.C0917c;

/* renamed from: s0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0844b {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f14170a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f14171b;

    /* renamed from: c, reason: collision with root package name */
    public final y1.f f14172c;

    /* renamed from: d, reason: collision with root package name */
    public final J f14173d;

    /* renamed from: e, reason: collision with root package name */
    public final v f14174e;

    /* renamed from: f, reason: collision with root package name */
    public final C0917c f14175f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14176g;

    /* renamed from: h, reason: collision with root package name */
    public final int f14177h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14178i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14179j;

    public C0844b(com.google.android.gms.common.internal.f builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f14170a = com.airbnb.lottie.h.a(false);
        this.f14171b = com.airbnb.lottie.h.a(true);
        this.f14172c = new y1.f();
        String str = K.f14166a;
        J j4 = new J();
        Intrinsics.checkNotNullExpressionValue(j4, "getDefaultWorkerFactory()");
        this.f14173d = j4;
        this.f14174e = v.f14221h;
        this.f14175f = new C0917c();
        this.f14176g = 4;
        this.f14177h = Integer.MAX_VALUE;
        this.f14179j = 20;
        this.f14178i = 8;
    }
}
