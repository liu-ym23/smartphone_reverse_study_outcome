package com.stepos.ailauncher.agent.aispace.connect;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J\r\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0006J\r\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\u0011\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/l;", "", "<init>", "()V", "", Const.INTENT_KEY_PKGNAME, "()Z", "LY8/t;", "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "c", "", "f", "()Ljava/lang/String;", "KEY_STEPAI", "Ljava/lang/String;", "KEY_EXTERNAL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.l, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2215l {
    public static final C2215l INSTANCE = new C2215l();
    private static final String KEY_EXTERNAL = "agent_cross_device_auth_external_";
    private static final String KEY_STEPAI = "agent_cross_device_auth_stepai_";

    public final boolean a() {
        String strF = f();
        if (strF == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_EXTERNAL + strF, false, false, 4, null);
    }

    public final boolean b() {
        String strF = f();
        if (strF == null) {
            return false;
        }
        return C5009a.g(C5009a.INSTANCE, KEY_STEPAI + strF, false, false, 4, null);
    }

    public final void c() {
        String strF = f();
        if (strF == null) {
            return;
        }
        C5009a c5009a = C5009a.INSTANCE;
        C5009a.y(c5009a, KEY_STEPAI + strF, false, false, 4, null);
        C5009a.y(c5009a, KEY_EXTERNAL + strF, false, false, 4, null);
    }

    public final void d() {
        String strF = f();
        if (strF == null) {
            return;
        }
        C5009a.y(C5009a.INSTANCE, KEY_EXTERNAL + strF, true, false, 4, null);
    }

    public final void e() {
        String strF = f();
        if (strF == null) {
            return;
        }
        C5009a.y(C5009a.INSTANCE, KEY_STEPAI + strF, true, false, 4, null);
    }

    public final String f() {
        Object objB;
        com.stepos.ailauncher.foundation.account.f fVar = com.stepos.ailauncher.foundation.account.f.INSTANCE;
        if (!fVar.v()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(fVar.k());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }
}
