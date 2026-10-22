package com.obric.autogui.agents.vlm.models.omni.intent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.agents.vlm.models.omni.l;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.agents.vlm.models.omni.t;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentApi;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.HostAppInfo;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.model.IAutoActionLocalModelProvider;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.intent.BaseGUIINITIntent;
import com.obric.capabilitykit.common.intent.GUIINITParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import d.n;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniGUIInitIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OmniGUIInitIntent extends BaseGUIINITIntent {
    public static final a Companion = null;
    private static final String KEY_INSTRUCTION_ID = "instruction_id";
    private static final String KEY_OMNI_TASK_ID = "o_omni_task_id";
    private static final String TAG = "OmniGUIInitIntent";

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    public static final class IntentExtras {

        @SerializedName("allow_user_interaction")
        private final Boolean allowUserInteraction;

        @SerializedName("caller_source")
        private final String callerSource;

        @SerializedName("hard_blacklist")
        private final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> hardBlackList;

        @SerializedName("log_id")
        private final String logId;

        @SerializedName("mode")
        private final Integer mode;

        @SerializedName(DownloadConstants.QUERY_KEY)
        private final String query;

        @SerializedName("soft_blacklist")
        private final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> softBlackList;

        @SerializedName("start_in_place")
        private final Boolean startInPlace;

        @SerializedName("whitelist")
        private final List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> whiteList;

        public static /* synthetic */ IntentExtras copy$default(IntentExtras r10, String r11, List r12, List r13, Integer r14, List r15, String r16, String r17, Boolean r18, Boolean r19, int r20, Object r21) {
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.aiagent.plugin");
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            if ((r20 & 1) == 0) goto L5;
            String r5 = r10.logId;
        L7:
            if ((r20 & 2) == 0) goto L10;
            r2 = r10.hardBlackList;
        L10:
            if ((r20 & 4) == 0) goto L13;
            r4 = r10.softBlackList;
        L13:
            if ((r20 & 8) == 0) goto L15;
            Integer r6 = r10.mode;
        L17:
            if ((r20 & 16) == 0) goto L20;
            r3 = r10.whiteList;
        L20:
            if ((r20 & 32) == 0) goto L22;
            String r7 = r10.query;
        L24:
            if ((r20 & 64) == 0) goto L26;
            String r8 = r10.callerSource;
        L28:
            if ((r20 & 128) == 0) goto L30;
            Boolean r9 = r10.allowUserInteraction;
        L32:
            if ((r20 & 256) == 0) goto L34;
            Boolean r1 = r10.startInPlace;
        L36:
            return r10.copy(r5, r2, r4, r6, r3, r7, r8, r9, r1);
        L34:
            r1 = r19;
            goto L36
        L30:
            r9 = r18;
            goto L32
        L26:
            r8 = r17;
            goto L28
        L22:
            r7 = r16;
            goto L24
        L15:
            r6 = r14;
            goto L17
        L5:
            r5 = r11;
            goto L7
        }

        public final String component1() {
            return this.logId;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> component2() {
            return this.hardBlackList;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> component3() {
            return this.softBlackList;
        }

        public final Integer component4() {
            return this.mode;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> component5() {
            return this.whiteList;
        }

        public final String component6() {
            return this.query;
        }

        public final String component7() {
            return this.callerSource;
        }

        public final Boolean component8() {
            return this.allowUserInteraction;
        }

        public final Boolean component9() {
            return this.startInPlace;
        }

        public final IntentExtras copy(String r13, List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r14, List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r15, Integer r16, List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r17, String r18, String r19, Boolean r20, Boolean r21) {
            return new IntentExtras(r13, (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin"), r16, (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin"), r18, r19, r20, r21);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, IntentExtras.class) == true) goto L8;
            return false;
        L8:
            IntentExtras r6 = (IntentExtras) ZeusTransformUtils.preCheckCast(r5, IntentExtras.class, "com.obric.aiagent.plugin");
            if (o.a(this.logId, r6.logId) == true) goto L12;
            return false;
        L12:
            if (o.a(this.hardBlackList, r6.hardBlackList) == true) goto L15;
            return false;
        L15:
            if (o.a(this.softBlackList, r6.softBlackList) == true) goto L18;
            return false;
        L18:
            if (o.a(this.mode, r6.mode) == true) goto L21;
            return false;
        L21:
            if (o.a(this.whiteList, r6.whiteList) == true) goto L24;
            return false;
        L24:
            if (o.a(this.query, r6.query) == true) goto L27;
            return false;
        L27:
            if (o.a(this.callerSource, r6.callerSource) == true) goto L30;
            return false;
        L30:
            if (o.a(this.allowUserInteraction, r6.allowUserInteraction) == true) goto L33;
            return false;
        L33:
            if (o.a(this.startInPlace, r6.startInPlace) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            String r0 = this.logId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r4 = this.hardBlackList;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r7 = this.softBlackList;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.mode;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r13 = this.whiteList;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.query;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.callerSource;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            Boolean r22 = this.allowUserInteraction;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            Boolean r25 = this.startInPlace;
            if (r25 == null) goto L39;
            r1 = r25.hashCode();
        L39:
            return r24 + r1;
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "IntentExtras(logId=" + this.logId + ", hardBlackList=" + this.hardBlackList + ", softBlackList=" + this.softBlackList + ", mode=" + this.mode + ", whiteList=" + this.whiteList + ", query=" + this.query + ", callerSource=" + this.callerSource + ", allowUserInteraction=" + this.allowUserInteraction + ", startInPlace=" + this.startInPlace + ')';
        }

        public IntentExtras(String r3, List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r4, List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r5, Integer r6, List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r7, String r8, String r9, Boolean r10, Boolean r11) {
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            this.logId = r3;
            this.hardBlackList = r12;
            this.softBlackList = r13;
            this.mode = r6;
            this.whiteList = r14;
            this.query = r8;
            this.callerSource = r9;
            this.allowUserInteraction = r10;
            this.startInPlace = r11;
        }

        public final String getLogId() {
            return this.logId;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> getHardBlackList() {
            return this.hardBlackList;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> getSoftBlackList() {
            return this.softBlackList;
        }

        public final Integer getMode() {
            return this.mode;
        }

        public final List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> getWhiteList() {
            return this.whiteList;
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getCallerSource() {
            return this.callerSource;
        }

        public final Boolean getAllowUserInteraction() {
            return this.allowUserInteraction;
        }

        public final Boolean getStartInPlace() {
            return this.startInPlace;
        }
    }

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    @d.c.b.a.f(b = "OmniGUIInitIntent.kt", c = {319, 334}, d = "createOrActivateSession", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28354c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28355d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28356e;
        /* synthetic */ Object f;
        final /* synthetic */ OmniGUIInitIntent g;
        int h;

        b(OmniGUIInitIntent r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            this.f = r9;
            this.h |= Integer.MIN_VALUE;
            return OmniGUIInitIntent.access$createOrActivateSession(this.g, null, null, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    @d.c.b.a.f(b = "OmniGUIInitIntent.kt", c = {342}, d = "createSessionFallback", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f28357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OmniGUIInitIntent f28358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f28359c;

        c(OmniGUIInitIntent r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f28358b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f28357a = r3;
            this.f28359c |= Integer.MIN_VALUE;
            return OmniGUIInitIntent.access$createSessionFallback(this.f28358b, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    @d.c.b.a.f(b = "OmniGUIInitIntent.kt", c = {126, 169}, d = "doAction", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28361b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28362c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28363d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28364e;
        /* synthetic */ Object f;
        final /* synthetic */ OmniGUIInitIntent g;
        int h;

        d(OmniGUIInitIntent r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f = r3;
            this.h |= Integer.MIN_VALUE;
            return this.g.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: OmniGUIInitIntent.kt */
    @d.c.b.a.f(b = "OmniGUIInitIntent.kt", c = {215, 241}, d = "terminateCurrentSessionBeforeInit", e = "com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f28365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f28366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f28367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f28368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f28369e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ OmniGUIInitIntent h;
        int i;

        e(OmniGUIInitIntent r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.h = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            this.g = r7;
            this.i |= Integer.MIN_VALUE;
            return OmniGUIInitIntent.access$terminateCurrentSessionBeforeInit(this.h, null, null, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$EZ4-QKJOO8dhPQPsER18F2MC_iM, reason: not valid java name */
    public static /* synthetic */ x m776lambda$EZ4QKJOO8dhPQPsER18F2MC_iM(com.obric.autogui.common.e r0, JSONObject r1) {
        return terminateCurrentSessionBeforeInit$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Gr12M2daD3_BNGd7PnWXaDg-DGo, reason: not valid java name */
    public static /* synthetic */ x m777lambda$Gr12M2daD3_BNGd7PnWXaDgDGo(JSONObject r0) {
        return reportGuiInitSessionMismatch$lambda$14(r0);
    }

    public static /* synthetic */ x lambda$uHl1kgt9BF0u9t6BeVG4mhNwpTA(com.obric.autogui.common.e r0, com.obric.autogui.session.a r1, JSONObject r2) {
        return terminateCurrentSessionBeforeInit$lambda$12(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$vJazFdc9-9OdgwbdsCpCvErV8gE, reason: not valid java name */
    public static /* synthetic */ x m778lambda$vJazFdc99OdgwbdsCpCvErV8gE(com.obric.autogui.common.e r0, boolean r1, JSONObject r2) {
        return terminateCurrentSessionBeforeInit$lambda$13(r0, r1, r2);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIINITIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public boolean isBlock() {
        return true;
    }

    public OmniGUIInitIntent() {
    }

    public static final /* synthetic */ Object access$createOrActivateSession(OmniGUIInitIntent r8, String r9, String r10, Long r11, String r12, Boolean r13, Boolean r14, d.c.d r15) {
        return r8.createOrActivateSession(r9, r10, r11, r12, r13, r14, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$createSessionFallback(OmniGUIInitIntent r2, String r3, Bundle r4, d.c.d r5) {
        return r2.createSessionFallback(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$terminateCurrentSessionBeforeInit(OmniGUIInitIntent r6, com.obric.autogui.session.a r7, String r8, Long r9, String r10, d.c.d r11) {
        return r6.terminateCurrentSessionBeforeInit(r7, r8, r9, r10, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.capabilitykit.common.intent.BaseGUIINITIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Bitmap>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Bitmap>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((GUIINITParams) ZeusTransformUtils.preCheckCast(r6, GUIINITParams.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46, types: [com.obric.autogui.agents.vlm.models.omni.t] */
    /* JADX WARN: Type inference failed for: r0v56, types: [com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v5, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r16v4, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v69, types: [com.obric.autogui.agents.vlm.models.omni.r, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.obric.autogui.agents.vlm.models.omni.r] */
    /* JADX WARN: Type inference failed for: r1v71, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v77 */
    /* JADX WARN: Type inference failed for: r1v78 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r1v91 */
    /* JADX WARN: Type inference failed for: r1v92 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v31, types: [com.obric.autogui.agents.vlm.models.omni.intent.OmniGUIInitIntent, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.capabilitykit.common.intent.BaseGUIINITIntent
    public Object doAction(GUIINITParams r34, DispatchContext r35, d.c.d<? super IntentResult<Bitmap>> r36) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r36, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L7;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        if ((r1.h & Integer.MIN_VALUE) == 0) goto L7;
        r1.h -= Integer.MIN_VALUE;
    L8:
        d r15 = r1;
        Object r2 = r15.f;
        Object r14 = d.c.a.b.a();
        ?? r3 = r15.h;
        String r11 = "";
        ?? r4 = 1;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 != 2) goto L18;
        r r5 = (r) ZeusTransformUtils.preCheckCast(r15.f28361b, r.class, "com.obric.aiagent.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r15.f28360a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r2);     // Catch: Throwable -> L15
        String r7 = TAG;
        boolean r8 = false;
        r3 = r5;
        r4 = r6;
    L153:
        Object r9 = n.f(d.c.b.a.b.a(((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue()));     // Catch: Throwable -> L155
        ?? r10 = r3;
        ?? r12 = r4;
    L157:
        Throwable r13 = n.c(r9);
        if (r13 == null) goto L160;
        r10.j();
        Loog.INSTANCE.e(r7, "createOrActivateSession exception", r13);
    L160:
        Boolean r16 = d.c.b.a.b.a(r8);
        if (n.b(r9) == false) goto L164;
        r9 = r16;
    L164:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L168;
        r10.d().b();
        r10.j();
        Loog.INSTANCE.e(r7, "postUserQuery failed, fallback to gui_action path");
        return new IntentResult(-2, null, null, "VD creation failed", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L168:
        if (r10.h() == false) goto L171;
        Loog.INSTANCE.i(r7, "GUI_INIT session closed during creation: " + r12);
        return new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.a(), null, null, com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L171:
        IntentResult r17 = new IntentResult(0, null, null, "VD created, waiting for session notify", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
        r17.setFinal(r8);
        return r17;
    L155:
        th = th;
    L156:
        n.a r18 = n.f38560a;
        r9 = n.f(d.o.a(th));
        r10 = r3;
        r12 = r4;
        goto L157
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        String r19 = (String) ZeusTransformUtils.preCheckCast(r15.f28364e, String.class, "com.obric.aiagent.plugin");
        String r20 = (String) ZeusTransformUtils.preCheckCast(r15.f28363d, String.class, "com.obric.aiagent.plugin");
        IntentExtras r21 = (IntentExtras) ZeusTransformUtils.preCheckCast(r15.f28362c, IntentExtras.class, "com.obric.aiagent.plugin");
        DispatchContext r22 = (DispatchContext) ZeusTransformUtils.preCheckCast(r15.f28361b, DispatchContext.class, "com.obric.aiagent.plugin");
        OmniGUIInitIntent r23 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r15.f28360a, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r2);
        String r110 = null;
        String r24 = r20;
        OmniGUIInitIntent r25 = r23;
    L106:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L108;
        String r26 = r19;
        r4 = r24;
        ?? r27 = r25;
    L111:
        com.obric.autogui.agents.vlm.models.omni.intent.a.a(ObricProductSdk.INSTANCE);
        r3 = t.f28523a.a(r4, r26);
        if (r26 == null) goto L115;
        r3.a(r26);
    L115:
        if (r21 == null) goto L117;
        String r28 = r21.getQuery();
    L118:
        if (r28 != null) goto L121;
        r28 = "";
    L121:
        if (r3.c(new l(r27.buildGUIInitRequest(r4, r28, r22), r22, true, null, 8, null)) == true) goto L178;
        Loog.INSTANCE.i(TAG, "GUI_INIT lost race with session close: " + r4);
        return new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.a(), null, null, com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L178:
        n.a r29 = n.f38560a;     // Catch: Throwable -> L126
        OmniGUIInitIntent r30 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r27, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L126
        r3.d().a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r21.getQuery());     // Catch: Throwable -> L126
        Object r31 = n.f(x.f38692a);     // Catch: Throwable -> L126
    L128:
        Throwable r32 = n.c(r31);
        if (r32 == null) goto L131;
        Loog.INSTANCE.e(TAG, "first-App prewarm binding failed; ignored", r32);
    L131:
        n.a r33 = n.f38560a;     // Catch: Throwable -> L15
        ?? r37 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r27, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r21 == null) goto L134;
        String r38 = r21.getQuery();     // Catch: Throwable -> L15
    L135:
        if (r38 == null) goto L138;
        r11 = r38;
    L138:
        Long r111 = r22.getQuestionId();     // Catch: Throwable -> L15
        if (r21 == null) goto L141;
        String r39 = r21.getCallerSource();     // Catch: Throwable -> L15
    L142:
        if (r21 == null) goto L144;
        Object r40 = r21.getAllowUserInteraction();     // Catch: Throwable -> L15
    L145:
        if (r21 == null) goto L147;
        Object r41 = r21.getStartInPlace();     // Catch: Throwable -> L15
    L148:
        r15.f28360a = r4;     // Catch: Throwable -> L15
        r15.f28361b = r3;     // Catch: Throwable -> L15
        r15.f28362c = r110;     // Catch: Throwable -> L15
        r15.f28363d = r110;     // Catch: Throwable -> L15
        r15.f28364e = r110;     // Catch: Throwable -> L15
        r15.h = 2;     // Catch: Throwable -> L15
        r7 = TAG;
        r8 = false;
        r2 = r37.createOrActivateSession(r11, r4, r111, r39, r40, r41, r15);     // Catch: Throwable -> L155
        r3 = r3;
        r4 = r4;
        if (r2 != r14) goto L153;
        return r14;
    L147:
        r41 = r110;
        goto L148
    L144:
        r40 = r110;
        goto L145
    L141:
        r39 = r110;
        goto L142
    L134:
        r38 = r110;
    L126:
        th = move-exception;
        n.a r42 = n.f38560a;
        r31 = n.f(d.o.a(th));
        goto L128
    L117:
        r28 = r110;
        goto L118
    L108:
        return new IntentResult(-2, null, null, "ongoing session not released", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L20:
        d.o.a(r2);
        Loog.INSTANCE.i(TAG, "doAction: params=" + r34);
        IAutoActionAgentApi.IMPL.initLib();
        initAIKernelIfOautoModelPreinstalled();
        n.a r43 = n.f38560a;     // Catch: Throwable -> L29
        OmniGUIInitIntent r44 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        Gson r45 = com.obric.eventkit.eventstaskmanager.b.a();     // Catch: Throwable -> L29
        String r46 = r34.getExt();     // Catch: Throwable -> L29
        if (r46 != null) goto L24;
        r46 = "";
    L24:
        CharSequence r47 = (CharSequence) ZeusTransformUtils.preCheckCast(r46, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        if (d.o.o.d(r47) == false) goto L27;
        r47 = "{}";
    L27:
        Object r48 = n.f((IntentExtras) ZeusTransformUtils.preCheckCast(r45.fromJson((String) ZeusTransformUtils.preCheckCast(r47, String.class, "com.obric.aiagent.plugin"), IntentExtras.class), IntentExtras.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L29
    L32:
        if (n.b(r48) == false) goto L34;
        r48 = null;
    L34:
        IntentExtras r49 = (IntentExtras) ZeusTransformUtils.preCheckCast(r48, IntentExtras.class, "com.obric.aiagent.plugin");
        Loog r50 = Loog.INSTANCE;
        StringBuilder r51 = new StringBuilder().append("doAction: =logid = ");
        if (r49 == null) goto L37;
        String r52 = r49.getLogId();
    L38:
        StringBuilder r53 = r51.append(r52).append(", logid = ");
        Map<String, String> r54 = r35.getExt();
        if (r54 == null) goto L41;
        String r55 = (String) ZeusTransformUtils.preCheckCast(r54.get("log_id"), String.class, "com.obric.aiagent.plugin");
    L42:
        r50.i(TAG, r53.append(r55).toString());
        IAutoActionPresentationApi r56 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r56 == null) goto L45;
        r56.initGui((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r35.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L45:
        initBlackList(r49);
        String r57 = r34.getUniqueId();
        if (r57 != null) goto L48;
        String r112 = "";
    L49:
        if (r49 != null) goto L51;
    L173:
        Loog.INSTANCE.e(TAG, "doAction failed: params invalid " + r49);
        return new IntentResult(-1, null, null, "invalid params", false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L51:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r112, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L173;
        if (r49.getQuery() == null) goto L173;
        String r58 = r49.getLogId();
        if (r58 != null) goto L58;
    L64:
        Map<String, String> r59 = r35.getExt();
        if (r59 == null) goto L71;
        r58 = (String) ZeusTransformUtils.preCheckCast(r59.get("log_id"), String.class, "com.obric.aiagent.plugin");
        if (r58 == null) goto L71;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r58, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L71;
    L63:
        r26 = r58;
    L72:
        com.obric.autogui.agents.vlm.models.omni.d.e r60 = com.obric.autogui.agents.vlm.models.omni.d.e.f28334a;
        Long r61 = r35.getQuestionId();
        Map<String, String> r62 = r35.getExt();
        if (r62 == null) goto L82;
        String r63 = (String) ZeusTransformUtils.preCheckCast(r62.get(KEY_OMNI_TASK_ID), String.class, "com.obric.aiagent.plugin");
        if (r63 == null) goto L82;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r63, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L80;
        r63 = null;
    L80:
        if (r63 == null) goto L82;
    L90:
        r60.a(r112, r61, r63, r26);
        r r64 = t.f28523a.a(r112);
        if (r64 != null) goto L93;
    L95:
        boolean r65 = false;
    L96:
        if (r65 == false) goto L99;
        Loog.INSTANCE.i(TAG, "Refusing GUI_INIT on closed session: " + r112);
        return new IntentResult(com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.a(), null, null, com.obric.autogui.agents.vlm.models.omni.intent.c.f28410e.b(), false, false, 0, null, null, null, DownloadErrorCode.ERROR_REMOVE_DOWNLOAD_RUNNABLE, null);
    L99:
        com.obric.autogui.session.a r66 = com.obric.autogui.session.c.f30777a.b();
        if (r66 == null) goto L110;
        Long r67 = r35.getQuestionId();
        r15.f28360a = this;
        r15.f28361b = r35;
        r15.f28362c = r49;
        r15.f28363d = r112;
        r15.f28364e = r26;
        r15.h = 1;
        String r113 = r26;
        r110 = null;
        Object r68 = terminateCurrentSessionBeforeInit(r66, r112, r67, r26, r15);
        if (r68 != r14) goto L104;
        return r14;
    L104:
        r22 = r35;
        r21 = r49;
        r2 = r68;
        r25 = this;
        r24 = r112;
        r19 = r113;
        goto L106
    L110:
        r110 = null;
        r22 = r35;
        r21 = r49;
        r27 = this;
        r4 = r112;
        goto L111
    L93:
        if (r64.h() != true) goto L95;
        r65 = true;
    L82:
        Map<String, String> r69 = r35.getExt();
        if (r69 == null) goto L89;
        r63 = (String) ZeusTransformUtils.preCheckCast(r69.get(KEY_INSTRUCTION_ID), String.class, "com.obric.aiagent.plugin");
        if (r63 == null) goto L89;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r63, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L90;
    L89:
        r63 = null;
    L71:
        r26 = null;
        goto L72
    L58:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r58, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L61;
        r58 = null;
    L61:
        if (r58 != null) goto L63;
    L48:
        r112 = r57;
        goto L49
    L41:
        r55 = null;
        goto L42
    L37:
        r52 = null;
    L29:
        th = move-exception;
        n.a r70 = n.f38560a;
        r48 = n.f(d.o.a(th));
    L15:
        th = th;
        r7 = TAG;
        r8 = false;
    L7:
        r1 = new d(this, r0);
        goto L8
    }

    private final Object terminateCurrentSessionBeforeInit(com.obric.autogui.session.a r27, String r28, Long r29, String r30, d.c.d<? super Boolean> r31) {
        OmniGUIInitIntent r0 = this;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r31, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, e.class) == false) goto L7;
        e r5 = (e) ZeusTransformUtils.preCheckCast(r3, e.class, "com.obric.aiagent.plugin");
        if ((r5.i & Integer.MIN_VALUE) == 0) goto L7;
        r5.i -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.g;
        Object r6 = d.c.a.b.a();
        int r7 = r5.i;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        final com.obric.autogui.common.e r1 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.f28369e, String.class, "com.obric.aiagent.plugin");
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(r5.f28368d, Long.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.f28367c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r10 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f28366b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        OmniGUIInitIntent r11 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r5.f28365a, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        String r12 = r2;
        OmniGUIInitIntent r13 = r11;
        Long r14 = r8;
        String r15 = r9;
    L37:
        final boolean r16 = ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r16 == false) goto L40;
        String r17 = "FORCE_RELEASED_AFTER_TERMINATE";
    L41:
        r13.reportGuiInitSessionMismatch("force_release_result", r17, r10, r15, r14, r12, new $$Lambda$OmniGUIInitIntent$vJazFdc99OdgwbdsCpCvErV8gE(r1, r16));
        return d.c.b.a.b.a(r16);
    L40:
        r17 = "FORCE_RELEASE_FAILED";
        goto L41
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.common.e r18 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5.f, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        String r19 = (String) ZeusTransformUtils.preCheckCast(r5.f28369e, String.class, "com.obric.aiagent.plugin");
        Long r20 = (Long) ZeusTransformUtils.preCheckCast(r5.f28368d, Long.class, "com.obric.aiagent.plugin");
        String r110 = (String) ZeusTransformUtils.preCheckCast(r5.f28367c, String.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.a r111 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r5.f28366b, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        OmniGUIInitIntent r21 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r5.f28365a, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        final com.obric.autogui.common.e r22 = r18;
        r0 = r21;
    L20:
        final com.obric.autogui.session.a r23 = com.obric.autogui.session.c.f30777a.b();
        if (r23 != null) goto L24;
        Loog.INSTANCE.w(TAG, "GUI_INIT old session released after terminate: running=" + r111.b() + ", request=" + r110);
        r0.reportGuiInitSessionMismatch("released_after_terminate", "RELEASED_AFTER_TERMINATE", r111, r110, r20, r19, new $$Lambda$OmniGUIInitIntent$EZ4QKJOO8dhPQPsER18F2MC_iM(r22));
        return d.c.b.a.b.a(true);
    L24:
        if (r23 == r111) goto L27;
        Loog.INSTANCE.e(TAG, "GUI_INIT old session switched while waiting terminate: expected=" + r111.b() + ", actual=" + r23.b() + ", request=" + r110);
        r0.reportGuiInitSessionMismatch("switched_after_terminate", "SWITCHED_AFTER_TERMINATE", r111, r110, r20, r19, new $$Lambda$OmniGUIInitIntent$uHl1kgt9BF0u9t6BeVG4mhNwpTA(r22, r23));
        return d.c.b.a.b.a(false);
    L27:
        String r24 = "gui_init_force_release_after_terminate_timeout:running=" + r111.b() + ",request=" + r110 + ",msgId=" + r20;
        Loog r25 = Loog.INSTANCE;
        StringBuilder r26 = new StringBuilder().append("GUI_INIT old session still occupies ongoing slot after terminate, force release before new request: running=").append(r111.b()).append(", request=").append(r110).append(", runningKey=").append(r111.a()).append(", terminated=").append(r111.J().d()).append(", currentState=").append(r111.m().e().b()).append(", pendingState=").append(r111.m().c()).append(", loopActive=");
        AOThreadingTools.LaunchedJob r112 = r111.i();
        if (r112 == null) goto L32;
        ca r113 = r112.getJob();
        if (r113 == null) goto L32;
        Boolean r114 = d.c.b.a.b.a(r113.b());
    L33:
        r25.e(TAG, r26.append(r114).toString());
        com.obric.autogui.session.c r32 = com.obric.autogui.session.c.f30777a;
        r5.f28365a = r0;
        r5.f28366b = r111;
        r5.f28367c = r110;
        r5.f28368d = r20;
        r5.f28369e = r19;
        r5.f = r22;
        r5.i = 2;
        r4 = r32.a(r111, r24, r5);
        if (r4 != r6) goto L36;
        return r6;
    L36:
        r13 = r0;
        r1 = r22;
        r14 = r20;
        r10 = r111;
        r15 = r110;
        r12 = r19;
    L32:
        r114 = null;
        goto L33
    L16:
        d.o.a(r4);
        Loog.INSTANCE.e(TAG, "WTF, currentSession is not null, sessionId=" + r28 + ",and then start a new session");
        r22 = com.obric.autogui.session.state.termination.a.a(r27.J(), com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null), 108001, null, null, 12, null);
        Loog.INSTANCE.w(TAG, "GUI_INIT terminate old session: running=" + r27.b() + ", request=" + r28 + ", runningKey=" + r27.a() + ", terminateOk=" + r22.g() + ", terminateMsg=" + r22.h());
        r5.f28365a = r0;
        r5.f28366b = r27;
        r5.f28367c = r28;
        r20 = r29;
        r5.f28368d = r20;
        r5.f28369e = r30;
        r5.f = r22;
        r5.i = 1;
        if (ax.a(1000, r5) != r6) goto L19;
        return r6;
    L19:
        r110 = r28;
        r19 = r30;
        r111 = r27;
    L7:
        r5 = new e(r0, r3);
        goto L8
    }

    private static final x terminateCurrentSessionBeforeInit$lambda$11(com.obric.autogui.common.e r2, JSONObject r3) {
        o.e(r3, "$this$reportGuiInitSessionMismatch");
        r3.put("terminate_ok", r2.g());
        String r4 = r2.h();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r3.put("terminate_msg", r4);
        return x.f38692a;
    }

    private static final x terminateCurrentSessionBeforeInit$lambda$12(com.obric.autogui.common.e r2, com.obric.autogui.session.a r3, JSONObject r4) {
        o.e(r4, "$this$reportGuiInitSessionMismatch");
        r4.put("terminate_ok", r2.g());
        String r5 = r2.h();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.put("terminate_msg", r5);
        r4.put("actual_session_id", r3.b());
        r4.put("actual_session_key", r3.a());
        return x.f38692a;
    }

    private static final x terminateCurrentSessionBeforeInit$lambda$13(com.obric.autogui.common.e r2, boolean r3, JSONObject r4) {
        o.e(r4, "$this$reportGuiInitSessionMismatch");
        r4.put("terminate_ok", r2.g());
        String r5 = r2.h();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r4.put("terminate_msg", r5);
        r4.put("force_released", r3);
        return x.f38692a;
    }

    static /* synthetic */ void reportGuiInitSessionMismatch$default(OmniGUIInitIntent r9, String r10, String r11, com.obric.autogui.session.a r12, String r13, Long r14, String r15, d.h.a.b r16, int r17, Object r18) {
        d.h.a.b<? super JSONObject, x> r0 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r16, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r17 & 64) == 0) goto L5;
        r0 = $$Lambda$OmniGUIInitIntent$Gr12M2daD3_BNGd7PnWXaDgDGo.INSTANCE;
    L5:
        r9.reportGuiInitSessionMismatch(r10, r11, r12, r13, r14, r15, r0);
    }

    private static final x reportGuiInitSessionMismatch$lambda$14(JSONObject r1) {
        o.e(r1, "<this>");
        return x.f38692a;
    }

    private final void reportGuiInitSessionMismatch(String r19, String r20, com.obric.autogui.session.a r21, String r22, Long r23, String r24, d.h.a.b<? super JSONObject, x> r25) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r25, d.h.a.b.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L75
        OmniGUIInitIntent r1 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(this, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        n.a r2 = n.f38560a;     // Catch: Throwable -> L6
        Object r3 = n.f(AOHostAppTools.INSTANCE.getHostAppInfo());     // Catch: Throwable -> L6
    L8:
        Boolean r7 = null;
        if (n.b(r3) == false) goto L11;
        r3 = null;
    L11:
        HostAppInfo r6 = (HostAppInfo) ZeusTransformUtils.preCheckCast(r3, HostAppInfo.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        n.a r4 = n.f38560a;     // Catch: Throwable -> L14
        Object r8 = n.f(AOHostAppTools.INSTANCE.getHostAppPackage());     // Catch: Throwable -> L14
    L17:
        String r9 = "";
        if (n.b(r8) == false) goto L20;
        r8 = "";
    L20:
        String r10 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        IAutoActionTrackingApi r11 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L75
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L75
        r12.put(DBHelper.BATTERY_COL_SOURCE, "gui_init");     // Catch: Throwable -> L75
        r12.put("stage", r19);     // Catch: Throwable -> L75
        r12.put("outcome", r20);     // Catch: Throwable -> L75
        r12.put("is_terminated", r21.J().d());     // Catch: Throwable -> L75
        r12.put("is_omni", r21.c());     // Catch: Throwable -> L75
        if (r24 != null) goto L23;
        String r13 = "";
    L24:
        r12.put("request_log_id", r13);     // Catch: Throwable -> L75
        r r14 = t.f28523a.a(r21.b());     // Catch: Throwable -> L75
        if (r14 == null) goto L27;
        String r15 = r14.b();     // Catch: Throwable -> L75
    L28:
        if (r15 != null) goto L30;
        r15 = "";
    L30:
        r12.put("running_inner_log_id", r15);     // Catch: Throwable -> L75
        r12.put("session_id", r21.b());     // Catch: Throwable -> L75
        r12.put("request_session_id", r22);     // Catch: Throwable -> L75
        r12.put("session_key", r21.a());     // Catch: Throwable -> L75
        r12.put("request_tool_id", "gui_init");     // Catch: Throwable -> L75
        r12.put("request_tool_name", "gui_init");     // Catch: Throwable -> L75
        r12.put("request_instruction_type", "gui_init");     // Catch: Throwable -> L75
        r12.put("request_action_type", "gui_init");     // Catch: Throwable -> L75
        if (r23 == null) goto L33;
        String r16 = r23.toString();     // Catch: Throwable -> L75
    L34:
        if (r16 != null) goto L36;
        r16 = "";
    L36:
        r12.put("request_msg_id", r16);     // Catch: Throwable -> L75
        r12.put("device_id", r21.R().a());     // Catch: Throwable -> L75
        r12.put("plugin_version_code", AOHostAppTools.INSTANCE.getAppVersionCode());     // Catch: Throwable -> L75
        r12.put("host_app_package", r10);     // Catch: Throwable -> L75
        if (r6 == null) goto L39;
        String r17 = r6.getVersionName();     // Catch: Throwable -> L75
    L40:
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        r12.put("host_app_version_name", r17);     // Catch: Throwable -> L75
        if (r6 == null) goto L45;
        int r18 = r6.getVersionCode();     // Catch: Throwable -> L75
    L46:
        r12.put("host_app_version_code", r18);     // Catch: Throwable -> L75
        r12.put("current_state", r21.m().e().b().toString());     // Catch: Throwable -> L75
        BizStatus r26 = r21.m().c();     // Catch: Throwable -> L75
        if (r26 == null) goto L49;
        String r27 = r26.toString();     // Catch: Throwable -> L75
    L50:
        if (r27 != null) goto L52;
        r27 = "";
    L52:
        r12.put("pending_state", r27);     // Catch: Throwable -> L75
        AOThreadingTools.LaunchedJob r28 = r21.i();     // Catch: Throwable -> L75
        if (r28 == null) goto L57;
        ca r29 = r28.getJob();     // Catch: Throwable -> L75
        if (r29 == null) goto L57;
        Boolean r30 = Boolean.valueOf(r29.b());     // Catch: Throwable -> L75
    L58:
        r12.put("loop_active", r30);     // Catch: Throwable -> L75
        AOThreadingTools.LaunchedJob r31 = r21.i();     // Catch: Throwable -> L75
        if (r31 == null) goto L63;
        ca r32 = r31.getJob();     // Catch: Throwable -> L75
        if (r32 == null) goto L63;
        Boolean r33 = Boolean.valueOf(r32.j());     // Catch: Throwable -> L75
    L64:
        r12.put("loop_cancelled", r33);     // Catch: Throwable -> L75
        AOThreadingTools.LaunchedJob r34 = r21.i();     // Catch: Throwable -> L75
        if (r34 == null) goto L69;
        ca r35 = r34.getJob();     // Catch: Throwable -> L75
        if (r35 == null) goto L69;
        r7 = Boolean.valueOf(r35.i());     // Catch: Throwable -> L75
    L69:
        r12.put("loop_completed", r7);     // Catch: Throwable -> L75
        r12.put("has_reached_end_step", r21.J().a());     // Catch: Throwable -> L75
        r12.put("step", r21.s());     // Catch: Throwable -> L75
        String r36 = r21.v();     // Catch: Throwable -> L75
        if (r36 == null) goto L73;
        r9 = r36;
    L73:
        r12.put("tracking_step_id", r9);     // Catch: Throwable -> L75
        r5.invoke(r12);     // Catch: Throwable -> L75
        x r37 = x.f38692a;     // Catch: Throwable -> L75
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r11, "oauto_omni_session_mismatch", r12, false, false, null, 28, null);     // Catch: Throwable -> L75
        Object r38 = n.f(x.f38692a);     // Catch: Throwable -> L75
    L77:
        Throwable r39 = n.c(r38);
        if (r39 == null) goto L87;
        Loog.INSTANCE.e(TAG, "report GUI_INIT session mismatch failed: running=" + r21.b() + ", request=" + r22 + ", outcome=" + r20, r39);
        return;
    L87:
        return;
    L63:
        r33 = null;
    L57:
        r30 = null;
        goto L58
    L49:
        r27 = null;
        goto L50
    L45:
        r18 = -1;
        goto L46
    L39:
        r17 = null;
        goto L40
    L33:
        r16 = null;
        goto L34
    L27:
        r15 = null;
        goto L28
    L23:
        r13 = r24;
    L14:
        th = move-exception;
        n.a r40 = n.f38560a;     // Catch: Throwable -> L75
        r8 = n.f(d.o.a(th));     // Catch: Throwable -> L75
        goto L17
    L6:
        th = move-exception;
        n.a r41 = n.f38560a;     // Catch: Throwable -> L75
        r3 = n.f(d.o.a(th));     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        n.a r42 = n.f38560a;
        r38 = n.f(d.o.a(th));
        goto L77
    }

    private final Object createOrActivateSession(String r17, String r18, Long r19, String r20, Boolean r21, Boolean r22, d.c.d<? super Boolean> r23) {
        OmniGUIInitIntent r7 = this;
        String r8 = r17;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, b.class) == false) goto L7;
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");
        if ((r2.h & Integer.MIN_VALUE) == 0) goto L7;
        r2.h -= Integer.MIN_VALUE;
    L8:
        b r10 = r2;
        Object r3 = r10.f;
        Object r11 = d.c.a.b.a();
        int r4 = r10.h;
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        d.o.a(r3);
    L65:
        return r3;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        com.obric.autogui.session.a r5 = (com.obric.autogui.session.a) ZeusTransformUtils.preCheckCast(r10.f28356e, com.obric.autogui.session.a.class, "com.obric.aiagent.plugin");
        Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r10.f28355d, Bundle.class, "com.obric.aiagent.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r10.f28354c, String.class, "com.obric.aiagent.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.f28353b, String.class, "com.obric.aiagent.plugin");
        OmniGUIInitIntent r13 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r10.f28352a, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");
        d.o.a(r3);     // Catch: Throwable -> L18
        r8 = r12;
    L66:
        Object r0 = n.f((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L35
    L42:
        Throwable r14 = n.c(r0);
        if (r14 == null) goto L46;
        Loog.INSTANCE.e(TAG, "activate pending session exception", r14);
    L46:
        if (n.b(r0) == false) goto L48;
        r0 = null;
    L48:
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r0, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        boolean r16 = false;
        if (r15 != null) goto L51;
    L53:
        if (r16 == false) goto L56;
        Loog.INSTANCE.i(TAG, "activate pending session success; key=" + r5.a() + ", sessionId=" + r9);
        return d.c.b.a.b.a(true);
    L56:
        com.obric.autogui.session.d.i.f30907a.a(r5, "activate_failed");
        Loog r24 = Loog.INSTANCE;
        StringBuilder r25 = new StringBuilder().append("activate pending session failed: ");
        if (r15 == null) goto L59;
        String r26 = r15.h();
    L60:
        r24.e(TAG, r25.append(r26).append("; fallback to postUserQuery").toString());
    L62:
        r10.f28352a = null;
        r10.f28353b = null;
        r10.f28354c = null;
        r10.f28355d = null;
        r10.f28356e = null;
        r10.h = 2;
        r3 = r13.createSessionFallback(r8, r6, r10);
        if (r3 != r11) goto L65;
        return r11;
    L59:
        r26 = null;
        goto L60
    L51:
        if (r15.g() != true) goto L53;
        r16 = true;
    L35:
        th = th;
    L20:
        r7 = r13;
    L41:
        n.a r27 = n.f38560a;
        r0 = n.f(d.o.a(th));
        r13 = r7;
    L18:
        th = th;
        r8 = r12;
        goto L20
    L21:
        d.o.a(r3);
        r6 = buildTaskExtras(r18, r19, r20, r21, r22);
        r5 = com.obric.autogui.session.d.i.f30907a.b();
        if (r5 == null) goto L61;
        com.obric.autogui.session.d.f r28 = r5.k().b();
        if (r28 == null) goto L26;
        com.obric.autogui.session.d.a.a((com.obric.autogui.session.d.a) ZeusTransformUtils.preCheckCast(r28, com.obric.autogui.session.d.a.class, "com.obric.aiagent.plugin"), null, 1, null);
    L26:
        AutoOperateTask r29 = r7.buildActivationTask(r8, r6);
        com.obric.autogui.b.b.f28935a.a(r5);
        n.a r30 = n.f38560a;     // Catch: Throwable -> L39
        OmniGUIInitIntent r31 = (OmniGUIInitIntent) ZeusTransformUtils.preCheckCast(r7, OmniGUIInitIntent.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
        com.obric.autogui.b.b r32 = com.obric.autogui.b.b.f28935a;     // Catch: Throwable -> L39
        r10.f28352a = r7;     // Catch: Throwable -> L39
        r10.f28353b = r8;     // Catch: Throwable -> L39
        r9 = r18;
        r10.f28354c = r9;     // Catch: Throwable -> L37
        r10.f28355d = r6;     // Catch: Throwable -> L37
        r10.f28356e = r5;     // Catch: Throwable -> L37
        r10.h = 1;     // Catch: Throwable -> L37
        r3 = r32.a(r5, r29, r10);     // Catch: Throwable -> L37
        if (r3 != r11) goto L32;
        return r11;
    L32:
        r13 = r7;
    L37:
        th = th;
    L39:
        th = th;
        r9 = r18;
        goto L41
    L61:
        Loog.INSTANCE.i(TAG, "pending session miss; fallback to postUserQuery");
        r13 = r7;
    L7:
        r2 = new b(r7, r1);
        goto L8
    }

    private final Object createSessionFallback(String r10, Bundle r11, d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin");
        if ((r0.f28359c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f28359c -= Integer.MIN_VALUE;
    L8:
        c r7 = r0;
        Object r9 = r7.f28357a;
        Object r14 = d.c.a.b.a();
        int r1 = r7.f28359c;
        if (r1 == 0) goto L17;
        if (r1 != 1) goto L16;
        d.o.a(r9);     // Catch: Exception -> L13
    L21:
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r9, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L13
        boolean r16 = r15.g();     // Catch: Exception -> L13
        if (r16 == true) goto L27;
        Loog.INSTANCE.e(TAG, "postUserQuery failed: " + r15.h());     // Catch: Exception -> L13
    L27:
        return d.c.b.a.b.a(r16);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r9);
        AutoActionAgent r17 = AutoActionAgent.INSTANCE;     // Catch: Exception -> L13
        r7.f28359c = 1;     // Catch: Exception -> L13
        r9 = r17.postUserQuery(r10, false, r11, 36, r7);     // Catch: Exception -> L13
        if (r9 != r14) goto L21;
        return r14;
    L13:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "postUserQuery exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        r16 = false;
    L7:
        r0 = new c(this, r13);
        goto L8
    }

    private final void initAIKernelIfOautoModelPreinstalled() {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ObricProductSdk.INSTANCE.platformService().romInfo().isOautoModelPreinstalled(r4) == true) goto L5;
        return;
    L5:
        Loog.INSTANCE.i(TAG, "init AIKernel on demand for preinstalled oauto model");
        IAutoActionLocalModelProvider r0 = (IAutoActionLocalModelProvider) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLocalModelProvider.class), IAutoActionLocalModelProvider.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L9;
        r0.init(r4);
        return;
    }

    private final Bundle buildTaskExtras(String r2, Long r3, String r4, Boolean r5, Boolean r6) {
        Bundle r1 = new Bundle();
        r1.putString("session_id", r2);
        if (r3 == null) goto L5;
        r1.putLong("doubao_message_id", ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).longValue());
    L5:
        if (r4 == null) goto L7;
        r1.putString("caller_source", r4);
    L7:
        if (r5 == null) goto L10;
        r1.putBoolean("allow_user_interaction", r5.booleanValue());
    L10:
        if (o.a(r4, "ai_proactive") == false) goto L12;
        boolean r7 = false;
    L15:
        r1.putBoolean("start_in_place", r7);
        return r1;
    L12:
        if (r6 == null) goto L14;
        r7 = r6.booleanValue();
        goto L15
    L14:
        r7 = true;
        goto L15
    }

    private final AutoOperateTask buildActivationTask(String r1, Bundle r2) {
        AutoOperateTask r0 = new AutoOperateTask();
        r0.setUserTask(r1);
        r0.setTaskExtras(r2);
        r0.setLaunchOrigin(36);
        return r0;
    }

    private final g buildGUIInitRequest(String r24, String r25, DispatchContext r26) {
        Long r1 = r26.getQuestionId();
        JsonObject r4 = new JsonObject();
        Map<String, String> r0 = r26.getExt();
        if (r0 == null) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get(KEY_OMNI_TASK_ID), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L12;
    L18:
        String r10 = r2;
    L21:
        return new g(r1, r24, null, r4, null, r25, "gui_init", "gui_init", "gui_init", r10, false, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r26.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), false, null, null, null, null, null, null, 520192, null);
    L12:
        Map<String, String> r3 = r26.getExt();
        if (r3 == null) goto L19;
        r2 = (String) ZeusTransformUtils.preCheckCast(r3.get(KEY_INSTRUCTION_ID), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L19;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L18;
    L19:
        r10 = null;
        goto L21
    }

    private final void initBlackList(IntentExtras r6) {
        Integer r5 = null;
        if (r6 == null) goto L5;
        List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r0 = r6.getHardBlackList();
    L6:
        if (r0 != null) goto L8;
        r0 = p.b();
    L8:
        if (r6 == null) goto L10;
        List<com.obric.autogui.agents.vlm.models.impl.applist.black.a> r1 = r6.getSoftBlackList();
    L11:
        if (r1 != null) goto L13;
        r1 = p.b();
    L13:
        if (r6 == null) goto L15;
        List<com.obric.autogui.agents.vlm.models.impl.applist.black.h> r2 = r6.getWhiteList();
    L16:
        if (r2 != null) goto L18;
        r2 = p.b();
    L18:
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.c();
        com.obric.autogui.agents.vlm.models.impl.applist.black.g r3 = com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a;
        if (r6 == null) goto L21;
        r5 = r6.getMode();
    L21:
        r3.a(r5);
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27353a);
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin"), com.obric.autogui.agents.vlm.models.impl.applist.black.e.a.f27354b);
        com.obric.autogui.agents.vlm.models.impl.applist.black.g.f27362a.a((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
        OperatingSpaceManager r7 = OperatingSpaceManager.INSTANCE;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r8, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r8.iterator();
    L23:
        if (r9.hasNext() == false) goto L25;
        r4.add(((com.obric.autogui.agents.vlm.models.impl.applist.black.a) ZeusTransformUtils.preCheckCast(r9.next(), com.obric.autogui.agents.vlm.models.impl.applist.black.a.class, "com.obric.aiagent.plugin")).d());
        goto L23
    L25:
        r7.setGlobalDisabledApps((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"));
        return;
    L15:
        r2 = null;
        goto L16
    L10:
        r1 = null;
        goto L11
    L5:
        r0 = null;
        goto L6
    }
}
