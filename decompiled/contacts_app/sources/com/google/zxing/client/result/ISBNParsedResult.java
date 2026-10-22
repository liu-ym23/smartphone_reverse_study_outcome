package com.google.zxing.client.result;

/* JADX INFO: loaded from: classes.dex */
public final class ISBNParsedResult extends ParsedResult {
    private final String isbn;

    ISBNParsedResult(String r2) {
        super(ParsedResultType.ISBN);
        this.isbn = r2;
    }

    public String getISBN() {
        return this.isbn;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        return this.isbn;
    }
}
