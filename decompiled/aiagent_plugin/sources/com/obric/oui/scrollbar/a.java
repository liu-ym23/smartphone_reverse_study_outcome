package com.obric.oui.scrollbar;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.LinkedHashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ListViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static final String TAG = "ListViewScrollBarHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36130a = null;

    static {
        f36130a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(a r0, ListView r1, float r2) {
        r0.a(r1, r2);
    }

    private final void a(ListView r5, float r6) {
        ListAdapter r0 = r5.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r0.getCount() != 0) goto L9;
        r5.setVerticalScrollBarEnabled(false);
        return;
    L9:
        int r2 = r5.getHeight();
        int r4 = a(r5);
        if (r4 <= 0) goto L13;
        if (r2 <= 0) goto L13;
        float r3 = r4 / r2;
    L15:
        if (r3 <= r6) goto L17;
        r1 = true;
    L17:
        r5.setVerticalScrollBarEnabled(r1);
        a(TAG, "ListView updateScrollBarVisibility, isVerticalScrollBarEnabled: " + r5.isVerticalScrollBarEnabled() + ", contentScreens: " + r3 + ", totalHeight: " + r4 + ", visibleHeight: " + r2);
        return;
    L13:
        r3 = 0.0f;
        goto L15
    }

    private final int a(ListView r11) {
        ListAdapter r10 = r11.getAdapter();
        if (r10 != null) goto L5;
        return 0;
    L5:
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        int r2 = r10.getCount();
        int r4 = 0;
        int r5 = 0;
    L6:
        if (r4 >= r2) goto L11;
        int r6 = r4 + 1;
        int r7 = r10.getItemViewType(r4);
        View r8 = (View) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r7)), View.class, "com.obric.aiagent.plugin");
        View r9 = r10.getView(r4, r8, (ViewGroup) ZeusTransformUtils.preCheckCast(r11, ViewGroup.class, "com.obric.aiagent.plugin"));
        if (r8 != null) goto L10;
        Integer r12 = Integer.valueOf(r7);
        o.c(r9, "view");
        r1.put(r12, r9);
    L10:
        r9.measure(View.MeasureSpec.makeMeasureSpec(r11.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r5 = r5 + r9.getMeasuredHeight();
        r4 = r6;
        goto L6
    L11:
        int r13 = r11.getDividerHeight();
        if (r13 > 0) goto L14;
        return r5;
    L14:
        return r5 + (r13 * (r10.getCount() - 1));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
