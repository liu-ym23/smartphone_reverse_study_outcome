package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes.dex */
public final class TextParsedResult extends ParsedResult {
    private final String language;
    private final String text;

    public TextParsedResult(String r2, String r3) {
        super(ParsedResultType.TEXT);
        this.text = r2;
        this.language = r3;
    }

    public String getText() {
        return this.text;
    }

    public String getLanguage() {
        return this.language;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.text;
    }
}
