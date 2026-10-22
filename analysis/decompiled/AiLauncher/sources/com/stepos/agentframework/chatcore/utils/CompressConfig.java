package com.stepos.agentframework.chatcore.utils;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/chatcore/utils/a;", "", "", "enable", "", "imageWidth", "imageHeight", "imageQuality", "<init>", "(ZIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getEnable", "()Z", "I", "c", "setImageWidth", "(I)V", Const.INTENT_KEY_APIKEY, "setImageHeight", Const.INTENT_KEY_PKGNAME, "setImageQuality", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.utils.a, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CompressConfig {
    private final boolean enable;
    private int imageHeight;
    private int imageQuality;
    private int imageWidth;

    public CompressConfig() {
        this(false, 0, 0, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getImageHeight() {
        return this.imageHeight;
    }

    /* renamed from: b, reason: from getter */
    public final int getImageQuality() {
        return this.imageQuality;
    }

    /* renamed from: c, reason: from getter */
    public final int getImageWidth() {
        return this.imageWidth;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CompressConfig)) {
            return false;
        }
        CompressConfig compressConfig = (CompressConfig) other;
        return this.enable == compressConfig.enable && this.imageWidth == compressConfig.imageWidth && this.imageHeight == compressConfig.imageHeight && this.imageQuality == compressConfig.imageQuality;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.enable) * 31) + Integer.hashCode(this.imageWidth)) * 31) + Integer.hashCode(this.imageHeight)) * 31) + Integer.hashCode(this.imageQuality);
    }

    public String toString() {
        return "CompressConfig(enable=" + this.enable + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ", imageQuality=" + this.imageQuality + ")";
    }

    public CompressConfig(boolean z10, int i10, int i11, int i12) {
        this.enable = z10;
        this.imageWidth = i10;
        this.imageHeight = i11;
        this.imageQuality = i12;
    }

    public /* synthetic */ CompressConfig(boolean z10, int i10, int i11, int i12, int i13, kotlin.jvm.internal.i iVar) {
        this((i13 & 1) != 0 ? true : z10, (i13 & 2) != 0 ? -1 : i10, (i13 & 4) != 0 ? -1 : i11, (i13 & 8) != 0 ? 80 : i12);
    }
}
