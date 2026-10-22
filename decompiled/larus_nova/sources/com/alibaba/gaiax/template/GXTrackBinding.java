package com.alibaba.gaiax.template;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/alibaba/gaiax/template/GXTrackBinding;", "", GXTemplateKey.GAIAX_TRACK, "Lcom/alibaba/gaiax/template/GXIExpression;", "(Lcom/alibaba/gaiax/template/GXIExpression;)V", "getTrack", "()Lcom/alibaba/gaiax/template/GXIExpression;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTrackBinding {
    private final GXIExpression track;

    public static /* synthetic */ GXTrackBinding copy$default(GXTrackBinding r100, GXIExpression r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.track;
    L6:
        return r100.copy(r101);
    }

    public final GXIExpression component1() {
        return this.track;
    }

    public final GXTrackBinding copy(GXIExpression r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        return new GXTrackBinding(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXTrackBinding) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.track, ((GXTrackBinding) r100).track) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.track.hashCode();
    }

    public String toString() {
        return "GXTrackBinding(track=" + this.track + ')';
    }

    public final GXIExpression getTrack() {
        return this.track;
    }

    public GXTrackBinding(GXIExpression r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
        this.track = r100;
    }
}
