package com.fasterxml.jackson.core;

import B7.a;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class StreamReadConstraints implements Serializable {
    public static final int DEFAULT_MAX_DEPTH = 1000;
    public static final long DEFAULT_MAX_DOC_LEN = -1;
    public static final int DEFAULT_MAX_NUM_LEN = 1000;
    public static final long DEFAULT_MAX_TOKEN_COUNT = -1;
    private static final int MAX_BIGINT_SCALE_MAGNITUDE = 100000;
    private static final long serialVersionUID = 1;
    protected final long _maxDocLen;
    protected final int _maxNameLen;
    protected final int _maxNestingDepth;
    protected final int _maxNumLen;
    protected final int _maxStringLen;
    protected final long _maxTokenCount;
    public static final int DEFAULT_MAX_STRING_LEN = 20000000;
    public static final int DEFAULT_MAX_NAME_LEN = 50000;
    private static StreamReadConstraints DEFAULT = new StreamReadConstraints(1000, -1, 1000, DEFAULT_MAX_STRING_LEN, DEFAULT_MAX_NAME_LEN);

    public static final class Builder {
        private long maxDocLen;
        private int maxNameLen;
        private int maxNestingDepth;
        private int maxNumLen;
        private int maxStringLen;
        private long maxTokenCount;

        public Builder() {
            this(1000, -1L, -1L, 1000, StreamReadConstraints.DEFAULT_MAX_STRING_LEN, StreamReadConstraints.DEFAULT_MAX_NAME_LEN);
        }

        public StreamReadConstraints build() {
            return new StreamReadConstraints(this.maxNestingDepth, this.maxDocLen, this.maxNumLen, this.maxStringLen, this.maxNameLen, this.maxTokenCount);
        }

        public Builder maxDocumentLength(long j5) {
            if (j5 <= 0) {
                j5 = -1;
            }
            this.maxDocLen = j5;
            return this;
        }

        public Builder maxNameLength(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot set maxNameLen to a negative value");
            }
            this.maxNameLen = i;
            return this;
        }

        public Builder maxNestingDepth(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot set maxNestingDepth to a negative value");
            }
            this.maxNestingDepth = i;
            return this;
        }

        public Builder maxNumberLength(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot set maxNumberLength to a negative value");
            }
            this.maxNumLen = i;
            return this;
        }

        public Builder maxStringLength(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot set maxStringLen to a negative value");
            }
            this.maxStringLen = i;
            return this;
        }

        public Builder maxTokenCount(long j5) {
            if (j5 <= 0) {
                j5 = -1;
            }
            this.maxTokenCount = j5;
            return this;
        }

        public Builder(int i, long j5, long j6, int i6, int i10, int i11) {
            this.maxNestingDepth = i;
            this.maxDocLen = j5;
            this.maxTokenCount = j6;
            this.maxNumLen = i6;
            this.maxStringLen = i10;
            this.maxNameLen = i11;
        }

        public Builder(StreamReadConstraints streamReadConstraints) {
            this.maxNestingDepth = streamReadConstraints._maxNestingDepth;
            this.maxDocLen = streamReadConstraints._maxDocLen;
            this.maxTokenCount = streamReadConstraints._maxTokenCount;
            this.maxNumLen = streamReadConstraints._maxNumLen;
            this.maxStringLen = streamReadConstraints._maxStringLen;
            this.maxNameLen = streamReadConstraints._maxNameLen;
        }
    }

    @Deprecated
    public StreamReadConstraints(int i, long j5, int i6, int i10) {
        this(i, j5, i6, i10, DEFAULT_MAX_NAME_LEN, -1L);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StreamReadConstraints defaults() {
        return DEFAULT;
    }

    public static void overrideDefaultStreamReadConstraints(StreamReadConstraints streamReadConstraints) {
        if (streamReadConstraints == null) {
            DEFAULT = new StreamReadConstraints(1000, -1L, 1000, DEFAULT_MAX_STRING_LEN);
        } else {
            DEFAULT = streamReadConstraints;
        }
    }

    public String _constrainRef(String str) {
        return a.m("`StreamReadConstraints.", str, "()`");
    }

    public StreamConstraintsException _constructException(String str, Object... objArr) throws StreamConstraintsException {
        throw new StreamConstraintsException(String.format(str, objArr));
    }

    public long getMaxDocumentLength() {
        return this._maxDocLen;
    }

    public int getMaxNameLength() {
        return this._maxNameLen;
    }

    public int getMaxNestingDepth() {
        return this._maxNestingDepth;
    }

    public int getMaxNumberLength() {
        return this._maxNumLen;
    }

    public int getMaxStringLength() {
        return this._maxStringLen;
    }

    public long getMaxTokenCount() {
        return this._maxTokenCount;
    }

    public boolean hasMaxDocumentLength() {
        return this._maxDocLen > 0;
    }

    public boolean hasMaxTokenCount() {
        return this._maxTokenCount > 0;
    }

    public Builder rebuild() {
        return new Builder(this);
    }

    public void validateBigIntegerScale(int i) throws StreamConstraintsException {
        if (Math.abs(i) > 100000) {
            throw _constructException("BigDecimal scale (%d) magnitude exceeds the maximum allowed (%d)", Integer.valueOf(i), 100000);
        }
    }

    public void validateDocumentLength(long j5) throws StreamConstraintsException {
        long j6 = this._maxDocLen;
        if (j5 > j6 && j6 > 0) {
            throw _constructException("Document length (%d) exceeds the maximum allowed (%d, from %s)", Long.valueOf(j5), Long.valueOf(this._maxDocLen), _constrainRef("getMaxDocumentLength"));
        }
    }

    public void validateFPLength(int i) throws StreamConstraintsException {
        if (i > this._maxNumLen) {
            throw _constructException("Number value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNumLen), _constrainRef("getMaxNumberLength"));
        }
    }

    public void validateIntegerLength(int i) throws StreamConstraintsException {
        if (i > this._maxNumLen) {
            throw _constructException("Number value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNumLen), _constrainRef("getMaxNumberLength"));
        }
    }

    public void validateNameLength(int i) throws StreamConstraintsException {
        if (i > this._maxNameLen) {
            throw _constructException("Name length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNameLen), _constrainRef("getMaxNameLength"));
        }
    }

    public void validateNestingDepth(int i) throws StreamConstraintsException {
        if (i > this._maxNestingDepth) {
            throw _constructException("Document nesting depth (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNestingDepth), _constrainRef("getMaxNestingDepth"));
        }
    }

    public void validateStringLength(int i) throws StreamConstraintsException {
        if (i > this._maxStringLen) {
            throw _constructException("String value length (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxStringLen), _constrainRef("getMaxStringLength"));
        }
    }

    public void validateTokenCount(long j5) throws StreamConstraintsException {
        if (j5 > this._maxTokenCount) {
            throw _constructException("Token count (%d) exceeds the maximum allowed (%d, from %s)", Long.valueOf(j5), Long.valueOf(this._maxTokenCount), _constrainRef("getMaxTokenCount"));
        }
    }

    @Deprecated
    public StreamReadConstraints(int i, long j5, int i6, int i10, int i11) {
        this(i, j5, i6, i10, i11, -1L);
    }

    public StreamReadConstraints(int i, long j5, int i6, int i10, int i11, long j6) {
        this._maxNestingDepth = i;
        this._maxDocLen = j5;
        this._maxNumLen = i6;
        this._maxStringLen = i10;
        this._maxNameLen = i11;
        this._maxTokenCount = j6;
    }
}
