package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC0481a;
import androidx.datastore.preferences.protobuf.AbstractC0481a.AbstractC0126a;
import androidx.datastore.preferences.protobuf.AbstractC0488h;
import androidx.datastore.preferences.protobuf.S;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0481a<MessageType extends AbstractC0481a<MessageType, BuilderType>, BuilderType extends AbstractC0126a<MessageType, BuilderType>> implements S {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0126a<MessageType extends AbstractC0481a<MessageType, BuilderType>, BuilderType extends AbstractC0126a<MessageType, BuilderType>> implements S.a {
        protected static <T> void l(Iterable<T> iterable, List<? super T> list) {
            A.a(iterable);
            if (!(iterable instanceof G)) {
                if (iterable instanceof b0) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    n(iterable, list);
                    return;
                }
            }
            List<?> listG = ((G) iterable).g();
            G g5 = (G) list;
            int size = list.size();
            for (Object obj : listG) {
                if (obj == null) {
                    String str = "Element at index " + (g5.size() - size) + " is null.";
                    for (int size2 = g5.size() - 1; size2 >= size; size2--) {
                        g5.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof AbstractC0488h) {
                    g5.e((AbstractC0488h) obj);
                } else {
                    g5.add((String) obj);
                }
            }
        }

        private static <T> void n(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t5 : iterable) {
                if (t5 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t5);
            }
        }

        protected static n0 s(S s5) {
            return new n0(s5);
        }

        protected abstract BuilderType p(MessageType messagetype);

        @Override // androidx.datastore.preferences.protobuf.S.a
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public BuilderType f(S s5) {
            if (b().getClass().isInstance(s5)) {
                return (BuilderType) p((AbstractC0481a) s5);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        AbstractC0126a.l(iterable, list);
    }

    private String m(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    int c() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.S
    public AbstractC0488h e() {
        try {
            AbstractC0488h.C0127h c0127hS = AbstractC0488h.s(g());
            h(c0127hS.b());
            return c0127hS.a();
        } catch (IOException e6) {
            throw new RuntimeException(this.m("ByteString"), e6);
        }
    }

    int l(h0 h0Var) {
        int iC = c();
        if (iC != -1) {
            return iC;
        }
        int iG = h0Var.g(this);
        o(iG);
        return iG;
    }

    n0 n() {
        return new n0(this);
    }

    void o(int i5) {
        throw new UnsupportedOperationException();
    }

    public void p(OutputStream outputStream) {
        AbstractC0491k abstractC0491kF0 = AbstractC0491k.f0(outputStream, AbstractC0491k.I(g()));
        h(abstractC0491kF0);
        abstractC0491kF0.c0();
    }
}
