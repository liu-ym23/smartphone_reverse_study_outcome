package com.stepos.agentframework.display;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroid/view/View;", Parameters.ROOT, LinkHeader.Parameters.Anchor, "Lkotlin/Triple;", "Lcom/stepos/agentframework/display/DisplayWindowHost;", "Landroid/app/Activity;", "", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;Landroid/view/View;)Lkotlin/Triple;", "Landroid/content/Context;", "context", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static final Triple<DisplayWindowHost, Activity, Integer> b(View root, View anchor) {
        p.i(root, "root");
        p.i(anchor, "anchor");
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return new Triple<>(DisplayWindowHost.NONE, null, -1);
        }
        int i10 = layoutParams2.type;
        if (i10 != 1) {
            return new Triple<>(DisplayWindowHost.OVERLAY, null, Integer.valueOf(i10));
        }
        Activity activityA = a(anchor.getContext());
        if (activityA == null) {
            View viewFindViewById = root.findViewById(R.id.content);
            activityA = a(viewFindViewById != null ? viewFindViewById.getContext() : null);
            if (activityA == null) {
                activityA = a(root.getContext());
            }
        }
        return new Triple<>(DisplayWindowHost.ACTIVITY, activityA, Integer.valueOf(layoutParams2.type));
    }
}
