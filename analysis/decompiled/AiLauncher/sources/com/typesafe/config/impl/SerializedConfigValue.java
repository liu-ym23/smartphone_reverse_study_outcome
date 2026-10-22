package com.typesafe.config.impl;

import b8.InterfaceC1455a;
import b8.InterfaceC1461g;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigValueType;
import com.typesafe.config.impl.ConfigString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
class SerializedConfigValue extends AbstractConfigValue implements Externalizable {

    /* renamed from: b, reason: collision with root package name */
    public b8.p f31807b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f31808c;

    public enum SerializedField {
        UNKNOWN,
        END_MARKER,
        ROOT_VALUE,
        ROOT_WAS_CONFIG,
        VALUE_DATA,
        VALUE_ORIGIN,
        ORIGIN_DESCRIPTION,
        ORIGIN_LINE_NUMBER,
        ORIGIN_END_LINE_NUMBER,
        ORIGIN_TYPE,
        ORIGIN_URL,
        ORIGIN_COMMENTS,
        ORIGIN_NULL_URL,
        ORIGIN_NULL_COMMENTS,
        ORIGIN_RESOURCE,
        ORIGIN_NULL_RESOURCE;

        public static SerializedField forInt(int i10) {
            return i10 < values().length ? values()[i10] : UNKNOWN;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class SerializedValueType {
        private static final /* synthetic */ SerializedValueType[] $VALUES;
        public static final SerializedValueType BOOLEAN;
        public static final SerializedValueType DOUBLE;
        public static final SerializedValueType INT;
        public static final SerializedValueType LIST;
        public static final SerializedValueType LONG;
        public static final SerializedValueType NULL;
        public static final SerializedValueType OBJECT;
        public static final SerializedValueType STRING;
        ConfigValueType configType;

        static {
            SerializedValueType serializedValueType = new SerializedValueType("NULL", 0, ConfigValueType.NULL);
            NULL = serializedValueType;
            SerializedValueType serializedValueType2 = new SerializedValueType("BOOLEAN", 1, ConfigValueType.BOOLEAN);
            BOOLEAN = serializedValueType2;
            ConfigValueType configValueType = ConfigValueType.NUMBER;
            SerializedValueType serializedValueType3 = new SerializedValueType("INT", 2, configValueType);
            INT = serializedValueType3;
            SerializedValueType serializedValueType4 = new SerializedValueType("LONG", 3, configValueType);
            LONG = serializedValueType4;
            SerializedValueType serializedValueType5 = new SerializedValueType("DOUBLE", 4, configValueType);
            DOUBLE = serializedValueType5;
            SerializedValueType serializedValueType6 = new SerializedValueType("STRING", 5, ConfigValueType.STRING);
            STRING = serializedValueType6;
            SerializedValueType serializedValueType7 = new SerializedValueType("LIST", 6, ConfigValueType.LIST);
            LIST = serializedValueType7;
            SerializedValueType serializedValueType8 = new SerializedValueType("OBJECT", 7, ConfigValueType.OBJECT);
            OBJECT = serializedValueType8;
            $VALUES = new SerializedValueType[]{serializedValueType, serializedValueType2, serializedValueType3, serializedValueType4, serializedValueType5, serializedValueType6, serializedValueType7, serializedValueType8};
        }

        private SerializedValueType(String str, int i10, ConfigValueType configValueType) {
            this.configType = configValueType;
        }

        public static SerializedValueType forInt(int i10) {
            if (i10 < values().length) {
                return values()[i10];
            }
            return null;
        }

        public static SerializedValueType forValue(b8.p pVar) {
            ConfigValueType configValueTypeC = pVar.c();
            if (configValueTypeC != ConfigValueType.NUMBER) {
                for (SerializedValueType serializedValueType : values()) {
                    if (serializedValueType.configType == configValueTypeC) {
                        return serializedValueType;
                    }
                }
            } else {
                if (pVar instanceof ConfigInt) {
                    return INT;
                }
                if (pVar instanceof ConfigLong) {
                    return LONG;
                }
                if (pVar instanceof ConfigDouble) {
                    return DOUBLE;
                }
            }
            throw new ConfigException.BugOrBroken("don't know how to serialize " + pVar);
        }

        public static SerializedValueType valueOf(String str) {
            return (SerializedValueType) Enum.valueOf(SerializedValueType.class, str);
        }

        public static SerializedValueType[] values() {
            return (SerializedValueType[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31809a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f31810b;

        static {
            int[] iArr = new int[SerializedValueType.values().length];
            f31810b = iArr;
            try {
                iArr[SerializedValueType.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31810b[SerializedValueType.NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31810b[SerializedValueType.INT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31810b[SerializedValueType.LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31810b[SerializedValueType.DOUBLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31810b[SerializedValueType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31810b[SerializedValueType.LIST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31810b[SerializedValueType.OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[SerializedField.values().length];
            f31809a = iArr2;
            try {
                iArr2[SerializedField.ORIGIN_DESCRIPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31809a[SerializedField.ORIGIN_LINE_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31809a[SerializedField.ORIGIN_END_LINE_NUMBER.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31809a[SerializedField.ORIGIN_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f31809a[SerializedField.ORIGIN_URL.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f31809a[SerializedField.ORIGIN_RESOURCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f31809a[SerializedField.ORIGIN_COMMENTS.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f31809a[SerializedField.ORIGIN_NULL_URL.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f31809a[SerializedField.ORIGIN_NULL_RESOURCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f31809a[SerializedField.ORIGIN_NULL_COMMENTS.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f31809a[SerializedField.END_MARKER.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f31809a[SerializedField.ROOT_VALUE.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f31809a[SerializedField.ROOT_WAS_CONFIG.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f31809a[SerializedField.VALUE_DATA.ordinal()] = 14;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f31809a[SerializedField.VALUE_ORIGIN.ordinal()] = 15;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f31809a[SerializedField.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final SerializedField f31811a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteArrayOutputStream f31812b;

        /* renamed from: c, reason: collision with root package name */
        public final DataOutput f31813c;

        public b(SerializedField serializedField) {
            this.f31811a = serializedField;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f31812b = byteArrayOutputStream;
            this.f31813c = new DataOutputStream(byteArrayOutputStream);
        }
    }

    public SerializedConfigValue() {
        super(null);
    }

    public static void A0(DataOutput dataOutput, M m10, M m11) throws IOException {
        for (Map.Entry<SerializedField, Object> entry : (m10 != null ? m10.x(m11) : Collections.EMPTY_MAP).entrySet()) {
            b bVar = new b(entry.getKey());
            B0(bVar.f31813c, bVar.f31811a, entry.getValue());
            z0(dataOutput, bVar);
        }
        y0(dataOutput);
    }

    public static void B0(DataOutput dataOutput, SerializedField serializedField, Object obj) throws IOException {
        switch (a.f31809a[serializedField.ordinal()]) {
            case 1:
                dataOutput.writeUTF((String) obj);
                return;
            case 2:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 3:
                dataOutput.writeInt(((Integer) obj).intValue());
                return;
            case 4:
                dataOutput.writeByte(((Integer) obj).intValue());
                return;
            case 5:
                dataOutput.writeUTF((String) obj);
                return;
            case 6:
                dataOutput.writeUTF((String) obj);
                return;
            case 7:
                List list = (List) obj;
                dataOutput.writeInt(list.size());
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    dataOutput.writeUTF((String) it.next());
                }
                return;
            case 8:
            case 9:
            case 10:
                return;
            default:
                throw new IOException("Unhandled field from origin: " + serializedField);
        }
    }

    public static void C0(DataOutput dataOutput, b8.p pVar, M m10) throws IOException {
        b bVar = new b(SerializedField.VALUE_ORIGIN);
        A0(bVar.f31813c, (M) pVar.e(), m10);
        z0(dataOutput, bVar);
        b bVar2 = new b(SerializedField.VALUE_DATA);
        D0(bVar2.f31813c, pVar);
        z0(dataOutput, bVar2);
        y0(dataOutput);
    }

    public static void D0(DataOutput dataOutput, b8.p pVar) throws IOException {
        SerializedValueType serializedValueTypeForValue = SerializedValueType.forValue(pVar);
        dataOutput.writeByte(serializedValueTypeForValue.ordinal());
        switch (a.f31810b[serializedValueTypeForValue.ordinal()]) {
            case 1:
                dataOutput.writeBoolean(((ConfigBoolean) pVar).a().booleanValue());
                break;
            case 3:
                dataOutput.writeInt(((ConfigInt) pVar).a().intValue());
                dataOutput.writeUTF(((ConfigNumber) pVar).m0());
                break;
            case 4:
                dataOutput.writeLong(((ConfigLong) pVar).a().longValue());
                dataOutput.writeUTF(((ConfigNumber) pVar).m0());
                break;
            case 5:
                dataOutput.writeDouble(((ConfigDouble) pVar).a().doubleValue());
                dataOutput.writeUTF(((ConfigNumber) pVar).m0());
                break;
            case 6:
                dataOutput.writeUTF(((ConfigString) pVar).a());
                break;
            case 7:
                InterfaceC1461g interfaceC1461g = (InterfaceC1461g) pVar;
                dataOutput.writeInt(interfaceC1461g.size());
                Iterator<b8.p> it = interfaceC1461g.iterator();
                while (it.hasNext()) {
                    C0(dataOutput, it.next(), (M) interfaceC1461g.e());
                }
                break;
            case 8:
                b8.j jVar = (b8.j) pVar;
                dataOutput.writeInt(jVar.size());
                for (Map.Entry<String, b8.p> entry : jVar.entrySet()) {
                    dataOutput.writeUTF(entry.getKey());
                    C0(dataOutput, entry.getValue(), (M) jVar.e());
                }
                break;
        }
    }

    private Object readResolve() throws ObjectStreamException {
        return this.f31808c ? ((b8.j) this.f31807b).k() : this.f31807b;
    }

    public static SerializedField s0(DataInput dataInput) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        if (unsignedByte != SerializedField.UNKNOWN.ordinal()) {
            return SerializedField.forInt(unsignedByte);
        }
        throw new IOException("field code " + unsignedByte + " is not supposed to be on the wire");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0007 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.typesafe.config.impl.M t0(java.io.DataInput r6, com.typesafe.config.impl.M r7) throws java.io.IOException {
        /*
            java.util.EnumMap r0 = new java.util.EnumMap
            java.lang.Class<com.typesafe.config.impl.SerializedConfigValue$SerializedField> r1 = com.typesafe.config.impl.SerializedConfigValue.SerializedField.class
            r0.<init>(r1)
        L7:
            com.typesafe.config.impl.SerializedConfigValue$SerializedField r1 = s0(r6)
            int[] r2 = com.typesafe.config.impl.SerializedConfigValue.a.f31809a
            int r3 = r1.ordinal()
            r2 = r2[r3]
            switch(r2) {
                case 1: goto L8e;
                case 2: goto L82;
                case 3: goto L76;
                case 4: goto L6a;
                case 5: goto L62;
                case 6: goto L5a;
                case 7: goto L3f;
                case 8: goto L39;
                case 9: goto L39;
                case 10: goto L39;
                case 11: goto L34;
                case 12: goto L1d;
                case 13: goto L1d;
                case 14: goto L1d;
                case 15: goto L1d;
                case 16: goto L17;
                default: goto L16;
            }
        L16:
            goto L1a
        L17:
            x0(r6)
        L1a:
            r2 = 0
            goto L95
        L1d:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Not expecting this field here: "
            r7.append(r0)
            r7.append(r1)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L34:
            com.typesafe.config.impl.M r6 = com.typesafe.config.impl.M.g(r7, r0)
            return r6
        L39:
            r6.readInt()
            java.lang.String r2 = ""
            goto L95
        L3f:
            r6.readInt()
            int r2 = r6.readInt()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r4 = 0
        L4c:
            if (r4 >= r2) goto L58
            java.lang.String r5 = r6.readUTF()
            r3.add(r5)
            int r4 = r4 + 1
            goto L4c
        L58:
            r2 = r3
            goto L95
        L5a:
            r6.readInt()
            java.lang.String r2 = r6.readUTF()
            goto L95
        L62:
            r6.readInt()
            java.lang.String r2 = r6.readUTF()
            goto L95
        L6a:
            r6.readInt()
            int r2 = r6.readUnsignedByte()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L95
        L76:
            r6.readInt()
            int r2 = r6.readInt()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L95
        L82:
            r6.readInt()
            int r2 = r6.readInt()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L95
        L8e:
            r6.readInt()
            java.lang.String r2 = r6.readUTF()
        L95:
            if (r2 == 0) goto L7
            r0.put(r1, r2)
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.typesafe.config.impl.SerializedConfigValue.t0(java.io.DataInput, com.typesafe.config.impl.M):com.typesafe.config.impl.M");
    }

    public static AbstractConfigValue u0(DataInput dataInput, M m10) throws IOException {
        AbstractConfigValue abstractConfigValueV0 = null;
        M mT0 = null;
        while (true) {
            SerializedField serializedFieldS0 = s0(dataInput);
            if (serializedFieldS0 == SerializedField.END_MARKER) {
                if (abstractConfigValueV0 != null) {
                    return abstractConfigValueV0;
                }
                throw new IOException("No value data found in serialization of value");
            }
            if (serializedFieldS0 == SerializedField.VALUE_DATA) {
                if (mT0 == null) {
                    throw new IOException("Origin must be stored before value data");
                }
                dataInput.readInt();
                abstractConfigValueV0 = v0(dataInput, mT0);
            } else if (serializedFieldS0 == SerializedField.VALUE_ORIGIN) {
                dataInput.readInt();
                mT0 = t0(dataInput, m10);
            } else {
                x0(dataInput);
            }
        }
    }

    public static AbstractConfigValue v0(DataInput dataInput, M m10) throws IOException {
        int unsignedByte = dataInput.readUnsignedByte();
        SerializedValueType serializedValueTypeForInt = SerializedValueType.forInt(unsignedByte);
        if (serializedValueTypeForInt == null) {
            throw new IOException("Unknown serialized value type: " + unsignedByte);
        }
        int i10 = 0;
        switch (a.f31810b[serializedValueTypeForInt.ordinal()]) {
            case 1:
                return new ConfigBoolean(m10, dataInput.readBoolean());
            case 2:
                return new ConfigNull(m10);
            case 3:
                return new ConfigInt(m10, dataInput.readInt(), dataInput.readUTF());
            case 4:
                return new ConfigLong(m10, dataInput.readLong(), dataInput.readUTF());
            case 5:
                return new ConfigDouble(m10, dataInput.readDouble(), dataInput.readUTF());
            case 6:
                return new ConfigString.Quoted(m10, dataInput.readUTF());
            case 7:
                int i11 = dataInput.readInt();
                ArrayList arrayList = new ArrayList(i11);
                while (i10 < i11) {
                    arrayList.add(u0(dataInput, m10));
                    i10++;
                }
                return new SimpleConfigList(m10, arrayList);
            case 8:
                int i12 = dataInput.readInt();
                HashMap map = new HashMap(i12);
                while (i10 < i12) {
                    map.put(dataInput.readUTF(), u0(dataInput, m10));
                    i10++;
                }
                return new SimpleConfigObject(m10, map);
            default:
                throw new IOException("Unhandled serialized value type: " + serializedValueTypeForInt);
        }
    }

    public static ConfigException w0() {
        return new ConfigException.BugOrBroken(SerializedConfigValue.class.getName() + " should not exist outside of serialization");
    }

    public static void x0(DataInput dataInput) throws IOException {
        int i10 = dataInput.readInt();
        int iSkipBytes = dataInput.skipBytes(i10);
        if (iSkipBytes < i10) {
            dataInput.readFully(new byte[i10 - iSkipBytes]);
        }
    }

    public static void y0(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(SerializedField.END_MARKER.ordinal());
    }

    public static void z0(DataOutput dataOutput, b bVar) throws IOException {
        byte[] byteArray = bVar.f31812b.toByteArray();
        dataOutput.writeByte(bVar.f31811a.ordinal());
        dataOutput.writeInt(byteArray.length);
        dataOutput.write(byteArray);
    }

    @Override // b8.p
    public Object a() {
        throw w0();
    }

    @Override // b8.p
    public ConfigValueType c() {
        throw w0();
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public boolean equals(Object obj) {
        if ((obj instanceof SerializedConfigValue) && P(obj)) {
            SerializedConfigValue serializedConfigValue = (SerializedConfigValue) obj;
            if (this.f31808c == serializedConfigValue.f31808c && this.f31807b.equals(serializedConfigValue.f31807b)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public int hashCode() {
        return (((this.f31807b.hashCode() + 41) * 41) + (this.f31808c ? 1 : 0)) * 41;
    }

    public final DataInput q0(ObjectInput objectInput) throws IOException {
        byte[] bArr = new byte[objectInput.readInt()];
        objectInput.readFully(bArr);
        return new DataInputStream(new ByteArrayInputStream(bArr));
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public SerializedConfigValue c0(b8.k kVar) {
        throw w0();
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        while (true) {
            SerializedField serializedFieldS0 = s0(objectInput);
            if (serializedFieldS0 == SerializedField.END_MARKER) {
                return;
            }
            DataInput dataInputQ0 = q0(objectInput);
            if (serializedFieldS0 == SerializedField.ROOT_VALUE) {
                this.f31807b = u0(dataInputQ0, null);
            } else if (serializedFieldS0 == SerializedField.ROOT_WAS_CONFIG) {
                this.f31808c = dataInputQ0.readBoolean();
            }
        }
    }

    @Override // com.typesafe.config.impl.AbstractConfigValue
    public final String toString() {
        return getClass().getSimpleName() + "(value=" + this.f31807b + ",wasConfig=" + this.f31808c + ")";
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        if (((AbstractConfigValue) this.f31807b).j0() != ResolveStatus.RESOLVED) {
            throw new NotSerializableException("tried to serialize a value with unresolved substitutions, need to Config#resolve() first, see API docs");
        }
        b bVar = new b(SerializedField.ROOT_VALUE);
        C0(bVar.f31813c, this.f31807b, null);
        z0(objectOutput, bVar);
        b bVar2 = new b(SerializedField.ROOT_WAS_CONFIG);
        bVar2.f31813c.writeBoolean(this.f31808c);
        z0(objectOutput, bVar2);
        y0(objectOutput);
    }

    public SerializedConfigValue(b8.p pVar) {
        this();
        this.f31807b = pVar;
        this.f31808c = false;
    }

    public SerializedConfigValue(InterfaceC1455a interfaceC1455a) {
        this(interfaceC1455a.K());
        this.f31808c = true;
    }
}
