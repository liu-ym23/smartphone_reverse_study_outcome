package cg3;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f23666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f23667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f23669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f23670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<Boolean, String, Unit> f23671f;

    /* JADX WARN: Multi-variable type inference failed */
    public k(e r100, f r101, String r102, String r103, Object r104, Function2<? super Boolean, ? super String, Unit> r105) {
        Intrinsics.checkNotNullParameter(r105, "onFinished");
        this.f23666a = r100;
        this.f23667b = r101;
        this.f23668c = r102;
        this.f23669d = r103;
        this.f23670e = r104;
        this.f23671f = r105;
    }
}
