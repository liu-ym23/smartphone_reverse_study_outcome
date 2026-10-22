package com.android.internal.util.jobs;

import android.util.ArraySet;
import android.util.EmptyArray;
import dalvik.system.VMRuntime;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class ArrayUtils {
    private static final int CACHE_SIZE = 73;
    public static final File[] EMPTY_FILE = null;
    private static Object[] sCache;

    public static native void zeroize(byte[] r0);

    public static native void zeroize(char[] r0);

    static {
        sCache = new Object[73];
        EMPTY_FILE = new File[0];
    }

    private ArrayUtils() {
    }

    public static byte[] newUnpaddedByteArray(int minLen) {
        return (byte[]) VMRuntime.getRuntime().newUnpaddedArray(Byte.TYPE, minLen);
    }

    public static char[] newUnpaddedCharArray(int minLen) {
        return (char[]) VMRuntime.getRuntime().newUnpaddedArray(Character.TYPE, minLen);
    }

    public static int[] newUnpaddedIntArray(int minLen) {
        return (int[]) VMRuntime.getRuntime().newUnpaddedArray(Integer.TYPE, minLen);
    }

    public static boolean[] newUnpaddedBooleanArray(int minLen) {
        return (boolean[]) VMRuntime.getRuntime().newUnpaddedArray(Boolean.TYPE, minLen);
    }

    public static long[] newUnpaddedLongArray(int minLen) {
        return (long[]) VMRuntime.getRuntime().newUnpaddedArray(Long.TYPE, minLen);
    }

    public static float[] newUnpaddedFloatArray(int minLen) {
        return (float[]) VMRuntime.getRuntime().newUnpaddedArray(Float.TYPE, minLen);
    }

    public static Object[] newUnpaddedObjectArray(int minLen) {
        return (Object[]) VMRuntime.getRuntime().newUnpaddedArray(Object.class, minLen);
    }

    public static <T> T[] newUnpaddedArray(Class<T> r1, int r2) {
        return (T[]) ((Object[]) VMRuntime.getRuntime().newUnpaddedArray(r1, r2));
    }

    public static byte[] newNonMovableByteArray(int length) {
        return (byte[]) VMRuntime.getRuntime().newNonMovableArray(Byte.TYPE, length);
    }

    public static char[] newNonMovableCharArray(int length) {
        return (char[]) VMRuntime.getRuntime().newNonMovableArray(Character.TYPE, length);
    }

    public static void zeroize$ravenwood(byte[] array) {
        if (array == null) goto L5;
        Arrays.fill(array, (byte) 0);
        return;
    }

    public static void zeroize$ravenwood(char[] array) {
        if (array == null) goto L5;
        Arrays.fill(array, 0);
        return;
    }

    public static boolean equals(byte[] array1, byte[] array2, int length) {
        if (length < 0) goto L24;
        if (array1 != array2) goto L7;
        return true;
    L7:
        if (array1 == null) goto L22;
        if (array2 == null) goto L22;
        if (array1.length < length) goto L22;
        if (array2.length < length) goto L22;
        int i = 0;
    L15:
        if (i >= length) goto L21;
        if (array1[i] != array2[i]) goto L18;
        i = i + 1;
        goto L15
    L18:
        return false;
    L21:
        return true;
    L22:
        return false;
    L24:
        throw new IllegalArgumentException();
    }

    public static <T> T[] emptyArray(Class<T> r3) {
        if (r3 == Object.class) goto L5;
        int r0 = (r3.hashCode() & Integer.MAX_VALUE) % 73;
        Object r1 = sCache[r0];
        if (r1 != null) goto L9;
    L10:
        r1 = Array.newInstance(r3, 0);
        sCache[r0] = r1;
    L12:
        return (T[]) ((Object[]) r1);
    L9:
        if (r1.getClass().getComponentType() == r3) goto L12;
    L5:
        return (T[]) EmptyArray.OBJECT;
    }

    public static <T> T[] emptyIfNull(T[] r1, Class<T> r2) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        return (T[]) emptyArray(r2);
    }

    public static boolean isEmpty(Collection<?> array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map != null) goto L4;
    L7:
        return true;
    L4:
        if (map.isEmpty() == true) goto L7;
        return false;
    }

    public static <T> boolean isEmpty(T[] array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(int[] array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(long[] array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(byte[] array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.length == 0) goto L7;
        return false;
    }

    public static boolean isEmpty(boolean[] array) {
        if (array != null) goto L4;
    L7:
        return true;
    L4:
        if (array.length == 0) goto L7;
        return false;
    }

    public static int size(Object[] array) {
        if (array != null) goto L5;
        return 0;
    L5:
        return array.length;
    }

    public static int size(Collection<?> collection) {
        if (collection != null) goto L5;
        return 0;
    L5:
        return collection.size();
    }

    public static int size(Map<?, ?> map) {
        if (map != null) goto L5;
        return 0;
    L5:
        return map.size();
    }

    public static <T> boolean contains(T[] array, T value) {
        if (indexOf(array, value) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> int indexOf(T[] array, T value) {
        if (array != null) goto L5;
        return -1;
    L5:
        int i = 0;
    L7:
        if (i >= array.length) goto L13;
        if (Objects.equals(array[i], value) == true) goto L10;
        i = i + 1;
        goto L7
    L10:
        return i;
    L13:
        return -1;
    }

    public static <T> boolean containsAll(T[] array, T[] check) {
        if (check != null) goto L5;
        return true;
    L5:
        int r1 = check.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        T checkItem = check[r3];
        if (contains(array, checkItem) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static <T> boolean containsAny(T[] array, T[] check) {
        if (check != null) goto L5;
        return false;
    L5:
        int r1 = check.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        T checkItem = check[r2];
        if (contains(array, checkItem) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean contains(int[] array, int value) {
        if (array != null) goto L5;
        return false;
    L5:
        int r1 = array.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        int element = array[r2];
        if (element == value) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean contains(long[] array, long value) {
        if (array != null) goto L5;
        return false;
    L5:
        int r1 = array.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        long element = array[r2];
        if (element == value) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean contains(char[] array, char value) {
        if (array != null) goto L5;
        return false;
    L5:
        int r1 = array.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        char element = array[r2];
        if (element == value) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static <T> boolean containsAll(char[] array, char[] check) {
        if (check != null) goto L5;
        return true;
    L5:
        int r1 = check.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        char checkItem = check[r3];
        if (contains(array, checkItem) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static long total(long[] array) {
        long total = 0;
        if (array == null) goto L8;
        int r2 = array.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        long value = array[r3];
        total = total + value;
        r3 = r3 + 1;
    L8:
        return total;
    }

    @Deprecated
    public static int[] convertToIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        int i = 0;
    L4:
        if (i >= list.size()) goto L7;
        array[i] = list.get(i).intValue();
        i = i + 1;
        goto L4
    L7:
        return array;
    }

    public static int[] convertToIntArray(ArraySet<Integer> set) {
        int size = set.size();
        int[] array = new int[size];
        int i = 0;
    L3:
        if (i >= size) goto L6;
        array[i] = set.valueAt(i).intValue();
        i = i + 1;
        goto L3
    L6:
        return array;
    }

    public static long[] convertToLongArray(int[] intArray) {
        if (intArray != null) goto L5;
        return null;
    L5:
        long[] array = new long[intArray.length];
        int i = 0;
    L7:
        if (i >= intArray.length) goto L10;
        array[i] = intArray[i];
        i = i + 1;
        goto L7
    L10:
        return array;
    }

    public static <T> T[] concat(Class<T> r8, T[]... r9) {
        if (r9 == null) goto L27;
        if (r9.length == 0) goto L27;
        int r0 = 0;
        int r1 = r9.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L13;
        T[] r4 = r9[r3];
        if (r4 == null) goto L12;
        r0 = r0 + r4.length;
    L12:
        r3 = r3 + 1;
        goto L7
    L13:
        if (r0 == 0) goto L15;
        T[] r2 = (T[]) ((Object[]) Array.newInstance(r8, r0));
        int r5 = 0;
        int r6 = r9.length;
        int r7 = 0;
    L17:
        if (r7 >= r6) goto L25;
        T[] r10 = r9[r7];
        if (r10 == null) goto L24;
        if (r10.length == 0) goto L24;
        System.arraycopy(r10, 0, r2, r5, r10.length);
        r5 = r5 + r10.length;
    L24:
        r7 = r7 + 1;
        goto L17
    L25:
        return r2;
    L15:
        return (T[]) createEmptyArray(r8);
    L27:
        return (T[]) createEmptyArray(r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> T[] createEmptyArray(Class<T> r1) {
        if (r1 != String.class) goto L7;
        return (T[]) EmptyArray.STRING;
    L7:
        if (r1 != Object.class) goto L11;
        return (T[]) EmptyArray.OBJECT;
    L11:
        return (T[]) ((Object[]) Array.newInstance(r1, 0));
    }

    public static byte[] concat(byte[]... arrays) {
        if (arrays == null) goto L5;
        int totalLength = 0;
        int r2 = arrays.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        byte[] a = arrays[r3];
        if (a == null) goto L11;
        totalLength = totalLength + a.length;
    L11:
        r3 = r3 + 1;
        goto L7
    L12:
        byte[] result = new byte[totalLength];
        int pos = 0;
        int r4 = arrays.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L18;
        byte[] a2 = arrays[r5];
        if (a2 == null) goto L17;
        System.arraycopy(a2, 0, result, pos, a2.length);
        pos = pos + a2.length;
    L17:
        r5 = r5 + 1;
        goto L13
    L18:
        return result;
    L5:
        return new byte[0];
    }

    public static <T> T[] appendElement(Class<T> r1, T[] r2, T r3) {
        return (T[]) appendElement(r1, r2, r3, false);
    }

    public static <T> T[] appendElement(Class<T> r3, T[] r4, T r5, boolean r6) {
        if (r4 == null) goto L8;
        if (r6 == false) goto L5;
    L7:
        int r0 = r4.length;
        T[] r1 = (T[]) ((Object[]) Array.newInstance(r3, r0 + 1));
        System.arraycopy(r4, 0, r1, 0, r0);
    L9:
        r1[r0] = r5;
        return r1;
    L5:
        if (contains(r4, r5) == false) goto L7;
        return r4;
    L8:
        r0 = 0;
        r1 = (T[]) ((Object[]) Array.newInstance(r3, 1));
        goto L9
    }

    public static <T> T[] removeElement(Class<T> r6, T[] r7, T r8) {
        if (r7 != null) goto L4;
    L17:
        return r7;
    L4:
        if (contains(r7, r8) == true) goto L6;
        return r7;
    L6:
        int r0 = r7.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L17;
        if (Objects.equals(r7[r1], r8) == true) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        if (r0 != 1) goto L14;
        return null;
    L14:
        T[] r3 = (T[]) ((Object[]) Array.newInstance(r6, r0 - 1));
        System.arraycopy(r7, 0, r3, 0, r1);
        System.arraycopy(r7, r1 + 1, r3, r1, (r0 - r1) - 1);
        return r3;
    }

    public static int[] appendInt(int[] cur, int val, boolean allowDuplicates) {
        if (cur == null) goto L4;
        int N = cur.length;
        if (allowDuplicates == true) goto L13;
        int i = 0;
    L8:
        if (i >= N) goto L13;
        if (cur[i] == val) goto L11;
        i = i + 1;
        goto L8
    L11:
        return cur;
    L13:
        int i2 = N + 1;
        int[] ret = new int[i2];
        System.arraycopy(cur, 0, ret, 0, N);
        ret[N] = val;
        return ret;
    L4:
        return new int[]{val};
    }

    public static int[] appendInt(int[] cur, int val) {
        return appendInt(cur, val, false);
    }

    public static int[] removeInt(int[] cur, int val) {
        if (cur != null) goto L5;
        return null;
    L5:
        int N = cur.length;
        int i = 0;
    L6:
        if (i >= N) goto L18;
        if (cur[i] == val) goto L9;
        i = i + 1;
        goto L6
    L9:
        int[] ret = new int[N - 1];
        if (i <= 0) goto L13;
        System.arraycopy(cur, 0, ret, 0, i);
    L13:
        if (i >= (N - 1)) goto L15;
        System.arraycopy(cur, i + 1, ret, i, (N - i) - 1);
    L15:
        return ret;
    L18:
        return cur;
    }

    public static String[] removeString(String[] cur, String val) {
        if (cur != null) goto L5;
        return null;
    L5:
        int N = cur.length;
        int i = 0;
    L6:
        if (i >= N) goto L18;
        if (Objects.equals(cur[i], val) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        String[] ret = new String[N - 1];
        if (i <= 0) goto L13;
        System.arraycopy(cur, 0, ret, 0, i);
    L13:
        if (i >= (N - 1)) goto L15;
        System.arraycopy(cur, i + 1, ret, i, (N - i) - 1);
    L15:
        return ret;
    L18:
        return cur;
    }

    public static long[] appendLong(long[] cur, long val, boolean allowDuplicates) {
        if (cur == null) goto L5;
        int N = cur.length;
        if (allowDuplicates == true) goto L14;
        int i = 0;
    L9:
        if (i >= N) goto L14;
        if (cur[i] == val) goto L12;
        i = i + 1;
        goto L9
    L12:
        return cur;
    L14:
        long[] ret = new long[1 + N];
        System.arraycopy(cur, 0, ret, 0, N);
        ret[N] = val;
        return ret;
    L5:
        return new long[]{val};
    }

    public static boolean[] appendBooleanDuplicatesAllowed(boolean[] cur, boolean val) {
        if (cur == null) goto L5;
        int N = cur.length;
        boolean[] ret = new boolean[1 + N];
        System.arraycopy(cur, 0, ret, 0, N);
        ret[N] = val;
        return ret;
    L5:
        return new boolean[]{val};
    }

    public static long[] appendLong(long[] cur, long val) {
        return appendLong(cur, val, false);
    }

    public static long[] removeLong(long[] cur, long val) {
        if (cur != null) goto L5;
        return null;
    L5:
        int N = cur.length;
        int i = 0;
    L6:
        if (i >= N) goto L18;
        if (cur[i] == val) goto L9;
        i = i + 1;
        goto L6
    L9:
        long[] ret = new long[N - 1];
        if (i <= 0) goto L13;
        System.arraycopy(cur, 0, ret, 0, i);
    L13:
        if (i >= (N - 1)) goto L15;
        System.arraycopy(cur, i + 1, ret, i, (N - i) - 1);
    L15:
        return ret;
    L18:
        return cur;
    }

    public static long[] cloneOrNull(long[] array) {
        if (array != null) goto L6;
        return null;
    L6:
        return (long[]) array.clone();
    }

    public static <T> T[] cloneOrNull(T[] r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (T[]) ((Object[]) r1.clone());
    }

    public static <T> ArraySet<T> cloneOrNull(ArraySet<T> array) {
        if (array != null) goto L6;
        return null;
    L6:
        return new ArraySet(array);
    }

    public static <T> ArraySet<T> add(ArraySet<T> cur, T val) {
        if (cur != null) goto L4;
        cur = new ArraySet();
    L4:
        cur.add(val);
        return cur;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> ArraySet<T> addAll(ArraySet<T> cur, Collection<T> r2) {
        if (cur != null) goto L4;
        cur = new ArraySet();
    L4:
        if (r2 == 0) goto L6;
        cur.addAll(r2);
    L6:
        return cur;
    }

    public static <T> ArraySet<T> remove(ArraySet<T> cur, T val) {
        if (cur != null) goto L5;
        return null;
    L5:
        cur.remove(val);
        if (cur.isEmpty() == false) goto L8;
        return null;
    L8:
        return cur;
    }

    public static <T> ArrayList<T> add(ArrayList<T> cur, T val) {
        if (cur != null) goto L4;
        cur = new ArrayList();
    L4:
        cur.add(val);
        return cur;
    }

    public static <T> ArrayList<T> add(ArrayList<T> cur, int index, T val) {
        if (cur != null) goto L4;
        cur = new ArrayList();
    L4:
        cur.add(index, val);
        return cur;
    }

    public static <T> ArrayList<T> remove(ArrayList<T> cur, T val) {
        if (cur != null) goto L5;
        return null;
    L5:
        cur.remove(val);
        if (cur.isEmpty() == false) goto L8;
        return null;
    L8:
        return cur;
    }

    public static <T> boolean contains(Collection<T> cur, T val) {
        if (cur != null) goto L6;
        return false;
    L6:
        return cur.contains(val);
    }

    public static <T> T[] trimToSize(T[] r1, int r2) {
        if (r1 == null) goto L10;
        if (r2 != 0) goto L6;
        return null;
    L6:
        if (r1.length != r2) goto L9;
        return r1;
    L9:
        return (T[]) Arrays.copyOf(r1, r2);
    L10:
        return null;
    }

    public static <T> boolean referenceEquals(ArrayList<T> a, ArrayList<T> b) {
        if (a != b) goto L5;
        return true;
    L5:
        int sizeA = a.size();
        int sizeB = b.size();
        if (sizeA == sizeB) goto L8;
        return false;
    L8:
        boolean diff = false;
        int i = 0;
    L9:
        if (i >= sizeA) goto L17;
        if (diff == true) goto L17;
        if (a.get(i) == b.get(i)) goto L14;
        boolean r6 = true;
    L15:
        diff = diff | r6;
        i = i + 1;
        goto L9
    L14:
        r6 = false;
    L17:
        return !diff;
    }

    public static <T> int unstableRemoveIf(ArrayList<T> collection, Predicate<T> predicate) {
        if (collection != null) goto L5;
        return 0;
    L5:
        int size = collection.size();
        int leftIdx = 0;
        int rightIdx = size - 1;
    L7:
        if (leftIdx > rightIdx) goto L19;
    L8:
        if (leftIdx >= size) goto L12;
        if (predicate.test(collection.get(leftIdx)) == true) goto L12;
        leftIdx = leftIdx + 1;
    L12:
        if (rightIdx <= leftIdx) goto L16;
        if (predicate.test(collection.get(rightIdx)) == false) goto L16;
        rightIdx = rightIdx - 1;
    L16:
        if (leftIdx >= rightIdx) goto L19;
        Collections.swap(collection, leftIdx, rightIdx);
        leftIdx = leftIdx + 1;
        rightIdx = rightIdx - 1;
    L19:
        int i = size - 1;
    L20:
        if (i < leftIdx) goto L22;
        collection.remove(i);
        i = i - 1;
        goto L20
    L22:
        int i2 = size - leftIdx;
        return i2;
    }

    public static int[] defeatNullable(int[] val) {
        if (val == null) goto L5;
        return val;
    L5:
        return EmptyArray.INT;
    }

    public static String[] defeatNullable(String[] val) {
        if (val == null) goto L5;
        return val;
    L5:
        return EmptyArray.STRING;
    }

    public static File[] defeatNullable(File[] val) {
        if (val == null) goto L5;
        return val;
    L5:
        return EMPTY_FILE;
    }

    public static void checkBounds(int len, int index) {
        if (index < 0) goto L6;
        if (len <= index) goto L6;
        return;
    L6:
        throw new ArrayIndexOutOfBoundsException("length=" + len + "; index=" + index);
    }

    public static void throwsIfOutOfBounds(int len, int offset, int count) {
        if (len < 0) goto L11;
        if ((offset | count) < 0) goto L9;
        if (offset > (len - count)) goto L9;
        return;
    L9:
        throw new ArrayIndexOutOfBoundsException("length=" + len + "; regionStart=" + offset + "; regionLength=" + count);
    L11:
        throw new ArrayIndexOutOfBoundsException("Negative length: " + len);
    }

    public static <T> T[] filterNotNull(T[] val, IntFunction<T[]> arrayConstructor) {
        int nullCount = 0;
        int size = size(val);
        int i = 0;
    L3:
        if (i >= size) goto L9;
        if (val[i] != null) goto L7;
        nullCount = nullCount + 1;
    L7:
        i = i + 1;
        goto L3
    L9:
        if (nullCount != 0) goto L11;
        return val;
    L11:
        T[] result = arrayConstructor.apply(size - nullCount);
        int outIdx = 0;
        int i2 = 0;
    L12:
        if (i2 >= size) goto L18;
        if (val[i2] == null) goto L16;
        result[outIdx] = val[i2];
        outIdx = outIdx + 1;
    L16:
        i2 = i2 + 1;
        goto L12
    L18:
        return result;
    }

    public static <T> T[] filter(T[] items, IntFunction<T[]> arrayConstructor, Predicate<T> predicate) {
        if (isEmpty(items) == false) goto L5;
        return items;
    L5:
        int matchesCount = 0;
        int size = size(items);
        boolean[] tests = new boolean[size];
        int i = 0;
    L6:
        if (i >= size) goto L11;
        tests[i] = predicate.test(items[i]);
        if (tests[i] == false) goto L10;
        matchesCount = matchesCount + 1;
    L10:
        i = i + 1;
        goto L6
    L11:
        int i2 = items.length;
        if (matchesCount != i2) goto L14;
        return items;
    L14:
        T[] result = arrayConstructor.apply(matchesCount);
        if (matchesCount != 0) goto L17;
        return result;
    L17:
        int outIdx = 0;
        int i3 = 0;
    L18:
        if (i3 >= size) goto L24;
        if (tests[i3] == false) goto L22;
        result[outIdx] = items[i3];
        outIdx = outIdx + 1;
    L22:
        i3 = i3 + 1;
        goto L18
    L24:
        return result;
    }

    public static boolean startsWith(byte[] cur, byte[] val) {
        if (cur == null) goto L18;
        if (val == null) goto L18;
        if (cur.length >= val.length) goto L9;
        return false;
    L9:
        int i = 0;
    L11:
        if (i >= val.length) goto L16;
        if (cur[i] != val[i]) goto L14;
        i = i + 1;
        goto L11
    L14:
        return false;
    L16:
        return true;
    L18:
        return false;
    }

    public static <T> T find(T[] items, Predicate<T> predicate) {
        if (isEmpty(items) == false) goto L5;
        return null;
    L5:
        int r0 = items.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        T item = items[r2];
        if (predicate.test(item) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return item;
    L11:
        return null;
    }

    public static String deepToString(Object value) {
        if (value == null) goto L40;
        if (value.getClass().isArray() == false) goto L40;
        if (value.getClass() != boolean[].class) goto L10;
        return Arrays.toString((boolean[]) value);
    L10:
        if (value.getClass() != byte[].class) goto L14;
        return Arrays.toString((byte[]) value);
    L14:
        if (value.getClass() != char[].class) goto L18;
        return Arrays.toString((char[]) value);
    L18:
        if (value.getClass() != double[].class) goto L22;
        return Arrays.toString((double[]) value);
    L22:
        if (value.getClass() != float[].class) goto L26;
        return Arrays.toString((float[]) value);
    L26:
        if (value.getClass() != int[].class) goto L30;
        return Arrays.toString((int[]) value);
    L30:
        if (value.getClass() != long[].class) goto L34;
        return Arrays.toString((long[]) value);
    L34:
        if (value.getClass() != short[].class) goto L38;
        return Arrays.toString((short[]) value);
    L38:
        return Arrays.deepToString((Object[]) value);
    L40:
        return String.valueOf(value);
    }

    public static <T> T getOrNull(T[] items, int i) {
        if (items != null) goto L4;
    L6:
        return null;
    L4:
        if (items.length <= i) goto L6;
        return items[i];
    }

    public static <T> T firstOrNull(T[] items) {
        if (items.length > 0) goto L7;
        return null;
    L7:
        return items[0];
    }

    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList(array.length);
        int r1 = array.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        T item = array[r2];
        list.add(item);
        r2 = r2 + 1;
        goto L3
    L5:
        return list;
    }
}
