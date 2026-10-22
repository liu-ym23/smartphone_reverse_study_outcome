package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "Ljava/io/Serializable;", "kolAllVideoCnt", "", "contentSource", "", "(ILjava/lang/String;)V", "getContentSource", "()Ljava/lang/String;", "getKolAllVideoCnt", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationTrackMeta implements Serializable {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE)
    private final String contentSource;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_KOL_VIDEO_CNT)
    private final int kolAllVideoCnt;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4KolEvaluationTrackMeta() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4KolEvaluationTrackMeta copy$default(AnchorV4KolEvaluationTrackMeta r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.kolAllVideoCnt;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.contentSource;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.kolAllVideoCnt;
    }

    public final String component2() {
        return this.contentSource;
    }

    public final AnchorV4KolEvaluationTrackMeta copy(int r100, String r101) {
        return new AnchorV4KolEvaluationTrackMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4KolEvaluationTrackMeta) == false) goto L10;
        AnchorV4KolEvaluationTrackMeta r101 = (AnchorV4KolEvaluationTrackMeta) r100;
        if (this.kolAllVideoCnt == r101.kolAllVideoCnt) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.contentSource, r101.contentSource) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.kolAllVideoCnt * 31;
        String r101 = this.contentSource;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "AnchorV4KolEvaluationTrackMeta(kolAllVideoCnt=" + this.kolAllVideoCnt + ", contentSource=" + this.contentSource + ")";
    }

    public final String getContentSource() {
        return this.contentSource;
    }

    public final int getKolAllVideoCnt() {
        return this.kolAllVideoCnt;
    }

    public AnchorV4KolEvaluationTrackMeta(int r100, String r101) {
        this.kolAllVideoCnt = r100;
        this.contentSource = r101;
    }

    public /* synthetic */ AnchorV4KolEvaluationTrackMeta(int r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
