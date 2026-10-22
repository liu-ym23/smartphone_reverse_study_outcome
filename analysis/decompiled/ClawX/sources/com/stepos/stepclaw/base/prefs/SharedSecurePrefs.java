package com.stepos.stepclaw.base.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserManager;
import b5.e;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.DeviceNames;
import com.stepos.stepclaw.config.GatewayAuthConstants;
import d6.u;
import d6.w;
import d6.y;
import d6.z;
import d8.m;
import java.security.GeneralSecurityException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import x0.b;
import x0.c;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 W2\u00020\u0001:\u0001WB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\nJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\nJ\u0015\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b \u0010\nJ\u000f\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\u001cJ\u0015\u0010\"\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\nJ\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u001cJ\u0017\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0002H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010,R\u001c\u0010.\u001a\n -*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00100\u001a\n -*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00102R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010<R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0006¢\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010AR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010<R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0=8\u0006¢\u0006\f\n\u0004\bF\u0010?\u001a\u0004\bG\u0010AR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010<R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0006¢\u0006\f\n\u0004\bI\u0010?\u001a\u0004\bJ\u0010AR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010<R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0=8\u0006¢\u0006\f\n\u0004\bL\u0010?\u001a\u0004\bM\u0010AR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010<R\u001d\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000b0=8\u0006¢\u0006\f\n\u0004\bO\u0010?\u001a\u0004\bP\u0010AR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010<R\u001d\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0006¢\u0006\f\n\u0004\bR\u0010?\u001a\u0004\bS\u0010AR\u001a\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00060:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010<R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060=8\u0006¢\u0006\f\n\u0004\bU\u0010?\u001a\u0004\bV\u0010A¨\u0006X"}, d2 = {"Lcom/stepos/stepclaw/base/prefs/SharedSecurePrefs;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "value", "Lb5/a0;", "setDisplayName", "(Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "setManualEnabled", "(Z)V", "setManualHost", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "setManualPort", "(I)V", "setManualTls", "setLastDiscoveredStableId", "stableId", "loadGatewayTlsFingerprint", "(Ljava/lang/String;)Ljava/lang/String;", "fingerprint", "saveGatewayTlsFingerprint", "(Ljava/lang/String;Ljava/lang/String;)V", "setGatewayToken", "loadGatewayToken", "()Ljava/lang/String;", "fallback", "publishGatewayTokenIfEmpty", GatewayAuthConstants.AUTH_MODE, "saveGatewayToken", "loadGatewayPassword", "setGatewayPassword", "Landroid/content/SharedPreferences;", "securePrefs", "()Landroid/content/SharedPreferences;", "loadOrCreateInstanceId", "ctx", "loadOrMigrateDisplayName", "(Landroid/content/Context;)Ljava/lang/String;", "name", "createSecurePrefs", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "deviceContext", "plainPrefs", "Landroid/content/SharedPreferences;", "Lx0/c;", "masterKey$delegate", "Lb5/e;", "getMasterKey", "()Lx0/c;", "masterKey", "_securePrefs", "Ld6/u;", "_instanceId", "Ld6/u;", "Ld6/w;", "instanceId", "Ld6/w;", "getInstanceId", "()Ld6/w;", "_displayName", "displayName", "getDisplayName", "_manualEnabled", "manualEnabled", "getManualEnabled", "_manualHost", "manualHost", "getManualHost", "_manualPort", "manualPort", "getManualPort", "_manualTls", "manualTls", "getManualTls", "_lastDiscoveredStableId", "lastDiscoveredStableId", "getLastDiscoveredStableId", "_gatewayToken", "gatewayToken", "getGatewayToken", "Companion", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SharedSecurePrefs {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_DISPLAY_NAME = "node.displayName";
    private static final String KEY_GATEWAY_MANUAL_TOKEN = "gateway.manual.token";
    private static final String KEY_INSTANCE_ID = "node.instanceId";
    private static final String KEY_LAST_DISCOVERED_STABLE_ID = "gateway.lastDiscoveredStableID";
    private static final String KEY_MANUAL_ENABLED = "gateway.manual.enabled";
    private static final String KEY_MANUAL_HOST = "gateway.manual.host";
    private static final String KEY_MANUAL_PORT = "gateway.manual.port";
    private static final String KEY_MANUAL_TLS = "gateway.manual.tls";
    private static final String PLAIN_PREFS_NAME = "openclaw.node";
    private static final String SECURE_PREFS_NAME = "openclaw.node.secure";
    private static volatile SharedSecurePrefs instance;
    private final u _displayName;
    private final u _gatewayToken;
    private final u _instanceId;
    private final u _lastDiscoveredStableId;
    private final u _manualEnabled;
    private final u _manualHost;
    private final u _manualPort;
    private final u _manualTls;
    private volatile SharedPreferences _securePrefs;
    private final Context appContext;
    private final Context deviceContext;
    private final w displayName;
    private final w gatewayToken;
    private final w instanceId;
    private final w lastDiscoveredStableId;
    private final w manualEnabled;
    private final w manualHost;
    private final w manualPort;
    private final w manualTls;

    /* renamed from: masterKey$delegate, reason: from kotlin metadata */
    private final e masterKey;
    private final SharedPreferences plainPrefs;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stepos/stepclaw/base/prefs/SharedSecurePrefs$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "PLAIN_PREFS_NAME", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "SECURE_PREFS_NAME", "KEY_INSTANCE_ID", "KEY_DISPLAY_NAME", "KEY_MANUAL_ENABLED", "KEY_MANUAL_HOST", "KEY_MANUAL_PORT", "KEY_MANUAL_TLS", "KEY_LAST_DISCOVERED_STABLE_ID", "KEY_GATEWAY_MANUAL_TOKEN", "instance", "Lcom/stepos/stepclaw/base/prefs/SharedSecurePrefs;", "acquire", "context", "Landroid/content/Context;", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final SharedSecurePrefs acquire(Context context) {
            SharedSecurePrefs sharedSecurePrefs;
            p.e(context, "context");
            SharedSecurePrefs sharedSecurePrefs2 = SharedSecurePrefs.instance;
            if (sharedSecurePrefs2 != null) {
                return sharedSecurePrefs2;
            }
            synchronized (this) {
                sharedSecurePrefs = SharedSecurePrefs.instance;
                if (sharedSecurePrefs == null) {
                    Context applicationContext = context.getApplicationContext();
                    p.d(applicationContext, "getApplicationContext(...)");
                    sharedSecurePrefs = new SharedSecurePrefs(applicationContext, null);
                    SharedSecurePrefs.instance = sharedSecurePrefs;
                }
            }
            return sharedSecurePrefs;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SharedSecurePrefs(Context context, i iVar) {
        this(context);
    }

    private final SharedPreferences createSecurePrefs(Context ctx, String name) {
        try {
            return b.a(ctx, name, getMasterKey());
        } catch (GeneralSecurityException unused) {
            ctx.deleteSharedPreferences(name);
            return b.a(ctx, name, this.getMasterKey());
        }
    }

    private final c getMasterKey() {
        return (c) this.masterKey.getValue();
    }

    private final String loadOrCreateInstanceId() {
        String string = this.plainPrefs.getString(KEY_INSTANCE_ID, null);
        String string2 = string != null ? n.T1(string).toString() : null;
        if (string2 != null && !n.t1(string2)) {
            return string2;
        }
        String string3 = UUID.randomUUID().toString();
        p.d(string3, "toString(...)");
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(KEY_INSTANCE_ID, string3);
        editorEdit.apply();
        return string3;
    }

    private final String loadOrMigrateDisplayName(Context ctx) {
        String string = this.plainPrefs.getString(KEY_DISPLAY_NAME, null);
        String string2 = string != null ? n.T1(string).toString() : null;
        if (string2 == null) {
            string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        int length = string2.length();
        String str = SecurePrefs.DEFAULT_DISPLAY_NAME;
        if (length > 0 && !string2.equals(SecurePrefs.DEFAULT_DISPLAY_NAME)) {
            return string2;
        }
        String string3 = n.T1(DeviceNames.INSTANCE.bestDefaultNodeName(ctx)).toString();
        if (string3.length() != 0) {
            str = string3;
        }
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(KEY_DISPLAY_NAME, str);
        editorEdit.apply();
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c masterKey_delegate$lambda$0(SharedSecurePrefs sharedSecurePrefs) {
        m mVar = new m(sharedSecurePrefs.appContext);
        mVar.d();
        return mVar.b();
    }

    private final SharedPreferences securePrefs() {
        SharedPreferences sharedPreferencesCreateSecurePrefs;
        SharedPreferences sharedPreferences = this._securePrefs;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        UserManager userManager = (UserManager) this.appContext.getSystemService(UserManager.class);
        if (userManager == null || !userManager.isUserUnlocked()) {
            return null;
        }
        synchronized (this) {
            sharedPreferencesCreateSecurePrefs = this._securePrefs;
            if (sharedPreferencesCreateSecurePrefs == null) {
                Context appContext = this.appContext;
                p.d(appContext, "appContext");
                sharedPreferencesCreateSecurePrefs = createSecurePrefs(appContext, SECURE_PREFS_NAME);
                this._securePrefs = sharedPreferencesCreateSecurePrefs;
            }
        }
        return sharedPreferencesCreateSecurePrefs;
    }

    public final w getDisplayName() {
        return this.displayName;
    }

    public final w getGatewayToken() {
        return this.gatewayToken;
    }

    public final w getInstanceId() {
        return this.instanceId;
    }

    public final w getLastDiscoveredStableId() {
        return this.lastDiscoveredStableId;
    }

    public final w getManualEnabled() {
        return this.manualEnabled;
    }

    public final w getManualHost() {
        return this.manualHost;
    }

    public final w getManualPort() {
        return this.manualPort;
    }

    public final w getManualTls() {
        return this.manualTls;
    }

    public final String loadGatewayPassword() {
        String string;
        String strM = a8.b.m(((y) this._instanceId).getValue(), "gateway.password.");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        String string2 = (sharedPreferencesSecurePrefs == null || (string = sharedPreferencesSecurePrefs.getString(strM, null)) == null) ? null : n.T1(string).toString();
        if (string2 == null || string2.length() <= 0) {
            return null;
        }
        return string2;
    }

    public final String loadGatewayTlsFingerprint(String stableId) {
        String string;
        p.e(stableId, "stableId");
        String string2 = this.plainPrefs.getString("gateway.tls.".concat(stableId), null);
        if (string2 == null || (string = n.T1(string2).toString()) == null || string.length() <= 0) {
            return null;
        }
        return string;
    }

    public final String loadGatewayToken() {
        String string;
        String string2;
        String string3 = n.T1((String) ((y) this._gatewayToken).getValue()).toString();
        int length = string3.length();
        String str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (length == 0) {
            SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
            string3 = (sharedPreferencesSecurePrefs == null || (string2 = sharedPreferencesSecurePrefs.getString(KEY_GATEWAY_MANUAL_TOKEN, null)) == null) ? null : n.T1(string2).toString();
            if (string3 == null) {
                string3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (string3.length() > 0) {
                y yVar = (y) this._gatewayToken;
                yVar.getClass();
                yVar.c(null, string3);
            }
        }
        if (string3.length() > 0) {
            return string3;
        }
        String strM = a8.b.m(((y) this._instanceId).getValue(), "gateway.token.");
        SharedPreferences sharedPreferencesSecurePrefs2 = securePrefs();
        String string4 = (sharedPreferencesSecurePrefs2 == null || (string = sharedPreferencesSecurePrefs2.getString(strM, null)) == null) ? null : n.T1(string).toString();
        if (string4 != null) {
            str = string4;
        }
        if (str.length() <= 0) {
            return null;
        }
        y yVar2 = (y) this._gatewayToken;
        yVar2.getClass();
        yVar2.c(null, str);
        return str;
    }

    public final void publishGatewayTokenIfEmpty(String fallback) {
        p.e(fallback, "fallback");
        if (((CharSequence) ((y) this._gatewayToken).getValue()).length() != 0 || fallback.length() <= 0) {
            return;
        }
        y yVar = (y) this._gatewayToken;
        yVar.getClass();
        yVar.c(null, fallback);
    }

    public final void saveGatewayTlsFingerprint(String stableId, String fingerprint) {
        p.e(stableId, "stableId");
        p.e(fingerprint, "fingerprint");
        String strConcat = "gateway.tls.".concat(stableId);
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(strConcat, n.T1(fingerprint).toString());
        editorEdit.apply();
    }

    public final void saveGatewayToken(String token) {
        p.e(token, "token");
        String strM = a8.b.m(((y) this._instanceId).getValue(), "gateway.token.");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesSecurePrefs.edit();
            editorEdit.putString(strM, n.T1(token).toString());
            editorEdit.apply();
        }
    }

    public final void setDisplayName(String value) {
        p.e(value, "value");
        String string = n.T1(value).toString();
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(KEY_DISPLAY_NAME, string);
        editorEdit.apply();
        ((y) this._displayName).b(string);
    }

    public final void setGatewayPassword(String value) {
        p.e(value, "value");
        String strM = a8.b.m(((y) this._instanceId).getValue(), "gateway.password.");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesSecurePrefs.edit();
            editorEdit.putString(strM, n.T1(value).toString());
            editorEdit.apply();
        }
    }

    public final void setGatewayToken(String value) {
        p.e(value, "value");
        String string = n.T1(value).toString();
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesSecurePrefs.edit();
            editorEdit.putString(KEY_GATEWAY_MANUAL_TOKEN, string);
            editorEdit.apply();
        }
        ((y) this._gatewayToken).b(string);
    }

    public final void setLastDiscoveredStableId(String value) {
        p.e(value, "value");
        String string = n.T1(value).toString();
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(KEY_LAST_DISCOVERED_STABLE_ID, string);
        editorEdit.apply();
        ((y) this._lastDiscoveredStableId).b(string);
    }

    public final void setManualEnabled(boolean value) {
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putBoolean(KEY_MANUAL_ENABLED, value);
        editorEdit.apply();
        u uVar = this._manualEnabled;
        Boolean boolValueOf = Boolean.valueOf(value);
        y yVar = (y) uVar;
        yVar.getClass();
        yVar.c(null, boolValueOf);
    }

    public final void setManualHost(String value) {
        p.e(value, "value");
        String string = n.T1(value).toString();
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(KEY_MANUAL_HOST, string);
        editorEdit.apply();
        ((y) this._manualHost).b(string);
    }

    public final void setManualPort(int value) {
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putInt(KEY_MANUAL_PORT, value);
        editorEdit.apply();
        u uVar = this._manualPort;
        Integer numValueOf = Integer.valueOf(value);
        y yVar = (y) uVar;
        yVar.getClass();
        yVar.c(null, numValueOf);
    }

    public final void setManualTls(boolean value) {
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putBoolean(KEY_MANUAL_TLS, value);
        editorEdit.apply();
        u uVar = this._manualTls;
        Boolean boolValueOf = Boolean.valueOf(value);
        y yVar = (y) uVar;
        yVar.getClass();
        yVar.c(null, boolValueOf);
    }

    private SharedSecurePrefs(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        Context contextCreateDeviceProtectedStorageContext = applicationContext.createDeviceProtectedStorageContext();
        this.deviceContext = contextCreateDeviceProtectedStorageContext;
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences(PLAIN_PREFS_NAME, 0);
        p.d(sharedPreferences, "getSharedPreferences(...)");
        this.plainPrefs = sharedPreferences;
        this.masterKey = h.x(new b7.c(17, this));
        y yVarA = z.a(loadOrCreateInstanceId());
        this._instanceId = yVarA;
        this.instanceId = yVarA;
        y yVarA2 = z.a(loadOrMigrateDisplayName(context));
        this._displayName = yVarA2;
        this.displayName = yVarA2;
        y yVarA3 = z.a(Boolean.valueOf(sharedPreferences.getBoolean(KEY_MANUAL_ENABLED, true)));
        this._manualEnabled = yVarA3;
        this.manualEnabled = yVarA3;
        String string = sharedPreferences.getString(KEY_MANUAL_HOST, "127.0.0.1");
        y yVarA4 = z.a(string != null ? string : "127.0.0.1");
        this._manualHost = yVarA4;
        this.manualHost = yVarA4;
        y yVarA5 = z.a(Integer.valueOf(sharedPreferences.getInt(KEY_MANUAL_PORT, 18789)));
        this._manualPort = yVarA5;
        this.manualPort = yVarA5;
        y yVarA6 = z.a(Boolean.valueOf(sharedPreferences.getBoolean(KEY_MANUAL_TLS, false)));
        this._manualTls = yVarA6;
        this.manualTls = yVarA6;
        String string2 = sharedPreferences.getString(KEY_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        y yVarA7 = z.a(string2 == null ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : string2);
        this._lastDiscoveredStableId = yVarA7;
        this.lastDiscoveredStableId = yVarA7;
        y yVarA8 = z.a(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        this._gatewayToken = yVarA8;
        this.gatewayToken = yVarA8;
    }
}
