package com.bytedance.android.shopping.buynow.slice.counter;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import com.bytedance.android.shopping.extensions.k;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<EditText> f171078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f171079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function1<? super Integer, Unit> f171080c;

    public static Integer a() {
        WeakReference<EditText> r100 = f171078a;
        if (r100 == null) goto L9;
        EditText r101 = r100.get();
        if (r101 != null) goto L8;
        return null;
    L8:
        return Integer.valueOf(k.r(r101.getText().toString(), 0));
    L9:
        return null;
    }

    static {
    }

    public static boolean b(Context r100, MotionEvent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "ev");
        WeakReference<EditText> r102 = f171078a;
        if (r102 == null) goto L16;
        EditText r103 = r102.get();
        if (r103 == null) goto L16;
        int[] r104 = new int[2];
        r103.getLocationInWindow(r104);
        int[] r105 = {r104[0], r104[1], r104[0] + r103.getWidth(), r104[1] + r103.getHeight()};
        r103.getWindowToken();
        if (r101.getX() <= r105[0]) goto L16;
        if (r101.getX() >= r105[2]) goto L16;
        if (r101.getY() <= r105[1]) goto L16;
        if (r101.getY() >= r105[3]) goto L16;
        return true;
    L16:
        return false;
    }
}
