package androidx.camera.core.processing.util;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_GraphicDeviceInfo extends GraphicDeviceInfo {
    private final String eglExtensions;
    private final String eglVersion;
    private final String glExtensions;
    private final String glVersion;

    /* JADX INFO: renamed from: androidx.camera.core.processing.util.AutoValue_GraphicDeviceInfo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder extends GraphicDeviceInfo.Builder {
        private String eglExtensions;
        private String eglVersion;
        private String glExtensions;
        private String glVersion;

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo build() {
            if (this.glVersion != null) goto L5;
            String r100 = " glVersion";
        L7:
            if (this.eglVersion != null) goto L10;
            r100 = r100 + " eglVersion";
        L10:
            if (this.glExtensions != null) goto L13;
            r100 = r100 + " glExtensions";
        L13:
            if (this.eglExtensions != null) goto L16;
            r100 = r100 + " eglExtensions";
        L16:
            if (r100.isEmpty() == false) goto L20;
            return new AutoValue_GraphicDeviceInfo(this.glVersion, this.eglVersion, this.glExtensions, this.eglExtensions, null);
        L20:
            throw new IllegalStateException("Missing required properties:".concat(r100));
        L5:
            r100 = "";
            goto L7
        }

        public Builder() {
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setEglExtensions(String r100) {
            if (r100 == null) goto L6;
            this.eglExtensions = r100;
            return this;
        L6:
            throw new NullPointerException("Null eglExtensions");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setEglVersion(String r100) {
            if (r100 == null) goto L6;
            this.eglVersion = r100;
            return this;
        L6:
            throw new NullPointerException("Null eglVersion");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setGlExtensions(String r100) {
            if (r100 == null) goto L6;
            this.glExtensions = r100;
            return this;
        L6:
            throw new NullPointerException("Null glExtensions");
        }

        @Override // androidx.camera.core.processing.util.GraphicDeviceInfo.Builder
        public GraphicDeviceInfo.Builder setGlVersion(String r100) {
            if (r100 == null) goto L6;
            this.glVersion = r100;
            return this;
        L6:
            throw new NullPointerException("Null glVersion");
        }
    }

    public int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.glVersion + ", eglVersion=" + this.eglVersion + ", glExtensions=" + this.glExtensions + ", eglExtensions=" + this.eglExtensions + i.f25855d;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getEglExtensions() {
        return this.eglExtensions;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getEglVersion() {
        return this.eglVersion;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getGlExtensions() {
        return this.glExtensions;
    }

    @Override // androidx.camera.core.processing.util.GraphicDeviceInfo
    public String getGlVersion() {
        return this.glVersion;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof GraphicDeviceInfo) == false) goto L18;
        GraphicDeviceInfo r101 = (GraphicDeviceInfo) r100;
        if (this.glVersion.equals(r101.getGlVersion()) == true) goto L10;
    L16:
        return false;
    L10:
        if (this.eglVersion.equals(r101.getEglVersion()) == false) goto L16;
        if (this.glExtensions.equals(r101.getGlExtensions()) == false) goto L16;
        if (this.eglExtensions.equals(r101.getEglExtensions()) == false) goto L16;
        return true;
    L18:
        return false;
    }

    private AutoValue_GraphicDeviceInfo(String r100, String r101, String r102, String r103) {
        this.glVersion = r100;
        this.eglVersion = r101;
        this.glExtensions = r102;
        this.eglExtensions = r103;
    }

    public /* synthetic */ AutoValue_GraphicDeviceInfo(String r100, String r101, String r102, String r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
