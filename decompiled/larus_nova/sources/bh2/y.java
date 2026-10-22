package bh2;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class y<T> implements am3.c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Constructor<T> f19024a;

    public y(Constructor<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "constructor");
        this.f19024a = r100;
    }

    @Override // am3.c
    public final T decode(am3.g r100) throws Exception {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return this.f19024a.newInstance(new Object[]{r100});
    }
}
