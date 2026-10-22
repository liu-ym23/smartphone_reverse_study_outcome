package h5;

import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h extends g implements l {
    private final int arity;

    public h(int i8, f5.c cVar) {
        super(cVar);
        this.arity = i8;
    }

    @Override // kotlin.jvm.internal.l
    public int getArity() {
        return this.arity;
    }

    @Override // h5.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        z.f3687a.getClass();
        String strA = a0.a(this);
        p.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
