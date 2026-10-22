package com.obric.aiagent.interaction.provider.a;

import android.os.Bundle;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.windoweffects.IWindowEffects;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.n;
import d.o;

/* JADX INFO: compiled from: ScreenShotEffectAbility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "ScreenShotEffectAbility";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0387a f18593a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.interaction.provider.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ScreenShotEffectAbility.kt */
    public static final class C0387a {
        public /* synthetic */ C0387a(h r1) {
            this();
        }

        private C0387a() {
        }
    }

    static {
        f18593a = new C0387a(null);
    }

    public a() {
    }

    public Bundle call(String r6, Bundle r7) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L9
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        if (r7 == null) goto L6;
        boolean r8 = r7.getBoolean("skipAssistantWindow", false);     // Catch: Throwable -> L9
    L7:
        Object r9 = n.f(Boolean.valueOf(r8));     // Catch: Throwable -> L9
    L11:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L15;
        ILogDepend.Companion.w(TAG, "get skipAssistantWindow failed: " + r10.getMessage(), r10);
    L15:
        if (n.b(r9) == false) goto L17;
        r9 = false;
    L17:
        boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        ILogDepend.Companion.i(TAG, "call: skipAssistantWindow = " + r11);
        IWindowEffects.DefaultImpls.showScreenShotEffect$default(ObricProductSdk.INSTANCE.platformService().windowEffects(), r11, null, 2, null);
        return null;
    L6:
        r8 = false;
    L9:
        th = move-exception;
        n.a r12 = n.f38560a;
        r9 = n.f(o.a(th));
        goto L11
    }
}
