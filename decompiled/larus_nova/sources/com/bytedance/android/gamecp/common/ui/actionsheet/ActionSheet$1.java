package com.bytedance.android.gamecp.common.ui.actionsheet;

import android.app.Dialog;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/app/Dialog;", "view", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ActionSheet$1 extends Lambda implements Function2<Dialog, View, Unit> {
    public static final ActionSheet$1 INSTANCE = null;

    static {
        INSTANCE = new ActionSheet$1();
    }

    public ActionSheet$1() {
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Dialog r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        Intrinsics.checkNotNullParameter(r101, "view");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Dialog r100, View r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
