package org.apache.http.config;

import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class ConnectionConfig implements Cloneable {
    public static final ConnectionConfig DEFAULT = null;
    private final int bufferSize;
    private final Charset charset;
    private final int fragmentSizeHint;
    private final CodingErrorAction malformedInputAction;
    private final MessageConstraints messageConstraints;
    private final CodingErrorAction unmappableInputAction;

    public static class Builder {
        private int bufferSize;
        private Charset charset;
        private int fragmentSizeHint;
        private CodingErrorAction malformedInputAction;
        private MessageConstraints messageConstraints;
        private CodingErrorAction unmappableInputAction;

        public Builder() {
            this.fragmentSizeHint = -1;
        }

        public ConnectionConfig build() {
            Charset r10 = this.charset;
            if (r10 == null) goto L5;
        L9:
            Charset r11 = r10;
            int r12 = this.bufferSize;
            if (r12 <= 0) goto L12;
        L11:
            int r13 = r12;
            int r14 = this.fragmentSizeHint;
            if (r14 < 0) goto L16;
            int r15 = r14;
        L18:
            return new ConnectionConfig(r13, r15, r11, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
        L16:
            r15 = r13;
            goto L18
        L12:
            r12 = 8192;
            goto L11
        L5:
            if (this.malformedInputAction == null) goto L7;
        L8:
            r10 = Consts.ASCII;
            goto L9
        L7:
            if (this.unmappableInputAction == null) goto L9;
            goto L8
        }

        public Builder setBufferSize(int r10) {
            this.bufferSize = r10;
            return this;
        }

        public Builder setCharset(Charset r10) {
            this.charset = r10;
            return this;
        }

        public Builder setFragmentSizeHint(int r10) {
            this.fragmentSizeHint = r10;
            return this;
        }

        public Builder setMalformedInputAction(CodingErrorAction r10) {
            this.malformedInputAction = r10;
            if (r10 != null) goto L5;
        L7:
            return this;
        L5:
            if (this.charset != null) goto L7;
            this.charset = Consts.ASCII;
            goto L7
        }

        public Builder setMessageConstraints(MessageConstraints r10) {
            this.messageConstraints = r10;
            return this;
        }

        public Builder setUnmappableInputAction(CodingErrorAction r10) {
            this.unmappableInputAction = r10;
            if (r10 != null) goto L5;
        L7:
            return this;
        L5:
            if (this.charset != null) goto L7;
            this.charset = Consts.ASCII;
            goto L7
        }
    }

    static {
        DEFAULT = new Builder().build();
    }

    public ConnectionConfig(int r10, int r11, Charset r12, CodingErrorAction r13, CodingErrorAction r14, MessageConstraints r15) {
        this.bufferSize = r10;
        this.fragmentSizeHint = r11;
        this.charset = r12;
        this.malformedInputAction = r13;
        this.unmappableInputAction = r14;
        this.messageConstraints = r15;
    }

    public static Builder copy(ConnectionConfig r10) {
        Args.notNull(r10, "Connection config");
        return new Builder().setBufferSize(r10.getBufferSize()).setCharset(r10.getCharset()).setFragmentSizeHint(r10.getFragmentSizeHint()).setMalformedInputAction(r10.getMalformedInputAction()).setUnmappableInputAction(r10.getUnmappableInputAction()).setMessageConstraints(r10.getMessageConstraints());
    }

    public static Builder custom() {
        return new Builder();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m60clone();
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getFragmentSizeHint() {
        return this.fragmentSizeHint;
    }

    public CodingErrorAction getMalformedInputAction() {
        return this.malformedInputAction;
    }

    public MessageConstraints getMessageConstraints() {
        return this.messageConstraints;
    }

    public CodingErrorAction getUnmappableInputAction() {
        return this.unmappableInputAction;
    }

    public String toString() {
        return "[bufferSize=" + this.bufferSize + ", fragmentSizeHint=" + this.fragmentSizeHint + ", charset=" + this.charset + ", malformedInputAction=" + this.malformedInputAction + ", unmappableInputAction=" + this.unmappableInputAction + ", messageConstraints=" + this.messageConstraints + "]";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public ConnectionConfig m60clone() throws CloneNotSupportedException {
        return (ConnectionConfig) super.clone();
    }
}
