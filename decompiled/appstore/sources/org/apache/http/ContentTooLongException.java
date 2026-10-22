package org.apache.http;

import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class ContentTooLongException extends IOException {
    private static final long serialVersionUID = -924287689552495383L;

    public ContentTooLongException(String r10) {
        super(r10);
    }

    public ContentTooLongException(String r10, Object... r11) {
        super(HttpException.clean(String.format(r10, r11)));
    }
}
