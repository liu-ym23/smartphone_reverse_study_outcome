package com.bytedance.android.shopping.api.mall.preload.gecko;

import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R$\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig;", "Ljava/io/Serializable;", "()V", "eventExecuteEnable", "", "getEventExecuteEnable", "()Z", "exposureExecuteEnable", "getExposureExecuteEnable", "itemConfigMap", "", "", "Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig$ItemConfig;", "getItemConfigMap", "()Ljava/util/Map;", "ItemConfig", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallGeckoPreloadConfig implements Serializable {

    @SerializedName("event_execute_enable")
    private final boolean eventExecuteEnable;

    @SerializedName("exposure_execute_enable")
    private final boolean exposureExecuteEnable;

    @SerializedName("item_config_map")
    private final Map<String, ItemConfig> itemConfigMap;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0010HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\rHÆ\u0003J\u0083\u0001\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\nHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013¨\u00065"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/preload/gecko/ECMallGeckoPreloadConfig$ItemConfig;", "", "channelName", "", "accessKeyOnline", "accessKeyDebug", "componentId", "tileComponentId", "tabId", "executeCountLimit", "", "executeGapDuration", "retryEnable", "", "executeCount", "lastExecuteTimestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZIJ)V", "getAccessKeyDebug", "()Ljava/lang/String;", "getAccessKeyOnline", "getChannelName", "getComponentId", "getExecuteCount", "()I", "setExecuteCount", "(I)V", "getExecuteCountLimit", "getExecuteGapDuration", "getLastExecuteTimestamp", "()J", "setLastExecuteTimestamp", "(J)V", "getRetryEnable", "()Z", "getTabId", "getTileComponentId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemConfig {

        @SerializedName("access_key_debug")
        private final String accessKeyDebug;

        @SerializedName("access_key_online")
        private final String accessKeyOnline;

        @SerializedName(OpenFeedConstantKt.KEY_CHANNEL_NAME)
        private final String channelName;

        @SerializedName("component_id")
        private final String componentId;
        private transient int executeCount;

        @SerializedName("execute_count_limit")
        private final int executeCountLimit;

        @SerializedName("execute_gap_duration")
        private final int executeGapDuration;
        private transient long lastExecuteTimestamp;

        @SerializedName("retry_enable")
        private final boolean retryEnable;

        @SerializedName("tab_id")
        private final String tabId;

        @SerializedName("tile_component_id")
        private final String tileComponentId;

        public ItemConfig() {
            this(null, null, null, null, null, null, 0, 0, false, 0, 0, 2047, null);
        }

        public static /* synthetic */ ItemConfig copy$default(ItemConfig r110, String r111, String r112, String r113, String r114, String r115, String r210, int r211, int r212, boolean r213, int r214, long r215, int r216, Object r217) {
            if ((r216 & 1) == 0) goto L5;
            String r100 = r110.channelName;
        L7:
            if ((r216 & 2) == 0) goto L9;
            String r101 = r110.accessKeyOnline;
        L11:
            if ((r216 & 4) == 0) goto L13;
            String r102 = r110.accessKeyDebug;
        L15:
            if ((r216 & 8) == 0) goto L17;
            String r103 = r110.componentId;
        L19:
            if ((r216 & 16) == 0) goto L21;
            String r104 = r110.tileComponentId;
        L23:
            if ((r216 & 32) == 0) goto L25;
            String r105 = r110.tabId;
        L27:
            if ((r216 & 64) == 0) goto L29;
            int r106 = r110.executeCountLimit;
        L31:
            if ((r216 & 128) == 0) goto L33;
            int r107 = r110.executeGapDuration;
        L35:
            if ((r216 & 256) == 0) goto L37;
            boolean r116 = r110.retryEnable;
        L39:
            if ((r216 & 512) == 0) goto L41;
            int r117 = r110.executeCount;
        L43:
            if ((r216 & 1024) == 0) goto L45;
            long r118 = r110.lastExecuteTimestamp;
        L47:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r116, r117, r118);
        L45:
            r118 = r215;
            goto L47
        L41:
            r117 = r214;
            goto L43
        L37:
            r116 = r213;
            goto L39
        L33:
            r107 = r212;
            goto L35
        L29:
            r106 = r211;
            goto L31
        L25:
            r105 = r210;
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

        public final String component1() {
            return this.channelName;
        }

        public final int component10() {
            return this.executeCount;
        }

        public final long component11() {
            return this.lastExecuteTimestamp;
        }

        public final String component2() {
            return this.accessKeyOnline;
        }

        public final String component3() {
            return this.accessKeyDebug;
        }

        public final String component4() {
            return this.componentId;
        }

        public final String component5() {
            return this.tileComponentId;
        }

        public final String component6() {
            return this.tabId;
        }

        public final int component7() {
            return this.executeCountLimit;
        }

        public final int component8() {
            return this.executeGapDuration;
        }

        public final boolean component9() {
            return this.retryEnable;
        }

        public final ItemConfig copy(String r110, String r111, String r112, String r113, String r114, String r210, int r211, int r212, boolean r213, int r214, long r215) {
            return new ItemConfig(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof ItemConfig) == false) goto L28;
            ItemConfig r101 = (ItemConfig) r100;
            if (Intrinsics.areEqual(this.channelName, r101.channelName) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.accessKeyOnline, r101.accessKeyOnline) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.accessKeyDebug, r101.accessKeyDebug) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.componentId, r101.componentId) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.tileComponentId, r101.tileComponentId) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.tabId, r101.tabId) == true) goto L18;
            return false;
        L18:
            if (this.executeCountLimit == r101.executeCountLimit) goto L20;
            return false;
        L20:
            if (this.executeGapDuration == r101.executeGapDuration) goto L22;
            return false;
        L22:
            if (this.retryEnable == r101.retryEnable) goto L24;
            return false;
        L24:
            if (this.executeCount == r101.executeCount) goto L26;
            return false;
        L26:
            if (this.lastExecuteTimestamp == r101.lastExecuteTimestamp) goto L43;
            return false;
        L43:
            return true;
        L28:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            String r100 = this.channelName;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.accessKeyOnline;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.accessKeyDebug;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.componentId;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.tileComponentId;
            if (r113 == null) goto L21;
            int r114 = r113.hashCode();
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.tabId;
            if (r116 == null) goto L25;
            r101 = r116.hashCode();
        L25:
            int r117 = (((((r115 + r101) * 31) + this.executeCountLimit) * 31) + this.executeGapDuration) * 31;
            boolean r118 = this.retryEnable;
            ?? r119 = r118;
            if (r118 == false) goto L28;
            r119 = 1;
        L28:
            int r120 = (((r117 + r119) * 31) + this.executeCount) * 31;
            long r121 = this.lastExecuteTimestamp;
            return r120 + ((int) (r121 ^ (r121 >>> 32)));
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
            return "ItemConfig(channelName=" + this.channelName + ", accessKeyOnline=" + this.accessKeyOnline + ", accessKeyDebug=" + this.accessKeyDebug + ", componentId=" + this.componentId + ", tileComponentId=" + this.tileComponentId + ", tabId=" + this.tabId + ", executeCountLimit=" + this.executeCountLimit + ", executeGapDuration=" + this.executeGapDuration + ", retryEnable=" + this.retryEnable + ", executeCount=" + this.executeCount + ", lastExecuteTimestamp=" + this.lastExecuteTimestamp + ")";
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

        public final String getComponentId() {
            return this.componentId;
        }

        public final int getExecuteCount() {
            return this.executeCount;
        }

        public final int getExecuteCountLimit() {
            return this.executeCountLimit;
        }

        public final int getExecuteGapDuration() {
            return this.executeGapDuration;
        }

        public final long getLastExecuteTimestamp() {
            return this.lastExecuteTimestamp;
        }

        public final boolean getRetryEnable() {
            return this.retryEnable;
        }

        public final String getTabId() {
            return this.tabId;
        }

        public final String getTileComponentId() {
            return this.tileComponentId;
        }

        public final void setExecuteCount(int r100) {
            this.executeCount = r100;
        }

        public final void setLastExecuteTimestamp(long r100) {
            this.lastExecuteTimestamp = r100;
        }

        public ItemConfig(String r100, String r101, String r102, String r103, String r104, String r105, int r106, int r107, boolean r108, int r110, long r111) {
            this.channelName = r100;
            this.accessKeyOnline = r101;
            this.accessKeyDebug = r102;
            this.componentId = r103;
            this.tileComponentId = r104;
            this.tabId = r105;
            this.executeCountLimit = r106;
            this.executeGapDuration = r107;
            this.retryEnable = r108;
            this.executeCount = r110;
            this.lastExecuteTimestamp = r111;
        }

        public /* synthetic */ ItemConfig(String r110, String r111, String r112, String r113, String r114, String r115, int r210, int r211, boolean r212, int r213, long r214, int r215, DefaultConstructorMarker r216) {
            String r100 = null;
            if ((r215 & 1) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r215 & 2) == 0) goto L9;
            String r102 = null;
        L11:
            if ((r215 & 4) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r215 & 8) == 0) goto L17;
            String r104 = null;
        L19:
            if ((r215 & 16) == 0) goto L21;
            String r105 = null;
        L23:
            if ((r215 & 32) != 0) goto L26;
            r100 = r115;
        L26:
            int r106 = 0;
            if ((r215 & 64) == 0) goto L29;
            int r107 = 0;
        L31:
            if ((r215 & 128) == 0) goto L33;
            int r108 = 0;
        L35:
            if ((r215 & 256) == 0) goto L37;
            boolean r116 = false;
        L39:
            if ((r215 & 512) != 0) goto L43;
            r106 = r213;
        L43:
            if ((r215 & 1024) == 0) goto L45;
            long r117 = 0;
        L46:
            this(r101, r102, r103, r104, r105, r100, r107, r108, r116, r106, r117);
            return;
        L45:
            r117 = r214;
            goto L46
        L37:
            r116 = r212;
            goto L39
        L33:
            r108 = r211;
            goto L35
        L29:
            r107 = r210;
            goto L31
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

    public ECMallGeckoPreloadConfig() {
    }

    public final boolean getEventExecuteEnable() {
        return this.eventExecuteEnable;
    }

    public final boolean getExposureExecuteEnable() {
        return this.exposureExecuteEnable;
    }

    public final Map<String, ItemConfig> getItemConfigMap() {
        return this.itemConfigMap;
    }
}
