package kotlin.text;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "R", SlideCard.KEY_INDEX, "", "invoke", "(I)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class StringsKt___StringsKt$windowedSequence$2 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ int $size;
    final /* synthetic */ CharSequence $this_windowedSequence;
    final /* synthetic */ Function1<CharSequence, Object> $transform;

    /* JADX WARN: Multi-variable type inference failed */
    public StringsKt___StringsKt$windowedSequence$2(int r10, CharSequence r11, Function1<? super CharSequence, Object> r12) {
        this.$size = r10;
        this.$this_windowedSequence = r11;
        this.$transform = r12;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer r10) {
        return invoke(r10.intValue());
    }

    public final Object invoke(int r10) {
        int r11 = this.$size + r10;
        if (r11 >= 0) goto L5;
    L6:
        r11 = this.$this_windowedSequence.length();
    L8:
        return this.$transform.invoke(this.$this_windowedSequence.subSequence(r10, r11));
    L5:
        if (r11 <= this.$this_windowedSequence.length()) goto L8;
        goto L6
    }
}
