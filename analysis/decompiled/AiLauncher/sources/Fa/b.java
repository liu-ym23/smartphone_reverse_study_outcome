package Fa;

import Fa.g;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class b {
    public final g a(kotlin.reflect.jvm.internal.impl.descriptors.e functionDescriptor) {
        kotlin.jvm.internal.p.i(functionDescriptor, "functionDescriptor");
        for (h hVar : b()) {
            if (hVar.b(functionDescriptor)) {
                return hVar.a(functionDescriptor);
            }
        }
        return g.a.f2638b;
    }

    public abstract List<h> b();
}
