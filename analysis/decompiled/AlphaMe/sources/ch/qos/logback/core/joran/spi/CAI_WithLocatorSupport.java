package ch.qos.logback.core.joran.spi;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareImpl;
import com.stepos.alphame.awareness.AwarenessDataItem;
import org.xml.sax.Locator;

/* loaded from: classes.dex */
class CAI_WithLocatorSupport extends ContextAwareImpl {
    public CAI_WithLocatorSupport(Context context, Interpreter interpreter) {
        super(context, interpreter);
    }

    @Override // ch.qos.logback.core.spi.ContextAwareImpl
    public Object getOrigin() {
        Locator locator = ((Interpreter) super.getOrigin()).locator;
        if (locator == null) {
            return Interpreter.class.getName().concat("@NA:NA");
        }
        return Interpreter.class.getName() + "@" + locator.getLineNumber() + AwarenessDataItem.USERID_SPLITTER + locator.getColumnNumber();
    }
}
