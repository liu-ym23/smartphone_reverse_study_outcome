package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J`\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ParseSeiData;", "", "seiVersion", "", "seiSubScene", "seiUiLayout", "canvas", "Lorg/json/JSONObject;", "positionStashStatus", "isShowPlayerInAudioRoom", "", "subUILayout", "seiStyle", "(IIILorg/json/JSONObject;IZLjava/lang/Integer;I)V", "getCanvas", "()Lorg/json/JSONObject;", "()Z", "getPositionStashStatus", "()I", "setPositionStashStatus", "(I)V", "getSeiStyle", "getSeiSubScene", "getSeiUiLayout", "getSeiVersion", "getSubUILayout", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(IIILorg/json/JSONObject;IZLjava/lang/Integer;I)Lcom/bytedance/android/livesdkapi/model/ParseSeiData;", "equals", "other", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ParseSeiData {
    private final JSONObject canvas;
    private final boolean isShowPlayerInAudioRoom;
    private int positionStashStatus;
    private final int seiStyle;
    private final int seiSubScene;
    private final int seiUiLayout;
    private final int seiVersion;
    private final Integer subUILayout;

    public ParseSeiData() {
        this(0, 0, 0, null, 0, false, null, 0, 255, null);
    }

    public static /* synthetic */ ParseSeiData copy$default(ParseSeiData r100, int r110, int r111, int r112, JSONObject r113, int r114, boolean r115, Integer r116, int r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.seiVersion;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.seiSubScene;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.seiUiLayout;
    L15:
        if ((r118 & 8) == 0) goto L17;
        JSONObject r104 = r100.canvas;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.positionStashStatus;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.isShowPlayerInAudioRoom;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = r100.subUILayout;
    L31:
        if ((r118 & 128) == 0) goto L33;
        int r108 = r100.seiStyle;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
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

    public final int component1() {
        return this.seiVersion;
    }

    public final int component2() {
        return this.seiSubScene;
    }

    public final int component3() {
        return this.seiUiLayout;
    }

    public final JSONObject component4() {
        return this.canvas;
    }

    public final int component5() {
        return this.positionStashStatus;
    }

    public final boolean component6() {
        return this.isShowPlayerInAudioRoom;
    }

    public final Integer component7() {
        return this.subUILayout;
    }

    public final int component8() {
        return this.seiStyle;
    }

    public final ParseSeiData copy(int r110, int r111, int r112, JSONObject r113, int r114, boolean r115, Integer r116, int r117) {
        Intrinsics.checkNotNullParameter(r113, "canvas");
        return new ParseSeiData(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ParseSeiData) == false) goto L22;
        ParseSeiData r101 = (ParseSeiData) r100;
        if (this.seiVersion == r101.seiVersion) goto L8;
        return false;
    L8:
        if (this.seiSubScene == r101.seiSubScene) goto L10;
        return false;
    L10:
        if (this.seiUiLayout == r101.seiUiLayout) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.canvas, r101.canvas) == true) goto L14;
        return false;
    L14:
        if (this.positionStashStatus == r101.positionStashStatus) goto L16;
        return false;
    L16:
        if (this.isShowPlayerInAudioRoom == r101.isShowPlayerInAudioRoom) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subUILayout, r101.subUILayout) == true) goto L20;
        return false;
    L20:
        if (this.seiStyle == r101.seiStyle) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int r100 = ((((this.seiVersion * 31) + this.seiSubScene) * 31) + this.seiUiLayout) * 31;
        JSONObject r101 = this.canvas;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.positionStashStatus) * 31;
        boolean r105 = this.isShowPlayerInAudioRoom;
        ?? r106 = r105;
        if (r105 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.subUILayout;
        if (r108 == null) goto L13;
        r102 = r108.hashCode();
    L13:
        return ((r107 + r102) * 31) + this.seiStyle;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "ParseSeiData(seiVersion=" + this.seiVersion + ", seiSubScene=" + this.seiSubScene + ", seiUiLayout=" + this.seiUiLayout + ", canvas=" + this.canvas + ", positionStashStatus=" + this.positionStashStatus + ", isShowPlayerInAudioRoom=" + this.isShowPlayerInAudioRoom + ", subUILayout=" + this.subUILayout + ", seiStyle=" + this.seiStyle + ")";
    }

    public final JSONObject getCanvas() {
        return this.canvas;
    }

    public final int getPositionStashStatus() {
        return this.positionStashStatus;
    }

    public final int getSeiStyle() {
        return this.seiStyle;
    }

    public final int getSeiSubScene() {
        return this.seiSubScene;
    }

    public final int getSeiUiLayout() {
        return this.seiUiLayout;
    }

    public final int getSeiVersion() {
        return this.seiVersion;
    }

    public final Integer getSubUILayout() {
        return this.subUILayout;
    }

    public final boolean isShowPlayerInAudioRoom() {
        return this.isShowPlayerInAudioRoom;
    }

    public final void setPositionStashStatus(int r100) {
        this.positionStashStatus = r100;
    }

    public ParseSeiData(int r100, int r101, int r102, JSONObject r103, int r104, boolean r105, Integer r106, int r107) {
        Intrinsics.checkNotNullParameter(r103, "canvas");
        this.seiVersion = r100;
        this.seiSubScene = r101;
        this.seiUiLayout = r102;
        this.canvas = r103;
        this.positionStashStatus = r104;
        this.isShowPlayerInAudioRoom = r105;
        this.subUILayout = r106;
        this.seiStyle = r107;
    }

    public /* synthetic */ ParseSeiData(int r110, int r111, int r112, JSONObject r113, int r114, boolean r115, Integer r116, int r117, int r118, DefaultConstructorMarker r119) {
        int r100 = 0;
        if ((r118 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = 0;
    L15:
        if ((r118 & 8) == 0) goto L17;
        JSONObject r104 = new JSONObject();
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Integer r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
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
