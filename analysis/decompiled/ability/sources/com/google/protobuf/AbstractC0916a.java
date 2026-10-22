package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: com.google.protobuf.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0916a extends AbstractC0928d implements InterfaceC0919a2 {
    public static UninitializedMessageException x(AbstractC0924c abstractC0924c) {
        ArrayList arrayList = new ArrayList();
        AbstractC1002v2.w(abstractC0924c, "", arrayList);
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        Iterator it = arrayList.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return new UninitializedMessageException(sb.toString());
    }

    public abstract AbstractC0916a A(M2 m2);

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d internalMergeFrom(AbstractC0932e abstractC0932e) {
        return r((AbstractC0924c) abstractC0932e);
    }

    public abstract AbstractC0916a j(D0 d02, Object obj);

    public abstract AbstractC0924c k();

    public abstract AbstractC0924c m();

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o) {
        return mergeFrom(abstractC0972o, O0.h);
    }

    public void n() {
        throw new IllegalStateException("Should be overridden by subclasses.");
    }

    public AbstractC0916a o(D0 d02) {
        throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }

    public I2 p() {
        M2 m2F = f();
        I2 i2G = M2.g();
        i2G.o(m2F);
        return i2G;
    }

    public void q() {
        throw new IllegalStateException("Should be overridden by subclasses.");
    }

    public AbstractC0916a r(AbstractC0924c abstractC0924c) {
        Map mapB = abstractC0924c.b();
        if (abstractC0924c.e() != e()) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        for (Map.Entry entry : mapB.entrySet()) {
            D0 d02 = (D0) entry.getKey();
            if (d02.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    j(d02, it.next());
                }
            } else if (d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                AbstractC0924c abstractC0924c2 = (AbstractC0924c) a(d02);
                if (abstractC0924c2 == abstractC0924c2.getDefaultInstanceForType()) {
                    y(d02, entry.getValue());
                } else {
                    y(d02, abstractC0924c2.q().t(abstractC0924c2).t((AbstractC0924c) entry.getValue()).k());
                }
            } else {
                y(d02, entry.getValue());
            }
        }
        v(abstractC0924c.f());
        return this;
    }

    @Override // com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        abstractC0972o.getClass();
        I2 i2P = p();
        C0923b2 c0923b2 = new C0923b2(this);
        C1004w0 c1004w0E = e();
        while (true) {
            int iD = abstractC0972o.D();
            if (iD == 0) {
                break;
            }
            AbstractC0972o abstractC0972o2 = abstractC0972o;
            R0 r03 = r02;
            if (!AbstractC1002v2.D(abstractC0972o2, i2P, r03, c1004w0E, c0923b2, iD)) {
                break;
            }
            abstractC0972o = abstractC0972o2;
            r02 = r03;
        }
        if (i2P != null) {
            z(i2P);
        }
        return this;
    }

    public /* bridge */ AbstractC0916a t(AbstractC0924c abstractC0924c) {
        return r(abstractC0924c);
    }

    public final String toString() {
        Logger logger = E2.f2828a;
        return D2.b.c(this);
    }

    public final void u(ByteString byteString) {
    }

    public void v(M2 m2) {
        M2 m2F = f();
        I2 i2G = M2.g();
        i2G.o(m2F);
        i2G.o(m2);
        A(i2G.k());
    }

    public abstract AbstractC0916a w(D0 d02);

    public abstract AbstractC0916a y(D0 d02, Object obj);

    public void z(I2 i22) {
        A(i22.k());
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(AbstractC0972o abstractC0972o) {
        return mergeFrom(abstractC0972o, O0.h);
    }

    @Override // com.google.protobuf.AbstractC0928d
    /* renamed from: mergeFrom */
    public final AbstractC0928d m7320mergeFrom(byte[] bArr, int i, int i6) throws InvalidProtocolBufferException {
        try {
            C0960l c0960lH = AbstractC0972o.h(bArr, 0, i6, false);
            mergeFrom((AbstractC0972o) c0960lH);
            c0960lH.a(0);
            return this;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(h("byte array"), e6);
        }
    }

    @Override // com.google.protobuf.AbstractC0928d
    /* renamed from: mergeFrom */
    public final AbstractC0928d m7321mergeFrom(byte[] bArr, int i, int i6, R0 r02) throws InvalidProtocolBufferException {
        try {
            C0960l c0960lH = AbstractC0972o.h(bArr, 0, i6, false);
            mergeFrom((AbstractC0972o) c0960lH, r02);
            c0960lH.a(0);
            return this;
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new RuntimeException(h("byte array"), e6);
        }
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final /* bridge */ /* synthetic */ W1 mergeFrom(X1 x12) {
        return mergeFrom(x12);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(ByteString byteString) {
        return (AbstractC0916a) super.mergeFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(ByteString byteString) {
        return (AbstractC0916a) super.mergeFrom(byteString);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(ByteString byteString, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(byteString, r02);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(ByteString byteString, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(byteString, r02);
    }

    @Override // com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final AbstractC0928d mergeFrom(byte[] bArr) {
        return (AbstractC0916a) super.mergeFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final W1 mergeFrom(byte[] bArr) {
        return (AbstractC0916a) super.mergeFrom(bArr);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(byte[] bArr, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(bArr, r02);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(byte[] bArr, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(bArr, r02);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(InputStream inputStream) {
        return (AbstractC0916a) super.mergeFrom(inputStream);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(InputStream inputStream) {
        return (AbstractC0916a) super.mergeFrom(inputStream);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final AbstractC0928d mergeFrom(InputStream inputStream, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(inputStream, r02);
    }

    @Override // com.google.protobuf.AbstractC0928d
    public final W1 mergeFrom(InputStream inputStream, R0 r02) {
        return (AbstractC0916a) super.mergeFrom(inputStream, r02);
    }
}
