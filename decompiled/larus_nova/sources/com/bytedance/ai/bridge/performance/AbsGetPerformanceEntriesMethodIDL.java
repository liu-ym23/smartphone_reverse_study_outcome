package com.bytedance.ai.bridge.performance;

import com.bytedance.ai.bridge.core.CoreAIBridgeMethod;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamField;
import com.bytedance.ai.bridge.core.annotation.AIBridgeParamModel;
import com.bytedance.ai.bridge.core.annotation.AIBridgeResultModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL;", "Lcom/bytedance/ai/bridge/core/CoreAIBridgeMethod;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesParamModel;", "Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$GetPerformanceEntriesResultModel;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetPerformanceEntriesParamModel", "GetPerformanceEntriesResultModel", "PerformanceEntry", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsGetPerformanceEntriesMethodIDL extends CoreAIBridgeMethod<a, b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36063a;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b.\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00107\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010,JÔ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b!\u0010\u001eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u001a\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b$\u0010\u001eR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b%\u0010\u001eR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b&\u0010\u001eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b(\u0010\u001eR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010-\u001a\u0004\b\u0014\u0010,¨\u0006F"}, d2 = {"Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$PerformanceEntry;", "", "entryType", "", "name", DyPayConstant.KEY_START_TIME, "", "duration", "path", "navigationStart", "navigationType", TextureRenderKeys.KEY_MODULE_NAME, "viewLayerRenderStartTime", "viewLayerRenderEndTime", "pageId", "referrerPath", "referrerPageId", "viewLayerReadyTime", "widgetId", "widgetInstanceId", "isAppColdLaunch", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEntryType", "()Ljava/lang/String;", "getName", "getStartTime", "()J", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPath", "getNavigationStart", "getNavigationType", "getModuleName", "getViewLayerRenderStartTime", "getViewLayerRenderEndTime", "getPageId", "getReferrerPath", "getReferrerPageId", "getViewLayerReadyTime", "getWidgetId", "getWidgetInstanceId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/bridge/performance/AbsGetPerformanceEntriesMethodIDL$PerformanceEntry;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PerformanceEntry {

        @SerializedName("duration")
        private final Long duration;

        @SerializedName("entryType")
        private final String entryType;

        @SerializedName("isAppColdLaunch")
        private final Boolean isAppColdLaunch;

        @SerializedName(TextureRenderKeys.KEY_MODULE_NAME)
        private final String moduleName;

        @SerializedName("name")
        private final String name;

        @SerializedName("navigationStart")
        private final Long navigationStart;

        @SerializedName("navigationType")
        private final String navigationType;

        @SerializedName("pageId")
        private final Long pageId;

        @SerializedName("path")
        private final String path;

        @SerializedName("referrerPageId")
        private final Long referrerPageId;

        @SerializedName("referrerPath")
        private final String referrerPath;

        @SerializedName(DyPayConstant.KEY_START_TIME)
        private final long startTime;

        @SerializedName("viewLayerReadyTime")
        private final Long viewLayerReadyTime;

        @SerializedName("viewLayerRenderEndTime")
        private final Long viewLayerRenderEndTime;

        @SerializedName("viewLayerRenderStartTime")
        private final Long viewLayerRenderStartTime;

        @SerializedName("widgetId")
        private final String widgetId;

        @SerializedName("widgetInstanceId")
        private final String widgetInstanceId;

        public static /* synthetic */ PerformanceEntry copy$default(PerformanceEntry r110, String r111, String r112, long r210, Long r211, String r212, Long r213, String r214, String r215, Long r216, Long r217, Long r218, String r310, Long r311, Long r312, String r313, String r314, Boolean r315, int r316, Object r317) {
            if ((r316 & 1) == 0) goto L5;
            String r100 = r110.entryType;
        L7:
            if ((r316 & 2) == 0) goto L9;
            String r101 = r110.name;
        L11:
            if ((r316 & 4) == 0) goto L13;
            long r102 = r110.startTime;
        L15:
            if ((r316 & 8) == 0) goto L17;
            Long r103 = r110.duration;
        L19:
            if ((r316 & 16) == 0) goto L21;
            String r104 = r110.path;
        L23:
            if ((r316 & 32) == 0) goto L25;
            Long r105 = r110.navigationStart;
        L27:
            if ((r316 & 64) == 0) goto L29;
            String r106 = r110.navigationType;
        L31:
            if ((r316 & 128) == 0) goto L33;
            String r113 = r110.moduleName;
        L35:
            if ((r316 & 256) == 0) goto L37;
            Long r114 = r110.viewLayerRenderStartTime;
        L39:
            if ((r316 & 512) == 0) goto L41;
            Long r115 = r110.viewLayerRenderEndTime;
        L43:
            if ((r316 & 1024) == 0) goto L45;
            Long r116 = r110.pageId;
        L47:
            if ((r316 & 2048) == 0) goto L49;
            String r117 = r110.referrerPath;
        L51:
            if ((r316 & 4096) == 0) goto L53;
            Long r118 = r110.referrerPageId;
        L54:
            Long r318 = r118;
            if ((r316 & 8192) == 0) goto L57;
            Long r119 = r110.viewLayerReadyTime;
        L58:
            Long r319 = r119;
            if ((r316 & 16384) == 0) goto L61;
            String r120 = r110.widgetId;
        L62:
            String r320 = r120;
            if ((r316 & 32768) == 0) goto L65;
            String r121 = r110.widgetInstanceId;
        L67:
            if ((r316 & 65536) == 0) goto L69;
            Boolean r107 = r110.isAppColdLaunch;
        L71:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r318, r319, r320, r121, r107);
        L69:
            r107 = r315;
            goto L71
        L65:
            r121 = r314;
            goto L67
        L61:
            r120 = r313;
            goto L62
        L57:
            r119 = r312;
            goto L58
        L53:
            r118 = r311;
            goto L54
        L49:
            r117 = r310;
            goto L51
        L45:
            r116 = r218;
            goto L47
        L41:
            r115 = r217;
            goto L43
        L37:
            r114 = r216;
            goto L39
        L33:
            r113 = r215;
            goto L35
        L29:
            r106 = r214;
            goto L31
        L25:
            r105 = r213;
            goto L27
        L21:
            r104 = r212;
            goto L23
        L17:
            r103 = r211;
            goto L19
        L13:
            r102 = r210;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.entryType;
        }

        public final Long component10() {
            return this.viewLayerRenderEndTime;
        }

        public final Long component11() {
            return this.pageId;
        }

        public final String component12() {
            return this.referrerPath;
        }

        public final Long component13() {
            return this.referrerPageId;
        }

        public final Long component14() {
            return this.viewLayerReadyTime;
        }

        public final String component15() {
            return this.widgetId;
        }

        public final String component16() {
            return this.widgetInstanceId;
        }

        public final Boolean component17() {
            return this.isAppColdLaunch;
        }

        public final String component2() {
            return this.name;
        }

        public final long component3() {
            return this.startTime;
        }

        public final Long component4() {
            return this.duration;
        }

        public final String component5() {
            return this.path;
        }

        public final Long component6() {
            return this.navigationStart;
        }

        public final String component7() {
            return this.navigationType;
        }

        public final String component8() {
            return this.moduleName;
        }

        public final Long component9() {
            return this.viewLayerRenderStartTime;
        }

        public final PerformanceEntry copy(String r210, String r211, long r212, Long r213, String r214, Long r215, String r216, String r310, Long r311, Long r312, Long r313, String r314, Long r315, Long r316, String r317, String r318, Boolean r319) {
            Intrinsics.checkNotNullParameter(r210, "entryType");
            Intrinsics.checkNotNullParameter(r211, "name");
            return new PerformanceEntry(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof PerformanceEntry) == true) goto L8;
            return false;
        L8:
            PerformanceEntry r101 = (PerformanceEntry) r100;
            if (Intrinsics.areEqual(this.entryType, r101.entryType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
            return false;
        L15:
            if (this.startTime == r101.startTime) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.path, r101.path) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.navigationStart, r101.navigationStart) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.navigationType, r101.navigationType) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.moduleName, r101.moduleName) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.viewLayerRenderStartTime, r101.viewLayerRenderStartTime) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.viewLayerRenderEndTime, r101.viewLayerRenderEndTime) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.referrerPath, r101.referrerPath) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.referrerPageId, r101.referrerPageId) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.viewLayerReadyTime, r101.viewLayerReadyTime) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.widgetId, r101.widgetId) == true) goto L54;
            return false;
        L54:
            if (Intrinsics.areEqual(this.widgetInstanceId, r101.widgetInstanceId) == true) goto L57;
            return false;
        L57:
            if (Intrinsics.areEqual(this.isAppColdLaunch, r101.isAppColdLaunch) == true) goto L59;
            return false;
        L59:
            return true;
        }

        public int hashCode() {
            int r100 = ((this.entryType.hashCode() * 31) + this.name.hashCode()) * 31;
            long r101 = this.startTime;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Long r103 = this.duration;
            int r104 = 0;
            if (r103 != null) goto L5;
            int r105 = 0;
        L6:
            int r106 = (r102 + r105) * 31;
            String r107 = this.path;
            if (r107 != null) goto L9;
            int r108 = 0;
        L10:
            int r109 = (r106 + r108) * 31;
            Long r110 = this.navigationStart;
            if (r110 != null) goto L13;
            int r111 = 0;
        L14:
            int r112 = (r109 + r111) * 31;
            String r113 = this.navigationType;
            if (r113 != null) goto L17;
            int r114 = 0;
        L18:
            int r115 = (r112 + r114) * 31;
            String r116 = this.moduleName;
            if (r116 != null) goto L21;
            int r117 = 0;
        L22:
            int r118 = (r115 + r117) * 31;
            Long r119 = this.viewLayerRenderStartTime;
            if (r119 != null) goto L25;
            int r120 = 0;
        L26:
            int r121 = (r118 + r120) * 31;
            Long r122 = this.viewLayerRenderEndTime;
            if (r122 != null) goto L29;
            int r123 = 0;
        L30:
            int r124 = (r121 + r123) * 31;
            Long r125 = this.pageId;
            if (r125 != null) goto L33;
            int r126 = 0;
        L34:
            int r127 = (r124 + r126) * 31;
            String r128 = this.referrerPath;
            if (r128 != null) goto L37;
            int r129 = 0;
        L38:
            int r130 = (r127 + r129) * 31;
            Long r131 = this.referrerPageId;
            if (r131 != null) goto L41;
            int r132 = 0;
        L42:
            int r133 = (r130 + r132) * 31;
            Long r134 = this.viewLayerReadyTime;
            if (r134 != null) goto L45;
            int r135 = 0;
        L46:
            int r136 = (r133 + r135) * 31;
            String r137 = this.widgetId;
            if (r137 != null) goto L49;
            int r138 = 0;
        L50:
            int r139 = (r136 + r138) * 31;
            String r140 = this.widgetInstanceId;
            if (r140 != null) goto L53;
            int r141 = 0;
        L54:
            int r142 = (r139 + r141) * 31;
            Boolean r143 = this.isAppColdLaunch;
            if (r143 == null) goto L59;
            r104 = r143.hashCode();
        L59:
            return r142 + r104;
        L53:
            r141 = r140.hashCode();
            goto L54
        L49:
            r138 = r137.hashCode();
            goto L50
        L45:
            r135 = r134.hashCode();
            goto L46
        L41:
            r132 = r131.hashCode();
            goto L42
        L37:
            r129 = r128.hashCode();
            goto L38
        L33:
            r126 = r125.hashCode();
            goto L34
        L29:
            r123 = r122.hashCode();
            goto L30
        L25:
            r120 = r119.hashCode();
            goto L26
        L21:
            r117 = r116.hashCode();
            goto L22
        L17:
            r114 = r113.hashCode();
            goto L18
        L13:
            r111 = r110.hashCode();
            goto L14
        L9:
            r108 = r107.hashCode();
            goto L10
        L5:
            r105 = r103.hashCode();
            goto L6
        }

        public String toString() {
            return "PerformanceEntry(entryType=" + this.entryType + ", name=" + this.name + ", startTime=" + this.startTime + ", duration=" + this.duration + ", path=" + this.path + ", navigationStart=" + this.navigationStart + ", navigationType=" + this.navigationType + ", moduleName=" + this.moduleName + ", viewLayerRenderStartTime=" + this.viewLayerRenderStartTime + ", viewLayerRenderEndTime=" + this.viewLayerRenderEndTime + ", pageId=" + this.pageId + ", referrerPath=" + this.referrerPath + ", referrerPageId=" + this.referrerPageId + ", viewLayerReadyTime=" + this.viewLayerReadyTime + ", widgetId=" + this.widgetId + ", widgetInstanceId=" + this.widgetInstanceId + ", isAppColdLaunch=" + this.isAppColdLaunch + ')';
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getEntryType() {
            return this.entryType;
        }

        public final String getModuleName() {
            return this.moduleName;
        }

        public final String getName() {
            return this.name;
        }

        public final Long getNavigationStart() {
            return this.navigationStart;
        }

        public final String getNavigationType() {
            return this.navigationType;
        }

        public final Long getPageId() {
            return this.pageId;
        }

        public final String getPath() {
            return this.path;
        }

        public final Long getReferrerPageId() {
            return this.referrerPageId;
        }

        public final String getReferrerPath() {
            return this.referrerPath;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        public final Long getViewLayerReadyTime() {
            return this.viewLayerReadyTime;
        }

        public final Long getViewLayerRenderEndTime() {
            return this.viewLayerRenderEndTime;
        }

        public final Long getViewLayerRenderStartTime() {
            return this.viewLayerRenderStartTime;
        }

        public final String getWidgetId() {
            return this.widgetId;
        }

        public final String getWidgetInstanceId() {
            return this.widgetInstanceId;
        }

        public final Boolean isAppColdLaunch() {
            return this.isAppColdLaunch;
        }

        public PerformanceEntry(String r100, String r101, long r102, Long r103, String r110, Long r111, String r112, String r113, Long r114, Long r115, Long r116, String r117, Long r118, Long r119, String r210, String r211, Boolean r212) {
            Intrinsics.checkNotNullParameter(r100, "entryType");
            Intrinsics.checkNotNullParameter(r101, "name");
            this.entryType = r100;
            this.name = r101;
            this.startTime = r102;
            this.duration = r103;
            this.path = r110;
            this.navigationStart = r111;
            this.navigationType = r112;
            this.moduleName = r113;
            this.viewLayerRenderStartTime = r114;
            this.viewLayerRenderEndTime = r115;
            this.pageId = r116;
            this.referrerPath = r117;
            this.referrerPageId = r118;
            this.viewLayerReadyTime = r119;
            this.widgetId = r210;
            this.widgetInstanceId = r211;
            this.isAppColdLaunch = r212;
        }

        public /* synthetic */ PerformanceEntry(String r210, String r211, long r212, Long r213, String r214, Long r215, String r310, String r311, Long r312, Long r313, Long r314, String r315, Long r316, Long r317, String r318, String r319, Boolean r410, int r411, DefaultConstructorMarker r412) {
            if ((r411 & 8) == 0) goto L5;
            Long r100 = null;
        L7:
            if ((r411 & 16) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r411 & 32) == 0) goto L13;
            Long r110 = null;
        L15:
            if ((r411 & 64) == 0) goto L17;
            String r111 = null;
        L19:
            if ((r411 & 128) == 0) goto L21;
            String r112 = null;
        L23:
            if ((r411 & 256) == 0) goto L25;
            Long r113 = null;
        L27:
            if ((r411 & 512) == 0) goto L29;
            Long r114 = null;
        L31:
            if ((r411 & 1024) == 0) goto L33;
            Long r115 = null;
        L35:
            if ((r411 & 2048) == 0) goto L37;
            String r116 = null;
        L39:
            if ((r411 & 4096) == 0) goto L41;
            Long r117 = null;
        L43:
            if ((r411 & 8192) == 0) goto L45;
            Long r118 = null;
        L47:
            if ((r411 & 16384) == 0) goto L49;
            String r119 = null;
        L51:
            if ((32768 & r411) == 0) goto L53;
            String r216 = null;
        L55:
            if ((r411 & 65536) == 0) goto L57;
            Boolean r217 = null;
        L58:
            this(r210, r211, r212, r100, r101, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r216, r217);
            return;
        L57:
            r217 = r410;
            goto L58
        L53:
            r216 = r319;
            goto L55
        L49:
            r119 = r318;
            goto L51
        L45:
            r118 = r317;
            goto L47
        L41:
            r117 = r316;
            goto L43
        L37:
            r116 = r315;
            goto L39
        L33:
            r115 = r314;
            goto L35
        L29:
            r114 = r313;
            goto L31
        L25:
            r113 = r312;
            goto L27
        L21:
            r112 = r311;
            goto L23
        L17:
            r111 = r310;
            goto L19
        L13:
            r110 = r215;
            goto L15
        L9:
            r101 = r214;
            goto L11
        L5:
            r100 = r213;
            goto L7
        }
    }

    @AIBridgeParamModel
    public interface a extends ParamModel {
        @AIBridgeParamField(keyPath = "entryType", required = false)
        String getEntryType();

        @AIBridgeParamField(keyPath = "name", required = false)
        String getName();
    }

    @AIBridgeResultModel
    public interface b extends ResultModel {
        @AIBridgeParamField(keyPath = "entries", required = true)
        void setEntries(List<PerformanceEntry> r100);
    }

    public AbsGetPerformanceEntriesMethodIDL() {
        this.f36063a = "doubao.getPerformanceEntries";
    }

    @Override // com.bytedance.ai.bridge.core.AIBridgeMethod
    public final String getName() {
        return this.f36063a;
    }
}
