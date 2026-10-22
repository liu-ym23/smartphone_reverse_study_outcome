package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.elements.MediaBoxElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0005HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0003J\u007f\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/MediaScrollBoxComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "medias", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "space", "", "scrollable", "", "edgePercent", "", "alignStrategy", "statusId", "", "states", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Ljava/util/List;IZFILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAlignStrategy", "()I", "getEdgePercent", "()F", "getMedias", "()Ljava/util/List;", "getScrollable", "()Z", "getShowEvent", "getSpace", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaScrollBoxComponent implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("align_strategy")
    private final int alignStrategy;

    @SerializedName("edge_percent")
    private final float edgePercent;

    @SerializedName("medias")
    private final List<MediaBoxElement> medias;

    @SerializedName("scrollable")
    private final boolean scrollable;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166521space;

    @SerializedName("states")
    private final List<MediaScrollBoxComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    public MediaScrollBoxComponent() {
        this(null, null, 0, false, 0.0f, 0, null, null, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaScrollBoxComponent copy$default(MediaScrollBoxComponent r110, Action r111, List r112, int r113, boolean r114, float r115, int r116, String r117, List r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r101 = r110.medias;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = r110.f166521space;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.scrollable;
    L19:
        if ((r210 & 16) == 0) goto L21;
        float r104 = r110.edgePercent;
    L23:
        if ((r210 & 32) == 0) goto L25;
        int r105 = r110.alignStrategy;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.statusId;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r107 = r110.states;
    L35:
        if ((r210 & 256) == 0) goto L37;
        List r108 = r110.showEvent;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Action component1() {
        return this.action;
    }

    public final List<MediaBoxElement> component2() {
        return this.medias;
    }

    public final int component3() {
        return this.f166521space;
    }

    public final boolean component4() {
        return this.scrollable;
    }

    public final float component5() {
        return this.edgePercent;
    }

    public final int component6() {
        return this.alignStrategy;
    }

    public final String component7() {
        return this.statusId;
    }

    public final List<MediaScrollBoxComponent> component8() {
        return this.states;
    }

    public final List<ShowEvent> component9() {
        return this.showEvent;
    }

    public final MediaScrollBoxComponent copy(Action r110, List<MediaBoxElement> r111, int r112, boolean r113, float r114, int r115, String r116, List<MediaScrollBoxComponent> r117, List<ShowEvent> r210) {
        return new MediaScrollBoxComponent(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MediaScrollBoxComponent) == false) goto L24;
        MediaScrollBoxComponent r101 = (MediaScrollBoxComponent) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.medias, r101.medias) == true) goto L10;
        return false;
    L10:
        if (this.f166521space == r101.f166521space) goto L12;
        return false;
    L12:
        if (this.scrollable == r101.scrollable) goto L14;
        return false;
    L14:
        if (Float.compare(this.edgePercent, r101.edgePercent) == 0) goto L16;
        return false;
    L16:
        if (this.alignStrategy == r101.alignStrategy) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<MediaBoxElement> r104 = this.medias;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f166521space) * 31;
        boolean r107 = this.scrollable;
        ?? r108 = r107;
        if (r107 == false) goto L13;
        r108 = 1;
    L13:
        int r109 = (((((r106 + r108) * 31) + Float.floatToIntBits(this.edgePercent)) * 31) + this.alignStrategy) * 31;
        String r110 = this.statusId;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        List<MediaScrollBoxComponent> r113 = this.states;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        List<ShowEvent> r116 = this.showEvent;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MediaScrollBoxComponent(action=" + this.action + ", medias=" + this.medias + ", space=" + this.f166521space + ", scrollable=" + this.scrollable + ", edgePercent=" + this.edgePercent + ", alignStrategy=" + this.alignStrategy + ", statusId=" + this.statusId + ", states=" + this.states + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final float getEdgePercent() {
        return this.edgePercent;
    }

    public final List<MediaBoxElement> getMedias() {
        return this.medias;
    }

    public final boolean getScrollable() {
        return this.scrollable;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final int getSpace() {
        return this.f166521space;
    }

    public final List<MediaScrollBoxComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public MediaScrollBoxComponent(Action r100, List<MediaBoxElement> r101, int r102, boolean r103, float r104, int r105, String r106, List<MediaScrollBoxComponent> r107, List<ShowEvent> r108) {
        this.action = r100;
        this.medias = r101;
        this.f166521space = r102;
        this.scrollable = r103;
        this.edgePercent = r104;
        this.alignStrategy = r105;
        this.statusId = r106;
        this.states = r107;
        this.showEvent = r108;
    }

    public /* synthetic */ MediaScrollBoxComponent(Action r110, List r111, int r112, boolean r113, float r114, int r115, String r116, List r117, List r118, int r210, DefaultConstructorMarker r211) {
        List r100 = null;
        if ((r210 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r210 & 2) == 0) goto L9;
        List r102 = null;
    L10:
        int r103 = 0;
        if ((r210 & 4) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r105 = false;
    L19:
        if ((r210 & 16) == 0) goto L21;
        float r106 = 0.25f;
    L23:
        if ((r210 & 32) != 0) goto L27;
        r103 = r115;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r210 & 128) == 0) goto L33;
        List r108 = null;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r102, r104, r105, r106, r103, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
