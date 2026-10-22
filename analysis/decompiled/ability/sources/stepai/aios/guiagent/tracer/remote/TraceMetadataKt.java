package stepai.aios.guiagent.tracer.remote;

import C7.r;
import N9.j;
import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;
import z2.l;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"buildAppMetadata", "Lcom/google/gson/JsonObject;", "guiagent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TraceMetadataKt {
    public static final JsonObject buildAppMetadata() {
        Object objA;
        Application application;
        JsonObject jsonObject = new JsonObject();
        try {
            application = l.b;
        } catch (Throwable th) {
            objA = b.a(th);
        }
        if (application == null) {
            k.n("application");
            throw null;
        }
        PackageManager packageManager = application.getPackageManager();
        String packageName = application.getPackageName();
        String string = application.getApplicationInfo().loadLabel(packageManager).toString();
        PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
        String str = packageInfo.versionName;
        int i = Build.VERSION.SDK_INT;
        long longVersionCode = packageInfo.getLongVersionCode();
        jsonObject.addProperty(GuiAgentConfigKt.META_KEY_APP_NAME, string);
        jsonObject.addProperty("app_version_name", str);
        jsonObject.addProperty("app_version_code", Long.valueOf(longVersionCode));
        jsonObject.addProperty("sdk_version", Integer.valueOf(i));
        jsonObject.addProperty("gui_agent_version", "1.1.18");
        objA = r.f317a;
        Throwable thA = Result.a(objA);
        if (thA != null) {
            j.J("buildAppMetadata failed: " + thA.getMessage(), "RobotTrace");
        }
        return jsonObject;
    }
}
