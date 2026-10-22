package com.bytedance.android.shopping.anchorv4.voavhs.base.elements;

import android.content.Context;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/View;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MediaBoxElementView$maskView$2 extends Lambda implements Function0<View> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MediaBoxElementView this$0;

    public MediaBoxElementView$maskView$2(MediaBoxElementView r100, Context r101) {
        this.this$0 = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View r100 = new View(this.$context);
        ViewCompat.setBackground(r100, com.bytedance.commerce.base.drawable.a.a(new MediaBoxElementView$maskView$2$$special$$inlined$apply$lambda$1(this)));
        r100.setVisibility(4);
        return r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }
}
