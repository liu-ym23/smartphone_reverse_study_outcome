package ch.qos.logback.classic.html;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.pattern.MDCConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.html.HTMLLayoutBase;
import ch.qos.logback.core.html.IThrowableRenderer;
import ch.qos.logback.core.pattern.Converter;
import java.util.Map;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class HTMLLayout extends HTMLLayoutBase<ILoggingEvent> {
    static final String DEFAULT_CONVERSION_PATTERN = "%date%thread%level%logger%mdc%msg";
    IThrowableRenderer<ILoggingEvent> throwableRenderer;

    public HTMLLayout() {
        this.pattern = DEFAULT_CONVERSION_PATTERN;
        this.throwableRenderer = new DefaultThrowableRenderer();
        this.cssBuilder = new DefaultCssBuilder();
    }

    private void appendEventToBuffer(StringBuilder sb, Converter<ILoggingEvent> converter, ILoggingEvent iLoggingEvent) {
        sb.append("<td class=\"");
        sb.append(computeConverterName(converter));
        sb.append("\">");
        converter.write(sb, iLoggingEvent);
        sb.append("</td>");
        sb.append(CoreConstants.LINE_SEPARATOR);
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase
    public String computeConverterName(Converter converter) {
        if (!(converter instanceof MDCConverter)) {
            return super.computeConverterName(converter);
        }
        String firstOption = ((MDCConverter) converter).getFirstOption();
        return firstOption != null ? firstOption : "MDC";
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase
    public Map<String, String> getDefaultConverterMap() {
        return PatternLayout.defaultConverterMap;
    }

    public IThrowableRenderer getThrowableRenderer() {
        return this.throwableRenderer;
    }

    public void setThrowableRenderer(IThrowableRenderer<ILoggingEvent> iThrowableRenderer) {
        this.throwableRenderer = iThrowableRenderer;
    }

    @Override // ch.qos.logback.core.html.HTMLLayoutBase, ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.throwableRenderer == null) {
            addError("ThrowableRender cannot be null.");
        } else {
            super.start();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ch.qos.logback.core.Layout
    public String doLayout(ILoggingEvent iLoggingEvent) {
        StringBuilder sb = new StringBuilder();
        startNewTableIfLimitReached(sb);
        long j4 = this.counter;
        this.counter = j4 + 1;
        boolean z4 = (j4 & 1) != 0;
        String lowerCase = iLoggingEvent.getLevel().toString().toLowerCase();
        String str = CoreConstants.LINE_SEPARATOR;
        AbstractC0831a.h(sb, str, "<tr class=\"", lowerCase);
        if (z4) {
            sb.append(" odd\">");
        } else {
            sb.append(" even\">");
        }
        sb.append(str);
        for (Converter next = this.head; next != null; next = next.getNext()) {
            appendEventToBuffer(sb, next, iLoggingEvent);
        }
        sb.append("</tr>");
        sb.append(CoreConstants.LINE_SEPARATOR);
        if (iLoggingEvent.getThrowableProxy() != null) {
            this.throwableRenderer.render(sb, iLoggingEvent);
        }
        return sb.toString();
    }
}
