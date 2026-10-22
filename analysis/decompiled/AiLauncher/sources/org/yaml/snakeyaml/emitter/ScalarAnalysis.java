package org.yaml.snakeyaml.emitter;

/* loaded from: classes5.dex */
public final class ScalarAnalysis {
    private final boolean allowBlock;
    private final boolean allowBlockPlain;
    private final boolean allowFlowPlain;
    private final boolean allowSingleQuoted;
    private final boolean empty;
    private final boolean multiline;
    private final String scalar;

    public ScalarAnalysis(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.scalar = str;
        this.empty = z10;
        this.multiline = z11;
        this.allowFlowPlain = z12;
        this.allowBlockPlain = z13;
        this.allowSingleQuoted = z14;
        this.allowBlock = z15;
    }

    public String getScalar() {
        return this.scalar;
    }

    public boolean isAllowBlock() {
        return this.allowBlock;
    }

    public boolean isAllowBlockPlain() {
        return this.allowBlockPlain;
    }

    public boolean isAllowFlowPlain() {
        return this.allowFlowPlain;
    }

    public boolean isAllowSingleQuoted() {
        return this.allowSingleQuoted;
    }

    public boolean isEmpty() {
        return this.empty;
    }

    public boolean isMultiline() {
        return this.multiline;
    }
}
