package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.Border;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.base.VideoModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a¢\u0006\u0002\u0010\u001bJ\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u00108\u001a\u00020\u0016HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0011\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001aHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010B\u001a\u00020\u0011HÆ\u0003J³\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001aHÆ\u0001J\u0013\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010G\u001a\u00020\u0016HÖ\u0001J\t\u0010H\u001a\u00020\u0018HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010#R\u0016\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104¨\u0006I"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/MediaBoxElement;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "link", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "radius", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "outBorder", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "selectInBorder", "defaultInBorder", "video", "Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "imageModel", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "usePlaceholder", "", DocCallbackImpl.KEY_THUMBNAIL, "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "type", "", "statusId", "", "states", "", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;ZLcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;ILjava/lang/String;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getDefaultInBorder", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Border;", "getImageModel", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getLink", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getOutBorder", "getRadius", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "getSelectInBorder", "getStates", "()Ljava/util/List;", "getStatusId", "()Ljava/lang/String;", "getThumbnail", "getType", "()I", "getUsePlaceholder", "()Z", "getVideo", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/VideoModel;", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaBoxElement implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("background")
    private final Background background;

    @SerializedName("default_in_border")
    private final Border defaultInBorder;

    @SerializedName("image")
    private final ImageModel imageModel;

    @SerializedName("link")
    private final Link link;

    @SerializedName("border")
    private final Border outBorder;

    @SerializedName("radius")
    private final Radius radius;

    @SerializedName("select_in_border")
    private final Border selectInBorder;

    @SerializedName("states")
    private final List<MediaBoxElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName(DocCallbackImpl.KEY_THUMBNAIL)
    private final ImageModel thumbnail;

    @SerializedName("type")
    private final int type;

    @SerializedName("use_placeholder")
    private final boolean usePlaceholder;

    @SerializedName("video")
    private final VideoModel video;

    public MediaBoxElement() {
        this(null, null, null, null, null, null, null, null, false, null, null, 0, null, null, 16383, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MediaBoxElement copy$default(MediaBoxElement r110, Action r111, Link r112, Radius r113, Border r114, Border r210, Border r211, VideoModel r212, ImageModel r213, boolean r214, ImageModel r215, Background r216, int r217, String r218, List r219, int r310, Object r311) {
        if ((r310 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Link r101 = r110.link;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Radius r102 = r110.radius;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Border r103 = r110.outBorder;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Border r104 = r110.selectInBorder;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Border r105 = r110.defaultInBorder;
    L27:
        if ((r310 & 64) == 0) goto L29;
        VideoModel r106 = r110.video;
    L31:
        if ((r310 & 128) == 0) goto L33;
        ImageModel r107 = r110.imageModel;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r115 = r110.usePlaceholder;
    L39:
        if ((r310 & 512) == 0) goto L41;
        ImageModel r116 = r110.thumbnail;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Background r117 = r110.background;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        int r118 = r110.type;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r119 = r110.statusId;
    L55:
        if ((r310 & 8192) == 0) goto L57;
        List r108 = r110.states;
    L59:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r115, r116, r117, r118, r119, r108);
    L57:
        r108 = r219;
        goto L59
    L53:
        r119 = r218;
        goto L55
    L49:
        r118 = r217;
        goto L51
    L45:
        r117 = r216;
        goto L47
    L41:
        r116 = r215;
        goto L43
    L37:
        r115 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
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

    public final ImageModel component10() {
        return this.thumbnail;
    }

    public final Background component11() {
        return this.background;
    }

    public final int component12() {
        return this.type;
    }

    public final String component13() {
        return this.statusId;
    }

    public final List<MediaBoxElement> component14() {
        return this.states;
    }

    public final Link component2() {
        return this.link;
    }

    public final Radius component3() {
        return this.radius;
    }

    public final Border component4() {
        return this.outBorder;
    }

    public final Border component5() {
        return this.selectInBorder;
    }

    public final Border component6() {
        return this.defaultInBorder;
    }

    public final VideoModel component7() {
        return this.video;
    }

    public final ImageModel component8() {
        return this.imageModel;
    }

    public final boolean component9() {
        return this.usePlaceholder;
    }

    public final MediaBoxElement copy(Action r110, Link r111, Radius r112, Border r210, Border r211, Border r212, VideoModel r213, ImageModel r214, boolean r215, ImageModel r216, Background r217, int r218, String r219, List<MediaBoxElement> r310) {
        return new MediaBoxElement(r110, r111, r112, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MediaBoxElement) == false) goto L34;
        MediaBoxElement r101 = (MediaBoxElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.radius, r101.radius) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.outBorder, r101.outBorder) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectInBorder, r101.selectInBorder) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.defaultInBorder, r101.defaultInBorder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.imageModel, r101.imageModel) == true) goto L22;
        return false;
    L22:
        if (this.usePlaceholder == r101.usePlaceholder) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.thumbnail, r101.thumbnail) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L28;
        return false;
    L28:
        if (this.type == r101.type) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v45 */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Link r104 = this.link;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Radius r107 = this.radius;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Border r110 = this.outBorder;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Border r113 = this.selectInBorder;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Border r116 = this.defaultInBorder;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        VideoModel r119 = this.video;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ImageModel r122 = this.imageModel;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        boolean r125 = this.usePlaceholder;
        ?? r126 = r125;
        if (r125 == false) goto L37;
        r126 = 1;
    L37:
        int r127 = (r124 + r126) * 31;
        ImageModel r128 = this.thumbnail;
        if (r128 == null) goto L40;
        int r129 = r128.hashCode();
    L41:
        int r130 = (r127 + r129) * 31;
        Background r131 = this.background;
        if (r131 == null) goto L44;
        int r132 = r131.hashCode();
    L45:
        int r133 = (((r130 + r132) * 31) + this.type) * 31;
        String r134 = this.statusId;
        if (r134 == null) goto L48;
        int r135 = r134.hashCode();
    L49:
        int r136 = (r133 + r135) * 31;
        List<MediaBoxElement> r137 = this.states;
        if (r137 == null) goto L53;
        r101 = r137.hashCode();
    L53:
        return r136 + r101;
    L48:
        r135 = 0;
        goto L49
    L44:
        r132 = 0;
        goto L45
    L40:
        r129 = 0;
        goto L41
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
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
        return "MediaBoxElement(action=" + this.action + ", link=" + this.link + ", radius=" + this.radius + ", outBorder=" + this.outBorder + ", selectInBorder=" + this.selectInBorder + ", defaultInBorder=" + this.defaultInBorder + ", video=" + this.video + ", imageModel=" + this.imageModel + ", usePlaceholder=" + this.usePlaceholder + ", thumbnail=" + this.thumbnail + ", background=" + this.background + ", type=" + this.type + ", statusId=" + this.statusId + ", states=" + this.states + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final Border getDefaultInBorder() {
        return this.defaultInBorder;
    }

    public final ImageModel getImageModel() {
        return this.imageModel;
    }

    public final Link getLink() {
        return this.link;
    }

    public final Border getOutBorder() {
        return this.outBorder;
    }

    public final Radius getRadius() {
        return this.radius;
    }

    public final Border getSelectInBorder() {
        return this.selectInBorder;
    }

    public final List<MediaBoxElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final ImageModel getThumbnail() {
        return this.thumbnail;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean getUsePlaceholder() {
        return this.usePlaceholder;
    }

    public final VideoModel getVideo() {
        return this.video;
    }

    public MediaBoxElement(Action r100, Link r101, Radius r102, Border r103, Border r104, Border r105, VideoModel r106, ImageModel r107, boolean r108, ImageModel r110, Background r111, int r112, String r113, List<MediaBoxElement> r114) {
        this.action = r100;
        this.link = r101;
        this.radius = r102;
        this.outBorder = r103;
        this.selectInBorder = r104;
        this.defaultInBorder = r105;
        this.video = r106;
        this.imageModel = r107;
        this.usePlaceholder = r108;
        this.thumbnail = r110;
        this.background = r111;
        this.type = r112;
        this.statusId = r113;
        this.states = r114;
    }

    public /* synthetic */ MediaBoxElement(Action r110, Link r111, Radius r112, Border r113, Border r210, Border r211, VideoModel r212, ImageModel r213, boolean r214, ImageModel r215, Background r216, int r217, String r218, List r219, int r310, DefaultConstructorMarker r311) {
        List r100 = null;
        if ((r310 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r310 & 2) == 0) goto L9;
        Link r102 = null;
    L11:
        if ((r310 & 4) == 0) goto L13;
        Radius r103 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        Border r104 = null;
    L19:
        if ((r310 & 16) == 0) goto L21;
        Border r105 = null;
    L23:
        if ((r310 & 32) == 0) goto L25;
        Border r106 = null;
    L27:
        if ((r310 & 64) == 0) goto L29;
        VideoModel r107 = null;
    L31:
        if ((r310 & 128) == 0) goto L33;
        ImageModel r108 = null;
    L35:
        if ((r310 & 256) == 0) goto L37;
        boolean r114 = true;
    L39:
        if ((r310 & 512) == 0) goto L41;
        ImageModel r115 = null;
    L43:
        if ((r310 & 1024) == 0) goto L45;
        Background r116 = null;
    L47:
        if ((r310 & 2048) == 0) goto L49;
        int r117 = 0;
    L51:
        if ((r310 & 4096) == 0) goto L53;
        String r118 = null;
    L55:
        if ((r310 & 8192) != 0) goto L58;
        r100 = r219;
    L58:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r100);
        return;
    L53:
        r118 = r218;
        goto L55
    L49:
        r117 = r217;
        goto L51
    L45:
        r116 = r216;
        goto L47
    L41:
        r115 = r215;
        goto L43
    L37:
        r114 = r214;
        goto L39
    L33:
        r108 = r213;
        goto L35
    L29:
        r107 = r212;
        goto L31
    L25:
        r106 = r211;
        goto L27
    L21:
        r105 = r210;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
