package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AnchorModeParseSeiData;", "", "appData", "Lorg/json/JSONObject;", "seiUiLayout", "", "seiScene", "containerTop", "canvas", "(Lorg/json/JSONObject;IIILorg/json/JSONObject;)V", "getAppData", "()Lorg/json/JSONObject;", "getCanvas", "getContainerTop", "()I", "getSeiScene", "getSeiUiLayout", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorModeParseSeiData {
    private final JSONObject appData;
    private final JSONObject canvas;
    private final int containerTop;
    private final int seiScene;
    private final int seiUiLayout;

    public static /* synthetic */ AnchorModeParseSeiData copy$default(AnchorModeParseSeiData r100, JSONObject r101, int r102, int r103, int r104, JSONObject r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.appData;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.seiUiLayout;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.seiScene;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.containerTop;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.canvas;
    L17:
        JSONObject r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final JSONObject component1() {
        return this.appData;
    }

    public final int component2() {
        return this.seiUiLayout;
    }

    public final int component3() {
        return this.seiScene;
    }

    public final int component4() {
        return this.containerTop;
    }

    public final JSONObject component5() {
        return this.canvas;
    }

    public final AnchorModeParseSeiData copy(JSONObject r100, int r101, int r110, int r111, JSONObject r112) {
        Intrinsics.checkNotNullParameter(r112, "canvas");
        return new AnchorModeParseSeiData(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorModeParseSeiData) == false) goto L16;
        AnchorModeParseSeiData r101 = (AnchorModeParseSeiData) r100;
        if (Intrinsics.areEqual(this.appData, r101.appData) == true) goto L8;
        return false;
    L8:
        if (this.seiUiLayout == r101.seiUiLayout) goto L10;
        return false;
    L10:
        if (this.seiScene == r101.seiScene) goto L12;
        return false;
    L12:
        if (this.containerTop == r101.containerTop) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.canvas, r101.canvas) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        JSONObject r100 = this.appData;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((((r102 * 31) + this.seiUiLayout) * 31) + this.seiScene) * 31) + this.containerTop) * 31;
        JSONObject r104 = this.canvas;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorModeParseSeiData(appData=" + this.appData + ", seiUiLayout=" + this.seiUiLayout + ", seiScene=" + this.seiScene + ", containerTop=" + this.containerTop + ", canvas=" + this.canvas + ")";
    }

    public final JSONObject getAppData() {
        return this.appData;
    }

    public final JSONObject getCanvas() {
        return this.canvas;
    }

    public final int getContainerTop() {
        return this.containerTop;
    }

    public final int getSeiScene() {
        return this.seiScene;
    }

    public final int getSeiUiLayout() {
        return this.seiUiLayout;
    }

    public AnchorModeParseSeiData(JSONObject r100, int r101, int r102, int r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r104, "canvas");
        this.appData = r100;
        this.seiUiLayout = r101;
        this.seiScene = r102;
        this.containerTop = r103;
        this.canvas = r104;
    }

    public /* synthetic */ AnchorModeParseSeiData(JSONObject r100, int r101, int r110, int r111, JSONObject r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        int r102 = 0;
    L7:
        if ((r113 & 4) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r113 & 8) == 0) goto L13;
        int r104 = 0;
    L15:
        if ((r113 & 16) == 0) goto L17;
        r112 = new JSONObject();
    L17:
        this(r100, r102, r103, r104, r112);
        return;
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
