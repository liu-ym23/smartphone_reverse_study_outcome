package com.obric.oui.constraintlayout.core.parser;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class CLElement implements Cloneable {
    protected static int sBaseIndent = 2;
    protected static int sMaxLine = 80;
    protected CLContainer mContainer;
    private final char[] mContent;
    protected long mEnd;
    private int mLine;
    protected long mStart;

    static {
    }

    protected String toFormattedJSON(int r1, int r2) {
        return "";
    }

    protected String toJSON() {
        return "";
    }

    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo442clone() throws CloneNotSupportedException {
        return clone();
    }

    public CLElement(char[] r3) {
        this.mStart = -1;
        this.mEnd = Long.MAX_VALUE;
        this.mContent = r3;
    }

    public boolean notStarted() {
        if (this.mStart != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void setLine(int r1) {
        this.mLine = r1;
    }

    public int getLine() {
        return this.mLine;
    }

    public void setStart(long r1) {
        this.mStart = r1;
    }

    public long getStart() {
        return this.mStart;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public void setEnd(long r5) {
        if (this.mEnd == Long.MAX_VALUE) goto L5;
        return;
    L5:
        this.mEnd = r5;
        if (CLParser.sDebug == false) goto L8;
        System.out.println("closing " + hashCode() + " -> " + this);
    L8:
        CLContainer r6 = this.mContainer;
        if (r6 == null) goto L12;
        r6.add(this);
        return;
    }

    protected void addIndent(StringBuilder r2, int r3) {
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L5;
        r2.append(' ');
        r1 = r1 + 1;
        goto L3
    }

    public String toString() {
        long r0 = this.mStart;
        long r2 = this.mEnd;
        if (r0 > r2) goto L10;
        if (r2 == Long.MAX_VALUE) goto L10;
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1) + ">>";
    L10:
        return getClass() + " (INVALID, " + this.mStart + "-" + this.mEnd + ")";
    }

    protected String getStrClass() {
        String r1 = getClass().toString();
        return r1.substring(r1.lastIndexOf(46) + 1);
    }

    protected String getDebugName() {
        if (CLParser.sDebug == true) goto L5;
        return "";
    L5:
        return getStrClass() + " -> ";
    }

    public String content() {
        String r0 = new String(this.mContent);
        if (r0.length() >= 1) goto L6;
        return "";
    L6:
        long r3 = this.mEnd;
        if (r3 == Long.MAX_VALUE) goto L13;
        long r5 = this.mStart;
        if (r3 < r5) goto L13;
        return r0.substring((int) r5, ((int) r3) + 1);
    L13:
        long r4 = this.mStart;
        return r0.substring((int) r4, ((int) r4) + 1);
    }

    public boolean hasContent() {
        char[] r1 = this.mContent;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.length < 1) goto L7;
        return true;
    }

    public boolean isDone() {
        if (this.mEnd == Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public void setContainer(CLContainer r1) {
        this.mContainer = r1;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public boolean isStarted() {
        if (this.mStart <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public int getInt() {
        if ((this instanceof CLNumber) == true) goto L5;
        return 0;
    L5:
        return ((CLNumber) this).getInt();
    }

    public float getFloat() {
        if ((this instanceof CLNumber) == true) goto L5;
        return Float.NaN;
    L5:
        return ((CLNumber) this).getFloat();
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if ((r7 instanceof CLElement) == true) goto L8;
        return false;
    L8:
        CLElement r8 = (CLElement) r7;
        if (this.mStart == r8.mStart) goto L12;
        return false;
    L12:
        if (this.mEnd == r8.mEnd) goto L15;
        return false;
    L15:
        if (this.mLine == r8.mLine) goto L18;
        return false;
    L18:
        if (Arrays.equals(this.mContent, r8.mContent) == true) goto L21;
        return false;
    L21:
        return Objects.equals(this.mContainer, r8.mContainer);
    }

    public int hashCode() {
        int r0 = Arrays.hashCode(this.mContent) * 31;
        long r1 = this.mStart;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.mEnd;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        CLContainer r5 = this.mContainer;
        if (r5 == null) goto L5;
        int r6 = r5.hashCode();
    L7:
        return ((r4 + r6) * 31) + this.mLine;
    L5:
        r6 = 0;
        goto L7
    }

    public CLElement clone() {
        return (CLElement) super.clone();
    L5:
        throw new AssertionError();
    }
}
