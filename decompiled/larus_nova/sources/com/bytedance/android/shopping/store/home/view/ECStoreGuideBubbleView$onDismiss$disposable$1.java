package com.bytedance.android.shopping.store.home.view;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECStoreGuideBubbleView$onDismiss$disposable$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $action;
    final /* synthetic */ h this$0;

    public ECStoreGuideBubbleView$onDismiss$disposable$1(h r100, Function0 r101) {
        this.$action = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        INVOKEVIRTUAL_com_bytedance_android_shopping_store_home_view_ECStoreGuideBubbleView$onDismiss$disposable$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(null);
        Function0 r100 = this.$action;
        if (r100 == null) goto L6;
        Unit r101 = (Unit) r100.invoke();
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    public static void INVOKEVIRTUAL_com_bytedance_android_shopping_store_home_view_ECStoreGuideBubbleView$onDismiss$disposable$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(h r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        throw null;
    }
}
