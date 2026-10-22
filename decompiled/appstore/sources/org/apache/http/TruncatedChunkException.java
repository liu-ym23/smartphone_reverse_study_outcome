package org.apache.http;

/* JADX INFO: loaded from: classes4.dex */
public class TruncatedChunkException extends MalformedChunkCodingException {
    private static final long serialVersionUID = -23506263930279460L;

    public TruncatedChunkException(String r10) {
        super(r10);
    }

    public TruncatedChunkException(String r10, Object... r11) {
        super(HttpException.clean(String.format(r10, r11)));
    }
}
