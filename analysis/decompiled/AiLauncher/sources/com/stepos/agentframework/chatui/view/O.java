package com.stepos.agentframework.chatui.view;

import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/agentframework/chatui/view/O;", "", "<init>", "()V", "Landroid/view/View;", "view", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Z", "", "TOUCH_WRAPPER", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class O {
    public static final O INSTANCE = new O();
    private static final String TOUCH_WRAPPER = "com.stepos.ailauncher.container.ViewPagerTouchWrapper";

    public final boolean a(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        while (view != null) {
            if (kotlin.jvm.internal.p.d(view.getClass().getName(), TOUCH_WRAPPER)) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }
}
