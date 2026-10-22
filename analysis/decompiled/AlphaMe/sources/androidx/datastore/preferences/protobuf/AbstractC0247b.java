package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0247b {
    protected int memoizedHashCode;

    public abstract int a();

    public final int b(InterfaceC0262i0 interfaceC0262i0) {
        A a4 = (A) this;
        int i4 = a4.memoizedSerializedSize;
        if (i4 != -1) {
            return i4;
        }
        int iG = interfaceC0262i0.g(this);
        a4.memoizedSerializedSize = iG;
        return iG;
    }

    public abstract void c(AbstractC0268o abstractC0268o);
}
