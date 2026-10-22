package com.stepos.agentframework.uikit;

import android.view.View;
import android.view.ViewParent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", "uikit_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class h0 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(View view) {
        kotlin.jvm.internal.p.i(view, "<this>");
        View view2 = view;
        while (view2 != 0) {
            if (view2 instanceof g0) {
                ((g0) view2).a();
                return;
            } else {
                Object parent = view2.getParent();
                view2 = parent instanceof View ? (View) parent : 0;
            }
        }
        ViewParent parent2 = view.getParent();
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(false);
        }
    }
}
