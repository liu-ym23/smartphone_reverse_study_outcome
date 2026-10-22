package com.bytedance.applet.impl;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.applet.jsb.AppletSendOutputMethod;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f191882a = 0;

    static {
    }

    public static void a(AppletSendOutputMethod r100, dx7.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "params");
        h16.e r102 = (h16.e) r100.e(h16.e.class);
        if (r102 == null) goto L7;
        com.bytedance.ies.bullet.service.base.o r103 = r102.getKitView();
        if (r103 == null) goto L7;
        View r104 = r103.realView();
    L9:
        if ((r104 instanceof WebView) == false) goto L11;
        WebView r105 = (WebView) r104;
    L12:
        if (r105 != null) goto L14;
        return;
    L14:
        String r106 = r101.getString("message");
        AppletRuntimeManager.INSTANCE.getClass();
        k2.i r107 = AppletRuntimeManager.d(r105);
        if (Intrinsics.areEqual(r101.getString("type"), AppletSendOutputMethod.SupportedOutputType.Tips.getTypeName()) == false) goto L18;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AppletBridgeFlavorDelegate$sendOutput$1(r107, r106, null), 3, null);
        return;
    L18:
        return;
    L11:
        r105 = null;
    L7:
        r104 = null;
        goto L9
    }
}
