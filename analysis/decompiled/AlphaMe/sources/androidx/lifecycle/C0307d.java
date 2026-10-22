package androidx.lifecycle;

import Z2.D0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: androidx.lifecycle.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0307d {

    /* renamed from: a, reason: collision with root package name */
    public final C0314k f3919a;

    /* renamed from: b, reason: collision with root package name */
    public final Function2 f3920b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3921c;

    /* renamed from: d, reason: collision with root package name */
    public final Z2.F f3922d;

    /* renamed from: e, reason: collision with root package name */
    public final Function0 f3923e;

    /* renamed from: f, reason: collision with root package name */
    public Z2.o0 f3924f;

    /* renamed from: g, reason: collision with root package name */
    public D0 f3925g;

    public C0307d(C0314k liveData, C0320q block, long j4, d3.f scope, S.A onDone) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(block, "block");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onDone, "onDone");
        this.f3919a = liveData;
        this.f3920b = block;
        this.f3921c = j4;
        this.f3922d = scope;
        this.f3923e = onDone;
    }
}
