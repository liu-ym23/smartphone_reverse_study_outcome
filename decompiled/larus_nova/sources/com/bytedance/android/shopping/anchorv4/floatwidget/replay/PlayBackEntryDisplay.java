package com.bytedance.android.shopping.anchorv4.floatwidget.replay;

import com.bytedance.android.shopping.anchorv4.dto.base.Background;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0086\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\tHÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001a\u0010\r\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001e\u0010\u0018R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u00063"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackEntryDisplay;", "Ljava/io/Serializable;", "textPrefixIcon", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "entryBackground", "Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "entryText", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "showStyle", "", "initState", "floatEntryIcon", "lottie", "playTime", "replayViewBackground", "initPosition", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Ljava/lang/Integer;)V", "getEntryBackground", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;", "getEntryText", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getFloatEntryIcon", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getInitPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInitState", "getLottie", "getPlayTime", "getReplayViewBackground", "getShowStyle", "getTextPrefixIcon", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;Ljava/lang/Integer;Lcom/bytedance/android/shopping/anchorv4/dto/base/Background;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv4/floatwidget/replay/PlayBackEntryDisplay;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayBackEntryDisplay implements Serializable {

    @SerializedName("entry_background")
    private final Background entryBackground;

    @SerializedName("entry_text")
    private final TextElement entryText;

    @SerializedName("float_entry_icon")
    private final ImageModel floatEntryIcon;

    @SerializedName("float_entry_init_position")
    private final Integer initPosition;

    @SerializedName("float_entry_init_state")
    private final Integer initState;

    @SerializedName("replay_change_animation")
    private final ImageModel lottie;

    @SerializedName(HistoryTableOperate.HISTORY_PLAY_TIME)
    private final Integer playTime;

    @SerializedName("replay_view_background")
    private final Background replayViewBackground;

    @SerializedName("float_entry_show_style")
    private final Integer showStyle;

    @SerializedName("text_prefix_icon")
    private final ImageModel textPrefixIcon;

    public PlayBackEntryDisplay() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public static /* synthetic */ PlayBackEntryDisplay copy$default(PlayBackEntryDisplay r110, ImageModel r111, Background r112, TextElement r113, Integer r114, Integer r115, ImageModel r116, ImageModel r117, Integer r118, Background r210, Integer r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        ImageModel r100 = r110.textPrefixIcon;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Background r101 = r110.entryBackground;
    L11:
        if ((r212 & 4) == 0) goto L13;
        TextElement r102 = r110.entryText;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r103 = r110.showStyle;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r104 = r110.initState;
    L23:
        if ((r212 & 32) == 0) goto L25;
        ImageModel r105 = r110.floatEntryIcon;
    L27:
        if ((r212 & 64) == 0) goto L29;
        ImageModel r106 = r110.lottie;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r107 = r110.playTime;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Background r119 = r110.replayViewBackground;
    L39:
        if ((r212 & 512) == 0) goto L41;
        Integer r108 = r110.initPosition;
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

    public final ImageModel component1() {
        return this.textPrefixIcon;
    }

    public final Integer component10() {
        return this.initPosition;
    }

    public final Background component2() {
        return this.entryBackground;
    }

    public final TextElement component3() {
        return this.entryText;
    }

    public final Integer component4() {
        return this.showStyle;
    }

    public final Integer component5() {
        return this.initState;
    }

    public final ImageModel component6() {
        return this.floatEntryIcon;
    }

    public final ImageModel component7() {
        return this.lottie;
    }

    public final Integer component8() {
        return this.playTime;
    }

    public final Background component9() {
        return this.replayViewBackground;
    }

    public final PlayBackEntryDisplay copy(ImageModel r110, Background r111, TextElement r112, Integer r113, Integer r114, ImageModel r115, ImageModel r116, Integer r210, Background r211, Integer r212) {
        return new PlayBackEntryDisplay(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayBackEntryDisplay) == false) goto L26;
        PlayBackEntryDisplay r101 = (PlayBackEntryDisplay) r100;
        if (Intrinsics.areEqual(this.textPrefixIcon, r101.textPrefixIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.entryBackground, r101.entryBackground) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.entryText, r101.entryText) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showStyle, r101.showStyle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.initState, r101.initState) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.floatEntryIcon, r101.floatEntryIcon) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lottie, r101.lottie) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.playTime, r101.playTime) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.replayViewBackground, r101.replayViewBackground) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.initPosition, r101.initPosition) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public int hashCode() {
        ImageModel r100 = this.textPrefixIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Background r104 = this.entryBackground;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextElement r107 = this.entryText;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.showStyle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.initState;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ImageModel r116 = this.floatEntryIcon;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ImageModel r119 = this.lottie;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.playTime;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Background r125 = this.replayViewBackground;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.initPosition;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "PlayBackEntryDisplay(textPrefixIcon=" + this.textPrefixIcon + ", entryBackground=" + this.entryBackground + ", entryText=" + this.entryText + ", showStyle=" + this.showStyle + ", initState=" + this.initState + ", floatEntryIcon=" + this.floatEntryIcon + ", lottie=" + this.lottie + ", playTime=" + this.playTime + ", replayViewBackground=" + this.replayViewBackground + ", initPosition=" + this.initPosition + ")";
    }

    public final Background getEntryBackground() {
        return this.entryBackground;
    }

    public final TextElement getEntryText() {
        return this.entryText;
    }

    public final ImageModel getFloatEntryIcon() {
        return this.floatEntryIcon;
    }

    public final Integer getInitPosition() {
        return this.initPosition;
    }

    public final Integer getInitState() {
        return this.initState;
    }

    public final ImageModel getLottie() {
        return this.lottie;
    }

    public final Integer getPlayTime() {
        return this.playTime;
    }

    public final Background getReplayViewBackground() {
        return this.replayViewBackground;
    }

    public final Integer getShowStyle() {
        return this.showStyle;
    }

    public final ImageModel getTextPrefixIcon() {
        return this.textPrefixIcon;
    }

    public PlayBackEntryDisplay(ImageModel r100, Background r101, TextElement r102, Integer r103, Integer r104, ImageModel r105, ImageModel r106, Integer r107, Background r108, Integer r110) {
        this.textPrefixIcon = r100;
        this.entryBackground = r101;
        this.entryText = r102;
        this.showStyle = r103;
        this.initState = r104;
        this.floatEntryIcon = r105;
        this.lottie = r106;
        this.playTime = r107;
        this.replayViewBackground = r108;
        this.initPosition = r110;
    }

    public /* synthetic */ PlayBackEntryDisplay(ImageModel r110, Background r111, TextElement r112, Integer r113, Integer r114, ImageModel r115, ImageModel r116, Integer r117, Background r210, Integer r211, int r212, DefaultConstructorMarker r213) {
        Integer r100 = null;
        if ((r212 & 1) == 0) goto L5;
        ImageModel r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        Background r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        TextElement r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        Integer r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        Integer r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        ImageModel r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        ImageModel r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Integer r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        Background r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
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
