package com.bytedance.android.live.browser.utils;

import android.view.View;
import com.bytedance.android.live.core.setting.q0;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f64310a = 0;

    static {
    }

    public static void a(CallContext r100) {
        if (q0.f65388a.getValue().intValue() < 1) goto L9;
        if (r100 == null) goto L10;
        View r101 = r100.f249269d;
        if (r101 == null) goto L11;
        r101.setTag(R.id.listeners_msg_method, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void c(View r100) {
        if (q0.f65388a.getValue().intValue() < 1) goto L16;
        Object r101 = r100.getTag(R.id.listeners_msg_method);
        if ((r101 instanceof LinkedHashSet) == true) goto L7;
        r101 = null;
    L7:
        LinkedHashSet r102 = (LinkedHashSet) r101;
        if (r102 == null) goto L13;
        Iterator r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        ((com.bytedance.android.live.browser.jsbridge.e) r103.next()).onClean();
    L13:
        r100.setTag(R.id.listeners_msg, null);
        return;
    }

    public static void b(CallContext r100, com.bytedance.android.live.browser.jsbridge.e r101) {
        Intrinsics.checkNotNullParameter(r101, "jsbMethod");
        if (q0.f65388a.getValue().intValue() < 1) goto L15;
        if (r100 == null) goto L16;
        View r102 = r100.f249269d;
        if (r102 == null) goto L17;
        Object r103 = r102.getTag(R.id.listeners_msg_method);
        if ((r103 instanceof LinkedHashSet) == true) goto L10;
        r103 = null;
    L10:
        LinkedHashSet r104 = (LinkedHashSet) r103;
        if (r104 != null) goto L13;
        r104 = new LinkedHashSet();
        r102.setTag(R.id.listeners_msg_method, r104);
    L13:
        r104.add(r101);
        return;
    L17:
        return;
    L16:
        return;
    }
}
