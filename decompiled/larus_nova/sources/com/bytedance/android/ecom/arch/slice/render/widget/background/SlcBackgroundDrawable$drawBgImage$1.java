package com.bytedance.android.ecom.arch.slice.render.widget.background;

import com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.SlcImageFetchManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class SlcBackgroundDrawable$drawBgImage$1 extends Lambda implements Function0<String> {
    final /* synthetic */ SlcBackgroundDrawable this$0;

    public SlcBackgroundDrawable$drawBgImage$1(SlcBackgroundDrawable r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        StringBuilder r100 = new StringBuilder("draw bg image failed,callerContext:");
        SlcImageFetchManager r101 = this.this$0.f50866r;
        if (r101 == null) goto L7;
        Object r102 = r101.f50365i;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        r100.append(r103);
        return r100.toString();
    L7:
        r103 = null;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
