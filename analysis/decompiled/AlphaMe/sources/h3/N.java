package h3;

import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class N {

    /* renamed from: a, reason: collision with root package name */
    public final k3.l f12737a;

    /* renamed from: b, reason: collision with root package name */
    public M f12738b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f12739c;

    public N() {
        String boundary = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(boundary, "randomUUID().toString()");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        k3.l lVar = k3.l.f13358d;
        this.f12737a = C0611u.k(boundary);
        this.f12738b = P.f12742e;
        this.f12739c = new ArrayList();
    }
}
