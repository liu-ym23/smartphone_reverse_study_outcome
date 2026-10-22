package org.json;

/* loaded from: classes4.dex */
public class ParserConfiguration {
    public static final int DEFAULT_MAXIMUM_NESTING_DEPTH = 512;
    public static final int UNDEFINED_MAXIMUM_NESTING_DEPTH = -1;
    protected boolean keepStrings;
    protected int maxNestingDepth;

    public ParserConfiguration() {
        this.keepStrings = false;
        this.maxNestingDepth = 512;
    }

    public int getMaxNestingDepth() {
        return this.maxNestingDepth;
    }

    public boolean isKeepStrings() {
        return this.keepStrings;
    }

    public <T extends ParserConfiguration> T withKeepStrings(boolean z10) {
        T t9 = (T) clone();
        t9.keepStrings = z10;
        return t9;
    }

    public <T extends ParserConfiguration> T withMaxNestingDepth(int i) {
        T t9 = (T) clone();
        if (i > -1) {
            t9.maxNestingDepth = i;
            return t9;
        }
        t9.maxNestingDepth = -1;
        return t9;
    }

    @Override // 
    public ParserConfiguration clone() {
        return new ParserConfiguration(this.keepStrings, this.maxNestingDepth);
    }

    public ParserConfiguration(boolean z10, int i) {
        this.keepStrings = z10;
        this.maxNestingDepth = i;
    }
}
