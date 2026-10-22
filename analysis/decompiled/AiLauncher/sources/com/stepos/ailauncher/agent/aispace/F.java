package com.stepos.ailauncher.agent.aispace;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/F;", "", "<init>", "()V", "Landroid/view/View;", "target", "", "cornerDp", "blurRadiusDp", "Ly7/E;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;FF)Ly7/E;", "radiusDp", "c", "TAB_ROOT_BLUR_RADIUS_DP", "F", "TAB_ROOT_CORNER_DP", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class F {
    public static final F INSTANCE = new F();
    private static final float TAB_ROOT_BLUR_RADIUS_DP = 30.0f;
    private static final float TAB_ROOT_CORNER_DP = 24.0f;

    public static /* synthetic */ y7.E b(F f10, View view, float f11, float f12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f11 = 24.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 30.0f;
        }
        return f10.a(view, f11, f12);
    }

    public final y7.E a(View target, float cornerDp, float blurRadiusDp) {
        kotlin.jvm.internal.p.i(target, "target");
        return c(target, blurRadiusDp, cornerDp);
    }

    public final y7.E c(View target, float radiusDp, float cornerDp) {
        com.stepos.ailauncher.container.glass.h hVar = com.stepos.ailauncher.container.glass.h.INSTANCE;
        hVar.j(target, cornerDp);
        return hVar.n(target, radiusDp, false, Float.valueOf(cornerDp));
    }
}
