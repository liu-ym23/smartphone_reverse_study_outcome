package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.capabilitykit.common.UiType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p0.c;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6231j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6232k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6233l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6234m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6235n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6236o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ArrayList f6237p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f6238q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6241c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6246h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f6247i;

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
            TimeFormat r10 = new TimeFormat("RAW", 0, 0);
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
        public Context f6248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6250c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f6252e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6253f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6254g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6255h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f6256i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f6257j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f6258k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f6259l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6260m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6261n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6262o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6263p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6264q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f6265r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f6266s;

        public a(Context r10) {
            this.f6249b = 0;
            this.f6250c = false;
            this.f6251d = null;
            this.f6252e = null;
            this.f6253f = UiType.FLAG_REMOTE_CARD;
            this.f6254g = 20971520;
            this.f6255h = 7;
            this.f6256i = null;
            this.f6257j = 65536;
            this.f6258k = 196608;
            this.f6259l = null;
            this.f6260m = Alog.a();
            this.f6261n = Alog.b();
            this.f6262o = Alog.c();
            this.f6263p = Alog.d();
            this.f6264q = Alog.e();
            this.f6265r = Alog.f();
            this.f6266s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L5;
            r10 = r11;
        L5:
            this.f6248a = r10;
        }

        public Alog a() {
            if (this.f6251d != null) goto L5;
            this.f6251d = "default";
        L5:
            ArrayList r10 = Alog.g();
            monitor-enter(r10);
            Iterator r11 = Alog.g().iterator();     // Catch: Throwable -> L14
        L9:
            if (r11.hasNext() == false) goto L16;
            if (((String) r11.next()).equals(this.f6251d) == false) goto L9;
            monitor-exit(r10);     // Catch: Throwable -> L14
            return null;
        L16:
            Alog.g().add(this.f6251d);     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
            if (this.f6252e != null) goto L25;
            File r12 = this.f6248a.getExternalFilesDir(null);
            if (r12 == null) goto L23;
            this.f6252e = r12.getPath() + "/alog";
            goto L25
        L23:
            this.f6252e = this.f6248a.getFilesDir() + "/alog";
        L25:
            if (this.f6256i != null) goto L28;
            this.f6256i = this.f6248a.getFilesDir() + "/alog";
        L28:
            if (this.f6259l != null) goto L30;
            this.f6259l = c.a(this.f6248a);
        L30:
            int r13 = (this.f6257j / 4096) * 4096;
            this.f6257j = r13;
            int r14 = (this.f6258k / 4096) * 4096;
            this.f6258k = r14;
            if (r13 >= 4096) goto L33;
            this.f6257j = 4096;
        L33:
            int r15 = this.f6257j;
            if (r14 >= (r15 * 2)) goto L37;
            this.f6258k = r15 * 2;
        L37:
            return new Alog(this.f6248a, this.f6249b, this.f6250c, this.f6251d, this.f6252e, this.f6253f, this.f6254g, this.f6255h, this.f6256i, this.f6257j, this.f6258k, this.f6259l, this.f6260m, this.f6261n, this.f6262o, this.f6263p, this.f6264q, this.f6265r, this.f6266s);
        L14:
            th = move-exception;
            throw th;
        }

        public a b(AsymCrypt r10) {
            this.f6265r = r10.getValue();
            return this;
        }

        public a c(String r10) {
            this.f6256i = r10;
            return this;
        }

        public a d(int r10) {
            this.f6257j = r10;
            return this;
        }

        public a e(int r10) {
            this.f6258k = r10;
            return this;
        }

        public a f(Compress r10) {
            this.f6263p = r10.getValue();
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
            this.f6251d = r10;
            goto L13
        }

        public a h(int r10) {
            this.f6249b = r10;
            return this;
        }

        public a i(String r10) {
            this.f6252e = r10;
            return this;
        }

        public a j(int r10) {
            this.f6255h = r10;
            return this;
        }

        public a k(int r10) {
            this.f6253f = r10;
            return this;
        }

        public a l(int r10) {
            this.f6254g = r10;
            return this;
        }

        public a m(Mode r10) {
            this.f6260m = r10.getValue();
            return this;
        }

        public a n(PrefixFormat r10) {
            this.f6262o = r10.getValue();
            return this;
        }

        public a o(String r10) {
            this.f6266s = r10;
            return this;
        }

        public a p(SymCrypt r10) {
            this.f6264q = r10.getValue();
            return this;
        }

        public a q(boolean r10) {
            this.f6250c = r10;
            return this;
        }

        public a r(TimeFormat r10) {
            this.f6261n = r10.getValue();
            return this;
        }
    }

    static {
        f6231j = Mode.SAFE.getValue();
        f6232k = TimeFormat.RAW.getValue();
        f6233l = PrefixFormat.DEFAULT.getValue();
        f6234m = Compress.ZSTD.getValue();
        f6235n = SymCrypt.TEA_16.getValue();
        f6236o = AsymCrypt.EC_SECP256K1.getValue();
        f6237p = new ArrayList();
        f6238q = false;
    }

    public Alog(Context r10, int r11, boolean r12, String r13, String r14, int r15, int r16, int r17, String r18, int r19, int r110, String r111, int r112, int r20, int r21, int r22, int r23, int r24, String r25) {
        this.f6239a = r10;
        this.f6240b = r11;
        this.f6241c = r14;
        this.f6242d = r18;
        this.f6243e = r19;
        this.f6244f = r110 / r19;
        this.f6245g = null;
        this.f6246h = r13;
        this.f6247i = nativeCreate(r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ int a() {
        return f6231j;
    }

    public static /* synthetic */ int b() {
        return f6232k;
    }

    public static /* synthetic */ int c() {
        return f6233l;
    }

    public static /* synthetic */ int d() {
        return f6234m;
    }

    public static /* synthetic */ int e() {
        return f6235n;
    }

    public static /* synthetic */ int f() {
        return f6236o;
    }

    public static /* synthetic */ ArrayList g() {
        return f6237p;
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

    public static synchronized void p(ILibLoader r10) {
        monitor-enter(Alog.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f6238q == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        if (r10 != null) goto L12;
        System.loadLibrary(CloudControlInf.ALOG);     // Catch: Throwable -> L10
    L13:
        f6238q = true;     // Catch: Throwable -> L10
        monitor-exit(Alog.class);
        return;
    L12:
        r10.loadLibrary(CloudControlInf.ALOG);     // Catch: Throwable -> L10
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
        long r10 = this.f6247i;
        if (r10 == 0) goto L6;
        nativeAsyncFlush(r10);
        return;
    }

    public void i() {
        monitor-enter(this);
        long r10 = this.f6247i;     // Catch: Throwable -> L6
        if (r10 == 0) goto L8;
        this.f6239a = null;     // Catch: Throwable -> L6
        this.f6240b = 6;     // Catch: Throwable -> L6
        nativeDestroy(r10);     // Catch: Throwable -> L6
        this.f6247i = 0;     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void j(String r10, String r11) {
        t(1, r10, r11);
    }

    public void k(String r10, String r11) {
        t(4, r10, r11);
    }

    public long l() {
        if (this.f6247i != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public File[] m(String r10, String r11, long r12, long r13) {
        return p0.a.a(this.f6241c, r10, r11, r12, r13);
    }

    public long n() {
        return this.f6247i;
    }

    public void o(String r10, String r11) {
        t(2, r10, r11);
    }

    public void q(boolean r10) {
        long r11 = this.f6247i;
        if (r11 == 0) goto L6;
        nativeSetSyslog(r11, r10);
        return;
    }

    public void r(String r10, String r11) {
        t(0, r10, r11);
    }

    public void s(String r10, String r11) {
        t(3, r10, r11);
    }

    public void t(int r10, String r11, String r12) {
        long r13 = this.f6247i;
        if (r13 != 0) goto L5;
        return;
    L5:
        if (r10 < this.f6240b) goto L11;
        if (r11 == null) goto L12;
        if (r12 == null) goto L13;
        nativeWrite(r13, r10, r11, r12);
        return;
    L13:
        return;
    L12:
        return;
    }

    public void u(int r10, String r11, String r12, long r13, long r15) {
        long r14 = this.f6247i;
        if (r14 != 0) goto L5;
        return;
    L5:
        if (r10 < this.f6240b) goto L11;
        if (r11 == null) goto L12;
        if (r12 == null) goto L13;
        nativeWriteAsyncMsg(r14, r10, r11, r12, r13, r15);
        return;
    L13:
        return;
    L12:
        return;
    }
}
