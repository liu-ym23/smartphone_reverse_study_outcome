package com.stepos.ailauncher.sheet.nav;

import Y8.t;
import Z8.F;
import android.view.View;
import androidx.dynamicanimation.animation.e;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ailauncher.sheet.SheetSpring;
import com.stepos.ailauncher.sheet.h0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$IntRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003JM\u0010\u000f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u000b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018JA\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\t2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010)\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/ailauncher/sheet/nav/p;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroid/view/View;", "oldView", "newView", "", "widthPx", "Lkotlin/Function1;", "onOldSettled", "Lkotlin/Function0;", "onSettled", "n", "(Landroid/view/View;Landroid/view/View;ILp9/l;Lp9/a;)V", "topView", "underView", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;Landroid/view/View;ILp9/a;)V", "view", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;I)F", "Landroidx/dynamicanimation/animation/e$s;", "property", "target", "gen", "onEnd", "r", "(Landroid/view/View;Landroidx/dynamicanimation/animation/e$s;FILp9/a;)V", "Lcom/stepos/ailauncher/sheet/g0;", "SPRING", "Lcom/stepos/ailauncher/sheet/g0;", "PARENT_TRAVEL_FRACTION", "F", HomeGestureEligibilityContract.EXTRA_GENERATION, "I", "", "Landroidx/dynamicanimation/animation/e;", "running", "Ljava/util/List;", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class p {
    private static final float PARENT_TRAVEL_FRACTION = 0.7f;
    private static int generation;
    public static final p INSTANCE = new p();
    private static final SheetSpring SPRING = SheetSpring.Companion.b(SheetSpring.INSTANCE, 180.0f, 24.0f, 0.0f, 4, null);
    private static final List<androidx.dynamicanimation.animation.e<?>> running = new ArrayList();

    public static final t k(Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a) {
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 == 0) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final t l(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return t.f7040a;
    }

    public static final t m(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return t.f7040a;
    }

    public static final t o(Ref$IntRef ref$IntRef, InterfaceC5063a interfaceC5063a) {
        int i10 = ref$IntRef.f34818a - 1;
        ref$IntRef.f34818a = i10;
        if (i10 == 0 && interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return t.f7040a;
    }

    public static final t p(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return t.f7040a;
    }

    public static final t q(View view, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a) {
        view.setTranslationX(0.0f);
        interfaceC5074l.invoke(view);
        interfaceC5063a.invoke();
        return t.f7040a;
    }

    public static final void s(int i10, InterfaceC5063a interfaceC5063a, androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
        running.remove(eVar);
        if (i10 != generation || interfaceC5063a == null) {
            return;
        }
        interfaceC5063a.invoke();
    }

    public final void h() {
        generation++;
        List<androidx.dynamicanimation.animation.e<?>> list = running;
        List listM1 = F.m1(list);
        list.clear();
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((androidx.dynamicanimation.animation.e) it.next()).d();
        }
    }

    public final float i(View view, int widthPx) {
        if (widthPx <= 0) {
            widthPx = view.getResources().getDisplayMetrics().widthPixels;
        }
        return widthPx;
    }

    public final void j(View topView, View underView, int widthPx, final InterfaceC5063a<t> onSettled) {
        kotlin.jvm.internal.p.i(topView, "topView");
        kotlin.jvm.internal.p.i(underView, "underView");
        kotlin.jvm.internal.p.i(onSettled, "onSettled");
        h();
        int i10 = generation;
        float fI = i(topView, widthPx);
        underView.setVisibility(0);
        if (underView.getTranslationX() == 0.0f) {
            underView.setTranslationX((-fI) * 0.7f);
        }
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = 2;
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.i
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.k(ref$IntRef, onSettled);
            }
        };
        e.s TRANSLATION_X = androidx.dynamicanimation.animation.e.f13690n;
        kotlin.jvm.internal.p.h(TRANSLATION_X, "TRANSLATION_X");
        r(topView, TRANSLATION_X, fI, i10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.l(interfaceC5063a);
            }
        });
        kotlin.jvm.internal.p.h(TRANSLATION_X, "TRANSLATION_X");
        r(underView, TRANSLATION_X, 0.0f, i10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.m(interfaceC5063a);
            }
        });
    }

    public final void n(final View oldView, View newView, int widthPx, final InterfaceC5074l<? super View, t> onOldSettled, final InterfaceC5063a<t> onSettled) {
        kotlin.jvm.internal.p.i(newView, "newView");
        kotlin.jvm.internal.p.i(onOldSettled, "onOldSettled");
        h();
        int i10 = generation;
        float fI = i(newView, widthPx);
        newView.setTranslationX(fI);
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = oldView != null ? 2 : 1;
        final InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.o(ref$IntRef, onSettled);
            }
        };
        e.s TRANSLATION_X = androidx.dynamicanimation.animation.e.f13690n;
        kotlin.jvm.internal.p.h(TRANSLATION_X, "TRANSLATION_X");
        r(newView, TRANSLATION_X, 0.0f, i10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return p.p(interfaceC5063a);
            }
        });
        if (oldView != null) {
            oldView.setVisibility(0);
            kotlin.jvm.internal.p.h(TRANSLATION_X, "TRANSLATION_X");
            r(oldView, TRANSLATION_X, (-fI) * 0.7f, i10, new InterfaceC5063a() { // from class: com.stepos.ailauncher.sheet.nav.o
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return p.q(oldView, onOldSettled, interfaceC5063a);
                }
            });
        }
    }

    public final void r(View view, e.s property, float target, final int gen, final InterfaceC5063a<t> onEnd) {
        androidx.dynamicanimation.animation.i iVar = new androidx.dynamicanimation.animation.i(view, property, target);
        iVar.B(h0.d(SPRING, target));
        iVar.b(new e.q() { // from class: com.stepos.ailauncher.sheet.nav.l
            @Override // androidx.dynamicanimation.animation.e.q
            public final void a(androidx.dynamicanimation.animation.e eVar, boolean z10, float f10, float f11) {
                p.s(gen, onEnd, eVar, z10, f10, f11);
            }
        });
        running.add(iVar);
        iVar.t();
    }
}
