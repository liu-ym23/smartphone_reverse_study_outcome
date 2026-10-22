package q8;

import h8.InterfaceC1536s;
import k8.AbstractC1644m;

/* renamed from: q8.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1831d extends z {
    public static final /* synthetic */ int l = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final InterfaceC1536s a(InterfaceC1536s functionDescriptor) {
        kotlin.jvm.internal.k.f(functionDescriptor, "functionDescriptor");
        G8.f name = ((AbstractC1644m) functionDescriptor).getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        if (b(name)) {
            return (InterfaceC1536s) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(functionDescriptor, C1830c.b);
        }
        return null;
    }

    public static boolean b(G8.f fVar) {
        kotlin.jvm.internal.k.f(fVar, "<this>");
        return z.e.contains(fVar);
    }
}
