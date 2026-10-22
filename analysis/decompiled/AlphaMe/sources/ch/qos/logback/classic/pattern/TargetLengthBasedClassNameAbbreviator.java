package ch.qos.logback.classic.pattern;

/* loaded from: classes.dex */
public class TargetLengthBasedClassNameAbbreviator implements Abbreviator {
    final int targetLength;

    public TargetLengthBasedClassNameAbbreviator(int i4) {
        this.targetLength = i4;
    }

    public static int computeDotIndexes(String str, int[] iArr) {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int iIndexOf = str.indexOf(46, i4);
            if (iIndexOf == -1 || i5 >= 16) {
                break;
            }
            iArr[i5] = iIndexOf;
            i5++;
            i4 = iIndexOf + 1;
        }
        return i5;
    }

    public static void printArray(String str, int[] iArr) {
        System.out.print(str);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (i4 == 0) {
                System.out.print(iArr[i4]);
            } else {
                System.out.print(", " + iArr[i4]);
            }
        }
        System.out.println();
    }

    @Override // ch.qos.logback.classic.pattern.Abbreviator
    public String abbreviate(String str) {
        StringBuilder sb = new StringBuilder(this.targetLength);
        if (str == null) {
            throw new IllegalArgumentException("Class name may not be null");
        }
        if (str.length() < this.targetLength) {
            return str;
        }
        int[] iArr = new int[16];
        int[] iArr2 = new int[17];
        int iComputeDotIndexes = computeDotIndexes(str, iArr);
        if (iComputeDotIndexes == 0) {
            return str;
        }
        computeLengthArray(str, iArr, iArr2, iComputeDotIndexes);
        for (int i4 = 0; i4 <= iComputeDotIndexes; i4++) {
            if (i4 == 0) {
                sb.append(str.substring(0, iArr2[i4] - 1));
            } else {
                int i5 = iArr[i4 - 1];
                sb.append(str.substring(i5, iArr2[i4] + i5));
            }
        }
        return sb.toString();
    }

    public void computeLengthArray(String str, int[] iArr, int[] iArr2, int i4) {
        int length = str.length() - this.targetLength;
        int i5 = 0;
        while (i5 < i4) {
            int i6 = (iArr[i5] - (i5 > 0 ? iArr[i5 - 1] : -1)) - 1;
            int i7 = (length <= 0 || i6 < 1) ? i6 : 1;
            length -= i6 - i7;
            iArr2[i5] = i7 + 1;
            i5++;
        }
        iArr2[i4] = str.length() - iArr[i4 - 1];
    }
}
