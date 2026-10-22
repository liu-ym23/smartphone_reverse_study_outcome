package com.bytedance.android.shopping.anchorv4.dto.base;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "Ljava/io/Serializable;", "id", "", "meta", "trackMeta", "refId", "checkParams", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCheckParams", "()Ljava/lang/String;", "getId", "getMeta", "getRefId", "getTrackMeta", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Action implements Serializable {

    @SerializedName("check_params")
    private final String checkParams;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f166510id;

    @SerializedName("meta")
    private final String meta;

    @SerializedName("ref_id")
    private final String refId;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final String trackMeta;

    public Action() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ Action copy$default(Action r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.f166510id;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.meta;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.trackMeta;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.refId;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.checkParams;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.f166510id;
    }

    public final String component2() {
        return this.meta;
    }

    public final String component3() {
        return this.trackMeta;
    }

    public final String component4() {
        return this.refId;
    }

    public final String component5() {
        return this.checkParams;
    }

    public final Action copy(String r100, String r101, String r110, String r111, String r112) {
        return new Action(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Action) == false) goto L16;
        Action r101 = (Action) r100;
        if (Intrinsics.areEqual(this.f166510id, r101.f166510id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.meta, r101.meta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.refId, r101.refId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.checkParams, r101.checkParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.f166510id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.meta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.trackMeta;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.refId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.checkParams;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Action(id=" + this.f166510id + ", meta=" + this.meta + ", trackMeta=" + this.trackMeta + ", refId=" + this.refId + ", checkParams=" + this.checkParams + ")";
    }

    public final String getCheckParams() {
        return this.checkParams;
    }

    public final String getId() {
        return this.f166510id;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final String getRefId() {
        return this.refId;
    }

    public final String getTrackMeta() {
        return this.trackMeta;
    }

    public Action(String r100, String r101, String r102, String r103, String r104) {
        this.f166510id = r100;
        this.meta = r101;
        this.trackMeta = r102;
        this.refId = r103;
        this.checkParams = r104;
    }

    public /* synthetic */ Action(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
