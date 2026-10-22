package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f160005a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f160006b = false;

    static {
        f160005a = (int) s1.e(260.0f);
        f160006b = j40.a0.f497164a.getValue().b();
    }

    public static boolean a(DataCenter r100) {
        if (r100 == null) goto L9;
        IRoom r101 = lu2.c.f(r100);
        if (r101 == null) goto L9;
        if (r101.isMergeVSRoom() == true) goto L9;
        boolean r102 = true;
    L10:
        StringBuilder r103 = new StringBuilder("isUgcMultiTabEnable isUgc = ");
        r103.append(r102);
        r103.append("   ugcMultiTabEnable = ");
        boolean r104 = f160006b;
        r103.append(r104);
        r103.append(' ');
        ALogger.i("MultiTabUgcHelper", r103.toString());
        if (r102 == false) goto L15;
        if (r104 == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    L9:
        r102 = false;
        goto L10
    }
}
