package com.stepos.ailauncher.sheet;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import p9.InterfaceC5063a;
import v9.C5685n;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u001a]\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010\u001a!\u0010\u0011\u001a\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroid/view/View;", "handle", "", "toAlpha", "fromAlpha", "", "visibleWhileAnimating", "Lcom/stepos/ailauncher/sheet/g0;", "spring", "", "reason", "Lkotlin/Function0;", "LY8/t;", "onEnd", "Landroidx/dynamicanimation/animation/i;", "c", "(Landroid/view/View;FLjava/lang/Float;ZLcom/stepos/ailauncher/sheet/g0;Ljava/lang/String;Lp9/a;)Landroidx/dynamicanimation/animation/i;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/view/View;Ljava/lang/String;)V", "", "visibility", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "sheet_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.sheet.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3440h {
    private static final String TAG = "DragHandleAlpha";

    public static final androidx.dynamicanimation.animation.i c(final View view, float f10, Float f11, boolean z10, SheetSpring spring, final String reason, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(spring, "spring");
        kotlin.jvm.internal.p.i(reason, "reason");
        if (view == null) {
            Log.w(TAG, "skip null handle reason=" + reason);
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            return null;
        }
        final float fM = C5685n.m(f10, 0.0f, 1.0f);
        float fM2 = C5685n.m(f11 != null ? f11.floatValue() : view.getAlpha(), 0.0f, 1.0f);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float alpha = view.getAlpha();
        String strH = h(view.getVisibility());
        int width = view.getWidth();
        int height = view.getHeight();
        int i10 = iArr[0];
        int i11 = iArr[1];
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        String strH2 = view2 != null ? h(view2.getVisibility()) : null;
        Log.i(TAG, "start reason=" + reason + " from=" + fM2 + " to=" + fM + " curAlpha=" + alpha + " vis=" + strH + " size=" + width + "x" + height + " screen=(" + i10 + Const.STR_MART_COMMA + i11 + ") parentVis=" + strH2 + " spring={k=" + spring.getStiffness() + ",z=" + spring.getDampingRatio() + "}");
        view.animate().cancel();
        if (z10 && (fM > 0.0f || fM2 > 0.0f)) {
            view.setVisibility(0);
        }
        view.setAlpha(fM2);
        if (Math.abs(fM2 - fM) < 0.001f) {
            view.setAlpha(fM);
            Log.w(TAG, "skip already-at-target reason=" + reason + " alpha=" + fM);
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
            return null;
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, androidx.dynamicanimation.animation.e.f13701y, fM);
        iVar.o(0.00390625f);
        iVar.B(h0.d(spring, fM));
        iVar.q(fM2);
        iVar.c(new e.r() { // from class: com.stepos.ailauncher.sheet.f
            @Override // androidx.dynamicanimation.animation.e.r
            public final void b(androidx.dynamicanimation.animation.e eVar, float f12, float f13) {
                C3440h.e(ref$IntRef, ref$LongRef, reason, view, eVar, f12, f13);
            }
        });
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.sheet.g
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z11, float f12, float f13) {
                C3440h.f(fM, view, reason, ref$IntRef, interfaceC5063a, eVar, z11, f12, f13);
            }
        });
        iVar.t();
        Log.i(TAG, "running reason=" + reason + " isRunning=" + iVar.i());
        return iVar;
    }

    public static /* synthetic */ androidx.dynamicanimation.animation.i d(View view, float f10, Float f11, boolean z10, SheetSpring sheetSpring, String str, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f11 = null;
        }
        if ((i10 & 8) != 0) {
            z10 = true;
        }
        if ((i10 & 16) != 0) {
            sheetSpring = i0.INSTANCE.u();
        }
        if ((i10 & 32) != 0) {
            str = "";
        }
        if ((i10 & 64) != 0) {
            interfaceC5063a = null;
        }
        return c(view, f10, f11, z10, sheetSpring, str, interfaceC5063a);
    }

    public static final void e(Ref$IntRef ref$IntRef, Ref$LongRef ref$LongRef, String str, View view, androidx.dynamicanimation.animation.e eVar, float f10, float f11) {
        ref$IntRef.f34818a++;
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i10 = ref$IntRef.f34818a;
        if (i10 == 1 || jUptimeMillis - ref$LongRef.f34819a >= 50) {
            ref$LongRef.f34819a = jUptimeMillis;
            String str2 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            String str3 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f11)}, 1));
            kotlin.jvm.internal.p.h(str3, "format(...)");
            String str4 = String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(view.getAlpha())}, 1));
            kotlin.jvm.internal.p.h(str4, "format(...)");
            Log.d(TAG, "tick reason=" + str + " frame=" + i10 + " alpha=" + str2 + " v=" + str3 + " viewAlpha=" + str4);
        }
    }

    public static final void f(float f10, View view, String str, Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f11, float f12) {
        if (z10) {
            f10 = C5685n.m(f11, 0.0f, 1.0f);
        }
        view.setAlpha(f10);
        Log.i(TAG, "end reason=" + str + " canceled=" + z10 + " frames=" + ref$IntRef.f34818a + " final=" + f10 + " viewAlpha=" + view.getAlpha() + " vis=" + h(view.getVisibility()));
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void g(View view, String reason) {
        kotlin.jvm.internal.p.i(reason, "reason");
        if (view == null) {
            return;
        }
        view.animate().cancel();
        float alpha = view.getAlpha();
        view.setAlpha(0.34f);
        Log.i(TAG, "snapRest reason=" + reason + " before=" + alpha + " after=" + view.getAlpha());
    }

    public static final String h(int i10) {
        return i10 != 0 ? i10 != 4 ? i10 != 8 ? String.valueOf(i10) : "GONE" : "INVISIBLE" : "VISIBLE";
    }
}
