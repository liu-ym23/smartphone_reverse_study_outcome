package ch.qos.logback.core.html;

import B0.g;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.pattern.Converter;
import ch.qos.logback.core.pattern.ConverterUtil;
import ch.qos.logback.core.pattern.parser.Parser;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import ch.qos.logback.core.spi.ScanException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public abstract class HTMLLayoutBase<E> extends LayoutBase<E> {
    protected CssBuilder cssBuilder;
    protected Converter<E> head;
    protected String pattern;
    protected String title = "Logback Log Messages";
    protected long counter = 0;

    private void buildHeaderRowForTable(StringBuilder sb) {
        Converter<E> next = this.head;
        sb.append("<tr class=\"header\">");
        sb.append(CoreConstants.LINE_SEPARATOR);
        while (next != null) {
            if (computeConverterName(next) == null) {
                next = next.getNext();
            } else {
                sb.append("<td class=\"");
                sb.append(computeConverterName(next));
                sb.append("\">");
                sb.append(computeConverterName(next));
                sb.append("</td>");
                sb.append(CoreConstants.LINE_SEPARATOR);
                next = next.getNext();
            }
        }
        sb.append("</tr>");
        sb.append(CoreConstants.LINE_SEPARATOR);
    }

    public String computeConverterName(Converter converter) {
        String simpleName = converter.getClass().getSimpleName();
        int iIndexOf = simpleName.indexOf("Converter");
        return iIndexOf == -1 ? simpleName : simpleName.substring(0, iIndexOf);
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getContentType() {
        return "text/html";
    }

    public CssBuilder getCssBuilder() {
        return this.cssBuilder;
    }

    public abstract Map<String, String> getDefaultConverterMap();

    public Map<String, String> getEffectiveConverterMap() {
        Map map;
        HashMap map2 = new HashMap();
        Map<String, String> defaultConverterMap = getDefaultConverterMap();
        if (defaultConverterMap != null) {
            map2.putAll(defaultConverterMap);
        }
        Context context = getContext();
        if (context != null && (map = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY)) != null) {
            map2.putAll(map);
        }
        return map2;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getFileFooter() {
        return g.r(new StringBuilder(), CoreConstants.LINE_SEPARATOR, "</body></html>");
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getFileHeader() {
        StringBuilder sbS = g.s("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        String str = CoreConstants.LINE_SEPARATOR;
        AbstractC0351g.C(sbS, str, "<html>", str, "  <head>");
        sbS.append(str);
        sbS.append("    <title>");
        AbstractC0831a.h(sbS, this.title, "</title>", str);
        this.cssBuilder.addCss(sbS);
        sbS.append(str);
        sbS.append("  </head>");
        sbS.append(str);
        return g.r(sbS, "<body>", str);
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getPresentationFooter() {
        return "</table>";
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        StringBuilder sbS = g.s("<hr/>");
        String str = CoreConstants.LINE_SEPARATOR;
        sbS.append(str);
        sbS.append("<p>Log session start time ");
        sbS.append(new Date());
        sbS.append("</p><p></p>");
        sbS.append(str);
        AbstractC0831a.h(sbS, str, "<table cellspacing=\"0\">", str);
        buildHeaderRowForTable(sbS);
        return sbS.toString();
    }

    public String getTitle() {
        return this.title;
    }

    public void setCssBuilder(CssBuilder cssBuilder) {
        this.cssBuilder = cssBuilder;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        try {
            Parser parser = new Parser(this.pattern);
            parser.setContext(getContext());
            Converter<E> converterCompile = parser.compile(parser.parse(), getEffectiveConverterMap());
            this.head = converterCompile;
            ConverterUtil.startConverters(converterCompile);
            this.started = true;
        } catch (ScanException e4) {
            addError("Incorrect pattern found", e4);
        }
    }

    public void startNewTableIfLimitReached(StringBuilder sb) {
        if (this.counter >= AbstractComponentTracker.LINGERING_TIMEOUT) {
            this.counter = 0L;
            sb.append("</table>");
            String str = CoreConstants.LINE_SEPARATOR;
            AbstractC0351g.C(sb, str, "<p></p>", "<table cellspacing=\"0\">", str);
            buildHeaderRowForTable(sb);
        }
    }
}
