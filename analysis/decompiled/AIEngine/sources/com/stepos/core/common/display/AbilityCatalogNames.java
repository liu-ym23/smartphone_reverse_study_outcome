package com.stepos.core.common.display;

import android.content.Context;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.common.notification.ModelDownloadNotifier;
import com.stepos.core.model.manifest.ModelManifest;
import gc.a;
import gc.q;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jd.b;
import kotlin.Pair;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.g;
import mb.v;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityCatalogNames {
    private static final String ASSET = "abilities.json";
    public static final AbilityCatalogNames INSTANCE = new AbilityCatalogNames();
    private static final String TAG = "AbilityCatalogNames";
    private static volatile Map<String, String> cache;

    private AbilityCatalogNames() {
    }

    private final synchronized Map<String, String> load(Context context) {
        Object objA;
        BufferedReader bufferedReader;
        try {
            Map<String, String> map = cache;
            if (map != null) {
                return map;
            }
            try {
                InputStream inputStreamOpen = context.getAssets().open(ASSET);
                g.e(inputStreamOpen, "open(...)");
                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            try {
                String strF = b.F(bufferedReader);
                bufferedReader.close();
                objA = parseNames$common_release(strF);
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.OTA, TAG, "load abilities.json failed", thB);
                }
                Map mapD0 = kotlin.collections.b.d0();
                if (objA instanceof Result.Failure) {
                    objA = mapD0;
                }
                Map<String, String> map2 = (Map) objA;
                cache = map2;
                AIEngineLogger.i(LogModule.OTA, TAG, "loaded " + map2.size() + " modelId→name mappings");
                return map2;
            } finally {
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final String nameForModelId(Context context, String modelId) {
        g.f(context, "context");
        g.f(modelId, "modelId");
        if (q.t0(modelId)) {
            return "";
        }
        Map<String, String> mapLoad = cache;
        if (mapLoad == null) {
            mapLoad = load(context);
        }
        String str = mapLoad.get(modelId);
        return str == null ? "" : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<String, String> parseNames$common_release(String json) {
        Pair pair;
        g.f(json, "json");
        JSONArray jSONArray = new JSONArray(json);
        HashMap map = new HashMap();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString(ModelDownloadNotifier.EXTRA_NOTIF_ID);
                String strOptString2 = jSONObjectOptJSONObject.optString("name");
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(ModelManifest.TYPE_MODEL);
                String strOptString3 = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("modelId") : null;
                if (strOptString3 == null) {
                    strOptString3 = "";
                }
                if (!q.t0(strOptString3)) {
                    g.c(strOptString2);
                    if (!q.t0(strOptString2) && ((pair = (Pair) map.get(strOptString3)) == null || strOptString.compareTo((String) pair.f9986b) < 0)) {
                        map.put(strOptString3, new Pair(strOptString2, strOptString));
                    }
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a0(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), (String) ((Pair) entry.getValue()).f9985a);
        }
        return linkedHashMap;
    }
}
