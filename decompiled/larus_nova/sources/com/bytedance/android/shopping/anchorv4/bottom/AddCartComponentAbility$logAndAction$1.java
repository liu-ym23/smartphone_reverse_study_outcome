package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "confirm", "", "<anonymous parameter 1>", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AddCartComponentAbility$logAndAction$1 extends Lambda implements Function2<Boolean, Boolean, Unit> {
    final /* synthetic */ a this$0;

    public AddCartComponentAbility$logAndAction$1(a r100) {
        this.this$0 = r100;
        super(2);
    }

    public final void invoke(boolean r100, boolean r101) {
        if (r100 == true) goto L6;
        Set<String> r102 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -3, null, null, null, 14);
        return;
    L6:
        throw null;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Boolean r101) {
        invoke(r100.booleanValue(), r101.booleanValue());
        return Unit.INSTANCE;
    }
}
