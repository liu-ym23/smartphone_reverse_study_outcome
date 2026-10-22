package com.stepos.ailauncher.sheet;

import android.content.res.Resources;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/sheet/g0;", "", "finalPosition", "Landroidx/dynamicanimation/animation/j;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/sheet/g0;F)Landroidx/dynamicanimation/animation/j;", ConstConfig.KEY_VIEW_SCALE_PROPERTY, "c", "(F)F", "Landroid/content/res/Resources;", "resources", "extraDp", Const.INTENT_KEY_APIKEY, "(Landroid/content/res/Resources;F)F", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h0 {
    public static final float a(Resources resources, float f10) {
        kotlin.jvm.internal.p.i(resources, "resources");
        return resources.getDimension(R$dimen.ail_nav_handle_height) + (resources.getDisplayMetrics().density * f10);
    }

    public static /* synthetic */ float b(Resources resources, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.85f;
        }
        return a(resources, f10);
    }

    public static final float c(float f10) {
        return (C5685n.m((1.0f - f10) / 0.050000012f, 0.0f, 1.0f) * (-0.09803921f)) + 1.0f;
    }

    public static final androidx.dynamicanimation.animation.j d(SheetSpring sheetSpring, float f10) {
        kotlin.jvm.internal.p.i(sheetSpring, "<this>");
        androidx.dynamicanimation.animation.j jVarF = new androidx.dynamicanimation.animation.j(f10).h(sheetSpring.getStiffness()).f(sheetSpring.getDampingRatio());
        kotlin.jvm.internal.p.h(jVarF, "setDampingRatio(...)");
        return jVarF;
    }
}
