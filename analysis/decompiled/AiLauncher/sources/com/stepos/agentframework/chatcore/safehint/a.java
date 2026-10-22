package com.stepos.agentframework.chatcore.safehint;

import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.net.HttpManager;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R$\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/stepos/agentframework/chatcore/safehint/a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "c", "", UxipConstants.f30680s, "baseUrl", "Ljava/lang/String;", "getBaseUrl", "()Ljava/lang/String;", "", x5.d.EXTRA_ENABLED, "Z", Const.INTENT_KEY_APIKEY, "()Z", "setEnabled", "(Z)V", "initialized", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static volatile String baseUrl = "";
    private static volatile boolean enabled = true;
    private static volatile boolean initialized;

    public final boolean a() {
        return enabled;
    }

    public final void b(Context context) {
        p.i(context, "context");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            baseUrl = C4.a.INSTANCE.a(context.getApplicationContext()).a();
            INSTANCE.c();
            initialized = true;
            t tVar = t.f7040a;
        }
    }

    public final void c() {
        if (baseUrl.length() <= 0 || !HttpManager.isInitialized()) {
            return;
        }
        HttpManager.INSTANCE.addBaseUrl("safe_hint_base_url_key", baseUrl);
    }
}
