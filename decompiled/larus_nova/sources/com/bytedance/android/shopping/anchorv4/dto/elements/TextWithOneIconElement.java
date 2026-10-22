package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bJ\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u0011\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000bHÆ\u0003J\t\u0010J\u001a\u00020\rHÆ\u0003J\t\u0010K\u001a\u00020\rHÆ\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010M\u001a\u0004\u0018\u00010\u0012HÆ\u0003JÒ\u0001\u0010N\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010OJ\u0013\u0010P\u001a\u00020\u00102\b\u0010Q\u001a\u0004\u0018\u00010RHÖ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\t\u0010T\u001a\u00020\rHÖ\u0001J\t\u0010U\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R&\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0016\u0010\u0019\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0016\u0010\u0013\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010!R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010,\"\u0004\b;\u0010.R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*¨\u0006V"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "icon", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "contentV2", "", "buttonType", "", "alignStrategy", "halfAlphaAction", "", "link", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "space", "statusId", "", "states", "tag", "contentDescription", "showFirstScreen", "elementId", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;IILjava/lang/Boolean;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "setAction", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;)V", "getAlignStrategy", "()I", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getButtonType", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "setContent", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;)V", "getContentDescription", "()Ljava/lang/String;", "getContentV2", "()Ljava/util/List;", "setContentV2", "(Ljava/util/List;)V", "getElementId", "getHalfAlphaAction", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getLink", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getShowFirstScreen", "()Z", "getSpace", "getStates", "setStates", "getStatusId", "getTag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;IILjava/lang/Boolean;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "equals", "other", "", "findStatus", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextWithOneIconElement implements Serializable {

    @SerializedName("action")
    private Action action;

    @SerializedName("align_strategy")
    private final int alignStrategy;

    @SerializedName("background")
    private final Background background;

    @SerializedName(a.KEY_BUTTON_TYPE)
    private final int buttonType;

    @SerializedName("content")
    private TextElement content;

    @SerializedName("content_description")
    private final String contentDescription;

    @SerializedName("content_v2")
    private List<TextElement> contentV2;

    @SerializedName("element_id")
    private final String elementId;

    @SerializedName("half_alpha_action")
    private final Boolean halfAlphaAction;

    @SerializedName("icon")
    private final ImageModel icon;

    @SerializedName("link")
    private final Link link;

    @SerializedName("show_first_screen")
    private final boolean showFirstScreen;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166528space;

    @SerializedName("states")
    private List<TextWithOneIconElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("tag")
    private final String tag;

    public TextWithOneIconElement() {
        this(null, null, null, null, null, 0, 0, null, null, 0, null, null, null, null, false, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextWithOneIconElement copy$default(TextWithOneIconElement r110, Action r111, Background r112, ImageModel r210, TextElement r211, List r212, int r213, int r214, Boolean r215, Link r216, int r217, String r218, List r219, String r310, String r311, boolean r312, String r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Background r101 = r110.background;
    L11:
        if ((r314 & 4) == 0) goto L13;
        ImageModel r102 = r110.icon;
    L15:
        if ((r314 & 8) == 0) goto L17;
        TextElement r103 = r110.content;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = r110.contentV2;
    L23:
        if ((r314 & 32) == 0) goto L25;
        int r105 = r110.buttonType;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r106 = r110.alignStrategy;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r107 = r110.halfAlphaAction;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Link r113 = r110.link;
    L39:
        if ((r314 & 512) == 0) goto L41;
        int r114 = r110.f166528space;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.statusId;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        List r116 = r110.states;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r117 = r110.tag;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r118 = r110.contentDescription;
    L58:
        String r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        boolean r119 = r110.showFirstScreen;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r108 = r110.elementId;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
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

    public final int component10() {
        return this.f166528space;
    }

    public final String component11() {
        return this.statusId;
    }

    public final List<TextWithOneIconElement> component12() {
        return this.states;
    }

    public final String component13() {
        return this.tag;
    }

    public final String component14() {
        return this.contentDescription;
    }

    public final boolean component15() {
        return this.showFirstScreen;
    }

    public final String component16() {
        return this.elementId;
    }

    public final Background component2() {
        return this.background;
    }

    public final ImageModel component3() {
        return this.icon;
    }

    public final TextElement component4() {
        return this.content;
    }

    public final List<TextElement> component5() {
        return this.contentV2;
    }

    public final int component6() {
        return this.buttonType;
    }

    public final int component7() {
        return this.alignStrategy;
    }

    public final Boolean component8() {
        return this.halfAlphaAction;
    }

    public final Link component9() {
        return this.link;
    }

    public final TextWithOneIconElement copy(Action r110, Background r210, ImageModel r211, TextElement r212, List<TextElement> r213, int r214, int r215, Boolean r216, Link r217, int r218, String r219, List<TextWithOneIconElement> r310, String r311, String r312, boolean r313, String r314) {
        return new TextWithOneIconElement(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextWithOneIconElement) == false) goto L38;
        TextWithOneIconElement r101 = (TextWithOneIconElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.contentV2, r101.contentV2) == true) goto L16;
        return false;
    L16:
        if (this.buttonType == r101.buttonType) goto L18;
        return false;
    L18:
        if (this.alignStrategy == r101.alignStrategy) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.halfAlphaAction, r101.halfAlphaAction) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L24;
        return false;
    L24:
        if (this.f166528space == r101.f166528space) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.contentDescription, r101.contentDescription) == true) goto L34;
        return false;
    L34:
        if (this.showFirstScreen == r101.showFirstScreen) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.elementId, r101.elementId) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v34, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v47 */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Background r104 = this.background;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ImageModel r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextElement r110 = this.content;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<TextElement> r113 = this.contentV2;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((((r112 + r114) * 31) + this.buttonType) * 31) + this.alignStrategy) * 31;
        Boolean r116 = this.halfAlphaAction;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Link r119 = this.link;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((r118 + r120) * 31) + this.f166528space) * 31;
        String r122 = this.statusId;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<TextWithOneIconElement> r125 = this.states;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.tag;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.contentDescription;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        boolean r134 = this.showFirstScreen;
        ?? r135 = r134;
        if (r134 == false) goto L49;
        r135 = 1;
    L49:
        int r136 = (r133 + r135) * 31;
        String r137 = this.elementId;
        if (r137 == null) goto L53;
        r101 = r137.hashCode();
    L53:
        return r136 + r101;
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
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
        return "TextWithOneIconElement(action=" + this.action + ", background=" + this.background + ", icon=" + this.icon + ", content=" + this.content + ", contentV2=" + this.contentV2 + ", buttonType=" + this.buttonType + ", alignStrategy=" + this.alignStrategy + ", halfAlphaAction=" + this.halfAlphaAction + ", link=" + this.link + ", space=" + this.f166528space + ", statusId=" + this.statusId + ", states=" + this.states + ", tag=" + this.tag + ", contentDescription=" + this.contentDescription + ", showFirstScreen=" + this.showFirstScreen + ", elementId=" + this.elementId + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final int getButtonType() {
        return this.buttonType;
    }

    public final TextElement getContent() {
        return this.content;
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final List<TextElement> getContentV2() {
        return this.contentV2;
    }

    public final String getElementId() {
        return this.elementId;
    }

    public final Boolean getHalfAlphaAction() {
        return this.halfAlphaAction;
    }

    public final ImageModel getIcon() {
        return this.icon;
    }

    public final Link getLink() {
        return this.link;
    }

    public final boolean getShowFirstScreen() {
        return this.showFirstScreen;
    }

    public final int getSpace() {
        return this.f166528space;
    }

    public final List<TextWithOneIconElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final TextWithOneIconElement findStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusId");
        if (Intrinsics.areEqual(this.statusId, r100) == false) goto L5;
        return this;
    L5:
        List<TextWithOneIconElement> r101 = this.states;
        if (r101 == null) goto L35;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((TextWithOneIconElement) r103).statusId, r100) == false) goto L9;
    L14:
        TextWithOneIconElement r104 = (TextWithOneIconElement) r103;
        if (r104 == null) goto L36;
        ArrayList r105 = new ArrayList();
        List<TextWithOneIconElement> r106 = this.states;
        if (r106 == null) goto L25;
        ArrayList r107 = new ArrayList();
        Iterator<T> r108 = r106.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((TextWithOneIconElement) r109).statusId, r100) == true) goto L20;
        r107.add(r109);
        goto L20
    L24:
        r105.addAll(r107);
    L25:
        r105.add(this);
        r104.states = r105;
        return r104;
    L36:
        return null;
    L13:
        r103 = null;
        goto L14
    L35:
        return null;
    }

    public final void setAction(Action r100) {
        this.action = r100;
    }

    public final void setContent(TextElement r100) {
        this.content = r100;
    }

    public final void setContentV2(List<TextElement> r100) {
        this.contentV2 = r100;
    }

    public final void setStates(List<TextWithOneIconElement> r100) {
        this.states = r100;
    }

    public TextWithOneIconElement(Action r100, Background r101, ImageModel r102, TextElement r103, List<TextElement> r104, int r105, int r106, Boolean r110, Link r111, int r112, String r113, List<TextWithOneIconElement> r114, String r115, String r116, boolean r117, String r118) {
        this.action = r100;
        this.background = r101;
        this.icon = r102;
        this.content = r103;
        this.contentV2 = r104;
        this.buttonType = r105;
        this.alignStrategy = r106;
        this.halfAlphaAction = r110;
        this.link = r111;
        this.f166528space = r112;
        this.statusId = r113;
        this.states = r114;
        this.tag = r115;
        this.contentDescription = r116;
        this.showFirstScreen = r117;
        this.elementId = r118;
    }

    public /* synthetic */ TextWithOneIconElement(Action r110, Background r111, ImageModel r210, TextElement r211, List r212, int r213, int r214, Boolean r215, Link r216, int r217, String r218, List r219, String r310, String r311, boolean r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        Action r100 = null;
    L7:
        if ((r314 & 2) == 0) goto L9;
        Background r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        ImageModel r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        TextElement r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        List r104 = null;
    L22:
        int r105 = 0;
        if ((r314 & 32) == 0) goto L25;
        int r106 = 0;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r107 = 1;
    L31:
        if ((r314 & 128) == 0) goto L33;
        Boolean r112 = null;
    L35:
        if ((r314 & 256) == 0) goto L37;
        Link r113 = null;
    L39:
        if ((r314 & 512) != 0) goto L43;
        r105 = r217;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r114 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        List r115 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        String r116 = null;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        boolean r117 = true;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        String r109 = null;
    L66:
        this(r100, r101, r102, r103, r104, r106, r107, r112, r113, r105, r114, r115, r116, r108, r117, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r117 = r312;
        goto L63
    L57:
        r108 = r311;
        goto L59
    L53:
        r116 = r310;
        goto L55
    L49:
        r115 = r219;
        goto L51
    L45:
        r114 = r218;
        goto L47
    L37:
        r113 = r216;
        goto L39
    L33:
        r112 = r215;
        goto L35
    L29:
        r107 = r214;
        goto L31
    L25:
        r106 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L22
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
