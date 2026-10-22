package com.stepos.ailauncher.chat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0082\u0010¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "Landroid/app/Activity;", Const.INTENT_KEY_PKGNAME, "(Landroid/content/Context;)Landroid/app/Activity;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X6 {
    public static final Activity b(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            kotlin.jvm.internal.p.h(context, "getBaseContext(...)");
        }
        return (Activity) context;
    }
}
