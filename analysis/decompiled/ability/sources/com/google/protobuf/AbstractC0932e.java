package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;

/* renamed from: com.google.protobuf.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0932e implements X1 {
    protected int memoizedHashCode = 0;

    public static void g(ByteString byteString) {
        if (!byteString.i()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    public abstract int h();

    public int i(InterfaceC0979p2 interfaceC0979p2) {
        int iH = h();
        if (iH != -1) {
            return iH;
        }
        int iB = interfaceC0979p2.b(this);
        l(iB);
        return iB;
    }

    public final String j(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public UninitializedMessageException k() {
        return new UninitializedMessageException();
    }

    public abstract void l(int i);

    public final byte[] m() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            C0980q c0980q = new C0980q(bArr, serializedSize);
            c(c0980q);
            if (serializedSize - c0980q.f == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(j("byte array"), e);
        }
    }

    public final ByteString n() {
        try {
            int serializedSize = getSerializedSize();
            ByteString byteString = ByteString.b;
            byte[] bArr = new byte[serializedSize];
            C0980q c0980q = new C0980q(bArr, serializedSize);
            c(c0980q);
            if (c0980q.e - c0980q.f == 0) {
                return new ByteString.LiteralByteString(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(j("ByteString"), e);
        }
    }
}
