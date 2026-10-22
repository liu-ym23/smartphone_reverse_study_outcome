package com.stepos.stepclaw.provider.handlers;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\tJ\"\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/InstallVersionResolver;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "DEFAULT_VERSION", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "LEGACY_INSTALL_VERSION_KEY", "META_VERSION_KEY", "parseJSONObject", "Lorg/json/JSONObject;", "raw", "firstMetaVersionFromMerged", "mergedMeta", "versionFromMergedJsonReadCompat", "resolve", "businessVersion", "mergedMetaJson", "markdownVersion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InstallVersionResolver {
    public static final String DEFAULT_VERSION = "1.0.0";
    public static final InstallVersionResolver INSTANCE = new InstallVersionResolver();
    private static final String LEGACY_INSTALL_VERSION_KEY = "install_version";
    public static final String META_VERSION_KEY = "version";

    private InstallVersionResolver() {
    }

    public final String firstMetaVersionFromMerged(JSONObject mergedMeta) {
        p.e(mergedMeta, "mergedMeta");
        return versionFromMergedJsonReadCompat(mergedMeta);
    }

    public final JSONObject parseJSONObject(String raw) {
        if (raw != null && !n.t1(raw)) {
            try {
                JSONObject jSONObject = new JSONObject(raw);
                if (jSONObject.length() > 0) {
                    return jSONObject;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final String resolve(String businessVersion, JSONObject mergedMetaJson, String markdownVersion) {
        String string;
        String string2;
        p.e(mergedMetaJson, "mergedMetaJson");
        if (businessVersion != null && (string2 = n.T1(businessVersion).toString()) != null) {
            if (string2.length() <= 0) {
                string2 = null;
            }
            if (string2 != null) {
                return string2;
            }
        }
        String strVersionFromMergedJsonReadCompat = versionFromMergedJsonReadCompat(mergedMetaJson);
        if (strVersionFromMergedJsonReadCompat != null) {
            return strVersionFromMergedJsonReadCompat;
        }
        if (markdownVersion == null || (string = n.T1(markdownVersion).toString()) == null) {
            return DEFAULT_VERSION;
        }
        String str = string.length() > 0 ? string : null;
        return str != null ? str : DEFAULT_VERSION;
    }

    public final String versionFromMergedJsonReadCompat(JSONObject mergedMeta) {
        p.e(mergedMeta, "mergedMeta");
        String strOptString = mergedMeta.optString("version", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        p.d(strOptString, "optString(...)");
        String string = n.T1(strOptString).toString();
        if (string.length() <= 0) {
            string = null;
        }
        if (string != null) {
            return string;
        }
        String strOptString2 = mergedMeta.optString(LEGACY_INSTALL_VERSION_KEY, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        p.d(strOptString2, "optString(...)");
        String string2 = n.T1(strOptString2).toString();
        if (string2.length() <= 0) {
            string2 = null;
        }
        if (string2 != null) {
            return string2;
        }
        return null;
    }
}
