package com.stepos.backend.qnn;

import android.util.Log;
import com.stepos.core.ability.converter.BundleContentBridge;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.model.manifest.ModelManifest;
import gc.r;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SmsParseGenieConfig {
    public static final String DEFAULT_GENIE_CONFIG_NAME = "genie-config.json";
    public static final int GENIE_STATUS_ERROR_JSON_SCHEMA = -8;
    public static final boolean INJECT_POS_EMBEDDING_PATH = false;
    public static final SmsParseGenieConfig INSTANCE = new SmsParseGenieConfig();
    private static final boolean SMSPARSE_ALLOW_ASYNC_INIT = false;
    private static final int SMSPARSE_DEFAULT_CONTEXT_SIZE = 512;
    private static final String TAG = "SmsParseGenieConfig";

    private SmsParseGenieConfig() {
    }

    private final String applyPlaceholders(String str, File file) {
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = new File(file, "tokenizer.json").getAbsolutePath();
        for (Map.Entry entry : kotlin.collections.b.g0(new Pair("<models_path>", absolutePath), new Pair("<adapter_models_path>", absolutePath), new Pair("<htp_backend_ext_path>", new File(file, "htp_backend_ext_config.json").getAbsolutePath()), new Pair("<tokenizer_path>", absolutePath2), new Pair("\"<max_num_tokens>\"", "512"), new Pair("\"<context_size>\"", "2048"), new Pair("\"<temp>\"", "0.4"), new Pair("\"<top_k>\"", "1"), new Pair("\"<top_p>\"", "1.0"), new Pair("\"<n_threads>\"", "2"), new Pair("\"<greedy>\"", "false"), new Pair("\"<repetition_penalty>\"", "1.0")).entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            kotlin.jvm.internal.g.c(str3);
            str = gc.o.i0(str, str2, str3);
        }
        return str;
    }

    private final boolean needsPlaceholderPass(String str) {
        return gc.q.l0(str, "<models_path>", false) || gc.q.l0(str, "<tokenizer_path>", false) || gc.q.l0(str, "<htp_backend_ext_path>", false) || gc.q.l0(str, "<adapter_models_path>", false);
    }

    private final void prepareDatFiles(File file) throws IOException {
        File file2 = new File(file, "raw_init/position_ids_sin.raw");
        File file3 = new File(file, "raw_init/position_ids_cos.raw");
        File file4 = new File(file, "position_ids_sin.ufixed16.dat");
        File file5 = new File(file, "position_ids_cos.ufixed16.dat");
        if (!file4.exists() && file2.isFile()) {
            wb.d.S(file2, file4, false);
            ai.onnxruntime.a.y(com.stepos.core.ota.d.l("Created ", file4.length(), file4.getName(), " ("), " bytes)", TAG);
        }
        if (file5.exists() || !file3.isFile()) {
            return;
        }
        wb.d.S(file3, file5, false);
        ai.onnxruntime.a.y(com.stepos.core.ota.d.l("Created ", file5.length(), file5.getName(), " ("), " bytes)", TAG);
    }

    public final String applySmsparseEngineDefaults(String json) {
        kotlin.jvm.internal.g.f(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            JSONObject jSONObject2 = jSONObject.getJSONObject("dialog");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("context");
            JSONObject jSONObject4 = jSONObject2.getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
            int iOptInt = jSONObject3.optInt("size", -1);
            if (iOptInt != 512) {
                jSONObject3.put("size", 512);
                Log.i(TAG, "applySmsparseEngineDefaults: context.size " + iOptInt + " -> 512 (包内 genie-config 未更新时由 APK 覆盖)");
            }
            jSONObject4.optBoolean("allow-async-init", false);
            return jSONObject.toString();
        } catch (Exception e10) {
            a0.a.A("applySmsparseEngineDefaults skipped: ", e10.getMessage(), TAG);
            return json;
        }
    }

    public final String dedupeQnnHtpRopeWhenModelHasPositionalEncoding(String json) throws JSONException {
        boolean z;
        kotlin.jvm.internal.g.f(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            if (jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject(ModelManifest.TYPE_MODEL).has("positional-encoding")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
                boolean z3 = true;
                if (jSONObject2.has("rope-theta")) {
                    jSONObject2.remove("rope-theta");
                    Log.i(TAG, "dedupeQnnHtpRope: removed QnnHtp.rope-theta (keep model.positional-encoding only; avoids Genie -8)");
                    z = true;
                } else {
                    z = false;
                }
                if (jSONObject2.has("pos-id-dim")) {
                    jSONObject2.remove("pos-id-dim");
                    Log.i(TAG, "dedupeQnnHtpRope: removed QnnHtp.pos-id-dim (model.positional-encoding present)");
                } else {
                    z3 = z;
                }
                if (z3) {
                    return jSONObject.toString();
                }
            }
            return json;
        } catch (Exception e10) {
            a0.a.A("dedupeQnnHtpRopeWhenModelHasPositionalEncoding skipped: ", e10.getMessage(), TAG);
            return json;
        }
    }

    public final void ensureHtpBackendConfig(File modelRoot) {
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        File file = new File(modelRoot, "htp_backend_ext_config.json");
        if (file.exists() && file.length() >= 10) {
            Log.i(TAG, "htp_backend_ext_config.json exists: " + file.length() + " bytes");
            return;
        }
        Log.w(TAG, "htp_backend_ext_config.json 不存在或损坏（" + file.length() + " bytes），创建默认配置");
        wb.d.d0(file, "{\n  \"graphs\": {\n    \"Llama_graph\": {\n      \"graph_names\": [\"ar32_1_of_2\", \"ar32_2_of_2\"],\n      \"vtcm_mb\": 8,\n      \"fp16_relaxed_precision\": 1\n    }\n  }\n}", gc.a.f9106b);
        a0.a.y("Created default htp_backend_ext_config.json: ", file.getAbsolutePath(), TAG);
    }

    public final String ensureQnnHtpMandatoryFieldsForGenie(String json) throws JSONException {
        boolean z;
        kotlin.jvm.internal.g.f(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            JSONObject jSONObject2 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
            boolean z3 = true;
            if (jSONObject2.has("spill-fill-bufsize")) {
                z = false;
            } else {
                jSONObject2.put("spill-fill-bufsize", 0);
                z = true;
            }
            if (!jSONObject2.has("mmap-budget")) {
                jSONObject2.put("mmap-budget", 0);
                z = true;
            }
            if (!jSONObject2.has("cpu-mask")) {
                jSONObject2.put("cpu-mask", "0xe0");
                z = true;
            }
            if (jSONObject2.has("poll")) {
                z3 = z;
            } else {
                jSONObject2.put("poll", true);
            }
            if (z3) {
                Log.i(TAG, "ensureQnnHtpMandatoryFieldsForGenie: 已补全 QnnHtp 必填项（spill-fill-bufsize/mmap-budget/cpu-mask/poll）");
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            a0.a.A("ensureQnnHtpMandatoryFieldsForGenie skipped: ", e10.getMessage(), TAG);
            return json;
        }
    }

    public final boolean hasRawInitRoPeFiles(File modelRoot) {
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        return new File(modelRoot, "raw_init/position_ids_sin.raw").isFile() && new File(modelRoot, "raw_init/position_ids_cos.raw").isFile();
    }

    public final String loadResolvedGenieJson(File modelRoot, String bundleConfigPath) throws IOException {
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        kotlin.jvm.internal.g.f(bundleConfigPath, "bundleConfigPath");
        File file = new File(modelRoot, DEFAULT_GENIE_CONFIG_NAME);
        if (!file.isFile()) {
            File file2 = new File(bundleConfigPath);
            if (!file2.isFile()) {
                throw new IllegalArgumentException(ai.onnxruntime.a.l("缺少 Genie 配置：既无 ", new File(modelRoot, DEFAULT_GENIE_CONFIG_NAME).getPath(), "，也无入口文件 ", bundleConfigPath).toString());
            }
            String strZ = wb.d.Z(file2, gc.a.f9106b);
            return needsPlaceholderPass(strZ) ? applyPlaceholders(strZ, modelRoot) : strZ;
        }
        if (file.length() <= 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.k("genie-config.json 存在但为空，请删除或填入合法 Dialog JSON（参考仓库 genie-config-smsparse.json）: ", file.getPath()).toString());
        }
        String string = gc.q.L0(wb.d.Z(file, gc.a.f9106b)).toString();
        if (string.length() <= 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.k("genie-config.json 无有效内容: ", file.getPath()).toString());
        }
        String strApplyPlaceholders = applyPlaceholders(string, modelRoot);
        File file3 = new File(modelRoot, "htp_backend_ext_config.json");
        String name = file.getName();
        long length = file.length();
        int length2 = strApplyPlaceholders.length();
        boolean zIsFile = file3.isFile();
        String strR0 = r.R0(160, strApplyPlaceholders);
        StringBuilder sbL = com.stepos.core.ota.d.l("Using ", length, name, " (");
        sbL.append(" bytes) → resolved len=");
        sbL.append(length2);
        sbL.append(", htp_backend_ext_config.json exists=");
        sbL.append(zIsFile);
        sbL.append(" preview=");
        sbL.append(strR0);
        sbL.append("...");
        Log.i(TAG, sbL.toString());
        return strApplyPlaceholders;
    }

    public final void logInitDiagnostics(File modelRoot, String resolvedJson) {
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        kotlin.jvm.internal.g.f(resolvedJson, "resolvedJson");
        if (gc.q.l0(resolvedJson, "<models_path>", false) || gc.q.l0(resolvedJson, "<tokenizer_path>", false)) {
            Log.e(TAG, "genie JSON 仍含占位符，占位符替换未生效，native 必失败");
        }
        try {
            JSONObject jSONObject = new JSONObject(resolvedJson).getJSONObject("dialog");
            JSONObject jSONObject2 = jSONObject.getJSONObject("context");
            JSONObject jSONObject3 = jSONObject.getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
            JSONArray jSONArray = jSONObject.getJSONObject("engine").getJSONObject(ModelManifest.TYPE_MODEL).getJSONObject("binary").getJSONArray("ctx-bins");
            String strOptString = jSONObject.getJSONObject("engine").getJSONObject("backend").optString("extensions", "");
            String string = jSONObject.getJSONObject("tokenizer").getString(BundleContentBridge.KEY_PATH);
            StringBuilder sb2 = new StringBuilder("context.size=");
            JSONArray jSONArray2 = jSONArray;
            sb2.append(jSONObject2.optInt("size", -1));
            sb2.append(" n-vocab=");
            sb2.append(jSONObject2.optInt("n-vocab", -1));
            sb2.append(" | QnnHtp kv-dim=");
            sb2.append(jSONObject3.optInt("kv-dim", -1));
            sb2.append(" allow-async-init=");
            sb2.append(jSONObject3.optBoolean("allow-async-init", false));
            if (jSONObject3.has("pos-id-dim")) {
                sb2.append(" pos-id-dim=");
                sb2.append(jSONObject3.optInt("pos-id-dim"));
            }
            sb2.append(" | extensions=");
            sb2.append(strOptString);
            if (jSONObject.getJSONObject("engine").getJSONObject(ModelManifest.TYPE_MODEL).has("positional-encoding")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("engine").getJSONObject(ModelManifest.TYPE_MODEL).getJSONObject("positional-encoding");
                sb2.append(" | rope-dim=");
                sb2.append(jSONObject4.optInt("rope-dim", -1));
                sb2.append(" rope-theta=");
                sb2.append(jSONObject4.optDouble("rope-theta", -1.0d));
            }
            Log.i(TAG, sb2.toString());
            File file = new File(string);
            Log.i(TAG, "tokenizer: exists=" + file.isFile() + " len=" + (file.isFile() ? file.length() : -1L) + " path=" + string);
            int length = jSONArray2.length();
            int i10 = 0;
            while (i10 < length) {
                JSONArray jSONArray3 = jSONArray2;
                String string2 = jSONArray3.getString(i10);
                File file2 = new File(string2);
                Log.i(TAG, "ctx-bin[" + i10 + "]: exists=" + file2.isFile() + " len=" + (file2.isFile() ? file2.length() : -1L) + " path=" + string2);
                i10++;
                jSONArray2 = jSONArray3;
            }
            File file3 = new File(modelRoot, "htp_backend_ext_config.json");
            Log.i(TAG, "htp_backend_ext_config.json: exists=" + file3.isFile() + " len=" + (file3.isFile() ? file3.length() : -1L));
        } catch (Exception e10) {
            a0.a.A("logInitDiagnostics parse failed: ", e10.getMessage(), TAG);
        }
    }

    public final String maybeInjectPosEmbeddingPath(File modelRoot, String json) throws JSONException {
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        kotlin.jvm.internal.g.f(json, "json");
        File file = new File(modelRoot, "raw_init/position_ids_sin.raw");
        File file2 = new File(modelRoot, "raw_init/position_ids_cos.raw");
        if (file.isFile() && file2.isFile()) {
            try {
                JSONObject jSONObject = new JSONObject(json);
                JSONObject jSONObject2 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
                String absolutePath = new File(modelRoot, "raw_init").getAbsolutePath();
                jSONObject2.put("pos-embedding-path", absolutePath);
                Log.i(TAG, "Injected pos-embedding-path=" + absolutePath + " (raw_init present)");
                return jSONObject.toString();
            } catch (Exception e10) {
                a0.a.A("maybeInjectPosEmbeddingPath skipped: ", e10.getMessage(), TAG);
            }
        }
        return json;
    }

    public final String stripPosEmbeddingPath(String json) throws JSONException {
        kotlin.jvm.internal.g.f(json, "json");
        try {
            JSONObject jSONObject = new JSONObject(json);
            JSONObject jSONObject2 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
            if (jSONObject2.has("pos-embedding-path")) {
                jSONObject2.remove("pos-embedding-path");
                Log.i(TAG, "Stripped pos-embedding-path for Genie retry");
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return json;
        }
    }

    public final String switchToPrecomputedPositionIds(String json, File modelRoot) throws JSONException {
        kotlin.jvm.internal.g.f(json, "json");
        kotlin.jvm.internal.g.f(modelRoot, "modelRoot");
        if (!hasRawInitRoPeFiles(modelRoot)) {
            return json;
        }
        try {
            JSONObject jSONObject = new JSONObject(json);
            JSONObject jSONObject2 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject(ModelManifest.TYPE_MODEL);
            JSONObject jSONObject3 = jSONObject.getJSONObject("dialog").getJSONObject("engine").getJSONObject("backend").getJSONObject("QnnHtp");
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("positional-encoding");
            int iOptInt = TraceIdKeys.MAX_LENGTH;
            if (jSONObjectOptJSONObject != null) {
                iOptInt = jSONObjectOptJSONObject.optInt("rope-dim", TraceIdKeys.MAX_LENGTH);
            }
            jSONObject2.remove("positional-encoding");
            jSONObject3.remove("rope-theta");
            jSONObject3.put("pos-id-dim", iOptInt);
            prepareDatFiles(modelRoot);
            Log.i(TAG, "switchToPrecomputedPositionIds: removed positional-encoding, set QnnHtp.pos-id-dim=" + iOptInt + ", created .ufixed16.dat in " + modelRoot.getPath());
            return jSONObject.toString();
        } catch (Exception e10) {
            a0.a.A("switchToPrecomputedPositionIds skipped: ", e10.getMessage(), TAG);
            return json;
        }
    }
}
