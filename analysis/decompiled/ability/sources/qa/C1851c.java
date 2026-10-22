package qa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: qa.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1851c extends C1849a {
    @Override // qa.C1849a
    public final List a(Executor executor) {
        return Arrays.asList(new C1857i(), new C1861m(executor));
    }

    @Override // qa.C1849a
    public final List b() {
        return Collections.singletonList(new C1850b(1));
    }
}
