package com.stepos.ailauncher.floatcard;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Z", "floatcard_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final boolean a(Context context) {
        Context baseContext;
        p.i(context, "<this>");
        while (true) {
            if ((context instanceof LifecycleOwner) && ((LifecycleOwner) context).getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED)) {
                return true;
            }
            if (!(context instanceof ContextWrapper) || (baseContext = ((ContextWrapper) context).getBaseContext()) == null || baseContext == context) {
                return false;
            }
            context = baseContext;
        }
    }
}
