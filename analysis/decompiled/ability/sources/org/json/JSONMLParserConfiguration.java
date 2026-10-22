package org.json;

/* loaded from: classes4.dex */
public class JSONMLParserConfiguration extends ParserConfiguration {
    public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
    public static final JSONMLParserConfiguration ORIGINAL = new JSONMLParserConfiguration();
    public static final JSONMLParserConfiguration KEEP_STRINGS = new JSONMLParserConfiguration().withKeepStrings(true);

    public JSONMLParserConfiguration() {
        this.maxNestingDepth = 512;
    }

    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration withKeepStrings(boolean z10) {
        return (JSONMLParserConfiguration) super.withKeepStrings(z10);
    }

    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration withMaxNestingDepth(int i) {
        return (JSONMLParserConfiguration) super.withMaxNestingDepth(i);
    }

    public JSONMLParserConfiguration(boolean z10, int i) {
        super(z10, i);
    }

    @Override // org.json.ParserConfiguration
    public JSONMLParserConfiguration clone() {
        return new JSONMLParserConfiguration(this.keepStrings, this.maxNestingDepth);
    }
}
