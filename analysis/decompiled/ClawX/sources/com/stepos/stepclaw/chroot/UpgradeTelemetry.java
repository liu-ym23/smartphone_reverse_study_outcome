package com.stepos.stepclaw.chroot;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import m5.l;
import org.json.JSONException;
import org.json.JSONObject;
import x5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/stepclaw/chroot/UpgradeTelemetry;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "Lcom/stepos/stepclaw/chroot/AssetManifest;", "m", "Lorg/json/JSONObject;", "manifestSummary", "(Lcom/stepos/stepclaw/chroot/AssetManifest;)Lorg/json/JSONObject;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "filesDir", "phase", "extra", "Lb5/a0;", "writeInProgress", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "clearInProgress", "(Ljava/lang/String;)V", "entry", "appendAudit", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "TAG", "Ljava/lang/String;", "IN_PROGRESS_FILE", "AUDIT_FILE", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "MAX_AUDIT_BYTES", "I", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpgradeTelemetry {
    public static final String AUDIT_FILE = "upgrade-audit.jsonl";
    public static final UpgradeTelemetry INSTANCE = new UpgradeTelemetry();
    public static final String IN_PROGRESS_FILE = "upgrade-in-progress.json";
    private static final int MAX_AUDIT_BYTES = 524288;
    private static final String TAG = "UpgradeTelemetry";

    private UpgradeTelemetry() {
    }

    public static /* synthetic */ void writeInProgress$default(UpgradeTelemetry upgradeTelemetry, String str, String str2, JSONObject jSONObject, int i8, Object obj) throws JSONException {
        if ((i8 & 4) != 0) {
            jSONObject = null;
        }
        upgradeTelemetry.writeInProgress(str, str2, jSONObject);
    }

    public final void appendAudit(String filesDir, JSONObject entry) {
        p.e(filesDir, "filesDir");
        p.e(entry, "entry");
        try {
            if (!entry.has("t")) {
                entry.put("t", System.currentTimeMillis());
            }
            File file = new File(filesDir, AUDIT_FILE);
            if (file.exists() && file.length() > 524288) {
                file.delete();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("t", System.currentTimeMillis());
                jSONObject.put(ExtensionCallContract.OP, "audit_rotated");
                jSONObject.put("reason", "max_bytes");
                l.w0(file, jSONObject.toString() + "\n", a.f6276a);
            }
            l.w0(file, entry.toString() + "\n", a.f6276a);
        } catch (Exception e9) {
            b.y("appendAudit failed: ", e9.getMessage(), TAG);
        }
    }

    public final void clearInProgress(String filesDir) {
        p.e(filesDir, "filesDir");
        try {
            File file = new File(filesDir, IN_PROGRESS_FILE);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e9) {
            b.y("clearInProgress failed: ", e9.getMessage(), TAG);
        }
    }

    public final JSONObject manifestSummary(AssetManifest m3) throws JSONException {
        p.e(m3, "m");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gatewayVersion", m3.getGatewayVersion());
        jSONObject.put("apkVersionCode", m3.getApkVersionCode());
        jSONObject.put("rootfsVersion", m3.getRootfsVersion());
        jSONObject.put("configVersion", m3.getConfigVersion());
        jSONObject.put("releaseProfileId", m3.getReleaseProfileId());
        jSONObject.put("buildTimestamp", m3.getBuildTimestamp());
        return jSONObject;
    }

    public final void writeInProgress(String filesDir, String phase, JSONObject extra) throws JSONException {
        p.e(filesDir, "filesDir");
        p.e(phase, "phase");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("phase", phase);
            jSONObject.put("startedAtMs", System.currentTimeMillis());
            if (extra != null) {
                Iterator<String> itKeys = extra.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, extra.get(next));
                }
            }
            File file = new File(filesDir, IN_PROGRESS_FILE);
            String string = jSONObject.toString(2);
            p.d(string, "toString(...)");
            l.G0(file, string, a.f6276a);
        } catch (Exception e9) {
            b.y("writeInProgress failed: ", e9.getMessage(), TAG);
        }
    }
}
