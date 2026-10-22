package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.AbstractC1338a;
import androidx.datastore.preferences.protobuf.AbstractC1338a.AbstractC0164a;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.K;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1338a<MessageType extends AbstractC1338a<MessageType, BuilderType>, BuilderType extends AbstractC0164a<MessageType, BuilderType>> implements K {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0164a<MessageType extends AbstractC1338a<MessageType, BuilderType>, BuilderType extends AbstractC0164a<MessageType, BuilderType>> implements K.a {
        public static <T> void d(Iterable<T> iterable, List<? super T> list) {
            C1359w.a(iterable);
            if (!(iterable instanceof A)) {
                if (iterable instanceof U) {
                    list.addAll((Collection) iterable);
                    return;
                } else {
                    f(iterable, list);
                    return;
                }
            }
            List<?> underlyingElements = ((A) iterable).getUnderlyingElements();
            A a10 = (A) list;
            int size = list.size();
            for (Object obj : underlyingElements) {
                if (obj == null) {
                    String str = "Element at index " + (a10.size() - size) + " is null.";
                    for (int size2 = a10.size() - 1; size2 >= size; size2--) {
                        a10.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    a10.F((ByteString) obj);
                } else {
                    a10.add((String) obj);
                }
            }
        }

        public static <T> void f(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t10 : iterable) {
                if (t10 == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t10);
            }
        }

        public static UninitializedMessageException i(K k10) {
            return new UninitializedMessageException(k10);
        }

        public abstract BuilderType g(MessageType messagetype);

        @Override // androidx.datastore.preferences.protobuf.K.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public BuilderType l(K k10) {
            if (getDefaultInstanceForType().getClass().isInstance(k10)) {
                return (BuilderType) g((AbstractC1338a) k10);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static <T> void b(Iterable<T> iterable, List<? super T> list) {
        AbstractC0164a.d(iterable, list);
    }

    public int c() {
        throw new UnsupportedOperationException();
    }

    public int d(Z z10) {
        int iC = c();
        if (iC != -1) {
            return iC;
        }
        int serializedSize = z10.getSerializedSize(this);
        g(serializedSize);
        return serializedSize;
    }

    public final String e(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException f() {
        return new UninitializedMessageException(this);
    }

    public void g(int i10) {
        throw new UnsupportedOperationException();
    }

    public void h(OutputStream outputStream) throws IOException {
        CodedOutputStream codedOutputStreamF0 = CodedOutputStream.f0(outputStream, CodedOutputStream.I(getSerializedSize()));
        a(codedOutputStreamF0);
        codedOutputStreamF0.c0();
    }

    @Override // androidx.datastore.preferences.protobuf.K
    public ByteString toByteString() {
        try {
            ByteString.g gVarU = ByteString.u(getSerializedSize());
            a(gVarU.b());
            return gVarU.a();
        } catch (IOException e10) {
            throw new RuntimeException(this.e("ByteString"), e10);
        }
    }
}
