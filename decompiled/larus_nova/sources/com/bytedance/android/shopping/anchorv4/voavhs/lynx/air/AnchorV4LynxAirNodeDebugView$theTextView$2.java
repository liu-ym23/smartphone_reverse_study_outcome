package com.bytedance.android.shopping.anchorv4.voavhs.lynx.air;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AnchorV4LynxAirNodeDebugView$theTextView$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ Context $context;

    public AnchorV4LynxAirNodeDebugView$theTextView$2(Context r100) {
        this.$context = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TextView invoke() {
        return new TextView(this.$context);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ TextView invoke() {
        return invoke();
    }
}
