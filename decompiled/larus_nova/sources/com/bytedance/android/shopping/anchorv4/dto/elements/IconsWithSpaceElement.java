package com.bytedance.android.shopping.anchorv4.dto.elements;

import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\tHÆ\u0003J[\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\fJ\t\u0010&\u001a\u00020\u0007HÖ\u0001J\t\u0010'\u001a\u00020\fHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/elements/IconsWithSpaceElement;", "Ljava/io/Serializable;", "background", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "action", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "space", "", IconList.ELEM_NAME, "", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "statusId", "", "states", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;ILjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getAction", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Action;", "getBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getIconList", "()Ljava/util/List;", "getSpace", "()I", "getStates", "getStatusId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "findStatus", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconsWithSpaceElement implements Serializable {

    @SerializedName("action")
    private final Action action;

    @SerializedName("background")
    private final Background background;

    @SerializedName("icon_list")
    private final List<ImageModel> iconList;

    /* JADX INFO: renamed from: space, reason: collision with root package name */
    @SerializedName("space")
    private final int f166526space;

    @SerializedName("states")
    private final List<IconsWithSpaceElement> states;

    @SerializedName("status_id")
    private final String statusId;

    public IconsWithSpaceElement() {
        this(null, null, 0, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IconsWithSpaceElement copy$default(IconsWithSpaceElement r100, Background r101, Action r102, int r103, List r104, String r105, List r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.background;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.action;
    L8:
        Action r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f166526space;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.iconList;
    L14:
        List r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.statusId;
    L17:
        String r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.states;
    L20:
        Background r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final Background component1() {
        return this.background;
    }

    public final Action component2() {
        return this.action;
    }

    public final int component3() {
        return this.f166526space;
    }

    public final List<ImageModel> component4() {
        return this.iconList;
    }

    public final String component5() {
        return this.statusId;
    }

    public final List<IconsWithSpaceElement> component6() {
        return this.states;
    }

    public final IconsWithSpaceElement copy(Background r100, Action r110, int r111, List<ImageModel> r112, String r113, List<IconsWithSpaceElement> r114) {
        return new IconsWithSpaceElement(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IconsWithSpaceElement) == false) goto L18;
        IconsWithSpaceElement r101 = (IconsWithSpaceElement) r100;
        if (Intrinsics.areEqual(this.background, r101.background) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L10;
        return false;
    L10:
        if (this.f166526space == r101.f166526space) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconList, r101.iconList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.statusId, r101.statusId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.states, r101.states) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        Background r100 = this.background;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Action r104 = this.action;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.f166526space) * 31;
        List<ImageModel> r107 = this.iconList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.statusId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<IconsWithSpaceElement> r113 = this.states;
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
        return "IconsWithSpaceElement(background=" + this.background + ", action=" + this.action + ", space=" + this.f166526space + ", iconList=" + this.iconList + ", statusId=" + this.statusId + ", states=" + this.states + ")";
    }

    public final Action getAction() {
        return this.action;
    }

    public final Background getBackground() {
        return this.background;
    }

    public final List<ImageModel> getIconList() {
        return this.iconList;
    }

    public final int getSpace() {
        return this.f166526space;
    }

    public final List<IconsWithSpaceElement> getStates() {
        return this.states;
    }

    public final String getStatusId() {
        return this.statusId;
    }

    public final IconsWithSpaceElement findStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "statusId");
        if (Intrinsics.areEqual(this.statusId, r100) == false) goto L5;
        return this;
    L5:
        List<IconsWithSpaceElement> r101 = this.states;
        Object r102 = null;
        if (r101 == null) goto L18;
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        Object r104 = r103.next();
        if (Intrinsics.areEqual(((IconsWithSpaceElement) r104).statusId, r100) == false) goto L9;
        r102 = r104;
    L14:
        return (IconsWithSpaceElement) r102;
    L18:
        return null;
    }

    public IconsWithSpaceElement(Background r100, Action r101, int r102, List<ImageModel> r103, String r104, List<IconsWithSpaceElement> r105) {
        this.background = r100;
        this.action = r101;
        this.f166526space = r102;
        this.iconList = r103;
        this.statusId = r104;
        this.states = r105;
    }

    public /* synthetic */ IconsWithSpaceElement(Background r100, Action r101, int r102, List r103, String r110, List r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        Background r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        Action r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        int r105 = 0;
    L15:
        if ((r112 & 8) == 0) goto L17;
        List r106 = null;
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = null;
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
