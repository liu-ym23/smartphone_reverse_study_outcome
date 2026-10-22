package androidx.compose.ui.text.input;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a7\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0080\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a7\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0002H\u0080\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u0006\u0010\u0005¨\u0006\u0007"}, d2 = {"", "right", "Lkotlin/Function0;", "defaultValue", "addExactOrElse", "(IILS7/a;)I", "subtractExactOrElse", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MathUtilsKt {
    public static final int addExactOrElse(int i, int i6, S7.a aVar) {
        int i10 = i + i6;
        return ((i ^ i10) & (i6 ^ i10)) < 0 ? ((Number) aVar.invoke()).intValue() : i10;
    }

    public static final int subtractExactOrElse(int i, int i6, S7.a aVar) {
        int i10 = i - i6;
        return ((i ^ i10) & (i6 ^ i)) < 0 ? ((Number) aVar.invoke()).intValue() : i10;
    }
}
