package com.bytedance.android.livesdkapi.sti;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010!\u001a\u00020\u0003H\u0016J\t\u0010\"\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "", "typeId", "", "view", "Landroid/view/View;", "blockingEntryMs", "", "iconDesc", "", "isEnhancedTouch", "", "dynamicPriority", "(ILandroid/view/View;JLjava/lang/String;ZJ)V", "getBlockingEntryMs", "()J", "getDynamicPriority", "getIconDesc", "()Ljava/lang/String;", "()Z", "getTypeId", "()I", "getView", "()Landroid/view/View;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "livedynamic-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTermIcon {
    private final long blockingEntryMs;
    private final long dynamicPriority;
    private final String iconDesc;
    private final boolean isEnhancedTouch;
    private final int typeId;
    private final View view;

    public ShortTermIcon(int r110, View r111) {
        this(r110, r111, 0, null, false, 0, 60, null);
    }

    public ShortTermIcon(int r110, View r111, long r112) {
        this(r110, r111, r112, null, false, 0, 56, null);
    }

    public ShortTermIcon(int r110, View r111, long r112, String r113) {
        this(r110, r111, r112, r113, false, 0, 48, null);
    }

    public ShortTermIcon(int r110, View r111, long r112, String r113, boolean r114) {
        this(r110, r111, r112, r113, r114, 0, 32, null);
    }

    public static /* synthetic */ ShortTermIcon copy$default(ShortTermIcon r100, int r110, View r111, long r112, String r113, boolean r114, long r115, int r116, Object r117) {
        if ((r116 & 1) == 0) goto L5;
        int r101 = r100.typeId;
    L7:
        if ((r116 & 2) == 0) goto L9;
        View r102 = r100.view;
    L11:
        if ((r116 & 4) == 0) goto L13;
        long r103 = r100.blockingEntryMs;
    L15:
        if ((r116 & 8) == 0) goto L17;
        String r104 = r100.iconDesc;
    L19:
        if ((r116 & 16) == 0) goto L21;
        boolean r105 = r100.isEnhancedTouch;
    L23:
        if ((r116 & 32) == 0) goto L25;
        long r106 = r100.dynamicPriority;
    L27:
        return r100.copy(r101, r102, r103, r104, r105, r106);
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

    public final int component1() {
        return this.typeId;
    }

    public final View component2() {
        return this.view;
    }

    public final long component3() {
        return this.blockingEntryMs;
    }

    public final String component4() {
        return this.iconDesc;
    }

    public final boolean component5() {
        return this.isEnhancedTouch;
    }

    public final long component6() {
        return this.dynamicPriority;
    }

    public final ShortTermIcon copy(int r110, View r111, long r112, String r113, boolean r114, long r115) {
        Intrinsics.checkNotNullParameter(r111, "view");
        Intrinsics.checkNotNullParameter(r113, "iconDesc");
        return new ShortTermIcon(r110, r111, r112, r113, r114, r115);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShortTermIcon) == false) goto L18;
        ShortTermIcon r101 = (ShortTermIcon) r100;
        if (this.typeId == r101.typeId) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L10;
        return false;
    L10:
        if (this.blockingEntryMs == r101.blockingEntryMs) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.iconDesc, r101.iconDesc) == true) goto L14;
        return false;
    L14:
        if (this.isEnhancedTouch == r101.isEnhancedTouch) goto L16;
        return false;
    L16:
        if (this.dynamicPriority == r101.dynamicPriority) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public String toString() {
        return "ShortTermIcon(typeId=" + this.typeId + ", view=" + this.view + ", blockingEntryMs=" + this.blockingEntryMs + ", iconDesc=" + this.iconDesc + ", isEnhancedTouch=" + this.isEnhancedTouch + ", dynamicPriority=" + this.dynamicPriority + ")";
    }

    public int hashCode() {
        int r100 = (this.typeId * 31) + (this.view.hashCode() * 31);
        long r101 = this.blockingEntryMs;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final long getBlockingEntryMs() {
        return this.blockingEntryMs;
    }

    public final long getDynamicPriority() {
        return this.dynamicPriority;
    }

    public final String getIconDesc() {
        return this.iconDesc;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final View getView() {
        return this.view;
    }

    public final boolean isEnhancedTouch() {
        return this.isEnhancedTouch;
    }

    public ShortTermIcon(int r100, View r101, long r102, String r103, boolean r104, long r105) {
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, "iconDesc");
        this.typeId = r100;
        this.view = r101;
        this.blockingEntryMs = r102;
        this.iconDesc = r103;
        this.isEnhancedTouch = r104;
        this.dynamicPriority = r105;
        r101.setTag(Boolean.valueOf(r104));
    }

    public /* synthetic */ ShortTermIcon(int r110, View r111, long r112, String r113, boolean r114, long r115, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 4) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r210 & 8) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r210 & 16) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r210 & 32) == 0) goto L17;
        long r116 = 0;
    L18:
        this(r110, r111, r100, r101, r102, r116);
        return;
    L17:
        r116 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
