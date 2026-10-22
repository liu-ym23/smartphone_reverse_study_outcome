package org.apache.http.impl.entity;

import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
public class EntityDeserializer {
    private final ContentLengthStrategy lenStrategy;

    public EntityDeserializer(ContentLengthStrategy r10) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(r10, "Content length strategy");
    }

    public HttpEntity deserialize(SessionInputBuffer r10, HttpMessage r11) throws HttpException, IOException {
        Args.notNull(r10, "Session input buffer");
        Args.notNull(r11, "HTTP message");
        return doDeserialize(r10, r11);
    }

    public BasicHttpEntity doDeserialize(SessionInputBuffer r10, HttpMessage r11) throws HttpException, IOException {
        BasicHttpEntity r12 = new BasicHttpEntity();
        long r13 = this.lenStrategy.determineLength(r11);
        if (r13 != (-2)) goto L6;
        r12.setChunked(true);
        r12.setContentLength(-1);
        r12.setContent(new ChunkedInputStream(r10));
    L9:
        Header r14 = r11.getFirstHeader("Content-Type");
        if (r14 == null) goto L12;
        r12.setContentType(r14);
    L12:
        Header r15 = r11.getFirstHeader("Content-Encoding");
        if (r15 == null) goto L15;
        r12.setContentEncoding(r15);
    L15:
        return r12;
    L6:
        if (r13 != (-1)) goto L8;
        r12.setChunked(false);
        r12.setContentLength(-1);
        r12.setContent(new IdentityInputStream(r10));
        goto L9
    L8:
        r12.setChunked(false);
        r12.setContentLength(r13);
        r12.setContent(new ContentLengthInputStream(r10, r13));
        goto L9
    }
}
