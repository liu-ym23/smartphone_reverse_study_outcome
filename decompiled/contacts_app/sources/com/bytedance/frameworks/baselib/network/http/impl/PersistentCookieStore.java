package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PersistentCookieStore implements CookieStore {
    private static final String SP_COOKIE_STORE = "cookieStore";
    private static final String SP_KEY_DELIMITER = "|";
    private static final String SP_KEY_DELIMITER_REGEX = "\\|";
    private static final String TAG = "PersistentCookieStore";
    private static final Map<String, String> memoryStore = null;
    private static String sCustomizedCookieStoreName;
    private final Map<URI, Set<SerializableHttpCookie>> allCookies;
    private final SharedPreferences cookieStore;

    static /* synthetic */ void access$000(PersistentCookieStore r0) {
        r0.tryMvHttpsCookies2HttpCookie();
    }

    static {
        memoryStore = new LinkedHashMap();
    }

    public static void useCustomizedCookieStoreName() {
        sCustomizedCookieStoreName = "ttnetCookieStore";
    }

    public PersistentCookieStore(Context r3) {
        this.allCookies = new LinkedHashMap();
        String r0 = sCustomizedCookieStoreName;
        if (r0 != null) goto L5;
        r0 = SP_COOKIE_STORE;
    L5:
        SharedPreferences r4 = r3.getSharedPreferences(r0, 4);
        this.cookieStore = r4;
        loadAllFromPersistence(r4.getAll(), true);
        loadAllFromPersistence(memoryStore, false);
    }

    private synchronized void loadAllFromPersistence(Map<String, ?> r5, boolean r6) {
        monitor-enter(this);
        if (r5 != null) goto L35;
    L29:
        monitor-exit(this);
        return;
    L35:
    L26:
        th = move-exception;
        throw th;
    L5:
        if (r5.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, ?>> r7 = r5.entrySet().iterator();     // Catch: Throwable -> L22
    L9:
        if (r7.hasNext() == false) goto L19;
        Map.Entry<String, ?> r0 = r7.next();     // Catch: Throwable -> L22
        URI r2 = new URI(r0.getKey().split(SP_KEY_DELIMITER_REGEX, 2)[0]);     // Catch: URISyntaxException -> L17 Throwable -> L22
        SerializableHttpCookie r1 = SerializableHttpCookie.decode((String) r0.getValue());     // Catch: URISyntaxException -> L17 Throwable -> L22
        Set<SerializableHttpCookie> r3 = this.allCookies.get(r2);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L12:
        if (r3 != null) goto L14;
        r3 = new HashSet();     // Catch: URISyntaxException -> L17 Throwable -> L22
        this.allCookies.put(r2, r3);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L14:
        if (r1 == null) goto L9;
        r3.add(r1);     // Catch: URISyntaxException -> L17 Throwable -> L22
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        goto L9
    L19:
        if (r6 == false) goto L24;
        ThreadPlus.submitRunnable(new AnonymousClass1(this));     // Catch: Throwable -> L22
    L24:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L26
        goto L24
    }

    private synchronized void tryMvHttpsCookies2HttpCookie() {
        monitor-enter(this);
        Map<URI, Set<SerializableHttpCookie>> r0 = this.allCookies;     // Catch: Throwable -> L90
        if (r0 != null) goto L6;
    L88:
        monitor-exit(this);
        return;
    L6:
        if (r0.isEmpty() == true) goto L88;
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L90
        Iterator<Map.Entry<URI, Set<SerializableHttpCookie>>> r2 = this.allCookies.entrySet().iterator();     // Catch: Throwable -> L90
    L10:
        if (r2.hasNext() == false) goto L20;
        Map.Entry<URI, Set<SerializableHttpCookie>> r3 = r2.next();     // Catch: Throwable -> L90
        if (r3 == null) goto L10;
        URI r4 = r3.getKey();     // Catch: Throwable -> L90
        if (r4.getScheme() == null) goto L10;
        if (r4.getScheme().equals("https") == false) goto L10;
        r1.put(r3.getKey(), r3.getValue());     // Catch: Throwable -> L90
        goto L10
    L20:
        if (r1.isEmpty() == false) goto L23;
        monitor-exit(this);
        return;
    L23:
        Iterator r5 = r1.entrySet().iterator();     // Catch: Throwable -> L90
    L25:
        if (r5.hasNext() == false) goto L96;
        Map.Entry r6 = (Map.Entry) r5.next();     // Catch: Throwable -> L90
        if (r6 == null) goto L25;
        URI r7 = (URI) r6.getKey();     // Catch: Throwable -> L90
        Set<SerializableHttpCookie> r8 = (Set) r6.getValue();     // Catch: Throwable -> L90
        URI r9 = new URI(r7.toString().replace("https:", "http:"));     // Catch: Throwable -> L62
        Set<SerializableHttpCookie> r10 = this.allCookies.get(r9);     // Catch: Throwable -> L62
    L31:
        if (r10 == null) goto L60;
        if (r10.isEmpty() == true) goto L60;
        LinkedHashSet r11 = new LinkedHashSet();     // Catch: Throwable -> L62
        Iterator<SerializableHttpCookie> r12 = r10.iterator();     // Catch: Throwable -> L62
    L37:
        if (r12.hasNext() == false) goto L52;
        SerializableHttpCookie r13 = r12.next();     // Catch: Throwable -> L62
        Iterator<SerializableHttpCookie> r14 = r8.iterator();     // Catch: Throwable -> L62
        boolean r15 = false;
    L40:
        if (r14.hasNext() == false) goto L50;
        SerializableHttpCookie r16 = r14.next();     // Catch: Throwable -> L62
        if (r13 == null) goto L40;
        if (r16 == null) goto L40;
        if (r13.getHttpCookie().equals(r16.getHttpCookie()) == false) goto L40;
        if (r16.getWhenCreated().longValue() < r13.getWhenCreated().longValue()) goto L40;
        r11.add(r16);     // Catch: Throwable -> L62
        r15 = true;
        goto L40
    L50:
        if (r15 == true) goto L37;
        r11.add(r13);     // Catch: Throwable -> L62
        goto L37
    L52:
        Iterator<SerializableHttpCookie> r17 = r8.iterator();     // Catch: Throwable -> L62
    L54:
        if (r17.hasNext() == false) goto L59;
        SerializableHttpCookie r18 = r17.next();     // Catch: Throwable -> L62
        if (r11.contains(r18) == true) goto L54;
        r11.add(r18);     // Catch: Throwable -> L62
        goto L54
    L59:
        this.allCookies.remove(r7);     // Catch: Throwable -> L62
        this.allCookies.put(r9, r11);     // Catch: Throwable -> L62
    L60:
        this.allCookies.remove(r7);     // Catch: Throwable -> L62
        this.allCookies.put(r9, r8);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L90
        goto L25
    L96:
        Map<URI, Set<SerializableHttpCookie>> r19 = this.allCookies;     // Catch: Throwable -> L84
        if (r19 != null) goto L68;
    L82:
        monitor-exit(this);
        return;
    L68:
        if (r19.isEmpty() == true) goto L82;
        SharedPreferences.Editor r20 = this.cookieStore.edit();     // Catch: Throwable -> L84
        r20.clear();     // Catch: Throwable -> L84
        Iterator<Map.Entry<URI, Set<SerializableHttpCookie>>> r21 = this.allCookies.entrySet().iterator();     // Catch: Throwable -> L84
    L72:
        if (r21.hasNext() == false) goto L80;
        Map.Entry<URI, Set<SerializableHttpCookie>> r22 = r21.next();     // Catch: Throwable -> L84
        URI r23 = r22.getKey();     // Catch: Throwable -> L84
        Iterator<SerializableHttpCookie> r24 = r22.getValue().iterator();     // Catch: Throwable -> L84
    L75:
        if (r24.hasNext() == false) goto L72;
        SerializableHttpCookie r25 = r24.next();     // Catch: Throwable -> L84
        String r26 = r23.toString() + "|" + r25.getHttpCookie().getName();     // Catch: Throwable -> L84
        String r27 = r25.encode();     // Catch: Throwable -> L84
        if (r25.getHttpCookie().getMaxAge() > 0) goto L78;
        memoryStore.put(r26, r27);     // Catch: Throwable -> L84
        goto L75
    L78:
        r20.putString(r26, r27);     // Catch: Throwable -> L84
        goto L75
    L80:
        SharedPrefsEditorCompat.apply(r20);     // Catch: Throwable -> L84
    L86:
        monitor-exit(this);
        return;
    L84:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L90
    L90:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized void add(URI r3, HttpCookie r4) {
        monitor-enter(this);
        URI r5 = cookieUri(r3, r4);     // Catch: Throwable -> L10
        Set<SerializableHttpCookie> r0 = this.allCookies.get(r5);     // Catch: Throwable -> L10
        SerializableHttpCookie r1 = new SerializableHttpCookie(r4);     // Catch: Throwable -> L10
        if (r0 != null) goto L6;
        r0 = new HashSet();     // Catch: Throwable -> L10
        this.allCookies.put(r5, r0);     // Catch: Throwable -> L10
    L7:
        r0.add(r1);     // Catch: Throwable -> L10
        saveToPersistence(r5, r1);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L6:
        r0.remove(r1);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static URI cookieUri(URI r4, HttpCookie r5) {
        if (r5.getDomain() == null) goto L18;
        String r0 = r5.getDomain();
        if (r0.charAt(0) != '.') goto L16;
        r0 = r0.substring(1);
    L16:
    L13:
        e = move-exception;
        Log.w(TAG, e);
        return r4;
    L8:
        if (r5.getPath() != null) goto L10;
        String r6 = LibrarianImpl.Constants.SEPARATOR;
    L11:
        return new URI(HttpHost.DEFAULT_SCHEME_NAME, r0, r6, null);
    L10:
        r6 = r5.getPath();     // Catch: URISyntaxException -> L13
        goto L11
    L18:
        return r4;
    }

    private void saveToPersistence(URI r6, SerializableHttpCookie r7) {
        String r8 = r6.toString() + "|" + r7.getHttpCookie().getName();
        String r0 = r7.encode();
        if (r7.getHttpCookie().getMaxAge() <= 0) goto L5;
        SharedPreferences.Editor r5 = this.cookieStore.edit();
        r5.putString(r8, r0);
        r5.apply();
        return;
    L5:
        memoryStore.put(r8, r0);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> get(URI r1) {
        monitor-enter(this);
        List<HttpCookie> r2 = getValidCookies(r1);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<HttpCookie> getCookies() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<URI> r1 = this.allCookies.keySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L8;
        r0.addAll(getValidCookies(r1.next()));     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    private List<HttpCookie> getValidCookies(URI r6) {
        ArrayList r0 = new ArrayList();
        Iterator<URI> r1 = this.allCookies.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L13;
        URI r2 = r1.next();
        if (checkDomainsMatch(r2.getHost(), r6.getHost()) == false) goto L4;
        String r3 = r6.getPath();
        if (TextUtils.isEmpty(r3) == false) goto L11;
        r3 = LibrarianImpl.Constants.SEPARATOR;
    L11:
        if (checkPathsMatch(r2.getPath(), r3) == false) goto L4;
        r0.addAll(this.allCookies.get(r2));
        goto L4
    L13:
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator r7 = r0.iterator();
    L15:
        if (r7.hasNext() == false) goto L21;
        SerializableHttpCookie r8 = (SerializableHttpCookie) r7.next();
        if (r8.hasExpired() == true) goto L18;
        r4.add(r8.getHttpCookie());
        goto L15
    L18:
        r5.add(r8);
        goto L15
    L21:
        if (r5.isEmpty() == true) goto L23;
        removeFromPersistence(r6, r5);
    L23:
        return r4;
    }

    private boolean checkDomainsMatch(String r4, String r5) {
        if (r4 == null) goto L16;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.length() >= r4.length()) goto L11;
        return r4.equalsIgnoreCase(LibrarianImpl.Constants.DOT + r5);
    L11:
        if (r5.equalsIgnoreCase(r4) == false) goto L13;
    L14:
        return true;
    L13:
        if (r5.toLowerCase().endsWith(LibrarianImpl.Constants.DOT + r4.toLowerCase()) == true) goto L14;
        return false;
    L16:
        return false;
    }

    private boolean checkPathsMatch(String r4, String r5) {
        if (r5.equals(r4) == false) goto L5;
        return true;
    L5:
        if (r5.startsWith(r4) == false) goto L9;
        if (r4.charAt(r4.length() - 1) != '/') goto L9;
        return true;
    L9:
        if (r5.startsWith(r4) == false) goto L14;
        if (r5.substring(r4.length()).charAt(0) != '/') goto L14;
        return true;
    L14:
        return false;
    }

    private void removeFromPersistence(URI r4, List<SerializableHttpCookie> r5) {
        SharedPreferences.Editor r3 = this.cookieStore.edit();
        Iterator<SerializableHttpCookie> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        String r0 = r4.toString() + "|" + r6.next().getHttpCookie().getName();
        r3.remove(r0);
        memoryStore.remove(r0);
        goto L4
    L6:
        r3.apply();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized List<URI> getURIs() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.allCookies.keySet());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean remove(URI r3, HttpCookie r4) {
        monitor-enter(this);
        Set<SerializableHttpCookie> r0 = this.allCookies.get(r3);     // Catch: Throwable -> L11
        SerializableHttpCookie r1 = new SerializableHttpCookie(r4);     // Catch: Throwable -> L11
        if (r0 == null) goto L6;
        boolean r5 = r0.remove(r1);     // Catch: Throwable -> L11
    L7:
        if (r5 == false) goto L9;
        removeFromPersistence(r3, r1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r5;
    L6:
        r5 = false;
    L11:
        th = move-exception;
        throw th;
    }

    private void removeFromPersistence(URI r2, SerializableHttpCookie r3) {
        SharedPreferences.Editor r1 = this.cookieStore.edit();
        String r4 = r2.toString() + "|" + r3.getHttpCookie().getName();
        r1.remove(r4);
        r1.apply();
        memoryStore.remove(r4);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.CookieStore
    public synchronized boolean removeAll() {
        monitor-enter(this);
        this.allCookies.clear();     // Catch: Throwable -> L7
        removeAllFromPersistence();     // Catch: Throwable -> L7
        monitor-exit(this);
        return true;
    L7:
        th = move-exception;
        throw th;
    }

    private void removeAllFromPersistence() {
        this.cookieStore.edit().clear().apply();
        memoryStore.clear();
    }
}
