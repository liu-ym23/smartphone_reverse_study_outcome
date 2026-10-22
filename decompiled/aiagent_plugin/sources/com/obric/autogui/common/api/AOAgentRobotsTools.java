package com.obric.autogui.common.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import com.bytedance.agentrobots.identity.RobotAgent;
import com.bytedance.agentrobots.identity.RobotAgentProof;
import com.bytedance.agentrobots.identity.RobotAgentRegReq;
import com.bytedance.agentrobots.identity.RobotAgentRegRes;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.display.IAutoActionDisplayApi;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.d.a;
import d.d.b;
import d.f.c;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.n;
import d.x;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOSystemTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AOAgentRobotsTools {
    public static final AOAgentRobotsTools INSTANCE = null;
    private static final long REGISTER_INITIAL_RETRY_DELAY_MILLIS = 1000;
    private static final int REGISTER_MAX_ATTEMPTS = 3;
    private static final long REGISTER_MAX_RETRY_DELAY_MILLIS = 4000;
    private static final String TAG = "AOAgentRobots";
    public static final String TARGET_APP_GRANT_EXT_KEY = "target_app_grant";
    private static final AtomicReference<String> sAgentMd5 = null;
    private static final AtomicReference<String> sAgentName = null;
    private static final AtomicReference<String> sAgentType = null;
    private static final AtomicReference<String> sAgentUuid = null;
    private static final AtomicLong sAuditStepCounter = null;
    private static final AtomicReference<String> sCallerPackageName = null;
    private static String sOperationAgentUuid;
    private static Context sOperationAppContext;
    private static final AgentOperationTargetDispatcher sOperationTargetDispatcher = null;
    private static final AOThreadingTools.SingleThreadCoroutineScopeWrapper sOperationTargetScope = null;
    private static final AtomicReference<String> sPkgSha256 = null;
    private static final AtomicReference<String> sProofSignature = null;
    private static final AtomicBoolean sRegisterInFlight = null;
    private static final AgentRegistrationRetryRunner sRegistrationRetryRunner = null;
    private static final AtomicReference<String> sRobotsSessionId = null;
    private static final AtomicBoolean sSessionActive = null;
    private static final AtomicReference<String> sTrustLevel = null;

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public static final enum AgentType extends Enum<AgentType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ AgentType[] $VALUES = null;
        public static final AgentType ASSISTIVE = null;
        public static final AgentType AUTONOMOUS = null;
        public static final AgentType RECORDING = null;
        public static final AgentType SUGGESTIVE = null;

        private static final /* synthetic */ AgentType[] $values() {
            return new AgentType[]{RECORDING, SUGGESTIVE, ASSISTIVE, AUTONOMOUS};
        }

        public static a<AgentType> getEntries() {
            return $ENTRIES;
        }

        private AgentType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            RECORDING = new AgentType("RECORDING", 0);
            SUGGESTIVE = new AgentType("SUGGESTIVE", 1);
            ASSISTIVE = new AgentType("ASSISTIVE", 2);
            AUTONOMOUS = new AgentType("AUTONOMOUS", 3);
            AgentType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static AgentType valueOf(String r2) {
            return (AgentType) ZeusTransformUtils.preCheckCast(Enum.valueOf(AgentType.class, r2), AgentType.class, "com.obric.aiagent.plugin");
        }

        public static AgentType[] values() {
            return (AgentType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AgentType[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    private static final class AuditPayload {
        private final String actionArgs;
        private final String actionType;
        private final String appVersion;
        private final String checkLlmOutputAuditInfo;
        private final String checkUserInputAuditInfo;
        private final String deviceId;
        private final String doubaoMessageId;
        private final Long duration;
        private final String errorCode;
        private final String executeId;
        private final String finishReason;
        private final String instructionId;
        private final String instructionType;
        private final String intentType;
        private final String logType;
        private final String oReferenceMsgId;
        private final String omniLogId;
        private final String originToolsName;
        private final String policy;
        private final String query;
        private final String reasonCode;
        private final String riskLevel;
        private final String stepId;
        private final String targetActivity;
        private final String targetApkMd5;
        private final String targetApkVersion;
        private final TargetAppGrant targetAppGrant;
        private final String targetPackage;
        private final List<String> targetSignSha256;
        private final String toolName;
        private final String userAuthorizationType;

        public static /* synthetic */ AuditPayload copy$default(AuditPayload r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, Long r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, List r45, String r46, String r47, TargetAppGrant r48, int r49, Object r50) {
            List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r45, List.class, "com.obric.aiagent.plugin");
            if ((r49 & 1) == 0) goto L5;
            String r3 = r17.logType;
        L7:
            if ((r49 & 2) == 0) goto L9;
            String r4 = r17.targetPackage;
        L11:
            if ((r49 & 4) == 0) goto L13;
            String r5 = r17.targetActivity;
        L15:
            if ((r49 & 8) == 0) goto L17;
            String r6 = r17.errorCode;
        L19:
            if ((r49 & 16) == 0) goto L21;
            String r7 = r17.actionType;
        L23:
            if ((r49 & 32) == 0) goto L25;
            String r8 = r17.actionArgs;
        L27:
            if ((r49 & 64) == 0) goto L29;
            String r9 = r17.reasonCode;
        L31:
            if ((r49 & 128) == 0) goto L33;
            String r10 = r17.finishReason;
        L35:
            if ((r49 & 256) == 0) goto L37;
            String r11 = r17.policy;
        L39:
            if ((r49 & 512) == 0) goto L41;
            Long r12 = r17.duration;
        L43:
            if ((r49 & 1024) == 0) goto L45;
            String r13 = r17.intentType;
        L47:
            if ((r49 & 2048) == 0) goto L49;
            String r14 = r17.userAuthorizationType;
        L51:
            if ((r49 & 4096) == 0) goto L53;
            String r15 = r17.riskLevel;
        L55:
            if ((r49 & 8192) == 0) goto L57;
            String r16 = r17.executeId;
        L58:
            String r310 = r16;
            if ((r49 & 16384) == 0) goto L61;
            String r51 = r17.instructionId;
        L62:
            String r311 = r51;
            if ((r49 & 32768) == 0) goto L65;
            String r52 = r17.stepId;
        L66:
            String r312 = r52;
            if ((r49 & 65536) == 0) goto L69;
            String r53 = r17.omniLogId;
        L70:
            String r313 = r53;
            if ((r49 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
            String r54 = r17.toolName;
        L74:
            String r314 = r54;
            if ((r49 & 262144) == 0) goto L77;
            String r55 = r17.deviceId;
        L78:
            String r315 = r55;
            if ((r49 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
            String r56 = r17.instructionType;
        L82:
            String r316 = r56;
            if ((r49 & 1048576) == 0) goto L85;
            String r57 = r17.doubaoMessageId;
        L86:
            String r317 = r57;
            if ((r49 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
            String r58 = r17.originToolsName;
        L90:
            String r318 = r58;
            if ((r49 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
            String r59 = r17.oReferenceMsgId;
        L94:
            String r410 = r59;
            if ((r49 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
            String r60 = r17.query;
        L98:
            String r411 = r60;
            if ((r49 & 16777216) == 0) goto L101;
            String r61 = r17.checkUserInputAuditInfo;
        L102:
            String r412 = r61;
            if ((r49 & 33554432) == 0) goto L105;
            String r62 = r17.checkLlmOutputAuditInfo;
        L106:
            String r413 = r62;
            if ((r49 & 67108864) == 0) goto L109;
            String r63 = r17.targetApkVersion;
        L110:
            String r414 = r63;
            if ((r49 & 134217728) == 0) goto L113;
            List<String> r64 = r17.targetSignSha256;
        L114:
            List<String> r415 = r64;
            if ((r49 & 268435456) == 0) goto L117;
            String r65 = r17.targetApkMd5;
        L118:
            String r416 = r65;
            if ((r49 & 536870912) == 0) goto L121;
            String r66 = r17.appVersion;
        L123:
            if ((r49 & 1073741824) == 0) goto L125;
            TargetAppGrant r1 = r17.targetAppGrant;
        L127:
            return r17.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r413, r414, r415, r416, r66, r1);
        L125:
            r1 = r48;
            goto L127
        L121:
            r66 = r47;
            goto L123
        L117:
            r65 = r46;
            goto L118
        L113:
            r64 = r2;
            goto L114
        L109:
            r63 = r44;
            goto L110
        L105:
            r62 = r43;
            goto L106
        L101:
            r61 = r42;
            goto L102
        L97:
            r60 = r41;
            goto L98
        L93:
            r59 = r40;
            goto L94
        L89:
            r58 = r39;
            goto L90
        L85:
            r57 = r38;
            goto L86
        L81:
            r56 = r37;
            goto L82
        L77:
            r55 = r36;
            goto L78
        L73:
            r54 = r35;
            goto L74
        L69:
            r53 = r34;
            goto L70
        L65:
            r52 = r33;
            goto L66
        L61:
            r51 = r32;
            goto L62
        L57:
            r16 = r31;
            goto L58
        L53:
            r15 = r30;
            goto L55
        L49:
            r14 = r29;
            goto L51
        L45:
            r13 = r28;
            goto L47
        L41:
            r12 = r27;
            goto L43
        L37:
            r11 = r26;
            goto L39
        L33:
            r10 = r25;
            goto L35
        L29:
            r9 = r24;
            goto L31
        L25:
            r8 = r23;
            goto L27
        L21:
            r7 = r22;
            goto L23
        L17:
            r6 = r21;
            goto L19
        L13:
            r5 = r20;
            goto L15
        L9:
            r4 = r19;
            goto L11
        L5:
            r3 = r18;
            goto L7
        }

        public final String component1() {
            return this.logType;
        }

        public final Long component10() {
            return this.duration;
        }

        public final String component11() {
            return this.intentType;
        }

        public final String component12() {
            return this.userAuthorizationType;
        }

        public final String component13() {
            return this.riskLevel;
        }

        public final String component14() {
            return this.executeId;
        }

        public final String component15() {
            return this.instructionId;
        }

        public final String component16() {
            return this.stepId;
        }

        public final String component17() {
            return this.omniLogId;
        }

        public final String component18() {
            return this.toolName;
        }

        public final String component19() {
            return this.deviceId;
        }

        public final String component2() {
            return this.targetPackage;
        }

        public final String component20() {
            return this.instructionType;
        }

        public final String component21() {
            return this.doubaoMessageId;
        }

        public final String component22() {
            return this.originToolsName;
        }

        public final String component23() {
            return this.oReferenceMsgId;
        }

        public final String component24() {
            return this.query;
        }

        public final String component25() {
            return this.checkUserInputAuditInfo;
        }

        public final String component26() {
            return this.checkLlmOutputAuditInfo;
        }

        public final String component27() {
            return this.targetApkVersion;
        }

        public final List<String> component28() {
            return this.targetSignSha256;
        }

        public final String component29() {
            return this.targetApkMd5;
        }

        public final String component3() {
            return this.targetActivity;
        }

        public final String component30() {
            return this.appVersion;
        }

        public final TargetAppGrant component31() {
            return this.targetAppGrant;
        }

        public final String component4() {
            return this.errorCode;
        }

        public final String component5() {
            return this.actionType;
        }

        public final String component6() {
            return this.actionArgs;
        }

        public final String component7() {
            return this.reasonCode;
        }

        public final String component8() {
            return this.finishReason;
        }

        public final String component9() {
            return this.policy;
        }

        public final AuditPayload copy(String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, String r43, Long r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, List<String> r62, String r63, String r64, TargetAppGrant r65) {
            List r28 = (List) ZeusTransformUtils.wrapperContextForParams(r62, List.class, "com.obric.aiagent.plugin");
            o.e(r35, "logType");
            o.e(r36, "targetPackage");
            o.e(r38, "errorCode");
            return new AuditPayload(r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r28, r63, r64, r65);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AuditPayload.class) == true) goto L8;
            return false;
        L8:
            AuditPayload r6 = (AuditPayload) ZeusTransformUtils.preCheckCast(r5, AuditPayload.class, "com.obric.aiagent.plugin");
            if (o.a(this.logType, r6.logType) == true) goto L12;
            return false;
        L12:
            if (o.a(this.targetPackage, r6.targetPackage) == true) goto L15;
            return false;
        L15:
            if (o.a(this.targetActivity, r6.targetActivity) == true) goto L18;
            return false;
        L18:
            if (o.a(this.errorCode, r6.errorCode) == true) goto L21;
            return false;
        L21:
            if (o.a(this.actionType, r6.actionType) == true) goto L24;
            return false;
        L24:
            if (o.a(this.actionArgs, r6.actionArgs) == true) goto L27;
            return false;
        L27:
            if (o.a(this.reasonCode, r6.reasonCode) == true) goto L30;
            return false;
        L30:
            if (o.a(this.finishReason, r6.finishReason) == true) goto L33;
            return false;
        L33:
            if (o.a(this.policy, r6.policy) == true) goto L36;
            return false;
        L36:
            if (o.a(this.duration, r6.duration) == true) goto L39;
            return false;
        L39:
            if (o.a(this.intentType, r6.intentType) == true) goto L42;
            return false;
        L42:
            if (o.a(this.userAuthorizationType, r6.userAuthorizationType) == true) goto L45;
            return false;
        L45:
            if (o.a(this.riskLevel, r6.riskLevel) == true) goto L48;
            return false;
        L48:
            if (o.a(this.executeId, r6.executeId) == true) goto L51;
            return false;
        L51:
            if (o.a(this.instructionId, r6.instructionId) == true) goto L54;
            return false;
        L54:
            if (o.a(this.stepId, r6.stepId) == true) goto L57;
            return false;
        L57:
            if (o.a(this.omniLogId, r6.omniLogId) == true) goto L60;
            return false;
        L60:
            if (o.a(this.toolName, r6.toolName) == true) goto L63;
            return false;
        L63:
            if (o.a(this.deviceId, r6.deviceId) == true) goto L66;
            return false;
        L66:
            if (o.a(this.instructionType, r6.instructionType) == true) goto L69;
            return false;
        L69:
            if (o.a(this.doubaoMessageId, r6.doubaoMessageId) == true) goto L72;
            return false;
        L72:
            if (o.a(this.originToolsName, r6.originToolsName) == true) goto L75;
            return false;
        L75:
            if (o.a(this.oReferenceMsgId, r6.oReferenceMsgId) == true) goto L78;
            return false;
        L78:
            if (o.a(this.query, r6.query) == true) goto L81;
            return false;
        L81:
            if (o.a(this.checkUserInputAuditInfo, r6.checkUserInputAuditInfo) == true) goto L84;
            return false;
        L84:
            if (o.a(this.checkLlmOutputAuditInfo, r6.checkLlmOutputAuditInfo) == true) goto L87;
            return false;
        L87:
            if (o.a(this.targetApkVersion, r6.targetApkVersion) == true) goto L90;
            return false;
        L90:
            if (o.a(this.targetSignSha256, r6.targetSignSha256) == true) goto L93;
            return false;
        L93:
            if (o.a(this.targetApkMd5, r6.targetApkMd5) == true) goto L96;
            return false;
        L96:
            if (o.a(this.appVersion, r6.appVersion) == true) goto L99;
            return false;
        L99:
            if (o.a(this.targetAppGrant, r6.targetAppGrant) == true) goto L101;
            return false;
        L101:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.logType.hashCode() * 31) + this.targetPackage.hashCode()) * 31;
            String r1 = this.targetActivity;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.errorCode.hashCode()) * 31;
            String r5 = this.actionType;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.actionArgs;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.reasonCode;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.finishReason;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.policy;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            Long r20 = this.duration;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.intentType;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.userAuthorizationType;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.riskLevel;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.executeId;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.instructionId;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            String r38 = this.stepId;
            if (r38 != null) goto L53;
            int r39 = 0;
        L54:
            int r40 = (r37 + r39) * 31;
            String r41 = this.omniLogId;
            if (r41 != null) goto L57;
            int r42 = 0;
        L58:
            int r43 = (r40 + r42) * 31;
            String r44 = this.toolName;
            if (r44 != null) goto L61;
            int r45 = 0;
        L62:
            int r46 = (r43 + r45) * 31;
            String r47 = this.deviceId;
            if (r47 != null) goto L65;
            int r48 = 0;
        L66:
            int r49 = (r46 + r48) * 31;
            String r50 = this.instructionType;
            if (r50 != null) goto L69;
            int r51 = 0;
        L70:
            int r52 = (r49 + r51) * 31;
            String r53 = this.doubaoMessageId;
            if (r53 != null) goto L73;
            int r54 = 0;
        L74:
            int r55 = (r52 + r54) * 31;
            String r56 = this.originToolsName;
            if (r56 != null) goto L77;
            int r57 = 0;
        L78:
            int r58 = (r55 + r57) * 31;
            String r59 = this.oReferenceMsgId;
            if (r59 != null) goto L81;
            int r60 = 0;
        L82:
            int r61 = (r58 + r60) * 31;
            String r62 = this.query;
            if (r62 != null) goto L85;
            int r63 = 0;
        L86:
            int r64 = (r61 + r63) * 31;
            String r65 = this.checkUserInputAuditInfo;
            if (r65 != null) goto L89;
            int r66 = 0;
        L90:
            int r67 = (r64 + r66) * 31;
            String r68 = this.checkLlmOutputAuditInfo;
            if (r68 != null) goto L93;
            int r69 = 0;
        L94:
            int r70 = (r67 + r69) * 31;
            String r71 = this.targetApkVersion;
            if (r71 != null) goto L97;
            int r72 = 0;
        L98:
            int r73 = (r70 + r72) * 31;
            List<String> r74 = this.targetSignSha256;
            if (r74 != null) goto L101;
            int r75 = 0;
        L102:
            int r76 = (r73 + r75) * 31;
            String r77 = this.targetApkMd5;
            if (r77 != null) goto L105;
            int r78 = 0;
        L106:
            int r79 = (r76 + r78) * 31;
            String r80 = this.appVersion;
            if (r80 != null) goto L109;
            int r81 = 0;
        L110:
            int r82 = (r79 + r81) * 31;
            TargetAppGrant r83 = this.targetAppGrant;
            if (r83 == null) goto L115;
            r2 = r83.hashCode();
        L115:
            return r82 + r2;
        L109:
            r81 = r80.hashCode();
            goto L110
        L105:
            r78 = r77.hashCode();
            goto L106
        L101:
            r75 = r74.hashCode();
            goto L102
        L97:
            r72 = r71.hashCode();
            goto L98
        L93:
            r69 = r68.hashCode();
            goto L94
        L89:
            r66 = r65.hashCode();
            goto L90
        L85:
            r63 = r62.hashCode();
            goto L86
        L81:
            r60 = r59.hashCode();
            goto L82
        L77:
            r57 = r56.hashCode();
            goto L78
        L73:
            r54 = r53.hashCode();
            goto L74
        L69:
            r51 = r50.hashCode();
            goto L70
        L65:
            r48 = r47.hashCode();
            goto L66
        L61:
            r45 = r44.hashCode();
            goto L62
        L57:
            r42 = r41.hashCode();
            goto L58
        L53:
            r39 = r38.hashCode();
            goto L54
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AuditPayload(logType=").append(this.logType).append(", targetPackage=").append(this.targetPackage).append(", targetActivity=").append(this.targetActivity).append(", errorCode=").append(this.errorCode).append(", actionType=").append(this.actionType).append(", actionArgs=").append(this.actionArgs).append(", reasonCode=").append(this.reasonCode).append(", finishReason=").append(this.finishReason).append(", policy=").append(this.policy).append(", duration=").append(this.duration).append(", intentType=").append(this.intentType).append(", userAuthorizationType=");
            r0.append(this.userAuthorizationType).append(", riskLevel=").append(this.riskLevel).append(", executeId=").append(this.executeId).append(", instructionId=").append(this.instructionId).append(", stepId=").append(this.stepId).append(", omniLogId=").append(this.omniLogId).append(", toolName=").append(this.toolName).append(", deviceId=").append(this.deviceId).append(", instructionType=").append(this.instructionType).append(", doubaoMessageId=").append(this.doubaoMessageId).append(", originToolsName=").append(this.originToolsName).append(", oReferenceMsgId=").append(this.oReferenceMsgId);
            r0.append(", query=").append(this.query).append(", checkUserInputAuditInfo=").append(this.checkUserInputAuditInfo).append(", checkLlmOutputAuditInfo=").append(this.checkLlmOutputAuditInfo).append(", targetApkVersion=").append(this.targetApkVersion).append(", targetSignSha256=").append(this.targetSignSha256).append(", targetApkMd5=").append(this.targetApkMd5).append(", appVersion=").append(this.appVersion).append(", targetAppGrant=").append(this.targetAppGrant).append(')');
            return r0.toString();
        }

        public AuditPayload(String r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Long r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, List<String> r35, String r36, String r37, TargetAppGrant r38) {
            List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.aiagent.plugin");
            o.e(r8, "logType");
            o.e(r9, "targetPackage");
            o.e(r11, "errorCode");
            this.logType = r8;
            this.targetPackage = r9;
            this.targetActivity = r10;
            this.errorCode = r11;
            this.actionType = r12;
            this.actionArgs = r13;
            this.reasonCode = r14;
            this.finishReason = r15;
            this.policy = r16;
            this.duration = r17;
            this.intentType = r18;
            this.userAuthorizationType = r19;
            this.riskLevel = r20;
            this.executeId = r21;
            this.instructionId = r22;
            this.stepId = r23;
            this.omniLogId = r24;
            this.toolName = r25;
            this.deviceId = r26;
            this.instructionType = r27;
            this.doubaoMessageId = r28;
            this.originToolsName = r29;
            this.oReferenceMsgId = r30;
            this.query = r31;
            this.checkUserInputAuditInfo = r32;
            this.checkLlmOutputAuditInfo = r33;
            this.targetApkVersion = r34;
            this.targetSignSha256 = r4;
            this.targetApkMd5 = r36;
            this.appVersion = r37;
            this.targetAppGrant = r38;
        }

        public /* synthetic */ AuditPayload(String r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, Long r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, String r60, String r61, String r62, String r63, List r64, String r65, String r66, TargetAppGrant r67, int r68, h r69) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r64, List.class, "com.obric.aiagent.plugin");
            if ((r68 & 4) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r68 & 16) == 0) goto L9;
            String r9 = null;
        L11:
            if ((r68 & 32) == 0) goto L13;
            String r10 = null;
        L15:
            if ((r68 & 64) == 0) goto L17;
            String r11 = null;
        L19:
            if ((r68 & 128) == 0) goto L21;
            String r12 = null;
        L23:
            if ((r68 & 256) == 0) goto L25;
            String r13 = null;
        L27:
            if ((r68 & 512) == 0) goto L29;
            Long r14 = null;
        L31:
            if ((r68 & 1024) == 0) goto L33;
            String r15 = null;
        L35:
            if ((r68 & 2048) == 0) goto L37;
            String r16 = null;
        L39:
            if ((r68 & 4096) == 0) goto L41;
            String r17 = null;
        L43:
            if ((r68 & 8192) == 0) goto L45;
            String r18 = null;
        L47:
            if ((r68 & 16384) == 0) goto L49;
            String r19 = null;
        L51:
            if ((32768 & r68) == 0) goto L53;
            String r20 = null;
        L55:
            if ((65536 & r68) == 0) goto L57;
            String r21 = null;
        L59:
            if ((131072 & r68) == 0) goto L61;
            String r22 = null;
        L63:
            if ((262144 & r68) == 0) goto L65;
            String r23 = null;
        L67:
            if ((524288 & r68) == 0) goto L69;
            String r24 = null;
        L71:
            if ((1048576 & r68) == 0) goto L73;
            String r25 = null;
        L75:
            if ((2097152 & r68) == 0) goto L77;
            String r26 = null;
        L79:
            if ((4194304 & r68) == 0) goto L81;
            String r27 = null;
        L83:
            if ((8388608 & r68) == 0) goto L85;
            String r28 = null;
        L87:
            if ((16777216 & r68) == 0) goto L89;
            String r29 = null;
        L91:
            if ((33554432 & r68) == 0) goto L93;
            String r30 = null;
        L95:
            if ((67108864 & r68) == 0) goto L97;
            String r31 = null;
        L99:
            if ((134217728 & r68) == 0) goto L101;
            List r32 = null;
        L103:
            if ((268435456 & r68) == 0) goto L105;
            String r33 = null;
        L107:
            if ((536870912 & r68) == 0) goto L109;
            String r34 = null;
        L111:
            if ((r68 & 1073741824) == 0) goto L113;
            TargetAppGrant r35 = null;
        L114:
            this(r37, r38, r7, r40, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
            return;
        L113:
            r35 = r67;
            goto L114
        L109:
            r34 = r66;
            goto L111
        L105:
            r33 = r65;
            goto L107
        L101:
            r32 = r1;
            goto L103
        L97:
            r31 = r63;
            goto L99
        L93:
            r30 = r62;
            goto L95
        L89:
            r29 = r61;
            goto L91
        L85:
            r28 = r60;
            goto L87
        L81:
            r27 = r59;
            goto L83
        L77:
            r26 = r58;
            goto L79
        L73:
            r25 = r57;
            goto L75
        L69:
            r24 = r56;
            goto L71
        L65:
            r23 = r55;
            goto L67
        L61:
            r22 = r54;
            goto L63
        L57:
            r21 = r53;
            goto L59
        L53:
            r20 = r52;
            goto L55
        L49:
            r19 = r51;
            goto L51
        L45:
            r18 = r50;
            goto L47
        L41:
            r17 = r49;
            goto L43
        L37:
            r16 = r48;
            goto L39
        L33:
            r15 = r47;
            goto L35
        L29:
            r14 = r46;
            goto L31
        L25:
            r13 = r45;
            goto L27
        L21:
            r12 = r44;
            goto L23
        L17:
            r11 = r43;
            goto L19
        L13:
            r10 = r42;
            goto L15
        L9:
            r9 = r41;
            goto L11
        L5:
            r7 = r39;
            goto L7
        }

        public final String getLogType() {
            return this.logType;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public final String getTargetActivity() {
            return this.targetActivity;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getActionType() {
            return this.actionType;
        }

        public final String getActionArgs() {
            return this.actionArgs;
        }

        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final String getFinishReason() {
            return this.finishReason;
        }

        public final String getPolicy() {
            return this.policy;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getIntentType() {
            return this.intentType;
        }

        public final String getUserAuthorizationType() {
            return this.userAuthorizationType;
        }

        public final String getRiskLevel() {
            return this.riskLevel;
        }

        public final String getExecuteId() {
            return this.executeId;
        }

        public final String getInstructionId() {
            return this.instructionId;
        }

        public final String getStepId() {
            return this.stepId;
        }

        public final String getOmniLogId() {
            return this.omniLogId;
        }

        public final String getToolName() {
            return this.toolName;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getInstructionType() {
            return this.instructionType;
        }

        public final String getDoubaoMessageId() {
            return this.doubaoMessageId;
        }

        public final String getOriginToolsName() {
            return this.originToolsName;
        }

        public final String getOReferenceMsgId() {
            return this.oReferenceMsgId;
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getCheckUserInputAuditInfo() {
            return this.checkUserInputAuditInfo;
        }

        public final String getCheckLlmOutputAuditInfo() {
            return this.checkLlmOutputAuditInfo;
        }

        public final String getTargetApkVersion() {
            return this.targetApkVersion;
        }

        public final List<String> getTargetSignSha256() {
            return this.targetSignSha256;
        }

        public final String getTargetApkMd5() {
            return this.targetApkMd5;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final TargetAppGrant getTargetAppGrant() {
            return this.targetAppGrant;
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public static final class TargetAppGrant {
        private final String content;
        private final TargetAppGrantStatus status;
        private final String targetPackage;

        public static /* synthetic */ TargetAppGrant copy$default(TargetAppGrant r0, String r1, String r2, TargetAppGrantStatus r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.targetPackage;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.content;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.status;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.targetPackage;
        }

        public final String component2() {
            return this.content;
        }

        public final TargetAppGrantStatus component3() {
            return this.status;
        }

        public final TargetAppGrant copy(String r1, String r2, TargetAppGrantStatus r3) {
            o.e(r1, "targetPackage");
            o.e(r2, "content");
            o.e(r3, "status");
            return new TargetAppGrant(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, TargetAppGrant.class) == true) goto L8;
            return false;
        L8:
            TargetAppGrant r6 = (TargetAppGrant) ZeusTransformUtils.preCheckCast(r5, TargetAppGrant.class, "com.obric.aiagent.plugin");
            if (o.a(this.targetPackage, r6.targetPackage) == true) goto L12;
            return false;
        L12:
            if (o.a(this.content, r6.content) == true) goto L15;
            return false;
        L15:
            if (this.status == r6.status) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.targetPackage.hashCode() * 31) + this.content.hashCode()) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "TargetAppGrant(targetPackage=" + this.targetPackage + ", content=" + this.content + ", status=" + this.status + ')';
        }

        public TargetAppGrant(String r2, String r3, TargetAppGrantStatus r4) {
            o.e(r2, "targetPackage");
            o.e(r3, "content");
            o.e(r4, "status");
            this.targetPackage = r2;
            this.content = r3;
            this.status = r4;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public final String getContent() {
            return this.content;
        }

        public final TargetAppGrantStatus getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public static final enum TargetAppGrantStatus extends Enum<TargetAppGrantStatus> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ TargetAppGrantStatus[] $VALUES = null;
        public static final TargetAppGrantStatus DENY = null;
        public static final TargetAppGrantStatus GRANT = null;
        private final String wireValue;

        private static final /* synthetic */ TargetAppGrantStatus[] $values() {
            return new TargetAppGrantStatus[]{GRANT, DENY};
        }

        public static a<TargetAppGrantStatus> getEntries() {
            return $ENTRIES;
        }

        private TargetAppGrantStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.wireValue = r3;
        }

        public final String getWireValue() {
            return this.wireValue;
        }

        static {
            GRANT = new TargetAppGrantStatus("GRANT", 0, "grant");
            DENY = new TargetAppGrantStatus("DENY", 1, "deny");
            TargetAppGrantStatus[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static TargetAppGrantStatus valueOf(String r2) {
            return (TargetAppGrantStatus) ZeusTransformUtils.preCheckCast(Enum.valueOf(TargetAppGrantStatus.class, r2), TargetAppGrantStatus.class, "com.obric.aiagent.plugin");
        }

        public static TargetAppGrantStatus[] values() {
            return (TargetAppGrantStatus[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TargetAppGrantStatus[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public static final class TaskFinishAuditLogParams {
        private final String appVersion;
        private final String checkLlmOutputAuditInfo;
        private final String checkUserInputAuditInfo;
        private final String deviceId;
        private final String doubaoMessageId;
        private final Long duration;
        private final String errorCode;
        private final String executeId;
        private final String finishReason;
        private final String instructionId;
        private final String instructionType;
        private final String oReferenceMsgId;
        private final String omniLogId;
        private final String query;
        private final String riskLevel;
        private final String stepId;
        private final String targetPackage;
        private final String toolName;

        public static /* synthetic */ TaskFinishAuditLogParams copy$default(TaskFinishAuditLogParams r17, String r18, String r19, String r20, Long r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, int r36, Object r37) {
            if ((r36 & 1) == 0) goto L5;
            String r2 = r17.targetPackage;
        L7:
            if ((r36 & 2) == 0) goto L9;
            String r3 = r17.errorCode;
        L11:
            if ((r36 & 4) == 0) goto L13;
            String r4 = r17.finishReason;
        L15:
            if ((r36 & 8) == 0) goto L17;
            Long r5 = r17.duration;
        L19:
            if ((r36 & 16) == 0) goto L21;
            String r6 = r17.riskLevel;
        L23:
            if ((r36 & 32) == 0) goto L25;
            String r7 = r17.executeId;
        L27:
            if ((r36 & 64) == 0) goto L29;
            String r8 = r17.instructionId;
        L31:
            if ((r36 & 128) == 0) goto L33;
            String r9 = r17.stepId;
        L35:
            if ((r36 & 256) == 0) goto L37;
            String r10 = r17.omniLogId;
        L39:
            if ((r36 & 512) == 0) goto L41;
            String r11 = r17.toolName;
        L43:
            if ((r36 & 1024) == 0) goto L45;
            String r12 = r17.deviceId;
        L47:
            if ((r36 & 2048) == 0) goto L49;
            String r13 = r17.instructionType;
        L51:
            if ((r36 & 4096) == 0) goto L53;
            String r14 = r17.doubaoMessageId;
        L55:
            if ((r36 & 8192) == 0) goto L57;
            String r15 = r17.oReferenceMsgId;
        L58:
            String r38 = r15;
            if ((r36 & 16384) == 0) goto L61;
            String r16 = r17.query;
        L62:
            String r39 = r16;
            if ((r36 & 32768) == 0) goto L65;
            String r110 = r17.checkUserInputAuditInfo;
        L66:
            String r310 = r110;
            if ((r36 & 65536) == 0) goto L69;
            String r111 = r17.checkLlmOutputAuditInfo;
        L71:
            if ((r36 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
            String r1 = r17.appVersion;
        L75:
            return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r38, r39, r310, r111, r1);
        L73:
            r1 = r35;
            goto L75
        L69:
            r111 = r34;
            goto L71
        L65:
            r110 = r33;
            goto L66
        L61:
            r16 = r32;
            goto L62
        L57:
            r15 = r31;
            goto L58
        L53:
            r14 = r30;
            goto L55
        L49:
            r13 = r29;
            goto L51
        L45:
            r12 = r28;
            goto L47
        L41:
            r11 = r27;
            goto L43
        L37:
            r10 = r26;
            goto L39
        L33:
            r9 = r25;
            goto L35
        L29:
            r8 = r24;
            goto L31
        L25:
            r7 = r23;
            goto L27
        L21:
            r6 = r22;
            goto L23
        L17:
            r5 = r21;
            goto L19
        L13:
            r4 = r20;
            goto L15
        L9:
            r3 = r19;
            goto L11
        L5:
            r2 = r18;
            goto L7
        }

        public final String component1() {
            return this.targetPackage;
        }

        public final String component10() {
            return this.toolName;
        }

        public final String component11() {
            return this.deviceId;
        }

        public final String component12() {
            return this.instructionType;
        }

        public final String component13() {
            return this.doubaoMessageId;
        }

        public final String component14() {
            return this.oReferenceMsgId;
        }

        public final String component15() {
            return this.query;
        }

        public final String component16() {
            return this.checkUserInputAuditInfo;
        }

        public final String component17() {
            return this.checkLlmOutputAuditInfo;
        }

        public final String component18() {
            return this.appVersion;
        }

        public final String component2() {
            return this.errorCode;
        }

        public final String component3() {
            return this.finishReason;
        }

        public final Long component4() {
            return this.duration;
        }

        public final String component5() {
            return this.riskLevel;
        }

        public final String component6() {
            return this.executeId;
        }

        public final String component7() {
            return this.instructionId;
        }

        public final String component8() {
            return this.stepId;
        }

        public final String component9() {
            return this.omniLogId;
        }

        public final TaskFinishAuditLogParams copy(String r21, String r22, String r23, Long r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38) {
            o.e(r21, "targetPackage");
            o.e(r22, "errorCode");
            return new TaskFinishAuditLogParams(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, TaskFinishAuditLogParams.class) == true) goto L8;
            return false;
        L8:
            TaskFinishAuditLogParams r6 = (TaskFinishAuditLogParams) ZeusTransformUtils.preCheckCast(r5, TaskFinishAuditLogParams.class, "com.obric.aiagent.plugin");
            if (o.a(this.targetPackage, r6.targetPackage) == true) goto L12;
            return false;
        L12:
            if (o.a(this.errorCode, r6.errorCode) == true) goto L15;
            return false;
        L15:
            if (o.a(this.finishReason, r6.finishReason) == true) goto L18;
            return false;
        L18:
            if (o.a(this.duration, r6.duration) == true) goto L21;
            return false;
        L21:
            if (o.a(this.riskLevel, r6.riskLevel) == true) goto L24;
            return false;
        L24:
            if (o.a(this.executeId, r6.executeId) == true) goto L27;
            return false;
        L27:
            if (o.a(this.instructionId, r6.instructionId) == true) goto L30;
            return false;
        L30:
            if (o.a(this.stepId, r6.stepId) == true) goto L33;
            return false;
        L33:
            if (o.a(this.omniLogId, r6.omniLogId) == true) goto L36;
            return false;
        L36:
            if (o.a(this.toolName, r6.toolName) == true) goto L39;
            return false;
        L39:
            if (o.a(this.deviceId, r6.deviceId) == true) goto L42;
            return false;
        L42:
            if (o.a(this.instructionType, r6.instructionType) == true) goto L45;
            return false;
        L45:
            if (o.a(this.doubaoMessageId, r6.doubaoMessageId) == true) goto L48;
            return false;
        L48:
            if (o.a(this.oReferenceMsgId, r6.oReferenceMsgId) == true) goto L51;
            return false;
        L51:
            if (o.a(this.query, r6.query) == true) goto L54;
            return false;
        L54:
            if (o.a(this.checkUserInputAuditInfo, r6.checkUserInputAuditInfo) == true) goto L57;
            return false;
        L57:
            if (o.a(this.checkLlmOutputAuditInfo, r6.checkLlmOutputAuditInfo) == true) goto L60;
            return false;
        L60:
            if (o.a(this.appVersion, r6.appVersion) == true) goto L62;
            return false;
        L62:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.targetPackage.hashCode() * 31) + this.errorCode.hashCode()) * 31;
            String r1 = this.finishReason;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Long r5 = this.duration;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.riskLevel;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.executeId;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.instructionId;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.stepId;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.omniLogId;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.toolName;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.deviceId;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.instructionType;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.doubaoMessageId;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.oReferenceMsgId;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            String r38 = this.query;
            if (r38 != null) goto L53;
            int r39 = 0;
        L54:
            int r40 = (r37 + r39) * 31;
            String r41 = this.checkUserInputAuditInfo;
            if (r41 != null) goto L57;
            int r42 = 0;
        L58:
            int r43 = (r40 + r42) * 31;
            String r44 = this.checkLlmOutputAuditInfo;
            if (r44 != null) goto L61;
            int r45 = 0;
        L62:
            int r46 = (r43 + r45) * 31;
            String r47 = this.appVersion;
            if (r47 == null) goto L67;
            r2 = r47.hashCode();
        L67:
            return r46 + r2;
        L61:
            r45 = r44.hashCode();
            goto L62
        L57:
            r42 = r41.hashCode();
            goto L58
        L53:
            r39 = r38.hashCode();
            goto L54
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("TaskFinishAuditLogParams(targetPackage=").append(this.targetPackage).append(", errorCode=").append(this.errorCode).append(", finishReason=").append(this.finishReason).append(", duration=").append(this.duration).append(", riskLevel=").append(this.riskLevel).append(", executeId=").append(this.executeId).append(", instructionId=").append(this.instructionId).append(", stepId=").append(this.stepId).append(", omniLogId=").append(this.omniLogId).append(", toolName=").append(this.toolName).append(", deviceId=").append(this.deviceId).append(", instructionType=");
            r0.append(this.instructionType).append(", doubaoMessageId=").append(this.doubaoMessageId).append(", oReferenceMsgId=").append(this.oReferenceMsgId).append(", query=").append(this.query).append(", checkUserInputAuditInfo=").append(this.checkUserInputAuditInfo).append(", checkLlmOutputAuditInfo=").append(this.checkLlmOutputAuditInfo).append(", appVersion=").append(this.appVersion).append(')');
            return r0.toString();
        }

        public TaskFinishAuditLogParams(String r5, String r6, String r7, Long r8, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) {
            o.e(r5, "targetPackage");
            o.e(r6, "errorCode");
            this.targetPackage = r5;
            this.errorCode = r6;
            this.finishReason = r7;
            this.duration = r8;
            this.riskLevel = r9;
            this.executeId = r10;
            this.instructionId = r11;
            this.stepId = r12;
            this.omniLogId = r13;
            this.toolName = r14;
            this.deviceId = r15;
            this.instructionType = r16;
            this.doubaoMessageId = r17;
            this.oReferenceMsgId = r18;
            this.query = r19;
            this.checkUserInputAuditInfo = r20;
            this.checkLlmOutputAuditInfo = r21;
            this.appVersion = r22;
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getFinishReason() {
            return this.finishReason;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getRiskLevel() {
            return this.riskLevel;
        }

        public final String getExecuteId() {
            return this.executeId;
        }

        public final String getInstructionId() {
            return this.instructionId;
        }

        public final String getStepId() {
            return this.stepId;
        }

        public final String getOmniLogId() {
            return this.omniLogId;
        }

        public final String getToolName() {
            return this.toolName;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getInstructionType() {
            return this.instructionType;
        }

        public final String getDoubaoMessageId() {
            return this.doubaoMessageId;
        }

        public final String getOReferenceMsgId() {
            return this.oReferenceMsgId;
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getCheckUserInputAuditInfo() {
            return this.checkUserInputAuditInfo;
        }

        public final String getCheckLlmOutputAuditInfo() {
            return this.checkLlmOutputAuditInfo;
        }

        public /* synthetic */ TaskFinishAuditLogParams(String r23, String r24, String r25, Long r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, int r41, h r42) {
            if ((r41 & 4) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r41 & 8) == 0) goto L9;
            Long r7 = null;
        L11:
            if ((r41 & 16) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r41 & 32) == 0) goto L17;
            String r9 = null;
        L19:
            if ((r41 & 64) == 0) goto L21;
            String r10 = null;
        L23:
            if ((r41 & 128) == 0) goto L25;
            String r11 = null;
        L27:
            if ((r41 & 256) == 0) goto L29;
            String r12 = null;
        L31:
            if ((r41 & 512) == 0) goto L33;
            String r13 = null;
        L35:
            if ((r41 & 1024) == 0) goto L37;
            String r14 = null;
        L39:
            if ((r41 & 2048) == 0) goto L41;
            String r15 = null;
        L43:
            if ((r41 & 4096) == 0) goto L45;
            String r16 = null;
        L47:
            if ((r41 & 8192) == 0) goto L49;
            String r17 = null;
        L51:
            if ((r41 & 16384) == 0) goto L53;
            String r18 = null;
        L55:
            if ((32768 & r41) == 0) goto L57;
            String r19 = null;
        L59:
            if ((65536 & r41) == 0) goto L61;
            String r20 = null;
        L63:
            if ((r41 & UiType.FLAG_PHONE_CARD) == 0) goto L65;
            String r21 = IAppContext.Companion.getVersionName();
        L66:
            this(r23, r24, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
            return;
        L65:
            r21 = r40;
            goto L66
        L61:
            r20 = r39;
            goto L63
        L57:
            r19 = r38;
            goto L59
        L53:
            r18 = r37;
            goto L55
        L49:
            r17 = r36;
            goto L51
        L45:
            r16 = r35;
            goto L47
        L41:
            r15 = r34;
            goto L43
        L37:
            r14 = r33;
            goto L39
        L33:
            r13 = r32;
            goto L35
        L29:
            r12 = r31;
            goto L31
        L25:
            r11 = r30;
            goto L27
        L21:
            r10 = r29;
            goto L23
        L17:
            r9 = r28;
            goto L19
        L13:
            r8 = r27;
            goto L15
        L9:
            r7 = r26;
            goto L11
        L5:
            r6 = r25;
            goto L7
        }

        public final String getAppVersion() {
            return this.appVersion;
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public static final class ToolAuditLogParams {
        private final String actionArgs;
        private final String actionType;
        private final String checkLlmOutputAuditInfo;
        private final String checkUserInputAuditInfo;
        private final String deviceId;
        private final String doubaoMessageId;
        private final Long duration;
        private final String errorCode;
        private final String executeId;
        private final String instructionId;
        private final String instructionType;
        private final String oReferenceMsgId;
        private final String omniLogId;
        private final String originToolsName;
        private final String policy;
        private final String query;
        private final String reasonCode;
        private final String riskLevel;
        private final String stepId;
        private final String targetActivity;
        private final String targetApkMd5;
        private final String targetApkVersion;
        private final TargetAppGrant targetAppGrant;
        private final String targetPackage;
        private final List<String> targetSignSha256;
        private final String toolName;
        private final String userAuthorizationType;

        public static /* synthetic */ ToolAuditLogParams copy$default(ToolAuditLogParams r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, Long r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, List r42, String r43, TargetAppGrant r44, int r45, Object r46) {
            List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.aiagent.plugin");
            if ((r45 & 1) == 0) goto L5;
            String r3 = r17.targetPackage;
        L7:
            if ((r45 & 2) == 0) goto L9;
            String r4 = r17.targetActivity;
        L11:
            if ((r45 & 4) == 0) goto L13;
            String r5 = r17.errorCode;
        L15:
            if ((r45 & 8) == 0) goto L17;
            String r6 = r17.actionType;
        L19:
            if ((r45 & 16) == 0) goto L21;
            String r7 = r17.actionArgs;
        L23:
            if ((r45 & 32) == 0) goto L25;
            String r8 = r17.reasonCode;
        L27:
            if ((r45 & 64) == 0) goto L29;
            String r9 = r17.policy;
        L31:
            if ((r45 & 128) == 0) goto L33;
            Long r10 = r17.duration;
        L35:
            if ((r45 & 256) == 0) goto L37;
            String r11 = r17.userAuthorizationType;
        L39:
            if ((r45 & 512) == 0) goto L41;
            String r12 = r17.riskLevel;
        L43:
            if ((r45 & 1024) == 0) goto L45;
            String r13 = r17.executeId;
        L47:
            if ((r45 & 2048) == 0) goto L49;
            String r14 = r17.instructionId;
        L51:
            if ((r45 & 4096) == 0) goto L53;
            String r15 = r17.stepId;
        L55:
            if ((r45 & 8192) == 0) goto L57;
            String r16 = r17.omniLogId;
        L58:
            String r310 = r16;
            if ((r45 & 16384) == 0) goto L61;
            String r47 = r17.toolName;
        L62:
            String r311 = r47;
            if ((r45 & 32768) == 0) goto L65;
            String r48 = r17.deviceId;
        L66:
            String r312 = r48;
            if ((r45 & 65536) == 0) goto L69;
            String r49 = r17.instructionType;
        L70:
            String r313 = r49;
            if ((r45 & UiType.FLAG_PHONE_CARD) == 0) goto L73;
            String r50 = r17.doubaoMessageId;
        L74:
            String r314 = r50;
            if ((r45 & 262144) == 0) goto L77;
            String r51 = r17.originToolsName;
        L78:
            String r315 = r51;
            if ((r45 & UiType.FLAG_WIFI_QRCODE_CARD) == 0) goto L81;
            String r52 = r17.oReferenceMsgId;
        L82:
            String r316 = r52;
            if ((r45 & 1048576) == 0) goto L85;
            String r53 = r17.query;
        L86:
            String r317 = r53;
            if ((r45 & UiType.FLAG_REMOTE_CARD) == 0) goto L89;
            String r54 = r17.checkUserInputAuditInfo;
        L90:
            String r318 = r54;
            if ((r45 & UiType.FLAG_NO_FEEDBACK) == 0) goto L93;
            String r55 = r17.checkLlmOutputAuditInfo;
        L94:
            String r410 = r55;
            if ((r45 & UiType.FLAG_APPLET_CARD) == 0) goto L97;
            String r56 = r17.targetApkVersion;
        L98:
            String r411 = r56;
            if ((r45 & 16777216) == 0) goto L101;
            List<String> r57 = r17.targetSignSha256;
        L102:
            List<String> r412 = r57;
            if ((r45 & 33554432) == 0) goto L105;
            String r58 = r17.targetApkMd5;
        L107:
            if ((r45 & 67108864) == 0) goto L109;
            TargetAppGrant r1 = r17.targetAppGrant;
        L111:
            return r17.copy(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412, r58, r1);
        L109:
            r1 = r44;
            goto L111
        L105:
            r58 = r43;
            goto L107
        L101:
            r57 = r2;
            goto L102
        L97:
            r56 = r41;
            goto L98
        L93:
            r55 = r40;
            goto L94
        L89:
            r54 = r39;
            goto L90
        L85:
            r53 = r38;
            goto L86
        L81:
            r52 = r37;
            goto L82
        L77:
            r51 = r36;
            goto L78
        L73:
            r50 = r35;
            goto L74
        L69:
            r49 = r34;
            goto L70
        L65:
            r48 = r33;
            goto L66
        L61:
            r47 = r32;
            goto L62
        L57:
            r16 = r31;
            goto L58
        L53:
            r15 = r30;
            goto L55
        L49:
            r14 = r29;
            goto L51
        L45:
            r13 = r28;
            goto L47
        L41:
            r12 = r27;
            goto L43
        L37:
            r11 = r26;
            goto L39
        L33:
            r10 = r25;
            goto L35
        L29:
            r9 = r24;
            goto L31
        L25:
            r8 = r23;
            goto L27
        L21:
            r7 = r22;
            goto L23
        L17:
            r6 = r21;
            goto L19
        L13:
            r5 = r20;
            goto L15
        L9:
            r4 = r19;
            goto L11
        L5:
            r3 = r18;
            goto L7
        }

        public final String component1() {
            return this.targetPackage;
        }

        public final String component10() {
            return this.riskLevel;
        }

        public final String component11() {
            return this.executeId;
        }

        public final String component12() {
            return this.instructionId;
        }

        public final String component13() {
            return this.stepId;
        }

        public final String component14() {
            return this.omniLogId;
        }

        public final String component15() {
            return this.toolName;
        }

        public final String component16() {
            return this.deviceId;
        }

        public final String component17() {
            return this.instructionType;
        }

        public final String component18() {
            return this.doubaoMessageId;
        }

        public final String component19() {
            return this.originToolsName;
        }

        public final String component2() {
            return this.targetActivity;
        }

        public final String component20() {
            return this.oReferenceMsgId;
        }

        public final String component21() {
            return this.query;
        }

        public final String component22() {
            return this.checkUserInputAuditInfo;
        }

        public final String component23() {
            return this.checkLlmOutputAuditInfo;
        }

        public final String component24() {
            return this.targetApkVersion;
        }

        public final List<String> component25() {
            return this.targetSignSha256;
        }

        public final String component26() {
            return this.targetApkMd5;
        }

        public final TargetAppGrant component27() {
            return this.targetAppGrant;
        }

        public final String component3() {
            return this.errorCode;
        }

        public final String component4() {
            return this.actionType;
        }

        public final String component5() {
            return this.actionArgs;
        }

        public final String component6() {
            return this.reasonCode;
        }

        public final String component7() {
            return this.policy;
        }

        public final Long component8() {
            return this.duration;
        }

        public final String component9() {
            return this.userAuthorizationType;
        }

        public final ToolAuditLogParams copy(String r30, String r31, String r32, String r33, String r34, String r35, String r36, Long r37, String r38, String r39, String r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, List<String> r54, String r55, TargetAppGrant r56) {
            List r25 = (List) ZeusTransformUtils.wrapperContextForParams(r54, List.class, "com.obric.aiagent.plugin");
            o.e(r30, "targetPackage");
            o.e(r32, "errorCode");
            return new ToolAuditLogParams(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r25, r55, r56);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ToolAuditLogParams.class) == true) goto L8;
            return false;
        L8:
            ToolAuditLogParams r6 = (ToolAuditLogParams) ZeusTransformUtils.preCheckCast(r5, ToolAuditLogParams.class, "com.obric.aiagent.plugin");
            if (o.a(this.targetPackage, r6.targetPackage) == true) goto L12;
            return false;
        L12:
            if (o.a(this.targetActivity, r6.targetActivity) == true) goto L15;
            return false;
        L15:
            if (o.a(this.errorCode, r6.errorCode) == true) goto L18;
            return false;
        L18:
            if (o.a(this.actionType, r6.actionType) == true) goto L21;
            return false;
        L21:
            if (o.a(this.actionArgs, r6.actionArgs) == true) goto L24;
            return false;
        L24:
            if (o.a(this.reasonCode, r6.reasonCode) == true) goto L27;
            return false;
        L27:
            if (o.a(this.policy, r6.policy) == true) goto L30;
            return false;
        L30:
            if (o.a(this.duration, r6.duration) == true) goto L33;
            return false;
        L33:
            if (o.a(this.userAuthorizationType, r6.userAuthorizationType) == true) goto L36;
            return false;
        L36:
            if (o.a(this.riskLevel, r6.riskLevel) == true) goto L39;
            return false;
        L39:
            if (o.a(this.executeId, r6.executeId) == true) goto L42;
            return false;
        L42:
            if (o.a(this.instructionId, r6.instructionId) == true) goto L45;
            return false;
        L45:
            if (o.a(this.stepId, r6.stepId) == true) goto L48;
            return false;
        L48:
            if (o.a(this.omniLogId, r6.omniLogId) == true) goto L51;
            return false;
        L51:
            if (o.a(this.toolName, r6.toolName) == true) goto L54;
            return false;
        L54:
            if (o.a(this.deviceId, r6.deviceId) == true) goto L57;
            return false;
        L57:
            if (o.a(this.instructionType, r6.instructionType) == true) goto L60;
            return false;
        L60:
            if (o.a(this.doubaoMessageId, r6.doubaoMessageId) == true) goto L63;
            return false;
        L63:
            if (o.a(this.originToolsName, r6.originToolsName) == true) goto L66;
            return false;
        L66:
            if (o.a(this.oReferenceMsgId, r6.oReferenceMsgId) == true) goto L69;
            return false;
        L69:
            if (o.a(this.query, r6.query) == true) goto L72;
            return false;
        L72:
            if (o.a(this.checkUserInputAuditInfo, r6.checkUserInputAuditInfo) == true) goto L75;
            return false;
        L75:
            if (o.a(this.checkLlmOutputAuditInfo, r6.checkLlmOutputAuditInfo) == true) goto L78;
            return false;
        L78:
            if (o.a(this.targetApkVersion, r6.targetApkVersion) == true) goto L81;
            return false;
        L81:
            if (o.a(this.targetSignSha256, r6.targetSignSha256) == true) goto L84;
            return false;
        L84:
            if (o.a(this.targetApkMd5, r6.targetApkMd5) == true) goto L87;
            return false;
        L87:
            if (o.a(this.targetAppGrant, r6.targetAppGrant) == true) goto L89;
            return false;
        L89:
            return true;
        }

        public int hashCode() {
            int r0 = this.targetPackage.hashCode() * 31;
            String r1 = this.targetActivity;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.errorCode.hashCode()) * 31;
            String r5 = this.actionType;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.actionArgs;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.reasonCode;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.policy;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.duration;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.userAuthorizationType;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.riskLevel;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.executeId;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.instructionId;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.stepId;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.omniLogId;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            String r38 = this.toolName;
            if (r38 != null) goto L53;
            int r39 = 0;
        L54:
            int r40 = (r37 + r39) * 31;
            String r41 = this.deviceId;
            if (r41 != null) goto L57;
            int r42 = 0;
        L58:
            int r43 = (r40 + r42) * 31;
            String r44 = this.instructionType;
            if (r44 != null) goto L61;
            int r45 = 0;
        L62:
            int r46 = (r43 + r45) * 31;
            String r47 = this.doubaoMessageId;
            if (r47 != null) goto L65;
            int r48 = 0;
        L66:
            int r49 = (r46 + r48) * 31;
            String r50 = this.originToolsName;
            if (r50 != null) goto L69;
            int r51 = 0;
        L70:
            int r52 = (r49 + r51) * 31;
            String r53 = this.oReferenceMsgId;
            if (r53 != null) goto L73;
            int r54 = 0;
        L74:
            int r55 = (r52 + r54) * 31;
            String r56 = this.query;
            if (r56 != null) goto L77;
            int r57 = 0;
        L78:
            int r58 = (r55 + r57) * 31;
            String r59 = this.checkUserInputAuditInfo;
            if (r59 != null) goto L81;
            int r60 = 0;
        L82:
            int r61 = (r58 + r60) * 31;
            String r62 = this.checkLlmOutputAuditInfo;
            if (r62 != null) goto L85;
            int r63 = 0;
        L86:
            int r64 = (r61 + r63) * 31;
            String r65 = this.targetApkVersion;
            if (r65 != null) goto L89;
            int r66 = 0;
        L90:
            int r67 = (r64 + r66) * 31;
            List<String> r68 = this.targetSignSha256;
            if (r68 != null) goto L93;
            int r69 = 0;
        L94:
            int r70 = (r67 + r69) * 31;
            String r71 = this.targetApkMd5;
            if (r71 != null) goto L97;
            int r72 = 0;
        L98:
            int r73 = (r70 + r72) * 31;
            TargetAppGrant r74 = this.targetAppGrant;
            if (r74 == null) goto L103;
            r2 = r74.hashCode();
        L103:
            return r73 + r2;
        L97:
            r72 = r71.hashCode();
            goto L98
        L93:
            r69 = r68.hashCode();
            goto L94
        L89:
            r66 = r65.hashCode();
            goto L90
        L85:
            r63 = r62.hashCode();
            goto L86
        L81:
            r60 = r59.hashCode();
            goto L82
        L77:
            r57 = r56.hashCode();
            goto L78
        L73:
            r54 = r53.hashCode();
            goto L74
        L69:
            r51 = r50.hashCode();
            goto L70
        L65:
            r48 = r47.hashCode();
            goto L66
        L61:
            r45 = r44.hashCode();
            goto L62
        L57:
            r42 = r41.hashCode();
            goto L58
        L53:
            r39 = r38.hashCode();
            goto L54
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("ToolAuditLogParams(targetPackage=").append(this.targetPackage).append(", targetActivity=").append(this.targetActivity).append(", errorCode=").append(this.errorCode).append(", actionType=").append(this.actionType).append(", actionArgs=").append(this.actionArgs).append(", reasonCode=").append(this.reasonCode).append(", policy=").append(this.policy).append(", duration=").append(this.duration).append(", userAuthorizationType=").append(this.userAuthorizationType).append(", riskLevel=").append(this.riskLevel).append(", executeId=").append(this.executeId).append(", instructionId=");
            r0.append(this.instructionId).append(", stepId=").append(this.stepId).append(", omniLogId=").append(this.omniLogId).append(", toolName=").append(this.toolName).append(", deviceId=").append(this.deviceId).append(", instructionType=").append(this.instructionType).append(", doubaoMessageId=").append(this.doubaoMessageId).append(", originToolsName=").append(this.originToolsName).append(", oReferenceMsgId=").append(this.oReferenceMsgId).append(", query=").append(this.query).append(", checkUserInputAuditInfo=").append(this.checkUserInputAuditInfo).append(", checkLlmOutputAuditInfo=").append(this.checkLlmOutputAuditInfo);
            r0.append(", targetApkVersion=").append(this.targetApkVersion).append(", targetSignSha256=").append(this.targetSignSha256).append(", targetApkMd5=").append(this.targetApkMd5).append(", targetAppGrant=").append(this.targetAppGrant).append(')');
            return r0.toString();
        }

        public ToolAuditLogParams(String r7, String r8, String r9, String r10, String r11, String r12, String r13, Long r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, List<String> r31, String r32, TargetAppGrant r33) {
            List<String> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
            o.e(r7, "targetPackage");
            o.e(r9, "errorCode");
            this.targetPackage = r7;
            this.targetActivity = r8;
            this.errorCode = r9;
            this.actionType = r10;
            this.actionArgs = r11;
            this.reasonCode = r12;
            this.policy = r13;
            this.duration = r14;
            this.userAuthorizationType = r15;
            this.riskLevel = r16;
            this.executeId = r17;
            this.instructionId = r18;
            this.stepId = r19;
            this.omniLogId = r20;
            this.toolName = r21;
            this.deviceId = r22;
            this.instructionType = r23;
            this.doubaoMessageId = r24;
            this.originToolsName = r25;
            this.oReferenceMsgId = r26;
            this.query = r27;
            this.checkUserInputAuditInfo = r28;
            this.checkLlmOutputAuditInfo = r29;
            this.targetApkVersion = r30;
            this.targetSignSha256 = r3;
            this.targetApkMd5 = r32;
            this.targetAppGrant = r33;
        }

        public /* synthetic */ ToolAuditLogParams(String r33, String r34, String r35, String r36, String r37, String r38, String r39, Long r40, String r41, String r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, String r55, String r56, List r57, String r58, TargetAppGrant r59, int r60, h r61) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r57, List.class, "com.obric.aiagent.plugin");
            if ((r60 & 2) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r60 & 8) == 0) goto L9;
            String r8 = null;
        L11:
            if ((r60 & 16) == 0) goto L13;
            String r9 = null;
        L15:
            if ((r60 & 32) == 0) goto L17;
            String r10 = null;
        L19:
            if ((r60 & 64) == 0) goto L21;
            String r11 = null;
        L23:
            if ((r60 & 128) == 0) goto L25;
            Long r12 = null;
        L27:
            if ((r60 & 256) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r60 & 512) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r60 & 1024) == 0) goto L37;
            String r15 = null;
        L39:
            if ((r60 & 2048) == 0) goto L41;
            String r16 = null;
        L43:
            if ((r60 & 4096) == 0) goto L45;
            String r17 = null;
        L47:
            if ((r60 & 8192) == 0) goto L49;
            String r18 = null;
        L51:
            if ((r60 & 16384) == 0) goto L53;
            String r19 = null;
        L55:
            if ((32768 & r60) == 0) goto L57;
            String r20 = null;
        L59:
            if ((65536 & r60) == 0) goto L61;
            String r21 = null;
        L63:
            if ((131072 & r60) == 0) goto L65;
            String r22 = null;
        L67:
            if ((262144 & r60) == 0) goto L69;
            String r23 = null;
        L71:
            if ((524288 & r60) == 0) goto L73;
            String r24 = null;
        L75:
            if ((1048576 & r60) == 0) goto L77;
            String r25 = null;
        L79:
            if ((2097152 & r60) == 0) goto L81;
            String r26 = null;
        L83:
            if ((4194304 & r60) == 0) goto L85;
            String r27 = null;
        L87:
            if ((8388608 & r60) == 0) goto L89;
            String r28 = null;
        L91:
            if ((16777216 & r60) == 0) goto L93;
            List r29 = null;
        L95:
            if ((33554432 & r60) == 0) goto L97;
            String r30 = null;
        L99:
            if ((r60 & 67108864) == 0) goto L101;
            TargetAppGrant r31 = null;
        L102:
            this(r33, r6, r35, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31);
            return;
        L101:
            r31 = r59;
            goto L102
        L97:
            r30 = r58;
            goto L99
        L93:
            r29 = r1;
            goto L95
        L89:
            r28 = r56;
            goto L91
        L85:
            r27 = r55;
            goto L87
        L81:
            r26 = r54;
            goto L83
        L77:
            r25 = r53;
            goto L79
        L73:
            r24 = r52;
            goto L75
        L69:
            r23 = r51;
            goto L71
        L65:
            r22 = r50;
            goto L67
        L61:
            r21 = r49;
            goto L63
        L57:
            r20 = r48;
            goto L59
        L53:
            r19 = r47;
            goto L55
        L49:
            r18 = r46;
            goto L51
        L45:
            r17 = r45;
            goto L47
        L41:
            r16 = r44;
            goto L43
        L37:
            r15 = r43;
            goto L39
        L33:
            r14 = r42;
            goto L35
        L29:
            r13 = r41;
            goto L31
        L25:
            r12 = r40;
            goto L27
        L21:
            r11 = r39;
            goto L23
        L17:
            r10 = r38;
            goto L19
        L13:
            r9 = r37;
            goto L15
        L9:
            r8 = r36;
            goto L11
        L5:
            r6 = r34;
            goto L7
        }

        public final String getTargetPackage() {
            return this.targetPackage;
        }

        public final String getTargetActivity() {
            return this.targetActivity;
        }

        public final String getErrorCode() {
            return this.errorCode;
        }

        public final String getActionType() {
            return this.actionType;
        }

        public final String getActionArgs() {
            return this.actionArgs;
        }

        public final String getReasonCode() {
            return this.reasonCode;
        }

        public final String getPolicy() {
            return this.policy;
        }

        public final Long getDuration() {
            return this.duration;
        }

        public final String getUserAuthorizationType() {
            return this.userAuthorizationType;
        }

        public final String getRiskLevel() {
            return this.riskLevel;
        }

        public final String getExecuteId() {
            return this.executeId;
        }

        public final String getInstructionId() {
            return this.instructionId;
        }

        public final String getStepId() {
            return this.stepId;
        }

        public final String getOmniLogId() {
            return this.omniLogId;
        }

        public final String getToolName() {
            return this.toolName;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getInstructionType() {
            return this.instructionType;
        }

        public final String getDoubaoMessageId() {
            return this.doubaoMessageId;
        }

        public final String getOriginToolsName() {
            return this.originToolsName;
        }

        public final String getOReferenceMsgId() {
            return this.oReferenceMsgId;
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getCheckUserInputAuditInfo() {
            return this.checkUserInputAuditInfo;
        }

        public final String getCheckLlmOutputAuditInfo() {
            return this.checkLlmOutputAuditInfo;
        }

        public final String getTargetApkVersion() {
            return this.targetApkVersion;
        }

        public final List<String> getTargetSignSha256() {
            return this.targetSignSha256;
        }

        public final String getTargetApkMd5() {
            return this.targetApkMd5;
        }

        public final TargetAppGrant getTargetAppGrant() {
            return this.targetAppGrant;
        }
    }

    /* JADX INFO: compiled from: AOSystemTools.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[AgentType.values().length];
            r0[AgentType.RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[AgentType.SUGGESTIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L29:
            r0[AgentType.ASSISTIVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L23:
            r0[AgentType.AUTONOMOUS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L8:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[AgentOperationStatus.values().length];
            r1[AgentOperationStatus.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[AgentOperationStatus.STOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L11:
            $EnumSwitchMapping$1 = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$endRobotsSessionAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$endRobotsSessionAsync$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super n<? extends x>>, Object> {
        final /* synthetic */ Context $appCtx;
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Context r3, d<? super AnonymousClass1> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$appCtx = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$appCtx, r5);
            r0.L$0 = r3;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super n<? extends x>> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super n<x>> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.label != 0) goto L15;
            d.o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            Context r4 = this.$appCtx;
            n.a r7 = n.f38560a;     // Catch: Throwable -> L7
            com.bytedance.agentrobots.policy.d.a(r4).b();     // Catch: Throwable -> L7
            Loog.INSTANCE.i(AOAgentRobotsTools.TAG, "robots endSession ok");     // Catch: Throwable -> L7
            Object r8 = n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r9 = n.c(r8);
            if (r9 == null) goto L12;
            Loog.INSTANCE.e(AOAgentRobotsTools.TAG, "robots endSession failed: " + r9.getMessage(), r9);
        L12:
            n r10 = n.g(r8);
            r10.a();
            AOAgentRobotsTools.access$getSRobotsSessionId$p().set(null);
            return r10;
        L7:
            th = move-exception;
            n.a r11 = n.f38560a;
            r8 = n.f(d.o.a(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$logTopActivityPolicyAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$logTopActivityPolicyAsync$1")
    static final class C11341 extends l implements m<am, d<? super n<? extends x>>, Object> {
        final /* synthetic */ Context $appCtx;
        final /* synthetic */ String $reason;
        private /* synthetic */ Object L$0;
        int label;

        C11341(Context r3, String r4, d<? super C11341> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$appCtx = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.$reason = r4;
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            C11341 r0 = new C11341(this.$appCtx, this.$reason, r6);
            r0.L$0 = r4;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super n<? extends x>> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super n<x>> r4) {
            return ((C11341) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11341.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.label != 0) goto L47;
            d.o.a(r8);
            am r9 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            Context r10 = this.$appCtx;
            String r7 = this.$reason;
            n.a r1 = n.f38560a;     // Catch: Throwable -> L39
            IAutoActionDisplayApi r2 = AOPlatformTools.INSTANCE.display();     // Catch: Throwable -> L39
            o.a(r10);     // Catch: Throwable -> L39
            DisplayAccessor r3 = r2.getMDAccess(r10);     // Catch: Throwable -> L39
            String r4 = null;
            if (r3 == null) goto L10;
            DisplayedAppInfo r5 = r3.getTopDisplayedApp();     // Catch: Throwable -> L39
            if (r5 == null) goto L10;
            ComponentName r6 = r5.getTopActivity();     // Catch: Throwable -> L39
        L11:
            if (r6 == null) goto L13;
            String r11 = r6.getPackageName();     // Catch: Throwable -> L39
        L14:
            if (r6 == null) goto L16;
            r4 = r6.getClassName();     // Catch: Throwable -> L39
        L16:
            CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
            boolean r13 = false;
            if (r12 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == true) goto L36;
            CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L39
            if (r15 != null) goto L27;
        L28:
            r13 = true;
        L29:
            if (r13 == true) goto L36;
            String r16 = AOAgentRobotsTools.INSTANCE.acquireTargetPolicy(r10, r11, r4);     // Catch: Throwable -> L39
            if (r16 == null) goto L34;
            int r17 = r16.length();     // Catch: Throwable -> L39
        L35:
            Loog.INSTANCE.i(AOAgentRobotsTools.TAG, "topActivityPolicy reason=" + r7 + ", top=" + r11 + '/' + r4 + ", policySize=" + r17);     // Catch: Throwable -> L39
        L37:
            Object r18 = n.f(x.f38692a);     // Catch: Throwable -> L39
        L41:
            Throwable r19 = n.c(r18);
            if (r19 == null) goto L45;
            Loog.INSTANCE.e(AOAgentRobotsTools.TAG, "logTopActivityPolicy exception: " + r19.getMessage(), r19);
        L45:
            return n.g(r18);
        L34:
            r17 = -1;
            goto L35
        L27:
            if (d.o.o.d(r15) == false) goto L29;
        L36:
            Loog.INSTANCE.w(AOAgentRobotsTools.TAG, "logTopActivityPolicy skipped: topActivity is null, reason=" + r7);     // Catch: Throwable -> L39
            goto L37
        L19:
            if (d.o.o.d(r12) == true) goto L22;
            r14 = false;
            goto L23
        L13:
            r11 = null;
        L10:
            r6 = null;
        L39:
            th = move-exception;
            n.a r20 = n.f38560a;
            r18 = n.f(d.o.a(th));
            goto L41
        L47:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$registerAgentAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {259}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$registerAgentAsync$1")
    static final class C11351 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ String $agentName;
        final /* synthetic */ AgentType $agentType;
        final /* synthetic */ Context $appCtx;
        int label;

        C11351(String r3, AgentType r4, Context r5, d<? super C11351> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.$agentName = r3;
            this.$agentType = r4;
            this.$appCtx = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11351(this.$agentName, this.$agentType, this.$appCtx, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11351) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11351.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            d.o.a(r10);     // Catch: Throwable -> L7
        L16:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L18;
            Loog.INSTANCE.w(AOAgentRobotsTools.TAG, "registerAgent exhausted 3 attempts, name=" + this.$agentName + ", type=" + this.$agentType);     // Catch: Throwable -> L7
        L18:
            AOAgentRobotsTools.access$getSRegisterInFlight$p().set(false);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            d.o.a(r10);
            AgentRegistrationRetryRunner r11 = AOAgentRobotsTools.access$getSRegistrationRetryRunner$p();     // Catch: Throwable -> L7
            m<? super Integer, ? super d<? super Boolean>, ? extends Object> r2 = (m) ZeusTransformUtils.preCheckCast(new AOAgentRobotsTools$registerAgentAsync$1$registered$1(this.$appCtx, this.$agentName, this.$agentType, null), m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            d<? super Boolean> r5 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r10 = r11.run(r2, r5);     // Catch: Throwable -> L7
            if (r10 != r0) goto L16;
            return r0;
        L7:
            th = move-exception;
            AOAgentRobotsTools.access$getSRegisterInFlight$p().set(false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$scheduleOperationIdentityReady$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$scheduleOperationIdentityReady$1")
    static final class C11361 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ String $agentUuid;
        final /* synthetic */ Context $appCtx;
        int label;

        C11361(Context r3, String r4, d<? super C11361> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$appCtx = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.$agentUuid = r4;
            super(1, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11361(this.$appCtx, this.$agentUuid, r5), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11361) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11361.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            d.o.a(r2);
            AOAgentRobotsTools r3 = AOAgentRobotsTools.INSTANCE;
            AOAgentRobotsTools.access$setSOperationAppContext$p(this.$appCtx);
            AOAgentRobotsTools r4 = AOAgentRobotsTools.INSTANCE;
            AOAgentRobotsTools.access$setSOperationAgentUuid$p(this.$agentUuid);
            AOAgentRobotsTools.access$getSOperationTargetDispatcher$p().onIdentityReady();
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$startRobotsSessionAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$startRobotsSessionAsync$1")
    static final class C11371 extends l implements m<am, d<? super n<? extends x>>, Object> {
        final /* synthetic */ Context $appCtx;
        final /* synthetic */ String $sid;
        private /* synthetic */ Object L$0;
        int label;

        C11371(String r3, Context r4, d<? super C11371> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$sid = r3;
            this.$appCtx = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            C11371 r0 = new C11371(this.$sid, this.$appCtx, r6);
            r0.L$0 = r4;
            return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super n<? extends x>> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super n<x>> r4) {
            return ((C11371) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11371.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            d.c.a.b.a();
            if (this.label != 0) goto L15;
            d.o.a(r5);
            am r6 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
            String r7 = this.$sid;
            Context r4 = this.$appCtx;
            n.a r1 = n.f38560a;     // Catch: Throwable -> L7
            AOAgentRobotsTools.access$getSRobotsSessionId$p().set(r7);     // Catch: Throwable -> L7
            AOAgentRobotsTools.access$getSAuditStepCounter$p().set(0);     // Catch: Throwable -> L7
            com.bytedance.agentrobots.policy.d.a(r4).a(r7);     // Catch: Throwable -> L7
            Loog.INSTANCE.i(AOAgentRobotsTools.TAG, "robots startSession ok, sessionId=" + r7);     // Catch: Throwable -> L7
            Object r8 = n.f(x.f38692a);     // Catch: Throwable -> L7
        L9:
            Throwable r9 = n.c(r8);
            if (r9 == null) goto L13;
            AOAgentRobotsTools.access$getSSessionActive$p().set(false);
            AOAgentRobotsTools.access$getSRobotsSessionId$p().set(null);
            Loog.INSTANCE.e(AOAgentRobotsTools.TAG, "robots startSession failed: " + r9.getMessage(), r9);
        L13:
            return n.g(r8);
        L7:
            th = move-exception;
            n.a r10 = n.f38560a;
            r8 = n.f(d.o.a(th));
            goto L9
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$updateOperationTarget$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$updateOperationTarget$1")
    static final class C11381 extends l implements d.h.a.b<d<? super x>, Object> {
        final /* synthetic */ String $normalizedTarget;
        int label;

        C11381(String r3, d<? super C11381> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$normalizedTarget = r3;
            super(1, r5);
        }

        @Override // d.c.b.a.a
        public final d<x> create(d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11381(this.$normalizedTarget, r4), d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(d<? super x> r3) {
            return ((C11381) ZeusTransformUtils.preCheckCast(create((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin")), C11381.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d<? super x> r3) {
            return invoke2((d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            d.o.a(r2);
            AOAgentRobotsTools.access$getSOperationTargetDispatcher$p().updateTarget(this.$normalizedTarget);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.AOAgentRobotsTools$writeTaskFinishAuditLogAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AOSystemTools.kt */
    @f(b = "AOSystemTools.kt", c = {}, d = "invokeSuspend", e = "com.obric.autogui.common.api.AOAgentRobotsTools$writeTaskFinishAuditLogAsync$1")
    static final class C11391 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ TaskFinishAuditLogParams $params;
        int label;

        C11391(Context r3, TaskFinishAuditLogParams r4, d<? super C11391> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.$params = r4;
            super(2, r7);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11391(this.$context, this.$params, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11391) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11391.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r38) {
            d.c.a.b.a();
            if (this.label != 0) goto L7;
            d.o.a(r38);
            String r4 = "task";
            String r0 = "";
            AOAgentRobotsTools.access$writeAuditLogInternal(AOAgentRobotsTools.INSTANCE, this.$context, new AuditPayload(r4, this.$params.getTargetPackage(), null, this.$params.getErrorCode(), r0, null, null, this.$params.getFinishReason(), null, this.$params.getDuration(), this.$params.getToolName(), null, this.$params.getRiskLevel(), this.$params.getExecuteId(), this.$params.getInstructionId(), this.$params.getStepId(), this.$params.getOmniLogId(), this.$params.getToolName(), this.$params.getDeviceId(), this.$params.getInstructionType(), this.$params.getDoubaoMessageId(), null, this.$params.getOReferenceMsgId(), this.$params.getQuery(), this.$params.getCheckUserInputAuditInfo(), this.$params.getCheckLlmOutputAuditInfo(), null, null, null, this.$params.getAppVersion(), null, 1545603396, null));
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String auditErrorDesc(int r1) {
        if (r1 == (-100)) goto L17;
        switch(r1) {
            case -10: goto L16;
            case -9: goto L15;
            case -8: goto L14;
            case -7: goto L13;
            case -6: goto L12;
            case -5: goto L11;
            case -4: goto L10;
            case -3: goto L9;
            case -2: goto L8;
            case -1: goto L7;
            case 0: goto L6;
            default: goto L5;
        };
    L5:
        return "UNKNOWN";
    L6:
        return "AUDIT_SUCCESS";
    L7:
        return "AUDIT_ERR_INVALID_INPUT";
    L8:
        return "AUDIT_ERR_INVALID_JSON";
    L9:
        return "AUDIT_ERR_MISSING_FIELD";
    L10:
        return "AUDIT_ERR_WRITE_FAILED";
    L11:
        return "AUDIT_ERR_RATE_LIMIT";
    L12:
        return "AUDIT_ERR_SERVICE_NOT_READY";
    L13:
        return "AUDIT_ERR_PERMISSION_DENIED";
    L14:
        return "AUDIT_ERR_TIMEOUT";
    L15:
        return "AUDIT_ERR_REMOTE_EXCEPTION";
    L16:
        return "ERR_ROBOTS_DISABLED";
    L17:
        return "AUDIT_ERR_UNKNOWN";
    }

    public static /* synthetic */ x lambda$79jYz5ljx4bnBi6ASezw_MgijK4(String r0, AgentOperationStatus r1, Throwable r2) {
        return sOperationTargetDispatcher$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ CharSequence lambda$mKtqIKpSUopKHQ3ANfHQH4dErCc(byte r0) {
        return computePackageBaseApkMd5$lambda$18(r0);
    }

    public static /* synthetic */ x lambda$zMKTMJ7LjcMKrERuo8zWN9_vvhs(long r0, d.h.a.a r2) {
        return sOperationTargetDispatcher$lambda$1(r0, r2);
    }

    private AOAgentRobotsTools() {
    }

    public static final /* synthetic */ AtomicLong access$getSAuditStepCounter$p() {
        return sAuditStepCounter;
    }

    public static final /* synthetic */ AgentOperationTargetDispatcher access$getSOperationTargetDispatcher$p() {
        return sOperationTargetDispatcher;
    }

    public static final /* synthetic */ AtomicBoolean access$getSRegisterInFlight$p() {
        return sRegisterInFlight;
    }

    public static final /* synthetic */ AgentRegistrationRetryRunner access$getSRegistrationRetryRunner$p() {
        return sRegistrationRetryRunner;
    }

    public static final /* synthetic */ AtomicReference access$getSRobotsSessionId$p() {
        return sRobotsSessionId;
    }

    public static final /* synthetic */ AtomicBoolean access$getSSessionActive$p() {
        return sSessionActive;
    }

    public static final /* synthetic */ void access$notifyOperationState(AOAgentRobotsTools r0, String r1, AgentOperationStatus r2) {
        r0.notifyOperationState(r1, r2);
    }

    public static final /* synthetic */ Object access$registerAgentOnce(AOAgentRobotsTools r8, Context r9, String r10, AgentType r11, int r12, d r13) {
        return r8.registerAgentOnce((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, r11, r12, (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$setSOperationAgentUuid$p(String r0) {
        sOperationAgentUuid = r0;
    }

    public static final /* synthetic */ void access$setSOperationAppContext$p(Context r2) {
        sOperationAppContext = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$writeAuditLogInternal(AOAgentRobotsTools r2, Context r3, AuditPayload r4) {
        r2.writeAuditLogInternal((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        AOAgentRobotsTools r0 = new AOAgentRobotsTools();
        INSTANCE = r0;
        sRegisterInFlight = new AtomicBoolean(false);
        sSessionActive = new AtomicBoolean(false);
        sAgentName = new AtomicReference(null);
        sAgentUuid = new AtomicReference(null);
        sAgentType = new AtomicReference(null);
        sPkgSha256 = new AtomicReference(null);
        sAgentMd5 = new AtomicReference(null);
        sProofSignature = new AtomicReference(null);
        sCallerPackageName = new AtomicReference(null);
        sTrustLevel = new AtomicReference(null);
        sRobotsSessionId = new AtomicReference(null);
        sAuditStepCounter = new AtomicLong(0);
        sOperationTargetScope = AOThreadingTools.createSingleThreadCoroutineScope$default(AOThreadingTools.INSTANCE, "AO-AgentOperation", false, 2, null);
        sOperationTargetDispatcher = new AgentOperationTargetDispatcher((m) ZeusTransformUtils.preCheckCast(new AOAgentRobotsTools$sOperationTargetDispatcher$1(r0), m.class, "com.obric.aiagent.plugin"), $$Lambda$AOAgentRobotsTools$79jYz5ljx4bnBi6ASezw_MgijK4.INSTANCE, $$Lambda$AOAgentRobotsTools$zMKTMJ7LjcMKrERuo8zWN9_vvhs.INSTANCE, null, 8, null);
        sRegistrationRetryRunner = new AgentRegistrationRetryRunner(3, 1000, REGISTER_MAX_RETRY_DELAY_MILLIS, (m) ZeusTransformUtils.preCheckCast(new AOAgentRobotsTools$sRegistrationRetryRunner$1(AOThreadingTools.INSTANCE), m.class, "com.obric.aiagent.plugin"));
    }

    private static final x sOperationTargetDispatcher$lambda$0(String r3, AgentOperationStatus r4, Throwable r5) {
        o.e(r3, "targetPackage");
        o.e(r4, "status");
        o.e(r5, WsConstants.KEY_CONNECTION_ERROR);
        Loog.INSTANCE.e(TAG, "operation state submit failed, package=" + r3 + ", status=" + INSTANCE.toKitStatus(r4) + ": " + r5.getMessage(), r5);
        return x.f38692a;
    }

    private static final x sOperationTargetDispatcher$lambda$1(long r4, d.h.a.a r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "retry");
        sOperationTargetScope.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new AOAgentRobotsTools$sOperationTargetDispatcher$3$1(r4, r7, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    private final boolean isRobotsProtocolSupportedSafe(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        AOAgentRobotsTools r2 = (AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this, AOAgentRobotsTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r5 = n.f(Boolean.valueOf(com.bytedance.agentrobots.d.a.a(r4)));     // Catch: Throwable -> L5
    L8:
        if (n.b(r5) == false) goto L11;
        r5 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L8
    }

    public static /* synthetic */ void registerAgentAsync$default(AOAgentRobotsTools r1, Context r2, String r3, AgentType r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = "obric_oauto";
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = AgentType.AUTONOMOUS;
    L8:
        r1.registerAgentAsync(r7, r3, r4);
    }

    public final void registerAgentAsync(Context r6, String r7, AgentType r8) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r7, "agentName");
        o.e(r8, "agentType");
        Context r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AtomicReference<String> r10 = sAgentUuid;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.get(), CharSequence.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return;
    L11:
        AtomicBoolean r4 = sRegisterInFlight;
        if (r4.compareAndSet(false, true) == true) goto L14;
        return;
    L14:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.get(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L17;
    L20:
        if (r2 == true) goto L23;
        r4.set(false);
        return;
    L23:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11351(r7, r8, r9, null), m.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        if (d.o.o.d(r11) == true) goto L20;
        r2 = false;
        goto L20
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r3 = false;
        goto L9
    }

    private final Object registerAgentOnce(Context r18, String r19, AgentType r20, int r21, d<? super Boolean> r22) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r22, d.class, "com.obric.aiagent.plugin");
        n.a r1 = n.f38560a;     // Catch: Throwable -> L114
        AOAgentRobotsTools r8 = (AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this, AOAgentRobotsTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L114
        PackageManager r2 = r6.getPackageManager();     // Catch: Throwable -> L114
        o.a(r2);     // Catch: Throwable -> L114
        List<String> r3 = r8.getGrantedPermissionsSafely(r6, r2);     // Catch: Throwable -> L114
        int r9 = WhenMappings.$EnumSwitchMapping$0[r20.ordinal()];     // Catch: Throwable -> L114
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L7;
        com.bytedance.agentrobots.identity.b r10 = com.bytedance.agentrobots.identity.b.f4037b;     // Catch: Throwable -> L114
    L16:
        RobotAgentRegRes r4 = com.bytedance.agentrobots.identity.a.a(r6).a(r6, new RobotAgentRegReq(r19, r10, r3));     // Catch: Throwable -> L114
        if (r4 != null) goto L20;
        Loog.INSTANCE.w(TAG, "registerAgent returned null, attempt=" + r21);     // Catch: Throwable -> L114
    L19:
        boolean r11 = false;
    L112:
        Object r5 = n.f(d.c.b.a.b.a(r11));     // Catch: Throwable -> L114
    L116:
        Throwable r7 = n.c(r5);
        if (r7 == null) goto L119;
        Loog.INSTANCE.e(TAG, "registerAgent exception, attempt=" + r21 + ": " + r7.getMessage(), r7);
    L119:
        Boolean r12 = d.c.b.a.b.a(false);
        if (n.b(r5) == true) goto L122;
        return r5;
    L122:
        return r12;
    L20:
        int r13 = r4.getResult();     // Catch: Throwable -> L114
        if (r13 == 0) goto L24;
        Loog.INSTANCE.w(TAG, "registerAgent failed, attempt=" + r21 + ", code=" + r13 + ", name=" + r19 + ", type=" + r20);     // Catch: Throwable -> L114
        goto L19
    L24:
        RobotAgent r14 = r4.getAgent();     // Catch: Throwable -> L114
        RobotAgentProof r15 = r4.getAgentProof();     // Catch: Throwable -> L114
        n.a r16 = n.f38560a;     // Catch: Throwable -> L31
        if (r14 == null) goto L28;
        String r17 = r14.getAgentUuid();     // Catch: Throwable -> L31
    L29:
        Object r23 = n.f(r17);     // Catch: Throwable -> L31
    L34:
        if (n.b(r23) == false) goto L36;
        r23 = null;
    L36:
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L114
        if (r24 == null) goto L46;
        String r25 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L114
        if (r25 == null) goto L46;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L43;
        boolean r110 = true;
    L44:
        if (r110 == false) goto L46;
        String r111 = r25;
    L47:
        if (r111 != null) goto L127;
        Loog.INSTANCE.w(TAG, "registerAgent succeeded without a usable uuid, attempt=" + r21);     // Catch: Throwable -> L114
        goto L19
    L127:
        n.a r26 = n.f38560a;     // Catch: Throwable -> L56
        if (r14 == null) goto L53;
        String r27 = r14.getSignatureHash();     // Catch: Throwable -> L56
    L54:
        Object r28 = n.f(r27);     // Catch: Throwable -> L56
    L59:
        if (n.b(r28) == false) goto L61;
        r28 = null;
    L61:
        String r29 = (String) ZeusTransformUtils.preCheckCast(r28, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L114
        if (r29 != null) goto L65;
    L67:
        String r30 = null;
    L125:
        n.a r31 = n.f38560a;     // Catch: Throwable -> L85
        if (r15 == null) goto L82;
        byte[] r32 = r15.getSignature();     // Catch: Throwable -> L85
        if (r32 == null) goto L82;
        if (r32.length != 0) goto L75;
        boolean r112 = true;
    L77:
        if ((!r112) == true) goto L80;
        r32 = null;
    L80:
        if (r32 == null) goto L82;
        String r33 = Base64.encodeToString(r32, 2);     // Catch: Throwable -> L85
    L83:
        Object r34 = n.f(r33);     // Catch: Throwable -> L85
    L88:
        if (n.b(r34) == false) goto L90;
        r34 = null;
    L90:
        String r113 = (String) ZeusTransformUtils.preCheckCast(r34, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L114
        n.a r35 = n.f38560a;     // Catch: Throwable -> L97
        if (r14 == null) goto L94;
        String r36 = r14.getPackageName();     // Catch: Throwable -> L97
    L95:
        Object r37 = n.f(r36);     // Catch: Throwable -> L97
    L100:
        if (n.b(r37) == false) goto L102;
        r37 = null;
    L102:
        String r38 = (String) ZeusTransformUtils.preCheckCast(r37, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L114
        if (r38 != null) goto L105;
    L110:
        r38 = r6.getPackageName();     // Catch: Throwable -> L114
    L111:
        o.a(r38);     // Catch: Throwable -> L114
        String r39 = r8.computePackageBaseApkMd5(r6, r38);     // Catch: Throwable -> L114
        sAgentName.set(r19);     // Catch: Throwable -> L114
        sAgentType.set(r20.name());     // Catch: Throwable -> L114
        sPkgSha256.set(r30);     // Catch: Throwable -> L114
        sAgentMd5.set(r39);     // Catch: Throwable -> L114
        sProofSignature.set(r113);     // Catch: Throwable -> L114
        sCallerPackageName.set(r38);     // Catch: Throwable -> L114
        sTrustLevel.set("TRUSTED_TEE");     // Catch: Throwable -> L114
        sAgentUuid.set(r111);     // Catch: Throwable -> L114
        r8.scheduleOperationIdentityReady(r6, r111);     // Catch: Throwable -> L114
        Loog.INSTANCE.i(TAG, "registerAgent success, attempt=" + r21 + ", uuid=" + r111 + ", name=" + r19 + ", type=" + r20);     // Catch: Throwable -> L114
        r11 = true;
        goto L112
    L105:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L108;
        r38 = null;
    L108:
        if (r38 == null) goto L110;
    L94:
        r36 = null;
    L97:
        th = move-exception;
        n.a r40 = n.f38560a;     // Catch: Throwable -> L114
        r37 = n.f(d.o.a(th));     // Catch: Throwable -> L114
        goto L100
    L75:
        r112 = false;
    L82:
        r33 = null;
    L85:
        th = move-exception;
        n.a r114 = n.f38560a;     // Catch: Throwable -> L114
        r34 = n.f(d.o.a(th));     // Catch: Throwable -> L114
        goto L88
    L65:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L67;
        r30 = r29;
        goto L125
    L53:
        r27 = null;
    L56:
        th = move-exception;
        n.a r115 = n.f38560a;     // Catch: Throwable -> L114
        r28 = n.f(d.o.a(th));     // Catch: Throwable -> L114
        goto L59
    L43:
        r110 = false;
    L46:
        r111 = null;
        goto L47
    L28:
        r17 = null;
    L31:
        th = move-exception;
        n.a r116 = n.f38560a;     // Catch: Throwable -> L114
        r23 = n.f(d.o.a(th));     // Catch: Throwable -> L114
        goto L34
    L7:
        if (r9 != 3) goto L9;
        r10 = com.bytedance.agentrobots.identity.b.f4038c;     // Catch: Throwable -> L114
        goto L16
    L9:
        if (r9 != 4) goto L12;
        r10 = com.bytedance.agentrobots.identity.b.f4039d;     // Catch: Throwable -> L114
        goto L16
    L12:
        throw new k();     // Catch: Throwable -> L114
    L15:
        r10 = com.bytedance.agentrobots.identity.b.f4036a;     // Catch: Throwable -> L114
    L114:
        th = move-exception;
        n.a r41 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L116
    }

    public final void updateOperationTarget(String r5) {
        if (r5 == null) goto L12;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r1 == null) goto L12;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
    L13:
        if (r5 == null) goto L16;
        if (r1 != null) goto L16;
        Loog.INSTANCE.w(TAG, "treat blank operation target as stop");
    L16:
        sOperationTargetScope.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11381(r1, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L9:
        r2 = false;
    L12:
        r1 = null;
        goto L13
    }

    private final void scheduleOperationIdentityReady(Context r4, String r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        sOperationTargetScope.launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new C11361(r3, r5, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    private final void notifyOperationState(String r5, AgentOperationStatus r6) {
        Context r0 = sOperationAppContext;
        if (r0 == null) goto L16;
        String r1 = sOperationAgentUuid;
        if (r1 == null) goto L14;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L14;
        String r4 = toKitStatus(r6);
        com.bytedance.agentrobots.c.a.a(r0, r1, r5, r4);
        Loog.INSTANCE.i(TAG, "operation state submitted, package=" + r5 + ", status=" + r4);
        return;
    L14:
        throw new IllegalStateException("operation agent UUID is unavailable after identity became ready".toString());
    L16:
        throw new IllegalStateException("operation context is unavailable after identity became ready".toString());
    }

    private final String toKitStatus(AgentOperationStatus r1) {
        int r0 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r0 != 1) goto L5;
        return "start";
    L5:
        if (r0 != 2) goto L8;
        return "stop";
    L8:
        throw new k();
    }

    private final String computePackageBaseApkMd5(Context r14, String r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L34;
        return null;
    L34:
        String r17 = r16.getPackageManager().getApplicationInfo(r15, 0).sourceDir;     // Catch: Exception -> L31
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == false) goto L14;
        Loog.INSTANCE.w(TAG, "compute agent md5 skipped: missing sourceDir, package=" + r15);     // Catch: Exception -> L31
        return null;
    L14:
        File r5 = new File(r17);     // Catch: Exception -> L31
        if (r5.isFile() == true) goto L17;
        Loog.INSTANCE.w(TAG, "compute agent md5 skipped: sourceDir is not a file, package=" + r15);     // Catch: Exception -> L31
        return null;
    L17:
        MessageDigest r18 = MessageDigest.getInstance(CryptoConst.ALGORITHM_MD5);     // Catch: Exception -> L31
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r5), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L31
        FileInputStream r7 = (FileInputStream) ZeusTransformUtils.preCheckCast(r6, FileInputStream.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        byte[] r8 = new byte[8192];     // Catch: Throwable -> L26
    L19:
        int r9 = r7.read(r8);     // Catch: Throwable -> L26
        if (r9 < 0) goto L21;
        r18.update(r8, 0, r9);     // Catch: Throwable -> L26
        goto L19
    L21:
        x r0 = x.f38692a;     // Catch: Throwable -> L26
        c.a(r6, null);     // Catch: Exception -> L31
        byte[] r10 = r18.digest();     // Catch: Exception -> L31
        o.c(r10, "digest(...)");     // Catch: Exception -> L31
        return i.a(r10, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$AOAgentRobotsTools$mKtqIKpSUopKHQ3ANfHQH4dErCc.INSTANCE, 30, null);
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        c.a(r6, th);     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L8:
        if (d.o.o.d(r3) == true) goto L11;
        r4 = false;
    L31:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "compute agent md5 failed, package=" + r15 + ", error=" + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private static final CharSequence computePackageBaseApkMd5$lambda$18(byte r3) {
        String r4 = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(r3 & 255)}, 1));
        o.c(r4, "format(...)");
        return (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final void startRobotsSessionAsync(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
        if (isRobotsProtocolSupportedSafe(r7) == true) goto L6;
        return;
    L6:
        if (sSessionActive.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        String r4 = UUID.randomUUID().toString();
        o.c(r4, "toString(...)");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11371(r4, r7, null), m.class, "com.obric.aiagent.plugin"));
    }

    public final void endRobotsSessionAsync(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
        if (isRobotsProtocolSupportedSafe(r7) == true) goto L7;
        sSessionActive.set(false);
        sRobotsSessionId.set(null);
        return;
    L7:
        if (sSessionActive.compareAndSet(true, false) == true) goto L9;
        return;
    L9:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7, null), m.class, "com.obric.aiagent.plugin"));
    }

    public final String encodeTargetAppGrant(TargetAppGrant r4) {
        o.e(r4, "targetAppGrant");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.getTargetPackage(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L5;
        return null;
    L5:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4.getContent(), CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L14;
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L9
        r3.put("target_package", r4.getTargetPackage());     // Catch: Exception -> L9
        r3.put("content", r4.getContent());     // Catch: Exception -> L9
        r3.put("status", r4.getStatus().getWireValue());     // Catch: Exception -> L9
        return r3.toString();
    L9:
        Loog.INSTANCE.e(TAG, "encodeTargetAppGrant failed");
        return null;
    L14:
        return null;
    }

    public final TargetAppGrant decodeTargetAppGrant(String r8) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        boolean r2 = true;
        if (r7 != null) goto L5;
    L8:
        boolean r9 = true;
    L10:
        if (r9 == false) goto L53;
        return null;
    L53:
        JSONObject r10 = new JSONObject(r8);     // Catch: Exception -> L51
        Object r11 = r10.opt("target_package");     // Catch: Exception -> L51
        if (ZeusTransformUtils.instanceOf(r11, String.class) == false) goto L15;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
    L16:
        Object r4 = r10.opt("content");     // Catch: Exception -> L51
        if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L19;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
    L20:
        Object r13 = r10.opt("status");     // Catch: Exception -> L51
        if (ZeusTransformUtils.instanceOf(r13, String.class) == false) goto L23;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
    L24:
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        if (r6 != null) goto L27;
    L30:
        boolean r15 = true;
    L31:
        if (r15 == true) goto L57;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L51
        if (r0 != null) goto L35;
    L38:
        if (r2 == true) goto L58;
        TargetAppGrantStatus[] r3 = TargetAppGrantStatus.values();     // Catch: Exception -> L51
        int r16 = r3.length;     // Catch: Exception -> L51
    L41:
        if (r1 >= r16) goto L46;
        TargetAppGrantStatus r17 = r3[r1];     // Catch: Exception -> L51
        if (o.a(r17.getWireValue(), r14) == true) goto L47;
        r1 = r1 + 1;     // Catch: Exception -> L51
    L47:
        if (r17 != null) goto L49;
        return null;
    L49:
        return new TargetAppGrant(r12, r5, r17);
    L46:
        r17 = null;
        goto L47
    L58:
        return null;
    L35:
        if (d.o.o.d(r0) == true) goto L38;
        r2 = false;
        goto L38
    L57:
        return null;
    L27:
        if (d.o.o.d(r6) == true) goto L30;
        r15 = false;
        goto L31
    L23:
        r14 = null;
        goto L24
    L19:
        r5 = null;
        goto L20
    L15:
        r12 = null;
    L51:
        Loog.INSTANCE.e(TAG, "decodeTargetAppGrant failed");
        return null;
    L5:
        if (d.o.o.d(r7) == true) goto L8;
        r9 = false;
        goto L10
    }

    public final void writeToolAuditLog(Context r38, ToolAuditLogParams r39) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r38, Context.class, "com.obric.aiagent.plugin");
        o.e(r0, "context");
        o.e(r39, "params");
        String r4 = "tool";
        String r11 = null;
        String r33 = null;
        writeAuditLogInternal(r0, new AuditPayload(r4, r39.getTargetPackage(), r39.getTargetActivity(), r39.getErrorCode(), r39.getActionType(), r39.getActionArgs(), r39.getReasonCode(), r11, r39.getPolicy(), r39.getDuration(), r39.getToolName(), r39.getUserAuthorizationType(), r39.getRiskLevel(), r39.getExecuteId(), r39.getInstructionId(), r39.getStepId(), r39.getOmniLogId(), r39.getToolName(), r39.getDeviceId(), r39.getInstructionType(), r39.getDoubaoMessageId(), r39.getOriginToolsName(), r39.getOReferenceMsgId(), r39.getQuery(), r39.getCheckUserInputAuditInfo(), r39.getCheckLlmOutputAuditInfo(), r39.getTargetApkVersion(), r39.getTargetSignSha256(), r39.getTargetApkMd5(), r33, r39.getTargetAppGrant(), 536871040, null));
    }

    public final void writeTaskFinishAuditLogAsync(Context r4, TaskFinishAuditLogParams r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        o.e(r5, "params");
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11391(r3, r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final void writeAuditLogInternal(Context r41, AuditPayload r42) {
        Context r4 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r41, Context.class, "com.obric.aiagent.plugin")).getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L180
        AOAgentRobotsTools r5 = (AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this, AOAgentRobotsTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r6 = (String) ZeusTransformUtils.preCheckCast(sAgentUuid.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r7 = (String) ZeusTransformUtils.preCheckCast(sPkgSha256.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r8 = (String) ZeusTransformUtils.preCheckCast(sAgentMd5.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r9 = (String) ZeusTransformUtils.preCheckCast(sProofSignature.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r10 = (String) ZeusTransformUtils.preCheckCast(sAgentType.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r1 = (String) ZeusTransformUtils.preCheckCast(sAgentName.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r11 = (String) ZeusTransformUtils.preCheckCast(sCallerPackageName.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r11 != null) goto L6;
        r11 = r4.getPackageName();     // Catch: Throwable -> L180
    L6:
        String r12 = (String) ZeusTransformUtils.preCheckCast(sTrustLevel.get(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r12 != null) goto L10;
        r12 = "TRUSTED_TEE";
    L10:
        if (r1 != null) goto L13;
    L15:
        r1 = null;
    L17:
        if (r1 != null) goto L19;
        String r14 = "";
    L20:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r2 != null) goto L23;
    L26:
        boolean r3 = true;
    L27:
        if (r3 == true) goto L161;
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r13 != null) goto L31;
    L34:
        boolean r15 = true;
    L35:
        if (r15 == true) goto L161;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r16 != null) goto L39;
    L42:
        boolean r17 = true;
    L43:
        if (r17 == true) goto L161;
        CharSequence r18 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        if (r18 != null) goto L47;
    L50:
        boolean r19 = true;
    L51:
        if (r19 == true) goto L161;
        String r20 = r5.takeIfUsefulId(r42.getOmniLogId());     // Catch: Throwable -> L180
        if (r20 != null) goto L56;
        String r110 = "";
    L57:
        String r21 = r5.takeIfUsefulId(r42.getInstructionId());     // Catch: Throwable -> L180
        if (r21 != null) goto L60;
        String r111 = "";
    L61:
        String r22 = r5.takeIfUsefulId(r42.getStepId());     // Catch: Throwable -> L180
        if (r22 != null) goto L64;
        String r112 = "";
    L65:
        String r23 = r5.takeIfUsefulId(r42.getExecuteId());     // Catch: Throwable -> L180
        if (r23 != null) goto L68;
        String r24 = "";
    L69:
        String r25 = r5.takeIfUsefulId(r42.getDeviceId());     // Catch: Throwable -> L180
        if (r25 == null) goto L186;
    L79:
        if (r25 != null) goto L81;
        r25 = "";
    L81:
        LoggedInUserInfo r113 = AOPlatformTools.INSTANCE.account().acquireUserInfo().getUserInfo();     // Catch: Throwable -> L180
        if (r113 == null) goto L84;
        String r114 = r113.getUserId();     // Catch: Throwable -> L180
    L85:
        String r115 = r5.takeIfUsefulId(r114);     // Catch: Throwable -> L180
        if (r115 != null) goto L88;
        r115 = "";
        String r26 = r115;
    L89:
        String[] r116 = new String[5];     // Catch: Throwable -> L180
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L93;
        String r27 = "agent_name";
    L94:
        r116[0] = r27;     // Catch: Throwable -> L180
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r25, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L98;
        String r28 = "device_id";
    L100:
        r116[1] = r28;     // Catch: Throwable -> L180
        String r29 = r14;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r115, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L104;
        String r117 = "uid";
        char r30 = 2;
    L105:
        r116[r30] = r117;     // Catch: Throwable -> L180
        String r210 = r115;
        String r118 = r111;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L109;
        String r119 = "instruction_id";
        char r31 = 3;
    L110:
        r116[r31] = r119;     // Catch: Throwable -> L180
        String r32 = r110;
        String r120 = r25;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r32, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L114;
        String r33 = "log_id";
    L116:
        r116[4] = r33;     // Catch: Throwable -> L180
        List r34 = p.e(r116);     // Catch: Throwable -> L180
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r34, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L127;
        Loog r121 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r35 = new StringBuilder().append("writeAuditLog missing audit fields=").append(p.a((Iterable) ZeusTransformUtils.preCheckCast(r34, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null)).append(", logType=").append(r42.getLogType()).append(", tool=");     // Catch: Throwable -> L180
        String r36 = r42.getToolName();     // Catch: Throwable -> L180
        if (r36 != null) goto L122;
        r36 = r26;
    L122:
        StringBuilder r37 = r35.append(r36).append(", target=").append(r42.getTargetPackage()).append('/');     // Catch: Throwable -> L180
        String r38 = r42.getTargetActivity();     // Catch: Throwable -> L180
        if (r38 != null) goto L125;
        r38 = r26;
    L125:
        r121.e(TAG, r37.append(r38).toString());     // Catch: Throwable -> L180
    L127:
        JSONObject r39 = new JSONObject();     // Catch: Throwable -> L180
        r39.put("log_source", "agent");     // Catch: Throwable -> L180
        r39.put(DBHelper.COL_TIME, String.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "target_package", r42.getTargetPackage());     // Catch: Throwable -> L180
        r39.put("agent_uuid", r6);     // Catch: Throwable -> L180
        r39.put("pkg_sha256", r7);     // Catch: Throwable -> L180
        r39.put("agent_type", r10);     // Catch: Throwable -> L180
        r39.put("trust_level", r12);     // Catch: Throwable -> L180
        r39.put("package_name", r11);     // Catch: Throwable -> L180
        r39.put("agent_version", IAppContext.Companion.getVersionName());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "agent_md5", r8);     // Catch: Throwable -> L180
        r39.put("proof_signature", r9);     // Catch: Throwable -> L180
        r39.put("log_id", r32);     // Catch: Throwable -> L180
        r39.put("omni_log_id", r32);     // Catch: Throwable -> L180
        r39.put("execute_id", r24);     // Catch: Throwable -> L180
        r39.put("instruction_id", r118);     // Catch: Throwable -> L180
        r39.put("step_id", r112);     // Catch: Throwable -> L180
        r39.put("error_code", r42.getErrorCode());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "action_type", r42.getActionType());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "action_args", r42.getActionArgs());     // Catch: Throwable -> L180
        r39.put("device_id", r120);     // Catch: Throwable -> L180
        r39.put("uid", r210);     // Catch: Throwable -> L180
        r39.put("agent_name", r29);     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "target_activity", r42.getTargetActivity());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "intent_type", r42.getIntentType());     // Catch: Throwable -> L180
        r39.put("log_type", r42.getLogType());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "tool_name", r42.getToolName());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "instruction_type", r42.getInstructionType());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "doubao_message_id", r42.getDoubaoMessageId());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "origin_tools_name", r42.getOriginToolsName());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "o_reference_msg_id", r42.getOReferenceMsgId());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "user_authorization_type", r42.getUserAuthorizationType());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "risk_level", r42.getRiskLevel());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "policy", r42.getPolicy());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "reason_code", r42.getReasonCode());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "finish_reason", r42.getFinishReason());     // Catch: Throwable -> L180
        if (r42.getDuration() == null) goto L130;
        r39.put("duration", r42.getDuration().longValue());     // Catch: Throwable -> L180
    L130:
        r5.putIfNotBlank(r39, DownloadConstants.QUERY_KEY, r42.getQuery());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "check_user_input_audit_info", r42.getCheckUserInputAuditInfo());     // Catch: Throwable -> L180
        r5.putIfNotBlank(r39, "check_llm_output_audit_info", r42.getCheckLlmOutputAuditInfo());     // Catch: Throwable -> L180
        Iterator<Map.Entry<String, Object>> r40 = AOSystemToolsKt.buildTargetApkAuditFields(r42.getTargetApkVersion(), r42.getTargetSignSha256(), r42.getTargetApkMd5()).entrySet().iterator();     // Catch: Throwable -> L180
    L132:
        if (r40.hasNext() == false) goto L137;
        Map.Entry r43 = (Map.Entry) ZeusTransformUtils.preCheckCast(r40.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        String r44 = (String) ZeusTransformUtils.preCheckCast(r43.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
        Object r45 = r43.getValue();     // Catch: Throwable -> L180
        if (ZeusTransformUtils.instanceOf(r45, List.class) == false) goto L136;
        r45 = new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r45, Collection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L180
    L136:
        r39.put(r44, r45);     // Catch: Throwable -> L180
        goto L132
    L137:
        r5.putIfNotBlank(r39, "appversion", r42.getAppVersion());     // Catch: Throwable -> L180
        TargetAppGrant r46 = r42.getTargetAppGrant();     // Catch: Throwable -> L180
        if (r46 == null) goto L142;
        String r47 = r5.encodeTargetAppGrant(r46);     // Catch: Throwable -> L180
        if (r47 == null) goto L142;
        r39.put(TARGET_APP_GRANT_EXT_KEY, new JSONObject(r47));     // Catch: Throwable -> L180
    L142:
        r39.put("uuid", UUID.randomUUID().toString());     // Catch: Throwable -> L180
        r39.put(DBHelper.BATTERY_COL_PROCESS_NAME, r4.getPackageName());     // Catch: Throwable -> L180
        Loog.INSTANCE.d(TAG, "input=" + r39);     // Catch: Throwable -> L180
        Loog r48 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r49 = new StringBuilder().append("package=").append(r42.getTargetPackage()).append(", target_sign_sha256=");     // Catch: Throwable -> L180
        List<String> r50 = r42.getTargetSignSha256();     // Catch: Throwable -> L180
        if (r50 == null) goto L146;
        String r51 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r50, Iterable.class, "com.obric.aiagent.plugin"), null, null, null, 0, null, null, 63, null);     // Catch: Throwable -> L180
        if (r51 == null) goto L146;
    L147:
        r48.i(TAG, r49.append(r51).append(", target_apk_md5=").append(r42.getTargetApkMd5()).append(", target_apk_version=").append(r42.getTargetApkVersion()).toString());     // Catch: Throwable -> L180
        int r52 = com.bytedance.agentrobots.b.a.a(r4, r39.toString());     // Catch: Throwable -> L180
        Loog r53 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r54 = new StringBuilder().append("writeAuditLog rc=").append(r52).append(", logType=").append(r42.getLogType()).append(", target=").append(r42.getTargetPackage()).append('/');     // Catch: Throwable -> L180
        String r55 = r42.getTargetActivity();     // Catch: Throwable -> L180
        if (r55 != null) goto L150;
        r55 = r26;
    L150:
        r53.i(TAG, r54.append(r55).append(", omniLogId=").append(r32).toString());     // Catch: Throwable -> L180
        if (r52 != 0) goto L157;
        Loog r56 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r57 = new StringBuilder().append("writeAuditLog ok, source=agent, target=").append(r42.getTargetPackage()).append('/');     // Catch: Throwable -> L180
        String r58 = r42.getTargetActivity();     // Catch: Throwable -> L180
        if (r58 != null) goto L156;
        r58 = r26;
    L156:
        r56.i(TAG, r57.append(r58).append(", errorCode=").append(r42.getErrorCode()).append(", omniLogId=").append(r32).toString());     // Catch: Throwable -> L180
    L178:
        Object r59 = n.f(x.f38692a);     // Catch: Throwable -> L180
    L182:
        Throwable r60 = n.c(r59);
        if (r60 == null) goto L193;
        Loog.INSTANCE.e(TAG, "writeAuditLog exception: " + r60.getMessage(), r60);
        return;
    L193:
        return;
    L157:
        Loog r61 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r62 = new StringBuilder().append("writeAuditLog failed, code=").append(r52).append('(').append(r5.auditErrorDesc(r52)).append("), source=agent, target=").append(r42.getTargetPackage()).append('/');     // Catch: Throwable -> L180
        String r63 = r42.getTargetActivity();     // Catch: Throwable -> L180
        if (r63 != null) goto L160;
        r63 = r26;
    L160:
        r61.e(TAG, r62.append(r63).append(", errorCode=").append(r42.getErrorCode()).append(", omniLogId=").append(r32).toString());     // Catch: Throwable -> L180
    L146:
        r51 = r26;
        goto L147
    L114:
        r33 = null;
        goto L116
    L109:
        r31 = 3;
        r119 = null;
        goto L110
    L104:
        r30 = 2;
        r117 = null;
        goto L105
    L98:
        r28 = null;
        goto L100
    L93:
        r27 = null;
        goto L94
    L88:
        r26 = "";
        goto L89
    L84:
        r114 = null;
        goto L85
    L186:
        n.a r64 = n.f38560a;     // Catch: Throwable -> L73
        Object r65 = n.f(r5.takeIfUsefulId(AOPlatformTools.INSTANCE.registry().getDid()));     // Catch: Throwable -> L73
    L76:
        if (n.b(r65) == false) goto L78;
        r65 = null;
    L78:
        r25 = (String) ZeusTransformUtils.preCheckCast(r65, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L180
    L73:
        th = move-exception;
        n.a r211 = n.f38560a;     // Catch: Throwable -> L180
        r65 = n.f(d.o.a(th));     // Catch: Throwable -> L180
        goto L76
    L68:
        r24 = r23;
        goto L69
    L64:
        r112 = r22;
        goto L65
    L60:
        r111 = r21;
        goto L61
    L56:
        r110 = r20;
        goto L57
    L47:
        if (d.o.o.d(r18) == true) goto L50;
        r19 = false;
        goto L51
    L39:
        if (d.o.o.d(r16) == true) goto L42;
        r17 = false;
        goto L43
    L31:
        if (d.o.o.d(r13) == true) goto L34;
        r15 = false;
    L161:
        Loog r66 = Loog.INSTANCE;     // Catch: Throwable -> L180
        StringBuilder r67 = new StringBuilder().append("writeAuditLog skipped: missing identity fields; uuid=").append(r6).append(", sha256=");     // Catch: Throwable -> L180
        if (r7 != null) goto L164;
        Boolean r68 = null;
    L169:
        StringBuilder r69 = r67.append(r68).append(", sig=");     // Catch: Throwable -> L180
        if (r9 != null) goto L172;
        Boolean r122 = null;
    L177:
        r66.e(TAG, r69.append(r122).append(", type=").append(r10).toString());     // Catch: Throwable -> L180
        goto L178
    L172:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L174;
        boolean r123 = true;
    L175:
        r122 = Boolean.valueOf(r123);     // Catch: Throwable -> L180
        goto L177
    L174:
        r123 = false;
        goto L175
    L164:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L166;
        boolean r70 = true;
    L167:
        r68 = Boolean.valueOf(r70);     // Catch: Throwable -> L180
        goto L169
    L166:
        r70 = false;
        goto L167
    L23:
        if (d.o.o.d(r2) == true) goto L26;
        r3 = false;
        goto L27
    L19:
        r14 = r1;
        goto L20
    L13:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L15;
    L180:
        th = move-exception;
        n.a r71 = n.f38560a;
        r59 = n.f(d.o.a(th));
        goto L182
    }

    private final String takeIfUsefulId(String r3) {
        if (r3 == null) goto L15;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L11:
        r1 = false;
    L12:
        if (r1 == false) goto L15;
        return r3;
    L7:
        if (o.a(r3, "0") == true) goto L11;
        if (o.a(r3, "null") == true) goto L11;
    L15:
        return null;
    }

    private final void putIfNotBlank(JSONObject r2, String r3, String r4) {
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        r2.put(r3, r4);
        return;
    L12:
        return;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r5 = false;
        goto L9
    }

    public final String acquireTargetPolicy(Context r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r5, "packageName");
        o.e(r6, "activityClassName");
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r8);
        Object r2 = null;
        if (isRobotsProtocolSupportedSafe(r8) == true) goto L18;
        return null;
    L18:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L7
        AOAgentRobotsTools r3 = (AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this, AOAgentRobotsTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        Object r9 = n.f(com.bytedance.agentrobots.policy.d.a(r8).e(r5, r6));     // Catch: Throwable -> L7
    L9:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L13;
        Loog.INSTANCE.e(TAG, "acquireTargetPolicy failed: " + r10.getMessage(), r10);
    L13:
        if (n.b(r9) == true) goto L17;
        r2 = r9;
    L17:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
    L7:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L9
    }

    public final String querySaepPackagesJson(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r11);
        if (isRobotsProtocolSupportedSafe(r11) == true) goto L15;
        return null;
    L15:
        Map<String, List<String>> r8 = com.bytedance.agentrobots.policy.d.a(r11).c();     // Catch: Exception -> L10 LinkageError -> L12
        if (r8 != null) goto L8;
        return null;
    L8:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L10 LinkageError -> L12
        AOAgentRobotsTools r5 = INSTANCE;     // Catch: Exception -> L10 LinkageError -> L12
        r12.put("restricted_packages", r5.toSaepPackageJsonArray((List) ZeusTransformUtils.preCheckCast(r8.get("restricted_packages"), List.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L10 LinkageError -> L12
        r12.put("saep_declared_packages", r5.toSaepPackageJsonArray((List) ZeusTransformUtils.preCheckCast(r8.get("saep_declared_packages"), List.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L10 LinkageError -> L12
    L18:
        return r12.toString();
    L10:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "querySaepPackages failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L12:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "querySaepPackages unavailable because SDK linkage failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    }

    private final JSONArray toSaepPackageJsonArray(List<String> r5) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        JSONArray r6 = new JSONArray();
        if (r4 == null) goto L24;
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L16;
        String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L6;
        r1.add(r2);
        goto L6
    L10:
        r3 = false;
        goto L11
    L16:
        List r9 = p.s((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"));
        if (r9 == null) goto L24;
        List r10 = p.m((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin"));
        if (r10 == null) goto L24;
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r11.hasNext() == false) goto L24;
        r6.put((String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.aiagent.plugin"));
    L24:
        return r6;
    }

    public final void logTopActivityPolicyAsync(Context r4, String r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        o.e(r5, "reason");
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.a(r7);
        if (isRobotsProtocolSupportedSafe(r7) == true) goto L5;
        return;
    L5:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11341(r7, r5, null), m.class, "com.obric.aiagent.plugin"));
    }

    private final List<String> getRequestedPermissionsSafely(Context r5, PackageManager r6) {
        String r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getPackageName();
        n.a r0 = n.f38560a;     // Catch: Throwable -> L14
        AOAgentRobotsTools r4 = (AOAgentRobotsTools) ZeusTransformUtils.preCheckCast(this, AOAgentRobotsTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 33) goto L6;
        PackageInfo r8 = r6.getPackageInfo(r7, PackageManager.PackageInfoFlags.of(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));     // Catch: Throwable -> L14
        o.a(r8);     // Catch: Throwable -> L14
    L7:
        String[] r9 = r8.requestedPermissions;     // Catch: Throwable -> L14
        if (r9 == null) goto L11;
        List r10 = i.g(r9);     // Catch: Throwable -> L14
        if (r10 == null) goto L11;
    L12:
        Object r11 = n.f(r10);     // Catch: Throwable -> L14
    L16:
        List r12 = p.b();
        if (n.b(r11) == false) goto L20;
        r11 = r12;
    L20:
        return (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.aiagent.plugin");
    L11:
        r10 = p.b();     // Catch: Throwable -> L14
        goto L12
    L6:
        r8 = r6.getPackageInfo(r7, 4096);     // Catch: Throwable -> L14
        o.a(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        n.a r13 = n.f38560a;
        r11 = n.f(d.o.a(th));
        goto L16
    }

    private final List<String> getGrantedPermissionsSafely(Context r8, PackageManager r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        String r0 = r10.getPackageName();
        List<String> r7 = getRequestedPermissionsSafely(r10, r9);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L20;
        Object r3 = r12.next();
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
        n.a r6 = n.f38560a;     // Catch: Throwable -> L12
        if (r9.checkPermission(r4, r0) != 0) goto L9;
        boolean r5 = true;
    L10:
        Object r13 = n.f(Boolean.valueOf(r5));     // Catch: Throwable -> L12
    L15:
        if (n.b(r13) == false) goto L18;
        r13 = false;
    L18:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r13, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L4;
        r2.add(r3);
        goto L4
    L9:
        r5 = false;
    L12:
        th = move-exception;
        n.a r14 = n.f38560a;
        r13 = n.f(d.o.a(th));
        goto L15
    L20:
        List<String> r15 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "registerAgent permissions requested=" + r7.size() + ", granted=" + r15.size());
        return r15;
    }
}
