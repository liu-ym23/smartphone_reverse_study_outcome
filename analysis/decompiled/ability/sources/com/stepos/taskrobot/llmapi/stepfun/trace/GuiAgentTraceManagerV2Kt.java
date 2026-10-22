package com.stepos.taskrobot.llmapi.stepfun.trace;

import android.app.Application;
import android.os.Build;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import z2.l;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002¨\u0006\u0002"}, d2 = {"buildLocalAppMetadata", "Lcom/google/gson/JsonObject;", "stepfun_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentTraceManagerV2Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonObject buildLocalAppMetadata() {
        JsonObject jsonObject = new JsonObject();
        Application application = l.b;
        if (application == null) {
            k.n("application");
            throw null;
        }
        jsonObject.addProperty("app_package_name", application.getPackageName());
        jsonObject.addProperty("app_version_name", "");
        jsonObject.addProperty("app_version_code", (Number) 0);
        jsonObject.addProperty("device_model", Build.MODEL);
        jsonObject.addProperty("sdk_int", Integer.valueOf(Build.VERSION.SDK_INT));
        return jsonObject;
    }
}
