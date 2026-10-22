package com.google.gson;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class FormattingStyle {
    public static final FormattingStyle COMPACT = null;
    public static final FormattingStyle PRETTY = null;
    private final String indent;
    private final String newline;
    private final boolean spaceAfterSeparators;

    static {
        COMPACT = new FormattingStyle("", "", false);
        PRETTY = new FormattingStyle("\n", "  ", true);
    }

    private FormattingStyle(String r2, String r3, boolean r4) {
        Objects.requireNonNull(r2, "newline == null");
        Objects.requireNonNull(r3, "indent == null");
        if (r2.matches("[\r\n]*") == false) goto L11;
        if (r3.matches("[ \t]*") == false) goto L9;
        this.newline = r2;
        this.indent = r3;
        this.spaceAfterSeparators = r4;
        return;
    L9:
        throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
    L11:
        throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
    }

    public FormattingStyle withNewline(String r3) {
        return new FormattingStyle(r3, this.indent, this.spaceAfterSeparators);
    }

    public FormattingStyle withIndent(String r3) {
        return new FormattingStyle(this.newline, r3, this.spaceAfterSeparators);
    }

    public FormattingStyle withSpaceAfterSeparators(boolean r3) {
        return new FormattingStyle(this.newline, this.indent, r3);
    }

    public String getNewline() {
        return this.newline;
    }

    public String getIndent() {
        return this.indent;
    }

    public boolean usesSpaceAfterSeparators() {
        return this.spaceAfterSeparators;
    }
}
