package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.a.AbstractC0012a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0012a<MessageType, BuilderType>> implements i0 {
    protected int memoizedHashCode = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0012a<MessageType extends a<MessageType, BuilderType>, BuilderType extends AbstractC0012a<MessageType, BuilderType>> implements j0, Cloneable {
    }

    public int a() {
        throw new UnsupportedOperationException();
    }

    public final int g(w0 w0Var) {
        int iA = a();
        if (iA != -1) {
            return iA;
        }
        int iC = w0Var.c(this);
        h(iC);
        return iC;
    }

    public void h(int i10) {
        throw new UnsupportedOperationException();
    }
}
