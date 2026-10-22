package com.bytedance.crash.monitor;

import com.bytedance.crash.o.j;
import com.bytedance.crash.o.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f7565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CachedString f7566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CachedString f7567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CachedString f7568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CachedString f7569e;
    private CachedVersion f;

    static class CachedString implements Serializable {
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private String mValue;

        CachedString() {
        }

        String getBefore(File r8, String r9, long r10) {
            if (r10 == 0) goto L36;
            long r3 = this.mCreateTime;
            if (r3 != 0) goto L7;
        L9:
            File[] r11 = CacheManager.a(r8, r9);
            if (r11 == null) goto L12;
            int r1 = r11.length;
            int r2 = 0;
        L15:
            if (r2 >= r1) goto L25;
            File r4 = r11[r2];
            if (r10 <= CacheManager.b(r4, r9)) goto L24;
            CachedString r5 = (CachedString) ZeusTransformUtils.preCheckCast(v.a(r4), CachedString.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L23;
            String r6 = r5.mValue;
            if (r6 == null) goto L23;
            return r6;
        L23:
            j.a(r4);
        L24:
            r2 = r2 + 1;
            goto L15
        L25:
            int r12 = r11.length - 1;
        L26:
            if (r12 < 0) goto L34;
            CachedString r13 = (CachedString) ZeusTransformUtils.preCheckCast(v.a(r11[r12]), CachedString.class, "com.obric.aiagent.plugin");
            if (r13 == null) goto L32;
            String r14 = r13.mValue;
            if (r14 == null) goto L32;
            return r14;
        L32:
            r11[r12].delete();
            r12 = r12 - 1;
            goto L26
        L34:
            return this.mValue;
        L12:
            return this.mValue;
        L7:
            if (r10 <= r3) goto L9;
        L36:
            return this.mValue;
        }

        static CachedString getCurrent(File r3, String r4) {
            CachedString r5 = (CachedString) ZeusTransformUtils.preCheckCast(v.a(new File(r3, "current" + r4)), CachedString.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L5;
            return r5;
        L5:
            return new CachedString();
        }

        void update(File r7, String r8, String r9) {
            long r0 = System.currentTimeMillis();
            String r2 = this.mValue;
            if (r2 != null) goto L5;
        L8:
            this.mValue = r9;
            this.mCreateTime = r0;
            v.a(new File(r7, "current" + r8), this);
            return;
        L5:
            if (r2.equals(r9) == false) goto L7;
            return;
        L7:
            CacheManager.c(r7, r8);
            v.a(new File(r7, this.mCreateTime + r8), this);
            goto L8
        }
    }

    static class CachedVersion implements Serializable {
        public static final int VERSION_NEW = 2;
        public static final int VERSION_NO_CHANGE = 0;
        public static final int VERSION_UPDATE = 1;
        private static final String VER_SUFFIX = ".ver";
        private static final long serialVersionUID = 1;
        private long mCreateTime;
        private long mManifestCode;
        private String mName;
        private long mUpdateVersionCode;
        private long mVersionCode;

        CachedVersion() {
        }

        c getAfter(File r19, long r20) {
            long r1 = this.mCreateTime;
            c r6 = null;
            if (r1 == 0) goto L8;
            if (r20 <= r1) goto L8;
            return null;
        L8:
            if (this.mVersionCode != 0) goto L10;
        L12:
            File[] r2 = CacheManager.a(r19, VER_SUFFIX);
            if (r2 == null) goto L27;
            int r3 = r2.length;
            int r5 = 0;
        L15:
            if (r5 >= r3) goto L27;
            File r7 = r2[r5];
            if (r20 >= CacheManager.b(r7, VER_SUFFIX)) goto L26;
            CachedVersion r8 = (CachedVersion) ZeusTransformUtils.preCheckCast(v.a(r7), CachedVersion.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L21;
        L25:
            j.a(r7);
            goto L26
        L21:
            if (r8.mName == null) goto L25;
            if (r8.mVersionCode == 0) goto L25;
            r6 = new c(r8.mVersionCode, r8.mUpdateVersionCode, r8.mManifestCode, r8.mName);
        L26:
            r5 = r5 + 1;
        L27:
            return r6;
        L10:
            if (this.mName == null) goto L12;
            r6 = new c(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
            goto L12
        }

        c getBefore(File r18, long r19) {
            if (r19 == 0) goto L30;
            long r3 = this.mCreateTime;
            if (r3 != 0) goto L7;
        L9:
            File[] r4 = CacheManager.a(r18, VER_SUFFIX);
            if (r4 == null) goto L27;
            int r5 = r4.length;
            int r6 = 0;
        L12:
            if (r6 >= r5) goto L35;
            File r7 = r4[r6];
            if (r19 <= CacheManager.b(r7, VER_SUFFIX)) goto L26;
            CachedVersion r8 = (CachedVersion) ZeusTransformUtils.preCheckCast(v.a(r7), CachedVersion.class, "com.obric.aiagent.plugin");
            if (r8 != null) goto L18;
        L25:
            j.a(r7);
            goto L26
        L18:
            if (r8.mName == null) goto L25;
            if (r8.mVersionCode == 0) goto L25;
            if (r8.mUpdateVersionCode == 0) goto L25;
            return new c(r8.mVersionCode, r8.mUpdateVersionCode, r8.mManifestCode, r8.mName);
        L26:
            r6 = r6 + 1;
            goto L12
        L35:
            return null;
        L27:
            return null;
        L7:
            if (r19 <= r3) goto L9;
        L30:
            return new c(this.mVersionCode, this.mUpdateVersionCode, this.mManifestCode, this.mName);
        }

        static CachedVersion getCurrent(File r2) {
            CachedVersion r3 = (CachedVersion) ZeusTransformUtils.preCheckCast(v.a(new File(r2, "current.ver")), CachedVersion.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L5;
            return r3;
        L5:
            return new CachedVersion();
        }

        void update(File r8, long r9, long r11, long r13, String r15) {
            long r0 = System.currentTimeMillis();
            String r2 = this.mName;
            if (r2 != null) goto L5;
        L16:
            com.bytedance.crash.i.a(2);
        L17:
            this.mName = r15;
            this.mVersionCode = r9;
            this.mUpdateVersionCode = r11;
            this.mCreateTime = r0;
            this.mManifestCode = r13;
            v.a(new File(r8, "current.ver"), this);
            return;
        L5:
            if (this.mVersionCode == 0) goto L16;
            if (r2.equals(r15) == true) goto L9;
        L15:
            com.bytedance.crash.i.a(1);
            CacheManager.c(r8, VER_SUFFIX);
            v.a(new File(r8, this.mCreateTime + VER_SUFFIX), this);
            goto L17
        L9:
            if (this.mVersionCode != r9) goto L15;
            if (r13 != this.mManifestCode) goto L15;
            if (this.mUpdateVersionCode != r11) goto L15;
        }
    }

    static /* synthetic */ File[] a(File r0, String r1) {
        return e(r0, r1);
    }

    static /* synthetic */ long b(File r0, String r1) {
        return d(r0, r1);
    }

    static /* synthetic */ void c(File r0, String r1) {
        f(r0, r1);
    }

    CacheManager(File r2) {
        this.f7565a = com.bytedance.crash.o.i.a(r2, "params");
    }

    CacheManager(File r2, String r3) {
        this.f7565a = com.bytedance.crash.o.i.a(com.bytedance.crash.o.i.a(r2, "params"), r3);
    }

    String a() {
        return a(0);
    }

    String b() {
        return b(0);
    }

    long c() {
        return c(0);
    }

    String d() {
        return e(0);
    }

    c e() {
        c r8 = f(0);
        if (r8 == null) goto L5;
        return r8;
    L5:
        return new c(0, 0, 0, "0");
    }

    private CachedString d(String r5) {
        switch(r5.hashCode()) {
            case 1466958: goto L15;
            case 1468859: goto L12;
            case 1469841: goto L9;
            case 1486178: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        if (r0 == 0) goto L37;
        if (r0 == 1) goto L32;
        if (r0 == 2) goto L27;
        if (this.f7567c != null) goto L25;
        this.f7567c = CachedString.getCurrent(this.f7565a, ".chn");
    L25:
        return this.f7567c;
    L27:
        if (this.f7569e != null) goto L30;
        this.f7569e = CachedString.getCurrent(this.f7565a, r5);
    L30:
        return this.f7569e;
    L32:
        if (this.f7568d != null) goto L35;
        this.f7568d = CachedString.getCurrent(this.f7565a, r5);
    L35:
        return this.f7568d;
    L37:
        if (this.f7566b != null) goto L40;
        this.f7566b = CachedString.getCurrent(this.f7565a, r5);
    L40:
        return this.f7566b;
    L6:
        if (r5.equals(".uid") == false) goto L17;
        r0 = 2;
        goto L18
    L9:
        if (r5.equals(".did") == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (r5.equals(".chn") == false) goto L17;
        r0 = 3;
        goto L18
    L15:
        if (r5.equals(".aid") == false) goto L17;
        r0 = 1;
        goto L18
    }

    private CachedVersion f() {
        if (this.f != null) goto L6;
        this.f = CachedVersion.getCurrent(this.f7565a);
    L6:
        return this.f;
    }

    String a(long r3) {
        return d(".did").getBefore(this.f7565a, ".did", r3);
    }

    void a(String r3) {
        d(".did").update(this.f7565a, ".did", r3);
    }

    String b(long r3) {
        return d(".aid").getBefore(this.f7565a, ".aid", r3);
    }

    void b(String r3) {
        d(".aid").update(this.f7565a, ".aid", r3);
    }

    long c(long r3) {
        String r2 = d(".uid").getBefore(this.f7565a, ".uid", r3);
        if (r2 != null) goto L10;
    L8:
        return 0;
    L10:
        return Long.decode(r2).longValue();
    L6:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        goto L8
    }

    void d(long r3) {
        d(".uid").update(this.f7565a, ".uid", String.valueOf(r3));
    }

    String e(long r3) {
        return d(".chn").getBefore(this.f7565a, ".chn", r3);
    }

    void c(String r3) {
        d(".chn").update(this.f7565a, ".chn", r3);
    }

    c f(long r2) {
        return f().getBefore(this.f7565a, r2);
    }

    void a(long r10, long r12, long r14, String r16) {
        f().update(this.f7565a, r10, r12, r14, r16);
    }

    c g(long r2) {
        return f().getAfter(this.f7565a, r2);
    }

    private static long d(File r2, String r3) {
        String r4 = r2.getName();     // Catch: Throwable -> L4
        return Long.parseLong(r4.substring(0, r4.length() - r3.length()));
    L4:
        th = move-exception;
        com.bytedance.crash.c.b.a(th);
        return -1;
    }

    private static File[] e(File r1, final String r2) {
        File[] r3 = r1.listFiles(new AnonymousClass1(r2));
        if (r3 == null) goto L5;
        Arrays.sort(r3, new AnonymousClass2(r2));
    L5:
        return r3;
    }

    private static void f(File r9, String r10) {
        File[] r11 = e(r9, r10);
        if (r11 == null) goto L12;
        long r0 = System.currentTimeMillis();
        int r2 = r11.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L16;
        File r4 = r11[r3];
        long r5 = d(r4, r10);
        if (r5 <= r0) goto L9;
    L10:
        j.a(r4);
    L11:
        r3 = r3 + 1;
        goto L5
    L9:
        if ((r0 - r5) <= 1209600000) goto L11;
    L16:
        return;
    }
}
