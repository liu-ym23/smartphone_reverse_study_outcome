package com.bytedance.android.anniex.container.popup;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.lynx.tasm.LynxView;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AnnieXLynxViewNestedScrollUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40405a = 0;

    static {
    }

    public static void b(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        final View r101 = a(r100, AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$vp$1.INSTANCE);
        boolean r102 = r101 instanceof ViewPager;
        if (r102 == false) goto L11;
        final ArrayList r103 = new ArrayList();
        if (r102 == false) goto L7;
        ViewPager r104 = (ViewPager) r101;
    L8:
        if (r104 == null) goto L12;
        r104.addOnPageChangeListener(new AnnieXLynxViewNestedScrollUtil$handleNestedScrollWithVp$1(r103, r101));
        return;
    L12:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public static View a(View r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if (((Boolean) r101.invoke(r100)).booleanValue() == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        View r105 = a(r102.getChildAt(r104), r101);
        if (r105 != null) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return r105;
    L14:
        return null;
    }
}
