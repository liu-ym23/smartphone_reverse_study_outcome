package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class InputFunctionManager$registerBehavior$1 extends FunctionReferenceImpl implements Function2<Boolean, Long, Unit> {
    public InputFunctionManager$registerBehavior$1(b r100) {
        super(2, r100, b.class, "changeStatus", "changeStatus(ZJ)V", 0);
    }

    public final void invoke(final boolean r110, long r111) {
        final b r100 = (b) this.receiver;
        int r101 = b.f135473o;
        r100.getClass();
        AnimatorSet r102 = new AnimatorSet();
        ArrayList r103 = new ArrayList();
        if (r110 == false) goto L5;
        int r104 = Math.min(3, r100.b()) * r100.f135480g;
    L6:
        if (r110 == false) goto L8;
        int r105 = r100.f135481h;
    L9:
        int r106 = 2;
        ValueAnimator r107 = ValueAnimator.ofInt(new int[]{r104, r105});
        r107.setInterpolator(new AccelerateDecelerateInterpolator());
        r107.setDuration(r111);
        r107.addUpdateListener(new d(r107, r100));
        r103.add(r107);
        if (r110 == false) goto L12;
        int r112 = r100.f135482i;
    L13:
        if (r110 == false) goto L15;
        int r113 = 0;
    L16:
        int r114 = r100.f135485l.getChildCount();
        int r115 = 0;
    L17:
        if (r115 >= r114) goto L19;
        View r116 = r100.f135485l.getChildAt(r115);
        int[] r108 = new int[r106];
        r108[0] = r113;
        r108[1] = r112;
        ValueAnimator r109 = ValueAnimator.ofInt(r108);
        r109.setDuration(r111);
        r109.addUpdateListener(new e(r109, r116));
        r103.add(r109);
        r115 = r115 + 1;
        r106 = 2;
        goto L17
    L19:
        com.bytedance.android.live.core.utils.h.b(r107, new InputFunctionManager$changeStatus$1(r100));
        com.bytedance.android.live.core.utils.h.a(r107, new InputFunctionManager$changeStatus$2(r100, r110));
        r102.playTogether(r103);
        r102.start();
        if (r110 == false) goto L22;
        r100.f135487n.setImportantForAccessibility(4);
    L23:
        r100.f135486m.setOnTouchListener(new f(r110));
        return;
    L22:
        r100.f135487n.setImportantForAccessibility(1);
        goto L23
    L15:
        r113 = r100.f135482i;
        goto L16
    L12:
        r112 = 0;
        goto L13
    L8:
        r105 = Math.min(3, r100.b()) * r100.f135480g;
        goto L9
    L5:
        r104 = r100.f135481h;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Long r101) {
        invoke(r100.booleanValue(), r101.longValue());
        return Unit.INSTANCE;
    }
}
