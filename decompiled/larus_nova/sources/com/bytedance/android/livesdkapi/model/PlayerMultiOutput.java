package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerMultiOutput;", "", "id", "", "input", "Lcom/bytedance/android/livesdkapi/model/PlayerMultiInput;", "displayRect", "Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "level", "", "(Ljava/lang/String;Lcom/bytedance/android/livesdkapi/model/PlayerMultiInput;Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;I)V", "getDisplayRect", "()Lcom/bytedance/android/livesdkapi/model/RenderAreaInfo;", "getId", "()Ljava/lang/String;", "getInput", "()Lcom/bytedance/android/livesdkapi/model/PlayerMultiInput;", "getLevel", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerMultiOutput {
    private final RenderAreaInfo displayRect;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f162635id;
    private final PlayerMultiInput input;
    private final int level;

    public static /* synthetic */ PlayerMultiOutput copy$default(PlayerMultiOutput r100, String r101, PlayerMultiInput r102, RenderAreaInfo r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.f162635id;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.input;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.displayRect;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.level;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.f162635id;
    }

    public final PlayerMultiInput component2() {
        return this.input;
    }

    public final RenderAreaInfo component3() {
        return this.displayRect;
    }

    public final int component4() {
        return this.level;
    }

    public final PlayerMultiOutput copy(String r100, PlayerMultiInput r101, RenderAreaInfo r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, "displayRect");
        return new PlayerMultiOutput(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PlayerMultiOutput) == false) goto L14;
        PlayerMultiOutput r101 = (PlayerMultiOutput) r100;
        if (Intrinsics.areEqual(this.f162635id, r101.f162635id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.input, r101.input) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.displayRect, r101.displayRect) == true) goto L12;
        return false;
    L12:
        if (this.level == r101.level) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.f162635id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PlayerMultiInput r104 = this.input;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        RenderAreaInfo r107 = this.displayRect;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.level;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PlayerMultiOutput(id=" + this.f162635id + ", input=" + this.input + ", displayRect=" + this.displayRect + ", level=" + this.level + ")";
    }

    public final RenderAreaInfo getDisplayRect() {
        return this.displayRect;
    }

    public final String getId() {
        return this.f162635id;
    }

    public final PlayerMultiInput getInput() {
        return this.input;
    }

    public final int getLevel() {
        return this.level;
    }

    public PlayerMultiOutput(String r100, PlayerMultiInput r101, RenderAreaInfo r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "input");
        Intrinsics.checkNotNullParameter(r102, "displayRect");
        this.f162635id = r100;
        this.input = r101;
        this.displayRect = r102;
        this.level = r103;
    }
}
