package com.stepos.ailauncher.chat.view;

import android.R;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/view/Window;", "host", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroid/view/Window;Landroid/view/Window;)V", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.z7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3034z7 {
    public static final void b(Window window, Window window2) {
        window.addFlags(768);
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        androidx.core.view.Y.b(window, false);
        window.setBackgroundDrawableResource(R.color.transparent);
        androidx.core.view.b0 b0Var = new androidx.core.view.b0(window2, window2.getDecorView());
        androidx.core.view.b0 b0Var2 = new androidx.core.view.b0(window, window.getDecorView());
        b0Var2.e(b0Var.c());
        b0Var2.d(b0Var.b());
    }
}
