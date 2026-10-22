package com.bytedance.android.shopping.anchorv3.detail.widget;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/anchorv3/detail/widget/VideoImageSquareViewPager$initWithData$1$1$1", "com/bytedance/android/shopping/anchorv3/detail/widget/VideoImageSquareViewPager$$special$$inlined$apply$lambda$1"}, k = 3, mv = {1, 4, 3})
final class VideoImageSquareViewPager$initWithData$$inlined$map$lambda$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List $groupImages$inlined;
    final /* synthetic */ fj.d $video$inlined;
    final /* synthetic */ VideoImageSquareViewPager this$0;

    public VideoImageSquareViewPager$initWithData$$inlined$map$lambda$1(fj.d r100, VideoImageSquareViewPager r101, List r102) {
        this.$video$inlined = r100;
        this.this$0 = r101;
        this.$groupImages$inlined = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        VideoImageSquareViewPager r100 = this.this$0;
        Function1<? super Integer, Unit> r101 = r100.f164891a;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(Integer.valueOf(r100.getCurrentItem()));
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
