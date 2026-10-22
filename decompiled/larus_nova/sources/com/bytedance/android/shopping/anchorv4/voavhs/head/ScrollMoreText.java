package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0014J\\\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\rHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "Ljava/io/Serializable;", "icon", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "schema", "", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "showEvent", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "entranceLocation", "findSameType", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getEntranceLocation", "()Ljava/lang/String;", "getFindSameType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getSchema", "getShowEvent", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/voavhs/head/ScrollMoreText;", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScrollMoreText implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION)
    private final String entranceLocation;

    @SerializedName("find_same_type")
    private final Integer findSameType;

    @SerializedName("icon")
    private final ImageModel icon;

    @SerializedName("jump_schema")
    private final String schema;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    public ScrollMoreText() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScrollMoreText copy$default(ScrollMoreText r100, ImageModel r101, String r102, Action r103, List r104, String r105, Integer r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.schema;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.action;
    L11:
        Action r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.showEvent;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.entranceLocation;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.findSameType;
    L20:
        ImageModel r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final ImageModel component1() {
        return this.icon;
    }

    public final String component2() {
        return this.schema;
    }

    public final Action component3() {
        return this.action;
    }

    public final List<ShowEvent> component4() {
        return this.showEvent;
    }

    public final String component5() {
        return this.entranceLocation;
    }

    public final Integer component6() {
        return this.findSameType;
    }

    public final ScrollMoreText copy(ImageModel r100, String r110, Action r111, List<ShowEvent> r112, String r113, Integer r114) {
        return new ScrollMoreText(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ScrollMoreText) == false) goto L18;
        ScrollMoreText r101 = (ScrollMoreText) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.entranceLocation, r101.entranceLocation) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.findSameType, r101.findSameType) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        ImageModel r100 = this.icon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.schema;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Action r107 = this.action;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ShowEvent> r110 = this.showEvent;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.entranceLocation;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.findSameType;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "ScrollMoreText(icon=" + this.icon + ", schema=" + this.schema + ", action=" + this.action + ", showEvent=" + this.showEvent + ", entranceLocation=" + this.entranceLocation + ", findSameType=" + this.findSameType + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final String getEntranceLocation() {
        return this.entranceLocation;
    }

    public final Integer getFindSameType() {
        return this.findSameType;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public ScrollMoreText(ImageModel r100, String r101, Action r102, List<ShowEvent> r103, String r104, Integer r105) {
        this.icon = r100;
        this.schema = r101;
        this.action = r102;
        this.showEvent = r103;
        this.entranceLocation = r104;
        this.findSameType = r105;
    }

    public /* synthetic */ ScrollMoreText(ImageModel r100, String r101, Action r102, List r103, String r110, Integer r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        ImageModel r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        Action r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        Integer r115 = null;
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
