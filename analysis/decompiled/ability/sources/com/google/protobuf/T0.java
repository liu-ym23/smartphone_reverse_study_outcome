package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class T0 extends S0 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f2875a;
    public static final /* synthetic */ int b = 0;

    static {
        f2875a = W2.c.l(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("c"));
    }

    @Override // com.google.protobuf.S0
    public final int a(Map.Entry entry) {
        return ((D0) entry.getKey()).b.e;
    }

    @Override // com.google.protobuf.S0
    public final void b(R0 r02, X1 x12, int i) {
        if (((O0) r02).f.get(new N0(((AbstractC0924c) x12).e(), i)) != null) {
            throw new ClassCastException();
        }
    }

    @Override // com.google.protobuf.S0
    public final Y0 c(Object obj) {
        return (Y0) W2.c.k(obj, f2875a);
    }

    @Override // com.google.protobuf.S0
    public final Y0 d(Object obj) {
        Y0 y0C = c(obj);
        if (!y0C.b) {
            return y0C;
        }
        Y0 y0Clone = y0C.clone();
        W2.p(obj, f2875a, y0Clone);
        return y0Clone;
    }

    @Override // com.google.protobuf.S0
    public final boolean e(X1 x12) {
        return x12 instanceof GeneratedMessageV3.ExtendableMessage;
    }

    @Override // com.google.protobuf.S0
    public final void f(Object obj) {
        c(obj).q();
    }

    @Override // com.google.protobuf.S0
    public final void g(F1 f12, Map.Entry entry) throws CodedOutputStream$OutOfSpaceException {
        D0 d02 = (D0) entry.getKey();
        boolean zIsRepeated = d02.isRepeated();
        DescriptorProtos$FieldDescriptorProto descriptorProtos$FieldDescriptorProto = d02.b;
        int i = 0;
        if (zIsRepeated) {
            switch (d02.h().ordinal()) {
                case 0:
                    AbstractC0983q2.q(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 1:
                    AbstractC0983q2.u(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 2:
                    AbstractC0983q2.w(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 3:
                    AbstractC0983q2.D(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 4:
                    AbstractC0983q2.v(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 5:
                    AbstractC0983q2.t(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 6:
                    AbstractC0983q2.s(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 7:
                    AbstractC0983q2.o(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 8:
                    AbstractC0983q2.B(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12);
                    break;
                case 9:
                    int i6 = descriptorProtos$FieldDescriptorProto.e;
                    List list = (List) entry.getValue();
                    Class cls = AbstractC0983q2.f2936a;
                    if (list != null && !list.isEmpty()) {
                        f12.getClass();
                        while (i < list.size()) {
                            ((C0980q) f12.b).c0(i6, (X1) list.get(i));
                            i++;
                        }
                        break;
                    }
                    break;
                case 10:
                    int i10 = descriptorProtos$FieldDescriptorProto.e;
                    List list2 = (List) entry.getValue();
                    Class cls2 = AbstractC0983q2.f2936a;
                    if (list2 != null && !list2.isEmpty()) {
                        f12.getClass();
                        while (i < list2.size()) {
                            ((C0980q) f12.b).f0(i10, (X1) list2.get(i));
                            i++;
                        }
                        break;
                    }
                    break;
                case 11:
                    AbstractC0983q2.p(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12);
                    break;
                case 12:
                    AbstractC0983q2.C(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 13:
                    List list3 = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((C0) it.next()).f2759a.e));
                    }
                    AbstractC0983q2.v(descriptorProtos$FieldDescriptorProto.e, arrayList, f12, d02.isPacked());
                    break;
                case 14:
                    AbstractC0983q2.x(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 15:
                    AbstractC0983q2.y(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 16:
                    AbstractC0983q2.z(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
                case 17:
                    AbstractC0983q2.A(descriptorProtos$FieldDescriptorProto.e, (List) entry.getValue(), f12, d02.isPacked());
                    break;
            }
        }
        switch (d02.h().ordinal()) {
            case 0:
                int i11 = descriptorProtos$FieldDescriptorProto.e;
                double dDoubleValue = ((Double) entry.getValue()).doubleValue();
                C0980q c0980q = (C0980q) f12.b;
                c0980q.getClass();
                c0980q.a0(i11, Double.doubleToRawLongBits(dDoubleValue));
                break;
            case 1:
                int i12 = descriptorProtos$FieldDescriptorProto.e;
                float fFloatValue = ((Float) entry.getValue()).floatValue();
                C0980q c0980q2 = (C0980q) f12.b;
                c0980q2.getClass();
                c0980q2.Y(i12, Float.floatToRawIntBits(fFloatValue));
                break;
            case 2:
                ((C0980q) f12.b).m0(descriptorProtos$FieldDescriptorProto.e, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                ((C0980q) f12.b).m0(descriptorProtos$FieldDescriptorProto.e, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                ((C0980q) f12.b).d0(descriptorProtos$FieldDescriptorProto.e, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                ((C0980q) f12.b).a0(descriptorProtos$FieldDescriptorProto.e, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                ((C0980q) f12.b).Y(descriptorProtos$FieldDescriptorProto.e, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                ((C0980q) f12.b).W(descriptorProtos$FieldDescriptorProto.e, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                int i13 = descriptorProtos$FieldDescriptorProto.e;
                String str = (String) entry.getValue();
                C0980q c0980q3 = (C0980q) f12.b;
                c0980q3.k0(i13, 2);
                c0980q3.j0(str);
                break;
            case 9:
                ((C0980q) f12.b).c0(descriptorProtos$FieldDescriptorProto.e, (X1) entry.getValue());
                break;
            case 10:
                ((C0980q) f12.b).f0(descriptorProtos$FieldDescriptorProto.e, (X1) entry.getValue());
                break;
            case 11:
                ((C0980q) f12.b).X(descriptorProtos$FieldDescriptorProto.e, (ByteString) entry.getValue());
                break;
            case 12:
                int i14 = descriptorProtos$FieldDescriptorProto.e;
                int iIntValue = ((Integer) entry.getValue()).intValue();
                C0980q c0980q4 = (C0980q) f12.b;
                c0980q4.k0(i14, 0);
                c0980q4.l0(iIntValue);
                break;
            case 13:
                ((C0980q) f12.b).d0(descriptorProtos$FieldDescriptorProto.e, ((C0) entry.getValue()).f2759a.e);
                break;
            case 14:
                ((C0980q) f12.b).Y(descriptorProtos$FieldDescriptorProto.e, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                ((C0980q) f12.b).a0(descriptorProtos$FieldDescriptorProto.e, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                int i15 = descriptorProtos$FieldDescriptorProto.e;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                C0980q c0980q5 = (C0980q) f12.b;
                c0980q5.k0(i15, 0);
                c0980q5.l0((iIntValue2 >> 31) ^ (iIntValue2 << 1));
                break;
            case 17:
                int i16 = descriptorProtos$FieldDescriptorProto.e;
                long jLongValue = ((Long) entry.getValue()).longValue();
                ((C0980q) f12.b).m0(i16, (jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }
}
