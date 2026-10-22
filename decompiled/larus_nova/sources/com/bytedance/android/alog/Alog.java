package com.bytedance.android.alog;

import android.content.Context;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Alog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38325i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38326j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f38327k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f38328l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38329m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f38330n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static volatile List<d> f38331o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ArrayList<String> f38332p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f38333q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f38337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f38338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f38339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f38340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f38341h;

    public static final enum AsymCrypt extends Enum<AsymCrypt> {
        public static final AsymCrypt EC_SECP256K1 = null;
        public static final AsymCrypt EC_SECP256R1 = null;
        public static final AsymCrypt NONE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AsymCrypt[] f38342a = null;
        private final int value;

        static {
            AsymCrypt r100 = new AsymCrypt(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            AsymCrypt r101 = new AsymCrypt("EC_SECP256K1", 1, 1);
            EC_SECP256K1 = r101;
            AsymCrypt r102 = new AsymCrypt("EC_SECP256R1", 2, 2);
            EC_SECP256R1 = r102;
            f38342a = new AsymCrypt[]{r100, r101, r102};
        }

        public static AsymCrypt[] values() {
            return (AsymCrypt[]) f38342a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static AsymCrypt valueOf(String r100) {
            return (AsymCrypt) r27.a.a(AsymCrypt.class, r100);
        }

        public AsymCrypt(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Compress extends Enum<Compress> {
        public static final Compress NONE = null;
        public static final Compress ZLIB = null;
        public static final Compress ZSTD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Compress[] f38343a = null;
        private final int value;

        static {
            Compress r100 = new Compress(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            Compress r101 = new Compress("ZLIB", 1, 1);
            ZLIB = r101;
            Compress r102 = new Compress("ZSTD", 2, 2);
            ZSTD = r102;
            f38343a = new Compress[]{r100, r101, r102};
        }

        public static Compress[] values() {
            return (Compress[]) f38343a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Compress valueOf(String r100) {
            return (Compress) r27.a.a(Compress.class, r100);
        }

        public Compress(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        public static final Mode SAFE = null;
        public static final Mode SPEED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f38344a = null;
        private final int value;

        static {
            Mode r100 = new Mode("SPEED", 0, 0);
            SPEED = r100;
            Mode r101 = new Mode("SAFE", 1, 1);
            SAFE = r101;
            f38344a = new Mode[]{r100, r101};
        }

        public static Mode[] values() {
            return (Mode[]) f38344a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PrefixFormat extends Enum<PrefixFormat> {
        public static final PrefixFormat DEFAULT = null;
        public static final PrefixFormat LEGACY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PrefixFormat[] f38345a = null;
        private final int value;

        static {
            PrefixFormat r100 = new PrefixFormat("DEFAULT", 0, 0);
            DEFAULT = r100;
            PrefixFormat r101 = new PrefixFormat("LEGACY", 1, 1);
            LEGACY = r101;
            f38345a = new PrefixFormat[]{r100, r101};
        }

        public static PrefixFormat[] values() {
            return (PrefixFormat[]) f38345a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static PrefixFormat valueOf(String r100) {
            return (PrefixFormat) r27.a.a(PrefixFormat.class, r100);
        }

        public PrefixFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum SymCrypt extends Enum<SymCrypt> {
        public static final SymCrypt NONE = null;
        public static final SymCrypt TEA_16 = null;
        public static final SymCrypt TEA_32 = null;
        public static final SymCrypt TEA_64 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SymCrypt[] f38346a = null;
        private final int value;

        static {
            SymCrypt r100 = new SymCrypt(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            SymCrypt r101 = new SymCrypt("TEA_16", 1, 1);
            TEA_16 = r101;
            SymCrypt r102 = new SymCrypt("TEA_32", 2, 2);
            TEA_32 = r102;
            SymCrypt r103 = new SymCrypt("TEA_64", 3, 3);
            TEA_64 = r103;
            f38346a = new SymCrypt[]{r100, r101, r102, r103};
        }

        public static SymCrypt[] values() {
            return (SymCrypt[]) f38346a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static SymCrypt valueOf(String r100) {
            return (SymCrypt) r27.a.a(SymCrypt.class, r100);
        }

        public SymCrypt(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum TimeFormat extends Enum<TimeFormat> {
        public static final TimeFormat ISO_8601 = null;
        public static final TimeFormat RAW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TimeFormat[] f38347a = null;
        private final int value;

        static {
            TimeFormat r100 = new TimeFormat("RAW", 0, 0);
            RAW = r100;
            TimeFormat r101 = new TimeFormat("ISO_8601", 1, 1);
            ISO_8601 = r101;
            f38347a = new TimeFormat[]{r100, r101};
        }

        public static TimeFormat[] values() {
            return (TimeFormat[]) f38347a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static TimeFormat valueOf(String r100) {
            return (TimeFormat) r27.a.a(TimeFormat.class, r100);
        }

        public TimeFormat(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f38348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f38350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f38351d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f38352e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f38353f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f38354g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f38355h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f38356i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f38357j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f38358k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f38359l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f38360m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f38361n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f38362o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f38363p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f38364q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f38365r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f38366s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f38367t;

        public final Alog a() {
            if (this.f38351d != null) goto L5;
            this.f38351d = "default";
        L5:
            ArrayList<String> r100 = Alog.f38332p;
            monitor-enter(r100);
            Iterator<String> r101 = r100.iterator();     // Catch: Throwable -> L43
        L8:
            String r102 = null;
            if (r101.hasNext() == false) goto L14;
            if (r101.next().equals(this.f38351d) == false) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L43
            return null;
        L14:
            Alog.f38332p.add(this.f38351d);     // Catch: Throwable -> L43
            monitor-exit(r100);     // Catch: Throwable -> L43
            if (this.f38352e != null) goto L23;
            File r103 = this.f38348a.getExternalFilesDir(null);
            if (r103 == null) goto L21;
            this.f38352e = r103.getPath() + "/alog";
            goto L23
        L21:
            this.f38352e = this.f38348a.getFilesDir() + "/alog";
        L23:
            if (this.f38356i != null) goto L26;
            this.f38356i = this.f38348a.getFilesDir() + "/alog";
        L26:
            if (this.f38359l != null) goto L35;
            Context r104 = this.f38348a;
            r102 = r104.getPackageManager().getPackageInfo(r104.getPackageName(), 0).versionName;     // Catch: Exception -> L30
        L32:
            if (TextUtils.isEmpty(r102) == false) goto L34;
            r102 = "unknown";
        L34:
            this.f38359l = r102;
        L35:
            int r105 = (this.f38357j / 4096) * 4096;
            this.f38357j = r105;
            int r106 = (this.f38358k / 4096) * 4096;
            this.f38358k = r106;
            if (r105 >= 4096) goto L38;
            this.f38357j = 4096;
        L38:
            int r107 = this.f38357j;
            if (r106 >= (r107 * 2)) goto L42;
            this.f38358k = r107 * 2;
        L42:
            return new Alog(this.f38348a, this.f38349b, this.f38350c, this.f38351d, this.f38352e, this.f38353f, this.f38354g, this.f38355h, this.f38356i, this.f38357j, this.f38358k, this.f38359l, this.f38360m, this.f38361n, this.f38362o, this.f38363p, this.f38364q, this.f38365r, this.f38366s, this.f38367t);
        L43:
            th = move-exception;
            throw th;
        }

        public a(Context r100) {
            this.f38349b = 0;
            this.f38350c = false;
            this.f38351d = null;
            this.f38352e = null;
            this.f38353f = 2097152;
            this.f38354g = 20971520;
            this.f38355h = 7;
            this.f38356i = null;
            this.f38357j = 65536;
            this.f38358k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            this.f38359l = null;
            this.f38360m = Alog.f38325i;
            this.f38361n = Alog.f38326j;
            this.f38362o = Alog.f38327k;
            this.f38363p = Alog.f38328l;
            this.f38364q = Alog.f38329m;
            this.f38365r = Alog.f38330n;
            this.f38366s = "b012e20c9aab1cb5257aca2069cb79a9339b3a2224f771c78d64972137936eaf0b2f7ebd8d46c2607e1d7fe7723d40b147b8ecfa8fe2eaeee05210c75822381a";
            this.f38367t = false;
            Context r101 = r100.getApplicationContext();
            if (r101 == null) goto L5;
            r100 = r101;
        L5:
            this.f38348a = r100;
        }

        public final void b(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L5;
            return;
        L5:
            if (r100.contains("-") == false) goto L8;
            r100 = r100.replace("-", "");
        L8:
            if (r100.contains("_") == false) goto L11;
            r100 = r100.replace("_", "");
        L11:
            if (TextUtils.isEmpty(r100) == true) goto L15;
            this.f38351d = r100;
            return;
        }
    }

    private static native void nativeAsyncFlush(long r100);

    private static native long nativeCreate(int r100, boolean r101, String r102, String r103, int r104, int r105, int r106, String r107, int r108, int r109, String r110, int r111, int r112, int r113, int r114, int r115, int r116, String r117, boolean r118, long r119);

    private static native void nativeDestroy(long r100);

    private static native long nativeGetLegacyFlushFuncAddr();

    private static native long nativeGetLegacyGetLogFileDirFuncAddr();

    private static native long nativeGetLegacyWriteFuncAddr();

    private static native long nativeGetNativeInitFuncAddr();

    private static native long nativeGetNativeWriteAsyncFuncAddr();

    private static native long nativeGetNativeWriteFuncAddr();

    public static native void nativeSetDefaultInstance(long r100);

    private static native void nativeSetLevel(long r100, int r101);

    private static native void nativeSetSyslog(long r100, boolean r101);

    private static native void nativeSyncFlush(long r100);

    private static native void nativeTimedSyncFlush(long r100, int r101);

    private static native void nativeWrite(long r100, int r101, String r102, String r103);

    private static native void nativeWriteAsyncMsg(long r100, int r101, String r102, String r103, long r104, long r105);

    public final void b() {
        monitor-enter(this);
        long r100 = this.f38341h;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        this.f38334a = 6;     // Catch: Throwable -> L8
        nativeDestroy(r100);     // Catch: Throwable -> L8
        this.f38341h = 0;     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    static {
        f38325i = Mode.SAFE.getValue();
        f38326j = TimeFormat.RAW.getValue();
        f38327k = PrefixFormat.DEFAULT.getValue();
        f38328l = Compress.ZSTD.getValue();
        f38329m = SymCrypt.TEA_16.getValue();
        f38330n = AsymCrypt.EC_SECP256K1.getValue();
        f38331o = null;
        f38332p = new ArrayList();
        f38333q = false;
    }

    public final void a() {
        long r100 = this.f38341h;
        if (r100 == 0) goto L6;
        nativeAsyncFlush(r100);
        return;
    }

    public final long c() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyFlushFuncAddr();
    }

    public final long d() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyGetLogFileDirFuncAddr();
    }

    public final long e() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetLegacyWriteFuncAddr();
    }

    public final long f() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeInitFuncAddr();
    }

    public final long g() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteAsyncFuncAddr();
    }

    public final long h() {
        if (this.f38341h != 0) goto L5;
        return 0;
    L5:
        return nativeGetNativeWriteFuncAddr();
    }

    public final void l() {
        long r100 = this.f38341h;
        if (r100 == 0) goto L6;
        nativeSyncFlush(r100);
        return;
    }

    public final void finalize() throws Throwable {
        super.finalize();     // Catch: Throwable -> L5
        b();
        return;
    L5:
        th = move-exception;
        b();
        throw th;
    }

    public static synchronized void i(nra.c r100) {
        monitor-enter(Alog.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (f38333q == false) goto L8;
        monitor-exit(Alog.class);
        return;
    L8:
        r100.a();     // Catch: Throwable -> L11
        f38333q = true;     // Catch: Throwable -> L11
        monitor-exit(Alog.class);
    }

    public final void j(int r100) {
        this.f38334a = r100;
        long r101 = this.f38341h;
        if (r101 == 0) goto L6;
        nativeSetLevel(r101, r100);
        return;
    }

    public final void k(boolean r100) {
        long r101 = this.f38341h;
        if (r101 == 0) goto L6;
        nativeSetSyslog(r101, r100);
        return;
    }

    public final void m(int r100) {
        long r101 = this.f38341h;
        if (r101 == 0) goto L6;
        nativeTimedSyncFlush(r101, r100);
        return;
    }

    public final void n(int r100, String r101, String r102) {
        if (this.f38341h != 0) goto L5;
        return;
    L5:
        if (r100 < this.f38334a) goto L21;
        if (r101 == null) goto L22;
        if (r102 != null) goto L9;
        return;
    L9:
        if (f38331o == null) goto L17;
        f r103 = new f(r100, r101, r102);
        Iterator r104 = ((CopyOnWriteArrayList) f38331o).iterator();
    L12:
        if (r104.hasNext() == false) goto L14;
        r103 = ((d) r104.next()).intercept();
        goto L12
    L14:
        if (r103 != null) goto L16;
        return;
    L16:
        nativeWrite(this.f38341h, r103.f38379a, r103.f38380b, r103.f38381c);
        return;
    L17:
        nativeWrite(this.f38341h, r100, r101, r102);
        return;
    L22:
        return;
    }

    public final void o(int r110, String r111, String r112, long r113, long r114) {
        if (this.f38341h != 0) goto L5;
        return;
    L5:
        if (r110 < this.f38334a) goto L21;
        if (r111 == null) goto L22;
        if (r112 != null) goto L9;
        return;
    L9:
        if (f38331o == null) goto L17;
        f r100 = new f(r110, r111, r112);
        Iterator r101 = ((CopyOnWriteArrayList) f38331o).iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        r100 = ((d) r101.next()).intercept();
        goto L12
    L14:
        if (r100 != null) goto L16;
        return;
    L16:
        nativeWriteAsyncMsg(this.f38341h, r100.f38379a, r100.f38380b, r100.f38381c, r113, r114);
        return;
    L17:
        nativeWriteAsyncMsg(this.f38341h, r110, r111, r112, r113, r114);
        return;
    L22:
        return;
    }

    public Alog(Context r210, int r211, boolean r212, String r213, String r214, int r215, int r216, int r310, String r311, int r312, int r313, String r314, int r315, int r316, int r317, int r318, int r319, int r410, String r411, boolean r412) {
        this.f38334a = r211;
        this.f38335b = r214;
        this.f38336c = r311;
        this.f38337d = r312;
        this.f38338e = r313 / r312;
        this.f38339f = null;
        this.f38340g = r213;
        this.f38341h = nativeCreate(r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, TimeZone.getDefault().getRawOffset() / 1000);
    }
}
