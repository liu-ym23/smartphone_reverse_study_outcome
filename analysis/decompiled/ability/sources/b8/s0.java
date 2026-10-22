package b8;

import h8.InterfaceC1501I;
import h8.InterfaceC1520c;
import h8.InterfaceC1536s;
import java.io.IOException;
import java.util.List;
import k8.AbstractC1644m;

/* loaded from: classes4.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public static final I8.g f2054a = I8.g.c;

    public static void a(InterfaceC1520c interfaceC1520c, StringBuilder sb) {
        k8.u uVarG = v0.g(interfaceC1520c);
        k8.u uVarI = interfaceC1520c.I();
        if (uVarG != null) {
            sb.append(d(uVarG.getType()));
            sb.append(".");
        }
        boolean z10 = (uVarG == null || uVarI == null) ? false : true;
        if (z10) {
            sb.append("(");
        }
        if (uVarI != null) {
            sb.append(d(uVarI.getType()));
            sb.append(".");
        }
        if (z10) {
            sb.append(")");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String b(InterfaceC1536s descriptor) throws IOException {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        a(descriptor, sb);
        G8.f name = ((AbstractC1644m) descriptor).getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        sb.append(f2054a.M(name, true));
        List listX = descriptor.x();
        kotlin.jvm.internal.k.e(listX, "getValueParameters(...)");
        D7.v.H0(listX, sb, ", ", "(", ")", C0841b.h, 48);
        sb.append(": ");
        X8.w returnType = descriptor.getReturnType();
        kotlin.jvm.internal.k.c(returnType);
        sb.append(d(returnType));
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static String c(InterfaceC1501I descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.H() ? "var " : "val ");
        a(descriptor, sb);
        G8.f name = descriptor.getName();
        kotlin.jvm.internal.k.e(name, "getName(...)");
        sb.append(f2054a.M(name, true));
        sb.append(": ");
        X8.w type = descriptor.getType();
        kotlin.jvm.internal.k.e(type, "getType(...)");
        sb.append(d(type));
        String string = sb.toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        return string;
    }

    public static String d(X8.w type) {
        kotlin.jvm.internal.k.f(type, "type");
        return f2054a.W(type);
    }
}
