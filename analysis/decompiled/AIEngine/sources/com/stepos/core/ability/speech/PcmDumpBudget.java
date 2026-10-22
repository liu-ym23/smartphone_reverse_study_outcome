package com.stepos.core.ability.speech;

import kotlin.Result;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PcmDumpBudget {
    public static final long BYTES_PER_MB = 1048576;
    public static final int DEFAULT_DIR_MB = 4096;
    public static final int DEFAULT_FILE_MB = 256;
    public static final int HARD_MAX_DIR_MB = 8192;
    public static final int HARD_MAX_FILE_MB = 2048;
    public static final PcmDumpBudget INSTANCE = new PcmDumpBudget();
    public static final String ORIGIN_DEFAULT = "default";
    public static final String ORIGIN_PROP = "prop";
    public static final String ORIGIN_PROP_CLAMPED = "prop,clamped";
    public static final String ORIGIN_RAISED_TO_FILE = "raisedToFile";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Caps {
        private final String dirOrigin;
        private final String fileOrigin;
        private final long maxDirBytes;
        private final long maxFileBytes;

        public Caps(long j10, long j11, String fileOrigin, String dirOrigin) {
            kotlin.jvm.internal.g.f(fileOrigin, "fileOrigin");
            kotlin.jvm.internal.g.f(dirOrigin, "dirOrigin");
            this.maxFileBytes = j10;
            this.maxDirBytes = j11;
            this.fileOrigin = fileOrigin;
            this.dirOrigin = dirOrigin;
        }

        public static /* synthetic */ Caps copy$default(Caps caps, long j10, long j11, String str, String str2, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = caps.maxFileBytes;
            }
            long j12 = j10;
            if ((i10 & 2) != 0) {
                j11 = caps.maxDirBytes;
            }
            long j13 = j11;
            if ((i10 & 4) != 0) {
                str = caps.fileOrigin;
            }
            String str3 = str;
            if ((i10 & 8) != 0) {
                str2 = caps.dirOrigin;
            }
            return caps.copy(j12, j13, str3, str2);
        }

        public final long component1() {
            return this.maxFileBytes;
        }

        public final long component2() {
            return this.maxDirBytes;
        }

        public final String component3() {
            return this.fileOrigin;
        }

        public final String component4() {
            return this.dirOrigin;
        }

        public final Caps copy(long j10, long j11, String fileOrigin, String dirOrigin) {
            kotlin.jvm.internal.g.f(fileOrigin, "fileOrigin");
            kotlin.jvm.internal.g.f(dirOrigin, "dirOrigin");
            return new Caps(j10, j11, fileOrigin, dirOrigin);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Caps)) {
                return false;
            }
            Caps caps = (Caps) obj;
            return this.maxFileBytes == caps.maxFileBytes && this.maxDirBytes == caps.maxDirBytes && kotlin.jvm.internal.g.b(this.fileOrigin, caps.fileOrigin) && kotlin.jvm.internal.g.b(this.dirOrigin, caps.dirOrigin);
        }

        public final long getDirCapMb() {
            return this.maxDirBytes / PcmDumpBudget.BYTES_PER_MB;
        }

        public final String getDirOrigin() {
            return this.dirOrigin;
        }

        public final long getFileCapMb() {
            return this.maxFileBytes / PcmDumpBudget.BYTES_PER_MB;
        }

        public final String getFileOrigin() {
            return this.fileOrigin;
        }

        public final long getMaxDirBytes() {
            return this.maxDirBytes;
        }

        public final long getMaxFileBytes() {
            return this.maxFileBytes;
        }

        public int hashCode() {
            return this.dirOrigin.hashCode() + v1.d.a(a0.a.c(Long.hashCode(this.maxFileBytes) * 31, this.maxDirBytes, 31), 31, this.fileOrigin);
        }

        public final String toLog() {
            long fileCapMb = getFileCapMb();
            String str = this.fileOrigin;
            long dirCapMb = getDirCapMb();
            String str2 = this.dirOrigin;
            StringBuilder sbO = a0.a.o("fileCapMb=", fileCapMb, "(", str);
            a0.a.s(dirCapMb, ") dirCapMb=", "(", sbO);
            return ai.onnxruntime.a.o(sbO, str2, ")");
        }

        public String toString() {
            long j10 = this.maxFileBytes;
            long j11 = this.maxDirBytes;
            String str = this.fileOrigin;
            String str2 = this.dirOrigin;
            StringBuilder sbQ = ai.onnxruntime.a.q(j10, "Caps(maxFileBytes=", ", maxDirBytes=");
            ai.onnxruntime.a.u(j11, ", fileOrigin=", str, sbQ);
            return ai.onnxruntime.a.p(sbQ, ", dirOrigin=", str2, ")");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ResolvedMb {

        /* renamed from: mb, reason: collision with root package name */
        private final int f7234mb;
        private final String origin;

        public ResolvedMb(int i10, String origin) {
            kotlin.jvm.internal.g.f(origin, "origin");
            this.f7234mb = i10;
            this.origin = origin;
        }

        public static /* synthetic */ ResolvedMb copy$default(ResolvedMb resolvedMb, int i10, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = resolvedMb.f7234mb;
            }
            if ((i11 & 2) != 0) {
                str = resolvedMb.origin;
            }
            return resolvedMb.copy(i10, str);
        }

        public final int component1() {
            return this.f7234mb;
        }

        public final String component2() {
            return this.origin;
        }

        public final ResolvedMb copy(int i10, String origin) {
            kotlin.jvm.internal.g.f(origin, "origin");
            return new ResolvedMb(i10, origin);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResolvedMb)) {
                return false;
            }
            ResolvedMb resolvedMb = (ResolvedMb) obj;
            return this.f7234mb == resolvedMb.f7234mb && kotlin.jvm.internal.g.b(this.origin, resolvedMb.origin);
        }

        public final int getMb() {
            return this.f7234mb;
        }

        public final String getOrigin() {
            return this.origin;
        }

        public int hashCode() {
            return this.origin.hashCode() + (Integer.hashCode(this.f7234mb) * 31);
        }

        public String toString() {
            return "ResolvedMb(mb=" + this.f7234mb + ", origin=" + this.origin + ")";
        }
    }

    private PcmDumpBudget() {
    }

    private final int readIntProp(String str, int i10) {
        Object objA;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i10));
            kotlin.jvm.internal.g.d(objInvoke, "null cannot be cast to non-null type kotlin.Int");
            objA = (Integer) objInvoke;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Object objValueOf = Integer.valueOf(i10);
        if (objA instanceof Result.Failure) {
            objA = objValueOf;
        }
        return ((Number) objA).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlin.Result$Failure] */
    private final String readStringProp(String str, String str2) {
        String strA;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            kotlin.jvm.internal.g.d(objInvoke, "null cannot be cast to non-null type kotlin.String");
            strA = (String) objInvoke;
        } catch (Throwable th) {
            strA = kotlin.c.a(th);
        }
        if (!(strA instanceof Result.Failure)) {
            str2 = strA;
        }
        return str2;
    }

    public final Caps capsFromProps(int i10, int i11) {
        ResolvedMb resolvedMbResolve = resolve(i10, 256, 2048);
        ResolvedMb resolvedMbResolve2 = resolve(i11, 4096, HARD_MAX_DIR_MB);
        int mb2 = resolvedMbResolve2.getMb();
        int mb3 = resolvedMbResolve.getMb();
        if (mb2 < mb3) {
            mb2 = mb3;
        }
        return new Caps(resolvedMbResolve.getMb() * BYTES_PER_MB, BYTES_PER_MB * mb2, resolvedMbResolve.getOrigin(), mb2 > resolvedMbResolve2.getMb() ? ORIGIN_RAISED_TO_FILE : resolvedMbResolve2.getOrigin());
    }

    public final boolean isEnabled(String prop) {
        kotlin.jvm.internal.g.f(prop, "prop");
        return kotlin.jvm.internal.g.b(readStringProp(prop, "0"), "1");
    }

    public final Caps readCaps(String fileProp, String dirProp) {
        kotlin.jvm.internal.g.f(fileProp, "fileProp");
        kotlin.jvm.internal.g.f(dirProp, "dirProp");
        return capsFromProps(readIntProp(fileProp, 0), readIntProp(dirProp, 0));
    }

    public final ResolvedMb resolve(int i10, int i11, int i12) {
        if (i10 <= 0) {
            return new ResolvedMb(i11, "default");
        }
        int iA0 = dc.h.a0(i10, 1, i12);
        return new ResolvedMb(iA0, iA0 == i10 ? ORIGIN_PROP : ORIGIN_PROP_CLAMPED);
    }

    public final int resolveMb(int i10, int i11, int i12) {
        return resolve(i10, i11, i12).getMb();
    }
}
