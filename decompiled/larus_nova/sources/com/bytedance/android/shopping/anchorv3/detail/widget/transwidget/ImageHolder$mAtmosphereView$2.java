package com.bytedance.android.shopping.anchorv3.detail.widget.transwidget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ImageHolder$mAtmosphereView$2 extends Lambda implements Function0<SimpleDraweeView> {
    final /* synthetic */ b this$0;

    public ImageHolder$mAtmosphereView$2(b r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final SimpleDraweeView invoke() {
        return (SimpleDraweeView) this.this$0.b().findViewById(R.id.atmosphere_image);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ SimpleDraweeView invoke() {
        return invoke();
    }
}
