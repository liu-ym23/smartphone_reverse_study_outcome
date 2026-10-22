package com.bytedance.android.livesdk.player.game;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/player/game/d;", "", "Lcom/bytedance/android/livesdk/player/game/c;", "conditions", "Lcom/bytedance/android/livesdk/player/game/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/player/game/c;", "setConditions", "(Lcom/bytedance/android/livesdk/player/game/c;)V", "Lcom/google/gson/JsonObject;", "multiViewData", "Lcom/google/gson/JsonObject;", "b", "()Lcom/google/gson/JsonObject;", "setMultiViewData", "(Lcom/google/gson/JsonObject;)V", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("conditions")
    private c conditions;

    @SerializedName("multi_view_data")
    private JsonObject multiViewData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.conditions, r101.conditions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.multiViewData, r101.multiViewData) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        c r100 = this.conditions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.multiViewData;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameSpecialLayoutConfig(conditions=" + this.conditions + ", multiViewData=" + this.multiViewData + ")";
    }

    public d() {
        this.conditions = null;
        this.multiViewData = null;
    }

    public final c a() {
        return this.conditions;
    }

    public final JsonObject b() {
        return this.multiViewData;
    }
}
