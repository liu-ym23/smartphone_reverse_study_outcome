package com.stepos.stepclaw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserManager;
import b5.e;
import b8.h;
import com.stepos.stepclaw.config.DeviceGatewayTokenStore;
import d6.v;
import d6.w;
import d6.z;
import d8.m;
import java.security.GeneralSecurityException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0012J\u001d\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u0016J\u0015\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\n \u001d*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\n \u001d*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\"R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b0\u0010.R\u001d\u00102\u001a\b\u0012\u0004\u0012\u0002010*8\u0006¢\u0006\f\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006¢\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.R\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002060*8\u0006¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b8\u0010.R\u001d\u00109\u001a\b\u0012\u0004\u0012\u0002010*8\u0006¢\u0006\f\n\u0004\b9\u0010,\u001a\u0004\b:\u0010.R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\t0*8\u0006¢\u0006\f\n\u0004\b;\u0010,\u001a\u0004\b<\u0010.¨\u0006>"}, d2 = {"Lcom/stepos/stepclaw/SecurePrefs;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/content/SharedPreferences;", "securePrefs", "()Landroid/content/SharedPreferences;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "name", "createSecurePrefs", "(Landroid/content/Context;Ljava/lang/String;)Landroid/content/SharedPreferences;", "loadGatewayToken", "()Ljava/lang/String;", "loadGatewayPassword", "stableId", "loadGatewayTlsFingerprint", "(Ljava/lang/String;)Ljava/lang/String;", "fingerprint", "Lb5/a0;", "saveGatewayTlsFingerprint", "(Ljava/lang/String;Ljava/lang/String;)V", "key", "getString", "value", "putString", "remove", "(Ljava/lang/String;)V", "kotlin.jvm.PlatformType", "appContext", "Landroid/content/Context;", "deviceContext", "plainPrefs", "Landroid/content/SharedPreferences;", "Lx0/c;", "masterKey$delegate", "Lb5/e;", "getMasterKey", "()Lx0/c;", "masterKey", "_securePrefs", "Ld6/w;", "instanceId", "Ld6/w;", "getInstanceId", "()Ld6/w;", "displayName", "getDisplayName", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "manualEnabled", "getManualEnabled", "manualHost", "getManualHost", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "manualPort", "getManualPort", "manualTls", "getManualTls", "lastDiscoveredStableId", "getLastDiscoveredStableId", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SecurePrefs {
    public static final String DEFAULT_DISPLAY_NAME = "Android Node";
    public static final String DEFAULT_INSTANCE_ID = "stepclaw-default";
    public static final String DEFAULT_LAST_DISCOVERED_STABLE_ID = "";
    public static final boolean DEFAULT_MANUAL_ENABLED = true;
    public static final String DEFAULT_MANUAL_HOST = "127.0.0.1";
    public static final int DEFAULT_MANUAL_PORT = 18789;
    public static final boolean DEFAULT_MANUAL_TLS = false;
    private static final String plainPrefsName = "openclaw.node";
    private static final String securePrefsName = "openclaw.node.secure";
    private volatile SharedPreferences _securePrefs;
    private final Context appContext;
    private final Context deviceContext;
    private final w displayName;
    private final w instanceId;
    private final w lastDiscoveredStableId;
    private final w manualEnabled;
    private final w manualHost;
    private final w manualPort;
    private final w manualTls;

    /* renamed from: masterKey$delegate, reason: from kotlin metadata */
    private final e masterKey;
    private final SharedPreferences plainPrefs;

    public SecurePrefs(Context context) {
        p.e(context, "context");
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        Context contextCreateDeviceProtectedStorageContext = applicationContext.createDeviceProtectedStorageContext();
        this.deviceContext = contextCreateDeviceProtectedStorageContext;
        SharedPreferences sharedPreferences = contextCreateDeviceProtectedStorageContext.getSharedPreferences(plainPrefsName, 0);
        p.d(sharedPreferences, "getSharedPreferences(...)");
        this.plainPrefs = sharedPreferences;
        this.masterKey = h.x(new b7.c(6, this));
        this.instanceId = new v(z.a(DEFAULT_INSTANCE_ID));
        this.displayName = new v(z.a(DEFAULT_DISPLAY_NAME));
        this.manualEnabled = new v(z.a(Boolean.TRUE));
        this.manualHost = new v(z.a("127.0.0.1"));
        this.manualPort = new v(z.a(18789));
        this.manualTls = new v(z.a(Boolean.FALSE));
        this.lastDiscoveredStableId = new v(z.a(DEFAULT_LAST_DISCOVERED_STABLE_ID));
    }

    private final SharedPreferences createSecurePrefs(Context context, String name) {
        try {
            return x0.b.a(context, name, getMasterKey());
        } catch (GeneralSecurityException unused) {
            context.deleteSharedPreferences(name);
            return x0.b.a(context, name, this.getMasterKey());
        }
    }

    private final x0.c getMasterKey() {
        return (x0.c) this.masterKey.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x0.c masterKey_delegate$lambda$0(SecurePrefs securePrefs) {
        m mVar = new m(securePrefs.appContext);
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
                sharedPreferencesCreateSecurePrefs = createSecurePrefs(appContext, securePrefsName);
                this._securePrefs = sharedPreferencesCreateSecurePrefs;
            }
        }
        return sharedPreferencesCreateSecurePrefs;
    }

    public final w getDisplayName() {
        return this.displayName;
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

    public final String getString(String key) {
        p.e(key, "key");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            return sharedPreferencesSecurePrefs.getString(key, null);
        }
        return null;
    }

    public final String loadGatewayPassword() {
        return null;
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
        DeviceGatewayTokenStore deviceGatewayTokenStore = DeviceGatewayTokenStore.INSTANCE;
        Context appContext = this.appContext;
        p.d(appContext, "appContext");
        return deviceGatewayTokenStore.getOrCreate(appContext);
    }

    public final void putString(String key, String value) {
        p.e(key, "key");
        p.e(value, "value");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesSecurePrefs.edit();
            editorEdit.putString(key, value);
            editorEdit.apply();
        }
    }

    public final void remove(String key) {
        p.e(key, "key");
        SharedPreferences sharedPreferencesSecurePrefs = securePrefs();
        if (sharedPreferencesSecurePrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPreferencesSecurePrefs.edit();
            editorEdit.remove(key);
            editorEdit.apply();
        }
    }

    public final void saveGatewayTlsFingerprint(String stableId, String fingerprint) {
        p.e(stableId, "stableId");
        p.e(fingerprint, "fingerprint");
        String strConcat = "gateway.tls.".concat(stableId);
        SharedPreferences.Editor editorEdit = this.plainPrefs.edit();
        editorEdit.putString(strConcat, n.T1(fingerprint).toString());
        editorEdit.apply();
    }
}
