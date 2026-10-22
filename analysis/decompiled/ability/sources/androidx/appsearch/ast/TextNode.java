package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import com.fasterxml.jackson.core.JsonFactory;
import java.util.Objects;
import o7.s;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
/* loaded from: classes.dex */
public final class TextNode implements Node {
    private boolean mPrefix;
    private String mValue;
    private boolean mVerbatim;

    public TextNode(String str) {
        this.mPrefix = false;
        this.mVerbatim = false;
        this.mValue = (String) Preconditions.checkNotNull(str);
    }

    private void escapeString(StringBuilder sb) {
        for (int i = 0; i < this.mValue.length(); i++) {
            char cCharAt = this.mValue.charAt(i);
            if ((!this.mVerbatim && isSpecialCharacter(cCharAt)) || cCharAt == '\"') {
                sb.append('\\');
            } else if (!this.mVerbatim && isLatinLetter(cCharAt) && Character.isUpperCase(cCharAt)) {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
    }

    private boolean isLatinLetter(char c) {
        if (c < 'A' || c > 'Z') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    private boolean isSpecialCharacter(char c) {
        if (c == '\"' || c == '&' || c == ':' || c == '\\' || c == '|') {
            return true;
        }
        switch (c) {
            case '(':
            case ')':
            case '*':
                return true;
            default:
                switch (c) {
                    case ',':
                    case '-':
                    case '.':
                        return true;
                    default:
                        switch (c) {
                            case '<':
                            case s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                            case '>':
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TextNode.class == obj.getClass()) {
            TextNode textNode = (TextNode) obj;
            if (this.mPrefix == textNode.mPrefix && this.mVerbatim == textNode.mVerbatim && Objects.equals(this.mValue, textNode.mValue)) {
                return true;
            }
        }
        return false;
    }

    public String getValue() {
        return this.mValue;
    }

    public int hashCode() {
        return Objects.hash(this.mValue, Boolean.valueOf(this.mPrefix), Boolean.valueOf(this.mVerbatim));
    }

    public boolean isPrefix() {
        return this.mPrefix;
    }

    public boolean isVerbatim() {
        return this.mVerbatim;
    }

    public void setPrefix(boolean z10) {
        this.mPrefix = z10;
    }

    public void setValue(String str) {
        this.mValue = (String) Preconditions.checkNotNull(str);
    }

    public void setVerbatim(boolean z10) {
        this.mVerbatim = z10;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        if (this.mVerbatim) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        escapeString(sb);
        if (this.mVerbatim) {
            sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }
        if (this.mPrefix) {
            sb.append('*');
        }
        sb.append(')');
        return sb.toString();
    }

    public TextNode(TextNode textNode) {
        this.mPrefix = false;
        this.mVerbatim = false;
        Preconditions.checkNotNull(textNode);
        this.mValue = textNode.mValue;
        this.mPrefix = textNode.mPrefix;
        this.mVerbatim = textNode.mVerbatim;
    }
}
