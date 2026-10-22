package aq6;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f15909a = 0;

    static {
    }

    public static boolean a(View r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.canScrollVertically(-1) == false) goto L8;
    L11:
        boolean r101 = true;
    L13:
        if (r100.canScrollHorizontally(-1) == false) goto L15;
    L18:
        boolean r102 = true;
    L19:
        if (r101 == true) goto L21;
        if (r102 == true) goto L21;
        return false;
    L21:
        return true;
    L15:
        if (r100.canScrollHorizontally(1) == true) goto L18;
        r102 = false;
        goto L19
    L8:
        if (r100.canScrollVertically(1) == true) goto L11;
        r101 = false;
        goto L13
    }

    public static void b(View r100) {
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        Context r102 = r100.getContext();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = r102.getResources().getIdentifier("status_bar_height", "dimen", "android");
        r101.height = r102.getResources().getDimensionPixelSize(r103);
        return;
    }
}
