package com.bytedance.frameworks.baselib.network.http.ok3.impl.metadispatch;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.android.contacts.ContactsUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.frameworks.baselib.network.config.hostpathmatch.TTHostPathCondition;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTMetaDispatchManager {
    private static volatile TTMetaDispatchManager mInstance;
    private static TTMetaDispatchConfig mTncConfig;
    private static final ReentrantReadWriteLock mTncConfigLock = null;

    static {
        mTncConfigLock = new ReentrantReadWriteLock();
    }

    private TTMetaDispatchManager() {
    }

    public static TTMetaDispatchManager getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(TTMetaDispatchManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new TTMetaDispatchManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMetaDispatchManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public String dispatch(String r5, Request r6, TTMetaDispatchLog r7, List<Header> r8) {
        LinkedHashMap r0 = new LinkedHashMap();
        Pair<String, String> r1 = null;
        ReentrantReadWriteLock r2 = mTncConfigLock;     // Catch: Throwable -> L16
        r2.readLock().lock();     // Catch: Throwable -> L16
        TTMetaDispatchConfig r3 = mTncConfig;     // Catch: Throwable -> L16
        if (r3 != null) goto L6;
    L10:
        r2.readLock().unlock();
        return r5;
    L6:
        if (r3.isEnabled() == false) goto L10;
        TTMetaDispatchValue r4 = mTncConfig.getValue(r5);     // Catch: Throwable -> L16
        if (r4 == null) goto L10;
        r1 = UrlUtils.parseUrlWithValueList(r5, r0);     // Catch: Throwable -> L16
        handleQuery(r0, r4, r7);     // Catch: Throwable -> L16
        List<Header> r9 = handleHeader(r6, r4, r7);     // Catch: Throwable -> L16
        if (CollectionUtils.isEmpty(r9) == true) goto L15;
        r8.addAll(r9);     // Catch: Throwable -> L16
    L15:
        ReentrantReadWriteLock.ReadLock r10 = r2.readLock();
    L19:
        r10.unlock();
        if (r1 != null) goto L53;
        return r5;
    L53:
        UrlBuilder r11 = new UrlBuilder(((String) r1.first) + ((String) r1.second));     // Catch: Throwable -> L45
        if (r0.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, List<String>>> r12 = r0.entrySet().iterator();     // Catch: Throwable -> L45
    L26:
        if (r12.hasNext() == false) goto L41;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L45
        if (r13 == null) goto L26;
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L26;
        List<String> r14 = r13.getValue();     // Catch: Throwable -> L45
        if (r14 == null) goto L26;
        if (r14.isEmpty() == true) goto L26;
        Iterator<String> r15 = r14.iterator();     // Catch: Throwable -> L45
    L39:
        if (r15.hasNext() == false) goto L26;
        r11.addParam(r13.getKey(), r15.next());     // Catch: Throwable -> L45
    L41:
        String r16 = r11.build();     // Catch: Throwable -> L45
        String r17 = Uri.parse(r5).getEncodedFragment();     // Catch: Throwable -> L45
        if (TextUtils.isEmpty(r17) == true) goto L68;
        return r16 + ContactsUtils.CHAR_POUND + r17;
    L68:
        return r16;
    L45:
        return r5;
    L16:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L46
        r10 = mTncConfigLock.readLock();
    L46:
        th = move-exception;
        mTncConfigLock.readLock().unlock();
        throw th;
    }

    private void handleQuery(Map<String, List<String>> r5, TTMetaDispatchValue r6, TTMetaDispatchLog r7) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L45;
        if (r6 == null) goto L46;
        if (r7 != null) goto L9;
        return;
    L9:
        if (CollectionUtils.isEmpty(r6.queryRmSet) == true) goto L26;
        HashSet r4 = new HashSet();
        Iterator<String> r0 = r6.queryRmSet.iterator();
    L12:
        if (r0.hasNext() == false) goto L24;
        String r1 = r0.next();
        String r2 = URLDecoder.decode(r1, "UTF-8");     // Catch: UnsupportedEncodingException -> L20
        if (TextUtils.isEmpty(r2) == true) goto L12;
        if (r5.containsKey(r2) == false) goto L12;
        r5.remove(r2);
        r4.add(r1);
    L20:
        e = move-exception;
        throw new RuntimeException(e);
    L24:
        if (r4.isEmpty() == true) goto L26;
        r7.queryRm = r4;
    L26:
        HashSet r8 = new HashSet();
        Iterator<Map.Entry<String, String>> r9 = r6.queryAddMap.entrySet().iterator();
    L28:
        if (r9.hasNext() == false) goto L31;
        Map.Entry<String, String> r3 = r9.next();
        r5.put(r3.getKey(), Collections.singletonList(r3.getValue()));
        r8.add(r3.getKey());
        goto L28
    L31:
        if (r8.isEmpty() == true) goto L47;
        r7.queryAdd = r8;
        return;
    L47:
        return;
    L46:
        return;
    }

    private List<Header> handleHeader(Request r6, TTMetaDispatchValue r7, TTMetaDispatchLog r8) {
        ArrayList r5 = null;
        if (r6 == null) goto L40;
        if (r7 == null) goto L40;
        if (r8 == null) goto L40;
        if (CollectionUtils.isEmpty(r7.headerRmSet) == false) goto L12;
        if (r7.headerAddMap != null) goto L12;
    L13:
        return null;
    L12:
        if (r7.headerAddMap.isEmpty() == true) goto L13;
        ArrayList r0 = new ArrayList();
        HashSet r1 = new HashSet();
        if (CollectionUtils.isEmpty(r7.headerRmSet) == true) goto L25;
        if (r6.getHeaders().isEmpty() == true) goto L25;
        Iterator<String> r2 = r7.headerRmSet.iterator();
    L20:
        if (r2.hasNext() == false) goto L25;
        String r3 = r2.next();
        List<Header> r4 = r6.headers(r3);
        if (r4 == null) goto L20;
        r0.addAll(r4);
        r1.add(r3);
    L25:
        if (r1.isEmpty() == true) goto L28;
        r8.headerRm = r1;
        r5 = new ArrayList(r6.getHeaders());
        r5.removeAll(r0);
    L28:
        if (r7.headerAddMap == null) goto L40;
        if (r7.headerAddMap.isEmpty() == true) goto L40;
        if (r5 != null) goto L33;
        r5 = new ArrayList(r6.getHeaders());
    L33:
        HashSet r9 = new HashSet();
        Iterator<Map.Entry<String, String>> r10 = r7.headerAddMap.entrySet().iterator();
    L35:
        if (r10.hasNext() == false) goto L38;
        Map.Entry<String, String> r11 = r10.next();
        r5.add(new Header(r11.getKey(), r11.getValue()));
        r9.add(r11.getKey());
        goto L35
    L38:
        if (r9.isEmpty() == true) goto L40;
        r8.headerAdd = r9;
    L40:
        return r5;
    }

    public static void onServerConfigChanged(JSONObject r2) {
        ReentrantReadWriteLock r0 = mTncConfigLock;     // Catch: Throwable -> L16
        r0.writeLock().lock();     // Catch: Throwable -> L16
        TTMetaDispatchConfig r1 = new TTMetaDispatchConfig();     // Catch: Throwable -> L16
        mTncConfig = r1;     // Catch: Throwable -> L16
        if (r2 != null) goto L7;
        r0.writeLock().unlock();
        return;
    L7:
        if (r1.parseTNCConfig(r2) == true) goto L9;
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L9:
        List<Pair<TTHostPathCondition, TTMetaDispatchValue>> r3 = mTncConfig.getmRuleList();     // Catch: Throwable -> L16
        if (r3 != null) goto L12;
    L13:
        mTncConfig.setEnabled(false);     // Catch: Throwable -> L16
    L14:
        r0.writeLock().unlock();
        return;
    L12:
        if (r3.isEmpty() == false) goto L14;
    L16:
        th = move-exception;
        mTncConfigLock.writeLock().unlock();
        throw th;
    }
}
