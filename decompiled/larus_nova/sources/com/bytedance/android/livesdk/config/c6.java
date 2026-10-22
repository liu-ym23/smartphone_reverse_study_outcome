package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/config/c6;", "", "", "enable", "Z", "b", "()Z", "", "", "screenShotRoomConfig", "Ljava/util/List;", "d", "()Ljava/util/List;", "normalGameRoomConfig", "c", "delayLoadConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c6 {

    @SerializedName("delay_load_config")
    private final List<String> delayLoadConfig;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("normal_room_forbid_config")
    private final List<String> normalGameRoomConfig;

    @SerializedName("screen_shot_forbid_config")
    private final List<String> screenShotRoomConfig;

    public c6() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c6) == false) goto L14;
        c6 r101 = (c6) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.screenShotRoomConfig, r101.screenShotRoomConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.normalGameRoomConfig, r101.normalGameRoomConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.delayLoadConfig, r101.delayLoadConfig) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        List<String> r103 = this.screenShotRoomConfig;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        List<String> r107 = this.normalGameRoomConfig;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.delayLoadConfig;
        if (r110 == null) goto L17;
        r104 = r110.hashCode();
    L17:
        return r109 + r104;
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "GameEnterRoomWidgetOptConfig(enable=" + this.enable + ", screenShotRoomConfig=" + this.screenShotRoomConfig + ", normalGameRoomConfig=" + this.normalGameRoomConfig + ", delayLoadConfig=" + this.delayLoadConfig + ')';
    }

    public final List<String> a() {
        return this.delayLoadConfig;
    }

    public final boolean b() {
        return this.enable;
    }

    public final List<String> c() {
        return this.normalGameRoomConfig;
    }

    public final List<String> d() {
        return this.screenShotRoomConfig;
    }

    public c6(Object r100) {
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        this.enable = false;
        this.screenShotRoomConfig = r101;
        this.normalGameRoomConfig = r102;
        this.delayLoadConfig = r103;
    }
}
