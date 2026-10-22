package com.bytedance.android.shopping.deepfeed;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/MotionEvent;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class DeepFeedProductFragment$initView$1$1 extends FunctionReferenceImpl implements Function1<MotionEvent, Unit> {
    public DeepFeedProductFragment$initView$1$1(com.bytedance.android.shopping.deepfeed.event.a r100) {
        super(1, r100, com.bytedance.android.shopping.deepfeed.event.a.class, "onTouchEvent", "onTouchEvent(Landroid/view/MotionEvent;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "p1");
        com.bytedance.android.shopping.deepfeed.event.a r100 = (com.bytedance.android.shopping.deepfeed.event.a) this.receiver;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "event");
        com.bytedance.android.shopping.deepfeed.event.a.d r101 = r100.f173298c;
        if (r101 != null) goto L5;
    L9:
        int r102 = r110.getActionMasked();
        if (r102 == 0) goto L22;
        if (r102 != 1) goto L13;
        r100.d(r110);
        return;
    L13:
        if (r102 != 2) goto L15;
        VelocityTracker r103 = r100.f173299d;
        if (r103 == null) goto L36;
        r103.addMovement(r110);
        return;
    L36:
        return;
    L15:
        if (r102 != 3) goto L39;
        r100.d(r110);
        return;
    L39:
        return;
    L22:
        com.bytedance.android.shopping.deepfeed.event.a.e r104 = r100.f173301f;
        if (r104 != null) goto L25;
    L26:
        r100.f173301f = null;
    L27:
        r100.a(null);
        r100.b();
        VelocityTracker r105 = r100.f173299d;
        if (r105 == null) goto L30;
        r105.recycle();
    L30:
        r100.f173299d = null;
        r100.f173298c = null;
        com.bytedance.android.shopping.deepfeed.event.a.c r106 = r100.f173308m.invoke(Float.valueOf(r110.getX()), Float.valueOf(r110.getY()));
        if (r106 == null) goto L40;
        long r107 = r100.f173296a + 1;
        r100.f173296a = r107;
        r100.f173298c = new com.bytedance.android.shopping.deepfeed.event.a.d(r107, r106.f173320a, r106.f173321b, r106.f173322c, System.currentTimeMillis(), r110.getX(), r110.getY());
        VelocityTracker r108 = VelocityTracker.obtain();
        r108.addMovement(r110);
        Unit r111 = Unit.INSTANCE;
        r100.f173299d = r108;
        return;
    L40:
        return;
    L25:
        if (r104.f173343g == true) goto L27;
    L5:
        if (r101.f173335m == true) goto L9;
        if (r110.getActionMasked() == 0) goto L9;
        r101.f173331i = r110.getX();
        r101.f173332j = r110.getY();
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(MotionEvent r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
