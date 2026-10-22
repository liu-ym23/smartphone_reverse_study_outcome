package com.bytedance.android.shopping.anchorv4.dto.components;

import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ShowEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000bHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0003J]\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\tHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/components/GradientTextWithIconsComponent;", "Ljava/io/Serializable;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "statusId", "", "states", "", "showEvent", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ShowEvent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongTitleComponent;", "getShowEvent", "()Ljava/util/List;", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GradientTextWithIconsComponent implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("background")
    private final Background background;

    @SerializedName("content")
    private final LongTitleComponent content;

    @SerializedName("show_event")
    private final List<ShowEvent> showEvent;

    @SerializedName("states")
    private final List<GradientTextWithIconsComponent> states;

    @SerializedName("status_id")
    private final String statusId;

    public GradientTextWithIconsComponent() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GradientTextWithIconsComponent copy$default(GradientTextWithIconsComponent r100, Action r101, Background r102, LongTitleComponent r103, String r104, List r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.action;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.background;
    L8:
        Background r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        LongTitleComponent r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.statusId;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.states;
    L17:
        List r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.showEvent;
    L20:
        Action r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Action component1() {
        return this.action;
    }

    public final Background component2() {
        return this.background;
    }

    public final LongTitleComponent component3() {
        return this.content;
    }

    public final String component4() {
        return this.statusId;
    }

    public final List<GradientTextWithIconsComponent> component5() {
        return this.states;
    }

    public final List<ShowEvent> component6() {
        return this.showEvent;
    }

    public final GradientTextWithIconsComponent copy(Action r100, Background r110, LongTitleComponent r111, String r112, List<GradientTextWithIconsComponent> r113, List<ShowEvent> r114) {
        return new GradientTextWithIconsComponent(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GradientTextWithIconsComponent) == false) goto L18;
        GradientTextWithIconsComponent r101 = (GradientTextWithIconsComponent) r100;
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.showEvent, r101.showEvent) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

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
        LongTitleComponent r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.statusId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<GradientTextWithIconsComponent> r113 = this.states;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<ShowEvent> r116 = this.showEvent;
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
        return "GradientTextWithIconsComponent(action=" + this.action + ", background=" + this.background + ", content=" + this.content + ", statusId=" + this.statusId + ", states=" + this.states + ", showEvent=" + this.showEvent + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final LongTitleComponent getContent() {
        return this.content;
    }

    public final List<ShowEvent> getShowEvent() {
        return this.showEvent;
    }

    public final List<GradientTextWithIconsComponent> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public GradientTextWithIconsComponent(Action r100, Background r101, LongTitleComponent r102, String r103, List<GradientTextWithIconsComponent> r104, List<ShowEvent> r105) {
        this.action = r100;
        this.background = r101;
        this.content = r102;
        this.statusId = r103;
        this.states = r104;
        this.showEvent = r105;
    }

    public /* synthetic */ GradientTextWithIconsComponent(Action r100, Background r101, LongTitleComponent r102, String r103, List r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Action r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Background r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        LongTitleComponent r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        List r107 = null;
    L23:
        if ((r112 & 32) == 0) goto L25;
        List r115 = null;
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
