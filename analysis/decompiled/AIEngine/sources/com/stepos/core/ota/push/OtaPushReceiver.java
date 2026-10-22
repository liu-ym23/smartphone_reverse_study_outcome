package com.stepos.core.ota.push;

import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.cta.CTAPermissionManager;
import com.stepos.core.ota.d;
import gc.n;
import gc.q;
import gc.r;
import kotlin.Result;
import kotlin.c;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import n7.b;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaPushReceiver extends b {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_FORCE_UPDATE = "forceUpdate";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_MODEL_ID = "modelId";
    private static final String KEY_MODEL_UPDATE = "modelUpdate";
    private static final String KEY_SIZE = "size";
    private static final String KEY_TASK_ID = "taskId";
    private static final String KEY_VERSION_CODE = "versionCode";
    private static final String TAG = "OtaPushReceiver";

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    private final void diag(String str) {
        h0.e.k("[DIAG] ", str, LogModule.OTA, TAG);
    }

    private final void dispatchIfValid(Context context, String str) {
        if (!CTAPermissionManager.INSTANCE.isModelOtaAllowed()) {
            AIEngineLogger.w(LogModule.OTA, TAG, "skip: CTA not granted, drop push");
            diag(ai.onnxruntime.a.k("drop push: CTA not granted payload=", preview(str)));
            return;
        }
        OtaPushModelUpdate modelUpdate = parseModelUpdate(str);
        if (modelUpdate == null) {
            ai.onnxruntime.a.w("skip: no modelUpdate in payload=", preview(str), LogModule.OTA, TAG);
            diag(ai.onnxruntime.a.k("drop push: no modelUpdate payload=", preview(str)));
            return;
        }
        diag(ai.onnxruntime.a.k("push parsed ", modelUpdate.summary()));
        OtaPushDownloadGate.INSTANCE.schedule(context, modelUpdate);
        AIEngineLogger.i(LogModule.OTA, TAG, "dispatched to gate: modelId=" + modelUpdate.getModelId() + " force=" + modelUpdate.getForceUpdate());
        diag(ai.onnxruntime.a.k("push dispatched to gate ", modelUpdate.summary()));
    }

    private final boolean parseForceUpdate(JSONObject jSONObject) {
        if (jSONObject.has(KEY_FORCE_UPDATE)) {
            Object objOpt = jSONObject.opt(KEY_FORCE_UPDATE);
            if (objOpt instanceof Boolean) {
                return ((Boolean) objOpt).booleanValue();
            }
            if (objOpt instanceof Number) {
                return ((Number) objOpt).intValue() == 1;
            }
            if (objOpt instanceof String) {
                return ((String) objOpt).equalsIgnoreCase("true") || objOpt.equals("1");
            }
        }
        return false;
    }

    private final OtaPushModelUpdate parseModelUpdate(String str) {
        String string;
        Object objA;
        Object objA2;
        if (str != null && (string = q.L0(str).toString()) != null) {
            if (string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                try {
                    objA = new JSONObject(string);
                } catch (Throwable th) {
                    objA = c.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = null;
                }
                JSONObject jSONObject = (JSONObject) objA;
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("content");
                    g.c(strOptString);
                    if (q.t0(strOptString)) {
                        strOptString = null;
                    }
                    if (strOptString != null) {
                        try {
                            objA2 = new JSONObject(strOptString);
                        } catch (Throwable th2) {
                            objA2 = c.a(th2);
                        }
                        if (objA2 instanceof Result.Failure) {
                            objA2 = null;
                        }
                        JSONObject jSONObject2 = (JSONObject) objA2;
                        if (jSONObject2 != null) {
                            jSONObject = jSONObject2;
                        }
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(KEY_MODEL_UPDATE);
                    if (jSONObjectOptJSONObject != null) {
                        String strOptString2 = jSONObjectOptJSONObject.optString(KEY_MODEL_ID);
                        g.c(strOptString2);
                        String str2 = !q.t0(strOptString2) ? strOptString2 : null;
                        if (str2 != null) {
                            String strOptString3 = jSONObjectOptJSONObject.optString("md5");
                            g.c(strOptString3);
                            if (q.t0(strOptString3)) {
                                strOptString3 = null;
                            }
                            String strOptString4 = jSONObjectOptJSONObject.optString(KEY_VERSION_CODE);
                            g.c(strOptString4);
                            String str3 = !q.t0(strOptString4) ? strOptString4 : null;
                            String strOptString5 = jSONObjectOptJSONObject.optString(KEY_SIZE);
                            g.e(strOptString5, "optString(...)");
                            Long lD0 = n.d0(strOptString5);
                            String strOptString6 = jSONObjectOptJSONObject.optString(KEY_TASK_ID);
                            g.c(strOptString6);
                            return new OtaPushModelUpdate(str2, str3, lD0, !q.t0(strOptString6) ? strOptString6 : null, strOptString3 != null ? a0.a.g("len=", strOptString3.length(), ",hash=", r.R0(8, strOptString3)) : null, parseForceUpdate(jSONObjectOptJSONObject));
                        }
                    }
                }
            }
        }
        return null;
    }

    private final String preview(String str) {
        if (str == null) {
            return "null";
        }
        int length = str.length();
        String hexString = Integer.toHexString(str.hashCode());
        g.e(hexString, "toHexString(...)");
        return a0.a.g("len=", length, ",hash=", r.R0(8, hexString));
    }

    @Override // n7.b, z7.b
    public void onMessage(Context context, String str, String str2) {
        g.f(context, "context");
        AIEngineLogger.i(LogModule.OTA, TAG, ai.onnxruntime.a.l("onMessage: ", preview(str), " extra=", preview(str2)));
        diag(ai.onnxruntime.a.l("push message arrived payload=", preview(str), " extra=", preview(str2)));
        dispatchIfValid(context, str);
    }

    @Override // n7.b, z7.b
    public void onNotificationArrived(Context context, u7.a aVar) {
        g.f(context, "context");
        h0.e.k("onNotificationArrived: taskId=", aVar != null ? aVar.f13178c : null, LogModule.OTA, TAG);
        diag(ai.onnxruntime.a.l("push notification arrived taskId=", aVar != null ? aVar.f13178c : null, " payload=", preview(aVar != null ? aVar.f13179d : null)));
        dispatchIfValid(context, aVar != null ? aVar.f13179d : null);
    }

    @Override // n7.b, z7.b
    public void onNotificationClicked(Context context, u7.a aVar) {
        g.f(context, "context");
        h0.e.k("onNotificationClicked: taskId=", aVar != null ? aVar.f13178c : null, LogModule.OTA, TAG);
        diag(ai.onnxruntime.a.k("push notification clicked taskId=", aVar != null ? aVar.f13178c : null));
    }

    @Override // n7.b, z7.b
    public void onRegisterStatus(Context context, y7.b bVar) {
        g.f(context, "context");
        super.onRegisterStatus(context, bVar);
        if (bVar == null) {
            return;
        }
        LogModule logModule = LogModule.OTA;
        String str = (String) bVar.f10168c;
        String str2 = bVar.f14169e;
        AIEngineLogger.i(logModule, TAG, d.h("onRegisterStatus: code=", str2 != null ? str2.length() : 0, str, " pushIdLen="));
        String str3 = (String) bVar.f10168c;
        String str4 = bVar.f14169e;
        diag(d.h("push register status code=", str4 != null ? str4.length() : 0, str3, " pushIdLen="));
    }
}
