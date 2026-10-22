package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1353p extends AbstractC1352o<GeneratedMessageLite.d> {

    /* renamed from: androidx.datastore.preferences.protobuf.p$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13626a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13626a = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13626a[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13626a[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13626a[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13626a[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13626a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13626a[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13626a[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13626a[WireFormat.FieldType.UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13626a[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13626a[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13626a[WireFormat.FieldType.SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13626a[WireFormat.FieldType.SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13626a[WireFormat.FieldType.ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13626a[WireFormat.FieldType.BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13626a[WireFormat.FieldType.STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13626a[WireFormat.FieldType.GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13626a[WireFormat.FieldType.MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).getNumber();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public Object b(C1351n c1351n, K k10, int i10) {
        return c1351n.a(k10, i10);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public C1355s<GeneratedMessageLite.d> c(Object obj) {
        return ((GeneratedMessageLite.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public C1355s<GeneratedMessageLite.d> d(Object obj) {
        return ((GeneratedMessageLite.c) obj).C();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public boolean e(K k10) {
        return k10 instanceof GeneratedMessageLite.c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public void f(Object obj) {
        c(obj).t();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public <UT, UB> UB g(Y y10, Object obj, C1351n c1351n, C1355s<GeneratedMessageLite.d> c1355s, UB ub2, f0<UT, UB> f0Var) throws IOException {
        Object objI;
        ArrayList arrayList;
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        int iC = eVar.c();
        Object objH = null;
        if (eVar.f13456b.isRepeated() && eVar.f13456b.isPacked()) {
            switch (a.f13626a[eVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    y10.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    y10.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    y10.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    y10.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    y10.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    y10.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    y10.readFixed32List(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    y10.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    y10.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    y10.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    y10.readSFixed64List(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    y10.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    y10.readSInt64List(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    y10.readEnumList(arrayList);
                    eVar.f13456b.b();
                    ub2 = (UB) b0.z(iC, arrayList, null, ub2, f0Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f13456b.getLiteType());
            }
            c1355s.x(eVar.f13456b, arrayList);
            return ub2;
        }
        if (eVar.a() == WireFormat.FieldType.ENUM) {
            y10.readInt32();
            eVar.f13456b.b();
            throw null;
        }
        int[] iArr = a.f13626a;
        switch (iArr[eVar.a().ordinal()]) {
            case 1:
                objH = Double.valueOf(y10.readDouble());
                break;
            case 2:
                objH = Float.valueOf(y10.readFloat());
                break;
            case 3:
                objH = Long.valueOf(y10.readInt64());
                break;
            case 4:
                objH = Long.valueOf(y10.readUInt64());
                break;
            case 5:
                objH = Integer.valueOf(y10.readInt32());
                break;
            case 6:
                objH = Long.valueOf(y10.readFixed64());
                break;
            case 7:
                objH = Integer.valueOf(y10.readFixed32());
                break;
            case 8:
                objH = Boolean.valueOf(y10.readBool());
                break;
            case 9:
                objH = Integer.valueOf(y10.readUInt32());
                break;
            case 10:
                objH = Integer.valueOf(y10.readSFixed32());
                break;
            case 11:
                objH = Long.valueOf(y10.readSFixed64());
                break;
            case 12:
                objH = Integer.valueOf(y10.readSInt32());
                break;
            case 13:
                objH = Long.valueOf(y10.readSInt64());
                break;
            case 14:
                throw new IllegalStateException("Shouldn't reach here.");
            case 15:
                objH = y10.readBytes();
                break;
            case 16:
                objH = y10.readString();
                break;
            case 17:
                objH = y10.e(eVar.b().getClass(), c1351n);
                break;
            case 18:
                objH = y10.d(eVar.b().getClass(), c1351n);
                break;
        }
        if (eVar.d()) {
            c1355s.a(eVar.f13456b, objH);
            return ub2;
        }
        int i10 = iArr[eVar.a().ordinal()];
        if ((i10 == 17 || i10 == 18) && (objI = c1355s.i(eVar.f13456b)) != null) {
            objH = C1359w.h(objI, objH);
        }
        c1355s.x(eVar.f13456b, objH);
        return ub2;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public void h(Y y10, Object obj, C1351n c1351n, C1355s<GeneratedMessageLite.d> c1355s) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        c1355s.x(eVar.f13456b, y10.d(eVar.b().getClass(), c1351n));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public void i(ByteString byteString, Object obj, C1351n c1351n, C1355s<GeneratedMessageLite.d> c1355s) throws IOException {
        GeneratedMessageLite.e eVar = (GeneratedMessageLite.e) obj;
        K kBuildPartial = eVar.b().newBuilderForType().buildPartial();
        AbstractC1342e abstractC1342eH = AbstractC1342e.h(ByteBuffer.wrap(byteString.A()), true);
        V.a().b(kBuildPartial, abstractC1342eH, c1351n);
        c1355s.x(eVar.f13456b, kBuildPartial);
        if (abstractC1342eH.getFieldNumber() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.a();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC1352o
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (!dVar.isRepeated()) {
            switch (a.f13626a[dVar.getLiteType().ordinal()]) {
                case 1:
                    writer.writeDouble(dVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    writer.writeFloat(dVar.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    writer.writeInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    writer.writeUInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    writer.writeInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    writer.writeFixed64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    writer.writeFixed32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    writer.writeBool(dVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    writer.writeUInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    writer.writeSFixed32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    writer.writeSFixed64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    writer.writeSInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    writer.writeSInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    writer.writeInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    writer.b(dVar.getNumber(), (ByteString) entry.getValue());
                    break;
                case 16:
                    writer.writeString(dVar.getNumber(), (String) entry.getValue());
                    break;
                case 17:
                    writer.e(dVar.getNumber(), entry.getValue(), V.a().d(entry.getValue().getClass()));
                    break;
                case 18:
                    writer.c(dVar.getNumber(), entry.getValue(), V.a().d(entry.getValue().getClass()));
                    break;
            }
        }
        switch (a.f13626a[dVar.getLiteType().ordinal()]) {
            case 1:
                b0.P(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 2:
                b0.T(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 3:
                b0.W(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 4:
                b0.e0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 5:
                b0.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 6:
                b0.S(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 7:
                b0.R(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 8:
                b0.N(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 9:
                b0.d0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 10:
                b0.Y(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 11:
                b0.Z(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 12:
                b0.a0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 13:
                b0.b0(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 14:
                b0.V(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                break;
            case 15:
                b0.O(dVar.getNumber(), (List) entry.getValue(), writer);
                break;
            case 16:
                b0.c0(dVar.getNumber(), (List) entry.getValue(), writer);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    b0.U(dVar.getNumber(), (List) entry.getValue(), writer, V.a().d(list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    b0.X(dVar.getNumber(), (List) entry.getValue(), writer, V.a().d(list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }
}
