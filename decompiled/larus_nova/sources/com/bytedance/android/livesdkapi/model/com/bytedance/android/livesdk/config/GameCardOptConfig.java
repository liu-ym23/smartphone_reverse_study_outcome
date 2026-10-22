package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameCardOptConfig;", "", "cardLoadOptEnable", "", "cancelEventEnable", "(ZZ)V", "getCancelEventEnable", "()Z", "getCardLoadOptEnable", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCardOptConfig {

    @SerializedName("enter_room_cancel_enable")
    private final boolean cancelEventEnable;

    @SerializedName("card_load_opt_enable")
    private final boolean cardLoadOptEnable;

    public GameCardOptConfig() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ GameCardOptConfig copy$default(GameCardOptConfig r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.cardLoadOptEnable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cancelEventEnable;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.cardLoadOptEnable;
    }

    public final boolean component2() {
        return this.cancelEventEnable;
    }

    public final GameCardOptConfig copy(boolean r100, boolean r101) {
        return new GameCardOptConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GameCardOptConfig) == false) goto L10;
        GameCardOptConfig r101 = (GameCardOptConfig) r100;
        if (this.cardLoadOptEnable == r101.cardLoadOptEnable) goto L8;
        return false;
    L8:
        if (this.cancelEventEnable == r101.cancelEventEnable) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r100 = this.cardLoadOptEnable;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.cancelEventEnable;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return r103 + r101;
    }

    public String toString() {
        return "GameCardOptConfig(cardLoadOptEnable=" + this.cardLoadOptEnable + ", cancelEventEnable=" + this.cancelEventEnable + ")";
    }

    public final boolean getCancelEventEnable() {
        return this.cancelEventEnable;
    }

    public final boolean getCardLoadOptEnable() {
        return this.cardLoadOptEnable;
    }

    public GameCardOptConfig(boolean r100, boolean r101) {
        this.cardLoadOptEnable = r100;
        this.cancelEventEnable = r101;
    }

    public /* synthetic */ GameCardOptConfig(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
