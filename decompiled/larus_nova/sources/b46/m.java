package b46;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17551a = 0;

    static {
    }

    public static i a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L16
        Object r103 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Throwable -> L16
        if (r103 != null) goto L6;
    L14:
        Resources r104 = r100.getResources();     // Catch: Throwable -> L16
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Throwable -> L16
        return new i(r105.widthPixels, r105.heightPixels);
    L6:
        if ((r103 instanceof WindowManager) == false) goto L8;
        WindowManager r106 = (WindowManager) r103;     // Catch: Throwable -> L16
    L9:
        if (r106 == null) goto L14;
        Display r107 = r106.getDefaultDisplay();     // Catch: Throwable -> L16
        if (r107 == null) goto L14;
        Point r108 = new Point();     // Catch: Throwable -> L16
        r107.getRealSize(r108);     // Catch: Throwable -> L16
        return new i(r108.x, r108.y);
    L8:
        r106 = null;
    L16:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r110) == true) goto L22;
        r101 = r110;
    L22:
        return (i) r101;
    }
}
