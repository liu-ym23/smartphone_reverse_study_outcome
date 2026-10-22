package q0;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

/* renamed from: q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0955b implements U {

    /* renamed from: a, reason: collision with root package name */
    public static final C0955b f19755a = new C0955b();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) throws IOException {
        e0 e0Var = c0946i.f19676k;
        if (obj instanceof LongAdder) {
            e0Var.L('{', "value", ((LongAdder) obj).longValue());
            e0Var.write(125);
        } else if (obj instanceof DoubleAdder) {
            e0Var.G('{', "value", ((DoubleAdder) obj).doubleValue());
            e0Var.write(125);
        }
    }
}
