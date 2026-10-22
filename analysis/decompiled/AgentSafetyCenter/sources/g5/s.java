package g5;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class s {
    public static r a() {
        h hVar = h.f4318b;
        r rVar = new r();
        rVar.f4337a = hVar;
        VarHandle.storeStoreFence();
        return rVar;
    }
}
