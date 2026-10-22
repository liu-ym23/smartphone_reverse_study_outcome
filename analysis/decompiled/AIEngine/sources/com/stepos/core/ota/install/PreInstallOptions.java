package com.stepos.core.ota.install;

import ai.onnxruntime.a;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PreInstallOptions {
    private final boolean enableZipPreset;
    private final int maxConcurrentExtract;
    private final boolean requireSha256;
    private final boolean syncPeekZipVersion;
    private final ExtractMode zipExtractMode;

    public PreInstallOptions() {
        this(null, 0, false, false, false, 31, null);
    }

    public static /* synthetic */ PreInstallOptions copy$default(PreInstallOptions preInstallOptions, ExtractMode extractMode, int i10, boolean z, boolean z3, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            extractMode = preInstallOptions.zipExtractMode;
        }
        if ((i11 & 2) != 0) {
            i10 = preInstallOptions.maxConcurrentExtract;
        }
        if ((i11 & 4) != 0) {
            z = preInstallOptions.syncPeekZipVersion;
        }
        if ((i11 & 8) != 0) {
            z3 = preInstallOptions.requireSha256;
        }
        if ((i11 & 16) != 0) {
            z10 = preInstallOptions.enableZipPreset;
        }
        boolean z11 = z10;
        boolean z12 = z;
        return preInstallOptions.copy(extractMode, i10, z12, z3, z11);
    }

    public final ExtractMode component1() {
        return this.zipExtractMode;
    }

    public final int component2() {
        return this.maxConcurrentExtract;
    }

    public final boolean component3() {
        return this.syncPeekZipVersion;
    }

    public final boolean component4() {
        return this.requireSha256;
    }

    public final boolean component5() {
        return this.enableZipPreset;
    }

    public final PreInstallOptions copy(ExtractMode zipExtractMode, int i10, boolean z, boolean z3, boolean z10) {
        g.f(zipExtractMode, "zipExtractMode");
        return new PreInstallOptions(zipExtractMode, i10, z, z3, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PreInstallOptions)) {
            return false;
        }
        PreInstallOptions preInstallOptions = (PreInstallOptions) obj;
        return this.zipExtractMode == preInstallOptions.zipExtractMode && this.maxConcurrentExtract == preInstallOptions.maxConcurrentExtract && this.syncPeekZipVersion == preInstallOptions.syncPeekZipVersion && this.requireSha256 == preInstallOptions.requireSha256 && this.enableZipPreset == preInstallOptions.enableZipPreset;
    }

    public final boolean getEnableZipPreset() {
        return this.enableZipPreset;
    }

    public final int getMaxConcurrentExtract() {
        return this.maxConcurrentExtract;
    }

    public final boolean getRequireSha256() {
        return this.requireSha256;
    }

    public final boolean getSyncPeekZipVersion() {
        return this.syncPeekZipVersion;
    }

    public final ExtractMode getZipExtractMode() {
        return this.zipExtractMode;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enableZipPreset) + a.f(a.f(a.d(this.maxConcurrentExtract, this.zipExtractMode.hashCode() * 31, 31), 31, this.syncPeekZipVersion), 31, this.requireSha256);
    }

    public String toString() {
        ExtractMode extractMode = this.zipExtractMode;
        int i10 = this.maxConcurrentExtract;
        boolean z = this.syncPeekZipVersion;
        boolean z3 = this.requireSha256;
        boolean z10 = this.enableZipPreset;
        StringBuilder sb2 = new StringBuilder("PreInstallOptions(zipExtractMode=");
        sb2.append(extractMode);
        sb2.append(", maxConcurrentExtract=");
        sb2.append(i10);
        sb2.append(", syncPeekZipVersion=");
        sb2.append(z);
        sb2.append(", requireSha256=");
        sb2.append(z3);
        sb2.append(", enableZipPreset=");
        return a0.a.m(sb2, z10, ")");
    }

    public PreInstallOptions(ExtractMode zipExtractMode, int i10, boolean z, boolean z3, boolean z10) {
        g.f(zipExtractMode, "zipExtractMode");
        this.zipExtractMode = zipExtractMode;
        this.maxConcurrentExtract = i10;
        this.syncPeekZipVersion = z;
        this.requireSha256 = z3;
        this.enableZipPreset = z10;
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ PreInstallOptions(com.stepos.core.ota.install.ExtractMode r2, int r3, boolean r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.e r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            com.stepos.core.ota.install.ExtractMode r2 = com.stepos.core.ota.install.ExtractMode.ASYNC
        L6:
            r8 = r7 & 2
            if (r8 == 0) goto Lb
            r3 = 2
        Lb:
            r8 = r7 & 4
            r0 = 1
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            if (r8 == 0) goto L16
            r5 = 0
        L16:
            r7 = r7 & 16
            if (r7 == 0) goto L21
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L27
        L21:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L27:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ota.install.PreInstallOptions.<init>(com.stepos.core.ota.install.ExtractMode, int, boolean, boolean, boolean, int, kotlin.jvm.internal.e):void");
    }
}
