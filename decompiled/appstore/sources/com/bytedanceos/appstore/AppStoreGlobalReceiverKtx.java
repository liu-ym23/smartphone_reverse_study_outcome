package com.bytedanceos.appstore;

import android.content.Context;
import android.content.Intent;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.JumpActivity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes2.dex */
public final class AppStoreGlobalReceiverKtx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f8260a;

    public AppStoreGlobalReceiverKtx() {
        this.f8260a = d0.a(x1.b(null, 1, null).plus(l0.c().e()));
    }

    public final void a(Context r10, Intent r11) {
        q.g(r10, "context");
        q.g(r11, MemorySourceLinkType.INTENT);
        int r12 = r11.getIntExtra("status", -1);
        AppInfo r13 = AppStoreGlobalReceiver.c(r11);
        q.f(r13, "getAppInfo(...)");
        boolean r14 = ((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue();
        j.n("[AppStatus] handleQuickSearchInstallRequest: status:" + r12 + ", privacyPolicyUserAgreed:" + r14);
        if (r14 == true) goto L5;
        Intent r15 = new Intent(r10, JumpActivity.class);
        r15.putExtra(JumpActivity.ARG_USER_AGREEMENT_ONLY, true);
        r15.putExtra(JumpActivity.ARG_OVERRIDE_ENTER_ANIM, true);
        r15.setFlags(268468224);
        r10.startActivity(r15);
    L5:
        h.d(this.f8260a, null, null, new AppStoreGlobalReceiverKtx$handleQuickSearchInstallRequest$1(!r14, r12, r13, null), 3, null);
    }
}
