package com.fasterxml.jackson.core;

import B7.a;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class StreamWriteConstraints implements Serializable {
    private static StreamWriteConstraints DEFAULT = new StreamWriteConstraints(1000);
    public static final int DEFAULT_MAX_DEPTH = 1000;
    private static final long serialVersionUID = 1;
    protected final int _maxNestingDepth;

    public static final class Builder {
        private int maxNestingDepth;

        public Builder() {
            this(1000);
        }

        public StreamWriteConstraints build() {
            return new StreamWriteConstraints(this.maxNestingDepth);
        }

        public Builder maxNestingDepth(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("Cannot set maxNestingDepth to a negative value");
            }
            this.maxNestingDepth = i;
            return this;
        }

        public Builder(int i) {
            this.maxNestingDepth = i;
        }

        public Builder(StreamWriteConstraints streamWriteConstraints) {
            this.maxNestingDepth = streamWriteConstraints._maxNestingDepth;
        }
    }

    public StreamWriteConstraints(int i) {
        this._maxNestingDepth = i;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static StreamWriteConstraints defaults() {
        return DEFAULT;
    }

    public static void overrideDefaultStreamWriteConstraints(StreamWriteConstraints streamWriteConstraints) {
        if (streamWriteConstraints == null) {
            DEFAULT = new StreamWriteConstraints(1000);
        } else {
            DEFAULT = streamWriteConstraints;
        }
    }

    public String _constrainRef(String str) {
        return a.m("`StreamWriteConstraints.", str, "()`");
    }

    public StreamConstraintsException _constructException(String str, Object... objArr) throws StreamConstraintsException {
        throw new StreamConstraintsException(String.format(str, objArr));
    }

    public int getMaxNestingDepth() {
        return this._maxNestingDepth;
    }

    public Builder rebuild() {
        return new Builder(this);
    }

    public void validateNestingDepth(int i) throws StreamConstraintsException {
        if (i > this._maxNestingDepth) {
            throw _constructException("Document nesting depth (%d) exceeds the maximum allowed (%d, from %s)", Integer.valueOf(i), Integer.valueOf(this._maxNestingDepth), _constrainRef("getMaxNestingDepth"));
        }
    }
}
