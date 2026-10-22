package com.android.contacts.dialpad.search;

import android.content.Context;
import com.GlobalProxyLancet;
import com.android.contacts.ContactsApplication;
import com.android.contacts.R;
import com.android.contacts.common.SimContactsConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class T9SearchHelper {
    private static final String TAG = "T9SearchHelper";
    private static volatile T9SearchHelper sT9SearchHelper;
    private Context mContext;
    private Map<String, String[]> mKoreanBaseLetter;
    private Map<String, String[]> mKoreanComplexConsonant;
    private Map<String, String[]> mKoreanWords;

    public static T9SearchHelper getInstance(Context r2) {
        if (sT9SearchHelper != null) goto L18;
        monitor-enter(T9SearchHelper.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (sT9SearchHelper != null) goto L12;
        if (r2 != null) goto L10;
        Context r3 = ContactsApplication.getInstance();     // Catch: Throwable -> L14
    L11:
        sT9SearchHelper = new T9SearchHelper(r3);     // Catch: Throwable -> L14
        goto L12
    L10:
        r3 = r2.getApplicationContext();     // Catch: Throwable -> L14
    L12:
        monitor-exit(T9SearchHelper.class);     // Catch: Throwable -> L14
    L18:
        return sT9SearchHelper;
    }

    private T9SearchHelper(Context r1) {
        this.mContext = r1;
    }

    public boolean isEnabled() {
        boolean r2 = this.mContext.getResources().getBoolean(R.bool.config_enable_t9_search_helper);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "isEnabled = " + r2);
        return r2;
    }

    public void resume() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        this.mKoreanBaseLetter = r0;
        r0.put("ㅏ", new String[]{"ㅣ", "ㆍ"});
        this.mKoreanBaseLetter.put("ㅐ", new String[]{"ㅣ", "ㆍ", "ㅣ"});
        this.mKoreanBaseLetter.put("ㅑ", new String[]{"ㅣ", "ㆍ", "ㆍ"});
        this.mKoreanBaseLetter.put("ㅓ", new String[]{"ㆍ", "ㅣ"});
        this.mKoreanBaseLetter.put("ㅔ", new String[]{"ㆍ", "ㅣ", "ㅣ"});
        this.mKoreanBaseLetter.put("ㅕ", new String[]{"ㆍ", "ㆍ", "ㅣ"});
        this.mKoreanBaseLetter.put("ㅗ", new String[]{"ㆍ", "ㅡ"});
        this.mKoreanBaseLetter.put("ㅘ", new String[]{"ㆍ", "ㅡ", "ㅣ", "ㆍ"});
        this.mKoreanBaseLetter.put("ㅛ", new String[]{"ㆍ", "ㆍ", "ㅡ"});
        this.mKoreanBaseLetter.put("ㅜ", new String[]{"ㅡ", "ㆍ"});
        this.mKoreanBaseLetter.put("ㅠ", new String[]{"ㅡ", "ㆍ", "ㆍ"});
        this.mKoreanBaseLetter.put("ㅢ", new String[]{"ㅡ", "ㅣ"});
        HashMap r1 = new HashMap();
        this.mKoreanComplexConsonant = r1;
        r1.put("ㄲ", new String[]{"ㄱ", "ㄱㄱ"});
        this.mKoreanComplexConsonant.put("ㄸ", new String[]{"ㄷ", "ㄷㄷ"});
        this.mKoreanComplexConsonant.put("ㅃ", new String[]{"ㅂ", "ㅂㅂ"});
        this.mKoreanComplexConsonant.put("ㅆ", new String[]{"ㅅ", "ㅅㅅ"});
        this.mKoreanComplexConsonant.put("ㅉ", new String[]{"ㅈ", "ㅈㅈ"});
        importKoreanWordsFromCSV();
    }

    private void importKoreanWordsFromCSV() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "importKoreanWordsFromCSV begin");
        HashMap r1 = new HashMap();
        InputStream r5 = null;
        r5 = this.mContext.getAssets().open("korea_t9.csv");     // Catch: Throwable -> L17 IOException -> L19
        BufferedReader r3 = new BufferedReader(new InputStreamReader(r5));     // Catch: Throwable -> L17 IOException -> L19
    L4:
        String r4 = r3.readLine();     // Catch: Throwable -> L17 IOException -> L19
        if (r4 == null) goto L13;
        String[] r6 = r4.split(SimContactsConstants.EMAIL_SEP, 2);     // Catch: Throwable -> L17 IOException -> L19
        if (r6.length != 2) goto L8;
        String r7 = r6[1].trim();     // Catch: Throwable -> L17 IOException -> L19
        if (r7.length() < 3) goto L4;
        r1.put(r6[0].trim(), r7.substring(1, r7.length() - 1).split(SimContactsConstants.EMAIL_SEP));     // Catch: Throwable -> L17 IOException -> L19
        goto L4
    L8:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Skipping Bad CSV Row");     // Catch: Throwable -> L17 IOException -> L19
        goto L4
    L13:
        this.mKoreanWords = r1;     // Catch: Throwable -> L17 IOException -> L19
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "importKoreanWordsFromCSV finish");     // Catch: Throwable -> L17 IOException -> L19
        if (r5 == null) goto L47;
        r5.close();     // Catch: IOException -> L24
        return;
    L47:
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        return;
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        if (r5 == null) goto L48;
        r5.close();     // Catch: IOException -> L24
        return;
    L48:
        return;
    L17:
        th = move-exception;
        if (r5 != null) goto L34;
    L32:
        throw th;
    L34:
        r5.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public void pause() {
        this.mKoreanWords = null;
        this.mKoreanBaseLetter = null;
        this.mKoreanComplexConsonant = null;
    }

    public List<String> splitKoreanLetter(char r11) {
        Map<String, String[]> r0 = this.mKoreanWords;
        if (r0 != null) goto L5;
    L49:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Make sure invoke resume method first!");
        return null;
    L5:
        if (this.mKoreanBaseLetter == null) goto L49;
        if (this.mKoreanComplexConsonant == null) goto L49;
        String[] r1 = r0.get(String.valueOf(r11));
        if (r1 != null) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Can't found " + r11 + " in mKoreanWords.");
        return null;
    L13:
        ArrayList r12 = new ArrayList();
        r12.add(new StringBuilder());
        int r2 = r1.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L44;
        String r4 = r1[r3];
        if (this.mKoreanComplexConsonant.containsKey(r4) == false) goto L31;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r12.iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        r5.add(new StringBuilder((StringBuilder) r6.next()));
        goto L19
    L21:
        Iterator r7 = r12.iterator();
    L23:
        if (r7.hasNext() == false) goto L25;
        ((StringBuilder) r7.next()).append(this.mKoreanComplexConsonant.get(r4)[0]);
        goto L23
    L25:
        Iterator r8 = r5.iterator();
    L27:
        if (r8.hasNext() == false) goto L29;
        ((StringBuilder) r8.next()).append(this.mKoreanComplexConsonant.get(r4)[1]);
        goto L27
    L29:
        r12.addAll(r5);
    L43:
        r3 = r3 + 1;
        goto L14
    L31:
        if (this.mKoreanBaseLetter.containsKey(r4) == false) goto L39;
        String[] r9 = this.mKoreanBaseLetter.get(r4);
        int r10 = r9.length;
        int r13 = 0;
    L33:
        if (r13 >= r10) goto L43;
        String r14 = r9[r13];
        Iterator r15 = r12.iterator();
    L36:
        if (r15.hasNext() == false) goto L38;
        ((StringBuilder) r15.next()).append(r14);
        goto L36
    L38:
        r13 = r13 + 1;
        goto L33
    L39:
        Iterator r16 = r12.iterator();
    L41:
        if (r16.hasNext() == false) goto L43;
        ((StringBuilder) r16.next()).append(r4);
        goto L41
    L44:
        ArrayList r17 = new ArrayList();
        Iterator r18 = r12.iterator();
    L46:
        if (r18.hasNext() == false) goto L48;
        r17.add(((StringBuilder) r18.next()).toString());
        goto L46
    L48:
        return r17;
    }
}
