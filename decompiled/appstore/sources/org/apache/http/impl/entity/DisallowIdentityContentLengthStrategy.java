package org.apache.http.impl.entity;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
public class DisallowIdentityContentLengthStrategy implements ContentLengthStrategy {
    public static final DisallowIdentityContentLengthStrategy INSTANCE = null;
    private final ContentLengthStrategy contentLengthStrategy;

    static {
        INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
    }

    public DisallowIdentityContentLengthStrategy(ContentLengthStrategy r10) {
        this.contentLengthStrategy = r10;
    }

    @Override // org.apache.http.entity.ContentLengthStrategy
    public long determineLength(HttpMessage r10) throws HttpException {
        long r11 = this.contentLengthStrategy.determineLength(r10);
        if (r11 == (-1)) goto L6;
        return r11;
    L6:
        throw new ProtocolException("Identity transfer encoding cannot be used");
    }
}
