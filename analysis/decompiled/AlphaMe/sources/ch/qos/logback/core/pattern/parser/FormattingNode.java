package ch.qos.logback.core.pattern.parser;

import ch.qos.logback.core.pattern.FormatInfo;

/* loaded from: classes.dex */
public class FormattingNode extends Node {
    FormatInfo formatInfo;

    public FormattingNode(int i4) {
        super(i4);
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof FormattingNode)) {
            return false;
        }
        FormattingNode formattingNode = (FormattingNode) obj;
        FormatInfo formatInfo = this.formatInfo;
        return formatInfo != null ? formatInfo.equals(formattingNode.formatInfo) : formattingNode.formatInfo == null;
    }

    public FormatInfo getFormatInfo() {
        return this.formatInfo;
    }

    @Override // ch.qos.logback.core.pattern.parser.Node
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        FormatInfo formatInfo = this.formatInfo;
        return iHashCode + (formatInfo != null ? formatInfo.hashCode() : 0);
    }

    public void setFormatInfo(FormatInfo formatInfo) {
        this.formatInfo = formatInfo;
    }

    public FormattingNode(int i4, Object obj) {
        super(i4, obj);
    }
}
