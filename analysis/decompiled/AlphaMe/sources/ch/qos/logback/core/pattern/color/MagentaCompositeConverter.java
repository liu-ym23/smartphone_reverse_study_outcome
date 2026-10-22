package ch.qos.logback.core.pattern.color;

/* loaded from: classes.dex */
public class MagentaCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    public String getForegroundColorCode(E e4) {
        return ANSIConstants.MAGENTA_FG;
    }
}
