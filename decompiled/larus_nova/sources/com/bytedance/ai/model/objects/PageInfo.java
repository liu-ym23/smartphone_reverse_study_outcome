package com.bytedance.ai.model.objects;

import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.ai.utils.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.utils.statistics.PerfLog;
import f2.b;
import h2.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010?\u001a\u00020\u0003H\u0016J\u0006\u0010@\u001a\u00020\u0003J\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030BJ\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000fHÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010T\u001a\u00020\u00112\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020WHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001b\"\u0004\b'\u0010\u001eR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010 \"\u0004\b)\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001eR\u001a\u0010<\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00100\"\u0004\b=\u0010>¨\u0006X"}, d2 = {"Lcom/bytedance/ai/model/objects/PageInfo;", "", "pageName", "", "pageData", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "pageUrl", "pageType", "Lcom/bytedance/ai/model/objects/PageType;", "botId", "pageId", "pageSettings", "messageId", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "alignLeft", "", "replyFor", "traceInfo", "", "packageName", "mcpName", "fullScreenRefresh", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;Lcom/bytedance/ai/model/objects/PageType;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;Ljava/lang/String;DZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPageName", "()Ljava/lang/String;", "getPageData", "setPageData", "(Ljava/lang/String;)V", "getContext", "()Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;", "getPageUrl", "setPageUrl", "getPageType", "()Lcom/bytedance/ai/model/objects/PageType;", "getBotId", "getPageId", "setPageId", "getPageSettings", "setPageSettings", "(Lcom/bytedance/vmsdk/jsbridge/utils/ReadableMap;)V", "getMessageId", "setMessageId", "getPos", "()D", "getAlignLeft", "()Z", "getReplyFor", "getTraceInfo", "()Ljava/util/Map;", "setTraceInfo", "(Ljava/util/Map;)V", "getPackageName", "setPackageName", "getMcpName", "setMcpName", "getFullScreenRefresh", "setFullScreenRefresh", "isWidget", "setWidget", "(Z)V", "toString", "toViewContext", "buildMonitorEvent", "Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PageInfo {
    private final boolean alignLeft;
    private final String botId;
    private final ReadableMap context;
    private String fullScreenRefresh;
    private boolean isWidget;
    private String mcpName;
    private String messageId;
    private String packageName;
    private String pageData;
    private String pageId;
    private final String pageName;
    private ReadableMap pageSettings;
    private final PageType pageType;
    private String pageUrl;
    private final double pos;
    private final String replyFor;
    private Map<String, Object> traceInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageInfo copy$default(PageInfo r110, String r111, String r112, ReadableMap r210, String r211, PageType r212, String r213, String r214, ReadableMap r215, String r216, double r217, boolean r218, String r310, Map r311, String r312, String r313, String r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.pageName;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.pageData;
    L11:
        if ((r315 & 4) == 0) goto L13;
        ReadableMap r102 = r110.context;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.pageUrl;
    L19:
        if ((r315 & 16) == 0) goto L21;
        PageType r104 = r110.pageType;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.botId;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.pageId;
    L31:
        if ((r315 & 128) == 0) goto L33;
        ReadableMap r107 = r110.pageSettings;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.messageId;
    L39:
        if ((r315 & 512) == 0) goto L41;
        double r114 = r110.pos;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        boolean r115 = r110.alignLeft;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r110.replyFor;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Map r117 = r110.traceInfo;
    L54:
        Map r317 = r117;
        if ((r315 & 8192) == 0) goto L57;
        String r118 = r110.packageName;
    L58:
        String r318 = r118;
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r110.mcpName;
    L63:
        if ((r315 & 32768) == 0) goto L65;
        String r108 = r110.fullScreenRefresh;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r317, r318, r119, r108);
    L65:
        r108 = r314;
        goto L67
    L61:
        r119 = r313;
        goto L63
    L57:
        r118 = r312;
        goto L58
    L53:
        r117 = r311;
        goto L54
    L49:
        r116 = r310;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
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
        return this.pageName;
    }

    public final double component10() {
        return this.pos;
    }

    public final boolean component11() {
        return this.alignLeft;
    }

    public final String component12() {
        return this.replyFor;
    }

    public final Map<String, Object> component13() {
        return this.traceInfo;
    }

    public final String component14() {
        return this.packageName;
    }

    public final String component15() {
        return this.mcpName;
    }

    public final String component16() {
        return this.fullScreenRefresh;
    }

    public final String component2() {
        return this.pageData;
    }

    public final ReadableMap component3() {
        return this.context;
    }

    public final String component4() {
        return this.pageUrl;
    }

    public final PageType component5() {
        return this.pageType;
    }

    public final String component6() {
        return this.botId;
    }

    public final String component7() {
        return this.pageId;
    }

    public final ReadableMap component8() {
        return this.pageSettings;
    }

    public final String component9() {
        return this.messageId;
    }

    public final PageInfo copy(String r210, String r211, ReadableMap r212, String r213, PageType r214, String r215, String r216, ReadableMap r217, String r218, double r219, boolean r310, String r311, Map<String, Object> r312, String r313, String r314, String r315) {
        Intrinsics.checkNotNullParameter(r214, "pageType");
        Intrinsics.checkNotNullParameter(r215, "botId");
        Intrinsics.checkNotNullParameter(r216, "pageId");
        Intrinsics.checkNotNullParameter(r313, "packageName");
        return new PageInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PageInfo) == true) goto L8;
        return false;
    L8:
        PageInfo r101 = (PageInfo) r100;
        if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageData, r101.pageData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pageUrl, r101.pageUrl) == true) goto L21;
        return false;
    L21:
        if (this.pageType == r101.pageType) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.pageSettings, r101.pageSettings) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L36;
        return false;
    L36:
        if (Double.compare(this.pos, r101.pos) == 0) goto L39;
        return false;
    L39:
        if (this.alignLeft == r101.alignLeft) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.replyFor, r101.replyFor) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.traceInfo, r101.traceInfo) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.mcpName, r101.mcpName) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.fullScreenRefresh, r101.fullScreenRefresh) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        String r100 = this.pageName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ReadableMap r107 = this.context;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.pageUrl;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((((((r109 + r111) * 31) + this.pageType.hashCode()) * 31) + this.botId.hashCode()) * 31) + this.pageId.hashCode()) * 31;
        ReadableMap r113 = this.pageSettings;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.messageId;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = Double.doubleToLongBits(this.pos);
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        if (this.alignLeft == false) goto L29;
        int r121 = 1231;
    L30:
        int r122 = (r120 + r121) * 31;
        String r123 = this.replyFor;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        Map<String, Object> r126 = this.traceInfo;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (((r125 + r127) * 31) + this.packageName.hashCode()) * 31;
        String r129 = this.mcpName;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        String r132 = this.fullScreenRefresh;
        if (r132 == null) goto L47;
        r101 = r132.hashCode();
    L47:
        return r131 + r101;
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = 1237;
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toViewContext() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        ReadableMap r102 = this.context;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        HashMap<String, Object> r103 = r102.toHashMap();     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L14;
        r104 = null;
    L14:
        HashMap r105 = (HashMap) r104;
        if (r105 != null) goto L18;
        r105 = new HashMap();
    L18:
        if (this.pageId.length() <= 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        r105.put("viewId", this.pageId);
    L24:
        if (f.g(this.pageName) == false) goto L27;
        r105.put("pageName", this.pageName);
    L27:
        if (f.g(this.botId) == false) goto L30;
        r105.put("botId", this.botId);
    L30:
        if (f.g(this.messageId) == false) goto L33;
        r105.put(RemoteMessageConst.MSGID, this.messageId);
    L33:
        if (f.g(this.replyFor) == false) goto L36;
        r105.put("replyFor", this.replyFor);
    L36:
        if (f.g(this.pageUrl) == false) goto L39;
        r105.put("pageUrl", this.pageUrl);
    L39:
        if (f.g(this.mcpName) == false) goto L41;
        r105.put("mcpName", this.mcpName);
    L41:
        ReadableMap r107 = this.pageSettings;
        if (r107 == null) goto L48;
        HashMap<String, Object> r108 = r107.toHashMap();
        if (r108 == null) goto L48;
        if ((true ^ r108.isEmpty()) == false) goto L48;
        r105.putAll(r108);
    L48:
        a r109 = b.f475099c;
        if (r109 == null) goto L52;
        String r110 = r109.f483579r;
        if (r110 == null) goto L52;
    L53:
        r105.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r110);
        Object r111 = Result.m9449constructorimpl(e.c(r105));     // Catch: Throwable -> L56
    L59:
        if (Result.m9455isFailureimpl(r111) == true) goto L62;
        r100 = r111;
    L62:
        String r112 = (String) r100;
        if (r112 != null) goto L70;
        return "";
    L70:
        return r112;
    L56:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L52:
        r110 = "zh";
        goto L53
    L20:
        r106 = false;
        goto L21
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final HashMap<String, String> buildMonitorEvent() {
        HashMap<String, String> r100 = new HashMap();
        String r101 = this.messageId;
        if (r101 != null) goto L5;
    L10:
        r100.put("botId", this.botId);
        r100.put("viewType", this.pageType.toString());
        String r102 = this.pageName;
        if (r102 == null) goto L13;
        String r103 = r100.put("pagePath", r102);
    L13:
        return r100;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        r100.put(MusicAppletPage.KEY_MESSAGE_ID, r101);
        goto L10
    L7:
        r104 = false;
        goto L8
    }

    public String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(e.c(this));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r101) == false) goto L9;
        r101 = null;
    L9:
        String r102 = (String) r101;
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean getAlignLeft() {
        return this.alignLeft;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final ReadableMap getContext() {
        return this.context;
    }

    public final String getFullScreenRefresh() {
        return this.fullScreenRefresh;
    }

    public final String getMcpName() {
        return this.mcpName;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPageData() {
        return this.pageData;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final ReadableMap getPageSettings() {
        return this.pageSettings;
    }

    public final PageType getPageType() {
        return this.pageType;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final double getPos() {
        return this.pos;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final Map<String, Object> getTraceInfo() {
        return this.traceInfo;
    }

    public final boolean isWidget() {
        return this.isWidget;
    }

    public final void setFullScreenRefresh(String r100) {
        this.fullScreenRefresh = r100;
    }

    public final void setMcpName(String r100) {
        this.mcpName = r100;
    }

    public final void setMessageId(String r100) {
        this.messageId = r100;
    }

    public final void setPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.packageName = r100;
    }

    public final void setPageData(String r100) {
        this.pageData = r100;
    }

    public final void setPageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageId = r100;
    }

    public final void setPageSettings(ReadableMap r100) {
        this.pageSettings = r100;
    }

    public final void setPageUrl(String r100) {
        this.pageUrl = r100;
    }

    public final void setTraceInfo(Map<String, Object> r100) {
        this.traceInfo = r100;
    }

    public final void setWidget(boolean r100) {
        this.isWidget = r100;
    }

    public PageInfo(String r100, String r101, ReadableMap r102, String r110, PageType r111, String r112, String r113, ReadableMap r114, String r115, double r116, boolean r117, String r118, Map<String, Object> r210, String r211, String r212, String r213) {
        Intrinsics.checkNotNullParameter(r111, "pageType");
        Intrinsics.checkNotNullParameter(r112, "botId");
        Intrinsics.checkNotNullParameter(r113, "pageId");
        Intrinsics.checkNotNullParameter(r211, "packageName");
        this.pageName = r100;
        this.pageData = r101;
        this.context = r102;
        this.pageUrl = r110;
        this.pageType = r111;
        this.botId = r112;
        this.pageId = r113;
        this.pageSettings = r114;
        this.messageId = r115;
        this.pos = r116;
        this.alignLeft = r117;
        this.replyFor = r118;
        this.traceInfo = r210;
        this.packageName = r211;
        this.mcpName = r212;
        this.fullScreenRefresh = r213;
    }

    public /* synthetic */ PageInfo(String r210, String r211, ReadableMap r212, String r213, PageType r214, String r215, String r216, ReadableMap r217, String r310, double r311, boolean r312, String r313, Map r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r410) {
        if ((r318 & 64) == 0) goto L5;
        String r110 = "";
    L7:
        if ((r318 & 128) == 0) goto L9;
        ReadableMap r111 = null;
    L11:
        if ((r318 & 256) == 0) goto L13;
        String r112 = "";
    L15:
        if ((r318 & 512) == 0) goto L17;
        double r113 = 0.5d;
    L19:
        if ((r318 & 1024) == 0) goto L21;
        boolean r114 = false;
    L23:
        if ((r318 & 2048) == 0) goto L25;
        String r115 = null;
    L27:
        if ((r318 & 4096) == 0) goto L29;
        Map r116 = null;
    L31:
        if ((r318 & 8192) == 0) goto L33;
        String r117 = "";
    L35:
        if ((r318 & 16384) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r318 & 32768) == 0) goto L41;
        String r218 = null;
    L42:
        this(r210, r211, r212, r213, r214, r215, r110, r111, r112, r113, r114, r115, r116, r117, r118, r218);
        return;
    L41:
        r218 = r317;
        goto L42
    L37:
        r118 = r316;
        goto L39
    L33:
        r117 = r315;
        goto L35
    L29:
        r116 = r314;
        goto L31
    L25:
        r115 = r313;
        goto L27
    L21:
        r114 = r312;
        goto L23
    L17:
        r113 = r311;
        goto L19
    L13:
        r112 = r310;
        goto L15
    L9:
        r111 = r217;
        goto L11
    L5:
        r110 = r216;
        goto L7
    }
}
