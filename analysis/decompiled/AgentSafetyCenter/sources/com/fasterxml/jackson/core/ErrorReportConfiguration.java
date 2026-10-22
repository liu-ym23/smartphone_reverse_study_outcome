package com.fasterxml.jackson.core;

import b8.z;
import java.io.Serializable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class ErrorReportConfiguration implements Serializable {
    public static final int DEFAULT_MAX_RAW_CONTENT_LENGTH = 500;
    private static final long serialVersionUID = 1;
    protected final int _maxErrorTokenLength;
    protected final int _maxRawContentLength;
    public static final int DEFAULT_MAX_ERROR_TOKEN_LENGTH = 256;
    private static ErrorReportConfiguration DEFAULT = new ErrorReportConfiguration(DEFAULT_MAX_ERROR_TOKEN_LENGTH, 500);

    public ErrorReportConfiguration(int i, int i3) {
        this._maxErrorTokenLength = i;
        this._maxRawContentLength = i3;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static ErrorReportConfiguration defaults() {
        return DEFAULT;
    }

    public static void overrideDefaultErrorReportConfiguration(ErrorReportConfiguration errorReportConfiguration) {
        if (errorReportConfiguration == null) {
            DEFAULT = new ErrorReportConfiguration(DEFAULT_MAX_ERROR_TOKEN_LENGTH, 500);
        } else {
            DEFAULT = errorReportConfiguration;
        }
    }

    public static void validateMaxErrorTokenLength(int i) {
        if (i >= 0) {
            return;
        }
        z.u("Value of maxErrorTokenLength (%d) cannot be negative", new Object[]{Integer.valueOf(i)});
    }

    public static void validateMaxRawContentLength(int i) {
        if (i >= 0) {
            return;
        }
        z.u("Value of maxRawContentLength (%d) cannot be negative", new Object[]{Integer.valueOf(i)});
    }

    public int getMaxErrorTokenLength() {
        return this._maxErrorTokenLength;
    }

    public int getMaxRawContentLength() {
        return this._maxRawContentLength;
    }

    public Builder rebuild() {
        return new Builder(this);
    }

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class Builder {
        private int maxErrorTokenLength;
        private int maxRawContentLength;

        public Builder(ErrorReportConfiguration errorReportConfiguration) {
            this.maxErrorTokenLength = errorReportConfiguration._maxErrorTokenLength;
            this.maxRawContentLength = errorReportConfiguration._maxRawContentLength;
        }

        public ErrorReportConfiguration build() {
            return new ErrorReportConfiguration(this.maxErrorTokenLength, this.maxRawContentLength);
        }

        public Builder maxErrorTokenLength(int i) {
            ErrorReportConfiguration.validateMaxErrorTokenLength(i);
            this.maxErrorTokenLength = i;
            return this;
        }

        public Builder maxRawContentLength(int i) {
            ErrorReportConfiguration.validateMaxRawContentLength(i);
            this.maxRawContentLength = i;
            return this;
        }

        public Builder(int i, int i3) {
            this.maxErrorTokenLength = i;
            this.maxRawContentLength = i3;
        }

        public Builder() {
            this(ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH, 500);
        }
    }
}
