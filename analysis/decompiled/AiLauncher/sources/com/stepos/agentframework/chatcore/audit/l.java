package com.stepos.agentframework.chatcore.audit;

import Y8.t;
import android.content.Context;
import android.content.SharedPreferences;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J\u001f\u0010\u0011\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/l;", "", "<init>", "()V", "", "agentId", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "context", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "e", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "c", "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "PREF_NAME", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class l {
    public static final l INSTANCE = new l();
    private static final String PREF_NAME = "chatcore_main_session_established";
    private static final String TAG = "MainSessionEstablishedMarker";

    public final void a() {
        Object objB;
        ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
        if (chatCoreSdk.g()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                e(chatCoreSdk.c()).edit().clear().apply();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.h(TAG, "clear failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final boolean b(String agentId) {
        String strC;
        Object objB;
        p.i(agentId, "agentId");
        ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
        if (!chatCoreSdk.g() || (strC = c(agentId)) == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(e(chatCoreSdk.c()).getBoolean(strC, false)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        if (zBooleanValue) {
            C4148a.k(TAG, "everEstablished hit: key=" + strC, false, 4, null);
        }
        return zBooleanValue;
    }

    public final String c(String agentId) {
        O6.h hVarA = O6.a.INSTANCE.a();
        String strA = hVarA != null ? hVarA.a() : null;
        if (strA == null || strA.length() == 0 || agentId.length() == 0) {
            return null;
        }
        return strA + ServerSentEventKt.COLON + agentId;
    }

    public final void d(String agentId) {
        String strC;
        Object objB;
        p.i(agentId, "agentId");
        ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
        if (chatCoreSdk.g() && (strC = c(agentId)) != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                e(chatCoreSdk.c()).edit().putBoolean(strC, true).apply();
                objB = Result.b(Integer.valueOf(C4148a.k(TAG, "markEstablished: key=" + strC, false, 4, null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.h(TAG, "markEstablished failed: " + thE.getMessage(), false, 4, null);
            }
        }
    }

    public final SharedPreferences e(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0);
    }
}
