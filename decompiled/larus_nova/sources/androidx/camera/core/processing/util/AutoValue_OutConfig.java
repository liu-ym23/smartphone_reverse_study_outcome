package androidx.camera.core.processing.util;

import android.graphics.Rect;
import android.util.Size;
import com.alipay.sdk.m.u.i;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_OutConfig extends OutConfig {
    private final Rect getCropRect;
    private final int getFormat;
    private final int getRotationDegrees;
    private final Size getSize;
    private final int getTargets;
    private final UUID getUuid;
    private final boolean isMirroring;
    private final boolean shouldRespectInputCropRect;

    public int hashCode() {
        int r100 = (((((((((((this.getUuid.hashCode() ^ 1000003) * 1000003) ^ this.getTargets) * 1000003) ^ this.getFormat) * 1000003) ^ this.getCropRect.hashCode()) * 1000003) ^ this.getSize.hashCode()) * 1000003) ^ this.getRotationDegrees) * 1000003;
        int r101 = 1231;
        if (this.isMirroring == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 ^ r102) * 1000003;
        if (this.shouldRespectInputCropRect == true) goto L11;
        r101 = 1237;
    L11:
        return r103 ^ r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "OutConfig{getUuid=" + this.getUuid + ", getTargets=" + this.getTargets + ", getFormat=" + this.getFormat + ", getCropRect=" + this.getCropRect + ", getSize=" + this.getSize + ", getRotationDegrees=" + this.getRotationDegrees + ", isMirroring=" + this.isMirroring + ", shouldRespectInputCropRect=" + this.shouldRespectInputCropRect + i.f25855d;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public Rect getCropRect() {
        return this.getCropRect;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getFormat() {
        return this.getFormat;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public Size getSize() {
        return this.getSize;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public int getTargets() {
        return this.getTargets;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public UUID getUuid() {
        return this.getUuid;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public boolean isMirroring() {
        return this.isMirroring;
    }

    @Override // androidx.camera.core.processing.util.OutConfig
    public boolean shouldRespectInputCropRect() {
        return this.shouldRespectInputCropRect;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof OutConfig) == false) goto L26;
        OutConfig r101 = (OutConfig) r100;
        if (this.getUuid.equals(r101.getUuid()) == true) goto L10;
    L24:
        return false;
    L10:
        if (this.getTargets != r101.getTargets()) goto L24;
        if (this.getFormat != r101.getFormat()) goto L24;
        if (this.getCropRect.equals(r101.getCropRect()) == false) goto L24;
        if (this.getSize.equals(r101.getSize()) == false) goto L24;
        if (this.getRotationDegrees != r101.getRotationDegrees()) goto L24;
        if (this.isMirroring != r101.isMirroring()) goto L24;
        if (this.shouldRespectInputCropRect != r101.shouldRespectInputCropRect()) goto L24;
        return true;
    L26:
        return false;
    }

    public AutoValue_OutConfig(UUID r100, int r101, int r102, Rect r103, Size r104, int r105, boolean r106, boolean r107) {
        if (r100 == null) goto L15;
        this.getUuid = r100;
        this.getTargets = r101;
        this.getFormat = r102;
        if (r103 == null) goto L13;
        this.getCropRect = r103;
        if (r104 == null) goto L11;
        this.getSize = r104;
        this.getRotationDegrees = r105;
        this.isMirroring = r106;
        this.shouldRespectInputCropRect = r107;
        return;
    L11:
        throw new NullPointerException("Null getSize");
    L13:
        throw new NullPointerException("Null getCropRect");
    L15:
        throw new NullPointerException("Null getUuid");
    }
}
