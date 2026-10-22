package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1355s;
import androidx.datastore.preferences.protobuf.C1355s.b;
import java.io.IOException;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1352o<T extends C1355s.b<T>> {
    public abstract int a(Map.Entry<?, ?> entry);

    public abstract Object b(C1351n c1351n, K k10, int i10);

    public abstract C1355s<T> c(Object obj);

    public abstract C1355s<T> d(Object obj);

    public abstract boolean e(K k10);

    public abstract void f(Object obj);

    public abstract <UT, UB> UB g(Y y10, Object obj, C1351n c1351n, C1355s<T> c1355s, UB ub2, f0<UT, UB> f0Var) throws IOException;

    public abstract void h(Y y10, Object obj, C1351n c1351n, C1355s<T> c1355s) throws IOException;

    public abstract void i(ByteString byteString, Object obj, C1351n c1351n, C1355s<T> c1355s) throws IOException;

    public abstract void j(Writer writer, Map.Entry<?, ?> entry) throws IOException;
}
