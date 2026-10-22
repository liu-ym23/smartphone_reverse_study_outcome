package bm3;

import androidx.camera.video.AudioStats;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f19574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f19580g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f19581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f19582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f19583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<String> f19584k;

    public static final class a {
        public static void a(c r100, b r101) throws IOException {
            r100.c();
            r101.f19584k.clear();
        L3:
            int r102 = r100.e();
            if (r102 == (-1)) goto L31;
            switch(r102) {
                case 1: goto L30;
                case 2: goto L27;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L13;
                case 8: goto L11;
                case 9: goto L9;
                case 10: goto L8;
                default: goto L7;
            };
        L7:
            throw new IllegalStateException("Unexpected tag: " + r102);
        L9:
            long r103 = r100.b();
            com.bytedance.android.tools.superkv.c r104 = r100.f19585a;
            r104.getClass();
            byte[] r105 = new byte[(int) r103];
            r104.f187613a.get(r105);
            r101.f19583j = r105;
            return;
        L11:
            r101.f19582i = r100.h();
            return;
        L13:
            r101.f19581h = Double.longBitsToDouble(r100.g());
            return;
        L15:
            r101.f19580g = Float.intBitsToFloat(r100.f());
            return;
        L17:
            r101.f19579f = r100.j();
            return;
        L19:
            r101.f19578e = r100.i();
            return;
        L21:
            boolean r106 = true;
            if (r100.i() == 1) goto L25;
            r106 = false;
        L25:
            r101.f19577d = r106;
            return;
        L27:
            int r107 = r100.i();
            r101.f19576c = r107;
            if (r107 != 0) goto L3;
            return;
        L30:
            r101.f19575b = r100.h();
            goto L3
        L8:
            r101.f19584k.add(r100.h());
            goto L3
        }
    }

    public final void c() {
        this.f19577d = false;
        this.f19578e = 0;
        this.f19579f = 0;
        this.f19580g = 0.0f;
        this.f19581h = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f19582i = null;
        this.f19583j = null;
        this.f19584k.clear();
    }

    public final int hashCode() {
        int r100 = this.f19574a;
        if (r100 != 0) goto L17;
        int r101 = ((this.f19575b.hashCode() * 37) + this.f19576c) * 37;
        if (this.f19577d == false) goto L7;
        int r102 = 1231;
    L8:
        int r103 = (((r101 + r102) * 37) + this.f19578e) * 37;
        long r104 = this.f19579f;
        int r105 = ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 37) + Float.floatToIntBits(this.f19580g);
        long r106 = Double.doubleToLongBits(this.f19581h);
        int r107 = ((r105 * 37) + ((int) (r106 ^ (r106 >>> 32)))) * 37;
        String r108 = this.f19582i;
        int r109 = 0;
        if (r108 == null) goto L11;
        int r110 = r108.hashCode();
    L12:
        int r111 = (r107 + r110) * 37;
        byte[] r112 = this.f19583j;
        if (r112 == null) goto L15;
        r109 = Arrays.hashCode(r112);
    L15:
        int r113 = ((r111 + r109) * 37) + this.f19584k.hashCode();
        this.f19574a = r113;
        return r113;
    L11:
        r110 = 0;
        goto L12
    L7:
        r102 = 1237;
        goto L8
    L17:
        return r100;
    }

    public final String toString() {
        return "KVProto{ key=" + this.f19575b + ", type=" + this.f19576c + ", booleanValue=" + this.f19577d + ", intValue=" + this.f19578e + ", longValue=" + this.f19579f + ", floatValue=" + this.f19580g + ", doubleValue=" + this.f19581h + ", stringValue=" + this.f19582i + ", bytesValue=" + Arrays.toString(this.f19583j) + ", stringListValue=" + this.f19584k + " }";
    }

    public b() {
        this.f19574a = 0;
        this.f19584k = new ArrayList();
    }

    public static String b(Integer r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        switch(r100.intValue()) {
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L17;
            case 7: goto L15;
            case 8: goto L13;
            case 9: goto L11;
            case 10: goto L9;
            default: goto L7;
        };
    L7:
        return "UNKNOWN";
    L9:
        return "StringList";
    L11:
        return "Bytes";
    L13:
        return "String";
    L15:
        return "Double";
    L17:
        return "Float";
    L19:
        return "Long";
    L21:
        return "Integer";
    L23:
        return "Boolean";
    L25:
        return "TYPE";
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (a(this.f19575b, r101.f19575b) == true) goto L11;
    L29:
        return false;
    L11:
        if (a(Integer.valueOf(this.f19576c), Integer.valueOf(r101.f19576c)) == false) goto L29;
        if (a(Boolean.valueOf(this.f19577d), Boolean.valueOf(r101.f19577d)) == false) goto L29;
        if (a(Integer.valueOf(this.f19578e), Integer.valueOf(r101.f19578e)) == false) goto L29;
        if (a(Long.valueOf(this.f19579f), Long.valueOf(r101.f19579f)) == false) goto L29;
        if (a(Float.valueOf(this.f19580g), Float.valueOf(r101.f19580g)) == false) goto L29;
        if (a(Double.valueOf(this.f19581h), Double.valueOf(r101.f19581h)) == false) goto L29;
        if (a(this.f19582i, r101.f19582i) == false) goto L29;
        if (Arrays.equals(this.f19583j, r101.f19583j) == false) goto L29;
        if (this.f19584k.equals(r101.f19584k) == false) goto L29;
        return true;
    }

    public static boolean a(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }
}
