package com.bytedance.android.shopping.api.mall.model;

import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/PreloadGeckoConfig;", "", "channelName", "", "accessKeyDebug", "accessKeyOnline", "clearTimeInterval", "", "componentId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getAccessKeyDebug", "()Ljava/lang/String;", "getAccessKeyOnline", "getChannelName", "getClearTimeInterval", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getComponentId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/shopping/api/mall/model/PreloadGeckoConfig;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadGeckoConfig {

    @SerializedName("access_key_debug")
    private final String accessKeyDebug;

    @SerializedName("access_key_online")
    private final String accessKeyOnline;

    @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
    private final String channelName;

    @SerializedName("clear_time_interval")
    private final Integer clearTimeInterval;

    @SerializedName("component_id")
    private final String componentId;

    public PreloadGeckoConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PreloadGeckoConfig copy$default(PreloadGeckoConfig r100, String r101, String r102, String r103, Integer r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.channelName;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.accessKeyDebug;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.accessKeyOnline;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.clearTimeInterval;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.componentId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.channelName;
    }

    public final String component2() {
        return this.accessKeyDebug;
    }

    public final String component3() {
        return this.accessKeyOnline;
    }

    public final Integer component4() {
        return this.clearTimeInterval;
    }

    public final String component5() {
        return this.componentId;
    }

    public final PreloadGeckoConfig copy(String r100, String r101, String r110, Integer r111, String r112) {
        return new PreloadGeckoConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PreloadGeckoConfig) == false) goto L16;
        PreloadGeckoConfig r101 = (PreloadGeckoConfig) r100;
        if (Intrinsics.areEqual(this.channelName, r101.channelName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.accessKeyDebug, r101.accessKeyDebug) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.accessKeyOnline, r101.accessKeyOnline) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clearTimeInterval, r101.clearTimeInterval) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.channelName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.accessKeyDebug;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.accessKeyOnline;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.clearTimeInterval;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.componentId;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "PreloadGeckoConfig(channelName=" + this.channelName + ", accessKeyDebug=" + this.accessKeyDebug + ", accessKeyOnline=" + this.accessKeyOnline + ", clearTimeInterval=" + this.clearTimeInterval + ", componentId=" + this.componentId + ")";
    }

    public final String getAccessKeyDebug() {
        return this.accessKeyDebug;
    }

    public final String getAccessKeyOnline() {
        return this.accessKeyOnline;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final Integer getClearTimeInterval() {
        return this.clearTimeInterval;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public PreloadGeckoConfig(String r100, String r101, String r102, Integer r103, String r104) {
        this.channelName = r100;
        this.accessKeyDebug = r101;
        this.accessKeyOnline = r102;
        this.clearTimeInterval = r103;
        this.componentId = r104;
    }

    public /* synthetic */ PreloadGeckoConfig(String r100, String r101, String r102, Integer r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
