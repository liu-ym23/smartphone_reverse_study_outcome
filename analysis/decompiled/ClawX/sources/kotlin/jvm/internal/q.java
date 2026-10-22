package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class q implements l, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int f3679a;

    public q(int i8) {
        this.f3679a = i8;
    }

    @Override // kotlin.jvm.internal.l
    public final int getArity() {
        return this.f3679a;
    }

    public final String toString() {
        z.f3687a.getClass();
        String strA = a0.a(this);
        p.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
