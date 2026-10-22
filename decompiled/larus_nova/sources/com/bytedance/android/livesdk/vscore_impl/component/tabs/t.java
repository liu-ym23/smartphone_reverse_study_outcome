package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, s> f160003a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f160004b = null;

    public t() {
    }

    static {
        f160004b = new t();
        f160003a = new LinkedHashMap();
    }

    public final s a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        int r101 = r100.hashCode();
        Map<Integer, s> r102 = f160003a;
        Integer r103 = Integer.valueOf(r101);
        LinkedHashMap r104 = (LinkedHashMap) r102;
        Object r105 = r104.get(r103);
        if (r105 != null) goto L6;
        r105 = new s();
        r104.put(r103, r105);
    L6:
        return (s) r105;
    }

    public final void b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        int r101 = r100.hashCode();
        f160003a.remove(Integer.valueOf(r101));
    }
}
