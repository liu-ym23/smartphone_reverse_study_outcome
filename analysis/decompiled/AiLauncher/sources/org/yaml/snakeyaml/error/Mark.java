package org.yaml.snakeyaml.error;

import java.io.Serializable;
import org.yaml.snakeyaml.scanner.Constant;

/* loaded from: classes5.dex */
public final class Mark implements Serializable {
    private final int[] buffer;
    private final int column;
    private final int index;
    private final int line;
    private final String name;
    private final int pointer;

    public Mark(String str, int i10, int i11, int i12, char[] cArr, int i13) {
        this(str, i10, i11, i12, toCodePoints(cArr), i13);
    }

    private boolean isLineBreak(int i10) {
        return Constant.NULL_OR_LINEBR.has(i10);
    }

    private static int[] toCodePoints(char[] cArr) {
        int iCharCount = 0;
        int[] iArr = new int[Character.codePointCount(cArr, 0, cArr.length)];
        int i10 = 0;
        while (iCharCount < cArr.length) {
            int iCodePointAt = Character.codePointAt(cArr, iCharCount);
            iArr[i10] = iCodePointAt;
            iCharCount += Character.charCount(iCodePointAt);
            i10++;
        }
        return iArr;
    }

    public int[] getBuffer() {
        return this.buffer;
    }

    public int getColumn() {
        return this.column;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLine() {
        return this.line;
    }

    public String getName() {
        return this.name;
    }

    public int getPointer() {
        return this.pointer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        r3 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String get_snippet(int r9, int r10) {
        /*
            r8 = this;
            float r10 = (float) r10
            r0 = 1073741824(0x40000000, float:2.0)
            float r10 = r10 / r0
            r0 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 - r0
            int r0 = r8.pointer
        L9:
            java.lang.String r1 = " ... "
            java.lang.String r2 = ""
            if (r0 <= 0) goto L2b
            int[] r3 = r8.buffer
            int r4 = r0 + (-1)
            r3 = r3[r4]
            boolean r3 = r8.isLineBreak(r3)
            if (r3 != 0) goto L2b
            int r3 = r0 + (-1)
            int r4 = r8.pointer
            int r4 = r4 - r3
            float r4 = (float) r4
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 <= 0) goto L29
            int r0 = r0 + 4
            r3 = r1
            goto L2c
        L29:
            r0 = r3
            goto L9
        L2b:
            r3 = r2
        L2c:
            int r4 = r8.pointer
        L2e:
            int[] r5 = r8.buffer
            int r6 = r5.length
            if (r4 >= r6) goto L4b
            r5 = r5[r4]
            boolean r5 = r8.isLineBreak(r5)
            if (r5 != 0) goto L4b
            int r5 = r4 + 1
            int r6 = r8.pointer
            int r6 = r5 - r6
            float r6 = (float) r6
            int r6 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r6 <= 0) goto L49
            int r4 = r4 + (-4)
            goto L4c
        L49:
            r4 = r5
            goto L2e
        L4b:
            r1 = r2
        L4c:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r2 = 0
            r5 = r2
        L53:
            java.lang.String r6 = " "
            if (r5 >= r9) goto L5d
            r10.append(r6)
            int r5 = r5 + 1
            goto L53
        L5d:
            r10.append(r3)
            r5 = r0
        L61:
            if (r5 >= r4) goto L6d
            int[] r7 = r8.buffer
            r7 = r7[r5]
            r10.appendCodePoint(r7)
            int r5 = r5 + 1
            goto L61
        L6d:
            r10.append(r1)
            java.lang.String r1 = "\n"
            r10.append(r1)
        L75:
            int r1 = r8.pointer
            int r1 = r1 + r9
            int r1 = r1 - r0
            int r4 = r3.length()
            int r1 = r1 + r4
            if (r2 >= r1) goto L86
            r10.append(r6)
            int r2 = r2 + 1
            goto L75
        L86:
            java.lang.String r8 = "^"
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.yaml.snakeyaml.error.Mark.get_snippet(int, int):java.lang.String");
    }

    public String toString() {
        return " in " + this.name + ", line " + (this.line + 1) + ", column " + (this.column + 1) + ":\n" + get_snippet();
    }

    public Mark(String str, int i10, int i11, int i12, int[] iArr, int i13) {
        this.name = str;
        this.index = i10;
        this.line = i11;
        this.column = i12;
        this.buffer = iArr;
        this.pointer = i13;
    }

    public String get_snippet() {
        return get_snippet(4, 75);
    }
}
