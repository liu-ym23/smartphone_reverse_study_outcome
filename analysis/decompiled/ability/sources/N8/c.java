package N8;

import S7.k;
import g9.l;
import h8.InterfaceC1520c;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes4.dex */
public final class c extends l {
    public final /* synthetic */ int b = 0;
    public final /* synthetic */ k c;
    public final /* synthetic */ Serializable d;

    public c(k kVar, Ref$ObjectRef ref$ObjectRef) {
        this.d = ref$ObjectRef;
        this.c = kVar;
    }

    @Override // g9.l
    public void c(Object obj) {
        switch (this.b) {
            case 0:
                InterfaceC1520c current = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(current, "current");
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.d;
                if (ref$ObjectRef.f4920a == null && ((Boolean) this.c.invoke(current)).booleanValue()) {
                    ref$ObjectRef.f4920a = current;
                    break;
                }
                break;
        }
    }

    @Override // g9.l
    public final boolean d(Object obj) {
        switch (this.b) {
            case 0:
                InterfaceC1520c current = (InterfaceC1520c) obj;
                kotlin.jvm.internal.k.f(current, "current");
                return ((Ref$ObjectRef) this.d).f4920a == null;
            default:
                boolean[] zArr = (boolean[]) this.d;
                if (((Boolean) this.c.invoke(obj)).booleanValue()) {
                    zArr[0] = true;
                }
                return !zArr[0];
        }
    }

    @Override // g9.l
    public final Object k() {
        switch (this.b) {
            case 0:
                return (InterfaceC1520c) ((Ref$ObjectRef) this.d).f4920a;
            default:
                return Boolean.valueOf(((boolean[]) this.d)[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(k kVar, boolean[] zArr) {
        this.c = kVar;
        this.d = zArr;
    }
}
