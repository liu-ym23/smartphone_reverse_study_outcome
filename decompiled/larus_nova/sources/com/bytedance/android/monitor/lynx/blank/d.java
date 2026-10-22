package com.bytedance.android.monitor.lynx.blank;

import com.lynx.tasm.LynxView;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<LynxView, a> f162868a = null;

    public d() {
    }

    static {
        f162868a = new WeakHashMap();
    }

    public static void a(LynxView r100, a.C2488a r101) {
        a r102 = (a) ((WeakHashMap) f162868a).get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f162845f != null) goto L7;
        r102.f162845f = new ArrayList();
    L7:
        ((ArrayList) r102.f162845f).add(r101);
    }
}
