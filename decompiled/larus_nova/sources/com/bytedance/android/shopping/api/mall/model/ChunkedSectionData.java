package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/ChunkedSectionData;", "", "chunkSectionId", "", "chunkInfo", "", "Lcom/bytedance/android/shopping/api/mall/model/ChunkedTrackAndRec;", "(Ljava/lang/String;Ljava/util/List;)V", "getChunkInfo", "()Ljava/util/List;", "getChunkSectionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChunkedSectionData {

    @SerializedName("section_infos")
    private final List<ChunkedTrackAndRec> chunkInfo;

    @SerializedName("section_id")
    private final String chunkSectionId;

    /* JADX WARN: Multi-variable type inference failed */
    public ChunkedSectionData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChunkedSectionData copy$default(ChunkedSectionData r100, String r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.chunkSectionId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.chunkInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.chunkSectionId;
    }

    public final List<ChunkedTrackAndRec> component2() {
        return this.chunkInfo;
    }

    public final ChunkedSectionData copy(String r100, List<ChunkedTrackAndRec> r101) {
        return new ChunkedSectionData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ChunkedSectionData) == false) goto L10;
        ChunkedSectionData r101 = (ChunkedSectionData) r100;
        if (Intrinsics.areEqual(this.chunkSectionId, r101.chunkSectionId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.chunkInfo, r101.chunkInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.chunkSectionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ChunkedTrackAndRec> r104 = this.chunkInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ChunkedSectionData(chunkSectionId=" + this.chunkSectionId + ", chunkInfo=" + this.chunkInfo + ")";
    }

    public final List<ChunkedTrackAndRec> getChunkInfo() {
        return this.chunkInfo;
    }

    public final String getChunkSectionId() {
        return this.chunkSectionId;
    }

    public ChunkedSectionData(String r100, List<ChunkedTrackAndRec> r101) {
        this.chunkSectionId = r100;
        this.chunkInfo = r101;
    }

    public /* synthetic */ ChunkedSectionData(String r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
