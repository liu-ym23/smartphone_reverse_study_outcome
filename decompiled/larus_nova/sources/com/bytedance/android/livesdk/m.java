package com.bytedance.android.livesdk;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153482a = 0;

    public static float a() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L7;
        HostLargeFontParam r101 = r100.getHostLargeFontModeParams();
        if (r101 == null) goto L7;
        return r101.getFontScale();
    L7:
        return 1.0f;
    }

    public static float b() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L7;
        HostLargeFontParam r101 = r100.getHostLargeFontModeParams();
        if (r101 == null) goto L7;
        return r101.getViewZoom();
    L7:
        return 1.0f;
    }

    public static boolean c() {
        IMiddleWareHostContext r100 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r100 == null) goto L7;
        HostLargeFontParam r101 = r100.getHostLargeFontModeParams();
        if (r101 == null) goto L7;
        boolean r102 = r101.isViewZoomEnable();
    L8:
        if (r102 == false) goto L18;
        IMiddleWareHostContext r103 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r103 == null) goto L14;
        HostLargeFontParam r104 = r103.getHostLargeFontModeParams();
        if (r104 == null) goto L14;
        boolean r105 = r104.isLargeFontMode();
    L15:
        if (r105 == false) goto L19;
        return true;
    L19:
        return false;
    L14:
        r105 = false;
        goto L15
    L18:
        return false;
    L7:
        r102 = false;
        goto L8
    }

    static {
    }
}
