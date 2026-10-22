package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.bytedance.android.shopping.anchorv4.dto.elements.IconsWithSpaceElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e¢\u0006\u0002\u0010\u0013J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000eHÆ\u0003J\t\u0010-\u001a\u00020\u0010HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eHÆ\u0003J}\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eHÆ\u0001J\u0013\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001b¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "headIcons", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "tailIcons", "alignStrategy", "", "statusId", "", "states", "", BrowserDependency.UrlClickType.INLINE, "", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;ILjava/lang/String;Ljava/util/List;ZLjava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getAlignStrategy", "()I", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getHeadIcons", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "getInline", "()Z", "setInline", "(Z)V", "getShowEvent", "()Ljava/util/List;", "getStates", "getStatusId", "()Ljava/lang/String;", "getTailIcons", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LongTitleComponent implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("align_strategy")
    private final int alignStrategy;

    @SerializedName("content")
    private final TextElement content;

    @SerializedName("head_icons")
    private final IconsWithSpaceElement headIcons;

    @SerializedName(BrowserDependency.UrlClickType.INLINE)
    private boolean inline;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    @SerializedName("states")
    private final List<LongTitleComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    @SerializedName("tail_icons")
    private final IconsWithSpaceElement tailIcons;

    public LongTitleComponent() {
        this(null, null, null, null, 0, null, null, false, null, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LongTitleComponent copy$default(LongTitleComponent r110, Action r111, IconsWithSpaceElement r112, TextElement r113, IconsWithSpaceElement r114, int r115, String r116, List r117, boolean r118, List r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Action r100 = r110.action;
    L7:
        if ((r210 & 2) == 0) goto L9;
        IconsWithSpaceElement r101 = r110.headIcons;
    L11:
        if ((r210 & 4) == 0) goto L13;
        TextElement r102 = r110.content;
    L15:
        if ((r210 & 8) == 0) goto L17;
        IconsWithSpaceElement r103 = r110.tailIcons;
    L19:
        if ((r210 & 16) == 0) goto L21;
        int r104 = r110.alignStrategy;
    L23:
        if ((r210 & 32) == 0) goto L25;
        String r105 = r110.statusId;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.states;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.inline;
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

    public final IconsWithSpaceElement component2() {
        return this.headIcons;
    }

    public final TextElement component3() {
        return this.content;
    }

    public final IconsWithSpaceElement component4() {
        return this.tailIcons;
    }

    public final int component5() {
        return this.alignStrategy;
    }

    public final String component6() {
        return this.statusId;
    }

    public final List<LongTitleComponent> component7() {
        return this.states;
    }

    public final boolean component8() {
        return this.inline;
    }

    public final List<ShowEvent> component9() {
        return this.showEvent;
    }

    public final LongTitleComponent copy(Action r110, IconsWithSpaceElement r111, TextElement r112, IconsWithSpaceElement r113, int r114, String r115, List<LongTitleComponent> r116, boolean r117, List<ShowEvent> r210) {
        return new LongTitleComponent(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LongTitleComponent) == false) goto L24;
        LongTitleComponent r101 = (LongTitleComponent) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headIcons, r101.headIcons) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tailIcons, r101.tailIcons) == true) goto L14;
        return false;
    L14:
        if (this.alignStrategy == r101.alignStrategy) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L20;
        return false;
    L20:
        if (this.inline == r101.inline) goto L22;
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
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v25 */
    public int hashCode() {
        Action r100 = this.action;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        IconsWithSpaceElement r104 = this.headIcons;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextElement r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IconsWithSpaceElement r110 = this.tailIcons;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.alignStrategy) * 31;
        String r113 = this.statusId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<LongTitleComponent> r116 = this.states;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.inline;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        List<ShowEvent> r122 = this.showEvent;
        if (r122 == null) goto L33;
        r101 = r122.hashCode();
    L33:
        return r121 + r101;
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
        return "LongTitleComponent(action=" + this.action + ", headIcons=" + this.headIcons + ", content=" + this.content + ", tailIcons=" + this.tailIcons + ", alignStrategy=" + this.alignStrategy + ", statusId=" + this.statusId + ", states=" + this.states + ", inline=" + this.inline + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final int getAlignStrategy() {
        return this.alignStrategy;
    }

    public final TextElement getContent() {
        return this.content;
    }

    public final IconsWithSpaceElement getHeadIcons() {
        return this.headIcons;
    }

    public final boolean getInline() {
        return this.inline;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final List<LongTitleComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final IconsWithSpaceElement getTailIcons() {
        return this.tailIcons;
    }

    public final void setInline(boolean r100) {
        this.inline = r100;
    }

    public LongTitleComponent(Action r100, IconsWithSpaceElement r101, TextElement r102, IconsWithSpaceElement r103, int r104, String r105, List<LongTitleComponent> r106, boolean r107, List<ShowEvent> r108) {
        this.action = r100;
        this.headIcons = r101;
        this.content = r102;
        this.tailIcons = r103;
        this.alignStrategy = r104;
        this.statusId = r105;
        this.states = r106;
        this.inline = r107;
        this.showEvent = r108;
    }

    public /* synthetic */ LongTitleComponent(Action r110, IconsWithSpaceElement r111, TextElement r112, IconsWithSpaceElement r113, int r114, String r115, List r116, boolean r117, List r210, int r211, DefaultConstructorMarker r212) {
        List r100 = null;
        if ((r211 & 1) == 0) goto L5;
        Action r101 = null;
    L7:
        if ((r211 & 2) == 0) goto L9;
        IconsWithSpaceElement r102 = null;
    L11:
        if ((r211 & 4) == 0) goto L13;
        TextElement r103 = null;
    L15:
        if ((r211 & 8) == 0) goto L17;
        IconsWithSpaceElement r104 = null;
    L18:
        boolean r105 = false;
        if ((r211 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r211 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r211 & 64) == 0) goto L29;
        List r108 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r105 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r100 = r210;
    L38:
        this(r101, r102, r103, r104, r106, r107, r108, r105, r100);
        return;
    L29:
        r108 = r116;
        goto L31
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L18
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
