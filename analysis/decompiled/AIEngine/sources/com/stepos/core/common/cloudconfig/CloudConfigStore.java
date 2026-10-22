package com.stepos.core.common.cloudconfig;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import gc.n;
import gc.q;
import java.io.File;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.l;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudConfigStore {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "CloudConfigStore";
    private final File configDir;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class SuccessMarker {
        private final String sha;
        private final long version;
        private final long wallClockMs;

        public SuccessMarker(long j10, long j11, String sha) {
            g.f(sha, "sha");
            this.wallClockMs = j10;
            this.version = j11;
            this.sha = sha;
        }

        public static /* synthetic */ SuccessMarker copy$default(SuccessMarker successMarker, long j10, long j11, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = successMarker.wallClockMs;
            }
            long j12 = j10;
            if ((i10 & 2) != 0) {
                j11 = successMarker.version;
            }
            long j13 = j11;
            if ((i10 & 4) != 0) {
                str = successMarker.sha;
            }
            return successMarker.copy(j12, j13, str);
        }

        public final long component1() {
            return this.wallClockMs;
        }

        public final long component2() {
            return this.version;
        }

        public final String component3() {
            return this.sha;
        }

        public final SuccessMarker copy(long j10, long j11, String sha) {
            g.f(sha, "sha");
            return new SuccessMarker(j10, j11, sha);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SuccessMarker)) {
                return false;
            }
            SuccessMarker successMarker = (SuccessMarker) obj;
            return this.wallClockMs == successMarker.wallClockMs && this.version == successMarker.version && g.b(this.sha, successMarker.sha);
        }

        public final String getSha() {
            return this.sha;
        }

        public final long getVersion() {
            return this.version;
        }

        public final long getWallClockMs() {
            return this.wallClockMs;
        }

        public int hashCode() {
            return this.sha.hashCode() + a0.a.c(Long.hashCode(this.wallClockMs) * 31, this.version, 31);
        }

        public String toString() {
            long j10 = this.wallClockMs;
            long j11 = this.version;
            String str = this.sha;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "SuccessMarker(wallClockMs=", ", version=");
            ai.onnxruntime.a.u(j11, ", sha=", str, sbQ);
            sbQ.append(")");
            return sbQ.toString();
        }
    }

    public CloudConfigStore(File configDir) {
        g.f(configDir, "configDir");
        this.configDir = configDir;
        if (configDir.exists()) {
            return;
        }
        configDir.mkdirs();
    }

    private final File markerFile(String str) {
        return new File(this.configDir, a0.a.j(str, ".marker"));
    }

    private final String sha8(byte[] bArr) {
        byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(bArr);
        g.e(bArrDigest, "digest(...)");
        return kotlin.collections.a.z0(l.l0(bArrDigest, 4), "", null, null, new b6.e(26), 30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence sha8$lambda$9(byte b10) {
        return String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
    }

    private final File shaFile(String str) {
        return new File(this.configDir, a0.a.j(str, ".sha"));
    }

    private final File versionFile(String str) {
        return new File(this.configDir, a0.a.j(str, ".version"));
    }

    public final long fileSize(String name) {
        g.f(name, "name");
        File file = new File(this.configDir, name);
        if (file.exists()) {
            return file.length();
        }
        return -1L;
    }

    public final SuccessMarker lastSuccess(String name) {
        Object objA;
        Long lD0;
        g.f(name, "name");
        try {
            objA = q.L0(d.Z(markerFile(name), gc.a.f9106b)).toString();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        if (str != null) {
            List listD0 = q.D0(str, new String[]{"|"}, 6);
            if (listD0.size() == 3 && (lD0 = n.d0((String) listD0.get(0))) != null) {
                long jLongValue = lD0.longValue();
                Long lD02 = n.d0((String) listD0.get(1));
                if (lD02 != null) {
                    return new SuccessMarker(jLongValue, lD02.longValue(), (String) listD0.get(2));
                }
            }
        }
        return null;
    }

    public final long mtime(String name) {
        g.f(name, "name");
        Long lValueOf = Long.valueOf(new File(this.configDir, name).lastModified());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return -1L;
    }

    public final byte[] read(String name) {
        g.f(name, "name");
        File file = new File(this.configDir, name);
        if (file.exists()) {
            return d.X(file);
        }
        return null;
    }

    public final String sha256(String name) {
        Object objA;
        g.f(name, "name");
        try {
            objA = q.L0(d.Z(shaFile(name), gc.a.f9106b)).toString();
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        String str = (String) objA;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }

    public final long version(String name) {
        Object objA;
        g.f(name, "name");
        try {
            objA = Long.valueOf(Long.parseLong(q.L0(d.Z(versionFile(name), gc.a.f9106b)).toString()));
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        Long l10 = (Long) objA;
        if (l10 != null) {
            return l10.longValue();
        }
        SuccessMarker successMarkerLastSuccess = lastSuccess(name);
        Long lValueOf = successMarkerLastSuccess != null ? Long.valueOf(successMarkerLastSuccess.getVersion()) : null;
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        return 0L;
    }

    public final synchronized void writeAtomic(String name, byte[] bytes) {
        Object objA;
        g.f(name, "name");
        g.f(bytes, "bytes");
        File file = new File(this.configDir, name);
        File file2 = new File(this.configDir, name.concat(".tmp"));
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            fileOutputStream.write(bytes);
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            lb.n nVar = lb.n.f10413a;
            fileOutputStream.close();
            if (!file2.renameTo(file)) {
                d.S(file2, file, true);
                file2.delete();
            }
            try {
                long jVersion = version(name) + 1;
                String strSha8 = sha8(bytes);
                d.e0(versionFile(name), String.valueOf(jVersion));
                d.e0(shaFile(name), strSha8);
                d.e0(markerFile(name), System.currentTimeMillis() + "|" + jVersion + "|" + strSha8);
                objA = lb.n.f10413a;
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.CLOUDCONFIG, TAG, "side files write failed name=" + name + ": " + thB.getMessage());
            }
        } finally {
        }
    }
}
