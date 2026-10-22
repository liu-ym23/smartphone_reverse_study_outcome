package com.bytedance.android.live.ui.artist;

import android.graphics.Canvas;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"drawEllipsis", "", "x", "", "y", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TextArtist$drawPerSlice$3 extends Lambda implements Function2<Float, Float, Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ TextArtist this$0;

    public TextArtist$drawPerSlice$3(TextArtist r100, Canvas r101) {
        this.this$0 = r100;
        this.$canvas = r101;
        super(2);
    }

    public final void invoke(float r100, float r101) {
        this.$canvas.save();
        this.$canvas.translate(r100, r101);
        TextArtist r102 = this.this$0;
        TextArtist r103 = r102.E;
        if (r103 == null) goto L5;
        Canvas r104 = this.$canvas;
        int r105 = (int) r102.F.width();
        this.this$0.F.height();
        r103.b(r104, r105);
    L5:
        this.$canvas.restore();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Float r100, Float r101) {
        invoke(r100.floatValue(), r101.floatValue());
        return Unit.INSTANCE;
    }
}
