package com.bytedance.android.live.ui.artist;

import android.graphics.Canvas;
import android.text.style.CharacterStyle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"drawSlice", "", "sliceIndex", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class TextArtist$drawPerSlice$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Canvas $canvas;
    final /* synthetic */ Ref.IntRef $charIndex;
    final /* synthetic */ float $offsetY;
    final /* synthetic */ Ref.ObjectRef $rocketClickableSpanRange;
    final /* synthetic */ Ref.IntRef $rocketClickableSpanRangeIndex;
    final /* synthetic */ TextArtist this$0;

    public TextArtist$drawPerSlice$1(TextArtist r100, float r101, Canvas r102, Ref.IntRef r103, Ref.ObjectRef r104, Ref.IntRef r105) {
        this.this$0 = r100;
        this.$offsetY = r101;
        this.$canvas = r102;
        this.$charIndex = r103;
        this.$rocketClickableSpanRange = r104;
        this.$rocketClickableSpanRangeIndex = r105;
        super(1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void invoke(int r110) {
        Object r100 = ListProtector.get(this.this$0.f102020c, r110);
        TextArtist r101 = this.this$0;
        float r102 = r101.f102036s[r110];
        float r111 = r101.f102037t[r110];
        if ((r100 instanceof d) == false) goto L5;
        float r103 = this.$offsetY + r111;
        d r104 = (d) r100;
        r104.f102049c.draw(this.$canvas, r104.f102047a, r104.f102048b.getFirst(), r104.f102048b.getFirst() + r104.f102047a.length(), r102, (int) Math.max(0.0f, r111 - r103), (int) r111, (int) r103, this.this$0.M);
        TextArtist r112 = this.this$0;
        r112.M.getFontMetricsInt(r112.H);
        TextArtist r113 = this.this$0;
        r113.M.f102051a = r113.H;
        this.$charIndex.element += r104.f102047a.length();
    L17:
        int r114 = this.$charIndex.element;
        IntRange r105 = (IntRange) this.$rocketClickableSpanRange.element;
        if (r105 == null) goto L20;
        int r106 = r105.getEndInclusive().intValue();
    L21:
        if (r114 <= r106) goto L28;
        this.$rocketClickableSpanRangeIndex.element++;
        Ref.ObjectRef r115 = this.$rocketClickableSpanRange;
        int r107 = this.this$0.f102024g.size();
        int r108 = this.$rocketClickableSpanRangeIndex.element;
        if (r107 <= r108) goto L25;
        T r109 = (IntRange) ListProtector.get(this.this$0.f102024g, r108);
    L26:
        r115.element = r109;
        return;
    L25:
        r109 = 0;
        goto L26
    L28:
        return;
    L20:
        r106 = Integer.MAX_VALUE;
        goto L21
    L5:
        String r116 = r100.toString();
        IntRange r117 = (IntRange) this.$rocketClickableSpanRange.element;
        if (r117 != null) goto L8;
    L15:
        this.$canvas.drawText(r116, r102, r111, this.this$0.M);
    L16:
        this.$charIndex.element += r116.length();
        goto L17
    L8:
        if (r117.contains(this.$charIndex.element) != true) goto L15;
        TextArtist r118 = this.this$0;
        r118.N.set(r118.M);
        List<CharacterStyle> r119 = this.this$0.f102023f;
        if (r119 == null) goto L14;
        CharacterStyle r120 = (CharacterStyle) ListProtector.get(r119, this.$rocketClickableSpanRangeIndex.element);
        if (r120 == null) goto L14;
        r120.updateDrawState(this.this$0.N);
    L14:
        this.$canvas.drawText(r116, r102, r111, this.this$0.N);
        goto L16
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
