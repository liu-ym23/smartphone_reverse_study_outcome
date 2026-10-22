package androidx.work;

import android.util.Log;
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

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5405b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f5406c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f5407a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f5408a;

        public a() {
            this.f5408a = new HashMap();
        }

        public c a() {
            c r10 = new c(this.f5408a);
            c.k(r10);
            return r10;
        }

        public a b(String r10, Object r11) {
            if (r11 != null) goto L4;
            this.f5408a.put(r10, null);
        L54:
            return this;
        L4:
            Class<?> r12 = r11.getClass();
            if (r12 != Boolean.class) goto L7;
        L53:
            this.f5408a.put(r10, r11);
            goto L54
        L7:
            if (r12 == Byte.class) goto L53;
            if (r12 == Integer.class) goto L53;
            if (r12 == Long.class) goto L53;
            if (r12 == Float.class) goto L53;
            if (r12 == Double.class) goto L53;
            if (r12 == String.class) goto L53;
            if (r12 == Boolean[].class) goto L53;
            if (r12 == Byte[].class) goto L53;
            if (r12 == Integer[].class) goto L53;
            if (r12 == Long[].class) goto L53;
            if (r12 == Float[].class) goto L53;
            if (r12 == Double[].class) goto L53;
            if (r12 == String[].class) goto L53;
            if (r12 != boolean[].class) goto L37;
            this.f5408a.put(r10, c.a((boolean[]) r11));
            goto L54
        L37:
            if (r12 != byte[].class) goto L40;
            this.f5408a.put(r10, c.b((byte[]) r11));
            goto L54
        L40:
            if (r12 != int[].class) goto L43;
            this.f5408a.put(r10, c.e((int[]) r11));
            goto L54
        L43:
            if (r12 != long[].class) goto L46;
            this.f5408a.put(r10, c.f((long[]) r11));
            goto L54
        L46:
            if (r12 != float[].class) goto L49;
            this.f5408a.put(r10, c.d((float[]) r11));
            goto L54
        L49:
            if (r12 != double[].class) goto L52;
            this.f5408a.put(r10, c.c((double[]) r11));
            goto L54
        L52:
            throw new IllegalArgumentException("Key " + r10 + "has invalid type " + r12);
        }

        public a c(Map r10) {
            Iterator r11 = r10.entrySet().iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Map.Entry r12 = (Map.Entry) r11.next();
            b((String) r12.getKey(), r12.getValue());
            goto L4
        L6:
            return this;
        }
    }

    static {
        f5405b = i.i("Data");
        f5406c = new a().a();
    }

    public c(c r10) {
        this.f5407a = new HashMap(r10.f5407a);
    }

    public static Boolean[] a(boolean[] r10) {
        Boolean[] r11 = new Boolean[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Boolean.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static Byte[] b(byte[] r10) {
        Byte[] r11 = new Byte[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Byte.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static Double[] c(double[] r10) {
        Double[] r11 = new Double[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Double.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static Float[] d(float[] r10) {
        Float[] r11 = new Float[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Float.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static Integer[] e(int[] r10) {
        Integer[] r11 = new Integer[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Integer.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static Long[] f(long[] r10) {
        Long[] r11 = new Long[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = Long.valueOf(r10[r12]);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static c g(byte[] r10) {
        if (r10.length > 10240) goto L46;
        HashMap r11 = new HashMap();
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);
        ObjectInputStream r13 = null;
        ObjectInputStream r14 = new ObjectInputStream(r12);     // Catch: Throwable -> L22 Throwable -> L24
        int r15 = r14.readInt();     // Catch: Throwable -> L10 Throwable -> L12
    L7:
        if (r15 <= 0) goto L51;
        r11.put(r14.readUTF(), r14.readObject());     // Catch: Throwable -> L10 Throwable -> L12
        r15 = r15 - 1;
        goto L7
    L51:
        r14.close();     // Catch: IOException -> L16
    L18:
        r12.close();     // Catch: IOException -> L20
    L54:
    L34:
        return new c(r11);
    L16:
        e = move-exception;
        Log.e(f5405b, "Error in Data#fromByteArray: ", e);
    L12:
        Throwable e10 = e;
    L26:
        Log.e(f5405b, "Error in Data#fromByteArray: ", e10);     // Catch: Throwable -> L10
        if (r14 != null) goto L47;
    L32:
        r12.close();     // Catch: IOException -> L20
        goto L54
    L47:
        r14.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        Log.e(f5405b, "Error in Data#fromByteArray: ", e);
        goto L32
    L10:
        Throwable th = th;
    L35:
        if (0 != 0) goto L57;
    L49:
        r12.close();     // Catch: IOException -> L42
        throw th;
    L42:
        e = move-exception;
        Log.e(f5405b, "Error in Data#fromByteArray: ", e);
        throw th;
    L57:
        r13.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        Log.e(f5405b, "Error in Data#fromByteArray: ", e);
    L24:
        e = move-exception;
        r14 = null;
        e10 = e;
    L22:
        th = move-exception;
        th = th;
    L20:
        e = move-exception;
        Log.e(f5405b, "Error in Data#fromByteArray: ", e);
        goto L34
    L46:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public static byte[] k(c r10) {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = null;
        ObjectOutputStream r13 = new ObjectOutputStream(r11);     // Catch: Throwable -> L27 IOException -> L29
        r13.writeInt(r10.j());     // Catch: Throwable -> L9 IOException -> L11
        Iterator r14 = r10.f5407a.entrySet().iterator();     // Catch: Throwable -> L9 IOException -> L11
    L6:
        if (r14.hasNext() == false) goto L51;
        Map.Entry r15 = (Map.Entry) r14.next();     // Catch: Throwable -> L9 IOException -> L11
        r13.writeUTF((String) r15.getKey());     // Catch: Throwable -> L9 IOException -> L11
        r13.writeObject(r15.getValue());     // Catch: Throwable -> L9 IOException -> L11
    L51:
        r13.close();     // Catch: IOException -> L15
    L57:
        r11.close();     // Catch: IOException -> L19
    L22:
        if (r11.size() > 10240) goto L26;
        return r11.toByteArray();
    L26:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    L19:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
    L15:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
    L11:
        e = e;
        r12 = r13;
    L30:
        Log.e(f5405b, "Error in Data#toByteArray: ", e);     // Catch: Throwable -> L27
        byte[] r16 = r11.toByteArray();     // Catch: Throwable -> L27
        if (r12 != null) goto L63;
    L53:
        r11.close();     // Catch: IOException -> L38
    L40:
        return r16;
    L38:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
        goto L40
    L63:
        r12.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
    L9:
        th = th;
        r12 = r13;
    L41:
        if (r12 == null) goto L61;
        r12.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
    L61:
        r11.close();     // Catch: IOException -> L48
        throw th;
    L48:
        e = move-exception;
        Log.e(f5405b, "Error in Data#toByteArray: ", e);
        throw th;
    L27:
        th = th;
    L29:
        e = e;
        goto L30
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L32:
        return false;
    L8:
        if (c.class != r10.getClass()) goto L32;
        c r11 = (c) r10;
        Set r12 = this.f5407a.keySet();
        if (r12.equals(r11.f5407a.keySet()) == true) goto L13;
        return false;
    L13:
        Iterator r13 = r12.iterator();
    L15:
        if (r13.hasNext() == false) goto L31;
        String r14 = (String) r13.next();
        Object r15 = this.f5407a.get(r14);
        Object r16 = r11.f5407a.get(r14);
        if (r15 == null) goto L26;
        if (r16 == null) goto L26;
        if ((r15 instanceof Object[]) == true) goto L23;
    L25:
        boolean r17 = r15.equals(r16);
    L29:
        if (r17 == true) goto L15;
        return false;
    L23:
        if ((r16 instanceof Object[]) == false) goto L25;
        r17 = Arrays.deepEquals((Object[]) r15, (Object[]) r16);
    L26:
        if (r15 != r16) goto L28;
        r17 = true;
        goto L29
    L28:
        r17 = false;
        goto L29
    L31:
        return true;
    }

    public Map h() {
        return Collections.unmodifiableMap(this.f5407a);
    }

    public int hashCode() {
        return this.f5407a.hashCode() * 31;
    }

    public String i(String r10) {
        Object r11 = this.f5407a.get(r10);
        if ((r11 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r11;
    }

    public int j() {
        return this.f5407a.size();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("Data {");
        if (this.f5407a.isEmpty() == true) goto L12;
        Iterator r11 = this.f5407a.keySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L12;
        String r12 = (String) r11.next();
        r10.append(r12);
        r10.append(" : ");
        Object r13 = this.f5407a.get(r12);
        if ((r13 instanceof Object[]) == false) goto L10;
        r10.append(Arrays.toString((Object[]) r13));
    L11:
        r10.append(", ");
        goto L6
    L10:
        r10.append(r13);
    L12:
        r10.append("}");
        return r10.toString();
    }

    public c(Map r10) {
        this.f5407a = new HashMap(r10);
    }
}
