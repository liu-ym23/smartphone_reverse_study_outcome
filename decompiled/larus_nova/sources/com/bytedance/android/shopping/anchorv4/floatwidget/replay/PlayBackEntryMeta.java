package com.bytedance.android.shopping.anchorv4.floatwidget.replay;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR*\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\u0004\u0018\u0001`\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackEntryMeta;", "Ljava/io/Serializable;", "trackMeta", "", "", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackTrackExtra;", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackBusinessExtra;", "(Ljava/util/Map;Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackBusinessExtra;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackBusinessExtra;", "getTrackMeta", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayBackEntryMeta implements Serializable {

    @SerializedName("business_meta")
    private final PlayBackBusinessExtra businessMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final Map<String, String> trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayBackEntryMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayBackEntryMeta copy$default(PlayBackEntryMeta r100, Map r101, PlayBackBusinessExtra r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trackMeta;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.businessMeta;
    L9:
        return r100.copy(r101, r102);
    }

    public final Map<String, String> component1() {
        return this.trackMeta;
    }

    public final PlayBackBusinessExtra component2() {
        return this.businessMeta;
    }

    public final PlayBackEntryMeta copy(Map<String, String> r100, PlayBackBusinessExtra r101) {
        return new PlayBackEntryMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayBackEntryMeta) == false) goto L10;
        PlayBackEntryMeta r101 = (PlayBackEntryMeta) r100;
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
        Map<String, String> r100 = this.trackMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PlayBackBusinessExtra r104 = this.businessMeta;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayBackEntryMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final PlayBackBusinessExtra getBusinessMeta() {
        return this.businessMeta;
    }

    public final Map<String, String> getTrackMeta() {
        return this.trackMeta;
    }

    public PlayBackEntryMeta(Map<String, String> r100, PlayBackBusinessExtra r101) {
        this.trackMeta = r100;
        this.businessMeta = r101;
    }

    public /* synthetic */ PlayBackEntryMeta(Map r100, PlayBackBusinessExtra r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
