package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import K9.y;
import java.lang.reflect.Method;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReferenceImpl implements InterfaceC5074l<Method, y> {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$methods$2 f35016a = new ReflectJavaClass$methods$2();

    public ReflectJavaClass$methods$2() {
        super(1, y.class, "<init>", "<init>(Ljava/lang/reflect/Method;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final y invoke(Method p02) {
        p.i(p02, "p0");
        return new y(p02);
    }
}
