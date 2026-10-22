package com.stepos.stepclaw.config;

import a6.f0;
import a6.i0;
import a6.r0;
import android.content.Context;
import android.util.Log;
import b5.a0;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.chroot.RootfsFileHelper;
import com.stepos.stepclaw.provider.contract.ExtensionCallContract;
import com.stepos.stepclaw.runtime.OpenClawRuntimeConfig;
import d6.b;
import d6.u;
import d6.v;
import d6.y;
import f5.c;
import g5.a;
import h5.e;
import h5.i;
import h6.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import k4.z;
import kotlin.Metadata;
import m5.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p5.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 F2\u00020\u0001:\u0001FB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bH\u0086@¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0015\u0010\nJ\r\u0010\u0016\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0014J\r\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0014J\r\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0014J\r\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u0014J\r\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u0014J\r\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0014J\u0010\u0010\u001c\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u001c\u0010\nJ\r\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u0014J\u0010\u0010\u001e\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u001e\u0010\nJ\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0086@¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010#J+\u0010)\u001a\u00020\u00122\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u000fH\u0002¢\u0006\u0004\b+\u0010\u0011J\u0011\u0010,\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b,\u0010-J\u0018\u0010/\u001a\u00020&2\u0006\u0010.\u001a\u00020&H\u0082@¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u00010&2\u0006\u0010.\u001a\u00020&H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\b2\u0006\u00101\u001a\u00020&H\u0002¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020&2\u0006\u00108\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b9\u0010:J\u001f\u0010;\u001a\u00020&2\u0006\u00108\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u0010:R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010<R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\b0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\b0A8\u0006¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E¨\u0006G"}, d2 = {"Lcom/stepos/stepclaw/config/JsonConfigStore;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Landroid/content/Context;", "context", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "runtimeConfig", "<init>", "(Landroid/content/Context;Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;)V", "Lcom/stepos/stepclaw/config/OpenClawConfig;", ConfigIpcContract.METHOD_READ_CONFIG, "(Lf5/c;)Ljava/lang/Object;", "config", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "save", "(Lcom/stepos/stepclaw/config/OpenClawConfig;Lf5/c;)Ljava/lang/Object;", "Lb5/a0;", "backupKnownGood", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "restoreGatewayFields", "()Z", "restoreFromBackup", "ensureGatewayAuthTokenMode", "ensureGatewayPort", "ensureGatewayBind", "ensureGatewayModeLocal", "ensureGatewayTlsDisabled", "ensureGatewayExperimental", "restoreWorkspaceFiles", "hasApiKeySync", "hasApiKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/config/ModelPreset;", ConfigIpcContract.METHOD_READ_MODEL_PRESETS, "readOpenClawConfigResolved", "()Lcom/stepos/stepclaw/config/OpenClawConfig;", "Lcom/stepos/stepclaw/chroot/RootfsFileHelper;", "bootstrap", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "configPath", "assetPath", "restoreFileWithFallback", "(Lcom/stepos/stepclaw/chroot/RootfsFileHelper;Ljava/lang/String;Ljava/lang/String;)Z", "restoreCredentialsFromBackupDir", "loadAuthProfilesJson", "()Ljava/lang/String;", ConfigIpcContract.KEY_PROVIDER, "readApiKey", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "json", "readApiKeyFromJson", "(Ljava/lang/String;)Ljava/lang/String;", "readApiKeyForProvider", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "parseOpenClawJson", "(Ljava/lang/String;)Lcom/stepos/stepclaw/config/OpenClawConfig;", "existingJson", "updateOpenClawJson", "(Ljava/lang/String;Lcom/stepos/stepclaw/config/OpenClawConfig;)Ljava/lang/String;", "updateAuthProfilesJson", "Landroid/content/Context;", "Lcom/stepos/stepclaw/runtime/OpenClawRuntimeConfig;", "Ld6/u;", "_configFlow", "Ld6/u;", "Ld6/b;", "configFlow", "Ld6/b;", "getConfigFlow", "()Ld6/b;", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonConfigStore {
    private static final String AUTH_PROFILES_JSON = "root/.openclaw/agents/main/agent/auth-profiles.json";
    private static final String CREDENTIALS_BACKUP_DIR = "root/.openclaw/credentials.backup";
    private static final String CREDENTIALS_DIR = "root/.openclaw/credentials";
    private static final String CRON_JOBS_JSON = "root/.openclaw/cron/jobs.json";
    private static final String DOTENV = "root/.openclaw/.env";
    private static final String MODELS_JSON = "root/.openclaw/agents/main/agent/models.json";
    private static final String OPENCLAW_JSON = "root/.openclaw/openclaw.json";
    private static final String TAG = "JsonConfigStore";
    private final u _configFlow;
    private final b configFlow;
    private final Context context;
    private final OpenClawRuntimeConfig runtimeConfig;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$hasApiKey$2", f = "JsonConfigStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$hasApiKey$2, reason: invalid class name */
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new AnonymousClass2(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass2) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            return Boolean.valueOf(JsonConfigStore.this.hasApiKeySync());
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Ljava/lang/String;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$readApiKey$2", f = "JsonConfigStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$readApiKey$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00112 extends i implements p {
        final /* synthetic */ String $provider;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00112(String str, c cVar) {
            super(2, cVar);
            this.$provider = str;
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00112(this.$provider, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00112) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            String strLoadAuthProfilesJson = JsonConfigStore.this.loadAuthProfilesJson();
            if (strLoadAuthProfilesJson == null) {
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (!n.t1(this.$provider)) {
                String apiKeyForProvider = JsonConfigStore.this.readApiKeyForProvider(strLoadAuthProfilesJson, this.$provider);
                if (!n.t1(apiKeyForProvider)) {
                    return apiKeyForProvider;
                }
            }
            return JsonConfigStore.this.readApiKeyFromJson(strLoadAuthProfilesJson);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lcom/stepos/stepclaw/config/OpenClawConfig;", "<anonymous>", "(La6/f0;)Lcom/stepos/stepclaw/config/OpenClawConfig;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$readConfig$2", f = "JsonConfigStore.kt", l = {59}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$readConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00122 extends i implements p {
        Object L$0;
        Object L$1;
        int label;

        public C00122(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00122(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00122) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            OpenClawConfig openClawConfig;
            a aVar = a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                OpenClawConfig openClawConfigResolved = JsonConfigStore.this.readOpenClawConfigResolved();
                String provider = openClawConfigResolved.getProvider();
                if (n.t1(provider)) {
                    provider = new OpenClawConfig(null, null, null, null, 0, null, null, 127, null).getProvider();
                }
                JsonConfigStore jsonConfigStore = JsonConfigStore.this;
                this.L$0 = openClawConfigResolved;
                this.L$1 = null;
                this.label = 1;
                Object apiKey = jsonConfigStore.readApiKey(provider, this);
                if (apiKey == aVar) {
                    return aVar;
                }
                openClawConfig = openClawConfigResolved;
                obj = apiKey;
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                openClawConfig = (OpenClawConfig) this.L$0;
                a.a.c0(obj);
            }
            OpenClawConfig openClawConfigCopy$default = OpenClawConfig.copy$default(openClawConfig, (String) obj, null, null, null, 0, null, null, 126, null);
            ((y) JsonConfigStore.this._configFlow).b(openClawConfigCopy$default);
            return openClawConfigCopy$default;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/config/ModelPreset;", "<anonymous>", "(La6/f0;)Ljava/util/List;"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$readModelPresets$2", f = "JsonConfigStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$readModelPresets$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00132 extends i implements p {
        int label;

        public C00132(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00132(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00132) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            BufferedReader bufferedReader;
            String strE0;
            String strE02;
            JSONObject jSONObjectOptJSONObject;
            String strOptString;
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            File fileResolveRootfsPath = JsonConfigStore.this.runtimeConfig.resolveRootfsPath(JsonConfigStore.OPENCLAW_JSON);
            File fileResolveRootfsPath2 = JsonConfigStore.this.runtimeConfig.resolveRootfsPath(JsonConfigStore.AUTH_PROFILES_JSON);
            boolean zExists = fileResolveRootfsPath.exists();
            s sVar = s.f1092a;
            if (zExists) {
                strE0 = l.E0(fileResolveRootfsPath, x5.a.f6276a);
            } else {
                try {
                    InputStream inputStreamOpen = JsonConfigStore.this.context.getAssets().open("openclaw/openclaw.json");
                    kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                    try {
                        String strC = z.C(bufferedReader);
                        bufferedReader.close();
                        strE0 = strC;
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } catch (Exception unused) {
                    Log.w(JsonConfigStore.TAG, "openclaw.json not available in assets for presets");
                    return sVar;
                }
            }
            if (fileResolveRootfsPath2.exists()) {
                strE02 = l.E0(fileResolveRootfsPath2, x5.a.f6276a);
            } else {
                try {
                    InputStream inputStreamOpen2 = JsonConfigStore.this.context.getAssets().open("openclaw/auth-profiles.json");
                    kotlin.jvm.internal.p.d(inputStreamOpen2, "open(...)");
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen2, x5.a.f6276a), 8192);
                    try {
                        String strC2 = z.C(bufferedReader);
                        bufferedReader.close();
                        strE02 = strC2;
                    } finally {
                    }
                } catch (Exception unused2) {
                    strE02 = null;
                }
            }
            try {
                JSONObject jSONObjectOptJSONObject2 = new JSONObject(strE0).optJSONObject("models");
                if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("providers")) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    kotlin.jvm.internal.p.d(itKeys, "keys(...)");
                    JsonConfigStore jsonConfigStore = JsonConfigStore.this;
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(next);
                        if (jSONObjectOptJSONObject3 != null) {
                            String strOptString2 = jSONObjectOptJSONObject3.optString(ConfigIpcContract.KEY_BASE_URL, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                            kotlin.jvm.internal.p.b(next);
                            String apiKeyForProvider = jsonConfigStore.readApiKeyForProvider(strE02, next);
                            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("models");
                            if (jSONArrayOptJSONArray != null) {
                                int length = jSONArrayOptJSONArray.length();
                                for (int i8 = 0; i8 < length; i8++) {
                                    JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i8);
                                    if (jSONObjectOptJSONObject4 != null && (strOptString = jSONObjectOptJSONObject4.optString("id")) != null && !n.t1(strOptString)) {
                                        kotlin.jvm.internal.p.b(strOptString2);
                                        arrayList.add(new ModelPreset(strOptString, next, strOptString2, apiKeyForProvider));
                                    }
                                }
                            }
                        }
                    }
                    Log.d(JsonConfigStore.TAG, "Loaded " + arrayList.size() + " model presets");
                    return arrayList;
                }
            } catch (Exception unused3) {
            }
            return sVar;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$restoreFromBackup$2", f = "JsonConfigStore.kt", l = {317, 319}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$restoreFromBackup$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00142 extends i implements p {
        Object L$0;
        boolean Z$0;
        int label;

        public C00142(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00142(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00142) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            boolean zRestoreFileWithFallback;
            boolean z;
            a aVar = a.f2984a;
            int i8 = this.label;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    RootfsFileHelper rootfsFileHelperForMountedRootfs = RootfsFileHelper.INSTANCE.forMountedRootfs(JsonConfigStore.this.runtimeConfig);
                    zRestoreFileWithFallback = JsonConfigStore.this.restoreFileWithFallback(rootfsFileHelperForMountedRootfs, JsonConfigStore.OPENCLAW_JSON, "openclaw/openclaw.json");
                    JsonConfigStore.this.restoreFileWithFallback(rootfsFileHelperForMountedRootfs, JsonConfigStore.AUTH_PROFILES_JSON, "openclaw/auth-profiles.json");
                    JsonConfigStore.restoreFileWithFallback$default(JsonConfigStore.this, rootfsFileHelperForMountedRootfs, JsonConfigStore.MODELS_JSON, null, 4, null);
                    JsonConfigStore.restoreFileWithFallback$default(JsonConfigStore.this, rootfsFileHelperForMountedRootfs, JsonConfigStore.DOTENV, null, 4, null);
                    JsonConfigStore.restoreFileWithFallback$default(JsonConfigStore.this, rootfsFileHelperForMountedRootfs, JsonConfigStore.CRON_JOBS_JSON, null, 4, null);
                    JsonConfigStore.this.restoreCredentialsFromBackupDir();
                    JsonConfigStore jsonConfigStore = JsonConfigStore.this;
                    this.L$0 = null;
                    this.Z$0 = zRestoreFileWithFallback;
                    this.label = 1;
                    if (jsonConfigStore.restoreWorkspaceFiles(this) == aVar) {
                    }
                    return aVar;
                }
                if (i8 != 1) {
                    if (i8 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    z = this.Z$0;
                    a.a.c0(obj);
                    zRestoreFileWithFallback = z;
                    JsonConfigStore.this.ensureGatewayAuthTokenMode();
                    JsonConfigStore.this.ensureGatewayPort();
                    JsonConfigStore.this.ensureGatewayBind();
                    return Boolean.valueOf(zRestoreFileWithFallback);
                }
                boolean z2 = this.Z$0;
                a.a.c0(obj);
                zRestoreFileWithFallback = z2;
                if (zRestoreFileWithFallback) {
                    JsonConfigStore jsonConfigStore2 = JsonConfigStore.this;
                    this.L$0 = null;
                    this.Z$0 = zRestoreFileWithFallback;
                    this.label = 2;
                    if (jsonConfigStore2.readConfig(this) != aVar) {
                        z = zRestoreFileWithFallback;
                        zRestoreFileWithFallback = z;
                    }
                    return aVar;
                }
                JsonConfigStore.this.ensureGatewayAuthTokenMode();
                JsonConfigStore.this.ensureGatewayPort();
                JsonConfigStore.this.ensureGatewayBind();
                return Boolean.valueOf(zRestoreFileWithFallback);
            } catch (Exception e9) {
                Log.e(JsonConfigStore.TAG, "Failed to restore from backup", e9);
                return Boolean.FALSE;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$restoreWorkspaceFiles$2", f = "JsonConfigStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$restoreWorkspaceFiles$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00152 extends i implements p {
        int label;

        public C00152(c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00152(cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00152) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00ae  */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.io.IOException {
            /*
                r10 = this;
                java.lang.String r0 = "JsonConfigStore"
                g5.a r1 = g5.a.f2984a
                int r1 = r10.label
                if (r1 != 0) goto Lb4
                a.a.c0(r11)
                com.stepos.stepclaw.chroot.RootfsFileHelper$Companion r11 = com.stepos.stepclaw.chroot.RootfsFileHelper.INSTANCE
                com.stepos.stepclaw.config.JsonConfigStore r1 = com.stepos.stepclaw.config.JsonConfigStore.this
                com.stepos.stepclaw.runtime.OpenClawRuntimeConfig r1 = com.stepos.stepclaw.config.JsonConfigStore.access$getRuntimeConfig$p(r1)
                com.stepos.stepclaw.chroot.RootfsFileHelper r11 = r11.forMountedRootfs(r1)
                r1 = 0
                com.stepos.stepclaw.config.JsonConfigStore r2 = com.stepos.stepclaw.config.JsonConfigStore.this     // Catch: java.lang.Exception -> L2d
                android.content.Context r2 = com.stepos.stepclaw.config.JsonConfigStore.access$getContext$p(r2)     // Catch: java.lang.Exception -> L2d
                android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Exception -> L2d
                java.lang.String r3 = "openclaw/workspace"
                java.lang.String[] r2 = r2.list(r3)     // Catch: java.lang.Exception -> L2d
                if (r2 != 0) goto L31
                java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Exception -> L2d
                goto L31
            L2d:
                r10 = move-exception
                r5 = r1
                goto La7
            L31:
                int r3 = r2.length     // Catch: java.lang.Exception -> L2d
                r4 = r1
                r5 = r4
            L34:
                if (r4 >= r3) goto Lac
                r6 = r2[r4]     // Catch: java.lang.Exception -> L9e
                com.stepos.stepclaw.config.JsonConfigStore r7 = com.stepos.stepclaw.config.JsonConfigStore.this     // Catch: java.lang.Exception -> L9e
                android.content.Context r7 = com.stepos.stepclaw.config.JsonConfigStore.access$getContext$p(r7)     // Catch: java.lang.Exception -> L9e
                android.content.res.AssetManager r7 = r7.getAssets()     // Catch: java.lang.Exception -> L9e
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
                r8.<init>()     // Catch: java.lang.Exception -> L9e
                java.lang.String r9 = "openclaw/workspace/"
                r8.append(r9)     // Catch: java.lang.Exception -> L9e
                r8.append(r6)     // Catch: java.lang.Exception -> L9e
                java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L9e
                java.io.InputStream r7 = r7.open(r8)     // Catch: java.lang.Exception -> L9e
                java.lang.String r8 = "open(...)"
                kotlin.jvm.internal.p.d(r7, r8)     // Catch: java.lang.Exception -> L9e
                java.nio.charset.Charset r8 = x5.a.f6276a     // Catch: java.lang.Exception -> L9e
                java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L9e
                r9.<init>(r7, r8)     // Catch: java.lang.Exception -> L9e
                java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L9e
                r8 = 8192(0x2000, float:1.148E-41)
                r7.<init>(r9, r8)     // Catch: java.lang.Exception -> L9e
                java.lang.String r8 = k4.z.C(r7)     // Catch: java.lang.Throwable -> La0
                r7.close()     // Catch: java.lang.Exception -> L9e
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
                r7.<init>()     // Catch: java.lang.Exception -> L9e
                java.lang.String r9 = "root/.openclaw/workspace/"
                r7.append(r9)     // Catch: java.lang.Exception -> L9e
                r7.append(r6)     // Catch: java.lang.Exception -> L9e
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L9e
                r11.writeRootfsFile(r7, r8)     // Catch: java.lang.Exception -> L9e
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9e
                r7.<init>()     // Catch: java.lang.Exception -> L9e
                java.lang.String r8 = "Restored workspace file: "
                r7.append(r8)     // Catch: java.lang.Exception -> L9e
                r7.append(r6)     // Catch: java.lang.Exception -> L9e
                java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L9e
                android.util.Log.i(r0, r6)     // Catch: java.lang.Exception -> L9e
                int r5 = r5 + 1
                int r4 = r4 + 1
                goto L34
            L9e:
                r10 = move-exception
                goto La7
            La0:
                r10 = move-exception
                throw r10     // Catch: java.lang.Throwable -> La2
            La2:
                r11 = move-exception
                k4.z.h(r7, r10)     // Catch: java.lang.Exception -> L9e
                throw r11     // Catch: java.lang.Exception -> L9e
            La7:
                java.lang.String r11 = "Failed to restore workspace files"
                android.util.Log.w(r0, r11, r10)
            Lac:
                if (r5 <= 0) goto Laf
                r1 = 1
            Laf:
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
                return r10
            Lb4:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.JsonConfigStore.C00152.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)I"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.config.JsonConfigStore$save$2", f = "JsonConfigStore.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.config.JsonConfigStore$save$2, reason: invalid class name and case insensitive filesystem */
    public static final class C00162 extends i implements p {
        final /* synthetic */ OpenClawConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00162(OpenClawConfig openClawConfig, c cVar) {
            super(2, cVar);
            this.$config = openClawConfig;
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return JsonConfigStore.this.new C00162(this.$config, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((C00162) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws Exception {
            String strE0;
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            try {
                RootfsFileHelper rootfsFileHelperForMountedRootfs = RootfsFileHelper.INSTANCE.forMountedRootfs(JsonConfigStore.this.runtimeConfig);
                File fileResolveRootfsPath = JsonConfigStore.this.runtimeConfig.resolveRootfsPath(JsonConfigStore.OPENCLAW_JSON);
                String str = "{}";
                if (fileResolveRootfsPath.exists()) {
                    strE0 = l.E0(fileResolveRootfsPath, x5.a.f6276a);
                    try {
                        new JSONObject(strE0);
                    } catch (Exception unused) {
                        Log.w(JsonConfigStore.TAG, "openclaw.json is corrupted, resetting to defaults before save");
                    }
                } else {
                    strE0 = "{}";
                }
                if (n.t1(this.$config.getApiKey()) && !n.t1(this.$config.getProvider())) {
                    if (n.t1(JsonConfigStore.this.readApiKeyForProvider(JsonConfigStore.this.loadAuthProfilesJson(), this.$config.getProvider()))) {
                        throw new IllegalArgumentException("Cannot set " + this.$config.getProvider() + "/" + this.$config.getModel() + " as default: no API key configured for provider '" + this.$config.getProvider() + "'. Please provide an API key.");
                    }
                }
                rootfsFileHelperForMountedRootfs.writeRootfsFile(JsonConfigStore.OPENCLAW_JSON, JsonConfigStore.this.updateOpenClawJson(strE0, this.$config));
                if (!n.t1(this.$config.getApiKey())) {
                    File fileResolveRootfsPath2 = JsonConfigStore.this.runtimeConfig.resolveRootfsPath(JsonConfigStore.AUTH_PROFILES_JSON);
                    if (fileResolveRootfsPath2.exists()) {
                        String strE02 = l.E0(fileResolveRootfsPath2, x5.a.f6276a);
                        try {
                            new JSONObject(strE02);
                            str = strE02;
                        } catch (Exception unused2) {
                            Log.w(JsonConfigStore.TAG, "auth-profiles.json is corrupted, resetting before save");
                        }
                    }
                    String strUpdateAuthProfilesJson = JsonConfigStore.this.updateAuthProfilesJson(str, this.$config);
                    File parentFile = fileResolveRootfsPath2.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    rootfsFileHelperForMountedRootfs.writeRootfsFile(JsonConfigStore.AUTH_PROFILES_JSON, strUpdateAuthProfilesJson);
                }
                ((y) JsonConfigStore.this._configFlow).b(this.$config);
                return new Integer(Log.i(JsonConfigStore.TAG, "Config saved to JSON files (model=" + this.$config.getModel() + ", provider=" + this.$config.getProvider() + ")"));
            } catch (Exception e9) {
                Log.e(JsonConfigStore.TAG, "Failed to save config", e9);
                throw e9;
            }
        }
    }

    public JsonConfigStore(Context context, OpenClawRuntimeConfig runtimeConfig) {
        kotlin.jvm.internal.p.e(context, "context");
        kotlin.jvm.internal.p.e(runtimeConfig, "runtimeConfig");
        this.context = context;
        this.runtimeConfig = runtimeConfig;
        y yVarA = d6.z.a(new OpenClawConfig(null, null, null, null, 0, null, null, 127, null));
        this._configFlow = yVarA;
        this.configFlow = new v(yVarA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String loadAuthProfilesJson() throws IOException {
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(AUTH_PROFILES_JSON);
        if (fileResolveRootfsPath.exists()) {
            return l.E0(fileResolveRootfsPath, x5.a.f6276a);
        }
        try {
            InputStream inputStreamOpen = this.context.getAssets().open("openclaw/auth-profiles.json");
            kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
            try {
                String strC = z.C(bufferedReader);
                bufferedReader.close();
                return strC;
            } finally {
            }
        } catch (Exception e9) {
            Log.d(TAG, "No auth-profiles.json in APK assets or rootfs", e9);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00d2, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.stepos.stepclaw.config.OpenClawConfig parseOpenClawJson(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.config.JsonConfigStore.parseOpenClawJson(java.lang.String):com.stepos.stepclaw.config.OpenClawConfig");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object readApiKey(String str, c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00112(str, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readApiKeyForProvider(String json, String provider) {
        if (json != null && !n.t1(json)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(json).optJSONObject("profiles");
                if (jSONObjectOptJSONObject == null) {
                    return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(provider + ":default");
                if (jSONObjectOptJSONObject2 != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    if (strOptString != null) {
                        return strOptString;
                    }
                }
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            } catch (Exception e9) {
                Log.e(TAG, "Failed to read API key for provider " + provider, e9);
            }
        }
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String readApiKeyFromJson(String json) {
        if (json != null && !n.t1(json)) {
            try {
                JSONObject jSONObjectOptJSONObject = new JSONObject(json).optJSONObject("profiles");
                if (jSONObjectOptJSONObject == null) {
                    return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                }
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(itKeys.next());
                    if (kotlin.jvm.internal.p.a(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("type") : null, "api_key")) {
                        String strOptString = jSONObjectOptJSONObject2.optString("key", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                        kotlin.jvm.internal.p.d(strOptString, "optString(...)");
                        return strOptString;
                    }
                }
                return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            } catch (Exception e9) {
                Log.e(TAG, "Failed to parse API key from JSON", e9);
            }
        }
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OpenClawConfig readOpenClawConfigResolved() throws IOException {
        OpenClawConfig openClawConfig;
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
        try {
            if (fileResolveRootfsPath.exists()) {
                return parseOpenClawJson(l.E0(fileResolveRootfsPath, x5.a.f6276a));
            }
            Log.w(TAG, "openclaw.json not found in rootfs, trying assets");
            try {
                InputStream inputStreamOpen = this.context.getAssets().open("openclaw/openclaw.json");
                kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
                try {
                    String strC = z.C(bufferedReader);
                    bufferedReader.close();
                    return parseOpenClawJson(strC);
                } finally {
                }
            } catch (Exception e9) {
                Log.w(TAG, "no bundled openclaw.json, using Kotlin defaults", e9);
                openClawConfig = new OpenClawConfig(null, null, null, null, 0, null, null, 127, null);
                return openClawConfig;
            }
        } catch (Exception e10) {
            Log.e(TAG, "Failed to read openclaw.json", e10);
            openClawConfig = new OpenClawConfig(null, null, null, null, 0, null, null, 127, null);
            return openClawConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restoreCredentialsFromBackupDir() {
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(CREDENTIALS_BACKUP_DIR);
            File fileResolveRootfsPath2 = this.runtimeConfig.resolveRootfsPath(CREDENTIALS_DIR);
            if (fileResolveRootfsPath.exists() && fileResolveRootfsPath.isDirectory()) {
                if (fileResolveRootfsPath2.exists()) {
                    l.z0(fileResolveRootfsPath2);
                }
                l.x0(fileResolveRootfsPath, fileResolveRootfsPath2);
                Log.i(TAG, "Restored credentials from root/.openclaw/credentials.backup");
            }
        } catch (Exception e9) {
            Log.w(TAG, "Failed to restore credentials from backup directory", e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean restoreFileWithFallback(RootfsFileHelper bootstrap, String configPath, String assetPath) throws IOException {
        File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(configPath + ".known-good");
        if (fileResolveRootfsPath.exists() && fileResolveRootfsPath.length() > 100) {
            bootstrap.writeRootfsFile(configPath, l.E0(fileResolveRootfsPath, x5.a.f6276a));
            Log.i(TAG, "Restored " + configPath + " from .known-good");
            return true;
        }
        if (fileResolveRootfsPath.exists()) {
            Log.w(TAG, "Skipped .known-good for " + configPath + ": too small (" + fileResolveRootfsPath.length() + " bytes)");
        }
        File fileResolveRootfsPath2 = this.runtimeConfig.resolveRootfsPath(configPath + ".backup");
        if (fileResolveRootfsPath2.exists() && fileResolveRootfsPath2.length() > 100) {
            bootstrap.writeRootfsFile(configPath, l.E0(fileResolveRootfsPath2, x5.a.f6276a));
            Log.i(TAG, "Restored " + configPath + " from .backup (factory)");
            return true;
        }
        if (assetPath == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.context.getAssets().open(assetPath);
            kotlin.jvm.internal.p.d(inputStreamOpen, "open(...)");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen, x5.a.f6276a), 8192);
            try {
                String strC = z.C(bufferedReader);
                bufferedReader.close();
                bootstrap.writeRootfsFile(configPath, strC);
                Log.i(TAG, "Restored " + configPath + " from bundled assets");
                return true;
            } finally {
            }
        } catch (Exception e9) {
            Log.w(TAG, "No .known-good/.backup/asset fallback for " + configPath, e9);
            return false;
        }
    }

    public static /* synthetic */ boolean restoreFileWithFallback$default(JsonConfigStore jsonConfigStore, RootfsFileHelper rootfsFileHelper, String str, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        return jsonConfigStore.restoreFileWithFallback(rootfsFileHelper, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String updateAuthProfilesJson(String existingJson, OpenClawConfig config) throws JSONException {
        Log.d(TAG, "updateAuthProfilesJson: updating profile for provider=" + config.getProvider());
        JSONObject jSONObject = new JSONObject(existingJson);
        jSONObject.put("version", 1);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("profiles");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObject.put("profiles", jSONObjectOptJSONObject);
        }
        String strN = a8.b.n(config.getProvider(), ":default");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", "api_key");
        jSONObject2.put(ConfigIpcContract.KEY_PROVIDER, config.getProvider());
        jSONObject2.put("key", config.getApiKey());
        jSONObjectOptJSONObject.put(strN, jSONObject2);
        String string = jSONObject.toString(2);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String updateOpenClawJson(String existingJson, OpenClawConfig config) throws JSONException {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(existingJson);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("gateway");
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            jSONObject.put("gateway", jSONObjectOptJSONObject);
        }
        jSONObjectOptJSONObject.put(ConfigIpcContract.KEY_PORT, config.getPort());
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("models");
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
            jSONObject.put("models", jSONObjectOptJSONObject2);
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("providers");
        if (jSONObjectOptJSONObject3 == null) {
            jSONObjectOptJSONObject3 = new JSONObject();
            jSONObjectOptJSONObject2.put("providers", jSONObjectOptJSONObject3);
        }
        if (!n.t1(config.getProvider())) {
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject3.optJSONObject(config.getProvider());
            if (jSONObjectOptJSONObject4 == null) {
                jSONObjectOptJSONObject4 = new JSONObject();
                jSONObjectOptJSONObject3.put(config.getProvider(), jSONObjectOptJSONObject4);
            }
            if (!n.t1(config.getBaseUrl())) {
                jSONObjectOptJSONObject4.put(ConfigIpcContract.KEY_BASE_URL, config.getBaseUrl());
            }
            if (config.getApi() != null) {
                jSONObjectOptJSONObject4.put(ConfigIpcContract.KEY_API_FORMAT, config.getApi());
            }
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject4.optJSONArray("models");
            if (jSONArrayOptJSONArray == null) {
                jSONArrayOptJSONArray = new JSONArray();
                jSONObjectOptJSONObject4.put("models", jSONArrayOptJSONArray);
            }
            if (kotlin.jvm.internal.p.a(config.getImageInput(), Boolean.FALSE)) {
                jSONArray = new JSONArray();
                jSONArray.put("text");
            } else {
                jSONArray = new JSONArray();
                jSONArray.put("text");
                jSONArray.put("image");
            }
            int length = jSONArrayOptJSONArray.length();
            int i8 = 0;
            while (true) {
                if (i8 < length) {
                    JSONObject jSONObjectOptJSONObject5 = jSONArrayOptJSONArray.optJSONObject(i8);
                    if (kotlin.jvm.internal.p.a(jSONObjectOptJSONObject5 != null ? jSONObjectOptJSONObject5.optString("id") : null, config.getModel())) {
                        jSONObjectOptJSONObject5.put("name", config.getModel());
                        jSONObjectOptJSONObject5.put("input", jSONArray);
                        break;
                    }
                    i8++;
                } else if (!n.t1(config.getModel())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", config.getModel());
                    jSONObject2.put("name", config.getModel());
                    jSONObject2.put("input", jSONArray);
                    jSONArrayOptJSONArray.put(jSONObject2);
                }
            }
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObject.optJSONObject("agents");
        if (jSONObjectOptJSONObject6 == null) {
            jSONObjectOptJSONObject6 = new JSONObject();
            jSONObject.put("agents", jSONObjectOptJSONObject6);
        }
        JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject6.optJSONObject("defaults");
        if (jSONObjectOptJSONObject7 == null) {
            jSONObjectOptJSONObject7 = new JSONObject();
            jSONObjectOptJSONObject6.put("defaults", jSONObjectOptJSONObject7);
        }
        if (!n.t1(config.getProvider()) && !n.t1(config.getModel())) {
            jSONObjectOptJSONObject7.put(ConfigIpcContract.KEY_MODEL, config.getProvider() + "/" + config.getModel());
        }
        String string = jSONObject.toString(2);
        kotlin.jvm.internal.p.d(string, "toString(...)");
        return string;
    }

    public final void backupKnownGood() {
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && fileResolveRootfsPath.length() > 100) {
                l.y0(fileResolveRootfsPath, this.runtimeConfig.resolveRootfsPath("root/.openclaw/openclaw.json.known-good"));
                Log.i(TAG, "Backed up openclaw.json as known-good (" + fileResolveRootfsPath.length() + " bytes)");
            } else if (fileResolveRootfsPath.exists()) {
                Log.w(TAG, "Skipped known-good backup: openclaw.json too small (" + fileResolveRootfsPath.length() + " bytes)");
            }
        } catch (Exception e9) {
            Log.w(TAG, "Failed to backup openclaw.json", e9);
        }
        try {
            File fileResolveRootfsPath2 = this.runtimeConfig.resolveRootfsPath(AUTH_PROFILES_JSON);
            if (fileResolveRootfsPath2.exists() && fileResolveRootfsPath2.length() > 50) {
                l.y0(fileResolveRootfsPath2, this.runtimeConfig.resolveRootfsPath("root/.openclaw/agents/main/agent/auth-profiles.json.known-good"));
                Log.i(TAG, "Backed up auth-profiles.json as known-good (" + fileResolveRootfsPath2.length() + " bytes)");
            } else if (fileResolveRootfsPath2.exists()) {
                Log.w(TAG, "Skipped known-good backup: auth-profiles.json too small (" + fileResolveRootfsPath2.length() + " bytes)");
            }
        } catch (Exception e10) {
            Log.w(TAG, "Failed to backup auth-profiles.json", e10);
        }
        try {
            File fileResolveRootfsPath3 = this.runtimeConfig.resolveRootfsPath(MODELS_JSON);
            if (fileResolveRootfsPath3.exists()) {
                l.y0(fileResolveRootfsPath3, this.runtimeConfig.resolveRootfsPath("root/.openclaw/agents/main/agent/models.json.known-good"));
                Log.i(TAG, "Backed up models.json as known-good (" + fileResolveRootfsPath3.length() + " bytes)");
            }
        } catch (Exception e11) {
            Log.w(TAG, "Failed to backup models.json", e11);
        }
        try {
            File fileResolveRootfsPath4 = this.runtimeConfig.resolveRootfsPath(DOTENV);
            if (fileResolveRootfsPath4.exists()) {
                l.y0(fileResolveRootfsPath4, this.runtimeConfig.resolveRootfsPath("root/.openclaw/.env.known-good"));
                Log.i(TAG, "Backed up .env as known-good (" + fileResolveRootfsPath4.length() + " bytes)");
            }
        } catch (Exception e12) {
            Log.w(TAG, "Failed to backup .env", e12);
        }
        try {
            File fileResolveRootfsPath5 = this.runtimeConfig.resolveRootfsPath(CRON_JOBS_JSON);
            if (fileResolveRootfsPath5.exists()) {
                l.y0(fileResolveRootfsPath5, this.runtimeConfig.resolveRootfsPath("root/.openclaw/cron/jobs.json.known-good"));
                Log.i(TAG, "Backed up cron jobs.json as known-good (" + fileResolveRootfsPath5.length() + " bytes)");
            }
        } catch (Exception e13) {
            Log.w(TAG, "Failed to backup cron jobs.json", e13);
        }
        try {
            File fileResolveRootfsPath6 = this.runtimeConfig.resolveRootfsPath(CREDENTIALS_DIR);
            if (fileResolveRootfsPath6.exists() && fileResolveRootfsPath6.isDirectory()) {
                File fileResolveRootfsPath7 = this.runtimeConfig.resolveRootfsPath(CREDENTIALS_BACKUP_DIR);
                if (fileResolveRootfsPath7.exists()) {
                    l.z0(fileResolveRootfsPath7);
                }
                l.x0(fileResolveRootfsPath6, fileResolveRootfsPath7);
                Log.i(TAG, "Backed up credentials dir to root/.openclaw/credentials.backup");
            }
        } catch (Exception e14) {
            Log.w(TAG, "Failed to backup credentials directory", e14);
        }
    }

    public final boolean ensureGatewayAuthTokenMode() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        String str;
        String strOptString;
        String strOptString2;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null) {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("auth");
                String str2 = "none";
                if (jSONObjectOptJSONObject2 != null && (strOptString2 = jSONObjectOptJSONObject2.optString("mode", "none")) != null) {
                    str2 = strOptString2;
                }
                String str3 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                if (jSONObjectOptJSONObject2 != null && (strOptString = jSONObjectOptJSONObject2.optString(GatewayAuthConstants.AUTH_MODE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) != null) {
                    str3 = strOptString;
                }
                String strExpectedToken = GatewayAuthConstants.INSTANCE.expectedToken(this.context);
                if (str2.equals(GatewayAuthConstants.AUTH_MODE)) {
                    if (!str3.equals(strExpectedToken)) {
                    }
                }
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                }
                jSONObjectOptJSONObject2.put("mode", GatewayAuthConstants.AUTH_MODE);
                jSONObjectOptJSONObject2.put(GatewayAuthConstants.AUTH_MODE, strExpectedToken);
                jSONObjectOptJSONObject.put("auth", jSONObjectOptJSONObject2);
                String string = jSONObject.toString(2);
                kotlin.jvm.internal.p.d(string, "toString(...)");
                l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                if (str3.equals(strExpectedToken)) {
                    str = ConfigIpcContract.KEY_OK;
                } else {
                    str = "reset->" + GatewayTokenDeriver.INSTANCE.maskToken(strExpectedToken);
                }
                Log.w(TAG, "ensureGatewayAuthTokenMode: corrected gateway.auth (mode '" + str2 + "'->'token', token=" + str + ")");
                return true;
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayAuthTokenMode failed", e9);
            return false;
        }
    }

    public final boolean ensureGatewayBind() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("bind", "loopback");
                if (!kotlin.jvm.internal.p.a(strOptString, "loopback")) {
                    jSONObjectOptJSONObject.put("bind", "loopback");
                    String string = jSONObject.toString(2);
                    kotlin.jvm.internal.p.d(string, "toString(...)");
                    l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                    Log.w(TAG, "ensureGatewayBind: corrected gateway.bind from '" + strOptString + "' to 'loopback'");
                    return true;
                }
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayBind failed", e9);
            return false;
        }
    }

    public final boolean ensureGatewayExperimental() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("experimental", "snapshot");
                if (!kotlin.jvm.internal.p.a(strOptString, "snapshot")) {
                    jSONObjectOptJSONObject.put("experimental", "snapshot");
                    String string = jSONObject.toString(2);
                    kotlin.jvm.internal.p.d(string, "toString(...)");
                    l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                    Log.w(TAG, "ensureGatewayExperimental: corrected gateway.experimental from '" + strOptString + "' to 'snapshot'");
                    return true;
                }
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayExperimental failed", e9);
            return false;
        }
    }

    public final boolean ensureGatewayModeLocal() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null) {
                String strOptString = jSONObjectOptJSONObject.optString("mode", "local");
                if (!kotlin.jvm.internal.p.a(strOptString, "local")) {
                    jSONObjectOptJSONObject.put("mode", "local");
                    String string = jSONObject.toString(2);
                    kotlin.jvm.internal.p.d(string, "toString(...)");
                    l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                    Log.w(TAG, "ensureGatewayModeLocal: corrected gateway.mode from '" + strOptString + "' to 'local'");
                    return true;
                }
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayModeLocal failed", e9);
            return false;
        }
    }

    public final boolean ensureGatewayPort() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        int iOptInt;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null && (iOptInt = jSONObjectOptJSONObject.optInt(ConfigIpcContract.KEY_PORT, 18789)) != 18789) {
                jSONObjectOptJSONObject.put(ConfigIpcContract.KEY_PORT, 18789);
                String string = jSONObject.toString(2);
                kotlin.jvm.internal.p.d(string, "toString(...)");
                l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                Log.w(TAG, "ensureGatewayPort: corrected gateway.port from " + iOptInt + " to 18789");
                return true;
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayPort failed", e9);
            return false;
        }
    }

    public final boolean ensureGatewayTlsDisabled() {
        JSONObject jSONObject;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (fileResolveRootfsPath.exists() && (jSONObjectOptJSONObject = (jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, x5.a.f6276a))).optJSONObject("gateway")) != null && (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("tls")) != null && jSONObjectOptJSONObject2.optBoolean(ExtensionCallContract.ENABLED, false)) {
                jSONObjectOptJSONObject2.put(ExtensionCallContract.ENABLED, false);
                jSONObjectOptJSONObject.put("tls", jSONObjectOptJSONObject2);
                String string = jSONObject.toString(2);
                kotlin.jvm.internal.p.d(string, "toString(...)");
                l.G0(fileResolveRootfsPath, string, x5.a.f6276a);
                Log.w(TAG, "ensureGatewayTlsDisabled: disabled gateway.tls.enabled");
                return true;
            }
            return false;
        } catch (Exception e9) {
            Log.e(TAG, "ensureGatewayTlsDisabled failed", e9);
            return false;
        }
    }

    public final b getConfigFlow() {
        return this.configFlow;
    }

    public final Object hasApiKey(c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new AnonymousClass2(null), cVar);
    }

    public final boolean hasApiKeySync() throws IOException {
        if (loadAuthProfilesJson() == null) {
            return false;
        }
        return !n.t1(readApiKeyFromJson(r0));
    }

    public final Object readConfig(c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00122(null), cVar);
    }

    public final Object readModelPresets(c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00132(null), cVar);
    }

    public final Object restoreFromBackup(c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00142(null), cVar);
    }

    public final boolean restoreGatewayFields() {
        try {
            File fileResolveRootfsPath = this.runtimeConfig.resolveRootfsPath("root/.openclaw/openclaw.json.known-good");
            File fileResolveRootfsPath2 = this.runtimeConfig.resolveRootfsPath("root/.openclaw/openclaw.json.backup");
            if (!fileResolveRootfsPath.exists() || fileResolveRootfsPath.length() <= 100) {
                if (!fileResolveRootfsPath2.exists() || fileResolveRootfsPath2.length() <= 100) {
                    Log.w(TAG, "restoreGatewayFields: no .known-good or .backup file");
                    return false;
                }
                fileResolveRootfsPath = fileResolveRootfsPath2;
            }
            File fileResolveRootfsPath3 = this.runtimeConfig.resolveRootfsPath(OPENCLAW_JSON);
            if (!fileResolveRootfsPath3.exists()) {
                Log.w(TAG, "restoreGatewayFields: current openclaw.json missing");
                return false;
            }
            Charset charset = x5.a.f6276a;
            JSONObject jSONObject = new JSONObject(l.E0(fileResolveRootfsPath, charset));
            JSONObject jSONObject2 = new JSONObject(l.E0(fileResolveRootfsPath3, charset));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("gateway");
            if (jSONObjectOptJSONObject == null) {
                Log.w(TAG, "restoreGatewayFields: source has no gateway section");
                return false;
            }
            jSONObject2.put("gateway", jSONObjectOptJSONObject);
            String string = jSONObject2.toString(2);
            kotlin.jvm.internal.p.d(string, "toString(...)");
            l.G0(fileResolveRootfsPath3, string, x5.a.f6276a);
            ensureGatewayAuthTokenMode();
            ensureGatewayPort();
            ensureGatewayBind();
            Log.i(TAG, "restoreGatewayFields: restored gateway section from " + fileResolveRootfsPath.getName());
            return true;
        } catch (Exception e9) {
            Log.e(TAG, "restoreGatewayFields failed", e9);
            return false;
        }
    }

    public final Object restoreWorkspaceFiles(c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00152(null), cVar);
    }

    public final Object save(OpenClawConfig openClawConfig, c cVar) {
        h6.e eVar = r0.f210a;
        return i0.A(d.f3059c, new C00162(openClawConfig, null), cVar);
    }

    public /* synthetic */ JsonConfigStore(Context context, OpenClawRuntimeConfig openClawRuntimeConfig, int i8, kotlin.jvm.internal.i iVar) {
        this(context, (i8 & 2) != 0 ? OpenClawRuntimeConfig.INSTANCE.fromContext(context) : openClawRuntimeConfig);
    }
}
