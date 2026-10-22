package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* renamed from: com.google.protobuf.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0924c extends AbstractC0932e implements InterfaceC0919a2 {

    /* renamed from: a, reason: collision with root package name */
    public int f2909a = -1;

    public static Map o(List list) {
        if (list.isEmpty()) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        AbstractC0924c abstractC0924c = (AbstractC0924c) it.next();
        C1004w0 c1004w0E = abstractC0924c.e();
        D0 d0F = c1004w0E.f("key");
        D0 d0F2 = c1004w0E.f("value");
        Object objA = abstractC0924c.a(d0F2);
        if (objA instanceof C0) {
            objA = Integer.valueOf(((C0) objA).f2759a.e);
        }
        map.put(abstractC0924c.a(d0F), objA);
        while (it.hasNext()) {
            AbstractC0924c abstractC0924c2 = (AbstractC0924c) it.next();
            Object objA2 = abstractC0924c2.a(d0F2);
            if (objA2 instanceof C0) {
                objA2 = Integer.valueOf(((C0) objA2).f2759a.e);
            }
            map.put(abstractC0924c2.a(d0F), objA2);
        }
        return map;
    }

    public static int p(int i, Map map) {
        int i6;
        int iA;
        for (Map.Entry entry : map.entrySet()) {
            D0 d02 = (D0) entry.getKey();
            Object value = entry.getValue();
            int i10 = (i * 37) + d02.b.e;
            if (d02.k()) {
                i6 = i10 * 53;
                iA = MapFieldLite.a(o((List) value));
            } else if (d02.g != Descriptors$FieldDescriptor$Type.f) {
                i6 = i10 * 53;
                iA = value.hashCode();
            } else if (d02.isRepeated()) {
                int i11 = i10 * 53;
                Iterator it = ((List) value).iterator();
                int number = 1;
                while (it.hasNext()) {
                    number = (number * 31) + ((InterfaceC0974o1) it.next()).getNumber();
                }
                i = i11 + number;
            } else {
                i6 = i10 * 53;
                iA = ((InterfaceC0974o1) value).getNumber();
            }
            i = iA + i6;
        }
        return i;
    }

    public boolean equals(Object obj) {
        ByteString byteStringE;
        ByteString byteStringE2;
        boolean zEquals;
        ByteString byteStringE3;
        ByteString byteStringE4;
        boolean zEquals2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0924c) {
            AbstractC0924c abstractC0924c = (AbstractC0924c) obj;
            if (e() == abstractC0924c.e()) {
                Map mapB = b();
                Map mapB2 = abstractC0924c.b();
                if (mapB.size() == mapB2.size()) {
                    Iterator it = mapB.keySet().iterator();
                    loop0: while (true) {
                        if (it.hasNext()) {
                            D0 d02 = (D0) it.next();
                            if (!mapB2.containsKey(d02)) {
                                break;
                            }
                            Object obj2 = mapB.get(d02);
                            Object obj3 = mapB2.get(d02);
                            if (d02.g != Descriptors$FieldDescriptor$Type.e) {
                                if (!d02.k()) {
                                    if (!obj2.equals(obj3)) {
                                        break;
                                    }
                                } else {
                                    if (!MapFieldLite.f(o((List) obj2), o((List) obj3))) {
                                        break;
                                    }
                                }
                            } else if (!d02.isRepeated()) {
                                boolean z10 = obj2 instanceof byte[];
                                if (z10 && (obj3 instanceof byte[])) {
                                    zEquals2 = Arrays.equals((byte[]) obj2, (byte[]) obj3);
                                } else {
                                    if (z10) {
                                        byte[] bArr = (byte[]) obj2;
                                        ByteString byteString = ByteString.b;
                                        byteStringE3 = ByteString.e(bArr, 0, bArr.length);
                                    } else {
                                        byteStringE3 = (ByteString) obj2;
                                    }
                                    if (obj3 instanceof byte[]) {
                                        byte[] bArr2 = (byte[]) obj3;
                                        ByteString byteString2 = ByteString.b;
                                        byteStringE4 = ByteString.e(bArr2, 0, bArr2.length);
                                    } else {
                                        byteStringE4 = (ByteString) obj3;
                                    }
                                    zEquals2 = byteStringE3.equals(byteStringE4);
                                }
                                if (!zEquals2) {
                                    break;
                                }
                            } else {
                                List list = (List) obj2;
                                List list2 = (List) obj3;
                                if (list.size() != list2.size()) {
                                    break;
                                }
                                for (int i = 0; i < list.size(); i++) {
                                    Object obj4 = list.get(i);
                                    Object obj5 = list2.get(i);
                                    boolean z11 = obj4 instanceof byte[];
                                    if (z11 && (obj5 instanceof byte[])) {
                                        zEquals = Arrays.equals((byte[]) obj4, (byte[]) obj5);
                                    } else {
                                        if (z11) {
                                            byte[] bArr3 = (byte[]) obj4;
                                            ByteString byteString3 = ByteString.b;
                                            byteStringE = ByteString.e(bArr3, 0, bArr3.length);
                                        } else {
                                            byteStringE = (ByteString) obj4;
                                        }
                                        if (obj5 instanceof byte[]) {
                                            byte[] bArr4 = (byte[]) obj5;
                                            ByteString byteString4 = ByteString.b;
                                            byteStringE2 = ByteString.e(bArr4, 0, bArr4.length);
                                        } else {
                                            byteStringE2 = (ByteString) obj5;
                                        }
                                        zEquals = byteStringE.equals(byteStringE2);
                                    }
                                    if (!zEquals) {
                                        break loop0;
                                    }
                                }
                            }
                        } else if (f().equals(abstractC0924c.f())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final int h() {
        return this.f2909a;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = f().hashCode() + (p(e().hashCode() + 779, b()) * 29);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final UninitializedMessageException k() {
        return AbstractC0916a.x(this);
    }

    @Override // com.google.protobuf.AbstractC0932e
    public final void l(int i) {
        this.f2909a = i;
    }

    public abstract AbstractC0916a q();

    public AbstractC0916a r(C0986r2 c0986r2) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    /* renamed from: s */
    public abstract AbstractC0916a toBuilder();

    public final String toString() {
        Logger logger = E2.f2828a;
        return D2.b.c(this);
    }
}
