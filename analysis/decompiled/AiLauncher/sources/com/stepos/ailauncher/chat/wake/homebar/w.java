package com.stepos.ailauncher.chat.wake.homebar;

import android.content.Context;
import android.provider.Settings;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/homebar/w;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)V", "", "TAG", "Ljava/lang/String;", "SECURE_KEY", "MMKV_KEY", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    public static final w INSTANCE = new w();
    private static final String MMKV_KEY = "homebar_longpress_guide_done";
    private static final String SECURE_KEY = "stepos_ailauncher_homebar_lp_guide_done";
    private static final String TAG = "HomeBarLpGuide";

    public final boolean a(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Integer.valueOf(Settings.Secure.getInt(context.getContentResolver(), SECURE_KEY, 0)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = 0;
        }
        if (((Number) objB).intValue() == 1) {
            return true;
        }
        return C5009a.g(C5009a.INSTANCE, MMKV_KEY, false, false, 4, null);
    }

    public final void b(Context context) {
        Object objB;
        kotlin.jvm.internal.p.i(context, "context");
        try {
            Result.Companion companion = Result.INSTANCE;
            Settings.Secure.putInt(context.getContentResolver(), SECURE_KEY, 1);
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "putInt stepos_ailauncher_homebar_lp_guide_done failed, fallback MMKV", thE, false, 8, null);
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        boolean zBooleanValue = ((Boolean) objB).booleanValue();
        if (!zBooleanValue) {
            C5009a.y(C5009a.INSTANCE, MMKV_KEY, true, false, 4, null);
        }
        C4148a.k(TAG, "markCompleted secure=" + zBooleanValue, false, 4, null);
    }
}
