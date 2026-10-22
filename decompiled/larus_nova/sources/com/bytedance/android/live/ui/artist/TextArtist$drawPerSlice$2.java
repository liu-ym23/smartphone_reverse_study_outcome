package com.bytedance.android.live.ui.artist;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"drawNormalLine", "", "lineIndex", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TextArtist$drawPerSlice$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ TextArtist$drawPerSlice$1 $drawSlice$1;
    final /* synthetic */ TextArtist this$0;

    public TextArtist$drawPerSlice$2(TextArtist r100, TextArtist$drawPerSlice$1 r101) {
        this.this$0 = r100;
        this.$drawSlice$1 = r101;
        super(1);
    }

    public final void invoke(int r100) {
        IntRange r101 = (IntRange) ListProtector.get(this.this$0.f102038u, r100);
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        if (r102 > r103) goto L7;
    L4:
        this.$drawSlice$1.invoke(r102);
        if (r102 == r103) goto L9;
        r102 = r102 + 1;
        goto L4
    L9:
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
