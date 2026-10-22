package com.fasterxml.jackson.core;

import androidx.compose.foundation.b;
import com.fasterxml.jackson.core.io.ContentReference;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class JsonLocation implements Serializable {

    @Deprecated
    public static final int MAX_CONTENT_SNIPPET = 500;
    public static final JsonLocation NA = new JsonLocation(ContentReference.unknown(), -1L, -1L, -1, -1);
    private static final long serialVersionUID = 2;
    protected final int _columnNr;
    protected final ContentReference _contentReference;
    protected final int _lineNr;
    protected transient String _sourceDescription;
    protected final long _totalBytes;
    protected final long _totalChars;

    public JsonLocation(ContentReference contentReference, long j5, int i, int i6) {
        this(contentReference, -1L, j5, i, i6);
    }

    public static ContentReference _wrap(Object obj) {
        return obj instanceof ContentReference ? (ContentReference) obj : ContentReference.construct(false, obj, ErrorReportConfiguration.defaults());
    }

    public StringBuilder appendOffsetDescription(StringBuilder sb) {
        if (this._contentReference.hasTextualContent()) {
            sb.append("line: ");
            int i = this._lineNr;
            if (i >= 0) {
                sb.append(i);
            } else {
                sb.append("UNKNOWN");
            }
            sb.append(", column: ");
            int i6 = this._columnNr;
            if (i6 >= 0) {
                sb.append(i6);
                return sb;
            }
            sb.append("UNKNOWN");
            return sb;
        }
        if (this._lineNr > 0) {
            sb.append("line: ");
            sb.append(this._lineNr);
            if (this._columnNr > 0) {
                sb.append(", column: ");
                sb.append(this._columnNr);
            }
            return sb;
        }
        sb.append("byte offset: #");
        long j5 = this._totalBytes;
        if (j5 >= 0) {
            sb.append(j5);
            return sb;
        }
        sb.append("UNKNOWN");
        return sb;
    }

    public ContentReference contentReference() {
        return this._contentReference;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        ContentReference contentReference = this._contentReference;
        if (contentReference == null) {
            if (jsonLocation._contentReference != null) {
                return false;
            }
        } else if (!contentReference.equals(jsonLocation._contentReference)) {
            return false;
        }
        return this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && this._totalBytes == jsonLocation._totalBytes;
    }

    public long getByteOffset() {
        return this._totalBytes;
    }

    public long getCharOffset() {
        return this._totalChars;
    }

    public int getColumnNr() {
        return this._columnNr;
    }

    public int getLineNr() {
        return this._lineNr;
    }

    @Deprecated
    public Object getSourceRef() {
        return this._contentReference.getRawContent();
    }

    public int hashCode() {
        return ((((this._contentReference == null ? 1 : 2) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public String offsetDescription() {
        return appendOffsetDescription(new StringBuilder(40)).toString();
    }

    public String sourceDescription() {
        if (this._sourceDescription == null) {
            this._sourceDescription = this._contentReference.buildSourceDescription();
        }
        return this._sourceDescription;
    }

    public String toString() {
        String strSourceDescription = sourceDescription();
        StringBuilder sb = new StringBuilder(strSourceDescription.length() + 40);
        b.C(sb, "[Source: ", strSourceDescription, "; ");
        StringBuilder sbAppendOffsetDescription = appendOffsetDescription(sb);
        sbAppendOffsetDescription.append(']');
        return sbAppendOffsetDescription.toString();
    }

    public JsonLocation(ContentReference contentReference, long j5, long j6, int i, int i6) {
        this._contentReference = contentReference == null ? ContentReference.unknown() : contentReference;
        this._totalBytes = j5;
        this._totalChars = j6;
        this._lineNr = i;
        this._columnNr = i6;
    }

    @Deprecated
    public JsonLocation(Object obj, long j5, int i, int i6) {
        this(_wrap(obj), j5, i, i6);
    }

    @Deprecated
    public JsonLocation(Object obj, long j5, long j6, int i, int i6) {
        this(_wrap(obj), j5, j6, i, i6);
    }
}
