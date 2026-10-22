package com.obric.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.obric.capabilitykit.common.UiType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import oa.b;
import oa.c;

/* JADX INFO: loaded from: classes3.dex */
public class Alog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10482j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10483k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10484l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10485m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10486n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10487o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile List f10488p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ArrayList f10489q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f10490r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f10491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f10494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f10495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10499i;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        private static final /* synthetic */ AsymCrypt[] $VALUES = null;
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;
        private final int value;

        static {
            AsymCrypt r10 = new AsymCrypt("NONE", 0, 0);
            NONE = r10;
            AsymCrypt r11 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r11;
            AsymCrypt r12 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r12;
            $VALUES = new AsymCrypt[]{r10, r11, r12};
        }

        private AsymCrypt(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static AsymCrypt valueOf(String r10) {
            return (AsymCrypt) Enum.valueOf(AsymCrypt.class, r10);
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        private static final /* synthetic */ Compress[] $VALUES = null;
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;
        private final int value;

        static {
            Compress r10 = new Compress("NONE", 0, 0);
            NONE = r10;
            Compress r11 = new Compress("ZLIB", 1, 1);
            ZLIB = r11;
            Compress r12 = new Compress("ZSTD", 2, 2);
            ZSTD = r12;
            $VALUES = new Compress[]{r10, r11, r12};
        }

        private Compress(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Compress valueOf(String r10) {
            return (Compress) Enum.valueOf(Compress.class, r10);
        }

        public static Compress[] values() {
            return (Compress[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;
        private final int value;

        static {
            Mode r10 = new Mode("SPEED", 0, 0);
            SPEED = r10;
            Mode r11 = new Mode("SAFE", 1, 1);
            SAFE = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        private static final /* synthetic */ PrefixFormat[] $VALUES = null;
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;
        private final int value;

        static {
            PrefixFormat r10 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r10;
            PrefixFormat r11 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r11;
            $VALUES = new PrefixFormat[]{r10, r11};
        }

        private PrefixFormat(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static PrefixFormat valueOf(String r10) {
            return (PrefixFormat) Enum.valueOf(PrefixFormat.class, r10);
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        private static final /* synthetic */ SymCrypt[] $VALUES = null;
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;
        private final int value;

        static {
            SymCrypt r10 = new SymCrypt("NONE", 0, 0);
            NONE = r10;
            SymCrypt r11 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r11;
            SymCrypt r12 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r12;
            SymCrypt r13 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r13;
            $VALUES = new SymCrypt[]{r10, r11, r12, r13};
        }

        private SymCrypt(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static SymCrypt valueOf(String r10) {
            return (SymCrypt) Enum.valueOf(SymCrypt.class, r10);
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        private static final /* synthetic */ TimeFormat[] $VALUES = null;
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;
        private final int value;

        static {
            TimeFormat r10 = new TimeFormat("RAW", 0, 1);
            RAW = r10;
            TimeFormat r11 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r11;
            $VALUES = new TimeFormat[]{r10, r11};
        }

        private TimeFormat(String r10, int r11, int r12) {
            super(r10, r11);
            this.value = r12;
        }

        public static TimeFormat valueOf(String r10) {
            return (TimeFormat) Enum.valueOf(TimeFormat.class, r10);
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10500a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f10501b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10502c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f10503d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10504e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f10506g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f10507h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f10508i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f10509j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f10510k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f10511l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f10512m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f10513n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f10514o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f10515p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f10516q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f10517r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f10518s;

        public a(Context r10) {
            this.f10501b = 0;
            this.f10502c = false;
            this.f10503d = null;
            this.f10504e = null;
            this.f10505f = UiType.FLAG_REMOTE_CARD;
            this.f10506g = 20971520;
            this.f10507h = 7;
            this.f10508i = null;
            this.f10509j = 65536;
            this.f10510k = 196608;
            this.f10511l = null;
            this.f10512m = Alog.a();
            this.f10513n = Alog.b();
            this.f10514o = Alog.c();
            this.f10515p = Alog.d();
            this.f10516q = Alog.e();
            this.f10517r = Alog.f();
            this.f10518s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L5;
            r10 = r11;
        L5:
            this.f10500a = r10;
        }

        public Alog a() {
            if (this.f10503d != null) goto L5;
            this.f10503d = "default";
        L5:
            ArrayList r10 = Alog.g();
            monitor-enter(r10);
            Iterator r11 = Alog.g().iterator();     // Catch: Throwable -> L14
        L9:
            if (r11.hasNext() == false) goto L16;
            if (((String) r11.next()).equals(this.f10503d) == false) goto L9;
            monitor-exit(r10);     // Catch: Throwable -> L14
            return null;
        L16:
            Alog.g().add(this.f10503d);     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
            if (this.f10504e != null) goto L25;
            File r12 = this.f10500a.getExternalFilesDir(null);
            if (r12 == null) goto L23;
            this.f10504e = r12.getPath() + "/alog";
            goto L25
        L23:
            this.f10504e = this.f10500a.getFilesDir() + "/alog";
        L25:
            if (this.f10508i != null) goto L28;
            this.f10508i = this.f10500a.getFilesDir() + "/alog";
        L28:
            if (this.f10511l != null) goto L30;
            this.f10511l = c.a(this.f10500a);
        L30:
            int r13 = (this.f10509j / 4096) * 4096;
            this.f10509j = r13;
            int r14 = (this.f10510k / 4096) * 4096;
            this.f10510k = r14;
            if (r13 >= 4096) goto L33;
            this.f10509j = 4096;
        L33:
            int r15 = this.f10509j;
            if (r14 >= (r15 * 2)) goto L37;
            this.f10510k = r15 * 2;
        L37:
            return new Alog(this.f10500a, this.f10501b, this.f10502c, this.f10503d, this.f10504e, this.f10505f, this.f10506g, this.f10507h, this.f10508i, this.f10509j, this.f10510k, this.f10511l, this.f10512m, this.f10513n, this.f10514o, this.f10515p, this.f10516q, this.f10517r, this.f10518s);
        L14:
            th = move-exception;
            throw th;
        }

        public a b(AsymCrypt r10) {
            this.f10517r = r10.getValue();
            return this;
        }

        public a c(String r10) {
            this.f10508i = r10;
            return this;
        }

        public a d(int r10) {
            this.f10509j = r10;
            return this;
        }

        public a e(int r10) {
            this.f10510k = r10;
            return this;
        }

        public a f(Compress r10) {
            this.f10515p = r10.getValue();
            return this;
        }

        public a g(String r10) {
            if (TextUtils.isEmpty(r10) == false) goto L5;
        L13:
            return this;
        L5:
            if (r10.contains("-") == false) goto L8;
            r10 = r10.replace("-", "");
        L8:
            if (r10.contains("_") == false) goto L11;
            r10 = r10.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r10) == true) goto L13;
            this.f10503d = r10;
            goto L13
        }

        public a h(int r10) {
            this.f10501b = r10;
            return this;
        }

        public a i(String r10) {
            this.f10504e = r10;
            return this;
        }

        public a j(int r10) {
            this.f10507h = r10;
            return this;
        }

        public a k(int r10) {
            this.f10505f = r10;
            return this;
        }

        public a l(int r10) {
            this.f10506g = r10;
            return this;
        }

        public a m(Mode r10) {
            this.f10512m = r10.getValue();
            return this;
        }

        public a n(PrefixFormat r10) {
            this.f10514o = r10.getValue();
            return this;
        }

        public a o(String r10) {
            this.f10518s = r10;
            return this;
        }

        public a p(SymCrypt r10) {
            this.f10516q = r10.getValue();
            return this;
        }

        public a q(boolean r10) {
            this.f10502c = r10;
            return this;
        }

        public a r(TimeFormat r10) {
            this.f10513n = r10.getValue();
            return this;
        }
    }

    static {
        f10482j = Mode.SAFE.getValue();
        f10483k = TimeFormat.RAW.getValue();
        f10484l = PrefixFormat.DEFAULT.getValue();
        f10485m = Compress.ZSTD.getValue();
        f10486n = SymCrypt.TEA_16.getValue();
        f10487o = AsymCrypt.EC_SECP256K1.getValue();
        f10488p = null;
        f10489q = new ArrayList();
        f10490r = false;
    }

    public Alog(Context r10, int r11, boolean r12, String r13, String r14, int r15, int r16, int r17, String r18, int r19, int r110, String r111, int r112, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.f10491a = r10;
        this.f10492b = r11;
        this.f10493c = r14;
        this.f10494d = r18;
        this.f10495e = r19;
        this.f10496f = r110 / r19;
        this.f10497g = null;
        this.f10498h = r13;
        this.f10499i = nativeCreate(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ int a() {
        return f10482j;
    }

    public static /* synthetic */ int b() {
        return f10483k;
    }

    public static /* synthetic */ int c() {
        return f10484l;
    }

    public static /* synthetic */ int d() {
        return f10485m;
    }

    public static /* synthetic */ int e() {
        return f10486n;
    }

    public static /* synthetic */ int f() {
        return f10487o;
    }

    public static /* synthetic */ ArrayList g() {
        return f10489q;
    }

    private static native void nativeAsyncFlush(long r10);

    private static native long nativeCreate(int r10, boolean r11, String r12, String r13, int r14, int r15, int r16, String r17, int r18, int r19, String r110, int r111, int r112, int r113, int r114, int r115, int r116, String r117);

    private static native void nativeDestroy(long r10);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long r10);

    private static native void nativeSetLevel(long r10, int r11);

    private static native void nativeSetSyslog(long r10, boolean r11);

    private static native void nativeSyncFlush(long r10);

    private static native void nativeTimedSyncFlush(long r10, int r11);

    private static native void nativeWrite(long r10, int r11, String r12, String r13);

    private static native void nativeWriteAsyncMsg(long r10, int r11, String r12, String r13, long r14, long r15);

    public static synchronized void o(ILibLoader r10) {
        monitor-enter(Alog.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f10490r == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r10 != null) goto L12;
        System.loadLibrary("oalog");     // Catch: Throwable -> L10
    L13:
        f10490r = true;     // Catch: Throwable -> L10
        monitor-exit(Alog.class);
        return;
    L12:
        r10.loadLibrary("oalog");     // Catch: Throwable -> L10
        goto L13
    }

    public void finalize() {
        super.finalize();     // Catch: Throwable -> L5
        i();
        return;
    L5:
        th = move-exception;
        i();
        throw th;
    }

    public void h() {
        long r10 = this.f10499i;
        if (r10 == 0) goto L6;
        nativeAsyncFlush(r10);
        return;
    }

    public void i() {
        monitor-enter(this);
        long r10 = this.f10499i;     // Catch: Throwable -> L6
        if (r10 == 0) goto L8;
        this.f10491a = null;     // Catch: Throwable -> L6
        this.f10492b = 6;     // Catch: Throwable -> L6
        nativeDestroy(r10);     // Catch: Throwable -> L6
        this.f10499i = 0;     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void j(String r10, String r11) {
        s(1, r10, r11);
    }

    public void k(String r10, String r11) {
        s(4, r10, r11);
    }

    public long l() {
        if (this.f10499i != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public long m() {
        return this.f10499i;
    }

    public void n(String r10, String r11) {
        s(2, r10, r11);
    }

    public void p(int r10) {
        this.f10492b = r10;
        long r11 = this.f10499i;
        if (r11 == 0) goto L6;
        nativeSetLevel(r11, r10);
        return;
    }

    public void q(String r10, String r11) {
        s(0, r10, r11);
    }

    public void r(String r10, String r11) {
        s(3, r10, r11);
    }

    public void s(int r10, String r11, String r12) {
        if (this.f10499i != 0) goto L5;
        return;
    L5:
        if (r10 < this.f10492b) goto L21;
        if (r11 == null) goto L22;
        if (r12 != null) goto L9;
        return;
    L9:
        if (f10488p == null) goto L17;
        b r13 = new b(r10, r11, r12);
        Iterator r14 = f10488p.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r13 = ((IMessageInterceptor) r14.next()).intercept(r13);
        goto L12
    L14:
        if (r13 != null) goto L16;
        return;
    L16:
        nativeWrite(this.f10499i, r13.f22544a, r13.f22545b, r13.f22546c);
        return;
    L17:
        nativeWrite(this.f10499i, r10, r11, r12);
        return;
    L22:
        return;
    }

    public void t(int r13, String r14, String r15, long r16, long r18) {
        if (this.f10499i != 0) goto L5;
        return;
    L5:
        if (r13 < this.f10492b) goto L21;
        if (r14 == null) goto L22;
        if (r15 != null) goto L9;
        return;
    L9:
        if (f10488p == null) goto L17;
        b r10 = new b(r13, r14, r15);
        Iterator r11 = f10488p.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        r10 = ((IMessageInterceptor) r11.next()).intercept(r10);
        goto L12
    L14:
        if (r10 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.f10499i, r10.f22544a, r10.f22545b, r10.f22546c, r16, r18);
        return;
    L17:
        nativeWriteAsyncMsg(this.f10499i, r13, r14, r15, r16, r18);
        return;
    L22:
        return;
    }
}
