package c4;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import d3.a0;
import e3.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {
    public static final a a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        a0 r101 = r100.getContainerContext();
        if (r101 == null) goto L21;
        String r102 = r101.getAppletId();
        if (r102 != null) goto L7;
        return null;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        r102 = null;
    L13:
        if (r102 == null) goto L25;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r104 = AppletAppManagerService.a(r102);
        if (r104 == null) goto L23;
        v r105 = r104.h();
        if (r105 != null) goto L20;
        return null;
    L20:
        return (a) r105.f34405i.getValue();
    L23:
        return null;
    L25:
        return null;
    L9:
        r103 = false;
        goto L10
    L21:
        return null;
    }
}
