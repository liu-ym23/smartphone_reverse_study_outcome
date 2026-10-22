package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import S7.k;
import Z7.f;
import java.lang.reflect.Member;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.m;

/* loaded from: classes4.dex */
final /* synthetic */ class ReflectJavaClass$fields$1 extends FunctionReference implements k {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$fields$1 f4982a = new ReflectJavaClass$fields$1();

    public ReflectJavaClass$fields$1() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, Z7.c
    public final String getName() {
        return "isSynthetic";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final f getOwner() {
        return m.f4928a.b(Member.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "isSynthetic()Z";
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        Member p02 = (Member) obj;
        kotlin.jvm.internal.k.f(p02, "p0");
        return Boolean.valueOf(p02.isSynthetic());
    }
}
