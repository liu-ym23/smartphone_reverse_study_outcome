package ch.qos.logback.core.pattern.color;

/* loaded from: classes.dex */
public class YellowCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    public String getForegroundColorCode(E e4) {
        return ANSIConstants.YELLOW_FG;
    }
}
