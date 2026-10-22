package w0;

import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface k extends m {
    @Override // w0.m
    default boolean a(xb.l lVar) {
        return ((Boolean) lVar.invoke(this)).booleanValue();
    }

    @Override // w0.m
    default Object c(Object obj, p pVar) {
        return pVar.invoke(obj, this);
    }
}
