package com.stepos.stepclaw.provider.handlers;

import a8.b;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.provider.backend.IRootfsAccess;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import org.json.JSONArray;
import org.json.JSONObject;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0014\u0010 \u001a\u00020\n8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/stepclaw/provider/handlers/ChannelsHandler;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "rootfs", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;)V", "Landroid/database/MatrixCursor;", "cursor", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "type", "accountId", "Lorg/json/JSONObject;", "account", "Lb5/a0;", "addChannelRow", "(Landroid/database/MatrixCursor;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", "accountIdFromArrayElement", "(Lorg/json/JSONObject;Ljava/lang/String;I)Ljava/lang/String;", "Landroid/database/Cursor;", "query", "()Landroid/database/Cursor;", "channelId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ExtensionCallContract.ENABLED, "setEnabled", "(Ljava/lang/String;Z)I", "Landroid/content/Context;", "Lcom/stepos/stepclaw/provider/backend/IRootfsAccess;", "configPath", "Ljava/lang/String;", "fsLock", "Ljava/lang/Object;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChannelsHandler {
    private static final String TAG = "ChannelsHandler";
    private final String configPath;
    private final Context context;
    private final Object fsLock;
    private final IRootfsAccess rootfs;

    public ChannelsHandler(Context context, IRootfsAccess rootfs) {
        p.e(context, "context");
        p.e(rootfs, "rootfs");
        this.context = context;
        this.rootfs = rootfs;
        this.configPath = "root/.openclaw/openclaw.json";
        this.fsLock = new Object();
    }

    private final String accountIdFromArrayElement(JSONObject account, String type, int index) {
        String strOptString = account.optString("id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        if (strOptString.length() == 0) {
            strOptString = account.optString("name", type + "-" + index);
        }
        p.d(strOptString, "ifEmpty(...)");
        return strOptString;
    }

    private final void addChannelRow(MatrixCursor cursor, String type, String accountId, JSONObject account) {
        boolean zOptBoolean = account.optBoolean(ExtensionCallContract.ENABLED, true);
        cursor.addRow(new Object[]{b.o(type, ":", accountId), accountId, zOptBoolean ? "configured" : "disabled", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, Integer.valueOf(zOptBoolean ? 1 : 0)});
    }

    public final Cursor query() {
        synchronized (this.fsLock) {
            try {
                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"channel_id", "name", "status", "version", ExtensionCallContract.ENABLED});
                String rootfsFile = this.rootfs.readRootfsFile(this.configPath);
                if (rootfsFile == null) {
                    return matrixCursor;
                }
                try {
                    JSONObject jSONObjectOptJSONObject = new JSONObject(rootfsFile).optJSONObject("channels");
                    if (jSONObjectOptJSONObject == null) {
                        return matrixCursor;
                    }
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    p.d(itKeys, "keys(...)");
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(next);
                        if (jSONObjectOptJSONObject2 != null) {
                            if (jSONObjectOptJSONObject2.optJSONArray("accounts") != null) {
                                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("accounts");
                                p.b(jSONArrayOptJSONArray);
                                int length = jSONArrayOptJSONArray.length();
                                for (int i8 = 0; i8 < length; i8++) {
                                    JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i8);
                                    if (jSONObjectOptJSONObject3 != null) {
                                        p.b(next);
                                        addChannelRow(matrixCursor, next, accountIdFromArrayElement(jSONObjectOptJSONObject3, next, i8), jSONObjectOptJSONObject3);
                                    }
                                }
                            } else if (jSONObjectOptJSONObject2.optJSONObject("accounts") != null) {
                                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("accounts");
                                p.b(jSONObjectOptJSONObject4);
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject4.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject(next2);
                                    if (jSONObjectOptJSONObject5 != null) {
                                        p.b(next);
                                        p.b(next2);
                                        addChannelRow(matrixCursor, next, next2, jSONObjectOptJSONObject5);
                                    }
                                }
                            } else {
                                String strOptString = jSONObjectOptJSONObject2.optString("id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                                if (strOptString.length() == 0) {
                                    strOptString = jSONObjectOptJSONObject2.optString("name", next);
                                }
                                boolean zOptBoolean = jSONObjectOptJSONObject2.optBoolean(ExtensionCallContract.ENABLED, true);
                                String str = zOptBoolean ? "configured" : "disabled";
                                p.b(strOptString);
                                matrixCursor.addRow(new Object[]{next + ":" + strOptString, strOptString, str, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, Integer.valueOf(zOptBoolean ? 1 : 0)});
                            }
                        }
                    }
                    return matrixCursor;
                } catch (Exception unused) {
                    return matrixCursor;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int setEnabled(String channelId, boolean enabled) {
        p.e(channelId, "channelId");
        synchronized (this.fsLock) {
            ALog.i$default(TAG, "setEnabled: channelId=" + channelId + " enabled=" + enabled, null, 4, null);
            List listG1 = n.G1(channelId, new String[]{":"}, 2, 2);
            if (listG1.size() != 2) {
                ALog.w$default(TAG, "setEnabled: bad channelId (expected type:account)", null, 4, null);
                return 0;
            }
            String string = n.T1((String) listG1.get(0)).toString();
            if (string.length() == 0) {
                ALog.w$default(TAG, "setEnabled: empty type", null, 4, null);
                return 0;
            }
            String string2 = n.T1((String) listG1.get(1)).toString();
            if (string2.length() == 0) {
                ALog.w$default(TAG, "setEnabled: empty accountKey", null, 4, null);
                return 0;
            }
            String rootfsFile = this.rootfs.readRootfsFile(this.configPath);
            if (rootfsFile == null) {
                ALog.w$default(TAG, "setEnabled: openclaw.json missing or unreadable at " + this.configPath, null, 4, null);
                return 0;
            }
            try {
                JSONObject jSONObject = new JSONObject(rootfsFile);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("channels");
                if (jSONObjectOptJSONObject == null) {
                    ALog.w$default(TAG, "setEnabled: no top-level \"channels\" object", null, 4, null);
                    return 0;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(string);
                if (jSONObjectOptJSONObject2 == null) {
                    ALog.w$default(TAG, "setEnabled: no channel type \"" + string + "\" in config", null, 4, null);
                    return 0;
                }
                if (jSONObjectOptJSONObject2.optJSONArray("accounts") != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("accounts");
                    p.b(jSONArrayOptJSONArray);
                    int length = jSONArrayOptJSONArray.length();
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i8);
                        if (jSONObjectOptJSONObject3 != null && p.a(accountIdFromArrayElement(jSONObjectOptJSONObject3, string, i8), string2)) {
                            jSONObjectOptJSONObject3.put(ExtensionCallContract.ENABLED, enabled);
                            jSONArrayOptJSONArray.put(i8, jSONObjectOptJSONObject3);
                        }
                    }
                    ALog.w$default(TAG, "setEnabled: no accounts[] entry matching accountKey=" + string2 + " (type=" + string + ")", null, 4, null);
                    return 0;
                }
                if (jSONObjectOptJSONObject2.optJSONObject("accounts") != null) {
                    JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("accounts");
                    p.b(jSONObjectOptJSONObject4);
                    if (!jSONObjectOptJSONObject4.has(string2)) {
                        ALog.w$default(TAG, "setEnabled: accounts{" + string + "} has no key \"" + string2 + "\"", null, 4, null);
                        return 0;
                    }
                    JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject(string2);
                    if (jSONObjectOptJSONObject5 == null) {
                        jSONObjectOptJSONObject5 = new JSONObject();
                    }
                    jSONObjectOptJSONObject5.put(ExtensionCallContract.ENABLED, enabled);
                    jSONObjectOptJSONObject4.put(string2, jSONObjectOptJSONObject5);
                } else {
                    String strOptString = jSONObjectOptJSONObject2.optString("id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    if (strOptString.length() == 0) {
                        strOptString = jSONObjectOptJSONObject2.optString("name", string);
                    }
                    if (!string2.equals(strOptString)) {
                        ALog.w$default(TAG, "setEnabled: single-account mismatch accountKey=" + string2 + " currentId=" + strOptString, null, 4, null);
                        return 0;
                    }
                    jSONObjectOptJSONObject2.put(ExtensionCallContract.ENABLED, enabled);
                }
                jSONObjectOptJSONObject.put(string, jSONObjectOptJSONObject2);
                jSONObject.put("channels", jSONObjectOptJSONObject);
                IRootfsAccess iRootfsAccess = this.rootfs;
                String str = this.configPath;
                String string3 = jSONObject.toString(2);
                p.d(string3, "toString(...)");
                iRootfsAccess.writeRootfsFile(str, string3);
                ALog.i$default(TAG, "setEnabled: persisted enabled=" + enabled + " for " + channelId, null, 4, null);
                return 1;
            } catch (Exception e9) {
                ALog.w$default(TAG, "setEnabled: invalid JSON: " + e9.getMessage(), null, 4, null);
                return 0;
            }
        }
    }
}
