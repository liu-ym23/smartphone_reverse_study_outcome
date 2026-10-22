package com.stepos.core.model.manifest;

import android.content.Context;
import android.util.Log;
import com.stepos.core.ability.speech.PcmDumpBudget;
import dc.e;
import dc.h;
import gc.a;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jd.b;
import kotlin.Result;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import mb.m;
import mb.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import wb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelManifestLoader {
    public static final String ASSETS_PATH = "models_manifest.json";
    public static final ModelManifestLoader INSTANCE = new ModelManifestLoader();
    private static final String TAG = "ModelManifestLoader";

    private ModelManifestLoader() {
    }

    public static /* synthetic */ List loadFromAssets$default(ModelManifestLoader modelManifestLoader, Context context, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = ASSETS_PATH;
        }
        return modelManifestLoader.loadFromAssets(context, str);
    }

    private final ModelManifest parseEntry(JSONObject jSONObject) throws JSONException {
        List arrayList;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tags");
        if (jSONArrayOptJSONArray != null) {
            e eVarE0 = h.e0(0, jSONArrayOptJSONArray.length());
            arrayList = new ArrayList(m.Z(eVarE0, 10));
            Iterator<Integer> it = eVarE0.iterator();
            while (it.hasNext()) {
                arrayList.add(jSONArrayOptJSONArray.getString(((t) it).nextInt()));
            }
        } else {
            arrayList = EmptyList.f10001a;
        }
        List list = arrayList;
        String string = jSONObject.getString("ability_id");
        g.e(string, "getString(...)");
        String strOptString = jSONObject.optString("manifest_type", ModelManifest.TYPE_MODEL);
        g.e(strOptString, "optString(...)");
        String string2 = jSONObject.getString("ability_type");
        g.e(string2, "getString(...)");
        String strOptString2 = jSONObject.optString("description", "");
        g.e(strOptString2, "optString(...)");
        String string3 = jSONObject.getString("model_id");
        g.e(string3, "getString(...)");
        String string4 = jSONObject.getString("model_file");
        g.e(string4, "getString(...)");
        String strOptString3 = jSONObject.optString("backend", ModelManifest.BACKEND_NONE);
        g.e(strOptString3, "optString(...)");
        String strOptString4 = jSONObject.optString("base_ability_id", "");
        g.e(strOptString4, "optString(...)");
        String strOptString5 = jSONObject.optString("plugin_key", "");
        g.e(strOptString5, "optString(...)");
        return new ModelManifest(string, strOptString, string2, strOptString2, string3, string4, strOptString3, list, strOptString4, strOptString5);
    }

    public final List<ModelManifest> loadFromAssets(Context context, String assetName) throws IOException {
        g.f(context, "context");
        g.f(assetName, "assetName");
        try {
            InputStream inputStreamOpen = context.getAssets().open(assetName);
            g.e(inputStreamOpen, "open(...)");
            return parse$model_release(b.F(new BufferedReader(new InputStreamReader(inputStreamOpen, a.f9106b), PcmDumpBudget.HARD_MAX_DIR_MB)));
        } catch (Exception e10) {
            Log.e(TAG, "loadFromAssets failed: ".concat(assetName), e10);
            return EmptyList.f10001a;
        }
    }

    public final List<ModelManifest> loadFromFile(String path) {
        g.f(path, "path");
        try {
            return parse$model_release(d.Z(new File(path), a.f9106b));
        } catch (Exception e10) {
            Log.e(TAG, "loadFromFile failed: ".concat(path), e10);
            return EmptyList.f10001a;
        }
    }

    public final List<ModelManifest> parse$model_release(String json) throws JSONException {
        Object objA;
        g.f(json, "json");
        JSONArray jSONArrayOptJSONArray = new JSONObject(json).optJSONArray("abilities");
        if (jSONArrayOptJSONArray == null) {
            return EmptyList.f10001a;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i10);
            try {
                g.c(jSONObject);
                objA = parseEntry(jSONObject);
            } catch (Throwable th) {
                objA = c.a(th);
            }
            if (!(objA instanceof Result.Failure)) {
                arrayList.add((ModelManifest) objA);
            }
            Throwable thB = Result.b(objA);
            if (thB != null) {
                a0.a.u("Skip invalid entry[", i10, "]: ", thB.getMessage(), TAG);
            }
        }
        Log.d(TAG, "Loaded " + arrayList.size() + " manifest entries");
        return arrayList;
    }
}
