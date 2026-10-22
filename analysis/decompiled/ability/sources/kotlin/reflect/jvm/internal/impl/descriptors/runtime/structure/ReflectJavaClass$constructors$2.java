package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import S7.k;
import Z7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReference implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$constructors$2 f4981a = new ReflectJavaClass$constructors$2();

    public ReflectJavaClass$constructors$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return AppAgent.CONSTRUCT;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(n8.k.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Constructor p02 = (Constructor) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return new n8.k(p02);
    }
}
