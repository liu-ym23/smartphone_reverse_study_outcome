package android.os.collector.base;

import android.hardware.display.StepOSDisplayManager;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.collector.StepOSCollectEvent;
import android.os.collector.StepOSCollectLog;
import android.os.collector.base.WireReader;
import android.util.ArrayMap;
import android.util.Log;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/* loaded from: classes.dex */
public abstract class StepOSBaseEntity implements SceneEntity {
    public static final byte DOMAIN_TYPE_DEVICE = 0;
    public static final byte DOMAIN_TYPE_INTENTION = 3;
    public static final byte DOMAIN_TYPE_SCENE = 5;
    public static final byte DOMAIN_TYPE_SENSOR = 4;
    public static final byte DOMAIN_TYPE_SYSTEM = 1;
    public static final byte DOMAIN_TYPE_USER = 2;
    public static final int S_EVENT_SIZE = 24;
    private static final String TAG = "StepOSBaseEntity";
    public int mAtomId;
    public int mEntityDomain;
    public long mTimestampMillis;
    public int mVersion;

    @FunctionalInterface
    public interface EntityFactory<T extends StepOSBaseEntity> {
        T create();
    }

    public StepOSBaseEntity(int entityDomain, int atomId) {
        this.mVersion = 1;
        this.mEntityDomain = entityDomain;
        this.mAtomId = atomId;
        this.mTimestampMillis = System.currentTimeMillis();
    }

    public StepOSBaseEntity() {
        this.mVersion = 0;
        this.mEntityDomain = 0;
        this.mAtomId = 0;
        this.mTimestampMillis = 0L;
    }

    protected Field[] fields() {
        return null;
    }

    public int getAtomId() {
        return this.mAtomId;
    }

    public Object get(String fieldName) {
        if (fieldName == null) {
            return null;
        }
        int dot = fieldName.indexOf(46);
        if (dot < 0) {
            return getDirect(fieldName);
        }
        String head = fieldName.substring(0, dot);
        String tail = fieldName.substring(dot + 1);
        Object child = getDirect(head);
        return resolveSubField(child, tail);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.Object getDirect(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toLowerCase()
            int r1 = r0.hashCode()
            r2 = 0
            switch(r1) {
                case -1407396308: goto L2b;
                case -741729572: goto L21;
                case 351608024: goto L17;
                case 1216479847: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L35
        Ld:
            java.lang.String r1 = "entitydomain"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = 1
            goto L36
        L17:
            java.lang.String r1 = "version"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = r2
            goto L36
        L21:
            java.lang.String r1 = "timestampmillis"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = 3
            goto L36
        L2b:
            java.lang.String r1 = "atomid"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Lc
            r0 = 2
            goto L36
        L35:
            r0 = -1
        L36:
            switch(r0) {
                case 0: goto L56;
                case 1: goto L4f;
                case 2: goto L48;
                case 3: goto L41;
                default: goto L39;
            }
        L39:
            android.os.collector.base.Field[] r0 = r5.fields()
            if (r0 == 0) goto L73
            int r1 = r0.length
            goto L5d
        L41:
            long r0 = r5.mTimestampMillis
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            return r0
        L48:
            int r0 = r5.mAtomId
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L4f:
            int r0 = r5.mEntityDomain
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L56:
            int r0 = r5.mVersion
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            return r0
        L5d:
            if (r2 >= r1) goto L73
            r3 = r0[r2]
            java.lang.String r4 = r3.name
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L70
            java.util.function.Supplier<java.lang.Object> r1 = r3.getter
            java.lang.Object r1 = r1.get()
            return r1
        L70:
            int r2 = r2 + 1
            goto L5d
        L73:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.os.collector.base.StepOSBaseEntity.getDirect(java.lang.String):java.lang.Object");
    }

    private static Object resolveSubField(Object child, String path) {
        if (!(child instanceof StepOSSubFieldHolder)) {
            return null;
        }
        StepOSSubFieldHolder holder = (StepOSSubFieldHolder) child;
        int dot = path.indexOf(46);
        String head = dot < 0 ? path : path.substring(0, dot);
        for (Field f : holder.subFields()) {
            if (f.name.equalsIgnoreCase(head)) {
                Object v = f.getter.get();
                return dot < 0 ? v : resolveSubField(v, path.substring(dot + 1));
            }
        }
        return null;
    }

    public void write() {
        StepOSCollectEvent.Builder builder = StepOSCollectEvent.newBuilder();
        writeToEvent(builder);
        builder.usePooledBuffer();
        StepOSCollectLog.write(builder.build());
    }

    public void writeToEvent(StepOSCollectEvent.Builder builder) {
        builder.setAtomId(this.mAtomId);
        builder.writeInt(this.mVersion);
        builder.writeInt(this.mEntityDomain);
        builder.writeLong(this.mTimestampMillis);
        Field[] fs = fields();
        if (fs != null) {
            for (Field f : fs) {
                writeFieldToEvent(builder, f);
            }
        }
    }

    public StepOSBaseEntity parseBufferGeneric(byte[] buffer, int offset) {
        Field[] fs = fields();
        if (fs == null) {
            return null;
        }
        if (buffer == null || buffer.length < offset + 24) {
            Log.w(TAG, "parseBufferGeneric: buffer/size invalid");
            return null;
        }
        try {
            WireReader reader = new WireReader(buffer, offset);
            readHeader(reader);
            for (Field f : fs) {
                readFieldGeneric(reader, f);
            }
            return this;
        } catch (RuntimeException e) {
            Log.w(TAG, "parseBufferGeneric failed atomId=0x" + Integer.toHexString(this.mAtomId) + ", buffer.length=" + buffer.length + ", offset=" + offset, e);
            return null;
        }
    }

    private void readHeader(WireReader reader) {
        reader.skipByte("atomId.marker");
        this.mAtomId = reader.readInt("atomId");
        reader.skipByte("version.marker");
        this.mVersion = reader.readInt("version");
        reader.skipByte("domain.marker");
        this.mEntityDomain = reader.readInt("domain");
        reader.skipByte("ts.marker");
        this.mTimestampMillis = reader.readLong("timestampMillis");
    }

    public int readInner(byte[] buffer, int offset) {
        if (buffer == null || buffer.length < offset + 24) {
            Log.w(TAG, "readInner: buffer/size invalid, offset=" + offset);
            return -1;
        }
        int index = offset + 1;
        this.mAtomId = readInt(buffer, index);
        int index2 = index + 1 + 4;
        this.mVersion = readInt(buffer, index2);
        int index3 = index2 + 1 + 4;
        this.mEntityDomain = readInt(buffer, index3);
        int i = index3 + 1 + 4;
        this.mTimestampMillis = readLong(buffer, offset + 16);
        return 24;
    }

    public ArrayMap<String, Object> readArrayMap(byte[] buffer, int index) {
        int type = buffer[index] & 255;
        if (type != 10) {
            Log.w(TAG, "readArrayMap failed, type:" + type);
            return null;
        }
        int size = buffer[index + 1] & 255;
        int value_type = index + 2;
        ArrayMap<String, Object> map = new ArrayMap<>(size);
        for (int i = 0; i < size; i++) {
            int s_type = buffer[value_type] & 255;
            if (s_type != 2) {
                Log.w(TAG, "readArrayMap key type error type:" + s_type + ", i:" + i);
                return null;
            }
            int new_index = value_type + 1;
            String key = readString(buffer, new_index);
            if (key == null) {
                return null;
            }
            int new_index2 = new_index + 4 + key.getBytes(StandardCharsets.UTF_8).length;
            int value_type2 = buffer[new_index2] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
            int new_index3 = new_index2 + 1;
            if (value_type2 != 0) {
                if (value_type2 == 1) {
                    long lvalue = readLong(buffer, new_index3);
                    map.put(key, Long.valueOf(lvalue));
                    value_type = new_index3 + 8;
                } else if (value_type2 != 5) {
                    if (value_type2 == 2) {
                        String svalue = readString(buffer, new_index3);
                        if (svalue == null) {
                            return null;
                        }
                        int new_index4 = new_index3 + 4 + svalue.getBytes(StandardCharsets.UTF_8).length;
                        map.put(key, svalue);
                        value_type = new_index4;
                    } else if (value_type2 == 4) {
                        float fvalue = readFloat(buffer, new_index3);
                        map.put(key, Float.valueOf(fvalue));
                        value_type = new_index3 + 4;
                    } else {
                        Log.w(TAG, "readArrayMap i:" + i + " invalid value type: " + value_type2);
                        return null;
                    }
                } else {
                    boolean bvalue = readBoolean(buffer, new_index3);
                    map.put(key, Boolean.valueOf(bvalue));
                    value_type = new_index3 + 1;
                }
            } else {
                int value = readInt(buffer, new_index3);
                map.put(key, Integer.valueOf(value));
                value_type = new_index3 + 4;
            }
        }
        return map;
    }

    public boolean readBoolean(byte[] buffer, int index) {
        byte value = buffer[index];
        return value != 0;
    }

    public int readInt(byte[] buffer, int index) {
        return ((buffer[index + 3] & 255) << 24) | ((buffer[index + 2] & 255) << 16) | ((buffer[index + 1] & 255) << 8) | (buffer[index] & 255);
    }

    public float readFloat(byte[] buffer, int index) {
        return Float.intBitsToFloat(readInt(buffer, index));
    }

    public double readDouble(byte[] buffer, int index) {
        return Double.longBitsToDouble(readLong(buffer, index));
    }

    public long readLong(byte[] buffer, int index) {
        return ((buffer[index + 7] & 255) << 56) | ((buffer[index + 6] & 255) << 48) | ((buffer[index + 5] & 255) << 40) | ((buffer[index + 4] & 255) << 32) | ((buffer[index + 3] & 255) << 24) | ((buffer[index + 2] & 255) << 16) | ((buffer[index + 1] & 255) << 8) | (buffer[index] & 255);
    }

    public String readString(byte[] buffer, int index) {
        if (buffer == null || index < 0 || index + 4 > buffer.length) {
            Log.w(TAG, "readString: index out of range, index=" + index);
            return null;
        }
        int numBytes = readInt(buffer, index);
        int payloadStart = index + 4;
        if (numBytes < 0 || numBytes > buffer.length - payloadStart) {
            Log.w(TAG, "readString: invalid numBytes=" + numBytes + ", index=" + index + ", buffer.length=" + buffer.length);
            return null;
        }
        return new String(buffer, payloadStart, numBytes, StandardCharsets.UTF_8);
    }

    public boolean[] readBooleanArray(byte[] buffer, int index) {
        int type_list = buffer[index] & 255;
        int size = buffer[index + 1] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int type_id = buffer[index + 2] & 255;
        if (type_list != 3 || type_id != 5) {
            Log.w(TAG, "readBooleanArray failed, type_list:" + type_list + ", type_id:" + type_id);
            return null;
        }
        if (size > 127) {
            Log.w(TAG, "readBooleanArray invalid size: " + size);
            return null;
        }
        if (index + 3 + size > buffer.length) {
            Log.w(TAG, "readBooleanArray out of range, size=" + size);
            return null;
        }
        int pos = index + 3;
        boolean[] elements = new boolean[size];
        for (int i = 0; i < size; i++) {
            elements[i] = readBoolean(buffer, pos + i);
        }
        return elements;
    }

    public int[] readIntArray(byte[] buffer, int index) {
        int type_list = buffer[index] & 255;
        int size = buffer[index + 1] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int type_id = buffer[index + 2] & 255;
        if (type_list != 3 || type_id != 0) {
            Log.w(TAG, "readIntArray failed, type_list:" + type_list + ", type_id:" + type_id);
            return null;
        }
        if (size > 127) {
            Log.w(TAG, "readIntArray invalid size: " + size);
            return null;
        }
        if (index + 3 + (size * 4) > buffer.length) {
            Log.w(TAG, "readIntArray out of range, size=" + size);
            return null;
        }
        int pos = index + 3;
        int[] elements = new int[size];
        for (int i = 0; i < size; i++) {
            elements[i] = readInt(buffer, (i * 4) + pos);
        }
        return elements;
    }

    public long[] readLongArray(byte[] buffer, int index) {
        int type_list = buffer[index] & 255;
        int size = buffer[index + 1] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int type_id = buffer[index + 2] & 255;
        if (type_list != 3 || type_id != 1) {
            Log.w(TAG, "readLongArray failed, type_list:" + type_list + ", type_id:" + type_id);
            return null;
        }
        if (size > 127) {
            Log.w(TAG, "readLongArray invalid size: " + size);
            return null;
        }
        if (index + 3 + (size * 8) > buffer.length) {
            Log.w(TAG, "readLongArray out of range, size=" + size);
            return null;
        }
        int pos = index + 3;
        long[] elements = new long[size];
        for (int i = 0; i < size; i++) {
            elements[i] = readLong(buffer, (i * 8) + pos);
        }
        return elements;
    }

    public float[] readFloatArray(byte[] buffer, int index) {
        int type_list = buffer[index] & 255;
        int size = buffer[index + 1] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int type_id = buffer[index + 2] & 255;
        if (type_list != 3 || type_id != 4) {
            Log.w(TAG, "readFloatArray failed, type_list:" + type_list + ", type_id:" + type_id);
            return null;
        }
        if (size > 127) {
            Log.w(TAG, "readFloatArray invalid size: " + size);
            return null;
        }
        if (index + 3 + (size * 4) > buffer.length) {
            Log.w(TAG, "readFloatArray out of range, size=" + size);
            return null;
        }
        int pos = index + 3;
        float[] elements = new float[size];
        for (int i = 0; i < size; i++) {
            elements[i] = readFloat(buffer, (i * 4) + pos);
        }
        return elements;
    }

    public String[] readStringArray(byte[] buffer, int index) {
        int type_list = buffer[index] & 255;
        int size = buffer[index + 1] & StepOSDisplayManager.BACK_SCREEN_BRIGHTNESS_MAX;
        int type_id = buffer[index + 2] & 255;
        if (type_list != 3 || type_id != 2) {
            Log.w(TAG, "readStringArray failed, type_list:" + type_list + ", type_id:" + type_id);
            return null;
        }
        if (size > 127) {
            Log.w(TAG, "readStringArray invalid size: " + size);
            return null;
        }
        int pos = index + 3;
        String[] elements = new String[size];
        for (int i = 0; i < size; i++) {
            String s = readString(buffer, pos);
            if (s == null) {
                return null;
            }
            elements[i] = s;
            pos += s.getBytes(StandardCharsets.UTF_8).length + 4;
        }
        return elements;
    }

    public StepOSBaseEntity createFromBuffer(byte[] buffer) {
        return parseBufferGeneric(buffer, 0);
    }

    public void buildStepOSBaseEntity(Parcel in) {
        this.mVersion = in.readInt();
        this.mEntityDomain = in.readInt();
        this.mAtomId = in.readInt();
        this.mTimestampMillis = in.readLong();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mVersion);
        dest.writeInt(this.mEntityDomain);
        dest.writeInt(this.mAtomId);
        dest.writeLong(this.mTimestampMillis);
        Field[] fs = fields();
        if (fs != null) {
            for (Field f : fs) {
                writeFieldToParcel(dest, f, flags);
            }
        }
    }

    public final void readFromParcelGeneric(Parcel in) {
        buildStepOSBaseEntity(in);
        Field[] fs = fields();
        if (fs == null) {
            return;
        }
        for (Field f : fs) {
            readFieldFromParcel(in, f);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName()).append('{');
        sb.append("version=").append(this.mVersion);
        sb.append(", entityDomain=").append(this.mEntityDomain);
        sb.append(", atomId=").append(this.mAtomId);
        sb.append(", timestampMillis=").append(this.mTimestampMillis);
        appendFields(sb, true);
        sb.append('}');
        return sb.toString();
    }

    public String fieldsToString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName()).append('{');
        appendFields(sb, false);
        sb.append('}');
        return sb.toString();
    }

    public static <T extends StepOSBaseEntity> Parcelable.Creator<T> creatorOf(final EntityFactory<T> entityFactory, final IntFunction<T[]> intFunction) {
        return (Parcelable.Creator<T>) new Parcelable.Creator<T>() { // from class: android.os.collector.base.StepOSBaseEntity.1
            /* JADX WARN: Incorrect return type in method signature: (Landroid/os/Parcel;)TT; */
            @Override // android.os.Parcelable.Creator
            public StepOSBaseEntity createFromParcel(Parcel in) {
                StepOSBaseEntity stepOSBaseEntityCreate = entityFactory.create();
                stepOSBaseEntityCreate.readFromParcelGeneric(in);
                return stepOSBaseEntityCreate;
            }

            /* JADX WARN: Incorrect return type in method signature: (I)[TT; */
            @Override // android.os.Parcelable.Creator
            public StepOSBaseEntity[] newArray(int size) {
                return (StepOSBaseEntity[]) intFunction.apply(size);
            }
        };
    }

    private static void writeFieldToEvent(StepOSCollectEvent.Builder b, Field f) {
        switch (f.type) {
            case INT:
                b.writeInt(((Integer) f.getter.get()).intValue());
                return;
            case LONG:
                b.writeLong(((Long) f.getter.get()).longValue());
                return;
            case FLOAT:
                b.writeFloat(((Float) f.getter.get()).floatValue());
                return;
            case DOUBLE:
                b.writeLong(Double.doubleToRawLongBits(((Double) f.getter.get()).doubleValue()));
                return;
            case BOOL:
                b.writeBoolean(((Boolean) f.getter.get()).booleanValue());
                return;
            case STRING:
                String s = (String) f.getter.get();
                b.writeString(s == null ? "" : s);
                return;
            case INT_ARRAY:
                int[] a = (int[]) f.getter.get();
                b.writeIntArray(a == null ? new int[0] : a);
                return;
            case LONG_ARRAY:
                long[] a2 = (long[]) f.getter.get();
                b.writeLongArray(a2 == null ? new long[0] : a2);
                return;
            case FLOAT_ARRAY:
                float[] a3 = (float[]) f.getter.get();
                b.writeFloatArray(a3 == null ? new float[0] : a3);
                return;
            case BOOL_ARRAY:
                boolean[] a4 = (boolean[]) f.getter.get();
                b.writeBooleanArray(a4 == null ? new boolean[0] : a4);
                return;
            case STRING_ARRAY:
                String[] a5 = (String[]) f.getter.get();
                b.writeStringArray(a5 == null ? new String[0] : a5);
                return;
            case STRING_MAP:
                ArrayMap<String, String> m = (ArrayMap) f.getter.get();
                b.writeArrayMap(toObjectMap(m));
                return;
            case MESSAGE:
                Object sub = f.getter.get();
                if (sub != null) {
                    b.writeMessageBegin();
                    for (Field sf : f.msgFieldsFn.apply(sub)) {
                        writeFieldToEvent(b, sf);
                    }
                    b.writeMessageEnd();
                    return;
                }
                return;
            case MESSAGE_LIST:
                List<?> list = (List) f.getter.get();
                if (list != null && !list.isEmpty()) {
                    b.writeMessageListBegin(list.size());
                    for (Object item : list) {
                        b.writeMessageBegin();
                        for (Field sf2 : f.msgFieldsFn.apply(item)) {
                            writeFieldToEvent(b, sf2);
                        }
                        b.writeMessageEnd();
                    }
                    return;
                }
                return;
            default:
                throw new IllegalStateException("unsupported Field.Type for collect write: " + f.type);
        }
    }

    private static void readFieldGeneric(WireReader r, Field f) {
        switch (f.type) {
            case INT:
                r.skipByte(f.name + ".marker");
                f.setter.accept(Integer.valueOf(r.readInt(f.name)));
                return;
            case LONG:
                r.skipByte(f.name + ".marker");
                f.setter.accept(Long.valueOf(r.readLong(f.name)));
                return;
            case FLOAT:
                r.skipByte(f.name + ".marker");
                f.setter.accept(Float.valueOf(r.readFloat(f.name)));
                return;
            case DOUBLE:
                r.skipByte(f.name + ".marker");
                f.setter.accept(Double.valueOf(r.readDouble(f.name)));
                return;
            case BOOL:
                r.skipByte(f.name + ".marker");
                f.setter.accept(Boolean.valueOf(r.readBool(f.name)));
                return;
            case STRING:
                r.skipByte(f.name + ".marker");
                f.setter.accept(r.readString(f.name));
                return;
            case INT_ARRAY:
                f.setter.accept(r.readIntArray(f.name));
                return;
            case LONG_ARRAY:
                f.setter.accept(r.readLongArray(f.name));
                return;
            case FLOAT_ARRAY:
                f.setter.accept(r.readFloatArray(f.name));
                return;
            case BOOL_ARRAY:
                f.setter.accept(r.readBoolArray(f.name));
                return;
            case STRING_ARRAY:
                f.setter.accept(r.readStringArray(f.name));
                return;
            case STRING_MAP:
                ArrayMap<String, Object> raw = r.readArrayMap(f.name);
                f.setter.accept(toStringMap(raw));
                return;
            case MESSAGE:
                readMessageField(r, f);
                return;
            case MESSAGE_LIST:
                readMessageListField(r, f);
                return;
            default:
                throw new IllegalStateException("unsupported Field.Type for buffer read: " + f.type);
        }
    }

    private static void readMessageField(WireReader r, Field f) {
        r.expectMarker(StepOSCollectEvent.TYPE_MESSAGE, f.name + ".marker");
        int nestedLen = r.readInt(f.name + ".len");
        int nestedEnd = r.position() + nestedLen;
        Object sub = f.msgCtor.get();
        for (Field sf : f.msgFieldsFn.apply(sub)) {
            if (r.position() >= nestedEnd) {
                break;
            }
            readFieldGeneric(r, sf);
        }
        int leftover = nestedEnd - r.position();
        if (leftover > 0) {
            r.skip(leftover, f.name + ".tail");
        } else if (leftover < 0) {
            throw new WireReader.ParseException(f.name + ": sub-fields read past nested end by " + (-leftover) + " bytes");
        }
        f.setter.accept(sub);
    }

    private static void readMessageListField(WireReader r, Field f) {
        int count = r.readListHeader(StepOSCollectEvent.TYPE_MESSAGE, f.name);
        List<Object> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            r.expectMarker(StepOSCollectEvent.TYPE_MESSAGE, f.name + "[" + i + "].marker");
            int elemLen = r.readInt(f.name + "[" + i + "].len");
            int elemEnd = r.position() + elemLen;
            Object sub = f.msgCtor.get();
            for (Field sf : f.msgFieldsFn.apply(sub)) {
                if (r.position() >= elemEnd) {
                    break;
                }
                readFieldGeneric(r, sf);
            }
            int leftover = elemEnd - r.position();
            if (leftover > 0) {
                r.skip(leftover, f.name + "[" + i + "].tail");
            } else if (leftover < 0) {
                throw new WireReader.ParseException(f.name + "[" + i + "]: sub-fields read past element end by " + (-leftover) + " bytes");
            }
            list.add(sub);
        }
        f.setter.accept(list);
    }

    private static void writeFieldToParcel(Parcel parcel, Field field, int i) {
        switch (field.type) {
            case INT:
                parcel.writeInt(((Integer) field.getter.get()).intValue());
                return;
            case LONG:
                parcel.writeLong(((Long) field.getter.get()).longValue());
                return;
            case FLOAT:
                parcel.writeFloat(((Float) field.getter.get()).floatValue());
                return;
            case DOUBLE:
                parcel.writeDouble(((Double) field.getter.get()).doubleValue());
                return;
            case BOOL:
                parcel.writeByte(((Boolean) field.getter.get()).booleanValue() ? (byte) 1 : (byte) 0);
                return;
            case STRING:
                parcel.writeString((String) field.getter.get());
                return;
            case INT_ARRAY:
                parcel.writeIntArray((int[]) field.getter.get());
                return;
            case LONG_ARRAY:
                parcel.writeLongArray((long[]) field.getter.get());
                return;
            case FLOAT_ARRAY:
                parcel.writeFloatArray((float[]) field.getter.get());
                return;
            case BOOL_ARRAY:
                parcel.writeBooleanArray((boolean[]) field.getter.get());
                return;
            case STRING_ARRAY:
                parcel.writeStringArray((String[]) field.getter.get());
                return;
            case STRING_MAP:
                parcel.writeMap((ArrayMap) field.getter.get());
                return;
            case MESSAGE:
                parcel.writeParcelable((Parcelable) field.getter.get(), i);
                return;
            case MESSAGE_LIST:
                parcel.writeList((List) field.getter.get());
                return;
            default:
                throw new IllegalStateException("unsupported Field.Type for parcel write: " + field.type);
        }
    }

    private static void readFieldFromParcel(Parcel p, Field f) {
        switch (f.type) {
            case INT:
                f.setter.accept(Integer.valueOf(p.readInt()));
                return;
            case LONG:
                f.setter.accept(Long.valueOf(p.readLong()));
                return;
            case FLOAT:
                f.setter.accept(Float.valueOf(p.readFloat()));
                return;
            case DOUBLE:
                f.setter.accept(Double.valueOf(p.readDouble()));
                return;
            case BOOL:
                f.setter.accept(Boolean.valueOf(p.readByte() != 0));
                return;
            case STRING:
                f.setter.accept(p.readString());
                return;
            case INT_ARRAY:
                f.setter.accept(p.createIntArray());
                return;
            case LONG_ARRAY:
                f.setter.accept(p.createLongArray());
                return;
            case FLOAT_ARRAY:
                f.setter.accept(p.createFloatArray());
                return;
            case BOOL_ARRAY:
                f.setter.accept(p.createBooleanArray());
                return;
            case STRING_ARRAY:
                f.setter.accept(p.createStringArray());
                return;
            case STRING_MAP:
                ArrayMap<String, String> m = new ArrayMap<>();
                p.readMap(m, StepOSBaseEntity.class.getClassLoader());
                f.setter.accept(m);
                return;
            case MESSAGE:
                Parcelable sub = p.readParcelable(StepOSBaseEntity.class.getClassLoader());
                f.setter.accept(sub);
                return;
            case MESSAGE_LIST:
                List<?> list = p.readArrayList(StepOSBaseEntity.class.getClassLoader());
                f.setter.accept(list);
                return;
            default:
                throw new IllegalStateException("unsupported Field.Type for parcel read: " + f.type);
        }
    }

    private static ArrayMap<String, Object> toObjectMap(ArrayMap<String, String> in) {
        if (in == null) {
            return null;
        }
        ArrayMap<String, Object> out = new ArrayMap<>(in.size());
        for (int i = 0; i < in.size(); i++) {
            out.put(in.keyAt(i), in.valueAt(i));
        }
        return out;
    }

    private static ArrayMap<String, String> toStringMap(ArrayMap<String, Object> in) {
        if (in == null) {
            return null;
        }
        ArrayMap<String, String> out = new ArrayMap<>(in.size());
        for (int i = 0; i < in.size(); i++) {
            Object v = in.valueAt(i);
            out.put(in.keyAt(i), v == null ? null : v.toString());
        }
        return out;
    }

    private void appendFields(StringBuilder sb, boolean leadingComma) {
        Field[] fs = fields();
        if (fs == null) {
            return;
        }
        boolean needComma = leadingComma;
        for (Field f : fs) {
            if (needComma) {
                sb.append(", ");
            }
            needComma = true;
            sb.append(f.name).append('=');
            appendFieldValue(sb, f);
        }
    }

    private static void appendFieldValue(StringBuilder sb, Field f) {
        Object v = f.getter.get();
        if (v == null) {
            sb.append("null");
        }
        switch (f.type) {
            case INT_ARRAY:
                sb.append(Arrays.toString((int[]) v));
                break;
            case LONG_ARRAY:
                sb.append(Arrays.toString((long[]) v));
                break;
            case FLOAT_ARRAY:
                sb.append(Arrays.toString((float[]) v));
                break;
            case BOOL_ARRAY:
                sb.append(Arrays.toString((boolean[]) v));
                break;
            case STRING_ARRAY:
                sb.append(Arrays.toString((String[]) v));
                break;
            default:
                sb.append(v);
                break;
        }
    }
}
