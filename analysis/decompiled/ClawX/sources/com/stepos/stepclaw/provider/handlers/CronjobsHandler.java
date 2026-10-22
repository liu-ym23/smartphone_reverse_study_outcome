package com.stepos.stepclaw.provider.handlers;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/CronjobsHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "context", "Landroid/content/Context;", "rootfs", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "authority", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;Ljava/lang/String;)V", "cronJobsFile", "legacyBase", "query", "Landroid/database/Cursor;", "add", "Landroid/net/Uri;", "values", "Landroid/content/ContentValues;", "delete", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "jobId", "setEnabled", ExtensionCallContract.ENABLED, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "setLegacyEnabled", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CronjobsHandler {
    private final String authority;
    private final Context context;
    private final String cronJobsFile;
    private final String legacyBase;
    private final IRootfsAccess rootfs;

    public CronjobsHandler(Context context, IRootfsAccess rootfs, String authority) {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        p.e(authority, "authority");
        this.context = context;
        this.rootfs = rootfs;
        this.authority = authority;
        this.cronJobsFile = "root/.openclaw/cron/jobs.json";
        this.legacyBase = "root/.openclaw/cronjobs";
    }

    private final int setLegacyEnabled(String jobId, boolean enabled) throws JSONException {
        String str = this.legacyBase + "/" + jobId + ".json";
        if (!this.rootfs.resolveRootfsPath(str).exists()) {
            return 0;
        }
        try {
            String rootfsFile = this.rootfs.readRootfsFile(str);
            if (rootfsFile == null) {
                return 0;
            }
            JSONObject jSONObject = new JSONObject(rootfsFile);
            jSONObject.put(ExtensionCallContract.ENABLED, enabled);
            IRootfsAccess iRootfsAccess = this.rootfs;
            String string = jSONObject.toString(2);
            p.d(string, "toString(...)");
            iRootfsAccess.writeRootfsFile(str, string);
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public final Uri add(ContentValues values) throws JSONException {
        JSONObject jSONObject;
        p.e(values, "values");
        String asString = values.getAsString("job_id");
        if (asString == null) {
            throw new IllegalArgumentException("job_id required");
        }
        String asString2 = values.getAsString("name");
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (asString2 == null) {
            asString2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String asString3 = values.getAsString("description");
        if (asString3 == null) {
            asString3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        String asString4 = values.getAsString("cron");
        if (asString4 == null) {
            throw new IllegalArgumentException("cron required");
        }
        String asString5 = values.getAsString("action_type");
        if (asString5 == null) {
            asString5 = ExtensionCallContract.KIND_SKILL;
        }
        if (!asString5.equals(ExtensionCallContract.KIND_SKILL)) {
            throw new IllegalArgumentException("Only 'skill' action type allowed");
        }
        String asString6 = values.getAsString("action_target");
        if (asString6 != null) {
            str = asString6;
        }
        String asString7 = values.getAsString("action_params");
        if (asString7 == null) {
            asString7 = "{}";
        }
        Boolean asBoolean = values.getAsBoolean(ExtensionCallContract.ENABLED);
        boolean zBooleanValue = asBoolean != null ? asBoolean.booleanValue() : true;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("job_id", asString);
        jSONObject2.put("name", asString2);
        jSONObject2.put("description", asString3);
        jSONObject2.put("cron", asString4);
        jSONObject2.put(ExtensionCallContract.ENABLED, zBooleanValue);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("type", asString5);
        jSONObject3.put("skill_id", str);
        try {
            jSONObject = new JSONObject(asString7);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        jSONObject3.put("params", jSONObject);
        jSONObject2.put("action", jSONObject3);
        this.rootfs.ensureDirectory(this.legacyBase);
        IRootfsAccess iRootfsAccess = this.rootfs;
        String str2 = this.legacyBase + "/" + asString + ".json";
        String string = jSONObject2.toString(2);
        p.d(string, "toString(...)");
        iRootfsAccess.writeRootfsFile(str2, string);
        Uri uri = Uri.parse("content://" + this.authority + "/cronjobs/" + asString);
        p.d(uri, "parse(...)");
        return uri;
    }

    public final int delete(String jobId) {
        p.e(jobId, "jobId");
        File fileResolveRootfsPath = this.rootfs.resolveRootfsPath(this.legacyBase + "/" + jobId + ".json");
        if (!fileResolveRootfsPath.exists()) {
            return 0;
        }
        fileResolveRootfsPath.delete();
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0103  */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r20v2, types: [int] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.Cursor query() {
        /*
            Method dump skipped, instructions count: 550
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.provider.handlers.CronjobsHandler.query():android.database.Cursor");
    }

    public final int setEnabled(String jobId, boolean enabled) throws JSONException {
        p.e(jobId, "jobId");
        String string = n.T1(jobId).toString();
        if (string.length() == 0) {
            return 0;
        }
        String rootfsFile = this.rootfs.readRootfsFile(this.cronJobsFile);
        if (rootfsFile != null) {
            try {
                JSONObject jSONObject = new JSONObject(rootfsFile);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("jobs");
                if (jSONArrayOptJSONArray != null) {
                    int length = jSONArrayOptJSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i8);
                        if (jSONObjectOptJSONObject != null && p.a(jSONObjectOptJSONObject.optString("id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID), string)) {
                            jSONObjectOptJSONObject.put(ExtensionCallContract.ENABLED, enabled);
                            jSONObject.put("jobs", jSONArrayOptJSONArray);
                            this.rootfs.ensureDirectory("root/.openclaw/cron");
                            IRootfsAccess iRootfsAccess = this.rootfs;
                            String str = this.cronJobsFile;
                            String string2 = jSONObject.toString(2);
                            p.d(string2, "toString(...)");
                            iRootfsAccess.writeRootfsFile(str, string2);
                            return 1;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return setLegacyEnabled(string, enabled);
    }
}
