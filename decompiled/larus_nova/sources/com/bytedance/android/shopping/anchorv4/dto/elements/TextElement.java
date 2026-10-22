package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.FontStyle;
import com.bytedance.android.shopping.anchorv4.dto.base.Highlight;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007¢\u0006\u0002\u0010\u0013J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0011HÆ\u0003J\u0089\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0007HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0011HÖ\u0001J\t\u00108\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010 \"\u0004\b#\u0010$R\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0012\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 ¨\u00069"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "fontStyle", "Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "text", "", "link", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "highlights", "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Highlight;", "statusId", "states", "tag", "textGravity", "", "truncate", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;Ljava/lang/String;Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getFontStyle", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;", "setFontStyle", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/FontStyle;)V", "getHighlights", "()Ljava/util/List;", "getLink", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Link;", "getStates", "getStatusId", "()Ljava/lang/String;", "getTag", "getText", "setText", "(Ljava/lang/String;)V", "getTextGravity", "()I", "getTruncate", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextElement implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("font_style")
    private FontStyle fontStyle;

    @SerializedName("highlights")
    private final List<Highlight> highlights;

    @SerializedName("link")
    private final Link link;

    @SerializedName("states")
    private final List<TextElement> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("tag")
    private final String tag;

    @SerializedName("text")
    private String text;

    @SerializedName("text_gravity")
    private final int textGravity;

    @SerializedName("truncate")
    private final String truncate;

    public TextElement() {
        this(null, null, null, null, null, null, null, null, 0, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextElement copy$default(TextElement r110, Action r111, FontStyle r112, String r113, Link r114, List r115, String r116, List r117, String r118, int r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r212 & 2) == 0) goto L9;
        FontStyle r101 = r110.fontStyle;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.text;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Link r103 = r110.link;
    L19:
        if ((r212 & 16) == 0) goto L21;
        List r104 = r110.highlights;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.statusId;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r106 = r110.states;
    L31:
        if ((r212 & 128) == 0) goto L33;
        String r107 = r110.tag;
    L35:
        if ((r212 & 256) == 0) goto L37;
        int r119 = r110.textGravity;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.truncate;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
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

    public final String component10() {
        return this.truncate;
    }

    public final FontStyle component2() {
        return this.fontStyle;
    }

    public final String component3() {
        return this.text;
    }

    public final Link component4() {
        return this.link;
    }

    public final List<Highlight> component5() {
        return this.highlights;
    }

    public final String component6() {
        return this.statusId;
    }

    public final List<TextElement> component7() {
        return this.states;
    }

    public final String component8() {
        return this.tag;
    }

    public final int component9() {
        return this.textGravity;
    }

    public final TextElement copy(Action r110, FontStyle r111, String r112, Link r113, List<Highlight> r114, String r115, List<TextElement> r116, String r210, int r211, String r212) {
        Intrinsics.checkNotNullParameter(r212, "truncate");
        return new TextElement(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof TextElement) == false) goto L26;
        TextElement r101 = (TextElement) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.fontStyle, r101.fontStyle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.link, r101.link) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.highlights, r101.highlights) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L22;
        return false;
    L22:
        if (this.textGravity == r101.textGravity) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.truncate, r101.truncate) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FontStyle r104 = this.fontStyle;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Link r110 = this.link;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Highlight> r113 = this.highlights;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.statusId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<TextElement> r119 = this.states;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.tag;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (((r121 + r123) * 31) + this.textGravity) * 31;
        String r125 = this.truncate;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "TextElement(action=" + this.action + ", fontStyle=" + this.fontStyle + ", text=" + this.text + ", link=" + this.link + ", highlights=" + this.highlights + ", statusId=" + this.statusId + ", states=" + this.states + ", tag=" + this.tag + ", textGravity=" + this.textGravity + ", truncate=" + this.truncate + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    public final List<Highlight> getHighlights() {
        return this.highlights;
    }

    public final Link getLink() {
        return this.link;
    }

    public final List<TextElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextGravity() {
        return this.textGravity;
    }

    public final String getTruncate() {
        return this.truncate;
    }

    public final void setFontStyle(FontStyle r100) {
        this.fontStyle = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }

    public TextElement(Action r100, FontStyle r101, String r102, Link r103, List<Highlight> r104, String r105, List<TextElement> r106, String r107, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "truncate");
        this.action = r100;
        this.fontStyle = r101;
        this.text = r102;
        this.link = r103;
        this.highlights = r104;
        this.statusId = r105;
        this.states = r106;
        this.tag = r107;
        this.textGravity = r110;
        this.truncate = r111;
    }

    public /* synthetic */ TextElement(Action r110, FontStyle r111, String r112, Link r113, List r114, String r115, List r116, String r117, int r118, String r210, int r211, DefaultConstructorMarker r212) {
        String r100 = null;
        if ((r211 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        FontStyle r102 = null;
    L11:
        if ((r211 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Link r104 = null;
    L19:
        if ((r211 & 16) == 0) goto L21;
        List r105 = null;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r211 & 64) == 0) goto L29;
        List r107 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) == 0) goto L37;
        int r108 = 0;
    L39:
        if ((r211 & 512) == 0) goto L41;
        String r109 = "end";
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r100, r108, r109);
        return;
    L41:
        r109 = r210;
        goto L42
    L37:
        r108 = r118;
        goto L39
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
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
