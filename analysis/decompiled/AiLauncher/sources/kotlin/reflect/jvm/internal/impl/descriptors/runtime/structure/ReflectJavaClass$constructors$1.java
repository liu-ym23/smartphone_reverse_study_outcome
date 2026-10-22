package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class ReflectJavaClass$constructors$1 extends FunctionReferenceImpl implements InterfaceC5074l<Member, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$constructors$1 f35012a = new ReflectJavaClass$constructors$1();

    public ReflectJavaClass$constructors$1() {
        super(1, Member.class, "isSynthetic", "isSynthetic()Z", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final Boolean invoke(Member p02) {
        p.i(p02, "p0");
        return Boolean.valueOf(p02.isSynthetic());
    }
}
