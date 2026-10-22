package org.apache.http.impl.entity;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
@Deprecated
public class EntitySerializer {
    private final ContentLengthStrategy lenStrategy;

    public EntitySerializer(ContentLengthStrategy r10) {
        this.lenStrategy = (ContentLengthStrategy) Args.notNull(r10, "Content length strategy");
    }

    public OutputStream doSerialize(SessionOutputBuffer r10, HttpMessage r11) throws HttpException, IOException {
        long r12 = this.lenStrategy.determineLength(r11);
        if (r12 != (-2)) goto L7;
        return new ChunkedOutputStream(r10);
    L7:
        if (r12 != (-1)) goto L11;
        return new IdentityOutputStream(r10);
    L11:
        return new ContentLengthOutputStream(r10, r12);
    }

    public void serialize(SessionOutputBuffer r10, HttpMessage r11, HttpEntity r12) throws HttpException, IOException {
        Args.notNull(r10, "Session output buffer");
        Args.notNull(r11, "HTTP message");
        Args.notNull(r12, "HTTP entity");
        OutputStream r13 = doSerialize(r10, r11);
        r12.writeTo(r13);
        r13.close();
    }
}
