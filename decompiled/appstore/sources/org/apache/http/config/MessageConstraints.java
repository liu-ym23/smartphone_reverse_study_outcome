package org.apache.http.config;

import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
public class MessageConstraints implements Cloneable {
    public static final MessageConstraints DEFAULT = null;
    private final int maxHeaderCount;
    private final int maxLineLength;

    public static class Builder {
        private int maxHeaderCount;
        private int maxLineLength;

        public Builder() {
            this.maxLineLength = -1;
            this.maxHeaderCount = -1;
        }

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }

        public Builder setMaxHeaderCount(int r10) {
            this.maxHeaderCount = r10;
            return this;
        }

        public Builder setMaxLineLength(int r10) {
            this.maxLineLength = r10;
            return this;
        }
    }

    static {
        DEFAULT = new Builder().build();
    }

    public MessageConstraints(int r10, int r11) {
        this.maxLineLength = r10;
        this.maxHeaderCount = r11;
    }

    public static Builder copy(MessageConstraints r10) {
        Args.notNull(r10, "Message constraints");
        return new Builder().setMaxHeaderCount(r10.getMaxHeaderCount()).setMaxLineLength(r10.getMaxLineLength());
    }

    public static Builder custom() {
        return new Builder();
    }

    public static MessageConstraints lineLen(int r10) {
        return new MessageConstraints(Args.notNegative(r10, "Max line length"), -1);
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return m61clone();
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public String toString() {
        return "[maxLineLength=" + this.maxLineLength + ", maxHeaderCount=" + this.maxHeaderCount + "]";
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public MessageConstraints m61clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }
}
