package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0000J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006&"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "Ljava/io/Serializable;", "bubbleColor", "", "promptTextColor", "promptText", "jumpTextColor", "jumpText", "seperatorColor", "showLimit", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBubbleColor", "()Ljava/lang/String;", "getJumpText", "getJumpTextColor", "getPromptText", "getPromptTextColor", "getSeperatorColor", "getShowLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/store/home/entity/FansClubBubbleConfig;", "deepCopy", "equals", "", "other", "", "hashCode", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FansClubBubbleConfig implements Serializable {

    @SerializedName("bubble_color")
    private final String bubbleColor;

    @SerializedName("jump_text")
    private final String jumpText;

    @SerializedName("jump_text_color")
    private final String jumpTextColor;

    @SerializedName("prompt_text")
    private final String promptText;

    @SerializedName("prompt_text_color")
    private final String promptTextColor;

    @SerializedName("seperator_color")
    private final String seperatorColor;

    @SerializedName("show_limit")
    private final Integer showLimit;

    public FansClubBubbleConfig() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FansClubBubbleConfig copy$default(FansClubBubbleConfig r100, String r101, String r102, String r103, String r104, String r110, String r111, Integer r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.bubbleColor;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.promptTextColor;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.promptText;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.jumpTextColor;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.jumpText;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.seperatorColor;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.showLimit;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.bubbleColor;
    }

    public final String component2() {
        return this.promptTextColor;
    }

    public final String component3() {
        return this.promptText;
    }

    public final String component4() {
        return this.jumpTextColor;
    }

    public final String component5() {
        return this.jumpText;
    }

    public final String component6() {
        return this.seperatorColor;
    }

    public final Integer component7() {
        return this.showLimit;
    }

    public final FansClubBubbleConfig copy(String r110, String r111, String r112, String r113, String r114, String r115, Integer r116) {
        return new FansClubBubbleConfig(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FansClubBubbleConfig) == false) goto L20;
        FansClubBubbleConfig r101 = (FansClubBubbleConfig) r100;
        if (Intrinsics.areEqual(this.bubbleColor, r101.bubbleColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promptTextColor, r101.promptTextColor) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.promptText, r101.promptText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpTextColor, r101.jumpTextColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jumpText, r101.jumpText) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.seperatorColor, r101.seperatorColor) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showLimit, r101.showLimit) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.bubbleColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.promptTextColor;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.promptText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.jumpTextColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.jumpText;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.seperatorColor;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.showLimit;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "FansClubBubbleConfig(bubbleColor=" + this.bubbleColor + ", promptTextColor=" + this.promptTextColor + ", promptText=" + this.promptText + ", jumpTextColor=" + this.jumpTextColor + ", jumpText=" + this.jumpText + ", seperatorColor=" + this.seperatorColor + ", showLimit=" + this.showLimit + ")";
    }

    public final FansClubBubbleConfig deepCopy() {
        return copy(this.bubbleColor, this.promptTextColor, this.promptText, this.jumpTextColor, this.jumpText, this.seperatorColor, this.showLimit);
    }

    public final String getBubbleColor() {
        return this.bubbleColor;
    }

    public final String getJumpText() {
        return this.jumpText;
    }

    public final String getJumpTextColor() {
        return this.jumpTextColor;
    }

    public final String getPromptText() {
        return this.promptText;
    }

    public final String getPromptTextColor() {
        return this.promptTextColor;
    }

    public final String getSeperatorColor() {
        return this.seperatorColor;
    }

    public final Integer getShowLimit() {
        return this.showLimit;
    }

    public FansClubBubbleConfig(String r100, String r101, String r102, String r103, String r104, String r105, Integer r106) {
        this.bubbleColor = r100;
        this.promptTextColor = r101;
        this.promptText = r102;
        this.jumpTextColor = r103;
        this.jumpText = r104;
        this.seperatorColor = r105;
        this.showLimit = r106;
    }

    public /* synthetic */ FansClubBubbleConfig(String r100, String r101, String r102, String r110, String r111, String r112, Integer r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        String r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        Integer r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
