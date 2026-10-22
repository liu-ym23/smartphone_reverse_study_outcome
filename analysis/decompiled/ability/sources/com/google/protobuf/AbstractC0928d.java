package com.google.protobuf;

import H8.C0240a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0928d implements W1 {
    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        addAll((Iterable) iterable, (List) collection);
    }

    public static UninitializedMessageException newUninitializedMessageException(X1 x12) {
        return new UninitializedMessageException();
    }

    public final String h(String str) {
        return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
    }

    public abstract AbstractC0928d internalMergeFrom(AbstractC0932e abstractC0932e);

    public boolean mergeDelimitedFrom(InputStream inputStream, R0 r02) throws IOException {
        int i = inputStream.read();
        if (i == -1) {
            return false;
        }
        if ((i & 128) != 0) {
            i &= 127;
            int i6 = 7;
            while (true) {
                if (i6 >= 32) {
                    while (i6 < 64) {
                        int i10 = inputStream.read();
                        if (i10 == -1) {
                            throw InvalidProtocolBufferException.g();
                        }
                        if ((i10 & 128) != 0) {
                            i6 += 7;
                        }
                    }
                    throw InvalidProtocolBufferException.d();
                }
                int i11 = inputStream.read();
                if (i11 == -1) {
                    throw InvalidProtocolBufferException.g();
                }
                i |= (i11 & 127) << i6;
                if ((i11 & 128) == 0) {
                    break;
                }
                i6 += 7;
            }
        }
        mergeFrom((InputStream) new C0240a(inputStream, i, 1), r02);
        return true;
    }

    @Override // com.google.protobuf.W1
    public abstract AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02);

    @Override // 
    public AbstractC0928d mergeFrom(InputStream inputStream) throws IOException {
        AbstractC0972o c0964m;
        if (inputStream == null) {
            byte[] bArr = AbstractC0989s1.c;
            c0964m = AbstractC0972o.h(bArr, 0, bArr.length, false);
        } else {
            c0964m = new C0964m(inputStream);
        }
        mergeFrom(c0964m);
        c0964m.a(0);
        return this;
    }

    /* renamed from: mergeFrom */
    public abstract AbstractC0928d m7320mergeFrom(byte[] bArr, int i, int i6);

    /* renamed from: mergeFrom */
    public abstract AbstractC0928d m7321mergeFrom(byte[] bArr, int i, int i6, R0 r02);

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        Charset charset = AbstractC0989s1.f2940a;
        iterable.getClass();
        if (iterable instanceof InterfaceC1009x1) {
            List underlyingElements = ((InterfaceC1009x1) iterable).getUnderlyingElements();
            InterfaceC1009x1 interfaceC1009x1 = (InterfaceC1009x1) list;
            int size = list.size();
            for (Object obj : underlyingElements) {
                if (obj == null) {
                    String str = "Element at index " + (interfaceC1009x1.size() - size) + " is null.";
                    for (int size2 = interfaceC1009x1.size() - 1; size2 >= size; size2--) {
                        interfaceC1009x1.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof ByteString) {
                    interfaceC1009x1.a((ByteString) obj);
                } else {
                    interfaceC1009x1.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof InterfaceC0959k2) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size3 = list.size();
        for (T t9 : iterable) {
            if (t9 == null) {
                String str2 = "Element at index " + (list.size() - size3) + " is null.";
                for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                    list.remove(size4);
                }
                throw new NullPointerException(str2);
            }
            list.add(t9);
        }
    }

    @Override // 
    public AbstractC0928d mergeFrom(InputStream inputStream, R0 r02) throws IOException {
        AbstractC0972o c0964m;
        if (inputStream == null) {
            byte[] bArr = AbstractC0989s1.c;
            c0964m = AbstractC0972o.h(bArr, 0, bArr.length, false);
        } else {
            c0964m = new C0964m(inputStream);
        }
        mergeFrom(c0964m, r02);
        c0964m.a(0);
        return this;
    }

    public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
        return mergeDelimitedFrom(inputStream, R0.a());
    }

    @Override // 
    public AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o) throws IOException {
        return mergeFrom(abstractC0972o, R0.a());
    }

    @Override // 
    public AbstractC0928d mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
        try {
            AbstractC0972o abstractC0972oJ = byteString.j();
            mergeFrom(abstractC0972oJ);
            abstractC0972oJ.a(0);
            return this;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(h("ByteString"), e6);
        }
    }

    @Override // 
    public AbstractC0928d mergeFrom(ByteString byteString, R0 r02) throws InvalidProtocolBufferException {
        try {
            AbstractC0972o abstractC0972oJ = byteString.j();
            mergeFrom(abstractC0972oJ, r02);
            abstractC0972oJ.a(0);
            return this;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(h("ByteString"), e6);
        }
    }

    @Override // com.google.protobuf.W1
    public AbstractC0928d mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return m7320mergeFrom(bArr, 0, bArr.length);
    }

    @Override // 
    public AbstractC0928d mergeFrom(byte[] bArr, R0 r02) throws InvalidProtocolBufferException {
        return m7321mergeFrom(bArr, 0, bArr.length, r02);
    }

    @Override // 
    public AbstractC0928d mergeFrom(X1 x12) {
        if (getDefaultInstanceForType().getClass().isInstance(x12)) {
            return internalMergeFrom((AbstractC0932e) x12);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
