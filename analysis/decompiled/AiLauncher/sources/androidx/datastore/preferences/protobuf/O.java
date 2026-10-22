package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1355s;
import androidx.datastore.preferences.protobuf.C1360x;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class O<T> implements Z<T> {

    /* renamed from: a, reason: collision with root package name */
    public final K f13481a;

    /* renamed from: b, reason: collision with root package name */
    public final f0<?, ?> f13482b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13483c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1352o<?> f13484d;

    public O(f0<?, ?> f0Var, AbstractC1352o<?> abstractC1352o, K k10) {
        this.f13482b = f0Var;
        this.f13483c = abstractC1352o.e(k10);
        this.f13484d = abstractC1352o;
        this.f13481a = k10;
    }

    private <UT, UB> int c(f0<UT, UB> f0Var, T t10) {
        return f0Var.i(f0Var.g(t10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <UT, UB, ET extends C1355s.b<ET>> void d(f0<UT, UB> f0Var, AbstractC1352o<ET> abstractC1352o, T t10, Y y10, C1351n c1351n) throws Throwable {
        f0<UT, UB> f0Var2;
        UB ubF = f0Var.f(t10);
        Object objD = abstractC1352o.d(t10);
        while (y10.getFieldNumber() != Integer.MAX_VALUE) {
            try {
                O o10 = this;
                f0Var2 = f0Var;
                AbstractC1352o<ET> abstractC1352o2 = abstractC1352o;
                Y y11 = y10;
                C1351n c1351n2 = c1351n;
                try {
                    if (!o10.f(y11, c1351n2, abstractC1352o2, objD, f0Var2, ubF)) {
                        f0Var2.o(t10, ubF);
                        return;
                    }
                    this = o10;
                    y10 = y11;
                    c1351n = c1351n2;
                    abstractC1352o = abstractC1352o2;
                    f0Var = f0Var2;
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    f0Var2.o(t10, ubF);
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                f0Var2 = f0Var;
            }
        }
        f0Var.o(t10, ubF);
    }

    public static <T> O<T> e(f0<?, ?> f0Var, AbstractC1352o<?> abstractC1352o, K k10) {
        return new O<>(f0Var, abstractC1352o, k10);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void a(T t10, Y y10, C1351n c1351n) throws Throwable {
        d(this.f13482b, this.f13484d, t10, y10, c1351n);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void b(T t10, Writer writer) throws IOException {
        Iterator itS = this.f13484d.c(t10).s();
        while (itS.hasNext()) {
            Map.Entry entry = (Map.Entry) itS.next();
            C1355s.b bVar = (C1355s.b) entry.getKey();
            if (bVar.getLiteJavaType() != WireFormat.JavaType.MESSAGE || bVar.isRepeated() || bVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof C1360x.b) {
                writer.writeMessageSetItem(bVar.getNumber(), ((C1360x.b) entry).a().e());
            } else {
                writer.writeMessageSetItem(bVar.getNumber(), entry.getValue());
            }
        }
        g(this.f13482b, t10, writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public boolean equals(T t10, T t11) {
        if (!this.f13482b.g(t10).equals(this.f13482b.g(t11))) {
            return false;
        }
        if (this.f13483c) {
            return this.f13484d.c(t10).equals(this.f13484d.c(t11));
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends C1355s.b<ET>> boolean f(Y y10, C1351n c1351n, AbstractC1352o<ET> abstractC1352o, C1355s<ET> c1355s, f0<UT, UB> f0Var, UB ub2) throws IOException {
        int tag = y10.getTag();
        if (tag != WireFormat.f13495a) {
            if (WireFormat.b(tag) != 2) {
                return y10.skipField();
            }
            Object objB = abstractC1352o.b(c1351n, this.f13481a, WireFormat.a(tag));
            if (objB == null) {
                return f0Var.m(ub2, y10);
            }
            abstractC1352o.h(y10, objB, c1351n, c1355s);
            return true;
        }
        Object objB2 = null;
        int uInt32 = 0;
        ByteString bytes = null;
        while (y10.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = y10.getTag();
            if (tag2 == WireFormat.f13497c) {
                uInt32 = y10.readUInt32();
                objB2 = abstractC1352o.b(c1351n, this.f13481a, uInt32);
            } else if (tag2 == WireFormat.f13498d) {
                if (objB2 != null) {
                    abstractC1352o.h(y10, objB2, c1351n, c1355s);
                } else {
                    bytes = y10.readBytes();
                }
            } else if (!y10.skipField()) {
                break;
            }
        }
        if (y10.getTag() != WireFormat.f13496b) {
            throw InvalidProtocolBufferException.a();
        }
        if (bytes != null) {
            if (objB2 != null) {
                abstractC1352o.i(bytes, objB2, c1351n, c1355s);
            } else {
                f0Var.d(ub2, uInt32, bytes);
            }
        }
        return true;
    }

    public final <UT, UB> void g(f0<UT, UB> f0Var, T t10, Writer writer) throws IOException {
        f0Var.s(f0Var.g(t10), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public int getSerializedSize(T t10) {
        int iC = c(this.f13482b, t10);
        return this.f13483c ? iC + this.f13484d.c(t10).j() : iC;
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public int hashCode(T t10) {
        int iHashCode = this.f13482b.g(t10).hashCode();
        return this.f13483c ? (iHashCode * 53) + this.f13484d.c(t10).hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public final boolean isInitialized(T t10) {
        return this.f13484d.c(t10).p();
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void makeImmutable(T t10) {
        this.f13482b.j(t10);
        this.f13484d.f(t10);
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public void mergeFrom(T t10, T t11) {
        b0.G(this.f13482b, t10, t11);
        if (this.f13483c) {
            b0.E(this.f13484d, t10, t11);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Z
    public T newInstance() {
        return (T) this.f13481a.newBuilderForType().buildPartial();
    }
}
