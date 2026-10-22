package ch.qos.logback.core.pattern.color;

import ch.qos.logback.core.pattern.CompositeConverter;

/* loaded from: classes.dex */
public abstract class ForegroundCompositeConverterBase<E> extends CompositeConverter<E> {
    private static final String SET_DEFAULT_COLOR = "\u001b[0;39m";

    public abstract String getForegroundColorCode(E e4);

    @Override // ch.qos.logback.core.pattern.CompositeConverter
    public String transform(E e4, String str) {
        return ANSIConstants.ESC_START + getForegroundColorCode(e4) + ANSIConstants.ESC_END + str + SET_DEFAULT_COLOR;
    }
}
