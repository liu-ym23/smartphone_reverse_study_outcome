package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import K9.s;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReferenceImpl implements InterfaceC5074l<Constructor<?>, s> {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$constructors$2 f35013a = new ReflectJavaClass$constructors$2();

    public ReflectJavaClass$constructors$2() {
        super(1, s.class, "<init>", "<init>(Ljava/lang/reflect/Constructor;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final s invoke(Constructor<?> p02) {
        p.i(p02, "p0");
        return new s(p02);
    }
}
