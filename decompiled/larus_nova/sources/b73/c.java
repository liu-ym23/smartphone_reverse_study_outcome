package b73;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f17933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f17935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f17936d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Object> f17937e;

    public c(b r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "creator");
        this.f17936d = r100;
        this.f17937e = r101;
    }
}
