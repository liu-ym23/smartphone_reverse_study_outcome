package y0;

import B0.r;
import kotlin.jvm.internal.Intrinsics;
import z0.AbstractC0998f;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0998f f16170a;

    public d(AbstractC0998f tracker) {
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f16170a = tracker;
    }

    public abstract int a();

    public abstract boolean b(r rVar);

    public abstract boolean c(Object obj);
}
