package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import com.obric.autogui.common.api.abilities.AutoActionAbilitiesKt;
import com.obric.autogui.common.api.abilities.AutoActionAbility;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: DonationHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private static final String TAG = "DonationHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f23731b;

    private c() {
    }

    static {
        f23730a = new c();
        f23731b = "";
    }

    public final String a() {
        return f23731b;
    }

    public final void a(String r1) {
        o.e(r1, "<set-?>");
        f23731b = r1;
    }

    public final boolean a(Context r4) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), "context");
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L17
        if (AutoActionAbilitiesKt.isSupported(AutoActionAbility.ProdDataDonation) == true) goto L9;
        Loog.INSTANCE.i(TAG, "enableDonation: abilityEnable false");     // Catch: Throwable -> L17
        return false;
    L9:
        if (AOPlatformTools.INSTANCE.account().acquireUserInfo().getType() != 0) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == false) goto L15;
        Loog.INSTANCE.i(TAG, "enableDonation: isLogin true");     // Catch: Throwable -> L17
        return true;
    L15:
        d.n.f(x.f38692a);     // Catch: Throwable -> L17
    L19:
        return false;
    L11:
        r6 = false;
    L17:
        th = move-exception;
        d.n.a r0 = d.n.f38560a;
        d.n.f(d.o.a(th));
        goto L19
    }
}
