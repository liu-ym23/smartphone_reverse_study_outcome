package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import ca.AbstractC0897f;
import g8.n;
import g9.l;
import h8.InterfaceC1522e;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a extends l {
    public final /* synthetic */ String b;
    public final /* synthetic */ Ref$ObjectRef c;

    public a(String str, Ref$ObjectRef ref$ObjectRef) {
        this.b = str;
        this.c = ref$ObjectRef;
    }

    @Override // g9.l
    public final boolean d(Object obj) {
        InterfaceC1522e javaClassDescriptor = (InterfaceC1522e) obj;
        k.f(javaClassDescriptor, "javaClassDescriptor");
        String strK = AbstractC0897f.K(javaClassDescriptor, this.b);
        boolean zContains = n.b.contains(strK);
        Ref$ObjectRef ref$ObjectRef = this.c;
        if (zContains) {
            ref$ObjectRef.f4920a = JvmBuiltInsCustomizer$JDKMemberStatus.f4948a;
        } else if (n.d.contains(strK)) {
            ref$ObjectRef.f4920a = JvmBuiltInsCustomizer$JDKMemberStatus.b;
        } else if (n.c.contains(strK)) {
            ref$ObjectRef.f4920a = JvmBuiltInsCustomizer$JDKMemberStatus.c;
        } else if (n.f4499a.contains(strK)) {
            ref$ObjectRef.f4920a = JvmBuiltInsCustomizer$JDKMemberStatus.e;
        }
        return ref$ObjectRef.f4920a == null;
    }

    @Override // g9.l
    public final Object k() {
        JvmBuiltInsCustomizer$JDKMemberStatus jvmBuiltInsCustomizer$JDKMemberStatus = (JvmBuiltInsCustomizer$JDKMemberStatus) this.c.f4920a;
        return jvmBuiltInsCustomizer$JDKMemberStatus == null ? JvmBuiltInsCustomizer$JDKMemberStatus.d : jvmBuiltInsCustomizer$JDKMemberStatus;
    }
}
