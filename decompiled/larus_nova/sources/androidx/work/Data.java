package androidx.work;

import com.alipay.sdk.m.u.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class Data {
    public static final Data EMPTY = null;
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = null;
    Map<String, Object> mValues;

    public static final class Builder {
        private Map<String, Object> mValues;

        public Data build() {
            Data r100 = new Data(this.mValues);
            Data.toByteArrayInternal(r100);
            return r100;
        }

        public Builder() {
            this.mValues = new HashMap();
        }

        public Builder putAll(Map<String, Object> r100) {
            Iterator<Map.Entry<String, Object>> r101 = r100.entrySet().iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            Map.Entry<String, Object> r102 = r101.next();
            put(r102.getKey(), r102.getValue());
            goto L4
        L6:
            return this;
        }

        public Builder putAll(Data r100) {
            putAll(r100.mValues);
            return this;
        }

        public Builder put(String r100, Object r101) {
            if (r101 != null) goto L4;
            this.mValues.put(r100, null);
        L54:
            return this;
        L4:
            Class<?> r102 = r101.getClass();
            if (r102 != Boolean.class) goto L7;
        L53:
            this.mValues.put(r100, r101);
            goto L54
        L7:
            if (r102 == Byte.class) goto L53;
            if (r102 == Integer.class) goto L53;
            if (r102 == Long.class) goto L53;
            if (r102 == Float.class) goto L53;
            if (r102 == Double.class) goto L53;
            if (r102 == String.class) goto L53;
            if (r102 == Boolean[].class) goto L53;
            if (r102 == Byte[].class) goto L53;
            if (r102 == Integer[].class) goto L53;
            if (r102 == Long[].class) goto L53;
            if (r102 == Float[].class) goto L53;
            if (r102 == Double[].class) goto L53;
            if (r102 == String[].class) goto L53;
            if (r102 != boolean[].class) goto L37;
            this.mValues.put(r100, Data.convertPrimitiveBooleanArray((boolean[]) r101));
            goto L54
        L37:
            if (r102 != byte[].class) goto L40;
            this.mValues.put(r100, Data.convertPrimitiveByteArray((byte[]) r101));
            goto L54
        L40:
            if (r102 != int[].class) goto L43;
            this.mValues.put(r100, Data.convertPrimitiveIntArray((int[]) r101));
            goto L54
        L43:
            if (r102 != long[].class) goto L46;
            this.mValues.put(r100, Data.convertPrimitiveLongArray((long[]) r101));
            goto L54
        L46:
            if (r102 != float[].class) goto L49;
            this.mValues.put(r100, Data.convertPrimitiveFloatArray((float[]) r101));
            goto L54
        L49:
            if (r102 != double[].class) goto L52;
            this.mValues.put(r100, Data.convertPrimitiveDoubleArray((double[]) r101));
            goto L54
        L52:
            throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{r100, r102}));
        }

        public Builder putBoolean(String r100, boolean r101) {
            this.mValues.put(r100, Boolean.valueOf(r101));
            return this;
        }

        public Builder putBooleanArray(String r100, boolean[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveBooleanArray(r101));
            return this;
        }

        public Builder putByte(String r100, byte r101) {
            this.mValues.put(r100, Byte.valueOf(r101));
            return this;
        }

        public Builder putByteArray(String r100, byte[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveByteArray(r101));
            return this;
        }

        public Builder putDouble(String r100, double r101) {
            this.mValues.put(r100, Double.valueOf(r101));
            return this;
        }

        public Builder putDoubleArray(String r100, double[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveDoubleArray(r101));
            return this;
        }

        public Builder putFloat(String r100, float r101) {
            this.mValues.put(r100, Float.valueOf(r101));
            return this;
        }

        public Builder putFloatArray(String r100, float[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveFloatArray(r101));
            return this;
        }

        public Builder putInt(String r100, int r101) {
            this.mValues.put(r100, Integer.valueOf(r101));
            return this;
        }

        public Builder putIntArray(String r100, int[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveIntArray(r101));
            return this;
        }

        public Builder putLong(String r100, long r101) {
            this.mValues.put(r100, Long.valueOf(r101));
            return this;
        }

        public Builder putLongArray(String r100, long[] r101) {
            this.mValues.put(r100, Data.convertPrimitiveLongArray(r101));
            return this;
        }

        public Builder putString(String r100, String r101) {
            this.mValues.put(r100, r101);
            return this;
        }

        public Builder putStringArray(String r100, String[] r101) {
            this.mValues.put(r100, r101);
            return this;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Data");
        EMPTY = new Builder().build();
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public int size() {
        return this.mValues.size();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("Data {");
        if (this.mValues.isEmpty() == true) goto L12;
        Iterator<String> r101 = this.mValues.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();
        r100.append(r102);
        r100.append(" : ");
        Object r103 = this.mValues.get(r102);
        if ((r103 instanceof Object[]) == false) goto L10;
        r100.append(Arrays.toString((Object[]) r103));
    L11:
        r100.append(", ");
        goto L6
    L10:
        r100.append(r103);
    L12:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    public Data() {
    }

    public Data(Data r100) {
        this.mValues = new HashMap(r100.mValues);
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] r100) {
        Boolean[] r101 = new Boolean[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Boolean.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] r100) {
        Byte[] r101 = new Byte[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Byte.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] r100) {
        Double[] r101 = new Double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Double.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Float[] convertPrimitiveFloatArray(float[] r100) {
        Float[] r101 = new Float[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Float.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Integer[] convertPrimitiveIntArray(int[] r100) {
        Integer[] r101 = new Integer[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Integer.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Long[] convertPrimitiveLongArray(long[] r100) {
        Long[] r101 = new Long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = Long.valueOf(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static byte[] convertToPrimitiveArray(Byte[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].byteValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static Data fromByteArray(byte[] r100) {
        if (r100.length > 10240) goto L28;
        HashMap r101 = new HashMap();
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        ObjectInputStream r103 = null;
        ObjectInputStream r104 = new ObjectInputStream(r102);     // Catch: Throwable -> L16 Throwable -> L33
        int r105 = r104.readInt();     // Catch: Throwable -> L13 Throwable -> L15
    L7:
        if (r105 <= 0) goto L10;
        r101.put(r104.readUTF(), r104.readObject());     // Catch: Throwable -> L13 Throwable -> L15
        r105 = r105 - 1;
        goto L7
    L10:
        r104.close();     // Catch: IOException -> L29
    L15:
        r103 = r104;
    L13:
        Throwable th10 = th;
    L18:
        if (r104 != null) goto L38;
    L36:
        r102.close();     // Catch: IOException -> L32
        throw th10;
    L48:
        throw th10;
    L38:
        r104.close();     // Catch: IOException -> L31
        goto L36
    L16:
        th = move-exception;
        r104 = null;
        th10 = th;
    L22:
        if (r103 == null) goto L34;
        r103.close();     // Catch: IOException -> L29
    L34:
        r102.close();     // Catch: IOException -> L30
    L26:
        return new Data(r101);
    L28:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public static byte[] toByteArrayInternal(Data r100) {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        ObjectOutputStream r102 = null;
        ObjectOutputStream r103 = new ObjectOutputStream(r101);     // Catch: Throwable -> L22 IOException -> L36
        r103.writeInt(r100.size());     // Catch: Throwable -> L19 IOException -> L21
        Iterator<Map.Entry<String, Object>> r104 = r100.mValues.entrySet().iterator();     // Catch: Throwable -> L19 IOException -> L21
    L6:
        if (r104.hasNext() == false) goto L52;
        Map.Entry<String, Object> r105 = r104.next();     // Catch: Throwable -> L19 IOException -> L21
        r103.writeUTF(r105.getKey());     // Catch: Throwable -> L19 IOException -> L21
        r103.writeObject(r105.getValue());     // Catch: Throwable -> L19 IOException -> L21
    L52:
        r103.close();     // Catch: IOException -> L33
    L47:
        r101.close();     // Catch: IOException -> L12
    L14:
        if (r101.size() > 10240) goto L18;
        return r101.toByteArray();
    L18:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    L21:
        r102 = r103;
    L19:
        th = th;
        r102 = r103;
    L29:
        if (r102 != null) goto L45;
    L43:
        r101.close();     // Catch: IOException -> L35
        throw th;
    L57:
        throw th;
    L45:
        r102.close();     // Catch: IOException -> L34
    L22:
        th = th;
    L24:
        byte[] r106 = r101.toByteArray();     // Catch: Throwable -> L22
        if (r102 != null) goto L41;
    L39:
        r101.close();     // Catch: IOException -> L38
    L28:
        return r106;
    L41:
        r102.close();     // Catch: IOException -> L37
        goto L39
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L32:
        return false;
    L8:
        if (Data.class != r100.getClass()) goto L32;
        Data r101 = (Data) r100;
        Set<String> r102 = this.mValues.keySet();
        if (r102.equals(r101.mValues.keySet()) == true) goto L13;
        return false;
    L13:
        Iterator<String> r103 = r102.iterator();
    L15:
        if (r103.hasNext() == false) goto L31;
        String r104 = r103.next();
        Object r105 = this.mValues.get(r104);
        Object r106 = r101.mValues.get(r104);
        if (r105 == null) goto L26;
        if (r106 == null) goto L26;
        if ((r105 instanceof Object[]) == true) goto L23;
    L25:
        boolean r107 = r105.equals(r106);
    L29:
        if (r107 == true) goto L15;
        return false;
    L23:
        if ((r106 instanceof Object[]) == false) goto L25;
        r107 = Arrays.deepEquals((Object[]) r105, (Object[]) r106);
    L26:
        if (r105 != r106) goto L28;
        r107 = true;
        goto L29
    L28:
        r107 = false;
        goto L29
    L31:
        return true;
    }

    public boolean[] getBooleanArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Boolean[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Boolean[]) r101);
    }

    public byte[] getByteArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Byte[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Byte[]) r101);
    }

    public double[] getDoubleArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Double[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Double[]) r101);
    }

    public float[] getFloatArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Float[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Float[]) r101);
    }

    public int[] getIntArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Integer[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Integer[]) r101);
    }

    public long[] getLongArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof Long[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Long[]) r101);
    }

    public String getString(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r101;
    }

    public String[] getStringArray(String r100) {
        Object r101 = this.mValues.get(r100);
        if ((r101 instanceof String[]) == true) goto L5;
        return null;
    L5:
        return (String[]) r101;
    }

    public Data(Map<String, ?> r100) {
        this.mValues = new HashMap(r100);
    }

    public static double[] convertToPrimitiveArray(Double[] r100) {
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].doubleValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static float[] convertToPrimitiveArray(Float[] r100) {
        float[] r101 = new float[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].floatValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static int[] convertToPrimitiveArray(Integer[] r100) {
        int[] r101 = new int[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].intValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static long[] convertToPrimitiveArray(Long[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].longValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] r100) {
        boolean[] r101 = new boolean[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102].booleanValue();
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public boolean getBoolean(String r100, boolean r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Boolean) == true) goto L5;
        return r101;
    L5:
        return ((Boolean) r102).booleanValue();
    }

    public byte getByte(String r100, byte r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Byte) == true) goto L5;
        return r101;
    L5:
        return ((Byte) r102).byteValue();
    }

    public double getDouble(String r100, double r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Double) == true) goto L5;
        return r101;
    L5:
        return ((Double) r102).doubleValue();
    }

    public float getFloat(String r100, float r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Float) == true) goto L5;
        return r101;
    L5:
        return ((Float) r102).floatValue();
    }

    public int getInt(String r100, int r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Integer) == true) goto L5;
        return r101;
    L5:
        return ((Integer) r102).intValue();
    }

    public long getLong(String r100, long r101) {
        Object r102 = this.mValues.get(r100);
        if ((r102 instanceof Long) == true) goto L5;
        return r101;
    L5:
        return ((Long) r102).longValue();
    }

    public <T> boolean hasKeyWithValueOfType(String r100, Class<T> r101) {
        Object r102 = this.mValues.get(r100);
        if (r102 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isAssignableFrom(r102.getClass()) == false) goto L7;
        return true;
    }
}
