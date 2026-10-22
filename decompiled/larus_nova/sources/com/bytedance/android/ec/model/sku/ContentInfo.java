package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0019\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0018\b\u0002\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\nHÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/android/ec/model/sku/ContentInfo;", "Ljava/io/Serializable;", "imageObject", "Lcom/bytedance/android/ec/model/sku/ImageObject;", "textObject", "Lcom/bytedance/android/ec/model/sku/TextObject;", "blankObject", "Lcom/bytedance/android/ec/model/sku/BlankObject;", "showEventTrack", "", "", "(Lcom/bytedance/android/ec/model/sku/ImageObject;Lcom/bytedance/android/ec/model/sku/TextObject;Lcom/bytedance/android/ec/model/sku/BlankObject;Ljava/util/Map;)V", "getBlankObject", "()Lcom/bytedance/android/ec/model/sku/BlankObject;", "getImageObject", "()Lcom/bytedance/android/ec/model/sku/ImageObject;", "getShowEventTrack", "()Ljava/util/Map;", "getTextObject", "()Lcom/bytedance/android/ec/model/sku/TextObject;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ContentInfo implements Serializable {

    @SerializedName("blank_obj")
    private final BlankObject blankObject;

    @SerializedName("image_obj")
    private final ImageObject imageObject;

    @SerializedName("show_event_track")
    private final Map<String, String> showEventTrack;

    @SerializedName("text_obj")
    private final TextObject textObject;

    public ContentInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ContentInfo copy$default(ContentInfo r100, ImageObject r101, TextObject r102, BlankObject r103, Map r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.imageObject;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.textObject;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.blankObject;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.showEventTrack;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ImageObject component1() {
        return this.imageObject;
    }

    public final TextObject component2() {
        return this.textObject;
    }

    public final BlankObject component3() {
        return this.blankObject;
    }

    public final Map<String, String> component4() {
        return this.showEventTrack;
    }

    public final ContentInfo copy(ImageObject r100, TextObject r101, BlankObject r102, Map<String, String> r103) {
        return new ContentInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ContentInfo) == false) goto L14;
        ContentInfo r101 = (ContentInfo) r100;
        if (Intrinsics.areEqual(this.imageObject, r101.imageObject) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textObject, r101.textObject) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.blankObject, r101.blankObject) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showEventTrack, r101.showEventTrack) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        ImageObject r100 = this.imageObject;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextObject r104 = this.textObject;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        BlankObject r107 = this.blankObject;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.showEventTrack;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "ContentInfo(imageObject=" + this.imageObject + ", textObject=" + this.textObject + ", blankObject=" + this.blankObject + ", showEventTrack=" + this.showEventTrack + ")";
    }

    public final BlankObject getBlankObject() {
        return this.blankObject;
    }

    public final ImageObject getImageObject() {
        return this.imageObject;
    }

    public final Map<String, String> getShowEventTrack() {
        return this.showEventTrack;
    }

    public final TextObject getTextObject() {
        return this.textObject;
    }

    public ContentInfo(ImageObject r100, TextObject r101, BlankObject r102, Map<String, String> r103) {
        this.imageObject = r100;
        this.textObject = r101;
        this.blankObject = r102;
        this.showEventTrack = r103;
    }

    public /* synthetic */ ContentInfo(ImageObject r100, TextObject r101, BlankObject r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
