package com.stepos.core.ability.config;

import android.content.Context;
import android.os.Build;
import androidx.datastore.preferences.protobuf.b1;
import b7.k;
import b7.p;
import com.stepos.base.ability.ApplyScope;
import com.stepos.base.model.InferenceConfig;
import com.stepos.base.protocol.ProtocolType;
import com.stepos.core.ability.speech.AsrCloudConfig;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.common.telemetry.ModelCallFlywheelBizMapper;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.model.device.DeviceCapability;
import com.stepos.core.model.manifest.ModelManifest;
import com.stepos.core.ota.crypto.AtRestSealer;
import com.stepos.deepbinder.annotation.BaseConstantsKt;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import com.tonyodev.fetch2core.server.FileResponse;
import gc.a;
import gc.o;
import gc.q;
import h0.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.collections.builders.ListBuilder;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.g;
import mb.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p6.a;
import p6.b;
import p6.h;
import p6.i;
import p6.j;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityConfigLoader {
    private static final String ABILITIES_JSON = "abilities.json";
    private static final String CONFIG_DIR = "config";
    public static final AbilityConfigLoader INSTANCE = new AbilityConfigLoader();
    private static final String KEY_DOWNLOAD_URL_EXPIRES_SECONDS = "download_url_expires_seconds";
    public static final String KEY_THRESHOLD = "privacyClassifyThreshold";
    private static final String TAG = "AbilityConfigLoader";

    private AbilityConfigLoader() {
    }

    private final boolean checkRequirement(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        g.e(lowerCase, "toLowerCase(...)");
        if (lowerCase.equals("qnn")) {
            return DeviceCapability.INSTANCE.hasQNN();
        }
        if (lowerCase.equals("qualcomm")) {
            return DeviceCapability.INSTANCE.isQualcomm();
        }
        return true;
    }

    private final String legacyEntryPathOf(String str, String str2) {
        if (o.e0(str2, ".json", true) && !str2.equals("bundle_config.json")) {
            if (q.m0(str2, '/')) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, "abilities.json modelFile '" + str2 + "' 含子目录，违反 entry 必须在包根，已忽略");
                return null;
            }
            File file = new File(str, str2);
            if (file.isFile()) {
                AIEngineLogger.i(LogModule.ABILITY, TAG, "manifest 缺失，entry 回落 abilities.json:modelFile -> " + file.getAbsolutePath());
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    private final String manifestEntryPathOf(String str) {
        Object objA;
        File file = new File(str, AtRestSealer.MODEL_MANIFEST);
        if (!file.isFile()) {
            file = null;
        }
        if (file != null) {
            try {
                String strOptString = new JSONObject(d.Z(file, a.f9106b)).optString("entry", "");
                g.e(strOptString, "optString(...)");
                objA = q.L0(strOptString).toString();
            } catch (Throwable th) {
                objA = c.a(th);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("manifest entry 解析失败: ", file.getAbsolutePath(), ": ", thB.getMessage()));
                return null;
            }
            String str2 = (String) objA;
            if (str2.length() != 0) {
                if (q.m0(str2, '/')) {
                    AIEngineLogger.e(LogModule.ABILITY, TAG, e.c("manifest entry 必须位于包根，实得 '", str2, "'（", file.getAbsolutePath(), "）：native chdir(dirname(entry)) 会落到子目录导致包内相对路径全错，已忽略"));
                    return null;
                }
                File file2 = new File(str, str2);
                if (file2.isFile()) {
                    AIEngineLogger.i(LogModule.ABILITY, TAG, "manifest.entry 命中 → opaque，native 入口 = " + file2.getAbsolutePath());
                    return file2.getAbsolutePath();
                }
                AIEngineLogger.e(LogModule.ABILITY, TAG, "manifest entry 指向的文件不存在: " + file2.getAbsolutePath());
                return null;
            }
        }
        return null;
    }

    private final p6.a parseAbilityConfig(JSONObject jSONObject) throws JSONException {
        b bVar;
        Map mapD0;
        String str;
        ProtocolType protocolType;
        h hVar;
        Map mapD02;
        p6.a aVarB;
        JSONObject jSONObjectOptJSONObject;
        ProtocolType protocolType2;
        h hVar2;
        JSONObject jSONObject2;
        String str2;
        JSONObject jSONObjectOptJSONObject2;
        String string = jSONObject.getString(ModelDownloadNotifier.EXTRA_NOTIF_ID);
        String string2 = jSONObject.getString(FileResponse.FIELD_TYPE);
        String strOptString = jSONObject.optString("name", string);
        String strOptString2 = jSONObject.optString("protocol", "");
        b bVar2 = b.f11432e;
        g.c(string2);
        b bVarA = b.a.a(string2);
        g.c(strOptString2);
        ProtocolType protocolType3 = strOptString2.length() > 0 ? parseProtocolType(strOptString2) : null;
        JSONObject jSONObject3 = jSONObject.getJSONObject(ModelManifest.TYPE_MODEL);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject(BaseConstantsKt.KEY_PARAMS);
        g.c(jSONObject3);
        k modelConfig = parseModelConfig(jSONObject3, jSONObjectOptJSONObject3);
        h quota = parseQuota(jSONObject.optJSONObject("quota"));
        i segmentation = parseSegmentation(jSONObject.optJSONObject("segmentation"));
        j vad = parseVad(jSONObject.optJSONObject("vad"));
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject(ModelCallFlywheelBizMapper.MODEL_PATH_CLOUD);
        long jOptLong = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;
        if (jSONObjectOptJSONObject4 != null) {
            jOptLong = jSONObjectOptJSONObject4.optLong("timeout", AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS);
        }
        long j10 = jOptLong;
        boolean zOptBoolean = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optBoolean("enable", false) : false;
        p6.c cVar = p6.c.f11438b;
        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optJSONObject(BaseConstantsKt.KEY_PARAMS) : null;
        p6.c cloudParams = jSONObjectOptJSONObject5 != null ? new p6.c(jSONObjectOptJSONObject5) : p6.c.f11438b;
        if (jSONObjectOptJSONObject4 == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject4.optJSONObject("params_by_package")) == null) {
            bVar = bVarA;
            mapD0 = kotlin.collections.b.d0();
        } else {
            MapBuilder mapBuilder = new MapBuilder();
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject2.optJSONObject(next);
                if (jSONObjectOptJSONObject6 != null) {
                    g.c(next);
                    b bVar3 = bVarA;
                    bVarA = bVar3;
                }
            }
            bVar = bVarA;
            mapD0 = mapBuilder.b();
        }
        Map map = mapD0;
        p6.c cloudPolicy = parseCloudPolicy(jSONObjectOptJSONObject4);
        if (jSONObjectOptJSONObject4 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject4.optJSONObject("scene_type_by_package")) == null) {
            str = strOptString;
            protocolType = protocolType3;
            hVar = quota;
            mapD02 = kotlin.collections.b.d0();
        } else {
            MapBuilder mapBuilder2 = new MapBuilder();
            Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                String str3 = strOptString;
                JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject.optJSONObject(next2);
                if (jSONObjectOptJSONObject7 != null) {
                    protocolType2 = protocolType3;
                    MapBuilder mapBuilder3 = new MapBuilder();
                    Iterator<String> itKeys3 = jSONObjectOptJSONObject7.keys();
                    while (itKeys3.hasNext()) {
                        h hVar3 = quota;
                        String next3 = itKeys3.next();
                        String strOptString3 = jSONObjectOptJSONObject7.optString(next3);
                        g.c(strOptString3);
                        if (q.t0(strOptString3)) {
                            jSONObject2 = jSONObjectOptJSONObject7;
                            str2 = null;
                        } else {
                            jSONObject2 = jSONObjectOptJSONObject7;
                            str2 = strOptString3;
                        }
                        if (str2 != null) {
                            g.c(next3);
                        }
                        jSONObjectOptJSONObject7 = jSONObject2;
                        quota = hVar3;
                    }
                    hVar2 = quota;
                    MapBuilder mapBuilderB = mapBuilder3.b();
                    if (!mapBuilderB.isEmpty()) {
                        g.c(next2);
                        mapBuilder2.put(next2, mapBuilderB);
                    }
                } else {
                    protocolType2 = protocolType3;
                    hVar2 = quota;
                    String strOptString4 = jSONObjectOptJSONObject.optString(next2);
                    g.c(strOptString4);
                    if (q.t0(strOptString4)) {
                        strOptString4 = null;
                    }
                    if (strOptString4 != null) {
                        g.c(next2);
                    }
                }
                strOptString = str3;
                protocolType3 = protocolType2;
                quota = hVar2;
            }
            str = strOptString;
            protocolType = protocolType3;
            hVar = quota;
            mapD02 = mapBuilder2.b();
        }
        Map map2 = mapD02;
        g.c(string);
        int downloadUrlExpiresSeconds = parseDownloadUrlExpiresSeconds(jSONObjectOptJSONObject4, string);
        boolean zOptBoolean2 = jSONObject.optBoolean("keepAlive", false);
        if (protocolType != null) {
            int i10 = p6.a.r;
            g.c(str);
            g.f(modelConfig, "modelConfig");
            aVarB = a.C0126a.a(string, bVar, str, modelConfig, y.M(protocolType), hVar);
        } else {
            String str4 = str;
            int i11 = p6.a.r;
            g.c(str4);
            aVarB = a.C0126a.b(string, bVar, str4, modelConfig, hVar, 48);
        }
        String id2 = aVarB.f11416a;
        b abilityType = aVarB.f11417b;
        String description = aVarB.f11418c;
        List<k> modelConfigs = aVarB.f11419d;
        List<p> modelProtocols = aVarB.f11420e;
        boolean z = aVarB.f11421f;
        h hVar4 = aVarB.h;
        g.f(id2, "id");
        g.f(abilityType, "abilityType");
        g.f(description, "description");
        g.f(modelConfigs, "modelConfigs");
        g.f(modelProtocols, "modelProtocols");
        g.f(cloudParams, "cloudParams");
        g.f(cloudPolicy, "cloudPolicy");
        return new p6.a(id2, abilityType, description, modelConfigs, modelProtocols, z, zOptBoolean2, hVar4, j10, zOptBoolean, cloudParams, map, map2, downloadUrlExpiresSeconds, cloudPolicy, segmentation, vad);
    }

    private final p6.c parseCloudPolicy(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return p6.c.f11438b;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(PolicySdkConstants.policyFileDir);
        if (jSONObjectOptJSONObject != null) {
            return new p6.c(jSONObjectOptJSONObject);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("streamPolicy");
        if (jSONObjectOptJSONObject2 == null) {
            return p6.c.f11438b;
        }
        p6.c cVar = p6.c.f11438b;
        JSONObject jSONObjectPut = new JSONObject().put(AsrCloudConfig.SCENE_MODE_STREAM, jSONObjectOptJSONObject2);
        return jSONObjectPut != null ? new p6.c(jSONObjectPut) : p6.c.f11438b;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final InferenceConfig.ComputeDevice parseComputeDevice(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case 66952:
                if (upperCase.equals("CPU")) {
                    return InferenceConfig.ComputeDevice.f6271b;
                }
                break;
            case 68001:
                if (upperCase.equals("DSP")) {
                    return InferenceConfig.ComputeDevice.f6274e;
                }
                break;
            case 70796:
                if (upperCase.equals("GPU")) {
                    return InferenceConfig.ComputeDevice.f6272c;
                }
                break;
            case 77523:
                if (upperCase.equals("NPU")) {
                    return InferenceConfig.ComputeDevice.f6273d;
                }
                break;
        }
        return InferenceConfig.ComputeDevice.f6270a;
    }

    private final int parseDownloadUrlExpiresSeconds(JSONObject jSONObject, String str) {
        int i10 = p6.a.r;
        int i11 = p6.a.r;
        if (jSONObject != null && jSONObject.has(KEY_DOWNLOAD_URL_EXPIRES_SECONDS)) {
            int iOptInt = jSONObject.optInt(KEY_DOWNLOAD_URL_EXPIRES_SECONDS, -1);
            if (i11 <= iOptInt && iOptInt < 604801) {
                return iOptInt;
            }
            LogModule logModule = LogModule.ABILITY;
            StringBuilder sbF = e.f("ability=", str, " download_url_expires_seconds=", iOptInt, " out of range [");
            sbF.append(i11);
            sbF.append(",604800] (lower bound = max server poll budget), falling back to default ");
            sbF.append(i11);
            sbF.append("s");
            AIEngineLogger.w(logModule, TAG, sbF.toString());
        }
        return i11;
    }

    private final InferenceConfig parseInferenceConfig(JSONObject jSONObject, String value, JSONObject jSONObject2) {
        g.f(value, "value");
        String upperCase = value.toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jSONObject2 != null && jSONObject2.has("threshold")) {
            linkedHashMap.put(KEY_THRESHOLD, Float.valueOf((float) jSONObject2.getDouble("threshold")));
        }
        if (jSONObject == null) {
            return new InferenceConfig(upperCase, null, 0, null, false, null, false, linkedHashMap, 254);
        }
        String strOptString = jSONObject.optString("computeDevice", "auto");
        g.e(strOptString, "optString(...)");
        InferenceConfig.ComputeDevice computeDevice = parseComputeDevice(strOptString);
        int iOptInt = jSONObject.optInt("threads", 2);
        String strOptString2 = jSONObject.optString("performanceProfile", "balanced");
        g.e(strOptString2, "optString(...)");
        InferenceConfig.PerformanceProfile performanceProfile = parsePerformanceProfile(strOptString2);
        boolean zOptBoolean = jSONObject.optBoolean("quantizationEnabled", true);
        String strOptString3 = jSONObject.optString("quantizationType", "q8_0");
        g.e(strOptString3, "optString(...)");
        return new InferenceConfig(upperCase, computeDevice, iOptInt, performanceProfile, zOptBoolean, strOptString3, jSONObject.optBoolean("warmupEnabled", true), linkedHashMap, TraceIdKeys.MAX_LENGTH);
    }

    public static /* synthetic */ InferenceConfig parseInferenceConfig$default(AbilityConfigLoader abilityConfigLoader, JSONObject jSONObject, String str, JSONObject jSONObject2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            jSONObject2 = null;
        }
        return abilityConfigLoader.parseInferenceConfig(jSONObject, str, jSONObject2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b1, code lost:
    
        r22 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final b7.k parseModelConfig(org.json.JSONObject r38, org.json.JSONObject r39) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.ability.config.AbilityConfigLoader.parseModelConfig(org.json.JSONObject, org.json.JSONObject):b7.k");
    }

    public static /* synthetic */ k parseModelConfig$default(AbilityConfigLoader abilityConfigLoader, JSONObject jSONObject, JSONObject jSONObject2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            jSONObject2 = null;
        }
        return abilityConfigLoader.parseModelConfig(jSONObject, jSONObject2);
    }

    private final InferenceConfig.PerformanceProfile parsePerformanceProfile(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        int iHashCode = upperCase.hashCode();
        if (iHashCode != -1142203128) {
            if (iHashCode != -831719532) {
                if (iHashCode == 672572432 && upperCase.equals("PERFORMANCE")) {
                    return InferenceConfig.PerformanceProfile.f6277c;
                }
            } else if (upperCase.equals("POWER_SAVING")) {
                return InferenceConfig.PerformanceProfile.f6275a;
            }
        } else if (upperCase.equals("BALANCED")) {
            return InferenceConfig.PerformanceProfile.f6276b;
        }
        return InferenceConfig.PerformanceProfile.f6276b;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    private final ProtocolType parseProtocolType(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        g.e(upperCase, "toUpperCase(...)");
        switch (upperCase.hashCode()) {
            case -1842742046:
                if (upperCase.equals("SPEECH")) {
                    return ProtocolType.h;
                }
                break;
            case -1762897944:
                if (upperCase.equals("VISION")) {
                    return ProtocolType.f6379b;
                }
                break;
            case 2571565:
                if (upperCase.equals("TEXT")) {
                    return ProtocolType.f6378a;
                }
                break;
            case 62628790:
                if (upperCase.equals("AUDIO")) {
                    return ProtocolType.f6380c;
                }
                break;
            case 998325960:
                if (upperCase.equals("GRAPHIC")) {
                    return ProtocolType.f6381d;
                }
                break;
            case 1747479828:
                if (upperCase.equals("MULTIMODAL")) {
                    return ProtocolType.f6382e;
                }
                break;
        }
        return ProtocolType.f6378a;
    }

    private final h parseQuota(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            h hVar = h.f11440b;
            return new h(jSONObject.optInt("maxConcurrent", h.f11440b.f11441a));
        } catch (IllegalArgumentException e10) {
            ai.onnxruntime.a.w("Invalid quota config, falling back to default: ", e10.getMessage(), LogModule.ABILITY, TAG);
            return null;
        }
    }

    private final i parseSegmentation(JSONObject jSONObject) {
        Map mapD0;
        ApplyScope applyScopeA;
        if (jSONObject == null) {
            return null;
        }
        int iOptInt = jSONObject.optInt("max_chars", 0);
        int iOptInt2 = jSONObject.optInt("punct_window", 80);
        ApplyScope.a aVar = ApplyScope.f6188a;
        String strOptString = jSONObject.optString("apply_to", "");
        aVar.getClass();
        i iVar = new i(iOptInt, iOptInt2, ApplyScope.a.a(strOptString), 8);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package_override");
        if (jSONObjectOptJSONObject != null) {
            MapBuilder mapBuilder = new MapBuilder();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    g.c(next);
                    int iOptInt3 = jSONObjectOptJSONObject2.optInt("max_chars", iVar.f11443a);
                    int iOptInt4 = jSONObjectOptJSONObject2.optInt("punct_window", iVar.f11444b);
                    if (jSONObjectOptJSONObject2.has("apply_to")) {
                        ApplyScope.a aVar2 = ApplyScope.f6188a;
                        String strOptString2 = jSONObjectOptJSONObject2.optString("apply_to", null);
                        aVar2.getClass();
                        applyScopeA = ApplyScope.a.a(strOptString2);
                    } else {
                        applyScopeA = iVar.f11445c;
                    }
                }
            }
            mapD0 = mapBuilder.b();
        } else {
            mapD0 = kotlin.collections.b.d0();
        }
        return i.a(iVar, 0, 0, mapD0, 7);
    }

    private final List<String> parseStringArrayOrNull(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
            return null;
        }
        ListBuilder listBuilder = new ListBuilder(jSONArrayOptJSONArray.length());
        int length = jSONArrayOptJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            String string = jSONArrayOptJSONArray.getString(i10);
            g.e(string, "getString(...)");
            listBuilder.add(string);
        }
        return b1.i(listBuilder);
    }

    private final j parseVad(JSONObject jSONObject) {
        Map mapD0;
        if (jSONObject == null) {
            return null;
        }
        j jVarVadFrom = vadFrom(jSONObject, j.f11447k);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("package_override");
        if (jSONObjectOptJSONObject != null) {
            MapBuilder mapBuilder = new MapBuilder();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject2 != null) {
                    g.c(next);
                }
            }
            mapD0 = mapBuilder.b();
        } else {
            mapD0 = kotlin.collections.b.d0();
        }
        return new j(jVarVadFrom.f11448a, jVarVadFrom.f11449b, jVarVadFrom.f11450c, jVarVadFrom.f11451d, jVarVadFrom.f11452e, jVarVadFrom.f11453f, jVarVadFrom.f11454g, jVarVadFrom.h, jVarVadFrom.f11455i, (Map<String, j>) mapD0);
    }

    private final String readConfigDir(Context context) {
        Object objA;
        try {
            File file = new File(new File(context.getDataDir(), CONFIG_DIR), ABILITIES_JSON);
            if (!file.exists()) {
                file = null;
            }
            objA = file != null ? d.Z(file, gc.a.f9106b) : null;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        return (String) (objA instanceof Result.Failure ? null : objA);
    }

    private final j vadFrom(JSONObject jSONObject, j jVar) {
        return new j((float) jSONObject.optDouble("threshold", jVar.f11448a), (float) jSONObject.optDouble("minSpeechRms", jVar.f11449b), jSONObject.optInt("speechStartMs", jVar.f11450c), jSONObject.optInt("silenceDurationMs", jVar.f11451d), jSONObject.optInt("leadingSilenceTimeoutMs", jVar.f11452e), jSONObject.optInt("maxDurationMs", jVar.f11453f), jSONObject.optInt("maxDurationCeilingMs", jVar.f11454g), jSONObject.optBoolean("levelEnabled", jVar.h), jSONObject.optInt("levelIntervalMs", jVar.f11455i), VadSessionManager.FRAME_BYTES);
    }

    public final String effectiveJsonForRecord$ability_release(Context context) {
        Object objA;
        Object objA2;
        g.f(context, "context");
        String configDir = readConfigDir(context);
        if (configDir != null && !q.t0(configDir)) {
            try {
                objA2 = new JSONArray(configDir);
            } catch (Throwable th) {
                objA2 = c.a(th);
            }
            if (!(objA2 instanceof Result.Failure)) {
                return configDir;
            }
        }
        try {
            InputStream inputStreamOpen = context.getAssets().open(ABILITIES_JSON);
            g.e(inputStreamOpen, "open(...)");
            objA = jd.b.F(new BufferedReader(new InputStreamReader(inputStreamOpen, gc.a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB));
        } catch (Throwable th2) {
            objA = c.a(th2);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            ai.onnxruntime.a.w("abilities.json 不在 assets，回落空配置: ", thB.getMessage(), LogModule.ABILITY, TAG);
            objA = "[]";
        }
        return (String) objA;
    }

    public final List<p6.a> loadAbilities(Context context) {
        g.f(context, "context");
        try {
            return parseAbilities(effectiveJsonForRecord$ability_release(context));
        } catch (Exception e10) {
            ai.onnxruntime.a.w("Failed to load abilities.json: ", e10.getMessage(), LogModule.ABILITY, TAG);
            return EmptyList.f10001a;
        }
    }

    public final Map<String, AbilityParams> loadParams(Context context) {
        g.f(context, "context");
        try {
            return parseParams(effectiveJsonForRecord$ability_release(context));
        } catch (Exception unused) {
            return kotlin.collections.b.d0();
        }
    }

    public final List<p6.a> parseAbilities(String json) {
        g.f(json, "json");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(json);
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            String string = jSONObject.getString(ModelDownloadNotifier.EXTRA_NOTIF_ID);
            String strOptString = jSONObject.optString("requires", "");
            g.c(strOptString);
            if (strOptString.length() <= 0 || checkRequirement(strOptString)) {
                try {
                    p6.a abilityConfig = parseAbilityConfig(jSONObject);
                    List<k> list = abilityConfig.f11419d;
                    if (list == null || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            List<String> list2 = ((k) it.next()).f3100l;
                            if (list2 == null || !list2.contains(Build.MODEL)) {
                                arrayList.add(abilityConfig);
                                AIEngineLogger.d(LogModule.ABILITY, TAG, "Parsed ability: " + string);
                                break;
                            }
                        }
                    }
                    AIEngineLogger.i(LogModule.ABILITY, TAG, "Skipping '" + string + "': device '" + Build.MODEL + "' in disabledDevices");
                } catch (Exception e10) {
                    AIEngineLogger.w(LogModule.ABILITY, TAG, ai.onnxruntime.a.l("Failed to parse ability '", string, "': ", e10.getMessage()));
                }
            } else {
                AIEngineLogger.d(LogModule.ABILITY, TAG, e.c("Skipping '", string, "': hardware requirement '", strOptString, "' not met"));
            }
        }
        return arrayList;
    }

    public final Map<String, AbilityParams> parseParams(String json) {
        g.f(json, "json");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = new JSONArray(json);
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i10);
            String string = jSONObject.getString(ModelDownloadNotifier.EXTRA_NOTIF_ID);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(BaseConstantsKt.KEY_PARAMS);
            if (jSONObjectOptJSONObject != null) {
                g.c(string);
                linkedHashMap.put(string, new AbilityParams(string, jSONObjectOptJSONObject.has("maxTokens") ? Integer.valueOf(jSONObjectOptJSONObject.getInt("maxTokens")) : null, jSONObjectOptJSONObject.has("temperature") ? Float.valueOf((float) jSONObjectOptJSONObject.getDouble("temperature")) : null, jSONObjectOptJSONObject.has("topK") ? Integer.valueOf(jSONObjectOptJSONObject.getInt("topK")) : null, jSONObjectOptJSONObject.has("topP") ? Float.valueOf((float) jSONObjectOptJSONObject.getDouble("topP")) : null, jSONObjectOptJSONObject.has("sampleRate") ? Integer.valueOf(jSONObjectOptJSONObject.getInt("sampleRate")) : null, jSONObjectOptJSONObject.has("threshold") ? Float.valueOf((float) jSONObjectOptJSONObject.getDouble("threshold")) : null));
            }
        }
        return linkedHashMap;
    }

    public final String pickJson(String str, String assetsJson) {
        Object objA;
        g.f(assetsJson, "assetsJson");
        if (str != null && !q.t0(str)) {
            try {
                objA = new JSONArray(str);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                return str;
            }
        }
        return assetsJson;
    }
}
