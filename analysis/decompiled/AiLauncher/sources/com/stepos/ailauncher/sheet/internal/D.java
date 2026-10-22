package com.stepos.ailauncher.sheet.internal;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.container.glass.SheetGlassStyle;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJE\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/D;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "LY8/t;", "c", "(Landroid/app/Activity;)V", "Landroid/view/View;", "panel", "", "cornerRadiusDp", "Lcom/stepos/ailauncher/container/glass/SheetGlassStyle;", "sheetStyle", "Lkotlin/Pair;", "", "sheetLook", "Ly7/E;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;FLcom/stepos/ailauncher/container/glass/SheetGlassStyle;Lkotlin/Pair;)Ly7/E;", "handle", "e", "(Ly7/E;)V", Const.INTENT_KEY_UMID, "(Landroid/view/View;F)V", "", "TAG", "Ljava/lang/String;", "DEFAULT_CORNER_RADIUS_DP", "F", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class D {
    public static final float DEFAULT_CORNER_RADIUS_DP = 28.0f;
    public static final D INSTANCE = new D();
    private static final String TAG = "SheetGlass";

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ y7.E b(D d10, View view, float f10, SheetGlassStyle sheetGlassStyle, Pair pair, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 28.0f;
        }
        if ((i10 & 4) != 0) {
            sheetGlassStyle = null;
        }
        if ((i10 & 8) != 0) {
            pair = null;
        }
        return d10.a(view, f10, sheetGlassStyle, pair);
    }

    public final y7.E a(View panel, float cornerRadiusDp, SheetGlassStyle sheetStyle, Pair<Integer, Float> sheetLook) {
        View view;
        y7.E eY;
        kotlin.jvm.internal.p.i(panel, "panel");
        d(panel, cornerRadiusDp);
        if (sheetLook != null) {
            eY = com.stepos.ailauncher.container.glass.h.INSTANCE.x(panel, sheetLook.e().intValue(), sheetLook.f().floatValue(), true, Float.valueOf(cornerRadiusDp));
            view = panel;
        } else {
            view = panel;
            eY = sheetStyle != null ? com.stepos.ailauncher.container.glass.h.INSTANCE.y(view, sheetStyle, true, Float.valueOf(cornerRadiusDp)) : com.stepos.ailauncher.container.glass.h.m(com.stepos.ailauncher.container.glass.h.INSTANCE, view, true, Float.valueOf(cornerRadiusDp), null, false, 24, null);
        }
        if (eY == null) {
            if (sheetStyle == SheetGlassStyle.FULL) {
                view.setBackgroundColor(-15066598);
            }
            Log.i(TAG, "attachPanelGlass degraded, sheetStyle=" + sheetStyle);
            return null;
        }
        Log.d(TAG, "attachPanelGlass activeCount=" + eY.c() + " ids=" + eY.d());
        return eY;
    }

    public final void c(Activity activity) {
        kotlin.jvm.internal.p.i(activity, "activity");
        Window window = activity.getWindow();
        try {
            window.setBackgroundBlurRadius(0);
        } catch (Throwable unused) {
        }
        try {
            window.getClass().getMethod("setCrossWindowBlurEnabled", Boolean.TYPE).invoke(window, Boolean.FALSE);
        } catch (Throwable unused2) {
        }
        window.clearFlags(Integer.MIN_VALUE);
        window.addFlags(Integer.MIN_VALUE);
    }

    public final void d(View panel, float cornerRadiusDp) {
        kotlin.jvm.internal.p.i(panel, "panel");
        com.stepos.ailauncher.container.glass.h.INSTANCE.k(panel, cornerRadiusDp);
    }

    public final void e(y7.E handle) {
        com.stepos.ailauncher.container.glass.h.INSTANCE.F(handle);
    }
}
