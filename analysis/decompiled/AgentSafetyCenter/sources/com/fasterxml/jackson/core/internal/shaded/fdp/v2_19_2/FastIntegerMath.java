package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

import java.math.BigInteger;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class FastIntegerMath {
    public static final BigInteger FIVE = BigInteger.valueOf(5);
    static final BigInteger TEN_POW_16 = BigInteger.valueOf(10000000000000000L);
    static final BigInteger FIVE_POW_16 = BigInteger.valueOf(152587890625L);
    private static final BigInteger[] SMALL_POWERS_OF_TEN = {BigInteger.ONE, BigInteger.TEN, BigInteger.valueOf(100), BigInteger.valueOf(1000), BigInteger.valueOf(10000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(10000000), BigInteger.valueOf(100000000), BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L), BigInteger.valueOf(1000000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L)};

    private FastIntegerMath() {
    }

    public static BigInteger computePowerOfTen(NavigableMap<Integer, BigInteger> navigableMap, int i) {
        BigInteger[] bigIntegerArr = SMALL_POWERS_OF_TEN;
        if (i < bigIntegerArr.length) {
            return bigIntegerArr[i];
        }
        if (navigableMap == null) {
            return FIVE.pow(i).shiftLeft(i);
        }
        Map.Entry<Integer, BigInteger> entryFloorEntry = navigableMap.floorEntry(Integer.valueOf(i));
        Integer key = entryFloorEntry.getKey();
        return key.intValue() == i ? entryFloorEntry.getValue() : FftMultiplier.multiply(entryFloorEntry.getValue(), computePowerOfTen(navigableMap, i - key.intValue()));
    }

    public static BigInteger computeTenRaisedByNFloor16Recursive(NavigableMap<Integer, BigInteger> navigableMap, int i) {
        int i3 = i & (-16);
        Map.Entry<Integer, BigInteger> entryFloorEntry = navigableMap.floorEntry(Integer.valueOf(i3));
        int iIntValue = entryFloorEntry.getKey().intValue();
        BigInteger value = entryFloorEntry.getValue();
        if (iIntValue == i3) {
            return value;
        }
        int i10 = i3 - iIntValue;
        BigInteger bigIntegerComputeTenRaisedByNFloor16Recursive = navigableMap.get(Integer.valueOf(i10));
        if (bigIntegerComputeTenRaisedByNFloor16Recursive == null) {
            bigIntegerComputeTenRaisedByNFloor16Recursive = computeTenRaisedByNFloor16Recursive(navigableMap, i10);
            navigableMap.put(Integer.valueOf(i10), bigIntegerComputeTenRaisedByNFloor16Recursive);
        }
        return FftMultiplier.multiply(value, bigIntegerComputeTenRaisedByNFloor16Recursive);
    }

    public static NavigableMap<Integer, BigInteger> createPowersOfTenFloor16Map() {
        TreeMap treeMap = new TreeMap();
        treeMap.put(0, BigInteger.ONE);
        treeMap.put(16, TEN_POW_16);
        return treeMap;
    }

    public static long estimateNumBits(long j10) {
        return ((j10 * 3402) >>> 10) + 1;
    }

    public static NavigableMap<Integer, BigInteger> fillPowersOf10Floor16(int i, int i3) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(0, BigInteger.valueOf(5L));
        treeMap.put(16, FIVE_POW_16);
        fillPowersOfNFloor16Recursive(treeMap, i, i3);
        for (Map.Entry entry : treeMap.entrySet()) {
            entry.setValue(((BigInteger) entry.getValue()).shiftLeft(((Integer) entry.getKey()).intValue()));
        }
        return treeMap;
    }

    public static void fillPowersOfNFloor16Recursive(NavigableMap<Integer, BigInteger> navigableMap, int i, int i3) {
        if (i3 - i <= 18) {
            return;
        }
        int iSplitFloor16 = splitFloor16(i, i3);
        int i10 = i3 - iSplitFloor16;
        if (navigableMap.containsKey(Integer.valueOf(i10))) {
            return;
        }
        fillPowersOfNFloor16Recursive(navigableMap, i, iSplitFloor16);
        fillPowersOfNFloor16Recursive(navigableMap, iSplitFloor16, i3);
        navigableMap.put(Integer.valueOf(i10), computeTenRaisedByNFloor16Recursive(navigableMap, i10));
    }

    public static int splitFloor16(int i, int i3) {
        return i3 - ((((i3 - i) + 31) >>> 5) << 4);
    }

    public static long unsignedMultiplyHigh(long j10, long j11) {
        long j12 = j10 & 4294967295L;
        long j13 = j10 >>> 32;
        long j14 = j11 & 4294967295L;
        long j15 = j11 >>> 32;
        long j16 = j13 * j15;
        long j17 = j15 * j12;
        return j16 + ((((j13 * j14) + ((j12 * j14) >>> 32)) + (4294967295L & j17)) >>> 32) + (j17 >>> 32);
    }
}
