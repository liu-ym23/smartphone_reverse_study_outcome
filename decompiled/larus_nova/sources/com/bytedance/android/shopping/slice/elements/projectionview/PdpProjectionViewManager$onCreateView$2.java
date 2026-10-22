package com.bytedance.android.shopping.slice.elements.projectionview;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class PdpProjectionViewManager$onCreateView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a $bkgImageView;
    final /* synthetic */ Function1 $drawCallback;
    final /* synthetic */ Ref.ObjectRef $headView;
    final /* synthetic */ PdpProjectionViewManager this$0;

    public PdpProjectionViewManager$onCreateView$2(PdpProjectionViewManager r100, Ref.ObjectRef r101, Function1 r102, a r103) {
        this.this$0 = r100;
        this.$headView = r101;
        this.$drawCallback = r102;
        this.$bkgImageView = r103;
        super(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (PdpProjectionViewManager.K1(this.this$0, (View) this.$headView.element, this.$drawCallback) == null) goto L6;
        this.this$0.getClass();
        this.$bkgImageView.setBackground(new BitmapDrawable(null));
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
