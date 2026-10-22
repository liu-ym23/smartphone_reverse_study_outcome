package ch.qos.logback.classic.html;

import androidx.room.AbstractC0351g;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.html.CssBuilder;

/* loaded from: classes.dex */
public class DefaultCssBuilder implements CssBuilder {
    @Override // ch.qos.logback.core.html.CssBuilder
    public void addCss(StringBuilder sb) {
        sb.append("<style  type=\"text/css\">");
        String str = CoreConstants.LINE_SEPARATOR;
        AbstractC0351g.C(sb, str, "table { margin-left: 2em; margin-right: 2em; border-left: 2px solid #AAA; }", str, "TR.even { background: #FFFFFF; }");
        AbstractC0351g.C(sb, str, "TR.odd { background: #EAEAEA; }", str, "TR.warn TD.Level, TR.error TD.Level, TR.fatal TD.Level {font-weight: bold; color: #FF4040 }");
        AbstractC0351g.C(sb, str, "TD { padding-right: 1ex; padding-left: 1ex; border-right: 2px solid #AAA; }", str, "TD.Time, TD.Date { text-align: right; font-family: courier, monospace; font-size: smaller; }");
        AbstractC0351g.C(sb, str, "TD.Thread { text-align: left; }", str, "TD.Level { text-align: right; }");
        AbstractC0351g.C(sb, str, "TD.Logger { text-align: left; }", str, "TR.header { background: #596ED5; color: #FFF; font-weight: bold; font-size: larger; }");
        AbstractC0351g.C(sb, str, "TD.Exception { background: #A2AEE8; font-family: courier, monospace;}", str, "</style>");
        sb.append(str);
    }
}
