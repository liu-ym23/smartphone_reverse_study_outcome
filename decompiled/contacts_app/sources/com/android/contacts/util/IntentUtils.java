package com.android.contacts.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.GlobalProxyLancet;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class IntentUtils {
    public IntentUtils() {
    }

    public static boolean getBooleanExtra(Intent r0, String r1, boolean r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getBooleanExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static byte getByteExtra(Intent r0, String r1, byte r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getByteExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static short getShortExtra(Intent r0, String r1, short r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getShortExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static char getCharExtra(Intent r0, String r1, char r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getCharExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static int getIntExtra(Intent r0, String r1, int r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getIntExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static long getLongExtra(Intent r0, String r1, long r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getLongExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static float getFloatExtra(Intent r0, String r1, float r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getFloatExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static double getDoubleExtra(Intent r0, String r1, double r2) {
        if (r0 != null) goto L9;
        return r2;
    L9:
        return r0.getDoubleExtra(r1, r2);
    L6:
        e = move-exception;
        e.printStackTrace();
        return r2;
    }

    public static String getStringExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getStringExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static CharSequence getCharSequenceExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getCharSequenceExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static <T extends Parcelable> T getParcelableExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return (T) r1.getParcelableExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Parcelable[] getParcelableArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getParcelableArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Serializable getSerializableExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getSerializableExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ArrayList<Integer> getIntegerArrayListExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getIntegerArrayListExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ArrayList<String> getStringArrayListExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getStringArrayListExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ArrayList<CharSequence> getCharSequenceArrayListExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getCharSequenceArrayListExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean[] getBooleanArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getBooleanArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static byte[] getByteArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getByteArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static short[] getShortArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getShortArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static char[] getCharArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getCharArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static int[] getIntArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getIntArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static long[] getLongArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getLongArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static float[] getFloatArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getFloatArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static double[] getDoubleArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getDoubleArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String[] getStringArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getStringArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static CharSequence[] getCharSequenceArrayExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getCharSequenceArrayExtra(r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static Bundle getBundleExtra(Intent r1, String r2) {
        if (r1 != null) goto L10;
        return null;
    L10:
        return GlobalProxyLancet.com_bytedance_sysoptimizer_BadParcelableLancet_getBundleExtra(r1, r2);
    L7:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static int[] getIntArray(Bundle r0, String r1) {
        return r0.getIntArray(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static String[] getStringArray(Bundle r0, String r1) {
        return r0.getStringArray(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean[] getBooleanArray(Bundle r0, String r1) {
        return r0.getBooleanArray(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static ArrayList<String> getStringArrayList(Bundle r0, String r1) {
        return r0.getStringArrayList(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
