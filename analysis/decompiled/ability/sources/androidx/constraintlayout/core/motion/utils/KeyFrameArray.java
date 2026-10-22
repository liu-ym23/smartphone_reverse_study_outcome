package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.CustomAttribute;
import androidx.constraintlayout.core.motion.CustomVariable;
import java.io.PrintStream;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class KeyFrameArray {

    public static class CustomArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomAttribute[] mValues = new CustomAttribute[101];

        public CustomArray() {
            clear();
        }

        public void append(int i, CustomAttribute customAttribute) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customAttribute;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "" : ", ");
                sb.append(valueAt(i));
                printStream.print(sb.toString());
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i6 = 0;
            int i10 = 0;
            while (true) {
                int i11 = this.mCount;
                if (i6 >= i11) {
                    this.mCount = i11 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i == iArr[i6]) {
                    iArr[i6] = 999;
                    i10++;
                }
                if (i6 != i10) {
                    iArr[i6] = iArr[i10];
                }
                i10++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomAttribute valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    public static class CustomVar {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        CustomVariable[] mValues = new CustomVariable[101];

        public CustomVar() {
            clear();
        }

        public void append(int i, CustomVariable customVariable) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = customVariable;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "" : ", ");
                sb.append(valueAt(i));
                printStream.print(sb.toString());
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i6 = 0;
            int i10 = 0;
            while (true) {
                int i11 = this.mCount;
                if (i6 >= i11) {
                    this.mCount = i11 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i == iArr[i6]) {
                    iArr[i6] = 999;
                    i10++;
                }
                if (i6 != i10) {
                    iArr[i6] = iArr[i10];
                }
                i10++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public CustomVariable valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }

    public static class FloatArray {
        private static final int EMPTY = 999;
        int mCount;
        int[] mKeys = new int[101];
        float[][] mValues = new float[101][];

        public FloatArray() {
            clear();
        }

        public void append(int i, float[] fArr) {
            if (this.mValues[i] != null) {
                remove(i);
            }
            this.mValues[i] = fArr;
            int[] iArr = this.mKeys;
            int i6 = this.mCount;
            this.mCount = i6 + 1;
            iArr[i6] = i;
            Arrays.sort(iArr);
        }

        public void clear() {
            Arrays.fill(this.mKeys, 999);
            Arrays.fill(this.mValues, (Object) null);
            this.mCount = 0;
        }

        public void dump() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.mKeys, this.mCount)));
            System.out.print("K: [");
            int i = 0;
            while (i < this.mCount) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append(i == 0 ? "" : ", ");
                sb.append(Arrays.toString(valueAt(i)));
                printStream.print(sb.toString());
                i++;
            }
            System.out.println("]");
        }

        public int keyAt(int i) {
            return this.mKeys[i];
        }

        public void remove(int i) {
            this.mValues[i] = null;
            int i6 = 0;
            int i10 = 0;
            while (true) {
                int i11 = this.mCount;
                if (i6 >= i11) {
                    this.mCount = i11 - 1;
                    return;
                }
                int[] iArr = this.mKeys;
                if (i == iArr[i6]) {
                    iArr[i6] = 999;
                    i10++;
                }
                if (i6 != i10) {
                    iArr[i6] = iArr[i10];
                }
                i10++;
                i6++;
            }
        }

        public int size() {
            return this.mCount;
        }

        public float[] valueAt(int i) {
            return this.mValues[this.mKeys[i]];
        }
    }
}
