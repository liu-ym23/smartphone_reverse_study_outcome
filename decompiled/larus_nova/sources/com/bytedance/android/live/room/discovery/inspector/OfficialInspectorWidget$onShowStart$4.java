package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.view.View;
import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class OfficialInspectorWidget$onShowStart$4 extends FunctionReferenceImpl implements Function1<View, Unit> {
    public OfficialInspectorWidget$onShowStart$4(OfficialInspectorWidget r100) {
        super(1, r100, OfficialInspectorWidget.class, "playClickViewAnimation", "playClickViewAnimation(Landroid/view/View;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View r100) {
        OfficialInspectorWidget r101 = (OfficialInspectorWidget) this.receiver;
        AnimatorSet r102 = r101.f99539i;
        if (r102 != null) goto L5;
    L6:
        AnimatorSet r103 = r101.f99540j;
        if (r103 == null) goto L11;
        if (r103.isRunning() != true) goto L11;
        return;
    L11:
        if (r101.f99535e == true) goto L13;
        return;
    L13:
        if (r101.isViewValid() == false) goto L26;
        TextView r104 = r101.f99533c;
        if (r104 == null) goto L18;
        r104.clearAnimation();
    L18:
        AnimatorSet r105 = r101.f99540j;
        if (r105 == null) goto L25;
        r105.start();
        return;
    L25:
        return;
    L26:
        return;
    L5:
        if (r102.isRunning() != true) goto L6;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
