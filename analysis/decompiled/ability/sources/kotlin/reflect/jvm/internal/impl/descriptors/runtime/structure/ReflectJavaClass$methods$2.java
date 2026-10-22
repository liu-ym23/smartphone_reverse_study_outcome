package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import S7.k;
import Z7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.lang.reflect.Method;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;
import n8.q;

/* loaded from: classes4.dex */
final /* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReference implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$methods$2 f4984a = new ReflectJavaClass$methods$2();

    public ReflectJavaClass$methods$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return AppAgent.CONSTRUCT;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(q.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Method p02 = (Method) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return new q(p02);
    }
}
