package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "LP", "Landroid/view/ViewGroup$LayoutParams;", AbsMethodDelegate.TAG_INVOKE, "(Landroid/view/ViewGroup$LayoutParams;)V"}, k = 3, mv = {1, 4, 3})
public final class STIDebugHelperKt$layout$1 extends Lambda implements Function1 {
    public static final STIDebugHelperKt$layout$1 INSTANCE = null;

    static {
        INSTANCE = new STIDebugHelperKt$layout$1();
    }

    public STIDebugHelperKt$layout$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Object r100) {
        invoke((ViewGroup.LayoutParams) r100);
        return Unit.INSTANCE;
    }

    public final void invoke(ViewGroup.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
    }
}
