package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/Group;", "Ljava/io/Serializable;", "groupName", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "groupTips", "", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/util/List;)V", "getGroupName", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getGroupTips", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Group implements Serializable {

    @SerializedName("group_name")
    private final TextElement groupName;

    @SerializedName("group_tips")
    private final List<LongContentLabelComponent> groupTips;

    /* JADX WARN: Multi-variable type inference failed */
    public Group() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Group copy$default(Group r100, TextElement r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.groupName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.groupTips;
    L9:
        return r100.copy(r101, r102);
    }

    public final TextElement component1() {
        return this.groupName;
    }

    public final List<LongContentLabelComponent> component2() {
        return this.groupTips;
    }

    public final Group copy(TextElement r100, List<? extends LongContentLabelComponent> r101) {
        return new Group(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Group) == false) goto L10;
        Group r101 = (Group) r100;
        if (Intrinsics.areEqual(this.groupName, r101.groupName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.groupTips, r101.groupTips) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        TextElement r100 = this.groupName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LongContentLabelComponent> r104 = this.groupTips;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "Group(groupName=" + this.groupName + ", groupTips=" + this.groupTips + ")";
    }

    public final TextElement getGroupName() {
        return this.groupName;
    }

    public final List<LongContentLabelComponent> getGroupTips() {
        return this.groupTips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Group(TextElement r100, List<? extends LongContentLabelComponent> r101) {
        this.groupName = r100;
        this.groupTips = r101;
    }

    public /* synthetic */ Group(TextElement r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
