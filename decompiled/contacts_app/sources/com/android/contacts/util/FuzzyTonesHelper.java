package com.android.contacts.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class FuzzyTonesHelper {
    private static final boolean DBG = true;
    private static Uri FUZZY_TONE_URI = null;
    private static final String TAG = "Contacts.FuzzyTone";
    private static volatile FuzzyTonesHelper sFuzzyTonesHelper;
    private HandlerThread mBackgroundThread;
    private Context mContext;
    private LinkedHashMap<String, List<String>> mFuzzyToneSet;

    private interface FuzzyTonesQuery {
        public static final int TONE_1 = 0;
        public static final int TONE_2 = 1;
        public static final String[] _PROJECTION = null;

        static {
            _PROJECTION = new String[]{"tone_1", "tone_2"};
        }
    }

    static /* synthetic */ void access$000(FuzzyTonesHelper r0) {
        r0.queryFuzzyTonesPairs();
    }

    static {
        FUZZY_TONE_URI = Uri.parse("content://com.android.quicksearchbox.fuzzytone/fuzzy_tones");
    }

    public static FuzzyTonesHelper getInstance(Context r2) {
        if (sFuzzyTonesHelper != null) goto L15;
        monitor-enter(FuzzyTonesHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sFuzzyTonesHelper != null) goto L9;
        sFuzzyTonesHelper = new FuzzyTonesHelper(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(FuzzyTonesHelper.class);     // Catch: Throwable -> L11
    L15:
        return sFuzzyTonesHelper;
    }

    public FuzzyTonesHelper(Context r5) {
        this.mContext = r5;
        HandlerThread r6 = new HandlerThread("FuzzyTonesHelper_Worker", 10);
        this.mBackgroundThread = r6;
        r6.start();
        queryFuzzyTonesPairs();
        ContentResolver r7 = this.mContext.getContentResolver();
        Uri r0 = FUZZY_TONE_URI;
        final Handler r2 = new Handler(this.mBackgroundThread.getLooper());
        r7.registerContentObserver(r0, false, new AnonymousClass1(this, r2));
    }

    public Set<String> parseFuzzyTones(String r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        HashSet r0 = new HashSet();
        LinkedHashMap<String, List<String>> r1 = this.mFuzzyToneSet;
        if (r1 != null) goto L8;
    L71:
        r0.add(r14);
        return r0;
    L8:
        if (r1.size() == 0) goto L71;
        StringBuilder r2 = new StringBuilder("(");
        r2.append(TextUtils.join("|", this.mFuzzyToneSet.keySet())).append(")");
        Pattern r3 = Pattern.compile(r2.toString(), 2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "pattern:: " + r2.toString());
        String[] r4 = r3.split(r14);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "remainSegments:: " + Arrays.toString(r4));
        Matcher r5 = r3.matcher(r14);
        if (r5.groupCount() >= 1) goto L14;
        r0.add(r14);
        return r0;
    L14:
        ArrayList r6 = new ArrayList();
    L16:
        if (r5.find() == false) goto L18;
        r6.add(r5.group());
        goto L16
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "matchedSegents:: " + Arrays.toString(r6.toArray(new String[0])));
        HashSet r7 = new HashSet();
        if (r4 == null) goto L23;
        if (r4.length == 0) goto L23;
    L26:
        int r15 = 0;
    L28:
        if (r15 >= r4.length) goto L44;
        if (r15 != 0) goto L31;
        r7.add(new StringBuilder());
    L31:
        HashSet r8 = new HashSet();
        Iterator r9 = r7.iterator();
    L33:
        if (r9.hasNext() == false) goto L42;
        StringBuilder r10 = (StringBuilder) r9.next();
        r10.append(r4[r15]);
        if (r15 >= r6.size()) goto L33;
        StringBuilder r11 = new StringBuilder(r10);
        r10.append((String) r6.get(r15));
        List<String> r12 = this.mFuzzyToneSet.get(((String) r6.get(r15)).toLowerCase());
        if (r12 == null) goto L33;
        int r13 = 0;
    L40:
        if (r13 >= r12.size()) goto L33;
        r8.add(new StringBuilder(r11).append(r12.get(r13)));
        r13 = r13 + 1;
        goto L40
    L42:
        r7.addAll(r8);
        r15 = r15 + 1;
        goto L28
    L44:
        if (r6.size() <= r4.length) goto L60;
        int r16 = r4.length;
    L47:
        if (r16 >= r6.size()) goto L60;
        if (r16 != 0) goto L50;
        r7.add(new StringBuilder());
    L50:
        HashSet r17 = new HashSet();
        Iterator r18 = r7.iterator();
    L52:
        if (r18.hasNext() == false) goto L59;
        StringBuilder r19 = (StringBuilder) r18.next();
        StringBuilder r20 = new StringBuilder(r19);
        r19.append((String) r6.get(r16));
        List<String> r21 = this.mFuzzyToneSet.get(((String) r6.get(r16)).toLowerCase());
        if (r21 == null) goto L52;
        int r22 = 0;
    L57:
        if (r22 >= r21.size()) goto L52;
        r17.add(new StringBuilder(r20).append(r21.get(r22)));
        r22 = r22 + 1;
        goto L57
    L59:
        r7.addAll(r17);
        r16 = r16 + 1;
    L60:
        Iterator r110 = r7.iterator();
    L62:
        if (r110.hasNext() == false) goto L65;
        r0.add(((StringBuilder) r110.next()).toString());
        goto L62
    L65:
        if (ContactsUtils.DEBUG == false) goto L70;
        int r111 = 0;
    L68:
        if (r111 >= r0.size()) goto L70;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "results:: " + r111 + " = " + Arrays.toString(r0.toArray(new String[0])));
        r111 = r111 + 1;
    L70:
        return r0;
    L23:
        if (r6.size() != 0) goto L26;
        r0.add(r14);
        return r0;
    }

    private void queryFuzzyTonesPairs() {
        Cursor r0 = null;
        r0 = this.mContext.getContentResolver().query(FUZZY_TONE_URI, FuzzyTonesQuery._PROJECTION, null, null, null);     // Catch: Throwable -> L19
        if (r0 == null) goto L17;
        LinkedHashMap<String, List<String>> r1 = new LinkedHashMap();     // Catch: Throwable -> L19
    L7:
        if (r0.moveToNext() == false) goto L16;
        String r2 = r0.getString(0);     // Catch: Throwable -> L19
        String r3 = r0.getString(1);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r2) == true) goto L7;
        if (TextUtils.isEmpty(r3) == true) goto L7;
        if (r2.length() > r3.length()) goto L14;
        putFuzzyTone(r1, r3, r2);     // Catch: Throwable -> L19
        putFuzzyTone(r1, r2, r3);     // Catch: Throwable -> L19
        goto L7
    L14:
        putFuzzyTone(r1, r2, r3);     // Catch: Throwable -> L19
        putFuzzyTone(r1, r3, r2);     // Catch: Throwable -> L19
        goto L7
    L16:
        this.mFuzzyToneSet = r1;     // Catch: Throwable -> L19
    L17:
        if (r0 == null) goto L42;
    L22:
        r0.close();
        return;
    L42:
        return;
    L19:
        th = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "queryFuzzyTonesPairs Exception", th);     // Catch: Throwable -> L24
        if (r0 != null) goto L22;
        return;
    L24:
        th = move-exception;
        if (r0 == null) goto L27;
        r0.close();
    L27:
        throw th;
    }

    private void putFuzzyTone(LinkedHashMap<String, List<String>> r1, String r2, String r3) {
        if (r1.get(r2) != null) goto L5;
        List<String> r0 = new ArrayList();
        r1.put(r2, r0);
    L6:
        r0.add(r3);
        return;
    L5:
        r0 = r1.get(r2);
        goto L6
    }
}
