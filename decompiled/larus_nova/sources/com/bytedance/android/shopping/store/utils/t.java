package com.bytedance.android.shopping.store.utils;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class t {
    public static final void a(View r100, Map<String, ? extends Object> r101, boolean r102, Set<String> r103, q r104, PageFinder r110, Function2<? super Map<String, String>, ? super Integer, Unit> r111, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "pageFinder");
        Intrinsics.checkNotNullParameter(r112, "reportShow");
        u r105 = v.a(r101, null);
        int r106 = r105.f186976a;
        String r107 = r105.f186977b;
        String r108 = r105.f186982g;
        if (r102 == false) goto L5;
        return;
    L5:
        if (r103 != null) goto L7;
    L9:
        if (r111 == null) goto L11;
        Unit r109 = r111.invoke(r105.f186980e, Integer.valueOf(r106));
    L11:
        Set<String> r113 = s.f186965a;
        Map<String, String> r114 = r105.f186980e;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "btm");
        Intrinsics.checkNotNullParameter(r110, "pageFinder");
        r112.invoke(r107 + "_i" + r106, r108, s.a(r114, r104, r107, r106, r110));
        if (r103 == null) goto L15;
        r103.add(r108);
        return;
    L15:
        return;
    L7:
        if (r103.contains(r108) != true) goto L9;
    }
}
