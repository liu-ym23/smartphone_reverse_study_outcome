package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import g5.f;
import java.io.Serializable;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class StreamWriteConstraints implements Serializable {
    private static StreamWriteConstraints DEFAULT = new StreamWriteConstraints(1000);
    public static final int DEFAULT_MAX_DEPTH = 1000;
    private static final long serialVersionUID = 1;
    protected final int _maxNestingDepth;

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
        return a.C("`StreamWriteConstraints.", str, "()`");
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private int maxNestingDepth;

        public Builder(StreamWriteConstraints streamWriteConstraints) {
            this.maxNestingDepth = streamWriteConstraints._maxNestingDepth;
        }

        public StreamWriteConstraints build() {
            return new StreamWriteConstraints(this.maxNestingDepth);
        }

        public Builder maxNestingDepth(int i) {
            if (i >= 0) {
                this.maxNestingDepth = i;
                return this;
            }
            f.s("Cannot set maxNestingDepth to a negative value");
            return null;
        }

        public Builder(int i) {
            this.maxNestingDepth = i;
        }

        public Builder() {
            this(1000);
        }
    }
}
