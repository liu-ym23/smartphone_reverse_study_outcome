package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/content/Context;", "Landroidx/lifecycle/LifecycleOwner;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class A {
    /* JADX WARN: Multi-variable type inference failed */
    public static final LifecycleOwner a(Context context) {
        kotlin.jvm.internal.p.i(context, "<this>");
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        kotlin.jvm.internal.p.h(baseContext, "getBaseContext(...)");
        return a(baseContext);
    }
}
