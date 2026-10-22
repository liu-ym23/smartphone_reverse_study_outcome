package com.android.contacts.common.compat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;
import android.text.TextUtils;
import android.util.Patterns;
import com.GlobalProxyLancet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class TelephonyThreadsCompat {
    private static final String[] ID_PROJECTION = null;
    private static final Pattern NAME_ADDR_EMAIL_PATTERN = null;
    private static final String TAG = "TelephonyThreadsCompat";
    private static final Uri THREAD_ID_CONTENT_URI = null;

    private TelephonyThreadsCompat() {
    }

    public static long getOrCreateThreadId(Context r2, String r3) {
        if (SdkVersionOverride.getSdkVersion(23) < 23) goto L7;
        return Telephony.Threads.getOrCreateThreadId(r2, r3);
    L7:
        return getOrCreateThreadIdInternal(r2, r3);
    }

    static {
        THREAD_ID_CONTENT_URI = Uri.parse("content://mms-sms/threadID");
        ID_PROJECTION = new String[]{"_id"};
        NAME_ADDR_EMAIL_PATTERN = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");
    }

    private static long getOrCreateThreadIdInternal(Context r1, String r2) {
        HashSet r0 = new HashSet();
        r0.add(r2);
        return getOrCreateThreadIdInternal(r1, r0);
    }

    private static long getOrCreateThreadIdInternal(Context r9, Set<String> r10) {
        Uri.Builder r0 = THREAD_ID_CONTENT_URI.buildUpon();
        Iterator<String> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        String r1 = r11.next();
        if (isEmailAddress(r1) == false) goto L8;
        r1 = extractAddrSpec(r1);
    L8:
        r0.appendQueryParameter("recipient", r1);
        goto L4
    L9:
        Uri r12 = r0.build();
        Cursor r13 = query(r9.getContentResolver(), r12, ID_PROJECTION, null, null, null);
        if (r13 != null) goto L23;
    L21:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getOrCreateThreadId failed with uri " + r12.toString());
        throw new IllegalArgumentException("Unable to find or allocate a thread ID.");
    L23:
    L18:
        th = move-exception;
        r13.close();
        throw th;
    L12:
        if (r13.moveToFirst() == false) goto L16;
        long r2 = r13.getLong(0);     // Catch: Throwable -> L18
        r13.close();
        return r2;
    L16:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getOrCreateThreadId returned no rows!");     // Catch: Throwable -> L18
        r13.close();
        goto L21
    }

    private static Cursor query(ContentResolver r0, Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return r0.query(r1, r2, r3, r4, r5);
    L4:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Catch an exception when query: ", e);
        return null;
    }

    private static boolean isEmailAddress(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return false;
    L5:
        String r3 = extractAddrSpec(r2);
        if (r3 != null) goto L9;
        return false;
    L9:
        return Patterns.EMAIL_ADDRESS.matcher(r3).matches();
    }

    private static String extractAddrSpec(String r2) {
        Matcher r0 = NAME_ADDR_EMAIL_PATTERN.matcher(r2);
        if (r0.matches() == true) goto L5;
        return r2;
    L5:
        return r0.group(2);
    }
}
