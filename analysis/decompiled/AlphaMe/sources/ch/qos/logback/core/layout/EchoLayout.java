package ch.qos.logback.core.layout;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;

/* loaded from: classes.dex */
public class EchoLayout<E> extends LayoutBase<E> {
    @Override // ch.qos.logback.core.Layout
    public String doLayout(E e4) {
        return e4 + CoreConstants.LINE_SEPARATOR;
    }
}
