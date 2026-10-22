package com.google.protobuf;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class D2 {
    public static final D2 b;

    /* renamed from: a, reason: collision with root package name */
    public final G2 f2764a;

    static {
        int i = G2.b;
        b = new D2(F2.f2830a);
    }

    public D2(G2 g22) {
        this.f2764a = g22;
    }

    public static void d(int i, int i6, List list, C1012y0 c1012y0) throws InvalidProtocolBufferException {
        for (Object obj : list) {
            c1012y0.h(String.valueOf(i));
            c1012y0.h(": ");
            int i10 = i6 & 7;
            if (i10 == 0) {
                long jLongValue = ((Long) obj).longValue();
                Logger logger = E2.f2828a;
                c1012y0.h(jLongValue >= 0 ? Long.toString(jLongValue) : BigInteger.valueOf(jLongValue & Long.MAX_VALUE).setBit(63).toString());
            } else if (i10 == 1) {
                c1012y0.h(String.format(null, "0x%016x", (Long) obj));
            } else if (i10 == 2) {
                try {
                    ByteString byteString = (ByteString) obj;
                    I2 i2G = M2.g();
                    try {
                        AbstractC0972o abstractC0972oJ = byteString.j();
                        i2G.n(abstractC0972oJ);
                        abstractC0972oJ.a(0);
                        M2 m2K = i2G.k();
                        c1012y0.h("{");
                        c1012y0.c();
                        ((StringBuilder) c1012y0.c).append("  ");
                        e(m2K, c1012y0);
                        c1012y0.g();
                        c1012y0.h("}");
                    } catch (InvalidProtocolBufferException e) {
                        throw e;
                    } catch (IOException e6) {
                        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e6);
                    }
                } catch (InvalidProtocolBufferException unused) {
                    c1012y0.h("\"");
                    Logger logger2 = E2.f2828a;
                    c1012y0.h(AbstractC1002v2.u((ByteString) obj));
                    c1012y0.h("\"");
                }
            } else if (i10 == 3) {
                e((M2) obj, c1012y0);
            } else {
                if (i10 != 5) {
                    throw new IllegalArgumentException(B7.a.h(i6, "Bad tag: "));
                }
                c1012y0.h(String.format(null, "0x%08x", (Integer) obj));
            }
            c1012y0.c();
        }
    }

    public static void e(M2 m2, C1012y0 c1012y0) {
        for (Map.Entry entry : ((Map) m2.f2854a.clone()).entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            K2 k22 = (K2) entry.getValue();
            d(iIntValue, 0, k22.f2849a, c1012y0);
            d(iIntValue, 5, k22.b, c1012y0);
            d(iIntValue, 1, k22.c, c1012y0);
            d(iIntValue, 2, k22.d, c1012y0);
            for (M2 m22 : k22.e) {
                c1012y0.h(((Integer) entry.getKey()).toString());
                c1012y0.h(" {");
                c1012y0.c();
                ((StringBuilder) c1012y0.c).append("  ");
                e(m22, c1012y0);
                c1012y0.g();
                c1012y0.h("}");
                c1012y0.c();
            }
        }
    }

    public final void a(InterfaceC0919a2 interfaceC0919a2, C1012y0 c1012y0) throws InvalidProtocolBufferException {
        if (interfaceC0919a2.e().b.equals("google.protobuf.Any")) {
            C1004w0 c1004w0E = interfaceC0919a2.e();
            D0 d0G = c1004w0E.g(1);
            D0 d0G2 = c1004w0E.g(2);
            if (d0G != null && d0G.g == Descriptors$FieldDescriptor$Type.b && d0G2 != null && d0G2.g == Descriptors$FieldDescriptor$Type.e) {
                String str = (String) interfaceC0919a2.a(d0G);
                if (!str.isEmpty()) {
                    Object objA = interfaceC0919a2.a(d0G2);
                    try {
                        this.f2764a.getClass();
                        String[] strArrSplit = str.split("/");
                        if (strArrSplit.length <= 1) {
                            throw new InvalidProtocolBufferException("Invalid type url found: ".concat(str));
                        }
                        C1004w0 c1004w0 = (C1004w0) Collections.EMPTY_MAP.get(strArrSplit[strArrSplit.length - 1]);
                        if (c1004w0 != null) {
                            L0 l02 = new L0(M0.t(c1004w0).b);
                            l02.u((ByteString) objA);
                            c1012y0.h("[");
                            c1012y0.h(str);
                            c1012y0.h("] {");
                            c1012y0.c();
                            ((StringBuilder) c1012y0.c).append("  ");
                            a(l02, c1012y0);
                            c1012y0.g();
                            c1012y0.h("}");
                            c1012y0.c();
                            return;
                        }
                    } catch (InvalidProtocolBufferException unused) {
                    }
                }
            }
        }
        for (Map.Entry entry : interfaceC0919a2.b().entrySet()) {
            D0 d02 = (D0) entry.getKey();
            Object value = entry.getValue();
            if (d02.k()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    arrayList.add(new C2(d02, it.next()));
                }
                Collections.sort(arrayList);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    C2 c2 = (C2) it2.next();
                    Object obj = c2.b;
                    if (obj == null) {
                        obj = c2.f2760a;
                    }
                    b(d02, obj, c1012y0);
                }
            } else if (d02.isRepeated()) {
                Iterator it3 = ((List) value).iterator();
                while (it3.hasNext()) {
                    b(d02, it3.next(), c1012y0);
                }
            } else {
                b(d02, value, c1012y0);
            }
        }
        e(interfaceC0919a2.f(), c1012y0);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.protobuf.D0 r7, java.lang.Object r8, com.google.protobuf.C1012y0 r9) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.D2.b(com.google.protobuf.D0, java.lang.Object, com.google.protobuf.y0):void");
    }

    public final String c(InterfaceC0919a2 interfaceC0919a2) {
        try {
            StringBuilder sb = new StringBuilder();
            Logger logger = E2.f2828a;
            a(interfaceC0919a2, new C1012y0(sb));
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
