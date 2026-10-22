package com.stepos.net.token;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\tR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/stepos/net/token/EncryptedTokenStore;", "Lcom/stepos/net/token/TokenStore;", "Landroid/content/SharedPreferences;", "prefs", AppAgent.CONSTRUCT, "(Landroid/content/SharedPreferences;)V", "LC7/r;", "clear", "()V", "Landroid/content/SharedPreferences;", "", "value", "getAccess", "()Ljava/lang/String;", "setAccess", "(Ljava/lang/String;)V", "access", "getRefresh", "setRefresh", "refresh", "Companion", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EncryptedTokenStore implements TokenStore {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DEFAULT_NAME = "stepos_secure_tokens";
    private static final String KEY_ACCESS = "access_token";
    private static final String KEY_REFRESH = "refresh_token";
    private final SharedPreferences prefs;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/net/token/EncryptedTokenStore$Companion;", "", AppAgent.CONSTRUCT, "()V", "KEY_ACCESS", "", "KEY_REFRESH", "DEFAULT_NAME", "create", "Lcom/stepos/net/token/EncryptedTokenStore;", "context", "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_NAME, "buildEncryptedPrefs", "Landroid/content/SharedPreferences;", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final SharedPreferences buildEncryptedPrefs(Context context, String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Object obj;
            Object obj2;
            Object obj3;
            Class<?> cls = Class.forName("androidx.security.crypto.MasterKey");
            Class<?> cls2 = Class.forName("androidx.security.crypto.MasterKey$Builder");
            Class<?> cls3 = Class.forName("androidx.security.crypto.MasterKey$KeyScheme");
            Object[] enumConstants = cls3.getEnumConstants();
            if (enumConstants != null) {
                int length = enumConstants.length;
                int i = 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        obj = null;
                        break;
                    }
                    obj = enumConstants[i6];
                    k.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
                    if (k.b(((Enum) obj).name(), "AES256_GCM")) {
                        break;
                    }
                    i6++;
                }
                if (obj != null) {
                    Object objNewInstance = cls2.getConstructor(Context.class).newInstance(context);
                    cls2.getMethod("setKeyScheme", cls3).invoke(objNewInstance, obj);
                    Object objInvoke = cls2.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, null).invoke(objNewInstance, null);
                    Class<?> cls4 = Class.forName("androidx.security.crypto.EncryptedSharedPreferences");
                    Class<?> cls5 = Class.forName("androidx.security.crypto.EncryptedSharedPreferences$PrefKeyEncryptionScheme");
                    Class<?> cls6 = Class.forName("androidx.security.crypto.EncryptedSharedPreferences$PrefValueEncryptionScheme");
                    Object[] enumConstants2 = cls5.getEnumConstants();
                    if (enumConstants2 != null) {
                        int length2 = enumConstants2.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length2) {
                                obj2 = null;
                                break;
                            }
                            obj2 = enumConstants2[i10];
                            k.d(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                            if (k.b(((Enum) obj2).name(), "AES256_SIV")) {
                                break;
                            }
                            i10++;
                        }
                        if (obj2 != null) {
                            Object[] enumConstants3 = cls6.getEnumConstants();
                            if (enumConstants3 != null) {
                                int length3 = enumConstants3.length;
                                while (true) {
                                    if (i >= length3) {
                                        obj3 = null;
                                        break;
                                    }
                                    obj3 = enumConstants3[i];
                                    k.d(obj3, "null cannot be cast to non-null type kotlin.Enum<*>");
                                    if (k.b(((Enum) obj3).name(), "AES256_GCM")) {
                                        break;
                                    }
                                    i++;
                                }
                                if (obj3 != null) {
                                    Object objInvoke2 = cls4.getMethod("create", Context.class, String.class, cls, cls5, cls6).invoke(null, context, name, objInvoke, obj2, obj3);
                                    k.d(objInvoke2, "null cannot be cast to non-null type android.content.SharedPreferences");
                                    return (SharedPreferences) objInvoke2;
                                }
                            }
                            throw new IllegalStateException("AES256_GCM PrefValue scheme not found");
                        }
                    }
                    throw new IllegalStateException("AES256_SIV PrefKey scheme not found");
                }
            }
            throw new IllegalStateException("AES256_GCM KeyScheme not found");
        }

        public static /* synthetic */ EncryptedTokenStore create$default(Companion companion, Context context, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = EncryptedTokenStore.DEFAULT_NAME;
            }
            return companion.create(context, str);
        }

        public final EncryptedTokenStore create(Context context) {
            k.f(context, "context");
            return create$default(this, context, null, 2, null);
        }

        private Companion() {
        }

        public final EncryptedTokenStore create(Context context, String name) {
            Object objA;
            k.f(context, "context");
            k.f(name, "name");
            try {
                Context applicationContext = context.getApplicationContext();
                k.e(applicationContext, "getApplicationContext(...)");
                objA = buildEncryptedPrefs(applicationContext, name);
            } catch (Throwable th) {
                objA = b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA == null) {
                return new EncryptedTokenStore((SharedPreferences) objA, null);
            }
            throw new IllegalStateException("EncryptedTokenStore requires the AndroidX security-crypto library on the classpath. Add this to your app/build.gradle.kts:\nimplementation(\"androidx.security:security-crypto:1.1.0-alpha06\")", thA);
        }
    }

    public /* synthetic */ EncryptedTokenStore(SharedPreferences sharedPreferences, e eVar) {
        this(sharedPreferences);
    }

    public static final EncryptedTokenStore create(Context context) {
        return INSTANCE.create(context);
    }

    @Override // com.stepos.net.token.TokenStore
    public void clear() {
        this.prefs.edit().remove(KEY_ACCESS).remove(KEY_REFRESH).apply();
    }

    @Override // com.stepos.net.token.TokenStore
    public String getAccess() {
        return this.prefs.getString(KEY_ACCESS, null);
    }

    @Override // com.stepos.net.token.TokenStore
    public String getRefresh() {
        return this.prefs.getString(KEY_REFRESH, null);
    }

    @Override // com.stepos.net.token.TokenStore
    public void setAccess(String str) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        if (str == null) {
            editorEdit.remove(KEY_ACCESS);
        } else {
            editorEdit.putString(KEY_ACCESS, str);
        }
        editorEdit.apply();
    }

    @Override // com.stepos.net.token.TokenStore
    public void setRefresh(String str) {
        SharedPreferences.Editor editorEdit = this.prefs.edit();
        if (str == null) {
            editorEdit.remove(KEY_REFRESH);
        } else {
            editorEdit.putString(KEY_REFRESH, str);
        }
        editorEdit.apply();
    }

    private EncryptedTokenStore(SharedPreferences sharedPreferences) {
        this.prefs = sharedPreferences;
    }

    public static final EncryptedTokenStore create(Context context, String str) {
        return INSTANCE.create(context, str);
    }
}
