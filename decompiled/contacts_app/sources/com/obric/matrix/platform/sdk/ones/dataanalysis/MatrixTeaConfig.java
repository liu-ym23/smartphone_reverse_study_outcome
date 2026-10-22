package com.obric.matrix.platform.sdk.ones.dataanalysis;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MatrixTeaConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0010B)\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "", "pkgName", "", "versionCode", "", "versionName", "isBoe", "", "(Ljava/lang/String;ILjava/lang/String;Z)V", "()Z", "getPkgName", "()Ljava/lang/String;", "getVersionCode", "()I", "getVersionName", "Builder", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixTeaConfig {
    private final boolean isBoe;
    private final String pkgName;
    private final int versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: MatrixTeaConfig.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig$Builder;", "", "()V", "isBoe", "", "pkgName", "", "versionCode", "", "versionName", "build", "Lcom/obric/matrix/platform/sdk/ones/dataanalysis/MatrixTeaConfig;", "setIsBoe", "setPackageName", "setVersionCode", "setVersionName", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private boolean isBoe;
        private String pkgName;
        private int versionCode;
        private String versionName;

        public Builder() {
            this.pkgName = "";
            this.versionName = "";
        }

        public final Builder setPackageName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pkgName");
            this.pkgName = r2;
            return this;
        }

        public final Builder setVersionCode(int r1) {
            this.versionCode = r1;
            return this;
        }

        public final Builder setVersionName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "versionName");
            this.versionName = r2;
            return this;
        }

        public final Builder setIsBoe(boolean r1) {
            this.isBoe = r1;
            return this;
        }

        public final MatrixTeaConfig build() {
            return new MatrixTeaConfig(this.pkgName, this.versionCode, this.versionName, this.isBoe, null);
        }
    }

    public /* synthetic */ MatrixTeaConfig(String r1, int r2, String r3, boolean r4, DefaultConstructorMarker r5) {
        this(r1, r2, r3, r4);
    }

    private MatrixTeaConfig(String r1, int r2, String r3, boolean r4) {
        this.pkgName = r1;
        this.versionCode = r2;
        this.versionName = r3;
        this.isBoe = r4;
    }

    /* synthetic */ MatrixTeaConfig(String r1, int r2, String r3, boolean r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final boolean isBoe() {
        return this.isBoe;
    }
}
