package com.bytedance.android.ec.base.api.ai;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u001b\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\rHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\u0087\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010)\u001a\u00020\u000b2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016¨\u0006-"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatInputConfig;", "", "defaultInputMode", "", "hint", "", "speakHint", "indicateActionEntrance", "actionEntranceConfig", "", "showPlusMenu", "", "plusActions", "", "enableActionBar", "useAlphaStyle", "(ILjava/lang/String;Ljava/lang/String;ILjava/util/Map;ZLjava/util/List;ZZ)V", "getActionEntranceConfig", "()Ljava/util/Map;", "getDefaultInputMode", "()I", "getEnableActionBar", "()Z", "getHint", "()Ljava/lang/String;", "getIndicateActionEntrance", "getPlusActions", "()Ljava/util/List;", "getShowPlusMenu", "getSpeakHint", "getUseAlphaStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatInputConfig {
    private final Map<String, String> actionEntranceConfig;
    private final int defaultInputMode;
    private final boolean enableActionBar;
    private final String hint;
    private final int indicateActionEntrance;
    private final List<Map<String, String>> plusActions;
    private final boolean showPlusMenu;
    private final String speakHint;
    private final boolean useAlphaStyle;

    public AIChatInputConfig() {
        this(0, null, null, 0, null, false, null, false, false, 511, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIChatInputConfig copy$default(AIChatInputConfig r110, int r111, String r112, String r113, int r114, Map r115, boolean r116, List r117, boolean r118, boolean r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        int r100 = r110.defaultInputMode;
    L7:
        if ((r210 & 2) == 0) goto L9;
        String r101 = r110.hint;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = r110.speakHint;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r103 = r110.indicateActionEntrance;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Map r104 = r110.actionEntranceConfig;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.showPlusMenu;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r106 = r110.plusActions;
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r107 = r110.enableActionBar;
    L35:
        if ((r210 & 256) == 0) goto L37;
        boolean r108 = r110.useAlphaStyle;
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

    public final int component1() {
        return this.defaultInputMode;
    }

    public final String component2() {
        return this.hint;
    }

    public final String component3() {
        return this.speakHint;
    }

    public final int component4() {
        return this.indicateActionEntrance;
    }

    public final Map<String, String> component5() {
        return this.actionEntranceConfig;
    }

    public final boolean component6() {
        return this.showPlusMenu;
    }

    public final List<Map<String, String>> component7() {
        return this.plusActions;
    }

    public final boolean component8() {
        return this.enableActionBar;
    }

    public final boolean component9() {
        return this.useAlphaStyle;
    }

    public final AIChatInputConfig copy(int r110, String r111, String r112, int r113, Map<String, String> r114, boolean r115, List<? extends Map<String, String>> r116, boolean r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r116, "plusActions");
        return new AIChatInputConfig(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AIChatInputConfig) == false) goto L24;
        AIChatInputConfig r101 = (AIChatInputConfig) r100;
        if (this.defaultInputMode == r101.defaultInputMode) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hint, r101.hint) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.speakHint, r101.speakHint) == true) goto L12;
        return false;
    L12:
        if (this.indicateActionEntrance == r101.indicateActionEntrance) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.actionEntranceConfig, r101.actionEntranceConfig) == true) goto L16;
        return false;
    L16:
        if (this.showPlusMenu == r101.showPlusMenu) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.plusActions, r101.plusActions) == true) goto L20;
        return false;
    L20:
        if (this.enableActionBar == r101.enableActionBar) goto L22;
        return false;
    L22:
        if (this.useAlphaStyle == r101.useAlphaStyle) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        int r100 = this.defaultInputMode * 31;
        String r101 = this.hint;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.speakHint;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (((r104 + r106) * 31) + this.indicateActionEntrance) * 31;
        Map<String, String> r108 = this.actionEntranceConfig;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.showPlusMenu;
        ?? r112 = 1;
        ?? r113 = r111;
        if (r111 == false) goto L17;
        r113 = 1;
    L17:
        int r114 = (r110 + r113) * 31;
        List<Map<String, String>> r115 = this.plusActions;
        if (r115 == null) goto L20;
        r102 = r115.hashCode();
    L20:
        int r116 = (r114 + r102) * 31;
        boolean r117 = this.enableActionBar;
        ?? r118 = r117;
        if (r117 == false) goto L23;
        r118 = 1;
    L23:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.useAlphaStyle;
        if (r120 == true) goto L28;
        r112 = r120;
    L28:
        return r119 + r112;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatInputConfig(defaultInputMode=" + this.defaultInputMode + ", hint=" + this.hint + ", speakHint=" + this.speakHint + ", indicateActionEntrance=" + this.indicateActionEntrance + ", actionEntranceConfig=" + this.actionEntranceConfig + ", showPlusMenu=" + this.showPlusMenu + ", plusActions=" + this.plusActions + ", enableActionBar=" + this.enableActionBar + ", useAlphaStyle=" + this.useAlphaStyle + ")";
    }

    public final Map<String, String> getActionEntranceConfig() {
        return this.actionEntranceConfig;
    }

    public final int getDefaultInputMode() {
        return this.defaultInputMode;
    }

    public final boolean getEnableActionBar() {
        return this.enableActionBar;
    }

    public final String getHint() {
        return this.hint;
    }

    public final int getIndicateActionEntrance() {
        return this.indicateActionEntrance;
    }

    public final List<Map<String, String>> getPlusActions() {
        return this.plusActions;
    }

    public final boolean getShowPlusMenu() {
        return this.showPlusMenu;
    }

    public final String getSpeakHint() {
        return this.speakHint;
    }

    public final boolean getUseAlphaStyle() {
        return this.useAlphaStyle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIChatInputConfig(int r100, String r101, String r102, int r103, Map<String, String> r104, boolean r105, List<? extends Map<String, String>> r106, boolean r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r106, "plusActions");
        this.defaultInputMode = r100;
        this.hint = r101;
        this.speakHint = r102;
        this.indicateActionEntrance = r103;
        this.actionEntranceConfig = r104;
        this.showPlusMenu = r105;
        this.plusActions = r106;
        this.enableActionBar = r107;
        this.useAlphaStyle = r110;
    }

    public /* synthetic */ AIChatInputConfig(int r110, String r111, String r112, int r113, Map r114, boolean r115, List r116, boolean r117, boolean r118, int r210, DefaultConstructorMarker r211) {
        boolean r100 = false;
        if ((r210 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        Map r102 = null;
        if ((r210 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r210 & 8) == 0) goto L17;
        int r105 = 0;
    L19:
        if ((r210 & 16) != 0) goto L23;
        r102 = r114;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r210 & 64) == 0) goto L29;
        List r107 = CollectionsKt.emptyList();
    L31:
        if ((r210 & 128) == 0) goto L33;
        boolean r108 = false;
    L35:
        if ((r210 & 256) != 0) goto L38;
        r100 = r118;
    L38:
        this(r101, r103, r104, r105, r102, r106, r107, r108, r100);
        return;
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
