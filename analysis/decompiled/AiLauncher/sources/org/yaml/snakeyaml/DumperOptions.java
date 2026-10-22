package org.yaml.snakeyaml;

import com.fasterxml.jackson.core.JsonFactory;
import io.ktor.sse.ServerSentEventKt;
import java.util.Map;
import java.util.TimeZone;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.serializer.AnchorGenerator;
import org.yaml.snakeyaml.serializer.NumberAnchorGenerator;

/* loaded from: classes5.dex */
public class DumperOptions {
    private ScalarStyle defaultStyle = ScalarStyle.PLAIN;
    private FlowStyle defaultFlowStyle = FlowStyle.AUTO;
    private boolean canonical = false;
    private boolean allowUnicode = true;
    private boolean allowReadOnlyProperties = false;
    private int indent = 2;
    private int indicatorIndent = 0;
    private boolean indentWithIndicator = false;
    private int bestWidth = 80;
    private boolean splitLines = true;
    private LineBreak lineBreak = LineBreak.UNIX;
    private boolean explicitStart = false;
    private boolean explicitEnd = false;
    private TimeZone timeZone = null;
    private int maxSimpleKeyLength = 128;
    private boolean processComments = false;
    private NonPrintableStyle nonPrintableStyle = NonPrintableStyle.BINARY;
    private Version version = null;
    private Map<String, String> tags = null;
    private Boolean prettyFlow = Boolean.FALSE;
    private AnchorGenerator anchorGenerator = new NumberAnchorGenerator(0);
    private boolean dereferenceAliases = false;

    public enum FlowStyle {
        FLOW(Boolean.TRUE),
        BLOCK(Boolean.FALSE),
        AUTO(null);

        private final Boolean styleBoolean;

        FlowStyle(Boolean bool) {
            this.styleBoolean = bool;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Flow style: '" + this.styleBoolean + "'";
        }
    }

    public enum LineBreak {
        WIN(ServerSentEventKt.END_OF_LINE),
        MAC("\r"),
        UNIX("\n");

        private final String lineBreak;

        LineBreak(String str) {
            this.lineBreak = str;
        }

        public static LineBreak getPlatformLineBreak() {
            String property = System.getProperty("line.separator");
            for (LineBreak lineBreak : values()) {
                if (lineBreak.lineBreak.equals(property)) {
                    return lineBreak;
                }
            }
            return UNIX;
        }

        public String getString() {
            return this.lineBreak;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Line break: " + name();
        }
    }

    public enum NonPrintableStyle {
        BINARY,
        ESCAPE
    }

    public enum ScalarStyle {
        DOUBLE_QUOTED(Character.valueOf(JsonFactory.DEFAULT_QUOTE_CHAR)),
        SINGLE_QUOTED('\''),
        LITERAL('|'),
        FOLDED('>'),
        JSON_SCALAR_STYLE('J'),
        PLAIN(null);

        private final Character styleChar;

        ScalarStyle(Character ch) {
            this.styleChar = ch;
        }

        public static ScalarStyle createStyle(Character ch) {
            if (ch == null) {
                return PLAIN;
            }
            char cCharValue = ch.charValue();
            if (cCharValue == '\"') {
                return DOUBLE_QUOTED;
            }
            if (cCharValue == '\'') {
                return SINGLE_QUOTED;
            }
            if (cCharValue == '>') {
                return FOLDED;
            }
            if (cCharValue == '|') {
                return LITERAL;
            }
            throw new YAMLException("Unknown scalar style character: " + ch);
        }

        public Character getChar() {
            return this.styleChar;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Scalar style: '" + this.styleChar + "'";
        }
    }

    public enum Version {
        V1_0(new Integer[]{1, 0}),
        V1_1(new Integer[]{1, 1});

        private final Integer[] version;

        Version(Integer[] numArr) {
            this.version = numArr;
        }

        public String getRepresentation() {
            return this.version[0] + "." + this.version[1];
        }

        public int major() {
            return this.version[0].intValue();
        }

        public int minor() {
            return this.version[1].intValue();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Version: " + getRepresentation();
        }
    }

    public AnchorGenerator getAnchorGenerator() {
        return this.anchorGenerator;
    }

    public FlowStyle getDefaultFlowStyle() {
        return this.defaultFlowStyle;
    }

    public ScalarStyle getDefaultScalarStyle() {
        return this.defaultStyle;
    }

    public int getIndent() {
        return this.indent;
    }

    public boolean getIndentWithIndicator() {
        return this.indentWithIndicator;
    }

    public int getIndicatorIndent() {
        return this.indicatorIndent;
    }

    public LineBreak getLineBreak() {
        return this.lineBreak;
    }

    public int getMaxSimpleKeyLength() {
        return this.maxSimpleKeyLength;
    }

    public NonPrintableStyle getNonPrintableStyle() {
        return this.nonPrintableStyle;
    }

    public boolean getSplitLines() {
        return this.splitLines;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public Version getVersion() {
        return this.version;
    }

    public int getWidth() {
        return this.bestWidth;
    }

    public boolean isAllowReadOnlyProperties() {
        return this.allowReadOnlyProperties;
    }

    public boolean isAllowUnicode() {
        return this.allowUnicode;
    }

    public boolean isCanonical() {
        return this.canonical;
    }

    public boolean isDereferenceAliases() {
        return this.dereferenceAliases;
    }

    public boolean isExplicitEnd() {
        return this.explicitEnd;
    }

    public boolean isExplicitStart() {
        return this.explicitStart;
    }

    public boolean isPrettyFlow() {
        return this.prettyFlow.booleanValue();
    }

    public boolean isProcessComments() {
        return this.processComments;
    }

    public void setAllowReadOnlyProperties(boolean z10) {
        this.allowReadOnlyProperties = z10;
    }

    public void setAllowUnicode(boolean z10) {
        this.allowUnicode = z10;
    }

    public void setAnchorGenerator(AnchorGenerator anchorGenerator) {
        this.anchorGenerator = anchorGenerator;
    }

    public void setCanonical(boolean z10) {
        this.canonical = z10;
    }

    public void setDefaultFlowStyle(FlowStyle flowStyle) {
        if (flowStyle == null) {
            throw new NullPointerException("Use FlowStyle enum.");
        }
        this.defaultFlowStyle = flowStyle;
    }

    public void setDefaultScalarStyle(ScalarStyle scalarStyle) {
        if (scalarStyle == null) {
            throw new NullPointerException("Use ScalarStyle enum.");
        }
        this.defaultStyle = scalarStyle;
    }

    public void setDereferenceAliases(boolean z10) {
        this.dereferenceAliases = z10;
    }

    public void setExplicitEnd(boolean z10) {
        this.explicitEnd = z10;
    }

    public void setExplicitStart(boolean z10) {
        this.explicitStart = z10;
    }

    public void setIndent(int i10) {
        if (i10 < 1) {
            throw new YAMLException("Indent must be at least 1");
        }
        if (i10 > 10) {
            throw new YAMLException("Indent must be at most 10");
        }
        this.indent = i10;
    }

    public void setIndentWithIndicator(boolean z10) {
        this.indentWithIndicator = z10;
    }

    public void setIndicatorIndent(int i10) {
        if (i10 < 0) {
            throw new YAMLException("Indicator indent must be non-negative.");
        }
        if (i10 > 9) {
            throw new YAMLException("Indicator indent must be at most Emitter.MAX_INDENT-1: 9");
        }
        this.indicatorIndent = i10;
    }

    public void setLineBreak(LineBreak lineBreak) {
        if (lineBreak == null) {
            throw new NullPointerException("Specify line break.");
        }
        this.lineBreak = lineBreak;
    }

    public void setMaxSimpleKeyLength(int i10) {
        if (i10 > 1024) {
            throw new YAMLException("The simple key must not span more than 1024 stream characters. See https://yaml.org/spec/1.1/#id934537");
        }
        this.maxSimpleKeyLength = i10;
    }

    public void setNonPrintableStyle(NonPrintableStyle nonPrintableStyle) {
        this.nonPrintableStyle = nonPrintableStyle;
    }

    public void setPrettyFlow(boolean z10) {
        this.prettyFlow = Boolean.valueOf(z10);
    }

    public void setProcessComments(boolean z10) {
        this.processComments = z10;
    }

    public void setSplitLines(boolean z10) {
        this.splitLines = z10;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public void setWidth(int i10) {
        this.bestWidth = i10;
    }
}
