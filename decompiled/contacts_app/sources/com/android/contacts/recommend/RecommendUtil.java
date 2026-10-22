package com.android.contacts.recommend;

import android.content.Context;
import android.os.Parcel;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.google.common.io.Closeables;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendUtil {
    private static final boolean DEBUG = false;
    private static final String RECOMMEND_DATA_FILE = "recommend.par";
    private static final byte RECOMMEND_DATA_VERSION = 3;
    private static final String TAG = "RecommendUtil";
    private static float[] sFrequentFactor;

    public RecommendUtil() {
    }

    static /* synthetic */ boolean access$000() {
        return DEBUG;
    }

    static {
        DEBUG = ContactsUtils.DEBUG;
    }

    public static void saveRecommendDataToFile(final Context r2, final List<BaseFlowAdapter.FlowEntry> r3) {
        if (ContactsUtils.DEBUG == false) goto L9;
        StringBuilder r0 = new StringBuilder("saveRecommendDataToFile: ");
        if (r3 != null) goto L7;
        Integer r1 = null;
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r0.append(r1).toString());
        goto L9
    L7:
        r1 = Integer.valueOf(r3.size());
    L9:
        Thread r4 = new Thread(new AnonymousClass1(r3, r2), "SaveRecommendData");
        r4.setPriority(10);
        r4.start();
    }

    public static List<BaseFlowAdapter.FlowEntry> loadRecommendDataFromFile() {
        Context r3 = ContactsApplication.getInstance().getApplicationContext();
        ArrayList r4 = new ArrayList();
        Parcel r5 = Parcel.obtain();
        FileInputStream r6 = null;
        r6 = r3.openFileInput(RECOMMEND_DATA_FILE);     // Catch: Throwable -> L43 Exception -> L45
        byte[] r7 = new byte[r6.available()];     // Catch: Throwable -> L43 Exception -> L45
        r5.unmarshall(r7, 0, r6.read(r7));     // Catch: Throwable -> L43 Exception -> L45
        r5.setDataPosition(0);     // Catch: Throwable -> L43 Exception -> L45
        if (r5.readByte() == 3) goto L13;
        Closeables.closeQuietly(r6);
        r5.recycle();
        if (DEBUG == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Cached recommend datas: " + r4);
    L10:
        if (r4.isEmpty() == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Recommend data from cached file.");
    L12:
        return r4;
    L13:
        HashMap r8 = new HashMap();     // Catch: Throwable -> L43 Exception -> L45
    L15:
        if (r5.dataAvail() <= 0) goto L21;
        Integer r9 = Integer.valueOf(r5.readInt());     // Catch: Throwable -> L43 Exception -> L45
        List<BaseFlowAdapter.FlowEntry> r10 = readRecommendContacts(r5, r9, r5.readInt());     // Catch: Throwable -> L43 Exception -> L45
        if (r10.isEmpty() == true) goto L21;
        r8.put(r9, r10);     // Catch: Throwable -> L43 Exception -> L45
    L21:
        if (r8.isEmpty() == true) goto L37;
        List r11 = (List) r8.get(0);     // Catch: Throwable -> L43 Exception -> L45
        if (r11 != null) goto L25;
    L27:
        List r12 = (List) r8.get(1);     // Catch: Throwable -> L43 Exception -> L45
        if (r12 != null) goto L30;
    L32:
        List r13 = (List) r8.get(2);     // Catch: Throwable -> L43 Exception -> L45
        if (r13 == null) goto L37;
        if (r13.isEmpty() == true) goto L37;
        r4.add(new RecommendHead(r3.getText(R.string.recommend_favorite), 2));     // Catch: Throwable -> L43 Exception -> L45
        r4.addAll(r13);     // Catch: Throwable -> L43 Exception -> L45
    L30:
        if (r12.isEmpty() == true) goto L32;
        r4.add(new RecommendHead(r3.getText(R.string.recommend_frequent), 1));     // Catch: Throwable -> L43 Exception -> L45
        r4.addAll(r12);     // Catch: Throwable -> L43 Exception -> L45
        goto L32
    L25:
        if (r11.isEmpty() == true) goto L27;
        r4.add(new RecommendHead(r3.getText(R.string.recommend_recent), 0));     // Catch: Throwable -> L43 Exception -> L45
        r4.addAll(r11);     // Catch: Throwable -> L43 Exception -> L45
    L37:
        Closeables.closeQuietly(r6);
        r5.recycle();
        if (DEBUG == false) goto L41;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Cached recommend datas: " + r4);
    L41:
        if (r4.isEmpty() == true) goto L52;
    L53:
        return r4;
    L52:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Recommend data from cached file.");
    L43:
        th = move-exception;
        Closeables.closeQuietly(r6);
        r5.recycle();
        if (DEBUG == false) goto L58;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Cached recommend datas: " + r4);
    L58:
        if (r4.isEmpty() == false) goto L60;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "Recommend data from cached file.");
    L60:
        throw th;
    L45:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Load recommend data list from file error: " + e);     // Catch: Throwable -> L43
        Closeables.closeQuietly(r6);
        r5.recycle();
        if (DEBUG == false) goto L51;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Cached recommend datas: " + r4);
    L51:
        if (r4.isEmpty() == false) goto L53;
        goto L52
    }

    private static List<BaseFlowAdapter.FlowEntry> readRecommendContacts(Parcel r5, Integer r6, int r7) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L13;
        RecommendContact r2 = RecommendContact.CREATOR.createFromParcel(r5);
        if (r2 == null) goto L13;
        if (r2.isValid() == false) goto L10;
        r0.add(r2);
    L12:
        r1 = r1 + 1;
        goto L3
    L10:
        if (DEBUG == false) goto L12;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "For head (" + r6 + ") read an invalid recommend contact: " + r2);
    L13:
        return r0;
    }

    public static final synchronized float getDayFactor(long r8) {
        monitor-enter(RecommendUtil.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (sFrequentFactor != null) goto L10;
        sFrequentFactor = new float[90];     // Catch: Throwable -> L20
        int r1 = 0;
    L7:
        float[] r2 = sFrequentFactor;     // Catch: Throwable -> L20
        if (r1 >= r2.length) goto L10;
        int r3 = r1 + 1;     // Catch: Throwable -> L20
        r2[r1] = (float) ((2.39d / (Math.pow(((double) r3) / 0.51d, 0.44d) + 1.0d)) - 0.14d);     // Catch: Throwable -> L20
        r1 = r3;
    L10:
        int r9 = (int) ((Calendar.getInstance().getTimeInMillis() / 86400000) - (r8 / 86400000));     // Catch: Throwable -> L20
        if (r9 <= 0) goto L17;
        float[] r10 = sFrequentFactor;     // Catch: Throwable -> L20
        if (r9 >= r10.length) goto L17;
        float r11 = r10[r9 - 1];     // Catch: Throwable -> L20
        monitor-exit(RecommendUtil.class);
        return r11;
    L17:
        monitor-exit(RecommendUtil.class);
        return -1.0f;
    }
}
