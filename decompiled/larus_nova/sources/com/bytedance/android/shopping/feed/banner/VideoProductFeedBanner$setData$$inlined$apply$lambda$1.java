package com.bytedance.android.shopping.feed.banner;

import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", TeaEventTrack.ACTION_DRAMA_NEXT, "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/shopping/feed/banner/VideoProductFeedBanner$setData$3$1"}, k = 3, mv = {1, 4, 3})
final class VideoProductFeedBanner$setData$$inlined$apply$lambda$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ List $list$inlined;
    final /* synthetic */ VideoProductFeedBanner this$0;

    public VideoProductFeedBanner$setData$$inlined$apply$lambda$1(VideoProductFeedBanner r100, List r101) {
        this.this$0 = r100;
        this.$list$inlined = r101;
        super(1);
    }

    public final void invoke(boolean r100) {
        if (r100 == false) goto L6;
        this.this$0.getViewPager().scrollToPosition(this.this$0.getCurPagePos() + 1);
    L8:
        VideoProductFeedBanner r101 = this.this$0;
        if (r101.f174404o == false) goto L11;
        r101.f174404o = false;
    L11:
        r101.f174401l.getClass();
        return;
    L6:
        if (this.this$0.getCurPagePos() < 1) goto L8;
        this.this$0.getViewPager().scrollToPosition(this.this$0.getCurPagePos() - 1);
        goto L8
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
