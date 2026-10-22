package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.entity.ResultCode;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ExifInterface.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final c[] A = null;
    private static final c[] B = null;
    private static final c[] C = null;
    private static final c[] D = null;
    private static final c E = null;
    private static final c F = null;
    private static final HashMap<Integer, c>[] G = null;
    private static final HashMap<String, c>[] H = null;
    private static final HashSet<String> I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final HashMap<Integer, Integer> f1675J = null;
    private static final byte[] K = null;
    private static final String TAG = "ExifInterface";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f1676a = null;
    private static final Pattern ad = null;
    private static final Pattern ae = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1677b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1678c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final byte[] f1679d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String[] f1680e = null;
    static final int[] f = null;
    static final byte[] g = null;
    static final c[][] h = null;
    static final Charset i = null;
    static final byte[] j = null;
    private static final boolean k = false;
    private static final List<Integer> l = null;
    private static final List<Integer> m = null;
    private static final byte[] n = null;
    private static final byte[] o = null;
    private static final byte[] p = null;
    private static final byte[] q = null;
    private static final byte[] r = null;
    private static SimpleDateFormat s;
    private static final c[] t = null;
    private static final c[] u = null;
    private static final c[] v = null;
    private static final c[] w = null;
    private static final c[] x = null;
    private static final c y = null;
    private static final c[] z = null;
    private String L;
    private FileDescriptor M;
    private AssetManager.AssetInputStream N;
    private int O;
    private final HashMap<String, b>[] P;
    private Set<Integer> Q;
    private ByteOrder R;
    private boolean S;
    private int T;
    private int U;
    private byte[] V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private boolean ac;

    /* JADX INFO: renamed from: androidx.exifinterface.media.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ExifInterface.java */
    private static class C0054a extends InputStream implements DataInput {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ByteOrder f1681c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ByteOrder f1682d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1684b;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private DataInputStream f1685e;
        private ByteOrder f;

        static {
            f1681c = ByteOrder.LITTLE_ENDIAN;
            f1682d = ByteOrder.BIG_ENDIAN;
        }

        public C0054a(InputStream r2) {
            this.f = ByteOrder.BIG_ENDIAN;
            DataInputStream r0 = new DataInputStream(r2);
            this.f1685e = r0;
            int r3 = r0.available();
            this.f1683a = r3;
            this.f1684b = 0;
            this.f1685e.mark(r3);
        }

        public C0054a(byte[] r2) {
            this(new ByteArrayInputStream(r2));
        }

        public void a(ByteOrder r1) {
            this.f = r1;
        }

        public void a(long r4) {
            int r0 = this.f1684b;
            if (r0 <= r4) goto L5;
            this.f1684b = 0;
            this.f1685e.reset();
            this.f1685e.mark(this.f1683a);
        L6:
            int r5 = (int) r4;
            if (skipBytes(r5) != r5) goto L10;
            return;
        L10:
            throw new IOException("Couldn't seek up to the byteCount");
        L5:
            r4 = r4 - ((long) r0);
            goto L6
        }

        public int a() {
            return this.f1684b;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f1685e.available();
        }

        @Override // java.io.InputStream
        public int read() {
            this.f1684b++;
            return this.f1685e.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] r2, int r3, int r4) {
            int r5 = this.f1685e.read(r2, r3, r4);
            this.f1684b += r5;
            return r5;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f1684b++;
            return this.f1685e.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public String readLine() {
            a(a.TAG, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f1684b++;
            return this.f1685e.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f1684b += 2;
            return this.f1685e.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f1684b += 2;
            return this.f1685e.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r3, int r4, int r5) {
            int r0 = this.f1684b + r5;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L10;
            if (this.f1685e.read(r3, r4, r5) != r5) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] r3) {
            int r0 = this.f1684b + r3.length;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L10;
            if (this.f1685e.read(r3, 0, r3.length) != r3.length) goto L8;
            return;
        L8:
            throw new IOException("Couldn't read up to the length of buffer");
        L10:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            int r0 = this.f1684b + 1;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L11;
            int r2 = this.f1685e.read();
            if (r2 < 0) goto L9;
            return (byte) r2;
        L9:
            throw new EOFException();
        L11:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            int r0 = this.f1684b + 2;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L19;
            int r1 = this.f1685e.read();
            int r2 = this.f1685e.read();
            if ((r1 | r2) < 0) goto L17;
            ByteOrder r3 = this.f;
            if (r3 != f1681c) goto L12;
            int r4 = (r2 << 8) + r1;
        L10:
            return (short) r4;
        L12:
            if (r3 != f1682d) goto L15;
            r4 = (r1 << 8) + r2;
            goto L10
        L15:
            throw new IOException("Invalid byte order: " + this.f);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() {
            int r0 = this.f1684b + 4;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L19;
            int r1 = this.f1685e.read();
            int r2 = this.f1685e.read();
            int r3 = this.f1685e.read();
            int r4 = this.f1685e.read();
            if ((((r1 | r2) | r3) | r4) < 0) goto L17;
            ByteOrder r5 = this.f;
            if (r5 != f1681c) goto L11;
            return (((r4 << 24) + (r3 << 16)) + (r2 << 8)) + r1;
        L11:
            if (r5 != f1682d) goto L15;
            return (((r1 << 24) + (r2 << 16)) + (r3 << 8)) + r4;
        L15:
            throw new IOException("Invalid byte order: " + this.f);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int r4) {
            int r5 = Math.min(r4, this.f1683a - this.f1684b);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L5;
            r0 = r0 + this.f1685e.skipBytes(r5 - r0);
            goto L3
        L5:
            this.f1684b += r0;
            return r0;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            int r0 = this.f1684b + 2;
            this.f1684b = r0;
            if (r0 > this.f1683a) goto L19;
            int r1 = this.f1685e.read();
            int r2 = this.f1685e.read();
            if ((r1 | r2) < 0) goto L17;
            ByteOrder r3 = this.f;
            if (r3 != f1681c) goto L11;
            return (r2 << 8) + r1;
        L11:
            if (r3 != f1682d) goto L15;
            return (r1 << 8) + r2;
        L15:
            throw new IOException("Invalid byte order: " + this.f);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        public long b() {
            return ((long) readInt()) & 4294967295L;
        }

        @Override // java.io.DataInput
        public long readLong() {
            int r1 = this.f1684b + 8;
            this.f1684b = r1;
            if (r1 > this.f1683a) goto L19;
            int r2 = this.f1685e.read();
            int r3 = this.f1685e.read();
            int r4 = this.f1685e.read();
            int r5 = this.f1685e.read();
            int r6 = this.f1685e.read();
            int r7 = this.f1685e.read();
            int r8 = this.f1685e.read();
            int r9 = this.f1685e.read();
            if ((((((((r2 | r3) | r4) | r5) | r6) | r7) | r8) | r9) < 0) goto L17;
            ByteOrder r10 = this.f;
            if (r10 != f1681c) goto L11;
            return (((((((((long) r9) << 56) + (((long) r8) << 48)) + (((long) r7) << 40)) + (((long) r6) << 32)) + (((long) r5) << 24)) + (((long) r4) << 16)) + (((long) r3) << 8)) + ((long) r2);
        L11:
            if (r10 != f1682d) goto L15;
            return (((((((((long) r2) << 56) + (((long) r3) << 48)) + (((long) r4) << 40)) + (((long) r5) << 32)) + (((long) r6) << 24)) + (((long) r7) << 16)) + (((long) r8) << 8)) + ((long) r9);
        L15:
            throw new IOException("Invalid byte order: " + this.f);
        L17:
            throw new EOFException();
        L19:
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        public int c() {
            return this.f1683a;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f1688c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f1689d;

        b(int r7, int r8, byte[] r9) {
            this(r7, r8, -1, r9);
        }

        b(int r1, int r2, long r3, byte[] r5) {
            this.f1686a = r1;
            this.f1687b = r2;
            this.f1688c = r3;
            this.f1689d = r5;
        }

        public static b a(int[] r4, ByteOrder r5) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[a.f[3] * r4.length]);
            r0.order(r5);
            int r6 = r4.length;
            int r2 = 0;
        L3:
            if (r2 >= r6) goto L6;
            r0.putShort((short) r4[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new b(3, r4.length, r0.array());
        }

        public static b a(int r2, ByteOrder r3) {
            return a(new int[]{r2}, r3);
        }

        public static b a(long[] r5, ByteOrder r6) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[a.f[4] * r5.length]);
            r0.order(r6);
            int r7 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r7) goto L6;
            r0.putInt((int) r5[r2]);
            r2 = r2 + 1;
            goto L3
        L6:
            return new b(4, r5.length, r0.array());
        }

        public static b a(long r2, ByteOrder r4) {
            return a(new long[]{r2}, r4);
        }

        public static b a(String r3) {
            byte[] r4 = (r3 + 0).getBytes(a.i);
            return new b(2, r4.length, r4);
        }

        public static b a(d[] r6, ByteOrder r7) {
            ByteBuffer r0 = ByteBuffer.wrap(new byte[a.f[5] * r6.length]);
            r0.order(r7);
            int r8 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r8) goto L6;
            d r3 = r6[r2];
            r0.putInt((int) r3.f1694a);
            r0.putInt((int) r3.f1695b);
            r2 = r2 + 1;
            goto L3
        L6:
            return new b(5, r6.length, r0.array());
        }

        public static b a(d r2, ByteOrder r3) {
            return a(new d[]{r2}, r3);
        }

        public String toString() {
            return "(" + a.f1680e[this.f1686a] + ", data length:" + this.f1689d.length + ")";
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a4: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x01a4 */
        Object a(ByteOrder r11) {
            C0054a r2 = null;
            C0054a r3 = new C0054a(this.f1689d);     // Catch: Throwable -> L140 IOException -> L142
            r3.a(r11);     // Catch: IOException -> L138 Throwable -> L151
            boolean r4 = true;
            int r5 = 0;
            switch(this.f1686a) {
                case 1: goto L115;
                case 2: goto L88;
                case 3: goto L77;
                case 4: goto L67;
                case 5: goto L57;
                case 6: goto L115;
                case 7: goto L88;
                case 8: goto L47;
                case 9: goto L37;
                case 10: goto L27;
                case 11: goto L17;
                case 12: goto L7;
                default: goto L177;
            };     // Catch: IOException -> L138 Throwable -> L151
        L7:
            double[] r12 = new double[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L9:
            if (r5 >= this.f1687b) goto L166;
            r12[r5] = r3.readDouble();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L9
        L166:
            r3.close();     // Catch: IOException -> L14
        L16:
            return r12;
        L14:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L16
        L17:
            double[] r13 = new double[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L19:
            if (r5 >= this.f1687b) goto L175;
            r13[r5] = r3.readFloat();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L19
        L175:
            r3.close();     // Catch: IOException -> L24
        L26:
            return r13;
        L24:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L26
        L27:
            d[] r14 = new d[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L29:
            if (r5 >= this.f1687b) goto L164;
            r14[r5] = new d(r3.readInt(), r3.readInt());     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L29
        L164:
            r3.close();     // Catch: IOException -> L34
        L36:
            return r14;
        L34:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L36
        L37:
            int[] r15 = new int[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L39:
            if (r5 >= this.f1687b) goto L173;
            r15[r5] = r3.readInt();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L39
        L173:
            r3.close();     // Catch: IOException -> L44
        L46:
            return r15;
        L44:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L46
        L47:
            int[] r16 = new int[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L49:
            if (r5 >= this.f1687b) goto L181;
            r16[r5] = r3.readShort();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L49
        L181:
            r3.close();     // Catch: IOException -> L54
        L56:
            return r16;
        L54:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L56
        L57:
            d[] r17 = new d[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L59:
            if (r5 >= this.f1687b) goto L179;
            r17[r5] = new d(r3.b(), r3.b());     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L59
        L179:
            r3.close();     // Catch: IOException -> L64
        L66:
            return r17;
        L64:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L66
        L67:
            long[] r18 = new long[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L69:
            if (r5 >= this.f1687b) goto L187;
            r18[r5] = r3.b();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L69
        L187:
            r3.close();     // Catch: IOException -> L74
        L76:
            return r18;
        L74:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L76
        L77:
            int[] r19 = new int[this.f1687b];     // Catch: IOException -> L138 Throwable -> L151
        L79:
            if (r5 >= this.f1687b) goto L159;
            r19[r5] = r3.readUnsignedShort();     // Catch: IOException -> L138 Throwable -> L151
            r5 = r5 + 1;
            goto L79
        L159:
            r3.close();     // Catch: IOException -> L84
        L86:
            return r19;
        L84:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L86
        L115:
            byte[] r110 = this.f1689d;     // Catch: IOException -> L138 Throwable -> L151
            if (r110.length == 1) goto L118;
        L127:
            String r111 = new String(this.f1689d, a.i);     // Catch: IOException -> L138 Throwable -> L151
            r3.close();     // Catch: IOException -> L130
        L132:
            return r111;
        L130:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L132
        L118:
            if (r110[0] < 0) goto L127;
            if (r110[0] > 1) goto L127;
            String r112 = new String(new char[]{(char) (this.f1689d[0] + 48)});     // Catch: IOException -> L138 Throwable -> L151
            r3.close();     // Catch: IOException -> L124
        L126:
            return r112;
        L124:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L126
        L177:
            r3.close();     // Catch: IOException -> L135
        L137:
            return null;
        L135:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L137
        L88:
            if (this.f1687b < a.g.length) goto L98;
            int r113 = 0;
        L91:
            if (r113 >= a.g.length) goto L96;
            if (this.f1689d[r113] != a.g[r113]) goto L94;
            r113 = r113 + 1;     // Catch: IOException -> L138 Throwable -> L151
            goto L91
        L94:
            r4 = false;
        L96:
            if (r4 == false) goto L98;
            r5 = a.g.length;     // Catch: IOException -> L138 Throwable -> L151
        L98:
            StringBuilder r114 = new StringBuilder();     // Catch: IOException -> L138 Throwable -> L151
        L100:
            if (r5 >= this.f1687b) goto L109;
            byte r6 = this.f1689d[r5];     // Catch: IOException -> L138 Throwable -> L151
            if (r6 == 0) goto L109;
            if (r6 < 32) goto L107;
            r114.append((char) r6);     // Catch: IOException -> L138 Throwable -> L151
        L108:
            r5 = r5 + 1;     // Catch: IOException -> L138 Throwable -> L151
            goto L100
        L107:
            r114.append('?');     // Catch: IOException -> L138 Throwable -> L151
        L109:
            String r10 = r114.toString();     // Catch: IOException -> L138 Throwable -> L151
            r3.close();     // Catch: IOException -> L112
        L114:
            return r10;
        L112:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
        L138:
            e = e;
        L144:
            b(a.TAG, "IOException occurred during reading a value", e);     // Catch: Throwable -> L151
            if (r3 != null) goto L185;
        L150:
            return null;
        L185:
            r3.close();     // Catch: IOException -> L148
        L148:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
            goto L150
        L151:
            th = th;
            r2 = r3;
        L153:
            if (r2 != null) goto L169;
        L158:
            throw th;
        L169:
            r2.close();     // Catch: IOException -> L156
        L156:
            e = move-exception;
            a(a.TAG, "IOException occurred while closing InputStream", e);
        L142:
            e = e;
            r3 = null;
        L140:
            th = th;
            goto L153
        }

        public double b(ByteOrder r8) {
            Object r7 = a(r8);
            if (r7 == null) goto L43;
            if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L9;
            return Double.parseDouble((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin"));
        L9:
            if ((r7 instanceof long[]) == false) goto L17;
            long[] r9 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r7, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
            if (r9.length != 1) goto L15;
            return r9[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r7 instanceof int[]) == false) goto L25;
            int[] r10 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r7, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
            if (r10.length != 1) goto L23;
            return r10[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            if ((r7 instanceof double[]) == false) goto L33;
            double[] r11 = (double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r7, double[].class, "com.obric.aiagent.plugin"), double[].class, "com.obric.aiagent.plugin");
            if (r11.length != 1) goto L31;
            return r11[0];
        L31:
            throw new NumberFormatException("There are more than one component");
        L33:
            if ((r7 instanceof d[]) == false) goto L41;
            d[] r12 = (d[]) ZeusTransformUtils.preCheckCast((d[]) ZeusTransformUtils.preCheckCast(r7, d[].class, "com.obric.aiagent.plugin"), d[].class, "com.obric.aiagent.plugin");
            if (r12.length != 1) goto L39;
            return r12[0].a();
        L39:
            throw new NumberFormatException("There are more than one component");
        L41:
            throw new NumberFormatException("Couldn't find a double value");
        L43:
            throw new NumberFormatException("NULL can't be converted to a double value");
        }

        public int c(ByteOrder r7) {
            Object r6 = a(r7);
            if (r6 == null) goto L27;
            if (ZeusTransformUtils.instanceOf(r6, String.class) == false) goto L9;
            return Integer.parseInt((String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.aiagent.plugin"));
        L9:
            if ((r6 instanceof long[]) == false) goto L17;
            long[] r8 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r6, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
            if (r8.length != 1) goto L15;
            return (int) r8[0];
        L15:
            throw new NumberFormatException("There are more than one component");
        L17:
            if ((r6 instanceof int[]) == false) goto L25;
            int[] r9 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r6, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
            if (r9.length != 1) goto L23;
            return r9[0];
        L23:
            throw new NumberFormatException("There are more than one component");
        L25:
            throw new NumberFormatException("Couldn't find a integer value");
        L27:
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String d(ByteOrder r9) {
            Object r8 = a(r9);
            if (r8 != null) goto L6;
            return null;
        L6:
            if (ZeusTransformUtils.instanceOf(r8, String.class) == true) goto L8;
            StringBuilder r3 = new StringBuilder();
            int r7 = 0;
            if ((r8 instanceof long[]) == false) goto L20;
            long[] r10 = (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r8, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
        L13:
            if (r7 >= r10.length) goto L18;
            r3.append(r10[r7]);
            r7 = r7 + 1;
            if (r7 == r10.length) goto L13;
            r3.append(",");
            goto L13
        L18:
            return r3.toString();
        L20:
            if ((r8 instanceof int[]) == false) goto L30;
            int[] r11 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        L23:
            if (r7 >= r11.length) goto L28;
            r3.append(r11[r7]);
            r7 = r7 + 1;
            if (r7 == r11.length) goto L23;
            r3.append(",");
            goto L23
        L28:
            return r3.toString();
        L30:
            if ((r8 instanceof double[]) == false) goto L40;
            double[] r12 = (double[]) ZeusTransformUtils.preCheckCast((double[]) ZeusTransformUtils.preCheckCast(r8, double[].class, "com.obric.aiagent.plugin"), double[].class, "com.obric.aiagent.plugin");
        L33:
            if (r7 >= r12.length) goto L38;
            r3.append(r12[r7]);
            r7 = r7 + 1;
            if (r7 == r12.length) goto L33;
            r3.append(",");
            goto L33
        L38:
            return r3.toString();
        L40:
            if ((r8 instanceof d[]) == false) goto L49;
            d[] r13 = (d[]) ZeusTransformUtils.preCheckCast((d[]) ZeusTransformUtils.preCheckCast(r8, d[].class, "com.obric.aiagent.plugin"), d[].class, "com.obric.aiagent.plugin");
        L43:
            if (r7 >= r13.length) goto L48;
            r3.append(r13[r7].f1694a);
            r3.append('/');
            r3.append(r13[r7].f1695b);
            r7 = r7 + 1;
            if (r7 == r13.length) goto L43;
            r3.append(",");
            goto L43
        L48:
            return r3.toString();
        L49:
            return null;
        L8:
            return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r1, String r2, Throwable r3) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2, r3);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1, Throwable r2) {
            return Log.e(r0, r1, r2);
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f1691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1693d;

        c(String r1, int r2, int r3) {
            this.f1691b = r1;
            this.f1690a = r2;
            this.f1692c = r3;
            this.f1693d = -1;
        }

        c(String r1, int r2, int r3, int r4) {
            this.f1691b = r1;
            this.f1690a = r2;
            this.f1692c = r3;
            this.f1693d = r4;
        }

        boolean a(int r4) {
            int r0 = this.f1692c;
            if (r0 == 7) goto L30;
            if (r4 == 7) goto L30;
            if (r0 == r4) goto L30;
            int r3 = this.f1693d;
            if (r3 == r4) goto L30;
            if (r0 == 4) goto L14;
            if (r3 == 4) goto L14;
        L17:
            if (r0 == 9) goto L20;
            if (r3 == 9) goto L20;
        L23:
            if (r0 == 12) goto L26;
            if (r3 == 12) goto L26;
            return false;
        L26:
            if (r4 != 11) goto L31;
            return true;
        L31:
            return false;
        L20:
            if (r4 != 8) goto L23;
            return true;
        L14:
            if (r4 != 3) goto L17;
            return true;
        L30:
            return true;
        }
    }

    /* JADX INFO: compiled from: ExifInterface.java */
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f1694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1695b;

        d(long r4, long r6) {
            if (r6 != 0) goto L6;
            this.f1694a = 0;
            this.f1695b = 1;
            return;
        L6:
            this.f1694a = r4;
            this.f1695b = r6;
        }

        public String toString() {
            return this.f1694a + "/" + this.f1695b;
        }

        public double a() {
            return this.f1694a / this.f1695b;
        }
    }

    static {
        k = b(TAG, 3);
        l = Arrays.asList(new Integer[]{1, 6, 3, 8});
        m = Arrays.asList(new Integer[]{2, 7, 4, 5});
        f1676a = new int[]{8, 8, 8};
        f1677b = new int[]{4};
        f1678c = new int[]{8};
        f1679d = new byte[]{-1, -40, -1};
        n = new byte[]{102, 116, 121, 112};
        o = new byte[]{109, 105, 102, 49};
        p = new byte[]{104, 101, 105, 99};
        q = new byte[]{79, 76, 89, 77, 80, 0};
        r = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        f1680e = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        f = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        g = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        c[] r3 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED, 2), new c("DateTime", ResultCode.ERROR_MEMORY_SERVICE_DISABLED, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7), new c("Xmp", 700, 1)};
        t = r3;
        c[] r6 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        u = r6;
        c[] r4 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        v = r4;
        c[] r7 = {new c("InteroperabilityIndex", 1, 2)};
        w = r7;
        c[] r10 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("ThumbnailOrientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", ResultCode.ERROR_CREDENTIAL_ENCRYPTED_STORAGE_LOCKED, 2), new c("DateTime", ResultCode.ERROR_MEMORY_SERVICE_DISABLED, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        x = r10;
        y = new c("StripOffsets", 273, 3);
        c[] r0 = {new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        z = r0;
        c[] r1 = {new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        A = r1;
        c[] r8 = {new c("AspectFrame", 4371, 3)};
        B = r8;
        c[] r14 = {new c("ColorSpace", 55, 3)};
        C = r14;
        c[][] r11 = {r3, r6, r4, r7, r10, r3, r0, r1, r8, r14};
        h = r11;
        D = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        E = new c("JPEGInterchangeFormat", 513, 4);
        F = new c("JPEGInterchangeFormatLength", 514, 4);
        G = new HashMap[r11.length];
        H = new HashMap[r11.length];
        I = new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"}));
        f1675J = new HashMap();
        Charset r2 = Charset.forName("US-ASCII");
        i = r2;
        j = "Exif\u0000\u0000".getBytes(r2);
        K = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(r2);
        SimpleDateFormat r5 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        s = r5;
        r5.setTimeZone(TimeZone.getTimeZone("UTC"));
        int r12 = 0;
    L3:
        c[][] r9 = h;
        if (r12 >= r9.length) goto L9;
        G[r12] = new HashMap();
        H[r12] = new HashMap();
        c[] r13 = r9[r12];
        int r15 = r13.length;
        int r16 = 0;
    L6:
        if (r16 >= r15) goto L8;
        c r17 = r13[r16];
        G[r12].put(Integer.valueOf(r17.f1690a), r17);
        H[r12].put(r17.f1691b, r17);
        r16 = r16 + 1;
        goto L6
    L8:
        r12 = r12 + 1;
        goto L3
    L9:
        HashMap<Integer, Integer> r18 = f1675J;
        c[] r19 = D;
        r18.put(Integer.valueOf(r19[0].f1690a), 5);
        r18.put(Integer.valueOf(r19[1].f1690a), 1);
        r18.put(Integer.valueOf(r19[2].f1690a), 2);
        r18.put(Integer.valueOf(r19[3].f1690a), 3);
        r18.put(Integer.valueOf(r19[4].f1690a), 7);
        r18.put(Integer.valueOf(r19[5].f1690a), 8);
        ad = Pattern.compile(".*[1-9].*");
        ae = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public a(String r3) {
        c[][] r0 = h;
        this.P = new HashMap[r0.length];
        this.Q = new HashSet(r0.length);
        this.R = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(r3, "filename cannot be null");
        c(r3);
    }

    public a(InputStream r4) {
        c[][] r0 = h;
        this.P = new HashMap[r0.length];
        this.Q = new HashSet(r0.length);
        this.R = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(r4, "inputStream cannot be null");
        this.L = null;
        if (ZeusTransformUtils.instanceOf(r4, AssetManager.AssetInputStream.class) == false) goto L6;
        this.N = (AssetManager.AssetInputStream) ZeusTransformUtils.preCheckCast(r4, AssetManager.AssetInputStream.class, "com.obric.aiagent.plugin");
        this.M = null;
    L11:
        a(r4);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, FileInputStream.class) == true) goto L8;
    L10:
        this.N = null;
        this.M = null;
        goto L11
    L8:
        if (a(((FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.aiagent.plugin")).getFD()) == false) goto L10;
        this.N = null;
        this.M = ((FileInputStream) ZeusTransformUtils.preCheckCast(r4, FileInputStream.class, "com.obric.aiagent.plugin")).getFD();
        goto L11
    }

    private b b(String r5) {
        Objects.requireNonNull(r5, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(r5) == true) goto L5;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= h.length) goto L15;
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.P[r0].get(r5), b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        r0 = r0 + 1;
        goto L10
    L13:
        return r1;
    L15:
        return null;
    L5:
        if (k == false) goto L7;
        a(TAG, "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
    L7:
        r5 = "PhotographicSensitivity";
        goto L8
    }

    public String a(String r5) {
        Objects.requireNonNull(r5, "tag shouldn't be null");
        b r0 = b(r5);
        if (r0 != null) goto L5;
    L27:
        return null;
    L5:
        if (I.contains(r5) == true) goto L9;
        return r0.d(this.R);
    L9:
        if (r5.equals("GPSTimeStamp") == true) goto L11;
        return Double.toString(r0.b(this.R));
    L11:
        if (r0.f1686a != 5) goto L13;
    L16:
        d[] r4 = (d[]) ZeusTransformUtils.preCheckCast((d[]) ZeusTransformUtils.preCheckCast(r0.a(this.R), d[].class, "com.obric.aiagent.plugin"), d[].class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L19;
    L23:
        b(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(r4));
        return null;
    L19:
        if (r4.length != 3) goto L23;
        return String.format("%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (r4[0].f1694a / r4[0].f1695b)), Integer.valueOf((int) (r4[1].f1694a / r4[1].f1695b)), Integer.valueOf((int) (r4[2].f1694a / r4[2].f1695b))});
    L13:
        if (r0.f1686a == 10) goto L16;
        b(TAG, "GPS Timestamp format is not rational. format=" + r0.f1686a);
        return null;
    }

    public int a(String r2, int r3) {
        Objects.requireNonNull(r2, "tag shouldn't be null");
        b r4 = b(r2);
        if (r4 != null) goto L8;
        return r3;
    L8:
        return r4.c(this.R);
    L7:
        return r3;
    }

    private void a(InputStream r5) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "inputstream shouldn't be null"
            java.util.Objects.requireNonNull(r5, r0)
            r0 = 0
            r1 = r0
        L7:
            androidx.exifinterface.media.a$c[][] r2 = androidx.exifinterface.media.a.h     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            int r2 = r2.length     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            if (r1 >= r2) goto L18
            java.util.HashMap<java.lang.String, androidx.exifinterface.media.a$b>[] r2 = r4.P     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            java.util.HashMap r3 = new java.util.HashMap     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r3.<init>()     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r2[r1] = r3     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            int r1 = r1 + 1
            goto L7
        L18:
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r2 = 5000(0x1388, float:7.006E-42)
            r1.<init>(r5, r2)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            java.lang.Class<java.io.BufferedInputStream> r5 = java.io.BufferedInputStream.class
            java.lang.String r2 = "com.obric.aiagent.plugin"
            java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, r5, r2)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            java.io.BufferedInputStream r5 = (java.io.BufferedInputStream) r5     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            int r5 = r4.a(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r4.O = r5     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            androidx.exifinterface.media.a$a r5 = new androidx.exifinterface.media.a$a     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            int r1 = r4.O     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            switch(r1) {
                case 0: goto L4e;
                case 1: goto L4e;
                case 2: goto L4e;
                case 3: goto L4e;
                case 4: goto L4a;
                case 5: goto L4e;
                case 6: goto L4e;
                case 7: goto L46;
                case 8: goto L4e;
                case 9: goto L42;
                case 10: goto L3e;
                case 11: goto L4e;
                case 12: goto L3a;
                default: goto L39;
            }     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
        L39:
            goto L51
        L3a:
            r4.c(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            goto L51
        L3e:
            r4.e(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            goto L51
        L42:
            r4.b(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            goto L51
        L46:
            r4.d(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            goto L51
        L4a:
            r4.a(r5, r0, r0)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            goto L51
        L4e:
            r4.a(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
        L51:
            r4.g(r5)     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r5 = 1
            r4.ac = r5     // Catch: java.lang.Throwable -> L5f java.io.IOException -> L61
            r4.b()
            boolean r5 = androidx.exifinterface.media.a.k
            if (r5 == 0) goto L77
            goto L74
        L5f:
            r5 = move-exception
            goto L78
        L61:
            r5 = move-exception
            r4.ac = r0     // Catch: java.lang.Throwable -> L5f
            boolean r0 = androidx.exifinterface.media.a.k     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L6f
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            a(r1, r2, r5)     // Catch: java.lang.Throwable -> L5f
        L6f:
            r4.b()
            if (r0 == 0) goto L77
        L74:
            r4.a()
        L77:
            return
        L78:
            r4.b()
            boolean r0 = androidx.exifinterface.media.a.k
            if (r0 == 0) goto L82
            r4.a()
        L82:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.a.a(java.io.InputStream):void");
    }

    private static boolean a(FileDescriptor r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L10;
    L8:
        return false;
    L10:
        Os.lseek(r4, 0, OsConstants.SEEK_CUR);     // Catch: Exception -> L9
        return true;
    }

    private void a() {
        int r0 = 0;
    L4:
        if (r0 >= this.P.length) goto L10;
        a(TAG, "The size of tag group[" + r0 + "]: " + this.P[r0].size());
        Iterator<Map.Entry<String, b>> r1 = this.P[r0].entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(r3.getValue(), b.class, "com.obric.aiagent.plugin");
        a(TAG, "tagName: " + ((String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.aiagent.plugin")) + ", tagType: " + r4.toString() + ", tagValue: '" + r4.d(this.R) + "'");
        goto L7
    L9:
        r0 = r0 + 1;
        goto L4
    }

    private void c(String r3) {
        Objects.requireNonNull(r3, "filename cannot be null");
        FileInputStream r0 = null;
        this.N = null;
        this.L = r3;
        FileInputStream r1 = new FileInputStream(r3);     // Catch: Throwable -> L13
    L11:
        th = th;
        r0 = r1;
    L14:
        a(r0);
        throw th;
    L5:
        if (a(r1.getFD()) == false) goto L7;
        this.M = r1.getFD();     // Catch: Throwable -> L11
    L8:
        a(r1);     // Catch: Throwable -> L11
        a(r1);
        return;
    L7:
        this.M = null;     // Catch: Throwable -> L11
    L13:
        th = th;
        goto L14
    }

    private int a(BufferedInputStream r2) {
        r2.mark(DownloadSettingValues.SYNC_INTERVAL_MS_FG);
        byte[] r0 = new byte[DownloadSettingValues.SYNC_INTERVAL_MS_FG];
        r2.read(r0);
        r2.reset();
        if (a(r0) == false) goto L7;
        return 4;
    L7:
        if (b(r0) == false) goto L11;
        return 9;
    L11:
        if (c(r0) == false) goto L15;
        return 12;
    L15:
        if (d(r0) == false) goto L19;
        return 7;
    L19:
        if (e(r0) == false) goto L22;
        return 10;
    L22:
        return 0;
    }

    private static boolean a(byte[] r4) {
        int r1 = 0;
    L3:
        byte[] r2 = f1679d;
        if (r1 >= r2.length) goto L9;
        if (r4[r1] != r2[r1]) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return false;
    L9:
        return true;
    }

    private boolean b(byte[] r5) {
        byte[] r4 = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int r1 = 0;
    L4:
        if (r1 >= r4.length) goto L9;
        if (r5[r1] != r4[r1]) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private boolean c(byte[] r14) {
        C0054a r0 = null;
        C0054a r1 = new C0054a(r14);     // Catch: Throwable -> L50 Exception -> L52
        r1.a(ByteOrder.BIG_ENDIAN);     // Catch: Throwable -> L46 Exception -> L48
        long r2 = r1.readInt();     // Catch: Throwable -> L46 Exception -> L48
        byte[] r4 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        r1.read(r4);     // Catch: Throwable -> L46 Exception -> L48
        if (Arrays.equals(r4, n) == true) goto L8;
        r1.close();
        return false;
    L8:
        long r7 = 16;
        if (r2 != 1) goto L15;
        r2 = r1.readLong();     // Catch: Throwable -> L46 Exception -> L48
        if (r2 >= 16) goto L17;
        r1.close();
        return false;
    L17:
        if (r2 > r14.length) goto L19;
    L20:
        long r3 = r2 - r7;
        if (r3 >= 8) goto L24;
        r1.close();
        return false;
    L24:
        byte[] r15 = new byte[4];     // Catch: Throwable -> L46 Exception -> L48
        long r6 = 0;
        boolean r8 = false;
        boolean r9 = false;
    L25:
        if (r6 >= (r3 / 4)) goto L45;
        if (r1.read(r15) != 4) goto L29;
        if (r6 == 1) goto L44;
        if (Arrays.equals(r15, o) == false) goto L38;
        r8 = true;
    L40:
        if (r8 == false) goto L44;
        if (r9 == false) goto L44;
        r1.close();
        return true;
    L38:
        if (Arrays.equals(r15, p) == false) goto L40;
        r9 = true;
    L44:
        r6 = r6 + 1;
        goto L25
    L29:
        r1.close();
        return false;
    L45:
        r1.close();
    L58:
        return false;
    L19:
        r2 = r14.length;     // Catch: Throwable -> L46 Exception -> L48
        goto L20
    L15:
        r7 = 8;
    L48:
        e = e;
        r0 = r1;
    L54:
        if (k == false) goto L56;
        b(TAG, "Exception parsing HEIF file type box.", e);     // Catch: Throwable -> L50
    L56:
        if (r0 == null) goto L58;
        r0.close();
    L46:
        th = th;
        r0 = r1;
    L59:
        if (r0 == null) goto L61;
        r0.close();
    L61:
        throw th;
    L50:
        th = th;
    L52:
        e = e;
        goto L54
    }

    private boolean d(byte[] r2) {
        C0054a r0 = new C0054a(r2);
        ByteOrder r3 = f(r0);
        this.R = r3;
        r0.a(r3);
        short r1 = r0.readShort();
        r0.close();
        if (r1 != 20306) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 21330) goto L8;
        return false;
    }

    private boolean e(byte[] r2) {
        C0054a r0 = new C0054a(r2);
        ByteOrder r3 = f(r0);
        this.R = r3;
        r0.a(r3);
        short r1 = r0.readShort();
        r0.close();
        if (r1 != 85) goto L5;
        return true;
    L5:
        return false;
    }

    private void a(C0054a r21, int r22, int r23) {
        if (k == false) goto L5;
        a(TAG, "getJpegAttributes starting with: " + r21);
    L5:
        r21.a(ByteOrder.BIG_ENDIAN);
        r21.a(r22);
        byte r4 = r21.readByte();
        if (r4 != (-1)) goto L73;
        int r2 = r22 + 1;
        if (r21.readByte() != (-40)) goto L71;
        int r3 = r2 + 1;
    L10:
        byte r5 = r21.readByte();
        if (r5 != (-1)) goto L69;
        int r6 = r3 + 1;
        byte r7 = r21.readByte();
        boolean r8 = k;
        if (r8 == false) goto L15;
        a(TAG, "Found JPEG segment indicator: " + Integer.toHexString(r7 & 255));
    L15:
        int r9 = r6 + 1;
        if (r7 == (-39)) goto L66;
        if (r7 == (-38)) goto L66;
        int r10 = r21.readUnsignedShort() - 2;
        int r11 = r9 + 2;
        if (r8 == false) goto L24;
        a(TAG, "JPEG segment: " + Integer.toHexString(r7 & 255) + " (length: " + (r10 + 2) + ")");
    L24:
        if (r10 < 0) goto L65;
        if (r7 != (-31)) goto L28;
        byte[] r12 = new byte[r10];
        r21.readFully(r12);
        int r13 = r11 + r10;
        byte[] r14 = j;
        if (a(r12, r14) == false) goto L42;
        long r15 = r11 + r14.length;
        a(Arrays.copyOfRange(r12, r14.length, r10), r23);
        this.X = (int) r15;
    L47:
        r11 = r13;
        r10 = 0;
    L48:
        byte[] r16 = new byte[r10];
        if (r21.read(r16) != r10) goto L63;
        if (a("UserComment") != null) goto L53;
        this.P[1].put("UserComment", b.a(new String(r16, i)));
    L53:
        r10 = 0;
    L54:
        if (r10 < 0) goto L61;
        if (r21.skipBytes(r10) != r10) goto L59;
        r3 = r11 + r10;
        goto L10
    L59:
        throw new IOException("Invalid JPEG segment");
    L61:
        throw new IOException("Invalid length");
    L63:
        throw new IOException("Invalid exif");
    L42:
        byte[] r17 = K;
        if (a(r12, r17) == false) goto L47;
        long r18 = r11 + r17.length;
        byte[] r19 = Arrays.copyOfRange(r12, r17.length, r10);
        if (a("Xmp") != null) goto L47;
        this.P[0].put("Xmp", new b(1, r19.length, r18, r19));
        goto L47
    L28:
        if (r7 == (-2)) goto L48;
        switch(r7) {
            case -64: goto L35;
            case -63: goto L35;
            case -62: goto L35;
            case -61: goto L35;
            default: goto L30;
        };
    L30:
        switch(r7) {
            case -59: goto L35;
            case -58: goto L35;
            case -57: goto L35;
            default: goto L31;
        };
    L31:
        switch(r7) {
            case -55: goto L35;
            case -54: goto L35;
            case -53: goto L35;
            default: goto L32;
        };
    L32:
        switch(r7) {
            case -51: goto L35;
            case -50: goto L35;
            case -49: goto L35;
            default: goto L54;
        };
    L35:
        if (r21.skipBytes(1) != 1) goto L38;
        this.P[r23].put("ImageLength", b.a(r21.readUnsignedShort(), this.R));
        this.P[r23].put("ImageWidth", b.a(r21.readUnsignedShort(), this.R));
        r10 = r10 - 5;
        goto L54
    L38:
        throw new IOException("Invalid SOFx");
    L65:
        throw new IOException("Invalid length");
    L66:
        r21.a(this.R);
        return;
    L69:
        throw new IOException("Invalid marker:" + Integer.toHexString(r5 & 255));
    L71:
        throw new IOException("Invalid marker: " + Integer.toHexString(r4 & 255));
    L73:
        throw new IOException("Invalid marker: " + Integer.toHexString(r4 & 255));
    }

    private void a(C0054a r6) {
        a(r6, r6.available());
        b(r6, 0);
        d(r6, 0);
        d(r6, 5);
        d(r6, 4);
        b(r6);
        if (this.O != 8) goto L10;
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.P[1].get("MakerNote"), b.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L11;
        C0054a r1 = new C0054a(r7.f1689d);
        r1.a(this.R);
        r1.a(6);
        b(r1, 9);
        b r8 = (b) ZeusTransformUtils.preCheckCast(this.P[9].get("ColorSpace"), b.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L12;
        this.P[1].put("ColorSpace", r8);
        return;
    L12:
        return;
    L11:
        return;
    }

    private void b(C0054a r8) {
        r8.skipBytes(84);
        byte[] r1 = new byte[4];
        byte[] r2 = new byte[4];
        r8.read(r1);
        r8.skipBytes(4);
        r8.read(r2);
        int r0 = ByteBuffer.wrap(r1).getInt();
        int r3 = ByteBuffer.wrap(r2).getInt();
        a(r8, r0, 5);
        r8.a(r3);
        r8.a(ByteOrder.BIG_ENDIAN);
        int r4 = r8.readInt();
        if (k == false) goto L5;
        a(TAG, "numberOfDirectoryEntry: " + r4);
    L5:
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L14;
        int r6 = r8.readUnsignedShort();
        int r7 = r8.readUnsignedShort();
        if (r6 == y.f1690a) goto L9;
        r8.skipBytes(r7);
        r5 = r5 + 1;
        goto L6
    L9:
        short r9 = r8.readShort();
        short r10 = r8.readShort();
        b r11 = b.a(r9, this.R);
        b r12 = b.a(r10, this.R);
        this.P[0].put("ImageLength", r11);
        this.P[0].put("ImageWidth", r12);
        if (k == false) goto L17;
        a(TAG, "Updated to length: " + r9 + ", width: " + r10);
        return;
    L17:
        return;
    }

    private void c(final C0054a r13) {
        MediaMetadataRetriever r1 = new MediaMetadataRetriever();
    L63:
        th = move-exception;
        r1.release();
        throw th;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        r1.setDataSource(new ExifInterface$1(this, r13));     // Catch: Throwable -> L63
    L12:
        String r2 = r1.extractMetadata(33);     // Catch: Throwable -> L63
        String r3 = r1.extractMetadata(34);     // Catch: Throwable -> L63
        String r4 = r1.extractMetadata(26);     // Catch: Throwable -> L63
        String r5 = r1.extractMetadata(17);     // Catch: Throwable -> L63
        String r6 = null;
        if ("yes".equals(r4) == false) goto L16;
        r6 = r1.extractMetadata(29);     // Catch: Throwable -> L63
        String r0 = r1.extractMetadata(30);     // Catch: Throwable -> L63
        String r7 = r1.extractMetadata(31);     // Catch: Throwable -> L63
    L20:
        if (r6 == null) goto L22;
        this.P[0].put("ImageWidth", b.a(Integer.parseInt(r6), this.R));     // Catch: Throwable -> L63
    L22:
        if (r0 == null) goto L25;
        this.P[0].put("ImageLength", b.a(Integer.parseInt(r0), this.R));     // Catch: Throwable -> L63
    L25:
        if (r7 == null) goto L37;
        int r8 = 1;
        int r9 = Integer.parseInt(r7);     // Catch: Throwable -> L63
        if (r9 != 90) goto L29;
        r8 = 6;
    L36:
        this.P[0].put("Orientation", b.a(r8, this.R));     // Catch: Throwable -> L63
        goto L37
    L29:
        if (r9 != 180) goto L31;
        r8 = 3;
        goto L36
    L31:
        if (r9 != 270) goto L36;
        r8 = 8;
    L37:
        if (r2 == null) goto L57;
        if (r3 == null) goto L57;
        int r10 = Integer.parseInt(r2);     // Catch: Throwable -> L63
        int r11 = Integer.parseInt(r3);     // Catch: Throwable -> L63
        if (r11 <= 6) goto L55;
        r13.a(r10);     // Catch: Throwable -> L63
        byte[] r12 = new byte[6];     // Catch: Throwable -> L63
        if (r13.read(r12) != 6) goto L53;
        int r14 = r11 - 6;     // Catch: Throwable -> L63
        if (Arrays.equals(r12, j) == false) goto L51;
        byte[] r15 = new byte[r14];     // Catch: Throwable -> L63
        if (r13.read(r15) != r14) goto L49;
        a(r15, 0);     // Catch: Throwable -> L63
        goto L57
    L49:
        throw new IOException("Can't read exif");     // Catch: Throwable -> L63
    L51:
        throw new IOException("Invalid identifier");     // Catch: Throwable -> L63
    L53:
        throw new IOException("Can't read identifier");     // Catch: Throwable -> L63
    L55:
        throw new IOException("Invalid exif length");     // Catch: Throwable -> L63
    L57:
        if (k == false) goto L59;
        a(TAG, "Heif meta: " + r6 + "x" + r0 + ", rotation " + r7);     // Catch: Throwable -> L63
    L59:
        r1.release();
        return;
    L16:
        if ("yes".equals(r5) == false) goto L18;
        r6 = r1.extractMetadata(18);     // Catch: Throwable -> L63
        r0 = r1.extractMetadata(19);     // Catch: Throwable -> L63
        r7 = r1.extractMetadata(24);     // Catch: Throwable -> L63
        goto L20
    L18:
        r0 = null;
        r7 = null;
        goto L20
    L6:
        FileDescriptor r16 = this.M;     // Catch: Throwable -> L63
        if (r16 == null) goto L9;
        r1.setDataSource(r16);     // Catch: Throwable -> L63
        goto L12
    L9:
        String r17 = this.L;     // Catch: Throwable -> L63
        if (r17 == null) goto L61;
        r1.setDataSource(r17);     // Catch: Throwable -> L63
        goto L12
    L61:
        r1.release();
    }

    private void d(C0054a r8) {
        a(r8);
        b r9 = (b) ZeusTransformUtils.preCheckCast(this.P[1].get("MakerNote"), b.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L31;
        C0054a r2 = new C0054a(r9.f1689d);
        r2.a(this.R);
        byte[] r10 = q;
        byte[] r4 = new byte[r10.length];
        r2.readFully(r4);
        r2.a(0);
        byte[] r5 = r;
        byte[] r6 = new byte[r5.length];
        r2.readFully(r6);
        if (Arrays.equals(r4, r10) == false) goto L8;
        r2.a(8);
    L10:
        b(r2, 6);
        b r11 = (b) ZeusTransformUtils.preCheckCast(this.P[7].get("PreviewImageStart"), b.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.P[7].get("PreviewImageLength"), b.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L14;
        if (r3 == null) goto L14;
        this.P[5].put("JPEGInterchangeFormat", r11);
        this.P[5].put("JPEGInterchangeFormatLength", r3);
    L14:
        b r12 = (b) ZeusTransformUtils.preCheckCast(this.P[8].get("AspectFrame"), b.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L32;
        int[] r13 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r12.a(this.R), int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L19;
    L29:
        b(TAG, "Invalid aspect frame values. frame=" + Arrays.toString(r13));
        return;
    L19:
        if (r13.length != 4) goto L29;
        if (r13[2] > r13[0]) goto L24;
        return;
    L24:
        if (r13[3] <= r13[1]) goto L34;
        int r0 = (r13[2] - r13[0]) + 1;
        int r7 = (r13[3] - r13[1]) + 1;
        if (r0 >= r7) goto L28;
        int r1 = r0 + r7;
        r7 = r1 - r7;
        r0 = r1 - r7;
    L28:
        b r14 = b.a(r0, this.R);
        b r15 = b.a(r7, this.R);
        this.P[0].put("ImageWidth", r14);
        this.P[0].put("ImageLength", r15);
        return;
    L34:
        return;
    L32:
        return;
    L8:
        if (Arrays.equals(r6, r5) == false) goto L10;
        r2.a(12);
        goto L10
    }

    private void e(C0054a r6) {
        a(r6);
        if (((b) ZeusTransformUtils.preCheckCast(this.P[0].get("JpgFromRaw"), b.class, "com.obric.aiagent.plugin")) == null) goto L5;
        a(r6, this.ab, 5);
    L5:
        b r7 = (b) ZeusTransformUtils.preCheckCast(this.P[0].get("ISO"), b.class, "com.obric.aiagent.plugin");
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.P[1].get("PhotographicSensitivity"), b.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        if (r0 != null) goto L11;
        this.P[1].put("PhotographicSensitivity", r7);
        return;
    L11:
        return;
    }

    private void a(byte[] r2, int r3) {
        C0054a r0 = new C0054a(r2);
        a(r0, r2.length);
        b(r0, r3);
    }

    private void b() {
        String r0 = a("DateTimeOriginal");
        if (r0 == null) goto L8;
        if (a("DateTime") != null) goto L8;
        this.P[0].put("DateTime", b.a(r0));
    L8:
        if (a("ImageWidth") != null) goto L11;
        this.P[0].put("ImageWidth", b.a(0, this.R));
    L11:
        if (a("ImageLength") != null) goto L14;
        this.P[0].put("ImageLength", b.a(0, this.R));
    L14:
        if (a("Orientation") != null) goto L17;
        this.P[0].put("Orientation", b.a(0, this.R));
    L17:
        if (a("LightSource") != null) goto L20;
        this.P[1].put("LightSource", b.a(0, this.R));
        return;
    }

    private ByteOrder f(C0054a r3) {
        short r2 = r3.readShort();
        if (r2 == 18761) goto L14;
        if (r2 != 19789) goto L12;
        if (k == false) goto L10;
        a(TAG, "readExifSegment: Byte Align MM");
    L10:
        return ByteOrder.BIG_ENDIAN;
    L12:
        throw new IOException("Invalid byte order: " + Integer.toHexString(r2));
    L14:
        if (k == false) goto L17;
        a(TAG, "readExifSegment: Byte Align II");
    L17:
        return ByteOrder.LITTLE_ENDIAN;
    }

    private void a(C0054a r3, int r4) {
        ByteOrder r0 = f(r3);
        this.R = r0;
        r3.a(r0);
        int r1 = r3.readUnsignedShort();
        int r2 = this.O;
        if (r2 != 7) goto L5;
    L11:
        int r5 = r3.readInt();
        if (r5 < 8) goto L23;
        if (r5 >= r4) goto L23;
        int r6 = r5 - 8;
        if (r6 > 0) goto L17;
        return;
    L17:
        if (r3.skipBytes(r6) != r6) goto L20;
        return;
    L20:
        throw new IOException("Couldn't jump to first Ifd: " + r6);
    L23:
        throw new IOException("Invalid first Ifd offset: " + r5);
    L5:
        if (r2 == 10) goto L11;
        if (r1 == 42) goto L11;
        throw new IOException("Invalid start code: " + Integer.toHexString(r1));
    }

    private void b(C0054a r32, int r33) {
        this.Q.add(Integer.valueOf(r32.f1684b));
        if ((r32.f1684b + 2) <= r32.f1683a) goto L5;
        return;
    L5:
        short r3 = r32.readShort();
        if (k == false) goto L9;
        a(TAG, "numberOfDirectoryEntry: " + r3);
    L9:
        if ((r32.f1684b + (r3 * 12)) > r32.f1683a) goto L163;
        if (r3 <= 0) goto L171;
        short r7 = 0;
    L14:
        if (r7 >= r3) goto L137;
        int r13 = r32.readUnsignedShort();
        int r14 = r32.readUnsignedShort();
        int r15 = r32.readInt();
        long r9 = ((long) r32.a()) + 4;
        c r4 = (c) ZeusTransformUtils.preCheckCast(G[r33].get(Integer.valueOf(r13)), c.class, "com.obric.aiagent.plugin");
        boolean r12 = k;
        if (r12 == false) goto L22;
        Object[] r8 = new Object[5];
        r8[0] = Integer.valueOf(r33);
        r8[1] = Integer.valueOf(r13);
        if (r4 == null) goto L20;
        String r5 = r4.f1691b;
    L21:
        r8[2] = r5;
        r8[3] = Integer.valueOf(r14);
        r8[4] = Integer.valueOf(r15);
        a(TAG, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", r8));
        goto L22
    L20:
        r5 = null;
    L22:
        if (r4 != null) goto L26;
        if (r12 == false) goto L25;
        a(TAG, "Skip the tag entry since tag number is not defined: " + r13);
    L25:
        short r26 = r7;
        int r27 = r13;
    L49:
        boolean r6 = false;
        long r10 = 0;
    L50:
        if (r6 == true) goto L54;
        r32.a(r9);
        short r28 = r3;
    L52:
        char r11 = 2;
    L135:
        r7 = (short) (r26 + 1);
        r3 = r28;
        goto L14
    L54:
        if (r10 <= 4) goto L81;
        int r16 = r32.readInt();
        r28 = r3;
        if (r12 == false) goto L59;
        a(TAG, "seek to data offset: " + r16);
    L59:
        int r17 = this.O;
        if (r17 == 7) goto L62;
        String r25 = "com.obric.aiagent.plugin";
        int r19 = r15;
        if (r17 == 10) goto L73;
    L75:
        long r2 = r16;
        if ((r2 + r10) > r32.f1683a) goto L78;
        r32.a(r2);
    L82:
        Integer r18 = (Integer) ZeusTransformUtils.preCheckCast(f1675J.get(Integer.valueOf(r27)), Integer.class, r25);
        if (r12 == false) goto L85;
        long r20 = r10;
        a(TAG, "nextIfdType: " + r18 + " byteCount: " + r20);
    L87:
        if (r18 == null) goto L118;
        long r21 = -1;
        int r110 = r14;
        if (r110 != 3) goto L91;
        int r22 = r32.readUnsignedShort();
    L102:
        r21 = r22;
    L103:
        r11 = 2;
        if (r12 == false) goto L107;
        a(TAG, String.format("Offset: %d, tagName: %s", new Object[]{Long.valueOf(r21), r4.f1691b}));
    L107:
        if (r21 > 0) goto L109;
    L115:
        if (r12 == false) goto L117;
        a(TAG, "Skip jump into the IFD since its offset is invalid: " + r21);
    L117:
        r32.a(r9);
        goto L135
    L109:
        if (r21 >= r32.f1683a) goto L115;
        if (this.Q.contains(Integer.valueOf((int) r21)) == true) goto L113;
        r32.a(r21);
        b(r32, r18.intValue());
        goto L117
    L113:
        if (r12 == false) goto L117;
        a(TAG, "Skip jump into the IFD since it has already been read: IfdType " + r18 + " (at " + r21 + ")");
        goto L117
    L91:
        if (r110 == 4) goto L100;
        if (r110 != 8) goto L94;
        r22 = r32.readShort();
        goto L102
    L94:
        if (r110 != 9) goto L96;
    L98:
        r22 = r32.readInt();
        goto L102
    L96:
        if (r110 == 13) goto L98;
    L100:
        r21 = r32.b();
        goto L103
    L118:
        r11 = 2;
        int r23 = r32.a();
        byte[] r24 = new byte[(int) r20];
        r32.readFully(r24);
        b r29 = new b(r14, r19, r23, r24);
        this.P[r33].put(r4.f1691b, r29);
        if ("DNGVersion".equals(r4.f1691b) == false) goto L122;
        this.O = 3;
    L122:
        if ("Make".equals(r4.f1691b) == true) goto L126;
        if ("Model".equals(r4.f1691b) == true) goto L126;
    L128:
        if ("Compression".equals(r4.f1691b) == false) goto L133;
        if (r29.c(this.R) != 65535) goto L133;
    L131:
        this.O = 8;
    L133:
        if (r32.a() == r9) goto L135;
        r32.a(r9);
    L126:
        if (r29.d(this.R).contains("PENTAX") == true) goto L131;
    L85:
        r20 = r10;
        goto L87
    L78:
        if (r12 == false) goto L80;
        a(TAG, "Skip the tag entry since data offset is invalid: " + r16);
    L80:
        r32.a(r9);
        goto L52
    L73:
        if ("JpgFromRaw".equals(r4.f1691b) == false) goto L75;
        this.ab = r16;
        goto L75
    L62:
        if ("MakerNote".equals(r4.f1691b) == false) goto L65;
        this.Y = r16;
    L69:
        r25 = "com.obric.aiagent.plugin";
        r19 = r15;
        goto L75
    L65:
        if (r33 != 6) goto L69;
        if ("ThumbnailImage".equals(r4.f1691b) == false) goto L69;
        this.Z = r16;
        this.aa = r15;
        b r30 = b.a(6, this.R);
        r19 = r15;
        b r31 = b.a(this.Z, this.R);
        r25 = "com.obric.aiagent.plugin";
        b r111 = b.a(this.aa, this.R);
        this.P[4].put("Compression", r30);
        this.P[4].put("JPEGInterchangeFormat", r31);
        this.P[4].put("JPEGInterchangeFormatLength", r111);
        goto L75
    L81:
        r28 = r3;
        r25 = "com.obric.aiagent.plugin";
        r14 = r14;
        r19 = r15;
        goto L82
    L26:
        if (r14 <= 0) goto L46;
        int[] r34 = f;
        if (r14 >= r34.length) goto L46;
        if (r4.a(r14) == true) goto L35;
        if (r12 == false) goto L25;
        a(TAG, "Skip the tag entry since data format (" + f1680e[r14] + ") is unexpected for tag: " + r4.f1691b);
        goto L25
    L35:
        if (r14 != 7) goto L37;
        r14 = r4.f1692c;
    L37:
        r26 = r7;
        r27 = r13;
        int r210 = r14;
        r10 = ((long) r15) * ((long) r34[r14]);
        if (r10 >= 0) goto L40;
    L43:
        if (r12 == false) goto L45;
        a(TAG, "Skip the tag entry since the number of components is invalid: " + r15);
    L45:
        r14 = r210;
        r6 = false;
        goto L50
    L40:
        if (r10 > 2147483647L) goto L43;
        r14 = r210;
        r6 = true;
    L46:
        r26 = r7;
        r27 = r13;
        if (r12 == false) goto L49;
        a(TAG, "Skip the tag entry since data format is invalid: " + r14);
        goto L49
    L137:
        if ((r32.a() + 4) > r32.f1683a) goto L164;
        int r35 = r32.readInt();
        boolean r36 = k;
        if (r36 == false) goto L141;
        a(TAG, String.format("nextIfdOffset: %d", new Object[]{Integer.valueOf(r35)}));
    L141:
        long r37 = r35;
        if (r37 > 0) goto L144;
    L155:
        if (r36 == false) goto L170;
        a(TAG, "Stop reading file since a wrong offset may cause an infinite loop: " + r35);
        return;
    L170:
        return;
    L144:
        if (r35 >= r32.f1683a) goto L155;
        if (this.Q.contains(Integer.valueOf(r35)) == true) goto L153;
        r32.a(r37);
        if (this.P[4].isEmpty() == false) goto L151;
        b(r32, 4);
        return;
    L151:
        if (this.P[5].isEmpty() == false) goto L166;
        b(r32, 5);
        return;
    L166:
        return;
    L153:
        if (r36 == false) goto L168;
        a(TAG, "Stop reading file since re-reading an IFD may cause an infinite loop: " + r35);
        return;
    L168:
        return;
    L164:
        return;
    L171:
        return;
    }

    private void c(C0054a r5, int r6) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.P[r6].get("ImageLength"), b.class, "com.obric.aiagent.plugin");
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.P[r6].get("ImageWidth"), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        if (r1 == null) goto L5;
        return;
    L5:
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.P[r6].get("JPEGInterchangeFormat"), b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        a(r5, r2.c(this.R), r6);
        return;
    }

    private void g(C0054a r5) {
        HashMap<String, b> r0 = this.P[4];
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get("Compression"), b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L14;
        int r2 = r1.c(this.R);
        this.W = r2;
        if (r2 == 1) goto L12;
        if (r2 != 6) goto L8;
        a(r5, r0);
        return;
    L8:
        if (r2 == 7) goto L12;
        return;
    L12:
        if (a(r0) == false) goto L17;
        b(r5, r0);
        return;
    L17:
        return;
    L14:
        this.W = 6;
        a(r5, r0);
    }

    private void a(C0054a r4, HashMap r5) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r5.get("JPEGInterchangeFormat"), b.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5.get("JPEGInterchangeFormatLength"), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L30;
        if (r6 == null) goto L31;
        int r1 = r0.c(this.R);
        int r7 = Math.min(r6.c(this.R), r4.c() - r1);
        int r2 = this.O;
        if (r2 != 4) goto L8;
    L15:
        int r3 = this.X;
    L16:
        r1 = r1 + r3;
    L18:
        if (k == false) goto L20;
        a(TAG, "Setting thumbnail attributes with offset: " + r1 + ", length: " + r7);
    L20:
        if (r1 <= 0) goto L32;
        if (r7 <= 0) goto L33;
        this.S = true;
        this.T = r1;
        this.U = r7;
        if (this.L == null) goto L25;
        return;
    L25:
        if (this.N == null) goto L27;
        return;
    L27:
        if (this.M != null) goto L36;
        byte[] r8 = new byte[r7];
        r4.a(r1);
        r4.readFully(r8);
        this.V = r8;
        return;
    L36:
        return;
    L33:
        return;
    L32:
        return;
    L8:
        if (r2 == 9) goto L15;
        if (r2 == 10) goto L15;
        if (r2 != 7) goto L18;
        r3 = this.Y;
        goto L16
    L31:
        return;
    }

    private void b(C0054a r13, HashMap r14) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r14.get("StripOffsets"), b.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.preCheckCast(r14.get("StripByteCounts"), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L28;
        if (r15 == null) goto L29;
        long[] r1 = a(r0.a(this.R));
        long[] r16 = a(r15.a(this.R));
        if (r1 != null) goto L9;
        b(TAG, "stripOffsets should not be null.");
        return;
    L9:
        if (r16 != null) goto L12;
        b(TAG, "stripByteCounts should not be null.");
        return;
    L12:
        long r2 = 0;
        int r4 = r16.length;
        int r6 = 0;
    L13:
        if (r6 >= r4) goto L15;
        r2 = r2 + r16[r6];
        r6 = r6 + 1;
        goto L13
    L15:
        int r3 = (int) r2;
        byte[] r5 = new byte[r3];
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L17:
        if (r7 >= r1.length) goto L22;
        int r10 = (int) r1[r7];
        int r11 = (int) r16[r7];
        int r12 = r10 - r8;
        if (r12 >= 0) goto L21;
        a(TAG, "Invalid strip offset value");
    L21:
        r13.a(r12);
        int r17 = r8 + r12;
        byte[] r18 = new byte[r11];
        r13.read(r18);
        r8 = r17 + r11;
        System.arraycopy(r18, 0, r5, r9, r11);
        r9 = r9 + r11;
        r7 = r7 + 1;
        goto L17
    L22:
        this.S = true;
        this.V = r5;
        this.U = r3;
        return;
    L29:
        return;
    }

    private boolean a(HashMap r7) {
        b r1 = (b) ZeusTransformUtils.preCheckCast(r7.get("BitsPerSample"), b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L21;
        int[] r0 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r1.a(this.R), int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        int[] r2 = f1676a;
        if (Arrays.equals(r2, r0) == false) goto L8;
        return true;
    L8:
        if (this.O != 3) goto L21;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r7.get("PhotometricInterpretation"), b.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L21;
        int r6 = r8.c(this.R);
        if (r6 != 1) goto L16;
        if (Arrays.equals(r0, f1678c) == false) goto L16;
    L19:
        return true;
    L16:
        if (r6 != 6) goto L21;
        if (Arrays.equals(r0, r2) == true) goto L19;
    L21:
        if (k == false) goto L25;
        a(TAG, "Unsupported data type value");
        return false;
    L25:
        return false;
    }

    private boolean b(HashMap r4) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(r4.get("ImageLength"), b.class, "com.obric.aiagent.plugin");
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4.get("ImageWidth"), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L10;
        if (r5 == null) goto L12;
        int r1 = r0.c(this.R);
        int r3 = r5.c(this.R);
        if (r1 > 512) goto L13;
        if (r3 > 512) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L12:
        return false;
    L10:
        return false;
    }

    private void b(InputStream r7) {
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.P[1].get("PixelXDimension"), b.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.P[1].get("PixelYDimension"), b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        if (r3 == null) goto L7;
        this.P[0].put("ImageWidth", r2);
        this.P[0].put("ImageLength", r3);
    L7:
        if (this.P[4].isEmpty() == false) goto L12;
        if (b(this.P[5]) == false) goto L12;
        HashMap<String, b>[] r8 = this.P;
        r8[4] = r8[5];
        r8[5] = new HashMap();
    L12:
        if (b(this.P[4]) == true) goto L15;
        a(TAG, "No image meets the size requirements of a thumbnail image.");
        return;
    }

    private void d(C0054a r12, int r13) {
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.P[r13].get("DefaultCropSize"), b.class, "com.obric.aiagent.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.P[r13].get("SensorTopBorder"), b.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.P[r13].get("SensorLeftBorder"), b.class, "com.obric.aiagent.plugin");
        b r5 = (b) ZeusTransformUtils.preCheckCast(this.P[r13].get("SensorBottomBorder"), b.class, "com.obric.aiagent.plugin");
        b r6 = (b) ZeusTransformUtils.preCheckCast(this.P[r13].get("SensorRightBorder"), b.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        if (r2 == null) goto L31;
        if (r4 == null) goto L31;
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        int r14 = r2.c(this.R);
        int r0 = r5.c(this.R);
        int r3 = r6.c(this.R);
        int r7 = r4.c(this.R);
        if (r0 <= r14) goto L34;
        if (r3 <= r7) goto L35;
        b r15 = b.a(r0 - r14, this.R);
        b r8 = b.a(r3 - r7, this.R);
        this.P[r13].put("ImageLength", r15);
        this.P[r13].put("ImageWidth", r8);
        return;
    L35:
        return;
    L34:
        return;
    L31:
        c(r12, r13);
        return;
    L5:
        if (r1.f1686a != 5) goto L14;
        d[] r16 = (d[]) ZeusTransformUtils.preCheckCast((d[]) ZeusTransformUtils.preCheckCast(r1.a(this.R), d[].class, "com.obric.aiagent.plugin"), d[].class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L9;
    L12:
        b(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r16));
        return;
    L9:
        if (r16.length != 2) goto L12;
        b r9 = b.a(r16[0], this.R);
        b r17 = b.a(r16[1], this.R);
    L20:
        this.P[r13].put("ImageWidth", r9);
        this.P[r13].put("ImageLength", r17);
        return;
    L14:
        int[] r18 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r1.a(this.R), int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        if (r18 != null) goto L17;
    L21:
        b(TAG, "Invalid crop size values. cropSize=" + Arrays.toString(r18));
        return;
    L17:
        if (r18.length != 2) goto L21;
        r9 = b.a(r18[0], this.R);
        r17 = b.a(r18[1], this.R);
        goto L20
    }

    private void a(int r8, int r9) {
        if (this.P[r8].isEmpty() == true) goto L26;
        if (this.P[r9].isEmpty() == true) goto L26;
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.P[r8].get("ImageLength"), b.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(this.P[r8].get("ImageWidth"), b.class, "com.obric.aiagent.plugin");
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.P[r9].get("ImageLength"), b.class, "com.obric.aiagent.plugin");
        b r4 = (b) ZeusTransformUtils.preCheckCast(this.P[r9].get("ImageWidth"), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L22;
        if (r3 == null) goto L22;
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r1 = r0.c(this.R);
        int r5 = r3.c(this.R);
        int r6 = r2.c(this.R);
        int r7 = r4.c(this.R);
        if (r1 >= r6) goto L29;
        if (r5 >= r7) goto L30;
        HashMap<String, b>[] r10 = this.P;
        HashMap<String, b> r11 = r10[r8];
        r10[r8] = r10[r9];
        r10[r9] = r11;
        return;
    L30:
        return;
    L29:
        return;
    L19:
        if (k == false) goto L32;
        a(TAG, "Second image does not contain valid size information");
        return;
    L32:
        return;
    L22:
        if (k == false) goto L34;
        a(TAG, "First image does not contain valid size information");
        return;
    L34:
        return;
    L26:
        if (k == false) goto L35;
        a(TAG, "Cannot perform swap since only one image data exists");
        return;
    }

    private static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
        return;
    L10:
        r3.close();     // Catch: RuntimeException -> L6 Exception -> L9
        goto L13
    L12:
        return;
    L6:
        e = move-exception;
        throw e;
    }

    private static long[] a(Object r4) {
        if ((r4 instanceof int[]) == false) goto L10;
        int[] r5 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r4, int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
        long[] r0 = new long[r5.length];
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L8;
        r0[r1] = r5[r1];
        r1 = r1 + 1;
        goto L6
    L8:
        return r0;
    L10:
        if ((r4 instanceof long[]) == true) goto L12;
        return null;
    L12:
        return (long[]) ZeusTransformUtils.preCheckCast((long[]) ZeusTransformUtils.preCheckCast(r4, long[].class, "com.obric.aiagent.plugin"), long[].class, "com.obric.aiagent.plugin");
    }

    private static boolean a(byte[] r4, byte[] r5) {
        if (r4 == null) goto L18;
        if (r5 == null) goto L18;
        if (r4.length >= r5.length) goto L9;
        return false;
    L9:
        int r1 = 0;
    L11:
        if (r1 >= r5.length) goto L16;
        if (r4[r1] != r5[r1]) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean b(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
