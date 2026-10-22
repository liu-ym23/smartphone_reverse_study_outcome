package com.stepos.ailauncher.chat.panelui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2735f;
import com.stepos.ailauncher.contract.api.homegesture.HomeRootToken;
import com.stepos.ailauncher.contract.api.homegesture.IHomeGestureCoordinator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011*\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/d;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/panelui/e;", "layer", "LY8/t;", "c", "(Lcom/stepos/ailauncher/chat/panelui/e;)V", "", "layerId", "e", "(Ljava/lang/String;)V", "ownerKey", "Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", Const.INTENT_KEY_UMID, "(Ljava/lang/Object;)Lcom/stepos/ailauncher/contract/api/homegesture/HomeRootToken;", "Landroid/app/Activity;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Landroid/app/Activity;", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)Landroid/app/Activity;", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final d INSTANCE = new d();
    private static final String TAG = "HomePopupRegistrar";

    public final Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final Activity b(Object ownerKey) {
        if (ownerKey instanceof Activity) {
            return (Activity) ownerKey;
        }
        if (!(ownerKey instanceof View)) {
            return null;
        }
        Context context = ((View) ownerKey).getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return a(context);
    }

    public final void c(e layer) {
        kotlin.jvm.internal.p.i(layer, "layer");
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator == null) {
            return;
        }
        iHomeGestureCoordinator.registerPopup(new h(layer, d(layer.a())));
    }

    public final HomeRootToken d(Object ownerKey) {
        Context context;
        Activity activityB = b(ownerKey);
        if (activityB != null) {
            return C2735f.INSTANCE.c(activityB);
        }
        C2735f c2735f = C2735f.INSTANCE;
        View view = ownerKey instanceof View ? (View) ownerKey : null;
        return (view == null || (context = view.getContext()) == null) ? HomeRootToken.DESKTOP : c2735f.c(context);
    }

    public final void e(String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        IHomeGestureCoordinator iHomeGestureCoordinator = (IHomeGestureCoordinator) D5.a.INSTANCE.a(IHomeGestureCoordinator.class);
        if (iHomeGestureCoordinator != null) {
            iHomeGestureCoordinator.unregisterPopup(layerId);
        }
    }
}
