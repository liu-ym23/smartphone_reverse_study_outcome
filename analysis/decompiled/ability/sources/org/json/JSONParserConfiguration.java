package org.json;

/* loaded from: classes4.dex */
public class JSONParserConfiguration extends ParserConfiguration {
    @Override // org.json.ParserConfiguration
    public JSONParserConfiguration withMaxNestingDepth(int i) {
        return (JSONParserConfiguration) super.withMaxNestingDepth(i);
    }

    @Override // org.json.ParserConfiguration
    public JSONParserConfiguration clone() {
        return new JSONParserConfiguration();
    }
}
