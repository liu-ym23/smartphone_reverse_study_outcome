package junit.framework;

import com.android.contacts.util.HanziToPinyin;

/* JADX INFO: loaded from: classes4.dex */
public class ComparisonCompactor {
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";
    private static final String ELLIPSIS = "...";
    private String fActual;
    private int fContextLength;
    private String fExpected;
    private int fPrefix;
    private int fSuffix;

    public ComparisonCompactor(int r1, String r2, String r3) {
        this.fContextLength = r1;
        this.fExpected = r2;
        this.fActual = r3;
    }

    public String compact(String r3) {
        if (this.fExpected == null) goto L12;
        if (this.fActual == null) goto L12;
        if (areStringsEqual() == true) goto L12;
        findCommonPrefix();
        findCommonSuffix();
        return format(r3, compactString(this.fExpected), compactString(this.fActual));
    L12:
        return format(r3, this.fExpected, this.fActual);
    }

    private String compactString(String r5) {
        String r6 = DELTA_START + r5.substring(this.fPrefix, (r5.length() - this.fSuffix) + 1) + DELTA_END;
        if (this.fPrefix <= 0) goto L6;
        r6 = computeCommonPrefix() + r6;
    L6:
        if (this.fSuffix > 0) goto L8;
        return r6;
    L8:
        return r6 + computeCommonSuffix();
    }

    private void findCommonPrefix() {
        this.fPrefix = 0;
        int r0 = Math.min(this.fExpected.length(), this.fActual.length());
    L3:
        int r1 = this.fPrefix;
        if (r1 >= r0) goto L9;
        if (this.fExpected.charAt(r1) != this.fActual.charAt(this.fPrefix)) goto L12;
        this.fPrefix++;
        goto L3
    L12:
        return;
    }

    private void findCommonSuffix() {
        int r0 = this.fExpected.length() - 1;
        int r1 = this.fActual.length() - 1;
    L3:
        int r2 = this.fPrefix;
        if (r1 < r2) goto L10;
        if (r0 < r2) goto L10;
        if (this.fExpected.charAt(r0) != this.fActual.charAt(r1)) goto L10;
        r1 = r1 - 1;
        r0 = r0 - 1;
    L10:
        this.fSuffix = this.fExpected.length() - r0;
    }

    private String computeCommonPrefix() {
        StringBuilder r0 = new StringBuilder();
        if (this.fPrefix <= this.fContextLength) goto L5;
        String r1 = ELLIPSIS;
    L7:
        return r0.append(r1).append(this.fExpected.substring(Math.max(0, this.fPrefix - this.fContextLength), this.fPrefix)).toString();
    L5:
        r1 = "";
        goto L7
    }

    private String computeCommonSuffix() {
        int r0 = Math.min(((this.fExpected.length() - this.fSuffix) + 1) + this.fContextLength, this.fExpected.length());
        StringBuilder r1 = new StringBuilder();
        String r2 = this.fExpected;
        StringBuilder r3 = r1.append(r2.substring((r2.length() - this.fSuffix) + 1, r0));
        if (((this.fExpected.length() - this.fSuffix) + 1) >= (this.fExpected.length() - this.fContextLength)) goto L5;
        String r5 = ELLIPSIS;
    L7:
        return r3.append(r5).toString();
    L5:
        r5 = "";
        goto L7
    }

    private boolean areStringsEqual() {
        return this.fExpected.equals(this.fActual);
    }

    private static String format(String r1, Object r2, Object r3) {
        if (r1 != null) goto L4;
    L6:
        String r4 = "";
    L8:
        return r4 + "expected:<" + r2 + "> but was:<" + r3 + ">";
    L4:
        if (r1.length() <= 0) goto L6;
        r4 = r1 + HanziToPinyin.Token.SEPARATOR;
        goto L8
    }
}
