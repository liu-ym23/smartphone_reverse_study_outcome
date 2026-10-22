package com.bytedance.android.shopping.anchorv3.detail.widget.transwidget;

import androidx.core.view.ViewCompat;
import com.bytedance.android.shopping.anchorv3.matchpurchase.view.FloatingTagLayout;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/anchorv3/matchpurchase/view/FloatingTagLayout;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ImageHolder$mCombinationView$2 extends Lambda implements Function0<FloatingTagLayout> {
    final /* synthetic */ b this$0;

    public ImageHolder$mCombinationView$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final FloatingTagLayout invoke() {
        return (FloatingTagLayout) ViewCompat.requireViewById(this.this$0.b(), R.id.float_tags_layer);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ FloatingTagLayout invoke() {
        return invoke();
    }
}
