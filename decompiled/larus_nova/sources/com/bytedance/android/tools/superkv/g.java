package com.bytedance.android.tools.superkv;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.UByte;

/* JADX INFO: loaded from: classes14.dex */
public final class g implements com.bytedance.android.tools.superkv.f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static int f187619q = 32768;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f187620r = 8192;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f187621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f187622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile MappedByteBuffer f187623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, c> f187624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FileChannel f187625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RandomAccessFile f187626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f187627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f187628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final e f187629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.tools.superkv.f.a f187630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final bm3.c f187631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final bm3.a f187632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final bm3.b f187633m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.tools.superkv.c f187634n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f187635o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f187636p;

    public class a extends ThreadLocal<byte[]> {
        @Override // java.lang.ThreadLocal
        public final byte[] initialValue() {
            return new byte[g.f187620r];
        }

        public a() {
        }
    }

    public class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f187637a;

        public b(g r100) {
            this.f187637a = r100;
        }

        @Override // com.bytedance.android.tools.superkv.g.d
        public final void a(String r100) {
            this.f187637a.f187624d.remove(r100);
            ((com.bytedance.android.tools.superkv.d) this.f187637a.f187630j).f187618c.remove(r100);
        }

        @Override // com.bytedance.android.tools.superkv.g.d
        public final void b(String r100, c r101) {
            this.f187637a.f187624d.put(r100, r101);
            ((com.bytedance.android.tools.superkv.d) this.f187637a.f187630j).f187618c.remove(r100);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f187638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile int f187639b;

        public c() {
        }

        public c(int r100, int r101) {
            this.f187638a = r100;
            this.f187639b = r101;
        }
    }

    public interface d {
        void a(String r100);

        void b(String r100, c r101);
    }

    public interface e {
        void lock();

        void unlock();
    }

    public static final class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f187640a;

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void lock() {
            this.f187640a.readLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void unlock() {
            this.f187640a.readLock().unlock();
        }

        public f(ReentrantReadWriteLock r100) {
            this.f187640a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.tools.superkv.g$g, reason: collision with other inner class name */
    public static final class C2747g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f187641a;

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void lock() {
            this.f187641a.writeLock().lock();
        }

        @Override // com.bytedance.android.tools.superkv.g.e
        public final void unlock() {
            this.f187641a.writeLock().unlock();
        }

        public C2747g(ReentrantReadWriteLock r100) {
            this.f187641a = r100;
        }
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void a() {
        d(false);
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void release() {
        m.a(this.f187623c);
        this.f187625e.close();     // Catch: Exception -> L5
    L13:
        this.f187626f.close();     // Catch: Exception -> L9
        return;
    L9:
        com.bytedance.android.tools.superkv.b.a("Failed to close dataRandomAccessFile");
        return;
    L5:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.b("Failed to close dataFileChannel", e);
        goto L13
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final int b(List r100) {
        this.f187629i.lock();
        this.f187633m.c();     // Catch: Throwable -> L6
        bm3.b r101 = this.f187633m;     // Catch: Throwable -> L6
        r101.f19575b = "__prefetch_cache_key_array";     // Catch: Throwable -> L6
        r101.f19576c = 10;     // Catch: Throwable -> L6
        r101.f19584k = r100;     // Catch: Throwable -> L6
        int r102 = f("__prefetch_cache_key_array", (byte) 1);     // Catch: Throwable -> L6
        this.f187629i.unlock();
        return r102;
    L6:
        th = move-exception;
        this.f187629i.unlock();
        throw th;
    }

    public final void d(boolean r110) {
        byte[] r100 = this.f187635o.get();
        boolean r101 = false;
        this.f187623c.position(0);
        this.f187623c.get(r100, 0, 16);
        int r102 = 1;
        int r103 = ((((r100[0] & UByte.MAX_VALUE) << 24) | ((r100[1] & UByte.MAX_VALUE) << 16)) | ((r100[2] & UByte.MAX_VALUE) << 8)) | (r100[3] & UByte.MAX_VALUE);
        int r104 = (((r100[4] & UByte.MAX_VALUE) << 24) | ((r100[5] & UByte.MAX_VALUE) << 16)) | ((r100[6] & UByte.MAX_VALUE) << 8);
        int r105 = (r100[7] & UByte.MAX_VALUE) | r104;
        if (r103 <= 0) goto L27;
        if (r105 <= 0) goto L27;
        if (this.f187622b >= r103) goto L24;
        ((LinkedHashMap) this.f187624d).clear();
        int[] r106 = new int[1];
        if (e(16, r105, new h(this, r106)) == false) goto L12;
        r106[0] = -1;
    L12:
        if (r106[0] == this.f187624d.size()) goto L15;
        if (r110 == false) goto L15;
    L16:
        ByteBuffer r111 = ByteBuffer.allocate(this.f187623c.capacity() - 16);
        this.f187623c.position(16);
        byte[] r107 = r111.array();
        Iterator r108 = ((LinkedHashMap) this.f187624d).values().iterator();
        int r109 = 0;
    L18:
        if (r108.hasNext() == false) goto L20;
        c r112 = (c) r108.next();
        this.f187623c.position(r112.f187638a - 16);
        this.f187623c.get(r107, r109, r112.f187639b + 16);
        r112.f187638a = (r109 + 16) + 16;
        r109 = r109 + (r112.f187639b + 16);
        goto L18
    L20:
        this.f187623c.position(16);
        this.f187623c.put(r107, 0, r111.capacity());
        this.f187621a = r109 + 16;
        ((com.bytedance.android.tools.superkv.d) this.f187630j).f187618c.evictAll();
        r101 = true;
    L21:
        if (r101 == false) goto L26;
        r102 = r103 + 1;
        g(r102, this.f187621a);
    L28:
        this.f187622b = r102;
        return;
    L26:
        r102 = r103;
    L15:
        if (r106[0] != (-1)) goto L21;
    L24:
        if (this.f187621a >= r105) goto L26;
        e(this.f187621a, r105, this.f187636p);
    L27:
        g(1, 16);
        goto L28
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final bm3.b get(String r100) {
        this.f187628h.lock();
    L9:
        th = move-exception;
        this.f187628h.unlock();
        throw th;
    L11:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.d("Failed to read local data!", e);     // Catch: Throwable -> L9
    L17:
        this.f187628h.unlock();
        return null;
    L4:
        if (this.f187627g == false) goto L6;
        d(false);     // Catch: Throwable -> L9 Exception -> L11
    L6:
        c r101 = (c) ((LinkedHashMap) this.f187624d).get(r100);     // Catch: Throwable -> L9 Exception -> L11
        if (r101 != null) goto L13;
        com.bytedance.android.tools.superkv.b.f187611b.onLog(2, com.bytedance.android.tools.superkv.b.c("Item does not exist, key: " + r100));     // Catch: Throwable -> L9 Exception -> L11
        goto L17
    L13:
        bm3.c r102 = this.f187631k;     // Catch: Throwable -> L9 Exception -> L11
        com.bytedance.android.tools.superkv.c r103 = this.f187634n;     // Catch: Throwable -> L9 Exception -> L11
        MappedByteBuffer r104 = this.f187623c;     // Catch: Throwable -> L9 Exception -> L11
        int r105 = r101.f187638a;     // Catch: Throwable -> L9 Exception -> L11
        int r106 = r101.f187639b;     // Catch: Throwable -> L9 Exception -> L11
        r103.f187613a = r104;     // Catch: Throwable -> L9 Exception -> L11
        r103.f187614b = r106 + r105;     // Catch: Throwable -> L9 Exception -> L11
        r104.position(r105);     // Catch: Throwable -> L9 Exception -> L11
        r102.f19585a = r103;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19586b = 0;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19587c = Long.MAX_VALUE;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19588d = 0;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19589e = 2;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19590f = -1;     // Catch: Throwable -> L9 Exception -> L11
        r102.f19591g = -1;     // Catch: Throwable -> L9 Exception -> L11
        bm3.b r107 = this.f187633m;     // Catch: Throwable -> L9 Exception -> L11
        bm3.b.a.a(r102, r107);     // Catch: Throwable -> L9 Exception -> L11
        this.f187628h.unlock();
        return r107;
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final void remove(String r100) {
        this.f187629i.lock();
    L13:
        th = move-exception;
        this.f187629i.unlock();
        throw th;
    L4:
        if (this.f187627g == false) goto L7;
        d(false);     // Catch: Throwable -> L13
    L7:
        if (this.f187624d.remove(r100) != null) goto L11;
        com.bytedance.android.tools.superkv.b.f187611b.onLog(2, com.bytedance.android.tools.superkv.b.c("Tried to remove item doesn't exist, key: " + r100));     // Catch: Throwable -> L13
    L9:
        this.f187629i.unlock();
        return;
    L11:
        this.f187633m.c();     // Catch: Throwable -> L13
        bm3.b r101 = this.f187633m;     // Catch: Throwable -> L13
        r101.f19575b = r100;     // Catch: Throwable -> L13
        r101.f19576c = 0;     // Catch: Throwable -> L13
        f(r100, (byte) 0);     // Catch: Throwable -> L13
        goto L9
    }

    public g(String r100, com.bytedance.android.tools.superkv.f.a r101) throws IOException {
        this.f187621a = 16;
        this.f187622b = -1;
        this.f187624d = new LinkedHashMap();
        this.f187631k = new bm3.c();
        this.f187632l = new bm3.a();
        this.f187633m = new bm3.b();
        this.f187634n = new com.bytedance.android.tools.superkv.c();
        this.f187635o = new a();
        this.f187636p = new b(this);
        this.f187627g = false;
        this.f187630j = r101;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100 + ".mapped.data");
        if (r102.exists() == true) goto L5;
        r102.createNewFile();
    L5:
        RandomAccessFile r103 = new RandomAccessFile(r102, "rw");
        this.f187626f = r103;
        FileChannel r104 = r103.getChannel();
        this.f187625e = r104;
        if (r104.size() <= 0) goto L8;
        int r105 = (int) r104.size();
    L9:
        this.f187623c = r104.map(FileChannel.MapMode.READ_WRITE, 0, r105);
        ReentrantReadWriteLock r106 = new ReentrantReadWriteLock();
        f r107 = new f(r106);
        this.f187628h = r107;
        this.f187629i = new C2747g(r106);
        r107.lock();
        d(true);
        r107.unlock();
        return;
    L8:
        r105 = f187619q;
        goto L9
    }

    @Override // com.bytedance.android.tools.superkv.f
    public final int c(String r100, String r101) {
        this.f187629i.lock();
        this.f187633m.c();     // Catch: Throwable -> L6
        bm3.b r102 = this.f187633m;     // Catch: Throwable -> L6
        r102.f19575b = r100;     // Catch: Throwable -> L6
        r102.f19576c = 8;     // Catch: Throwable -> L6
        r102.f19582i = r101;     // Catch: Throwable -> L6
        int r103 = f(r100, (byte) 1);     // Catch: Throwable -> L6
        this.f187629i.unlock();
        return r103;
    L6:
        th = move-exception;
        this.f187629i.unlock();
        throw th;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int f(String r310, byte r311) {
        byte[] r100 = this.f187635o.get();
        if (this.f187627g == false) goto L5;
        d(false);
    L5:
        c r101 = new c();
        int r102 = this.f187621a;
        bm3.b r103 = this.f187633m;
        int r104 = cm3.a.a(2, r103.f19576c) + cm3.b.b(1, r103.f19575b);
        int r105 = r103.f19576c;
        if (r105 == 0) goto L54;
        switch(r105) {
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            case 9: goto L16;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        Iterator<String> r106 = r103.f19584k.iterator();
        int r107 = 0;
    L13:
        if (r106.hasNext() == false) goto L15;
        r107 = r107 + cm3.b.b(10, r106.next());
        goto L13
    L15:
        r104 = r104 + r107;
        goto L54
    L16:
        int r108 = r103.f19583j.length;
        int r109 = r108 + bm3.a.b(r108);
        int r110 = bm3.a.b(72);
    L49:
        int r111 = r109 + r110;
    L53:
        r104 = r104 + r111;
        goto L54
    L17:
        r111 = cm3.b.b(8, r103.f19582i);
        goto L53
    L18:
        r111 = bm3.a.b(56) + 8;
        goto L53
    L19:
        r111 = bm3.a.b(48) + 4;
        goto L53
    L20:
        long r112 = r103.f19579f;
        if ((r112 & (-128)) != 0) goto L24;
        r109 = 1;
    L48:
        r110 = bm3.a.b(40);
        goto L49
    L24:
        if ((r112 & (-16384)) != 0) goto L27;
        r109 = 2;
        goto L48
    L27:
        if ((r112 & (-2097152)) != 0) goto L30;
        r109 = 3;
        goto L48
    L30:
        if ((r112 & (-268435456)) != 0) goto L33;
        r109 = 4;
        goto L48
    L33:
        if ((r112 & (-34359738368L)) != 0) goto L36;
        r109 = 5;
        goto L48
    L36:
        if ((r112 & (-4398046511104L)) != 0) goto L39;
        r109 = 6;
        goto L48
    L39:
        if ((r112 & (-562949953421312L)) != 0) goto L42;
        r109 = 7;
        goto L48
    L42:
        if ((r112 & (-72057594037927936L)) != 0) goto L45;
        r109 = 8;
        goto L48
    L45:
        if ((r112 & Long.MIN_VALUE) != 0) goto L47;
        r109 = 9;
        goto L48
    L47:
        r109 = 10;
        goto L48
    L50:
        r111 = cm3.a.a(4, r103.f19578e);
        goto L53
    L51:
        r111 = bm3.a.b(24) + 1;
        goto L53
    L52:
        r111 = cm3.a.a(2, r105);
        goto L53
    L10:
        throw new IllegalArgumentException("Unknown type!");
    L54:
        r101.f187639b = r104;
        r101.f187638a = r102 + 16;
        int r113 = r104 + 16;
        if (r113 <= r100.length) goto L57;
        r100 = new byte[r113];
    L57:
        byte[] r114 = r100;
        bm3.a r115 = this.f187632l;
        r115.f19572a = r114;
        r115.f19573b = 16;
        bm3.b r116 = this.f187633m;
        cm3.b.a(r115, 1, r116.f19575b);
        int r117 = r116.f19576c;
        if (r117 == 0) goto L74;
        r115.c(16);
        if (r117 < 0) goto L63;
        r115.c(r117);
    L65:
        switch(r116.f19576c) {
            case 3: goto L82;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L76;
            case 7: goto L75;
            case 8: goto L73;
            case 9: goto L72;
            case 10: goto L68;
            default: goto L67;
        };
    L68:
        Iterator<String> r118 = r116.f19584k.iterator();
    L70:
        if (r118.hasNext() == false) goto L74;
        cm3.b.a(r115, 10, r118.next());
        goto L70
    L72:
        byte[] r119 = r116.f19583j;
        r115.c(74);
        r115.c(r119.length);
        System.arraycopy(r119, 0, r115.f19572a, r115.f19573b, r119.length);
        r115.f19573b += r119.length;
        goto L74
    L73:
        cm3.b.a(r115, 8, r116.f19582i);
        goto L74
    L75:
        double r120 = r116.f19581h;
        r115.c(57);
        long r121 = Double.doubleToLongBits(r120);
        byte[] r122 = r115.f19572a;
        int r123 = r115.f19573b;
        int r124 = r123 + 1;
        r122[r123] = (byte) ((r121 >>> 56) & 255);
        int r125 = r124 + 1;
        r122[r124] = (byte) ((r121 >>> 48) & 255);
        int r126 = r125 + 1;
        r122[r125] = (byte) ((r121 >>> 40) & 255);
        int r127 = r126 + 1;
        r122[r126] = (byte) ((r121 >>> 32) & 255);
        int r128 = r127 + 1;
        r122[r127] = (byte) ((r121 >>> 24) & 255);
        int r129 = r128 + 1;
        int r130 = r102;
        int r312 = r113;
        r122[r128] = (byte) ((r121 >>> 16) & 255);
        int r131 = r129 + 1;
        r122[r129] = (byte) ((r121 >>> 8) & 255);
        r115.f19573b = r131 + 1;
        r122[r131] = (byte) (r121 & 255);
    L83:
        long r132 = com.bytedance.android.tools.superkv.a.a(r114, 16, r104);
        r114[0] = (byte) (r104 >>> 24);
        r114[1] = (byte) (r104 >>> 16);
        r114[2] = (byte) (r104 >>> 8);
        r114[3] = (byte) r104;
        r114[4] = r311;
        r114[7] = -1;
        r114[6] = -1;
        r114[5] = -1;
        r114[8] = (byte) (r132 >>> 56);
        r114[9] = (byte) (r132 >>> 48);
        r114[10] = (byte) (r132 >>> 40);
        r114[11] = (byte) (r132 >>> 32);
        r114[12] = (byte) (r132 >>> 24);
        r114[13] = (byte) (r132 >>> 16);
        r114[14] = (byte) (r132 >>> 8);
        r114[15] = (byte) r132;
        if (this.f187623c.capacity() >= (r101.f187638a + r104)) goto L92;
        int r133 = r101.f187638a + r104;
        int r134 = this.f187623c.capacity();
    L86:
        if (r134 >= r133) goto L97;
        r134 = (int) (r134 * 1.5f);
        goto L86
    L97:
        m.a(this.f187623c);     // Catch: Exception -> L90
        this.f187623c = this.f187625e.map(FileChannel.MapMode.READ_WRITE, 0, r134);     // Catch: Exception -> L90
    L90:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.b("Failed to resize mapped buffer", e);
    L92:
        int r135 = r130;
        this.f187623c.position(r135);
        int r136 = r312;
        this.f187623c.put(r114, 0, r136);
        this.f187621a = r135 + r136;
        g(this.f187622b, this.f187621a);
        if (r311 != 1) goto L96;
        this.f187624d.put(r310, r101);
    L96:
        return r101.f187639b;
    L76:
        r130 = r102;
        r312 = r113;
        float r137 = r116.f19580g;
        r115.c(53);
        int r138 = Float.floatToIntBits(r137);
        byte[] r139 = r115.f19572a;
        int r140 = r115.f19573b;
        int r141 = r140 + 1;
        r139[r140] = (byte) ((r138 >>> 24) & 255);
        int r142 = r141 + 1;
        r139[r141] = (byte) ((r138 >>> 16) & 255);
        int r143 = r142 + 1;
        r139[r142] = (byte) ((r138 >>> 8) & 255);
        r115.f19573b = r143 + 1;
        r139[r143] = (byte) (r138 & 255);
        goto L83
    L77:
        r130 = r102;
        r312 = r113;
        long r144 = r116.f19579f;
        r115.c(40);
        r115.d(r144);
        goto L83
    L78:
        r130 = r102;
        r312 = r113;
        int r145 = r116.f19578e;
        r115.c(32);
        if (r145 < 0) goto L81;
        r115.c(r145);
        goto L83
    L81:
        r115.d(r145);
        goto L83
    L82:
        r130 = r102;
        r312 = r113;
        boolean r146 = r116.f19577d;
        r115.c(24);
        r115.c(r146 ? 1 : 0);
        goto L83
    L67:
        throw new IllegalArgumentException("Unknown type!");
    L63:
        r115.d(r117);
    L74:
        r130 = r102;
        r312 = r113;
        goto L83
    }

    public final void g(int r100, int r101) {
        byte[] r102 = this.f187635o.get();
        r102[0] = (byte) (r100 >>> 24);
        r102[1] = (byte) (r100 >>> 16);
        r102[2] = (byte) (r100 >>> 8);
        r102[3] = (byte) r100;
        r102[4] = (byte) (r101 >>> 24);
        r102[5] = (byte) (r101 >>> 16);
        r102[6] = (byte) (r101 >>> 8);
        r102[7] = (byte) r101;
        this.f187623c.position(0);
        this.f187623c.put(r102, 0, 16);
    }

    public final boolean e(int r110, int r111, d r210) {
        byte[] r100 = ByteBuffer.allocateDirect(r111 - r110).array();
        int r101 = r110;
        int r102 = 0;
        boolean r103 = false;
    L3:
        if (r101 >= r111) goto L36;
        this.f187623c.position(r101);
        this.f187623c.get(r100, r102, 16);
        int r104 = r102 + 1;
        int r112 = r104 + 1;
        int r105 = ((r100[r102] & UByte.MAX_VALUE) << 24) | ((r100[r104] & UByte.MAX_VALUE) << 16);
        int r106 = r112 + 1;
        int r107 = r105 | ((r100[r112] & UByte.MAX_VALUE) << 8);
        int r113 = r106 + 1;
        int r108 = r107 | (r100[r106] & UByte.MAX_VALUE);
        int r109 = r113 + 1;
        byte r114 = r100[r113];
        int r115 = r109 + 1;
        if (r100[r109] != (-1)) goto L35;
        int r116 = r115 + 1;
        if (r100[r115] != (-1)) goto L35;
        int r117 = r116 + 1;
        if (r100[r116] != (-1)) goto L35;
        int r118 = r117 + 1;
        int r119 = r118 + 1;
        int r120 = r119 + 1;
        long r121 = (((((long) r100[r118]) & 255) << 48) | ((((long) r100[r117]) & 255) << 56)) | ((((long) r100[r119]) & 255) << 40);
        int r122 = r120 + 1;
        long r123 = r121 | ((((long) r100[r120]) & 255) << 32);
        int r124 = r122 + 1;
        long r125 = r123 | ((((long) r100[r122]) & 255) << 24);
        int r126 = r124 + 1;
        long r127 = r125 | ((((long) r100[r124]) & 255) << 16);
        int r128 = r126 + 1;
        int r129 = r128 + 1;
        long r130 = (r127 | ((((long) r100[r126]) & 255) << 8)) | (((long) r100[r128]) & 255);
        if (r108 <= 0) goto L13;
        this.f187623c.get(r100, r129, r108);
        if (com.bytedance.android.tools.superkv.a.a(r100, r129, r108) != r130) goto L16;
        com.bytedance.android.tools.superkv.c r131 = this.f187634n;     // Catch: Exception -> L32
        MappedByteBuffer r132 = this.f187623c;     // Catch: Exception -> L32
        int r133 = r101 + 16;     // Catch: Exception -> L32
        r131.f187613a = r132;     // Catch: Exception -> L32
        int r134 = r108 + r133;     // Catch: Exception -> L32
        r131.f187614b = r134;     // Catch: Exception -> L32
        r132.position(r133);     // Catch: Exception -> L32
        bm3.c r135 = new bm3.c(r131);     // Catch: Exception -> L32
        r135.c();     // Catch: Exception -> L32
    L18:
        int r136 = r135.e();     // Catch: Exception -> L32
        if (r136 == (-1)) goto L31;
        if (r136 != 1) goto L18;
        String r137 = r135.h();     // Catch: Exception -> L38
        if ((r114 & 1) == 0) goto L27;
        r210.b(r137, new c(r133, r108));
    L28:
        r102 = r108 + r129;
        r101 = r134;
        goto L3
    L27:
        r210.a(r137);
        goto L28
    L31:
        throw new IllegalArgumentException("No key found in proto");     // Catch: Exception -> L38
    L33:
        com.bytedance.android.tools.superkv.b.a("Failed to decode data at: " + r101);
    L34:
        r101 = r101 + (r108 + 16);
        r102 = r129;
        r103 = true;
        goto L3
    L16:
        com.bytedance.android.tools.superkv.b.a("Checksum failed at position: " + r101 + ", expected: " + r130 + ", found: " + com.bytedance.android.tools.superkv.a.a(r100, r129, r108) + ", skipping...");
        goto L34
    L13:
        com.bytedance.android.tools.superkv.b.a("Unexpected EOF at " + r129 + "!");
    L35:
        com.bytedance.android.tools.superkv.b.a("Broken entry info at " + r101 + "! Skipping all the rest...");
        r103 = true;
    L36:
        this.f187621a = r101;
        return r103;
    }
}
