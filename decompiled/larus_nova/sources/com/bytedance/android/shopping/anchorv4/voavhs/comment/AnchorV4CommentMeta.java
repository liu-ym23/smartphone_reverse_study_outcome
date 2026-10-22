package com.bytedance.android.shopping.anchorv4.voavhs.comment;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentMeta;", "Ljava/io/Serializable;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "component2", "trackMeta", "businessMeta", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "getTrackMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;", "<init>", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/d;Lcom/bytedance/android/shopping/anchorv4/voavhs/comment/AnchorV4CommentBusinessMeta;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CommentMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4CommentBusinessMeta businessMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final d trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4CommentMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4CommentMeta copy$default(AnchorV4CommentMeta r100, d r101, AnchorV4CommentBusinessMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trackMeta;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.businessMeta;
    L9:
        return r100.copy(r101, r102);
    }

    public final d component1() {
        return this.trackMeta;
    }

    public final AnchorV4CommentBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4CommentMeta copy(d r100, AnchorV4CommentBusinessMeta r101) {
        return new AnchorV4CommentMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4CommentMeta) == false) goto L10;
        AnchorV4CommentMeta r101 = (AnchorV4CommentMeta) r100;
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessMeta, r101.businessMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        d r100 = this.trackMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4CommentBusinessMeta r104 = this.businessMeta;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4CommentMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4CommentBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final d getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4CommentMeta(d r100, AnchorV4CommentBusinessMeta r101) {
        this.trackMeta = r100;
        this.businessMeta = r101;
    }

    public /* synthetic */ AnchorV4CommentMeta(d r100, AnchorV4CommentBusinessMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
