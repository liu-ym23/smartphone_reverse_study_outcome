package com.volcengine.tos.model.object;

import B7.a;

/* loaded from: classes3.dex */
public class ContentLengthRange {
    private long rangeEnd;
    private long rangeStart;

    public static final class ContentLengthRangeBuilder {
        private long rangeEnd;
        private long rangeStart;

        public ContentLengthRange build() {
            ContentLengthRange contentLengthRange = new ContentLengthRange();
            contentLengthRange.setRangeStart(this.rangeStart);
            contentLengthRange.setRangeEnd(this.rangeEnd);
            return contentLengthRange;
        }

        public ContentLengthRangeBuilder rangeEnd(long j5) {
            this.rangeEnd = j5;
            return this;
        }

        public ContentLengthRangeBuilder rangeStart(long j5) {
            this.rangeStart = j5;
            return this;
        }

        private ContentLengthRangeBuilder() {
        }
    }

    public static ContentLengthRangeBuilder builder() {
        return new ContentLengthRangeBuilder();
    }

    public long getRangeEnd() {
        return this.rangeEnd;
    }

    public long getRangeStart() {
        return this.rangeStart;
    }

    public ContentLengthRange setRangeEnd(long j5) {
        this.rangeEnd = j5;
        return this;
    }

    public ContentLengthRange setRangeStart(long j5) {
        this.rangeStart = j5;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ContentLengthRange{rangeStart=");
        sb.append(this.rangeStart);
        sb.append(", rangeEnd=");
        return a.p(sb, this.rangeEnd, '}');
    }
}
