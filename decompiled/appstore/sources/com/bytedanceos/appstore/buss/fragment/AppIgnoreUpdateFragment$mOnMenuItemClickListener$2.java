package com.bytedanceos.appstore.buss.fragment;

import android.os.Bundle;
import com.bytedanceos.common.utils.BytedanceMenuHelper;
import com.obric.oui.popover.OPopover;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedanceos/common/utils/BytedanceMenuHelper$OUIMenuItem$OnMenuItemClickListener;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
public final class AppIgnoreUpdateFragment$mOnMenuItemClickListener$2 extends Lambda implements Function0<BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener> {
    final /* synthetic */ AppIgnoreUpdateFragment this$0;

    public AppIgnoreUpdateFragment$mOnMenuItemClickListener$2(AppIgnoreUpdateFragment r10) {
        this.this$0 = r10;
        super(0);
    }

    public static /* synthetic */ boolean a(AppIgnoreUpdateFragment r10, BytedanceMenuHelper.OUIMenuItem r11) {
        return invoke$lambda$0(r10, r11);
    }

    private static final boolean invoke$lambda$0(AppIgnoreUpdateFragment r10, BytedanceMenuHelper.OUIMenuItem r11) {
        kotlin.jvm.internal.q.g(r10, "this$0");
        AppIgnoreUpdateFragment.K(r10).h(AppIgnoreUpdateFragment.H(r10));
        OPopover r12 = AppIgnoreUpdateFragment.J(r10);
        if (r12 == null) goto L5;
        r12.dismiss();
    L5:
        Bundle r13 = new Bundle();
        r13.putString("long_click_operation", "cancle_ignore_update");
        f9.b.b("click_longpress_appmanager", r13);
        return true;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final BytedanceMenuHelper.OUIMenuItem.OnMenuItemClickListener invoke() {
        final AppIgnoreUpdateFragment r10 = this.this$0;
        return new r(r10);
    }
}
